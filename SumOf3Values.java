import java.util.Arrays;
import java.util.Scanner;

public class SumOf3Values {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt(),
                x = sc.nextInt();
            int[][] a = new int[n][2];
            for (int i = 0; i < n; i++) {
                a[i][0] = sc.nextInt();
                a[i][1] = i + 1;
            }
            Arrays.sort(a, (v1, v2) -> Integer.compare(v1[0], v2[0]));

            int[] ans = new int[]{-1,-1,-1};
            for (int i = 0; i < n - 2; i++) {
                int p1 = i + 1, p2 = n - 1;
                while (p1 < p2) {
                    int sum = a[p1][0] + a[p2][0] + a[i][0] - x;
                    if (sum == 0) {
                        ans[0] = a[i][1];
                        ans[1] = a[p1][1];
                        ans[2] = a[p2][1];
                        break;
                    }
                    if (sum > 0)    p2--;
                    else    p1++;
                }
                if (ans[0] != -1)   break;
            }
            
            if (ans[0] == -1)   System.out.println("IMPOSSIBLE");
            else System.out.println(ans[0] + " " + ans[1] + " " + ans[2]);
        }
    }
}
