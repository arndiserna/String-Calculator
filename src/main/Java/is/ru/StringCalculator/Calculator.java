package is.ru.stringcalculator;

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
	
    for(String number : numbers){
    	if (!number.isEmpty())
    	{
    		total += Integer.parseInt(number);
    	}
	}
	return total;
}
}