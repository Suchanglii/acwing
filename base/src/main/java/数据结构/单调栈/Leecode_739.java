package 数据结构.单调栈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Leecode_739 {
    static int N = 100010;
    static int temperature[] = new int[N];
    static int stk[] = new int[N];
    static int tt = 0;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(",");
        n = s.length;
        for (int i = 0; i < s.length; i++) {
            temperature[i] = Integer.parseInt(s[i]);
        }
        System.out.println(Arrays.toString(new Leecode_739().dailyTemperatures_1(temperature)));
    }

    //从后往前思考
    public int[] dailyTemperatures(int[] temperatures) {
        int res[] = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int x = temperatures[i];
            while (tt != 0 && x >= temperatures[stk[tt]]) tt--;
            if (tt != 0) res[i] = stk[tt] - i;
            else res[i] = 0;
            stk[++tt] = i;
        }
        return res;
    }
    //从前往后思考
    public int[] dailyTemperatures_1(int[] temperature) {
        int res[] = new int[n];
        for (int i =0; i < n; i++) {
            int x = temperature[i];
            //说明栈顶元素的答案找到了,就是x的下标
            while (tt != 0 && x > temperature[stk[tt]]) {
                res[stk[tt]] = i - stk[tt--];
            }
            stk[++tt] = i;
        }
        //循环执行完成后,如果栈内还有元素,说明这些元素已经是他以及他之后元素的最大元素
        //这里赋值与否都行,因为初始化的时候初始化成0了
        if (tt != 0) res[stk[tt--]] = 0;
        return res;
    }
}
