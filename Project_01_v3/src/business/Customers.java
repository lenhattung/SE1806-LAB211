/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Customer;
import tools.Inputter;

/**
 *
 * @author tungi
 */
public class Customers extends HashSet<Customer> implements Workable<Customer, String> {

    private boolean saved;
    private String pathFile;

    public Customers(String pathFile) {
        this.pathFile = pathFile;
        this.saved = false;
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
            this.saved = false;
        } else {
            System.out.println("Error: Customer Aldready Exists!");
        }
    }

    @Override
    public void update(Customer t) {
        this.remove(t);
        this.add(t);
        this.saved = false;
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

    public void saveToFile() {
        // -- 0. Neu da luu roi thi khong luu nua
        if (this.saved) {
            return;
        }

        FileOutputStream fos = null;
        try {
            //-- 1. Tao File object
            File f = new File(this.pathFile);
            if (!f.exists()) {
                f.createNewFile();
            }

            //-- 2. Tao FileutputStream
            fos = new FileOutputStream(f);

            //-- 3. Tao oos
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            //-- 4. Ghi file
            for (Customer c : this) {
                oos.writeObject(c);
            }
            //-- 5. Dong cac objcet
            oos.close();
            //--6. Thay doi trang thai cua saved
            this.saved = true;
        } catch (Exception e) {
            Logger.getLogger(Customers.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                fos.close();
            } catch (Exception e) {
                Logger.getLogger(Customers.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
}
