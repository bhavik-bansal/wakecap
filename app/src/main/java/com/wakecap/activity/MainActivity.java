package com.wakecap.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.wakecap.R;
import com.wakecap.adapter.HomeAdapter;
import com.wakecap.model.Item;
import com.wakecap.rest.HttpResultType;
import com.wakecap.stickyheaders.StickyRecyclerHeadersDecoration;
import com.wakecap.viewmodel.HomeViewModel;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends BaseActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private HomeViewModel viewModel;
    private RecyclerView recyclerView;
    private HomeAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setToolbar(getString(R.string.app_name), false);
        viewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        recyclerView = findViewById(R.id.recyclerView);
        init();
    }

    private void init() {
        toggleProgressbar(1);
        try {
            viewModel.getData().observe(this, response -> {
                toggleProgressbar(0);
                if (response.getResult() == HttpResultType.SUCCESS){
                    setData(response.getData().getItems());
                }else{
                    showApiErrorMsg(response.getMessage());
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void setData(ArrayList<Item> data){
        Collections.sort(data);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new HomeAdapter(this,data);
        recyclerView.addItemDecoration(new StickyRecyclerHeadersDecoration(mAdapter));
        recyclerView.setAdapter(mAdapter);
    }
}
