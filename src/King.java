public class King extends ChessPiece {

    public King(String color) {
        super(color);
    }

    @Override
    public String getSymbol() {
        return "K";
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (toLine < 0 || toLine >= 8 || toColumn < 0 || toColumn >= 8) {
            return false;
        }

         if (Math.abs(toLine - line) > 1 || Math.abs(toColumn - column) > 1) {
            return false;
        }

        ChessPiece targetPiece = chessBoard.board[toLine][toColumn];
        return targetPiece == null || !getColor().equals(targetPiece.getColor());
    }

    public boolean isUnderAttack(ChessBoard board, int line, int column) {

        for (int row = 0; row < board.board.length; row++) {
            for (int col = 0; col < board.board[row].length; col++) {
                ChessPiece piece = board.board[row][col];
                if (piece != null
                        && !piece.getColor().equals(getColor())
                        && !(line == row && col == column)
                        && canMoveToPosition(board, row, column, line, column)) {
                    return false;
                }
            }
        }
        return true;
    }
}


