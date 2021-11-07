package com.bridgelabz.cabinvoice;

import java.util.Objects;

/**
 * purpose - class to create invoice summery for multiple rides ,totalFare,avgFare
 *
 * @author Sunil
 * @version 12.0
 * @since 05/11/2021
 */
public class InvoiceSummary {
    private final int numOfRides;
    private final double totalFare;
    private final double averageFare;

    /**
     * initializing the variables
     *
     * @param numOfRides
     * @param totalFare
     */
    public InvoiceSummary(int numOfRides, double totalFare) {
        this.numOfRides = numOfRides;
        this.totalFare = totalFare;
        this.averageFare = this.totalFare / numOfRides;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceSummary that = (InvoiceSummary) o;
        return numOfRides == that.numOfRides &&
                Double.compare(that.totalFare, totalFare) == 0 &&
                Double.compare(that.averageFare, averageFare) == 0;
    }

}
