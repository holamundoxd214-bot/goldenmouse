package androidx.recyclerview.widget;

public abstract class SortedListAdapterCallback extends Callback {
    final Adapter mAdapter;

    public SortedListAdapterCallback(Adapter arg1) {
        super();
        this.mAdapter = arg1;
    }

    public void onChanged(int arg1, int arg2) {
        this.mAdapter.notifyItemRangeChanged(arg1, arg2);
    }

    public void onChanged(int arg1, int arg2, Object arg3) {
        this.mAdapter.notifyItemRangeChanged(arg1, arg2, arg3);
    }

    public void onInserted(int arg1, int arg2) {
        this.mAdapter.notifyItemRangeInserted(arg1, arg2);
    }

    public void onMoved(int arg1, int arg2) {
        this.mAdapter.notifyItemMoved(arg1, arg2);
    }

    public void onRemoved(int arg1, int arg2) {
        this.mAdapter.notifyItemRangeRemoved(arg1, arg2);
    }
}

