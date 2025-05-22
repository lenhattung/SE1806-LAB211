/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dispatcher;

import business.Customers;
import java.util.Scanner;
import models.Customer;
import tools.Inputter;
import models.Order;
import models.SetMenu;

/**
 *
 * @author tungi
 */
public class Main {

    public static void main(String[] args) {
        Inputter ip = new Inputter();
        Customers customers = new Customers();

        Scanner scanner = new Scanner(System.in);

        int testCase = 10;
        do {
            System.out.println("\n----------------------\n");
            System.out.println("1. Register customers");
            System.out.println("2. Update customer information");
            System.out.println("3. Seach for customer information by name");
            System.out.println("8. Display all customers");
            System.out.println("10. Exit");
            System.out.print("Enter Test Case No. : ");
            testCase = Integer.parseInt(scanner.nextLine());
            switch (testCase) {
                case 1:
                    int option = 0;
                    do {
                        Customer c = ip.inputCustomer();
                        if (!customers.isDupplicate(c)) {
                            customers.addNew(c);
                        } else {
                            System.out.println("Error: Customer Aldready Exists!");
                        }

                        System.out.println("1. Continue entering new customers");
                        System.out.println("2. Return to the main menu");
                        System.out.println("Entor your option: ");
                        option = Integer.parseInt(scanner.nextLine());
                    } while (option != 2);
                    break;
                case 8:
                    customers.showAll();
                    break;
                default:
                    throw new AssertionError();
            }
        } while (testCase != 10);
    }
}
