/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import business.Customers;
import business.SetMenus;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author tungi
 */
public class Order {

    private String orderId;
    private String customerCode;
    private String codeOfSetMenu;
    private int numberOfTables;
    private Date eventDate;

    public Order() {
    }

    public Order(String customerCode, String codeOfSetMenu, int numberOfTables, Date eventDate) {
        this.orderId = generateOrderCode();
        this.customerCode = customerCode;
        this.codeOfSetMenu = codeOfSetMenu;
        this.numberOfTables = numberOfTables;
        this.eventDate = eventDate;
    }

    public Order(String orderId, String customerCode, String codeOfSetMenu, int numberOfTables, Date eventDate) {
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

    public int getNumberOfTables() {
        return numberOfTables;
    }

    public void setNumberOfTables(int numberOfTables) {
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

    public String generateOrderCode() {
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
        return sdf.format(now);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.customerCode);
        hash = 67 * hash + Objects.hashCode(this.codeOfSetMenu);
        hash = 67 * hash + Objects.hashCode(this.eventDate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Order other = (Order) obj;
        if (!Objects.equals(this.customerCode, other.customerCode)) {
            return false;
        }
        if (!Objects.equals(this.codeOfSetMenu, other.codeOfSetMenu)) {
            return false;
        }
        return Objects.equals(this.eventDate, other.eventDate);
    }

    public void display(Customers customers, SetMenus setMenus) {
        System.out.println("-----------------------------");
        System.out.println("Customer order information [Order Id: " + this.getOrderId() + "]");
        System.out.println("-----------------------------");
        Customer c = customers.searchById(this.getCustomerCode());
        c.display();
        System.out.println("-----------------------------");
        SetMenu s = setMenus.searchById(this.getCodeOfSetMenu());
        s.display(this.eventDate, this.numberOfTables);
        System.out.println("-----------------------------");
        System.out.format("%-15s:%s\n", "Total cost: ", this.getNumberOfTables()*s.getPrice() + "Vnd");
    }

}
