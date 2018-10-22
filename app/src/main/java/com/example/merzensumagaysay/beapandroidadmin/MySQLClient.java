package com.example.merzensumagaysay.beapandroidadmin;

import android.content.Context;
import android.view.View;
import android.widget.GridView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by merzensumagaysay on 22/10/2018.
 */

public class MySQLClient {

    //SAVE/RETRIEVE URLS
    private static final String DATA_INSERT_URL="http://192.168.1.8/admin/crud.php/";
    private static final String DATA_RETRIEVE_URL="http://192.168.1.8/admin/index.php/";

    private final Context c;
    private GridViewAdapter adapter ;

    public MySQLClient(Context c) {
        this.c = c;

    }

    /*
   SAVE/INSERT
    */
    public void add(SafeExit s, final View...inputViews)
    {
        if(s==null)
        {
            Toast.makeText(c, "No Data To Save", Toast.LENGTH_SHORT).show();
        }
        else
        {
            AndroidNetworking.post(DATA_INSERT_URL)

                    .addBodyParameter("action","save")
                    .addBodyParameter("iStatus",String.valueOf(s.getiStatus()))
                    .setTag("TAG_ADD")
                    .build()
                    .getAsJSONArray(new JSONArrayRequestListener() {
                        @Override
                        public void onResponse(JSONArray response) {

                            if(response != null)
                                try {
                                    //SHOW RESPONSE FROM SERVER
                                    String responseString = response.get(0).toString();
                                    Toast.makeText(c, "PHP SERVER RESPONSE : " + responseString, Toast.LENGTH_SHORT).show();
                                }

                                catch (JSONException e) {
                                    e.printStackTrace();
                                    Toast.makeText(c, "GOOD RESPONSE BUT JAVA CAN'T PARSE JSON IT RECEIVED : "+e.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                        }

                        //ERROR
                        @Override
                        public void onError(ANError anError) {
                            Toast.makeText(c, "UNSUCCESSFUL :  ERROR IS : "+anError.getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    });

        }
    }

    /*
    RETRIEVE/SELECT/REFRESH
     */
    public void retrieve(final GridView gv)
    {
        final ArrayList<SafeExit> safeExits = new ArrayList<>();

        AndroidNetworking.get(DATA_RETRIEVE_URL)
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONArray(new JSONArrayRequestListener() {
                    @Override
                    public void onResponse(JSONArray response) {
                        JSONObject jo;
                        SafeExit s;
                        try
                        {
                            for(int i=0;i<response.length();i++)
                            {
                                jo=response.getJSONObject(i);

                                int exitID=jo.getInt("exitID");
                                String stats=jo.getString("iStatus");

                                s=new SafeExit();
                                s.setExitID(exitID);
                                s.setiStatus(stats.equalsIgnoreCase("1") ? 1 : 0);

                                safeExits.add(s);
                            }

                            //SET TO SPINNER
                            adapter =new GridViewAdapter(c,safeExits);
                            gv.setAdapter(adapter);

                        }catch (JSONException e)
                        {
                            Toast.makeText(c, "GOOD RESPONSE BUT JAVA CAN'T PARSE JSON IT RECEIEVED. "+e.getMessage(), Toast.LENGTH_LONG).show();

                        }

                    }

                    //ERROR
                    @Override
                    public void onError(ANError anError) {
                        anError.printStackTrace();
                        Toast.makeText(c, "UNSUCCESSFUL :  ERROR IS : "+anError.getMessage(), Toast.LENGTH_LONG).show();

                    }
                });
    }

}
