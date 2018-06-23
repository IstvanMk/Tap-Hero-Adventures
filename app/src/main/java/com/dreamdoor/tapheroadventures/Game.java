package com.dreamdoor.tapheroadventures;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

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

        //set gold to 0
        tv_gold.setText("Gold: " + gold);


        // Start at zone 1 of world 1

        tv_zone.setText("Zone " + zoneM + '-' + zoneB);
        b_click.setEnabled(false);

        //adding the mobs

        class Mobs {
            private String name;
            private String icon;
            private int health;
        }


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
}
