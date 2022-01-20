package CSES.DP;

import java.util.Scanner;

public class LCS {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String s = sc.nextLine();
            String t = sc.nextLine();

            int[][] dp = new int[s.length() + 1][t.length() + 1];

            for (int i = 1; i <= s.length(); i++) {
                for (int j = 1; j <= t.length(); j++) {
                    if (s.charAt(i-1) == t.charAt(j-1)) {
                        dp[i][j] = 1 + dp[i-1][j-1];
                    } else {
                        dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                    }
                }
            }

            StringBuilder str = new StringBuilder();
            int i = s.length(),
                j = t.length();
            while (i > 0 && j > 0) {
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    str.append(s.charAt(i-1));
                    i--;
                    j--;
                } else {
                    if (dp[i][j] == dp[i][j-1]) j--;
                    else    i--;
                }
            }
            str.reverse();
            System.out.println(str);
        }
    }
}
