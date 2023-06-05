package pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PawnTest {
    @DisplayName("흰색 폰이 생성되어야 한다")
    @Test
    void create() {
        Pawn pawn = new Pawn("while");
        assertThat(pawn.getColor()).isEqualTo("while");
    }
}