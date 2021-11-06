package com.bridgelabz.cabinvoice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CabInvoiceTest {
    InvoiceGenerator invoiceGenerator = null;

    @BeforeEach
    public void setUp() throws Exception {
        invoiceGenerator = new InvoiceGenerator();
    }

    @Test
    void givenDistanceAndTime_ShouldReturnTotalFare() {
        double distance = 2.0;
        int time = 5;
        double totalFare = invoiceGenerator.calculateFare(distance, time);
        Assertions.assertEquals(25, totalFare);
    }

    @Test
    void givenLessDistanceAndTime_ShouldReturnMinimumFare() {
        double distance = 0.1;
        int time = 1;
        double minFare = invoiceGenerator.calculateFare(distance, time);
        Assertions.assertEquals(5.0, minFare);
    }


    @Test
    void givenMultipleRidesAndTime_WhenCalculated_ShouldReturnInvoiceSummery() {
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1),
        };
        InvoiceSummary actualSummary = invoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedInvoice = new InvoiceSummary(2, 30.0);
        Assertions.assertEquals(expectedInvoice, actualSummary);
    }

    @Test
    void givenUserIDAndRideList_ShouldReturnInvoiceSummary() {
        String userId ="sunil2021";
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1),
        };
        invoiceGenerator.addRides(userId, rides);
        InvoiceSummary actualSummary = invoiceGenerator.getInvoiceSummary(userId);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        Assertions.assertEquals(expectedInvoiceSummary, actualSummary);
    }
}

