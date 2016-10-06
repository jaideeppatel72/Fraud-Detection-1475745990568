package example.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil
{

    public static Date toDate(final String lStrData, final String dateformat)
    {

        final Calendar cal = Calendar.getInstance();
        try
        {
            final SimpleDateFormat simpleDtFormat = new SimpleDateFormat(dateformat);
            cal.setTime(simpleDtFormat.parse(lStrData));
        }
        catch (final Exception e)
        {
            return null;
        }
        return cal.getTime();
    }
	
	public static Date toDate(final String lStrData)
   	 {
        final Calendar cal = Calendar.getInstance();
        try
        {
            final SimpleDateFormat simpleDtFormat = new SimpleDateFormat("dd/MM/yyyy");
            cal.setTime(simpleDtFormat.parse(lStrData));
        }
        catch (final Exception e)
        {
            return null;
        }
        return cal.getTime();
    }
}