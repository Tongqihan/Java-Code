package Heap;

import java.util.Arrays;

public class TestHeap {
    public int[] elem;
    public int usedSize;
    public TestHeap() {
        this.elem = new int[10];
    }

    public void initElem(int[] array) {
        for (int i = 0; i < array.length; i++) {
            elem[i] = array[i];
            usedSize++;
        }
    }

//    时间复杂度 O(N)
    public void createHeap() {
        for (int parent = (usedSize - 1 - 1) / 2; parent >= 0; parent--) {
            shiftDown(parent, usedSize);
        }
    }

//    时间复杂度 O(logN)
    private void shiftDown(int parent, int len) {
        int child = 2 * parent + 1;
//        最起码要有左孩子
        while (child < len) {
//            一定是有右孩子的情况下
            if (child + 1 < len && elem[child] < elem[child + 1]) {
                child++;
            }
//            child 下标，一定是左右孩子 最大值的下标
            if (elem[child] > elem[parent]) {
                int tmp = elem[child];
                elem[child] = elem[parent];
                elem[parent] = tmp;
                parent = child;
                child = 2 * parent + 1;
            } else {
                break;
            }
        }
    }

//    向下调整
//    时间复杂度 logN
    private void shiftUp(int child) {
        int parent = (child - 1) / 2;
        while (child > 0) {
            if (elem[child] > elem[parent]) {
                int tmp = elem[child];
                elem[child] = elem[parent];
                elem[parent] = tmp;
                child = parent;
                parent = (child - 1) / 2;
            } else {
                break;
            }
        }
    }
    private boolean isFull() {
        return usedSize == elem.length;
    }
    public void offer(int val) {
        if (isFull()) {
//            扩容
            elem = Arrays.copyOf(elem, 2 * elem.length);
        }
        elem[usedSize++] = val;
//        向上调整
        shiftUp(usedSize - 1);
    }

    private boolean isEmpty() {
        return usedSize == 0;
    }
    public void pop() {
        if (isEmpty()) return;
//        1.先交换元素
        int tmp = elem[0];
        elem[0] = elem[usedSize - 1];
        elem[usedSize - 1] = tmp;
//        向下调整
        usedSize--;
        shiftDown(0, usedSize);
    }

    public int peek() {
        if (isEmpty()) return -1;
        return elem[0];
    }
}
