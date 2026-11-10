package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build$VERSION;
import android.view.MotionEvent;
import android.view.View$MeasureSpec;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.R$attr;
import androidx.appcompat.graphics.drawable.DrawableWrapperCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.os.BuildCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.widget.ListViewAutoScrollHelper;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class DropDownListView extends ListView {
    class Api21Impl {
        private Api21Impl() {
            super();
        }

        static void drawableHotspotChanged(View arg0, float arg1, float arg2) {
            arg0.drawableHotspotChanged(arg1, arg2);
        }
    }

    class Api30Impl {
        private static boolean sHasMethods;
        private static Method sPositionSelector;
        private static Method sSetNextSelectedPositionInt;
        private static Method sSetSelectedPositionInt;

        static {
            try {
                Method v0_1 = AbsListView.class.getDeclaredMethod("positionSelector", Integer.TYPE, View.class, Boolean.TYPE, Float.TYPE, Float.TYPE);
                Api30Impl.sPositionSelector = v0_1;
                v0_1.setAccessible(true);
                Class v0_2 = AdapterView.class;
                Method v1 = v0_2.getDeclaredMethod("setSelectedPositionInt", Integer.TYPE);
                Api30Impl.sSetSelectedPositionInt = v1;
                v1.setAccessible(true);
                v0_1 = v0_2.getDeclaredMethod("setNextSelectedPositionInt", Integer.TYPE);
                Api30Impl.sSetNextSelectedPositionInt = v0_1;
                v0_1.setAccessible(true);
                Api30Impl.sHasMethods = true;
                return;
            }
            catch(NoSuchMethodException v0) {
                v0.printStackTrace();
                return;
            }
        }

        private Api30Impl() {
            super();
        }

        static boolean canPositionSelectorForHoveredItem() {
            return Api30Impl.sHasMethods;
        }

        static void positionSelectorForHoveredItem(DropDownListView arg5, int arg6, View arg7) {
            try {
                Api30Impl.sPositionSelector.invoke(arg5, Integer.valueOf(arg6), arg7, Boolean.valueOf(false), Integer.valueOf(-1), Integer.valueOf(-1));
                Api30Impl.sSetSelectedPositionInt.invoke(arg5, Integer.valueOf(arg6));
                Api30Impl.sSetNextSelectedPositionInt.invoke(arg5, Integer.valueOf(arg6));
                return;
            }
            catch(InvocationTargetException v5) {
                v5.printStackTrace();
            }
            catch(IllegalAccessException v5_1) {
                v5_1.printStackTrace();
            }
        }
    }

    class Api33Impl {
        private Api33Impl() {
            super();
        }

        static boolean isSelectedChildViewEnabled(AbsListView arg0) {
            return arg0.isSelectedChildViewEnabled();
        }

        static void setSelectedChildViewEnabled(AbsListView arg0, boolean arg1) {
            arg0.setSelectedChildViewEnabled(arg1);
        }
    }

    class GateKeeperDrawable extends DrawableWrapperCompat {
        private boolean mEnabled;

        GateKeeperDrawable(Drawable arg1) {
            super(arg1);
            this.mEnabled = true;
        }

        public void draw(Canvas arg2) {
            if(this.mEnabled) {
                super.draw(arg2);
            }
        }

        void setEnabled(boolean arg1) {
            this.mEnabled = arg1;
        }

        public void setHotspot(float arg2, float arg3) {
            if(this.mEnabled) {
                super.setHotspot(arg2, arg3);
            }
        }

        public void setHotspotBounds(int arg2, int arg3, int arg4, int arg5) {
            if(this.mEnabled) {
                super.setHotspotBounds(arg2, arg3, arg4, arg5);
            }
        }

        public boolean setState(int[] arg2) {
            if(this.mEnabled) {
                return super.setState(arg2);
            }

            return 0;
        }

        public boolean setVisible(boolean arg2, boolean arg3) {
            if(this.mEnabled) {
                return super.setVisible(arg2, arg3);
            }

            return 0;
        }
    }

    class PreApi33Impl {
        private static final Field sIsChildViewEnabled;

        static {
            Field v0;
            try {
                v0 = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
                v0.setAccessible(true);
            }
            catch(NoSuchFieldException v1) {
                v1.printStackTrace();
            }

            PreApi33Impl.sIsChildViewEnabled = v0;
        }

        private PreApi33Impl() {
            super();
        }

        static boolean isSelectedChildViewEnabled(AbsListView arg1) {
            Field v0 = PreApi33Impl.sIsChildViewEnabled;
            if(v0 != null) {
                try {
                    return v0.getBoolean(arg1);
                }
                catch(IllegalAccessException v1) {
                    v1.printStackTrace();
                }
            }

            return 0;
        }

        static void setSelectedChildViewEnabled(AbsListView arg1, boolean arg2) {
            Field v0 = PreApi33Impl.sIsChildViewEnabled;
            if(v0 != null) {
                try {
                    v0.set(arg1, Boolean.valueOf(arg2));
                    return;
                }
                catch(IllegalAccessException v1) {
                    v1.printStackTrace();
                }
            }
        }
    }

    class ResolveHoverRunnable implements Runnable {
        ResolveHoverRunnable(DropDownListView arg1) {
            DropDownListView.this = arg1;
            super();
        }

        public void cancel() {
            DropDownListView.this.mResolveHoverRunnable = null;
            DropDownListView.this.removeCallbacks(((Runnable)this));
        }

        public void post() {
            DropDownListView.this.post(((Runnable)this));
        }

        public void run() {
            DropDownListView.this.mResolveHoverRunnable = null;
            DropDownListView.this.drawableStateChanged();
        }
    }

    public static final int INVALID_POSITION = -1;
    public static final int NO_POSITION = -1;
    private ViewPropertyAnimatorCompat mClickAnimation;
    private boolean mDrawsInPressedState;
    private boolean mHijackFocus;
    private boolean mListSelectionHidden;
    private int mMotionPosition;
    ResolveHoverRunnable mResolveHoverRunnable;
    private ListViewAutoScrollHelper mScrollHelper;
    private int mSelectionBottomPadding;
    private int mSelectionLeftPadding;
    private int mSelectionRightPadding;
    private int mSelectionTopPadding;
    private GateKeeperDrawable mSelector;
    private final Rect mSelectorRect;

    DropDownListView(Context arg3, boolean arg4) {
        super(arg3, null, attr.dropDownListViewStyle);
        this.mSelectorRect = new Rect();
        this.mSelectionLeftPadding = 0;
        this.mSelectionTopPadding = 0;
        this.mSelectionRightPadding = 0;
        this.mSelectionBottomPadding = 0;
        this.mHijackFocus = arg4;
        this.setCacheColorHint(0);
    }

    private void clearPressedItem() {
        this.mDrawsInPressedState = false;
        this.setPressed(false);
        this.drawableStateChanged();
        View v1 = this.getChildAt(this.mMotionPosition - this.getFirstVisiblePosition());
        if(v1 != null) {
            v1.setPressed(false);
        }

        ViewPropertyAnimatorCompat v0 = this.mClickAnimation;
        if(v0 != null) {
            v0.cancel();
            this.mClickAnimation = null;
        }
    }

    private void clickPressedItem(View arg3, int arg4) {
        this.performItemClick(arg3, arg4, this.getItemIdAtPosition(arg4));
    }

    protected void dispatchDraw(Canvas arg1) {
        this.drawSelectorCompat(arg1);
        super.dispatchDraw(arg1);
    }

    private void drawSelectorCompat(Canvas arg2) {
        if(!this.mSelectorRect.isEmpty()) {
            Drawable v0 = this.getSelector();
            if(v0 != null) {
                v0.setBounds(this.mSelectorRect);
                v0.draw(arg2);
            }
        }
    }

    protected void drawableStateChanged() {
        if(this.mResolveHoverRunnable != null) {
            return;
        }

        super.drawableStateChanged();
        this.setSelectorEnabled(true);
        this.updateSelectorStateCompat();
    }

    public boolean hasFocus() {
        if(!this.mHijackFocus) {
            if(super.hasFocus()) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public boolean hasWindowFocus() {
        if(!this.mHijackFocus) {
            if(super.hasWindowFocus()) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public boolean isFocused() {
        if(!this.mHijackFocus) {
            if(super.isFocused()) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public boolean isInTouchMode() {
        if((this.mHijackFocus) && (this.mListSelectionHidden) || (super.isInTouchMode())) {
            return 1;
        }

        return 0;
    }

    public int lookForSelectablePosition(int arg4, boolean arg5) {
        ListAdapter v0 = this.getAdapter();
        int v1 = -1;
        if(v0 != null) {
            if(this.isInTouchMode()) {
            }
            else {
                int v2 = v0.getCount();
                if(!this.getAdapter().areAllItemsEnabled()) {
                    if(arg5) {
                        int v3;
                        for(v3 = Math.max(0, arg4); v3 < v2; ++v3) {
                            if(v0.isEnabled(v3)) {
                                break;
                            }
                        }
                    }
                    else {
                        for(v3 = Math.min(arg4, v2 - 1); v3 >= 0; --v3) {
                            if(v0.isEnabled(v3)) {
                                break;
                            }
                        }
                    }

                    if(v3 >= 0) {
                        if(v3 >= v2) {
                        }
                        else {
                            return v3;
                        }
                    }

                    return v1;
                }
                else {
                    if(arg4 < 0) {
                        return v1;
                    }

                    if(arg4 >= v2) {
                        return v1;
                    }

                    return arg4;
                }
            }
        }

        return v1;
    }

    public int measureHeightOfChildrenCompat(int arg11, int arg12, int arg13, int arg14, int arg15) {
        arg12 = this.getListPaddingTop();
        arg13 = this.getListPaddingBottom();
        int v0 = this.getDividerHeight();
        Drawable v1 = this.getDivider();
        ListAdapter v2 = this.getAdapter();
        if(v2 == null) {
            return arg12 + arg13;
        }

        arg12 += arg13;
        if(v0 <= 0 || v1 == null) {
            v0 = 0;
        }
        else {
        }

        int v1_1 = v2.getCount();
        View v3 = null;
        int v4 = 0;
        int v5 = 0;
        int v7 = 0;
        View v6 = v3;
        while(v4 < v1_1) {
            int v8 = v2.getItemViewType(v4);
            if(v8 != v5) {
                v6 = v3;
                v5 = v8;
            }

            v6 = v2.getView(v4, v6, ((ViewGroup)this));
            ViewGroup$LayoutParams v8_1 = v6.getLayoutParams();
            if(v8_1 == null) {
                v8_1 = this.generateDefaultLayoutParams();
                v6.setLayoutParams(v8_1);
            }

            v8 = v8_1.height > 0 ? View$MeasureSpec.makeMeasureSpec(v8_1.height, 0x40000000) : View$MeasureSpec.makeMeasureSpec(0, 0);
            v6.measure(arg11, v8);
            v6.forceLayout();
            if(v4 > 0) {
                arg12 += v0;
            }

            arg12 += v6.getMeasuredHeight();
            if(arg12 >= arg14) {
                if(arg15 >= 0 && v4 > arg15 && v7 > 0 && arg12 != arg14) {
                    return v7;
                }

                return arg14;
            }

            if(arg15 >= 0 && v4 >= arg15) {
                v7 = arg12;
            }

            ++v4;
        }

        return arg12;
    }

    protected void onDetachedFromWindow() {
        this.mResolveHoverRunnable = null;
        super.onDetachedFromWindow();
    }

    public boolean onForwardedEvent(MotionEvent arg8, int arg9) {
        boolean v3;
        int v0 = arg8.getActionMasked();
        if(v0 == 1) {
            v3 = false;
        label_17:
            arg9 = arg8.findPointerIndex(arg9);
            if(arg9 < 0) {
            label_11:
                arg9 = 0;
                v3 = false;
            }
            else {
                int v4 = ((int)arg8.getX(arg9));
                arg9 = ((int)arg8.getY(arg9));
                int v5 = this.pointToPosition(v4, arg9);
                if(v5 == -1) {
                    arg9 = 1;
                }
                else {
                    View v3_1 = this.getChildAt(v5 - this.getFirstVisiblePosition());
                    this.setPressedItem(v3_1, v5, ((float)v4), ((float)arg9));
                    if(v0 == 1) {
                        this.clickPressedItem(v3_1, v5);
                        goto label_8;
                    }
                    else {
                    label_8:
                        v3 = true;
                        arg9 = 0;
                    }
                }
            }
        }
        else if(v0 != 2) {
            if(v0 == 3) {
                goto label_11;
            }

            goto label_8;
        }
        else {
            v3 = true;
            goto label_17;
        }

        if(!v3 || arg9 != 0) {
            this.clearPressedItem();
        }

        ListViewAutoScrollHelper v9 = this.mScrollHelper;
        if(v3) {
            if(v9 == null) {
                v9 = new ListViewAutoScrollHelper(((ListView)this));
                this.mScrollHelper = v9;
            }

            v9.setEnabled(true);
            this.mScrollHelper.onTouch(((View)this), arg8);
            return v3;
        }

        if(v9 != null) {
            v9.setEnabled(false);
        }

        return v3;
    }

    public boolean onHoverEvent(MotionEvent arg5) {
        int v0 = arg5.getActionMasked();
        if(v0 == 10 && this.mResolveHoverRunnable == null) {
            ResolveHoverRunnable v1 = new ResolveHoverRunnable(this);
            this.mResolveHoverRunnable = v1;
            v1.post();
        }

        boolean v1_1 = super.onHoverEvent(arg5);
        int v3 = -1;
        if(v0 != 9) {
            if(v0 == 7) {
            }
            else {
                this.setSelection(v3);
                return v1_1;
            }
        }

        int v5 = this.pointToPosition(((int)arg5.getX()), ((int)arg5.getY()));
        if(v5 != v3 && v5 != this.getSelectedItemPosition()) {
            View v0_1 = this.getChildAt(v5 - this.getFirstVisiblePosition());
            if(v0_1.isEnabled()) {
                this.requestFocus();
                if(Build$VERSION.SDK_INT >= 30 && (Api30Impl.canPositionSelectorForHoveredItem())) {
                    Api30Impl.positionSelectorForHoveredItem(this, v5, v0_1);
                    goto label_43;
                }

                this.setSelectionFromTop(v5, v0_1.getTop() - this.getTop());
            }

        label_43:
            this.updateSelectorStateCompat();
        }

        return v1_1;
    }

    public boolean onTouchEvent(MotionEvent arg3) {
        if(arg3.getAction() != 0) {
        }
        else {
            this.mMotionPosition = this.pointToPosition(((int)arg3.getX()), ((int)arg3.getY()));
        }

        ResolveHoverRunnable v0 = this.mResolveHoverRunnable;
        if(v0 != null) {
            v0.cancel();
        }

        return super.onTouchEvent(arg3);
    }

    private void positionSelectorCompat(int arg6, View arg7) {
        Rect v0 = this.mSelectorRect;
        v0.set(arg7.getLeft(), arg7.getTop(), arg7.getRight(), arg7.getBottom());
        v0.left -= this.mSelectionLeftPadding;
        v0.top -= this.mSelectionTopPadding;
        v0.right += this.mSelectionRightPadding;
        v0.bottom += this.mSelectionBottomPadding;
        boolean v0_1 = this.superIsSelectedChildViewEnabled();
        if(arg7.isEnabled() != v0_1) {
            this.superSetSelectedChildViewEnabled((((int)v0_1)) ^ 1);
            if(arg6 != -1) {
                this.refreshDrawableState();
            }
        }
    }

    private void positionSelectorLikeFocusCompat(int arg5, View arg6) {
        Drawable v0 = this.getSelector();
        boolean v1 = true;
        int v3 = v0 == null || arg5 == -1 ? 0 : 1;
        if(v3 != 0) {
            v0.setVisible(false, false);
        }

        this.positionSelectorCompat(arg5, arg6);
        if(v3 != 0) {
            Rect v5 = this.mSelectorRect;
            float v6 = v5.exactCenterX();
            float v5_1 = v5.exactCenterY();
            if(this.getVisibility() == 0) {
            }
            else {
                v1 = false;
            }

            v0.setVisible(v1, false);
            DrawableCompat.setHotspot(v0, v6, v5_1);
        }
    }

    private void positionSelectorLikeTouchCompat(int arg1, View arg2, float arg3, float arg4) {
        this.positionSelectorLikeFocusCompat(arg1, arg2);
        Drawable v0 = this.getSelector();
        if(v0 != null && arg1 != -1) {
            DrawableCompat.setHotspot(v0, arg3, arg4);
        }
    }

    void setListSelectionHidden(boolean arg1) {
        this.mListSelectionHidden = arg1;
    }

    private void setPressedItem(View arg5, int arg6, float arg7, float arg8) {
        this.mDrawsInPressedState = true;
        Api21Impl.drawableHotspotChanged(((View)this), arg7, arg8);
        if(!this.isPressed()) {
            this.setPressed(true);
        }

        this.layoutChildren();
        int v1 = this.mMotionPosition;
        if(v1 != -1) {
            View v1_1 = this.getChildAt(v1 - this.getFirstVisiblePosition());
            if(v1_1 != null && v1_1 != arg5 && (v1_1.isPressed())) {
                v1_1.setPressed(false);
            }
        }

        this.mMotionPosition = arg6;
        Api21Impl.drawableHotspotChanged(arg5, arg7 - (((float)arg5.getLeft())), arg8 - (((float)arg5.getTop())));
        if(!arg5.isPressed()) {
            arg5.setPressed(true);
        }

        this.positionSelectorLikeTouchCompat(arg6, arg5, arg7, arg8);
        this.setSelectorEnabled(false);
        this.refreshDrawableState();
    }

    public void setSelector(Drawable arg2) {
        GateKeeperDrawable v0 = arg2 != null ? new GateKeeperDrawable(arg2) : null;
        this.mSelector = v0;
        super.setSelector(((Drawable)v0));
        Rect v0_1 = new Rect();
        if(arg2 != null) {
            arg2.getPadding(v0_1);
        }

        this.mSelectionLeftPadding = v0_1.left;
        this.mSelectionTopPadding = v0_1.top;
        this.mSelectionRightPadding = v0_1.right;
        this.mSelectionBottomPadding = v0_1.bottom;
    }

    private void setSelectorEnabled(boolean arg1) {
        GateKeeperDrawable v0 = this.mSelector;
        if(v0 != null) {
            v0.setEnabled(arg1);
        }
    }

    private boolean superIsSelectedChildViewEnabled() {
        if(BuildCompat.isAtLeastT()) {
            return Api33Impl.isSelectedChildViewEnabled(((AbsListView)this));
        }

        return PreApi33Impl.isSelectedChildViewEnabled(((AbsListView)this));
    }

    private void superSetSelectedChildViewEnabled(boolean arg2) {
        if(BuildCompat.isAtLeastT()) {
            Api33Impl.setSelectedChildViewEnabled(((AbsListView)this), arg2);
            return;
        }

        PreApi33Impl.setSelectedChildViewEnabled(((AbsListView)this), arg2);
    }

    private boolean touchModeDrawsInPressedStateCompat() {
        return this.mDrawsInPressedState;
    }

    private void updateSelectorStateCompat() {
        Drawable v0 = this.getSelector();
        if(v0 != null && (this.touchModeDrawsInPressedStateCompat()) && (this.isPressed())) {
            v0.setState(this.getDrawableState());
        }
    }
}

