package androidx.vectordrawable.graphics.drawable;

import android.content.res.Resources$Theme;
import android.graphics.PorterDuff$Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.graphics.drawable.TintAwareDrawable;

abstract class VectorDrawableCommon extends Drawable implements TintAwareDrawable {
    Drawable mDelegateDrawable;

    VectorDrawableCommon() {
        super();
    }

    public void applyTheme(Resources$Theme arg1) {
        Drawable v0 = this.mDelegateDrawable;
        if(v0 != null) {
            DrawableCompat.applyTheme(v0, arg1);
        }
    }

    public void clearColorFilter() {
        Drawable v0 = this.mDelegateDrawable;
        if(v0 != null) {
            v0.clearColorFilter();
            return;
        }

        super.clearColorFilter();
    }

    public Drawable getCurrent() {
        Drawable v0 = this.mDelegateDrawable;
        if(v0 != null) {
            return v0.getCurrent();
        }

        return super.getCurrent();
    }

    public int getMinimumHeight() {
        Drawable v0 = this.mDelegateDrawable;
        if(v0 != null) {
            return v0.getMinimumHeight();
        }

        return super.getMinimumHeight();
    }

    public int getMinimumWidth() {
        Drawable v0 = this.mDelegateDrawable;
        if(v0 != null) {
            return v0.getMinimumWidth();
        }

        return super.getMinimumWidth();
    }

    public boolean getPadding(Rect arg2) {
        Drawable v0 = this.mDelegateDrawable;
        if(v0 != null) {
            return v0.getPadding(arg2);
        }

        return super.getPadding(arg2);
    }

    public int[] getState() {
        Drawable v0 = this.mDelegateDrawable;
        if(v0 != null) {
            return v0.getState();
        }

        return super.getState();
    }

    public Region getTransparentRegion() {
        Drawable v0 = this.mDelegateDrawable;
        if(v0 != null) {
            return v0.getTransparentRegion();
        }

        return super.getTransparentRegion();
    }

    public void jumpToCurrentState() {
        Drawable v0 = this.mDelegateDrawable;
        if(v0 != null) {
            DrawableCompat.jumpToCurrentState(v0);
        }
    }

    protected void onBoundsChange(Rect arg2) {
        Drawable v0 = this.mDelegateDrawable;
        if(v0 != null) {
            v0.setBounds(arg2);
            return;
        }

        super.onBoundsChange(arg2);
    }

    protected boolean onLevelChange(int arg2) {
        Drawable v0 = this.mDelegateDrawable;
        if(v0 != null) {
            return v0.setLevel(arg2);
        }

        return super.onLevelChange(arg2);
    }

    public void setChangingConfigurations(int arg2) {
        Drawable v0 = this.mDelegateDrawable;
        if(v0 != null) {
            v0.setChangingConfigurations(arg2);
            return;
        }

        super.setChangingConfigurations(arg2);
    }

    public void setColorFilter(int arg2, PorterDuff$Mode arg3) {
        Drawable v0 = this.mDelegateDrawable;
        if(v0 != null) {
            v0.setColorFilter(arg2, arg3);
            return;
        }

        super.setColorFilter(arg2, arg3);
    }

    public void setFilterBitmap(boolean arg1) {
        Drawable v0 = this.mDelegateDrawable;
        if(v0 != null) {
            v0.setFilterBitmap(arg1);
        }
    }

    public void setHotspot(float arg1, float arg2) {
        Drawable v0 = this.mDelegateDrawable;
        if(v0 != null) {
            DrawableCompat.setHotspot(v0, arg1, arg2);
        }
    }

    public void setHotspotBounds(int arg1, int arg2, int arg3, int arg4) {
        Drawable v0 = this.mDelegateDrawable;
        if(v0 != null) {
            DrawableCompat.setHotspotBounds(v0, arg1, arg2, arg3, arg4);
        }
    }

    public boolean setState(int[] arg2) {
        Drawable v0 = this.mDelegateDrawable;
        if(v0 != null) {
            return v0.setState(arg2);
        }

        return super.setState(arg2);
    }
}

