import java.util.ArrayList;
import java.util.Objects;

public class Depot
{
    private String location;
    private ArrayList<Vehicle> vehicles = new ArrayList<>();
    private ArrayList<Client> clients = new ArrayList<>();
    public Depot(String location)
    {
        this.location = location;
    }


    public void addVehicle(Vehicle vehicle)
    {
        if (!vehicles.contains(vehicle))
            vehicles.add(vehicle);
    }

    public void addClient(Client client)
    {
        if(!clients.contains(client))
            clients.add(client);
    }
    /**
     * There is all getters and setters
     */
    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    public ArrayList<Vehicle> getVehicles()
    {
        return vehicles;
    }

    public void setVehicles(ArrayList<Vehicle> vehicles)
    {
        this.vehicles = vehicles;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }
    /**
     * toString() method to show all content from Depot class
     * @return location, vehicles and clients
     */
    @Override
    public String toString() {
        return "Depot{" +
                "location='" + location + '\'' +
                ", vehicles=" + vehicles +
                ", clients=" + clients +
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
        Depot depot = (Depot) o;
        return Objects.equals(location, depot.location);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(location);
    }
}