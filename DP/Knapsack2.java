package CSES.DP;

import java.util.*;

public class Knapsack2 {

    static Map<int[], Long> mem;

    static long solve(int[][] items, int w) {
        mem = new HashMap<>();
        return helper(items, items.length - 1, w);
    }

    static long helper(int[][] items, int i, int w) {
        int[] key = {i,w};
        if (mem.containsKey(key))   return mem.get(key);
        if (w < 0 || i < 0) return 0; 
        if (items[i][0] > w)    return helper(items, i-1, w);
        long val = Math.max(helper(items, i-1, w), helper(items, i-1, w-items[i][0]) + items[i][1]);
        mem.put(key, val);

        return val;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt(),
                w = sc.nextInt(),
                v = 0;
            int[][] items = new int[n][2];
            for (int i = 0; i < n; i++) {
                items[i][0] = sc.nextInt();
                items[i][1] = sc.nextInt();
                v += items[i][1];
            }

            // System.out.println(solve(items, w));
            System.out.println(botUp(items, v, w));
        }
    }

    static long botUp(int[][] items, int v, int w) {
        long[] dp = new long[v + 1];
        Arrays.fill(dp, Long.MAX_VALUE);
        
        for (int i = 0; i < items.length; i++) {
            for (int j = v; j >= items[i][1]; j--) {
                if (j == items[i][1]) {
                    dp[j] = Math.min(dp[j], items[i][0]);
                } else {
                    if (dp[j-items[i][1]] != Long.MAX_VALUE) {
                        dp[j] = Math.min(dp[j], dp[j-items[i][1]] + items[i][0]);
                    }
                }
            }
        }
        long val = 0;
        for (int i = v; i >= 0; i--) {
            if (dp[i] <= w) {
                val = i;
                break;
            }
        }
        return val;
    }
}
