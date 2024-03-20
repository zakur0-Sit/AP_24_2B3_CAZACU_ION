import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        Person driver1 = new Driver("Iasi", "Ion", 20);
        Person driver2 = new Driver("Bucharest", "Andrei", 45);
        Person driver3 = new Driver("Iasi", "Olivia", 22);

        Person passenger1 = new Passenger("Iasi", "Nicolai", 33);
        Person passenger2 = new Passenger("Neamt", "Andreea", 50);
        Person passenger3 = new Passenger("Bucharest", "Ion", 18);

        List<Person> personList = new ArrayList<>();
        personList.add(driver1);
        personList.add(driver2);
        personList.add(driver3);
        personList.add(passenger1);
        personList.add(passenger2);
        personList.add(passenger3);

        SortPeople sortPeople = new SortPeople(personList);

        sortPeople.sortedDrivers();
        sortPeople.sortedPassengers();
    }
}