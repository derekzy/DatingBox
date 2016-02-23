package com.derekzy.datingbox.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.derekzy.datingbox.Utils.LogUtil;
import com.derekzy.datingbox.modle.CardItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by derekzy on 2016/2/20.
 */
public class MyDatabase {

    /**
     * DatabaseName
     */
    public static final String DB_NAME = "Article.db";

    public static final int VERSION = 1;
    private static MyDatabase myDatabase;
    private SQLiteDatabase db;
    private ContentOpenHelper dpHelper;

    /**
     * 构造方法私有化
     */
    private MyDatabase(Context context) {
        dpHelper = new ContentOpenHelper(context, DB_NAME, null, VERSION);
        db = dpHelper.getWritableDatabase();  //执行这句时表已经插入
    }

    /**
     * 获取MyDatabase实例
     */
    public synchronized static MyDatabase getInstance(Context context) {
        if (myDatabase == null) {
            myDatabase = new MyDatabase(context);
        }
        return myDatabase;
    }

    public void updateFav(String status, String cardItemId) {
        ContentValues values = new ContentValues();
        values.put("fav",status); //浮点型，整型不需要String
        db.update("article", values, "_id like ?", new String[]{cardItemId});
        values.clear();
        Log.d("************", "updateFav is run");
    }

    public void saveNewContent(String content) {
        ContentValues values = new ContentValues();
        values.put("content", content);
        values.put("fav","true"); //浮点型，整型不需要String
        db.insert("article", null, values);
        Log.d("************", "saveNewContent is run");
    }

    public void saveArticle(){
        Log.d("***", "save");
        ContentValues values = new ContentValues();
        values.put("content", "我很怕黑，今晚你可以和我一起睡么");
        values.put("tag", "fun");
        values.put("level", 1);
        values.put("fav", "false");
        db.insert("article", null, values);
        values.clear();
        values.put("content", "虽然不能给你幸福，但是我可以给你祝福\n" +
                "如果祝福都不能给，我希望能给你舒服");
        values.put("tag", "fun evil");
        values.put("level", 4);
        values.put("fav", "false");
        db.insert("article", null, values);
        values.clear();
    }
    public List<CardItem> loadLevel1() {

        List<CardItem> itemList = new ArrayList<>();
        Log.d("***", "loadLevel1");
        Cursor c = db.query("article", null, "level like ?", new String[]{"1"}, null, null, null);
        if (c.moveToFirst()) {
            do {
                CardItem cardItem = new CardItem();
                cardItem.setId(c.getInt(c.getColumnIndex("_id")));
                cardItem.setContent(c.getString(c.getColumnIndex("content")));
                cardItem.setTag(c.getString(c.getColumnIndex("tag")));
                cardItem.setLevel(c.getInt(c.getColumnIndex("level")));
                cardItem.setFav(Boolean.valueOf(c.getString(c.getColumnIndex("fav"))));
                itemList.add(cardItem);
                Log.e("*******", "loadLevel1 content is " + c.getString(c.getColumnIndex("content")) + " tag is "
                        + c.getString(c.getColumnIndex("tag")) + " level is " + c.getInt(c.getColumnIndex("level"))
                        + " fav is " + Boolean.valueOf(c.getString(c.getColumnIndex("fav"))));
            } while (c.moveToNext());
        }
        if (c != null) {
            c.close();
        }
        return itemList;
    }

    public List<CardItem> loadLevel2() {

        List<CardItem> itemList = new ArrayList<>();
        //指定列无效了？
        Cursor c = db.query("article", null, "level like ?", new String[]{"2"}, null, null, null);
        if (c.moveToFirst()) {
            do {
                CardItem cardItem = new CardItem();
                cardItem.setId(c.getInt(c.getColumnIndex("_id")));
                cardItem.setContent(c.getString(c.getColumnIndex("content")));
                cardItem.setTag(c.getString(c.getColumnIndex("tag")));
                cardItem.setLevel(c.getInt(c.getColumnIndex("level")));
                cardItem.setFav(Boolean.valueOf(c.getString(c.getColumnIndex("fav"))));
                Log.e("*******", "loadLevel2 content is " + c.getString(c.getColumnIndex("content")) + " tag is "
                        + c.getString(c.getColumnIndex("tag")) + " level is " + c.getInt(c.getColumnIndex("level"))
                        + " fav is " + Boolean.valueOf(c.getString(c.getColumnIndex("fav"))));
                itemList.add(cardItem);
            } while (c.moveToNext());
        }
        if (c != null) {
            c.close();
        }
        return itemList;
    }

