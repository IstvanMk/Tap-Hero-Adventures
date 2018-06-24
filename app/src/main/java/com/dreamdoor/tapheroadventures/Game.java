package com.dreamdoor.tapheroadventures;

import android.media.Image;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class Game extends AppCompatActivity {

    TextView tv_time, tv_zone, tv_gold;
    Button b_click;
    ImageButton imageButton;

    CountDownTimer timer;
    int time = 30;
    int zoneM = 1;
    int zoneB = 1;
    int gold = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        tv_time = (TextView) findViewById(R.id.tv_time);
        tv_zone = (TextView) findViewById(R.id.tv_zone);
        tv_gold = (TextView) findViewById(R.id.tv_gold);
        b_click = (Button) findViewById(R.id.b_click);
        imageButton = (ImageButton) findViewById(R.id.imageButton);
        imageButton.setOnClickListener(imgButtonHandler);


        //set gold to 0
        tv_gold.setText("Gold: " + gold);


        // Start at zone 1 of world 1

        tv_zone.setText("Zone " + zoneM + '-' + zoneB);
        b_click.setEnabled(false);

        //adding the mobs



        timer = new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long l) {
                time--;
                tv_time.setText("Time: " + time);
            }

            @Override
            public void onFinish() {
                b_click.setEnabled(false);
                tv_time.setText("Time: 0");
            }
        };
        b_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gold++;
                tv_gold.setText("Gold: " + gold);
            }
        });
    }
    View.OnClickListener imgButtonHandler = new View.OnClickListener() {

        public void onClick(View v) {
            int[] MobArray = new int[10];{
                MobArray[0] = R.drawable.aerocephal;
                MobArray[1] = R.drawable.arcana_drake;
                MobArray[2] = R.drawable.aurumdrakueli;
                MobArray[3] = R.drawable.bat;
                MobArray[4] = R.drawable.daemarbora;
                MobArray[5] = R.drawable.deceleon;
                MobArray[6] = R.drawable.demonic_essence;
                MobArray[7] = R.drawable.dune_crawler;
                MobArray[8] = R.drawable.green_slime;
                MobArray[9] = R.drawable.nagaruda;
                MobArray[9] = R.drawable.rat;
                MobArray[9] = R.drawable.scorpion;
                MobArray[9] = R.drawable.skeleton;
                MobArray[9] = R.drawable.spider;
                MobArray[9] = R.drawable.stygian_lizard;
            }
            Random generator = new Random();
            int randomIndex = generator.nextInt(MobArray.length);

            imageButton.setImageResource(MobArray[randomIndex]);
        }
    };
}
