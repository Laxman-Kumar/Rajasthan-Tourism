package com.example.shared.hackathon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class placesActivity extends AppCompatActivity {

    private RecyclerView.LayoutManager layoutManager1;

    private android.support.v7.widget.RecyclerView recyclerView1;

    private ArrayList<PlacesListDataClass> data = new ArrayList<>();

    private RecyclerView rv;
    private CustomAdaptor adaptor;
    private ArrayList<PlacesListDataClass> tempData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);

        tempData = new ArrayList<>();
        rv = (RecyclerView)findViewById(R.id.recyclerView);
        layoutManager1 = new LinearLayoutManager(this);
        rv.setLayoutManager(layoutManager1);

        for(int i=0;i<DataList.imageList.length;i++){

            PlacesListDataClass obj = new PlacesListDataClass(DataList.placeList[i],DataList.imageList[i]);
            Log.i("msg","image: "+DataList.imageList[i]);
            tempData.add(obj);
        }


        adaptor = new CustomAdaptor(tempData);
        rv.setAdapter(adaptor);

    }



}
