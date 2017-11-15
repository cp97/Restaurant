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
public class Restaurants {
    Scanner scanner = new Scanner(System.in);
    private static List<Restaurant> restList = new ArrayList<>();
    List<String> restType = new ArrayList<>(Arrays.asList("Western", "Indian",
            "China", "Mamak", "Japanese"));
    Foods foods = new Foods();
    private static List<Food> foodList = new ArrayList<>();
    
    public static void main(String[] args){
        //restID, restName, restRegNo, block, tel,
        //town, postcode, state, ownerName, ownerIC, username, password
        Restaurants rest = new Restaurants();
        rest.start();
        
    }
    
    public void start(){
        Food food1 = new Food("AP0001","bbq pizza","Barbeque Pizza.", 12.00,
        10, "Promotion", "WE0001");
        Food food2 = new Food("AP0002","hawaii pizza","Pizza with pineapple.", 15.00,
        0, "New", "WE0001");
        Food food3 = new Food("AP0003","pepperoni pizza","Pizza with pepperoni.", 17.00,
        0, "Available", "WE0001");
        
        foodList.add(food1);
        foodList.add(food2);
        foodList.add(food3);
        
        Restaurants rest = new Restaurants();
        Restaurant restaurant = new Restaurant("WE0001", "Western Food", "0123456789","looyenchng112@gmail.com",
                "123456789","32","Bayan Lepas", "11900","Pulau Pinang","Yen",
                "123456789","123456","123456");
        restList.add(restaurant);
        select();
    }
    
    public void back(List<Restaurant> restPass, List<Food> foodPass){
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
        select();
    }
    
    public void select(){
        char ch;
        String selection;
        boolean check;
        
        
        
        
        do{
            System.out.println("\nPlease enter a number from selection."); 
            System.out.println("*************************************");
            System.out.println("Welcome to Fast Deliveryman System");
            System.out.println("==================================");
            System.out.println("1. Restaurant Owner");
            System.out.println("2. Delivery Man");
            System.out.println("3. Customer");
            System.out.println("4. Exit");
            System.out.print("Please enter an selection: ");
            selection = scanner.next();
            ch = selection.charAt(0);
            check = checkSelection(ch, 4);
        }while(selection.length()>1 || selection.length()<1 || check==false);
        
        
        selection2(ch);
    }
    
    
    public void selection(){  
        char ch;
        String selection;
        boolean check;
        
        
        do{
            System.out.println("\nPlease enter a number from selection."); 
            System.out.println("*************************************");
            System.out.println("Restaurant");
            System.out.println("==========");
            System.out.println("1. Sign In");
            System.out.println("2. Register");
            System.out.println("3. Back to Main Menu");
            System.out.print("Please enter an selection: ");
            selection = scanner.next();
            ch = selection.charAt(0);
            check = checkSelection(ch, 3);
        }while(selection.length()>1 || selection.length()<1 || check==false);
        
        
        selection1(ch);
    }
    
    public boolean checkSelection(char ch, int loop){
        String strLoop = String.format("%d", loop);
        char chrLoop = strLoop.charAt(0);
        
        if((!Character.isDigit(ch)) || ch>chrLoop || ch=='0'){
            System.out.println("\n**Wrong selection.\n" +
            "Please enter correct selection.**\n");
            return false;
        }
        return true;
    }
    
    public void selection2(char ch){

      switch(ch){
          case '1':{
              selection();
              break;}
          case '2':{
              System.out.println("Delivery Man");
              break;}
          case '3':{
              System.out.println("Customer");
              break;
          }
          case '4':{
              System.out.println("\n** Thank you for using this system. **");
              break;
          }
      }
    }
    
    public void selection1(char ch){

      switch(ch){
          case '1':{
              login();
              break;}
          case '2':{
              register();
              break;}
          case '3':{
              select();
              break;
          }
      }
    }
    
