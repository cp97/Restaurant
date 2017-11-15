/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Loo Yen
 */
public class Food {
    private String foodID;
    private String foodName;
    private double foodPrice;
    private String desc;
    private String status; // status = New, Promotion, Available, Cancel
    private int promotion;
    private String restID;
    
    
    public Food(String foodID, String foodName, String desc, double foodPrice, int promotion, String status, String restID){
        this.foodID = foodID;
        this.foodName = foodName;
        this.desc = desc;
        this.foodPrice = foodPrice;
        this.promotion = promotion;
        this.status = status;
        this.restID = restID;
    }
    
    // Getter
    public String getFoodID(){
        return foodID;
    }
    public String getFoodName(){
        return foodName;
    }
    public double getFoodPrice(){
        return foodPrice;
    }
    public String getDesc(){
        return desc;
    }
    public int getPromotion(){
        return promotion;
    }
    public String getStatus(){
        return status;
    }
    public String getRestID(){
        return restID;
    }
    
    // Setter
    public void setFoodID(String foodID){
        this.foodID = foodID;
    }
    public void setFoodName(String foodName){
        this.foodName = foodName;
    }
    public void setFoodPrice(double foodPrice){
        this.foodPrice = foodPrice;
    }
    public void setDesc(String desc){
        this.desc = desc;
    }
    public void setPromotion(int promotion){
        this.promotion = promotion;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public void setRestID(String restID){
        this.restID = restID;
    }
}
