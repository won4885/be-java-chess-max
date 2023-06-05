package pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pieces.pawn.Pawn;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static pieces.pawn.PawnColor.BLACK_PAWN;
import static pieces.pawn.PawnColor.WHITE_PAWN;

class PawnTest {
    @DisplayName("흰색 폰과 검은색 폰만이 생성되어야 한다")
    @Test
    void create() {
        final Pawn pawn1 = new Pawn(WHITE_PAWN);
        final Pawn pawn2 = new Pawn(BLACK_PAWN);

        assertAll(() -> assertThat(pawn1.getColor()).isEqualTo(WHITE_PAWN),
                () -> assertThat(pawn2.getColor()).isEqualTo(BLACK_PAWN),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> assertThat(new Pawn("orange"))));
    }

    @DisplayName("색이 없는 폰을 생성하는 경우 흰색 말을 생성한다")
    @Test
    void create_기본생성자() {
        Pawn pawn = new Pawn();
        assertThat(WHITE_PAWN).isEqualTo(pawn.getColor());
    }
}