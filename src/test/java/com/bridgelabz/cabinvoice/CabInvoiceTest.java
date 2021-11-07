package com.bridgelabz.cabinvoice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CabInvoiceTest {
    InvoiceService invoiceService = null;

    @BeforeEach
    public void setUp() throws Exception {
        invoiceService = new InvoiceService();
    }

    @Test
    void givenDistanceAndTime_ShouldReturnTotalFare() {
        double distance = 2.0;
        int time = 5;
        double totalFare = invoiceService.calculateFare(distance, time);
        Assertions.assertEquals(25, totalFare);
    }

    @Test
    void givenLessDistanceAndTime_ShouldReturnMinimumFare() {
        double distance = 0.1;
        int time = 1;
        double minFare = invoiceService.calculateFare(distance, time);
        Assertions.assertEquals(5.0, minFare);
    }


    @Test
    void givenMultipleRidesAndTime_WhenCalculated_ShouldReturnInvoiceSummery() {
        Ride[] rides = {new Ride(CabRide.NORMAL, 2.0, 5),
                new Ride(CabRide.PREMIUM, 0.1, 1),
        };
        InvoiceSummary actualSummary = invoiceService.calculateFare(rides);
        InvoiceSummary expectedInvoice = new InvoiceSummary(2, 45.0);
        Assertions.assertEquals(expectedInvoice, actualSummary);
    }

    @Test
    void givenUserIDAndRideList_ShouldReturnInvoiceSummary() {
        String userId = "sunil2021";
        Ride[] rides = {new Ride(CabRide.NORMAL, 2.0, 5),
                new Ride(CabRide.NORMAL, 0.1, 1)
        };
        invoiceService.addRides(userId, rides);
        InvoiceSummary actualSummary = invoiceService.getInvoiceSummary(userId);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        Assertions.assertEquals(expectedInvoiceSummary, actualSummary);
    }

    @Test
    void givenUserIDAndRideList_ShouldReturnInvoiceSummeryForPremium() {
        String userId = "sunil2021";
        Ride[] rides = new Ride[]{new Ride(CabRide.PREMIUM, 2.0, 5),
                new Ride(CabRide.PREMIUM, 0.1, 1),
                new Ride(CabRide.PREMIUM, 2.0, 5)
        };
        invoiceService.addRides(userId, rides);
        InvoiceSummary actualSummary = invoiceService.getInvoiceSummary(userId);
        InvoiceSummary expectedInvoice = new InvoiceSummary(3, 100.0);
        Assertions.assertEquals(expectedInvoice, actualSummary);
    }

    @Test
    void givenUserIDAndRideList_ShouldReturnInvoiceSummeryForNormal() {
        String userId = "sunil2021";
        Ride[] rides = new Ride[]{new Ride(CabRide.NORMAL, 2.0, 5),
                new Ride(CabRide.NORMAL, 0.1, 1),
                new Ride(CabRide.NORMAL, 2.0, 5)
        };
        invoiceService.addRides(userId, rides);
        InvoiceSummary actualSummary = invoiceService.getInvoiceSummary(userId);
        InvoiceSummary expectedInvoice = new InvoiceSummary(3, 55.0);
        Assertions.assertEquals(expectedInvoice, actualSummary);
    }
}

