package com.junbaole.kindergartern.presentation.home;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by liangrenwang on 16/6/21.
 */
public class RecorderAdapter extends RecyclerView.Adapter<RecorderAdapter.RecorderViewHolder> {


    @Override
    public RecorderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecorderViewHolder holder, int position) {

    }


    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class RecorderViewHolder extends RecyclerView.ViewHolder {
        public RecorderViewHolder(View itemView) {
            super(itemView);
        }
    }
}
