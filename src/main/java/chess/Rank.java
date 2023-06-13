package chess;

import pieces.Piece;
import pieces.Piece.Color;
import pieces.Piece.Type;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Rank {
    private final List<Piece> pieces = new ArrayList<>();

    public void move(int xPos, Piece piece) {
        pieces.set(xPos, piece);
    }

    public void addPiece(final Piece piece) {
        pieces.add(piece);
    }

    public Collection<Piece> getPieces() {
        return Collections.unmodifiableCollection(pieces);
    }

    public Piece findPiece(final int xPosition) {
        return pieces.get(xPosition);
    }

    public int countPieceByColorAndType(final Color color, final Type type) {
        int countPiece = 0;
        for (Piece piece : pieces) {
            if (piece.matchColorAndType(color, type)) {
                countPiece += 1;
            }
        }

        return countPiece;
    }

    public static Rank initializeWhitePieces() {
        Rank rank = new Rank();
        rank.addPiece(Piece.createWhiteRook());
        rank.addPiece(Piece.createWhiteKnight());
        rank.addPiece(Piece.createWhiteBishop());
        rank.addPiece(Piece.createWhiteQueen());
        rank.addPiece(Piece.createWhiteKing());
        rank.addPiece(Piece.createWhiteBishop());
        rank.addPiece(Piece.createWhiteKnight());
        rank.addPiece(Piece.createWhiteRook());

        return rank;
    }

    public static Rank initializeBlackPieces() {
        Rank rank = new Rank();
        rank.addPiece(Piece.createBlackRook());
        rank.addPiece(Piece.createBlackKnight());
        rank.addPiece(Piece.createBlackBishop());
        rank.addPiece(Piece.createBlackQueen());
        rank.addPiece(Piece.createBlackKing());
        rank.addPiece(Piece.createBlackBishop());
        rank.addPiece(Piece.createBlackKnight());
        rank.addPiece(Piece.createBlackRook());

        return rank;
    }

    public static Rank initializeWhitePawns() {
        Rank rank = new Rank();
        for(int i = 0; i < 8; i++) {
            rank.addPiece(Piece.createWhitePawn());
        }

        return rank;
    }

    public static Rank initializeBlackPawns() {
        Rank rank = new Rank();
        for(int i = 0; i < 8; i++) {
            rank.addPiece(Piece.createBlackPawn());
        }

        return rank;
    }

    public static Rank initializeBlankLine() {
        Rank rank = new Rank();
        for(int i = 0; i < 8; i++) {
            rank.addPiece(Piece.createBlank());
        }

        return rank;
    }
}
