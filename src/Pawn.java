public class Pawn extends ChessPiece {

    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getSymbol() {
        return "P";
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (toLine < 0 || toLine >= 8 || toColumn < 0 || toColumn >= 8) {
            return false;
        }

        int direction = getColor().equals("White") ? 1 : -1;

        if (line + direction == toLine && column == toColumn && chessBoard.board[toLine][toColumn] == null) {
            return true;
        }

        if ((getColor().equals("White") && line == 1) || (!getColor().equals("White") && line == 6)) {
            if (line + 2 * direction == toLine
                    && column == toColumn
                    && chessBoard.board[line + direction][column] == null
                    && chessBoard.board[toLine][toColumn] == null) {
                return true;
            }
        }

        if (line + direction == column
                && (column + 1 == toColumn || column - 1 == toColumn)) {
            ChessPiece targetPiece = chessBoard.board[toLine][toColumn];
            return targetPiece != null && !getColor().equals(targetPiece.getColor());
        }
        return false;
    }
}

