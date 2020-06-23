package com.example.ludo;

import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
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
    Random rng=new Random();    //generate random numbers
    SoundPool dice_sound;       //For dice sound playing
    int sound_id;               //Used to control sound stream return by SoundPool
    Handler handler;            //Post message to start roll
    Timer timer=new Timer();    //Used to implement feedback to user
    boolean rolling=false;      //Is die rolling?

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
            switch(rng.nextInt(6)+1) {
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
            switch(rng.nextInt(6)+1) {
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
            switch(rng.nextInt(6)+1) {
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
            switch(rng.nextInt(6)+1) {
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