package 其他;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 一个整数数组,求"超过一半"的元素个数
 * n = 8    1 2 3 4 4 4 4 4 其中4就是值,
 * 在 1 2 3 4 4 4 4 5 中,并未超一半(等于一半),返回-1
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入元素个数");
        int n = sc.nextInt();
        int p[] = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = sc.nextInt();
        }

        Arrays.sort(p);

        for (int i = 0; i <= n / 2; i++) {
            int j = i + n / 2;
            if (j < n && p[i] == p[j]) {
                System.out.println(p[i]);
                break;
            }
            if (i == n / 2) System.out.println("-1");
        }
    }
}
