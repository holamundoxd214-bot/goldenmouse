package com.google.android.material.bottomsheet;

import android.content.Context;
import android.content.DialogInterface$OnCancelListener;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View$OnClickListener;
import android.view.View$OnTouchListener;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatDialog;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$style;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.EdgeToEdgeUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.motion.MaterialBackOrchestrator;
import com.google.android.material.shape.MaterialShapeDrawable;

public class BottomSheetDialog extends AppCompatDialog {
    class com.google.android.material.bottomsheet.BottomSheetDialog$5 extends BottomSheetCallback {
        com.google.android.material.bottomsheet.BottomSheetDialog$5(BottomSheetDialog arg1) {
            BottomSheetDialog.this = arg1;
            super();
        }

        public void onSlide(View arg1, float arg2) {
        }

        public void onStateChanged(View arg1, int arg2) {
            if(arg2 == 5) {
                BottomSheetDialog.this.cancel();
            }
        }
    }

    class EdgeToEdgeCallback extends BottomSheetCallback {
        private final WindowInsetsCompat insetsCompat;
        private final Boolean lightBottomSheet;
        private boolean lightStatusBar;
        private Window window;

        EdgeToEdgeCallback(View arg1, WindowInsetsCompat arg2, com.google.android.material.bottomsheet.BottomSheetDialog$1 arg3) {
            this(arg1, arg2);
        }

        private EdgeToEdgeCallback(View arg1, WindowInsetsCompat arg2) {
            super();
            this.insetsCompat = arg2;
            MaterialShapeDrawable v2 = BottomSheetBehavior.from(arg1).getMaterialShapeDrawable();
            ColorStateList v2_1 = v2 != null ? v2.getFillColor() : ViewCompat.getBackgroundTintList(arg1);
            if(v2_1 != null) {
                this.lightBottomSheet = Boolean.valueOf(MaterialColors.isColorLight(v2_1.getDefaultColor()));
                return;
            }

            Integer v1 = ViewUtils.getBackgroundColor(arg1);
            if(v1 != null) {
                this.lightBottomSheet = Boolean.valueOf(MaterialColors.isColorLight(v1.intValue()));
                return;
            }

            this.lightBottomSheet = null;
        }

        void onLayout(View arg1) {
            this.setPaddingForPosition(arg1);
        }

        public void onSlide(View arg1, float arg2) {
            this.setPaddingForPosition(arg1);
        }

        public void onStateChanged(View arg1, int arg2) {
            this.setPaddingForPosition(arg1);
        }

        private void setPaddingForPosition(View arg4) {
            Window v0;
            if(arg4.getTop() < this.insetsCompat.getSystemWindowInsetTop()) {
                v0 = this.window;
                if(v0 != null) {
                    Boolean v1 = this.lightBottomSheet;
                    boolean v1_1 = v1 == null ? this.lightStatusBar : v1.booleanValue();
                    EdgeToEdgeUtils.setLightStatusBar(v0, v1_1);
                }

                arg4.setPadding(arg4.getPaddingLeft(), this.insetsCompat.getSystemWindowInsetTop() - arg4.getTop(), arg4.getPaddingRight(), arg4.getPaddingBottom());
                return;
            }

            if(arg4.getTop() != 0) {
                v0 = this.window;
                if(v0 != null) {
                    EdgeToEdgeUtils.setLightStatusBar(v0, this.lightStatusBar);
                }

                arg4.setPadding(arg4.getPaddingLeft(), 0, arg4.getPaddingRight(), arg4.getPaddingBottom());
            }
        }

        void setWindow(Window arg2) {
            if(this.window == arg2) {
            }
            else {
                this.window = arg2;
                if(arg2 != null) {
                    this.lightStatusBar = WindowCompat.getInsetsController(arg2, arg2.getDecorView()).isAppearanceLightStatusBars();
                }
            }
        }
    }

    private MaterialBackOrchestrator backOrchestrator;
    private BottomSheetBehavior behavior;
    private FrameLayout bottomSheet;
    private BottomSheetCallback bottomSheetCallback;
    boolean cancelable;
    private boolean canceledOnTouchOutside;
    private boolean canceledOnTouchOutsideSet;
    private FrameLayout container;
    private CoordinatorLayout coordinator;
    boolean dismissWithAnimation;
    private EdgeToEdgeCallback edgeToEdgeCallback;
    private boolean edgeToEdgeEnabled;

    public BottomSheetDialog(Context arg3) {
        this(arg3, 0);
        this.edgeToEdgeEnabled = this.getContext().getTheme().obtainStyledAttributes(new int[]{attr.enableEdgeToEdge}).getBoolean(0, false);
    }

