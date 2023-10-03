package 基础算法.双指针算法;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_799 {
    static int n;
    static int N = 100010;
    static int q[];
    static int s[] = new int[N]; //这个数组用来存放该值出现的次数

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] sw = br.readLine().split(" ");
        q = new int[n];
        for (int i = 0; i < n; i++) {
            q[i] = Integer.parseInt(sw[i]);
        }
        int res = 0;
        for (int i = 0, j = 0; i < n; i++) {
            s[q[i]]++;//先把该值出现次数+1
            //如果s[q[i]]>1,说明i处的数已经出现过一次了,那我们就需要在j端找到这个数,把他剪掉
            while (j < i && s[q[i]]>1) s[q[j++]]--; //这里意味着找到j以及删除j之前,前面出现的数的次数作废,从新计算
            res = Math.max(res, i - j + 1);
        }
        System.out.println(res);
    }
}
