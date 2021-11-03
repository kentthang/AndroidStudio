package com.example.laboration2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ExpandableListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        HashMap<String,List<String>> theData= getData();
        ArrayList<String> titles= new ArrayList<String>(theData.keySet());
        LabbAdapter adapter = new LabbAdapter(this,titles,theData);     //Adapter är till för att sätta in data i listview
        listView.setAdapter(adapter);

        EditText input = findViewById(R.id.input);
        input.setText("/");

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //String item = (String) parent.getItemAtPosition(position);
                String item = parent.getItemAtPosition(position).toString();
                input.setText(item);

            }
        });
    }

    public HashMap<String, List<String>> getData(){
        HashMap<String, List<String>> data= new HashMap<String,List<String>>();

        List<String> eu=new ArrayList<String>();
        eu.add("Sweden");
        eu.add("Germany");
        eu.add("Finland");
        eu.add("Norway");
        eu.add("Switzerland");
        eu.add("Poland");

        List<String> asia= new ArrayList<String>();
        asia.add("China");
        asia.add("Taiwan");
        asia.add("India");
        asia.add("Thailand");
        asia.add("Japan");

        data.put("EU",eu);
        data.put("Asia", asia);
        return data;
    }



    //Om ingenting är markerad ska det stå "/" i textrutan
    public void nothingSelected(){
        EditText input = findViewById(R.id.input);
        input.setText("/");
    }


}