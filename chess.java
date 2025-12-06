import java.util.ArrayList;

public class chess {

    ArrayList<Piece> pieces = new ArrayList<Piece>();

    public chess() {
        initializePieces();
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

    
}
