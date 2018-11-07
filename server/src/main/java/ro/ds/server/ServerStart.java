package ro.ds.server;

import ro.ds.common.serviceinterface.IPriceCalculator;
import ro.ds.common.serviceinterface.ITaxCalculator;
import ro.ds.server.service.PriceCalculator;
import ro.ds.server.service.TaxCalculator;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServerStart {

    public static void main(String[] args) {
        try {
            IPriceCalculator priceCalculator = new PriceCalculator();
            IPriceCalculator priceStub = (IPriceCalculator) UnicastRemoteObject
                    .exportObject(priceCalculator, 0);

            ITaxCalculator taxCalculator = new TaxCalculator();
            ITaxCalculator taxStub = (ITaxCalculator) UnicastRemoteObject
                    .exportObject(taxCalculator, 0);

            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("IPriceCalculator", priceStub);
            registry.rebind("ITaxCalculator", taxStub);
        } catch (RemoteException e){
            e.printStackTrace();
        }
    }
}
