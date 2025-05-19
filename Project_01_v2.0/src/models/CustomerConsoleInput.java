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
    

    public String inputCustomerCode() {
        String input;
        String errMsg = "Customer code cannot be empty!. Customer code must start with C, G, K, followed by 4 digits!";
        do {
            System.out.print("Input Customer Code (the first character is [C,G,K], followed by 4 digits): ");
            input = scanner.nextLine();

            if (!Validator.isValid(input, Validator.customerCodeRegex)) {
                System.out.println(errMsg + ". Please re-enter...");
            }
        } while (!Validator.isValid(input, Validator.customerCodeRegex));

        return input;
    }

    public String inputName() {
        String input;
        String errMsg = "Name cannot be empty. Name must be between 2 and 25 characters.";
        do {
            System.out.print("Input name: ");
            input = scanner.nextLine();

            if (!Validator.isValid(input, Validator.nameRegex)) {
                System.out.println(errMsg + ". Please re-enter...");
            }
        } while (!Validator.isValid(input, Validator.nameRegex));

        return input;
    }

    public String inputEmail() {
        String input;
        String errMsg = "Invalid email format!";
        do {
            System.out.print("Input email: ");
            input = scanner.nextLine();

            if (!Validator.isValid(input, Validator.emailRegex)) {
                System.out.println(errMsg + ". Please re-enter...");
            }
        } while (!Validator.isValid(input, Validator.emailRegex));

        return input;
    }

    public String inputPhone() {
        String input;
        String errMsg = "Invalid phone format!";
        do {
            System.out.print("Input phone: ");
            input = scanner.nextLine();

            if (!Validator.isValid(input, Validator.phoneRegex)) {
                System.out.println(errMsg + ". Please re-enter...");
            }
        } while (!Validator.isValid(input, Validator.phoneRegex));

        return input;
    }
}
