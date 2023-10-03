package 基础算法.前缀和与差分;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_797 {
    static int n, m;
    static int N = 100010;
    static int[] a = new int[N];
    static int[] b = new int[N];
    static int l, r, c;

    static void insert(int l, int r, int c) {
        b[l] += c;
        b[r + 1] -= c;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        s = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(s[i-1]);
        }
        //直接构造法
        //这种方法相当于将a中的每个值插入到b中
        for (int i = 1; i <= n; i++) {
            insert(i, i, a[i]);
        }
        while (m-- > 0) {
            s = br.readLine().split(" ");
            l = Integer.parseInt(s[0]);
            r = Integer.parseInt(s[1]);
            c = Integer.parseInt(s[2]);
            insert(l, r, c);
        }
        //前一个值决定了后一个值
        for (int i = 1; i <= n; i++) {
            b[i] += b[i - 1];
            System.out.print(b[i]+" ");
        }
    }
}
