package chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pieces.Piece;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static pieces.Piece.Color.BLACK;
import static pieces.Piece.Color.WHITE;
import static pieces.Piece.Type.*;
import static utils.StringUtils.appendNewLine;

class BoardTest {
    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
    }

    @DisplayName("전체 체스판의 전체 상태를 알 수 있다.")
    @Test
    void create() {
        board.initialize();

        String blankRank = appendNewLine("........");

        assertThat(appendNewLine("RNBQKBNR") +
                appendNewLine("PPPPPPPP") +
                blankRank + blankRank + blankRank + blankRank +
                appendNewLine("pppppppp") +
                appendNewLine("rnbqkbnr"))
                .isEqualTo(board.showBoard());
    }

    @Test
    void print() {
        board.initialize();
        System.out.println("board.showBoard()\n" + board.showBoard());
    }

    @DisplayName("각 색깔과 타입을 카운트할 수 있다.")
    @Test
    void countPieceByColorAndType() {
        board.initialize();

        assertThat(8).isEqualTo(board.countPieceByColorAndType(WHITE, PAWN));
        assertThat(2).isEqualTo(board.countPieceByColorAndType(BLACK, KNIGHT));
        assertThat(1).isEqualTo(board.countPieceByColorAndType(BLACK, KING));
    }

    @DisplayName("각각의 말을 찾을 수 있다.")
    @Test
    void findPiece() {
        board.initialize();

        assertThat(Piece.createBlackRook()).isEqualTo(board.findPiece("a8"));
        assertThat(Piece.createBlackRook()).isEqualTo(board.findPiece("h8"));
        assertThat(Piece.createWhiteRook()).isEqualTo(board.findPiece("a1"));
        assertThat(Piece.createWhiteRook()).isEqualTo(board.findPiece("h1"));
    }

    @DisplayName("말을 움직일 수 있다.")
    @Test
    void move() {
        board.initialize();

        String position = "b5";
        Piece blackRook = Piece.createBlackRook();
        board.move(position, blackRook);

        assertThat(blackRook).isEqualTo(board.findPiece(position));
        System.out.println("board.showBoard()\n" + board.showBoard());
    }

    @DisplayName("점수를 계산할 수 있다.")
    @Test
    void calculatePoint() {
        board.initialize();

        board.move("b6", Piece.createBlackPawn());
        board.move("e6", Piece.createBlackQueen());
        board.move("b8", Piece.createBlackKing());
        board.move("c8", Piece.createBlackRook());
        board.move("f2", Piece.createWhitePawn());
        board.move("g2", Piece.createWhitePawn());
        board.move("e1", Piece.createWhiteRook());
        board.move("f1", Piece.createWhiteKing());

        assertEquals(15.0, board.calculatePoint(BLACK), 0.01);
        assertEquals(7.0, board.calculatePoint(WHITE), 0.01);

        System.out.println("board.showBoard()\n" + board.showBoard());
    }
}