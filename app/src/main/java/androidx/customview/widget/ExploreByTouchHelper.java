package androidx.customview.widget;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityRecord;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import java.util.ArrayList;
import java.util.List;

public abstract class ExploreByTouchHelper extends AccessibilityDelegateCompat {
    class androidx.customview.widget.ExploreByTouchHelper$1 implements BoundsAdapter {
        androidx.customview.widget.ExploreByTouchHelper$1() {
            super();
        }

        public void obtainBounds(AccessibilityNodeInfoCompat arg1, Rect arg2) {
            arg1.getBoundsInParent(arg2);
        }

        public void obtainBounds(Object arg1, Rect arg2) {
            this.obtainBounds(((AccessibilityNodeInfoCompat)arg1), arg2);
        }
    }

    class androidx.customview.widget.ExploreByTouchHelper$2 implements CollectionAdapter {
        androidx.customview.widget.ExploreByTouchHelper$2() {
            super();
        }

        public AccessibilityNodeInfoCompat get(SparseArrayCompat arg1, int arg2) {
            return arg1.valueAt(arg2);
        }

        public Object get(Object arg1, int arg2) {
            return this.get(((SparseArrayCompat)arg1), arg2);
        }

        public int size(SparseArrayCompat arg1) {
            return arg1.size();
        }

        public int size(Object arg1) {
            return this.size(((SparseArrayCompat)arg1));
        }
    }

    class MyNodeProvider extends AccessibilityNodeProviderCompat {
        MyNodeProvider(ExploreByTouchHelper arg1) {
            ExploreByTouchHelper.this = arg1;
            super();
        }

        public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int arg1) {
            return AccessibilityNodeInfoCompat.obtain(ExploreByTouchHelper.this.obtainAccessibilityNodeInfo(arg1));
        }

        public AccessibilityNodeInfoCompat findFocus(int arg3) {
            ExploreByTouchHelper v0 = ExploreByTouchHelper.this;
            arg3 = arg3 == 2 ? v0.mAccessibilityFocusedVirtualViewId : v0.mKeyboardFocusedVirtualViewId;
            if(arg3 == 0x80000000) {
                return null;
            }

            return this.createAccessibilityNodeInfo(arg3);
        }

