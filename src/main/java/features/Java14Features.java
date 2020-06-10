package features;

public class Java14Features
{
    public String toStringWithInstanceOf(Object myObject)
    {
        if (myObject instanceof String myStringObject)
        {
            return myStringObject;
        }

        if (myObject instanceof Integer myIntegerObject)
        {
            return myIntegerObject.toString();
        }

        throw new IllegalArgumentException();
    }

    public boolean isWeekend(Day day)
    {
        return switch (day)
                {
                    case MONDAY, TUESDAY, THURSDAY -> false;
                    case SATURDAY, SUNDAY -> true;
                    case FRIDAY -> throw new IllegalStateException("Should be weekend");
                    default -> throw new IllegalArgumentException("features.Day is not expected: " + day);
                };
    }

    public String getStringFromTextBlock()
    {
        return """
                 Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus dignissim ac leo id pharetra.\n 
                 Phasellus mattis ut neque sit amet rhoncus. Vivamus sit amet ante eu tortor volutpat auctor nec id ante.\n 
                """;
    }

}
