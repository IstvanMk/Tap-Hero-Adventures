package com.dreamdoor.tapheroadventures;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import java.util.Random;

public class Game extends AppCompatActivity {

    TextView tv_time, tv_zone, tv_gold;
    Button b_click;
    ImageButton imageButton;

    CountDownTimer timer;
    int time = 30;
    int zoneM = 1;
    int zoneB = 1;
    int gold = 0;


    //theMobs

    MobBuilder aerocephal = new MobBuilder("Aerocephal", R.drawable.aerocephal, 10, 10);
    MobBuilder arcana_drake = new MobBuilder("Bat", R.drawable.arcana_drake, 10, 10);
    MobBuilder aurumdrakueli = new MobBuilder("Bat", R.drawable.aurumdrakueli, 10, 10);
    MobBuilder bat = new MobBuilder("Bat", R.drawable.bat, 10, 10);
    MobBuilder daemarbora = new MobBuilder("Bat", R.drawable.daemarbora, 10, 10);
    MobBuilder deceleon = new MobBuilder("Bat", R.drawable.deceleon, 10, 10);
    MobBuilder demonic_essence = new MobBuilder("Bat", R.drawable.demonic_essence, 10, 10);
    MobBuilder dune_crawler = new MobBuilder("Bat", R.drawable.dune_crawler, 10, 10);
    MobBuilder green_slime = new MobBuilder("Bat", R.drawable.green_slime, 10, 10);
    MobBuilder nagaruda = new MobBuilder("Bat", R.drawable.nagaruda, 10, 10);
    MobBuilder rat = new MobBuilder("Bat", R.drawable.rat, 10, 10);
    MobBuilder scorpion = new MobBuilder("Bat", R.drawable.scorpion, 10, 10);
    MobBuilder skeleton = new MobBuilder("Bat", R.drawable.skeleton, 10, 10);
    MobBuilder snake = new MobBuilder("Bat", R.drawable.snake, 10, 10);
    MobBuilder spider = new MobBuilder("Bat", R.drawable.spider, 10, 10);
    MobBuilder stygian_lizard = new MobBuilder("Bat", R.drawable.stygian_lizard, 10, 10);

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
        tv_gold = (TextView) findViewById(R.id.tv_gold);
        b_click = (Button) findViewById(R.id.b_click);
        imageButton = (ImageButton) findViewById(R.id.imageButton);
        imageButton.setOnClickListener(imgButtonHandler);


        //set gold to 0
        tv_gold.setText("Gold: " + gold);


        // Start at zone 1 of world 1

        tv_zone.setText("Zone " + zoneM + '-' + zoneB);
        b_click.setEnabled(false);

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
            int randomIndex = r.nextInt(mobArray.length);
            imageButton.setImageResource(mobArray[randomIndex].getImageloc());
        }
    };
}
