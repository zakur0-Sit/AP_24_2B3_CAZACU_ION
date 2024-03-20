import java.util.*;
import java.util.stream.Collectors;
import java.util.Set;

public class SortPeople
{
    private List<Person> personList;

    public SortPeople(List<Person> personList) {
        this.personList = personList;
    }

    public void sortedDrivers()
    {
        System.out.println("Sorted drivers by age : ");
        List<Integer> sortDriversList = personList.stream()
                .filter(driver -> driver instanceof Driver)
                .sorted(Comparator.comparing(Person::getAge))
                .map(driver -> ((Driver)driver).getAge())
                .collect(Collectors.toCollection(LinkedList::new));
        System.out.println(sortDriversList + "\n");
    }

    public void sortedPassengers()
    {
        System.out.println("Sorted passengers by name : ");
        Set<String> sortPassengersSet = personList.stream()
                .filter(passenger -> passenger instanceof Passenger)
                .sorted(Comparator.comparing(Person::getName))
                .map(passenger -> ((Passenger)passenger).getName())
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println(sortPassengersSet);
    }
}
