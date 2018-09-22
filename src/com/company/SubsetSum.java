package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class SubsetSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Long t = Long.parseLong(br.readLine());
        Map<Integer, Boolean> map[];

        for (int i = 0; i < t; i++) {
            int numberOfElements = Integer.parseInt(br.readLine());
            map = new HashMap[101];
            String[] split = br.readLine().split(" ");

            int[] numbers = new int[numberOfElements];

            int sum = 0;
            for (int i1 = 0; i1 < numberOfElements; i1++) {
                int number = Integer.parseInt(split[i1]);
                numbers[i1] = number;
                sum += number;
            }

            if (sum % 2 == 1) {
                System.out.println("NO");
                continue;
            }

            int remainingForBucket1 = sum / 2;

            boolean x = checkEquality(numbers, 0, remainingForBucket1, numberOfElements, map);
            if (x) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean checkEquality(int[] numbers, int index, int remainingForBucket1, int numberOfElements,
        Map<Integer, Boolean>[] map) {

        if (map[index] == null)
            map[index] = new HashMap();

        Map<Integer, Boolean> mapForIndex = map[index];

        if (mapForIndex.containsKey(remainingForBucket1)) {
            return mapForIndex.get(remainingForBucket1);
        }

        if (index >= numberOfElements || remainingForBucket1 <= 0) {
            mapForIndex.put(remainingForBucket1, false);
            return false;
        }

        if ((remainingForBucket1 == numbers[index])) {
            mapForIndex.put(remainingForBucket1, true);
            return true;
        }

        boolean withThisNumberInBucket1 = checkEquality(numbers, index + 1, remainingForBucket1 + numbers[index], numberOfElements, map);
        boolean withoutThisNumberInBucket1 = checkEquality(numbers, index + 1, remainingForBucket1, numberOfElements, map);

        boolean possible = withThisNumberInBucket1 || withoutThisNumberInBucket1;
        mapForIndex.put(remainingForBucket1, possible);
        return possible;
    }
}
