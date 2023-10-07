package 数据结构.队列;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_829 {
    static int N = 100010;
    static int[] queue = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int tt = 0,hh = 0;//y总这里是tt = -1的,添加的时候++tt
        while (M-- > 0) {
            String[] s = br.readLine().split(" ");
            String s1 = s[0];
            String s2;
            switch (s1) {
                case "push":
                    s2 = s[1];
                    queue[tt++] = Integer.parseInt(s2);
                    break;
                case "pop":
                    hh++;
                    break;
                case "empty"://tt == hh,队列就是空的
                    if (tt == hh) System.out.println("YES");
                    else System.out.println("NO");
                    break;
                default:
                    System.out.println(queue[hh]);
            }
        }
    }
}
