package 数据结构.Trie树;

import java.util.Scanner;

public class Main_835 {
    static int N = 100010;
    static int son[][] = new int[N][26];//表示当前结点以及儿子结点
    static int cnt[] = new int[N]; //最多会有N调记录
    static int idx = 0;

    static void insert(char c[]) {
        int p = 0;//根节点
        for (int i = 0; i < c.length; i++) {
            int u = c[i] - 'a';
            //为0表示这个点不存在这个字符
            if (son[p][u] == 0) son[p][u] = ++idx;
            p = son[p][u];
        }
        cnt[p]++;
    }

    static int query(char c[]) {
        int p = 0;
        for (int i = 0; i < c.length; i++) {
            int u = c[i] - 'a';
            if (son[p][u] == 0) return 0;
            p = son[p][u];
        }
        return cnt[p];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String op1,op2;
        String sss= sc.nextLine();
        while (n-- > 0) {
            String s[] = sc.nextLine().split(" ");
            op1 = s[0];
            op2 = s[1];
            if ("I".equals(op1)) insert(op2.toCharArray());
            else System.out.println(query(op2.toCharArray()));
        }
    }
}
