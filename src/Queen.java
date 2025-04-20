public class Queen extends ChessPiece {
    public Queen(String color) {
        super(color);
    }

    public String getColor() {
        return this.color;
    }

    public String getSymbol() {
        return "Q";
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!chessBoard.checkPos(toLine) || !chessBoard.checkPos(toColumn)) return false;
        if (line == toLine && column == toColumn) return false;

        // Проверка хода как ладьи
        if (line == toLine || column == toColumn) {
            int step;
            if (line == toLine) {
                step = (toColumn > column) ? 1 : -1;
                for (int y = column + step; y != toColumn; y += step) {
                    if (chessBoard.board[line][y] != null) return false;
                }
            } else {
                step = (toLine > line) ? 1 : -1;
                for (int x = line + step; x != toLine; x += step) {
                    if (chessBoard.board[x][column] != null) return false;
                }
            }
        }
        // Проверка хода как слона
        else if (Math.abs(toLine - line) == Math.abs(toColumn - column)) {
            int stepX = (toLine > line) ? 1 : -1;
            int stepY = (toColumn > column) ? 1 : -1;
            int x = line + stepX;
            int y = column + stepY;

            while (x != toLine && y != toColumn) {
                if (chessBoard.board[x][y] != null) return false;
                x += stepX;
                y += stepY;
            }
        }
        else {
            return false;
        }

        ChessPiece target = chessBoard.board[toLine][toColumn];
        return target == null || !target.getColor().equals(this.color);
    }
}