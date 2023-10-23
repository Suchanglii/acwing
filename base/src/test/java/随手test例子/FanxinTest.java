package 随手test例子;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class FanxinTest {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException,
            IllegalAccessException {
        List<Integer> list = new ArrayList<>();

        list.add(1);
        Method add = list.getClass().getDeclaredMethod("add", Object.class);

        list.getClass().getDeclaredMethod("add", Object.class).invoke(list, "suchangli");


        System.out.println(list);
    }
}
