package com.derekzy.datingbox.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.derekzy.datingbox.R;
import com.derekzy.datingbox.db.MyDatabase;
import com.derekzy.datingbox.modle.CardItem;

import java.io.BufferedInputStream;

/**
 * Created by derekzy on 2016/2/23.
 */
public class EditActivity extends AppCompatActivity{

    private Toolbar toolbar;
    private EditText editText;
    private MyDatabase myDatabase;
    private Button saveButton;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        backToOthersActivity();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_layout);
        myDatabase = MyDatabase.getInstance(this);

        toolbar = (Toolbar) findViewById(R.id.id_toolbar);
        editText = (EditText) findViewById(R.id.id_edit);
        saveButton = (Button) findViewById(R.id.id_save_button);
//        setSupportActionBar(toolbar);
        toolbar.inflateMenu(R.menu.edit_toolbar);

        toolbar.setNavigationIcon(R.drawable.ic_keyboard_arrow_left_white_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToOthersActivity();
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String newContent = editText.getText().toString();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        myDatabase.saveNewContent(newContent);
                    }
                }).start();

//                        CardItem cardItem = new CardItem();
//                        cardItem.setId(1000);
//                        cardItem.setContent(newContent);
//                        cardItem.setFav(true);
//                        cardItem.setLevel(0);
//                        cardItem.setTag(null);

                backToOthersActivity();
//                        intent.putExtra("newContent", cardItem);
//                        setResult(RESULT_OK, intent);
            }
        });
    }

    private void backToOthersActivity() {
        Intent intent = new Intent(EditActivity.this, OthersActivity.class);
        intent.putExtra("flag", OthersActivity.FAV);
        startActivity(intent);
        finish();
    }
}
