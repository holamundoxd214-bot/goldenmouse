package androidx.viewpager2.adapter;

import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;

public final class FragmentViewHolder extends ViewHolder {
    private FragmentViewHolder(FrameLayout arg1) {
        super(((View)arg1));
    }

    static FragmentViewHolder create(ViewGroup arg2) {
        FrameLayout v0 = new FrameLayout(arg2.getContext());
        v0.setLayoutParams(new ViewGroup$LayoutParams(-1, -1));
        v0.setId(ViewCompat.generateViewId());
        v0.setSaveEnabled(false);
        return new FragmentViewHolder(v0);
    }

    FrameLayout getContainer() {
        return this.itemView;
    }
}

