package com.example.android.musiccloudplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import static android.R.attr.y;

public class PlayList extends AppCompatActivity implements View.OnClickListener{
    private ImageButton imageButtonMenu, imageButtonOnRingtone, imageButtonShare, imageButtonClouds;
    private ImageButton imageButtonPlayer, imageButtonPlayList, imageButtonEqualizer, imageButtonRescan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_list);

        setUpBtnAndTxt();
        animationOfButtonsWhenActivityStart(Techniques.Shake);
    }

    //onClick selector for buttons actions
    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.imageButtonMenu:
                toastMaker(getString(R.string.popup_menu));
                animationOfButtonsWhenActivityStart(Techniques.Shake);
                break;
            case R.id.imageButtonOnRingtone:
                toastMaker(getString(R.string.ring_tone_selected));
                animationOfButtonsWhenActivityStart(Techniques.Shake);
                break;
            case R.id.imageButtonShare:
                toastMaker(getString(R.string.shared_song));
                animationOfButtonsWhenActivityStart(Techniques.Shake);
                break;
            case R.id.imageButtonClouds:
                Intent intent = new Intent(PlayList.this, CloudSelector.class);

                startActivity(intent);
                break;
            case R.id.imageButtonPlayer:
                Intent intent1 = new Intent(PlayList.this, MainActivity.class);

                startActivity(intent1);
                break;
            case R.id.imageButtonPlayList:
                Intent intent2 = new Intent(PlayList.this, PlayList.class);

                startActivity(intent2);
                break;
            case R.id.imageButtonEqualizer:

                Intent intent3 = new Intent(PlayList.this, Equalizer.class);

                startActivity(intent3);
                break;
            case R.id.imageButtonRescan:
                animationOfButtonsWhenActivityStart(Techniques.Shake);
                toastMaker(getString(R.string.rescan_folders));
                break;

        }
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(PlayList.this, MainActivity.class);
        startActivity(intent);
    }
    // setup buttons
    private void setUpBtnAndTxt() {
        imageButtonMenu = (ImageButton) findViewById(R.id.imageButtonMenu);
        imageButtonOnRingtone = (ImageButton) findViewById(R.id.imageButtonOnRingtone);
        imageButtonShare = (ImageButton) findViewById(R.id.imageButtonShare);
        imageButtonClouds = (ImageButton) findViewById(R.id.imageButtonClouds);
        imageButtonPlayer = (ImageButton) findViewById(R.id.imageButtonPlayer);
        imageButtonPlayList = (ImageButton) findViewById(R.id.imageButtonPlayList);
        imageButtonEqualizer = (ImageButton) findViewById(R.id.imageButtonEqualizer);
        imageButtonRescan = (ImageButton) findViewById(R.id.imageButtonRescan);

        imageButtonMenu.setOnClickListener(this);
        imageButtonOnRingtone.setOnClickListener(this);
        imageButtonShare.setOnClickListener(this);
        imageButtonClouds.setOnClickListener(this);
        imageButtonPlayer.setOnClickListener(this);
        imageButtonPlayList.setOnClickListener(this);
        imageButtonEqualizer.setOnClickListener(this);
        imageButtonRescan.setOnClickListener(this);
    }


    //toast maker
    public void toastMaker(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }



    //                          animations
    //View animation library - https://github.com/daimajia/AndroidViewAnimations
    public void btnAnimations(View view, Techniques techniques, int duration) {
        //without params
        YoYo.with(techniques).duration(duration).playOn(view);
        //with params
        //        YoYo.with(Techniques.FadeInUp)
        //
        //                .repeat(1)
        //                .playOn(view);
        //
    }
    protected void animationOfButtonsWhenActivityStart(Techniques techniques){
        btnAnimations(imageButtonMenu,techniques,400);
        btnAnimations(imageButtonOnRingtone,techniques,500);
        btnAnimations(imageButtonShare,techniques,600);
        btnAnimations(imageButtonClouds,techniques,700);
        btnAnimations(imageButtonPlayer,techniques,800);
        btnAnimations(imageButtonPlayList,techniques,900);
        btnAnimations(imageButtonEqualizer,techniques,1000);
        btnAnimations(imageButtonRescan,techniques,1100);
    }
    protected void animationOfButtonsWhenActivityClosed(Techniques techniques,Techniques techniques1){
        btnAnimations(imageButtonMenu,techniques,400);
        btnAnimations(imageButtonOnRingtone,techniques,500);
        btnAnimations(imageButtonShare,techniques,600);
        btnAnimations(imageButtonClouds,techniques,700);
        btnAnimations(imageButtonPlayer,techniques1,800);
        btnAnimations(imageButtonPlayList,techniques1,900);
        btnAnimations(imageButtonEqualizer,techniques1,1000);
        btnAnimations(imageButtonRescan,techniques1,1100);
    }
//**************************************************************************************************

}

