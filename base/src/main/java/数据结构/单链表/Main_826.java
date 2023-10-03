package 数据结构.单链表;

import java.util.Scanner;

/**
 * 使用数组模拟的单链表
 */
public class Main_826 {
    static int M;
    static int N = 100010;
    static int[] e = new int[N];
    static int[] ne = new int[N];
    static int head;//表示头节点指向的下标
    static int idx;//这个表示当前操作的结点的下标

    static void init() {
        head = -1;
        idx = 0;
    }

    /**
     * 在头节点后插入一个x
     *
     * @param x
     */
    static void add_to_head(int x) {
        e[idx] = x;
        ne[idx] = head;
        head = idx++;
    }

    /**
     * 在第k个插入的数后面插入x
     *
     * @param k
     * @param x
     */
    static void insert(int k, int x) {
        e[idx] = x;
        ne[idx] = ne[k];
        ne[k] = idx++;
    }

    /**
     * 删除第k个数
     *
     * @param k
     */
    static void remove(int k) {
        ne[k] = ne[ne[k]];
    }

    public static void main(String[] args) {
        init();
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        int k, x;
        char op;
        while (M-- > 0) {
            op = sc.next().charAt(0);
            if (op == 'H') {
                x = sc.nextInt();
                add_to_head(x);
            } else if (op == 'I') {
                k = sc.nextInt();
                x = sc.nextInt();
                insert(k - 1, x);
            } else {
                k = sc.nextInt();
                if (k == 0) head = ne[head];
                else remove(k - 1);
            }
        }
        for (int i = head; i != -1; i = ne[i]) {
            System.out.print(e[i] + " ");
        }
    }
}

