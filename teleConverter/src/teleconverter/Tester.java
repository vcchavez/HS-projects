/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package teleconverter;

/**
 *
 * @author DYanek
 */
public class Tester 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        TeleConverter tv = new TeleConverter("800","Com","Cast");
        System.out.println("" + tv);
        System.out.println("converted: " + tv.convert());
    }

}
