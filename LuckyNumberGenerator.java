
/**
 * The LuckyNumberGenerator class is to creat a machine 
 * which can create a random integer between 1 and 100.
 * I use the code "Math.random()" to let the system 
 * choose the random integer.
 * 
 * @author Jing Guo 
 * @version Assignment 1 of FIT5131(due day: 12/9/2014)
 */
public class LuckyNumberGenerator
{
    // the lucky number.
    private int luckyNumber;

    /**
     * Constructor for objects of class LuckyNumberGenerator
     */
    public LuckyNumberGenerator()
    {
        luckyNumber = 0;
    }
    
    /**
     * get a random lucky number.
     */
    public int getLuckyNumber()
    {
       luckyNumber = (int) (Math.random() * 100 + 1);//create a random integer 
                                                     //between 1 and 100(include 1 and 100)
       return luckyNumber;
    }
    
    /**
     * set a lucky number.
     */
    public void setLuckyNumber(int newLuckyNumber)
    {
        luckyNumber = newLuckyNumber;
    }
}