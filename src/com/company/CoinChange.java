package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoinChange {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Long t = Long.parseLong(br.readLine());
        int dp[][];

        for (int i = 0; i < t; i++) {
            int size = Integer.parseInt(br.readLine());
            String[] split = br.readLine().split(" ");
            int sum = Integer.parseInt(br.readLine());
            dp = new int[sum + 1][size + 1];

            int[] cents = new int[size];

            for (int k = 0; k < size; k++) {
                cents[k] = Integer.parseInt(split[k]);
            }

            System.out.println(calculate(cents, sum, size, dp));
        }
    }

    private static int calculate(int[] cents, int sum, int size, int[][] dp) {

        if (sum >= 0 && size >= 0 && dp[sum][size] != 0) {
            return dp[sum][size];
        }

        if (sum == 0) {
            dp[sum][size] = 1;
            return 1;
        }

        if (sum < 0) {
            return 0;
        }

        if (size <= 0 && sum >= 1) {
            return 0;
        }

        int count = calculate(cents, sum, size - 1, dp) + calculate(cents, sum - cents[size - 1], size, dp);
        dp[sum][size] = count;
        return count;
    }
}
