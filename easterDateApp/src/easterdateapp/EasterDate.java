package easterdateapp;

/**
 *
 * @author vcchavez
 */
        import java.util.Calendar;
        //import java.text.SimpleDateFormat;
        //import java.text.DateFormat;
        //import java.util.Date;

/*
    Easter Date calculated by using:
        http://www.oremus.org/liturgy/etc/ktf/app/easter.html
*/
public class EasterDate
{
    private int year;
    /** Creates a new instance of EasterDate */
    public EasterDate()
    {

    }
    
    public String getEasterDate(int y)
    {

        year = y;
        String output="";
        //place the steps from Algorithm E

        //E1
        int goldenNumber = 1 + (year % 19);

        //E2
        int centuryNumber = 1 + year/100;

        //E3
        int numberOfYears = (3 * centuryNumber) / 4 - 12;
        int correction = (8 * centuryNumber + 5) / 25 - 5;

        //E4
        int sunday = 5 * year / 4 - numberOfYears - 10;

        //E5
        int epact = (11 * goldenNumber + 20 + correction - numberOfYears) % 30;

        if (epact < 0)
        {
          epact = epact + 30;
        }
        else
        {
        }

        if ((epact == 25) && (goldenNumber > 11))
        {
            epact = epact + 1;
        }
        else
        {
        }

        if ( epact == 24)
        {
            epact =  epact + 1;
        }
        else
        {
        }

        //E6
        int date = 44 - epact;

        if (date < 21)
        {
            date = date + 30;
        }
        else
        {
        }

        //E7
        date = date + 7 - ((sunday + date) % 7);

        //E8
        if (date > 31)
        {
          epact = (date - 31);
          output = epact + " April" + ", " + year;
        }
        else
        {
            epact = date;
            output = epact + " March" + ", " + year;
        }

        // extra credit
        int thisYear = Calendar.YEAR;
        
        thisYear = thisYear + 2011;

        if (year < thisYear)
        {
            output = "Easter ocurred on " + output;
        }
        else
        {
            output = "Easter will occur on " + output;
        }

        return output;
    }
    
}
