package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class LongestBitonicSubsequence {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Long t = Long.parseLong(br.readLine());

        for (long i = 0; i < t; i++) {
            Integer n = Integer.parseInt(br.readLine());

            String[] split = br.readLine().split(" ");

            HashMap[] dp = new HashMap[101];

            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(split[j]);
            }

            int value = calculate(arr, 0, 0, Integer.MAX_VALUE, 0, 0, dp);
            System.out.println(value);
        }
    }

    private static int calculate(int[] arr, Integer index, int maxIncreasing, int minDecreasing, int increasing,
        int decreasing, HashMap<Limits, Integer>[] dp) {

        Limits limits = new Limits(maxIncreasing, minDecreasing);

        if (dp[index] == null) {
            dp[index] = new HashMap<>();
        } else if (dp[index].containsKey(limits)) {
//            return dp[index].get(limits);
        }

        if (index >= arr.length) {
            int i = increasing + decreasing;
            dp[index].put(limits, i);

            return i;
        }

        if (arr[index] > maxIncreasing) {
            int value = findMax(calculate(arr, index + 1, maxIncreasing, minDecreasing, increasing, decreasing, dp), calculate(arr, index + 1, arr[index], minDecreasing, increasing + 1, decreasing, dp));
            dp[index].put(limits, value);
            return value;
        }

        if (arr[index] < maxIncreasing && arr[index] < minDecreasing) {
            int value = findMax(calculate(arr, index + 1, maxIncreasing, minDecreasing, increasing, decreasing, dp), calculate(arr, index + 1, maxIncreasing, arr[index], increasing, decreasing + 1, dp));
            dp[index].put(limits, value);

            return value;
        }

        return 0;
    }

    private static int findMax(Integer... numbers) {
        List<Integer> ints = Arrays.asList(numbers);
        return Collections.max(ints);
    }

    static class Limits {
        int maxIncreasing;
        int minDecreasing;

        public Limits(int maxIncreasing, int minDecreasing) {
            this.maxIncreasing = maxIncreasing;
            this.minDecreasing = minDecreasing;
        }

        @Override public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Limits Limits = (Limits) o;
            return maxIncreasing == Limits.maxIncreasing &&
                minDecreasing == Limits.minDecreasing;
        }

        @Override public int hashCode() {

            return Objects.hash(maxIncreasing, minDecreasing);
        }
    }
}