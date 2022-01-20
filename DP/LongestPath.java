package CSES.DP;

import java.util.*;

public class LongestPath {

    static int[] mem;

    static int solve(List<List<Integer>> adj, int n) {
        mem = new int[n];
        Arrays.fill(mem, -1);
        int len = 0;
        for (int u = 0; u < n; u++) {
            if (mem[u] == -1) {
                len = Math.max(len, dfs(adj, u));
            }
        }
        return len;
    }

    static int dfs(List<List<Integer>> adj, int u) {
        if (mem[u] != -1)   return mem[u];

        int pathLen = 0;
        for (int v : adj.get(u)) {
            pathLen = Math.max(pathLen, 1 + dfs(adj, v));
        }

        mem[u] = pathLen;
        return pathLen;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt(),
                m = sc.nextInt();
            
            List<List<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                adj.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                int u = sc.nextInt(),
                    v = sc.nextInt();
                adj.get(u - 1).add(v - 1);
            }

            System.out.println(solve(adj, n));
        }
    }
}
