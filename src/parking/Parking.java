/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parking;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Andrew
 */
public class Parking {

    Map<Integer, Vehicle> parking;
    int capacity;
    float price;

    public Parking(int aCapacity, float aPrice) {
        if (aCapacity >= 0) {
            parking = new HashMap<>(aCapacity);
            capacity = aCapacity;
        } else {
            parking = new HashMap<>();
            capacity = 16;
        }
        price = aPrice;
    }

    public boolean park(int aID, int aTime) {
        if (parking.size() < capacity) {
            if (!parking.containsKey(aID)) {
                parking.put(aID, new Vehicle(aID, aTime));
                return true;
            }
        }
        return false;
    }

    public float unPark(int aID, int aTime) {
        Vehicle vehicle = parking.remove(aID);
        if (vehicle != null) {
            int hours = aTime - vehicle.getTime();
        }
        return 0f;
    }
}
