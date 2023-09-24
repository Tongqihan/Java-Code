package Queue;

import Stack.EmptyException;

/**
 * 利用单链表实现队列
 */
public class MyQueue {
    static class Node {
        public int val;
        public Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public Node head;
    public Node last;
    public int usedSize;

    //    入队
    public void offer(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
            last = node;
        } else {
            last.next = node;
            last = node;
        }
        usedSize++;
    }

    //    判断是否为空
    public boolean empty() {
        return usedSize == 0;
    }

    //    出队
    public int poll() {
        if (empty()) {
            throw new EmptyException("队列为空");
        }
        int ret = head.val;
        head = head.next;
        if (head == null) {
            last = null;  // 把最后一个节点删了，last 也要置空
        }
        usedSize--;
        return ret;
    }

    //    得到队头元素
    public int peek() {
        if (empty()) {
            throw new EmptyException("队列为空");
        }
        return head.val;
    }

    public int size() {
        return usedSize;
    }
}