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
                new String[]{"那天有个护士 好恶心喔 她叫我 小心肝\n" +
                        "我全身都软了，剩下肝是硬的\n" +
                        "Tips：护士、肾、医院", "fun", "6", "false"});

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
                new String[]{"前段时间看到一副漫画，我感觉挺喜感的\n" +
                        "若干年后，我们上到了天堂，看到上帝也在那低着头玩手机\n" +
                        "Tips：女神顾着玩手机", "fun", "1", "false"});

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

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"“把手给我。”\n" +
                        "“干吗？”\n" +
                        "“用意念发功，把大姨妈传给我，让我来代替你受这苦吧。”\n" +
                        "Tips:MM来大姨妈”", "fun", "1", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"你让我想起了一个广告\n" +
                        "什么？\n" +
                        "下雨天和美女更配哦\n" +
                        "Tips:下雨的时候", "fun", "1", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"你初吻几岁？\n" +
                        "24...\n" +
                        "15岁就24次了阿", "fun", "2", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"hi\n" +
                        "怎么了？\n" +
                        "没事，我只是好久没见过这么漂亮的姑娘了", "fun", "2", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"女孩子不可以打，即使是用花。\n" +
                        "Tips:讨论到打架的话题", "fun", "2", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"你的眼睛美得像海，我可以在里面游泳么？", "fun", "2", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"我：诶~~其实很多人说我的脸型像陈冠希的~~你发现没有\n" +
                        "她认真的看着我，说像或者不像\n" +
                        "我继续说：其实，我并不觉得这是一种夸奖，你不觉得（停顿一下）我比他帅多了吗~~", "fun", "2", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"“嘿，你是在等我吗？”\n" +
                        "“XX,你跟我想的不太一样啊”\n" +
                        "“怎么了，有什么不一样呢”\n" +
                        "“想象中的你应该是长发及腰,而且是虎背熊腰的”", "fun", "2", "false"});


        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"小时候我以为自己长大后可以拯救整个世界，等长大后才发现整个世界都拯救不了我。  \n" +
                        "真羡慕你这么年轻就认识我了。 ", "fun", "2", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"还没来得及去沾花惹草，就被人拔光了。\n" +
                        "Tips：被问有没有女朋友", "fun", "2", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"特别的人从来不说自己特别，比如说我。\n" +
                        "Tips:被夸奖时", "fun", "2", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"人家是十全十美，你怎么说也是十全八美~~\n" +
                        "那我是缺哪两美？\n" +
                        "内在美和外在美……\n" +
                        "……", "fun", "2", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"笑起来很可爱，让我想起了小松鼠", "fun", "2", "false"});


        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"我发现你侧脸挺美的\n" +
                        "你知道吗\n" +
                        "我不戴眼镜的时候看到什么都觉得美\n" +
                        "不过，你是真的美", "fun", "2", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"玩一个游戏，我问你问题，你要老实回答\n" +
                        "第一次对一个人有感觉是什么时候。\n" +
                        "说一些真的会令你生气的事\n" +
                        "Tips:想了解一个女生时，可以这么问", "fun", "2", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"眼神对视游戏，谁先眨眼谁就输了\n" +
                        "Tips:约会时缓和气氛", "fun", "2", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"要么不做，要做就做到最好。所以你看我什么都不做，就知道我是一个自我要求非常高的人。", "fun", "2", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"你是沦为单身狗，我是贵为单身狗，别我们我们的，狗也有品种的。", "fun", "2", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"你眼睛沾着东西\n" +
                        "沾着什么？\n" +
                        "粘着“迷人”了", "fun", "2", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"欧洲有个传说\n" +
                        "月圆之夜如果吃xx的话\n" +
                        "会出现可爱的妖精\n" +
                        "可是今天那个魔法实现不了了\n" +
                        "我身边已经有一位可爱的妖精\n" +
                        "Tips:晚上一起吃什么的时候", "fun", "2", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"下雨的时候和MM一起打着一把伞，哼唱道：\n" +
                        "外面下着雨～犹如我心血在滴～\n" +
                        "你知道这首歌是什么吗？\n" +
                        "\n" +
                        "张惠妹的《我可以抱你吗》？\n" +
                        "\n" +
                        "可以阿（把她抱入怀里）", "fun", "2", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"诶。。有件事我想跟你说\n" +
                        "其实。。你有点斗鸡眼（等她反应）\n" +
                        "开玩笑的，其实觉得你的眼睛很好看", "fun", "2", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"伸手去摸她头，装作拿掉东西\n" +
                        "她问怎么了\n" +
                        "然后可以说帮你拿掉头发上不清新空气", "fun", "2", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"“你好像某位演员……”（留白，引发好奇心）\n" +
                        "“是吗？谁啊？”\n" +
                        "“你的侧面很像范冰冰，真的很像很像。”\n" +
                        "“是吗，好像是有点。”\n" +
                        "“还好我也看到正面的样子了，看到正面后，一下子让我忘记刚才说你侧面像谁了……”\n" +
                        "Tips:当MM长得和某个明星像的时候", "fun", "2", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"“你今天这条裙子的长度，真的是齐那个什么的小短裙了。”", "fun", "2", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"有一天，妹子突然主动给你发信息，问：“最近怎么样啊？”\n" +
                        "你应该明白，她是有些想你了，提前一步告诉她：“都还好，除了……”\n" +
                        "“除了什么？”\n" +
                        "“别的都好，除了有时会想你。”", "fun", "2", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"咖啡店里，看到一个丑丑的女孩辛苦自拍了一下午，我们还有什么借口不努力？ ", "fun joke", "2", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"路上遇到一个卖龟苓膏的人\n" +
                        "不吆喝，就弄个计算器\n" +
                        "使劲按———\n" +
                        "归零归零归零归零归零归零\n" +
                        "哈哈哈哈哈笑成傻逼", "fun joke", "2", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"你有听过愚公移山的故事么\n" +
                        "愚公死之前把儿子叫到床边嘱咐：\n" +
                        "“移山...移山...”\n" +
                        "儿子眼睛发亮，握住他的手，说到：“亮晶晶满天都是小星星✨”\n" +
                        "“爸比，你有跑调喔~”。\n" +
                        "...愚公卒...", "joke", "6", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"今天有个快递员打电话给我朋友\n" +
                        "他问：“你好，请问你是小黑犬吗？”\n" +
                        "我朋友他其实是叫小默", "joke", "6", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"我有时间一定要去拜访你的母亲，看看她是怎么能生出如此美丽的你。", "fun", "2", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"“你是猫变的吧？气质跟猫一样的感觉，慵懒，温柔，优雅，挑剔。”", "fun", "2", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"如果妹子问“你明天去哪儿？”\n" +
                        "你应该捕捉到信号，她期待你能约她，但女人不能主动来对你说。所以这样的回复是再好不过的了：“我正想问你呢，明天有没有安排，没事的话，我们一起去看电影啊。”", "fun", "2", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"我可爱吗\n" +
                        "嗯 当然了..\n" +
                        "可怜没人爱呐", "fun", "3", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"你能把手指放在我的咖啡里转转吗？这样我就不用放糖了。", "fun", "3", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"要是能做你男票就好了，这样每天一睁眼就能看到天使。", "fun", "3", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"你男朋友真幸福，每天都被太阳照耀，不介意多一个吗？\n" +
                        "Tips:不确定对方有没有男票", "fun", "3", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"上帝对我太残酷了，让我今天才见到你。", "fun", "3", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"嗨，你是想先吃饭还是想先吃我？\n" +
                        "Tips:吃饭", "fun", "3", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"我:我最近脖子疼，今天去看了医生，医生说（停顿一下）只有靠着美女的肩才能缓解。", "fun", "3", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"“你有一点很吸引我”\n" +
                        "“是神马啊”\n" +
                        "“其实，我还没想好...”", "fun", "3", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"真的猛士，敢于直面自己未化妆的脸。\n" +
                        "Tips:约会的时候MM化妆让你等太久了", "fun", "3", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"你有什么不开心的事？说出来让大家开心一下", "fun", "3", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"你像小孩子一样可爱，我想我会像个大哥哥一样照顾你(摸MM的肩膀)", "fun", "3", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"看到我紧张了？原来你这么在乎我哦", "fun", "3", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"我：你什么星座的？\n" +
                        "妹纸：AA。\n" +
                        "我：不会吧，听说这个星座的妹纸性欲很强啊。\n" +
                        "妹纸：“乱讲，BB才强。”\n" +
                        "我：我就是BB。\n" +
                        "妹纸：哈哈，不会吧。\n" +
                        "我：是真的。年轻的时候体力好，用过的都说棒。\n" +
                        "妹纸偷笑。\n" +
                        "“开玩笑的啦，我是这种人吗？不是BB的”。我说。\n" +
                        "“哈哈，那是什么座？”妹纸问。\n" +
                        "“进来做做。”我一脸坏笑的看着妹纸。", "fun", "3", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"你：你相信么，我这张充满魔力的手，能变一个完整的世界出来？\n" +
                        "她：切，谁信啊，你以为你是刘谦啊？\n" +
                        "你：那你答应我，不要动啊，会影响我发挥。\n" +
                        "她：好的。\n" +
                        "你双眼看着自己的手，若有所思的绕着她转了一圈。\n" +
                        "现在，我要拥抱我的世界了。", "fun", "3", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"你把右手食指勾着，问MM是什么东西，答不答得出来都无所谓。\n" +
                        "MM：是什么耶\n" +
                        "GG:一边蠕动食指，一边说：这是一只海马。。。\n" +
                        "MM：神经病\n" +
                        "叫目标也伸出一只食指，把你的食指在MM的食指上移动，问她是什么\n" +
                        "MM：不知道耶\n" +
                        "GG:这是两只海马在kiss\n" +
                        "MM：笑\n" +
                        "这时深情的望着目标，和她十指相扣，问MM是什么？\n" +
                        "MM不解\n" +
                        "温柔的说，这是十只海马在抱抱", "fun", "3", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"“我觉得直接叫你女神概括不了你的个性特征。”\n" +
                        "“那叫什么？”\n" +
                        "“叫平胸女神更能体现你的个性！”", "fun", "3", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"男:问你一个问题,看你能不能答出来\n" +
                        "\n" +
                        "MM:说\n" +
                        "\n" +
                        "男:一个妙龄女孩在河边洗澡,一个男人走过来,那女孩为什么一点都不害羞?\n" +
                        "\n" +
                        "MM:那男的是一个瞎子,看不到?\n" +
                        "\n" +
                        "男:哪有这么简单.那可是一个身体健壮,精力旺盛的青年(强调的语气)\n" +
                        "\n" +
                        "MM:应该是她LG或男朋友吧?\n" +
                        "\n" +
                        "男:他们之间还没到那种程度(暗示),看你这么可怜,提示你一下.你这样想,就说现在你在河边洗澡,我是那个身体健壮,精力旺盛的青年(强调,加重语气),我从旁边走过,看到你在那里洗澡,而且就离我们现在这么近(暗示),应该什么都看得清清楚楚的,你想想,你在什么情况下不害羞呢?(角色扮演)\n" +
                        "\n" +
                        "MM:你胡说什么啊?(提醒:小心粉拳!哎哟,还是打到了)\n" +
                        "男:就是打个比方,看你想到哪去了\n" +
                        "\n" +
                        "MM:夜晚吧?不知道(MM心已乱,哪还有什么心思猜啊)\n" +
                        "\n" +
                        "男:真笨,告诉你算了.是在河边洗枣.红枣的枣.你是不是一开始就以为是洗澡.你脑子里天天在想什么啊", "fun joke", "3", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"告诉你一个秘密  \n" +
                        "靠近点。。  \n" +
                        "kiss", "", "3", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"如果你让你变成一种动物，你会变成什么动物\n" +
                        "......\n" +
                        "然后MM问你想变成什么\n" +
                        "我会变成狮子。。你知道狮子是怎么向母狮示爱的吗？抓住你的头发，然后在你颈部摩擦（可以假装自己是狮子然后这么去做）", "", "3", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"相信这个世界有魔法吗？\n" +
                        "把手给我，闭上眼睛，我数5声你睁开眼\n" +
                        "1...2...3...Kiss", "", "3", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"你造吗？社会学家做了一个调查，据说平常比较冷漠的女生，其实她们的性幻想更加丰富哦~ ", "", "3", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"“知道吗”，一边说一边牵起她的手，然后说，”今天出门前，我上了一座山上的一座庙请教了一个问题。我问他，跟你约会时候该怎么去牵你的手。他跟我说，直接牵她的手，把这个故事讲给你听，就可以了。“然后我装作很震惊的表情，“哇，好神奇啊，真的可以耶。”", "3", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"我发现你还挺温柔的\n" +
                        "我有点喜欢你了\n" +
                        "\n" +
                        "哈？当我没说好了\n" +
                        "Tips:MM为你做了一些事情时", "", "3", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"最近我学习了一种魔术，一种可以让人心跳加速的魔术,  信不信.....？（这个主要是激起她的好奇心）如果她不信，你就可以开始了......上前直接牵手然后慢慢靠近她,好像是要吻她，到一定的距离的时候就可以问她加速了没有。如果没有那就继续直到吻到她为止。", "", "3", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"拿起她的手，看了看她的手掌：“你原来那么花心，我都不想和你说话了。”然后甩开她的手。", "", "3", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"“你看上去还挺纯的。”“不过长得纯的一般都是坏女人。”", "", "3", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"看电影的时候，手悄悄伸过去握住了MM的手\n" +
                        "你要干嘛？\n" +
                        "这样我比较有安全感", "", "3", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"你爱我吗？\n" +
                        "爱\n" +
                        "有多爱？\n" +
                        "有80秒爱”", "fun", "4", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"你知道我第一眼看到你的时候，我想到什么了吗？\n" +
                        "当我看到你的时候，就像看到了童话里拥有永恒美貌的公主。", "fun", "4", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"只要¥998，本人带回家，既可么么哒，又可啪啪啪。", "fun", "4", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"快说你喜欢我这种类型的\n" +
                        "我要做一个有思想的人", "fun", "4", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"我多想一个不小心就和你白头偕老。 ", "fun", "4", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"结婚就是给自由穿件棉衣，活动起来不方便，但会很温暖\n" +
                        "Tips:谈论到婚姻", "fun", "4", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"XX就像内裤，看不见但很重要。", "fun", "4", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"我很怕黑，今晚你可以和我一起睡么", "fun sex", "4", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"硬邦邦，还挺长，在一个黑洞里面活动，慢慢就变软了 \n" +
                        "打一谜语：口香糖", "fun sex joke", "4", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"有一天，灰太郎抓住了美羊羊，回家之后，灰太郎把美羊羊肚子搞大了，红太狼发现把灰太狼打了一顿，灰太郎说：“老婆我是想让你多吃一只羊嘛！”如果我是灰太狼，也这么对你，你会不会打我阿？ ", "joke", "4", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"你就像一只乖乖待挤的奶牛\n" +
                        "Tips:讨论到动物，牛...", "sex", "4", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"给MM讲故事，故作神秘得和她说，给你出个脑筋急转弯：一只公老鹰和一只母老鹰在空中飞行，母老鹰发现一只羊死在下面草地上，母老鹰就对公老鹰说了一句话，结果公老鹰直接骑到母老鹰身上去了，猜一猜，母老鹰说了什么？\n" +
                        "\n" +
                        "如果MM听过这个，她会做出回应，若有意，会脸红娇羞，若无意，也会委婉得告诉你，总之呢，你可以通过这种方式调戏MM。\n" +
                        "\n" +
                        "如果MM没听过这个，你可以色色得看着她说：母老鹰说，下面羊（痒）死了。接下来，你懂得……", "sex", "4", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"慢慢靠近她，我觉得你的嘴唇很性感\n" +
                        "哦？刚刚看错了，我眼神恍惚了一下（如果她反应不好）", "fun", "4", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"这衣服不好，你的身材太完美了，我都看不够，怎么与别人分享呢？", "", "4", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"我一直都以为中分的女生才是我的菜，直到此刻我遇见了你。", "", "4", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"我宁愿我们身隔千里，而心在一起。但不愿我们身在咫尺，而心隔万里", "", "4", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"你说你以后可能会和不喜欢的人结婚，没关系，我愿意做那个你不喜欢的人。", "", "4", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"我又不是王子，为什么女孩遇见我总认为自己应该成为公主", "", "4", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"总有一天你的名字会出现在我家的户口本上", "", "4", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"你造吗？社会学家做了一个调查，据说经常对着电脑屏幕的女生，胸部会比其他女生小1/3哦~ ", "", "4", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"户外or室内野餐\n" +
                        "\n" +
                        "有吃有喝又能亲近自然的放松方式，谁不喜欢呢？买一个漂亮的藤篮（不少网店都有卖，而家价钱很便宜），带上厚一点的野餐毯和美味的小吃饮品，到附近的公园野餐吧，如果你的城市没有合适的户外场地可以这么做，其实在家里野餐也很有感觉，地上铺一张毯子，放一些靠枕，然后用椅子之类的东西和被子一起撑起类似于帐篷的空间，不开灯，只用烛光照明，这样就能营造出浪漫调情的氛围。\n" +
                        "\n" +
                        "*野餐的时候尽量不要用一次性餐具。室内野餐最好在晚上，但蜡烛不要里帐篷太紧，以免烧着。", "", "4", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"一起报名参加有趣的体验课程\n" +
                        "\n" +
                        "上网找找，你会发现自己所在的城市其实定期都会举行一些单日的小班趣味体验课程，比方说做Cupcake、做永生花盒、陶艺课、烹饪，或者是手作木器等等，可以一起学习一门新手艺，感觉保证要比吃饭看电影好玩、难忘得多", "", "4", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"去逛旧物市集\n" +
                        "\n" +
                        "同样是逛街，但逛旧物市集、手作市集、古董店之类地方，感觉可是大不同，一路上就象是在寻宝，说不定会淘到心仪的好物，但前提是你必须先了解清楚你的另一半对于复古、旧物的看法。", "", "4", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"去有Live Music Show的酒吧或者去看即兴表演\n" +
                        "\n" +
                        "有的酒吧会邀请音乐人现场表演，例如Jazz Bar，各位不妨在网络上搜索一下，看看有没有适合你们的活动，然后找个周末的晚上一起去喝喝酒、听听歌、跳跳舞，感受微醺的美好，现场气氛会让你暂忘掉烦恼。如果对音乐无感，那么也可以去看看即兴表演。", "", "4", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"去果园采集水果\n" +
                        "\n" +
                        "如果你的那一位不是那种特别娇气的，不妨考虑一下去城市周边的果园采集水果，尤其是像草莓这些女孩子比较喜欢的。但荔枝这种虫子比较多的就不推荐了。\n" +
                        "\n" +
                        "*出行前记得告诉另一半你的安排，以免对方穿着裙子、脚蹬高跟鞋去果园，另外就是记得贴心地准备好蚊虫叮咬药、防晒伞和清凉的湿纸巾。", "", "4", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"电影马拉松之夜\n" +
                        "\n" +
                        "非常低成本的约会方式，尤其适合不想出门的情侣。最好是安排在周六，大家先一齐商定好要看哪些电影，并且准备好足够的零食和饮料，然后就可以盖着毯子窝在沙发上开始你们的电影马拉松之夜啦！记得要穿上最舒适的衣服哦。如果你们都喜欢热闹，那么可以多约几个朋友来，然后举办一个恐怖电影之夜。", "", "4", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"列出Bucket list，然后陪对方去完成\n" +
                        "\n" +
                        "大家一起列出自己的Bucket List，然后选一些花一两天就能完成的去陪对方做，每个周末只要有时间都去实现Bucket List，这样好长时间都不用再苦恼约会要干什么了。", "", "4", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"举办一场Drunch Party或者是Game Night\n" +
                        "\n" +
                        "如果你们不想总是两个人私密约会，那么可以举办一个Drunch Party或者是Game Night。你没看错，我也没打错，确实是“Drunch”，这是一场有酒喝的早午餐，约上朋友一起在周末享用丰富的早午餐吧，有酒精助兴，气氛会更加活跃。\n" +
                        "\n" +
                        "食物方面，其实不需要太复杂，准备点水果、芝士、面包和果汁、酒，摆得漂亮一点，然后煎些火腿、香肠、培根之类的就可以了。如果你懒得开火，好一点的超级市场会有现成的熏鸡肉、咸牛肉卖。早上喜欢睡懒觉的话，你也可以改成游戏之夜。", "", "4", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"重温最难忘的约会\n" +
                        "\n" +
                        "什么点子都用完了吗？那么不妨试试去重现难忘的回忆吧。比方说第一次约会的情景，大家都尽量回复到当初的装扮，去同一家餐厅点同一样的菜，这同样会是很有趣的经历，如果你正打算求婚，那么大可以在这个时刻提出你的请求，告诉她你很后悔，后悔第一次约会的时候没有立刻娶她回家。", "", "4", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"1-10之间，你觉得我们之间的爱情指数是多少？\n" +
                        "我做些什么可以让你被爱的感觉提高呢", "", "4", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"我：不要诋毁撸，伍迪艾伦说：撸是我与自己的真爱之间发生的关系…", "fun", "", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"一女子因胸小而嫁不出去，一日相亲对男人说：我胸小，你嫌弃嘛？男人说：有馒头大嘛？女人说：有！洞房之夜，男人哭了…原来是旺仔小馒头！", "joke", "4", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"郭敬明家住16楼，为什么他每次都坐电梯到十楼再走回家？ 答：因为他只能按到10楼的按钮。", "joke", "", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"回家路上，见一位老大爷推着一个老太太，心想真温馨啊！ \n" +
                        "过了一会儿，那老头停了下来，对老太太说：“下来，该你推我了！” ", "joke", "", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"有个朋友暗恋女神很久了，犹豫很久终于鼓起勇气表白，她很不好意思，说：“这样吧，我们让上帝决定吧，扔骰子，你的点数大我就做你女朋友，我的点数大的话你就做我的男朋友。” \n" +
                        "这时候我的朋友想了想，哎呀，女神这是摆明了答应我了啊！心里很是激动，于是马上扔骰子，结果尼玛居然打平了！ ", "joke", "", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"以前听有的女生说13厘米受不了，很疼！还有的说9厘米都太长了。但是今天认识一个女汉子，竟然说5厘米也不行，疼得走路都别扭。可我看电视里很多女的20厘米也很享受啊，人跟人差别真大，同样是女的，穿个高跟鞋，怎么完全不一样呢？", "joke", "", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"一男子拿了便利店的巧克力拔腿就跑\n" +
                        "跑至半路时又冒雨折回\n" +
                        "抢夺售货员的随身听被逮住\n" +
                        "警察赶到时质问他为什么这么做\n" +
                        "他抹了把脸上的雨水茫然说：\n" +
                        "“听说下雨天巧克力和音乐更配。”", "joke", "", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"兄弟俩吵架\n" +
                        "哥哥用所知道的所有\n" +
                        "难听词汇骂了弟弟10分钟\n" +
                        "弟弟淡定的来了一句：\n" +
                        "“反弹”\n" +
                        "哥哥哭了", "joke", "", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"什么叫宽容？\n" +
                        "小明考完试，拿试卷给老爸看，老爸说：“数学0分！”小明惊吓中……\n" +
                        "老爸说：“语文1分！”小明点点头，颤抖中……\n" +
                        "空气凝结、气氛无比恐怖、小明感到有一场腥风暴雨将要发生在自己身上。\n" +
                        "老爸深吸一口气，缓缓说道：“明啊，你有点偏科啊！”", "joke", "", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"渔夫：“鱼儿，听说你冰雪聪明、足智多谋、深藏不露……”\n" +
                        "鱼儿：“是啊！”\n" +
                        "渔夫：“那我考考你。”\n" +
                        "鱼儿：“好啊。”\n" +
                        "二十分钟后，渔夫闻了闻手里的烤鱼：“嗯，真香！”", "joke", "", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"男：我上大学时有个老师总爱用荤段子来吸引大家的注意力\n" +
                        "有次他见我们下面说话的说话，睡觉的睡觉，突然说到：考你们一个智力题，烂掉的萝卜和怀孕的女人有什么相同点？（这时，你可以让对方先猜，如果她猜不对，你可以说你的智力果然如我所料——很有限，然后继续讲；如果她猜对了，你可以说想不到你在这方面天赋异禀啊！）下面安静了会后，有一个同学答道：都是虫子惹的祸，然后面露得意之色。想不到老师马上说：勉强及格。这时就坐我旁边一戴眼镜的看起来很斯文女生，弱弱的说了句：是不是因为拔晚了。教室顿时沉默了3妙，接着就是哄的满堂大笑！你还可以说，真是人不可貌相，女生也会伪装啊。", "joke", "", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"我很怕别人说的一句口头禅，你懂我的意思吗？\n" +
                        "我有个朋友，他就老喜欢说这句话，你懂我的意思吗。\n" +
                        "下星期请你吃顿饭吧，你懂我的意思吧？\n" +
                        "顺便带上小欣来，你懂我的意思吧？\n" +
                        "\n" +
                        "我懂什么啊。。。\n" +
                        "\n" +
                        "因此，每次跟他聊不到三句话，我都怀疑我智商是不是有问题，为什么我每听一句话都有别的意思啊 ", "joke", "", "false"});

        db.execSQL("insert into article (content, tag, level, fav) values(?, ?, ?, ?)",
                new String[]{"小烨（MM的名字）和宿舍的几个女同学去奶牛场挤牛奶体验生活，农场老板给每个人一个小板凳和一个奶桶，让大家自己找牛挤牛奶。半个小时过去了，别的同学都挤好了满满一桶，但是小烨却只挤出来了一点，小烨很烦躁，就喊来了农场老板说“老板，为什么她们都挤满了，我就挤了几滴？”老板看了下牛，无奈的说：“小烨，你挤的是公牛”", "joke", "", "false"});


    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }
}
