import java.io.*;

public class MissingNumber {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            String[] s = br.readLine().split(" ");

            int xor = 0;
            for (int i = 1; i <= n; i++) xor ^= i;

            for (String str : s) xor ^= Integer.parseInt(str);

            System.out.println(xor);
        }
    }
}
