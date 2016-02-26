package com.derekzy.datingbox.activity;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.derekzy.datingbox.R;

import kdx.kdy.kdz.AdManager;
import kdx.kdy.kdz.br.AdSize;
import kdx.kdy.kdz.br.AdView;

/**
 * Created by derekzy on 2016/2/25.
 */
public class AboutMeActivity extends Activity {
    private Toolbar toolbar;
    private TextView appName;
    private ImageView appLogo;
    private TextView version;
    private TextView supportMe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutme);
        toolbar = (Toolbar) findViewById(R.id.id_toolbar);
        appName = (TextView) findViewById(R.id.id_appname);
        appLogo = (ImageView) findViewById(R.id.id_app_logo);
        version = (TextView) findViewById(R.id.id_app_version);
        supportMe = (TextView) findViewById(R.id.id_support_me);

        toolbar.setNavigationIcon(R.drawable.ic_keyboard_arrow_left_white_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        try {
            PackageManager packageManager = getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(getPackageName(), 0);
            String versionName = packageInfo.versionName;
            version.setText("Version "+versionName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        AdView adView = new AdView(this, AdSize.FIT_SCREEN);
        LinearLayout adLayout = (LinearLayout) findViewById(R.id.id_ad_layout);
        adLayout.addView(adView);


    }
}
