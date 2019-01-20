package com.wakecap.stickyheaders;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

public interface HeaderAdapter<T extends RecyclerView.ViewHolder>{
    String getHeaderId(int position);
    T onCreateHeaderViewHolder(ViewGroup parent);
    void onBindHeaderViewHolder(T holder, int position);
    int getItemCount();
}
