/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;
import java.util.Date;

import java.io.Serializable;
/**
 *
 * @author Jason
 */
public class DeliveryManAttendance implements Serializable {
    private String delManID;
    private String delManName;
    private Date checkIn;
    private Date checkOut;
    private String remark;
    private boolean finished;
    
    public DeliveryManAttendance(String delManID, String delManName, Date checkIn, Date checkOut, String remark) {
        this.delManID = delManID;
        this.delManName = delManName;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.remark = remark;
    }

    public String getDelManName() {
        return delManName;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }
    
    public boolean getFinished(){
        return finished;
    }
    
    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public String getDelManID() {
        return delManID;
    }

    public String getRemark() {
        return remark;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public void setDelManID(String delManID) {
        this.delManID = delManID;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setDelManName(String delManName) {
        this.delManName = delManName;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
