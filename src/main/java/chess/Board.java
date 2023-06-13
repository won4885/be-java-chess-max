package chess;

import pieces.Piece;
import pieces.Piece.Color;
import pieces.Piece.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import static utils.StringUtils.appendNewLine;

public class Board {
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

    public String showBoard() {
        StringBuilder sb = new StringBuilder();
        ListIterator<Rank> rankListIterator = ranks.listIterator(ranks.size());
        while (rankListIterator.hasPrevious()) {
            sb.append(showRank(rankListIterator.previous()));
        }

        return sb.toString();
    }

    private String showRank(Rank rank) {
        StringBuilder sb = new StringBuilder();
        for (Piece piece : rank.getPieces()) {
            sb.append(piece.getRepresentation());
        }

        return appendNewLine(sb.toString());
    }

    public int countPieceByColorAndType(Color color, Type type) {
        int countPiece = 0;
        for (Rank rank : ranks) {
            countPiece += rank.countPieceByColorAndType(color, type);
        }

        return countPiece;
    }

    public Piece findPiece(String position) {
        char x = position.charAt(0);
        int xPos = x - 'a';

        char y = position.charAt(1);
        int yPos = Character.getNumericValue(y);

        return ranks.get(yPos - 1).findPiece(xPos);
    }
}
