package 算法;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Solution_831 {
    public static int N = 1000010, M = 100010;
    public static int next[] = new int[N];
    public static char p[] = new char[N];
    public static char s[] = new char[M];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(bf.readLine());
        char ss[] = bf.readLine().toCharArray();
        for (int i = 1; i <= n; i++) {
            p[i] = ss[i - 1];
        }
        int m = Integer.parseInt(bf.readLine());
        ss = bf.readLine().toCharArray();
        for(int i = 1; i <= m; i++) {
            s[i] = ss[i - 1];
        }

        for (int i = 2, j = 0; i <= m; i++) {
            while (j != 0 && p[i] != p[j + 1]) j = next[j];
            if (p[i] == p[j + 1]) j++;
            next[i] = j;
        }
        for (int i = 1, j = 0; i <= m; i++) {
            while (j != 0 && s[i] != p[j + 1]) j = next[j];//不创建j = 0;是因为next[0] = 0,死循环了
            if (s[i] == p[j + 1]) j++;
            if (j == n) {//说明包含一个完全一样的子串
                pw.write(i - n + " ");
                j = next[j];//j最大为m - 1,当j = m 的时候,next[j]变成自己了,没有意义
            }
        }
        pw.flush();
        pw.close();
    }
}
