package Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// 统计 10 w 个数据当中，每个数据出现的次数?
// K-V 模型
// 遍历数组，x -> map 有 val + 1, 没有 val = 1
// 遍历 map 就可以了
public class Solution3 {
    public static void main(String[] args) {
//        统计有重复数字的 K-V
        int[] array = {1, 1, 2, 2, 2, 3, 3, 6, 6, 6, 7, 8, 9};
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : array) {
            if (map.get(x) == null) {
                map.put(x, 1);
            } else {
                int val = map.get(x);
                map.put(x, val + 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("key: " + entry.getKey() + " | val: " + entry.getValue());
            }
        }
    }
    public static void main1(String[] args) {
        int[] array = {1, 1, 2, 2, 2, 3, 3, 6, 6, 6, 7, 8, 9};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                map.put(array[i], map.get(array[i]) + 1);
            } else {
                map.put(array[i], 1);
            }
        }
        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : set) {
            System.out.println(entry.getKey() + " 出现了 " +  entry.getValue() + " 次 ");
        }
    }
}
