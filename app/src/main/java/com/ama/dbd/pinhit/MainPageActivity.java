package com.ama.dbd.pinhit;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import com.ama.dbd.pinhit.Fragments.ChallengeFragment;
import com.ama.dbd.pinhit.Fragments.FriendsFragment;
import com.ama.dbd.pinhit.Fragments.PinsListFragment;
import com.ama.dbd.pinhit.Fragments.QRFragment;
import com.ama.dbd.pinhit.Fragments.UserFragment;
import com.ama.dbd.pinhit.SimpleClasses.ViewPagerAdapter;


public class MainPageActivity extends AppCompatActivity{

    BottomNavigationView bottomNavigationView;
    MenuItem prevMenuItem;

    //This is our viewPager
    private ViewPager viewPager;

    //    Fragments
    ChallengeFragment challengeFragment;
    PinsListFragment pinsListFragment;
    QRFragment qrFragment;
    FriendsFragment friendsFragment;
    UserFragment userFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

//Initializing viewPager
        viewPager = (ViewPager) findViewById(R.id.viewpager);

        //Initializing the bottomNavigationView
        bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.frag_pinList:
                                viewPager.setCurrentItem(1);
                                break;
                            case R.id.frag_gallery:
                                viewPager.setCurrentItem(1);
                                break;
                            case R.id.frag_challenges:
                                viewPager.setCurrentItem(0);
                                break;
                            case R.id.frag_social:
                                viewPager.setCurrentItem(2);
                                break;
                            case R.id.frag_user:
                                viewPager.setCurrentItem(3);
                                break;

                        }
                        return false;
                    }
                });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                }
                else
                {
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }
                Log.d("page", "onPageSelected: "+position);
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
                prevMenuItem = bottomNavigationView.getMenu().getItem(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

       /*  //Disable ViewPager Swipe
       viewPager.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                return true;
            }
        });
        */

        setupViewPager(viewPager);

    }
    private void setupViewPager(ViewPager viewPager)
    {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        pinsListFragment = new PinsListFragment();
        qrFragment = new QRFragment();
        challengeFragment = new ChallengeFragment();
        friendsFragment = new FriendsFragment();
        userFragment = new UserFragment();

//
        adapter.addFragment(challengeFragment);
        adapter.addFragment(pinsListFragment);
        adapter.addFragment(friendsFragment);
        adapter.addFragment(userFragment);
        adapter.addFragment(qrFragment);
        viewPager.setAdapter(adapter);
    }
}
