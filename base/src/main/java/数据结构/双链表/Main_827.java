package 数据结构.双链表;

import java.util.Scanner;

public class Main_827 {
    static int M;
    static int N = 100010;
    static int[] e = new int[N];
    static int[] ne = new int[N];
    static int[] pe = new int[N];
    static int head, tail;
    static int idx;

    static void init() {
        head = 0;
        tail = 1;
        ne[head] = tail;
        pe[tail] = head;
        idx = 2;
    }

    static void L(int x) {
        e[idx] = x;
        pe[idx] = head;
        ne[idx] = ne[head];
        pe[ne[head]] = idx;
        ne[head] = idx++;
    }

    static void R(int x) {
        e[idx] = x;
        ne[idx] = tail;
        pe[idx] = pe[tail];
        ne[pe[tail]] = idx;
        pe[tail] = idx++;
    }

    static void IR(int k, int x) {
        e[idx] = x;
        ne[idx] = ne[k];
        pe[idx] = k;
        ne[pe[idx]] = idx;
        pe[ne[idx]] = idx++;
    }

    static void insert(int k, int x) {
        e[idx] = x;
        ne[idx] = ne[k];
        pe[idx] = k;
        pe[ne[k]] = idx;
        ne[k] = idx++;
    }

    static void IL(int k, int x) {
        e[idx] = x;
        ne[idx] = k;
        pe[idx] = pe[k];
        ne[pe[idx]] = idx;
        pe[ne[idx]] = idx++;
    }

    static void remove(int k) {
        ne[pe[k]] = ne[k];
        pe[ne[k]] = pe[k];
    }

    public static void main(String[] args) {
        init();
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        while (M-- > 0) {
            int k, x;
            String op;
            op = sc.next();
            if (op.equals("L")) {
                x = sc.nextInt();
//                L(x);
                insert(0, x);
            } else if (op.equals("R")) {
                x = sc.nextInt();
//                R(x);
                insert(pe[tail], x);
            } else if (op.equals("IL")) {
                k = sc.nextInt();
                x = sc.nextInt();
//                IL(k + 1, x);
                insert(pe[k + 1], x);
            } else if (op.equals("IR")) {
                k = sc.nextInt();
                x = sc.nextInt();
//                IR(k + 1, x);
                insert(k + 1, x);
            } else {
                k = sc.nextInt();
                remove(k + 1);
            }
        }
        for (int i = ne[head]; i != 1; i = ne[i]) {
            System.out.print(e[i] + " ");
        }
    }
}
