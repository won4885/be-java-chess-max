package pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PieceTest {
    @DisplayName("흰색 폰과 검은색 폰만이 생성되어야 한다")
    @Test
    void create_piece() {
        validatePiece(Piece.createWhitePawn(), Piece.WHITE_COLOR, Piece.WHITE_PAWN_REPRESENTATION);
        validatePiece(Piece.createBlackPawn(), Piece.BLACK_COLOR, Piece.BLACK_PAWN_REPRESENTATION);
    }

    private void validatePiece(final Piece piece, final String color, final char representation) {
        assertThat(color).isEqualTo(piece.getColor());
        assertThat(representation).isEqualTo(piece.getRepresentation());
    }
}