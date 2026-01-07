import java.util.ArrayList;
import java.util.Scanner;

public class poker {
    ArrayList<Card> cards = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    int size = 52;
    private Card onec1;
    private Card onec2;
    private Card twoc1;
    private Card twoc2;
    private boolean oneSmall = true;
    private int oneMoney = 10000;
    private int twoMoney = 10000;
    private int oneInPot = 0;
    private int twoInPot = 0;
    private int pot = 0;
    private boolean oneStays;
    private boolean twoStays;
    private boolean oneCalls;
    private boolean twoCalls;

    public poker(){
        System.out.println(toInt("10908"));
        initializeDeck();
        deal();
        p1askToShow();
        p2askToShow();
        while(oneMoney > 0 && twoMoney > 0){
            if(oneSmall){
                showValues();
                blinds();
                askOne();
                askTwo();
            } else {
                showValues();
                blinds();
                askTwo();
                askOne();
            }
        }
        if(oneMoney > twoMoney)
            System.out.println("Player one wins!");
        else
            System.out.println("Player two wins!");
        askToPlay();
    }

    public String askOne(){
        
        if(oneInPot == twoInPot){
            //check or raise or fold
            System.out.println("Player One: Check, Raise, or Fold?");
            String input = scanner.nextLine();
            if(input.equals("Check"))
                return "Check";
            else if(input.equals("Raise")){
                System.out.println("");
                System.out.println("How much?");
                int amount = toInt(scanner.nextLine());
                while(amount > oneMoney){
                    System.out.println("");
                    System.out.println("Insufficient funds");
                    System.out.println("How much would you like to raise?");
                    amount = toInt(scanner.nextLine());
                }

                if(amount == oneMoney){
                    oneInPot += oneMoney;
                    pot += oneMoney;
                    oneMoney = 0;
                    return "All";
                }
                    
                oneMoney -= amount;
                oneInPot += amount;
                pot += amount;
                return "Raise";

                }
        } else {
            System.out.println("Player One: Call, Raise, or Fold?");
            String input = scanner.nextLine();
            if(input.equals("Call")){
                if(twoInPot < oneMoney){
                oneMoney -= twoInPot - oneInPot;
                pot += twoInPot - oneInPot;
                oneInPot = twoInPot;
                return "Call";
                } else {
                    //all
                    oneInPot += oneMoney;
                    pot += oneMoney;
                    oneMoney = 0;
                    return "All";
                }
            } else if(input.equals("Raise")){
                System.out.println("");
                System.out.println("How much?");
                int amount = toInt(scanner.nextLine());
                while(amount + (twoInPot - oneInPot) > oneMoney){
                    System.out.println("");
                    System.out.println("Insufficient funds");
                    System.out.println("How much would you like to raise?");
                    amount = toInt(scanner.nextLine());
                }

                if(amount + (twoInPot - oneInPot) == oneMoney){
                    oneInPot += oneMoney;
                    pot += oneMoney;
                    oneMoney = 0;
                    return "All";
                }

                oneMoney -= twoInPot - oneInPot + amount;
                oneInPot = twoInPot + amount;
                pot = 2 * oneInPot + amount;
                return "Raise";
            }
            }

            twoMoney += pot;
            oneInPot = 0;
            twoInPot= 0;
            pot = 0;
            return "Fold";
         
    }

    public String askTwo(){
        
        if(oneInPot == twoInPot){
            //check or raise or fold
            System.out.println("Player Two: Check, Raise, or Fold?");
            String input = scanner.nextLine();
            if(input.equals("Check"))
                return "Check";
            else if(input.equals("Raise")){
                System.out.println("");
                System.out.println("How much?");
                int amount = toInt(scanner.nextLine());
                while(amount > twoMoney){
                    System.out.println("");
                    System.out.println("Insufficient funds");
                    System.out.println("How much would you like to raise?");
                    amount = toInt(scanner.nextLine());
                }

                if(amount == twoMoney){
                    twoInPot += twoMoney;
                    pot += twoMoney;
                    twoMoney = 0;
                    return "All";
                }
                    
                twoMoney -= amount;
                twoInPot += amount;
                pot += amount;
                return "Raise";

                }
        } else {
            System.out.println("Player Two: Call, Raise, or Fold?");
            String input = scanner.nextLine();
            if(input.equals("Call")){
                if(oneInPot < twoMoney){
                twoMoney -= oneInPot - twoInPot;
                pot += oneInPot - twoInPot;
                twoInPot = oneInPot;
                return "Call";
                } else {
                    //all
                    twoInPot += twoMoney;
                    pot += twoMoney;
                    twoMoney = 0;
                    return "All";
                }
            } else if(input.equals("Raise")){
                System.out.println("");
                System.out.println("How much?");
                int amount = toInt(scanner.nextLine());
                while(amount + (oneInPot - twoInPot) > twoMoney){
                    System.out.println("");
                    System.out.println("Insufficient funds");
                    System.out.println("How much would you like to raise?");
                    amount = toInt(scanner.nextLine());
                }

                if(amount + (oneInPot - twoInPot) == twoMoney){
                    twoInPot += twoMoney;
                    pot += twoMoney;
                    twoMoney = 0;
                    return "All";
                }

                twoMoney -= oneInPot - twoInPot + amount;
                twoInPot = oneInPot + amount;
                pot = 2 * twoInPot + amount;
                return "Raise";
            }
            }

            oneMoney += pot;
            twoInPot = 0;
            oneInPot= 0;
            pot = 0;
            return "Fold";
         
    }

