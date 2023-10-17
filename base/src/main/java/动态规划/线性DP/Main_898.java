package 动态规划.线性DP;

import java.util.Scanner;

public class Main_898 {
    static int N = 510;
    static int f[][] = new int[N][N];
    static int w[][] = new int[N][N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                f[i][j] = sc.nextInt();//初始化每个点的权
            }
        }
        //发现可以优化
//        for (int i = 1; i <= n; i++) {
//            f[n][i] = w[n][i];
//        }
        for (int i = n - 1; i > 0; i--) {
            for (int j = 1; j <= i; j++) {
                f[i][j] += Math.max(f[i + 1][j], f[i + 1][j + 1]) ;
            }
        }

        System.out.println(f[1][1]);

    }
}
