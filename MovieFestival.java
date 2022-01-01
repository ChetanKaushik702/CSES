import java.io.*;
import java.util.Arrays;

public class MovieFestival {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            int[][] time = new int[n][2];

            for (int i = 0; i < n; i++) {
                String[] s = br.readLine().split(" ");
                time[i][0] = Integer.parseInt(s[0]);
                time[i][1] = Integer.parseInt(s[1]);
            }

            Arrays.sort(time, (t1, t2) -> Integer.compare(t1[1], t2[1]));
            
            int count = 1, currEnd = time[0][1];
            for (int i = 1; i < n; i++) {
                if (time[i][0] >= currEnd) {
                    count++;
                    currEnd = time[i][1];
                }
            }
            System.out.println(count);
        }
    }
}
