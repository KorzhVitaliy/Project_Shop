package controllers;

import models.Purchase;
import utils.Rounder;
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
        String paymentInitialRounded = Rounder.roundValue(initialPayment);

        //Расчёт процента скидки
        int discountRate = model.getDiscountRate(model.getQuantity());

        //Расчёт скидки
        double discount = model.calculateDiscount(initialPayment, discountRate);
        String discountRounded = Rounder.roundValue(discount);

        //Окончательная сумма к оплате
        double totalPayment = model.calculatePayment(initialPayment, discount);
        String totalPaymentRounded = Rounder.roundValue(totalPayment);

        String output = "------------------------------\n" +
                "Client name: " + name + "\n" +
                "Purchase amount (USD): " + paymentInitialRounded + "\n" +
                "Your discount rate is: " + discountRate + "%" + "\n" +
                "Discount amount (USD): " + discountRounded + "\n" +
                "For payment (USD): " + totalPaymentRounded;

        view.getOutput(output);
    }
}