    public void register(){
        String selectRestType;
        String selectTypeStr;
        char ch;
        boolean check;
        do{
        
        System.out.println("\nPlease select the restaurant type: ");
        System.out.println("**********************************");
        System.out.println("Register Restaurant");
        System.out.println("===================");
        
        for(int i=0; i<restType.size(); i++){
            int no = i+1;
            System.out.println(no+". " + restType.get(i));
        }
        
        System.out.print("Please enter a selection: ");
        selectRestType = scanner.next();
        ch = selectRestType.charAt(0);
        check = checkSelection(ch, restType.size());
        
        }while(selectRestType.length()>1 || selectRestType.length()<1 || check == false);
       
        Restaurant restaurant = restInformation();
        String restID  = restCode(ch);
        restaurant.setRestID(restID);
        selectTypeStr = getType(ch, restType);
        
            System.out.println("\n\nPlease check the information entered.");
            System.out.println("**************************************");
            System.out.println("(i) Restaurant Information");
            System.out.println("==========================");
            System.out.print("Restaurant Category: " + selectTypeStr + "\n");
            System.out.print("Restaurant ID: " + restaurant.getRestID() + "\n");
            System.out.print("Restaurant Name: " + restaurant.getRestName() + "\n");
            System.out.print("Restaurant Registration No.: " + restaurant.getRestNo() + "\n");
            System.out.print("Restaurant Tel No.: " + restaurant.getTel() + "\n");
        /**************************************************/
            System.out.println("\n(ii) Restaurant Address ");
            System.out.println("=======================");
            System.out.print("Block / Unit: " + restaurant.getBlock()+ "\n");
            System.out.print("Town: " + restaurant.getTown()+ "\n");
            System.out.print("Postcode: " + restaurant.getPostcode()+ "\n");
            System.out.print("State: " + restaurant.getState()+ "\n");
        /**************************************************/
            System.out.println("\n(iii) Owner Information");
            System.out.println("=======================");
            System.out.print("Owner Name: " + restaurant.getOwnerName()+ "\n");
            System.out.print("Owner I/C: " + restaurant.getOwnerIC()+ "\n");
            System.out.print("Email: " + restaurant.getEmail()+ "@gmail.com\n");
        /***************************************************/
            System.out.println("\n(iv) Login Information");
            System.out.println("======================");
            System.out.print("Username: " + restaurant.getUsername()+ "\n");
            System.out.print("Password: " + restaurant.getPassword()+ "\n");
            System.out.println("**************************************");
            
        boolean confirmation = confirm();
        if(confirmation == true){
            restList.add(restaurant);
            System.out.println("\n** Register Successful. **");
        }
        else{
            System.out.println("\n** Registration Cancel. **");
            
        }
        System.out.println("** Back to Restaurant Menu. **");
        selection();
    }
    
