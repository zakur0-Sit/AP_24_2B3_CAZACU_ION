public class Church extends Attractions implements Visitable
{
    private String name;

    public Church(String name) {
        super(name);
        this.name = name;
    }

    @Override
    public String dayOfTheWeek() {
        return "Every day";
    }

    @Override
    public String openHours() {
        return "7:00 - 20:00";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Church{" +
                "name='" + name + '\'' +
                '}';
    }
}
