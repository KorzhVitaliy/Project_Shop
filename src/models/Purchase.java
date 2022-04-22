package models;

import base.Discount;
import base.Payment;

public class Purchase implements Discount, Payment {

    private String clientName;
    private int quantity;
    private double price;
    private int discount;

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDiscountRate(double payment) {
        if (payment > 50) {
            discount = 5;
        }
        if (payment > 100) {
            discount = 10;
        }
        if (payment > 100) {
            discount = 15;
        }

        return discount;
    }

    //Расчёт скидки
    @Override
    public double calculateDiscount(double payment, int discount) {
        return payment * discount / 100;
    }

    //Расчёт платежа без скидки
    @Override
    public double calculatePayment(int quantity, double price) {
        return quantity * price;
    }

    //Расчёт платежа со скидкой
    @Override
    public double calculatePayment(double payment, double discount) {
        return payment - discount;
    }
}
