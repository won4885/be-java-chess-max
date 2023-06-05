package chess;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pieces.Pawn;

import static org.assertj.core.api.Assertions.assertThat;
import static pieces.PieceColor.BLACK_PIECE;
import static pieces.PieceColor.WHITE_PIECE;

class BoardTest {
    @DisplayName("Pawn을 체스 판에 추가할 수 있다.")
    @Test
    void create() {
        Board board = new Board();

        // white
        Pawn white = new Pawn(WHITE_PIECE);
        board.add(white);

        assertThat(1).isEqualTo(board.size());
        assertThat(white).isEqualTo(board.findPawn(0));

        // black
        Pawn black = new Pawn(BLACK_PIECE);
        board.add(black);

        assertThat(2).isEqualTo(board.size());
        assertThat(black).isEqualTo(board.findPawn(1));
    }
}