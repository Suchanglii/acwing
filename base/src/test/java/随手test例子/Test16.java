package 随手test例子;

public class Test16 {
    public static void main(String[] args) {
        try {
            test(new int[]{0, 1, 2, 3, 4, 5});
        } catch (Exception e) {

        }finally {
            System.out.println("E");
        }

    }

    public static void test(int a[]) {
        for (int n : a) {
            try {
                if (n % 2 == 0) {
                    throw new NullPointerException();
                } else {
                    System.out.println(n);
                }
            }finally {
                System.out.println("e");
            }
        }
    }
}
