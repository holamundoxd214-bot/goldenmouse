package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityActionCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand$CommandArguments;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.widget.ViewDragHelper$Callback;
import androidx.customview.widget.ViewDragHelper;

public class SwipeDismissBehavior extends Behavior {
    class com.google.android.material.behavior.SwipeDismissBehavior$1 extends Callback {
        private static final int INVALID_POINTER_ID = -1;
        private int activePointerId;
        private int originalCapturedViewLeft;

        com.google.android.material.behavior.SwipeDismissBehavior$1(SwipeDismissBehavior arg1) {
            SwipeDismissBehavior.this = arg1;
            super();
            this.activePointerId = -1;
        }

        public int clampViewPositionHorizontal(View arg3, int arg4, int arg5) {
            int v2;
            int v0;
            arg5 = ViewCompat.getLayoutDirection(arg3) == 1 ? 1 : 0;
            if(SwipeDismissBehavior.this.swipeDirection == 0) {
                v0 = this.originalCapturedViewLeft;
                if(arg5 != 0) {
                    v0 -= arg3.getWidth();
                    v2 = this.originalCapturedViewLeft;
                }
                else {
                    v2 = arg3.getWidth();
                    goto label_16;
                }
            }
            else if(SwipeDismissBehavior.this.swipeDirection == 1) {
                v0 = this.originalCapturedViewLeft;
                if(arg5 != 0) {
                    v2 = arg3.getWidth();
                label_16:
                    v2 += v0;
                }
                else {
                    v0 -= arg3.getWidth();
                    v2 = this.originalCapturedViewLeft;
                }
            }
            else {
                v0 = this.originalCapturedViewLeft - arg3.getWidth();
                v2 = this.originalCapturedViewLeft + arg3.getWidth();
            }

            return SwipeDismissBehavior.clamp(v0, arg4, v2);
        }

        public int clampViewPositionVertical(View arg1, int arg2, int arg3) {
            return arg1.getTop();
        }

        public int getViewHorizontalDragRange(View arg1) {
            return arg1.getWidth();
        }

        public void onViewCaptured(View arg2, int arg3) {
            this.activePointerId = arg3;
            this.originalCapturedViewLeft = arg2.getLeft();
            ViewParent v2 = arg2.getParent();
            if(v2 != null) {
                SwipeDismissBehavior.this.requestingDisallowInterceptTouchEvent = true;
                v2.requestDisallowInterceptTouchEvent(true);
                SwipeDismissBehavior.this.requestingDisallowInterceptTouchEvent = false;
            }
        }

        public void onViewDragStateChanged(int arg2) {
            if(SwipeDismissBehavior.this.listener != null) {
                SwipeDismissBehavior.this.listener.onDragStateChanged(arg2);
            }
        }

        public void onViewPositionChanged(View arg2, int arg3, int arg4, int arg5, int arg6) {
            float v4 = (((float)arg2.getWidth())) * SwipeDismissBehavior.this.alphaStartSwipeDistance;
            float v5 = (((float)arg2.getWidth())) * SwipeDismissBehavior.this.alphaEndSwipeDistance;
            float v1 = ((float)Math.abs(arg3 - this.originalCapturedViewLeft));
            float v6 = 1f;
            if(Float.compare(v1, v4) <= 0) {
                arg2.setAlpha(v6);
                return;
            }

            if(Float.compare(v1, v5) >= 0) {
                arg2.setAlpha(0f);
                return;
            }

            arg2.setAlpha(SwipeDismissBehavior.clamp(0f, v6 - SwipeDismissBehavior.fraction(v4, v5, v1), v6));
        }

        public void onViewReleased(View arg3, float arg4, float arg5) {
            boolean v4_1;
            int v0;
            this.activePointerId = -1;
            int v5 = arg3.getWidth();
            if(this.shouldDismiss(arg3, arg4)) {
                if(arg4 >= 0f) {
                    int v4 = arg3.getLeft();
                    v0 = this.originalCapturedViewLeft;
                    if(v4 < v0) {
                        goto label_13;
                    }
                    else {
                        v0 += v5;
                    }
                }
                else {
                label_13:
                    v0 = this.originalCapturedViewLeft - v5;
                }

                v4_1 = true;
            }
            else {
                v0 = this.originalCapturedViewLeft;
                v4_1 = false;
            }

            if(SwipeDismissBehavior.this.viewDragHelper.settleCapturedViewAt(v0, arg3.getTop())) {
                ViewCompat.postOnAnimation(arg3, new SettleRunnable(SwipeDismissBehavior.this, arg3, v4_1));
                return;
            }

            if((v4_1) && SwipeDismissBehavior.this.listener != null) {
                SwipeDismissBehavior.this.listener.onDismiss(arg3);
            }
        }

