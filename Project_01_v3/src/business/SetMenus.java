/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.SetMenu;

/**
 *
 * @author tungi
 */
public class SetMenus extends TreeMap<String, SetMenu> {

    private String pathFile;

    public SetMenus(String pathFile) {
        try {
            this.pathFile = pathFile;
            this.readFromFile();
        } catch (IOException ex) {
            Logger.getLogger(SetMenus.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void readFromFile() throws IOException {
        FileInputStream fis = null;
        try {
            // B1 - Tao doi tuong file de anh xa len tap tin
            File f = new File(this.pathFile);
            // B2 - Kiem tra su ton tai cua file
            if (!f.exists()) {
                System.out.println("Cannot read data from feastMenu.csv. Please check it.");
                return;
            } else {
                // B3 - Tao buffer de doc du lieu tu tap tin (tieng Viet UTF-8)
                fis = new FileInputStream(f);
                InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
                BufferedReader br = new BufferedReader(isr);
                String temp = "";
                while ((temp = br.readLine()) != null) {
                    SetMenu sm = dataToObject(temp);
                    if (sm != null) {
                        this.put(sm.getCode(), sm);
                    }
                }
                br.close();
            }
        } catch (FileNotFoundException e1) {
            Logger.getLogger(SetMenus.class.getName()).log(Level.SEVERE, null, e1);
        } catch (IOException e2) {
            Logger.getLogger(SetMenus.class.getName()).log(Level.SEVERE, null, e2);
        } catch (Exception e3) {
            Logger.getLogger(SetMenus.class.getName()).log(Level.SEVERE, null, e3);
        }finally {
            fis.close();
        }
    }

    public SetMenu dataToObject(String text) {
        SetMenu sm = null;
        String[] strs = text.split(",");
        if (strs.length >= 4) {
            try {
                String code = strs[0];
                String name = strs[1];
                double price = Double.parseDouble(strs[2]);
                String ingredients = strs[3];
                sm = new SetMenu(code, name, price, ingredients);
            } catch (Exception e) {
            }
        }
        return sm;
    }

    public void showAll() {
        System.out.println("------------------------");
        System.out.println("List of Set Menus for ordering party:");
        System.out.println("------------------------");
        List<SetMenu> values =  new ArrayList(this.values());
        Collections.sort(values);
        for (SetMenu sm : values) {
            System.out.format("%-15s:%s\n", "Code", sm.getCode());
            System.out.format("%-15s:%s\n", "Name", sm.getName());
            System.out.format("%-15s:%s\n", "Price", sm.getPrice() + "Vnd");
            System.out.println("Ingredients:");
            System.out.println(sm.getIngradients());
            System.out.println("------------------------");
        }
    }
    
    public SetMenu searchById(String id){
        return this.get(id);
    }
    
    public boolean contains(String id){
        return this.containsKey(id);
    }
}
