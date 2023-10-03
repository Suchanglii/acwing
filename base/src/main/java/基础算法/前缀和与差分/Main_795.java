package 基础算法.前缀和与差分;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_795 {
    static int n, m;
    static int N = 100010;
    static int[] q = new int[N];
    static int[] c = new int[N];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        s = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            q[i] = Integer.parseInt(s[i-1]);
        }
        for (int i = 1; i <= n; i++) {
            c[i] = c[i - 1] + q[i];
        }
        while (m-- > 0) {
            int l, r;
            s = br.readLine().split(" ");
            l = Integer.parseInt(s[0]);
            r = Integer.parseInt(s[1]);
            System.out.println(c[r] - c[l - 1]);
        }
    }
}
