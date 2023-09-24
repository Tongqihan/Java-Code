package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class Test {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        queue.offer(6);
        System.out.println(queue.peek());  // 1
        System.out.println(queue.poll());  // 1
        System.out.println(queue.poll());  // 2
        System.out.println(queue.poll());  // 3
        System.out.println(queue.poll());  // 4
        System.out.println(queue.poll());  // 5
        System.out.println(queue.poll());  // 6
    }

    public static void main1(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.offer(1);
        myQueue.offer(2);
        myQueue.offer(3);
        System.out.println(myQueue.peek());  // 1
        System.out.println(myQueue.poll());  // 1
        System.out.println(myQueue.poll());  // 2
        System.out.println(myQueue.poll());  // 3

    }
}
