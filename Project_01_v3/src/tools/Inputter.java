package tools;

import business.Customers;
import business.SetMenus;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import javax.sound.midi.SysexMessage;
import models.Customer;
import models.Order;

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

    public Customer inputCustomer(boolean isUpdated) {
        Customer customer = new Customer();

        String msg = "Input Customer Code (the first character is [C,G,K], followed by 4 digits): ";
        String errorMsg = "Customer code cannot be empty! Customer code must start with C, G, K, followed by 4 digits!";
        String regex = Acceptable.customerCodeRegex;
        if (!isUpdated) {
            customer.setCustomerCode(input(msg, errorMsg, regex).toUpperCase());
        }

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
    public Order inputOrder(Customers customers, SetMenus setMenus) {
        // ----
        String customerCode = "";
        boolean checkCustomerCode = false;
        do {
            String msg = "Enter Customer code:";
            String errorMsg = "Customer code cannot be empty! Customer code must start with C, G, K, followed by 4 digits!";
            String regex = Acceptable.customerCodeRegex;
            customerCode = input(msg, errorMsg, regex).toUpperCase();

            if (customers.searchById(customerCode) != null) {
                checkCustomerCode = true;
            } else {
                System.out.println("Customer is not exists!");
            }

        } while (!checkCustomerCode);

        // ----
        String setMenuCode = "";
        boolean checkSetMenuCode = false;
        do {
            System.out.println("Enter SetMenu code:");
            setMenuCode = scanner.nextLine();
            if (setMenus.contains(setMenuCode)) {
                checkSetMenuCode = true;
            } else {
                System.out.println("SetMenu is not exists!");
            }
        } while (!checkSetMenuCode);

        // ---- 
        int numberOfTables = 0;
        String msg = "Enter number of tables:";
        String errorMsg = "Number of tables must be greater than zero!";
        String regex = Acceptable.positive_integer;
        numberOfTables = Integer.parseInt(input(msg, errorMsg, regex).toUpperCase());

        // ---
        Date evenDate = null;
        boolean checkEventDate = false;
        do {
            try {
                System.out.println("Enter preferred event date:");
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String inputDate = scanner.nextLine().trim();
                evenDate = sdf.parse(inputDate);
                Date today = new Date();
                if (evenDate.after(today)) {
                    checkEventDate = true;
                } else {
                    System.out.println("Error: Event date must be in the future.");
                }
            } catch (Exception e) {
            }
        } while (!checkEventDate);

        // ----
        Order newOrder = new Order(customerCode, setMenuCode, numberOfTables, evenDate);
        return newOrder;

    }
}
