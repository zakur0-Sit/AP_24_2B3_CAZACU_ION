abstract public class Person
{
    private String destination;
    private String name;
    private int age;

    public Person(String destination, String name, int age) {
        this.destination = destination;
        this.name = name;
        this.age = age;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "destination='" + destination + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


}
