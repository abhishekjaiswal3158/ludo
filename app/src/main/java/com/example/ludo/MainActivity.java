package com.example.ludo;

import android.graphics.drawable.Drawable;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    ImageView  red_dice;
    ImageView  green_dice;
    ImageView  blue_dice;
    ImageView  yellow_dice;

    //reference to dice picture
    Random rng=new Random();
    int randomvalue;        //generate random numbers
    SoundPool dice_sound;       //For dice sound playing
    int sound_id;               //Used to control sound stream return by SoundPool
    Handler handler;            //Post message to start roll
    Timer timer=new Timer();    //Used to implement feedback to user
    boolean rolling=false;      //Is die rolling?


    TextView yt1;
    TextView yt2;
    TextView yt3;
    TextView yt4;
    TextView bt1;
    TextView bt2;
    TextView bt3;
    TextView bt4;
    TextView rt1;
    TextView rt2;
    TextView rt3;
    TextView rt4;
    TextView gt1;
    TextView gt2;
    TextView gt3;
    TextView gt4;

    TextView rstart;
    TextView gstart;
    TextView bstart;
    TextView ystart;

    ImageView yb1;
    ImageView yb2;
    ImageView yb3;
    ImageView yb4;
    ImageView gb1;
    ImageView gb2;
    ImageView gb3;
    ImageView gb4;
    ImageView bb1;
    ImageView bb2;
    ImageView bb3;
    ImageView bb4;
    ImageView rb1;
    ImageView rb2;
    ImageView rb3;
    ImageView rb4;


    ImageView rbstart;
    ImageView gbstart;
    ImageView bbstart;
    ImageView ybstart;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rt1=(TextView)findViewById(R.id.rt1);
        rt2=(TextView)findViewById(R.id.rt2);
        rt3=(TextView)findViewById(R.id.rt3);
        rt4=(TextView)findViewById(R.id.rt4);
        bt1=(TextView)findViewById(R.id.bt1);
        bt2=(TextView)findViewById(R.id.bt2);
        bt3=(TextView)findViewById(R.id.bt3);
        bt4=(TextView)findViewById(R.id.bt4);
        gt1=(TextView)findViewById(R.id.gt1);
        gt2=(TextView)findViewById(R.id.gt2);
        gt3=(TextView)findViewById(R.id.gt3);
        gt4=(TextView)findViewById(R.id.gt4);
        yt1=(TextView)findViewById(R.id.yt1);
        yt2=(TextView)findViewById(R.id.yt2);
        yt3=(TextView)findViewById(R.id.yt3);
        yt4=(TextView)findViewById(R.id.yt4);


        rstart=(TextView)findViewById(R.id.rstart);
        gstart=(TextView)findViewById(R.id.gstart);
        bstart=(TextView)findViewById(R.id.bstart);
        ystart=(TextView)findViewById(R.id.ystart);


        rb1=(ImageView)findViewById(R.id.rb1);
        rb2=(ImageView)findViewById(R.id.rb2);
        rb3=(ImageView)findViewById(R.id.rb3);
        rb4=(ImageView)findViewById(R.id.rb4);
        bb1=(ImageView)findViewById(R.id.bb1);
        bb2=(ImageView)findViewById(R.id.bb2);
        bb3=(ImageView)findViewById(R.id.bb3);
        bb4=(ImageView)findViewById(R.id.bb4);
        gb1=(ImageView)findViewById(R.id.gb1);
        gb2=(ImageView)findViewById(R.id.gb2);
        gb3=(ImageView)findViewById(R.id.gb3);
        gb4=(ImageView)findViewById(R.id.gb4);
        yb1=(ImageView)findViewById(R.id.yb1);
        yb2=(ImageView)findViewById(R.id.yb2);
        yb3=(ImageView)findViewById(R.id.yb3);
        yb4=(ImageView)findViewById(R.id.yb4);


        rbstart=(ImageView)findViewById(R.id.rbstart);
        bbstart=(ImageView)findViewById(R.id.bbstart);
        gbstart=(ImageView)findViewById(R.id.gbstart);
        ybstart=(ImageView)findViewById(R.id.ybstart);


        //Our function to initialise sound playing
        InitSound();
        //Get a reference to image widget
        red_dice = (ImageView) findViewById(R.id.red_dice);
        red_dice.setOnClickListener(new HandleClickr());

        green_dice = (ImageView) findViewById(R.id.green_dice);
        green_dice.setOnClickListener(new HandleClickg());
        //link handler to callback
        blue_dice = (ImageView) findViewById(R.id.blue_dice);
        blue_dice.setOnClickListener(new HandleClickb());

        yellow_dice= (ImageView) findViewById(R.id.yellow_dice);
        yellow_dice.setOnClickListener(new HandleClicky());


        rb1.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                if(randomvalue==6){
                rb1.setVisibility(View.GONE);
                rt1.setVisibility(View.VISIBLE);
                rstart.setVisibility(View.GONE);
                rbstart.setVisibility(View.VISIBLE);
                randomvalue=0;
                }
            }
        });
        rb2.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                if(randomvalue==6){
                    rb2.setVisibility(View.GONE);
                    rt2.setVisibility(View.VISIBLE);
                    rstart.setVisibility(View.GONE);
                    rbstart.setVisibility(View.VISIBLE);
                    randomvalue=0;
                }
            }
        });
        rb3.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                if(randomvalue==6){
                    rb3.setVisibility(View.GONE);
                    rt3.setVisibility(View.VISIBLE);
                    rstart.setVisibility(View.GONE);
                    rbstart.setVisibility(View.VISIBLE);
                    randomvalue=0;
                    }
            }
        });
        rb4.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                if(randomvalue==6){
                    rb4.setVisibility(View.GONE);
                    rt4.setVisibility(View.VISIBLE);
                    rstart.setVisibility(View.GONE);
                    rbstart.setVisibility(View.VISIBLE);
                    randomvalue=0;
                    }
            }
        });
        gb1.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                if(randomvalue==6){
                    gb1.setVisibility(View.GONE);
                    gt1.setVisibility(View.VISIBLE);
                    gstart.setVisibility(View.GONE);
                    gbstart.setVisibility(View.VISIBLE);
                    randomvalue=0;
                }
            }
        });
        gb2.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                if(randomvalue==6){
                    gb2.setVisibility(View.GONE);
                    gt2.setVisibility(View.VISIBLE);
                    gstart.setVisibility(View.GONE);
                    gbstart.setVisibility(View.VISIBLE);
                    randomvalue=0;
                }
            }
        });
        gb3.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                if(randomvalue==6){
                    gb3.setVisibility(View.GONE);
                    gt3.setVisibility(View.VISIBLE);
                    gstart.setVisibility(View.GONE);
                    gbstart.setVisibility(View.VISIBLE);
                    randomvalue=0;
                }
            }
        });
        gb4.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                if(randomvalue==6){
                    gb4.setVisibility(View.GONE);
                    gt4.setVisibility(View.VISIBLE);
                    gstart.setVisibility(View.GONE);
                    gbstart.setVisibility(View.VISIBLE);
                    randomvalue=0;
                }
            }
        });
        bb1.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                if(randomvalue==6){
                    bb1.setVisibility(View.GONE);
                    bt1.setVisibility(View.VISIBLE);
                    bstart.setVisibility(View.GONE);
                    bbstart.setVisibility(View.VISIBLE);
                    randomvalue=0;
                }
            }
        });

        bb2.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                if(randomvalue==6){
                    bb2.setVisibility(View.GONE);
                    bt2.setVisibility(View.VISIBLE);
                    bstart.setVisibility(View.GONE);
                    bbstart.setVisibility(View.VISIBLE);
                    randomvalue=0;
                }
            }
        });
        bb3.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                if(randomvalue==6){
                    bb3.setVisibility(View.GONE);
                    bt3.setVisibility(View.VISIBLE);
                    bstart.setVisibility(View.GONE);
                    bbstart.setVisibility(View.VISIBLE);
                    randomvalue=0;
                }
            }
        });
        bb4.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                if(randomvalue==6){
                    bb4.setVisibility(View.GONE);
                    bt4.setVisibility(View.VISIBLE);
                    bstart.setVisibility(View.GONE);
                    bbstart.setVisibility(View.VISIBLE);
                    randomvalue=0;
                }
            }
        });

        yb1.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                if(randomvalue==6){
                    yb1.setVisibility(View.GONE);
                    yt1.setVisibility(View.VISIBLE);
                    ystart.setVisibility(View.GONE);
                    ybstart.setVisibility(View.VISIBLE);
                    randomvalue=0;
                }
            }
        });
        yb2.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                if(randomvalue==6){
                    yb2.setVisibility(View.GONE);
                    yt2.setVisibility(View.VISIBLE);
                    ystart.setVisibility(View.GONE);
                    ybstart.setVisibility(View.VISIBLE);
                    randomvalue=0;
                }
            }
        });
        yb3.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                if(randomvalue==6){
                    yb3.setVisibility(View.GONE);
                    yt3.setVisibility(View.VISIBLE);
                    ystart.setVisibility(View.GONE);
                    ybstart.setVisibility(View.VISIBLE);
                    randomvalue=0;
                }
            }
        });
        yb4.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                if(randomvalue==6){
                    yb4.setVisibility(View.GONE);
                    yt4.setVisibility(View.VISIBLE);
                    ystart.setVisibility(View.GONE);
                    ybstart.setVisibility(View.VISIBLE);
                    randomvalue=0;
                }
            }
        });

    }




    //User pressed dice, lets start
    private class HandleClickr implements View.OnClickListener {

        public void onClick(View arg0) {

            if (!rolling) {
                rolling = true;
                //Show rolling image
                green_dice.setImageResource(R.drawable.dice3d160);
                blue_dice.setImageResource(R.drawable.dice3d160);
                yellow_dice.setImageResource(R.drawable.dice3d160);
                red_dice.setImageResource(R.drawable.dice3d160);
                //Start rolling sound
                dice_sound.play(sound_id, 1.0f, 1.0f, 0, 0, 1.0f);
                //Pause to allow image to update
                timer.schedule(new Roll(), 400);
            }
            handler=new Handler(callbackr);
        }
    }
    private class HandleClickg implements View.OnClickListener {
        public void onClick(View arg0) {
            if (!rolling) {
                rolling = true;
                //Show rolling image
                green_dice.setImageResource(R.drawable.dice3d160);
                blue_dice.setImageResource(R.drawable.dice3d160);
                yellow_dice.setImageResource(R.drawable.dice3d160);
                red_dice.setImageResource(R.drawable.dice3d160);
                //Start rolling sound
                dice_sound.play(sound_id, 1.0f, 1.0f, 0, 0, 1.0f);
                //Pause to allow image to update
                timer.schedule(new Roll(), 400);
            }
            handler=new Handler(callbackg);
        }
    }

    private class HandleClickb implements View.OnClickListener {
        public void onClick(View arg0) {
            if (!rolling) {
                rolling = true;
                green_dice.setImageResource(R.drawable.dice3d160);
                blue_dice.setImageResource(R.drawable.dice3d160);
                yellow_dice.setImageResource(R.drawable.dice3d160);
                red_dice.setImageResource(R.drawable.dice3d160);
                dice_sound.play(sound_id, 1.0f, 1.0f, 0, 0, 1.0f);
                //Pause to allow image to update
                timer.schedule(new Roll(), 400);
            }
            handler=new Handler(callbackb);
        }
    }
    private class HandleClicky implements View.OnClickListener {
        public void onClick(View arg0) {
            if (!rolling) {
                rolling = true;
                //Show rolling image
                green_dice.setImageResource(R.drawable.dice3d160);
                blue_dice.setImageResource(R.drawable.dice3d160);
                yellow_dice.setImageResource(R.drawable.dice3d160);
                red_dice.setImageResource(R.drawable.dice3d160);
                //Start rolling sound
                dice_sound.play(sound_id, 1.0f, 1.0f, 0, 0, 1.0f);
                //Pause to allow image to update
                timer.schedule(new Roll(), 400);
            }
            handler=new Handler(callbacky);
        }
    }

    //New code to initialise sound playback
    void InitSound() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //Use the newer SoundPool.Builder
            //Set the audio attributes, SONIFICATION is for interaction events
            //uses builder pattern
            AudioAttributes aa = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();

            //default max streams is 1
            //also uses builder pattern
            dice_sound= new SoundPool.Builder().setAudioAttributes(aa).build();

        } else {
            //Running on device earlier than Lollipop
            //Use the older SoundPool constructor
            dice_sound=PreLollipopSoundPool.NewSoundPool();
        }
        //Load the dice sound
        sound_id=dice_sound.load(this,R.raw.shake_dice,1);
    }

    //When pause completed message sent to callback
    class Roll extends TimerTask {
        public void run() {
            handler.sendEmptyMessage(0);
        }
    }

    //Receives message from timer to start dice roll
    Handler.Callback callbackr = new Handler.Callback() {
        public boolean handleMessage(Message msg) {
            //Get roll result
            //Remember nextInt returns 0 to 5 for argument of 6
            //hence + 1
            randomvalue=rng.nextInt(6)+1;
            switch(randomvalue) {
                case 1:
                    red_dice.setImageResource(R.drawable.one);
                    break;
                case 2:
                    red_dice.setImageResource(R.drawable.two);
                    break;
                case 3:
                    red_dice.setImageResource(R.drawable.three);
                    break;
                case 4:
                    red_dice.setImageResource(R.drawable.four);
                    break;
                case 5:
                    red_dice.setImageResource(R.drawable.five);
                    break;
                case 6:
                    red_dice.setImageResource(R.drawable.six);
                    break;
                default:
            }
            rolling=false;  //user can press again
            return true;
        }
    };
    Handler.Callback callbackg = new Handler.Callback() {
        public boolean handleMessage(Message msg) {
            //Get roll result
            //Remember nextInt returns 0 to 5 for argument of 6
            //hence + 1
            randomvalue=rng.nextInt(6)+1;
            switch(randomvalue) {
                case 1:
                    green_dice.setImageResource(R.drawable.one);
                    break;
                case 2:
                    green_dice.setImageResource(R.drawable.two);
                    break;
                case 3:
                    green_dice.setImageResource(R.drawable.three);
                    break;
                case 4:
                    green_dice.setImageResource(R.drawable.four);
                    break;
                case 5:
                    green_dice.setImageResource(R.drawable.five);
                    break;
                case 6:
                    green_dice.setImageResource(R.drawable.six);
                    break;
                default:
            }
            rolling=false;  //user can press again
            return true;
        }
    };


    Handler.Callback callbackb = new Handler.Callback() {
        public boolean handleMessage(Message msg) {
            //Get roll result
            //Remember nextInt returns 0 to 5 for argument of 6
            //hence + 1
            randomvalue=rng.nextInt(6)+1;
            switch(randomvalue) {
                case 1:
                    blue_dice.setImageResource(R.drawable.one);
                    break;
                case 2:
                    blue_dice.setImageResource(R.drawable.two);
                    break;
                case 3:
                    blue_dice.setImageResource(R.drawable.three);
                    break;
                case 4:
                    blue_dice.setImageResource(R.drawable.four);
                    break;
                case 5:
                    blue_dice.setImageResource(R.drawable.five);
                    break;
                case 6:
                    blue_dice.setImageResource(R.drawable.six);
                    break;
                default:
            }
            rolling=false;  //user can press again
            return true;
        }
    };


    Handler.Callback callbacky = new Handler.Callback() {
        public boolean handleMessage(Message msg) {
            //Get roll result
            //Remember nextInt returns 0 to 5 for argument of 6
            //hence + 1
            randomvalue=rng.nextInt(6)+1;
            switch(randomvalue) {
                case 1:
                    yellow_dice.setImageResource(R.drawable.one);
                    break;
                case 2:
                    yellow_dice.setImageResource(R.drawable.two);
                    break;
                case 3:
                    yellow_dice.setImageResource(R.drawable.three);
                    break;
                case 4:
                    yellow_dice.setImageResource(R.drawable.four);
                    break;
                case 5:
                    yellow_dice.setImageResource(R.drawable.five);
                    break;
                case 6:
                    yellow_dice.setImageResource(R.drawable.six);
                    break;
                default:
            }
            rolling=false;  //user can press again
            return true;
        }
    };
    //Clean up
    protected void onPause() {
        super.onPause();
        dice_sound.pause(sound_id);
    }
    protected void onDestroy() {
        super.onDestroy();
        timer.cancel();
    }
}