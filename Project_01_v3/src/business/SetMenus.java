/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import models.SetMenu;

/**
 *
 * @author tungi
 */
public class SetMenus extends ArrayList<SetMenu> {

    private String pathFile;

    public SetMenus(String pathFile) {
        this.pathFile = pathFile;
    }

    public void readFromFile() {
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
                while((temp=br.readLine())!=null){
                    System.out.println(temp);
                }
            }
        } catch (Exception e) {
        }

    }
}
