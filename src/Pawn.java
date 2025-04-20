public class Pawn extends ChessPiece {
    public Pawn(String color) {
        super(color);
    }

    public String getColor() {
        return this.color;
    }

    public String getSymbol() {
        return "P";
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!chessBoard.checkPos(toLine) || !chessBoard.checkPos(toColumn)) return false;
        if (line == toLine && column == toColumn) return false;

        // Пешка ходит только вперед
        int direction = color.equals("White") ? 1 : -1;

        // Обычный ход на 1 клетку
        if (column == toColumn && chessBoard.board[toLine][toColumn] == null) {
            if (toLine == line + direction) return true;

            // Первый ход на 2 клетки
            if ((line == 1 && color.equals("White")) || (line == 6 && color.equals("Black"))) {
                if (toLine == line + 2*direction &&
                        chessBoard.board[line + direction][column] == null) {
                    return true;
                }
            }
        }

        // Взятие фигуры по диагонали
        if (Math.abs(toColumn - column) == 1 && toLine == line + direction) {
            return chessBoard.board[toLine][toColumn] != null &&
                    !chessBoard.board[toLine][toColumn].getColor().equals(color);
        }

        return false;
    }
}