package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff$Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.R$styleable;
import androidx.core.view.ViewCompat;

class AppCompatBackgroundHelper {
    private int mBackgroundResId;
    private TintInfo mBackgroundTint;
    private final AppCompatDrawableManager mDrawableManager;
    private TintInfo mInternalBackgroundTint;
    private TintInfo mTmpInfo;
    private final View mView;

    AppCompatBackgroundHelper(View arg2) {
        super();
        this.mBackgroundResId = -1;
        this.mView = arg2;
        this.mDrawableManager = AppCompatDrawableManager.get();
    }

    private boolean applyFrameworkTintUsingColorFilter(Drawable arg4) {
        TintInfo v0 = this.mTmpInfo;
        if(v0 == null) {
            v0 = new TintInfo();
            this.mTmpInfo = v0;
        }

        v0.clear();
        ColorStateList v1 = ViewCompat.getBackgroundTintList(this.mView);
        if(v1 != null) {
            v0.mHasTintList = true;
            v0.mTintList = v1;
        }

        PorterDuff$Mode v1_1 = ViewCompat.getBackgroundTintMode(this.mView);
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

    void applySupportBackgroundTint() {
        Drawable v0 = this.mView.getBackground();
        if(v0 != null && (!this.shouldApplyFrameworkTintUsingColorFilter() || !this.applyFrameworkTintUsingColorFilter(v0))) {
            TintInfo v1 = this.mBackgroundTint;
            if(v1 != null) {
                AppCompatDrawableManager.tintDrawable(v0, v1, this.mView.getDrawableState());
                return;
            }

            v1 = this.mInternalBackgroundTint;
            if(v1 == null) {
                return;
            }

            AppCompatDrawableManager.tintDrawable(v0, v1, this.mView.getDrawableState());
        }
    }

    ColorStateList getSupportBackgroundTintList() {
        TintInfo v0 = this.mBackgroundTint;
        if(v0 != null) {
            return v0.mTintList;
        }

        return null;
    }

    PorterDuff$Mode getSupportBackgroundTintMode() {
        TintInfo v0 = this.mBackgroundTint;
        if(v0 != null) {
            return v0.mTintMode;
        }

        return null;
    }

    void loadFromAttributes(AttributeSet arg10, int arg11) {
        TintTypedArray v1 = TintTypedArray.obtainStyledAttributes(this.mView.getContext(), arg10, styleable.ViewBackgroundHelper, arg11, 0);
        ViewCompat.saveAttributeDataForStyleable(this.mView, this.mView.getContext(), styleable.ViewBackgroundHelper, arg10, v1.getWrappedTypeArray(), arg11, 0);
        try {
            arg11 = -1;
            if(v1.hasValue(styleable.ViewBackgroundHelper_android_background)) {
                this.mBackgroundResId = v1.getResourceId(styleable.ViewBackgroundHelper_android_background, arg11);
                ColorStateList v10 = this.mDrawableManager.getTintList(this.mView.getContext(), this.mBackgroundResId);
                if(v10 != null) {
                    this.setInternalBackgroundTint(v10);
                }
            }

            if(v1.hasValue(styleable.ViewBackgroundHelper_backgroundTint)) {
                ViewCompat.setBackgroundTintList(this.mView, v1.getColorStateList(styleable.ViewBackgroundHelper_backgroundTint));
            }

            if(v1.hasValue(styleable.ViewBackgroundHelper_backgroundTintMode)) {
                ViewCompat.setBackgroundTintMode(this.mView, DrawableUtils.parseTintMode(v1.getInt(styleable.ViewBackgroundHelper_backgroundTintMode, arg11), null));
            }
        }
        catch(Throwable v0) {
            v1.recycle();
            throw v0;
        }

        v1.recycle();
    }

    void onSetBackgroundDrawable(Drawable arg1) {
        this.mBackgroundResId = -1;
        this.setInternalBackgroundTint(null);
        this.applySupportBackgroundTint();
    }

    void onSetBackgroundResource(int arg3) {
        this.mBackgroundResId = arg3;
        AppCompatDrawableManager v0 = this.mDrawableManager;
        ColorStateList v3 = v0 != null ? v0.getTintList(this.mView.getContext(), arg3) : null;
        this.setInternalBackgroundTint(v3);
        this.applySupportBackgroundTint();
    }

    void setInternalBackgroundTint(ColorStateList arg2) {
        if(arg2 != null) {
            TintInfo v0 = this.mInternalBackgroundTint;
            if(v0 == null) {
                v0 = new TintInfo();
                this.mInternalBackgroundTint = v0;
            }

            v0.mTintList = arg2;
            this.mInternalBackgroundTint.mHasTintList = true;
        }
        else {
            this.mInternalBackgroundTint = null;
        }

        this.applySupportBackgroundTint();
    }

    void setSupportBackgroundTintList(ColorStateList arg2) {
        TintInfo v0 = this.mBackgroundTint;
        if(v0 == null) {
            v0 = new TintInfo();
            this.mBackgroundTint = v0;
        }

        v0.mTintList = arg2;
        this.mBackgroundTint.mHasTintList = true;
        this.applySupportBackgroundTint();
    }

    void setSupportBackgroundTintMode(PorterDuff$Mode arg2) {
        TintInfo v0 = this.mBackgroundTint;
        if(v0 == null) {
            v0 = new TintInfo();
            this.mBackgroundTint = v0;
        }

        v0.mTintMode = arg2;
        this.mBackgroundTint.mHasTintMode = true;
        this.applySupportBackgroundTint();
    }

    private boolean shouldApplyFrameworkTintUsingColorFilter() {
        if(this.mInternalBackgroundTint != null) {
            return 1;
        }

        return 0;
    }
}

