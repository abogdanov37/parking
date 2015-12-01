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

    private final int NIGHT_HOURS = 7;
    private final int HOURS_IN_DAY = 24;
    private final Map<Integer, Vehicle> parking;
    private final int capacity;
    private final float price;

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
            int nightHours;
            int firstDayTime = HOURS_IN_DAY - vehicle.getTime();
            if (firstDayTime < aTime) {
                int hours = aTime - (firstDayTime < HOURS_IN_DAY ? firstDayTime : 0);
                int lastDayTime = hours % HOURS_IN_DAY;
                int days = hours / HOURS_IN_DAY;
                nightHours = days * NIGHT_HOURS + (lastDayTime < 6 ? lastDayTime : 6);
                if (firstDayTime < HOURS_IN_DAY) {
                    nightHours += (vehicle.getTime() < 6 ? 6 - vehicle.getTime() : 0) + 1;
                }
            } else {
                nightHours = (vehicle.getTime() + aTime) <= 6 ? aTime : 6 - vehicle.getTime();
                nightHours += (vehicle.getTime() + aTime) == HOURS_IN_DAY ? 1 : 0;
            }
            return nightHours * price * 2 + (aTime - nightHours) * price;
        }
        return 0f;
    }
}
