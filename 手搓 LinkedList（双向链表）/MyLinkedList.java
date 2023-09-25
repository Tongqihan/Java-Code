package LinkedList;

public class MyLinkedList {
    static class ListNode {
        public int val;
        public ListNode prev;//前驱
        public ListNode next;//后继

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode head;
    public ListNode last;

//    头插法 O(1)
    public void addFirst(int data){
        ListNode node = new ListNode(data);
        if(head == null) {
            head = node;
            last = node;
        }else {
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

//    尾插法 O(1)
    public void addLast(int data){
        ListNode node = new ListNode(data);
        if(head == null) {
            head = node;
            last = node;
        }else {
            last.next = node;
            node.prev = last;
            last = node;
        }
    }

//    任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data){
        if(index < 0 || index > size()) {
            throw new ListIndexOutOfException("下标异常");
        }
        if(index == 0) {
            addFirst(data);
            return;
        }
        if(index == size()) {
            addLast(data);
            return;
        }

        ListNode cur = findIndex(index);
        //
        ListNode node = new ListNode(data);
        node.next = cur;
        cur.prev.next = node;
        node.prev = cur.prev;
        cur.prev = node;

    }
    private ListNode findIndex(int index) {
        ListNode cur = head;
        while (index != 0) {
            cur = cur.next;
            index--;
        }
        return cur;
    }

//    查找是否包含关键字 key 是否在单链表当中
    public boolean contains(int key){
        ListNode cur = head;
        while (cur != null) {
            if(cur.val == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    //删除第一次出现关键字为key的节点
    public void remove(int key) {
        ListNode cur = head;
        while (cur != null) {
            //开始删除了
            if (cur.val == key) {
                //1. 删除的是头节点
                if (cur == head) {
                    head = head.next;
                    //只有一个节点
                    if (head != null) {
                        head.prev = null;
                    }
                } else {
                    //中间  尾巴
                    cur.prev.next = cur.next;
                    //不是尾巴节点
                    if (cur.next != null) {
                        cur.next.prev = cur.prev;
                    } else {
                        //是尾巴节点
                        last = last.prev;
                    }
                }
                return;
            }
            cur = cur.next;
        }
    }

//    删除所有值为key的节点
    public void removeAllKey(int key){
        ListNode cur = head;
        while (cur != null) {
            //开始删除了
            if(cur.val == key) {
                //1. 删除的是头节点
                if(cur == head) {
                    head = head.next;
                    //只有一个节点
                    if(head != null) {
                        head.prev = null;
                    }
                }else {
                    //中间  尾巴
                    cur.prev.next = cur.next;
                    //不是尾巴节点
                    if(cur.next != null) {
                        cur.next.prev = cur.prev;
                    }else {
                        //是尾巴节点
                        last = last.prev;
                    }
                }
            }
            cur = cur.next;
        }
    }

    public int size(){
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        return len;
    }

    public void display(){
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    public void clear(){
        /*ListNode cur = head;
        while (cur != null) {
            ListNode curNext = cur.next;
            cur.prev = null;
            cur.next = null;
            cur = curNext;
        }*/

//        直接这种暴力的也是可以的
        head = null;
        last = null;
    }
}
