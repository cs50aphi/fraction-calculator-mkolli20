import java.util.*;

public class FractionCalculator
{
    public static void main(String[] args)
    {
        Scanner kb = new Scanner(System.in);
        Fraction first;
        Fraction second;
        Fraction ans;
        String operation;
        boolean quit = false;

        System.out.println("Welcome to the Fraction Calculator!");
        System.out.println("It will add, subtract, multiply, and divide fractions until you type Q to quit.");
        System.out.println("Please enter your fractions in the form a/b where a and b are both integers.");


        while(!quit)
        {
            operation = getOperation(kb);

            if (!operation.equals("q") && !operation.equals("Q"))
            {
                first = getFraction(kb);
                second = getFraction(kb);

                switch(operation)
                {
                    case "+":
                        ans = first.add(second);
                        System.out.println(first + " + " + second + " = " + " is " + ans);
                        break;

                    case "-":
                        ans = first.subtract(second);
                        System.out.println(first + " - " + second + " = " + " is " + ans);
                        break;

                    case "*":
                        ans = first.multiply(second);
                        System.out.println(first + " * " + second + " = " + " is " + ans);
                        break;

                    case "/":
                        ans = first.divide(second);
                        System.out.println(first + " / " + second + " = " + " is " + ans);
                        break;

                    case "=":
                        if (first.equals(second))
                        {
                            System.out.println(first + " is equal to " + second);
                        }
                        else
                        {
                            System.out.println(first + " is not equal to " + second);
                        }
                        break;
                }
            }
            else
            {
                System.out.println("Goodbye!");
                quit = true;
            }
        }
    }


public static String getOperation(Scanner kb)
{
    System.out.println("Please input an operation");

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
    // check if a negative appears after the division sign
    if(input.indexOf("-") > input.indexOf("/"))
    {
        return false;
    }

    int vinculum = input.indexOf("/");
    if(vinculum == -1)
    {
        String test = input.replaceAll("-","");
        if(!isNumber(test))
        {
            return false;
        }
        return true;
    }

    String numerator = input.substring(0, vinculum);
    String denominator = input.substring(vinculum + 1);

    if(!isNumber(numerator) || !isNumber(denominator) || denominator == String.valueOf('0'))
    {
        return false;
    }

    return true;
}

public static Fraction getFraction(Scanner kb)
{
    int numerator;
    int denominator;
    int vinculum;

    System.out.println("Please input a fraction");

    String fraction = kb.nextLine();

    if(validFraction(fraction))
    {
        if(fraction.indexOf("/") != -1)
        {
            vinculum = fraction.indexOf("/");
            numerator = Integer.parseInt(fraction.substring(0, vinculum));
            denominator = Integer.parseInt(fraction.substring(vinculum + 1));
            return new Fraction(numerator, denominator);
        }
        else
        {
            numerator = Integer.parseInt(fraction);
            return new Fraction(numerator);
        }
    }
    else
    {
        System.out.println("Invalid input, please try again");
        return getFraction(kb);
    }
}

public static Boolean isNumber(String test)
{
    try
    {
        Integer.parseInt(test);
        return true;
    }
    catch (NumberFormatException e)
    {
        return false;
    }
}

}