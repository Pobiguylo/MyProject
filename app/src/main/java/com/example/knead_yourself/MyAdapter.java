package com.example.knead_yourself;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyAdapter extends ArrayAdapter<Object> {
    public Context myContext;
    public MyAdapter(@NonNull Context context, int resource, @NonNull Object[] objects) {
        super(context, resource, objects);
        myContext = context;
    }
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(myContext);
            convertView = inflater.inflate(R.layout.adapter_view,parent,false);
        }else{

        }
        Object item = getItem(position);
        if (item != null){
            TextView title  =convertView.findViewById(R.id.title);
            title.setText("");
        }else{

        }
        return convertView;
    }
}
