public class Statue extends Attractions implements Visitable
{
    private String name;

    public Statue(String name) {
        super(name);
        this.name = name;
    }

    @Override
    public String dayOfTheWeek() {
        return "Every day";
    }

    @Override
    public String openHours() {
        return "Every hour";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Statue{" +
                "name='" + name + '\'' +
                '}';
    }
}
