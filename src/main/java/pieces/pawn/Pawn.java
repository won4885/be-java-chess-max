package pieces.pawn;

import lombok.Getter;

import static pieces.pawn.PawnColor.BLACK_PAWN;
import static pieces.pawn.PawnColor.WHITE_PAWN;

@Getter
public class Pawn {
    private final String color;

    public Pawn() {
        this.color = WHITE_PAWN;
    }

    public Pawn(String color) {
        validatePawnColor(color);
        this.color = color;
    }

    /**
     * black 또는 white 색상이 아닌 경우 예외를 던짐
     * TODO: 던진 예외를 처리해야 함
     */
    private void validatePawnColor(final String color) {
        if (!color.equals(BLACK_PAWN) && !color.equals(WHITE_PAWN)) {
            throw new IllegalArgumentException("[ERROR] black 또는 white 폰을 입력해야 합니다. color: " + color);
        }
    }
}
