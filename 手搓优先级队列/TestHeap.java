package Heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

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

//    TOP-K
    public int[] smallestK(int[] arr, int k) {

        int[] ret = new int[k];
        if (arr == null || k == 0) return ret;  // 必须返回一个空的数组

        Queue<Integer> maxHeap = new PriorityQueue<>(k, (a, b) -> b - a);
        // 1.遍历数组的前 K 个，放到堆当中
        for (int i = 0; i < k; i++) {
            maxHeap.offer(arr[i]);
        }

        // 2.遍历剩下的 K - 1 个，每次和堆顶元素进行比较
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.offer(arr[i]);
            }
        }

        for (int i = 0; i < k; i++) {
            ret[i] = maxHeap.poll();
        }
        return ret;
    }

//    交换
    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

//    堆排序
//    空间复杂度 O(1)
//    时间复杂度 O(N × logN)
    public void heapSort() {
        int end = usedSize - 1;
        while (end > 0) {
            swap(elem, 0, end);
            shiftDown(0, end);
            end--;
        }
    }
}
