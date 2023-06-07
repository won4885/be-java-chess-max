package pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static pieces.PieceColor.*;

class PieceTest {
    @DisplayName("흰색 폰과 검은색 폰만이 생성되어야 한다")
    @Test
    void create() {
        validatePawn(WHITE_COLOR, WHITE_REPRESENTATION);
        validatePawn(BLACK_COLOR, BLACK_REPRESENTATION);
    }

    private void validatePawn(final String color, final char representation) {
        final Piece piece = new Piece(color, representation);
        assertThat(color).isEqualTo(piece.getColor());
        assertThat(representation).isEqualTo(piece.getRepresentation());
    }

    @DisplayName("색이 없는 폰을 생성하는 경우 흰색 말을 생성한다")
    @Test
    void create_기본생성자() {
        final Piece piece = new Piece();
        assertThat(WHITE_COLOR).isEqualTo(piece.getColor());
        assertThat(WHITE_REPRESENTATION).isEqualTo(piece.getRepresentation());
    }
}