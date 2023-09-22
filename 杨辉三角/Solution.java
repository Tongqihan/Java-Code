package ArrayList;

import java.util.ArrayList;
import java.util.List;

public class Solution {
//    杨辉三角
    public static List<List<Integer>> generate(int numsRows) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
//        先把第一行给添加进去
        row.add(1);
        ret.add(row);
        for (int i = 1; i < numsRows; i++) {
            List<Integer> prevRow = ret.get(i - 1);  // 前一行

            List<Integer> curRow = new ArrayList<>();
            curRow.add(1);  // 第一个1
//            中间 curRow 的赋值
            for (int j = 1; j < i; j++) {
                int x = prevRow.get(j) + prevRow.get(j - 1);
                curRow.add(x);
            }
            curRow.add(1);  // 最后一个1
            ret.add(curRow);
        }
        return ret;
    }

    public static void main(String[] args) {
        List<List<Integer>> ret = new ArrayList<>();
        ret = generate(8);
        System.out.println(ret);
    }
}
