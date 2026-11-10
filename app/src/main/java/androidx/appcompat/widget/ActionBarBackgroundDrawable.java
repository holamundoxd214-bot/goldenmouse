package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;

class ActionBarBackgroundDrawable extends Drawable {
    class Api21Impl {
        private Api21Impl() {
            super();
        }

        public static void getOutline(Drawable arg0, Outline arg1) {
            arg0.getOutline(arg1);
        }
    }

    final ActionBarContainer mContainer;

    public ActionBarBackgroundDrawable(ActionBarContainer arg1) {
        super();
        this.mContainer = arg1;
    }

    public void draw(Canvas arg3) {
        boolean v0 = this.mContainer.mIsSplit;
        ActionBarContainer v1 = this.mContainer;
        if(!v0) {
            if(v1.mBackground != null) {
                this.mContainer.mBackground.draw(arg3);
            }

            if(this.mContainer.mStackedBackground == null) {
                return;
            }

            if(!this.mContainer.mIsStacked) {
                return;
            }

            this.mContainer.mStackedBackground.draw(arg3);
        }
        else if(v1.mSplitBackground != null) {
            this.mContainer.mSplitBackground.draw(arg3);
            return;
        }
    }

    public int getOpacity() {
        return 0;
    }

    public void getOutline(Outline arg3) {
        boolean v0 = this.mContainer.mIsSplit;
        ActionBarContainer v1 = this.mContainer;
        if(v0) {
            if(v1.mSplitBackground != null) {
                Api21Impl.getOutline(this.mContainer.mBackground, arg3);
                return;
            }
        }
        else if(v1.mBackground != null) {
            Api21Impl.getOutline(this.mContainer.mBackground, arg3);
        }
    }

    public void setAlpha(int arg1) {
    }

    public void setColorFilter(ColorFilter arg1) {
    }
}

