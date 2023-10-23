package 贪心.区间问题;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main_908 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            p[i][0] = sc.nextInt();
            p[i][1] = sc.nextInt();
        }

        Arrays.sort(p, Comparator.comparingInt(o -> o[1]));

        int res = 0;
        int ed = (int) (-1.0/0.0);
        for (int i = 0; i < n; i++) {
            if (ed < p[i][0]) {
                res++;
                ed = p[i][1];
            }
        }
        System.out.println(res);

    }
}
