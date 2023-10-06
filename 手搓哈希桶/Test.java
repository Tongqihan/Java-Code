package Map;

import java.util.Objects;

class Student {
    private String id;
    public Student(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

public class Test {
    public static void main(String[] args) {
        Student student1 = new Student("123");
        System.out.println(student1.hashCode());
        System.out.println("---------------");
        Student student2 = new Student("123456");
        System.out.println(student2.hashCode());
        System.out.println("---------------");
        HashBucketPro<Student, String> hashBucketPro = new HashBucketPro<>();
        hashBucketPro.put(student1, "张三");
        hashBucketPro.put(student2, "李四");
        System.out.println(hashBucketPro.get(student1));
        System.out.println(hashBucketPro.get(student2));
    }
    public static void main2(String[] args) {
        Student student1 = new Student("123");
        System.out.println(student1.hashCode());
        System.out.println("---------------");
        Student student2 = new Student("123");
        System.out.println(student2.hashCode());
    }
    public static void main1(String[] args) {
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
