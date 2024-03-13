public class Concert extends Attractions implements Payable, Visitable
{
    private String name;

    public Concert(String name)
    {
        super(name);
        this.name = name;
    }
    @Override
    public int fee() {
        return 100;
    }

    @Override
    public String dayOfTheWeek() {
        return "Sunday";
    }

    @Override
    public String openHours() {
        return "18:00 - 00:00";
    }

    public String getTitle() {
        return name;
    }

    public void setTitle(String nume) {
        this.name = nume;
    }

    @Override
    public String toString() {
        return "Concert{" +
                "nume='" + name + '\'' +
                '}';
    }
}
