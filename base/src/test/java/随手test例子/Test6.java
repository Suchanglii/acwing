package 随手test例子;

public class Test6 {
    public static void main(String[] args) {
        int a = 200;
        Integer b = 200;
        System.out.println(a == b);
        Integer c = 200;
        Integer d = 200;
        c = 100;
        d = 100;
        System.out.println(c == d);
    }
}
