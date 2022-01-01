import java.util.Scanner;

public class GrayCode {

    static void grayCode(int n, String code) {
        if (n == 0) {
            StringBuilder gray = new StringBuilder();
            gray.append(code.charAt(0));

            for (int i = 1; i < code.length(); i++) {
                int xor = (code.charAt(i-1) - '0') ^ (code.charAt(i) - '0');
                gray.append(xor);
            }

            System.out.println(gray);
        }
        else {
            grayCode(n - 1, code + "0");
            grayCode(n - 1, code + "1");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        grayCode(n, "");
        sc.close();
    }
}
