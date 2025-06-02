/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Customer;
import models.Order;
import models.SetMenu;

/**
 *
 * @author tungi
 */
public class Orders extends ArrayList<Order> implements Workable<Order, String> {

    private boolean saved;
    private String pathFile;

    public Orders(String pathFile) {
        this.pathFile = pathFile;
        this.readFromFile();
    }

    @Override
    public void addNew(Order t) {
        if (!isDupplicated(t)) {
            this.add(t);
            this.saved = false;
        }
    }

    @Override
    public void update(Order t) {
        this.saved = false;
    }

    @Override
    public void showAll() {
    }

    @Override
    public Order searchById(String id) {
        return null;
    }

    public boolean isDupplicated(Order o) {
        return this.contains(o);
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
            for (Order o : this) {
                oos.writeObject(o);
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
    
    public void readFromFile(){
        FileInputStream fis = null;
        try {
            // B1 - Tao doi tuong file de anh xa len tap tin
            File f = new File(this.pathFile);
            // B2 - Kiem tra su ton tai cua file
            if (!f.exists()) {
                System.out.println("Cannot read data from "+this.pathFile+". Please check it.");
                return;
            } else {
                // B3 - Tao fis
                fis = new FileInputStream(f);
                // B4 - Tap ois
                ObjectInputStream ois = new ObjectInputStream(fis);
                // B5 - Doc tung doi tuong
                try {
                    while (true) {
                        Object o = ois.readObject();
                        Order order = (Order) o;
                        this.addNew(order);
                    }
                } catch (Exception e) {
                }
            }
        } catch (FileNotFoundException e1) {
            Logger.getLogger(SetMenus.class.getName()).log(Level.SEVERE, null, e1);
        } catch (IOException e2) {
            Logger.getLogger(SetMenus.class.getName()).log(Level.SEVERE, null, e2);
        } catch (Exception e3) {
            Logger.getLogger(SetMenus.class.getName()).log(Level.SEVERE, null, e3);
        }finally {
            try {
                fis.close();
            } catch (Exception ex) {
            }
        }
    }
}
