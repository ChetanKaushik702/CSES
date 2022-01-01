import java.io.*;

public class Repetitions {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String s = br.readLine();

            int len = 1, i = 0;
            while (i < s.length()) {
                int count = 1;
                while (i < s.length() - 1 && s.charAt(i) == s.charAt(i+1)) {
                    count++;
                    i++;
                }
                if (len < count) len = count;
                i++;
            }

            System.out.println(len);
        }
    }
}