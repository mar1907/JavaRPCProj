package ro.ds.common.entity;

import java.io.Serializable;

public class Car implements Serializable {

    private static final long serialVersionUID = 1L;
    private int year;
    private int engineCapacity;
    private double price;

    public Car() {
    }

    public Car(int year, int engineCapacity, double price) {
        this.year = year;
        this.engineCapacity = engineCapacity;
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(int engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "year=" + year +
                ", engineCapacity=" + engineCapacity +
                ", price=" + price +
                '}';
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + engineCapacity;
        result = prime * result + year;
        result = prime * result + (int) Math.round(price);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Car other = (Car) obj;
        if (engineCapacity != other.engineCapacity)
            return false;
        if (year != other.year)
            return false;
        if (price != other.price)
            return false;
        return true;
    }
}
