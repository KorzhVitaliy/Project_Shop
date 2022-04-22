package base;

public interface Payment {

    double calculatePayment(int quantity, double price);
    double calculatePayment(double payment, double discount);

}
