package com.derekzy.datingbox.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.derekzy.datingbox.R;
import com.derekzy.datingbox.db.MyDatabase;
import com.derekzy.datingbox.modle.CardItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by derekzy on 2016/2/20.
 */
public class ListViewAdapter extends ArrayAdapter<CardItem> {

    private int resourceId;
    private List<String> numList;
    private List<CardItem> cardItemList;
    private MyDatabase myDatabase;
    private Context context;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;


    public ListViewAdapter(Context context, int resource, List<CardItem> objects) {
        super(context, resource, objects);
        this.resourceId = resource;
        numList = new ArrayList<>();
        for (int i = 1; i <= objects.size(); i++) {
            numList.add(""+i);
        }

        this.cardItemList = objects;
//        openHelper = new ContentOpenHelper(context, "Article.db", null, 1);
//        db = openHelper.getWritableDatabase();
        this.context = context;
        myDatabase = MyDatabase.getInstance(context);
        pref = PreferenceManager.getDefaultSharedPreferences(context);
        editor = pref.edit();
    }

    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {
        final CardItem cardItem = getItem(position); //这个adapter泛型是CardItem
        View view;
        final ViewHolder viewHolder;
        if (convertView == null) {
            //布局填充器调用from获取实例inflate传入的布局id
            viewHolder = new ViewHolder();//*create new holder
            view = LayoutInflater.from(getContext()).inflate(resourceId, null);
            viewHolder.numText = (TextView) view.findViewById(R.id.id_num);
            viewHolder.textView = (TextView) view.findViewById(R.id.id_textview);
            viewHolder.checkBox = (CheckBox) view.findViewById(R.id.id_star);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.numText.setText(numList.get(position));
        viewHolder.textView.setText(cardItem.getContent());
        viewHolder.checkBox.setChecked(cardItem.getFav());

        viewHolder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean status = pref.getBoolean(String.valueOf(cardItem.getId()), false);
                if (status) {
                    viewHolder.checkBox.setChecked(false);
                    editor.putBoolean(String.valueOf(cardItem.getId()), false);
                    editor.apply();
                    Toast.makeText(context, "取消收藏", Toast.LENGTH_SHORT).show();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            myDatabase.updateFav("false", String.valueOf(cardItem.getId()));
                        }
                    }).start();
                } else {
                    viewHolder.checkBox.setChecked(true);
                    editor.putBoolean(String.valueOf(cardItem.getId()), true);
                    editor.apply();
                    Toast.makeText(context, "已收藏", Toast.LENGTH_SHORT).show();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            myDatabase.updateFav("true", String.valueOf(cardItem.getId()));
                        }
                    }).start();
                }
            }
        });
        //返回当前的布局
        return view;
    }

    class ViewHolder {
        TextView numText;
        TextView textView;
        CheckBox checkBox;
    }
}
