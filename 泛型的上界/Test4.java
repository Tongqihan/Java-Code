// 泛型方法
// 把它改为 static 静态的，可以不依赖于对象，直接通过类名 + <类型> 调用
class Alg3 {
    public static <E extends Comparable<E>> E findMax(E[] array) {
        E max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max.compareTo(array[i]) < 0) {
                max = array[i];
            }
        }
        return max;
    }
}

public class Test4 {
    public static void main(String[] args) {
        Integer[] array = {1, 9, 3, 5, 8, 6, 2};
        Integer val = Alg3.<Integer>findMax(array);
        System.out.println(val);
    }
}
