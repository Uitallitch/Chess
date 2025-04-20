public class Rook extends ChessPiece {
    public Rook(String color) {
        super(color);
    }

    public String getColor() {
        return this.color;
    }

    public String getSymbol() {
        return "R";
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!chessBoard.checkPos(toLine) || !chessBoard.checkPos(toColumn)) return false;
        if (line == toLine && column == toColumn) return false;

        if (line == toLine) {
            int step = (toColumn > column) ? 1 : -1;
            for (int y = column + step; y != toColumn; y += step) {
                if (chessBoard.board[line][y] != null) return false;
            }
        }
        else if (column == toColumn) {
            int step = (toLine > line) ? 1 : -1;
            for (int x = line + step; x != toLine; x += step) {
                if (chessBoard.board[x][column] != null) return false;
            }
        }
        else {
            return false;
        }

        ChessPiece target = chessBoard.board[toLine][toColumn];
        return target == null || !target.getColor().equals(this.color);
    }
}
