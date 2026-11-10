package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View$MeasureSpec;
import android.view.View;
import android.view.ViewDebug$ExportedProperty;
import android.view.ViewGroup$LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.MenuBuilder$ItemInvoker;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter$Callback;
import androidx.appcompat.view.menu.MenuView;

public class ActionMenuView extends LinearLayoutCompat implements ItemInvoker, MenuView {
    public interface ActionMenuChildView {
        boolean needsDividerAfter();

        boolean needsDividerBefore();
    }

    class ActionMenuPresenterCallback implements Callback {
        ActionMenuPresenterCallback() {
            super();
        }

        public void onCloseMenu(MenuBuilder arg1, boolean arg2) {
        }

        public boolean onOpenSubMenu(MenuBuilder arg1) {
            return 0;
        }
    }

    public class LayoutParams extends androidx.appcompat.widget.LinearLayoutCompat$LayoutParams {
        @ViewDebug$ExportedProperty public int cellsUsed;
        @ViewDebug$ExportedProperty public boolean expandable;
        boolean expanded;
        @ViewDebug$ExportedProperty public int extraPixels;
        @ViewDebug$ExportedProperty public boolean isOverflowButton;
        @ViewDebug$ExportedProperty public boolean preventEdgeOffset;

        public LayoutParams(int arg1, int arg2) {
            super(arg1, arg2);
            this.isOverflowButton = false;
        }

        public LayoutParams(Context arg1, AttributeSet arg2) {
            super(arg1, arg2);
        }

        public LayoutParams(LayoutParams arg1) {
            super(((ViewGroup$LayoutParams)arg1));
            this.isOverflowButton = arg1.isOverflowButton;
        }

        public LayoutParams(ViewGroup$LayoutParams arg1) {
            super(arg1);
        }

        LayoutParams(int arg1, int arg2, boolean arg3) {
            super(arg1, arg2);
            this.isOverflowButton = arg3;
        }
    }

    class MenuBuilderCallback implements androidx.appcompat.view.menu.MenuBuilder$Callback {
        MenuBuilderCallback(ActionMenuView arg1) {
            ActionMenuView.this = arg1;
            super();
        }

        public boolean onMenuItemSelected(MenuBuilder arg1, MenuItem arg2) {
            if(ActionMenuView.this.mOnMenuItemClickListener != null && (ActionMenuView.this.mOnMenuItemClickListener.onMenuItemClick(arg2))) {
                return 1;
            }

            return 0;
        }