        public boolean performAction(int arg1, int arg2, Bundle arg3) {
            return ExploreByTouchHelper.this.performAction(arg1, arg2, arg3);
        }
    }

    private static final String DEFAULT_CLASS_NAME = "android.view.View";
    public static final int HOST_ID = -1;
    public static final int INVALID_ID = 0x80000000;
    private static final Rect INVALID_PARENT_BOUNDS;
    private static final BoundsAdapter NODE_ADAPTER;
    private static final CollectionAdapter SPARSE_VALUES_ADAPTER;
    int mAccessibilityFocusedVirtualViewId;
    private final View mHost;
    private int mHoveredVirtualViewId;
    int mKeyboardFocusedVirtualViewId;
    private final AccessibilityManager mManager;
    private MyNodeProvider mNodeProvider;
    private final int[] mTempGlobalRect;
    private final Rect mTempParentRect;
    private final Rect mTempScreenRect;
    private final Rect mTempVisibleRect;

    static {
        ExploreByTouchHelper.INVALID_PARENT_BOUNDS = new Rect(0x7FFFFFFF, 0x7FFFFFFF, 0x80000000, 0x80000000);
        ExploreByTouchHelper.NODE_ADAPTER = new androidx.customview.widget.ExploreByTouchHelper$1();
        ExploreByTouchHelper.SPARSE_VALUES_ADAPTER = new androidx.customview.widget.ExploreByTouchHelper$2();
    }

    public ExploreByTouchHelper(View arg3) {
        super();
        this.mTempScreenRect = new Rect();
        this.mTempParentRect = new Rect();
        this.mTempVisibleRect = new Rect();
        this.mTempGlobalRect = new int[2];
        this.mAccessibilityFocusedVirtualViewId = 0x80000000;
        this.mKeyboardFocusedVirtualViewId = 0x80000000;
        this.mHoveredVirtualViewId = 0x80000000;
        if(arg3 != null) {
            this.mHost = arg3;
            this.mManager = arg3.getContext().getSystemService("accessibility");
            arg3.setFocusable(true);
            if(ViewCompat.getImportantForAccessibility(arg3) == 0) {
                ViewCompat.setImportantForAccessibility(arg3, 1);
            }

            return;
        }

        throw new IllegalArgumentException("View may not be null");
    }

    private boolean clearAccessibilityFocus(int arg2) {
        if(this.mAccessibilityFocusedVirtualViewId == arg2) {
            this.mAccessibilityFocusedVirtualViewId = 0x80000000;
            this.mHost.invalidate();
            this.sendEventForVirtualView(arg2, 0x10000);
            return 1;
        }

        return 0;
    }

    public final boolean clearKeyboardFocusForVirtualView(int arg3) {
        if(this.mKeyboardFocusedVirtualViewId != arg3) {
            return 0;
        }

        this.mKeyboardFocusedVirtualViewId = 0x80000000;
        this.onVirtualViewKeyboardFocusChanged(arg3, false);
        this.sendEventForVirtualView(arg3, 8);
        return 1;
    }

    private boolean clickKeyboardFocusedVirtualView() {
        int v0 = this.mKeyboardFocusedVirtualViewId;
        if(v0 != 0x80000000 && (this.onPerformActionForVirtualView(v0, 16, null))) {
            return 1;
        }

        return 0;
    }

    private AccessibilityEvent createEvent(int arg2, int arg3) {
        if(arg2 != -1) {
            return this.createEventForChild(arg2, arg3);
        }

        return this.createEventForHost(arg3);
    }

    private AccessibilityEvent createEventForChild(int arg4, int arg5) {
        AccessibilityEvent v5 = AccessibilityEvent.obtain(arg5);
        AccessibilityNodeInfoCompat v0 = this.obtainAccessibilityNodeInfo(arg4);
        v5.getText().add(v0.getText());
        v5.setContentDescription(v0.getContentDescription());
        v5.setScrollable(v0.isScrollable());
        v5.setPassword(v0.isPassword());
        v5.setEnabled(v0.isEnabled());
        v5.setChecked(v0.isChecked());
        this.onPopulateEventForVirtualView(arg4, v5);
        if(v5.getText().isEmpty()) {
            if(v5.getContentDescription() != null) {
            }
            else {
                throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
            }
        }

        v5.setClassName(v0.getClassName());
        AccessibilityRecordCompat.setSource(((AccessibilityRecord)v5), this.mHost, arg4);
        v5.setPackageName(this.mHost.getContext().getPackageName());
        return v5;
    }

    private AccessibilityEvent createEventForHost(int arg1) {
        AccessibilityEvent v1 = AccessibilityEvent.obtain(arg1);
        this.mHost.onInitializeAccessibilityEvent(v1);
        return v1;
    }

    private AccessibilityNodeInfoCompat createNodeForChild(int arg8) {
        AccessibilityNodeInfoCompat v0 = AccessibilityNodeInfoCompat.obtain();
        v0.setEnabled(true);
        v0.setFocusable(true);
        v0.setClassName("android.view.View");
        Rect v2 = ExploreByTouchHelper.INVALID_PARENT_BOUNDS;
        v0.setBoundsInParent(v2);
        v0.setBoundsInScreen(v2);
        v0.setParent(this.mHost);
        this.onPopulateNodeForVirtualView(arg8, v0);
        if(v0.getText() == null) {
            if(v0.getContentDescription() != null) {
            }
            else {
                throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
            }
        }

        v0.getBoundsInParent(this.mTempParentRect);
        if(!this.mTempParentRect.equals(v2)) {
            int v3 = v0.getActions();
            if((v3 & 0x40) == 0) {
                int v4 = 0x80;
                if((v3 & v4) == 0) {
                    v0.setPackageName(this.mHost.getContext().getPackageName());
                    v0.setSource(this.mHost, arg8);
                    if(this.mAccessibilityFocusedVirtualViewId == arg8) {
                        v0.setAccessibilityFocused(true);
                        v0.addAction(v4);
                    }
                    else {
                        v0.setAccessibilityFocused(false);
                        v0.addAction(0x40);
                    }

                    boolean v8 = this.mKeyboardFocusedVirtualViewId == arg8 ? true : false;
                    if(v8) {
                        v0.addAction(2);
                    }
                    else if(v0.isFocusable()) {
                        v0.addAction(1);
                    }

                    v0.setFocused(v8);
                    this.mHost.getLocationOnScreen(this.mTempGlobalRect);
                    v0.getBoundsInScreen(this.mTempScreenRect);
                    if(this.mTempScreenRect.equals(v2)) {
                        v0.getBoundsInParent(this.mTempScreenRect);
                        int v2_1 = -1;
                        if(v0.mParentVirtualDescendantId != v2_1) {
                            AccessibilityNodeInfoCompat v8_1 = AccessibilityNodeInfoCompat.obtain();
                            for(v3 = v0.mParentVirtualDescendantId; v3 != v2_1; v3 = v8_1.mParentVirtualDescendantId) {
                                v8_1.setParent(this.mHost, v2_1);
                                v8_1.setBoundsInParent(ExploreByTouchHelper.INVALID_PARENT_BOUNDS);
                                this.onPopulateNodeForVirtualView(v3, v8_1);
                                v8_1.getBoundsInParent(this.mTempParentRect);
                                this.mTempScreenRect.offset(this.mTempParentRect.left, this.mTempParentRect.top);
                            }

                            v8_1.recycle();
                        }

                        this.mTempScreenRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
                    }

                    if(this.mHost.getLocalVisibleRect(this.mTempVisibleRect)) {
                        this.mTempVisibleRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
                        if(this.mTempScreenRect.intersect(this.mTempVisibleRect)) {
                            v0.setBoundsInScreen(this.mTempScreenRect);
                            if(this.isVisibleToUser(this.mTempScreenRect)) {
                                v0.setVisibleToUser(true);
                            }
                        }
                    }

                    return v0;
                }

                throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            }

            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }

        throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
    }

    private AccessibilityNodeInfoCompat createNodeForHost() {
        AccessibilityNodeInfoCompat v0 = AccessibilityNodeInfoCompat.obtain(this.mHost);
        ViewCompat.onInitializeAccessibilityNodeInfo(this.mHost, v0);
        ArrayList v1 = new ArrayList();
        this.getVisibleVirtualViews(((List)v1));
        if(v0.getChildCount() > 0) {
            if(v1.size() <= 0) {
            }
            else {
                throw new RuntimeException("Views cannot have both real and virtual children");
            }
        }

        int v2 = v1.size();
        int v3;
        for(v3 = 0; v3 < v2; ++v3) {
            v0.addChild(this.mHost, v1.get(v3).intValue());
        }

        return v0;
    }

    public final boolean dispatchHoverEvent(MotionEvent arg6) {
        if(this.mManager.isEnabled()) {
            if(!this.mManager.isTouchExplorationEnabled()) {
            }
            else {
                int v0 = arg6.getAction();
                int v4 = 0x80000000;
                if(v0 != 7 && v0 != 9) {
                    if(v0 != 10) {
                        return 0;
                    }
                    else if(this.mHoveredVirtualViewId != v4) {
                        this.updateHoveredVirtualView(v4);
                        return 1;
                    }
                    else {
                        return 0;
                    }
                }

                int v6 = this.getVirtualViewAt(arg6.getX(), arg6.getY());
                this.updateHoveredVirtualView(v6);
                if(v6 == v4) {
                    return 0;
                }

                return 1;
            }
        }

        return 0;
    }

    public final boolean dispatchKeyEvent(KeyEvent arg7) {
        int v1 = 0;
        if(arg7.getAction() != 1) {
            int v0 = arg7.getKeyCode();
            Rect v4 = null;
            if(v0 != 61) {
                if(v0 != 66) {
                    switch(v0) {
                        case 19: 
                        case 20: 
                        case 21: 
                        case 22: {
                            goto label_12;
                        }
                        case 23: {
                            goto label_25;
                        }
                    }

                    return 0;
                label_12:
                    if(arg7.hasNoModifiers()) {
                        v0 = ExploreByTouchHelper.keyToDirection(v0);
                        int v7 = arg7.getRepeatCount() + 1;
                        boolean v3;
                        for(v3 = false; v1 < v7; v3 = true) {
                            if(!this.moveFocus(v0, v4)) {
                                return v3;
                            }

                            ++v1;
                        }

                        return v3;
                    }
                    else {
                        return 0;
                    }
                }

            label_25:
                if(!arg7.hasNoModifiers()) {
                    return 0;
                }

                if(arg7.getRepeatCount() != 0) {
                    return 0;
                }

                this.clickKeyboardFocusedVirtualView();
                return 1;
            }
            else {
                if(arg7.hasNoModifiers()) {
                    return this.moveFocus(2, v4);
                }

                if(!arg7.hasModifiers(1)) {
                    return 0;
                }

                return this.moveFocus(1, v4);
            }
        }

        return 0;
    }

    public final int getAccessibilityFocusedVirtualViewId() {
        return this.mAccessibilityFocusedVirtualViewId;
    }

    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View arg1) {
        MyNodeProvider v1 = this.mNodeProvider;
        if(v1 == null) {
            v1 = new MyNodeProvider(this);
            this.mNodeProvider = v1;
        }

        return ((AccessibilityNodeProviderCompat)v1);
    }

    private SparseArrayCompat getAllNodes() {
        ArrayList v0 = new ArrayList();
        this.getVisibleVirtualViews(((List)v0));
        SparseArrayCompat v1 = new SparseArrayCompat();
        int v2;
        for(v2 = 0; v2 < ((List)v0).size(); ++v2) {
            v1.put(((List)v0).get(v2).intValue(), this.createNodeForChild(((List)v0).get(v2).intValue()));
        }

        return v1;
    }

    private void getBoundsInParent(int arg1, Rect arg2) {
        this.obtainAccessibilityNodeInfo(arg1).getBoundsInParent(arg2);
    }

    @Deprecated public int getFocusedVirtualView() {
        return this.getAccessibilityFocusedVirtualViewId();
    }

    public final int getKeyboardFocusedVirtualViewId() {
        return this.mKeyboardFocusedVirtualViewId;
    }

    protected abstract int getVirtualViewAt(float arg1, float arg2);

    protected abstract void getVisibleVirtualViews(List arg1);

    private static Rect guessPreviouslyFocusedRect(View arg4, int arg5, Rect arg6) {
        int v0 = arg4.getWidth();
        int v4 = arg4.getHeight();
        if(arg5 != 17) {
            if(arg5 != 33) {
                int v3 = -1;
                if(arg5 != 66) {
                    if(arg5 == 130) {
                        arg6.set(0, v3, v0, v3);
                        return arg6;
                    }

                    throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                }

                arg6.set(v3, 0, v3, v4);
                return arg6;
            }

            arg6.set(0, v4, v0, v4);
            return arg6;
        }

        arg6.set(v0, 0, v0, v4);
        return arg6;
    }

    public final void invalidateRoot() {
        this.invalidateVirtualView(-1, 1);
    }

    public final void invalidateVirtualView(int arg3, int arg4) {
        if(arg3 != 0x80000000 && (this.mManager.isEnabled())) {
            ViewParent v0 = this.mHost.getParent();
            if(v0 != null) {
                AccessibilityEvent v3 = this.createEvent(arg3, 0x800);
                AccessibilityEventCompat.setContentChangeTypes(v3, arg4);
                v0.requestSendAccessibilityEvent(this.mHost, v3);
            }
        }
    }

    public final void invalidateVirtualView(int arg2) {
        this.invalidateVirtualView(arg2, 0);
    }

    private boolean isVisibleToUser(Rect arg3) {
        if(arg3 != null) {
            if(arg3.isEmpty()) {
            }
            else if(this.mHost.getWindowVisibility() != 0) {
                return 0;
            }
            else {
                ViewParent v2 = this.mHost.getParent();
                while(true) {
                    if((v2 instanceof View)) {
                        if(((View)v2).getAlpha() > 0f) {
                            if(((View)v2).getVisibility() != 0) {
                            }
                            else {
                                v2 = ((View)v2).getParent();
                                continue;
                            }
                        }

                        return 0;
                    }
                    else {
                        goto label_22;
                    }
                }

                return 0;
            label_22:
                if(v2 == null) {
                    return 0;
                }

                return 1;
            }
        }

        return 0;
    }

    private static int keyToDirection(int arg1) {
        if(arg1 != 19) {
            if(arg1 != 21) {
                if(arg1 != 22) {
                    return 130;
                }

                return 66;
            }

            return 17;
        }

        return 33;
    }

    private boolean moveFocus(int arg9, Rect arg10) {
        Object v9;
        SparseArrayCompat v0 = this.getAllNodes();
        int v1 = this.mKeyboardFocusedVirtualViewId;
        int v7 = 0x80000000;
        Object v1_1 = v1 == v7 ? null : v0.get(v1);
        Object v3 = v1_1;
        boolean v1_2 = true;
        if(arg9 == 1 || arg9 == 2) {
            int v4_1 = arg9;
            if(ViewCompat.getLayoutDirection(this.mHost) == 1) {
            }
            else {
                v1_2 = false;
            }

            v9 = FocusStrategy.findNextFocusInRelativeDirection(v0, ExploreByTouchHelper.SPARSE_VALUES_ADAPTER, ExploreByTouchHelper.NODE_ADAPTER, v3, v4_1, v1_2, false);
        }
        else {
            if(arg9 != 17 && arg9 != 33 && arg9 != 66) {
                if(arg9 == 130) {
                }
                else {
                    throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                }
            }

            Rect v4 = new Rect();
            v1 = this.mKeyboardFocusedVirtualViewId;
            if(v1 != v7) {
                this.getBoundsInParent(v1, v4);
            }
            else if(arg10 != null) {
                v4.set(arg10);
            }
            else {
                ExploreByTouchHelper.guessPreviouslyFocusedRect(this.mHost, arg9, v4);
            }

            v9 = FocusStrategy.findNextFocusInAbsoluteDirection(v0, ExploreByTouchHelper.SPARSE_VALUES_ADAPTER, ExploreByTouchHelper.NODE_ADAPTER, v3, v4, arg9);
        }

        if(v9 == null) {
        }
        else {
            v7 = v0.keyAt(v0.indexOfValue(v9));
        }

        return this.requestKeyboardFocusForVirtualView(v7);
    }

    AccessibilityNodeInfoCompat obtainAccessibilityNodeInfo(int arg2) {
        if(arg2 == -1) {
            return this.createNodeForHost();
        }

        return this.createNodeForChild(arg2);
    }

    public final void onFocusChanged(boolean arg3, int arg4, Rect arg5) {
        int v0 = this.mKeyboardFocusedVirtualViewId;
        if(v0 != 0x80000000) {
            this.clearKeyboardFocusForVirtualView(v0);
        }

        if(arg3) {
            this.moveFocus(arg4, arg5);
        }
    }

    public void onInitializeAccessibilityEvent(View arg1, AccessibilityEvent arg2) {
        super.onInitializeAccessibilityEvent(arg1, arg2);
        this.onPopulateEventForHost(arg2);
    }

    public void onInitializeAccessibilityNodeInfo(View arg1, AccessibilityNodeInfoCompat arg2) {
        super.onInitializeAccessibilityNodeInfo(arg1, arg2);
        this.onPopulateNodeForHost(arg2);
    }

    protected abstract boolean onPerformActionForVirtualView(int arg1, int arg2, Bundle arg3);

    protected void onPopulateEventForHost(AccessibilityEvent arg1) {
    }

    protected void onPopulateEventForVirtualView(int arg1, AccessibilityEvent arg2) {
    }

    protected void onPopulateNodeForHost(AccessibilityNodeInfoCompat arg1) {
    }

    protected abstract void onPopulateNodeForVirtualView(int arg1, AccessibilityNodeInfoCompat arg2);

    protected void onVirtualViewKeyboardFocusChanged(int arg1, boolean arg2) {
    }

    boolean performAction(int arg2, int arg3, Bundle arg4) {
        if(arg2 != -1) {
            return this.performActionForChild(arg2, arg3, arg4);
        }

        return this.performActionForHost(arg3, arg4);
    }

    private boolean performActionForChild(int arg2, int arg3, Bundle arg4) {
        if(arg3 != 1) {
            if(arg3 != 2) {
                if(arg3 != 0x40) {
                    if(arg3 != 0x80) {
                        return this.onPerformActionForVirtualView(arg2, arg3, arg4);
                    }

                    return this.clearAccessibilityFocus(arg2);
                }

                return this.requestAccessibilityFocus(arg2);
            }

            return this.clearKeyboardFocusForVirtualView(arg2);
        }

        return this.requestKeyboardFocusForVirtualView(arg2);
    }

    private boolean performActionForHost(int arg1, Bundle arg2) {
        return ViewCompat.performAccessibilityAction(this.mHost, arg1, arg2);
    }

    private boolean requestAccessibilityFocus(int arg3) {
        if(this.mManager.isEnabled()) {
            if(!this.mManager.isTouchExplorationEnabled()) {
            }
            else {
                int v0 = this.mAccessibilityFocusedVirtualViewId;
                if(v0 != arg3) {
                    if(v0 != 0x80000000) {
                        this.clearAccessibilityFocus(v0);
                    }

                    this.mAccessibilityFocusedVirtualViewId = arg3;
                    this.mHost.invalidate();
                    this.sendEventForVirtualView(arg3, 0x8000);
                    return 1;
                }
            }
        }

        return 0;
    }

    public final boolean requestKeyboardFocusForVirtualView(int arg4) {
        if(!this.mHost.isFocused() && !this.mHost.requestFocus()) {
            return 0;
        }

        int v0 = this.mKeyboardFocusedVirtualViewId;
        if(v0 == arg4) {
            return 0;
        }

        int v2 = 0x80000000;
        if(v0 != v2) {
            this.clearKeyboardFocusForVirtualView(v0);
        }

        if(arg4 == v2) {
            return 0;
        }

        this.mKeyboardFocusedVirtualViewId = arg4;
        this.onVirtualViewKeyboardFocusChanged(arg4, true);
        this.sendEventForVirtualView(arg4, 8);
        return 1;
    }

    public final boolean sendEventForVirtualView(int arg3, int arg4) {
        if(arg3 != 0x80000000) {
            if(!this.mManager.isEnabled()) {
            }
            else {
                ViewParent v0 = this.mHost.getParent();
                if(v0 == null) {
                    return 0;
                }
                else {
                    return v0.requestSendAccessibilityEvent(this.mHost, this.createEvent(arg3, arg4));
                }
            }
        }

        return 0;
    }

    private void updateHoveredVirtualView(int arg3) {
        int v0 = this.mHoveredVirtualViewId;
        if(v0 == arg3) {
            return;
        }

        this.mHoveredVirtualViewId = arg3;
        this.sendEventForVirtualView(arg3, 0x80);
        this.sendEventForVirtualView(v0, 0x100);
    }
}

