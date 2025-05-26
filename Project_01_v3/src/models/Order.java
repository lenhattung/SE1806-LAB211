/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.Date;

/**
 *
 * @author tungi
 */
public class Order {
    private String orderId;
    private String customerCode;
    private String codeOfSetMenu;
    private String numberOfTables;
    private Date eventDate;

    public Order() {
    }

    public Order(String orderId, String customerCode, String codeOfSetMenu, String numberOfTables, Date eventDate) {
        this.orderId = orderId;
        this.customerCode = customerCode;
        this.codeOfSetMenu = codeOfSetMenu;
        this.numberOfTables = numberOfTables;
        this.eventDate = eventDate;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCodeOfSetMenu() {
        return codeOfSetMenu;
    }

    public void setCodeOfSetMenu(String codeOfSetMenu) {
        this.codeOfSetMenu = codeOfSetMenu;
    }

    public String getNumberOfTables() {
        return numberOfTables;
    }

    public void setNumberOfTables(String numberOfTables) {
        this.numberOfTables = numberOfTables;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    @Override
    public String toString() {
        return "Order{" + "orderId=" + orderId + ", customerCode=" + customerCode + ", codeOfSetMenu=" + codeOfSetMenu + ", numberOfTables=" + numberOfTables + ", eventDate=" + eventDate + '}';
    }
    
}
