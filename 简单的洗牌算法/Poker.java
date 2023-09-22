package Demo;

public class Poker {
    private String suit;  // 花色
    private int rank;  // 数字

    public Poker(String suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Poker{" +
                "suit='" + suit + '\'' +
                ", rank=" + rank +
                '}';
    }
}
