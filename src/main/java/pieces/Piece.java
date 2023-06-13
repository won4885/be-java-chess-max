package pieces;

import lombok.Getter;

import java.util.List;
import java.util.Objects;

import static pieces.Piece.Color.*;
import static pieces.Piece.Type.*;

@Getter
public class Piece {
    public enum Color {
        WHITE, BLACK, NOCOLOR;
    }

    public enum Type {
        PAWN('p', 1.0),
        ROOK('r', 5.0),
        KNIGHT('n', 2.5),
        BISHOP('b', 3.0),
        QUEEN('q', 9.0),
        KING('k', 0.0),
        NO_PIECE('.', 0.0);

        private final char representation;
        private final double defaultPoint;

        Type(final char representation, final double defaultPoint) {
            this.representation = representation;
            this.defaultPoint = defaultPoint;
        }

        public char getWhiteRepresentation() {
            return this.representation;
        }

        public char getBlackRepresentation() {
            return Character.toUpperCase(this.representation);
        }

        public double getDefaultPoint() {
            return defaultPoint;
        }
    }

    private final Color color;
    private final Type type;

    private Piece(final Color color, final Type type) {
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
        return createWhite(PAWN);
    }

    public static Piece createBlackPawn() {
        return createBlack(PAWN);
    }

    public static Piece createWhiteKnight() {
        return createWhite(KNIGHT);
    }

    public static Piece createBlackKnight() {
        return createBlack(KNIGHT);
    }

    public static Piece createWhiteRook() {
        return createWhite(ROOK);
    }

    public static Piece createBlackRook() {
        return createBlack(ROOK);
    }

    public static Piece createWhiteBishop() {
        return createWhite(BISHOP);
    }

    public static Piece createBlackBishop() {
        return createBlack(BISHOP);
    }

    public static Piece createWhiteQueen() {
        return createWhite(QUEEN);
    }

    public static Piece createBlackQueen() {
        return createBlack(QUEEN);
    }

    public static Piece createWhiteKing() {
        return createWhite(KING);
    }

    public static Piece createBlackKing() {
        return createBlack(KING);
    }

    private static Piece createWhite(final Type type) {
        return new Piece(WHITE, type);
    }

    private static Piece createBlack(final Type type) {
        return new Piece(BLACK, type);
    }

    public boolean isWhite() {
        return matchColor(WHITE);
    }

    public boolean isBlack() {
        return matchColor(BLACK);
    }

    public boolean matchColorAndType(final Color color, final Type type) {
        return matchColor(color) && matchType(type);
    }

    private boolean matchColor(final Color color) {
        return this.color == color;
    }

    private boolean matchType(final Type type) {
        return this.type == type;
    }

    public void addPiecesByColor(Color color, List<Piece> piecesByColor) {
        if (matchColor(color)) {
            piecesByColor.add(this);
        }
    }

    public double getPoint() {
        return this.type.getDefaultPoint();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((color == null) ? 0 : color.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());

        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        Piece other = (Piece) obj;

        if (color != other.color) {
            return false;
        }

        return type == other.type;
    }

    @Override
    public String toString() {
        return "Piece{" +
                "color=" + color +
                ", type=" + type +
                '}';
    }
}
