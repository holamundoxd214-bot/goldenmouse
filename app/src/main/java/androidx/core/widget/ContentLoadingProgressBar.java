package androidx.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

public class ContentLoadingProgressBar extends ProgressBar {
    private static final int MIN_DELAY_MS = 500;
    private static final int MIN_SHOW_TIME_MS = 500;
    private final Runnable mDelayedHide;
    private final Runnable mDelayedShow;
    boolean mDismissed;
    boolean mPostedHide;
    boolean mPostedShow;
    long mStartTime;

    public static void $r8$lambda$-QLbnDmeB_t0R62xLMJCkjyagZI(ContentLoadingProgressBar arg0) {
        arg0.showOnUiThread();
    }

    public static void $r8$lambda$LzWHroRwziRn4m5pH-wlpZWokBw(ContentLoadingProgressBar arg0) {
        arg0.hideOnUiThread();
    }

    public ContentLoadingProgressBar(Context arg2) {
        this(arg2, null);
    }

    public ContentLoadingProgressBar(Context arg2, AttributeSet arg3) {
        super(arg2, arg3, 0);
        this.mStartTime = -1;
        this.mPostedHide = false;
        this.mPostedShow = false;
        this.mDismissed = false;
        this.mDelayedHide = new ContentLoadingProgressBar$$ExternalSyntheticLambda0(this);
        this.mDelayedShow = new ContentLoadingProgressBar$$ExternalSyntheticLambda1(this);
    }

    public void hide() {
        this.post(new ContentLoadingProgressBar$$ExternalSyntheticLambda3(this));
    }

    private void hideOnUiThread() {
        this.mDismissed = true;
        this.removeCallbacks(this.mDelayedShow);
        this.mPostedShow = false;
        long v1 = System.currentTimeMillis();
        long v3 = this.mStartTime;
        v1 -= v3;
        long v5 = 500;
        if(v1 < v5) {
            if(v3 == -1) {
            }
            else {
                if(!this.mPostedHide) {
                    this.postDelayed(this.mDelayedHide, v5 - v1);
                    this.mPostedHide = true;
                }

                return;
            }
        }

        this.setVisibility(8);
    }

    void lambda$new$0$androidx-core-widget-ContentLoadingProgressBar() {
        this.mPostedHide = false;
        this.mStartTime = -1;
        this.setVisibility(8);
    }

    void lambda$new$1$androidx-core-widget-ContentLoadingProgressBar() {
        this.mPostedShow = false;
        if(!this.mDismissed) {
            this.mStartTime = System.currentTimeMillis();
            this.setVisibility(0);
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.removeCallbacks();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.removeCallbacks();
    }

    private void removeCallbacks() {
        this.removeCallbacks(this.mDelayedHide);
        this.removeCallbacks(this.mDelayedShow);
    }

    public void show() {
        this.post(new ContentLoadingProgressBar$$ExternalSyntheticLambda2(this));
    }

    private void showOnUiThread() {
        this.mStartTime = -1;
        this.mDismissed = false;
        this.removeCallbacks(this.mDelayedHide);
        this.mPostedHide = false;
        if(!this.mPostedShow) {
            this.postDelayed(this.mDelayedShow, 500);
            this.mPostedShow = true;
        }
    }
}

