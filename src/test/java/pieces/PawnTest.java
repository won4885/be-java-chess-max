package pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static pieces.PieceColor.BLACK_PIECE;
import static pieces.PieceColor.WHITE_PIECE;

class PawnTest {
    @DisplayName("흰색 폰과 검은색 폰만이 생성되어야 한다")
    @Test
    void create() {
        final Pawn pawn1 = new Pawn(WHITE_PIECE);
        final Pawn pawn2 = new Pawn(BLACK_PIECE);

        assertAll(() -> assertThat(pawn1.getColor()).isEqualTo(WHITE_PIECE),
                () -> assertThat(pawn2.getColor()).isEqualTo(BLACK_PIECE),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> assertThat(new Pawn("orange"))));
    }

    @DisplayName("색이 없는 폰을 생성하는 경우 흰색 말을 생성한다")
    @Test
    void create_기본생성자() {
        Pawn pawn = new Pawn();
        assertThat(WHITE_PIECE).isEqualTo(pawn.getColor());
    }
}