package helper;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import Adapter.RecyclerListAdapter;

/**
 * Created by Fang Ruijiao on 2017/2/10.
 */
public class ItemTouchHelperCallback extends ItemTouchHelper.Callback {

    private RecyclerListAdapter mAdapter;

    public ItemTouchHelperCallback(RecyclerListAdapter adapter){
        mAdapter = adapter;
    }

    /**
     * 指定可以支持的拖放和滑动的方向,上下为拖动（drag）,左右为滑动（swipe）
     * @param recyclerView
     * @param viewHolder
     * @return
     */
    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        int swipeFlags = ItemTouchHelper.START | ItemTouchHelper.END;
        return makeMovementFlags(dragFlags, swipeFlags);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        mAdapter.onItemMove(viewHolder.getAdapterPosition(),target.getAdapterPosition());
        return true;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        mAdapter.onItemDismiss(viewHolder.getAdapterPosition());
    }

    /**
     * 上下为拖动（drag）
     * @return
     */
    @Override
    public boolean isLongPressDragEnabled() {
        return true;
    }

    /**
     * 左右为滑动（swipe）
     * 在view任意位置触摸事件发生时启用滑动操作，则直接在sItemViewSwipeEnabled()中返回true就可以了
     * 也可以主动调用ItemTouchHelper.startSwipe(RecyclerView.ViewHolder) 来开始滑动操作
     * @return
     */
    @Override
    public boolean isItemViewSwipeEnabled() {
        return true ;
    }


    public interface ItemTouchHelperAdapter {
        void onItemMove(int fromPosition, int toPosition);
        void onItemDismiss(int position);
    }
}
