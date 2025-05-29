/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dispatcher;

import business.Customers;
import business.Orders;
import business.SetMenus;
import java.util.Date;
import java.util.HashSet;
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
        Inputter inputter = new Inputter();
        Customers customers = new Customers();
        Orders orders = new Orders();
        SetMenus setmenus = new SetMenus("D:\\OneDrive\\Teaching\\FPT\\Lab211\\Set14_SU25\\De_LAB211\\01_J1.L.P0028.TraditionalFeastOrderManagement_300LOC\\FeastMenu.csv");

        Scanner scanner = new Scanner(System.in);

        int testCase = 10;
        do {
            System.out.println("\n----------MAIN MENU------------");
            System.out.println("1. Register customers");
            System.out.println("2. Update customer information");
            System.out.println("3. Seach for customer information by name");
            System.out.println("4. Display feast menu");
            System.out.println("5. Place a feast order");
            System.out.println("8. Display all customers");
            System.out.println("10. Exit");
            System.out.print("Enter Test Case No. : ");
            testCase = Integer.parseInt(scanner.nextLine());
            switch (testCase) {
                case 1:
                    int option = 0;
                    do {
                        customers.addNew(inputter.inputCustomer(false));
                        System.out.println("1. Continue entering new customers");
                        System.out.println("2. Return to the main menu");
                        System.out.println("Enter your option: ");
                        option = Integer.parseInt(scanner.nextLine());
                    } while (option != 2);
                    break;
                case 2:
                    option = 0;
                    do {
                        System.out.print("Enter customer code: ");
                        String customerCode = scanner.nextLine();
                        Customer c = customers.searchById(customerCode);
                        if (c == null) {
                            System.out.println("This customer does not exist.");
                        } else {
                            Customer customer = inputter.inputCustomer(true);
                            customer.setCustomerCode(customerCode);
                            customers.update(customer);
                        }
                        System.out.println("1. Continue updating customer");
                        System.out.println("2. Return to the main menu");
                        System.out.println("Enter your option: ");
                    } while (option != 2);
                    break;
                case 3:
                    option = 0;
                    do {
                        System.out.print("Enter customer name: ");
                        String name = scanner.nextLine();
                        HashSet<Customer> cs = customers.filterByName(name);
                        if (cs.isEmpty()) {
                            System.out.println("No one matches the search criteria.");
                        } else {
                            customers.showAll(cs);
                        }
                        System.out.println("1. Continue search");
                        System.out.println("2. Return to the main menu");
                        System.out.println("Enter your option: ");
                    } while (option != 2);
                    break;
                case 4: {
                    try {
                        setmenus.readFromFile();
                    } catch (Exception e) {
                    }

                    setmenus.showAll();
                }
                break;
                case 5:
                    Order order = inputter.inputOrder(customers, setmenus);
                    if (orders.contains(order)) {
                        System.out.println("Dupplicate data!");
                    } else {
                        orders.addNew(order);
                        order.display(customers, setmenus);
                    }

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
