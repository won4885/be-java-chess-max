package pieces;

import lombok.Getter;

import static pieces.PieceColor.BLACK_PIECE;
import static pieces.PieceColor.WHITE_PIECE;

@Getter
public class Pawn {
    private final String color;

    public Pawn() {
        this.color = WHITE_PIECE;
    }

    public Pawn(final String color) {
        validatePawnColor(color);
        this.color = color;
    }

    /**
     * black 또는 white 색상이 아닌 경우 예외를 던짐
     * TODO: 던진 예외를 처리해야 함
     */
    private void validatePawnColor(final String color) {
        if (!color.equals(BLACK_PIECE) && !color.equals(WHITE_PIECE)) {
            throw new IllegalArgumentException("[ERROR] black 또는 white 폰을 입력해야 합니다. color: " + color);
        }
    }
}
