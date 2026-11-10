package com.google.android.material.sidesheet;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatDialog;
import androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R$id;
import com.google.android.material.R$style;
import com.google.android.material.motion.MaterialBackOrchestrator;

abstract class SheetDialog extends AppCompatDialog {
    private static final int COORDINATOR_LAYOUT_ID;
    private static final int TOUCH_OUTSIDE_ID;
    private MaterialBackOrchestrator backOrchestrator;
    private Sheet behavior;
    boolean cancelable;
    private boolean canceledOnTouchOutside;
    private boolean canceledOnTouchOutsideSet;
    private FrameLayout container;
    boolean dismissWithAnimation;
    private FrameLayout sheet;

    static {
        SheetDialog.COORDINATOR_LAYOUT_ID = id.coordinator;
        SheetDialog.TOUCH_OUTSIDE_ID = id.touch_outside;
    }

    SheetDialog(Context arg1, int arg2, int arg3, int arg4) {
        super(arg1, SheetDialog.getThemeResId(arg1, arg2, arg3, arg4));
        this.cancelable = true;
        this.canceledOnTouchOutside = true;
        this.supportRequestWindowFeature(1);
    }

    abstract void addSheetCancelOnHideCallback(Sheet arg1);

    public void cancel() {
        Sheet v0 = this.getBehavior();
        if(this.dismissWithAnimation) {
            int v2 = 5;
            if(v0.getState() == v2) {
            }
            else {
                v0.setState(v2);
                return;
            }
        }

        super.cancel();
    }

    private void ensureContainerAndBehavior() {
        if(this.container == null) {
            View v0 = View.inflate(this.getContext(), this.getLayoutResId(), null);
            this.container = ((FrameLayout)v0);
            v0 = ((FrameLayout)v0).findViewById(this.getDialogId());
            this.sheet = ((FrameLayout)v0);
            Sheet v0_1 = this.getBehaviorFromSheet(((FrameLayout)v0));
            this.behavior = v0_1;
            this.addSheetCancelOnHideCallback(v0_1);
            this.backOrchestrator = new MaterialBackOrchestrator(this.behavior, this.sheet);
        }
    }

    Sheet getBehavior() {
        if(this.behavior == null) {
            this.ensureContainerAndBehavior();
        }

        return this.behavior;
    }

    abstract Sheet getBehaviorFromSheet(FrameLayout arg1);

    private FrameLayout getContainer() {
        if(this.container == null) {
            this.ensureContainerAndBehavior();
        }

        return this.container;
    }

    abstract int getDialogId();

    abstract int getLayoutResId();

    private FrameLayout getSheet() {
        if(this.sheet == null) {
            this.ensureContainerAndBehavior();
        }

        return this.sheet;
    }

    abstract int getStateOnStart();

    private static int getThemeResId(Context arg1, int arg2, int arg3, int arg4) {
        if(arg2 == 0) {
            TypedValue v2 = new TypedValue();
            if(arg1.getTheme().resolveAttribute(arg3, v2, true)) {
                return v2.resourceId;
            }

            return arg4;
        }

        return arg2;
    }

    public boolean isDismissWithSheetAnimationEnabled() {
        return this.dismissWithAnimation;
    }

    void lambda$wrapInSheet$0$com-google-android-material-sidesheet-SheetDialog(View arg1) {
        if((this.cancelable) && (this.isShowing()) && (this.shouldWindowCloseOnTouchOutside())) {
            this.cancel();
        }
    }

