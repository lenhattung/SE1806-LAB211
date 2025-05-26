/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author tungi
 */
public class SetMenu implements Comparable<SetMenu>{
    private String code;
    private String name;
    private double price;
    private String ingradients;

    public SetMenu() {
    }

    public SetMenu(String code, String name, double price, String ingradients) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.ingradients = ingradients;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getIngradients() {
        return ingradients;
    }

    public void setIngradients(String ingradients) {
        this.ingradients = ingradients;
    }

    @Override
    public int compareTo(SetMenu that) {
        if(this.price<that.price)
            return -1;
        else if(this.price> that.price)
            return 1;
        else 
            return 0;
    }
}
