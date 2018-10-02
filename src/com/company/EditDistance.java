package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EditDistance {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Long t = Long.parseLong(br.readLine());
        int dp[][];

        for (int i = 0; i < t; i++) {
            String[] split = br.readLine().split(" ");

            int sizeStr1 = Integer.parseInt(split[0]);
            int sizeStr2 = Integer.parseInt(split[1]);

            String[] words = br.readLine().split(" ");
            String first = words[0];
            String second = words[1];

            calculate(first, second, sizeStr1, sizeStr2);
        }
    }

    private static int calculate(String first, String second, int length1, int length2) {

        if (first.charAt(length1) == second.charAt(length2)) {
            return calculate(first, second, length1 - 1, length2 - 1);
        }

        if (length1 == 0 || length2 == 0) {
            return 0;
        }
        return 0;

//        return 1 + min(calculate(first, second, length1 - 1, length2 - 1),
//                        calculate(first, second, ));
    }

    private static int min(Integer... numbers) {
        List<Integer> ints = Arrays.asList(numbers);
        return Collections.min(ints);
    }
}
