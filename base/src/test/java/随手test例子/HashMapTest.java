package 随手test例子;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapTest {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        // map.put(1, "suchangli");
//        map.put(null,"add null");
//        map.put(0, "be replaced");
//        map.put(1, "000");
//        map.put(1, "222");
        String s1 = "key s";
        String s2 = "key s";
        System.out.println(s1.hashCode() == s2.hashCode());
        map.put(s1, "s1");
        map.put(s2, "s2");

        Set<Map.Entry<String, String>> entries = map.entrySet();
        Iterator<Map.Entry<String, String>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> next = iterator.next();
            System.out.print(next.getKey() + " ");
            System.out.println(next.getValue());
        }
    }
}
