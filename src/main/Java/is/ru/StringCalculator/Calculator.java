package is.ru.stringcalculator;
import java.util.ArrayList;

public class Calculator {

public static int add(String text) 
{
	String delimiter = ",|\n";
	String numbers = text;
	    if (text.startsWith("//")) 
	    {
	        int delimiterIndex = text.indexOf("//") + 2;
	        delimiter = text.substring(delimiterIndex, delimiterIndex + 1);
	        numbers = text.substring(text.indexOf("\n") + 1);
	    }
	   return add(numbers, delimiter);
	}

public static int add(String text, String delimeter)
 {
	if(text.equals(""))
	{
		return 0;
	}
	return sum(splitNumbers(text, delimeter));			
 }

private static String[] splitNumbers(String numbers, String delimeter){
    return numbers.split(delimeter);
}

private static int sum(String[] numbers){
	int total = 0;
	ArrayList<Integer> negativeNumbers = new ArrayList<Integer>();
	
    for(String number : numbers){
    	if (!number.isEmpty())
    	{
    		int numberChecked = Integer.parseInt(number);
            if (numberChecked < 0)
			{
                negativeNumbers.add(numberChecked);
            }
    		else if (numberChecked <= 1000) 
            {
            	total += numberChecked;
            }
    	}
	}
    if (negativeNumbers.size() > 0) {
        throw new RuntimeException("Negatives not allowed: " + negativeNumbers.toString());
    }
	return total;
 }
}