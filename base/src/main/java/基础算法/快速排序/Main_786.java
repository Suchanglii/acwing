package 基础算法.快速排序;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_786 {
    static int N = 100010, n, k;
    static int[] w = new int[N];

    static int quick_select(int l, int r, int k) {
        if (l >= r) return w[l];
        int i = l - 1, j = r + 1, x = w[l + r >> 1];
        while (i < j) {
            do i++; while (w[i] < x);
            do j--; while (w[j] > x);
            if (i < j) {
                int t = w[i];
                w[i] = w[j];
                w[j] = t;
            }
        }
        int sl= j - l + 1;//sl 是排序好的左边的个数
        if (sl >= k) return quick_select(l, j, k);
        return quick_select(j + 1, r, k - sl);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = reader.readLine().split(" ");
        n=Integer.parseInt(str[0]);
        k=Integer.parseInt(str[1]);
        str = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            w[i] = Integer.parseInt(str[i]);
        }
        System.out.println(quick_select(0,n-1,k));
    }
}
