package com.derekzy.datingbox.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by derekzy on 2016/2/20.
 */
public class ContentOpenHelper extends SQLiteOpenHelper {
    public ContentOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists article(_id integer primary key autoincrement, content text, tag text, level integer, fav text)");
        Log.e("*******", "create db ");
        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)", new String[]{"我很怕黑，今晚你可以和我一起睡么", "fun", "1", "false"});
        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)", new String[]{"虽然不能给你幸福，但是我可以给你祝福\n" +
                "如果祝福都不能给，我希望能给你舒服", "fun evil", "4", "false"});
        for (int i =0; i< 20; i++) {
            db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)", new String[]{"虽然不能给你幸福，但是我可以给你祝福\n" +
                    "如果祝福都不能给，我希望能给你舒服 test3", "fun evil", "2", "true"});
        }

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)", new String[]{"虽然不能给你幸福，但是我可以给你祝福\n" +
                "如果祝福都不能给，我希望能给你舒服test4", "fun evil", "3", "false"});
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
