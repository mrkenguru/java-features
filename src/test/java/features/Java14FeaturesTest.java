package features;

import org.testng.annotations.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class Java14FeaturesTest
{
    @Test
    public void testPatternMatchingForInstanceOf()
    {
        Java14Features java14Features = new Java14Features();

        assertThat(java14Features.toStringWithInstanceOf("myString")).isEqualTo("myString");

        assertThat(java14Features.toStringWithInstanceOf(52)).isEqualTo("52");

        assertThatThrownBy(() -> java14Features.toStringWithInstanceOf(true)).isInstanceOf(
                IllegalArgumentException.class);

        assertThatThrownBy(() -> java14Features.toStringWithInstanceOf(Long.MAX_VALUE)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    public void testSwitchExpression()
    {
        Java14Features java14Features = new Java14Features();

        assertThat(java14Features.isWeekend(Day.MONDAY)).isEqualTo(false);
        assertThat(java14Features.isWeekend(Day.TUESDAY)).isEqualTo(false);
        assertThatThrownBy(() -> java14Features.isWeekend(Day.WEDNESDAY)).hasMessageContaining("not expected");
        assertThat(java14Features.isWeekend(Day.THURSDAY)).isEqualTo(false);
        assertThatThrownBy(() -> java14Features.isWeekend(Day.FRIDAY)).hasMessageContaining("Should be weekend");
        assertThat(java14Features.isWeekend(Day.SATURDAY)).isEqualTo(true);
        assertThat(java14Features.isWeekend(Day.SUNDAY)).isEqualTo(true);
    }

    @Test
    public void testRecord()
    {
        Rectangle actualRectangle = new Rectangle(10, 20);

        // record Square(int a) extends RectangleClass { } -- cannot extend other class
        // class Square extends features.Rectangle { }              -- records are final

        assertThat(actualRectangle).extracting(Rectangle::a).isEqualTo(10);
        assertThat(actualRectangle).extracting(Rectangle::b).isEqualTo(20);
        assertThat(actualRectangle).isEqualTo(new Rectangle(10, 20));

        record Empty() {}
        assertThat(new Empty()).isEqualTo(new Empty());

        record GeoCoordinate(BigDecimal latitude, BigDecimal longitude) {}
        GeoCoordinate geoCoordinate1 = new GeoCoordinate(BigDecimal.valueOf(10d), BigDecimal.valueOf(23d));
        GeoCoordinate geoCoordinate2 = new GeoCoordinate(BigDecimal.valueOf(10.00), BigDecimal.valueOf(23.00));
        assertThat(geoCoordinate1).isEqualTo(geoCoordinate2);
    }
}
