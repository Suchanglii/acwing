package 基础算法.前缀和与差分;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_797_2 {
    static int n, m;
    static int N = 100009;
    static int[] a = new int[N];
    static int[] b = new int[N];
    static int l, r, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        s = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(s[i - 1]);
        }
        //这种方式更加直观明了
        for (int i = 1; i <= n; i++) {
            b[i] = a[i] - a[i - 1];
        }

        while (m-- > 0) {
            s = br.readLine().split(" ");
            l = Integer.parseInt(s[0]);
            r = Integer.parseInt(s[1]);
            c = Integer.parseInt(s[2]);
            b[l] += c;
            b[r + 1] -= c;
        }

        for (int i = 1; i <= n; i++) {
            b[i] += b[i - 1];
            System.out.print(b[i] + " ");
        }
    }
}
