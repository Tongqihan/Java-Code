package Map;

public class HashBucketPro<K, V> {
    static class Node<K, V> {
        public K key;
        public V value;
        public Node<K, V> next;
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    public Node<K, V>[] array = (Node<K, V>[]) new Node[10];
    public int usedSize;
    public static final double LOAD_FACTOR = 0.75;

    public void put(K key, V value) {
        int hash = key.hashCode();
        int index = hash % array.length;
        Node<K, V> cur = array[index];
        while (cur != null) {
            if (cur.key.equals(key)) {
                cur.value = value;
                return;
            }
            cur = cur.next;
        }
//        采用头插法插入
        Node<K, V> node = new Node<>(key, value);
        node.next = array[index];
        array[index] = node;
        usedSize++;
        if (calculateLoadFactor() >= LOAD_FACTOR) {
//            扩容
            resize();
        }
    }

    private void resize() {
        HashBucketPro.Node<K, V>[] newArray = new HashBucketPro.Node[2 * array.length];

        for (int i = 0; i < array.length; i++) {
            HashBucketPro.Node<K, V> cur = array[i];
            while (cur != null) {
                HashBucketPro.Node<K, V> curNext = cur.next;
                int hash = cur.key.hashCode();
                int index = hash % newArray.length;
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

    public V get(K key) {
        int hash = key.hashCode();
        int index = hash % array.length;
        HashBucketPro.Node<K, V> cur = array[index];
        while (cur != null) {
            if (cur.key.equals(key)) {
                return cur.value;
            }
            cur = cur.next;
        }
        return null;
    }

}
