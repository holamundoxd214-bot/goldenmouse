package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff$Mode;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.core.view.TintableBackgroundView;
import androidx.core.widget.TintableImageSourceView;

public class AppCompatImageView extends ImageView implements TintableBackgroundView, TintableImageSourceView {
    private final AppCompatBackgroundHelper mBackgroundTintHelper;
    private boolean mHasLevel;
    private final AppCompatImageHelper mImageHelper;

    public AppCompatImageView(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, 0);
    }

    public AppCompatImageView(Context arg2) {
        this(arg2, null);
    }

    public AppCompatImageView(Context arg1, AttributeSet arg2, int arg3) {
        super(TintContextWrapper.wrap(arg1), arg2, arg3);
        this.mHasLevel = false;
        ThemeUtils.checkAppCompatTheme(((View)this), this.getContext());
        AppCompatBackgroundHelper v1 = new AppCompatBackgroundHelper(((View)this));
        this.mBackgroundTintHelper = v1;
        v1.loadFromAttributes(arg2, arg3);
        AppCompatImageHelper v1_1 = new AppCompatImageHelper(((ImageView)this));
        this.mImageHelper = v1_1;
        v1_1.loadFromAttributes(arg2, arg3);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatBackgroundHelper v0 = this.mBackgroundTintHelper;
        if(v0 != null) {
            v0.applySupportBackgroundTint();
        }

        AppCompatImageHelper v1 = this.mImageHelper;
        if(v1 != null) {
            v1.applySupportImageTint();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        AppCompatBackgroundHelper v0 = this.mBackgroundTintHelper;
        if(v0 != null) {
            return v0.getSupportBackgroundTintList();
        }

        return null;
    }

    public PorterDuff$Mode getSupportBackgroundTintMode() {
        AppCompatBackgroundHelper v0 = this.mBackgroundTintHelper;
        if(v0 != null) {
            return v0.getSupportBackgroundTintMode();
        }

        return null;
    }

    public ColorStateList getSupportImageTintList() {
        AppCompatImageHelper v0 = this.mImageHelper;
        if(v0 != null) {
            return v0.getSupportImageTintList();
        }

        return null;
    }

    public PorterDuff$Mode getSupportImageTintMode() {
        AppCompatImageHelper v0 = this.mImageHelper;
        if(v0 != null) {
            return v0.getSupportImageTintMode();
        }

        return null;
    }

    public boolean hasOverlappingRendering() {
        if((this.mImageHelper.hasOverlappingRendering()) && (super.hasOverlappingRendering())) {
            return 1;
        }

        return 0;
    }

    public void setBackgroundDrawable(Drawable arg1) {
        super.setBackgroundDrawable(arg1);
        AppCompatBackgroundHelper v0 = this.mBackgroundTintHelper;
        if(v0 != null) {
            v0.onSetBackgroundDrawable(arg1);
        }
    }

    public void setBackgroundResource(int arg1) {
        super.setBackgroundResource(arg1);
        AppCompatBackgroundHelper v0 = this.mBackgroundTintHelper;
        if(v0 != null) {
            v0.onSetBackgroundResource(arg1);
        }
    }

    public void setImageBitmap(Bitmap arg1) {
        super.setImageBitmap(arg1);
        AppCompatImageHelper v0 = this.mImageHelper;
        if(v0 != null) {
            v0.applySupportImageTint();
        }
    }

    public void setImageDrawable(Drawable arg3) {
        AppCompatImageHelper v0 = this.mImageHelper;
        if(v0 != null && arg3 != null && !this.mHasLevel) {
            v0.obtainLevelFromDrawable(arg3);
        }

        super.setImageDrawable(arg3);
        AppCompatImageHelper v3 = this.mImageHelper;
        if(v3 != null) {
            v3.applySupportImageTint();
            if(!this.mHasLevel) {
                this.mImageHelper.applyImageLevel();
            }
        }
    }

    public void setImageLevel(int arg1) {
        super.setImageLevel(arg1);
        this.mHasLevel = true;
    }

    public void setImageResource(int arg1) {
        AppCompatImageHelper v0 = this.mImageHelper;
        if(v0 != null) {
            v0.setImageResource(arg1);
        }
    }

    public void setImageURI(Uri arg1) {
        super.setImageURI(arg1);
        AppCompatImageHelper v0 = this.mImageHelper;
        if(v0 != null) {
            v0.applySupportImageTint();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList arg1) {
        AppCompatBackgroundHelper v0 = this.mBackgroundTintHelper;
        if(v0 != null) {
            v0.setSupportBackgroundTintList(arg1);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff$Mode arg1) {
        AppCompatBackgroundHelper v0 = this.mBackgroundTintHelper;
        if(v0 != null) {
            v0.setSupportBackgroundTintMode(arg1);
        }
    }

    public void setSupportImageTintList(ColorStateList arg1) {
        AppCompatImageHelper v0 = this.mImageHelper;
        if(v0 != null) {
            v0.setSupportImageTintList(arg1);
        }
    }

    public void setSupportImageTintMode(PorterDuff$Mode arg1) {
        AppCompatImageHelper v0 = this.mImageHelper;
        if(v0 != null) {
            v0.setSupportImageTintMode(arg1);
        }
    }
}