        public void onMenuModeChange(MenuBuilder arg2) {
            if(ActionMenuView.this.mMenuBuilderCallback != null) {
                ActionMenuView.this.mMenuBuilderCallback.onMenuModeChange(arg2);
            }
        }
    }

    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem arg1);
    }

    static final int GENERATED_ITEM_PADDING = 4;
    static final int MIN_CELL_SIZE = 56;
    private static final String TAG = "ActionMenuView";
    private Callback mActionMenuPresenterCallback;
    private boolean mFormatItems;
    private int mFormatItemsWidth;
    private int mGeneratedItemPadding;
    private MenuBuilder mMenu;
    androidx.appcompat.view.menu.MenuBuilder$Callback mMenuBuilderCallback;
    private int mMinCellSize;
    OnMenuItemClickListener mOnMenuItemClickListener;
    private Context mPopupContext;
    private int mPopupTheme;
    private ActionMenuPresenter mPresenter;
    private boolean mReserveOverflow;

    public ActionMenuView(Context arg2) {
        this(arg2, null);
    }

    public ActionMenuView(Context arg3, AttributeSet arg4) {
        super(arg3, arg4);
        this.setBaselineAligned(false);
        float v0 = arg3.getResources().getDisplayMetrics().density;
        this.mMinCellSize = ((int)(56f * v0));
        this.mGeneratedItemPadding = ((int)(v0 * 4f));
        this.mPopupContext = arg3;
        this.mPopupTheme = 0;
    }

    protected boolean checkLayoutParams(ViewGroup$LayoutParams arg1) {
        return arg1 instanceof LayoutParams;
    }

    public void dismissPopupMenus() {
        ActionMenuPresenter v0 = this.mPresenter;
        if(v0 != null) {
            v0.dismissPopupMenus();
        }
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent arg1) {
        return 0;
    }

    protected ViewGroup$LayoutParams generateDefaultLayoutParams() {
        return this.generateDefaultLayoutParams();
    }

    protected LayoutParams generateDefaultLayoutParams() {
        LayoutParams v1 = new LayoutParams(-2, -2);
        v1.gravity = 16;
        return v1;
    }

    protected androidx.appcompat.widget.LinearLayoutCompat$LayoutParams generateDefaultLayoutParams() {
        return this.generateDefaultLayoutParams();
    }

    protected LayoutParams generateLayoutParams(ViewGroup$LayoutParams arg1) {
        if(arg1 != null) {
            LayoutParams v0 = (arg1 instanceof LayoutParams) ? new LayoutParams(((LayoutParams)arg1)) : new LayoutParams(arg1);
            if(v0.gravity <= 0) {
                v0.gravity = 16;
            }

            return v0;
        }

        return this.generateDefaultLayoutParams();
    }

    public ViewGroup$LayoutParams generateLayoutParams(AttributeSet arg1) {
        return this.generateLayoutParams(arg1);
    }

    public LayoutParams generateLayoutParams(AttributeSet arg2) {
        return new LayoutParams(this.getContext(), arg2);
    }

    protected ViewGroup$LayoutParams generateLayoutParams(ViewGroup$LayoutParams arg1) {
        return this.generateLayoutParams(arg1);
    }

    public androidx.appcompat.widget.LinearLayoutCompat$LayoutParams generateLayoutParams(AttributeSet arg1) {
        return this.generateLayoutParams(arg1);
    }

    protected androidx.appcompat.widget.LinearLayoutCompat$LayoutParams generateLayoutParams(ViewGroup$LayoutParams arg1) {
        return this.generateLayoutParams(arg1);
    }

    public LayoutParams generateOverflowButtonLayoutParams() {
        LayoutParams v1 = this.generateDefaultLayoutParams();
        v1.isOverflowButton = true;
        return v1;
    }

    public Menu getMenu() {
        ActionMenuPresenterCallback v1_3;
        if(this.mMenu == null) {
            Context v0 = this.getContext();
            MenuBuilder v1 = new MenuBuilder(v0);
            this.mMenu = v1;
            v1.setCallback(new MenuBuilderCallback(this));
            ActionMenuPresenter v1_1 = new ActionMenuPresenter(v0);
            this.mPresenter = v1_1;
            v1_1.setReserveOverflow(true);
            ActionMenuPresenter v0_1 = this.mPresenter;
            Callback v1_2 = this.mActionMenuPresenterCallback;
            if(v1_2 != null) {
            }
            else {
                v1_3 = new ActionMenuPresenterCallback();
            }

            v0_1.setCallback(((Callback)v1_3));
            this.mMenu.addMenuPresenter(this.mPresenter, this.mPopupContext);
            this.mPresenter.setMenuView(this);
        }

        return this.mMenu;
    }

    public Drawable getOverflowIcon() {
        this.getMenu();
        return this.mPresenter.getOverflowIcon();
    }

    public int getPopupTheme() {
        return this.mPopupTheme;
    }

    public int getWindowAnimations() {
        return 0;
    }

    protected boolean hasSupportDividerBeforeChildAt(int arg4) {
        boolean v0_1;
        int v0 = 0;
        if(arg4 == 0) {
            return 0;
        }

        View v1 = this.getChildAt(arg4 - 1);
        View v2 = this.getChildAt(arg4);
        if(arg4 < this.getChildCount() && ((v1 instanceof ActionMenuChildView))) {
            v0_1 = ((ActionMenuChildView)v1).needsDividerAfter();
        }

        if(arg4 > 0 && ((v2 instanceof ActionMenuChildView))) {
            return ((ActionMenuChildView)v2).needsDividerBefore() | (((int)v0_1));
        }

        return v0_1;
    }

    public boolean hideOverflowMenu() {
        ActionMenuPresenter v0 = this.mPresenter;
        if(v0 != null && (v0.hideOverflowMenu())) {
            return 1;
        }

        return 0;
    }

    public void initialize(MenuBuilder arg1) {
        this.mMenu = arg1;
    }

    public boolean invokeItem(MenuItemImpl arg2) {
        return this.mMenu.performItemAction(((MenuItem)arg2), 0);
    }

    public boolean isOverflowMenuShowPending() {
        ActionMenuPresenter v0 = this.mPresenter;
        if(v0 != null && (v0.isOverflowMenuShowPending())) {
            return 1;
        }

        return 0;
    }

    public boolean isOverflowMenuShowing() {
        ActionMenuPresenter v0 = this.mPresenter;
        if(v0 != null && (v0.isOverflowMenuShowing())) {
            return 1;
        }

        return 0;
    }

    public boolean isOverflowReserved() {
        return this.mReserveOverflow;
    }

    static int measureChildForCells(View arg5, int arg6, int arg7, int arg8, int arg9) {
        int v3;
        ViewGroup$LayoutParams v0 = arg5.getLayoutParams();
        arg8 = View$MeasureSpec.makeMeasureSpec(View$MeasureSpec.getSize(arg8) - arg9, View$MeasureSpec.getMode(arg8));
        View v9 = (arg5 instanceof ActionMenuItemView) ? arg5 : null;
        boolean v1 = true;
        arg9 = v9 == null || !((ActionMenuItemView)v9).hasText() ? 0 : 1;
        if(arg7 > 0) {
            v3 = 2;
            if(arg9 != 0 && arg7 < v3) {
                goto label_36;
            }

            arg5.measure(View$MeasureSpec.makeMeasureSpec(arg7 * arg6, 0x80000000), arg8);
            arg7 = arg5.getMeasuredWidth();
            int v4 = arg7 / arg6;
            if(arg7 % arg6 != 0) {
                ++v4;
            }

            if(arg9 != 0 && v4 < v3) {
                goto label_37;
            }

            v3 = v4;
        }
        else {
        label_36:
            v3 = 0;
        }

    label_37:
        if((((LayoutParams)v0).isOverflowButton) || arg9 == 0) {
            v1 = false;
        }
        else {
        }

        ((LayoutParams)v0).expandable = v1;
        ((LayoutParams)v0).cellsUsed = v3;
        arg5.measure(View$MeasureSpec.makeMeasureSpec(arg6 * v3, 0x40000000), arg8);
        return v3;
    }

    public void onConfigurationChanged(Configuration arg2) {
        super.onConfigurationChanged(arg2);
        ActionMenuPresenter v2 = this.mPresenter;
        if(v2 != null) {
            v2.updateMenuView(false);
            if(this.mPresenter.isOverflowMenuShowing()) {
                this.mPresenter.hideOverflowMenu();
                this.mPresenter.showOverflowMenu();
            }
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.dismissPopupMenus();
    }

    protected void onLayout(boolean arg18, int arg19, int arg20, int arg21, int arg22) {
        ViewGroup$LayoutParams v6_1;
        View v4_1;
        int v7;
        int v15;
        ActionMenuView v0 = this;
        if(!v0.mFormatItems) {
            super.onLayout(arg18, arg19, arg20, arg21, arg22);
            return;
        }

        int v1 = v0.getChildCount();
        int v2 = (arg22 - arg20) / 2;
        int v3 = v0.getDividerWidth();
        int v4 = arg21 - arg19;
        int v5 = v4 - v0.getPaddingRight() - v0.getPaddingLeft();
        boolean v6 = ViewUtils.isLayoutRtl(((View)v0));
        int v8 = 0;
        int v9 = 0;
        int v10 = 0;
        while(true) {
            int v11 = 8;
            if(v8 >= v1) {
                break;
            }

            View v13 = v0.getChildAt(v8);
            if(v13.getVisibility() == v11) {
            }
            else {
                ViewGroup$LayoutParams v11_1 = v13.getLayoutParams();
                if(((LayoutParams)v11_1).isOverflowButton) {
                    v9 = v13.getMeasuredWidth();
                    if(v0.hasSupportDividerBeforeChildAt(v8)) {
                        v9 += v3;
                    }

                    int v14 = v13.getMeasuredHeight();
                    if(v6) {
                        v15 = v0.getPaddingLeft() + ((LayoutParams)v11_1).leftMargin;
                        v11 = v15 + v9;
                    }
                    else {
                        v11 = v0.getWidth() - v0.getPaddingRight() - ((LayoutParams)v11_1).rightMargin;
                        v15 = v11 - v9;
                    }

                    v7 = v2 - v14 / 2;
                    v13.layout(v15, v7, v11, v14 + v7);
                    v5 -= v9;
                    v9 = 1;
                }
                else {
                    v5 -= v13.getMeasuredWidth() + ((LayoutParams)v11_1).leftMargin + ((LayoutParams)v11_1).rightMargin;
                    v0.hasSupportDividerBeforeChildAt(v8);
                    ++v10;
                }
            }

            ++v8;
        }

        if(v1 == 1 && v9 == 0) {
            View v0_1 = v0.getChildAt(0);
            v1 = v0_1.getMeasuredWidth();
            v3 = v0_1.getMeasuredHeight();
            v4 = v4 / 2 - v1 / 2;
            v2 -= v3 / 2;
            v0_1.layout(v4, v2, v1 + v4, v3 + v2);
            return;
        }

        v10 -= v9 ^ 1;
        v3 = v10 > 0 ? v5 / v10 : 0;
        v3 = Math.max(0, v3);
        if(v6) {
            v5 = v0.getWidth() - v0.getPaddingRight();
            v7 = 0;
            goto label_90;
        }
        else {
            v5 = v0.getPaddingLeft();
            v7 = 0;
            while(true) {
                if(v7 < v1) {
                    v4_1 = v0.getChildAt(v7);
                    v6_1 = v4_1.getLayoutParams();
                    if(v4_1.getVisibility() != v11) {
                        if(((LayoutParams)v6_1).isOverflowButton) {
                        }
                        else {
                            v5 += ((LayoutParams)v6_1).leftMargin;
                            v8 = v4_1.getMeasuredWidth();
                            v9 = v4_1.getMeasuredHeight();
                            v10 = v2 - v9 / 2;
                            v4_1.layout(v5, v10, v5 + v8, v9 + v10);
                            v5 += v8 + ((LayoutParams)v6_1).rightMargin + v3;
                        }
                    }

                    ++v7;
                    continue;
                }

                return;
            }

        label_90:
            while(v7 < v1) {
                v4_1 = v0.getChildAt(v7);
                v6_1 = v4_1.getLayoutParams();
                if(v4_1.getVisibility() != v11) {
                    if(((LayoutParams)v6_1).isOverflowButton) {
                    }
                    else {
                        v5 -= ((LayoutParams)v6_1).rightMargin;
                        v8 = v4_1.getMeasuredWidth();
                        v9 = v4_1.getMeasuredHeight();
                        v10 = v2 - v9 / 2;
                        v4_1.layout(v5 - v8, v10, v5, v9 + v10);
                        v5 -= v8 + ((LayoutParams)v6_1).leftMargin + v3;
                    }
                }

                ++v7;
            }
        }
    }

    protected void onMeasure(int arg6, int arg7) {
        boolean v0 = this.mFormatItems;
        boolean v1 = View$MeasureSpec.getMode(arg6) == 0x40000000 ? true : false;
        this.mFormatItems = v1;
        if(v0 != v1) {
            this.mFormatItemsWidth = 0;
        }

        int v0_1 = View$MeasureSpec.getSize(arg6);
        if(this.mFormatItems) {
            MenuBuilder v1_1 = this.mMenu;
            if(v1_1 != null && v0_1 != this.mFormatItemsWidth) {
                this.mFormatItemsWidth = v0_1;
                v1_1.onItemsChanged(true);
            }
        }

        v0_1 = this.getChildCount();
        if((this.mFormatItems) && v0_1 > 0) {
            this.onMeasureExactFormat(arg6, arg7);
            return;
        }

        int v1_2;
        for(v1_2 = 0; v1_2 < v0_1; ++v1_2) {
            ViewGroup$LayoutParams v2 = this.getChildAt(v1_2).getLayoutParams();
            ((LayoutParams)v2).rightMargin = 0;
            ((LayoutParams)v2).leftMargin = 0;
        }

        super.onMeasure(arg6, arg7);
    }

    private void onMeasureExactFormat(int arg31, int arg32) {
        boolean v19;
        int v23_1;
        ViewGroup$LayoutParams v5_1;
        int v27;
        long v23;
        int v11_1;
        int v9_1;
        boolean v21_1;
        int v21;
        int v20;
        ActionMenuView v0 = this;
        int v1 = View$MeasureSpec.getMode(arg32);
        int v2 = View$MeasureSpec.getSize(arg31);
        int v3 = View$MeasureSpec.getSize(arg32);
        int v4 = v0.getPaddingLeft() + v0.getPaddingRight();
        int v5 = v0.getPaddingTop() + v0.getPaddingBottom();
        int v6 = ActionMenuView.getChildMeasureSpec(arg32, v5, -2);
        v2 -= v4;
        v4 = v0.mMinCellSize;
        int v7 = v2 / v4;
        int v8 = v2 % v4;
        if(v7 == 0) {
            v0.setMeasuredDimension(v2, 0);
            return;
        }

        v4 += v8 / v7;
        v8 = v0.getChildCount();
        int v10 = 0;
        int v12 = 0;
        int v13 = 0;
        int v14 = 0;
        int v15 = 0;
        int v16 = 0;
        long v31 = 0;
        long v17 = 0;
        while(v12 < v8) {
            View v11 = v0.getChildAt(v12);
            v20 = v3;
            if(v11.getVisibility() == 8) {
                v21 = v4;
            }
            else {
                boolean v3_1 = v11 instanceof ActionMenuItemView;
                ++v14;
                if(v3_1) {
                    v21_1 = v3_1;
                    v3_1 = false;
                    v11.setPadding(v0.mGeneratedItemPadding, 0, v0.mGeneratedItemPadding, 0);
                }
                else {
                    v21_1 = v3_1;
                    v3_1 = false;
                }

                ViewGroup$LayoutParams v9 = v11.getLayoutParams();
                ((LayoutParams)v9).expanded = v3_1;
                ((LayoutParams)v9).extraPixels = ((int)v3_1);
                ((LayoutParams)v9).cellsUsed = ((int)v3_1);
                ((LayoutParams)v9).expandable = v3_1;
                ((LayoutParams)v9).leftMargin = ((int)v3_1);
                ((LayoutParams)v9).rightMargin = ((int)v3_1);
                v3_1 = !v21_1 || !v11.hasText() ? false : true;
                ((LayoutParams)v9).preventEdgeOffset = v3_1;
                v3 = ((LayoutParams)v9).isOverflowButton ? 1 : v7;
                v3 = ActionMenuView.measureChildForCells(v11, v4, v3, v6, v5);
                v15 = Math.max(v15, v3);
                v21 = v4;
                if(((LayoutParams)v9).expandable) {
                    ++v16;
                }

                if(((LayoutParams)v9).isOverflowButton) {
                    v13 = 1;
                }

                v7 -= v3;
                v10 = Math.max(v10, v11.getMeasuredHeight());
                if(v3 != 1) {
                    goto label_87;
                }

                v17 |= ((long)(1 << v12));
            }

        label_87:
            ++v12;
            v3 = v20;
            v4 = v21;
        }

        v20 = v3;
        v21 = v4;
        v3 = 2;
        v4 = v13 == 0 || v14 != v3 ? 0 : 1;
        v5 = 0;
        while(true) {
            if(v16 <= 0) {
                break;
            }
            else if(v7 > 0) {
                v9_1 = 0x7FFFFFFF;
                long v25 = v31;
                int v22 = v3;
                v3 = 0;
                v11_1 = 0;
                v23 = 1;
                while(v11_1 < v8) {
                    ViewGroup$LayoutParams v12_1 = v0.getChildAt(v11_1).getLayoutParams();
                    v27 = v4;
                    if(!((LayoutParams)v12_1).expandable) {
                    }
                    else if(((LayoutParams)v12_1).cellsUsed < v9_1) {
                        v25 = v23 << v11_1;
                        v9_1 = ((LayoutParams)v12_1).cellsUsed;
                        v3 = 1;
                    }
                    else if(((LayoutParams)v12_1).cellsUsed == v9_1) {
                        v25 |= v23 << v11_1;
                        ++v3;
                    }

                    ++v11_1;
                    v4 = v27;
                }

                v27 = v4;
                v17 |= v25;
                if(v3 > v7) {
                    goto label_181;
                }

                ++v9_1;
                for(v3 = 0; v3 < v8; v3 = v23_1 + 1) {
                    View v4_1 = v0.getChildAt(v3);
                    v5_1 = v4_1.getLayoutParams();
                    long v11_2 = ((long)(1 << v3));
                    if((v25 & v11_2) == v31) {
                        if(((LayoutParams)v5_1).cellsUsed == v9_1) {
                            v17 |= v11_2;
                        }

                        v23_1 = v3;
                    }
                    else {
                        if(v27 == 0 || !((LayoutParams)v5_1).preventEdgeOffset) {
                            v23_1 = v3;
                            v19 = true;
                        }
                        else if(v7 == 1) {
                            v19 = true;
                            v23_1 = v3;
                            v4_1.setPadding(v0.mGeneratedItemPadding + v21, 0, v0.mGeneratedItemPadding, 0);
                        }
                        else {
                            v23_1 = v3;
                            v19 = true;
                        }

                        ++((LayoutParams)v5_1).cellsUsed;
                        ((LayoutParams)v5_1).expanded = v19;
                        --v7;
                    }
                }

                v3 = v22;
                v4 = v27;
                v5 = 1;
                continue;
            }
            else {
                break;
            }
        }

        v23 = 1;
    label_181:
        v3 = v13 != 0 || v14 != 1 ? 0 : 1;
        if(v7 <= 0 || v17 == v31) {
        label_276:
            v3 = 0;
        }
        else {
            if(v7 >= v14 - 1 && v3 == 0 && v15 <= 1) {
                goto label_276;
            }

            float v4_2 = ((float)Long.bitCount(v17));
            if(v3 == 0) {
                float v9_2 = 0.5f;
                if(Long.compare(v17 & v23, v31) != 0) {
                    v3 = 0;
                    if(!v0.getChildAt(0).getLayoutParams().preventEdgeOffset) {
                        v4_2 -= v9_2;
                    }
                }
                else {
                    v3 = 0;
                }

                v11_1 = v8 - 1;
                if((v17 & (((long)(1 << v11_1)))) == v31) {
                    goto label_221;
                }

                if(v0.getChildAt(v11_1).getLayoutParams().preventEdgeOffset) {
                    goto label_221;
                }

                v4_2 -= v9_2;
            }
            else {
                v3 = 0;
            }

        label_221:
            v4 = v4_2 > 0f ? ((int)((((float)(v7 * v21))) / v4_2)) : v3;
            v7 = v5;
            for(v5 = v3; v5 < v8; ++v5) {
                if((v17 & (((long)(1 << v5)))) == v31) {
                }
                else {
                    View v9_3 = v0.getChildAt(v5);
                    ViewGroup$LayoutParams v11_3 = v9_3.getLayoutParams();
                    if((v9_3 instanceof ActionMenuItemView)) {
                        ((LayoutParams)v11_3).extraPixels = v4;
                        ((LayoutParams)v11_3).expanded = true;
                        if(v5 == 0 && !((LayoutParams)v11_3).preventEdgeOffset) {
                            ((LayoutParams)v11_3).leftMargin = -v4 / 2;
                        }

                        v7 = 1;
                    }
                    else {
                        if(((LayoutParams)v11_3).isOverflowButton) {
                            ((LayoutParams)v11_3).extraPixels = v4;
                            ((LayoutParams)v11_3).expanded = true;
                            ((LayoutParams)v11_3).rightMargin = -v4 / 2;
                            v7 = 1;
                            goto label_272;
                        }

                        if(v5 != 0) {
                            ((LayoutParams)v11_3).leftMargin = v4 / 2;
                        }

                        if(v5 == v8 - 1) {
                            goto label_272;
                        }

                        ((LayoutParams)v11_3).rightMargin = v4 / 2;
                    }
                }

            label_272:
            }

            v5 = v7;
        }

        v4 = 0x40000000;
        if(v5 != 0) {
            for(v9_1 = v3; v9_1 < v8; ++v9_1) {
                View v3_2 = v0.getChildAt(v9_1);
                v5_1 = v3_2.getLayoutParams();
                if(!((LayoutParams)v5_1).expanded) {
                }
                else {
                    v3_2.measure(View$MeasureSpec.makeMeasureSpec(((LayoutParams)v5_1).cellsUsed * v21 + ((LayoutParams)v5_1).extraPixels, v4), v6);
                }
            }
        }

        v3 = v1 != v4 ? v10 : v20;
        v0.setMeasuredDimension(v2, v3);
    }

    public MenuBuilder peekMenu() {
        return this.mMenu;
    }

    public void setExpandedActionViewsExclusive(boolean arg1) {
        this.mPresenter.setExpandedActionViewsExclusive(arg1);
    }

    public void setMenuCallbacks(Callback arg1, androidx.appcompat.view.menu.MenuBuilder$Callback arg2) {
        this.mActionMenuPresenterCallback = arg1;
        this.mMenuBuilderCallback = arg2;
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener arg1) {
        this.mOnMenuItemClickListener = arg1;
    }

    public void setOverflowIcon(Drawable arg1) {
        this.getMenu();
        this.mPresenter.setOverflowIcon(arg1);
    }

    public void setOverflowReserved(boolean arg1) {
        this.mReserveOverflow = arg1;
    }

    public void setPopupTheme(int arg3) {
        if(this.mPopupTheme != arg3) {
            this.mPopupTheme = arg3;
            if(arg3 == 0) {
                this.mPopupContext = this.getContext();
                return;
            }
            else {
                this.mPopupContext = new ContextThemeWrapper(this.getContext(), arg3);
            }
        }
    }

    public void setPresenter(ActionMenuPresenter arg1) {
        this.mPresenter = arg1;
        arg1.setMenuView(this);
    }

    public boolean showOverflowMenu() {
        ActionMenuPresenter v0 = this.mPresenter;
        if(v0 != null && (v0.showOverflowMenu())) {
            return 1;
        }

        return 0;
    }
}

