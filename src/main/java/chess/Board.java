package chess;

import pieces.Piece;
import pieces.Piece.Color;
import pieces.Piece.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import static utils.StringUtils.appendNewLine;

public class Board {
    private static final int BOARD_LENGTH = 8;
    private final List<Rank> ranks = new ArrayList<>();

    public Board() {
    }

    public void initialize() {
        ranks.add(Rank.initializeWhitePieces());
        ranks.add(Rank.initializeWhitePawns());
        ranks.add(Rank.initializeBlankLine());
        ranks.add(Rank.initializeBlankLine());
        ranks.add(Rank.initializeBlankLine());
        ranks.add(Rank.initializeBlankLine());
        ranks.add(Rank.initializeBlackPawns());
        ranks.add(Rank.initializeBlackPieces());
    }

    public void initializeEmpty() {
        for (int i = 0; i < BOARD_LENGTH; i++) {
            ranks.add(Rank.initializeBlankLine());
        }
    }

    public String showBoard() {
        StringBuilder sb = new StringBuilder();
        ListIterator<Rank> rankListIterator = ranks.listIterator(ranks.size());
        while (rankListIterator.hasPrevious()) {
            sb.append(showRank(rankListIterator.previous()));
        }

        return sb.toString();
    }

    private String showRank(final Rank rank) {
        StringBuilder sb = new StringBuilder();
        for (Piece piece : rank.getPieces()) {
            sb.append(piece.getRepresentation());
        }

        return appendNewLine(sb.toString());
    }

    public int countPieceByColorAndType(final Color color, final Type type) {
        int countPiece = 0;
        for (Rank rank : ranks) {
            countPiece += rank.countPieceByColorAndType(color, type);
        }

        return countPiece;
    }

    public Piece findPiece(final String position) {
        Position p = new Position(position);
        return ranks.get(p.getIndexOfY()).findPiece(p.getIndexOfX());
    }

    public void move(final String position, final Piece piece) {
        Position p = new Position(position);
        ranks.get(p.getIndexOfY()).move(p.getIndexOfX(), piece);
    }

    public double calculatePoint(final Color color) {
        List<Piece> piecesByColor = findPiecesByColor(color);
        double point = 0.0;
        for (Piece piece : piecesByColor) {
            point += piece.getPoint();
        }

        return point;
    }

    private List<Piece> findPiecesByColor(final Color color) {
        List<Piece> pieces = new ArrayList<>();
        for (Rank rank : ranks) {
            pieces.addAll(rank.findPiecesByColor(color));
        }

        return pieces;
    }
}
