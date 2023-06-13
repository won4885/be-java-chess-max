package chess;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {
    @DisplayName("특정 위치에 말을 추가할 수 있다.")
    @Test
    public void create() {
        Position position = new Position("a1");

        assertThat(1).isEqualTo(position.getX());
        assertThat(1).isEqualTo(position.getY());

        assertThat(0).isEqualTo(position.getIndexOfX());
        assertThat(0).isEqualTo(position.getIndexOfY());
    }
}