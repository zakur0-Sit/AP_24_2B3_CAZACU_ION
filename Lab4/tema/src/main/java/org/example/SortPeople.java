package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class SortPeople
{
    private List<Person> personList;

    public SortPeople(List<Person> personList) {
        this.personList = personList;
    }

    public void sortedDrivers()
    {
        System.out.println("Sorted drivers by age : ");
        List<Person> sortDriversList = personList.stream()
                .filter(driver -> driver instanceof Driver)
                .sorted(Comparator.comparing(Person::getAge))
                .collect(Collectors.toCollection(LinkedList::new));
        System.out.println(sortDriversList + "\n");
    }

    public void sortedPassengers()
    {
        System.out.println("Sorted passengers by name : ");
        Set<Person> sortPassengersSet = personList.stream()
                .filter(passenger -> passenger instanceof Passenger)
                .sorted(Comparator.comparing(Person::getName))
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println(sortPassengersSet);
    }
}
