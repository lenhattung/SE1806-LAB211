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

    private static final int REGISTER_CUSTOMERS = 1;
    private static final int UPDATE_CUSTOMER = 2;
    private static final int SEARCH_CUSTOMER = 3;
    private static final int DISPLAY_MENU = 4;
    private static final int PLACE_ORDER = 5;
    private static final int UPDATE_ORDER = 6;
    private static final int SAVE_DATA = 7;
    private static final int DISPLAY_ALL = 8;
    private static final int EXIT = 9;

    private static final int CONTINUE_OPTION = 1;
    private static final int RETURN_TO_MAIN = 2;

    private static final String CUSTOMERS_FILE = "customers.dat";
    private static final String ORDERS_FILE = "feast_order_service.dat";
    private static final String MENU_FILE = "FeastMenu.csv";

    private static Inputter inputter;
    private static Customers customers;
    private static Orders orders;
    private static SetMenus setMenus;
    private static Scanner scanner;

    private static void initializeSystem() {
        inputter = new Inputter();
        customers = new Customers(CUSTOMERS_FILE);
        orders = new Orders(ORDERS_FILE);
        setMenus = new SetMenus(MENU_FILE);
        scanner = new Scanner(System.in);
    }

    private static void displayMainMenu() {
        System.out.println("\n----------MAIN MENU------------");
        System.out.println("1. Register customers");
        System.out.println("2. Update customer information");
        System.out.println("3. Seach for customer information by name");
        System.out.println("4. Display feast menu");
        System.out.println("5. Place a feast order");
        System.out.println("6. ");
        System.out.println("7. Save data to file");
        System.out.println("8. Display all customers");
        System.out.println("9. Exit");
        System.out.print("Enter Test Case No. : ");
    }

    private static int getMenuChoice() {
        return Integer.parseInt(scanner.nextLine());
    }

    private static void runMainMenu() {
        int testCase = EXIT;
        do {
            displayMainMenu();
            testCase = getMenuChoice();
            processMenuChoice(testCase);
        } while (testCase != EXIT);
    }

    private static void handleCustomerRegistration() {
        int option = 0;
        do {
            customers.addNew(inputter.inputCustomer(false));
            System.out.println("1. Continue entering new customers");
            System.out.println("2. Return to the main menu");
            System.out.println("Enter your option: ");
            option = Integer.parseInt(scanner.nextLine());
        } while (option != RETURN_TO_MAIN);
    }

    private static void handleCustomerUpdate() {
        int option = 0;
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
    }

    private static void handleCustomerSearch() {
        int option = 0;
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
    }

    private static void handleMenuDisplay() {
        try {
            setMenus.readFromFile();
        } catch (Exception e) {
        }
        setMenus.showAll();
    }

    private static void handleOrderPlacement() {
        Order order = inputter.inputOrder(customers, setMenus);
        if (orders.contains(order)) {
            System.out.println("Dupplicate data!");
        } else {
            orders.addNew(order);
            order.display(customers, setMenus);
        }
    }

    private static void handleOrderUpdating() {
    }

    private static void handleDataSaving() {
        customers.saveToFile();
        orders.saveToFile();
        System.out.println("The data is successfully saved!");
    }

    private static void handleDisplayAll() {
        Customers customers_temp = new Customers("customers.dat");
        Orders orders_temp = new Orders("feast_order_service.dat");
        if (customers_temp.size() > 0) {
            customers_temp.showAll();
        } else if (orders_temp.size() > 0) {
            orders_temp.showAll();
        } else {
            System.out.println("No data in the system!");
        }
    }

    private static void handleExit() {
    }

    private static void processMenuChoice(int testCase) {
        switch (testCase) {
            case REGISTER_CUSTOMERS:
                handleCustomerRegistration();
                break;
            case UPDATE_CUSTOMER:
                handleCustomerUpdate();
                break;
            case SEARCH_CUSTOMER:
                handleCustomerSearch();
                break;
            case DISPLAY_MENU:
                handleMenuDisplay();
                break;
            case PLACE_ORDER:
                handleOrderPlacement();
                break;
            case UPDATE_ORDER:
                handleOrderUpdating();
                break;
            case SAVE_DATA:
                handleDataSaving();
                break;
            case DISPLAY_ALL:
                handleDisplayAll();
                break;
            case EXIT:
                handleExit();
                break;
            default:
                throw new AssertionError();
        }
    }
    
    public static void main(String[] args) {
        initializeSystem();
        runMainMenu();
    }

}
