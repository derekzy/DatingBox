package com.derekzy.datingbox.activity;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.derekzy.datingbox.R;
import com.derekzy.datingbox.adapter.ViewPagerAdapter;
import com.derekzy.datingbox.db.MyDatabase;
import com.derekzy.datingbox.frag.FeedFrag;

import java.util.ArrayList;
import java.util.List;

public class LevelActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TextView appName;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    public FloatingActionButton floatingActionButton;
    private MyDatabase myDatabase;



    //声明tab里面的标签
    private String[] tabList;
    //填充到ViewPager中的FRAG列表
    private List<Fragment> fragmentList;
    private ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        //初始化各种控件
        toolbar = (Toolbar) findViewById(R.id.id_toolbar);
        appName = (TextView) findViewById(R.id.id_appname);
        tabLayout = (TabLayout) findViewById(R.id.id_tablayout);
        viewPager = (ViewPager) findViewById(R.id.id_viewpager);
        floatingActionButton = (FloatingActionButton) findViewById(R.id.id_floatingactionbar);

        //Create db
        myDatabase = MyDatabase.getInstance(this);

        //初始化tab,viewpager的数据
        tabList = new String[]{"❤", "❤❤", "❤❤❤", "❤❤❤❤"};
        fragmentList = new ArrayList<>();
        for (int i = 0; i < tabList.length; i++) {
            Bundle bundle = new Bundle();
            bundle.putInt("flag", i);
            FeedFrag feedFrag = new FeedFrag();
            feedFrag.setArguments(bundle);
            fragmentList.add(feedFrag);
        }


        //配置View
        //set toolbar
         //不把toolbar作为actionbar来用时，可以inflateMenu，setOnMenuItemListener
        toolbar.inflateMenu(R.menu.others_toolbar);
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
//
        //初始化ViewPager适配器
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), fragmentList, tabList);
        viewPager.setAdapter(viewPagerAdapter);

        // 设置ViewPager最大缓存的页面个数
        viewPager.setOffscreenPageLimit(2); //////
        //添加页面监听器
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(final int position) {


                floatingActionButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        FeedFrag feedFrag = (FeedFrag) fragmentList.get(position);
                        feedFrag.recyclerView.getLayoutManager().scrollToPosition(0);

                    }
                });
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        //设置完viewPager才可以进行关联*
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        //tablayout和viewpager进行关联，让两者联动
        tabLayout.setupWithViewPager(viewPager);
        //设置tablayout的tab和适配器中getPageTitle返回值关联起来
        tabLayout.setTabsFromPagerAdapter(viewPagerAdapter);

    }
}
