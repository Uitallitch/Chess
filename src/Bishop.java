public class Bishop extends ChessPiece {
    public Bishop(String color) {
        super(color);
    }

    public String getColor() {
        return this.color;
    }

    public String getSymbol() {
        return "B";
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!chessBoard.checkPos(toLine) || !chessBoard.checkPos(toColumn)) return false;
        if (line == toLine && column == toColumn) return false;

        if (Math.abs(toLine - line) != Math.abs(toColumn - column)) return false;

        int stepX = (toLine > line) ? 1 : -1;
        int stepY = (toColumn > column) ? 1 : -1;
        int x = line + stepX;
        int y = column + stepY;

        while (x != toLine && y != toColumn) {
            if (chessBoard.board[x][y] != null) return false;
            x += stepX;
            y += stepY;
        }

        ChessPiece target = chessBoard.board[toLine][toColumn];
        return target == null || !target.getColor().equals(this.color);
    }
}