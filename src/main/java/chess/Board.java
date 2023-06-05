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

    public Pawn findWhitePawn(final int index) {
        return whitePawns.get(index);
    }

    public Pawn findBlackPawn(final int index) {
        return blackPawns.get(index);
    }

    public void initialize() {
        for (int i = 0; i < BOARD_LENGTH; i++) {
            addWhitePawns(new Pawn());
            addBlackPawns(new Pawn(BLACK_COLOR, BLACK_REPRESENTATION));
        }
    }

    public String getWhitePawnsResult() {
        StringBuilder white = new StringBuilder();
        for (Pawn whitePawn : whitePawns) {
            white.append(whitePawn.getRepresentation());
        }

        return white.toString();
    }

    public String getBlackPawnsResult() {
        StringBuilder black = new StringBuilder();
        for (Pawn blackPawn : blackPawns) {
            black.append(blackPawn.getRepresentation());
        }

        return black.toString();
    }
}
