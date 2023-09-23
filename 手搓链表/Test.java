package LinkedList;

public class Test {
    public static void main(String[] args) {
        MySingleList mySingleList = new MySingleList();
        mySingleList.createLink();
        mySingleList.display();
        System.out.println("---------------------------");
        System.out.println(mySingleList.contains(1));
        System.out.println(mySingleList.contains(2));
        System.out.println(mySingleList.contains(3));
        System.out.println(mySingleList.contains(4));
        System.out.println(mySingleList.contains(5));
        System.out.println("---------------------------");
        System.out.println("当前链表长度为: " + mySingleList.size());
        System.out.println("---------------------------");
        mySingleList.addFirst(11);
        mySingleList.addFirst(12);
        System.out.println("头插了两个节点，结果为: ");
        mySingleList.display();
        System.out.println("---------------------------");
        mySingleList.addLast(21);
        mySingleList.addLast(22);
        System.out.println("尾插了两个节点，结果为: ");
        mySingleList.display();
        System.out.println("---------------------------");
        try {
            mySingleList.addIndex(6, 5);
            mySingleList.addIndex(7, 6);
        } catch (ListIndexOutOfException e) {
            e.printStackTrace();
        }
        System.out.println("任意位置插入两个节点，结果为: ");
        mySingleList.display();
        System.out.println("---------------------------");
        mySingleList.remove(4);
        System.out.println("删除值为4的节点，结果为: ");
        mySingleList.display();
        System.out.println("---------------------------");
        mySingleList.addFirst(15);
        mySingleList.addFirst(15);
        mySingleList.addIndex(6, 15);
        mySingleList.addIndex(7, 15);
        mySingleList.addLast(15);
        mySingleList.addLast(15);
        mySingleList.addLast(15);
        System.out.println("现在的链表为: ");
        mySingleList.display();
        System.out.println("删除所有值为15的节点的结果为: ");
        mySingleList.removeAllKey(15);
        mySingleList.display();
        System.out.println("---------------------------");
        System.out.println("清空前: ");
        mySingleList.display();
        System.out.println("清空后: ");
//        mySingleList.clear();
        mySingleList.display();
        System.out.println("---------------------------");
        System.out.println("反转链表: ");
        MySingleList.Node ret = mySingleList.reverseList();
        mySingleList.display(ret);
        System.out.println("---------------------------");
    }
}
