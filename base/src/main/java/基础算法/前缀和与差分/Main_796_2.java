package 基础算法.前缀和与差分;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_796_2 {
    static int n, m, q;
    static int[][] k, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        q = Integer.parseInt(s[2]);
        k = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            s = br.readLine().split(" ");
            for (int j = 1; j < m + 1; j++) {
                k[i][j] = Integer.parseInt(s[j - 1]);
            }
        }
        //使用y总公式
        //用来存该点(x,y)到(0,0)点矩形的前缀和
        //不清楚可以画图,画完就明白了
        c = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                c[i][j] = c[i - 1][j] + c[i][j - 1] - c[i - 1][j - 1] + k[i][j];
            }
        }
        while (q-- > 0) {
            int x1, y1, x2, y2;
            s = br.readLine().split(" ");
            x1 = Integer.parseInt(s[0]);
            y1 = Integer.parseInt(s[1]);
            x2 = Integer.parseInt(s[2]);
            y2 = Integer.parseInt(s[3]);
            System.out.println(c[x2][y2] - c[x2][y1 - 1] - c[x1 - 1][y2] + c[x1 - 1][y1 - 1]);
        }
    }
}
