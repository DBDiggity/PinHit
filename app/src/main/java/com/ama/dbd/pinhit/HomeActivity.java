package com.ama.dbd.pinhit;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ama.dbd.pinhit.SimpleClasses.HomeOptions;
import com.ama.dbd.pinhit.SimpleClasses.HomeRecycleViewAdapter;
import com.ama.dbd.pinhit.SimpleClasses.RecyclerViewHolder;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{

    private ConstraintLayout constraintLayout;
    private AnimationDrawable animationDrawable;
    private List<HomeOptions> optionsList;
    private LinearLayoutManager lLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        optionsList = getHomeOptionsList();
        lLayout = new LinearLayoutManager(HomeActivity.this);

        RecyclerView rView = (RecyclerView) findViewById(R.id.recycler_view);
        rView.setLayoutManager(lLayout);

        HomeRecycleViewAdapter rAdapter = new HomeRecycleViewAdapter(HomeActivity.this, optionsList);
        rView.setAdapter(rAdapter);
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

    public List<HomeOptions> getHomeOptionsList() {

        List<HomeOptions> homeOptions = new ArrayList<HomeOptions>();
        homeOptions.add(new HomeOptions("Pins", R.drawable.pin_icon));
        homeOptions.add(new HomeOptions("Gallery", R.drawable.gallery_icon));
        homeOptions.add(new HomeOptions("Challenges", R.drawable.challenge_icon));
        homeOptions.add(new HomeOptions("Social", R.drawable.social_icon));
        homeOptions.add(new HomeOptions("User", R.drawable.user_icon));

        return homeOptions;
    }

    private void backgroundChange(){
        constraintLayout = (ConstraintLayout) findViewById(R.id.constraintLayout);

        // initializing animation drawable by getting background from constraint layout
        animationDrawable = (AnimationDrawable) constraintLayout.getBackground();

        // setting enter fade animation duration to 5 seconds
        animationDrawable.setEnterFadeDuration(5000);

        // setting exit fade animation duration to 2 seconds
        animationDrawable.setExitFadeDuration(2000);

    }

    @Override
    public void onClick(View view) {
    }
}
