import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

public class Church extends Attraction implements Visitable
{
    private String name;
    private Map<LocalDate, TimeInterval<LocalTime>> openHours;
    public Church(String name, Map<LocalDate, TimeInterval<LocalTime>> openHours) {
        super(name);
        this.name = name;
        this.openHours = openHours;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

//    public Map<LocalDate, TimeInterval<LocalTime>> getOpenHours() {
//        return openHours;
//    }
//
//    public void setOpenHours(Map<LocalDate, TimeInterval<LocalTime>> openHours) {
//        this.openHours = openHours;
//    }

    @Override
    public Map<LocalDate, TimeInterval<LocalTime>> openHours() {
        return openHours;
    }

    @Override
    public String toString() {
        return "\n\nChurch\n{" +
                "\n\tname='" + name + '\'' +
                ",\n\topenHours=" + openHours +
                "\n}";
    }
}
