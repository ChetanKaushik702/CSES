package CSES.DP;

import java.io.*;
import java.util.Arrays;

public class Vacation {
    static int[][] mem;

    static int solve(int n, int[][] schedule) {
        mem = new int[n][3];
        for (int i = 0; i < n; i++) Arrays.fill(mem[i], -1);
        
        for (int j = 0; j <= 2; j++) {
            helper(0, j, n, schedule);
        }

        int val = Math.max(mem[0][0], Math.max(mem[0][1], mem[0][2]));
        return val;
    }

    static int helper(int i, int j, int n, int[][] points) {
        if (i == n) return 0;
        if (mem[i][j] != -1)    return mem[i][j];

        mem[i][j] = points[i][j] + Math.max(helper(i+1, (j + 1) % 3, n, points), helper(i+1, (j + 2) % 3, n, points));
        return mem[i][j];
    } 

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            int[][] schedule = new int[n][3];
            for (int i = 0; i < n; i++) {
                String[] s = br.readLine().split(" ");
                schedule[i] = new int[]{Integer.parseInt(s[0]), Integer.parseInt(s[1]), Integer.parseInt(s[2])};
            }

            System.out.println(solve(n, schedule));
        }
    }
}
