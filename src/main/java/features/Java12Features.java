package features;

import java.text.NumberFormat;
import java.util.Locale;

public class Java12Features
{
    private static final Locale LOCALE = new Locale("en", "US");

    public String format(int number, NumberFormat.Style style, int maxFractionDigits)
    {
        NumberFormat numberFormat = getNumberFormat(style);
        numberFormat.setMaximumFractionDigits(maxFractionDigits);
        return numberFormat.format(number);
    }

    private NumberFormat getNumberFormat(NumberFormat.Style style)
    {
        return NumberFormat.getCompactNumberInstance(LOCALE, style);
    }

}
