package application;

import entities.order.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class ProgramOrder {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter client data:");
        System.out.print("Name: ");
        String nameClient = sc.nextLine();
        System.out.print("Email: ");
        String emailClient = sc.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        String birthClient = sc.nextLine();

        Client client = new Client(nameClient , emailClient , sdf.parse(birthClient));

        System.out.println("Enter order data:");
        System.out.print("Status: ");
        String orderStatus = sc.nextLine();

        Order order = new Order(new Date() , OrderStatus.valueOf(orderStatus), client);

        System.out.print("How many items to this order? ");
        int nItems = sc.nextInt();
        for (int i = 0 ; i < nItems ; i++) {
            System.out.println("Enter #" + (i + 1) + " item data:");
            System.out.print("Product name: ");
            sc.nextLine();
            String nameProduct = sc.nextLine();
            System.out.print("Product price: ");
            double priceProduct = sc.nextDouble();
            System.out.print("Quantity: ");
            int quantityProduct = sc.nextInt();

            OrderItem orderItem = new OrderItem(quantityProduct , priceProduct , new Product(nameProduct , priceProduct));
            order.addItem(orderItem);
        }

        System.out.println();
        System.out.println("ORDER SUMMARY:");
        System.out.println(order);

        sc.close();
    }
}
