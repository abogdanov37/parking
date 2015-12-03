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
        if (vehicle != null && aTime >= vehicle.getTime()) {
            int firstDayTime = vehicle.getTime() % HOURS_IN_DAY;
            int hours = aTime - vehicle.getTime();
            int lastDayTime = (hours - (HOURS_IN_DAY - firstDayTime)) % HOURS_IN_DAY;
            int nightHours;
            if (lastDayTime >= 0) {
                int days = (hours - (HOURS_IN_DAY - firstDayTime) - lastDayTime) / HOURS_IN_DAY;
                nightHours = days * NIGHT_HOURS + (lastDayTime < 6 ? lastDayTime : 6);
                nightHours += (firstDayTime < 6 ? 6 - firstDayTime : 0) + 1;
            } else {
                nightHours = firstDayTime < 6 ? 6 - firstDayTime : 0;
                nightHours += firstDayTime + hours > 23 ? 1 : 0;
            }
            return nightHours * price * 2 + (hours - nightHours) * price;
        }
        return 0f;
    }
}
