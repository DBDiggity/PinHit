package com.ama.dbd.pinhit;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableWrapper;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ConstraintLayout constraintLayout;
    private AnimationDrawable animationDrawable;
    private int frameNumber;

//    @BindView(R.id.btn_login) Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ButterKnife.bind(this);

        // init constraintLayout
        constraintLayout = (ConstraintLayout) findViewById(R.id.constraintLayout);

        // initializing animation drawable by getting background from constraint layout
        animationDrawable = (AnimationDrawable) constraintLayout.getBackground();

        // setting enter fade animation duration to 5 seconds
        animationDrawable.setEnterFadeDuration(5000);

        // setting exit fade animation duration to 2 seconds
        animationDrawable.setExitFadeDuration(2000);

        Button btnLogin = (Button) findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (animationDrawable != null && !animationDrawable.isRunning()) {
            // start the animation
            animationDrawable.start();
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        if (animationDrawable != null && animationDrawable.isRunning()) {

            // stop the animation
            animationDrawable.stop();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_login:
                Intent goToHome = new Intent(view.getContext(), MainPageActivity.class);
//                Drawable currentFrame, checkFrame;
//                currentFrame = animationDrawable.getCurrent();
//
//                // Checks the position of the frame
//                for (int i = 0; i < animationDrawable.getNumberOfFrames(); i++) {
//                    checkFrame = animationDrawable.getFrame(i);
//                    if (checkFrame == currentFrame) {
//                        frameNumber = i;
//                        break;
//                    }
//                }
//                Log.d("CURRENT_BACKGROUND", "" + frameNumber);
                startActivity(goToHome);
                break;
            default:
                Toast.makeText(getApplicationContext(), "Not Implemented View", Toast.LENGTH_LONG).show();
                break;
        }
    }

}
