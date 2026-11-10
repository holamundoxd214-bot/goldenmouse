package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff$Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.R$styleable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ViewCompat;
import androidx.core.widget.ImageViewCompat;

public class AppCompatImageHelper {
    private TintInfo mImageTint;
    private TintInfo mInternalImageTint;
    private int mLevel;
    private TintInfo mTmpInfo;
    private final ImageView mView;

    public AppCompatImageHelper(ImageView arg2) {
        super();
        this.mLevel = 0;
        this.mView = arg2;
    }

    private boolean applyFrameworkTintUsingColorFilter(Drawable arg4) {
        TintInfo v0 = this.mTmpInfo;
        if(v0 == null) {
            v0 = new TintInfo();
            this.mTmpInfo = v0;
        }

        v0.clear();
        ColorStateList v1 = ImageViewCompat.getImageTintList(this.mView);
        if(v1 != null) {
            v0.mHasTintList = true;
            v0.mTintList = v1;
        }

        PorterDuff$Mode v1_1 = ImageViewCompat.getImageTintMode(this.mView);
        if(v1_1 != null) {
            v0.mHasTintMode = true;
            v0.mTintMode = v1_1;
        }

        if(!v0.mHasTintList) {
            if(v0.mHasTintMode) {
            }
            else {
                return 0;
            }
        }

        AppCompatDrawableManager.tintDrawable(arg4, v0, this.mView.getDrawableState());
        return 1;
    }

    void applyImageLevel() {
        if(this.mView.getDrawable() != null) {
            this.mView.getDrawable().setLevel(this.mLevel);
        }
    }

    void applySupportImageTint() {
        Drawable v0 = this.mView.getDrawable();
        if(v0 != null) {
            DrawableUtils.fixDrawable(v0);
        }

        if(v0 != null && (!this.shouldApplyFrameworkTintUsingColorFilter() || !this.applyFrameworkTintUsingColorFilter(v0))) {
            TintInfo v1 = this.mImageTint;
            if(v1 != null) {
                AppCompatDrawableManager.tintDrawable(v0, v1, this.mView.getDrawableState());
                return;
            }

            v1 = this.mInternalImageTint;
            if(v1 == null) {
                return;
            }

            AppCompatDrawableManager.tintDrawable(v0, v1, this.mView.getDrawableState());
        }
    }

    ColorStateList getSupportImageTintList() {
        TintInfo v0 = this.mImageTint;
        if(v0 != null) {
            return v0.mTintList;
        }

        return null;
    }

    PorterDuff$Mode getSupportImageTintMode() {
        TintInfo v0 = this.mImageTint;
        if(v0 != null) {
            return v0.mTintMode;
        }

        return null;
    }

    boolean hasOverlappingRendering() {
        if((this.mView.getBackground() instanceof RippleDrawable)) {
            return 0;
        }

        return 1;
    }

    public void loadFromAttributes(AttributeSet arg10, int arg11) {
        TintTypedArray v1 = TintTypedArray.obtainStyledAttributes(this.mView.getContext(), arg10, styleable.AppCompatImageView, arg11, 0);
        ViewCompat.saveAttributeDataForStyleable(this.mView, this.mView.getContext(), styleable.AppCompatImageView, arg10, v1.getWrappedTypeArray(), arg11, 0);
        try {
            Drawable v10 = this.mView.getDrawable();
            arg11 = -1;
            if(v10 == null) {
                int v0_1 = v1.getResourceId(styleable.AppCompatImageView_srcCompat, arg11);
                if(v0_1 != arg11) {
                    v10 = AppCompatResources.getDrawable(this.mView.getContext(), v0_1);
                    if(v10 != null) {
                        this.mView.setImageDrawable(v10);
                    }
                }
            }

            if(v10 != null) {
                DrawableUtils.fixDrawable(v10);
            }

            if(v1.hasValue(styleable.AppCompatImageView_tint)) {
                ImageViewCompat.setImageTintList(this.mView, v1.getColorStateList(styleable.AppCompatImageView_tint));
            }

            if(v1.hasValue(styleable.AppCompatImageView_tintMode)) {
                ImageViewCompat.setImageTintMode(this.mView, DrawableUtils.parseTintMode(v1.getInt(styleable.AppCompatImageView_tintMode, arg11), null));
            }
        }
        catch(Throwable v0) {
            v1.recycle();
            throw v0;
        }

        v1.recycle();
    }

    void obtainLevelFromDrawable(Drawable arg1) {
        this.mLevel = arg1.getLevel();
    }

    public void setImageResource(int arg2) {
        ImageView v0 = this.mView;
        if(arg2 != 0) {
            Drawable v2 = AppCompatResources.getDrawable(v0.getContext(), arg2);
            if(v2 != null) {
                DrawableUtils.fixDrawable(v2);
            }

            this.mView.setImageDrawable(v2);
        }
        else {
            v0.setImageDrawable(null);
        }

        this.applySupportImageTint();
    }

    void setInternalImageTint(ColorStateList arg2) {
        if(arg2 != null) {
            TintInfo v0 = this.mInternalImageTint;
            if(v0 == null) {
                v0 = new TintInfo();
                this.mInternalImageTint = v0;
            }

            v0.mTintList = arg2;
            this.mInternalImageTint.mHasTintList = true;
        }
        else {
            this.mInternalImageTint = null;
        }

        this.applySupportImageTint();
    }

    void setSupportImageTintList(ColorStateList arg2) {
        TintInfo v0 = this.mImageTint;
        if(v0 == null) {
            v0 = new TintInfo();
            this.mImageTint = v0;
        }

        v0.mTintList = arg2;
        this.mImageTint.mHasTintList = true;
        this.applySupportImageTint();
    }

    void setSupportImageTintMode(PorterDuff$Mode arg2) {
        TintInfo v0 = this.mImageTint;
        if(v0 == null) {
            v0 = new TintInfo();
            this.mImageTint = v0;
        }

        v0.mTintMode = arg2;
        this.mImageTint.mHasTintMode = true;
        this.applySupportImageTint();
    }

    private boolean shouldApplyFrameworkTintUsingColorFilter() {
        if(this.mInternalImageTint != null) {
            return 1;
        }

        return 0;
    }
}

