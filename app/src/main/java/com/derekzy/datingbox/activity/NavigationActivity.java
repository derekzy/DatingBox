package com.derekzy.datingbox.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.derekzy.datingbox.R;

import java.sql.BatchUpdateException;

/**
 * Created by derekzy on 2016/2/22.
 */
public class NavigationActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private Button feelingButton;
    private Button flirtingButton;
    private Button favButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_navigation);

        toolbar = (Toolbar) findViewById(R.id.id_toolbar);
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
