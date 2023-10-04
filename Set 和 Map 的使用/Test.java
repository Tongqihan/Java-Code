package Set;

import java.util.*;

class Student {

}

public class Test {
    public static void main(String[] args) {
        Set<String> set1 = new TreeSet<>();
        set1.add("hello");
        set1.add("abc");
        set1.add("CBD");
        System.out.println(set1);
    }
    public static void main2(String[] args) {
        Map<Student, Integer> treeMap = new TreeMap<>();
        treeMap.put(new Student(), 1);
        treeMap.put(new Student(), 2);
        System.out.println(treeMap);
    }
    public static void main1(String[] args) {
        Map<String, Integer> treeMap = new TreeMap<>();
//        底层是以红黑树的方式存储的
        treeMap.put("abc",1);
        treeMap.put("hello", 2);
        treeMap.put("world", 3);
        treeMap.put("and", 6);
        treeMap.put("student", 9);
        System.out.println(treeMap);
        System.out.println("--------------------");
        Integer val = treeMap.getOrDefault("hello2", 100);
        System.out.println(val);
        System.out.println("--------------------");
        Set<String> keySet = treeMap.keySet();
        System.out.println(keySet);
//        这里的顺序不用管,没有规律而言;仅仅只是把它们一股脑装进麻袋里面
        System.out.println("--------------------");
        Collection<Integer> values = treeMap.values();
        System.out.println(values);
        System.out.println("--------------------");
        Set<Map.Entry<String, Integer>> set = treeMap.entrySet();
        System.out.println(set);
        System.out.println("--------------------");
        for (Map.Entry<String, Integer> entry:set) {
            System.out.println("key: " + entry.getKey() + " | value: " + entry.getValue());
        }
        System.out.println("--------------------");
    }
}
