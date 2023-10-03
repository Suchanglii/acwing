package 基础算法.前缀和与差分;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//有点暴力,需要把每排的和都算出来存储
public class Main_796_1 {
    static int n, m, q;
    static int[][] k, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        q = Integer.parseInt(s[2]);
        k = new int[n + 1][m + 1];//因为从1开始,防止越界
        for (int i = 1; i < n + 1; i++) {
            s = br.readLine().split(" ");
            for (int j = 1; j <= m; j++) {
                k[i][j] = Integer.parseInt(s[j - 1]);
            }
        }

        //用来存每行的前缀和
        c = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                c[i][j] = c[i][j - 1] + k[i][j];
            }
        }

        while (q-- > 0) {
            int x1, y1, x2, y2;
            s = br.readLine().split(" ");
            x1 = Integer.parseInt(s[0]);
            y1 = Integer.parseInt(s[1]);
            x2 = Integer.parseInt(s[2]);
            y2 = Integer.parseInt(s[3]);
            int res = 0;
            while (x2 - x1 >= 0) {
                res += c[x1][y2] - c[x1][y1-1];
                x1++;
            }
            System.out.println(res);

        }
    }
}
