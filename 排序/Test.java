package sort;

import java.util.Arrays;
import java.util.Random;

public class Test {
    public static void initArrayOrder(int[] array) {
        for (int i = 0; i < array.length; i++) {
//            顺序
//            array[i] = i;
//            逆序的最慢
            array[i] = array.length - i;
        }

    }
    public static void initArrayNotOrder(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1_0000_0000);
        }
    }
    public static void testInsertSort(int[] array) {
        array = Arrays.copyOf(array, array.length);
        long startTime = System.currentTimeMillis();
        Sort.InsertSort(array);
        long endTime = System.currentTimeMillis();
        System.out.println("直接插入排序耗时：" + (endTime - startTime));
    }

    public static void testShellSort(int[] array) {
        array = Arrays.copyOf(array, array.length);
        long startTime = System.currentTimeMillis();
        Sort.ShellSort(array);
        long endTime = System.currentTimeMillis();
        System.out.println("希尔排序耗时：" + (endTime - startTime));
    }

    public static void testSelectSort(int[] array) {
        array = Arrays.copyOf(array, array.length);
        long startTime = System.currentTimeMillis();
        Sort.SelectSort(array);
        long endTime = System.currentTimeMillis();
        System.out.println("选择排序耗时：" + (endTime - startTime));
    }


    public static void testHeapSort(int[] array) {
        array = Arrays.copyOf(array, array.length);
        long startTime = System.currentTimeMillis();
        Sort.HeapSort(array);
        long endTime = System.currentTimeMillis();
        System.out.println("堆排序耗时：" + (endTime - startTime));
    }

    public static void testBubbleSort(int[] array) {
        array = Arrays.copyOf(array, array.length);
        long startTime = System.currentTimeMillis();
        Sort.BubbleSort(array);
        long endTime = System.currentTimeMillis();
        System.out.println("冒泡排序耗时：" + (endTime - startTime));
    }

    public static void testQuickSort(int[] array) {
        array = Arrays.copyOf(array, array.length);
        long startTime = System.currentTimeMillis();
        Sort.QuickSort(array);
        long endTime = System.currentTimeMillis();
//        System.out.println(Arrays.toString(array));
        System.out.println("快速排序耗时：" + (endTime - startTime));
    }

    public static void main(String[] args) {
//        int[] array = {12, 45, 36, 9, 7, 6, 98, 21};

//        我掏出一个亿的数据，请问阁下该如何应对呢
//        证实，随机数，快排碾压希尔和堆排
        int[] array = new int[1_0000_0000];
//        initArrayOrder(array);
        initArrayNotOrder(array);
//        testInsertSort(array);
//        testSelectSort(array);
//        testBubbleSort(array);
        testShellSort(array);
        testHeapSort(array);
        testQuickSort(array);
    }
}
