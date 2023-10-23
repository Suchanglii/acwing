package 算法;

//求最小的大于i的质数

public class Solution4 {
    public static void main(String[] args) {
        for (int i = 100000; ; i++) {
            boolean flag = true;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println(i);
                break;
            }
        }

    }
}
