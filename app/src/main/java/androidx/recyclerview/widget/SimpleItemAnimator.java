package androidx.recyclerview.widget;

import android.view.View;

public abstract class SimpleItemAnimator extends ItemAnimator {
    private static final boolean DEBUG = false;
    private static final String TAG = "SimpleItemAnimator";
    boolean mSupportsChangeAnimations;

    public SimpleItemAnimator() {
        super();
        this.mSupportsChangeAnimations = true;
    }

    public abstract boolean animateAdd(ViewHolder arg1);

    public boolean animateAppearance(ViewHolder arg9, ItemHolderInfo arg10, ItemHolderInfo arg11) {
        if(arg10 != null && (arg10.left != arg11.left || arg10.top != arg11.top)) {
            return this.animateMove(arg9, arg10.left, arg10.top, arg11.left, arg11.top);
        }

        return this.animateAdd(arg9);
    }

    public abstract boolean animateChange(ViewHolder arg1, ViewHolder arg2, int arg3, int arg4, int arg5, int arg6);

    public boolean animateChange(ViewHolder arg8, ViewHolder arg9, ItemHolderInfo arg10, ItemHolderInfo arg11) {
        int v5;
        int v6;
        int v3 = arg10.left;
        int v4 = arg10.top;
        if(arg9.shouldIgnore()) {
            int v11 = arg10.left;
            v6 = arg10.top;
            v5 = v11;
        }
        else {
            v5 = arg11.left;
            v6 = arg11.top;
        }

        return this.animateChange(arg8, arg9, v3, v4, v5, v6);
    }

    public boolean animateDisappearance(ViewHolder arg7, ItemHolderInfo arg8, ItemHolderInfo arg9) {
        int v2 = arg8.left;
        int v3 = arg8.top;
        View v8 = arg7.itemView;
        int v0 = arg9 == null ? v8.getLeft() : arg9.left;
        int v4 = v0;
        int v9 = arg9 == null ? v8.getTop() : arg9.top;
        int v5 = v9;
        if(!arg7.isRemoved() && (v2 != v4 || v3 != v5)) {
            v8.layout(v4, v5, v8.getWidth() + v4, v8.getHeight() + v5);
            return this.animateMove(arg7, v2, v3, v4, v5);
        }

        return this.animateRemove(arg7);
    }

    public abstract boolean animateMove(ViewHolder arg1, int arg2, int arg3, int arg4, int arg5);

    public boolean animatePersistence(ViewHolder arg7, ItemHolderInfo arg8, ItemHolderInfo arg9) {
        if(arg8.left == arg9.left) {
            if(arg8.top != arg9.top) {
            }
            else {
                this.dispatchMoveFinished(arg7);
                return 0;
            }
        }

        return this.animateMove(arg7, arg8.left, arg8.top, arg9.left, arg9.top);
    }

    public abstract boolean animateRemove(ViewHolder arg1);

    public boolean canReuseUpdatedViewHolder(ViewHolder arg1) {
        if(this.mSupportsChangeAnimations) {
            if(arg1.isInvalid()) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public final void dispatchAddFinished(ViewHolder arg1) {
        this.onAddFinished(arg1);
        this.dispatchAnimationFinished(arg1);
    }

    public final void dispatchAddStarting(ViewHolder arg1) {
        this.onAddStarting(arg1);
    }

    public final void dispatchChangeFinished(ViewHolder arg1, boolean arg2) {
        this.onChangeFinished(arg1, arg2);
        this.dispatchAnimationFinished(arg1);
    }

    public final void dispatchChangeStarting(ViewHolder arg1, boolean arg2) {
        this.onChangeStarting(arg1, arg2);
    }

    public final void dispatchMoveFinished(ViewHolder arg1) {
        this.onMoveFinished(arg1);
        this.dispatchAnimationFinished(arg1);
    }

    public final void dispatchMoveStarting(ViewHolder arg1) {
        this.onMoveStarting(arg1);
    }

    public final void dispatchRemoveFinished(ViewHolder arg1) {
        this.onRemoveFinished(arg1);
        this.dispatchAnimationFinished(arg1);
    }

    public final void dispatchRemoveStarting(ViewHolder arg1) {
        this.onRemoveStarting(arg1);
    }

    public boolean getSupportsChangeAnimations() {
        return this.mSupportsChangeAnimations;
    }

    public void onAddFinished(ViewHolder arg1) {
    }

    public void onAddStarting(ViewHolder arg1) {
    }

    public void onChangeFinished(ViewHolder arg1, boolean arg2) {
    }

    public void onChangeStarting(ViewHolder arg1, boolean arg2) {
    }

    public void onMoveFinished(ViewHolder arg1) {
    }

    public void onMoveStarting(ViewHolder arg1) {
    }

    public void onRemoveFinished(ViewHolder arg1) {
    }

    public void onRemoveStarting(ViewHolder arg1) {
    }

    public void setSupportsChangeAnimations(boolean arg1) {
        this.mSupportsChangeAnimations = arg1;
    }
}

