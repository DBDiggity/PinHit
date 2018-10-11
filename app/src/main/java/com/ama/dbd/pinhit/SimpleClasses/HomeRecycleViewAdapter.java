package com.ama.dbd.pinhit.SimpleClasses;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ama.dbd.pinhit.R;

import java.util.List;

public class HomeRecycleViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    private List<HomeOptions> optionsList;
    private Context context;

    public HomeRecycleViewAdapter(Context context, List<HomeOptions> optionsList){
        this.optionsList = optionsList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_home, null);
        RecyclerViewHolder rcv = new RecyclerViewHolder(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.menuIcon.setImageResource(optionsList.get(position).getPhoto());
    }

    @Override
    public int getItemCount() {
        return this.optionsList.size();
    }
}
