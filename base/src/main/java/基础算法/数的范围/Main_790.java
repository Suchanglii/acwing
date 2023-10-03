package 基础算法.数的范围;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_790 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double n = Double.parseDouble(br.readLine());
        double l = -10000, r = 10000;
        while (r - l > 1e-8) {
            double mid = (l + r) / 2;
            if (mid*mid*mid>=n) r=mid;
            else l = mid;
        }
        System.out.printf("%.6f", l);
    }
}
