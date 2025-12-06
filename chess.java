import java.util.ArrayList;
import java.util.Scanner;

public class chess {

    Scanner scanner = new Scanner(System.in);
    private String ref = "abcdefghijklmnopqrstuvwxyz";

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

        System.out.println("startCol" + startCol);
        System.out.println("startRow" + startRow);
        System.out.println("endCol" + endCol);
        System.out.println("endRow" + endRow);
        boolean found = false;

        if(isLegal(startCol, startRow, endCol, endRow)){
            
        //delete captured piece
        while(pieces.size() > n) {
            Piece p = pieces.get(n);
            if(p.getCol() == endCol && p.getRow() == endRow){
                captured.add(p);
                pieces.remove(pieces.indexOf(p));
            }
            n++;
        }

        n=0;

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
        String ref = "0123456789";
        return ref.indexOf(n);
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

    public String typeLet(int color, int n){
       
        if(color == 1){
        if(n == 1)
            return "p";
        if(n == 2)
            return "b";
        if(n == 3)
            return "k";
        if(n == 4)
            return "r";
        if(n == 5)
            return "q";
        if(n == 6)
            return "k";
        } else if(color == 2){
        if(n == 1)
            return "P";
        if(n == 2)
            return "B";
        if(n == 3)
            return "K";
        if(n == 4)
            return "R";
        if(n == 5)
            return "Q";
        if(n == 6)
            return "K";
        } 

        return "_";

    }

    public void initializePieces() {
        //0 = US, 1 = pawn, 2 = bishop, 3 = knight, 4 = rook, 5 = queen, 6 = king
        //1 = white, 2 = black
        //1 = row 1, 2 = row 2...
        //1 = col a, 2 = col b...

    for (int col = 1; col <= 8; col++)
        pieces.add(new Piece(1, 1, col, 2));

    for (int col = 1; col <= 8; col++)
        pieces.add(new Piece(1, 2, col, 7));

    //white back rank
    pieces.add(new Piece(4, 1, 1, 1)); 
    pieces.add(new Piece(3, 1, 2, 1));
    pieces.add(new Piece(2, 1, 3, 1));
    pieces.add(new Piece(5, 1, 4, 1));
    pieces.add(new Piece(6, 1, 5, 1));
    pieces.add(new Piece(2, 1, 6, 1));
    pieces.add(new Piece(3, 1, 7, 1)); 
    pieces.add(new Piece(4, 1, 8, 1));  

    // Black back rank
    pieces.add(new Piece(4, 2, 1, 8));
    pieces.add(new Piece(3, 2, 2, 8));
    pieces.add(new Piece(2, 2, 3, 8));
    pieces.add(new Piece(5, 2, 4, 8));
    pieces.add(new Piece(6, 2, 5, 8));
    pieces.add(new Piece(2, 2, 6, 8));
    pieces.add(new Piece(3, 2, 7, 8));
    pieces.add(new Piece(4, 2, 8, 8));

    // US
    for (int row = 3; row <= 6; row++)
        for (int col = 1; col <= 8; col++)
            pieces.add(new Piece(0, 0, col, row));
    }

    public void print() {
    for (int row = 8; row >= 1; row--) {       
        for (int col = 1; col <= 8; col++) {      

            for (Piece p : pieces) {
                if (p.getCol() == col && p.getRow() == row) {
                    System.out.print(typeLet(p.getColor(), p.getType()) + " ");
                    break;
                }
            }
        }
        System.out.println();
    }
}
}
