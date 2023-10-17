package 动态规划.背包问题;

import java.util.Scanner;

public class Main_3 {
    static int N = 1010;
    static int v[] = new int[N];
    static int w[] = new int[N];
    static int f[] = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            for (int j = v[i]; j <= m; j++) {
                //f[j] = f[j];//因为j是从小到大遍历,所以这里应该是f[i][j] = f[i - 1][j];是一样的
                //这里实际上是优化了很多步骤,具体可以看readme
                //如果不优化,会有三重循环
                f[j] = Math.max(f[j], f[j - v[i]] + w[i]);
                //f[j] = Math.max(f[i][j], f[i][j - v[i]] + w[i]);
                //观察上式,发现我们需要的f[i][j - v[i]],需要的是更新过的.
            }
        }

        System.out.println(f[m]);
//        int res = 0;
//        for (int i = 1; i <= m; i++) {
//            res = Math.max(res, f[n][i]);
//        }
//        System.out.println(res);
    }
}
