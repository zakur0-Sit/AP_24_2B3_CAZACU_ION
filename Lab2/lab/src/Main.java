public class Main
{
    public static void main(String[] args)
    {
        Client client = new Client("Ion", ClientType.PREMIUM);
        Vehicle vehicle = new Vehicle("black", 5);
        Depot depot = new Depot("Iasi", true);

        System.out.println(client.toString());
        System.out.println(vehicle.toString());
        System.out.println(depot.toString());
    }
}