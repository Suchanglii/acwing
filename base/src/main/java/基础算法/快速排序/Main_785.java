package 基础算法.快速排序;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_785 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());//读取n位
        int[] arr = new int[n];//创建n大小的数组
        String[] str = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        System.out.println(Arrays.toString(arr));
        quick_sort(arr, 0, n - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quick_sort(int[] q, int l, int r) {
        if (l >= r) return;
        int i = l - 1, j = r + 1;
        int x = q[l];
        while (i < j) {
            while (q[++i] < x) ;
            while (q[--j] > x) ;
            if (i < j) {
                int temp = q[i];
                q[i] = q[j];
                q[j] = temp;
            }
        }
        quick_sort(q, l, j);
        quick_sort(q, j + 1, r);
    }
}
