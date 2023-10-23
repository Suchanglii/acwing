package 算法;

import java.util.Scanner;

public class Test08 {
    static int N = 110;
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
                for (int k = 1; k <= s && k * v <= j; k++) {
                    f[j] = Math.max(f[j], f[j - k * v] + k * w);
                }
            }
        }
        System.out.println(f[m]);
    }
}