    public BottomSheetDialog(Context arg1, int arg2) {
        super(arg1, BottomSheetDialog.getThemeResId(arg1, arg2));
        this.cancelable = true;
        this.canceledOnTouchOutside = true;
        this.bottomSheetCallback = new com.google.android.material.bottomsheet.BottomSheetDialog$5(this);
        this.supportRequestWindowFeature(1);
        this.edgeToEdgeEnabled = this.getContext().getTheme().obtainStyledAttributes(new int[]{attr.enableEdgeToEdge}).getBoolean(0, false);
    }

    protected BottomSheetDialog(Context arg1, boolean arg2, DialogInterface$OnCancelListener arg3) {
        super(arg1, arg2, arg3);
        this.cancelable = true;
        this.canceledOnTouchOutside = true;
        this.bottomSheetCallback = new com.google.android.material.bottomsheet.BottomSheetDialog$5(this);
        this.supportRequestWindowFeature(1);
        this.cancelable = arg2;
        this.edgeToEdgeEnabled = this.getContext().getTheme().obtainStyledAttributes(new int[]{attr.enableEdgeToEdge}).getBoolean(0, false);
    }

    static EdgeToEdgeCallback access$000(BottomSheetDialog arg0) {
        return arg0.edgeToEdgeCallback;
    }

    static EdgeToEdgeCallback access$002(BottomSheetDialog arg0, EdgeToEdgeCallback arg1) {
        arg0.edgeToEdgeCallback = arg1;
        return arg1;
    }

    static BottomSheetBehavior access$100(BottomSheetDialog arg0) {
        return arg0.behavior;
    }

    static FrameLayout access$200(BottomSheetDialog arg0) {
        return arg0.bottomSheet;
    }

