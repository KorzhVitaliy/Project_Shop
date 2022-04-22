package controllers;

import models.Purchase;
import views.PurchaseView;

public class PurchaseController {

    Purchase model;
    PurchaseView view;

    public PurchaseController(Purchase model, PurchaseView view) {
        this.model = model;
        this.view = view;
    }

    public void runApp() {
        view.getInputs();

        String name = model.getClientName();

        //Расчет стоимости без скидки
        double initialPayment = model.calculatePayment(model.getQuantity(), model.getPrice());

        //Расчёт процента скидки
        int discountRate = model.getDiscountRate(model.getQuantity());

        //Расчёт скидки
        double discount = model.calculateDiscount(initialPayment, discountRate);

        //Окончательная сумма к оплате
        double totalPayment = model.calculatePayment(initialPayment, discount);

        String output = "------------------------------\n" +
                "Client name: " + name + "\n" +
                "Purchase amount (USD): " + initialPayment + "\n" +
                "Discount amount (USD): " + discount + "\n" +
                "For payment (USD): " + totalPayment;

        view.getOutput(output);
    }
}
