package is.ru.stringcalculator;

public class Calculator {

public static int add(String text)
 {
	int value = 0;
    String[] numberArray = text.split(",");
    
    for (String number : numberArray)
    {
        if (!number.isEmpty()) 
        {
            value += Integer.parseInt(number);
        }
    }
    return value;	
 }
}