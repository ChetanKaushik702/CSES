import java.io.*;
import java.util.Arrays;

public class SumOfTwoValues {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] s = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int x = Integer.parseInt(s[1]);
            s = br.readLine().split(" ");

            int[][] a = new int[n][2];
            for (int i = 0; i < n; i++) {
                a[i][0] = Integer.parseInt(s[i]);
                a[i][1] = i + 1;
            }

            Arrays.sort(a, (v1, v2) -> Integer.compare(v1[0], v2[0]));
            int pos1 = -1, pos2 = -1;
            int p1 = 0, p2 = n - 1;
            while (p1 < p2) {
                int sum = a[p1][0] + a[p2][0];
                if (sum == x) {
                    pos1 = a[p1][1];
                    pos2 = a[p2][1];
                    break;
                }
                if (sum > x) p2--;
                else    p1++; 
            }

            if (pos1 == -1) System.out.println("IMPOSSIBLE");
            else    System.out.println(pos1 + " " + pos2);
        }
    }
}
