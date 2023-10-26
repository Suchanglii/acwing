package 随手test例子;

import java.util.Date;

public class Test11 extends Date {
    public static void main(String[] args) {
//        new 随手test例子.Test11().test();
//        String s = "Hello";
//        System.out.println(s.hashCode());
//        s = s + "world";
//        创建了一个StringBuilder对象,一次调用append(),这里还执行了StringBuilder的toString()方法,不然变不成String对象
//        System.out.println(s.hashCode());
//        System.out.println(s.getClass().getName());
// ---------------------------------------------------------
//        String str = new String();
//        for(int i=0;i<100;i++)
//        {
//            str = str + i;
//            //总共会创建100个对象....
//        }
//----------------------

        Test11 test11 = new Test11();
        
    }
    public void test() {
        System.out.println(this.getClass().hashCode());
        System.out.println(super.getClass().hashCode());
        System.out.println(this.getClass());
        System.out.println(super.getClass());

        System.out.println(super.getClass().getName());
    }

}
