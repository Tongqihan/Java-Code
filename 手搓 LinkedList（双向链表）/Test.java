package LinkedList;

import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addFirst(3);
        myLinkedList.addFirst(3);
        myLinkedList.addFirst(3);
        myLinkedList.addFirst(3);
        myLinkedList.addFirst(3);
        myLinkedList.display();

        LinkedList<Integer> list = new LinkedList<>();

        System.out.println("=================");

        myLinkedList.removeAllKey(3);
        myLinkedList.display();

    }
}
