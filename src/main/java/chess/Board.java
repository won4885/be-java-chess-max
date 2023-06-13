package chess;

import pieces.Piece;

import java.util.ArrayList;
import java.util.List;

import static utils.StringUtils.appendNewLine;

public class Board {
    private static final int BOARD_LENGTH = 8;
    private static int pieceCount = 0;
    private final List<List<Piece>> pieces = new ArrayList<>();

    public Board() {
    }

    public void initialize() {
        pieces.add(initializeBlackPieces());
        pieces.add(initializeBlackPawns());
        pieces.add(initializeBlankLine());
        pieces.add(initializeBlankLine());
        pieces.add(initializeBlankLine());
        pieces.add(initializeBlankLine());
        pieces.add(initializeWhitePawns());
        pieces.add(initializeWhitePieces());
    }

    private List<Piece> initializeWhitePieces() {
        pieceCount += 8;

        List<Piece> whitePieces = new ArrayList<>();
        whitePieces.add(Piece.createWhiteRook());
        whitePieces.add(Piece.createWhiteKnight());
        whitePieces.add(Piece.createWhiteBishop());
        whitePieces.add(Piece.createWhiteQueen());
        whitePieces.add(Piece.createWhiteKing());
        whitePieces.add(Piece.createWhiteBishop());
        whitePieces.add(Piece.createWhiteKnight());
        whitePieces.add(Piece.createWhiteRook());

        return whitePieces;
    }

    private List<Piece> initializeBlackPieces() {
        pieceCount += 8;

        List<Piece> blackPieces = new ArrayList<>();
        blackPieces.add(Piece.createBlackRook());
        blackPieces.add(Piece.createBlackKnight());
        blackPieces.add(Piece.createBlackBishop());
        blackPieces.add(Piece.createBlackQueen());
        blackPieces.add(Piece.createBlackKing());
        blackPieces.add(Piece.createBlackBishop());
        blackPieces.add(Piece.createBlackKnight());
        blackPieces.add(Piece.createBlackRook());

        return blackPieces;
    }

    private List<Piece> initializeWhitePawns() {
        List<Piece> whitePawns = new ArrayList<>();
        for(int i = 0; i < BOARD_LENGTH; i++) {
            whitePawns.add(Piece.createWhitePawn());
            pieceCount++;
        }

        return whitePawns;
    }

    private List<Piece> initializeBlackPawns() {
        List<Piece> blackPawns = new ArrayList<>();
        for(int i = 0; i < BOARD_LENGTH; i++) {
            blackPawns.add(Piece.createBlackPawn());
            pieceCount++;
        }

        return blackPawns;
    }

    private List<Piece> initializeBlankLine() {
        List<Piece> blankLines = new ArrayList<>();
        for(int i = 0; i < BOARD_LENGTH; i++) {
            blankLines.add(Piece.createBlank());
        }

        return blankLines;
    }

    public String showBoard() {
        StringBuilder sb = new StringBuilder();
        for (List<Piece> rank : pieces) {
            sb.append(showRank(rank));
        }

        return sb.toString();
    }

    private String showRank(List<Piece> rank) {
        StringBuilder sb = new StringBuilder();
        for (Piece piece : rank) {
            sb.append(piece.getRepresentation());
        }

        return appendNewLine(sb.toString());
    }

    public int pieceCount() {
        return pieceCount;
    }
}
