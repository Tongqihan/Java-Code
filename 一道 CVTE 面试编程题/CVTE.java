package ArrayList;

import java.util.ArrayList;

public class CVTE {
    public static void main(String[] args) {
//        CVTE 的一道面试编程题
        ArrayList<Character> list = new ArrayList<>();
        String s1 = "welcome to china";
        String s2 = "come";

        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            if (!s2.contains(ch + "")) {
                list.add(ch);
            }
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
        }
    }
}
