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
        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"我很怕黑，今晚你可以和我一起睡么", "fun", "1", "false"});
        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"那天有个护士 好恶心喔 她叫我 小心肝\n" +
                        "我全身都软了，剩下肝是硬的\n" +
                        "Tips：护士、肾、医院", "fun joke", "6", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"前段时间看到一副漫画，我感觉挺喜感的\n" +
                        "若干年后，我们上到了天堂，看到上帝也在那低着头玩手机\n" +
                        "Tips：女神顾着玩手机", "fun", "1", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"你是星期天这么好看，还是每天都这么好看？", "fun", "1", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"你的眼睛像巧克力一样温暖甜美。", "fun", "1", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"长得好看的才叫暖男，我这种丑b只能叫热狗了\n" +
                        "Tips:当被夸是暖男", "fun", "1", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"诶今天穿得不错嘛\n" +
                        "不过这身打扮在我认识的女生中只能排第三了，所以我就喊你小三吧", "fun", "1", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"冬天时穿太多，可以调侃她\n" +
                        "“穿的好像爱斯基摩人啊”", "fun", "1", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"“脸好像比上次见到小了些，是不是刚刚韩国回来。”", "fun", "1", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"最近我老是失眠，每隔16个小时就醒一次", "fun", "1", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"别紧张,我又不是什么好人…… \n" +
                        "Tips:MM紧张", "fun", "1", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"人人都说我丑，其实我只是美得不明显。 ", "fun", "1", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"我又不是人民币，怎么能让人人都喜欢我？", "fun", "1", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"令人不能自拔的，除了牙齿还有爱情。", "fun", "1", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"生活不是林黛玉，不会因为忧伤而风情万种。 \n" +
                        "Tips:鼓励MM要乐观", "fun", "1", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"你今天穿的衣服很漂亮嘛\n" +
                        "（MM窃喜）\n" +
                        "我奶奶也有一件", "fun", "1", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"你笑起来这么甜，是不是经常被蜜蜂蛰呀", "fun", "1", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"“你一笑起来弯弯的眼睛很可爱，像机器猫吃铜锣烧一样。”", "fun", "1", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"“心情如何？”\n" +
                        "“不好。”\n" +
                        "“真的？快讲讲，我就爱听这个。”\n" +
                        "“讨厌。”\n" +
                        "“啊，被你发现在调戏你了，喜欢调戏你啊，要怪只能怪你自己这么可爱。”", "fun", "1", "false"});
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }
}
