/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;


import domain.Food;
import domain.Restaurant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Loo Yen
 */
public class Foods {
    Scanner scanner = new Scanner(System.in);
    Scanner scanner1 = new Scanner(System.in);
    private static List<Food> foodList = new ArrayList<>();
    private static List<Restaurant> restList = new ArrayList<>();
    List<String> categoryList = new ArrayList<>(Arrays.asList("Appetizer", "Main Course", 
            "Snack", "Dessert", "Beverage"));
    private static List<Food> userFoodList = new ArrayList<>();
    
    public void maintenanceStart(String restID, List<Food> foodPass, List<Restaurant> restPass){
        restList.clear();
        foodList.clear();
        if(!restPass.isEmpty()){
            for(int i=0; i<restPass.size(); i++){
                restList.add(restPass.get(i));
                
            }
        }
        if(!foodPass.isEmpty()){
            for(int i=0; i<foodPass.size(); i++){
                foodList.add(foodPass.get(i));
                
            }
        }
        maintenanceMenu(restID);
    }
    
    public void maintenanceMenu(String restID){
        char ch;
        String selection;
        boolean check;
        /*String foodID, String foodName, String desc, double foodPrice, 
                int promotion, String status, String restID*/
        
        
        do{
            System.out.println("\nPlease enter a number from selection."); 
            System.out.println("*************************************");
            System.out.println("Food Maintenance");
            System.out.println("================");
            System.out.println("1. Add New Food");
            System.out.println("2. Update Food Information");
            System.out.println("3. Search Food");
            System.out.println("4. Logout");
            System.out.print("Please enter an selection: ");
            selection = scanner.next();
            ch = selection.charAt(0);
            Restaurants rest = new Restaurants();
            check = rest.checkSelection(ch, 4);
        }while(selection.length()>1 || selection.length()<1 || check==false);
        
        selection1(ch, restID);
    }
    
    public void selection1(char ch, String restID){

      switch(ch){
          case '1':{
              addFood(restID);
              break;}
          case '2':{
              System.out.println("Update");
              break;}
          case '3':{
              search2(restID);
              break;
          }
          case '4':{
              logout();
              break;
          }
      }
    }
    
    public void addFood(String restID){
        String foodTypeStr;
        String selectFoodType;
        char ch;
        boolean check;
        
        do{
        System.out.println("\nPlease select a category: ");
        System.out.println("*************************");
        for(int i=0; i<categoryList.size(); i++){
            System.out.println(i+1 + ". " + categoryList.get(i));
        }
        System.out.print("Please enter a selection: ");
        selectFoodType = scanner.next();
        ch = selectFoodType.charAt(0);
        Restaurants rest = new Restaurants();
        check = rest.checkSelection(ch, categoryList.size());
        }while(selectFoodType.length()>1 || selectFoodType.length()<1 || check == false);
        Food food = foodInformation(restID);
        String foodID  = foodCode(ch);
        food.setFoodID(foodID);
        Restaurants rest = new Restaurants();
        foodTypeStr = rest.getType(ch, categoryList);
        String strPrice = String.format("%.2f", food.getFoodPrice());
        
        System.out.println("\nPlease select the restaurant type: ");
        System.out.println("**********************************");
        System.out.println("Food Information");
        System.out.println("================");
        System.out.print("Food Category: " + foodTypeStr + "\n");
        System.out.print("Food ID: " + food.getFoodID() + "\n");
        System.out.print("Food Name: " + food.getFoodName() + "\n");
        System.out.print("Description: " + food.getDesc() + "\n");
        System.out.print("Price: RM " + strPrice + "\n");
        System.out.print("Promotion: " + food.getPromotion() + " %\n");
        System.out.print("Status: " + food.getStatus() + "\n");
        System.out.println("**********************************");
        
        boolean confirmation = rest.confirm();
        if(confirmation == true){
            for(int i=0; i<foodList.size(); i++){
                if(foodList.get(i).getStatus().equals("New")){
                    foodList.get(i).setStatus("Available");
                }
            }
            String fdName = food.getFoodName().toLowerCase();
            food.setFoodName(fdName);
            foodList.add(food);
            System.out.println("\n** Add Food Successful. **");   
        }
        else{
            System.out.println("\n** Add Food Cancel. **");   
        }
        System.out.println("** Back to Maintenance Menu. **");
        maintenanceMenu(restID);
    }
    
    public Food foodInformation(String restID){
       
        Restaurants rest = new Restaurants();
        double price=0.00;
        String promotion;
        boolean check = false;
        String foodName = "";
        String desc = "";
        
        System.out.println("\nPlease enter the food information: ");
        System.out.println("1. Enter 0 if didn't have any promotion.");
        System.out.println("*****************************************");
        do{
        System.out.print("Food Name: ");
        foodName = scanner1.nextLine();
        }while(rest.checkString(foodName, 4, 50, "Food Name")==false);
        do{
        System.out.print("Food Description(Can be blank): ");
        desc = scanner1.nextLine();
        }while(rest.checkString(desc, 0, 100, "Description")==false);
        
        do{
        try{
                System.out.print("Food Price(RM): ");
                price = scanner.nextDouble();
                check = true;
        }
        catch(Exception e){
                scanner.next();
                System.out.println("\n**Please fill in correct price. **\n");
                continue;
        }}while(check ==false || rest.checkPrice(price)==false);
        
        
        do{
        System.out.print("Promotion(%): ");
        promotion = scanner.next();
        }while(rest.checkDigit(promotion, 1, 3, "Promotion Rate")==false||Integer.parseInt(promotion)>100);
        
        
      /*String foodID, String foodName, double foodPrice, 
        String desc, int promotion, String status
        
    */
        Food food = new Food("", foodName, desc, price, Integer.parseInt(promotion), "New", restID);
        return food;
    }
    
