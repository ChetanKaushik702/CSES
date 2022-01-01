import java.util.Scanner;

public class TowersOfHanoi {

    static int moves = 0;
    static StringBuilder out = new StringBuilder();

    static void toh(int n, int a, int b, int c) {
        if (n == 1) {
            moves++;
            out.append(a + " " + c).append("\n");
        } else {
            toh(n - 1, a, c, b);
            moves++;
            out.append(a + " " + c).append("\n");
            toh(n - 1, b, a, c);
        }
    }
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            toh(n, 1, 2, 3);
            System.out.print(moves + "\n" + out);
        }
    }
}
