public class Truck extends Vehicle
{
    private int capacity;

    public Truck(Depot depot, int capacity)
    {
        super(depot);
        this.capacity = capacity;
    }

    /**
     * There is all getters and setters
     */
    public int getCapacity()
    {
        return capacity;
    }

    public void setCapacity(int capacity)
    {
        this.capacity = capacity;
    }

    /**
     * toString() method to show all content from Depot class
     * @return capacity
     */
    @Override
    public String toString()
    {
        return "Truck{" +
                "capacity=" + capacity +
                '}';
    }
}