package com.example.xmb.room1;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ImageView mRoom_Main_Package,mRoom1,mRoom_Main_Package_1,mRoom1_tv,mRoom1_package,mRoom1_door,mBack,mPackage_open1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏标题
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);//设置全屏
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view();
    }

    protected void onResume() {//强制横屏

        if(getRequestedOrientation()!= ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
        super.onResume();
    }

    private void view(){
        mRoom_Main_Package= (ImageView) this.findViewById(R.id.main_package);
        mRoom1= (ImageView) this.findViewById(R.id.room1);
        mRoom1_tv= (ImageView) this.findViewById(R.id.room1_tv);
        mRoom1_package= (ImageView) this.findViewById(R.id.room1_package);
        mBack= (ImageView) this.findViewById(R.id.back);
        mRoom1_door= (ImageView) this.findViewById(R.id.room1_door);
        mPackage_open1= (ImageView) this.findViewById(R.id.package_open1);
        mRoom1.setImageResource(R.drawable.roomallsight);
        if (mRoom1.getDrawable().getCurrent().getConstantState().equals(getResources().getDrawable(R.drawable.roomallsight).getConstantState())){//判断image中是否为某个图片

            mRoom1_tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mRoom1.setImageResource(0);
                    mRoom1.setImageResource(R.drawable.romm1tv);
                    mBack.setImageResource(R.drawable.back);

                }
            });
            mRoom1_package.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mRoom1.setImageResource(0);
                    mRoom1.setImageResource(R.drawable.room1_package);
                    mBack.setImageResource(R.drawable.back);
                }
            });
            mRoom1_door.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mRoom1.setImageResource(0);
                    mRoom1.setImageResource(R.drawable.room1_door);
                    mBack.setImageResource(R.drawable.back);
                }
            });

        }
        if (mRoom1.getDrawable().getCurrent().getConstantState().equals(getResources().getDrawable(R.drawable.room1_package).getConstantState())){
            mPackage_open1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mRoom1.setImageResource(R.drawable.package_open1_1);
                }
            });

        }

        mRoom_Main_Package_1= (ImageView) this.findViewById(R.id.main_package_1);//背包
        mRoom_Main_Package.setOnClickListener(new View.OnClickListener() {
            int click=1;
            @Override
            public void onClick(View view) {

                if(click%2!=0){
                    mRoom_Main_Package_1.setImageResource(R.drawable.coin);
                    click ++;
                }else{mRoom_Main_Package_1.setImageResource(0);
                click++;}
            }
        });
    }
}
