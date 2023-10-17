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
                goods.add(new Good(k * v, k * w));//这里实际上就是将物品打包,
                //以后我们放物品,就一组一组放,比如以前能拿45个苹果的包,需要拿45次
                //我们将40个苹果打包成一箱,再拿的时候,就直接拿一箱,再拿5个.
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
