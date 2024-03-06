public class Depot extends Object
{
    private String location;
    private boolean inUsage;

    public Depot(String location, boolean inUsage)
    {
        this.location = location;
        this.inUsage = inUsage;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isInUsage() {
        return inUsage;
    }

    public void setInUsage(boolean inUsage) {
        this.inUsage = inUsage;
    }

    @Override
    public String toString()
    {
        return "Depot{" +
                "location='" + location + '\'' +
                ", inUsage=" + inUsage +
                '}';
    }
}