    public List<CardItem> loadLevel3() {

        List<CardItem> itemList = new ArrayList<>();
        //指定列无效了？
        Cursor c = db.query("article", null, "level like ?", new String[]{"3"}, null, null, null);
        if (c.moveToFirst()) {
            do {
                CardItem cardItem = new CardItem();
                cardItem.setId(c.getInt(c.getColumnIndex("_id")));
                cardItem.setContent(c.getString(c.getColumnIndex("content")));
                cardItem.setTag(c.getString(c.getColumnIndex("tag")));
                cardItem.setLevel(c.getInt(c.getColumnIndex("level")));
                cardItem.setFav(Boolean.valueOf(c.getString(c.getColumnIndex("fav"))));
                Log.e("*******", "loadLevel3 content is " + c.getString(c.getColumnIndex("content")) + " tag is "
                        + c.getString(c.getColumnIndex("tag")) + " level is " + c.getInt(c.getColumnIndex("level"))
                        + " fav is " + Boolean.valueOf(c.getString(c.getColumnIndex("fav"))));
                itemList.add(cardItem);
            } while (c.moveToNext());
        }
        if (c != null) {
            c.close();
        }
        return itemList;
    }

    public List<CardItem> loadLevel4() {

        List<CardItem> itemList = new ArrayList<>();
        //指定列无效了？
        Cursor c = db.query("article", null, "level like ?", new String[]{"4"}, null, null, null);
        if (c.moveToFirst()) {
            do {
                CardItem cardItem = new CardItem();
                cardItem.setId(c.getInt(c.getColumnIndex("_id")));
                cardItem.setContent(c.getString(c.getColumnIndex("content")));
                cardItem.setTag(c.getString(c.getColumnIndex("tag")));
                cardItem.setLevel(c.getInt(c.getColumnIndex("level")));
                cardItem.setFav(Boolean.valueOf(c.getString(c.getColumnIndex("fav"))));
                Log.e("*******", "loadLevel4 content is " + c.getString(c.getColumnIndex("content")) + " tag is "
                        + c.getString(c.getColumnIndex("tag")) + " level is " + c.getInt(c.getColumnIndex("level"))
                        + " fav is " + Boolean.valueOf(c.getString(c.getColumnIndex("fav"))));
                        itemList.add(cardItem);
            } while (c.moveToNext());
        }
        if (c != null) {
            c.close();
        }
        return itemList;
    }

    public List<CardItem> loadFlirt() {

        List<CardItem> itemList = new ArrayList<>();
        LogUtil.e("***", "loadFlirt");
        Cursor c = db.query("article", null, "tag like ?", new String[]{"%fun%"}, null, null, null);
        if (c.moveToFirst()) {
            do {
                CardItem cardItem = new CardItem();
                cardItem.setId(c.getInt(c.getColumnIndex("_id")));
                cardItem.setContent(c.getString(c.getColumnIndex("content")));
                cardItem.setTag(c.getString(c.getColumnIndex("tag")));
                cardItem.setLevel(c.getInt(c.getColumnIndex("level")));
                cardItem.setFav(Boolean.valueOf(c.getString(c.getColumnIndex("fav"))));
                itemList.add(cardItem);
                LogUtil.e("*******", "loadFlirt content is " + c.getString(c.getColumnIndex("content")) + " tag is "
                        + c.getString(c.getColumnIndex("tag")) + " level is " + c.getInt(c.getColumnIndex("level"))
                        + " fav is " + Boolean.valueOf(c.getString(c.getColumnIndex("fav"))));
            } while (c.moveToNext());
        }
        if (c != null) {
            c.close();
        }
        return itemList;
    }

    public List<CardItem> loadFav() {

        List<CardItem> itemList = new ArrayList<>();
        LogUtil.e("***", "loadFav");
//        Cursor c = db.query("article", null, "fav like ?", new String[]{"true"}, null, null, null);
        Cursor c = db.rawQuery("SELECT * FROM article where fav like ? ORDER BY _id DESC", new String[]{"true"});
        if (c.moveToFirst()) {
            do {
                CardItem cardItem = new CardItem();
                cardItem.setId(c.getInt(c.getColumnIndex("_id")));
                cardItem.setContent(c.getString(c.getColumnIndex("content")));
                cardItem.setTag(c.getString(c.getColumnIndex("tag")));
                cardItem.setLevel(c.getInt(c.getColumnIndex("level")));
                cardItem.setFav(Boolean.valueOf(c.getString(c.getColumnIndex("fav"))));
                itemList.add(cardItem);
                LogUtil.e("*******", "id is"+c.getInt(c.getColumnIndex("_id"))+"loadFav content is " + c.getString(c.getColumnIndex("content")) + " tag is "
                        + c.getString(c.getColumnIndex("tag")) + " level is " + c.getInt(c.getColumnIndex("level"))
                        + " fav is " + Boolean.valueOf(c.getString(c.getColumnIndex("fav"))));
            } while (c.moveToNext());
        }
        if (c != null) {
            c.close();
        }
        return itemList;
    }
}
