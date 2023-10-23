package 算法;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_841 {
    static int N = 100010;
    static long p[] = new long[N];
    static long h[] = new long[N];
    static int P = 131;
    static long Q = Long.MAX_VALUE;

    static long get(int l, int r) {
        return h[r] - h[l - 1] * p[l - r + 1];
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        String ss = br.readLine();
        //初始化
        p[0] = 1;
        for (int i = 1; i <= n; i++) {
            p[i] = (p[i - 1] * P) % Q;
            h[i] = (h[i - 1] * P + ss.charAt(i - 1)) % Q;
        }

        while (m-- > 0) {
            s = br.readLine().split(" ");
            int l1 = Integer.parseInt(s[0]);
            int r1 = Integer.parseInt(s[1]);
            int l2 = Integer.parseInt(s[2]);
            int r2 = Integer.parseInt(s[3]);
            if (get(l1,r1) == get(l2,r2)) System.out.println("Yes");
            else System.out.println("No");
        }
    }

}
