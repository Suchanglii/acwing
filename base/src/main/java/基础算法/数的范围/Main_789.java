package 基础算法.数的范围;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_789 {
    static void num_range(int[] q, int[] k) {
        for (int i = 0; i < k.length; i++) {
            int l = 0, r = q.length - 1;
            int x = k[i];
            while (l < r) {
                int mid = l + r >> 1;
                if (q[mid] >= x) r = mid;
                else l = mid + 1;
            }
            if (q[l] != x) System.out.println("-1 -1");
            else {
                System.out.print(l + " ");
                l = 0;
                r = q.length - 1;
                while (l < r) {
                    int mid = l + r + 1 >> 1;
                    if (q[mid] <= x) l = mid;
                    else r = mid - 1;
                }
                System.out.println(l);
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int[] q = new int[n];
        s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            q[i] = Integer.parseInt(s[i]);
        }
        int[] k = new int[m];
        for (int i = 0; i < m; i++) {
            k[i] = Integer.parseInt(br.readLine());
        }
        num_range(q, k);
    }
}
