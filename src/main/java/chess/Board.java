package chess;

import pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final List<Pawn> board = new ArrayList<>();

    public Board() {
    }

    public void add(final Pawn pawn) {
        board.add(pawn);
    }

    public int size() {
        return board.size();
    }

    public Pawn findPawn(final int index) {
        return board.get(index);
    }
}
