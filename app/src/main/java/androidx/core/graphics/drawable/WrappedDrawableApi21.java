package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff$Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.util.Log;
import java.lang.reflect.Method;

class WrappedDrawableApi21 extends WrappedDrawableApi14 {
    private static final String TAG = "WrappedDrawableApi21";
    private static Method sIsProjectedDrawableMethod;

    WrappedDrawableApi21(WrappedDrawableState arg1, Resources arg2) {
        super(arg1, arg2);
        this.findAndCacheIsProjectedDrawableMethod();
    }

    private void findAndCacheIsProjectedDrawableMethod() {
        if(WrappedDrawableApi21.sIsProjectedDrawableMethod == null) {
            try {
                WrappedDrawableApi21.sIsProjectedDrawableMethod = Drawable.class.getDeclaredMethod("isProjected");
                return;
            }
            catch(Exception v2) {
                Log.w("WrappedDrawableApi21", "Failed to retrieve Drawable#isProjected() method", ((Throwable)v2));
            }
        }
    }

    public Rect getDirtyBounds() {
        return this.mDrawable.getDirtyBounds();
    }

    public void getOutline(Outline arg1) {
        this.mDrawable.getOutline(arg1);
    }

    protected boolean isCompatTintEnabled() {
        Drawable v1 = this.mDrawable;
        if(!(v1 instanceof GradientDrawable) && !(v1 instanceof DrawableContainer) && !(v1 instanceof InsetDrawable)) {
            if((v1 instanceof RippleDrawable)) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public boolean isProjected() {
        if(this.mDrawable != null) {
            Method v0 = WrappedDrawableApi21.sIsProjectedDrawableMethod;
            if(v0 == null) {
                return 0;
            }

            try {
                return v0.invoke(this.mDrawable).booleanValue();
            }
            catch(Exception v3) {
                Log.w("WrappedDrawableApi21", "Error calling Drawable#isProjected() method", ((Throwable)v3));
            }
        }

        return 0;
    }

    public void setHotspot(float arg1, float arg2) {
        this.mDrawable.setHotspot(arg1, arg2);
    }

    public void setHotspotBounds(int arg1, int arg2, int arg3, int arg4) {
        this.mDrawable.setHotspotBounds(arg1, arg2, arg3, arg4);
    }

    public boolean setState(int[] arg1) {
        if(super.setState(arg1)) {
            this.invalidateSelf();
            return 1;
        }

        return 0;
    }

    public void setTint(int arg2) {
        if(this.isCompatTintEnabled()) {
            super.setTint(arg2);
            return;
        }

        this.mDrawable.setTint(arg2);
    }

    public void setTintList(ColorStateList arg2) {
        if(this.isCompatTintEnabled()) {
            super.setTintList(arg2);
            return;
        }

        this.mDrawable.setTintList(arg2);
    }

    public void setTintMode(PorterDuff$Mode arg2) {
        if(this.isCompatTintEnabled()) {
            super.setTintMode(arg2);
            return;
        }

        this.mDrawable.setTintMode(arg2);
    }
}

