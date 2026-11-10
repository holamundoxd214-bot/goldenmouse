package androidx.recyclerview.widget;

import java.util.List;

public abstract class ListAdapter extends Adapter {
    class androidx.recyclerview.widget.ListAdapter$1 implements ListListener {
        androidx.recyclerview.widget.ListAdapter$1(ListAdapter arg1) {
            ListAdapter.this = arg1;
            super();
        }

        public void onCurrentListChanged(List arg1, List arg2) {
            ListAdapter.this.onCurrentListChanged(arg1, arg2);
        }
    }

    final AsyncListDiffer mDiffer;
    private final ListListener mListener;

    protected ListAdapter(AsyncDifferConfig arg4) {
        super();
        androidx.recyclerview.widget.ListAdapter$1 v0 = new androidx.recyclerview.widget.ListAdapter$1(this);
        this.mListener = ((ListListener)v0);
        AsyncListDiffer v1 = new AsyncListDiffer(new AdapterListUpdateCallback(((Adapter)this)), arg4);
        this.mDiffer = v1;
        v1.addListListener(((ListListener)v0));
    }

    protected ListAdapter(ItemCallback arg5) {
        super();
        androidx.recyclerview.widget.ListAdapter$1 v0 = new androidx.recyclerview.widget.ListAdapter$1(this);
        this.mListener = ((ListListener)v0);
        AsyncListDiffer v1 = new AsyncListDiffer(new AdapterListUpdateCallback(((Adapter)this)), new Builder(arg5).build());
        this.mDiffer = v1;
        v1.addListListener(((ListListener)v0));
    }

    public List getCurrentList() {
        return this.mDiffer.getCurrentList();
    }

    protected Object getItem(int arg1) {
        return this.mDiffer.getCurrentList().get(arg1);
    }

    public int getItemCount() {
        return this.mDiffer.getCurrentList().size();
    }

    public void onCurrentListChanged(List arg1, List arg2) {
    }

    public void submitList(List arg1) {
        this.mDiffer.submitList(arg1);
    }

    public void submitList(List arg1, Runnable arg2) {
        this.mDiffer.submitList(arg1, arg2);
    }
}

