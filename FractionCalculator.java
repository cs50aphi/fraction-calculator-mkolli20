import java.util.*;

public class FractionCalculator
{
    public static void main(String[] args)
    {
        Scanner kb = new Scanner(System.in);
        Fraction one;
        Fraction two;
        Fraction ans;
        String operation;
        boolean quit = false;

        System.out.println("Welcome to the Fraction Calculator!");
        System.out.println("It will add, subtract, multiply, and divide fractions until you type Q to quit.");
        System.out.println("Please enter your fractions in the form a/b where a and b are both integers.");


        while(!quit)
        {

        }



    }
}


public static String getOperation(Scanner kb)
{

    String validOperations = "+-/*=qQ";
    String operation = kb.nextLine();

    if(operation.length()==1)
    {
        if(validOperations.indexOf(operation) >= 0)
        {
            return operation;
        }
        else
        {
            System.out.println("Invalid Input");
            return getOperation(kb);
        }
    }
    else
    {
        System.out.println("Invalid Input");
        return getOperation(kb);
    }

}


public static Boolean validFraction(String input)
{
    
}
