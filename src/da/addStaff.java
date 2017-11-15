/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staff;

import Domain.Staff;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author ChongLi
 */
public class addStaff {

    Staff info = new Staff();
    Staff info1 = new Staff("Chai", "123456789012", "qqww22", "0123456789", "dwdacwa", "w@w", Staff.status.Fulltime);
    Staff info2 = new Staff("lol", "098765432109", "wqe8989", "00198765432", "d9j9sjn", "wE@W", Staff.status.PartTime);
    Scanner input1 = new Scanner(System.in);
    private List<Staff> staff = new ArrayList<>();
    String select;

    //String name, String IC, String ID, String PhoneContact, String address, status status
    public void AddStaff() {
        boolean check = true;
        Scanner input = new Scanner(System.in);
        System.out.print("Staff Name:");
        info.setName(input.nextLine());
        System.out.print("\nStaff IC:");
        info.setIC(input.nextLine());
        System.out.print("\nStaff ID:");
        info.setID(input.nextLine());
        System.out.print("\nStaff Contact:");
        info.setPhoneContact(input.nextLine());
        System.out.print("\nStaff Address:");
        info.setAddress(input.nextLine());
        System.out.print("\nStaff  Email:");
        info.setEmail(input.nextLine());
        while (!select.equals("1")  || !select.equals("2")) {
            System.out.println("\n1." + Staff.status.Fulltime);
            System.out.println("2." + Staff.status.PartTime);
            System.out.print("\nSelect the Staff Working Status:");
            select = input.nextLine();
            if (select.equals("1")) {
                info.setStaffStaff(Staff.status.Fulltime);
                check = true;
                staff.add(info);
                break;
            } else if (select.equals("2")) {
                info.setStaffStaff(Staff.status.PartTime);
                
                check = true;
                staff.add(info);
                break;
            } else {
                check = false;
            }
           
            
 if (!check) {
                System.out.println("Please select correct number");
 }
            

        }
        for (int i = 0; i < staff.size(); i++) {
            System.out.println("Name:" + staff.get(i).getName());
            System.out.println("IC:" + staff.get(i).getIC());
            System.out.println("ID" + staff.get(i).getID());
            System.out.println("Contact:" + staff.get(i).getPhoneContact());
            System.out.println("Working Status:" + staff.get(i).getStaffStaff());
            System.out.println("Email:" + staff.get(i).getEmail());

        }
        Continue();
    }

    public void Search() {
        Scanner staffID = new Scanner(System.in);
        Scanner update = new Scanner(System.in);
        boolean check = true;
        System.out.print("Enter the staff ID for modify:");

        for (Staff user : staff) {
            if (user.getID().equals(staffID.nextLine())) {
                System.out.println(user.getName());
                System.out.println(user.getEmail());
                System.out.println(user.getAddress());
                System.out.println(user.getPhoneContact());
                check = true;
                System.out.println("You want to update: ");
                System.out.println("1.Contact.No\n2.Address\n3.Email");
                System.out.print("Enter your choice:");
                switch (update.nextInt()) {
                    case 1:
                        System.out.print("Contact");
                        break;
                    case 2:
                        System.out.print("Address");
                        break;
                    case 3:
                        System.out.print("Email");
                        break;
                    default:
                        System.out.print("dddd");

                }
                ;
            } else {
                check = false;
            }
            if (!check) {
                System.out.print("No the staff");
            }
            Continue();
        }
    }

    public void selection() {

        do {
            System.out.println("Enter Selection:");
            System.out.println("1. Add the New Delivery Men");
            System.out.println("2. Update the Staff Contact");
            System.out.println("3. ");
            System.out.println("4. View The Report");
            select = input1.nextLine();
            if (select.equals("1") ) {
                AddStaff();
            } else if (select.equals("2")) {
                Search();
            } else if (select.equals("3")) {
                System.out.println("3");
            } else if (select.equals("4")) {
                System.out.println("4");
            } else {
                System.out.println("Please enter correct selection");
            }
        } while (!select.equals("1")||!select.equals("2")||!select.equals("3")||!select.equals("4"));
    }

    public void start() {
        staff.add(info1);
        staff.add(info2);
        selection();

    }

    public void Continue() {
        Scanner option = new Scanner(System.in);
        System.out.println("Do you wish to continue(y/n)");
        String i;

        do {
            i = option.nextLine();
            if (i.equalsIgnoreCase("Y") || i.equalsIgnoreCase("y")) {
                selection();
            } else if (i.equalsIgnoreCase("N") || i.equalsIgnoreCase("n")) {
                System.exit(0);
            } else {
                System.out.println("Please enter correct option.");

            }
        } while (!i.equalsIgnoreCase("y") || !i.equalsIgnoreCase("n") || !i.equalsIgnoreCase("Y") || !i.equalsIgnoreCase("N"));

    }

    public static void main(String[] args) {

        addStaff start = new addStaff();
        start.start();
        //start.Continue();
    }

}
