package 数据结构.并查集;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_837 {
    static int N = 100010;
    static int p[] = new int[N];
    static int size[] = new int[N];

    static int find(int x) {
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        for (int i = 0; i <= n; i++) {
            p[i] = i;
            size[i] = 1;
        }

        while (m-- > 0) {
            s = br.readLine().split(" ");
            String op = s[0];
            int a, b;
            switch (op) {
                case "C":
                    a = Integer.parseInt(s[1]);
                    b = Integer.parseInt(s[2]);
                    if (find(a) == find(b)) continue;
                    size[find(b)] += size[find(a)];//注意,别写反了
                    p[find(a)] = find(b);
                    break;
                case "Q1":
                    a = Integer.parseInt(s[1]);
                    b = Integer.parseInt(s[2]);
                    if (find(a) == find(b)) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No");
                    }
                    break;
                default:
                    a = Integer.parseInt(s[1]);
                    System.out.println(size[find(a)]);
                    break;
            }
        }
    }
}
