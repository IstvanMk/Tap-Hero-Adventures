package com.dreamdoor.tapheroadventures;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.util.Random;

public class Game extends AppCompatActivity {

    TextView tv_time, tv_zone, tv_gold, tv_mobName, tv_health,tv_zoneName;
    ProgressBar  progressBar;
    ImageButton imageButton;

    CountDownTimer timer;
    int time = 30;
    int zoneM = 1;
    int zoneB = 1;
    int gold = 0;


    //theMobs
    MobBuilder aerocephal = new MobBuilder("Aerocephal", R.drawable.aerocephal, 5, 10);
    MobBuilder arcana_drake = new MobBuilder("Arcana Drake", R.drawable.arcana_drake, 2, 8);
    MobBuilder aurumdrakueli = new MobBuilder("Aurum Drakueli", R.drawable.aurumdrakueli, 4, 6);
    MobBuilder bat = new MobBuilder("Angry Bat", R.drawable.bat, 2, 10);
    MobBuilder daemarbora = new MobBuilder("Daemarbora", R.drawable.daemarbora, 5, 5);
    MobBuilder deceleon = new MobBuilder("Deceleon", R.drawable.deceleon, 7, 7);
    MobBuilder demonic_essence = new MobBuilder("Demonic Essence", R.drawable.demonic_essence, 6, 6);
    MobBuilder dune_crawler = new MobBuilder("Dune Crawler", R.drawable.dune_crawler, 8, 8);
    MobBuilder green_slime = new MobBuilder("Green Slime", R.drawable.green_slime, 6, 6);
    MobBuilder nagaruda = new MobBuilder("Nagaruda", R.drawable.nagaruda, 9, 9);
    MobBuilder rat = new MobBuilder("Rat", R.drawable.rat, 4, 4);
    MobBuilder scorpion = new MobBuilder("Scorpion", R.drawable.scorpion, 6, 7);
    MobBuilder skeleton = new MobBuilder("Skeleton", R.drawable.skeleton, 1, 3);
    MobBuilder snake = new MobBuilder("Snake", R.drawable.snake, 5, 6);
    MobBuilder spider = new MobBuilder("Spider", R.drawable.spider, 3, 6);
    MobBuilder stygian_lizard = new MobBuilder("Lizard", R.drawable.stygian_lizard, 1, 7);

    //add the mobs to the main array

    MobBuilder [] mobArray = new MobBuilder[] {
      aerocephal,arcana_drake,aurumdrakueli,bat,daemarbora,deceleon,demonic_essence,dune_crawler,green_slime,nagaruda,rat,scorpion,skeleton,snake,spider,stygian_lizard
    };

    //get the random mob from the list

    Random r = new Random();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        tv_time = (TextView) findViewById(R.id.tv_time);
        tv_zone = (TextView) findViewById(R.id.tv_zone);
        tv_zoneName = (TextView) findViewById(R.id.tv_zoneName);
        tv_gold = (TextView) findViewById(R.id.tv_gold);
        tv_health = (TextView) findViewById(R.id.tv_health);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        tv_mobName = (TextView) findViewById(R.id.tv_mobName);
        imageButton = (ImageButton) findViewById(R.id.imageButton);



        double  progress = ((double)(aerocephal.getHealth()*10) / aerocephal.getMaxHealth()) * 10;
        progressBar.setProgress((int)progress);
        tv_health.setText("Health: " + aerocephal.getHealth() + "/" +  aerocephal.getMaxHealth());

        //set gold to 0
        tv_gold.setText("Gold: " + gold);

        // Start at zone 1 of world 1
        tv_zone.setText("Zone " + zoneB + '-' + zoneM);

        //temp place for zoneName, will be moved into an object

        tv_zoneName.setText("Newbie Woods");

        timer = new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long l) {
                time--;
                tv_time.setText("Time: " + time);
            }

            @Override
            public void onFinish() {
//                b_click.setEnabled(false);
                tv_time.setText("Time: 0");
            }
        };
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gold++;
                tv_gold.setText("Gold: " + gold);
                int randomIndex = r.nextInt(mobArray.length);
                imageButton.setImageResource(mobArray[randomIndex].getImageloc());
                tv_mobName.setText(mobArray[randomIndex].getName());
                double  progress = ((double)(mobArray[randomIndex].getHealth()*10) / mobArray[randomIndex].getMaxHealth()) * 10;
                progressBar.setProgress((int)progress);
                tv_health.setText("Health: " + mobArray[randomIndex].getHealth() + "/" +  mobArray[randomIndex].getMaxHealth());
                if (zoneM < 10) {
                    zoneM++;
                    tv_zone.setText("Zone " + zoneB + '-' + zoneM);
                }
                else {
                    zoneM = 1;
                    zoneB++;
                    tv_zone.setText("Zone " + zoneB + '-' + zoneM);
                }
            }
        });
    }
}
