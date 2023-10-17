package 动态规划.背包问题;

import java.io.IOException;
import java.util.Scanner;

public class Main_2 {
    static int N = 1010;
    static int f[][] = new int[N][N];//表示的是前i个物品,容积是j的时候.包中物品的最大价值
    static int v[] = new int[N];
    static int w[] = new int[N];

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }

        //这种方式是遍历物品,背包j空间慢慢增大
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {// j有种背包容量的意思,对于每个物品,背包容量是逐渐增大再算的
                f[i][j] = f[i - 1][j];// 没选第i个物品
                // 如果此时背包空间大于等于第i个物品的体积,就可以将第i个物品放入(不用考虑上一个放入
                // 为什么这里考虑的不是背包剩余空间>=v[i]? 只要物品能放到背包中就行,后面如果空间不够,会
                // 取出一部分已经放入背包的东西
                if (j >= v[i]) f[i][j] = Math.max(f[i][j], f[i - 1][j - v[i]] + w[i]);
                // 为什么要用max(),不是已经决定要放到背包里面了吗?
                // 不行原因是:如果将加入的物品体积比较大,就会导致将已经放入背包的物品取出(j - v[i]表示要腾出i物品体积的空间
                // ,空间不够,就要拿出来已经存进去的东西),取出物品价值可能会大于放入的i物品的价值,得不偿失,所以用max衡量一下,取出与不取出的价值决定
//                if (j >= v[i]) f[i][j] = f[i - 1][j - v[i]] + w[i];
            }
        }

        int res = 0;
        for (int i = 0; i <= m; i++) {
            res = Math.max(res, f[n][i]);
        }
        System.out.println(res);
    }
}
