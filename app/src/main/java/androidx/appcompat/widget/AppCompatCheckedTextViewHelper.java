package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources$NotFoundException;
import android.graphics.PorterDuff$Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CheckedTextView;
import androidx.appcompat.R$styleable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.CheckedTextViewCompat;

class AppCompatCheckedTextViewHelper {
    private ColorStateList mCheckMarkTintList;
    private PorterDuff$Mode mCheckMarkTintMode;
    private boolean mHasCheckMarkTint;
    private boolean mHasCheckMarkTintMode;
    private boolean mSkipNextApply;
    private final CheckedTextView mView;

    AppCompatCheckedTextViewHelper(CheckedTextView arg2) {
        super();
        this.mCheckMarkTintList = null;
        this.mCheckMarkTintMode = null;
        this.mHasCheckMarkTint = false;
        this.mHasCheckMarkTintMode = false;
        this.mView = arg2;
    }

    void applyCheckMarkTint() {
        Drawable v0 = CheckedTextViewCompat.getCheckMarkDrawable(this.mView);
        if(v0 != null && ((this.mHasCheckMarkTint) || (this.mHasCheckMarkTintMode))) {
            v0 = DrawableCompat.wrap(v0).mutate();
            if(this.mHasCheckMarkTint) {
                DrawableCompat.setTintList(v0, this.mCheckMarkTintList);
            }

            if(this.mHasCheckMarkTintMode) {
                DrawableCompat.setTintMode(v0, this.mCheckMarkTintMode);
            }

            if(v0.isStateful()) {
                v0.setState(this.mView.getDrawableState());
            }

            this.mView.setCheckMarkDrawable(v0);
        }
    }

    ColorStateList getSupportCheckMarkTintList() {
        return this.mCheckMarkTintList;
    }

    PorterDuff$Mode getSupportCheckMarkTintMode() {
        return this.mCheckMarkTintMode;
    }

    void loadFromAttributes(AttributeSet arg11, int arg12) {
        TintTypedArray v1 = TintTypedArray.obtainStyledAttributes(this.mView.getContext(), arg11, styleable.CheckedTextView, arg12, 0);
        ViewCompat.saveAttributeDataForStyleable(this.mView, this.mView.getContext(), styleable.CheckedTextView, arg11, v1.getWrappedTypeArray(), arg12, 0);
        try {
            if(v1.hasValue(styleable.CheckedTextView_checkMarkCompat)) {
                int v11 = v1.getResourceId(styleable.CheckedTextView_checkMarkCompat, 0);
                if(v11 != 0) {
                    try {
                        this.mView.setCheckMarkDrawable(AppCompatResources.getDrawable(this.mView.getContext(), v11));
                    }
                    catch(Resources$NotFoundException ) {
                    label_24:
                        if(v1.hasValue(styleable.CheckedTextView_android_checkMark)) {
                            v11 = v1.getResourceId(styleable.CheckedTextView_android_checkMark, 0);
                            if(v11 != 0) {
                                this.mView.setCheckMarkDrawable(AppCompatResources.getDrawable(this.mView.getContext(), v11));
                            }
                        }
                    }
                }
                else {
                    goto label_24;
                }
            }
            else {
                goto label_24;
            }

            if(v1.hasValue(styleable.CheckedTextView_checkMarkTint)) {
                CheckedTextViewCompat.setCheckMarkTintList(this.mView, v1.getColorStateList(styleable.CheckedTextView_checkMarkTint));
            }

            if(v1.hasValue(styleable.CheckedTextView_checkMarkTintMode)) {
                CheckedTextViewCompat.setCheckMarkTintMode(this.mView, DrawableUtils.parseTintMode(v1.getInt(styleable.CheckedTextView_checkMarkTintMode, -1), null));
            }
        }
        catch(Throwable v0) {
            v1.recycle();
            throw v0;
        }

        v1.recycle();
    }

    void onSetCheckMarkDrawable() {
        if(this.mSkipNextApply) {
            this.mSkipNextApply = false;
            return;
        }

        this.mSkipNextApply = true;
        this.applyCheckMarkTint();
    }

    void setSupportCheckMarkTintList(ColorStateList arg1) {
        this.mCheckMarkTintList = arg1;
        this.mHasCheckMarkTint = true;
        this.applyCheckMarkTint();
    }

    void setSupportCheckMarkTintMode(PorterDuff$Mode arg1) {
        this.mCheckMarkTintMode = arg1;
        this.mHasCheckMarkTintMode = true;
        this.applyCheckMarkTint();
    }
}

