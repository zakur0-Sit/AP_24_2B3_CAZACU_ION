import java.util.Objects;

public abstract class Vehicle
{
    private Depot depot;
    private boolean inUse = false;

    protected Vehicle(Depot depot)
    {
        this.depot = depot;
    }

    /**
     * There is all getters and setters
     */
    public Depot getDepot()
    {
        return depot;
    }

    public void setDepot(Depot depot)
    {
        this.depot = depot;
    }

    public boolean isInUse() {
        return inUse;
    }

    public void setInUse(boolean inUse) {
        this.inUse = inUse;
    }

    /**
     * toString() method to show all content from Depot class
     * @return depot
     */
    @Override
    public String toString()
    {
        return "Vehicle{" +
                "depot=" + depot +
                '}';
    }

    /**
     * equals() and hashCode() methods
     */
    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(depot, vehicle.depot);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(depot);
    }
}