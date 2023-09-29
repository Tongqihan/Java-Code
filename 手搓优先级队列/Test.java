package Heap;

import com.sun.xml.internal.ws.addressing.WsaActionUtil;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Student {
    public int age;
    public String name;
    public Student(String name, int age) {
        this.age = age;
        this.name = name;
    }
}

public class Test {
    public static void main(String[] args) {
//        默认是小根堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        Queue<Integer> queue = new PriorityQueue<>();  // 采用接口的方式接收
        priorityQueue.offer(1);
        priorityQueue.offer(2);
        System.out.println(priorityQueue.poll());
        Queue<Student> priorityQueue2 = new PriorityQueue<>();
//        priorityQueue2.offer(new Student("张三", 13));
//        priorityQueue2.offer(new Student("李四", 23));
    }
    public static void main1(String[] args) {
        TestHeap testHeap = new TestHeap();
        int[] array = {27, 15, 19, 18, 28, 34, 65, 49, 25, 37};
        testHeap.initElem(array);
        testHeap.createHeap();
    }
}
