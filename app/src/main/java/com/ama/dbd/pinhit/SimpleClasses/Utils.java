package com.ama.dbd.pinhit.SimpleClasses;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ama.dbd.pinhit.R;
import com.flaviofaria.kenburnsview.KenBurnsView;
import com.google.android.gms.common.internal.GetServiceRequest;


/**
 * Created by GIGAMOLE on 8/18/16.
 */
public class Utils {

    static boolean animated = false;

    public static void setupItem(final View view, final LibraryObject libraryObject) {

        final TextView txt = (TextView) view.findViewById(R.id.card_list_primary);
        txt.setText(libraryObject.getTitle());

        TextView txt_location = (TextView) view.findViewById(R.id.card_list_secondary);
        txt_location.setText(libraryObject.getmLocation());

        final KenBurnsView backgroundThree = (KenBurnsView) view.findViewById(R.id.image);
        backgroundThree.setImageResource(libraryObject.mRes);
        backgroundThree.resume();
//
//      final ImageView animate_background = (ImageView) view.findViewById(R.id.animate_background);
//      animate_background.setOnClickListener(new View.OnClickListener() {
//          @Override
//          public void onClick(View view) {
//
//              if (!animated){
//                  backgroundThree.resume();
//                  animated = true;
//              } else {
//                  backgroundThree.pause();
//                  animated = false;
//              }
//          }
//      });


    }

    public static class LibraryObject {

        private String mTitle;
        private int mRes;
        private String mLocation;

        public LibraryObject(final int res, final String title, final String location) {
            mRes = res;
            mTitle = title;
            mLocation = location;
        }

        public LibraryObject(int mRes, String mTitle) {
            this.mTitle = mTitle;
            this.mRes = mRes;

            mLocation = "";
        }

        public String getTitle() {
            return mTitle;
        }

        public void setTitle(final String title) {
            mTitle = title;
        }

        public int getRes() {
            return mRes;
        }

        public void setRes(final int res) {
            mRes = res;
        }

        public String getmLocation() { return mLocation; }

        public void setmLocation(String mLocation) { this.mLocation = mLocation; }
    }
}