package 数据结构.单调栈;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 此题注意,不是要找左边最小的,找的是第一个比x小的
 */
public class Main_830 {
    static int N = 100010;
    static int[] stk = new int[N];
    static int tt = 0;
    static int q[] = new int[N];

    //思想:及时去掉无用的元素
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
//---------错误的---------
//        for (int i = n; i > 0; i--) {
//            int x = sc.nextInt();
//            while (tt != 0 && stk[tt] >= x) {
//                res[i] = x;
//                tt--;
//            }
//            stk[++tt] = x;
//        }
//------------------------
//反过来写,将没有找到最近小的答案的数的下标放到栈里面,如果栈顶元素找到答案,就出栈,剩下的就是找不到答案的数
        int a[] = new int[N];
        for (int i = 1; i <= n; i++) a[i] = sc.nextInt();
        for (int i = n; i > 0; i--) {
            while (tt != 0 && a[stk[tt]] > a[i]) {
                res[stk[tt]] = a[i];
                tt--;
            }
            stk[++tt] = i;
        }
        for (int i = 1; i <= n; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
