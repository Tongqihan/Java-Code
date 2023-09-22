package Demo;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Game game = new Game();
        List<Poker> pokers = game.buyPoker();
        System.out.println(pokers);
//        洗牌
        game.shuffle(pokers);
        System.out.println("------------------------------");
        System.out.println("洗牌: ");
        System.out.println(pokers);

//        揭牌
        List<List<Poker>> hand = game.game(pokers);
        System.out.println("揭牌: ");
        for (int i = 0; i < hand.size(); i++) {
            System.out.println("第 " + (i + 1) +" 个人的牌：" + hand.get(i));
        }
        System.out.println("剩下的牌: ");
        System.out.println(pokers);
    }
}
