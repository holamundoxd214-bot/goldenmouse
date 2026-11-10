package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View$OnAttachStateChangeListener;
import android.view.View$OnTouchListener;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.ListView;
import androidx.appcompat.view.menu.ShowableListMenu;

public abstract class ForwardingListener implements View$OnAttachStateChangeListener, View$OnTouchListener {
    class DisallowIntercept implements Runnable {
        DisallowIntercept(ForwardingListener arg1) {
            ForwardingListener.this = arg1;
            super();
        }

        public void run() {
            ViewParent v1 = ForwardingListener.this.mSrc.getParent();
            if(v1 != null) {
                v1.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    class TriggerLongPress implements Runnable {
        TriggerLongPress(ForwardingListener arg1) {
            ForwardingListener.this = arg1;
            super();
        }

        public void run() {
            ForwardingListener.this.onLongPress();
        }
    }

    private int mActivePointerId;
    private Runnable mDisallowIntercept;
    private boolean mForwarding;
    private final int mLongPressTimeout;
    private final float mScaledTouchSlop;
    final View mSrc;
    private final int mTapTimeout;
    private final int[] mTmpLocation;
    private Runnable mTriggerLongPress;

    public ForwardingListener(View arg3) {
        super();
        this.mTmpLocation = new int[2];
        this.mSrc = arg3;
        arg3.setLongClickable(true);
        arg3.addOnAttachStateChangeListener(((View$OnAttachStateChangeListener)this));
        this.mScaledTouchSlop = ((float)ViewConfiguration.get(arg3.getContext()).getScaledTouchSlop());
        int v3 = ViewConfiguration.getTapTimeout();
        this.mTapTimeout = v3;
        this.mLongPressTimeout = (v3 + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    private void clearCallbacks() {
        Runnable v0 = this.mTriggerLongPress;
        if(v0 != null) {
            this.mSrc.removeCallbacks(v0);
        }

        v0 = this.mDisallowIntercept;
        if(v0 != null) {
            this.mSrc.removeCallbacks(v0);
        }
    }

    public abstract ShowableListMenu getPopup();

    protected boolean onForwardingStarted() {
        ShowableListMenu v1 = this.getPopup();
        if(v1 != null && !v1.isShowing()) {
            v1.show();
        }

        return 1;
    }

    protected boolean onForwardingStopped() {
        ShowableListMenu v1 = this.getPopup();
        if(v1 != null && (v1.isShowing())) {
            v1.dismiss();
        }

        return 1;
    }

    void onLongPress() {
        this.clearCallbacks();
        View v0 = this.mSrc;
        if(v0.isEnabled()) {
            if(v0.isLongClickable()) {
            }
            else if(!this.onForwardingStarted()) {
            }
            else {
                v0.getParent().requestDisallowInterceptTouchEvent(true);
                long v3 = SystemClock.uptimeMillis();
                MotionEvent v1 = MotionEvent.obtain(v3, v3, 3, 0f, 0f, 0);
                v0.onTouchEvent(v1);
                v1.recycle();
                this.mForwarding = true;
            }
        }
    }

    public boolean onTouch(View arg11, MotionEvent arg12) {
        boolean v12;
        boolean v11 = this.mForwarding;
        if(v11) {
            if(!this.onTouchForwarded(arg12)) {
                if(!this.onForwardingStopped()) {
                }
                else {
                    v12 = false;
                    goto label_31;
                }
            }

            v12 = true;
        }
        else {
            v12 = !this.onTouchObserved(arg12) || !this.onForwardingStarted() ? false : true;
            if(!v12) {
                goto label_31;
            }

            long v2 = SystemClock.uptimeMillis();
            MotionEvent v2_1 = MotionEvent.obtain(v2, v2, 3, 0f, 0f, 0);
            this.mSrc.onTouchEvent(v2_1);
            v2_1.recycle();
        }

    label_31:
        this.mForwarding = v12;
        if(!v12) {
            if(v11) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    private boolean onTouchForwarded(MotionEvent arg5) {
        View v0 = this.mSrc;
        ShowableListMenu v1 = this.getPopup();
        if(v1 != null) {
            if(!v1.isShowing()) {
            }
            else {
                ListView v1_1 = v1.getListView();
                if(v1_1 != null) {
                    if(!((DropDownListView)v1_1).isShown()) {
                    }
                    else {
                        MotionEvent v3 = MotionEvent.obtainNoHistory(arg5);
                        this.toGlobalMotionEvent(v0, v3);
                        this.toLocalMotionEvent(((View)v1_1), v3);
                        boolean v4 = ((DropDownListView)v1_1).onForwardedEvent(v3, this.mActivePointerId);
                        v3.recycle();
                        int v5 = arg5.getActionMasked();
                        v5 = v5 == 1 || v5 == 3 ? 0 : 1;
                        if(!v4) {
                            return 0;
                        }

                        if(v5 == 0) {
                            return 0;
                        }

                        return 1;
                    }
                }
            }
        }

        return 0;
    }

    private boolean onTouchObserved(MotionEvent arg6) {
        View v0 = this.mSrc;
        if(!v0.isEnabled()) {
            return 0;
        }

        int v1 = arg6.getActionMasked();
        if(v1 != 0) {
            if(v1 != 1) {
                if(v1 == 2) {
                    v1 = arg6.findPointerIndex(this.mActivePointerId);
                    if(v1 < 0) {
                        return 0;
                    }
                    else if(!ForwardingListener.pointInView(v0, arg6.getX(v1), arg6.getY(v1), this.mScaledTouchSlop)) {
                        this.clearCallbacks();
                        v0.getParent().requestDisallowInterceptTouchEvent(true);
                        return 1;
                    }
                    else {
                        return 0;
                    }
                }
                else if(v1 != 3) {
                    return 0;
                }
            }

            this.clearCallbacks();
        }
        else {
            this.mActivePointerId = arg6.getPointerId(0);
            if(this.mDisallowIntercept == null) {
                this.mDisallowIntercept = new DisallowIntercept(this);
            }

            v0.postDelayed(this.mDisallowIntercept, ((long)this.mTapTimeout));
            if(this.mTriggerLongPress == null) {
                this.mTriggerLongPress = new TriggerLongPress(this);
            }

            v0.postDelayed(this.mTriggerLongPress, ((long)this.mLongPressTimeout));
        }

        return 0;
    }

    public void onViewAttachedToWindow(View arg1) {
    }

    public void onViewDetachedFromWindow(View arg1) {
        this.mForwarding = false;
        this.mActivePointerId = -1;
        Runnable v1 = this.mDisallowIntercept;
        if(v1 != null) {
            this.mSrc.removeCallbacks(v1);
        }
    }

    private static boolean pointInView(View arg2, float arg3, float arg4, float arg5) {
        float v0 = -arg5;
        if(arg3 >= v0 && arg4 >= v0 && arg3 < (((float)(arg2.getRight() - arg2.getLeft()))) + arg5 && arg4 < (((float)(arg2.getBottom() - arg2.getTop()))) + arg5) {
            return 1;
        }

        return 0;
    }

    private boolean toGlobalMotionEvent(View arg2, MotionEvent arg3) {
        int[] v1 = this.mTmpLocation;
        arg2.getLocationOnScreen(v1);
        arg3.offsetLocation(((float)v1[0]), ((float)v1[1]));
        return 1;
    }

    private boolean toLocalMotionEvent(View arg2, MotionEvent arg3) {
        int[] v1 = this.mTmpLocation;
        arg2.getLocationOnScreen(v1);
        arg3.offsetLocation(((float)(-v1[0])), ((float)(-v1[1])));
        return 1;
    }
}

