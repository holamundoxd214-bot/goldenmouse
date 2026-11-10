package com.google.android.material.bottomsheet;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager$AccessibilityStateChangeListener;
import android.view.accessibility.AccessibilityManager;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityActionCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand$CommandArguments;
import com.google.android.material.R$attr;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

public class BottomSheetDragHandleView extends AppCompatImageView implements AccessibilityManager$AccessibilityStateChangeListener {
    class com.google.android.material.bottomsheet.BottomSheetDragHandleView$1 extends BottomSheetCallback {
        com.google.android.material.bottomsheet.BottomSheetDragHandleView$1(BottomSheetDragHandleView arg1) {
            BottomSheetDragHandleView.this = arg1;
            super();
        }

        public void onSlide(View arg1, float arg2) {
        }

        public void onStateChanged(View arg1, int arg2) {
            BottomSheetDragHandleView.this.onBottomSheetStateChanged(arg2);
        }
    }

    private static final int DEF_STYLE_RES;
    private final AccessibilityManager accessibilityManager;
    private boolean accessibilityServiceEnabled;
    private BottomSheetBehavior bottomSheetBehavior;
    private final BottomSheetCallback bottomSheetCallback;
    private final String clickFeedback;
    private final String clickToCollapseActionLabel;
    private boolean clickToExpand;
    private final String clickToExpandActionLabel;
    private boolean interactable;

    static {
        BottomSheetDragHandleView.DEF_STYLE_RES = style.Widget_Material3_BottomSheet_DragHandle;
    }

    public BottomSheetDragHandleView(Context arg2) {
        this(arg2, null);
    }