    public String foodCode(char ch){
        Restaurants rest = new Restaurants();
        String foodTypes = rest.getType(ch, categoryList);
        String foodCode;
        String head = foodTypes.substring(0, 2).toUpperCase();
        if(foodList.isEmpty()){
            foodCode = head + "0001";
        }else{
            int code = foodList.size()+1;
            foodCode = String.format(head+"%04d", code);
        }
        return foodCode;
    }
    
    public void logout(){
        Restaurants restaurants = new Restaurants();
        restaurants.back(restList, foodList);
    }
    /******************************** 11/5/2017 *******************************/
    // food name & desc length
    // update func
    // search func
    // list type
    
    public void search(String restID){
        char ch;
        String selection;
        boolean check;
        /*String foodID, String foodName, String desc, double foodPrice, 
                int promotion, String status, String restID*/
        
        
        do{
            System.out.println("\nPlease enter a number from selection."); 
            System.out.println("*************************************");
            System.out.println("Search/Show Food By: ");
            System.out.println("====================");
            System.out.println("1. Food ID");
            System.out.println("2. Promotion Items");
            System.out.println("3. Newest Item");
            System.out.println("4. Back to Maintenance Menu");
            
            System.out.print("Please enter an selection: ");
            selection = scanner.next();
            ch = selection.charAt(0);
            Restaurants rest = new Restaurants();
            check = rest.checkSelection(ch, 4);
        }while(selection.length()>1 || selection.length()<1 || check==false);
        selection2(ch,restID);
    }
    
    public void search2(String restID){
        boolean check = checkFoodAvailable(restID);
        int checks;
        
        if(check==true){
            checks = 1;
        }
        else{
            checks = 0;
        }
        
        switch(checks){
            case 1:{
                search(restID);
                break;
            }
            case 0:{
                System.out.println("\n** No food exist. **");
                System.out.println("** Back to Food Maintenance Menu. **");
                maintenanceMenu(restID);
                break;
            }
        }
    }
    
    
    public void selection2(char ch, String restID){
        
      switch(ch){
          case '1':{
              searchFoodID(restID);
              break;}
          
          case '2':{
              showPromotion(restID);
              break;
          }
          case '3':{
              showNew(restID);
              break;
          }
          case '4':{
              maintenanceMenu(restID);
              break;
          }
      }
    }
    
    public void searchFoodID(String restID){
        String inputID = "";
        System.out.print("\nPlease enter a foodID: ");
        inputID = scanner.next().toUpperCase();
        
        for(int i=0; i<userFoodList.size(); i++){
            if(userFoodList.get(i).getFoodID().equals(inputID)){
                System.out.println("\nFood Information:");
                System.out.println("=================");
                System.out.println("Food ID: " + inputID);
                System.out.println("Food Name: " + userFoodList.get(i).getFoodName());
                System.out.println("Food Description: " + userFoodList.get(i).getDesc());
                System.out.println("Food Price: " + userFoodList.get(i).getFoodPrice());
                System.out.println("Food Status: " + userFoodList.get(i).getStatus());
                
                break;  
            }
            else{
                
            }
        }search(restID);
    }
    
    public void showPromotion(String restID){
        System.out.println("\nNo.    Food ID     Price(RM)   Food Name");
        System.out.println("============================================");
        for(int i=0; i<userFoodList.size(); i++){
            if(userFoodList.get(i).getStatus().equals("Promotion")){
                System.out.println(i+1+"." + "     " + userFoodList.get(i).getFoodID() + "      " + 
                        String.format("%.2f", userFoodList.get(i).getFoodPrice()) + "       " + userFoodList.get(i).getFoodName()
                        );
            }
            else{
                
            }
        }search(restID);
    }
    
    public void showNew(String restID){
        System.out.println("\nNo.   Food ID     Price(RM)   Food Name");
        System.out.println("============================================");
        for(int i=0; i<userFoodList.size(); i++){
            if(userFoodList.get(i).getStatus().equals("New")){
                System.out.println(i+1 + "     " + userFoodList.get(i).getFoodID() + "      " + 
                        String.format("%.2f", userFoodList.get(i).getFoodPrice()) + "       " + userFoodList.get(i).getFoodName()
                        );
            }
            else{
                
            }
        }search(restID);
    }
    
    public boolean checkFoodAvailable(String restID){
        userFoodList.clear();
        for(int i=0; i<foodList.size();i++){
            if(foodList.get(i).getRestID().equals(restID)){
                userFoodList.add(foodList.get(i));
            }
        }
        if(!userFoodList.isEmpty()){
            return true;
        }
        return false;
    }
    //*************************** 11/11/17 ******************************************
    
    // update func
    // display list
}
