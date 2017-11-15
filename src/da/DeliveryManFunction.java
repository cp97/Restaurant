/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DA;

import Domain.Staff;
import Domain.DeliveryManAttendance;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;

public class DeliveryManFunction {

    ArrayList<DeliveryManAttendance> delAttend = new ArrayList<>();
    ArrayList<Staff> delMan = new ArrayList<>();

    public void checkIn(String delManID) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        Date date = new Date();
        String delName = "";

        for (int i = 0; i < delMan.size(); i++) {
            if (delAttend.isEmpty()) {
                if (delManID.equals(delMan.get(i).getID())) {
                    delName = delMan.get(i).getName();
                    DeliveryManAttendance delCheckIn = new DeliveryManAttendance(delManID, delName, date, null, "");
                    delAttend.add(delCheckIn);
                    System.out.println("Successfully checked in at " + dateFormat.format(date) + " as " + delCheckIn.getDelManName());
                    delAttend.get(i).setFinished(false);
                    return;
                }
            } else if (delManID.equals(delMan.get(i).getID()) ) {
                for (int z = 0; z < delAttend.size(); z++) {
                    if (delAttend.get(i).getDelManID().equals(delManID) && delAttend.get(i).getFinished() == false) {
                        if (!delAttend.get(i).getCheckIn().equals(null)) {
                            System.out.println("Check out first before you check in.");
                            return;
                        }
                    }
                }
                delName = delMan.get(i).getName();
                DeliveryManAttendance delCheckIn = new DeliveryManAttendance(delManID, delName, date, null, "");
                delCheckIn.setFinished(false);
                delAttend.add(delCheckIn);
                System.out.println("Successfully checked in at " + dateFormat.format(date) + " as " + delCheckIn.getDelManName());
                return;
            }
        }
        System.out.println("Staff not found.");
        return;
    }

    public void checkOut(String delManID) {
        for (int i = 0; i < delAttend.size(); i++) {
            
            if (delAttend.get(i).getDelManID().equals(delManID) && delAttend.get(i).getCheckOut() == null) {
                if(delAttend.get(i).getCheckIn().equals(null)){
                    System.out.printf("Staff has not checked in yet.");
                    return;
                }
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
                Date date = new Date();
                delAttend.get(i).setCheckOut(date);
                System.out.println("Successfully checked out at " + dateFormat.format(date) + " as " + delAttend.get(i).getDelManName());
                delAttend.get(i).setFinished(true);
                return;
            }
        }
        System.out.println("Staff not found.");
        return;
    }

    public void showMenu() {
        int choice = 0;
        do {
            System.out.println("1. Check In");
            System.out.println("2. Check Out");
            System.out.println("3.Exit");
            Scanner scan = new Scanner(System.in);
            choice = scan.nextInt();
            if (choice == 1) {
                System.out.println("Enter staff ID to check in : ");
                String staffID = scan.next();
                checkIn(staffID);
            } else if (choice == 2) {
                System.out.println("Enter staff ID to check out : ");
                String staffID = scan.next();
                checkOut(staffID);
            } else if (choice == 3) {
                System.out.println("Exiting.. ");
                break;
            } else {
                System.out.println("Enter a valid choice! ");
            }
        } while (choice == 1 || choice == 2);
    }

    public void initializeApp() {
        // hardcode deliverymen
        // Statuses
        // A = Available, U = unavailable , B = break, D = delivery 


        //Active
        Staff delMan1 = new Staff();
        delMan1.setPhoneContact("011323488874");
        delMan1.setID("DEL0001");
        delMan1.setIC("780977065542");
        delMan1.setName("Ah Boon");
        delMan1.setStaffStaff(Staff.status.Available);
        delMan1.setEmail("ahboon@gmail.com");
        delMan1.setAddress("82z Ah Kek Road");
        delMan.add(delMan1);

        //break
        Staff delMan2 = new Staff();
        delMan2.setPhoneContact("011123444444");
        delMan2.setID("DEL0002");
        delMan2.setIC("4219451152");
        delMan2.setName("Ah Beng");
        delMan2.setStaffStaff(Staff.status.Break);
        delMan2.setEmail("ahbeng@gmail.com");
        delMan2.setAddress("92z Ah Beng Road");
        delMan.add(delMan2);

        //delivery
        Staff delMan3 = new Staff();
        delMan3.setPhoneContact("012546544888");
        delMan3.setID("DEL0003");
        delMan3.setIC("9251515151123");
        delMan3.setName("Ah Seng");
        delMan3.setStaffStaff(Staff.status.Delivery);
        delMan3.setEmail("ahseng@gmail.com");
        delMan3.setAddress("92z Ah Seng Road");
        delMan.add(delMan3);


        // inactive
        Staff delMan4 = new Staff();
        delMan4.setPhoneContact("01935343536");
        delMan4.setID("DEL0004");
        delMan4.setIC("9353377065542");
        delMan4.setName("Ah Heng");
        delMan4.setStaffStaff(Staff.status.Unavailable);
        delMan4.setEmail("ahheng@gmail.com");
        delMan4.setAddress("11z Ah Heng Road");
        delMan.add(delMan4);

        // no error handling
    }

    public static void main(String[] args) {
        DeliveryManFunction delman = new DeliveryManFunction();
        delman.initializeApp();
        delman.showMenu();
    }
}