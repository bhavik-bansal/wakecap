package com.booko.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Toast;

import com.booko.R;

/**
 * Created by aalapshah on 18/12/15.
 */
public abstract class BaseFragment extends Fragment {

    protected abstract void initView(View view);

    public void startActivity(Class className) {
        startActivity(new Intent(getActivity(), className));
    }

    public void startActivity(Intent intent) {
        getActivity().startActivity(intent);
    }

    public void showApiErrorMsg(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }

    protected void showNoInternetMsg() {
        showApiErrorMsg("No Internet is available. Please check your connection.");
    }

    public final void showToast(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    public void toggleProgressbar(int visibility) {
        try {
            View view = getView().findViewById(R.id.progress);
            if (visibility == 1) {
                view.setVisibility(View.VISIBLE);
            } else {
                view.setVisibility(View.GONE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }
}
