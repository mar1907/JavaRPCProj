package ro.ds.common.serviceinterface;

import ro.ds.common.entity.Car;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ITaxCalculator extends Remote {

    double computeTax(Car c) throws RemoteException;
}
