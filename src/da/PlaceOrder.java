/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

import da.Restaurants;
import domain.Food;
import domain.Order;
import domain.Restaurant;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Date;
import java.util.InputMismatchException;
import static javafx.scene.input.KeyCode.T;

/**
 *
 * @author USER
 */
public class PlaceOrder {

    static Scanner scanner = new Scanner(System.in);

    private static List<Restaurant> restList = new ArrayList<>();
    private static ArrayList<Food> foodList1 = new ArrayList<Food>();
    private static ArrayList<Food> foodList2 = new ArrayList<Food>();
    private ArrayList<Order> orderList = new ArrayList<Order>();

    private static ArrayList<ArrayList<Food>> foodList = new ArrayList<ArrayList<Food>>();

    private ArrayList<Food> orderedFood = new ArrayList<Food>();
    private ArrayList<Integer> orderedQty = new ArrayList<Integer>();

    public static void main(String[] args) {
        //"", restName, restRegNo, block,
        //town, postcode, state, ownerName, ownerIC, username, password

        Restaurant restaurant = new Restaurant("WE00001", "Western Food", "0123456789", "aaa@hotmail.com",
                "123456789", "32", "Bayan Lepas", "11900", "Pulau Pinang", "Yen",
                "123456789", "123456", "123456");
        Restaurant restaurant1 = new Restaurant("WE00002", "Japanese Food", "0123456788","aaa@hotmail.com",
                "123456788", "12", "Tanjung Tokong", "11700", "Pulau Pinang", "Ali",
                "123456788", "123455", "123455");
        restList.add(restaurant);
        restList.add(restaurant1);

        Food food = new Food("F0001", "Burger", "A burger", 10.00, 1, "Available", "WE00001");
        Food food1 = new Food("F0002", "French Fries", "french fries", 3.00, 1, "Available", "WE00001");

        foodList1.add(food);
        foodList1.add(food1);

        Food food3 = new Food("F0001", "Sushi", "sushi", 2.00, 1, "Available", "WE00002");
        Food food4 = new Food("F0002", "Ramen", "ramen", 15.00, 1, "Available", "WE00002");
        foodList2.add(food3);
        foodList2.add(food4);

        foodList.add(foodList1);
        foodList.add(foodList2);

        PlaceOrder pa = new PlaceOrder();

        pa.restMenu();

    }

    public void restMenu() {
        Scanner scanner1 = new Scanner(System.in);
        int restNo = 0;
        boolean error = false;

        for (int i = 0; i < restList.size(); i++) {
            System.out.print(String.format("\n%d. ", i + 1));
            System.out.println(restList.get(i).getRestName().toString());
        }

        do {

            try {
                System.out.print("\nPlease select Restaurant(number(0 to exit)):");
                restNo = scanner1.nextInt();
                error = false;
                break;
            } catch (InputMismatchException exception) {
                scanner1.next();
                System.out.println("\nThis is not an integer");
                error = true;
                continue;
            }
        } while (error);

//        System.out.print("Please select Restaurant(number(0 to exit)):");
//        restNo = scanner.nextInt();
        if (restNo == 0) {
            System.exit(-1);
        } else if (restNo <= restList.size()) {

            FoodMenu(restNo);
        } else {
            System.out.println("\nPlease enter the correct restaurant number!");
            restMenu();
        }

    }

    public void FoodMenu(int restNo) {
        int foodOption = 0;
        String foodID;
        int foodQty;
        boolean contOption = true;
        String confirmation;

        switch (restNo) {
            case 1:
                placeOrder(restNo);
//                do {
//
//                    for (int i = 0; i < foodList1.size(); i++) {
//                        System.out.print(String.format("\n%d. ", i + 1));
//                        System.out.println("Food ID: " + foodList1.get(i).getFoodID());
//                        System.out.println("Food Name: " + foodList1.get(i).getFoodName());
//                        System.out.println("Food Price: " + String.format("%.2f", foodList1.get(i).getFoodPrice()));
//                    }
//
//                    System.out.print("Please enter the Food ID:");
//                    foodID = scanner.next();
//
//                    System.out.print("Please enter quantity:");
//                    foodQty = scanner.nextInt();
//
//                    for (Food food1 : foodList1) {
//                        if (food1.getFoodID().compareTo(foodID) == 0) {
//                            orderedFood.add(food1);
//                            orderedQty.add(foodQty);
//                        }
//                    }
//
//                    contOption = Continue();
//
//                } while (contOption == true);

                displayFoodOrdered(orderedFood, orderedQty);

//                System.out.println("Your Order will be shown below:");
//
//                for (int i = 0; i < orderedFood.size(); i++) {
//                    System.out.print(String.format("\n%d. ", i + 1));
//                    System.out.println("Food ID: " + orderedFood.get(i).getFoodID());
//                    System.out.println("Food Name:" + orderedFood.get(i).getFoodName());
//                    System.out.println("Order Quantity: " + orderedQty.get(i));
//
//                }
                System.out.print("\nAre your sure your order is correct?(Y/N):");
                confirmation = scanner.next();

                if (confirmation.equalsIgnoreCase("y")) {
                    createOrder(orderedFood, orderedQty);

//                    Date orderDate = new Date();
//                    double totalAmount = 0.0;
//                    double foodAmount = 0.0;
//
//                    for (int i = 0; i < orderedFood.size(); i++) {
//                        foodAmount += orderedFood.get(i).getFoodPrice() * (double) orderedQty.get(i);
//                    }
//
//                    double gstAmount = foodAmount * 0.06;
//                    totalAmount = foodAmount + gstAmount;
//
//                    String orderID = generateOrderID(orderList.size());
//                    Order order = new Order(orderID, orderDate, totalAmount, gstAmount, orderedFood, orderedQty);
//                    orderList.add(order);
                } else if (confirmation.equalsIgnoreCase("n")) {
                    System.out.print("aa1");
                }
                break;

            case 2:
                placeOrder(restNo);
                displayFoodOrdered(orderedFood, orderedQty);
                System.out.print("\nAre your sure your order is correct?(Y/N):");
                confirmation = scanner.next();
                if (confirmation.equalsIgnoreCase("y")) {
                    createOrder(orderedFood, orderedQty);
                } else if (confirmation.equalsIgnoreCase("n")) {
                    System.out.print("Your order will be cancel.");
                }
                break;

            default:
                System.out.println("Invalid option.");
                restMenu();
        }
    }

