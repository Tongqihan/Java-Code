package Map;

public class HashBucket {
    static class Node {
        public int key;
        public int val;
        public Node next;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public Node[] array;
    public int usedSize;
    public static final double LOAD_FACTOR = 0.75;
    public HashBucket() {
        array = new Node[10];
    }

    public void put(int key, int val) {
        int index = key % array.length;
        Node cur = array[index];
        while (cur != null) {
            if (cur.key == key) {
                cur.val = val;
                return;
            }
            cur = cur.next;
        }
//        采用头插法进行插入
        Node node = new Node(key, val);
        node.next = array[index];
        array[index] = node;
        usedSize++;
        if (calculateLoadFactor() >= LOAD_FACTOR) {
//            扩容
            resize();
        }
    }

//    扩容
//    每个元素都要进行重新的哈希计算
    private void resize() {
        Node[] newArray = new Node[2 * array.length];

        for (int i = 0; i < array.length; i++) {
            Node cur = array[i];
            while (cur != null) {
                Node curNext = cur.next;
                int index = cur.key % newArray.length;
                cur.next = newArray[index];
                newArray[index] = cur;
                cur = curNext;
            }
        }
        array = newArray;
    }

    //    计算负载因子
    private double calculateLoadFactor() {
        return usedSize * 1.0 / array.length;
    }

    public int get(int key) {
        int index = key % array.length;
        Node cur = array[index];
        while (cur != null) {
            if (cur.key == key) {
                return cur.val;
            }
            cur = cur.next;
        }
        return -1;
    }
}
