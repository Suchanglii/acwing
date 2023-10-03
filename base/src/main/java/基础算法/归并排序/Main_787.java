package 基础算法.归并排序;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_787 {
    static int N = 100010, n;
    static int[] w = new int[N];
    static int[] tmp = new int[N];

    static void merge_sort(int[] q, int l, int r) {
        if (l >= r) return;
        int mid = (l + r) >> 1;
        merge_sort(q, l, mid);
        merge_sort(q, mid + 1, r);
        int i = l, j = mid + 1, k = 0;
        while (i <= mid && j <= r) {
            if (q[i] <= q[j]) tmp[k++] = q[i++];
            else tmp[k++] = q[j++];
        }
        while (i <= mid) tmp[k++] = q[i++];
        while (j <= r) tmp[k++] = q[j++];
        for (i = l, j = 0; i <= r; i++, j++) q[i] = tmp[j];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            w[i] = Integer.parseInt(s[i]);
        }
        merge_sort(w, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(w[i]+" ");
        }
    }
}
