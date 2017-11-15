/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class Order {

    private String orderID;
    private Date orderDate;
    private double totalAmount;
    private double gstAmount;

    private ArrayList<Food> orderedFood = new ArrayList<Food>();
    private ArrayList<Integer> orderQty = new ArrayList<Integer>();

    public Order() {
    }

    public Order(String orderID, Date orderDate, double totalAmount, double gstAmount) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.gstAmount = gstAmount;
    }
    
    public Order(String orderID, Date orderDate, double totalAmount, double gstAmount, ArrayList<Food> orderedFood, ArrayList<Integer> orderQty) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.gstAmount = gstAmount;
        this.orderedFood = orderedFood;
        this.orderQty = orderQty;
    }

    public String getOrderID() {
        return orderID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public double getGstAmount() {
        return gstAmount;
    }

    public ArrayList<Food> getOrderedFood() {
        return orderedFood;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setGstAmount(double gstAmount) {
        this.gstAmount = gstAmount;
    }

    public void setOrderedFood(ArrayList<Food> orderedFood) {
        this.orderedFood = orderedFood;
    }

    public ArrayList<Integer> getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(ArrayList<Integer> orderQty) {
        this.orderQty = orderQty;
    }

    public void addFood(Food food, int foodQty) {
        this.orderedFood.add(food);
        this.orderQty.add(foodQty);
    }
}
