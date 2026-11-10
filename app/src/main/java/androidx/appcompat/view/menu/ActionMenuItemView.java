package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View$MeasureSpec;
import android.view.View$OnClickListener;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.ActionMenuView$ActionMenuChildView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.ForwardingListener;
import androidx.appcompat.widget.TooltipCompat;

public class ActionMenuItemView extends AppCompatTextView implements View$OnClickListener, ItemView, ActionMenuChildView {
    class ActionMenuItemForwardingListener extends ForwardingListener {
        public ActionMenuItemForwardingListener(ActionMenuItemView arg1) {
            ActionMenuItemView.this = arg1;
            super(((View)arg1));
        }

        public ShowableListMenu getPopup() {
            if(ActionMenuItemView.this.mPopupCallback != null) {
                return ActionMenuItemView.this.mPopupCallback.getPopup();
            }

            return null;
        }

        protected boolean onForwardingStarted() {
            if(ActionMenuItemView.this.mItemInvoker != null && (ActionMenuItemView.this.mItemInvoker.invokeItem(ActionMenuItemView.this.mItemData))) {
                ShowableListMenu v3 = this.getPopup();
                if(v3 != null && (v3.isShowing())) {
                    return 1;
                }
            }

            return 0;
        }
    }

    public abstract class PopupCallback {
        public PopupCallback() {
            super();
        }

        public abstract ShowableListMenu getPopup();
    }

    private static final int MAX_ICON_SIZE = 0x20;
    private static final String TAG = "ActionMenuItemView";
    private boolean mAllowTextWithIcon;
    private boolean mExpandedFormat;
    private ForwardingListener mForwardingListener;
    private Drawable mIcon;
    MenuItemImpl mItemData;
    ItemInvoker mItemInvoker;
    private int mMaxIconSize;
    private int mMinWidth;
    PopupCallback mPopupCallback;
    private int mSavedPaddingLeft;
    private CharSequence mTitle;

    public ActionMenuItemView(Context arg2) {
        this(arg2, null);
    }

