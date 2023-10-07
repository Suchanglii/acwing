package 数据结构.单调栈;

import java.io.IOException;
import java.util.Scanner;

/**
 * 此题注意,不是要找左边最小的,找的是第一个比x小的
 */
public class Main_830 {
    static int N = 100010;
    static int[] stk = new int[N];
    static int tt = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            //栈不为空,一直弹出元素,直到某个元素小于栈顶元素
            while (tt != 0 && stk[tt] >= x) tt--;
            //栈顶保存的实际上是当前数所对应的最优解
            if (tt != 0) System.out.print(stk[tt] + " ");
            else System.out.println("-1" + " ");
            stk[++tt] = x;
        }
    }
}
