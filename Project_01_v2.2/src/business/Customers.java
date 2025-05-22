/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import java.util.HashSet;
import models.Customer;
import tools.Inputter;

/**
 *
 * @author tungi
 */
public class Customers extends HashSet<Customer> implements Workable<Customer, String> {

    public Customers() {
    }

    public boolean isDupplicate(Customer t) {
        //return this.contains(t);
        for (Customer c : this) {
            if (c.getCustomerCode().equals(t.getCustomerCode())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void addNew(Customer t) {
        if (!this.isDupplicate(t)) {
            this.add(t);
        } else {
            System.out.println("Error: Customer Aldready Exists!");
        }
    }

    @Override
    public void update(Customer t) {
    }

    @Override
    public void showAll() {
        System.out.println("-------------------------------------------------------------");
        System.out.format("%-6s | %-25s | %-11s | %-20s%n", "Code", "Customer Name", "Phone", "Email");
        System.out.println("-------------------------------------------------------------");
        for (Customer c : this) {
            System.out.format("%-6s | %-25s | %-11s | %-20s%n", c.getCustomerCode(), c.getName(), c.getPhone(), c.getEmail());
        }
        System.out.println("-------------------------------------------------------------");
    }

    @Override
    public Customer searchById(String id) {
        return null;
    }
}
