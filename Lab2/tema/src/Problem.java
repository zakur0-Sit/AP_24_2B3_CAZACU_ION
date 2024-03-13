/**
 * Created by ion on 12/3/24
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
public class Problem
{

    private ArrayList<Depot> depots = new ArrayList<>();

    /**
     * Method addDepot used to add a depot to ArrayList depots if it's not already exists
     * @param depot object of Depot class
     */
    public void addDepot(Depot depot)
    {
        if (!depots.contains(depot))
            depots.add(depot);
    }

    public ArrayList<Depot> getDepots() {
        return depots;
    }

    public void setDepots(ArrayList<Depot> depots) {
        this.depots = depots;
    }

    /**
     *
     * @return an array of all vehicles from all depots
     */
    public Vehicle[] getVehicles()
    {
        ArrayList<Vehicle> allVehicles = new ArrayList<>();

        for (Depot depot : depots)
            allVehicles.addAll(depot.getVehicles());

        return allVehicles.toArray(new Vehicle[0]);
    }

    @Override
    public String toString() {
        return "Problem{" +
                "depots=" + depots +
                '}';
    }
}

/**
 * Creating a random vector of distances
 */
class DistanceVector
{
    private int[] distances;

    public DistanceVector(int size, Depot depot, int vehicleNum)
    {
        distances = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            distances[i] = random.nextInt(100) + 1;
        }

        getDistance(size);
        System.out.println();
        clientOrder(size, depot, vehicleNum);
    }

    /**
     * Print distance vector
     * @param size - length of the vector
     */
    public void getDistance(int size) {
        for(int i = 0; i < size; i++)
        {
            System.out.print(distances[i] + " ");
        }
    }

    /**
     * This method order distances and chose vehicle for nearest clients
     * @param size - length of the vector
     * @param depot - object of Depot class
     * @param vehicleNum - number of vehicles inside the depot
     */
    public void clientOrder(int size, Depot depot, int vehicleNum)
    {
        int indexVehicle = 0;
        ArrayList<Integer> clientOrder = new ArrayList<>();

        /**
         * Move distance in ArrayList
         */
        for(int i = 0; i < size; i++)
        {
            clientOrder.add(distances[i]);
        }
        /**
         * Sort ArrayList
         */
        Collections.sort(clientOrder);
        /**
         * Distribution of all vehicles from depot
         */
        for(int el : clientOrder)
        {
            for(int i = 0; i < size; i++)
            {
                if(el == distances[i])
                {
                    if(vehicleNum > indexVehicle)
                    {
                        System.out.println(depot.getClients().get(i) + " get : " + depot.getVehicles().get(indexVehicle));
                        indexVehicle++;
                    }
                    else
                    {
                        System.out.println("No more vehicles in this depot");
                    }
                }
            }
        }
    }
}
