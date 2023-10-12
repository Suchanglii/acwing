package 数据结构.哈希表;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//开放寻址法
public class Main_840_solve2 {
    static int N = 200003;
    static int h[] = new int[N];
    static int nil = 0x3f3f3f3f;

    /**
     * 寻找x的位置,如果找到了,返回下标.没有找到,返回它理应存在的地方的下标
     * @param x
     * @return
     */
    static int find(int x) {
        int k = (x % N + N) % N;
        while (h[k] != nil && h[k] != x) {
            k++;
            if (k == N) k = 0;//如果k到h最后一个了,再从头继续找
        }
        return k;
    }
    public static void main(String[] args) throws IOException {
        //清空槽
        Arrays.fill(h, nil);

        String op;
        int n, x, k;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        while (n-- > 0) {
            String s[] = bf.readLine().split(" ");
            op = s[0];
            x = Integer.parseInt(s[1]);
            k = find(x);
            if ("I".equals(op)) {
                h[k] = x;
            } else {
                if (x == h[k]) System.out.println("Yes");
                else System.out.println("No");
            }
        }

    }
}
