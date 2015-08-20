/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package evilhang;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author vcchavez
 */
public class EvilHang 
{
    private int pLength;
    private ArrayList<String> wordList;
    private ArrayList<String> guessedLetters;
    private ArrayList<String> biggest;
    private String word;
    private int guessCount;
    private String positions;
    private int astCount;
    private Map positionMap;
    private ArrayList<String> keysets;
    private ArrayList<String> largestArrayList;
    private String largestKey;
    private String guessedWord;
    private String guessedLetter;
    private String front;
    private String back;
    private String gameOver;
    private String afterGuess;
    private String toReturn;
    
    
    public EvilHang(int pLength, int userGuessRequest)
    {
        wordList = new ArrayList<String>();
        guessedLetters = new ArrayList<String>();
        biggest=wordList;
        word="";
        guessCount=userGuessRequest;
        astCount=pLength;
        
        try
        {
            File file = new File("500words.txt");
            Scanner scan = new Scanner(file);
            while(scan.hasNext())
            {
                String temp= scan.next();
                if(temp.length()==pLength)
                {
                    wordList.add(temp.toLowerCase());
                }
            }
            scan.close();
            if(wordList.isEmpty())
            {
                System.err.println("Invalid word length. Please restart and try again.");
                System.exit(-1);
            }

        }
        catch(FileNotFoundException e)
        {
            System.err.println("Error: " +e);
        }
    }
    public String getWordList()
    {
        return "Word list: " + wordList + "\n" + "Word list Size: " + wordList.size();
    }
    public String initialWord()
    {
        for(int temp=0; temp<astCount; temp++) //TRY TO KEEP EVERYTHING PASSED THIS
        {
            word=word+"*";
        }
        guessedWord=word;
        return word;
    }
    public String getPosition(String letter, String word)
    {
        positions="";
        guessedLetter=letter;
            for(int i=0; i<word.length(); i++)
            {
                if(letter.charAt(0)==word.charAt(i))
                {
                    if(positions.isEmpty())
                    {
                        positions=positions+i;
                    }
                    else
                    {
                        positions=positions+","+i;
                    }
                }
            }
        return positions;
    }
    public boolean alreadyGuessed(String letter)
    {
        if(guessedLetters.contains(letter))
        {
            return true;
        }
        else
        {
            guessedLetters.add(letter);
            Collections.sort(guessedLetters);
            return false;
        }
    }
    public Map posToMap(String character)
    {
        positionMap=new TreeMap<String,ArrayList<String>>();
        for (String temp:wordList)
        {
            String pos=this.getPosition(character, temp);
            if(positionMap.containsKey(pos))
            {
                ArrayList<String> value=(ArrayList<String>)positionMap.get(pos);
                value.add(temp);
                positionMap.put(pos, value);
            }
            else
            {
                ArrayList<String> value= new ArrayList<String>();
                value.add(temp);
                positionMap.put(pos, value);
            }
        }
        return positionMap;
    }
    public String biggestKey()
    {
        int largest=0;
        largestKey="";
        for(Object key:positionMap.keySet())
        {
            ArrayList<String> value=(ArrayList<String>)positionMap.get(key);
            if(value.size()>largest)
            {
                largest=value.size();
                largestArrayList=value;
                largestKey=(String)key;
            }
        }
        wordList=largestArrayList;
        
        if(largestKey.isEmpty())
        {
            toReturn = "Largest ArrayList: "+largestArrayList + "\n" + "Largest key: *";
        }
        else
        {
            toReturn = "Largest ArrayList: "+largestArrayList + "\n" + "Largest key: "+largestKey;
        }
        return toReturn;
    }
    public String wordAfterGuess()
    {
        //only do this if keysey!=empty
        if (largestKey.isEmpty()==false)
        {
            String[] pos = largestKey.split(",");
            for(int i=0; i<pos.length; i++)
            {
            int num=Integer.parseInt(pos[i]);
            front=guessedWord.substring(0,num);
            back=guessedWord.substring(num+1);
            guessedWord=front+guessedLetter+back;
            }
            afterGuess="Guesses Left: "+guessCount+"\n"+guessedWord;
        }
        else
        {
            guessCount--;
            afterGuess="\n"+"Guesses Left:"+guessCount+"\n"+"Guessed Letters: "+guessedLetters+"\n"+guessedWord;
        }
        //if keyset is emoty then guessCount-- 
        //create a string so that each return is different for the different cases.
        return afterGuess;
    }
    public boolean doWordsMatch()
    {
        //insert else if here that returns true if the ONLY REMAINING word in the arrayList matches the guessedWord
        if(guessedWord.equalsIgnoreCase(wordList.get(0)))
        {
            return true;
        } 
        else
        {
            return false;
        }
            
    }
    public boolean isGameOver()
    {
        if(guessCount==0)
        {
            return true;
        }
        else if(wordList.size()==1&&doWordsMatch()==true)//insert else if here that returns true if the ONLY REMAINING word in the arrayList matches the guessedWord
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public String displayAnswer()
    {
        if(guessCount==0)
        {
            gameOver="Sorry! You have no more guesses left. The correct word was " + wordList.get(0).toUpperCase()+". Please play again.";
        }
        //insert else if here that returns a string congraatulating player only if the ONLY REMAINING word in the arrayList matches the guessedWord
        else
        {
            gameOver="Congratulations! The correct word was "+guessedWord.toUpperCase()+"! Please play again.";
        }
        return gameOver;
    }
    public boolean displayMagic(String yorn)
    {
        if(yorn.equalsIgnoreCase("y"))
        {
            return true;
        }
        else 
        {
            return false;
        }
    }
}
