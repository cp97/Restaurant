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
public class Restaurant {
    private String restID;
    private String restName;
    private String restNo;
    private String tel;
    private String email;
    private String block;
    private String town;
    private String postcode;
    private String state;
    
    private String username;
    private String password;
    private String ownerName;
    private String ownerIC;
    
    
    public Restaurant(String restID, String restName,String restNo, String tel, String email,
            String block, String town, String postcode, String state,
            String ownerName, String ownerIC, 
            String username, String password){
        this.restID = restID;
        this.restName = restName;
        this.restNo = restNo;
        this.tel = tel;
        this.email = email;
        
        this.block = block;
        this.town = town;
        this.postcode = postcode;
        this.state = state;
        
        this.ownerName = ownerName;
        this.ownerIC = ownerIC;
        
        this.username = username;
        this.password = password;
    }
    
    // Getter
    public String getRestID(){
        return restID;
    }
    public String getRestName(){
        return restName;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public String getOwnerName(){
        return ownerName;
    }
    public String getOwnerIC(){
        return ownerIC;
    }
    public String getRestNo(){
        return restNo;
    }
    public String getBlock(){
        return block;
    }
    public String getTown(){
        return town;
    }
    public String getTel(){
        return tel;
    }
    public String getEmail(){
        return email;
    }
    public String getPostcode(){
        return postcode;
    }
    public String getState(){
        return state;
    }
    
    // Setter
    public void setRestID(String restID){
        this.restID = restID;
    }
    public void setRestName(String restName){
        this.restName = restName;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setOwnerName(String ownerName){
        this.ownerName = ownerName;
    }
    public void setOwnerIC(String ownerIC){
        this.ownerIC = ownerIC;
    }
    public void setRestNo(String restNo){
        this.restNo = restNo;
    }
    public void setBlock(String block){
        this.block = block;
    }
    public void setTown(String town){
        this.town = town;
    }
    public void setPostcode(String postcode){
        this.postcode = postcode;
    }
    public void setState(String state){
        this.state = state;
    }
    public void setTel(String tel){
        this.tel = tel;
    }
    public void setEmail(String email){
        this.email = email;
    }
}
