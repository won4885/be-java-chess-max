package pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PieceTest {
    @DisplayName("흰색 폰과 검은색 폰만이 생성되어야 한다")
    @Test
    void create_piece() {
        validatePiece(Piece.createWhitePawn(), Piece.createBlackPawn(), Piece.Type.PAWN);
        validatePiece(Piece.createWhiteKnight(), Piece.createBlackKnight(), Piece.Type.KNIGHT);
        validatePiece(Piece.createWhiteRook(), Piece.createBlackRook(), Piece.Type.ROOK);
        validatePiece(Piece.createWhiteBishop(), Piece.createBlackBishop(), Piece.Type.BISHOP);
        validatePiece(Piece.createWhiteQueen(), Piece.createBlackQueen(), Piece.Type.QUEEN);
        validatePiece(Piece.createWhiteKing(), Piece.createBlackKing(), Piece.Type.KING);

        Piece blank = Piece.createBlank();
        assertThat(blank.isWhite()).isFalse();
        assertThat(blank.isBlack()).isFalse();
        assertThat(Piece.Type.NO_PIECE).isEqualTo(blank.getType());
    }

    private void validatePiece(final Piece white, final Piece black, final Piece.Type type) {
        assertThat(white.isWhite()).isTrue();
        assertThat(type).isEqualTo(white.getType());

        assertThat(black.isBlack()).isTrue();
        assertThat(type).isEqualTo(black.getType());
    }

    @DisplayName("검은색 말과 흰색 말을 구분할 수 있다.")
    @Test
    void checkColor() {
        Piece whitePawn = Piece.createWhitePawn();
        assertThat(whitePawn.isWhite()).isTrue();
        assertThat('p').isEqualTo(whitePawn.getRepresentation());

        Piece blackPawn = Piece.createBlackPawn();
        assertThat(blackPawn.isBlack()).isTrue();
        assertThat('P').isEqualTo(blackPawn.getRepresentation());
    }
}