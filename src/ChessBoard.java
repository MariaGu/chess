public class ChessBoard {
    public ChessPiece[][] board = new ChessPiece[8][8]; // creating a field for game
    String nowPlayer;

    public ChessBoard(String nowPlayer) {
        this.nowPlayer = nowPlayer;
    }

    public String nowPlayerColor() {
        return this.nowPlayer;
    }

    public boolean moveToPosition(int startLine, int startColumn, int endLine, int endColumn) {
        if (checkPos(startLine) && checkPos(startColumn)) {

            if (!nowPlayer.equals(board[startLine][startColumn].getColor())) return false;

            if (board[startLine][startColumn].canMoveToPosition(this, startLine, startColumn, endLine, endColumn)) {
                board[endLine][endColumn] = board[startLine][startColumn]; // if piece can move, we moved a piece
                board[startLine][startColumn] = null; // set null to previous cell

                ChessPiece piece = board[startLine][startColumn];
                if (piece.getSymbol().equals("K") || piece.getSymbol().equals("R")) {
                    piece.setCheck(true);
                }
                this.nowPlayer = this.nowPlayerColor().equals("White") ? "Black" : "White";

                return true;
            } else return false;
        } else return false;
    }

    public boolean castling0() {
        int line = nowPlayerColor().equals("White") ? 0 : 7;
        ChessPiece king = board[line][4];
        ChessPiece rook = board[line][0];

        if (king != null
                && rook != null
                && king.getSymbol().equals("K")
                && rook.getSymbol().equals("R")
                && king.isCheck()
                && rook.isCheck()
                && board[line][1] == null
                && board[line][2] == null
                && board[line][3] == null
                && new King(nowPlayerColor()).isUnderAttack(this, line, 2)) {
            board[line][4] = null;
            board[line][2] = new King(nowPlayerColor());
            board[line][2].setCheck(false);
            board[line][0] = null;
            board[line][3] = new Rook(nowPlayerColor());
            board[line][3].setCheck(false);
            nowPlayer = nowPlayerColor().equals("White") ? "Black" : "White";
            return true;
        }
        return false;
    }

    public boolean castling7() {
        int line = nowPlayerColor().equals("White") ? 0 : 7;
        ChessPiece king = board[line][4];
        ChessPiece rook = board[line][7];

        if (king != null
                && rook != null
                && king.getSymbol().equals("K")
                && rook.getSymbol().equals("R")
                && king.isCheck()
                && rook.isCheck()
                && board[line][5] == null
                && board[line][6] == null
                && new King(nowPlayerColor()).isUnderAttack(this, line, 6)) {
            board[line][6] = new King(nowPlayerColor());
            board[line][6].setCheck(false);
            board[line][4] = null;
            board[line][7] = null;
            board[line][5] = new Rook(nowPlayerColor());
            board[line][5].setCheck(false);
            nowPlayer = nowPlayerColor().equals("White") ? "Black" : "White";
            return true;
        }
        return false;
    }

    public void printBoard() {  //print board in console
        System.out.println("Turn " + nowPlayer);
        System.out.println();
        System.out.println("Player 2(Black)");
        System.out.println();
        System.out.println("\t0\t1\t2\t3\t4\t5\t6\t7");

        for (int i = 7; i > -1; i--) {
            System.out.print(i + "\t");
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == null) {
                    System.out.print(".." + "\t");
                } else {
                    System.out.print(board[i][j].getSymbol() + board[i][j].getColor().substring(0, 1).toLowerCase() + "\t");
                }
            }
            System.out.println();
            System.out.println();
        }
        System.out.println("Player 1(White)");
    }

    public boolean checkPos(int pos) {
        return pos >= 0 && pos <= 7;
    }
}