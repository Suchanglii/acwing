package 动态规划;

import java.util.Scanner;

public class Main_9 {
    static int N = 110;
    static int v[] = new int[N];
    static int w[] = new int[N];
    static int f[] = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            for (int j = 0; j < s; j++) {
                v[j] = sc.nextInt();
                w[j] = sc.nextInt();
            }
            for (int j = m; j >= 0; j--) {
                for(int k = 0; k < s; k++) {
                    if (j >= v[k])f[j] = Math.max(f[j], f[j - v[k]] + w[k]);
                }
            }
        }
        System.out.println(f[m]);
    }
}
