package com.example.shared.hackathon;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class selectCityActivity extends AppCompatActivity {

    Spinner spinner;
    String citystr;
    TextView textView;
    int check = 0;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_city);

        sharedPreferences = getSharedPreferences("user_data",0);
        String name =  sharedPreferences.getString("name",null);
        Log.i("msg","kj "+name);
        String text = "Welcome\n"+name;
        textView = (TextView)findViewById(R.id.selectedUserTextview);
        textView.setText(text);

        spinner = (Spinner)findViewById(R.id.spinnerUser);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, DataList.spinnerNames) {
            @Override
            public boolean isEnabled(int position) {
                if (position == 0) {
                    return false;
                } else {
                    return true;
                }
            }

            @Override
            public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if (position == 0) {
                    // Set the disable item text color
                    tv.setTextColor(Color.GRAY);
                } else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };

        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(++check > 1) {
                citystr = adapterView.getItemAtPosition(i).toString();

                sharedPreferences = getSharedPreferences("user_data", 0);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString("city", citystr);
                editor.apply();
                Intent intent = new Intent(getApplicationContext(), MainMenuActivity.class);
                intent.putExtra("city",citystr);
                startActivity(intent);}
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}
