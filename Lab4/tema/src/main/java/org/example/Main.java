package org.example;

import com.github.javafaker.Faker;
import java.util.*;

public class Main {
    public static void main(String[] args)
    {
        List<Driver> drivers = new ArrayList<>();
        List<Passenger> passengers = new ArrayList<>();
        List<Person> people = new ArrayList<>();
        List<String> address = new ArrayList<>();

        String cityName;

        for(int i = 0; i < 5; ++i)
        {
            cityName = new Faker().address().cityName();
            address.add(cityName);
        }

        people.add(new Driver(address.get(new Random().nextInt(address.size())), new Faker().name().firstName(), new Random().nextInt(18, 80)));
        people.add(new Driver(address.get(new Random().nextInt(address.size())), new Faker().name().firstName(), new Random().nextInt(18, 80)));
        people.add(new Driver(address.get(new Random().nextInt(address.size())), new Faker().name().firstName(), new Random().nextInt(18, 80)));
        people.add(new Driver(address.get(new Random().nextInt(address.size())), new Faker().name().firstName(), new Random().nextInt(18, 80)));
        people.add(new Driver(address.get(new Random().nextInt(address.size())), new Faker().name().firstName(), new Random().nextInt(18, 80)));
        people.add(new Driver(address.get(new Random().nextInt(address.size())), new Faker().name().firstName(), new Random().nextInt(18, 80)));

        people.add(new Passenger(address.get(new Random().nextInt(address.size())), new Faker().name().firstName(), new Random().nextInt(18, 80)));
        people.add(new Passenger(address.get(new Random().nextInt(address.size())), new Faker().name().firstName(), new Random().nextInt(18, 80)));
        people.add(new Passenger(address.get(new Random().nextInt(address.size())), new Faker().name().firstName(), new Random().nextInt(18, 80)));
        people.add(new Passenger(address.get(new Random().nextInt(address.size())), new Faker().name().firstName(), new Random().nextInt(18, 80)));
        people.add(new Passenger(address.get(new Random().nextInt(address.size())), new Faker().name().firstName(), new Random().nextInt(18, 80)));
        people.add(new Passenger(address.get(new Random().nextInt(address.size())), new Faker().name().firstName(), new Random().nextInt(18, 80)));

        System.out.println("Drivers : ");
        Problem.driversInfo(people);

        System.out.println("\nPassengers : ");
        Problem.passengersInfo(people);

        System.out.println("\nDestination and pair of passenger and driver : ");
        List<String> result = Problem.destinationsAndPeople(people);
        System.out.println(result);
    }
}