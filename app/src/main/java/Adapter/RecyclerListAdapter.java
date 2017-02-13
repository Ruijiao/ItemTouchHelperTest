package Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import helper.Data;
import helper.ItemTouchHelperCallback;
import test.com.itemtouchhelpertest.R;

/**
 * Created by Fang Ruijiao on 2017/2/10.
 */
public class RecyclerListAdapter extends RecyclerView.Adapter <RecyclerListAdapter.ItemViewHolder> implements ItemTouchHelperCallback.ItemTouchHelperAdapter{

    private Context mCon;
    private List<Data> mDataList;

    public RecyclerListAdapter(Context con,List<Data> dataList){
        mCon = con;
        mDataList = dataList;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemViewHolder(View.inflate(mCon, R.layout.a_item,null));
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.textView.setText(mDataList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        Collections.swap(mDataList, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
    }

    @Override
    public void onItemDismiss(int position) {
        mDataList.remove(position);
        notifyItemRemoved(position);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{

        public TextView textView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView);
        }
    }
}