    public void cancel() {
        BottomSheetBehavior v0 = this.getBehavior();
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

    private FrameLayout ensureContainerAndBehavior() {
        if(this.container == null) {
            View v0 = View.inflate(this.getContext(), layout.design_bottom_sheet_dialog, null);
            this.container = ((FrameLayout)v0);
            this.coordinator = ((FrameLayout)v0).findViewById(id.coordinator);
            v0 = this.container.findViewById(id.design_bottom_sheet);
            this.bottomSheet = ((FrameLayout)v0);
            BottomSheetBehavior v0_1 = BottomSheetBehavior.from(v0);
            this.behavior = v0_1;
            v0_1.addBottomSheetCallback(this.bottomSheetCallback);
            this.behavior.setHideable(this.cancelable);
            this.backOrchestrator = new MaterialBackOrchestrator(this.behavior, this.bottomSheet);
        }

        return this.container;
    }

    public BottomSheetBehavior getBehavior() {
        if(this.behavior == null) {
            this.ensureContainerAndBehavior();
        }

        return this.behavior;
    }

    public boolean getDismissWithAnimation() {
        return this.dismissWithAnimation;
    }

    public boolean getEdgeToEdgeEnabled() {
        return this.edgeToEdgeEnabled;
    }

    private static int getThemeResId(Context arg2, int arg3) {
        if(arg3 == 0) {
            TypedValue v3 = new TypedValue();
            if(arg2.getTheme().resolveAttribute(attr.bottomSheetDialogTheme, v3, true)) {
                return v3.resourceId;
            }

            return style.Theme_Design_Light_BottomSheetDialog;
        }

        return arg3;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window v0 = this.getWindow();
        if(v0 != null) {
            int v1 = !this.edgeToEdgeEnabled || Color.alpha(v0.getNavigationBarColor()) >= 0xFF ? 0 : 1;
            FrameLayout v3 = this.container;
            if(v3 != null) {
                v3.setFitsSystemWindows(v1 ^ 1);
            }

            CoordinatorLayout v3_1 = this.coordinator;
            if(v3_1 != null) {
                v3_1.setFitsSystemWindows(v1 ^ 1);
            }

            WindowCompat.setDecorFitsSystemWindows(v0, v1 ^ 1);
            EdgeToEdgeCallback v1_1 = this.edgeToEdgeCallback;
            if(v1_1 == null) {
                goto label_26;
            }

            v1_1.setWindow(v0);
        }

    label_26:
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
        EdgeToEdgeCallback v0 = this.edgeToEdgeCallback;
        if(v0 != null) {
            v0.setWindow(null);
        }

        MaterialBackOrchestrator v2 = this.backOrchestrator;
        if(v2 != null) {
            v2.stopListeningForBackCallbacks();
        }
    }

    protected void onStart() {
        super.onStart();
        BottomSheetBehavior v0 = this.behavior;
        if(v0 != null && v0.getState() == 5) {
            this.behavior.setState(4);
        }
    }

    void removeDefaultCallback() {
        this.behavior.removeBottomSheetCallback(this.bottomSheetCallback);
    }

    public void setCancelable(boolean arg2) {
        super.setCancelable(arg2);
        if(this.cancelable != arg2) {
            this.cancelable = arg2;
            BottomSheetBehavior v0 = this.behavior;
            if(v0 != null) {
                v0.setHideable(arg2);
            }

            if(this.getWindow() == null) {
                return;
            }

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
        super.setContentView(this.wrapInBottomSheet(arg2, null, null));
    }

    public void setContentView(View arg3) {
        super.setContentView(this.wrapInBottomSheet(0, arg3, null));
    }

    public void setContentView(View arg2, ViewGroup$LayoutParams arg3) {
        super.setContentView(this.wrapInBottomSheet(0, arg2, arg3));
    }

    public void setDismissWithAnimation(boolean arg1) {
        this.dismissWithAnimation = arg1;
    }

    @Deprecated public static void setLightStatusBar(View arg1, boolean arg2) {
        int v0 = arg1.getSystemUiVisibility();
        int v2 = arg2 ? v0 | 0x2000 : v0 & 0xFFFFDFFF;
        arg1.setSystemUiVisibility(v2);
    }

    boolean shouldWindowCloseOnTouchOutside() {
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

    private View wrapInBottomSheet(int arg3, View arg4, ViewGroup$LayoutParams arg5) {
        this.ensureContainerAndBehavior();
        View v0 = this.container.findViewById(id.coordinator);
        if(arg3 != 0 && arg4 == null) {
            arg4 = this.getLayoutInflater().inflate(arg3, ((ViewGroup)v0), false);
        }

        if(this.edgeToEdgeEnabled) {
            ViewCompat.setOnApplyWindowInsetsListener(this.bottomSheet, new OnApplyWindowInsetsListener() {
                public WindowInsetsCompat onApplyWindowInsets(View arg4, WindowInsetsCompat arg5) {
                    if(BottomSheetDialog.this.edgeToEdgeCallback != null) {
                        BottomSheetDialog.this.behavior.removeBottomSheetCallback(BottomSheetDialog.this.edgeToEdgeCallback);
                    }

                    if(arg5 != null) {
                        BottomSheetDialog.this.edgeToEdgeCallback = new EdgeToEdgeCallback(BottomSheetDialog.this.bottomSheet, arg5, null);
                        BottomSheetDialog.this.edgeToEdgeCallback.setWindow(BottomSheetDialog.this.getWindow());
                        BottomSheetDialog.this.behavior.addBottomSheetCallback(BottomSheetDialog.this.edgeToEdgeCallback);
                    }

                    return arg5;
                }
            });
        }

        this.bottomSheet.removeAllViews();
        FrameLayout v3 = this.bottomSheet;
        if(arg5 == null) {
            v3.addView(arg4);
        }
        else {
            v3.addView(arg4, arg5);
        }

        ((CoordinatorLayout)v0).findViewById(id.touch_outside).setOnClickListener(new View$OnClickListener() {
            public void onClick(View arg1) {
                if((BottomSheetDialog.this.cancelable) && (BottomSheetDialog.this.isShowing()) && (BottomSheetDialog.this.shouldWindowCloseOnTouchOutside())) {
                    BottomSheetDialog.this.cancel();
                }
            }
        });
        ViewCompat.setAccessibilityDelegate(this.bottomSheet, new AccessibilityDelegateCompat() {
            public void onInitializeAccessibilityNodeInfo(View arg1, AccessibilityNodeInfoCompat arg2) {
                super.onInitializeAccessibilityNodeInfo(arg1, arg2);
                if(BottomSheetDialog.this.cancelable) {
                    arg2.addAction(0x100000);
                    arg2.setDismissable(true);
                    return;
                }

                arg2.setDismissable(false);
            }

            public boolean performAccessibilityAction(View arg2, int arg3, Bundle arg4) {
                if(arg3 == 0x100000 && (BottomSheetDialog.this.cancelable)) {
                    BottomSheetDialog.this.cancel();
                    return 1;
                }

                return super.performAccessibilityAction(arg2, arg3, arg4);
            }
        });
        this.bottomSheet.setOnTouchListener(new View$OnTouchListener() {
            public boolean onTouch(View arg1, MotionEvent arg2) {
                return 1;
            }
        });
        return this.container;
    }
}

