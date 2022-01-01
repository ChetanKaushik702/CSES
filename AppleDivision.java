import java.io.*;

public class AppleDivision {

    static long minDiff = Long.MAX_VALUE;

    static void getMinDiff(String[] s, int i, long s1, long s2) {
        if (i == s.length) {
            minDiff = Math.min(minDiff, Math.abs(s1 - s2));
        } else {
            getMinDiff(s, i + 1, s1 + Integer.parseInt(s[i]), s2);
            getMinDiff(s, i + 1, s1, s2 + Integer.parseInt(s[i]));
        }
    }

    public static void main(String[] args) throws IOException{
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            br.readLine();
            String[] s = br.readLine().split(" ");

            getMinDiff(s, 0, 0, 0);
            System.out.println(minDiff);
        }
    }    
}
