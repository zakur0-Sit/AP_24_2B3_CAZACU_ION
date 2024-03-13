import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        Attractions concert1 = new Concert("Techno Rave");
        Attractions church1 = new Church("St.Emanuel");
        Attractions statue1 = new Statue("Stefan cel Mare");
        Trip trip1 = new Trip("Iasi", 1);

        List<Attractions> attractions = new ArrayList<>();
        attractions.add(church1);
        attractions.add(concert1);
        attractions.add(statue1);
        attractions.sort(Attractions::compareTo);

        System.out.println(concert1.getName() + " : " + ((Concert) concert1).dayOfTheWeek() + " : " + ((Concert) concert1).openHours() + " : " + ((Concert) concert1).fee() + " lei");
        System.out.println(church1.getName() + " : " + ((Church) church1).dayOfTheWeek() + " : " + ((Church) church1).openHours());
        System.out.println(statue1.getName() + " : " + ((Statue) statue1).dayOfTheWeek() + " : " + ((Statue) statue1).openHours());
        System.out.println(trip1.getCityName() + " : " + trip1.getPeriodOfTime() + " month : " + trip1.fee() + " lei : " + attractions);
    }
}