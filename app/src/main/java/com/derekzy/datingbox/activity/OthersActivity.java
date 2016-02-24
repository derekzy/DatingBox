package com.derekzy.datingbox.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.derekzy.datingbox.R;
import com.derekzy.datingbox.Utils.LogUtil;
import com.derekzy.datingbox.adapter.FavRecyclerAdapter;
import com.derekzy.datingbox.adapter.RecyclerAdapter;
import com.derekzy.datingbox.db.MyDatabase;
import com.derekzy.datingbox.modle.CardItem;

import java.util.List;

/**
 * Created by derekzy on 2016/2/23.
 */
public class OthersActivity extends AppCompatActivity {

    public static final int FLIRT = 0;
    public static final int FAV = 6;
    private int flag = 0; //flag通过传进来的数据要重新赋值

    private Toolbar toolbar;
    private TextView appName;
    private TextView tabName;
    private ImageView tabLine;
    private TextView tabTrangle;
    private List<CardItem> cardItemList;
    private RecyclerView recyclerView;
    private RecyclerAdapter recyclerAdapter;
    private FloatingActionButton floatingActionButton;

    private MyDatabase myDatabase;

    public static void actionStart(Context context, int type) {
        Intent intent = new Intent(context, OthersActivity.class);
        intent.putExtra("flag", type);
        context.startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    /**
                     * 获取序列化对象,并且是adapter里面的list发生改变，这里传入的增加了也不会重新载入适配器了
                     */

                    CardItem cardItem = (CardItem) getIntent().getSerializableExtra("newContent");
                    LogUtil.e("Before add cardItemList", "cardItemList is " +cardItemList);
                    recyclerAdapter.list.add(0, cardItem); //插入的位置
                    recyclerAdapter.notifyItemInserted(0);
                    LogUtil.e("result","onActivityResult run");
                    break;
                }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.others_activity_layout);

        toolbar = (Toolbar) findViewById(R.id.id_toolbar);
        appName = (TextView) findViewById(R.id.id_appname);
        tabName = (TextView) findViewById(R.id.id_tabtext);
        tabLine = (ImageView) findViewById(R.id.id_tabline);
        floatingActionButton = (FloatingActionButton) findViewById(R.id.id_floatingactionbar);
        recyclerView = (RecyclerView) findViewById(R.id.id_recycleview);


        toolbar.setNavigationIcon(R.drawable.ic_keyboard_arrow_left_white_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        AssetManager assetManager = getAssets();
        Typeface typeface = Typeface.createFromAsset(assetManager, "fonts/MargotRegular.ttf");
        appName.setTypeface(typeface);

        myDatabase = MyDatabase.getInstance(this);

        Intent intent = getIntent();
        flag = intent.getIntExtra("flag", 0);
        LogUtil.e("*********", "intent.getIntExtra is " + intent.getIntExtra("flag", 0));

        if (flag == FAV) {
            toolbar.inflateMenu(R.menu.fav_toolbar);

        } else {
            toolbar.inflateMenu(R.menu.others_toolbar);
        }
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.id_aboutme:
                        break;
                    case R.id.id_create:
                        Intent intent = new Intent(OthersActivity.this, EditActivity.class);
                        startActivity(intent);
                        finish();
                        break;
                    case R.id.id_exit:
                        finish();
                        break;
                }
                return true;
            }
        });

//        cardItemList = new ArrayList<>();
        switch (flag) {
            case FLIRT:
                cardItemList = myDatabase.loadFlirt();
                tabName.setText(R.string.Flirt);
                break;
            case FAV:
                cardItemList = myDatabase.loadFav();
                tabName.setText(R.string.MyFavorite);
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        if (flag == FAV) {
           FavRecyclerAdapter favRecyclerAdapter = new FavRecyclerAdapter(this, cardItemList);
            recyclerView.setAdapter(favRecyclerAdapter);
        }else {

            recyclerAdapter = new RecyclerAdapter(this, cardItemList);
            recyclerView.setAdapter(recyclerAdapter);
        }

        recyclerView.setItemAnimator(new DefaultItemAnimator());

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerView.getLayoutManager().scrollToPosition(0);
            }
        });

    }
}
