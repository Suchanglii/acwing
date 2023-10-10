package 数据结构.Trie树;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_143 {
    static int N = 100010, M = 31 * N;
    static int son[][] = new int[M][2];
    static int a[] = new int[N];
    static int idx = 0;
    //插入树
    static void insert(int n) {
       int p = 0;
        for (int i = 30; i >= 0; i--) {
            int u = n >> i & 1;
            if (son[p][u] == 0) son[p][u] = ++idx;
            p = son[p][u];
        }
    }

    //对于每个树都查
    static int query(int n) {
        int res = 0;
        int p = 0;
        for (int i = 30; i >= 0; i--) {
            int u = n >> i & 1;
            int x;
            if (son[p][ x = (1 - u)] != 0) {
//                res = res * 2 + x;
                res += 1 << i;
                p = son[p][1 - u];
            }
            else {
                p = son[p][u];
//                res = res * 2 + u;
            }
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s[] = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s[i]);
            insert(a[i]);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
//            res = Math.max(query(a[i]) ^ a[i], res);
            res = Math.max(query(a[i]), res);
        }
        System.out.println(res);

    }
}
