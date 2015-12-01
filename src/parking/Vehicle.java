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
public class Vehicle {

    int id;
    int timein;

    public Vehicle(int aID, int aTimeIn) {
        id = aID;
        timein = aTimeIn;
    }
    
    public int getTime() {
        return timein;
    }
}
