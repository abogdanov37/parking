/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parking;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Andrew
 */
public class ParkingLife {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int iterations = 0;
        int capacity = -1;
        float price = 0f;
        for (int i = 0; i < args.length; i++) {
            if ("-iterations".equals(args[i])) {
                if (i + 1 < args.length) {
                    iterations = Integer.parseInt(args[i + 1]);
                } else {
                    System.err.println("Iterations count not specified.");
                    System.exit(1);
                }
            } else if ("-places".equals(args[i])) {
                if (i + 1 < args.length) {
                    capacity = Integer.parseInt(args[i + 1]);
                } else {
                    System.err.println("Vehicle places count not specified.");
                }
            } else if ("-price".equals(args[i])) {
                if (i + 1 < args.length) {
                    price = Float.parseFloat(args[i + 1]);
                } else {
                    System.err.println("One hour price not specified.");
                }
            } 
        }
        List<Integer> parkedVehicles = new ArrayList<>(10);
        Parking parking = new Parking(capacity, price);
        Random rnd = new Random();
        for (int i = 0; i < iterations; i++) {
            if (i % 10 == 0 && i > 0) {
                int unparkVehicles = rnd.nextInt(10);
                for (int j = 0; j < unparkVehicles; j++) {
                    int id = parkedVehicles.get(j);
                    float purchase = parking.unPark(id, rnd.nextInt(100));
                    System.out.println("Vehicle " + String.valueOf(id) + " successfully unparked. The cost amounted to " + String.valueOf(purchase) + " rub.");
                }
            }
            int id = rnd.nextInt(10000);
            if (parking.park(id, rnd.nextInt(25))) {
                System.out.println("Vehicle " + String.valueOf(id) + " successfully parked.");
                parkedVehicles.add(id);
            } else {
                System.out.println("Vehicle " + String.valueOf(id) + " could not be parked. Parking has not free places.");
            }
        }
    }

}
