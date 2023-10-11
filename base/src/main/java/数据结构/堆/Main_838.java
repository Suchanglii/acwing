package 数据结构.堆;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_838 {
    static int N = 100010;
    static int n, m, size;
    static int h[] = new int[N];

    static void down(int u) {
        int t = u;
        if (u * 2 <= size && h[u * 2] < h[t]) t = u * 2;
        if (u * 2 + 1 <= size && h[u * 2 + 1] < h[t]) t = u * 2 + 1;
        if (t != u) {
            int temp = h[t];
            h[t] = h[u];
            h[u] = temp;
            down(t);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s[] = bf.readLine().split(" ");
        n = size = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        s = bf.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            h[i] = Integer.parseInt(s[i - 1]);
        }

        //建堆,
        //使用down方式建堆,这样做的条件是必须要有子节点
        //画个图一看,发现高度为1的结点有子节点的结点编号就是n/2
        //所以从n/2,开始,将1~n/2的元素做一遍down操作
        for (int i = n / 2; i > 0; i--) down(i);

        while (m-- > 0) {
            System.out.print(h[1] + " ");
            h[1] = h[size];
            size--;
            down(1);
        }
        //可以debug看一下,创建的堆是怎么样的,就明白不能用这种方式去取连续的最小值了
//        for (int i = 1; i <= m; i++) {
//            System.out.print(h[i]);
//        }
    }
}
