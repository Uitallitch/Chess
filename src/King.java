public class King extends ChessPiece {
    public King(String color) {
        super(color);
    }

    public String getColor() {
        return this.color;
    }

    public String getSymbol() {
        return "K";
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!chessBoard.checkPos(toLine) || !chessBoard.checkPos(toColumn)) return false;
        if (line == toLine && column == toColumn) return false;

        int lineDiff = Math.abs(toLine - line);
        int columnDiff = Math.abs(toColumn - column);

        if (lineDiff <= 1 && columnDiff <= 1) {
            ChessPiece target = chessBoard.board[toLine][toColumn];
            return target == null || !target.getColor().equals(this.color);
        }

        return false;
    }

    public boolean isUnderAttack(ChessBoard board, int line, int column) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessPiece piece = board.board[i][j];
                if (piece != null && !piece.getColor().equals(this.color)) {
                    if (piece.canMoveToPosition(board, i, j, line, column)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}