public class Piece {
    private int type;
    private int color;
    private int collumn;
    private int row;

    public Piece(int type, int color, int collumn, int row) {
        this.type = type;
        this.color = color;
        this.collumn = collumn;
        this.row = row;
    }

    public int getCol() {
        return collumn;
    }

    public int getRow() {
        return row;
    }

    public void setCol(int c) {
        this.collumn = c;
    }

    public void setRow(int r){
        this.row = r;
    }
}