package ro.ds.client;

import ro.ds.client.controller.CalculatorController;
import ro.ds.client.view.CalculatorView;
import ro.ds.common.serviceinterface.IPriceCalculator;
import ro.ds.common.serviceinterface.ITaxCalculator;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientStart {

    public static void main(String[] args) {

        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            IPriceCalculator priceCalculator = (IPriceCalculator) registry
                    .lookup("IPriceCalculator");

            ITaxCalculator taxCalculator = (ITaxCalculator) registry
                    .lookup("ITaxCalculator");

            CalculatorView calculatorView = new CalculatorView();

            new CalculatorController(calculatorView, priceCalculator, taxCalculator);

            calculatorView.setVisible(true);
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }
}
