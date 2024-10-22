public class Queen extends ChessPiece{

    public Queen(String color) {
        super(color);
    }

    @Override
    public String getSymbol() {
        return "Q";
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (toLine < 0 || toLine >= 8 || toColumn < 0 || toColumn >= 8) {
            return false;
        }

        int dx = toLine - line;
        int dy = toColumn - column;

        if (!(dx == 0 || dy == 0 || Math.abs(dx) == Math.abs(dy))) {
            return false;
        }

        int stepX = Integer.signum(dx);
        int stepY = Integer.signum(dy);
        int steps = Math.max(Math.abs(dx), Math.abs(dy)) - 1;

        for (int i = 1; i <= steps; i++) {
            int intermediateX = line + stepX * i;
            int intermediateY = column + stepY * i;
            if (chessBoard.board[intermediateX][intermediateY] != null) {
                return false;
            }
        }

        ChessPiece targetPiece = chessBoard.board[toLine][toColumn];
        return targetPiece == null || !getColor().equals(targetPiece.getColor());
    }
}

