/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.Scanner;

/**
 *
 * @author tungi
 */
public class CustomerConsoleInput {

    private Scanner scanner;

    public CustomerConsoleInput() {
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

    public String input(String msg, String errorMsg, String regex) {
        String input;
        String errMsg = errorMsg;
        do {
            System.out.print(msg);
            input = scanner.nextLine();

            if (!Validator.isValid(input, regex)) {
                System.out.println(errMsg + ". Please re-enter...");
            }
        } while (!Validator.isValid(input, regex));

        return input;
    }

    public String inputCustomerCode() {
        String msg = "Input Customer Code (the first character is [C,G,K], followed by 4 digits): ";
        String errorMsg = "Customer code cannot be empty!. Customer code must start with C, G, K, followed by 4 digits!";
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
