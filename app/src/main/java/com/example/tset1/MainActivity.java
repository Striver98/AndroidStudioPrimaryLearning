package com.example.tset1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.tset1.util.ToastUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //声明控件
    private Button mbtnLogin;
    private EditText mEtUser;
    private EditText mEtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //找到控件
        mbtnLogin=findViewById(R.id.btn_login);
        mEtUser=findViewById(R.id.et_1);
        mEtPassword=findViewById(R.id.et_2);

//        //实现直接跳转---方法一
//        mbtnLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=null;
//                intent = new Intent(MainActivity.this,FunctionActivity.class);
//                startActivity(intent);
//            }
//        });
        //匹配对应的用户名和密码才能进行登录操作
        mbtnLogin.setOnClickListener(this);

    }
   public void onClick(View v){
        //需要获取输入的用户名和密码
        String username = mEtUser.getText().toString();
        String password = mEtPassword.getText().toString();
        Intent intent = null;
        //弹出内容设置
       String ok = "登录成功";
       String fail = "密码或者账号有误，请重新输入";
        //假设正确的账号和密码分别是wzx，123456
        if(username.equals("wzx")&&password.equals("123456")){
            //toast普通版
            //Toast.makeText(getApplicationContext(),ok,Toast.LENGTH_SHORT).show();

            //封装好的类
            ToastUtil.showMsg(MainActivity.this,ok);

            //如果正确进行跳转
            intent = new Intent(MainActivity.this, SlideActivity.class);
            startActivity(intent);
        }else {
            //不正确,弹出登录失败toast
            //toast提升版，居中显示
//            Toast toastCenter = Toast.makeText(getApplicationContext(),fail,Toast.LENGTH_SHORT);
//            toastCenter.setGravity(Gravity.CENTER,0,0);
//            toastCenter.show();
            ToastUtil.showMsg(MainActivity.this,fail);
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }


}