        private boolean shouldDismiss(View arg7, float arg8) {
            int v1 = Float.compare(arg8, 0f);
            if(v1 != 0) {
                int v7 = ViewCompat.getLayoutDirection(arg7) == 1 ? 1 : 0;
                if(SwipeDismissBehavior.this.swipeDirection == 2) {
                    return 1;
                }

                if(SwipeDismissBehavior.this.swipeDirection == 0) {
                    if(v7 != 0) {
                        if(arg8 < 0f) {
                            return 1;
                        }

                        return 0;
                    }

                    if(v1 > 0) {
                        return 1;
                    }

                    return 0;
                }

                if(SwipeDismissBehavior.this.swipeDirection == 1) {
                    if(v7 != 0) {
                        if(v1 > 0) {
                            return 1;
                        }
                        else {
                            return 0;
                        }
                    }
                    else if(arg8 < 0f) {
                        return 1;
                    }
                }

                return 0;
            }

            if(Math.abs(arg7.getLeft() - this.originalCapturedViewLeft) >= Math.round((((float)arg7.getWidth())) * SwipeDismissBehavior.this.dragDismissThreshold)) {
                return 1;
            }

            return 0;
        }

        public boolean tryCaptureView(View arg3, int arg4) {
            int v0 = this.activePointerId;
            if((v0 == -1 || v0 == arg4) && (SwipeDismissBehavior.this.canSwipeDismissView(arg3))) {
                return 1;
            }

            return 0;
        }
    }

    public interface OnDismissListener {
        void onDismiss(View arg1);

        void onDragStateChanged(int arg1);
    }

    class SettleRunnable implements Runnable {
        private final boolean dismiss;
        private final View view;

        SettleRunnable(SwipeDismissBehavior arg1, View arg2, boolean arg3) {
            SwipeDismissBehavior.this = arg1;
            super();
            this.view = arg2;
            this.dismiss = arg3;
        }

        public void run() {
            if(SwipeDismissBehavior.this.viewDragHelper != null && (SwipeDismissBehavior.this.viewDragHelper.continueSettling(true))) {
                ViewCompat.postOnAnimation(this.view, ((Runnable)this));
                return;
            }

            if((this.dismiss) && SwipeDismissBehavior.this.listener != null) {
                SwipeDismissBehavior.this.listener.onDismiss(this.view);
            }
        }
    }

    private static final float DEFAULT_ALPHA_END_DISTANCE = 0.5f;
    private static final float DEFAULT_ALPHA_START_DISTANCE = 0f;
    private static final float DEFAULT_DRAG_DISMISS_THRESHOLD = 0.5f;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    public static final int SWIPE_DIRECTION_ANY = 2;
    public static final int SWIPE_DIRECTION_END_TO_START = 1;
    public static final int SWIPE_DIRECTION_START_TO_END;
    float alphaEndSwipeDistance;
    float alphaStartSwipeDistance;
    private final Callback dragCallback;
    float dragDismissThreshold;
    private boolean interceptingEvents;
    OnDismissListener listener;
    private boolean requestingDisallowInterceptTouchEvent;
    private float sensitivity;
    private boolean sensitivitySet;
    int swipeDirection;
    ViewDragHelper viewDragHelper;

    public SwipeDismissBehavior() {
        super();
        this.sensitivity = 0f;
        this.swipeDirection = 2;
        this.dragDismissThreshold = 0.5f;
        this.alphaStartSwipeDistance = 0f;
        this.alphaEndSwipeDistance = 0.5f;
        this.dragCallback = new com.google.android.material.behavior.SwipeDismissBehavior$1(this);
    }

    static boolean access$002(SwipeDismissBehavior arg0, boolean arg1) {
        arg0.requestingDisallowInterceptTouchEvent = arg1;
        return arg1;
    }

    public boolean canSwipeDismissView(View arg1) {
        return 1;
    }

    static float clamp(float arg0, float arg1, float arg2) {
        return Math.min(Math.max(arg0, arg1), arg2);
    }

    static int clamp(int arg0, int arg1, int arg2) {
        return Math.min(Math.max(arg0, arg1), arg2);
    }