    private void maybeUpdateWindowAnimationsBasedOnLayoutDirection() {
        Window v0 = this.getWindow();
        if(v0 != null) {
            FrameLayout v1 = this.sheet;
            if(v1 != null && ((v1.getLayoutParams() instanceof LayoutParams))) {
                int v2 = GravityCompat.getAbsoluteGravity(this.sheet.getLayoutParams().gravity, ViewCompat.getLayoutDirection(this.sheet)) == 3 ? style.Animation_Material3_SideSheetDialog_Left : style.Animation_Material3_SideSheetDialog_Right;
                v0.setWindowAnimations(v2);
            }
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.maybeUpdateWindowAnimationsBasedOnLayoutDirection();
        this.updateListeningForBackCallbacks();
    }

    protected void onCreate(Bundle arg1) {
        super.onCreate(arg1);
        Window v0 = this.getWindow();
        if(v0 != null) {
            v0.setStatusBarColor(0);
            v0.addFlags(0x80000000);
            v0.setLayout(-1, -1);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MaterialBackOrchestrator v0 = this.backOrchestrator;
        if(v0 != null) {
            v0.stopListeningForBackCallbacks();
        }
    }

    protected void onStart() {
        super.onStart();
        Sheet v0 = this.behavior;
        if(v0 != null && v0.getState() == 5) {
            this.behavior.setState(this.getStateOnStart());
        }
    }

    public void setCancelable(boolean arg2) {
        super.setCancelable(arg2);
        if(this.cancelable != arg2) {
            this.cancelable = arg2;
        }

        if(this.getWindow() != null) {
            this.updateListeningForBackCallbacks();
        }
    }

    public void setCanceledOnTouchOutside(boolean arg3) {
        super.setCanceledOnTouchOutside(arg3);
        if((arg3) && !this.cancelable) {
            this.cancelable = true;
        }

        this.canceledOnTouchOutside = arg3;
        this.canceledOnTouchOutsideSet = true;
    }

    public void setContentView(int arg2) {
        super.setContentView(this.wrapInSheet(arg2, null, null));
    }

    public void setContentView(View arg3) {
        super.setContentView(this.wrapInSheet(0, arg3, null));
    }

    public void setContentView(View arg2, ViewGroup$LayoutParams arg3) {
        super.setContentView(this.wrapInSheet(0, arg2, arg3));
    }

    public void setDismissWithSheetAnimationEnabled(boolean arg1) {
        this.dismissWithAnimation = arg1;
    }

    public void setSheetEdge(int arg3) {
        FrameLayout v0 = this.sheet;
        if(v0 != null) {
            if(!ViewCompat.isLaidOut(((View)v0))) {
                ViewGroup$LayoutParams v0_1 = this.sheet.getLayoutParams();
                if((v0_1 instanceof LayoutParams)) {
                    ((LayoutParams)v0_1).gravity = arg3;
                    this.maybeUpdateWindowAnimationsBasedOnLayoutDirection();
                }

                return;
            }

            throw new IllegalStateException("Sheet view has been laid out; sheet edge cannot be changed once the sheet has been laid out.");
        }

        throw new IllegalStateException("Sheet view reference is null; sheet edge cannot be changed if the sheet view is null.");
    }

    private boolean shouldWindowCloseOnTouchOutside() {
        if(!this.canceledOnTouchOutsideSet) {
            TypedArray v0 = this.getContext().obtainStyledAttributes(new int[]{0x101035B});
            this.canceledOnTouchOutside = v0.getBoolean(0, true);
            v0.recycle();
            this.canceledOnTouchOutsideSet = true;
        }

        return this.canceledOnTouchOutside;
    }

    private void updateListeningForBackCallbacks() {
        MaterialBackOrchestrator v0 = this.backOrchestrator;
        if(v0 == null) {
            return;
        }

        if(this.cancelable) {
            v0.startListeningForBackCallbacks();
            return;
        }

        v0.stopListeningForBackCallbacks();
    }

    private View wrapInSheet(int arg3, View arg4, ViewGroup$LayoutParams arg5) {
        this.ensureContainerAndBehavior();
        View v0 = this.getContainer().findViewById(SheetDialog.COORDINATOR_LAYOUT_ID);
        if(arg3 != 0 && arg4 == null) {
            arg4 = this.getLayoutInflater().inflate(arg3, ((ViewGroup)v0), false);
        }

        FrameLayout v3 = this.getSheet();
        v3.removeAllViews();
        if(arg5 == null) {
            v3.addView(arg4);
        }
        else {
            v3.addView(arg4, arg5);
        }

        ((CoordinatorLayout)v0).findViewById(SheetDialog.TOUCH_OUTSIDE_ID).setOnClickListener(new SheetDialog$$ExternalSyntheticLambda0(this));
        ViewCompat.setAccessibilityDelegate(this.getSheet(), new AccessibilityDelegateCompat() {
            public void onInitializeAccessibilityNodeInfo(View arg1, AccessibilityNodeInfoCompat arg2) {
                super.onInitializeAccessibilityNodeInfo(arg1, arg2);
                if(SheetDialog.this.cancelable) {
                    arg2.addAction(0x100000);
                    arg2.setDismissable(true);
                    return;
                }

                arg2.setDismissable(false);
            }

            public boolean performAccessibilityAction(View arg2, int arg3, Bundle arg4) {
                if(arg3 == 0x100000 && (SheetDialog.this.cancelable)) {
                    SheetDialog.this.cancel();
                    return 1;
                }

                return super.performAccessibilityAction(arg2, arg3, arg4);
            }
        });
        return this.container;
    }
}

