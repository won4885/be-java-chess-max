package chess;

import pieces.Piece;

import java.util.ArrayList;
import java.util.List;

import static pieces.PieceColor.BLACK_COLOR;
import static pieces.PieceColor.BLACK_REPRESENTATION;
import static utils.StringUtils.appendNewLine;

public class Board {
    private static final int BOARD_LENGTH = 8;
    private final List<Piece> whitePieces = new ArrayList<>();
    private final List<Piece> blackPieces = new ArrayList<>();

    public Board() {
    }

    public void addWhitePawns(final Piece piece) {
        whitePieces.add(piece);
    }

    public void addBlackPawns(final Piece piece) {
        blackPieces.add(piece);
    }

    public int sizeOfWhitePawns() {
        return whitePieces.size();
    }

    public int sizeOfBlackPawns() {
        return blackPieces.size();
    }

    // TODO: index 예외 처리
    public Piece findWhitePawn(final int index) {
        return whitePieces.get(index);
    }

    public Piece findBlackPawn(final int index) {
        return blackPieces.get(index);
    }

    public String getWhitePawnsResult() {
        return createPawnsResult(whitePieces);
    }

    public String getBlackPawnsResult() {
        return createPawnsResult(blackPieces);
    }

    private String createPawnsResult(final List<Piece> pieces) {
        StringBuilder sb = new StringBuilder();
        for (Piece p : pieces) {
            sb.append(p.getRepresentation());
        }

        return sb.toString();
    }

    public void initialize() {
        for (int i = 0; i < BOARD_LENGTH; i++) {
            addWhitePawns(new Piece());
            addBlackPawns(new Piece(BLACK_COLOR, BLACK_REPRESENTATION));
        }

        // TODO: output 클래스 분리
        printChessBoard();
    }

    private void printChessBoard() {
        System.out.println(createChessBoard());
    }

    private String createChessBoard() {
        final String BLANK_LINE = "........";

        StringBuilder sb = new StringBuilder();
        sb.append(appendNewLine(BLANK_LINE))
                .append(appendNewLine(getBlackPawnsResult()))
                .append(appendNewLine(BLANK_LINE))
                .append(appendNewLine(BLANK_LINE))
                .append(appendNewLine(BLANK_LINE))
                .append(appendNewLine(BLANK_LINE))
                .append(appendNewLine(getWhitePawnsResult()))
                .append(appendNewLine(BLANK_LINE));

        return sb.toString();
    }
}
