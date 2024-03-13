import java.util.ArrayList;
import java.util.List;

public class Trip implements Payable
{
    private String cityName;
    private int periodOfTime;
    private List<Attractions> attractions = new ArrayList<>();

    public Trip(String cityName, int periodOfTime) {
        this.cityName = cityName;
        this.periodOfTime = periodOfTime;
    }

    @Override
    public int fee() {
        return 1000;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getPeriodOfTime() {
        return periodOfTime;
    }

    public void setPeriodOfTime(int periodOfTime) {
        this.periodOfTime = periodOfTime;
    }

    public List<Attractions> getAttractions() {
        return attractions;
    }

    public void setAttractions(List<Attractions> attractions) {
        this.attractions = attractions;
    }
}
