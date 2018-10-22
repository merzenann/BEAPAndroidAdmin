package com.example.merzensumagaysay.beapandroidadmin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;

import java.util.ArrayList;

/**
 * Created by merzensumagaysay on 22/10/2018.
 */

public class GridViewAdapter extends BaseAdapter {

    Context c;
    ArrayList<SafeExit> safeExits;

    public GridViewAdapter(Context c, ArrayList<SafeExit> safeExits) {
        this.c = c;
        this.safeExits = safeExits;
    }

    @Override
    public int getCount() {
        return safeExits.size();
    }

    @Override
    public Object getItem(int i) {
        return safeExits.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null)
        {
            view= LayoutInflater.from(c).inflate(R.layout.activity_blueprint_safest_exit,viewGroup,false);
        }

        CheckBox chkTechExists = (CheckBox) view.findViewById(R.id.mainExit2nd);

        final SafeExit s= (SafeExit) this.getItem(i);

        chkTechExists.setChecked( s.getiStatus()==1);


        return view;
    }
}
