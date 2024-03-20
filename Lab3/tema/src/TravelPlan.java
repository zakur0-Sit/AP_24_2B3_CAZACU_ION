import java.time.LocalDate;
import java.util.Map;

public class TravelPlan
{
    private Map<Attraction, LocalDate> plan;

    TravelPlan(Map<Attraction, LocalDate> plan) {
        this.plan = plan;
    }

    @Override
    public String toString() {
        return "TravelPlan{" +
                "plan=" + plan +
                "\n}";
    }
}
