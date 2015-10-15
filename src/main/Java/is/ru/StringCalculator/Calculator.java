package is.ru.stringcalculator;
import java.util.ArrayList;

public class Calculator {

public static int add(String text){
	if(text.equals(""))
	{
		return 0;
	}
	return sum(splitNumbers(text, "[^-0-9]"));			
 }

private static String[] splitNumbers(String numbers, String delimeter){
    return numbers.split(delimeter);
}

private static int sum(String[] numbers){
	int total = 0;
	
    for(String number : numbers){
    	if (!number.isEmpty())
    	{
    		checkForNegatives(numbers);
            if (checkOverThousand(number)) 
            {
            	total += Integer.parseInt(number);
            }
    	}
	}
	return total;
  }

private static void checkForNegatives(String[] numbers){
ArrayList<Integer> negativeNumbers = new ArrayList<Integer>();
	
    for(String number : numbers){
    	if (!number.isEmpty())
    	{
    		int numberChecked = Integer.parseInt(number);
            if (numberChecked < 0) 
            {
                negativeNumbers.add(numberChecked);
            }
    	}
	}
    if (negativeNumbers.size() > 0) {
        throw new RuntimeException("Negatives not allowed: " + negativeNumbers.toString());
    }
 }

private static boolean checkOverThousand(String number){
	if(Integer.parseInt(number) <= 1000)
	{
		return true;
	}
  return false;
 }
}