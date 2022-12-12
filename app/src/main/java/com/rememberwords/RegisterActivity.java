package com.rememberwords;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.rememberwords.dao.UserDao;
import com.rememberwords.model.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {
    EditText et_userAccount, et_userName, et_userTel, et_userIssue1;
    EditText et_userDaan1,et_accountpassword, et_accountpassword1;
    Button btn_regist_id, btn_goback_id;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
        initEvent();
    }

    private void initEvent() {
        btn_regist_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userAccount=et_userAccount.getText().toString();
                String userName=et_userName.getText().toString();
                String userTel=et_userTel.getText().toString();
                String userIssue1=et_userIssue1.getText().toString();
                String userDaan1=et_userDaan1.getText().toString();
                String accountpassword=et_accountpassword.getText().toString();
                String accountpassword1=et_accountpassword1.getText().toString();
                UserDao userDao=new UserDao(RegisterActivity.this);
                User user = userDao.findUserByAccount(userAccount);
                if (userAccount == null||"".equals((userAccount.trim()))){
                    Toast.makeText(RegisterActivity.this, "用户账号不能为空", Toast.LENGTH_LONG).show();
                    return;
                }

                if (userName == null||"".equals((userAccount.trim()))){
                    Toast.makeText(RegisterActivity.this, "用户昵称不能为空", Toast.LENGTH_LONG).show();
                    return;
                }

                if (accountpassword == null||"".equals((userAccount.trim()))){
                    Toast.makeText(RegisterActivity.this, "用户密码不能为空", Toast.LENGTH_LONG).show();
                    return;
                }

                if (userIssue1 == null||"".equals((userAccount.trim()))){
                    Toast.makeText(RegisterActivity.this, "密保问题1不能为空", Toast.LENGTH_LONG).show();
                    return;
                }
                if (userDaan1 == null||"".equals((userAccount.trim()))){
                    Toast.makeText(RegisterActivity.this, "密保答案1不能为空", Toast.LENGTH_LONG).show();
                    return;
                }

                if (!accountpassword.equals((accountpassword1))){
                    Toast.makeText(RegisterActivity.this, "两次输入密码不一致", Toast.LENGTH_LONG).show();
                    return;
                }
                Pattern pattern = Pattern.compile("^1[3,4,5,7,8,9][0-9]{9}");
                Matcher matcher = pattern.matcher(userTel);
                if (!matcher.matches()){
                    Toast.makeText(RegisterActivity.this, "电话号码格式错误", Toast.LENGTH_LONG).show();
                    return;
                }


                if (user != null) {
                    Toast.makeText(RegisterActivity.this, "用户呢称已存在", Toast.LENGTH_LONG).show();
                }else {
                    User user1 = new User();
                    user1.setUserId(null);
                    user1.setAccount(userAccount);
                    user1.setNickName(userName);
                    user1.setMobile(userTel);
                    user1.setPassword(accountpassword);
                    user1.setQuestion(userIssue1);
                    user1.setAnswer(userDaan1);
                    long addflag = userDao.addAccount(user1);
                    if (addflag > 0) {
                        Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(RegisterActivity.this, "注册失败", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        btn_goback_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void initView() {
        et_userAccount=findViewById(R.id.et_userAccount);
        et_userName=findViewById(R.id.et_userName);
        et_userTel=findViewById(R.id.et_userTel);
        et_userIssue1=findViewById(R.id.et_userIssue1);
        et_userDaan1=findViewById(R.id.et_userDaan1);
        et_accountpassword=findViewById(R.id.et_accountpassword);
        et_accountpassword1=findViewById(R.id.et_accountpassword1);
        btn_regist_id=findViewById(R.id.btn_regist_id);
        btn_goback_id=findViewById(R.id.btn_goback_id);
    }
}