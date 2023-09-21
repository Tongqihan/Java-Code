// 泛型方法
// 在方法的返回值前面指定参数类型
// 调用的时候，在方法名前面指定参数类型
class Alg2 {
    public <E extends Comparable<E>> E findMax(E[] array) {
        E max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (max.compareTo(array[i]) < 0) {
                max = array[i];
            }
        }
        return max;
    }
}

public class Test3 {
    public static void main(String[] args) {
        Alg2 alg2 = new Alg2();
        Integer[] array = {1, 9, 3, 5, 8, 6, 2};
//        Integer val = alg2.findMax(array);
//        也可以这么写，少一个 Integer
        Integer val = alg2.<Integer>findMax(array);
        System.out.println(val);
    }
}