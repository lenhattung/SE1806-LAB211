/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.util.Scanner;
import models.Customer;
import models.Inputter;
import models.Order;
import models.SetMenu;

/**
 *
 * @author tungi
 */
public class Main {
    public static void main(String[] args) {
        Inputter inputter = new Inputter();
        Customer c = inputter.inputCustomer();
        Order o = inputter.inputOrder();
        SetMenu s = inputter.inputSetMenu();
    }
}
