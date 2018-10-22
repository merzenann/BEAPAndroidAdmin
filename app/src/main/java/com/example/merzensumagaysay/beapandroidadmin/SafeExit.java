package com.example.merzensumagaysay.beapandroidadmin;

/**
 * Created by merzensumagaysay on 22/10/2018.
 */

public class SafeExit {

    /*
   INSTANCE FIELDS
    */
    private int exitID;
    private String exitName;
    private int iStatus;

    /*
    GETTERS AND SETTERS
     */
    public int getExitID()
    {
        return exitID;
    }

    public void setExitID(int exitID)
    {
        this.exitID = exitID;
    }

    public String getName() {
        return exitName;
    }

    public void setName(String exitName) {
        this.exitName = exitName;
    }

    public int getiStatus() {
        return iStatus;
    }

    public void setiStatus(int iStatus) {
        this.iStatus = iStatus;
    }

}
