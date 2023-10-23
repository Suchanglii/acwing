package 算法;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_830 {
    static int N = 100010;
    static int tt = 0;
    static int stk[] = new int[N];


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int  n = sc.nextInt();
        // for (int i = 0; i < n; i++) {
        //     int x = sc.nextInt();
        //     while(tt != 0 && stk[tt] >= x) tt--;
        //     if (tt != 0) System.out.print(stk[tt] + " ");
        //     else System.out.print("-1" + " ");
        //     stk[++tt] = x;
        // }
        int res[] = new int[N];
        Arrays.fill(res, -1);
        //反着写,去看acwing
        //注释了的是错的,改变思路,就对了
//        for (int i = n; i > 0; i--) {
//            int x = sc.nextInt();
//            while (tt != 0 && stk[tt] >= x) {
//                res[i] = x;
//                tt--;
//            }
//            stk[++tt] = x;
//        }
        int a[] = new int[N];
        for (int i = 1; i <= n; i++) a[i] = sc.nextInt();
        for (int i = n; i > 0; i--) {
//            int x = sc.nextInt();
            while (tt != 0 && a[stk[tt]] > a[i]) {
                res[stk[tt]] = a[i];
                tt--;
            }
            stk[++tt] = i;
        }
        for (int i = 1; i <= n; i++) {
            System.out.println(res[i]);
        }
    }
}
