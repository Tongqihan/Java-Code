package Array;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4};
        func1(array1);
        func2(array1);
        System.out.println(Arrays.toString(array1));
        System.out.println(args[0]);
    }

    private static void func2(int[] array1) {
        array1[0] = 999;
//        改变了源数组
    }

    private static void func1(int[] array1) {
        array1 = new int[]{11, 22, 33};
//        只是改变了形参的指向，并没有改变实参的指向
    }
}
