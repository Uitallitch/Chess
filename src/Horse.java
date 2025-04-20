public class Horse extends ChessPiece {
    public Horse(String color) {
        super(color);
    }

    public String getColor() {
        return this.color;
    }

    public String getSymbol() {
        return "H";
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!chessBoard.checkPos(toLine) || !chessBoard.checkPos(toColumn)) return false;
        if (line == toLine && column == toColumn) return false;

        int x = Math.abs(toLine - line);
        int y = Math.abs(toColumn - column);
        boolean isValidMove = (x == 2 && y == 1) || (x == 1 && y == 2);

        if (isValidMove) {
            ChessPiece target = chessBoard.board[toLine][toColumn];
            return target == null || !target.getColor().equals(this.color);
        }

        return false;
    }
}