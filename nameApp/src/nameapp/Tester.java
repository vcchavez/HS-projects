/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nameapp;

/**
 *
 * @author vcchavez
 */
public class Tester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       System.out.println("Welcome back from Spring Break!");
       Name nm = new Name("Moe", "Howard");
        System.out.println("Name: " + nm);
        System.out.println(nm.reformat());
    }

}
