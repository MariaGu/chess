public class Horse extends ChessPiece {

    public Horse(String color) {
        super(color);
    }

    @Override
    public String getSymbol() {
        return "H";
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (toLine < 0 || toLine >= 8 || toColumn < 0 || toColumn >= 8) {
            return false;
        }

        int dx = Math.abs(toLine - line);
        int dy = Math.abs(toColumn - column);
        if (!((dx == 2 && dy == 1) || (dx == 1 && dy == 2))) {
            return false;
        }
        ChessPiece targetPiece = chessBoard.board[toLine][toColumn];
        if (targetPiece == null || !getColor().equals(targetPiece.getColor())) {
            return true;
        }

        return false;
    }
}
