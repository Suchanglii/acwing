package 动态规划.背包问题;

import java.util.Scanner;

public class Main_2_opt {
    static int N = 1010;
    static int f[] = new int[N];
    static int v[] = new int[N];
    static int w[] = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }

        for (int i = 1; i <= n; i++) {//遍历n个物品
            for (int j = m; j >= v[i]; j--) {
                //根据main_2发现,可以压缩
                f[j] = Math.max( f[j],f[j - v[i]] + w[i]);
            }
        }

        System.out.println(f[m]);
    }
}
