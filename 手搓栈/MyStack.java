package Stack;

import java.util.Arrays;

public class MyStack {
    public int[] elem;
    public int usedSize;
    public MyStack() {
        this.elem = new int[10];
    }

//    判断是否满了
    public boolean isFull() {
        return usedSize == elem.length;
    }
//    压栈
    public void push(int val) {
        if (isFull()) {
//            扩容
            elem = Arrays.copyOf(elem, 2 * elem.length);
        }
        elem[usedSize++] = val;
    }

//    判断是否为空
    public boolean isEmpty() {
        return usedSize == 0;
    }

//    出栈
    public int pop() {
        if (isEmpty()) {
            throw new EmptyException("栈是空的!");
        }
        return elem[--usedSize];
    }

//    获取栈顶的元素
    public int peek() {
        if (isEmpty()) {
            throw new EmptyException("栈是空的!");
        }
        return elem[usedSize - 1];
    }
}
