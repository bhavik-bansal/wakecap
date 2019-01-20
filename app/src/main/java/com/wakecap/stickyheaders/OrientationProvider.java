package com.wakecap.stickyheaders;

import android.support.v7.widget.RecyclerView;

public interface OrientationProvider {

    public int getOrientation(RecyclerView recyclerView);

    public boolean isReverseLayout(RecyclerView recyclerView);
}
