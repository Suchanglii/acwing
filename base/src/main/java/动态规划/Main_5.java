package 动态规划;

//使用二进制优化

import java.util.Scanner;
import java.util.Vector;

public class Main_5 {
    static int N = 2010;
    static int f[] = new int[N];

    static Vector<Good> goods = new Vector();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            int v, w, s;
            v = sc.nextInt();
            w = sc.nextInt();
            s = sc.nextInt();
            for (int k = 1; k <= s; k *= 2) {
                s -= k;
                goods.add(new Good(k * v, k * w));
            }
            if (s > 0) goods.add(new Good(s * v, s * w));
        }

        for (Good good : goods) {
            for (int j = m; good.v <= j; j--) {
                f[j] = Math.max(f[j], f[j - good.v] + good.w);
            }
        }

        System.out.println(f[m]);
    }
}

class Good {
    int v, w;

    public Good(int v, int w) {
        this.v = v;
        this.w = w;
    }
}
