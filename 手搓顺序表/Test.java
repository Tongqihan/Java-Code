package List;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(4);
        myArrayList.add(5);
        myArrayList.add(6);
        myArrayList.display();
        System.out.println("-----------------------------");
        myArrayList.remove(1);
        myArrayList.display();
        System.out.println("-----------------------------");
        myArrayList.remove(2);
        myArrayList.display();
        System.out.println("-----------------------------");
        myArrayList.remove(3);
        myArrayList.display();
        System.out.println("-----------------------------");
        myArrayList.remove(4);
        myArrayList.display();
        System.out.println("-----------------------------");
        myArrayList.remove(5);
        myArrayList.display();
        System.out.println("-----------------------------");
        myArrayList.remove(6);
        myArrayList.display();
        System.out.println("-----------------------------");
        myArrayList.clear();
    }
    public static void main2(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(4);
        myArrayList.add(5);
        myArrayList.add(6);
        myArrayList.display();

        System.out.println("-----------------------------");

        try {
            myArrayList.add(1, 66);
        } catch (IndexOutOfException e) {
            e.printStackTrace();
        }

        myArrayList.display();

        System.out.println("-----------------------------");

        try {
            System.out.println(myArrayList.get(1));
        } catch (IndexOutOfException e) {
            e.printStackTrace();
        }
        System.out.println("-----------------------------");

        try {
            myArrayList.set(1, 88);
        } catch (IndexOutOfException e) {
            e.printStackTrace();
        }
        myArrayList.display();
    }
    public static void main1(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);
    }
}
