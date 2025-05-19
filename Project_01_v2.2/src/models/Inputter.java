package models;

import java.util.Scanner;

/**
 *
 * @author tungi
 */
public class Inputter {

    private Scanner scanner;

    public Inputter() {
        scanner = new Scanner(System.in);
    }

    public Customer inputCustomer() {
        Customer customer = new Customer();
        customer.setCustomerCode(inputCustomerCode());
        customer.setName(inputName());
        customer.setPhone(inputPhone());
        customer.setEmail(inputEmail());
        return customer;
    }

    public Order inputOrder() {
        return null;
    }

    public SetMenu inputSetMenu() {
        return null;
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
            more = !Validator.isValid(input, regex);
            if (more) {
                System.out.println(errMsg + ". Please re-enter...");
            }
        } while (more);

        return input;
    }

    public String inputCustomerCode() {
        String msg = "Input Customer Code (the first character is [C,G,K], followed by 4 digits): ";
        String errorMsg = "Customer code cannot be empty! Customer code must start with C, G, K, followed by 4 digits!";
        String regex = Validator.customerCodeRegex;
        return input(msg, errorMsg, regex);
    }

    public String inputName() {
        String msg = "Input name: ";
        String errorMsg = "Name cannot be empty. Name must be between 2 and 25 characters.";
        String regex = Validator.nameRegex;
        return input(msg, errorMsg, regex);
    }

    public String inputEmail() {
        String msg = "Input email: ";
        String errorMsg = "Invalid email format!";
        String regex = Validator.emailRegex;
        return input(msg, errorMsg, regex);
    }

    public String inputPhone() {
        String msg = "Input phone: ";
        String errorMsg = "Invalid phone format!";
        String regex = Validator.emailRegex;
        return input(msg, errorMsg, regex);
    }
}
