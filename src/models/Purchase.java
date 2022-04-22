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

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    //Расчёт скидки по колличеству товара
    @Override
    public double calculateDiscount(int quantity, int discount) {
        if (quantity > 3) {
            discount = 5;
        } else if (quantity > 10) {
            discount = 10;
        } else if (quantity > 20) {
            discount = 25;
        } else {
            discount = 0;
        }

        return discount;
    }

    //Расчёт платежа без скидки
    @Override
    public double calculatePayment(int quantity, double price) {
        return quantity * price;
    }

    //Расчёт платежа со скидкой
    @Override
    public double calculatePayment(double payment, double discount) {
        return payment * discount / 100;
    }
}
