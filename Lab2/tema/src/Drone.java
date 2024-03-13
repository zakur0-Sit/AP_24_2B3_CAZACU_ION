public class Drone extends Vehicle
{
    private int maxFlightDuration;

    public Drone(Depot depot, int maxFlightDuration)
    {
        super(depot);
        this.maxFlightDuration = maxFlightDuration;
    }

    /**
     * There is all getters and setters
     */
    public int getMaxFlightDuration()
    {
        return maxFlightDuration;
    }

    public void setMaxFlightDuration(int maxFlightDuration)
    {
        this.maxFlightDuration = maxFlightDuration;
    }

    /**
     * toString() method to show all content from Depot class
     * @return maxFlightDuration
     */
    @Override
    public String toString()
    {
        return "Drone{" +
                "maxFlightDuration=" + maxFlightDuration +
                '}';
    }
}