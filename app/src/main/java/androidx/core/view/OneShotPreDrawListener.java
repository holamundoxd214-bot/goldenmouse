package androidx.core.view;

import android.view.View$OnAttachStateChangeListener;
import android.view.View;
import android.view.ViewTreeObserver$OnPreDrawListener;
import android.view.ViewTreeObserver;

public final class OneShotPreDrawListener implements View$OnAttachStateChangeListener, ViewTreeObserver$OnPreDrawListener {
    private final Runnable mRunnable;
    private final View mView;
    private ViewTreeObserver mViewTreeObserver;

    private OneShotPreDrawListener(View arg1, Runnable arg2) {
        super();
        this.mView = arg1;
        this.mViewTreeObserver = arg1.getViewTreeObserver();
        this.mRunnable = arg2;
    }

    public static OneShotPreDrawListener add(View arg1, Runnable arg2) {
        if(arg1 != null) {
            if(arg2 != null) {
                OneShotPreDrawListener v0 = new OneShotPreDrawListener(arg1, arg2);
                arg1.getViewTreeObserver().addOnPreDrawListener(((ViewTreeObserver$OnPreDrawListener)v0));
                arg1.addOnAttachStateChangeListener(((View$OnAttachStateChangeListener)v0));
                return v0;
            }

            throw new NullPointerException("runnable == null");
        }

        throw new NullPointerException("view == null");
    }

    public boolean onPreDraw() {
        this.removeListener();
        this.mRunnable.run();
        return 1;
    }

    public void onViewAttachedToWindow(View arg1) {
        this.mViewTreeObserver = arg1.getViewTreeObserver();
    }

    public void onViewDetachedFromWindow(View arg1) {
        this.removeListener();
    }

    public void removeListener() {
        if(this.mViewTreeObserver.isAlive()) {
            this.mViewTreeObserver.removeOnPreDrawListener(((ViewTreeObserver$OnPreDrawListener)this));
        }
        else {
            this.mView.getViewTreeObserver().removeOnPreDrawListener(((ViewTreeObserver$OnPreDrawListener)this));
        }

        this.mView.removeOnAttachStateChangeListener(((View$OnAttachStateChangeListener)this));
    }
}

