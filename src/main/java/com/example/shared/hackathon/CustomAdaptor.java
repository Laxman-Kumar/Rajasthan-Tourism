package com.example.shared.hackathon;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class CustomAdaptor extends RecyclerView.Adapter<CustomAdaptor.MyViewHolder> {

    private ArrayList<PlacesListDataClass> dataSet;

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView placeName;
        private ImageView placeImage;
        private PlacesListDataClass mPlacesListDataClass;
        private Context context;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.placeImage = (ImageView)itemView.findViewById(R.id.singleRowImageview);
            this.placeName = (TextView) itemView.findViewById(R.id.singleRowTexview);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            context = view.getContext();
            Intent intent = new Intent(context,detailedPlaceActivity.class);

            intent.putExtra("name",placeName.getText().toString());
            intent.putExtra("image",mPlacesListDataClass.getImage());

            context.startActivity(intent);
        }

        public void bindData(PlacesListDataClass placesListDataClass){
            mPlacesListDataClass = placesListDataClass;
            placeName.setText(mPlacesListDataClass.getName());
            placeImage.setImageResource(mPlacesListDataClass.getImage());
            Log.i("msg","image: "+mPlacesListDataClass.getImage());
        }


    }

    public CustomAdaptor(ArrayList<PlacesListDataClass> data) {
        dataSet = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.places_row, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

       PlacesListDataClass placesListDataClass1 = dataSet.get(listPosition);
        holder.bindData(placesListDataClass1);
        /* TextView placeNameList = holder.placeName;
        ImageView placeImageList  = holder.placeImage;

        placeNameList.setText(dataSet.get(listPosition).getName());

        placeImageList.setImageResource(dataSet.get(listPosition).getImage());*/


    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
