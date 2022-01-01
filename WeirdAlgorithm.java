import java.io.*;

public class WeirdAlgorithm {

    static String solve(long n) {
        StringBuilder out = new StringBuilder();
        while (n != 1) {
            out.append(n).append(" ");
            if ((n & 1) == 1) n = n * 3 + 1;
            else    n /= 2;
        }

        out.append(1);

        return out.toString();
    }

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            String out = solve(n);
            System.out.println(out);
        }
    }
}