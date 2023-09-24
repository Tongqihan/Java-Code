package Stack;

import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        Integer a = stack.pop();
        System.out.println(a);  // 3
        Integer b = stack.peek();
        System.out.println(b);  // 2
        Integer c = stack.peek();
        System.out.println(c);  // 2
        System.out.println(stack.isEmpty());  // false
    }
}
