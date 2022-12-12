package com.rememberwords.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBOpenHelper extends SQLiteOpenHelper {
    private static final String DBNAME="words.db";
    private static final int VERSION=1;
    public DBOpenHelper(@Nullable Context context) {//通过构造函数来创建数据库  context=LoginActivity
        super(context, DBNAME, null, VERSION);//sqliteopenhelper:创建数据库 context=LogigActivity
    }//3、在DBOpenHelper内运行构造函数
    //LoginActivity要操作数据：通过super就把context=LoginActivity与DBNAME=diancandb.db关联起来了

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {//通过onCreate函数创建表
        //创建单词表
        sqLiteDatabase.execSQL("create table tb_words(" +
                "word_id int(10) not null ," +
                "word varchar(20) not null," +
                "phonetics varchar(30) not null," +
                "pronunciation_address varchar(100) not null," +
                "mv_address varchar(500),"+
                "belongTo varchar(100) not null,"+
                "type varchar(30) not null,"+
                "interpretation varchar(50) not null,"+
                "example varchar(200)  not null, primary key(word_id))");
        sqLiteDatabase.execSQL("insert into tb_words values('1','hello',' [həˈləʊ] ','http://dict.youdao.com/dictvoice?audio=hello','','4'," +
                "'/n','你好;(用于问候、接电话或引起注意)喂;(表示惊讶或认为别人说了蠢话或没有注意听)嘿','Hello John, how are you?')");
        //创建用户表
        sqLiteDatabase.execSQL("CREATE TABLE `tb_user` (" +
                " user_id integer PRIMARY KEY AUTOINCREMENT," +
                "user_account varchar(10) not null," +
                "user_password varchar(20) not null," +
                "user_nickname varchar(15) not null," +
                "user_ques varchar(20) not null, user_answ varchar(20)," +
                "user_mobile varchar(15) not null," +
                "user_currencynum int(10) not null)");
        sqLiteDatabase.execSQL("INSERT INTO tb_user VALUES(null,'user01','123456','张三','我的妈妈是谁？','张三妈妈','18728553438',0)");
        sqLiteDatabase.execSQL("INSERT INTO tb_user VALUES(null,'user02','123456','李四','我的妈妈是谁？','李四妈妈','18200515719',10)");


        //创建日志表
        sqLiteDatabase.execSQL("CREATE TABLE `tb_logs` (" +
                "  `log_id` int(20) NOT NULL," +
                "  `logintime` datetime not null," +
                "  `exittime` datetime not null,"+
                "   studytime double(10,1) not null,"+
                "   user_id varchar(10) not null,"+
                " CONSTRAINT `FK_user_id` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT," +
                "  PRIMARY KEY (`log_id`));");
        //创造日志预置数据
        sqLiteDatabase.execSQL("INSERT INTO `tb_logs` VALUES ('1', '2021-12-16 22:07:41','2021-12-28 22:07:41',4.2,1);");

        //创建生词本表
        sqLiteDatabase.execSQL("CREATE TABLE `tb_user_word` (" +
                "  `word_id` int(10) NOT NULL," +
                "  `user_id` int(10) NOT NULL," +
                "  CONSTRAINT `FK_word_id` FOREIGN KEY (`word_id`) REFERENCES `tb_words` (`word_id`) ON DELETE RESTRICT ON UPDATE RESTRICT," +
                "  CONSTRAINT `FK_user_id` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT);");
        //创造生词本预置数据
        sqLiteDatabase.execSQL("INSERT INTO `tb_user_word` VALUES ('1', '1');");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
