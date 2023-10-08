package 数据结构.单调队列_滑动窗口;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_154 {
    static int N = 1000010;
    static int a[] = new int[N];
    static int q[] = new int[N];
    static int n, k;
    static int hh = 0, tt = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        k = Integer.parseInt(s[1]);
        s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s[i]);
        }
        //可以使用一个数据模拟一下,比如:5 6 7 8 1
        for (int i = 0; i < n; i++) {
            //i - k + 1 > q[hh] 队列中的元素超过k个了,要把hh出队了
            //i - k + 1 实际上是滑动窗口的左边界(当前值),如果q[hh](实际上现在的左边界)小了,说明元素已经滑出了窗口,
            if (hh <= tt && i - k + 1 > q[hh]) hh++;
            while (hh <= tt && a[q[tt]] >= a[i]) tt--;
            q[++tt] = i;
            if (i >= k - 1) System.out.print(a[q[hh]] + " ");
        }
        System.out.println();
        hh = 0;
        tt = -1;
        for (int i = 0; i < n; i++) {
            if (hh <= tt && i - k + 1 > q[hh]) hh++;
            while (hh <= tt && a[q[tt]] <= a[i]) tt--;
            q[++tt] = i;
            if (i >= k - 1) System.out.print(a[q[hh]] + " ");
        }

    }
}
