package 数据结构.栈;

import java.util.Scanner;

public class Main_828 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int[] stl = new int[100010];
        int tt = 0;

        while (m-- > 0) {
            String s = scan.next();

            if (s.equals("push")) {
                int x = scan.nextInt();
                stl[++tt] = x;
            } else if (s.equals("pop")) {
                tt--;
            } else if (s.equals("empty")) {
                if (tt > 0) {
                    System.out.println("NO");
                } else System.out.println("YES");
            } else {
                System.out.println(stl[tt]);
            }

        }
    }
}
