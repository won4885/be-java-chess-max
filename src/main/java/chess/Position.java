package chess;

public class Position {
    private int x;
    private int y;

    public Position(String position) {
        this.x = position.charAt(0) - 'a' + 1;
        this.y = Character.getNumericValue(position.charAt(1));
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getIndexOfX() {
        return x - 1;
    }

    public int getIndexOfY() {
        return y - 1;
    }
}
