/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nameapp;

/**
 *
 * @author vcchavez
 */
public class Name {
    private String first;
    private String last;

    //default constructor
    public Name()
    {
        first = "";
        last = "";
    }
    //consturctor
    public Name(String f, String l)
    {
        first = f;
        last = l;
    }

    public String toString()
    {
        return first + " " + last;
    }

    public String reformat()
    {
        String rename = last + ", " + first;
        return rename;
    }

    public String reverse()
    {
        String backWord = "";
        String name = this.toString();

        for (int index = name.length()-1; index >= 0; index--)
        {
            char letter = name.charAt(index);
            backWord = backWord + letter;
        }
        return backWord;
    }
}
