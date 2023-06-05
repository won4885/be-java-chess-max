package chess;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pieces.Pawn;

import static org.assertj.core.api.Assertions.assertThat;
import static pieces.PieceColor.BLACK_COLOR;
import static pieces.PieceColor.WHITE_COLOR;

class BoardTest {
    @DisplayName("Pawn을 체스 판에 추가할 수 있다.")
    @Test
    void create() {
        final Board board = new Board();

        // white
        final Pawn white = new Pawn(WHITE_COLOR);
        board.add(white);

        assertThat(1).isEqualTo(board.size());
        assertThat(white).isEqualTo(board.findPawn(0));

        // black
        final Pawn black = new Pawn(BLACK_COLOR);
        board.add(black);

        assertThat(2).isEqualTo(board.size());
        assertThat(black).isEqualTo(board.findPawn(1));
    }
}