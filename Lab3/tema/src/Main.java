import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

public class Main
{
    public static void main(String[] args)
    {
        Map<LocalDate, TimeInterval<LocalTime>> statueOpenHours = Map.of(
                LocalDate.of(2024,4,3), new TimeInterval<>(LocalTime.of(8,0), LocalTime.of(20,0)),
                LocalDate.of(2024,4,6), new TimeInterval<>(LocalTime.of(5,0), LocalTime.of(22,0))
        );

        Map<LocalDate, TimeInterval<LocalTime>> churchOpenHours = Map.of(
                LocalDate.of(2024, 4,4), new TimeInterval<>(LocalTime.of(7,0), LocalTime.of(19,0)),
                LocalDate.of(2024, 4, 5), new TimeInterval<>(LocalTime.of(9,0), LocalTime.of(19,0))
        );

        Map<LocalDate, TimeInterval<LocalTime>> concertOpenHours = Map.of(
                LocalDate.of(2024,2,1), new TimeInterval<>(LocalTime.of(18,0), LocalTime.of(0,0)),
                LocalDate.of(2024,4, 5), new TimeInterval<>(LocalTime.of(18,0), LocalTime.of(2,0))
        );

        Attraction statue1 = new Statue("Stefan cel Mare", statueOpenHours);
        Attraction church1 = new Church("St. Haralambie", churchOpenHours);
        Attraction concert1 = new Concert("Techno Rave",50 ,concertOpenHours);

        Trip trip1 = new Trip("Iasi", "3 days", List.of(statue1, church1, concert1));
        trip1.visitableNotPayable();

        Map<Attraction, LocalDate> travelPlanMap = Map.of(
                statue1, LocalDate.of(2024,4,3),
                church1, LocalDate.of(2024,4,4),
                concert1, LocalDate.of(2024,4,5)
        );

        TravelPlan travelPlan1 = new TravelPlan(travelPlanMap);

        System.out.println(travelPlan1);
    }
}