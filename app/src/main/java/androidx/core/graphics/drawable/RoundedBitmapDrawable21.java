package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.graphics.Rect;
import android.view.Gravity;

class RoundedBitmapDrawable21 extends RoundedBitmapDrawable {
    protected RoundedBitmapDrawable21(Resources arg1, Bitmap arg2) {
        super(arg1, arg2);
    }

    public void getOutline(Outline arg2) {
        this.updateDstRect();
        arg2.setRoundRect(this.mDstRect, this.getCornerRadius());
    }

    void gravityCompatApply(int arg1, int arg2, int arg3, Rect arg4, Rect arg5) {
        Gravity.apply(arg1, arg2, arg3, arg4, arg5, 0);
    }

    public boolean hasMipMap() {
        if(this.mBitmap != null && (this.mBitmap.hasMipMap())) {
            return 1;
        }

        return 0;
    }

    public void setMipMap(boolean arg2) {
        if(this.mBitmap != null) {
            this.mBitmap.setHasMipMap(arg2);
            this.invalidateSelf();
        }
    }
}

