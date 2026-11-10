package com.google.android.material.circularreveal;

import android.graphics.Bitmap$Config;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path$Direction;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader$TileMode;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.math.MathUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CircularRevealHelper {
    public interface Delegate {
        void actualDraw(Canvas arg1);

        boolean actualIsOpaque();
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface Strategy {
    }

    public static final int BITMAP_SHADER = 0;
    public static final int CLIP_PATH = 1;
    private static final boolean DEBUG = false;
    public static final int REVEAL_ANIMATOR = 2;
    public static final int STRATEGY;
    private boolean buildingCircularRevealCache;
    private Paint debugPaint;
    private final Delegate delegate;
    private boolean hasCircularRevealCache;
    private Drawable overlayDrawable;
    private RevealInfo revealInfo;
    private final Paint revealPaint;
    private final Path revealPath;
    private final Paint scrimPaint;
    private final View view;

    static {
        CircularRevealHelper.STRATEGY = 2;
    }

    public CircularRevealHelper(Delegate arg3) {
        super();
        this.delegate = arg3;
        this.view = ((View)arg3);
        ((View)arg3).setWillNotDraw(false);
        this.revealPath = new Path();
        this.revealPaint = new Paint(7);
        Paint v3 = new Paint(1);
        this.scrimPaint = v3;
        v3.setColor(0);
    }

    public void buildCircularRevealCache() {
        if(CircularRevealHelper.STRATEGY == 0) {
            this.buildingCircularRevealCache = true;
            this.hasCircularRevealCache = false;
            this.view.buildDrawingCache();
            Bitmap v2 = this.view.getDrawingCache();
            if(v2 == null && this.view.getWidth() != 0 && this.view.getHeight() != 0) {
                v2 = Bitmap.createBitmap(this.view.getWidth(), this.view.getHeight(), Bitmap$Config.ARGB_8888);
                this.view.draw(new Canvas(v2));
            }

            if(v2 != null) {
                this.revealPaint.setShader(new BitmapShader(v2, Shader$TileMode.CLAMP, Shader$TileMode.CLAMP));
            }

            this.buildingCircularRevealCache = false;
            this.hasCircularRevealCache = true;
        }
    }

    public void destroyCircularRevealCache() {
        if(CircularRevealHelper.STRATEGY == 0) {
            this.hasCircularRevealCache = false;
            this.view.destroyDrawingCache();
            this.revealPaint.setShader(null);
            this.view.invalidate();
        }
    }

    public void draw(Canvas arg14) {
        Canvas v7;
        if(this.shouldDrawCircularReveal()) {
            int v0 = CircularRevealHelper.STRATEGY;
            if(v0 == 0) {
                v7 = arg14;
                v7.drawCircle(this.revealInfo.centerX, this.revealInfo.centerY, this.revealInfo.radius, this.revealPaint);
                if(!this.shouldDrawScrim()) {
                    goto label_90;
                }

                v7.drawCircle(this.revealInfo.centerX, this.revealInfo.centerY, this.revealInfo.radius, this.scrimPaint);
            }
            else if(v0 == 1) {
                v7 = arg14;
                int v14 = v7.save();
                v7.clipPath(this.revealPath);
                this.delegate.actualDraw(v7);
                if(this.shouldDrawScrim()) {
                    v7.drawRect(0f, 0f, ((float)this.view.getWidth()), ((float)this.view.getHeight()), this.scrimPaint);
                }

                v7.restoreToCount(v14);
            }
            else if(v0 == 2) {
                this.delegate.actualDraw(arg14);
                if(this.shouldDrawScrim()) {
                    arg14.drawRect(0f, 0f, ((float)this.view.getWidth()), ((float)this.view.getHeight()), this.scrimPaint);
                    v7 = arg14;
                }
                else {
                    v7 = arg14;
                }
            }
            else {
                throw new IllegalStateException("Unsupported strategy " + v0);
            }
        }
        else {
            v7 = arg14;
            this.delegate.actualDraw(v7);
            if(!this.shouldDrawScrim()) {
                goto label_90;
            }

            v7.drawRect(0f, 0f, ((float)this.view.getWidth()), ((float)this.view.getHeight()), this.scrimPaint);
        }

    label_90:
        this.drawOverlayDrawable(v7);
    }

    private void drawDebugCircle(Canvas arg4, int arg5, float arg6) {
        this.debugPaint.setColor(arg5);
        this.debugPaint.setStrokeWidth(arg6);
        arg4.drawCircle(this.revealInfo.centerX, this.revealInfo.centerY, this.revealInfo.radius - arg6 / 2f, this.debugPaint);
    }

    private void drawDebugMode(Canvas arg5) {
        this.delegate.actualDraw(arg5);
        if(this.shouldDrawScrim()) {
            arg5.drawCircle(this.revealInfo.centerX, this.revealInfo.centerY, this.revealInfo.radius, this.scrimPaint);
        }

        if(this.shouldDrawCircularReveal()) {
            this.drawDebugCircle(arg5, 0xFF000000, 10f);
            this.drawDebugCircle(arg5, 0xFFFF0000, 5f);
        }

        this.drawOverlayDrawable(arg5);
    }

    private void drawOverlayDrawable(Canvas arg5) {
        if(this.shouldDrawOverlayDrawable()) {
            Rect v0 = this.overlayDrawable.getBounds();
            float v1 = this.revealInfo.centerX - (((float)v0.width())) / 2f;
            float v2 = this.revealInfo.centerY - (((float)v0.height())) / 2f;
            arg5.translate(v1, v2);
            this.overlayDrawable.draw(arg5);
            arg5.translate(-v1, -v2);
        }
    }

    public Drawable getCircularRevealOverlayDrawable() {
        return this.overlayDrawable;
    }

    public int getCircularRevealScrimColor() {
        return this.scrimPaint.getColor();
    }

    private float getDistanceToFurthestCorner(RevealInfo arg7) {
        return MathUtils.distanceToFurthestCorner(arg7.centerX, arg7.centerY, 0f, 0f, ((float)this.view.getWidth()), ((float)this.view.getHeight()));
    }

    public RevealInfo getRevealInfo() {
        if(this.revealInfo == null) {
            return null;
        }

        RevealInfo v0 = new RevealInfo(this.revealInfo);
        if(v0.isInvalid()) {
            v0.radius = this.getDistanceToFurthestCorner(v0);
        }

        return v0;
    }

    private void invalidateRevealInfo() {
        if(CircularRevealHelper.STRATEGY == 1) {
            this.revealPath.rewind();
            RevealInfo v0 = this.revealInfo;
            if(v0 != null) {
                this.revealPath.addCircle(v0.centerX, this.revealInfo.centerY, this.revealInfo.radius, Path$Direction.CW);
            }
        }

        this.view.invalidate();
    }

    public boolean isOpaque() {
        if((this.delegate.actualIsOpaque()) && !this.shouldDrawCircularReveal()) {
            return 1;
        }

        return 0;
    }

    public void setCircularRevealOverlayDrawable(Drawable arg1) {
        this.overlayDrawable = arg1;
        this.view.invalidate();
    }

    public void setCircularRevealScrimColor(int arg2) {
        this.scrimPaint.setColor(arg2);
        this.view.invalidate();
    }

    public void setRevealInfo(RevealInfo arg3) {
        if(arg3 == null) {
            this.revealInfo = null;
        }
        else {
            RevealInfo v0 = this.revealInfo;
            if(v0 == null) {
                this.revealInfo = new RevealInfo(arg3);
            }
            else {
                v0.set(arg3);
            }

            if(!MathUtils.geq(arg3.radius, this.getDistanceToFurthestCorner(arg3), 0.0001f)) {
                goto label_19;
            }

            this.revealInfo.radius = 3.402823E+38f;
        }

    label_19:
        this.invalidateRevealInfo();
    }

    private boolean shouldDrawCircularReveal() {
        RevealInfo v0 = this.revealInfo;
        int v0_1 = v0 == null || (v0.isInvalid()) ? 1 : 0;
        if(CircularRevealHelper.STRATEGY == 0) {
            if(v0_1 == 0 && (this.hasCircularRevealCache)) {
                return 1;
            }

            return 0;
        }

        return v0_1 ^ 1;
    }

    private boolean shouldDrawOverlayDrawable() {
        if(!this.buildingCircularRevealCache && this.overlayDrawable != null && this.revealInfo != null) {
            return 1;
        }

        return 0;
    }

    private boolean shouldDrawScrim() {
        if(!this.buildingCircularRevealCache && Color.alpha(this.scrimPaint.getColor()) != 0) {
            return 1;
        }

        return 0;
    }
}

