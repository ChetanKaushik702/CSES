import java.util.Scanner;

public class GridPaths {
    static int count = 0;

    static void getCount(int[][] mat, int i, int j, String path, String check) {
        if (i < 0 || i == 7 || j < 0 || j == 7 || mat[i][j] == -1) return;

        if (i == 6 && j == 0) {
            // System.out.println(path);
            if (path.length() == check.length()) {
                boolean flag = true;
                for (int k = 0; k < check.length(); k++) {
                    if (check.charAt(k) == '?') continue;
                    if (check.charAt(k) != path.charAt(k)) {
                        flag = false;
                        break;
                    }
                }
                if (flag)   count++;
            }
            return;
        }

        // down
        mat[i][j] = -1;
        getCount(mat, i+1, j, path + "D", check);
        // mat[i][j] = 0;

        // up
        // mat[i][j] = -1;
        getCount(mat, i-1, j, path + "U", check);
        // mat[i][j] = 0;

        // left
        // mat[i][j] = -1;
        getCount(mat, i, j-1, path + "L", check);
        // mat[i][j] = 0;

        // right
        // mat[i][j] = -1;
        getCount(mat, i, j+1, path + "R", check);
        mat[i][j] = 0;
    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            String check = sc.nextLine();
            getCount(new int[7][7], 0, 0, "", check);
            System.out.println(count);
        }
    }
}