    public BottomSheetDragHandleView(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, attr.bottomSheetDragHandleStyle);
    }

    public BottomSheetDragHandleView(Context arg2, AttributeSet arg3, int arg4) {
        super(MaterialThemeOverlay.wrap(arg2, arg3, arg4, BottomSheetDragHandleView.DEF_STYLE_RES), arg3, arg4);
        this.clickToExpandActionLabel = this.getResources().getString(string.bottomsheet_action_expand);
        this.clickToCollapseActionLabel = this.getResources().getString(string.bottomsheet_action_collapse);
        this.clickFeedback = this.getResources().getString(string.bottomsheet_drag_handle_clicked);
        this.bottomSheetCallback = new com.google.android.material.bottomsheet.BottomSheetDragHandleView$1(this);
        this.accessibilityManager = this.getContext().getSystemService("accessibility");
        this.updateInteractableState();
        ViewCompat.setAccessibilityDelegate(((View)this), new AccessibilityDelegateCompat() {
            public void onPopulateAccessibilityEvent(View arg1, AccessibilityEvent arg2) {
                super.onPopulateAccessibilityEvent(arg1, arg2);
                if(arg2.getEventType() == 1) {
                    BottomSheetDragHandleView.access$100(BottomSheetDragHandleView.this);
                }
            }
        });
    }

    static void access$000(BottomSheetDragHandleView arg0, int arg1) {
        arg0.onBottomSheetStateChanged(arg1);
    }

    static boolean access$100(BottomSheetDragHandleView arg0) {
        return arg0.expandOrCollapseBottomSheetIfPossible();
    }

    private void announceAccessibilityEvent(String arg3) {
        if(this.accessibilityManager == null) {
            return;
        }

        AccessibilityEvent v0 = AccessibilityEvent.obtain(0x4000);
        v0.getText().add(arg3);
        this.accessibilityManager.sendAccessibilityEvent(v0);
    }

    private boolean expandOrCollapseBottomSheetIfPossible() {
        int v1 = 0;
        if(!this.interactable) {
            return 0;
        }

        this.announceAccessibilityEvent(this.clickFeedback);
        if(!this.bottomSheetBehavior.isFitToContents() && !this.bottomSheetBehavior.shouldSkipHalfExpandedStateWhenDragging()) {
            v1 = 1;
        }

        int v0 = this.bottomSheetBehavior.getState();
        int v3 = 6;
        int v4 = 3;
        int v5 = 4;
        if(v0 == v5) {
            if(v1 != 0) {
            }
            else {
                goto label_31;
            }
        }
        else if(v0 == v4) {
            if(v1 != 0) {
            }
            else {
                v3 = v5;
            }
        }
        else if(this.clickToExpand) {
            goto label_31;
        }
        else {
            v4 = v5;
        label_31:
            v3 = v4;
        }

        this.bottomSheetBehavior.setState(v3);
        return 1;
    }

    private BottomSheetBehavior findParentBottomSheetBehavior() {
        Behavior v0_1;
        do {
        label_0:
            View v2 = BottomSheetDragHandleView.getParentView(v2);
            if(v2 == null) {
                return null;
            }

            ViewGroup$LayoutParams v0 = v2.getLayoutParams();
            if(!(v0 instanceof LayoutParams)) {
                goto label_0;
            }

            v0_1 = ((LayoutParams)v0).getBehavior();
        }
        while(!(v0_1 instanceof BottomSheetBehavior));

        return ((BottomSheetBehavior)v0_1);
    }

    private static View getParentView(View arg1) {
        ViewParent v1 = arg1.getParent();
        if((v1 instanceof View)) {
            return ((View)v1);
        }

        return null;
    }

    boolean lambda$onBottomSheetStateChanged$0$com-google-android-material-bottomsheet-BottomSheetDragHandleView(View arg1, CommandArguments arg2) {
        return this.expandOrCollapseBottomSheetIfPossible();
    }

    public void onAccessibilityStateChanged(boolean arg1) {
        this.accessibilityServiceEnabled = arg1;
        this.updateInteractableState();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.setBottomSheetBehavior(this.findParentBottomSheetBehavior());
        AccessibilityManager v0 = this.accessibilityManager;
        if(v0 != null) {
            v0.addAccessibilityStateChangeListener(((AccessibilityManager$AccessibilityStateChangeListener)this));
            this.onAccessibilityStateChanged(this.accessibilityManager.isEnabled());
        }
    }

    private void onBottomSheetStateChanged(int arg3) {
        if(arg3 == 4) {
            this.clickToExpand = true;
        }
        else if(arg3 == 3) {
            this.clickToExpand = false;
        }

        AccessibilityActionCompat v3 = AccessibilityActionCompat.ACTION_CLICK;
        String v0 = this.clickToExpand ? this.clickToExpandActionLabel : this.clickToCollapseActionLabel;
        ViewCompat.replaceAccessibilityAction(((View)this), v3, ((CharSequence)v0), new BottomSheetDragHandleView$$ExternalSyntheticLambda0(this));
    }

    protected void onDetachedFromWindow() {
        AccessibilityManager v0 = this.accessibilityManager;
        if(v0 != null) {
            v0.removeAccessibilityStateChangeListener(((AccessibilityManager$AccessibilityStateChangeListener)this));
        }

        this.setBottomSheetBehavior(null);
        super.onDetachedFromWindow();
    }

    private void setBottomSheetBehavior(BottomSheetBehavior arg3) {
        BottomSheetBehavior v0 = this.bottomSheetBehavior;
        if(v0 != null) {
            v0.removeBottomSheetCallback(this.bottomSheetCallback);
            this.bottomSheetBehavior.setAccessibilityDelegateView(null);
        }

        this.bottomSheetBehavior = arg3;
        if(arg3 != null) {
            arg3.setAccessibilityDelegateView(((View)this));
            this.onBottomSheetStateChanged(this.bottomSheetBehavior.getState());
            this.bottomSheetBehavior.addBottomSheetCallback(this.bottomSheetCallback);
        }

        this.updateInteractableState();
    }

    private void updateInteractableState() {
        int v1 = 1;
        boolean v0 = !this.accessibilityServiceEnabled || this.bottomSheetBehavior == null ? false : true;
        this.interactable = v0;
        if(this.bottomSheetBehavior != null) {
        }
        else {
            v1 = 2;
        }

        ViewCompat.setImportantForAccessibility(((View)this), v1);
        this.setClickable(this.interactable);
    }
}

