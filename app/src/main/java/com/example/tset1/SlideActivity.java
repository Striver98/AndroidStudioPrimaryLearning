package com.example.tset1;

import static com.example.tset1.R.id.btn_main_1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SlideActivity extends AppCompatActivity {
    //声明控件
    private ImageView mIvAvatar;
    private SlideMenu slideMenu;
    private Button mBtnNotes;
    private Button mBtnSchedule;
    private Button mBtnAgenda;
    private Button mBtnSayings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_slide);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    //找到控件
    mIvAvatar=findViewById(R.id.iv_user_avatar);
    slideMenu=findViewById(R.id.slideMenu);
    mBtnNotes=findViewById(btn_main_1);
    mBtnSchedule=findViewById(R.id.btn_main_2);
    mBtnAgenda=findViewById(R.id.btn_main_3);
    mBtnSayings=findViewById(R.id.btn_main_4);

    //实现侧滑的部分,点击加侧滑
    mIvAvatar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            slideMenu.switchMenu();
        }
    });
    setListener();
    }

    private void setListener(){
        OnClick onClick = new OnClick();
        //对每一个按钮进行setOnClickListener
        mBtnNotes.setOnClickListener(onClick);
        mBtnSchedule.setOnClickListener(onClick);
        mBtnAgenda.setOnClickListener(onClick);
        mBtnSayings.setOnClickListener(onClick);
    }
    private class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intent=null;
            switch(v.getId()){
                case R.id.btn_main_1:
                    intent = new Intent(SlideActivity.this,NotesActivity.class);
                    break;
                case R.id.btn_main_2:
                    intent = new Intent(SlideActivity.this,ScheduleActivity.class);
                    break;
                case R.id.btn_main_3:
                    intent = new Intent(SlideActivity.this,AgendaActivity.class);
                    break;
                case R.id.btn_main_4:
                    intent = new Intent(SlideActivity.this,SayingsActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }

}