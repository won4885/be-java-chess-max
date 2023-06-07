package pieces;

import lombok.Getter;

@Getter
public class Piece {
    public static final String WHITE_COLOR = "white";
    public static final char WHITE_PAWN_REPRESENTATION = 'p';
    public static final String BLACK_COLOR = "black";
    public static final char BLACK_PAWN_REPRESENTATION = 'P';

    private final String color;
    private final char representation;

    /**
     * 기본 생생자는 white 기반
     */
    private Piece() {
        this(WHITE_COLOR, WHITE_PAWN_REPRESENTATION);
    }

    private Piece(final String color, final char representation) {
        validatePiece(color, representation);
        this.color = color;
        this.representation = representation;
    }

    public static Piece createWhitePawn() {
        return new Piece();
    }

    public static Piece createBlackPawn() {
        return new Piece(BLACK_COLOR, BLACK_PAWN_REPRESENTATION);
    }

    /**
     * black 또는 white 색상이 아닌 경우 예외를 던짐
     * TODO: 던진 예외를 처리해야 함
     */
    private void validatePiece(final String color, final char representation) {
        if (!color.equals(BLACK_COLOR) && !color.equals(WHITE_COLOR)
                && representation != BLACK_PAWN_REPRESENTATION && representation != WHITE_PAWN_REPRESENTATION) {
            throw new IllegalArgumentException("[ERROR] color: " + color + ", " + "representation: " + representation);
        }
    }
}
