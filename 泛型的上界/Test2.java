// 泛型的上界
// 当继承一个类时，表示 E 必须是该类或者该类的子类
class A<E extends Number> {

}

public class Test2 {
    public static void main(String[] args) {
        A<Number> a1 = new A<>();
        A<Integer> a2 = new A<>();
        A<Double> a3 = new A<>();
    }
}
