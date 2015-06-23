import java.text.NumberFormat;
import java.util.Scanner;

/**
 * The Player class is to creat a file of 
 * the game player.
 * This class has 4 fields, the player's own name,
 * the number of the player's wins and the number of his losses,
 * and the number of his total winning.
 * As easy to see, the player's name is a String, 
 * and the numbers of wins & losses, and total winning are all integers.
 * 
 * @author Jing Guo 
 * @version Assignment 1 of FIT5131(due day: 12/9/2014)
 */

public class Player
{
    // the player's name.
    private String name;
    // the number of his wins.
    private int numberOfWins;
    // the number of his losses.
    private int numberOfLosses;
    // the money of the total winning.
    private int totalWinning;

    /**
     * Constructor for objects of class Player
     */
    public Player()
    {
        // create a new player.
        name = null;
        numberOfWins = 0;
        numberOfLosses = 0;
        totalWinning = 0;
    }
    
    /**
     * Display the number of losses
     */
    public int getLossNumber()
    {
        return numberOfLosses;
    }
    
    /**
     * Display the player's name
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Calculate the number of total winning
     */
    public int getTotalOfWinning()
    {
        return totalWinning;
    }
    
    /**
     * Display the number of wins
     */
    public int getWinNumber()
    {
        return numberOfWins;
    }
    
    /**
     * When the player losses, lossNumber + 1
     */
    public void lossOneRound()
    {
        numberOfLosses++;
    }
    
    /**
     * Change the number of losses
     */
    public void setLossNumber(int newNumOfLosses)
    {
        numberOfLosses = newNumOfLosses;
    }
    
    /**
     * Set up a player by entering his/her name
     */
    public void setName(String newName)
    {
        name = newName;
    }
    
    /**
     * Change the number of total winning
     */
    public void setTotalOfWinning(int newTotalOfWinning)
    {
        totalWinning = newTotalOfWinning;
    }
    
    /**
     * Change the number of wins
     */
    public void setWinNumber(int newNumOfWins)
    {
        numberOfWins = newNumOfWins;
    }
    
    /**
     * When the player wins, numberOfWins + 1, 
     * the int money is about how much can the player win.
     */
    public void winOneRound(int money)
    {
        numberOfWins++;
        totalWinning += money;
    }
}
