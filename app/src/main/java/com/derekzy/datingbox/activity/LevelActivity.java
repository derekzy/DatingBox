package com.derekzy.datingbox.activity;

import android.app.AlertDialog;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.TextView;
import android.widget.Toast;

import com.derekzy.datingbox.R;
import com.derekzy.datingbox.Utils.LogUtil;
import com.derekzy.datingbox.adapter.ViewPagerAdapter;
import com.derekzy.datingbox.db.MyDatabase;
import com.derekzy.datingbox.frag.FeedFrag;

import java.util.ArrayList;
import java.util.List;

public class LevelActivity extends AppCompatActivity {
    private CoordinatorLayout coordinatorLayout;
    private Toolbar toolbar;
    private TextView appName;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    public FloatingActionButton floatingActionButton;
    private MyDatabase myDatabase;
    private int pageSelectedPositon = 0;

    private Boolean isTranslate = true;


    //声明tab里面的标签
    private String[] tabList;
    //填充到ViewPager中的FRAG列表
    private List<Fragment> fragmentList;
    private ViewPagerAdapter viewPagerAdapter;

    private void startAnimation() {
        floatingActionButton.setTranslationY(2 * getResources()
                .getDimensionPixelOffset(R.dimen.btn_fab_size));

        floatingActionButton.animate().translationY(0)
                .setInterpolator(new OvershootInterpolator(0.f))
                .setDuration(300)
                .setStartDelay(300);
    }

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

        startAnimation();
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
        toolbar.inflateMenu(R.menu.level_toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_keyboard_arrow_left_white_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
      toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.id_question:
                    LogUtil.e("tag", "R.id.question");
                    android.support.v7.app.AlertDialog.Builder builder =
                            new android.support.v7.app.AlertDialog.Builder(LevelActivity.this);
                    LayoutInflater inflater = LayoutInflater.from(LevelActivity.this);
                    View view = inflater.inflate(R.layout.question_layout, null);
                    builder.setView(view);
                    builder.setCancelable(true);
                    android.support.v7.app.AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                    break;
                case R.id.id_translate:
                    if (isTranslate) {
                        LogUtil.e("tag", "isTranslate is " + isTranslate + "pageSelected is " + pageSelectedPositon);
                        for (int i = 0; i < 4 ; i++) {

                            FeedFrag feedFrag = (FeedFrag) fragmentList.get(i);
                            feedFrag.recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
                        }
                        isTranslate = false;
                    } else {
                        for (int i = 0; i < 4 ; i++) {
                            LogUtil.e("tag", "isTranslate is " + isTranslate);
                            FeedFrag feedFrag = (FeedFrag) fragmentList.get(i);
                            feedFrag.recyclerView.setLayoutManager(new LinearLayoutManager(LevelActivity.this, LinearLayoutManager.VERTICAL, false));
                        }
                        isTranslate = true;

                    }
                    break;
            }
            return true;
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
        viewPager.setOffscreenPageLimit(3); //////
        //添加页面监听器
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(final int position) {

                LevelActivity.this.pageSelectedPositon = position;

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

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FeedFrag feedFrag = (FeedFrag) fragmentList.get(pageSelectedPositon);
                feedFrag.recyclerView.getLayoutManager().scrollToPosition(0);

            }
        });
    }
}
