/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parking;

/**
 *
 * @author Andrew
 */
public class ParkingLife {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Parking p = new Parking(3, 100);
        
        System.out.println(p.park(1, 23));
        System.out.println(p.unPark(1, 29));

        System.out.println(p.park(1, 12));
        System.out.println(p.unPark(1, 36));

        System.out.println(p.park(1, 21));
        System.out.println(p.unPark(1, 45));
        
        System.out.println(p.park(1, 24));
        System.out.println(p.unPark(1, 48));

        System.out.println(p.park(1, 36));
        System.out.println(p.unPark(1, 72));

        System.out.println(p.park(1, 41));
        System.out.println(p.unPark(1, 89));
        
        System.out.println(p.park(1, 10));
        System.out.println(p.unPark(1, 17));
        
        System.out.println(p.park(1, 5));
        System.out.println(p.unPark(1, 19));

        System.out.println(p.park(1, 53));
        System.out.println(p.unPark(1, 72));
        
        
    }

}
