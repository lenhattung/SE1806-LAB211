package tools;

import java.util.Scanner;
import models.Customer;

/**
 *
 * @author tungi
 */
public class Inputter {

    private Scanner scanner;

    public Inputter() {
        scanner = new Scanner(System.in);
    }

    public String getString(String msg) {
        System.out.println(msg);
        return scanner.nextLine();
    }

    public int getInt(String msg) {
        String temp = getString(msg);
        int result = 0;
        try {
            result = Integer.parseInt(temp);
        } catch (Exception e) {
        }
        return result;
    }

    public double getDouble(String msg) {
        String temp = getString(msg);
        double result = 0;
        try {
            result = Double.parseDouble(temp);
        } catch (Exception e) {
        }
        return result;
    }

    public String input(String msg, String errorMsg, String regex) {
        String input;
        String errMsg = errorMsg;
        boolean more = true;
        do {
            input = getString(msg);
            more = !Acceptable.isValid(input, regex);
            if (more) {
                System.out.println(errMsg + ". Please re-enter...");
            }
        } while (more);

        return input;
    }

    public Customer inputCustomer() {
        Customer customer = new Customer();

        String msg = "Input Customer Code (the first character is [C,G,K], followed by 4 digits): ";
        String errorMsg = "Customer code cannot be empty! Customer code must start with C, G, K, followed by 4 digits!";
        String regex = Acceptable.customerCodeRegex;
        customer.setCustomerCode(input(msg, errorMsg, regex).toUpperCase());

        msg = "Input name: ";
        errorMsg = "Name cannot be empty. Name must be between 2 and 25 characters.";
        regex = Acceptable.nameRegex;
        customer.setName(input(msg, errorMsg, regex));

        msg = "Input phone: ";
        errorMsg = "Invalid phone format!";
        regex = Acceptable.phoneRegex;
        customer.setPhone(input(msg, errorMsg, regex));

        msg = "Input email: ";
        errorMsg = "Invalid email format!";
        regex = Acceptable.emailRegex;
        customer.setEmail(input(msg, errorMsg, regex));

        return customer;
    }

//    public SetMenu inputSetMenu() {
//        return null;
//    }
//
//    public Order inputOrder() {
//        String msg, errorMsg, regex;
//        Order o = new Order();
//        o.setOrderId(regex);
//        o.setCustomerCode(errorMsg);
//        o.setCodeOfSetMenu(regex);
//        o.setNumberOfTables(regex);
//        o.setEventDate(eventDate);
//    }
}
