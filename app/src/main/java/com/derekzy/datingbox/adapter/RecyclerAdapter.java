package com.derekzy.datingbox.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.derekzy.datingbox.R;
import com.derekzy.datingbox.Utils.LogUtil;
import com.derekzy.datingbox.db.MyDatabase;
import com.derekzy.datingbox.modle.CardItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by derekzy on 2016/2/18.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<MyViewHolder>{
    public Context context;
    public List<CardItem> list;
    private List<String> numList;
    public LayoutInflater inflater;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private MyDatabase myDatabase;

    //Callback Interface
    public interface OnItemClickListener {
        void onItemClick(View v, int position);
        void onItemLongClick(View v, int position);
    }
    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public RecyclerAdapter(Context context, List list) {
        this.list = list;
        this.context = context;
        numList = new ArrayList<>();
        for (int i = 1; i<=list.size(); i++) {
                numList.add(""+i);
        }
        inflater = LayoutInflater.from(context);
        pref = PreferenceManager.getDefaultSharedPreferences(context);
        myDatabase = MyDatabase.getInstance(context);
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_main, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder,  final int position) {

        editor = pref.edit();
//        editor.putBoolean(String.valueOf(list.get(position).getId()),list.get(position).getFav()); //为了收藏新添加的加的逻辑
        holder.numText.setText(numList.get(position));
        LogUtil.e("afterSave position", "" + position);
        holder.textView.setText(list.get(position).getContent());
        holder.checkBox.setChecked(pref.getBoolean(String.valueOf(list.get(position).getId()), false));

        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean alterStatus = pref.getBoolean(String.valueOf(list.get(position).getId()), false);
                LogUtil.e("*********", "current key is " + list.get(position) + "value is " + alterStatus);
                if (alterStatus) {
                    holder.checkBox.setChecked(false);
                    editor.putBoolean(String.valueOf(list.get(position).getId()), false);
                    editor.apply(); //apply没有返回值而commit返回boolean表明修改是否提交成功。apply异步提交到硬盘，后者可以覆盖；
                    // commit同步到磁盘，多个commit并发时要等待，降低了效率
                    Toast.makeText(context, "取消收藏", Toast.LENGTH_SHORT).show();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            myDatabase.updateFav("false", String.valueOf(list.get(position).getId()));
                        }
                    }).start();
                } else {
                    holder.checkBox.setChecked(true);
                    editor.putBoolean(String.valueOf(list.get(position).getId()), true);
                    editor.apply();
                    Toast.makeText(context, "已收藏", Toast.LENGTH_SHORT).show();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            myDatabase.updateFav("true", String.valueOf(list.get(position).getId()));
                        }
                    }).start();
                }
            }
        });
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int currentPosition = holder.getLayoutPosition();
//                //这个View是holder里面的itemView
//                mOnItemClickListener.onItemClick(holder.itemView, currentPosition);//原本的position删除第一项
//                //后第0位的仍占据着第一位的position，所以重新获取位置才正确
//            }
//        });
//        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//                int currentPosition = holder.getLayoutPosition();
//                mOnItemClickListener.onItemLongClick(holder.itemView, currentPosition);
//                Toast.makeText(context, ""+position,Toast.LENGTH_SHORT).show();
//                return true;
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

