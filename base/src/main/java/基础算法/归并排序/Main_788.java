package 基础算法.归并排序;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_788 {
    static int N = 100010, n;
    static int[] q = new int[N];
    static int[] tmp = new int[N];

    static long merge_sort(int l, int r) {
        if (l >= r) return 0;
        int mid = l + r >> 1;
        long res = merge_sort(l, mid) + merge_sort(mid + 1, r);
        int k = 0, i = l, j = mid + 1;
        while (i <= mid && j <= r) {
            if (q[i] <= q[j]) {tmp[k++] = q[i++];} else {
                res += mid - i + 1;
                tmp[k++] = q[j++];
            }
        }
        while (i <= mid) tmp[k++] = q[i++];
        while (j <= r) tmp[k++] = q[j++];
        for (i = l, j = 0; i <= r; i++, j++) {
            q[i] = tmp[j];
        }
        return res;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            q[i] = Integer.parseInt(s[i]);
        }
        System.out.println(merge_sort(0, n - 1));
    }
}
