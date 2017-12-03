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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText nameet,phoneet,emailet;
    String namestr,phonestr,emailstr,citystr;
    Spinner spinner;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if(!checkSharePref()) {
            Log.i("msg","in first if");
            if (!checkSharePrefData()) {
                Log.i("msg","in second if");
                spinner = (Spinner) findViewById(R.id.spinner);
                nameet = (EditText) findViewById(R.id.nameEditText);
                phoneet = (EditText) findViewById(R.id.phoneEditText);
                emailet = (EditText) findViewById(R.id.emailEditText);

                button = (Button) findViewById(R.id.button);

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
                        citystr = adapterView.getItemAtPosition(i).toString();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });



                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        namestr = nameet.getText().toString();
                        phonestr = phoneet.getText().toString();
                        emailstr = emailet.getText().toString();
                        sharedPreferences = getSharedPreferences("user_data", 0);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        Log.i("msg","name "+namestr);
                        Log.i("msg","phone "+phonestr);
                        Log.i("msg","email "+emailstr);
                        Log.i("msg","city "+citystr);

                        editor.putString("name", namestr);
                        editor.putString("phone", phonestr);
                        editor.putString("email", emailstr);
                        editor.putString("city", citystr);
                        editor.apply();
                        Log.i("msg",sharedPreferences.getString("name",null));

                        Intent i = new Intent(getApplicationContext(), MainMenuActivity.class);
                        startActivity(i);
                    }
                });

            }
            else{
                Log.i("msg","in inner else");
                Intent i = new Intent(getApplicationContext(), selectCityActivity.class);
                startActivity(i);

            }
        }
        else{

            Log.i("msg","in outer else");

            sharedPreferences = getSharedPreferences("user_data", 0);
            citystr=sharedPreferences.getString("city",null);

            Intent i = new Intent(getApplicationContext(), MainMenuActivity.class);
            i.putExtra("city",citystr);
            startActivity(i);

        }


    }  public Boolean checkSharePref(){

        sharedPreferences = getSharedPreferences("user_data",0);

        String check =  sharedPreferences.getString("city",null);
        if(check!=null){
            return true;
        }
        else
        {
            return false;
        }
    }
    public Boolean checkSharePrefData(){

        sharedPreferences = getSharedPreferences("user_data",0);

        String check =  sharedPreferences.getString("name",null);

        if(check!=null){
            Log.i("msg","in check share pref data. '"+check+"'");
            return true;

        }
        else
        {
            return false;
        }
    }
}
