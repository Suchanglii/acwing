package 基础算法.位运算;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_802 {
    static int n;
    static int N = 100010;
    static int q[] = new int[N];

    static int lowBit(int x) {
        return x & -x;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] st = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            q[i] = Integer.parseInt(st[i]);
        }

        //y总简介写法
        for (int i = 0; i < n; i++) {
            int res = 0;
            for (int j = q[i]; j != 0; j -= j & -j) res++;
            System.out.print(res+" ");
        }

        //lowBit做法
//        for (int i = 0; i < n; i++) {
//            int res = 0;
//            while (q[i] != 0) {
//                q[i] -= lowBit(q[i]);
//                res++;
//            }
//            System.out.print(res+" ");
//        }

//        for (int i = 0; i < n; i++) {
//            int res = 0;
//            while (q[i] != 0) {
//                if (q[i] % 2 == 1) res++;
//                q[i] = q[i] >> 1;
//            }
//            System.out.print(res+" ");
//        }

    }
}
