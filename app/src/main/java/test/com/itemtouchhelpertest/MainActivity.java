package test.com.itemtouchhelpertest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.ArrayList;
import java.util.List;

import Adapter.RecyclerListAdapter;
import helper.Data;
import helper.ItemTouchHelperCallback;

public class MainActivity extends AppCompatActivity {

    private List<Data> mDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        mDataList = new ArrayList<>();
        Data data;
        for(int i = 0; i < 50; i++){
            data = new Data();
            data.setName(String.valueOf(i * 1000));
            mDataList.add(data);
        }
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        RecyclerListAdapter adapter = new RecyclerListAdapter(this,mDataList);
        recyclerView.setAdapter(adapter);
        ItemTouchHelperCallback callback = new ItemTouchHelperCallback(adapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }
}
