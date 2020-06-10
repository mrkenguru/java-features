package features;

import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.text.NumberFormat;

public class Java12FeaturesTest
{

    @DataProvider(name = "numberFormatDataProvider")
    private Object[][] numberFormatDataProvider()
    {
        return new Object[][]{
                {25925, NumberFormat.Style.SHORT, 0, "26K"}, {25925, NumberFormat.Style.SHORT, 1, "25.9K"},
                {25925, NumberFormat.Style.SHORT, 2, "25.93K"}, {25925, NumberFormat.Style.LONG, 0, "26 thousand"},
                {25925, NumberFormat.Style.LONG, 1, "25.9 thousand"},
                {25925, NumberFormat.Style.LONG, 2, "25.93 thousand"}
        };
    }

    @Test(dataProvider = "numberFormatDataProvider")
    public void testNumberFormat(int numberToFormat, NumberFormat.Style style, int maxFractionDigits, String expectedResult)
    {
        Java12Features java12Features = new Java12Features();
        String actualResult = java12Features.format(numberToFormat, style, maxFractionDigits);
        Assertions.assertThat(actualResult).isEqualTo(expectedResult);
    }
}