package androidx.appcompat.widget;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View$OnAttachStateChangeListener;
import android.view.View$OnHoverListener;
import android.view.View$OnLongClickListener;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;

class TooltipCompatHandler implements View$OnAttachStateChangeListener, View$OnHoverListener, View$OnLongClickListener {
    private static final long HOVER_HIDE_TIMEOUT_MS = 15000;
    private static final long HOVER_HIDE_TIMEOUT_SHORT_MS = 3000;
    private static final long LONG_CLICK_HIDE_TIMEOUT_MS = 2500;
    private static final String TAG = "TooltipCompatHandler";
    private final View mAnchor;
    private int mAnchorX;
    private int mAnchorY;
    private boolean mForceNextChangeSignificant;
    private boolean mFromTouch;
    private final Runnable mHideRunnable;
    private final int mHoverSlop;
    private TooltipPopup mPopup;
    private final Runnable mShowRunnable;
    private final CharSequence mTooltipText;
    private static TooltipCompatHandler sActiveHandler;
    private static TooltipCompatHandler sPendingHandler;

    private TooltipCompatHandler(View arg2, CharSequence arg3) {
        super();
        this.mShowRunnable = new TooltipCompatHandler$$ExternalSyntheticLambda0(this);
        this.mHideRunnable = new TooltipCompatHandler$$ExternalSyntheticLambda1(this);
        this.mAnchor = arg2;
        this.mTooltipText = arg3;
        this.mHoverSlop = ViewConfigurationCompat.getScaledHoverSlop(ViewConfiguration.get(arg2.getContext()));
        this.forceNextChangeSignificant();
        arg2.setOnLongClickListener(((View$OnLongClickListener)this));
        arg2.setOnHoverListener(((View$OnHoverListener)this));
    }

    private void cancelPendingShow() {
        this.mAnchor.removeCallbacks(this.mShowRunnable);
    }

    private void forceNextChangeSignificant() {
        this.mForceNextChangeSignificant = true;
    }

    void hide() {
        TooltipCompatHandler v1 = null;
        if(TooltipCompatHandler.sActiveHandler == this) {
            TooltipCompatHandler.sActiveHandler = v1;
            TooltipPopup v0 = this.mPopup;
            if(v0 != null) {
                v0.hide();
                this.mPopup = ((TooltipPopup)v1);
                this.forceNextChangeSignificant();
                this.mAnchor.removeOnAttachStateChangeListener(((View$OnAttachStateChangeListener)this));
            }
            else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }

        if(TooltipCompatHandler.sPendingHandler == this) {
            TooltipCompatHandler.setPendingHandler(v1);
        }

        this.mAnchor.removeCallbacks(this.mHideRunnable);
    }

    void lambda$new$0$androidx-appcompat-widget-TooltipCompatHandler() {
        this.show(false);
    }

    public boolean onHover(View arg3, MotionEvent arg4) {
        if(this.mPopup != null && (this.mFromTouch)) {
            return 0;
        }

        Object v3 = this.mAnchor.getContext().getSystemService("accessibility");
        if((((AccessibilityManager)v3).isEnabled()) && (((AccessibilityManager)v3).isTouchExplorationEnabled())) {
            return 0;
        }

        int v3_1 = arg4.getAction();
        if(v3_1 != 7) {
            if(v3_1 != 10) {
            }
            else {
                this.forceNextChangeSignificant();
                this.hide();
            }
        }
        else if((this.mAnchor.isEnabled()) && this.mPopup == null && (this.updateAnchorPos(arg4))) {
            TooltipCompatHandler.setPendingHandler(this);
        }

        return 0;
    }

    public boolean onLongClick(View arg2) {
        this.mAnchorX = arg2.getWidth() / 2;
        this.mAnchorY = arg2.getHeight() / 2;
        this.show(true);
        return 1;
    }

    public void onViewAttachedToWindow(View arg1) {
    }

    public void onViewDetachedFromWindow(View arg1) {
        this.hide();
    }

    private void scheduleShow() {
        this.mAnchor.postDelayed(this.mShowRunnable, ((long)ViewConfiguration.getLongPressTimeout()));
    }

    private static void setPendingHandler(TooltipCompatHandler arg1) {
        TooltipCompatHandler v0 = TooltipCompatHandler.sPendingHandler;
        if(v0 != null) {
            v0.cancelPendingShow();
        }

        TooltipCompatHandler.sPendingHandler = arg1;
        if(arg1 != null) {
            arg1.scheduleShow();
        }
    }

    public static void setTooltipText(View arg2, CharSequence arg3) {
        TooltipCompatHandler v0 = TooltipCompatHandler.sPendingHandler;
        TooltipCompatHandler v1 = null;
        if(v0 != null && v0.mAnchor == arg2) {
            TooltipCompatHandler.setPendingHandler(v1);
        }

        if(TextUtils.isEmpty(arg3)) {
            TooltipCompatHandler v3 = TooltipCompatHandler.sActiveHandler;
            if(v3 != null && v3.mAnchor == arg2) {
                v3.hide();
            }

            arg2.setOnLongClickListener(((View$OnLongClickListener)v1));
            arg2.setLongClickable(false);
            arg2.setOnHoverListener(((View$OnHoverListener)v1));
            return;
        }

        new TooltipCompatHandler(arg2, arg3);
    }

    void show(boolean arg8) {
        long v2;
        long v0_1;
        if(!ViewCompat.isAttachedToWindow(this.mAnchor)) {
            return;
        }

        TooltipCompatHandler.setPendingHandler(null);
        TooltipCompatHandler v0 = TooltipCompatHandler.sActiveHandler;
        if(v0 != null) {
            v0.hide();
        }

        TooltipCompatHandler.sActiveHandler = this;
        this.mFromTouch = arg8;
        TooltipPopup v1 = new TooltipPopup(this.mAnchor.getContext());
        this.mPopup = v1;
        v1.show(this.mAnchor, this.mAnchorX, this.mAnchorY, this.mFromTouch, this.mTooltipText);
        this.mAnchor.addOnAttachStateChangeListener(((View$OnAttachStateChangeListener)this));
        if(this.mFromTouch) {
            v0_1 = 2500;
        }
        else {
            if((ViewCompat.getWindowSystemUiVisibility(this.mAnchor) & 1) == 1) {
                v0_1 = ((long)ViewConfiguration.getLongPressTimeout());
                v2 = 3000;
            }
            else {
                v0_1 = ((long)ViewConfiguration.getLongPressTimeout());
                v2 = 15000;
            }

            v0_1 = v2 - v0_1;
        }

        this.mAnchor.removeCallbacks(this.mHideRunnable);
        this.mAnchor.postDelayed(this.mHideRunnable, v0_1);
    }

    private boolean updateAnchorPos(MotionEvent arg5) {
        int v0 = ((int)arg5.getX());
        int v5 = ((int)arg5.getY());
        if(!this.mForceNextChangeSignificant && Math.abs(v0 - this.mAnchorX) <= this.mHoverSlop) {
            if(Math.abs(v5 - this.mAnchorY) > this.mHoverSlop) {
            }
            else {
                return 0;
            }
        }

        this.mAnchorX = v0;
        this.mAnchorY = v5;
        this.mForceNextChangeSignificant = false;
        return 1;
    }
}

