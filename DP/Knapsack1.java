package CSES.DP;

import java.util.Scanner;

public class Knapsack1 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt(),
                w = sc.nextInt();
            int[][] items = new int[n][2];
            for (int i = 0; i < n; i++) {
                items[i][0] = sc.nextInt();
                items[i][1] = sc.nextInt();
            }

            long[] dp = new long[w+1];
            for (int i = 0; i < n; i++) {
                for (int j = w; j >= items[i][0]; j--) {
                    dp[j] = Math.max(dp[j], dp[j-items[i][0]] + items[i][1]);
                }
            }
            System.out.println(dp[w]);
        }
    }
}
