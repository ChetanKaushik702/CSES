import java.io.*;

public class MaxSumSubArray {

    static long toLong(String s) {
        return Long.parseLong(s);
    }
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            String[] s = br.readLine().split(" ");
            
            long globMax = toLong(s[0]),
                currMax = toLong(s[0]);
            
            for (int i = 1; i < n; i++) {
                currMax = Math.max(currMax + toLong(s[i]), toLong(s[i]));
                globMax = Math.max(globMax, currMax);
            }

            System.out.println(globMax);
        }
    }
}
