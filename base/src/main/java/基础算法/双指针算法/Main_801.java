package 基础算法.双指针算法;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_801 {
    static int n, m;
    static int N = 100010;
    static int a[] = new int[N];
    static int b[] = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        n = Integer.parseInt(st[0]);
        m = Integer.parseInt(st[1]);
        st = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st[i]);
        }
        st = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st[i]);
        }
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (a[i] == b[j]) i++;
            j++;
        }
        if (i == n) System.out.println("Yes");
        else System.out.println("No");
    }
}
