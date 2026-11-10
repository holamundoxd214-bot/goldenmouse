package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import androidx.appcompat.R$attr;

public class AppCompatRatingBar extends RatingBar {
    private final AppCompatProgressBarHelper mAppCompatProgressBarHelper;

    public AppCompatRatingBar(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, attr.ratingBarStyle);
    }

    public AppCompatRatingBar(Context arg2) {
        this(arg2, null);
    }

    public AppCompatRatingBar(Context arg1, AttributeSet arg2, int arg3) {
        super(arg1, arg2, arg3);
        ThemeUtils.checkAppCompatTheme(((View)this), this.getContext());
        AppCompatProgressBarHelper v1 = new AppCompatProgressBarHelper(((ProgressBar)this));
        this.mAppCompatProgressBarHelper = v1;
        v1.loadFromAttributes(arg2, arg3);
    }

    protected void onMeasure(int arg2, int arg3) {
        __monitor_enter(this);
        try {
            super.onMeasure(arg2, arg3);
            Bitmap v3 = this.mAppCompatProgressBarHelper.getSampleTile();
            if(v3 != null) {
                this.setMeasuredDimension(View.resolveSizeAndState(v3.getWidth() * this.getNumStars(), arg2, 0), this.getMeasuredHeight());
            }
        }
        catch(Throwable v2) {
            try {
            label_15:
                __monitor_exit(this);
            }
            catch(Throwable v2) {
                goto label_15;
            }

            throw v2;
        }

        __monitor_exit(this);
    }
}

