package chess;

import pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

import static pieces.PieceColor.BLACK_COLOR;
import static pieces.PieceColor.BLACK_REPRESENTATION;

public class Board {
    private static final int BOARD_LENGTH = 8;
    private final List<Pawn> whitePawns = new ArrayList<>();
    private final List<Pawn> blackPawns = new ArrayList<>();

    public Board() {
    }

    public void addWhitePawns(final Pawn pawn) {
        whitePawns.add(pawn);
    }

    public void addBlackPawns(final Pawn pawn) {
        blackPawns.add(pawn);
    }

    public int sizeOfWhitePawns() {
        return whitePawns.size();
    }

    public int sizeOfBlackPawns() {
        return blackPawns.size();
    }

    // TODO: index 예외 처리
    public Pawn findWhitePawn(final int index) {
        return whitePawns.get(index);
    }

    public Pawn findBlackPawn(final int index) {
        return blackPawns.get(index);
    }

    public String getWhitePawnsResult() {
        return createPawnsResult(whitePawns);
    }

    public String getBlackPawnsResult() {
        return createPawnsResult(blackPawns);
    }

    private String createPawnsResult(List<Pawn> pawns) {
        StringBuilder sb = new StringBuilder();
        for (Pawn p : pawns) {
            sb.append(p.getRepresentation());
        }

        return sb.toString();
    }

    public void initialize() {
        for (int i = 0; i < BOARD_LENGTH; i++) {
            addWhitePawns(new Pawn());
            addBlackPawns(new Pawn(BLACK_COLOR, BLACK_REPRESENTATION));
        }

        // TODO: output 클래스 분리
        printChessBoard();
    }

    private void printChessBoard() {
        System.out.println(createChessBoard());
    }

    private String createChessBoard() {
        final String BLANK_LINE = "........";
        String lineSeparator = System.lineSeparator();

        StringBuilder sb = new StringBuilder();
        sb.append(BLANK_LINE).append(lineSeparator)
                .append(getBlackPawnsResult()).append(lineSeparator)
                .append(BLANK_LINE).append(lineSeparator)
                .append(BLANK_LINE).append(lineSeparator)
                .append(BLANK_LINE).append(lineSeparator)
                .append(BLANK_LINE).append(lineSeparator)
                .append(getWhitePawnsResult()).append(lineSeparator)
                .append(BLANK_LINE).append(lineSeparator);

        return sb.toString();
    }
}
