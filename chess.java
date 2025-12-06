import java.util.ArrayList;

public class chess {

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

    public chess() {
        initializePieces();
        print();
    }

    public void tonum(String first, String second) {
        

    }

    public String tolet(int num) {
        return ref.substring(num - 1, num);
    }

    public void initializePieces() {
        //1 = pawn, 2 = bishop, 3 = knight, 4 = rook, 5 = queen, 6 = king
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



    }

    public void print() {
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
