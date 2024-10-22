public class Rook extends ChessPiece {

    public Rook(String color) {
        super(color);
    }

    @Override
    public String getSymbol() {
        return "R";
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (toLine < 0 || toLine >= 8 || toColumn < 0 || toColumn >= 8) {
            return false;
        }

        if (line != toLine && column != toColumn) {
            return false;
        }

        if (line == toLine) {
            int step = (column < toColumn) ? 1 : -1;
            for (int y = column + step; y != toColumn; y += step) {
                if (chessBoard.board[line][y] != null) {
                    return false;
                }
            }
        }

        if (column == toColumn) {
            int step = (line < toLine) ? 1 : -1;
            for (int x = line + step; x != toLine; x += step) {
                if (chessBoard.board[x][column] != null) {
                    return false;
                }
            }
        }

        ChessPiece targetPiece = chessBoard.board[toLine][toColumn];
        if (targetPiece != null) {
            return !getColor().equals(targetPiece.getColor());
        }

        return true;
    }
}

