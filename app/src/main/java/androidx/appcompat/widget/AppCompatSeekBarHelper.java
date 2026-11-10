package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff$Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import androidx.appcompat.R$styleable;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;

class AppCompatSeekBarHelper extends AppCompatProgressBarHelper {
    private boolean mHasTickMarkTint;
    private boolean mHasTickMarkTintMode;
    private Drawable mTickMark;
    private ColorStateList mTickMarkTintList;
    private PorterDuff$Mode mTickMarkTintMode;
    private final SeekBar mView;

    AppCompatSeekBarHelper(SeekBar arg2) {
        super(((ProgressBar)arg2));
        this.mTickMarkTintList = null;
        this.mTickMarkTintMode = null;
        this.mHasTickMarkTint = false;
        this.mHasTickMarkTintMode = false;
        this.mView = arg2;
    }

    private void applyTickMarkTint() {
        Drawable v0 = this.mTickMark;
        if(v0 != null && ((this.mHasTickMarkTint) || (this.mHasTickMarkTintMode))) {
            v0 = DrawableCompat.wrap(v0.mutate());
            this.mTickMark = v0;
            if(this.mHasTickMarkTint) {
                DrawableCompat.setTintList(v0, this.mTickMarkTintList);
            }

            if(this.mHasTickMarkTintMode) {
                DrawableCompat.setTintMode(this.mTickMark, this.mTickMarkTintMode);
            }

            if(!this.mTickMark.isStateful()) {
                return;
            }

            this.mTickMark.setState(this.mView.getDrawableState());
        }
    }

    void drawTickMarks(Canvas arg7) {
        if(this.mTickMark != null) {
            int v0 = this.mView.getMax();
            int v1 = 1;
            if(v0 > 1) {
                int v2 = this.mTickMark.getIntrinsicWidth();
                int v3 = this.mTickMark.getIntrinsicHeight();
                if(v2 >= 0) {
                    v2 /= 2;
                }
                else {
                    v2 = 1;
                }

                if(v3 >= 0) {
                    v1 = v3 / 2;
                }

                this.mTickMark.setBounds(-v2, -v1, v2, v1);
                float v1_1 = (((float)(this.mView.getWidth() - this.mView.getPaddingLeft() - this.mView.getPaddingRight()))) / (((float)v0));
                v2 = arg7.save();
                arg7.translate(((float)this.mView.getPaddingLeft()), ((float)(this.mView.getHeight() / 2)));
                for(v3 = 0; v3 <= v0; ++v3) {
                    this.mTickMark.draw(arg7);
                    arg7.translate(v1_1, 0f);
                }

                arg7.restoreToCount(v2);
            }
        }
    }

    void drawableStateChanged() {
        Drawable v0 = this.mTickMark;
        if(v0 != null && (v0.isStateful()) && (v0.setState(this.mView.getDrawableState()))) {
            this.mView.invalidateDrawable(v0);
        }
    }

    Drawable getTickMark() {
        return this.mTickMark;
    }

    ColorStateList getTickMarkTintList() {
        return this.mTickMarkTintList;
    }

    PorterDuff$Mode getTickMarkTintMode() {
        return this.mTickMarkTintMode;
    }

    void jumpDrawablesToCurrentState() {
        Drawable v0 = this.mTickMark;
        if(v0 != null) {
            v0.jumpToCurrentState();
        }
    }

    void loadFromAttributes(AttributeSet arg9, int arg10) {
        super.loadFromAttributes(arg9, arg10);
        TintTypedArray v0 = TintTypedArray.obtainStyledAttributes(this.mView.getContext(), arg9, styleable.AppCompatSeekBar, arg10, 0);
        ViewCompat.saveAttributeDataForStyleable(this.mView, this.mView.getContext(), styleable.AppCompatSeekBar, arg9, v0.getWrappedTypeArray(), arg10, 0);
        Drawable v9 = v0.getDrawableIfKnown(styleable.AppCompatSeekBar_android_thumb);
        if(v9 != null) {
            this.mView.setThumb(v9);
        }

        this.setTickMark(v0.getDrawable(styleable.AppCompatSeekBar_tickMark));
        if(v0.hasValue(styleable.AppCompatSeekBar_tickMarkTintMode)) {
            this.mTickMarkTintMode = DrawableUtils.parseTintMode(v0.getInt(styleable.AppCompatSeekBar_tickMarkTintMode, -1), this.mTickMarkTintMode);
            this.mHasTickMarkTintMode = true;
        }

        if(v0.hasValue(styleable.AppCompatSeekBar_tickMarkTint)) {
            this.mTickMarkTintList = v0.getColorStateList(styleable.AppCompatSeekBar_tickMarkTint);
            this.mHasTickMarkTint = true;
        }

        v0.recycle();
        this.applyTickMarkTint();
    }

    void setTickMark(Drawable arg3) {
        Drawable v0 = this.mTickMark;
        if(v0 != null) {
            v0.setCallback(null);
        }

        this.mTickMark = arg3;
        if(arg3 != null) {
            arg3.setCallback(this.mView);
            DrawableCompat.setLayoutDirection(arg3, ViewCompat.getLayoutDirection(this.mView));
            if(arg3.isStateful()) {
                arg3.setState(this.mView.getDrawableState());
            }

            this.applyTickMarkTint();
        }

        this.mView.invalidate();
    }

    void setTickMarkTintList(ColorStateList arg1) {
        this.mTickMarkTintList = arg1;
        this.mHasTickMarkTint = true;
        this.applyTickMarkTint();
    }

    void setTickMarkTintMode(PorterDuff$Mode arg1) {
        this.mTickMarkTintMode = arg1;
        this.mHasTickMarkTintMode = true;
        this.applyTickMarkTint();
    }
}

