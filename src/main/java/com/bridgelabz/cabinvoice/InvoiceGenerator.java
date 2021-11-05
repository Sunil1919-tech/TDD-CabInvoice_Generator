package com.bridgelabz.cabinvoice;

/**
 * purpose- to perform cabInvoice generator programming and calculating the Fare
 *
 * @author Sunil
 * @version 12.0
 * @since 04/11/2021
 */
public class InvoiceGenerator {
    private static final double MINIMUM_COST_PER_KM = 10;
    private static final int COST_PER_MIN = 1;

    /**
     * method to calculate fare for particular ride
     *
     * @param distance
     * @param time
     * @return total fare
     */
    public double calculateFare(double distance, int time) {
        return distance * MINIMUM_COST_PER_KM + time * COST_PER_MIN;
    }
}
