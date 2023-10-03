package 基础算法.前缀和与差分;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_798 {
    static int n, m, q;
    static int N = 1010;
    static int[][] k = new int[N][N];
    static int[][] s = new int[N][N];
    static int[][] h = new int[N][N];

    static void insert(int x1, int y1, int x2, int y2, int c) {
        s[x1][y1] += c;
        s[x2 + 1][y1] -= c;
        s[x1][y2 + 1] -= c;
        s[x2 + 1][y2 + 1] += c;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        q = Integer.parseInt(str[2]);
        for (int i = 1; i <= n; i++) {
            str = br.readLine().split(" ");
            for (int j = 1; j <= m; j++) {
                k[i][j] = Integer.parseInt(str[j - 1]);
            }
        }
        for (int i = 1; i <= n; i++) {// 构造方式二的差分数组
            for (int j = 1; j <= m; j++) {
                insert(i, j, i, j, k[i][j]);
                h[i][j] = k[i][j] - k[i - 1][j] - k[i][j - 1] + k[i - 1][j - 1];
            }
        }
        while (q-- > 0) {
            str = br.readLine().split(" ");
            int x1 = Integer.parseInt(str[0]);
            int y1 = Integer.parseInt(str[1]);
            int x2 = Integer.parseInt(str[2]);
            int y2 = Integer.parseInt(str[3]);
            int c = Integer.parseInt(str[4]);
            insert(x1, y1, x2, y2, c);
            //方式二
            h[x1][y1] += c;
            h[x2 + 1][y1] -= c;
            h[x1][y2 + 1] -= c;
            h[x2 + 1][y2 + 1] += c;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                s[i][j] += s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1];
                System.out.print(s[i][j] + " ");

            }
            System.out.println();
        }
        System.out.println("=========================");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                h[i][j] += h[i - 1][j] + h[i][j - 1] - h[i - 1][j - 1];
                System.out.print(h[i][j] + " ");
            }
            System.out.println();
        }
    }
}
