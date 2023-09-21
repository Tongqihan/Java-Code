// 泛型的上界
// 利用泛型实现一个类，能够求出数组中的最大值
// 当继承一个接口时，表示将来的参数类型必须要实现该接口
class Alg<E extends Comparable<E>> {
    public E findMax(E[] array) {
        E max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max.compareTo(array[i]) < 0) {
                max = array[i];
            }
        }
        return max;
    }
}

public class Test {
    public static void main(String[] args) {
        Alg<Integer> alg = new Alg<>();
        Integer[] array = {1, 9, 3, 5, 8, 6, 2};
        Integer val = alg.findMax(array);
        System.out.println(val);
    }
}