package 算法;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution2 {
    public static void main(String[] args) throws IOException {
//        int q[] = {1, 2, 3, 0, 0, 0};
//        int p[] = {2, 5, 6};
//        //test(q, 3, p, 3);
//        test(new int[]{1}, 1, new int[]{}, 0);
//        test(new int[]{0}, 0, new int[]{1}, 1);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(",");
        int m, n;
        int nums1[] = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            nums1[i] = Integer.parseInt(s[i]);
        }
        m = Integer.parseInt(br.readLine());
        s = br.readLine().split(",");
        int nums2[] = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            nums2[i] = Integer.parseInt(s[i]);
        }
        n = Integer.parseInt(br.readLine());
        test(nums1, m, nums2, n);
    }

    public static void test(int nums1[], int m, int nums2[], int n) {
        int res[] = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) res[k++] = nums1[i++];
            else res[k++] = nums2[j++];
        }
        while (i < m) res[k++] = nums1[i++];
        while (j < n) res[k++] = nums2[j++];
        System.out.println(Arrays.toString(res));
    }
}
