package io.javabrains;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import org.junit.jupiter.api.*;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("When running MathUtils")
class MathUtilsTest {
    MathUtils mathUtils;

    @BeforeEach
    void init () {
        mathUtils = new MathUtils();
    }

    @Nested
    @DisplayName("add method")
    class AddTest {

        @Test
        @DisplayName("when adding two positive numbers")
        void testAddPositive() {
            assertEquals(2, mathUtils.add(1, 1), "should return the right sum");
        }

        @Test
        @DisplayName("when adding two positive numbers")
        void testAddNegative() {
            int expected = -2;
            int actual = mathUtils.add(-1, -1);
            assertEquals(expected, actual, () -> "should return sum" + expected + "but returned " + actual);
        }
    }

    @Test
    @DisplayName("multiply method")
    void testMultiply() {
        assertAll(
                () -> assertEquals(4, mathUtils.multiply(2, 2)),
                () -> assertEquals(0, mathUtils.multiply(2, 0)),
                () -> assertEquals(-2, mathUtils.multiply(2, -1))
                );
    }

    @Test
    @DisplayName("divide method")
    void testDivide() {
        assertThrows(ArithmeticException.class, () -> mathUtils.divide(1,0), "throws when divided by zero");
    }

    @RepeatedTest(3)
    void testComputerCircleRadius(RepetitionInfo repetitionInfo) {
        assertEquals(314.1592653589793, mathUtils.computeCircleArea(10), "Should return right circle area");
    }


    @Test
    @Disabled
    @DisplayName("TDD method. Should not run")
    void testDisabled() {
        fail("This test should be disabled");
    }
    //test
}