package 数据结构.堆;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_839 {
    static int N = 100010;
    static int h[] = new int[N];
    static int size = 0;
    static int ph[] = new int[N];//两个数组映射堆,看readme
    static int hp[] = new int[N];
    static int m = 0;//记录是第m个插入的数

    //java不能通过传入下标的方式取改变数组中的值,切记,切记
    static void swap(int arr[],int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    /**
     * 堆交换函数
     *
     * @param a 表示交换下标为a
     * @param b 交换下标为b
     */
    static void heap_swap(int a, int b) {
//        swap(ph[hp[a]], ph[hp[b]]);
//        swap(hp[a], hp[b]);
//        swap(h[a], h[b]);
        swap(ph,hp[a],hp[b]);
        swap(hp, a, b);
        swap(h, a, b);
    }

    /**
     * 将下标为u的某个值按条件往下移动
     *
     * @param u
     */
    static void down(int u) {
        int t = u;
        if (u * 2 <= size && h[u * 2] < h[t]) t = u * 2;
        if (u * 2 + 1 <= size && h[u * 2 + 1] < h[t]) t = u * 2 + 1;
        if (t != u){
            heap_swap(t, u);
            down(t);
        }
    }

    /**
     * 将下标为u的某个值按条件往上移动
     * @param u
     */
    static void up(int u) {
        //这里值需要关心父节点与其的大小关系即可,如果该结点为右儿子,不需要考虑它的兄弟结点
        // y总这里写了一个while循环,作用是一样的
//        while (u / 2 > 0 && h[u / 2] > h[u]){
//            heap_swap(u, u / 2);
//            u >>= 1;
//        }
        if (u / 2 > 0 && h[u / 2] > h[u]) {
            heap_swap(u, u / 2);
            up(u / 2);
        }
    }

    public static void main(String[] args) throws IOException {
        String op;
        String s[];
        int k, x, n;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        while (n-- > 0) {
            s = bf.readLine().split(" ");
            op = s[0];
            switch (op) {
                case "I":
                    x = Integer.parseInt(s[1]);
                    size++;
                    m++;
                    ph[m] = size;
                    hp[size] = m;
                    h[size] = x;
                    up(size);
                    break;
                case "PM":
                    System.out.println(h[1]);
                    break;
                case "DM":
                    heap_swap(1, size);
                    size--;
                    down(1);
                    break;
                case "D":
                    k = Integer.parseInt(s[1]);
                    k = ph[k];
                    heap_swap(k, size);
                    size--;
                    up(k);
                    down(k);
                    break;
                default:
                    k = Integer.parseInt(s[1]);
                    x = Integer.parseInt(s[2]);
                    k = ph[k];
                    h[k] = x;
                    up(k);
                    down(k);
            }
        }
    }
}
