package com.example.merzensumagaysay.beapandroidadmin.EditTemplates;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.merzensumagaysay.beapandroidadmin.R;

import java.util.ArrayList;

public class EarthquakeTemplate extends ListActivity {

    ArrayList list = new ArrayList();

    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earthquake_template);

        Button add = (Button)findViewById(R.id.add);
        Button delete = (Button)findViewById(R.id.del);

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, list);

        View.OnClickListener eqlistener1 = new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                EditText edit = (EditText)findViewById(R.id.items);

                if (!edit.getText().toString().equals(""))
                {
                    list.add(edit.getText().toString());
                    edit.setText("");
                    adapter.notifyDataSetChanged();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Please Enter a Command", Toast.LENGTH_LONG).show();
                }

            }
        };

        View.OnClickListener eqlistener2 = new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                SparseBooleanArray checkedItemsPosition = getListView().getCheckedItemPositions();

                int itemCount = getListView().getCount();

                for (int i = itemCount - 1; i >= 0; i--)
                {
                    if(checkedItemsPosition.get(i))
                    {
                        adapter.remove(list.get(i));
                    }
                }
                adapter.notifyDataSetChanged();
            }
        };

        add.setOnClickListener(eqlistener1);
        delete.setOnClickListener(eqlistener2);

        setListAdapter(adapter);


    }

}
