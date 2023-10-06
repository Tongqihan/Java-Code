package Map;

import java.util.HashSet;
import java.util.Set;

// 有 10 w 个数据，并且数据有重复，怎么去重
public class Solution1 {
    public static void main(String[] args) {
        int[] array = {1, 1, 2, 2, 2, 3, 3, 6, 6, 6, 7, 8, 9};
        Set<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            hashSet.add(array[i]);
        }
        System.out.println(hashSet);
    }
}
