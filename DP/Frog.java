package CSES.DP;
import java.io.*;

public class Frog {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] s = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]),
                k = Integer.parseInt(s[1]);
            
            s = br.readLine().split(" ");
            int[] dp = new int[n];
            for (int i = 1; i < n; i++) {
                int cost = Integer.MAX_VALUE;
                for (int j = i - 1; j >= 0 && j >= i - k; j--) {
                    cost = Math.min(cost, Math.abs(Integer.parseInt(s[i]) - Integer.parseInt(s[j])) + dp[j]);
                }
                dp[i] = cost;
            }
            System.out.println(dp[n-1]); 
        }
    }
}
