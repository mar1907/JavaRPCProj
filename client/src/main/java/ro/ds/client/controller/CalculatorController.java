package ro.ds.client.controller;

import ro.ds.client.view.CalculatorView;
import ro.ds.common.entity.Car;
import ro.ds.common.serviceinterface.IPriceCalculator;
import ro.ds.common.serviceinterface.ITaxCalculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

public class CalculatorController {

    private static final String  INVALID_INPUT = "Invalid input.";
    private CalculatorView calculatorView;
    private IPriceCalculator priceCalculator;
    private ITaxCalculator taxCalculator;

    public CalculatorController(CalculatorView calculatorView, IPriceCalculator priceCalculator, ITaxCalculator taxCalculator) {
        this.calculatorView = calculatorView;
        this.priceCalculator = priceCalculator;
        this.taxCalculator = taxCalculator;

        calculatorView.addBtnPriceActionListener(new PriceActionListener());
        calculatorView.addBtnTaxActionListener(new TaxActionListener());
    }

    class TaxActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            calculatorView.clearOutput();

            try {
                int year = Integer.parseInt(calculatorView.getYear());
                int engineSize = Integer.parseInt(calculatorView.getEngineSize());
                double price = Double.parseDouble(calculatorView.getPurchasingPrice());

                Car c = new Car(year, engineSize, price);

                double tax;

                tax = taxCalculator.computeTax(c);

                calculatorView.setTax(tax);

                calculatorView.clearInput();

            } catch (NumberFormatException ex){
                ex.printStackTrace();
                displayErrorMessage(INVALID_INPUT);
            } catch (RemoteException ex){
                ex.printStackTrace();
                displayErrorMessage("Connection error");
            } catch (IllegalArgumentException ex) {
                ex.printStackTrace();
                displayErrorMessage(ex.getMessage());
            }
        }
    }

    class PriceActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            calculatorView.clearOutput();

            try {
                int year = Integer.parseInt(calculatorView.getYear());
                int engineSize = Integer.parseInt(calculatorView.getEngineSize());
                double price = Double.parseDouble(calculatorView.getPurchasingPrice());

                Car c = new Car(year, engineSize, price);

                double sellingPrice;

                sellingPrice = priceCalculator.computePrice(c);

                calculatorView.setSellingPrice(sellingPrice);

                calculatorView.clearInput();

            } catch (NumberFormatException ex){
                ex.printStackTrace();
                displayErrorMessage(INVALID_INPUT);
            } catch (RemoteException ex){
                ex.printStackTrace();
                displayErrorMessage("Connection error");
            } catch (IllegalArgumentException ex) {
                ex.printStackTrace();
                displayErrorMessage(ex.getMessage());
            }
        }
    }

    private void displayErrorMessage(String message) {
        calculatorView.clearInput();
        calculatorView.clearOutput();
        JOptionPane.showMessageDialog(calculatorView, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
