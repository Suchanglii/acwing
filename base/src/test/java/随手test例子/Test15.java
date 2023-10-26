package 随手test例子;

public class Test15 {
    public static void main(String[] args) {
        System.out.println(getI());
    }

    public static int getI() {
        int i = 0;
        try {
            i = 4;
        }catch (Exception e){

        }finally {
            i++;
            return i;
        }
    }
}
