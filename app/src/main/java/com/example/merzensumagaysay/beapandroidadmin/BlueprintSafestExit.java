package com.example.merzensumagaysay.beapandroidadmin;


import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class BlueprintSafestExit extends AppCompatActivity {


    class SafeExit {
        /*
        INSTANCE FIELDS
         */

        @SerializedName("exitID")
        private int exitID;
        @SerializedName("exitName")
        private String exitName;
        @SerializedName("iStatus")
        private int iStatus;

        public SafeExit(int exitID, String exitName, int iStatus) {
            this.exitID = exitID;
            this.exitName = exitName;
            this.iStatus = iStatus;
        }


         /*
         *GETTERS AND SETTERS
         */

        public int getExitID() {
            return exitID;
        }

        public void setExitID(int exitID) {
            this.exitID = exitID;
        }

        public String getExitName() {
            return exitName;
        }

        public void setExitName(String exitName) {
            this.exitName = exitName;
        }

        public int getiStatus() {
            return iStatus;
        }

    }


    interface MyAPIService {

        @GET("admin/fetch.php")
        Call<List<SafeExit>> getSafeExit();
    }


    static class RetrofitClientInstance {

        private static Retrofit retrofit;
        private static final String BASE_URL = "http://192.168.1.8/";

        public static Retrofit getRetrofitInstance() {
            if (retrofit == null) {
                retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
            }
            return retrofit;
        }
    }


    class ListViewAdapter extends BaseAdapter {

        private List<SafeExit> safeExits;
        private Context context;

        public ListViewAdapter(Context context, List<SafeExit> safeExits) {
            this.context = context;
            this.safeExits = safeExits;
        }

        @Override
        public int getCount() {
            return safeExits.size();
        }

        @Override
        public Object getItem(int pos) {
            return safeExits.get(pos);
        }

        @Override
        public long getItemId(int pos) {
            return pos;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(context).inflate(R.layout.activity_guidelines_admin, viewGroup, false);
            }

            CheckBox MFCExit = view.findViewById(R.id.MFCExit);
            CheckBox BGate = view.findViewById(R.id.backgateExit);
            CheckBox Exit1 = view.findViewById(R.id.mainGateExit);
            CheckBox Exit2 = view.findViewById(R.id.mainExit);
            CheckBox LRTGate = view.findViewById(R.id.LRTExit);


            final SafeExit thisSafeExit = safeExits.get(position);


            MFCExit.setChecked(thisSafeExit.getiStatus() == 1);
            MFCExit.setEnabled(false);

            BGate.setChecked(thisSafeExit.getiStatus() == 1);
            BGate.setEnabled(false);

            Exit1.setChecked(thisSafeExit.getiStatus() == 1);
            Exit1.setEnabled(false);

            Exit2.setChecked(thisSafeExit.getiStatus() == 1);
            Exit2.setEnabled(false);

            LRTGate.setChecked(thisSafeExit.getiStatus() == 1);
            LRTGate.setEnabled(false);

            return view;

        }
    }

    private ListViewAdapter adapter;
    private ListView mListView;
    ProgressBar myProgressBar;

    private void populateListView(List<SafeExit> safeExits) {
        mListView = findViewById(R.id.mListView);
        adapter = new ListViewAdapter(this,safeExits);
        mListView.setAdapter(adapter);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blueprint_safest_exit);

        final ProgressBar myProgressBar= findViewById(R.id.myProgressBar);
        myProgressBar.setIndeterminate(true);
        myProgressBar.setVisibility(View.VISIBLE);

        /*Create handle for the RetrofitInstance interface*/
        MyAPIService myAPIService = RetrofitClientInstance.getRetrofitInstance().create(MyAPIService.class);

        Call<List<SafeExit>> call = myAPIService.getSafeExit();
        call.enqueue(new Callback<List<SafeExit>>() {

            @Override
            public void onResponse(Call<List<SafeExit>> call, Response<List<SafeExit>> response) {
                myProgressBar.setVisibility(View.GONE);
                populateListView(response.body());
            }
            @Override
            public void onFailure(Call<List<SafeExit>> call, Throwable throwable) {
                myProgressBar.setVisibility(View.GONE);
                Toast.makeText(BlueprintSafestExit.this, throwable.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    }






