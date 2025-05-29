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
         // Tạo sẵn một số customer mẫu
        this.add(new Customer("C0001", "Nguyen Van An", "0901234567", "nguyenvanan@gmail.com"));
        this.add(new Customer("G0002", "Tran Thi Binh", "0912345678", "tranthibinh@yahoo.com"));
        this.add(new Customer("K0003", "Le Van Cuong", "0923456789", "levancuong@hotmail.com"));
        this.add(new Customer("C0004", "Pham Thi Dung", "0934567890", "phamthidung@outlook.com"));
        this.add(new Customer("G0005", "Hoang Van Em", "0945678901", "hoangvanem@gmail.com"));
        this.add(new Customer("K0006", "Vu Thi Fang", "0956789012", "vuthifang@yahoo.com"));
        this.add(new Customer("C0007", "Dao Van Giang", "0967890123", "daovangiang@gmail.com"));
        this.add(new Customer("G0008", "Bui Thi Hoa", "0978901234", "buithihoa@hotmail.com"));
        this.add(new Customer("K0009", "Ly Van Inh", "0989012345", "lyvaninh@outlook.com"));
        this.add(new Customer("C0010", "Do Thi Kim", "0990123456", "dothikim@gmail.com"));
    }

    public boolean isDupplicate(Customer t) {
        return this.contains(t);
        //        for (Customer c : this) {
        //            if (c.getCustomerCode().equals(t.getCustomerCode())) {
        //                return true;
        //            }
        //        }
        //        return false;
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
        this.remove(t);
        this.add(t);
    }

    @Override
    public void showAll() {
        showAll(this);
    }

    public void showAll(HashSet<Customer> h) {
        System.out.println("-------------------------------------------------------------");
        System.out.format("%-6s | %-25s | %-11s | %-20s%n", "Code", "Customer Name", "Phone", "Email");
        System.out.println("-------------------------------------------------------------");
        for (Customer c : h) {
            System.out.format("%-6s | %-25s | %-11s | %-20s%n", c.getCustomerCode(), c.getName(), c.getPhone(), c.getEmail());
        }
        System.out.println("-------------------------------------------------------------");
    }

    @Override
    public Customer searchById(String id) {
        for (Customer c : this) {
            if (c.getCustomerCode().equals(id)) {
                return c;
            }
        }
        return null;
    }

    public HashSet<Customer> filterByName(String name) {
        HashSet<Customer> result = new HashSet<>();
        for (Customer c : this) {
            String cName = c.getName().toUpperCase();
            String kName = name.toUpperCase();
            if (cName.indexOf(kName) > -1) {
                result.add(c);
            }
        }
        return result;
    }
}
