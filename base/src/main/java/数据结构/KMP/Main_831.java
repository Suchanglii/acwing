package 数据结构.KMP;

import java.io.*;

public class Main_831 {
    static int n, m;
    static char P[] = new char[100010], S[] = new char[1000010];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        char p[] = br.readLine().toCharArray();
        for (int i = 1; i <= n; i++) {
            P[i] = p[i - 1];
        }
        m = Integer.parseInt(br.readLine());
        char s[] = br.readLine().toCharArray();
        for (int i = 1; i <= m; i++) {
            S[i] = s[i - 1];
        }

        //利用api,不算太暴力吧
//        int sub = 0;//上次已经丢掉的字符串长度
//        while (S.length() >= P.length()) {
//            if (S.contains(P)) {
//                int idx = S.indexOf(P);
//                System.out.print(idx + sub + " ");
//                sub += idx + 1;
//                S = S.substring(idx + 1);
//            }
//        }

        // 算法核心是求这个next数组哦!!
        //求next数组,等价来看,像是kmp算法
        int next[] = new int[n + 10];
        for (int i = 2, j = 0; i <= n; i++) {
            while (j != 0 && P[i] != P[j + 1]) j = next[j];
            if (P[i] == P[j + 1]) j++;
            next[i] = j;
        }

        //KMP算法
        for (int i = 1, j = 0; i <= m; i++) {
            //到i的时候不匹配了,回退
            while (j != 0 && S[i] != P[j + 1]) j = next[j];
            //匹配成功,则往后继续
            if (S[i] == P[j + 1]) j++;
            if (j == n) {
                bw.write(i - n + " ");
//                System.out.print(i - n + " ");
                //利用匹配失败之后的信息,往前回跳就行
                j = next[j];
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
