package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(2, Calculator.add("2"));
		assertEquals(5, Calculator.add("5"));
	}
	
	@Test
	public void testTwoNumbers() {
		assertEquals(2+5, Calculator.add("2,5"));
		assertEquals(8+7, Calculator.add("8,7"));
	}
	
	@Test
	public void testUnknownNumberOfNumbers() {
		assertEquals(2+5+7+3, Calculator.add("2,5,7,3"));
		assertEquals(8+7+1+2+6+4, Calculator.add("8,7,1,2,6,4"));
	}
}