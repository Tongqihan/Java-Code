package Heap;

import com.sun.xml.internal.ws.addressing.WsaActionUtil;

import java.util.*;

class Student implements Comparable<Student>{
    public int age;
    public String name;
    public Student(String name, int age) {
        this.age = age;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }

    @Override
    public int compareTo(Student o) {
        return this.age - o.age;
    }
}

class NameComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.name.compareTo(o2.name);
    }
}

class AgeComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
//        return o1.age - o2.age;
        return o2.age - o1.age;  // 此时就是大根堆了
    }
}

class Incmp implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
//        大根堆
        return o2.compareTo(o1);  // Integer 是引用类型，不要用 - 号
    }
}

public class Test {
    public static void main(String[] args) {
//        lambda 表达式
        Queue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> {return o2.compareTo(o1);});
        priorityQueue.offer(1);
        priorityQueue.offer(2);
        priorityQueue.offer(3);
    }
    public static void main7(String[] args) {
        Queue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        priorityQueue.offer(1);
        priorityQueue.offer(2);
        priorityQueue.offer(3);
    }
    public static void main6(String[] args) {
        Incmp incmp = new Incmp();
        Queue<Integer> priorityQueue = new PriorityQueue<>(incmp);  // 在这里传个比较器就可以实现大根堆了
        priorityQueue.offer(1);
        priorityQueue.offer(2);
        priorityQueue.offer(3);
        System.out.print(priorityQueue.poll() + " ");
        System.out.print(priorityQueue.poll() + " ");
        System.out.print(priorityQueue.poll() + " ");
    }
    public static void main5(String[] args) {
        Student student1 = new Student("张三", 20);
        Student student2 = new Student("张三", 10);
        System.out.println(student1.compareTo(student2));
        System.out.println("-------------------------------");
        NameComparator nameComparator = new NameComparator();
        int ret1 = nameComparator.compare(student1, student2);
        System.out.println("name :" + ret1);
        System.out.println("-------------------------------");
        AgeComparator ageComparator = new AgeComparator();
        int ret2 = ageComparator.compare(student1, student2);
        System.out.println("age :" + ret2);
    }
    public static void main4(String[] args) {
        Student student1 = new Student("张三", 10);
        Student student2 = new Student("张三", 10);
//        equals 只能比较两个对象是否相同，无法比较大小
        System.out.println(student1 == student2);  // false
        System.out.println(student1.equals(student2));  // true
    }
    public static void main3(String[] args) {
        TestHeap testHeap = new TestHeap();
        int[] arr = {9,8,7,6,5,4,3,2,1};
        int[] ret = testHeap.smallestK(arr, 3);
        for (int x : ret) {
            System.out.print(x + " ");
        }
    }
    public static void main2(String[] args) {
//        默认是小根堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        Queue<Integer> queue = new PriorityQueue<>();  // 采用接口的方式接收
        priorityQueue.offer(1);
        priorityQueue.offer(2);
        System.out.println(priorityQueue.poll());
        Queue<Student> priorityQueue2 = new PriorityQueue<>();
//        priorityQueue2.offer(new Student("张三", 13));
//        priorityQueue2.offer(new Student("李四", 23));
    }
    public static void main1(String[] args) {
        TestHeap testHeap = new TestHeap();
        int[] array = {27, 15, 19, 18, 28, 34, 65, 49, 25, 37};
        testHeap.initElem(array);
        testHeap.createHeap();
    }
}
