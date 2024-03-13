public class Vehicle extends Object
{
    private String color;
    private int capacity;

    public Vehicle(String color, int capacity)
    {
        this.color = color;
        this.capacity = capacity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString()
    {
        return "Vehicle{" +
                "color='" + color + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
