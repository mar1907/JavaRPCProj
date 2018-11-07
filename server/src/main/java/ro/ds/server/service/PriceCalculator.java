package ro.ds.server.service;

import ro.ds.common.entity.Car;
import ro.ds.common.serviceinterface.IPriceCalculator;

public class PriceCalculator implements IPriceCalculator {

    public double computePrice(Car c) {
        if (c.getPrice() <= 0) {
            throw new IllegalArgumentException("Price must be positive.");
        }

        if (c.getYear() > 2018) {
            throw new IllegalArgumentException("Year must be in the past.");
        }

        if(2018-c.getYear()>=7){
            return 0;
        } else {
            double price = c.getPrice();
            return price - (price / 7) * (2018 - c.getYear());
        }
    }
}
