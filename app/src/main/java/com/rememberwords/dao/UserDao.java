package com.rememberwords.dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.rememberwords.db.DBOpenHelper;
import com.rememberwords.model.User;

public class UserDao {
    private DBOpenHelper dbOpenHelper;
    private SQLiteDatabase sqLiteDatabase;

    public UserDao(Context context) {
        this.dbOpenHelper = new DBOpenHelper(context);
    }//2、在TbAccountDao 内运行构造函数

    public boolean login(String accountid,String password){
        sqLiteDatabase=dbOpenHelper.getReadableDatabase();//5、在dao对象具体操作数据库表首先要获得SQLiteDatabase数据库对象
        String querysql="select * from tb_account where account_id='"+accountid+"' and account_password='"+password+"'";
        Cursor cursor=sqLiteDatabase.rawQuery(querysql,null);//再通过获得的数据库对象来执行sql语句，//返回一个数据集指针cursor  resultset
        if (cursor.moveToNext()){
            return true;
        }
        return false;
    }

    @SuppressLint("Range")
    public User findUserByAccount(String userAccount) {
        sqLiteDatabase=dbOpenHelper.getReadableDatabase();
        User user=null;
        String querysql="Select * from tb_user where user_account='"+userAccount+"'";
        Cursor cursor=sqLiteDatabase.rawQuery(querysql,null);
        if (cursor.moveToNext()){
            user=new User();
            Integer userId=cursor.getInt(cursor.getColumnIndex("user_id"));
            String account=cursor.getString(cursor.getColumnIndex("user_account"));
            String password=cursor.getString(cursor.getColumnIndex("user_password"));
            String question=cursor.getString(cursor.getColumnIndex("user_ques"));
            String answer=cursor.getString(cursor.getColumnIndex("user_answ"));
            String nickName=cursor.getString(cursor.getColumnIndex("user_nickname"));
            String mobile=cursor.getString(cursor.getColumnIndex("user_mobile"));
            int currencyNum=cursor.getInt(cursor.getColumnIndex("user_currencynum"));
            user.setUserId(userId);
            user.setAccount(account);
            user.setPassword(password);
            user.setNickName(nickName);
            user.setQuestion(question);
            user.setAnswer(answer);
            user.setMobile(mobile);
            user.setCurrencyNum(currencyNum);
        }
        return user;
    }

    public long addAccount(User user) {
        long insertflag=0;
        sqLiteDatabase=dbOpenHelper.getReadableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("user_account",user.getAccount());
        contentValues.put("user_password",user.getPassword());
        contentValues.put("user_nickname",user.getNickName());
        contentValues.put("user_mobile",user.getMobile());
        contentValues.put("user_ques",user.getQuestion());
        contentValues.put("user_answ",user.getAnswer());
        contentValues.put("user_currencynum",0);
        insertflag=sqLiteDatabase.insert("tb_user",null,contentValues);
        return insertflag;
    }


    public int[] getNotificationNum(String user_id) {
        int[] a=new int[]{1,21,3};
        return a;
    }

    public String judgeTypeByiD(String user_id) {
        return "account";
    }
}