    public Restaurant restInformation(){
        Scanner scannerRest = new Scanner(System.in);
        String postcode="";
        String username = "";
        String password="";
        String ownerName="";
        String state="";
        String town ="";
        String block="";
        String restName="";
        String restRegNo="";
        String restTelNo="";
        String ownerIC="";
        String email="";
        
        System.out.println("\nPlease enter the restaurant information: ");
        System.out.println("********************************************");
        System.out.println("(i) Restaurant Information");
        System.out.println("==========================");
        do{
        System.out.print("Restaurant Name: ");
        restName = scannerRest.nextLine();
        }while(checkString(restName,6,50,"Restaurant Name")==false);
        
        do{
        System.out.print("Restaurant Registration No.: ");
        restRegNo = scannerRest.nextLine();
        }while(checkRegNo(restRegNo)==false||checkString(restRegNo,6,10,"Restaurant Registration No.")==false);
        
        do{
        System.out.print("Restaurant Tel No.(Without '-'): ");
        restTelNo = scannerRest.nextLine();
        }while(checkDigit(restTelNo,9,11,"Tel no.")==false);
        
        /**************************************************/
        System.out.println("\n(ii) Restaurant Address ");
        System.out.println("=======================");
        
        do{
        System.out.print("Block / Unit: ");
        block = scannerRest.nextLine();
        }while(checkString(block,1,20,"Unit / Block")==false);
        
        do{
        System.out.print("Town: ");
        town = scannerRest.nextLine();
        }while(checkOnlyStr(town,4,30,"Town")==false);
        do{
        System.out.print("Postcode: ");
        postcode = scannerRest.nextLine();
        }while(checkDigit(postcode,5,5,"postcode")==false||zeroCheck(postcode)==false);
        
        do{
        System.out.print("State: ");
        state = scannerRest.nextLine();
        }while(checkOnlyStr(state,4,30,"State")==false);
        /**************************************************/
        System.out.println("\n** Email can only accept @gmail.com **");
        System.out.println("(iii) Owner Information");
        System.out.println("=======================");
        
        do{
        System.out.print("Owner Name: ");
        ownerName = scannerRest.nextLine();
        }while(checkOnlyStr(ownerName,5,50,"Owner Name")==false);
        
        do{
        System.out.print("Owner I/C(Without '-'): ");
        ownerIC = scannerRest.nextLine();
        }while(checkDigit(ownerIC,12,20,"IC")==false);
        
        do{
        System.out.print("Email (Without '@gmail.com'): ");
        email = scannerRest.nextLine();
        }while(checkStrDig(email,3,40,"Email")==false);
        /***************************************************/
        System.out.println("\n(iv) Login Information");
        System.out.println("======================");
        
        do{
        System.out.print("Username: ");
        username = scannerRest.nextLine();
        }while(checkUsername(username)==false || checkString(username,5,18,"Username")==false);
        
        do{
        System.out.print("Password: ");
        password = scannerRest.nextLine();
        }while(checkString(password,5,18,"Password")==false);
        
        Restaurant restaurant = new Restaurant("", restName, restRegNo, restTelNo,email+"@gmail.com", block,
        town, postcode, state, ownerName, ownerIC, username, password);
        return restaurant;
    }
    
    public String getType(char ch, List<String> type){
        String types = "";
        String charString = String.format("%c", ch);
        int index = Integer.parseInt(charString);
        
        if(!type.isEmpty()){
            types = type.get(index-1);
        }
        return types;
    }
    
    public String restCode(char ch){
        
        String restTypes = getType(ch, restType);
        String restCode;
        String head = restTypes.substring(0, 2).toUpperCase();
        if(restList.isEmpty()){
            restCode = head + "0001";
        }else{
            int code = restList.size()+1;
            restCode = String.format(head+"%04d", code);
        }
        System.out.print(restCode);
        return restCode;
    }
    
    public boolean confirm(){
        boolean confirmation;
        String selection;
        char ch;
        boolean check;
        do{
            
            System.out.println("\nDo you want to register? ");
            System.out.println("==========================");
            System.out.println("1. Confirm ");
            System.out.println("2. Cancel ");
            System.out.print("Please enter an selection: ");
            selection = scanner.next();
            ch = selection.charAt(0);
            check = checkSelection(ch, 2);
        }while(selection.length()>1 || selection.length()<1 || check == false);
        
        if(ch=='1'){
            confirmation = true;
        }
        else{
            confirmation = false;
        }
        return confirmation;
    }
    
    public void login(){
        
        boolean check;
        String restID="";
        if(restID.length()>0){
            restID.equals("");
        }
        do{
            System.out.println("\nPlease enter the correct username and password.");
            System.out.println("*************************************************");
            System.out.print("Username: ");
            String username = "";
            username = scanner.next();
            System.out.print("Password: ");
            String password = "";
            password = scanner.next();
            check = checkLogin(username, password);
            restID = getRestaurant(username, password);
        }while(check==false);
        foods.maintenanceStart(restID, foodList, restList);
        
    }
    
