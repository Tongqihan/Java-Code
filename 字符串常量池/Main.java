package Test;

public class Main {
    public static void main(String[] args) {
        char[] ch = new char[]{'a', 'b', 'c'};
        String s1 = new String(ch);
        String s2 = "abc";
        System.out.println(s1 == s2);  // false
    }
    public static void main2(String[] args) {
        char[] ch = new char[]{'a', 'b', 'c'};
        String s1 = new String(ch);
        s1.intern();  // 手动把 String 对象放到字符串常量池中
        String s2 = "abc";
        System.out.println(s1 == s2);  // true
    }
}

//    public static void main1(String[] args) {
//        String s1 = "hello";
//        String s2 = "hello";
//        String s3 = new String("hello");
//        String s4 = new String("hello");
//        System.out.println(s1 == s2);  // true
//        System.out.println(s1 == s3);  // false
//        System.out.println(s3 == s4);  // false
//    }
