package pieces;

import lombok.Getter;

import java.util.Objects;

import static pieces.Piece.Color.*;
import static pieces.Piece.Type.*;

@Getter
public class Piece {
    public enum Color {
        WHITE, BLACK, NOCOLOR;
    }

    public enum Type {
        PAWN('p'), ROOK('r'), KNIGHT('n'), BISHOP('b'), QUEEN('q'), KING('k'), NO_PIECE('.');

        private final char representation;

        Type(final char representation) {
            this.representation = representation;
        }

        public char getWhiteRepresentation() {
            return this.representation;
        }

        public char getBlackRepresentation() {
            return Character.toUpperCase(this.representation);
        }
    }

    private final Color color;
    private final Type type;

    private Piece(final Color color, Type type) {
        this.color = color;
        this.type = type;
    }

    public char getRepresentation() {
        if (isWhite()) {
            return this.type.getWhiteRepresentation();
        }

        return this.type.getBlackRepresentation();
    }

    public static Piece createBlank() {
        return new Piece(NOCOLOR, NO_PIECE);
    }

    public static Piece createWhitePawn() {
        return new Piece(WHITE, PAWN);
    }

    public static Piece createBlackPawn() {
        return new Piece(BLACK, PAWN);
    }

    public static Piece createWhiteKnight() {
        return new Piece(WHITE, KNIGHT);
    }

    public static Piece createBlackKnight() {
        return new Piece(BLACK, KNIGHT);
    }

    public static Piece createWhiteRook() {
        return new Piece(WHITE, ROOK);
    }

    public static Piece createBlackRook() {
        return new Piece(BLACK, ROOK);
    }

    public static Piece createWhiteBishop() {
        return new Piece(WHITE, BISHOP);
    }

    public static Piece createBlackBishop() {
        return new Piece(BLACK, BISHOP);
    }

    public static Piece createWhiteQueen() {
        return new Piece(WHITE, QUEEN);
    }

    public static Piece createBlackQueen() {
        return new Piece(BLACK, QUEEN);
    }

    public static Piece createWhiteKing() {
        return new Piece(WHITE, KING);
    }

    public static Piece createBlackKing() {
        return new Piece(BLACK, KING);
    }

    public boolean isWhite() {
        return (Objects.equals(color, WHITE));
    }

    public boolean isBlack() {
        return (Objects.equals(color, BLACK));
    }
}