    public void placeOrder(int restNo) {
        int foodOption = 0;
        String foodID;
        int foodQty;
        boolean contOption = true, valid;

        Scanner scanner2 = new Scanner(System.in);

        do {

            /*  Display Food Menu   */
            for (int i = 0; i < foodList.get(restNo - 1).size(); i++) {
                System.out.print(String.format("\n%d. ", i + 1));
                System.out.println("Food ID: " + foodList.get(restNo - 1).get(i).getFoodID());
                System.out.println("Food Name: " + foodList.get(restNo - 1).get(i).getFoodName());
                System.out.println("Food Price: " + String.format("%.2f", foodList.get(restNo - 1).get(i).getFoodPrice()));
            }

            do {
                /*  Select Food Menu    */
                valid = true;
                System.out.print("\nPlease enter the Food ID:");
                foodID = scanner2.next();

                System.out.print("Please enter quantity:");
                foodQty = scanner2.nextInt();

                /*  Check Food Menu with the Food ID entered    */
                for (int i = 0; i < foodList.get(restNo - 1).size(); i++) {
//                    System.out.println("FoodID : " + foodList.get(restNo - 1).get(i).getFoodID());
                    if (foodList.get(restNo - 1).get(i).getFoodID().compareTo(foodID) == 0) {   /*    if Correct, Food ID entered same with the food ID in the FoodList array (based on restNo entered)  */
                        orderedFood.add(foodList.get(restNo - 1).get(i));
                        orderedQty.add(foodQty);
                        break;
                    } else { /* if Incorrect    */
                        valid = false;
                    }
                }
                
                if (!valid) {
                    System.out.println("\nPlease enter the correct Food ID!");
                }
            } while (!valid);
//            
//            for (Food food1 : foodList.get(restNo - 1)) {
//                if (foodList.get(restNo - 1).get(foodQty)getFoodID().compareTo(foodID) == 0) {
//
//                    orderedFood.add(food1);
//                    orderedQty.add(foodQty);
//                } else {
//                    System.out.println("\nPlease enter the correct Food ID!");
//                    placeOrder(restNo);
//
//                }
//            }

            contOption = Continue();

        } while (contOption == true);

    }

    public void displayFoodOrdered(ArrayList<Food> orderedFood, ArrayList<Integer> orderedQty) {
        System.out.println("\nYour Order will be shown below:");

        for (int i = 0; i < orderedFood.size(); i++) {
            System.out.print(String.format("\n%d. ", i + 1));
            System.out.println("Food ID: " + orderedFood.get(i).getFoodID());
            System.out.println("Food Name:" + orderedFood.get(i).getFoodName());
            System.out.println("Order Quantity: " + orderedQty.get(i));

        }
    }

    public void createOrder(ArrayList<Food> orderedFood, ArrayList<Integer> orderedQty) {
        Date orderDate = new Date();
        double totalAmount = 0.0;
        double foodAmount = 0.0;

        for (int i = 0; i < orderedFood.size(); i++) {
            foodAmount += orderedFood.get(i).getFoodPrice() * (double) orderedQty.get(i);
        }

        double gstAmount = foodAmount * 0.06;
        totalAmount = foodAmount + gstAmount;

        String orderID = generateOrderID(orderList.size());
        Order order = new Order(orderID, orderDate, totalAmount, gstAmount, orderedFood, orderedQty);
        orderList.add(order);
        displayInvoice(order);

    }

    public boolean Continue() {

        char option = '\u0000';
        System.out.print("\nDo you want to continue order?(Y/N) ");
        option = scanner.next().charAt(0);

        if (option == 'y' || option == 'Y') {
            return true;
        }
        return false;
    }

    public String generateOrderID(int size) {
        return String.format("OD%03d", size + 1);
    }

    public void displayInvoice(Order order) {

        System.out.print("\nOrder ID:" + order.getOrderID() + "        ");
        System.out.print("Order Date:" + new SimpleDateFormat("MM-dd-yyyy").format(order.getOrderDate()) + "       ");
        System.out.println("Order Time:" + new SimpleDateFormat("hh:mm:ss a").format(order.getOrderDate()));
        System.out.print(String.format("\n%-30s", "Ordered Food"));
        System.out.println("Quantity");
        for (int i = 0; i < order.getOrderedFood().size(); i++) {

            // System.out.println(String.format("",order.getOrderedFood().get(i).getFoodName()))+"      *        " +order.getOrderQty().get(i));
            System.out.printf("%-30s%-30s\n", order.getOrderedFood().get(i).getFoodName(), order.getOrderQty().get(i));

        }

        System.out.println("\nSubtotal:RM" + String.format("%.2f", order.getTotalAmount() - order.getGstAmount()));
        System.out.println("GST amount:RM" + String.format("%.2f", order.getGstAmount()));
        System.out.println("Total amount:RM" + String.format("%.2f", order.getTotalAmount()));

    }

}
