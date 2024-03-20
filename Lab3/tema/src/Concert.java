import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

public class Concert extends Attraction implements Payable, Visitable
{
    private String name;
    private double entryFee;
    private Map<LocalDate, TimeInterval<LocalTime>> openHours;

    public Concert(String name, double entryFee, Map<LocalDate, TimeInterval<LocalTime>> openHours)
    {
        super(name);
        this.name = name;
        this.entryFee = entryFee;
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

//    public double getEntryFee() {
//        return entryFee;
//    }
//
//    public void setEntryFee(double entryFee) {
//        this.entryFee = entryFee;
//    }
//
//    public Map<String, TimeInterval<LocalTime>> getOpenHours() {
//        return openHours;
//    }
//
//    public void setOpenHours(Map<String, TimeInterval<LocalTime>> openHours) {
//        this.openHours = openHours;
//    }

    @Override
    public double fee() {
        return entryFee;
    }

    @Override
    public Map<LocalDate, TimeInterval<LocalTime>> openHours() {
        return openHours;
    }

    @Override
    public String toString() {
        return "\n\nConcert\n{" +
                "\n\tname='" + name + '\'' +
                ", \n\tentryFee=" + entryFee +
                ", \n\topenHours=" + openHours +
                "\n}";
    }
}
