package LinkedList;

public class MySingleList {
    static class Node {
        public int val;  // 存储的数据
        public Node next;  // 存储下一个节点的地址
        public Node(int val) {
            this.val = val;
        }
    }
    public Node head;  // 代表当前链表的头节点的引用
    public void createLink() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;
        head = node1;
    }

//    遍历链表
    public void display() {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

//    从指定位置开始遍历链表
    public void display(Node newHead) {
        Node cur = newHead;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

//    查找关键字 key 是否在单链表中
    public boolean contains(int key) {
        Node cur = head;
        while (cur != null) {
//            如果是自定义类型，要用 equals
            if (cur.val == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

//    得到单链表的长度
    public int size() {
        int count = 0;
        Node cur = head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

//    头插 O(1)
    public void addFirst(int data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
    }

//    尾插 O(N) -> 有找尾巴的过程
    public void addLast(int data) {
        Node node = new Node(data);
        Node cur = head;
//        第一次插入节点
        if (head == null) {
            head = node;
            return;  // 一定要写 return 不写的话又往后走了
        }
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
    }

//    判断位置的合法性
    private void checkIndex(int index) throws ListIndexOutOfException{
        if (index < 0 || index > size()) {
            throw new ListIndexOutOfException("index 位置不合法");
        }
    }

//    找到 index - 1 位置的节点的地址
    private Node findIndexSubOne(int index) {
        Node cur = head;
        int count = 0;
        while (count != index - 1) {
            cur = cur.next;
            count++;
        }
        return cur;
    }

//    在任意位置前面插入
    public void addIndex(int index, int data) throws ListIndexOutOfException{
        checkIndex(index);

        if (index == 0) {
            addFirst(data);
            return;
        }

        if (index == size()) {
            addLast(data);
            return;
        }
        Node cur = findIndexSubOne(index);
        Node node = new Node(data);
        node.next = cur.next;
        cur.next = node;
    }

//    找到关键字 key 的前一个节点
    private Node searchPrev(int key) {
        if (head == null) {
            return null;  // 一个节点也没有
        }
        Node cur = head;
        while (cur.next != null) {
            if (cur.next.val == key) {
                return cur;
            }
            cur = cur.next;
        }
        return null;  // 没有要删除的节点
    }

//    删除第一次出现关键字 key 的节点 O(N)
    public void remove(int key) {
        if (head == null) {
            return;  // 一个节点也没有
        }
        if (head.val == key) {
            head = head.next;
            return;
        }
        Node prev = searchPrev(key);
        if (prev == null) {
            return;
        }
        Node del = prev.next;  // 要删除的节点
        prev.next = del.next;
    }

//    删除所有值为 key 的节点
    public void removeAllKey(int key) {
        if (head == null) {
            return;
        }
        Node prev = head;
        Node cur = prev.next;
        while (cur != null) {
            if (cur.val == key) {
                prev.next = cur.next;
                cur = cur.next;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
        if (head.val == key) {
            head = head.next;
        }
    }

//    清空链表
    public void clear() {
//        要保证链表当中的所有节点都被回收
        head = null;
    }

//    反转链表
    public Node reverseList() {
        if (head == null) return null;
        // 只有一个节点
        if (head.next == null) return head;
        Node cur = head.next;
        head.next = null;
        while (cur != null) {
            Node curNext = cur.next;
            cur.next = head;
            head = cur;
            cur = curNext;
        }
        return head;
    }
}
