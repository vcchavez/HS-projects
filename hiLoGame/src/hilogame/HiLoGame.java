package hilogame;

/**
 *
 * @author vcchavez 
 */
public class HiLoGame
{
    private int randomNum;
    private int guessCount;
    private int wager;
    /** Creates a new instance of HiLoGame */
    public HiLoGame()
    {
        randomNum = (int) (1 + Math.random()*100); 
        guessCount = 0;
        wager = 100;
    }
    
    public int getRandomNum()
    {
        return randomNum;
    }
    
    public int getCount()
    {
        return guessCount;
    }

    public int getWager()
    {
        return wager;
    }
    
    public int guess(int userGuess)
    {
         /* if userGuess is less than randomNum return -1;
         * if userGuess is equal to randomNum return 0;
         * if userGuess is greater than randomNum return 1; 
          *increments guessCount;
         */
           //while (userGuess != randomNum)

            wager--;
            guessCount++;
            

            if (userGuess < randomNum)
            {
                return -1;
            }
            else if (userGuess == randomNum)
            {
                return 0;
            }
            else
            {
            return 1;
            }

        
    }
    
}
