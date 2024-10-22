public abstract class ChessPiece {

    private final String color;
    private boolean check = true;

    public ChessPiece(String color) {
        this.color = color;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public boolean isCheck() {
        return check;
    }

    public abstract String getSymbol();

    public abstract boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);

    public String getColor() {
        return color;
    }

 }
