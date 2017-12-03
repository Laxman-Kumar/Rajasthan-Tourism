package com.example.shared.hackathon;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdaptor2 extends RecyclerView.Adapter<CustomAdaptor2.MyViewHolder> {

    private ArrayList<GuideListDataClass> dataSet1;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView guideName,guideLanguage,guideContact,guidePrice;
        ImageView guideImage;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.guideImage = (ImageView)itemView.findViewById(R.id.guideProfile);
            this.guideName = (TextView) itemView.findViewById(R.id.guideName);
            this.guideLanguage = (TextView) itemView.findViewById(R.id.guideLanguage);
            this.guideContact = (TextView) itemView.findViewById(R.id.guideContact);
            this.guidePrice = (TextView) itemView.findViewById(R.id.guidePrice);

        }
    }

    public CustomAdaptor2(ArrayList<GuideListDataClass> data) {
        this.dataSet1 = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.guide_row, parent, false);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        TextView guideTempName = holder.guideName;
        TextView guideTempLan = holder.guideLanguage;
        TextView guideTempContact = holder.guideContact;
        TextView guideTempPrice = holder.guidePrice;

        ImageView guideTempImage  = holder.guideImage;

        guideTempName.setText(dataSet1.get(listPosition).getName());
        guideTempLan.setText(dataSet1.get(listPosition).getLan());
        guideTempContact.setText(dataSet1.get(listPosition).getContact());
        guideTempPrice.setText(dataSet1.get(listPosition).getPrice());

        guideTempImage.setImageResource(dataSet1.get(listPosition).getPhoto());


    }

    @Override
    public int getItemCount() {
        return dataSet1.size();
    }
}
