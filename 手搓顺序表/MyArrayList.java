package List;

import java.util.Arrays;

// 缺点：插入元素的时候，如果插入 0 下标，O(N)，涉及到了移动元素，删除也是，也需要挪动元素，O(N)
// 顺序表不是很适合 频繁的对数据进行插入和删除的场景
// 适合给定一个下标，直接进行插入，O(1)
public class MyArrayList {
    public int[] elem;
    public int usedSize;  // 存储了多少个有效的数据
    public static final int DEFAULT_SIZE = 5;
    public MyArrayList() {
        this.elem = new int[DEFAULT_SIZE];
    }
//    打印顺序表，注意：该方法并不是顺序表中的方法，为了方便看测试结果给出的
    public void display() {
        System.out.print("[");
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i]);
            if (i < this.usedSize - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

//    获取顺序表的长度
    public int size() {
        return this.usedSize;
    }

//    判断是否包含某个元素
    public boolean contains(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
//            注意：如果是引用类型，要用 equals
            if (elem[i] == toFind) {
                return true;
            }
        }
        return false;
    }

//    查找某个元素对应的位置
    public int indexOf(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
//            注意：如果是引用类型，要用 equals
            if (elem[i] == toFind) {
                return i;
            }
        }
        return -1;
    }

//    判断数组是否为满
    public boolean isFull() {
//        if (this.usedSize == this.elem.length) {
//            return true;
//        }
//        return false;
        return this.usedSize == this.elem.length;
    }

//    新增元素，默认在数组最后新增
    public void add(int data) {
        if (this.isFull()) {
            this.elem = Arrays.copyOf(this.elem, 2 * this.elem.length);
        }
        this.elem[this.usedSize] = data;
        this.usedSize++;
    }

//    检查 add 数据的时候，pos 位置是否是合法的
    private void checkAddIndex(int pos) {
        if (pos < 0 || pos > usedSize) {
            throw new IndexOutOfException("add 元素的时候，位置不合法，请检查位置的合法性");
        }
    }

//    在 pos 位置新增元素 O(N)
    public void add(int pos, int data) {
//        源码中用的是 arraycopy 这个方法来完成向后移动一个位置的
//        咱们用的是 for 循环移动
        checkAddIndex(pos);

        if (this.isFull()) {
            this.elem = Arrays.copyOf(this.elem, 2 * this.elem.length);
        }
        for (int i = usedSize; i > pos; i--) {
            elem[i] = elem[i - 1];
        }
        elem[pos] = data;
        this.usedSize++;
    }

//    检查 get 数据的时候，pos 位置是否是合法的
    private void checkGetIndex(int pos) {
        if (pos < 0 || pos >= this.usedSize) {
            throw new IndexOutOfException("get 元素的时候，位置不合法，请检查位置的合法性");
        }
    }

//    获取 pos 位置的值
    public int get(int pos) {
        checkGetIndex(pos);
        return elem[pos];
    }

//    检查 set 数据的时候，pos 位置是否是合法的
    private void checkSetIndex(int pos) {
        if (pos < 0 || pos > usedSize) {
            throw new IndexOutOfException("set 元素的时候，位置不合法，请检查位置的合法性");
        }
    }

//    给 pos 位置的元素设为 value O(1)
    public void set(int pos, int value) {
        checkSetIndex(pos);
        elem[pos] = value;
    }

//    删除第一次出现的关键字 key O(N)
    public boolean remove(int toRemove) {
        int index = indexOf(toRemove);
        if (index == -1) {
            System.out.println("没有这个数据");
            return false;
        }

        for (int i = index; i < usedSize - 1; i++) {
//            i < userSize 当数组满的时候会越界
            elem[i] = elem[i + 1];
        }
        usedSize--;
        elem[usedSize] = 0;
        return true;
    }

//    清空顺序表
    public void clear() {
//        对于引用类型这样子操作
//        for (int i = 0; i < usedSize; i++) {
//            elem[i] = null;
//        }
//        usedSize = 0;

//        对于 int ，直接 usedSize = 0
        usedSize = 0;
    }
}