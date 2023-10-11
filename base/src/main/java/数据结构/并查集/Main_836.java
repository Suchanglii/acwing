package 数据结构.并查集;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_836 {
    static int N = 100010;
    static int p[] = new int[N];

    /**
     * 带了路径压缩
     * @param x
     * @return
     */
    static int find(int x) {
        if (p[x] != x) p[x] = find(p[x]);//这一步执行完,p[x]就直接指向了根节点
        return p[x];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        //初始化结点
        for (int i = 1; i <= n; i++) {
            p[i] = i;
        }
        while (m-- > 0) {
            s = br.readLine().split(" ");
            String op = s[0];
            int n1 = Integer.parseInt(s[1]);
            int n2 = Integer.parseInt(s[2]);
            if ("M".equals(op)) {
                p[find(n1)] = find(n2);
            }else {
                if (find(n1) == find(n2)) {
                    System.out.println("Yes");
                }else {
                    System.out.println("No");
                }
            }
        }
    }
}
