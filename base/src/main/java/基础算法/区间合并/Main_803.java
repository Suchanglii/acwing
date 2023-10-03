package 基础算法.区间合并;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_803 {
    static int n;
    static int q[][], k[][];

    static void quick_sort(int l, int r) {
        if (l >= r) return;
        int a = q[l][0];
        int i = l - 1, j = r + 1;
        while (i < j) {
            while (q[++i][0] < a) ;
            while (q[--j][0] > a) ;
            if (i < j) {
                int[] temp = q[i];
                q[i] = q[j];
                q[j] = temp;
            }
        }
        quick_sort(l, j);
        quick_sort(j + 1, r);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        q = new int[n][2];
        k = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] st = br.readLine().split(" ");
            q[i][0] = Integer.parseInt(st[0]);
            q[i][1] = Integer.parseInt(st[1]);
        }

        quick_sort(0, n - 1);

        int idx = -1;
        for (int i = 0; i < n; i++) {
            int l = q[i][0];
            int r = q[i][1];

            if (idx == -1 || k[idx][1] < l) {
                k[++idx] = q[i];
            } else {
                k[idx][1] = Math.max(r, k[idx][1]);
            }
        }
        System.out.println(Arrays.copyOf(k, idx + 1).length);

    }
}
