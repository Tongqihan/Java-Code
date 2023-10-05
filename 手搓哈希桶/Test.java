package Map;

public class Test {
    public static void main(String[] args) {
        HashBucket hashBucket = new HashBucket();
        hashBucket.put(1, 11);
        hashBucket.put(2, 22);
        hashBucket.put(3, 33);
        hashBucket.put(6, 66);
        hashBucket.put(7, 77);
        hashBucket.put(9, 99);
        System.out.println(hashBucket.get(1));
        System.out.println(hashBucket.get(2));
        System.out.println(hashBucket.get(3));
        System.out.println(hashBucket.get(6));
        System.out.println(hashBucket.get(7));
        System.out.println(hashBucket.get(9));
        System.out.println(hashBucket.get(10));
    }
}
