/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author ChongLi
 */
public class Staff {

private String name;
private String IC;
private String ID;
private String PhoneContact;
private String address;
private String email;
public enum status{resigned,PartTime,Fulltime,Available,Delivery,Break,Unavailable};
private status staffStaff = status.Fulltime;


public Staff(){}

    public Staff(String name, String IC, String ID, String PhoneContact, String address,String Email, status status) {
        this.name = name;
        this.IC = IC;
        this.ID = ID;
        this.PhoneContact = PhoneContact;
        this.address = address;
        this.email=Email;
        this.staffStaff = status;
    }
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getIC() {
        return IC;
    }

    public void setIC(String IC) {
        this.IC = IC;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPhoneContact() {
        return PhoneContact;
    }

    public void setPhoneContact(String PhoneContact) {
        this.PhoneContact = PhoneContact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public status getStaffStaff() {
        return staffStaff;
    }

    public void setStaffStaff(status staffStaff) {
        this.staffStaff = staffStaff;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
   

    
}
