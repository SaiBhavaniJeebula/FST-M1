package examples;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import mainPrograms.Calculator;

class CalculatorTest {

	private Calculator calculator;
	
	@BeforeEach
    public void setUp() throws Exception {
        calculator = new Calculator();
    }
 
    @Test
    @DisplayName("Simple multiplication should work")
    public void testMultiply() {
        assertEquals(20, calculator.multiply(4, 5));
    }

}
