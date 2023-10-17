package 动态规划.背包问题;

import java.util.Scanner;

public class Main_4 {
    static int N = 110;
    static int s[] = new int[N];
    static int v[] = new int[N];
    static int w[] = new int[N];
    static int f[] = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            int v = sc.nextInt();
            int w = sc.nextInt();
            int s = sc.nextInt();
            for (int j = m; j >= 0; j--) {//这里可以看成是多个物品,选育不选,就是01背包了,而不是完全背包
                for (int k = 0; k <= s && k * v <= j; k++) {//遍历s个物品,k是选取个数
                    //-------------
                    //f[i][j] = f[i - 1][j];不需要
                    //if (k == 0) f[i][j] = max(f[i - 1][j], f[i - 1][j - k * v[i]] + k * w[i]);
                    //------------------------------
                    //f[i][j] = Math.max(f[i][j], f[i - 1][j - k * v] + k * w);//朴素做法

                    f[j] = Math.max(f[j], f[j - k * v] + k * w);
                }
                //如果按照01背包的写法那么f[i][j]应该从f[i-1][j]和f[i-1][j-k*v[i]]+k*w[i]转移过来,但是这里max第一项写的是f[i][j].
                //f[i][j] = max(f[i-1][j], f[i - 1][j - k * v[i]] + k * w[i]);//惯常思路
                //写f[i-1][j]错误的原因是,取不同k下标的值只要大于f[i-1][j]就会被更新,而事实上要找的是取不同k下标的最大值,所以max第一项要写成f[i][j]
                //举个例子,有一个守擂台a和一个挑战者集合B,如果B中有人打败a就应该替换a,让别人挑战自己;而不是挑战者只能和a打,打败a就能守擂.
                //那么你会问f[i][j]一开始不是0吗,不取f[i-1][j],不会漏掉情况吗?事实上不会,当k=0时,f[i][j] = max(f[i][j],f[i-1][j]),这一步就会把f[i-1][j]的值转移过来
                //以上简介来自:https://zhuanlan.zhihu.com/p/368901684
            }
        }
        System.out.println(f[m]);
        //------------------------------
        // int res = 0;
        // for (int i = 0; i <= m; i++) {
        //     res = Math.max(res, f[n][i]);
        // }
        // System.out.println(res);
    }
}
