import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

public interface Visitable
{
    Map<LocalDate, TimeInterval<LocalTime>> openHours();
    default LocalTime openHour(LocalDate day)
    {
        return openHours().get(day).getStart();
    }
}
