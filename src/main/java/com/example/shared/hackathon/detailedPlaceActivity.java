package com.example.shared.hackathon;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class detailedPlaceActivity extends AppCompatActivity {

    CollapsingToolbarLayout collapsingToolbarLayout;
    CoordinatorLayout mCoordinatorLayout;
    ImageView imageView;
    TextView textView;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_place);
        mCoordinatorLayout = (CoordinatorLayout)findViewById(R.id.coordinator);

        collapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.collapsingToolbar);

        imageView = (ImageView)findViewById(R.id.toolbarImage);
        textView = (TextView)findViewById(R.id.textView);


        Intent i = getIntent();
        String name = i.getStringExtra("name");
        Integer image = i.getIntExtra("image",0);


        collapsingToolbarLayout.setTitle(name);
        imageView.setImageResource(image);
        StringBuffer temp = new StringBuffer();

        //String path = context.getFilesDir().getAbsolutePath();
       // Log.v("path",path);
       /* try {
            FileReader fr=new FileReader("city_palace.txt");
            BufferedReader br=new BufferedReader(fr);
            String line = null;
            try {
                while((line = br.readLine()) != null)
                {
                    temp.append(line);
                    temp.append("/n");

                    textView.append(line);
                    textView.append("/n");
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
*/
        textView.setText(DataList.city_palace);
    }
}
