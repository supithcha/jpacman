package nl.tudelft.jpacman.board;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test suite to confirm that {@link Unit}s correctly (de)occupy squares.
 *
 * @author Jeroen Roosen 
 *
 */
class OccupantTest {

    /**
     * The unit under test.
     */
    private Unit unit;

    /**
     * Resets the unit under test.
     */
    @BeforeEach
    void setUp() {
        unit = new BasicUnit();
    }

    /**
     * Asserts that a unit has no square to start with.
     */
    @Test
    void noStartSquare() {
        // Remove the following placeholder:
        //assertThat(unit).isNotNull();

        // The noStartSquare() test asserts that a unit has no square to start with,
        // i.e., a unit “has no square” at the beginning
        assertThat(unit.hasSquare()).isFalse();
    }

    /**
     * Tests that the unit indeed has the target square as its base after
     * occupation.
     */
    @Test
    void testOccupy() {
        // Remove the following placeholder:
        // assertThat(unit).isNotNull();

        // The testOccupy() verifies that the unit indeed has the target square as its base after occupation.
        // In other words, if a unit is occupied by a(ny) basic square, then one should contain the other.

        // Create a square
        Square square = new BasicSquare();

        // Occupy the square with the unit
        unit.occupy(square);

        // Assert that the square has the unit as an occupant
        assertThat(square.getOccupants()).contains(unit);

        // Assert that the unit's square is the target square
        assertThat(unit.getSquare()).isEqualTo(square);
    }

    /**
     * Test that the unit indeed has the target square as its base after
     * double occupation.
     */
    @Test
    void testReoccupy() {
        // Remove the following placeholder:
        // assertThat(unit).isNotNull();

        // Finally, the testReoccupy() verifies that the unit indeed has the target square as its base after double occupation.
        // What happens if the unit is reoccupied by another square?

        // Create two squares
        Square square1 = new BasicSquare();
        Square square2 = new BasicSquare();

        unit.occupy(square1); // Initially occupy the first square

        // Assert that the unit occupies square1
        assertThat(unit.getSquare()).isEqualTo(square1);
        assertThat(square1.getOccupants()).contains(unit);

        unit.occupy(square2); // Reoccupy the second square

        assertThat(square1.getOccupants()).doesNotContain(unit);  // Assert that the unit no longer occupies square1

        // Assert that the unit occupies square2
        assertThat(unit.getSquare()).isEqualTo(square2);
        assertThat(square2.getOccupants()).contains(unit);
    }
}
