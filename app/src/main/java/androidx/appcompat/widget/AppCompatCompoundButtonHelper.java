package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources$NotFoundException;
import android.graphics.PorterDuff$Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import androidx.appcompat.R$styleable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.CompoundButtonCompat;

class AppCompatCompoundButtonHelper {
    private ColorStateList mButtonTintList;
    private PorterDuff$Mode mButtonTintMode;
    private boolean mHasButtonTint;
    private boolean mHasButtonTintMode;
    private boolean mSkipNextApply;
    private final CompoundButton mView;

    AppCompatCompoundButtonHelper(CompoundButton arg2) {
        super();
        this.mButtonTintList = null;
        this.mButtonTintMode = null;
        this.mHasButtonTint = false;
        this.mHasButtonTintMode = false;
        this.mView = arg2;
    }

    void applyButtonTint() {
        Drawable v0 = CompoundButtonCompat.getButtonDrawable(this.mView);
        if(v0 != null && ((this.mHasButtonTint) || (this.mHasButtonTintMode))) {
            v0 = DrawableCompat.wrap(v0).mutate();
            if(this.mHasButtonTint) {
                DrawableCompat.setTintList(v0, this.mButtonTintList);
            }

            if(this.mHasButtonTintMode) {
                DrawableCompat.setTintMode(v0, this.mButtonTintMode);
            }

            if(v0.isStateful()) {
                v0.setState(this.mView.getDrawableState());
            }

            this.mView.setButtonDrawable(v0);
        }
    }

    int getCompoundPaddingLeft(int arg1) {
        return arg1;
    }

    ColorStateList getSupportButtonTintList() {
        return this.mButtonTintList;
    }

    PorterDuff$Mode getSupportButtonTintMode() {
        return this.mButtonTintMode;
    }

    void loadFromAttributes(AttributeSet arg11, int arg12) {
        TintTypedArray v1 = TintTypedArray.obtainStyledAttributes(this.mView.getContext(), arg11, styleable.CompoundButton, arg12, 0);
        ViewCompat.saveAttributeDataForStyleable(this.mView, this.mView.getContext(), styleable.CompoundButton, arg11, v1.getWrappedTypeArray(), arg12, 0);
        try {
            if(v1.hasValue(styleable.CompoundButton_buttonCompat)) {
                int v11 = v1.getResourceId(styleable.CompoundButton_buttonCompat, 0);
                if(v11 != 0) {
                    try {
                        this.mView.setButtonDrawable(AppCompatResources.getDrawable(this.mView.getContext(), v11));
                    }
                    catch(Resources$NotFoundException ) {
                    label_24:
                        if(v1.hasValue(styleable.CompoundButton_android_button)) {
                            v11 = v1.getResourceId(styleable.CompoundButton_android_button, 0);
                            if(v11 != 0) {
                                this.mView.setButtonDrawable(AppCompatResources.getDrawable(this.mView.getContext(), v11));
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

            if(v1.hasValue(styleable.CompoundButton_buttonTint)) {
                CompoundButtonCompat.setButtonTintList(this.mView, v1.getColorStateList(styleable.CompoundButton_buttonTint));
            }

            if(v1.hasValue(styleable.CompoundButton_buttonTintMode)) {
                CompoundButtonCompat.setButtonTintMode(this.mView, DrawableUtils.parseTintMode(v1.getInt(styleable.CompoundButton_buttonTintMode, -1), null));
            }
        }
        catch(Throwable v0) {
            v1.recycle();
            throw v0;
        }

        v1.recycle();
    }

    void onSetButtonDrawable() {
        if(this.mSkipNextApply) {
            this.mSkipNextApply = false;
            return;
        }

        this.mSkipNextApply = true;
        this.applyButtonTint();
    }

    void setSupportButtonTintList(ColorStateList arg1) {
        this.mButtonTintList = arg1;
        this.mHasButtonTint = true;
        this.applyButtonTint();
    }

    void setSupportButtonTintMode(PorterDuff$Mode arg1) {
        this.mButtonTintMode = arg1;
        this.mHasButtonTintMode = true;
        this.applyButtonTint();
    }
}

