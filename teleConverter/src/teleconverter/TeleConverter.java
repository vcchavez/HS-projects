/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package teleconverter;

/**
 *
 * @author VictoriaChavez
 */
public class TeleConverter 
{
    private String areaCode;
    private String prefix;
    private String number;
    
    public TeleConverter()
    {
        areaCode="";
        prefix = "";
        number = "";
    }
    
    public TeleConverter(String newAreaCode, String newPrefix, String newNumber)
    {
        areaCode=newAreaCode;
        prefix = newPrefix;
        number = newNumber;
    }
    
    public void setAreaCode(String newArea)
    {
        areaCode = newArea;
    }
    
    public String getAreaCode()
    {
        return areaCode;
    }

    public String getPrefix()
    {
        //your code
        return prefix;
    }

    public void setPrefix(String newPrefix)
    {
        //your code;
        prefix = newPrefix;
    }

    public String getNumber()
    {
        //your code
        return number;
    }

    public void setNumber(String newNum)
    {
        //your code
        number = newNum;
    }
    
    public String toString()
    {
        return "(" + areaCode + ")" + prefix + "-" + number;
    }
    
    public String convert()
    {
        String output="";
        //your code
        String phone = this.toString();

        for (int index = 0; index <= 12; index++)
        {
            char letter = phone.charAt(index);

            if ("ABCabc".indexOf(letter) > -1)
            {
                output = output + 2;
            }
            else if ("DEFdef".indexOf(letter) > -1)
            {
                output = output + 3;
            }
            else if ("GHIghi".indexOf(letter) > -1)
            {
                output = output + 4;
            }
            else if ("JKLjkl".indexOf(letter) > -1)
            {
                output = output + 5;
            }
            else if ("MNOmno".indexOf(letter) > -1)
            {
                output = output + 6;
            }
            else if ("PQRSpqrs".indexOf(letter) > -1)
            {
                output = output + 7;
            }
            else if ("TUVtuv".indexOf(letter) > -1)
            {
                output = output + 8;
            }
            else if ("WXYZwxyz".indexOf(letter) > -1)
            {
                output = output + 9;
            }
            else
            {
                output = output + letter;
            }
        }
        
        
        return output;
    }
    
}
