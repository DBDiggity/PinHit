package com.ama.dbd.pinhit.SimpleClasses;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.ama.dbd.pinhit.MainPageActivity;
import com.ama.dbd.pinhit.R;

public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public ImageView menuIcon;

    public RecyclerViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        menuIcon = (ImageView) itemView.findViewById(R.id.animate_background);
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(view.getContext(), "Position clicked " + getPosition(), Toast.LENGTH_SHORT ).show();

        switch (getPosition()){
            case 0:
                Intent i = new Intent(view.getContext(), MainPageActivity.class);
                view.getContext().startActivity(i);
        }
    }
}