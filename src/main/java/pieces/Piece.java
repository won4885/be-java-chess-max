package pieces;

import lombok.Getter;

import java.util.Objects;

import static pieces.Piece.Color.BLACK;
import static pieces.Piece.Color.WHITE;

@Getter
public class Piece {
    public enum Color {
        WHITE, BLACK, NOCOLOR;
    }

    public enum Type {
        PAWN, ROOK, KNIGHT, BISHOP, QUEEN, KING, NO_PIECE;
    }

    public static final String WHITE_COLOR = "white";
    public static final String BLACK_COLOR = "black";
    public static final char WHITE_PAWN_REPRESENTATION = 'p';
    public static final char BLACK_PAWN_REPRESENTATION = 'P';
    public static final char WHITE_KNIGHT_REPRESENTATION = 'n';
    public static final char BLACK_KNIGHT_REPRESENTATION = 'N';
    public static final char WHITE_ROOK_REPRESENTATION = 'r';
    public static final char BLACK_ROOK_REPRESENTATION = 'R';
    public static final char WHITE_BISHOP_REPRESENTATION = 'b';
    public static final char BLACK_BISHOP_REPRESENTATION = 'B';
    public static final char WHITE_QUEEN_REPRESENTATION = 'q';
    public static final char BLACK_QUEEN_REPRESENTATION = 'Q';
    public static final char WHITE_KING_REPRESENTATION = 'k';
    public static final char BLACK_KING_REPRESENTATION = 'K';

    private final Color color;
    private final char representation;

    /**
     * 기본 생생자는 white 기반
     */
    private Piece() {
        this(WHITE, WHITE_PAWN_REPRESENTATION);
    }

    private Piece(final Color color, final char representation) {
        validatePiece(color, representation);
        this.color = color;
        this.representation = representation;
    }

    public static Piece createWhitePawn() {
        return new Piece();
    }

    public static Piece createBlackPawn() {
        return new Piece(BLACK, BLACK_PAWN_REPRESENTATION);
    }

    public static Piece createWhiteKnight() {
        return new Piece(WHITE, WHITE_KNIGHT_REPRESENTATION);
    }

    public static Piece createBlackKnight() {
        return new Piece(BLACK, BLACK_KNIGHT_REPRESENTATION);
    }

    public static Piece createWhiteRook() {
        return new Piece(WHITE, WHITE_ROOK_REPRESENTATION);
    }

    public static Piece createBlackRook() {
        return new Piece(BLACK, BLACK_ROOK_REPRESENTATION);
    }

    public static Piece createWhiteBishop() {
        return new Piece(WHITE, WHITE_BISHOP_REPRESENTATION);
    }

    public static Piece createBlackBishop() {
        return new Piece(BLACK, BLACK_BISHOP_REPRESENTATION);
    }

    public static Piece createWhiteQueen() {
        return new Piece(WHITE, WHITE_QUEEN_REPRESENTATION);
    }

    public static Piece createBlackQueen() {
        return new Piece(BLACK, BLACK_QUEEN_REPRESENTATION);
    }

    public static Piece createWhiteKing() {
        return new Piece(WHITE, WHITE_KING_REPRESENTATION);
    }

    public static Piece createBlackKing() {
        return new Piece(BLACK, BLACK_KING_REPRESENTATION);
    }

    public boolean isWhite() {
        return (Objects.equals(color, WHITE));
    }

    public boolean isBlack() {
        return (Objects.equals(color, BLACK));
    }

    /**
     * black 또는 white 색상이 아닌 경우 예외를 던짐
     * TODO: 던진 예외를 처리해야 함
     */
    private void validatePiece(final Color color, final char representation) {
        if (!color.equals(BLACK) && !color.equals(WHITE)
                && representation != BLACK_PAWN_REPRESENTATION && representation != WHITE_PAWN_REPRESENTATION) {
            throw new IllegalArgumentException("[ERROR] color: " + color + ", " + "representation: " + representation);
        }
    }
}
