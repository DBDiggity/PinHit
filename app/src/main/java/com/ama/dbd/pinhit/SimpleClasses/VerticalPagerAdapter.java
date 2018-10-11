package com.ama.dbd.pinhit.SimpleClasses;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ama.dbd.pinhit.R;

import static com.ama.dbd.pinhit.SimpleClasses.Utils.setupItem;

public class VerticalPagerAdapter extends PagerAdapter {

private final Utils.LibraryObject[] TWO_WAY_LIBRARIES = new Utils.LibraryObject[]{
        new Utils.LibraryObject(
                R.drawable.svg_fort,
                "Fort Charlotte"
        ),
        new Utils.LibraryObject(
                R.drawable.svg_fort,
                "Fort Charlotte"
        ),
        new Utils.LibraryObject(
                R.drawable.svg_fort,
                "Fort Charlotte"
        ),
        new Utils.LibraryObject(
                R.drawable.svg_fort,
                "Fort Charlotte"
        ),
        new Utils.LibraryObject(
                R.drawable.svg_fort,
                "Fort Charlotte"
        ),
        new Utils.LibraryObject(
                R.drawable.svg_fort,
                "Fort Charlotte"
        ),
        };

private LayoutInflater mLayoutInflater;

public VerticalPagerAdapter(final Context context) {
        mLayoutInflater = LayoutInflater.from(context);
        }


@Override
public int getCount() {
        return TWO_WAY_LIBRARIES.length;
        }

@Override
public int getItemPosition(final Object object) {
        return POSITION_NONE;
        }

@Override
public Object instantiateItem(final ViewGroup container, final int position) {
final View view = mLayoutInflater.inflate(R.layout.item, container, false);

        setupItem(view, TWO_WAY_LIBRARIES[position]);

        container.addView(view);
        return view;
        }

@Override
public boolean isViewFromObject(final View view, final Object object) {
        return view.equals(object);
        }

@Override
public void destroyItem(final ViewGroup container, final int position, final Object object) {
        container.removeView((View) object);
        }
        }
