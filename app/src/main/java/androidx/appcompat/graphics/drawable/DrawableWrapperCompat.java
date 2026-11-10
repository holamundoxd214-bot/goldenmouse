package androidx.appcompat.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff$Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable$Callback;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.DrawableCompat;

public class DrawableWrapperCompat extends Drawable implements Drawable$Callback {
    private Drawable mDrawable;

    public DrawableWrapperCompat(Drawable arg1) {
        super();
        this.setDrawable(arg1);
    }

    public void draw(Canvas arg1) {
        this.mDrawable.draw(arg1);
    }

    public int getChangingConfigurations() {
        return this.mDrawable.getChangingConfigurations();
    }

    public Drawable getCurrent() {
        return this.mDrawable.getCurrent();
    }

    public Drawable getDrawable() {
        return this.mDrawable;
    }

    public int getIntrinsicHeight() {
        return this.mDrawable.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.mDrawable.getIntrinsicWidth();
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

    public void invalidateDrawable(Drawable arg1) {
        this.invalidateSelf();
    }

    public boolean isAutoMirrored() {
        return DrawableCompat.isAutoMirrored(this.mDrawable);
    }

    public boolean isStateful() {
        return this.mDrawable.isStateful();
    }

    public void jumpToCurrentState() {
        this.mDrawable.jumpToCurrentState();
    }

    protected void onBoundsChange(Rect arg1) {
        this.mDrawable.setBounds(arg1);
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

    public void setDrawable(Drawable arg3) {
        Drawable v0 = this.mDrawable;
        if(v0 != null) {
            v0.setCallback(null);
        }

        this.mDrawable = arg3;
        if(arg3 != null) {
            arg3.setCallback(((Drawable$Callback)this));
        }
    }

    public void setFilterBitmap(boolean arg1) {
        this.mDrawable.setFilterBitmap(arg1);
    }

    public void setHotspot(float arg1, float arg2) {
        DrawableCompat.setHotspot(this.mDrawable, arg1, arg2);
    }

    public void setHotspotBounds(int arg1, int arg2, int arg3, int arg4) {
        DrawableCompat.setHotspotBounds(this.mDrawable, arg1, arg2, arg3, arg4);
    }

    public boolean setState(int[] arg1) {
        return this.mDrawable.setState(arg1);
    }

    public void setTint(int arg1) {
        DrawableCompat.setTint(this.mDrawable, arg1);
    }

    public void setTintList(ColorStateList arg1) {
        DrawableCompat.setTintList(this.mDrawable, arg1);
    }

    public void setTintMode(PorterDuff$Mode arg1) {
        DrawableCompat.setTintMode(this.mDrawable, arg1);
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

    public void unscheduleDrawable(Drawable arg1, Runnable arg2) {
        this.unscheduleSelf(arg2);
    }
}

