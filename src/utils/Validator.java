package utils;

import java.util.Scanner;

public class Validator {

    // Валидация ввода имени
    public static String validateName(Scanner scanner) {
        String str = scanner.nextLine().trim();
        while (str.isEmpty()) {
            System.out.print(Constants.EMPTY_NAME_MSG);
            str = scanner.nextLine().trim();
        }
        return str;
    }

    // Валидация ввода количества
    public static int validateQuantityInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            String str = scanner.nextLine().trim();
            System.out.printf(Constants.NAN_QUANTITY_MSG, str);
        }
        int quantity = scanner.nextInt();
        while (quantity <= 0) {
            System.out.println(Constants.INCORRECT_QUANTITY_MSG);
            while (!scanner.hasNextInt()) {
                String str = scanner.next().trim();
                System.out.printf(Constants.NAN_QUANTITY_MSG, str);
            }
            quantity = scanner.nextInt();
        }
        return quantity;
    }

    // Валидация ввода цены
    public static double validatePriceInput(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            String str = scanner.nextLine().trim();
            System.out.printf(Constants.NAN_PRICE_MSG,str);
        }
        double price = scanner.nextDouble();
        while (price <= 0) {
            while (!scanner.hasNextDouble()) {
                String str = scanner.nextLine().trim();
                System.out.printf(Constants.NAN_PRICE_MSG, str);
            }
            price = scanner.nextDouble();
        }
        return price;
    }
}
