/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package evilhang;

import java.util.Scanner;

/**
 *
 * @author vcchavez
 */
public class EvilHangGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("How long would you like your word to be? Enter a number and press enter: ");
        String wordLength = keyboard.next();
        EvilHang game = new EvilHang(Integer.parseInt(wordLength),10);
        System.out.println(game.initialWord());

        while(game.isGameOver()==false)
        {
            System.out.print ("Enter a letter and press enter: ");
            String letter = keyboard.next();

            while (game.alreadyGuessed(letter)==true)
            {
                System.out.print ("You've already guessed that. Enter a letter and press enter: ");
                letter = keyboard.next();
            }

            game.posToMap(letter);
            game.biggestKey();

            System.out.println(game.wordAfterGuess());
        }
        System.out.println(game.displayAnswer());
    }
}
