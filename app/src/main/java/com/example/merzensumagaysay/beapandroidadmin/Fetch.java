package com.example.merzensumagaysay.beapandroidadmin;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by merzensumagaysay on 22/10/2018.
 */

public class Fetch {

    @SerializedName("exitID")
    @Expose
    private String exitID;

    @SerializedName("exitName")
    @Expose
    private String exitName;

    public String getExitID()
    {
        return exitID;
    }

    public void setExitID(String exitID)
    {
        this.exitID = exitID;
    }

    public String getExitName()
    {
        return exitName;
    }

    public void setExitName(String exitName)
    {
        this.exitName = exitName;
    }


}