    public int toInt(String s){
        String perm = "0123456789";
        int num = 0;

        while(s.length() > 0){
            String temp = "0123456789";
            String let = s.substring(0,1);
            while(!let.equals(temp.substring(0,1))){
                temp = temp.substring(1);
            }
            num *= 10;
            num += perm.indexOf(temp.substring(0,1));
            s = s.substring(1);
        }

        return num;
    }

    public void showValues(){
        System.out.println("");
        System.out.println("One's Money:   Two's Money:   Pot:");
        String gap1 = gap1();
        String gap2 = gap2();

        System.out.println(oneMoney + gap1 + twoMoney + gap2 + pot);
        System.out.println("");
        //one's length + gap1 = 15 
    }

    public String gap1(){
        int x = oneMoney;
        int length = 0;
        String g = "";
        while(x != 0){
            length++;
            x /= 10;
        }
        while(15 - length != 0){
            g += " ";
            length++;
        }
        return g;
    }

    public String gap2(){
        int x = twoMoney;
        int length = 0;
        String g = "";
        while(x != 0){
            length++;
            x /= 10;
        }
        while(15 - length != 0){
            g += " ";
            length++;
        }
        return g;
    }

    public void blinds(){
        // 5/10
        if(oneSmall){
            addToPot(1, 5);
            addToPot(2, 10);
        } else {
            addToPot(2, 5);
            addToPot(1, 10);
        }
        oneSmall = !oneSmall;
    }

    public void addToPot(int player, int amount){
        if(player == 1){
            oneMoney -= amount;
            oneInPot += amount;
            pot += amount;
        } else {
            twoMoney -= amount;
            twoInPot += amount;
            pot += amount;
        }
    }

    public void askToPlay(){
        System.out.println("");
        System.out.println("Would you like to play again? (type: yes)");
        if(scanner.nextLine().equals("yes"))
            new poker();
        else {
            System.out.println("");
            System.out.println("Thanks for playing!");
        }
    }

    private String translateNum(Card card){
        if(card.getNum() == 1)
            return "Ace";
        if(card.getNum() == 11)
            return "Jack";
        if(card.getNum() == 12)
            return "Queen";
        if(card.getNum() == 13)
            return "King";
        else
            return String.valueOf(card.getNum());
    }

    private String translateSuit(Card card){
        if(card.getSuit() == 1)
            return "Spades";
        if(card.getSuit() == 2)
            return "Clubs";
        if(card.getSuit() == 3)
            return "Diamonds";
        if(card.getSuit() == 4)
            return "Hearts";
        else
            return "No suit found";
    }

    public void p1askToShow(){
        System.out.println("P1, would you like to see your cards? (hit enter)");
        if(scanner.nextLine().equals("")){
            System.out.println(translateNum(onec1) + " of " + translateSuit(onec1));
            System.out.println(translateNum(onec2) + " of " + translateSuit(onec2));
        }
        System.out.println("Would you like me to hide your cards? (hit enter)");
        if(scanner.nextLine().equals("")){
            for(int i = 1; i < 50; i++){
                System.out.println("");
            }
        }
    }

    public void p2askToShow(){
        System.out.println("P2, would you like to see your cards? (hit enter)");
        String input = scanner.nextLine();
        if(input.equals("")){
            System.out.println(translateNum(twoc1) + " of " + translateSuit(twoc1));
            System.out.println(translateNum(twoc2) + " of " + translateSuit(twoc2));
        }
        System.out.println("Would you like me to hide your cards? (hit enter)");
        if(scanner.nextLine().equals("")){
            for(int i = 1; i < 50; i++){
                System.out.println("");
            }
        }
    }

    public void deal(){
        onec1 = cards.get((int) (Math.random() * size));
        cards.remove(onec1);
        size--;
        onec2 = cards.get((int) (Math.random() * size));
        cards.remove(onec2);
        size--;
        twoc1 = cards.get((int) (Math.random() * size));
        cards.remove(twoc1);
        size--;
        twoc2 = cards.get((int) (Math.random() * size));
        cards.remove(twoc2);
        size--;
    }

    public void initializeDeck(){
        for(int suit = 1; suit <= 4; suit++){
            for(int num = 1; num <= 13; num++){
                cards.add(new Card(suit, num, 13 * (suit - 1) + num));
            }
        }
    }
}