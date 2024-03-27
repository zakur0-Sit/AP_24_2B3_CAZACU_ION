package org.example;

import java.util.*;

public class Problem {

    public static void driversInfo(List<Person> personList)
    {
        List<String> infoDriver = personList.stream()
                .filter(person -> person instanceof Driver)
                .map(driver -> driver.getName() + "[" + driver.getAge() + "]" + " -> " + driver.getDestination())
                .toList();
        System.out.println(infoDriver);
    }

    public static void passengersInfo(List<Person> personList)
    {
        List<String> infoDriver = personList.stream()
                .filter(person -> person instanceof Passenger)
                .map(passenger -> passenger.getName() + "[" + passenger.getAge() + "]" + " -> " + passenger.getDestination())
                .toList();
        System.out.println(infoDriver);
    }

   public static List<String> destinationsAndPeople(List<Person> personList) {
        Set<Driver> busyDrivers = new HashSet<>();
        List<String> result = new ArrayList<>();

        personList.stream()
                .filter(person -> person instanceof Passenger)
                .forEach(passenger -> {
                    Optional<Driver> availableDriver = personList.stream()
                            .filter(driver -> driver instanceof Driver && !busyDrivers.contains(driver))
                            .filter(driver -> driver.getDestination().equals(passenger.getDestination()))
                            .map(driver -> (Driver) driver)
                            .findFirst();

                    availableDriver.ifPresent(driver -> {
                        result.add(String.format("%s -> [%s, %s]", passenger.getDestination(), driver.getName(), passenger.getName()));
                        busyDrivers.add(driver);
                    });
                });

        return result;
    }
}
