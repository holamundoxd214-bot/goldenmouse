package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff$Mode;
import android.graphics.drawable.Drawable$ConstantState;
import android.graphics.drawable.Drawable;

final class WrappedDrawableState extends Drawable$ConstantState {
    int mChangingConfigurations;
    Drawable$ConstantState mDrawableState;
    ColorStateList mTint;
    PorterDuff$Mode mTintMode;

    WrappedDrawableState(WrappedDrawableState arg2) {
        super();
        this.mTint = null;
        this.mTintMode = WrappedDrawableApi14.DEFAULT_TINT_MODE;
        if(arg2 != null) {
            this.mChangingConfigurations = arg2.mChangingConfigurations;
            this.mDrawableState = arg2.mDrawableState;
            this.mTint = arg2.mTint;
            this.mTintMode = arg2.mTintMode;
        }
    }

    boolean canConstantState() {
        if(this.mDrawableState != null) {
            return 1;
        }

        return 0;
    }

    public int getChangingConfigurations() {
        int v0 = this.mChangingConfigurations;
        Drawable$ConstantState v1 = this.mDrawableState;
        int v1_1 = v1 != null ? v1.getChangingConfigurations() : 0;
        return v1_1 | v0;
    }

    public Drawable newDrawable() {
        return this.newDrawable(null);
    }

    public Drawable newDrawable(Resources arg2) {
        return new WrappedDrawableApi21(this, arg2);
    }
}

