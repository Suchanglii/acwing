package 贪心.区间问题;

import java.util.Arrays;
import java.util.Scanner;

public class Main_905 {
    static int N = 100010;
    static Range range[] = new Range[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            range[i] = new Range(l, r);
        }
//        Arrays.sort(range, 0, n, (Range o1, Range o2) -> (o1.r - o2.r) < 0 ? -1 : (o1.r - o2.r) <= 0 ? 0 : 1);
        Arrays.sort(range, 0, n, (o1, o2) -> o1.r - o2.r);

        int res = 0;
        int ed = (int) (-1.0 / 0.0);
        for (int i = 0; i < n; i++) {
            if (range[i].l > ed) {
                res++;
                ed = range[i].r;
            }
        }
        System.out.println(res);
    }
}

class Range {
    public int l, r;

    Range(int l, int r) {
        this.l = l;
        this.r = r;
    }
}
