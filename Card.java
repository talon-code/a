public class Card {
    private int suit;
    private int num;
    private int c;

    public Card(int suit, int num, int c){
        this.suit = suit;
        this.num = num;
        this.c = c;
    }

    public int getSuit(){
        return suit;
    }

    public int getNum(){
        return num;
    }

    public int getC(){
        return c;
    }

    public void setSuit(int n){
        this.suit = n;
    }

    public void setNum(int n){
        this.num = n;
    }

    public void setC(int n){
        this.c = n;
    }

}