package com.example.merzensumagaysay.beapandroidadmin;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by merzensumagaysay on 21/10/2018.
 */

public class Model {


    @SerializedName("value")
    @Expose
    private Integer Value;

    @SerializedName("fetch")
    @Expose
    private List<Fetch> fetch = null;


    public Integer getValue()
    {
        return Value;
    }

    public  void setValue(Integer value)
    {
        this.Value = value;
    }


    public List<Fetch> getFetch()
    {
        return fetch;
    }

    public void setFetch(List<Fetch> fetch)
    {
        this.fetch = fetch;
    }

}
