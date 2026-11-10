package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff$Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable$Callback;
import android.graphics.drawable.Drawable$ConstantState;
import android.graphics.drawable.Drawable;

class WrappedDrawableApi14 extends Drawable implements Drawable$Callback, TintAwareDrawable, WrappedDrawable {
    static final PorterDuff$Mode DEFAULT_TINT_MODE;
    private boolean mColorFilterSet;
    private int mCurrentColor;
    private PorterDuff$Mode mCurrentMode;
    Drawable mDrawable;
    private boolean mMutated;
    WrappedDrawableState mState;

    static {
        WrappedDrawableApi14.DEFAULT_TINT_MODE = PorterDuff$Mode.SRC_IN;
    }

    WrappedDrawableApi14(Drawable arg2) {
        super();
        this.mState = this.mutateConstantState();
        this.setWrappedDrawable(arg2);
    }

    WrappedDrawableApi14(WrappedDrawableState arg1, Resources arg2) {
        super();
        this.mState = arg1;
        this.updateLocalState(arg2);
    }

    public void draw(Canvas arg1) {
        this.mDrawable.draw(arg1);
    }

    public int getChangingConfigurations() {
        int v0 = super.getChangingConfigurations();
        WrappedDrawableState v1 = this.mState;
        int v1_1 = v1 != null ? v1.getChangingConfigurations() : 0;
        return this.mDrawable.getChangingConfigurations() | (v0 | v1_1);
    }

    public Drawable$ConstantState getConstantState() {
        WrappedDrawableState v0 = this.mState;
        if(v0 != null && (v0.canConstantState())) {
            this.mState.mChangingConfigurations = this.getChangingConfigurations();
            return this.mState;
        }

        return null;
    }

    public Drawable getCurrent() {
        return this.mDrawable.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.mDrawable.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.mDrawable.getIntrinsicWidth();
    }

    public int getLayoutDirection() {
        return this.mDrawable.getLayoutDirection();
    }

    public int getMinimumHeight() {
        return this.mDrawable.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.mDrawable.getMinimumWidth();
    }

    public int getOpacity() {
        return this.mDrawable.getOpacity();
    }

    public boolean getPadding(Rect arg1) {
        return this.mDrawable.getPadding(arg1);
    }

    public int[] getState() {
        return this.mDrawable.getState();
    }

    public Region getTransparentRegion() {
        return this.mDrawable.getTransparentRegion();
    }

    public final Drawable getWrappedDrawable() {
        return this.mDrawable;
    }

    public void invalidateDrawable(Drawable arg1) {
        this.invalidateSelf();
    }

    public boolean isAutoMirrored() {
        return DrawableCompat.isAutoMirrored(this.mDrawable);
    }

    protected boolean isCompatTintEnabled() {
        return 1;
    }

    public boolean isStateful() {
        ColorStateList v0_1;
        if(this.isCompatTintEnabled()) {
            WrappedDrawableState v0 = this.mState;
            if(v0 != null) {
                v0_1 = v0.mTint;
            }
            else {
                goto label_6;
            }
        }
        else {
        label_6:
            v0_1 = null;
        }

        if(v0_1 != null && (v0_1.isStateful()) || (this.mDrawable.isStateful())) {
            return 1;
        }

        return 0;
    }

    public void jumpToCurrentState() {
        this.mDrawable.jumpToCurrentState();
    }

    public Drawable mutate() {
        if(!this.mMutated && super.mutate() == this) {
            this.mState = this.mutateConstantState();
            Drawable v0 = this.mDrawable;
            if(v0 != null) {
                v0.mutate();
            }

            WrappedDrawableState v0_1 = this.mState;
            if(v0_1 != null) {
                Drawable v1 = this.mDrawable;
                Drawable$ConstantState v1_1 = v1 != null ? v1.getConstantState() : null;
                v0_1.mDrawableState = v1_1;
            }

            this.mMutated = true;
        }

        return this;
    }

