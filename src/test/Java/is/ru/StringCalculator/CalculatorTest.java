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
	
	@Test
	public void testSpace() {
		assertEquals(2+5+7+3, Calculator.add("2\n5,7,3"));
		assertEquals(8+7+1+2+6+4, Calculator.add("8,7,1,2\n6,4"));
	}
	
	@Test
	public void testDelimiter() {
	    assertEquals(3+6+10, Calculator.add("//;\n3;6;10"));
	}
	
	@Test
	public final void testExceptionForNegativeNumbers() {
	    RuntimeException exception = null;
	    try {
	        Calculator.add("4,2,9,-1,11,-15");
	    } catch (RuntimeException e) 
	    {
	        exception = e;
	    }
	    assertEquals("Negatives not allowed: [-1, -15]", exception.getMessage());
	}
	
	@Test
	public final void testIfNumbersOverThousandAreIgnored() {
	    assertEquals(5+2+1000, Calculator.add("5,2,1001,1000,2040"));
	}
	
	@Test
	public void testDelimiterOfAnyLength() {
	    assertEquals(5+9+8, Calculator.add("//[***]\n5***9***8"));
	}
	
	@Test
	public void testMultipleDelimeters() {
	    assertEquals(1+2+3, Calculator.add("//[*][%]\n1*2%3"));
	}
}