package com.bridgelabz.cabinvoice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * purpose- created class to add rides to user with the help of UserID
 *
 * @author Sunil
 * @version 12.0
 * @since 04/11/2021
 */
public class RideRepository {
    Map<String, ArrayList<Ride>> userRides = null;

    public RideRepository() {
        this.userRides = new HashMap<>();
    }

    /**
     * method to add rides to the users
     *
     * @param userId
     * @param rides
     */
    public void addRides(String userId, Ride[] rides) {
        ArrayList<Ride> rideList = this.userRides.get(userId);
        if (rideList == null) {
            this.userRides.put(userId, new ArrayList<>(Arrays.asList(rides)));
        }
    }

    /**
     * this method gives the num. of Rides based on the userID
     *
     * @param userId
     * @return rides
     */
    public Ride[] getRides(String userId) {
        return this.userRides.get(userId).toArray(new Ride[0]);
    }
}
