package com.example.shared.hackathon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class guideActivity extends AppCompatActivity {
    private RecyclerView rv;
    private CustomAdaptor2 adaptor;
    private ArrayList<GuideListDataClass> tempData;
    private RecyclerView.LayoutManager layoutManager1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        tempData = new ArrayList<>();
        rv = (RecyclerView)findViewById(R.id.recyclerViewGuide);
        layoutManager1 = new LinearLayoutManager(this);
        rv.setLayoutManager(layoutManager1);

        for(int i=0;i<DataList.guideName.length;i++){

            GuideListDataClass obj = new GuideListDataClass(DataList.guideName[i],DataList.guideLanguage[i],DataList.guidePricing[i],DataList.guideNumber[i],DataList.guideImage[i]);
            tempData.add(obj);
        }


        adaptor = new CustomAdaptor2(tempData);
        rv.setAdapter(adaptor);
    }
}
