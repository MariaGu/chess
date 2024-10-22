public class Bishop extends ChessPiece{

    public Bishop(String color) {
        super(color);
    }

    @Override
    public String getSymbol() {
        return "B";
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (toLine < 0 || toLine >= 8 || toColumn < 0 || toColumn >= 8) {
            return false;
        }

        if (Math.abs(toLine - line) != Math.abs(toColumn - column)) {
            return false;
        }

        int dx = (toLine - line) > 0 ? 1 : -1;
        int dy = (toColumn - column) > 0 ? 1 : -1;

        int x = line + dx;
        int y = column + dy;
        while (x != line && y != column) {
            if (chessBoard.board[x][y] != null) {
                return false;
            }
            x += dx;
            y += dy;
        }

        ChessPiece targetPiece = chessBoard.board[toLine][toColumn];
        if (targetPiece == null || !getColor().equals(targetPiece.getColor())) {
            return true;
        }

        return false;
    }
}

