import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Trip
{
    private String cityName;
    private String periodOfTime;
    private List<Attraction> attractions;


    Trip(String cityName, String periodOfTime, List<Attraction> attractions)
    {
        this.cityName = cityName;
        this.periodOfTime = periodOfTime;
        this.attractions = attractions;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getPeriodOfTime() {
        return periodOfTime;
    }

    public void setPeriodOfTime(String periodOfTime) {
        this.periodOfTime = periodOfTime;
    }

    List<Attraction> getAttractions() {
        return attractions;
    }

    void setAttractions(List<Attraction> attractions) {
        this.attractions = attractions;
    }

    public void visitableNotPayable()
    {
        List<Attraction> visitNotPayLocations = attractions.stream().filter(attraction -> attraction instanceof Visitable && !(attraction instanceof Payable)).sorted(Comparator.comparing(attraction -> ((Visitable) attraction).openHours().values().iterator().next().getStart())).toList();
        System.out.println("Here you can go with no money :)");
        System.out.println(visitNotPayLocations);
        System.out.println("\n That's all :(");
    }

}
