package com.derekzy.datingbox.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.derekzy.datingbox.R;

public class MyViewHolder extends RecyclerView.ViewHolder{
    TextView numText;
    TextView textView;
    CheckBox checkBox;
    public MyViewHolder(View itemView) {
        super(itemView);
        numText = (TextView) itemView.findViewById(R.id.id_num);
        textView = (TextView) itemView.findViewById(R.id.id_textview);
        checkBox = (CheckBox) itemView.findViewById(R.id.id_star);

    }
}
