package ArrayList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Test {
    public static void main(String[] args) {
//        ArrayList 的三种遍历方式
        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(12);
        list.add(13);
        list.add(14);
        list.add(15);
        list.add(16);
        System.out.println("-----------------------------");
//        1.for 循环
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        System.out.println("-----------------------------");
//        2.foreach
        for (int val : list) {
            System.out.print(val + " ");
        }
        System.out.println();

        System.out.println("-----------------------------");
//        3.迭代器
        ListIterator<Integer> iterator = list.listIterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        System.out.println("-----------------------------");

    }
    public static void main3(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(11);
        arrayList.add(12);
        arrayList.add(13);
        arrayList.add(14);
        arrayList.add(15);
        arrayList.add(16);

//        subList 区间范围是左闭右开的
        List<Integer> sub = arrayList.subList(1, 3);  // [1, 3)
        System.out.println(sub);
        System.out.println("-----------------------------");
        sub.set(0, 999);
        System.out.println("sub :" + sub);
        System.out.println("arrayList :" + arrayList);
    }
    public static void main2(String[] args) {
//        ArrayList 复杂参数的构造方法
        LinkedList<Integer> list = new LinkedList<>();
        list.add(11);
        list.add(12);
        list.add(13);

        ArrayList<Number> arrayList1 = new ArrayList<>(list);
        arrayList1.add(1);
        System.out.println(arrayList1);
    }
    public static void main1(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(6);
        System.out.println(arrayList);
    }
}
