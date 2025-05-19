/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.util.Scanner;
import models.Customer;
import models.CustomerConsoleInput;

/**
 *
 * @author tungi
 */
public class Main {
    public static void main(String[] args) {
        CustomerConsoleInput cci = new CustomerConsoleInput();
        Customer c = cci.inputCustomer();
    }
}
