package com.example.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ProfileAdapter extends BaseAdapter {

    Context context;
    ArrayList<ProfileModel> profileData;
    LayoutInflater layoutInflater;
    ProfileModel profileModel;

    public ProfileAdapter(Context context, ArrayList<ProfileModel> profileData) {
        this.context = context;
        this.profileData = profileData;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return profileData.size();
    }

    @Override
    public Object getItem(int i) {
        return  profileData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return  profileData.get(i).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        View rowView = view;
        if (rowView==null) {
            rowView = layoutInflater.inflate(R.layout.list_profile, null, true);
        }
        //link views
        ImageView avata = rowView.findViewById(R.id.avata);
        TextView ten= rowView.findViewById(R.id.ten);
        TextView mota= rowView.findViewById(R.id.mota);
        ImageView tick = rowView.findViewById(R.id.tick);
        TextView phantram= rowView.findViewById(R.id.phantram);


        profileModel= profileData.get(position);

        avata.setImageResource(profileModel.getAvata());
        ten.setText(profileModel.getTen());
        mota.setText(profileModel.getMota());
        tick.setImageResource(profileModel.getTick());
        phantram.setText(profileModel.getPhantram());

        return rowView;
    }
//    public void RemoveItem(int position){
//        musicData.remove(position);
//        notifyDataSetChanged();
//    }
}