    public ActionMenuItemView(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, 0);
    }

    public ActionMenuItemView(Context arg4, AttributeSet arg5, int arg6) {
        super(arg4, arg5, arg6);
        Resources v0 = arg4.getResources();
        this.mAllowTextWithIcon = this.shouldAllowTextWithIcon();
        TypedArray v4 = arg4.obtainStyledAttributes(arg5, styleable.ActionMenuItemView, arg6, 0);
        this.mMinWidth = v4.getDimensionPixelSize(styleable.ActionMenuItemView_android_minWidth, 0);
        v4.recycle();
        this.mMaxIconSize = ((int)(v0.getDisplayMetrics().density * 32f + 0.5f));
        this.setOnClickListener(((View$OnClickListener)this));
        this.mSavedPaddingLeft = -1;
        this.setSaveEnabled(false);
    }

    public CharSequence getAccessibilityClassName() {
        return Button.class.getName();
    }

    public MenuItemImpl getItemData() {
        return this.mItemData;
    }

    public boolean hasText() {
        return TextUtils.isEmpty(this.getText()) ^ 1;
    }

    public void initialize(MenuItemImpl arg1, int arg2) {
        this.mItemData = arg1;
        this.setIcon(arg1.getIcon());
        this.setTitle(arg1.getTitleForItemView(((ItemView)this)));
        this.setId(arg1.getItemId());
        arg2 = arg1.isVisible() ? 0 : 8;
        this.setVisibility(arg2);
        this.setEnabled(arg1.isEnabled());
        if((arg1.hasSubMenu()) && this.mForwardingListener == null) {
            this.mForwardingListener = new ActionMenuItemForwardingListener(this);
        }
    }

    public boolean needsDividerAfter() {
        return this.hasText();
    }

    public boolean needsDividerBefore() {
        if((this.hasText()) && this.mItemData.getIcon() == null) {
            return 1;
        }

        return 0;
    }

    public void onClick(View arg1) {
        ItemInvoker v1 = this.mItemInvoker;
        if(v1 != null) {
            v1.invokeItem(this.mItemData);
        }
    }

    public void onConfigurationChanged(Configuration arg1) {
        super.onConfigurationChanged(arg1);
        this.mAllowTextWithIcon = this.shouldAllowTextWithIcon();
        this.updateTextButtonVisibility();
    }

    protected void onMeasure(int arg6, int arg7) {
        int v1;
        boolean v0 = this.hasText();
        if(v0) {
            v1 = this.mSavedPaddingLeft;
            if(v1 >= 0) {
                super.setPadding(v1, this.getPaddingTop(), this.getPaddingRight(), this.getPaddingBottom());
            }
        }

        super.onMeasure(arg6, arg7);
        v1 = View$MeasureSpec.getMode(arg6);
        arg6 = View$MeasureSpec.getSize(arg6);
        int v2 = this.getMeasuredWidth();
        int v3 = this.mMinWidth;
        if(v1 == 0x80000000) {
            v3 = Math.min(arg6, v3);
        }

        arg6 = 0x40000000;
        if(v1 != arg6 && this.mMinWidth > 0 && v2 < v3) {
            super.onMeasure(View$MeasureSpec.makeMeasureSpec(v3, arg6), arg7);
        }

        if(!v0 && this.mIcon != null) {
            super.setPadding((this.getMeasuredWidth() - this.mIcon.getBounds().width()) / 2, this.getPaddingTop(), this.getPaddingRight(), this.getPaddingBottom());
        }
    }

    public void onRestoreInstanceState(Parcelable arg1) {
        super.onRestoreInstanceState(null);
    }

    public boolean onTouchEvent(MotionEvent arg2) {
        if(this.mItemData.hasSubMenu()) {
            ForwardingListener v0 = this.mForwardingListener;
            if(v0 != null && (v0.onTouch(((View)this), arg2))) {
                return 1;
            }
        }

        return super.onTouchEvent(arg2);
    }

    public boolean prefersCondensedTitle() {
        return 1;
    }

    public void setCheckable(boolean arg1) {
    }

    public void setChecked(boolean arg1) {
    }

    public void setExpandedFormat(boolean arg2) {
        if(this.mExpandedFormat != arg2) {
            this.mExpandedFormat = arg2;
            MenuItemImpl v1 = this.mItemData;
            if(v1 != null) {
                v1.actionFormatChanged();
            }
        }
    }

    public void setIcon(Drawable arg5) {
        this.mIcon = arg5;
        if(arg5 != null) {
            int v0 = arg5.getIntrinsicWidth();
            int v1 = arg5.getIntrinsicHeight();
            int v2 = this.mMaxIconSize;
            if(v0 > v2) {
                v1 = ((int)((((float)v1)) * ((((float)v2)) / (((float)v0)))));
                v0 = v2;
            }

            if(v1 > v2) {
                v0 = ((int)((((float)v0)) * ((((float)v2)) / (((float)v1)))));
            }
            else {
                v2 = v1;
            }

            arg5.setBounds(0, 0, v0, v2);
        }

        this.setCompoundDrawables(arg5, null, null, null);
        this.updateTextButtonVisibility();
    }

    public void setItemInvoker(ItemInvoker arg1) {
        this.mItemInvoker = arg1;
    }

    public void setPadding(int arg1, int arg2, int arg3, int arg4) {
        this.mSavedPaddingLeft = arg1;
        super.setPadding(arg1, arg2, arg3, arg4);
    }

    public void setPopupCallback(PopupCallback arg1) {
        this.mPopupCallback = arg1;
    }

    public void setShortcut(boolean arg1, char arg2) {
    }

    public void setTitle(CharSequence arg1) {
        this.mTitle = arg1;
        this.updateTextButtonVisibility();
    }

    private boolean shouldAllowTextWithIcon() {
        Configuration v4 = this.getContext().getResources().getConfiguration();
        int v0 = v4.screenWidthDp;
        int v1 = v4.screenHeightDp;
        int v2 = 480;
        if(v0 < v2 && (v0 < 640 || v1 < v2) && v4.orientation != 2) {
            return 0;
        }

        return 1;
    }

    public boolean showsIcon() {
        return 1;
    }

    private void updateTextButtonVisibility() {
        int v1 = 1;
        int v0 = TextUtils.isEmpty(this.mTitle) ^ 1;
        if(this.mIcon != null) {
            if(this.mItemData.showsTextAsAction()) {
                if(this.mAllowTextWithIcon) {
                    goto label_15;
                }
                else if(this.mExpandedFormat) {
                    goto label_15;
                }
            }

            v1 = 0;
        }

    label_15:
        v0 &= v1;
        CharSequence v1_1 = null;
        CharSequence v2 = v0 != 0 ? this.mTitle : v1_1;
        this.setText(v2);
        v2 = this.mItemData.getContentDescription();
        if(TextUtils.isEmpty(v2)) {
            v2 = v0 != 0 ? v1_1 : this.mItemData.getTitle();
            this.setContentDescription(v2);
        }
        else {
            this.setContentDescription(v2);
        }

        v2 = this.mItemData.getTooltipText();
        if(TextUtils.isEmpty(v2)) {
            if(v0 != 0) {
            }
            else {
                v1_1 = this.mItemData.getTitle();
            }

            TooltipCompat.setTooltipText(((View)this), v1_1);
            return;
        }

        TooltipCompat.setTooltipText(((View)this), v2);
    }
}