    public boolean checkLogin(String username, String password){
        boolean check = false;
        
            for(int i=0; i<restList.size(); i++){
                if(restList.get(i).getUsername().equals(username) && 
                        restList.get(i).getPassword().equals(password)){
                    check = true;  
                    break;
                }
            }
            
        
        return check;
    }
    
    public String getRestaurant(String username, String password){
        String restID = "";
        if(!restList.isEmpty()){
            for(int i=0; i<restList.size(); i++){
                if(restList.get(i).getUsername().equals(username) && 
                        restList.get(i).getPassword().equals(password)){
                    restID = restList.get(i).getRestID();
                }
                break;
            }
        }
        return restID;
    }
    /********************** 11/5/2017 ****************************************/
    
    public boolean checkDigit(String input, int min, int max, String name){
        
        boolean check = false;
        
        for(int i=0; i<input.length(); i++){
            if(Character.isDigit(input.charAt(i))
                    &&(input.length()>=min && input.length()<=max)){
                check = true;
            }
            else{
                System.out.println("\n** Please enter correct " + name + ". **");
                System.out.println("** " +name+" must more than " + min + " words. **");
            System.out.println("** " +name+"  must also less than " + max + " words. **\n");
                return false;
            }
        }
        return check;
    }
    
    public boolean zeroCheck(String input){
        if(input.length()==1 && input.charAt(0)=='0'){
            System.out.println("\n** This information cannot be 0. **");
            return false;
        }
        return true;
    }
    
    public boolean checkPrice(double price){
        if(price==0.00||price>1000){
            System.out.println("**1. Price must be digit. **");
                System.out.println("**2. Price must more than RM 0.00. **");
                System.out.println("**3. Price must less than RM 1001. **\n");
            return false;
        }
        return true;
    }
    
    public boolean checkString(String input, int min, int max, String name){
        if(input.length()<min||input.length()>max){
            System.out.println("\n** Please enter correct " + name + ". **");
            System.out.println("** " +name+" must more than " + min + " words. **");
            System.out.println("** " +name+"  must also less than " + max + " words. **\n");
            return false;
        }
        return true;
    }
    
    public boolean checkUsername(String input){
        boolean check = false;
        for(int i=0; i<restList.size(); i++){
            if(restList.get(i).getUsername().equals(input)){
                System.out.println("\n** Username is available. **");
                System.out.println("** Please enter other username. **\n");
                check = false;
            }
            else{
                return true;
            }
        }
        return check;
    }
    public boolean checkRegNo(String input){
        boolean check = false;
        for(int i=0; i<restList.size(); i++){
            if(restList.get(i).getRestNo().equals(input)){
                System.out.println("\n** Restaurant No. is available. **");
                System.out.println("** Please enter other Restaurant No. **\n");
                check = false;
            }
            else{
                return true;
            }
        }
        return check;
    }
    
    public boolean checkStrDig(String input, int min, int max, String name){
        
        boolean check = false;
        
        for(int i=0; i<input.length(); i++){
            if(Character.isLetterOrDigit(input.charAt(i))
                    &&(input.length()>=min && input.length()<=max)){
                check = true;
            }
            else{
                System.out.println("\n** Please enter correct " + name + ". **");
                System.out.println("** " +name+" must more than " + min + " words. **");
            System.out.println("** " +name+"  must also less than " + max + " words. **\n");
                return false;
            }
        }
        return check;
    }
    public boolean checkOnlyStr(String input, int min, int max, String name){
        
        boolean check = false;
        
        for(int i=0; i<input.length(); i++){
            if(Character.isLetter(input.charAt(i))
                    &&(input.length()>=min && input.length()<=max)){
                check = true;
            }
            else{
                System.out.println("\n** Please enter correct " + name + ". **");
                System.out.println("** " +name+" must more than " + min + " words. **");
            System.out.println("** " +name+"  must also less than " + max + " words. **\n");
                return false;
            }
        }
        return check;
    }
}
