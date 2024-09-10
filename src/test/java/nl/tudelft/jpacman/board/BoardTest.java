package nl.tudelft.jpacman.board;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BoardTest {

    // Create a test class for Board in which you construct a board with the correct (1×1 is large enough) grid,
    // with a correct BasicSquare on it. Name your class BoardTest and put it in the src/test folder in the package nl.tudelft.jpacman.board.
    // Run your test. Since the board is valid your test should pass. Capture the screenshot of your test result and paste below.
    @Test
    void test1x1Board() {
        // Create a 1x1 grid with a BasicSquare
        Square[][] grid = new Square[1][1];
        grid[0][0] = new BasicSquare();

        // Create the board with the grid
        Board board = new Board(grid);

        // Assert that the board has the correct width and height
        assertThat(board.getWidth()).isEqualTo(1);
        assertThat(board.getHeight()).isEqualTo(1);

        // Assert that the square at (0, 0) is the BasicSquare we created
        assertThat(board.squareAt(0, 0)).isEqualTo(grid[0][0]);
    }

    // Create a second test case in which you construct a similar board, but with just one null square.
    // For both, write a test for the squareAt method. With what exception does your test fail?
    @Test
    void test1x1BoardWithNullSquare() {
        // Create a 1x1 grid with a null square
        Square[][] grid = new Square[1][1];
        grid[0][0] = null;

        // Assert that creating a board with a null square throws an AssertionError
        assertThrows(AssertionError.class, () -> {
            new Board(grid);
        });
    }

}