    private void ensureViewDragHelper(ViewGroup arg3) {
        if(this.viewDragHelper == null) {
            ViewDragHelper v3 = this.sensitivitySet ? ViewDragHelper.create(arg3, this.sensitivity, this.dragCallback) : ViewDragHelper.create(arg3, this.dragCallback);
            this.viewDragHelper = v3;
        }
    }

    static float fraction(float arg0, float arg1, float arg2) {
        return (arg2 - arg0) / (arg1 - arg0);
    }

    public int getDragState() {
        ViewDragHelper v0 = this.viewDragHelper;
        if(v0 != null) {
            return v0.getViewDragState();
        }

        return 0;
    }

    public OnDismissListener getListener() {
        return this.listener;
    }

    public boolean onInterceptTouchEvent(CoordinatorLayout arg5, View arg6, MotionEvent arg7) {
        boolean v0 = this.interceptingEvents;
        int v1 = arg7.getActionMasked();
        if(v1 != 0) {
            if(v1 != 1 && v1 != 3) {
                goto label_17;
            }

            this.interceptingEvents = false;
        }
        else {
            v0 = arg5.isPointInChildBounds(arg6, ((int)arg7.getX()), ((int)arg7.getY()));
            this.interceptingEvents = v0;
        }

    label_17:
        if(v0) {
            this.ensureViewDragHelper(((ViewGroup)arg5));
            if(!this.requestingDisallowInterceptTouchEvent && (this.viewDragHelper.shouldInterceptTouchEvent(arg7))) {
                return 1;
            }
        }

        return 0;
    }

    public boolean onLayoutChild(CoordinatorLayout arg1, View arg2, int arg3) {
        boolean v1 = super.onLayoutChild(arg1, arg2, arg3);
        if(ViewCompat.getImportantForAccessibility(arg2) == 0) {
            ViewCompat.setImportantForAccessibility(arg2, 1);
            this.updateAccessibilityActions(arg2);
        }

        return v1;
    }

    public boolean onTouchEvent(CoordinatorLayout arg1, View arg2, MotionEvent arg3) {
        if(this.viewDragHelper != null) {
            if(!this.requestingDisallowInterceptTouchEvent || arg3.getActionMasked() != 3) {
                this.viewDragHelper.processTouchEvent(arg3);
            }

            return 1;
        }

        return 0;
    }

    public void setDragDismissDistance(float arg3) {
        this.dragDismissThreshold = SwipeDismissBehavior.clamp(0f, arg3, 1f);
    }

    public void setEndAlphaSwipeDistance(float arg3) {
        this.alphaEndSwipeDistance = SwipeDismissBehavior.clamp(0f, arg3, 1f);
    }

    public void setListener(OnDismissListener arg1) {
        this.listener = arg1;
    }

    public void setSensitivity(float arg1) {
        this.sensitivity = arg1;
        this.sensitivitySet = true;
    }

    public void setStartAlphaSwipeDistance(float arg3) {
        this.alphaStartSwipeDistance = SwipeDismissBehavior.clamp(0f, arg3, 1f);
    }

    public void setSwipeDirection(int arg1) {
        this.swipeDirection = arg1;
    }

    private void updateAccessibilityActions(View arg3) {
        ViewCompat.removeAccessibilityAction(arg3, 0x100000);
        if(this.canSwipeDismissView(arg3)) {
            ViewCompat.replaceAccessibilityAction(arg3, AccessibilityActionCompat.ACTION_DISMISS, null, new AccessibilityViewCommand() {
                public boolean perform(View arg3, CommandArguments arg4) {
                    int v4;
                    int v0 = 0;
                    if(SwipeDismissBehavior.this.canSwipeDismissView(arg3)) {
                        if(ViewCompat.getLayoutDirection(arg3) == 1) {
                            v0 = 1;
                        }

                        if(SwipeDismissBehavior.this.swipeDirection != 0 || v0 == 0) {
                            if(SwipeDismissBehavior.this.swipeDirection == 1 && v0 == 0) {
                            label_16:
                                v4 = -arg3.getWidth();
                                goto label_20;
                            }

                            v4 = arg3.getWidth();
                        }
                        else {
                            goto label_16;
                        }

                    label_20:
                        ViewCompat.offsetLeftAndRight(arg3, v4);
                        arg3.setAlpha(0f);
                        if(SwipeDismissBehavior.this.listener != null) {
                            SwipeDismissBehavior.this.listener.onDismiss(arg3);
                        }

                        return 1;
                    }

                    return 0;
                }
            });
        }
    }
}

