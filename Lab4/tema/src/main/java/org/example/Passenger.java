package org.example;

public class Passenger extends Person implements Comparable<Passenger>
{

    public Passenger(String destination, String name, int age)
    {
        super(destination, name, age);
    }

    @Override
    public int compareTo(Passenger o) {
        return getName().compareTo(o.getName());
    }
}
