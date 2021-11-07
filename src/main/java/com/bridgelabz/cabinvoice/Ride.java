package com.bridgelabz.cabinvoice;

/**
 * purpose- Ride class has details for calculating particular ride
 */
public class Ride {
    public final int time;
    public final CabRide cabRide;
    public double distance;

    /**
     * constructor for initializing the variables
     *
     * @param cabRide
     * @param distance
     * @param time
     */
    public Ride(CabRide cabRide, double distance, int time) {
        this.distance = distance;
        this.time = time;
        this.cabRide = cabRide;
    }
}
