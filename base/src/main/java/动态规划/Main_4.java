package 动态规划;

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
//        for (int i = 1; i <=n; i++) {
//        s[i] = sc.nextInt();
//            v[i] = sc.nextInt();
//            w[i] = sc.nextInt();
//        }

        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            for (int j = m; j >= 0; j--) {
                for (int k = 1; k <= s && k * v <= j; k++) {
                    f[j] = Math.max(f[j], f[j - k * v] + k * w);
                }
            }
        }

        System.out.println(f[m]);

    }
}
