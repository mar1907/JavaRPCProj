package ro.ds.common.serviceinterface;

import ro.ds.common.entity.Car;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IPriceCalculator extends Remote {

    double computePrice(Car c) throws RemoteException;
}
