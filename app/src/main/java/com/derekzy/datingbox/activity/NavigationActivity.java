package com.derekzy.datingbox.activity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.derekzy.datingbox.R;
import com.derekzy.datingbox.Utils.LogUtil;
import com.derekzy.datingbox.Utils.Utils;

import java.sql.BatchUpdateException;

/**
 * Created by derekzy on 2016/2/22.
 */
public class NavigationActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView appName;
    private Button feelingButton;
    private Button flirtingButton;
    private Button favButton;

    private static final int ANIM_DURATION_TOOLBAR = 300;

    private void startIntroAnimation() {
        int actionBarsize = Utils.dpToPx(56);
        toolbar.setTranslationY(-actionBarsize);
        appName.setTranslationY(-actionBarsize);

        toolbar.animate().translationY(0)
                .setDuration(ANIM_DURATION_TOOLBAR)
                .setStartDelay(300);
        appName.animate().translationY(0)
                .setDuration(ANIM_DURATION_TOOLBAR)
                .setStartDelay(400);
    }

    @Override
    protected void onResume() {
        super.onResume();
        startIntroAnimation();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            PackageManager packageManager = getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(getPackageName(), 0);
            String versionName = packageInfo.versionName;
            int versionCode = packageInfo.versionCode;
            String packName = packageInfo.packageName;
            LogUtil.e("tag","versionName "+versionName+ " versionCode " +versionCode+" packageName "+packName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        setContentView(R.layout.activity_navigation);

        toolbar = (Toolbar) findViewById(R.id.id_toolbar);
        appName = (TextView) findViewById(R.id.id_appname);
        toolbar.setNavigationIcon(R.drawable.ic_inbox_white_24dp);
        feelingButton = (Button) findViewById(R.id.id_feeling_button);
        flirtingButton = (Button) findViewById(R.id.id_flirt_button);
        favButton = (Button) findViewById(R.id.id_fav_button);

        toolbar.inflateMenu(R.menu.menu_toobar);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.id_aboutme:
                        break;
                }
                return true;
            }
        });

        AssetManager assetManager = getAssets();
        Typeface typeface = Typeface.createFromAsset(assetManager, "fonts/MargotRegular.ttf");
        appName.setTypeface(typeface);

        startIntroAnimation();

        feelingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NavigationActivity.this, LevelActivity.class);
                startActivity(intent);
            }
        });
        flirtingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OthersActivity.actionStart(NavigationActivity.this, OthersActivity.FLIRT);
            }
        });
        favButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NavigationActivity.this, OthersActivity.class);
                intent.putExtra("flag", OthersActivity.FAV);
                NavigationActivity.this.startActivity(intent);
            }
        });
    }
}