    private WrappedDrawableState mutateConstantState() {
        return new WrappedDrawableState(this.mState);
    }

    protected void onBoundsChange(Rect arg1) {
        Drawable v0 = this.mDrawable;
        if(v0 != null) {
            v0.setBounds(arg1);
        }
    }

    public boolean onLayoutDirectionChanged(int arg1) {
        return this.mDrawable.setLayoutDirection(arg1);
    }

    protected boolean onLevelChange(int arg1) {
        return this.mDrawable.setLevel(arg1);
    }

    public void scheduleDrawable(Drawable arg1, Runnable arg2, long arg3) {
        this.scheduleSelf(arg2, arg3);
    }

    public void setAlpha(int arg1) {
        this.mDrawable.setAlpha(arg1);
    }

    public void setAutoMirrored(boolean arg1) {
        DrawableCompat.setAutoMirrored(this.mDrawable, arg1);
    }

    public void setChangingConfigurations(int arg1) {
        this.mDrawable.setChangingConfigurations(arg1);
    }

    public void setColorFilter(ColorFilter arg1) {
        this.mDrawable.setColorFilter(arg1);
    }

    public void setDither(boolean arg1) {
        this.mDrawable.setDither(arg1);
    }

    public void setFilterBitmap(boolean arg1) {
        this.mDrawable.setFilterBitmap(arg1);
    }

    public boolean setState(int[] arg2) {
        boolean v0 = this.mDrawable.setState(arg2);
        if(!this.updateTint(arg2)) {
            if(v0) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public void setTint(int arg1) {
        this.setTintList(ColorStateList.valueOf(arg1));
    }

    public void setTintList(ColorStateList arg2) {
        this.mState.mTint = arg2;
        this.updateTint(this.getState());
    }

    public void setTintMode(PorterDuff$Mode arg2) {
        this.mState.mTintMode = arg2;
        this.updateTint(this.getState());
    }

    public boolean setVisible(boolean arg2, boolean arg3) {
        if(!super.setVisible(arg2, arg3)) {
            if(this.mDrawable.setVisible(arg2, arg3)) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public final void setWrappedDrawable(Drawable arg3) {
        Drawable v0 = this.mDrawable;
        if(v0 != null) {
            v0.setCallback(null);
        }

        this.mDrawable = arg3;
        if(arg3 != null) {
            arg3.setCallback(((Drawable$Callback)this));
            this.setVisible(arg3.isVisible(), true);
            this.setState(arg3.getState());
            this.setLevel(arg3.getLevel());
            this.setBounds(arg3.getBounds());
            WrappedDrawableState v0_1 = this.mState;
            if(v0_1 != null) {
                v0_1.mDrawableState = arg3.getConstantState();
            }
        }

        this.invalidateSelf();
    }

    public void unscheduleDrawable(Drawable arg1, Runnable arg2) {
        this.unscheduleSelf(arg2);
    }

    private void updateLocalState(Resources arg2) {
        WrappedDrawableState v0 = this.mState;
        if(v0 != null && v0.mDrawableState != null) {
            this.setWrappedDrawable(this.mState.mDrawableState.newDrawable(arg2));
        }
    }

    private boolean updateTint(int[] arg5) {
        if(!this.isCompatTintEnabled()) {
            return 0;
        }

        ColorStateList v0 = this.mState.mTint;
        PorterDuff$Mode v2 = this.mState.mTintMode;
        if(v0 == null || v2 == null) {
            this.mColorFilterSet = false;
            this.clearColorFilter();
        }
        else {
            int v5 = v0.getColorForState(arg5, v0.getDefaultColor());
            if((this.mColorFilterSet) && v5 == this.mCurrentColor && v2 == this.mCurrentMode) {
                return 0;
            }

            this.setColorFilter(v5, v2);
            this.mCurrentColor = v5;
            this.mCurrentMode = v2;
            this.mColorFilterSet = true;
            return 1;
        }

        return 0;
    }
}

