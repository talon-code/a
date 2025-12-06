import java.util.ArrayList;
import java.util.Scanner;

public class chess {

    Scanner scanner = new Scanner(System.in);
    private String ref = "abcdefghijklmnopqrstuvwxyz";

    private String a = "r k b q k b k r";
    private String b = "p p p p p p p p";
    private String c = "_ _ _ _ _ _ _ _";
    private String d = "_ _ _ _ _ _ _ _";
    private String e = "_ _ _ _ _ _ _ _";
    private String f = "_ _ _ _ _ _ _ _";
    private String g = "P P P P P P P P";
    private String h = "R K B Q K B K R";

    ArrayList<Piece> pieces = new ArrayList<Piece>();
    ArrayList<Piece> captured = new ArrayList<Piece>();

    private int startRow;
    private int startCol;
    private int endCol;
    private int endRow;
    private boolean white = true;

    public chess() {
        initializePieces();
        print();
        while(captured.size() < 30){
            movePiece(askWhite());
            print();
            movePiece(askBlack());
            print();
        }
    }

    //will change location in array of piece moved
    //delete captured piece from array
    //replace previous location with underscore
    //ask if the move is legal
    public void movePiece(String str) {
        int n = 0;
        startCol = tonum(str.substring(0,1));
        startRow = stringToInt(str.substring(1,2));
        endCol = tonum(str.substring(3,4));
        endRow = stringToInt(str.substring(4,5));
        boolean found = false;

        if(!isLegal(startCol, startRow, endCol, endRow)){
            
        //delete captured piece
        while(pieces.size() > n) {
            Piece p = pieces.get(n);
            if(p.getCol() == endCol && p.getRow() == endRow){
                captured.add(p);
                pieces.remove(pieces.indexOf(p));
            }
            n++;
        }

        //change location of piece
        while(pieces.size() > n && !found) {
            Piece p = pieces.get(n);
            if(p.getCol() == startCol && p.getRow() == startRow){
                found = true;
                p.setCol(endCol);
                p.setRow(endRow);
            }
            n++;
        }
        //put underscore at previous location
        pieces.add(new Piece(0, 0, startCol, startRow));
        } else {
            System.out.println("Illegal move");
        }
    }

    public boolean isLegal(int sc, int sr, int ec, int er){
        return true;




    }

    public int stringToInt(String n){
        int ref = 987654321;
        while(n.indexOf(ref % 10) != -1){
            ref /= 10;
        }
        return ref % 10;
    }

    public int tonum(String let) { 
        return ref.indexOf(let) + 1;
    }

    public String tolet(int num) {
        return ref.substring(num - 1, num);
    }

    public String askWhite() {
        System.out.println("White to move (col|row col|row): ");
        white = true;
        return scanner.nextLine();
    }

    public String askBlack() {
        System.out.println("Black to move (col|row col|row): ");
        white = false;
        return scanner.nextLine();
    }

    public void initializePieces() {
        //0 = US, 1 = pawn, 2 = bishop, 3 = knight, 4 = rook, 5 = queen, 6 = king
        //1 = white, 2 = black
        //1 = row 1, 2 = row 2...
        //1 = col a, 2 = col b...

        //pawns
        int n = 1;
        while(n < 9){
            pieces.add(new Piece(1, 1, 2, n));
            n++;
        }
        n = 1;
        while(n < 9){
            pieces.add(new Piece(1, 2, 7, n));
            n++;
        }

        //bishops
        pieces.add(new Piece(2, 1, 1, 3));
        pieces.add(new Piece(2, 1, 1, 6));
        pieces.add(new Piece(2, 2, 8, 3));
        pieces.add(new Piece(2, 2, 8, 6));
        //knights
        pieces.add(new Piece(3, 1, 1, 2));
        pieces.add(new Piece(3, 1, 1, 7));
        pieces.add(new Piece(3, 2, 8, 2));
        pieces.add(new Piece(3, 2, 8, 7));
        //rooks
        pieces.add(new Piece(4, 1, 1, 1));
        pieces.add(new Piece(4, 1, 1, 8));
        pieces.add(new Piece(4, 1, 8, 1));
        pieces.add(new Piece(4, 1, 8, 8));
        //queens
        pieces.add(new Piece(5, 1, 1, 4));
        pieces.add(new Piece(5, 2, 8, 4));
        //kings
        pieces.add(new Piece(6, 1, 1, 5));
        pieces.add(new Piece(6, 2, 8, 5));
        //underscores
        int i = 3;
        n = 1;
        while(1 < 7){
            while(n < 9){
                pieces.add(new Piece(0, 0, i, n));
                n++;
            }
        i++;
        }
    }

    public void print() {
        //string a
        int rowInCol = 0;
        int character = 1;
        int count = 0;
        while(rowInCol < pieces.size()){
            while(character <= 8){
                while(count < 64){
                    Piece p = pieces.get(count);
                    if(p.getCol() == character && p.getRow() == rowInCol){
                        a = a + setType(p.getType)
                    }
                }
                
                count++;
                character++;
            }
            System.out.println("");
            character = 0;
            rowInCol++;
        }
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
        System.out.println(g);
        System.out.println(h);
    }
}
