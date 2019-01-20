package com.wakecap.activity;

import android.app.ProgressDialog;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.wakecap.R;


/**
 * Created by Bhavik Bansal on 17/12/15.
 */
public class BaseActivity extends AppCompatActivity {
    private static final String TAG = BaseActivity.class.getCanonicalName();
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void onStart() {
        super.onStart();
    }

    protected void setToolbar(String title, boolean showBack) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView txtTitle = (TextView) findViewById(R.id.txt_title);
        txtTitle.setTypeface(Typeface.createFromAsset(getAssets()
                , getString(R.string.font_path)), Typeface.BOLD);

        txtTitle.setText(title);

        getSupportActionBar().setTitle(title);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(showBack);
        getSupportActionBar().setHomeButtonEnabled(false);

        if (showBack) {
            txtTitle.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_back, 0
                    , 0, 0);
            txtTitle.setCompoundDrawablePadding(16);
            txtTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
           /* toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onBackPressed();
                }
            });*/
        }
    }


    protected Toolbar getToolbar() {
        return (Toolbar) findViewById(R.id.toolbar);
    }

    public final void showToast(String msg) {
        Toast.makeText(BaseActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

    protected final void showInternetMsg() {
        showToast("Please check your internet connection.");
    }

    public void showProgressDialog() {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setCancelable(false);
            progressDialog.setMessage("Loading...");
        }
        progressDialog.show();
    }


    public void showApiErrorMsg(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    protected void showNoInternetMsg() {
        showApiErrorMsg("No Internet is available. Please check your connection.");
    }

    public void toggleProgressbar(int visibility) {
        try {
            View view = findViewById(R.id.progress);
            if (visibility == 1) {
                view.setVisibility(View.VISIBLE);
            } else {
                view.setVisibility(View.GONE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dismissProgressDialog() {
        if (progressDialog != null && progressDialog.isShowing())
            progressDialog.dismiss();
    }


}
