package 数据结构.哈希表;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//拉链法
public class Main_840_solve1 {
    static int N = 100003;
    static int h[] = new int[N];
    static int e[] = new int[N];
    static int ne[] = new int[N];
    static int idx = 0;

    static void insert(int x) {
        //这就是我们的hash函数
        int k = (x % N + N) % N;//让k变成正数,k表示存到hash表哪个位置
        e[idx] = x;
        ne[idx] = h[k];
        h[k] = idx++;
    }

    static boolean find(int x) {
        int k = (x % N + N) % N;
        //遍历k处的链表
        for (int i = h[k]; i != -1; i = ne[i]) {
            if (e[i] == x) return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        //清空slot
        Arrays.fill(h, -1);

        String op;
        int n, x;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        while (n-- > 0) {
            String s[] = bf.readLine().split(" ");
            op = s[0];
            x = Integer.parseInt(s[1]);

            if ("I".equals(op)) {
                insert(x);
            } else {
                if (find(x)) System.out.println("Yes");
                else System.out.println("No");
            }

        }
    }

}

