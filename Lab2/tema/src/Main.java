/**
 * @author ion
 * @version 1.0
 * Main class of the Project
 */

public class Main
{
    /**
     * Start point of the program
     * @param args command line values
     */
    public static void main(String[] args)
    {
        /**
         * @see Depot
         * @see Depot#addVehicle(Vehicle)
         * @see Depot#addClient(Client)
         * @see Truck
         * @see Drone
         * @see Problem
         * @see Problem#addDepot(Depot)
         * @see Depot#getVehicles()
         * @see Depot#getClients()
         * @see DistanceVector
         */
        Depot depot1 = new Depot("Depot 1");

        depot1.addVehicle(new Truck(depot1, 100));
        depot1.addVehicle(new Drone(depot1, 50));
        depot1.addClient(new Client("Client 1", 10, ClientType.REGULAR));
        depot1.addClient(new Client("Client 1", 10, ClientType.REGULAR));
        depot1.addClient(new Client("Client 2", 20, ClientType.PREMIUM));
        depot1.addClient(new Client("Client 3", 45, ClientType.PREMIUM));

        Problem problem = new Problem();
        problem.addDepot(depot1);

        System.out.println(problem);

        int vehicleNumber = depot1.getVehicles().size();
        int clientNumber = depot1.getClients().size();

        DistanceVector distanceMatrix = new DistanceVector(clientNumber, depot1, vehicleNumber);
    }
}
