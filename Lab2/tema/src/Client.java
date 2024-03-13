import java.util.Objects;

enum ClientType
{
    REGULAR,
    PREMIUM
}

public class Client
{
    private String name;
    private int visitingTimeInterval;
    private ClientType type;


    public Client(String name, int visitingTimeInterval, ClientType type)
    {
        this.name = name;
        this.visitingTimeInterval = visitingTimeInterval;
        this.type = type;
    }



    /**
     * There is all getters and setters
     */
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getVisitingTimeInterval()
    {
        return visitingTimeInterval;
    }

    public void setVisitingTimeInterval(int visitingTimeInterval)
    {
        this.visitingTimeInterval = visitingTimeInterval;
    }

    public ClientType getType()
    {
        return type;
    }

    public void setType(ClientType type)
    {
        this.type = type;
    }



    /**
     * toString() method to show all content from Depot class
     * @return name, visitingTimeInterval and type
     */
    @Override
    public String toString()
    {
        return "Client{" +
                "name='" + name + '\'' +
                ", visitingTimeInterval=" + visitingTimeInterval +
                ", type=" + type +
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
        Client client = (Client) o;
        return visitingTimeInterval == client.visitingTimeInterval &&
                Objects.equals(name, client.name) &&
                type == client.type;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name, visitingTimeInterval, type);
    }
}