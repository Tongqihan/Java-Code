package sort;

import org.omg.CosNaming.IstringHelper;

public class Sort {
//    最坏情况下，时间复杂度 O(N^2)
//    最好情况下，时间复杂度 O(N) 数据有序的时候
//    当数据趋于有序的时候，排序速度非常快
//    一般的场景就是，当数据基本有序，建议使用直接插入排序
//    空间复杂度 O(1)
//    稳定性：稳定
//    如果一个排序是稳定的，那么可以实现为不稳定的
//    但是如果一个排序是不稳定的，没有办法实现为稳定
    public static void InsertSort(int[] array) {

        for (int i = 1; i < array.length; i++) {
            int j = i - 1;
            int tmp = array[i];
            for (; j >= 0; j--) {
                if (array[j] > tmp) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = tmp;
        }
    }

//    希尔排序
//    时间复杂度 O(N^1.3) - O(N^1.5)
//    空间复杂度 O(1)
//    稳定性：不稳定
    public static void ShellSort(int[] array) {
        int gap = array.length / 2;
        while (gap > 1) {
            shell(array, gap);
            gap /= 2;
        }
//        gap == 1 整体进行插入排序
        shell(array, 1);
    }

    public static void shell(int[] array, int gap) {
        for (int i = gap; i < array.length; i++) {
            int tmp = array[i];
            int j = i - gap;
            for (; j >= 0; j -= gap) {
                if (array[j] > tmp) {
                    array[j + gap] = array[j];
                } else {
                    break;
                }
            }
            array[j + gap] = tmp;
        }
    }

//    选择排序
//    时间复杂度 O(N^2)
//    空间复杂度 O(1)
//    稳定性：不稳定
    public static void SelectSort(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int minIndex = left;
            int maxIndex = left;
            for (int i = left + 1; i <= right; i++) {
                if (array[i] < array[minIndex]) {
                    minIndex = i;
                }
                if (array[i] > array[maxIndex]) {
                    maxIndex = i;
                }
            }
//            当最大值在 left 的时候需要判断一下，可能会调包
            swap(array, minIndex, left);  // 有可能把最大值换到了最小值的位置
            if (maxIndex == left) {
                maxIndex = minIndex;
            }
            swap(array, maxIndex, right);
            left++;
            right--;
        }
//        for (int i = 0; i < array.length; i++) {
//            int minIndex = i;
//            int j = i + 1;
//            for (; j < array.length; j++) {
//                if (array[j] < array[minIndex]) {
//                    minIndex = j;
//                }
//            }
//            swap(array, i, minIndex);
//        }
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

//    堆排序
//    时间复杂度 O(N * logN)
//    空间复杂度 O(1)
//    稳定性：不稳定
    public static void HeapSort(int[] array) {
        createBigHeap(array);
        int end = array.length-1;
        while (end > 0) {
            swap(array,0, end);
            shiftDown(array,0, end);
            end--;
        }
    }

    private static void createBigHeap(int[] array) {
        for (int parent = (array.length - 1 - 1) / 2; parent >= 0 ; parent--) {
            shiftDown(array, parent, array.length);
        }
    }

    private static void shiftDown(int[] array, int parent, int len) {
        int child = 2 * parent + 1;
        while (child < len) {
            if(child + 1 < len && array[child] < array[child + 1]) {
                child++;
            }
            if(array[child] > array[parent]) {
                swap(array, child, parent);
                parent = child;
                child = 2 * parent + 1;
            } else {
                break;
            }
        }
    }

//    冒泡排序
//    时间复杂度 O(N^2) (不考虑优化)
//    稳定性：稳定
    public static void BubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean flg = false;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if(array[j] > array[j + 1]) {
                    swap(array,j,j + 1);
                    flg = true;
                }
            }
            if (flg == false) {
                return;
            }
        }
    }

//    n-1 + n-1 + n-1 +....
    public static void BubbleSort2(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if(array[j] > array[j + 1]) {
                    swap(array, j,j + 1);
                }
            }
        }
    }

//    快速排序
//    时间复杂度 O(N * logN)
//    最好情况：O(N * logN)
//    最坏情况：O(N ^ 2) - 单分支的树 - 有序或者逆序
//
//    空间复杂度
//    最好情况：O(logN)
//    最坏情况：O(N)
//
//    稳定性：不稳定
//
//    如果数据量过大的时候，可能会跑不过，发生栈溢出异常
//    我们要进行优化

//    挖坑法
    public static void QuickSort(int[] array) {
        Quick(array, 0, array.length - 1);
    }

    private static void Quick(int[] array, int start, int end) {
        if (start >= end) return;

//        使用这个优化，主要解决减少递归次数
        if (end - start + 1 <= 14) {
//            直接插入排序
            InsertSort2(array, start, end);
            return;
        }
//        三数取中法
        int index = midThree(array, start, end);
        swap(array, start, index);
        int pivot = partition3(array, start, end);  // 划分
        Quick(array, start, pivot - 1);
        Quick(array, pivot + 1, end);
    }

    private static void InsertSort2(int[] array, int left, int right) {

        for (int i = left + 1; i <= right; i++) {
            int j = i - 1;
            int tmp = array[i];
            for (; j >= left; j--) {
                if (array[j] > tmp) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = tmp;
        }
    }

    private static int midThree(int[] array, int left, int right) {
        int mid = (left + right) / 2;
        if (array[left] < array[right]) {
            if (array[mid] < array[left]) {
                return left;
            } else if (array[mid] > array[right]) {
                return right;
            } else {
                return mid;
            }
        } else {
            if (array[mid] < array[right]) {
                return right;
            } else if (array[mid] > array[left]) {
                return left;
            } else {
                return mid;
            }
        }
    }

    private static int partition(int[] array, int left, int right) {
        int tmp = array[left];
        while (left < right) {
            while (left < right && array[right] >= tmp) {
                right--;
            }
            array[left] = array[right];
            while (left < right && array[left] <= tmp) {
                left++;
            }
            array[right] = array[left];
        }
        array[left] = tmp;
        return left;
    }

//    Hoare
//    right 找到比基准小的停下来
//    left 找到比基准大的停下来
//    交换
    private static int partition2(int[] array, int left, int right) {
        int tmp = array[left];
        int i = left;
        while (left < right) {
            while (left < right && array[right] >= tmp) {
                right--;
            }
            while (left < right && array[left] <= tmp) {
                left++;
            }
            swap(array, left, right);
        }
        swap(array, left, i);
        return left;
    }

//    前后指针法
    private static int partition3(int[] array, int left, int right) {
        int prev = left;
        int cur = left + 1;
        while (cur <= right) {
            if (array[cur] < array[left] && array[++prev] != array[cur]) {
                swap(array, cur, prev);
            }
            cur++;
        }
        swap(array, prev, left);
        return prev;
    }
}
