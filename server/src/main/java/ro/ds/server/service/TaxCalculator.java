package ro.ds.server.service;

import ro.ds.common.entity.Car;
import ro.ds.common.serviceinterface.ITaxCalculator;

public class TaxCalculator implements ITaxCalculator {

    public double computeTax(Car c) {
        if (c.getEngineCapacity() <= 0) {
            throw new IllegalArgumentException("Engine capacity must be positive.");
        }
        int sum = 8;
        if(c.getEngineCapacity() > 1601) sum = 18;
        if(c.getEngineCapacity() > 2001) sum = 72;
        if(c.getEngineCapacity() > 2601) sum = 144;
        if(c.getEngineCapacity() > 3001) sum = 290;
        return c.getEngineCapacity() / 200.0 * sum;
    }
}
