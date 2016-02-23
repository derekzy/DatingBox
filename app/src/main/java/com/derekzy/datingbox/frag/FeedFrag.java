package com.derekzy.datingbox.frag;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.derekzy.datingbox.R;
import com.derekzy.datingbox.Utils.LogUtil;
import com.derekzy.datingbox.adapter.ListViewAdapter;
import com.derekzy.datingbox.adapter.RecyclerAdapter;
import com.derekzy.datingbox.db.MyDatabase;
import com.derekzy.datingbox.modle.CardItem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by derekzy on 2016/2/22.
 */
public class FeedFrag extends Fragment {
    private View view;
    private List<CardItem> list;
    private MyDatabase myDatabase;


    public RecyclerView recyclerView;
    private RecyclerAdapter recyclerAdapter;

    //声明状态常量
    public static final int VERTICAL_LIST = 0;
    public static final int HORIZONTAL_LIST = 1;
    public static final int VERTICAL_GRID = 2;
    public static final int HORIZONTAL_GRID = 3;

    private int flag = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_layout, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        recyclerView = (RecyclerView) view.findViewById(R.id.id_recycleview);


        flag = getArguments().getInt("flag");
        LogUtil.e("flag*************", "" + flag);

        list = new ArrayList<>();
        myDatabase = MyDatabase.getInstance(getActivity());
        switch (flag) {
            case VERTICAL_LIST:
                list = myDatabase.loadLevel1();
                break;
            case HORIZONTAL_LIST:
                list = myDatabase.loadLevel2();
                break;
            case HORIZONTAL_GRID:
                list = myDatabase.loadLevel3();
                break;
            case VERTICAL_GRID:
                list = myDatabase.loadLevel4();
                break;
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recyclerAdapter = new RecyclerAdapter(getActivity(), list);
        recyclerView.setAdapter(recyclerAdapter);


    }
}

