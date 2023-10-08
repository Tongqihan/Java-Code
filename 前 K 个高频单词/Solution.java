package Test;

import java.util.*;

// 前 k 个高频单词
// TOP-K 问题
public class Solution {
    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        // 1.遍历数组，统计每个单词出现的频率
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        // 2.建立小根堆
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(
                k, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue().compareTo(o2.getValue()) == 0) {
                    return o2.getKey().compareTo(o1.getKey());
                }
                return o1.getValue().compareTo(o2.getValue());
            }
        }
        );
        // 3.遍历 HashMap，把里面的数据放到小根堆
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(entry);
            } else {
                // 小根堆当满了 k 个，下一个 entry 和堆顶元素比较
                Map.Entry<String, Integer> top = minHeap.peek();
                // 堆顶的频率小于当前 entry 的频率，就出队，然后入队 entry
                if (top.getValue().compareTo(entry.getValue()) < 0) {
                    minHeap.poll();
                    minHeap.add(entry);
                } else {
                    // 频率相同的情况
                    if (top.getValue().compareTo(entry.getValue()) == 0) {
                        if (top.getKey().compareTo(entry.getKey()) > 0) {
                            minHeap.poll();
                            minHeap.add(entry);
                        }
                    }
                }
            }
        }
        // 4.此时小根堆当中，已经有了结果
        List<String> ret = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            String key = minHeap.poll().getKey();
            ret.add(key);
        }
        Collections.reverse(ret);
        return ret;
    }

    public static void main(String[] args) {
        String[] words = {"a", "b", "a", "c", "d", "a", "c", "e", "e", "a", "e"};
        List<String> ret = topKFrequent(words, 3);
        System.out.println(ret);
    }
}
