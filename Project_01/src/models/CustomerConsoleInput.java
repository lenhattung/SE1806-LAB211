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
    private CustomerCodeValidator codeValidator;
    private NameValidator nameValidator;
    private EmailValidator emailValidator;
    private PhoneValidator phoneValidator;

    public CustomerConsoleInput() {
        scanner = new Scanner(System.in);
        codeValidator = new CustomerCodeValidator();
        nameValidator = new NameValidator();
        emailValidator = new EmailValidator();
        phoneValidator = new PhoneValidator();
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
        do {
            System.out.print("Input Customer Code (the first character is [C,G,K], followed by 4 digits): ");
            input = scanner.nextLine();

            if (!codeValidator.isValid(input)) {
                System.out.println(codeValidator.getErrorMessage() + ". Please re-enter...");
            }
        } while (!codeValidator.isValid(input));

        return input;
    }

    public String inputName() {
        String input;
        do {
            System.out.print("Input name: ");
            input = scanner.nextLine();

            if (!nameValidator.isValid(input)) {
                System.out.println(nameValidator.getErrorMessage() + ". Please re-enter...");
            }
        } while (!nameValidator.isValid(input));

        return input;
    }

    public String inputEmail() {
        String input;
        do {
            System.out.print("Input email: ");
            input = scanner.nextLine();

            if (!emailValidator.isValid(input)) {
                System.out.println(emailValidator.getErrorMessage() + ". Please re-enter...");
            }
        } while (!emailValidator.isValid(input));

        return input;
    }

    public String inputPhone() {
        String input;
        do {
            System.out.print("Input phone: ");
            input = scanner.nextLine();

            if (!phoneValidator.isValid(input)) {
                System.out.println(phoneValidator.getErrorMessage() + ". Please re-enter...");
            }
        } while (!phoneValidator.isValid(input));

        return input;
    }
}

class CustomerCodeValidator implements Validator<String> {

    private final String regex = "^[CGKcgk]\\d{4}$";
    private String errorMessage = "";

    @Override
    public boolean isValid(String value) {
        if (value == null || value.isEmpty()) {
            errorMessage = "Customer code cannot be empty!";
            return false;
        }
        if (!value.matches(regex)) {
            errorMessage = "Customer code must start with C, G, K, followed by 4 digits!";
            return false;
        }
        return true;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }
}

class NameValidator implements Validator<String> {

    private String errorMessage = "";

    @Override
    public boolean isValid(String name) {
        if (name == null || name.isEmpty()) {
            errorMessage = "Name cannot be empty";
            return false;
        }

        if (name.length() < 2 || name.length() > 25) {
            errorMessage = "Name must be between 2 and 25 characters";
            return false;
        }

        return true;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }
}

class EmailValidator implements Validator<String> {

    private final String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private String errorMessage = "";

    @Override
    public boolean isValid(String email) {
        if (email == null || email.isEmpty()) {
            errorMessage = "Email cannot be empty";
            return false;
        }

        if (!email.matches(regex)) {
            errorMessage = "Invalid email format";
            return false;
        }

        return true;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }
}

class PhoneValidator implements Validator<String> {

    private final String regex = "^\\d{10}$";  // Ví dụ đơn giản, có thể điều chỉnh
    private String errorMessage = "";

    @Override
    public boolean isValid(String phone) {
        if (phone == null || phone.isEmpty()) {
            errorMessage = "Phone number cannot be empty";
            return false;
        }

        if (!phone.matches(regex)) {
            errorMessage = "Phone must be 10-15 digits";
            return false;
        }

        return true;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }
}
