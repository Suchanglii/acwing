package 数据结构.哈希表;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_841 {
    static int N = 100010, P = 131;//P表示多少进制
    static long h[] = new long[N];//存的是某段字符串的hash值
    static long p[] = new long[N];//对应位的权
    static long Q = Long.MAX_VALUE;
    //12 1
    //xadfghbvcxas
    //1 2 10 11
    static long get(int l, int r) {
        return h[r] - h[l - 1] * p[r - l + 1];//这里乘p[r - l + 1]相当于乘以P的n次方
    }

    public static void main(String[] args) throws IOException {
        int n, m;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s[] = bf.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        String ss = bf.readLine();
        p[0] = 1;
        for (int i = 1; i <= n; i++) {
            p[i] = (p[i - 1] * P) % Q;
            h[i] = (h[i - 1] * P + ss.charAt(i - 1)) % Q;
        }
        while (m-- > 0) {
            s = bf.readLine().split(" ");
            int l1 = Integer.parseInt(s[0]), r1 = Integer.parseInt(s[1]), l2 = Integer.parseInt(s[2]), r2 =
                    Integer.parseInt(s[3]);
            if (get(l1, r1) == get(l2, r2)) System.out.println("Yes");
            else System.out.println("No");
        }
    }
}
