public class Fraction
{
    // Instance variables
    int numerator;
    int denominator;

    // Constructors for various user inputs
    public Fraction(int numerator, int denominator)
    {
        if ((numerator < 0 && denominator < 0) || (denominator < 0))
        {
            numerator = numerator * -1;
            denominator = denominator * -1;
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction(int numerator)
    {
        this.numerator = numerator;
        denominator = 1;
    }

    public Fraction()
    {
        numerator = 0;
        denominator = 1;
    }

    // Methods
    public int getNumerator()
    {
        return numerator;
    }

    public int getDenominator()
    {
        return denominator;
    }

    public String toString()
    {
        if (denominator == 1)
        {
            return String.valueOf(numerator);
        }

        return String.valueOf(numerator) + "/" + String.valueOf(denominator);
    }

    public Double toDouble()
    {
        return (double)(numerator / denominator);
    }

    public Fraction add(Fraction other)
    {
        int newNumerator = numerator * other.getDenominator() + denominator * other.getNumerator();
        int common = denominator * other.getDenominator();
        Fraction answer = new Fraction(newNumerator, common);
        answer.toLowestTerms();
        return answer;
    }

    public Fraction subtract(Fraction other)
    {
        int newNumerator = numerator * other.getDenominator() - denominator * other.getNumerator();
        int common = denominator * other.getDenominator();
        Fraction answer = new Fraction(newNumerator, common);
        answer.toLowestTerms();
        return answer;
    }

    public Fraction multiply(Fraction other)
    {
        int newNumerator = numerator * other.getNumerator();
        int newDenominator = denominator * other.getDenominator();
        Fraction answer = new Fraction(newNumerator, newDenominator);
        answer.toLowestTerms();
        return answer;
    }

    public Fraction divide(Fraction other)
    {
        try
        {
            int answer = (numerator * other.getDenominator()) / (denominator * other.getNumerator());
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Division by 0 is undefined over this group.");
        }

        int newNumerator = numerator * other.getDenominator();
        int newDenominator = denominator * other.getNumerator();
        Fraction answer = new Fraction(newNumerator, newDenominator);
        answer.toLowestTerms();
        return answer;
    }

    public boolean equals(Object o)
    {
        Fraction other = (Fraction) o;
        if(numerator == other.getNumerator() && denominator == other.getDenominator())
        {
            return true;
        }
        return false;
    }

    public void toLowestTerms()
    {
        int gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
    }

    public static int gcd(int num, int den)
    {
        if (den == 0)
        {
            return num;
        }
        return gcd(den, num % den);
    }

}