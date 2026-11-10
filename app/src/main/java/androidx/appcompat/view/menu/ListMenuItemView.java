package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup;
import android.widget.AbsListView$SelectionBoundsAdjuster;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout$LayoutParams;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.ViewCompat;

public class ListMenuItemView extends LinearLayout implements AbsListView$SelectionBoundsAdjuster, ItemView {
    private static final String TAG = "ListMenuItemView";
    private Drawable mBackground;
    private CheckBox mCheckBox;
    private LinearLayout mContent;
    private boolean mForceShowIcon;
    private ImageView mGroupDivider;
    private boolean mHasListDivider;
    private ImageView mIconView;
    private LayoutInflater mInflater;
    private MenuItemImpl mItemData;
    private boolean mPreserveIconSpacing;
    private RadioButton mRadioButton;
    private TextView mShortcutView;
    private Drawable mSubMenuArrow;
    private ImageView mSubMenuArrowView;
    private int mTextAppearance;
    private Context mTextAppearanceContext;
    private TextView mTitleView;

    public ListMenuItemView(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, attr.listMenuViewStyle);
    }

    public ListMenuItemView(Context arg4, AttributeSet arg5, int arg6) {
        super(arg4, arg5);
        TintTypedArray v5 = TintTypedArray.obtainStyledAttributes(this.getContext(), arg5, styleable.MenuView, arg6, 0);
        this.mBackground = v5.getDrawable(styleable.MenuView_android_itemBackground);
        this.mTextAppearance = v5.getResourceId(styleable.MenuView_android_itemTextAppearance, -1);
        this.mPreserveIconSpacing = v5.getBoolean(styleable.MenuView_preserveIconSpacing, false);
        this.mTextAppearanceContext = arg4;
        this.mSubMenuArrow = v5.getDrawable(styleable.MenuView_subMenuArrow);
        TypedArray v4 = arg4.getTheme().obtainStyledAttributes(null, new int[]{0x1010129}, attr.dropDownListViewStyle, 0);
        this.mHasListDivider = v4.hasValue(0);
        v5.recycle();
        v4.recycle();
    }

    private void addContentView(View arg2) {
        this.addContentView(arg2, -1);
    }

    private void addContentView(View arg2, int arg3) {
        LinearLayout v0 = this.mContent;
        if(v0 != null) {
            v0.addView(arg2, arg3);
            return;
        }

        this.addView(arg2, arg3);
    }

    public void adjustListItemSelectionBounds(Rect arg4) {
        ImageView v0 = this.mGroupDivider;
        if(v0 != null && v0.getVisibility() == 0) {
            ViewGroup$LayoutParams v0_1 = this.mGroupDivider.getLayoutParams();
            arg4.top += this.mGroupDivider.getHeight() + ((LinearLayout$LayoutParams)v0_1).topMargin + ((LinearLayout$LayoutParams)v0_1).bottomMargin;
        }
    }

    private LayoutInflater getInflater() {
        LayoutInflater v0 = this.mInflater;
        if(v0 == null) {
            v0 = LayoutInflater.from(this.getContext());
            this.mInflater = v0;
        }

        return v0;
    }

    public MenuItemImpl getItemData() {
        return this.mItemData;
    }

    public void initialize(MenuItemImpl arg2, int arg3) {
        this.mItemData = arg2;
        arg3 = arg2.isVisible() ? 0 : 8;
        this.setVisibility(arg3);
        this.setTitle(arg2.getTitleForItemView(((ItemView)this)));
        this.setCheckable(arg2.isCheckable());
        this.setShortcut(arg2.shouldShowShortcut(), arg2.getShortcut());
        this.setIcon(arg2.getIcon());
        this.setEnabled(arg2.isEnabled());
        this.setSubMenuArrowVisible(arg2.hasSubMenu());
        this.setContentDescription(arg2.getContentDescription());
    }

    private void insertCheckBox() {
        View v0 = this.getInflater().inflate(layout.abc_list_menu_item_checkbox, ((ViewGroup)this), false);
        this.mCheckBox = ((CheckBox)v0);
        this.addContentView(v0);
    }

    private void insertIconView() {
        View v0 = this.getInflater().inflate(layout.abc_list_menu_item_icon, ((ViewGroup)this), false);
        this.mIconView = ((ImageView)v0);
        this.addContentView(v0, 0);
    }

    private void insertRadioButton() {
        View v0 = this.getInflater().inflate(layout.abc_list_menu_item_radio, ((ViewGroup)this), false);
        this.mRadioButton = ((RadioButton)v0);
        this.addContentView(v0);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        ViewCompat.setBackground(((View)this), this.mBackground);
        View v0 = this.findViewById(id.title);
        this.mTitleView = ((TextView)v0);
        int v1 = this.mTextAppearance;
        if(v1 != -1) {
            ((TextView)v0).setTextAppearance(this.mTextAppearanceContext, v1);
        }

        this.mShortcutView = this.findViewById(id.shortcut);
        v0 = this.findViewById(id.submenuarrow);
        this.mSubMenuArrowView = ((ImageView)v0);
        if(v0 != null) {
            ((ImageView)v0).setImageDrawable(this.mSubMenuArrow);
        }

        this.mGroupDivider = this.findViewById(id.group_divider);
        this.mContent = this.findViewById(id.content);
    }

    protected void onMeasure(int arg4, int arg5) {
        if(this.mIconView != null && (this.mPreserveIconSpacing)) {
            ViewGroup$LayoutParams v0 = this.getLayoutParams();
            ViewGroup$LayoutParams v1 = this.mIconView.getLayoutParams();
            if(v0.height > 0 && ((LinearLayout$LayoutParams)v1).width <= 0) {
                ((LinearLayout$LayoutParams)v1).width = v0.height;
            }
        }

        super.onMeasure(arg4, arg5);
    }

    public boolean prefersCondensedTitle() {
        return 0;
    }

    public void setCheckable(boolean arg5) {
        CheckBox v0_1;
        CheckBox v2;
        CheckBox v1;
        if((arg5) || this.mRadioButton != null || this.mCheckBox != null) {
            if(this.mItemData.isExclusiveCheckable()) {
                if(this.mRadioButton == null) {
                    this.insertRadioButton();
                }

                RadioButton v0 = this.mRadioButton;
                v1 = this.mCheckBox;
                v2 = v1;
            }
            else {
                if(this.mCheckBox == null) {
                    this.insertCheckBox();
                }

                v0_1 = this.mCheckBox;
                RadioButton v1_1 = this.mRadioButton;
                v2 = v0_1;
            }

            int v3 = 8;
            if(arg5) {
                ((CompoundButton)v0_1).setChecked(this.mItemData.isChecked());
                if(((CompoundButton)v0_1).getVisibility() != 0) {
                    ((CompoundButton)v0_1).setVisibility(0);
                }

                if(v1 == null) {
                    return;
                }

                if(((CompoundButton)v1).getVisibility() == v3) {
                    return;
                }

                ((CompoundButton)v1).setVisibility(v3);
                return;
            }

            if(v2 != null) {
                v2.setVisibility(v3);
            }

            RadioButton v4 = this.mRadioButton;
            if(v4 == null) {
                return;
            }

            v4.setVisibility(v3);
        }
        else {
        }
    }

    public void setChecked(boolean arg2) {
        CheckBox v1_1;
        if(this.mItemData.isExclusiveCheckable()) {
            if(this.mRadioButton == null) {
                this.insertRadioButton();
            }

            RadioButton v1 = this.mRadioButton;
        }
        else {
            if(this.mCheckBox == null) {
                this.insertCheckBox();
            }

            v1_1 = this.mCheckBox;
        }

        ((CompoundButton)v1_1).setChecked(arg2);
    }

    public void setForceShowIcon(boolean arg1) {
        this.mForceShowIcon = arg1;
        this.mPreserveIconSpacing = arg1;
    }

    public void setGroupDividerEnabled(boolean arg2) {
        ImageView v0 = this.mGroupDivider;
        if(v0 != null) {
            int v1 = (this.mHasListDivider) || !arg2 ? 8 : 0;
            v0.setVisibility(v1);
        }
    }

    public void setIcon(Drawable arg5) {
        int v0 = (this.mItemData.shouldShowIcon()) || (this.mForceShowIcon) ? 1 : 0;
        if(v0 != 0 || (this.mPreserveIconSpacing)) {
            ImageView v2 = this.mIconView;
            if(v2 == null && arg5 == null && !this.mPreserveIconSpacing) {
                return;
            }

            if(v2 == null) {
                this.insertIconView();
            }

            if(arg5 == null) {
                if(this.mPreserveIconSpacing) {
                }
                else {
                    this.mIconView.setVisibility(8);
                    return;
                }
            }

            v2 = this.mIconView;
            if(v0 != 0) {
            }
            else {
                arg5 = null;
            }

            v2.setImageDrawable(arg5);
            if(this.mIconView.getVisibility() == 0) {
                return;
            }

            this.mIconView.setVisibility(0);
        }
        else {
        }
    }

    public void setShortcut(boolean arg2, char arg3) {
        int v2 = !arg2 || !this.mItemData.shouldShowShortcut() ? 8 : 0;
        if(v2 == 0) {
            this.mShortcutView.setText(this.mItemData.getShortcutLabel());
        }

        if(this.mShortcutView.getVisibility() != v2) {
            this.mShortcutView.setVisibility(v2);
        }
    }

    private void setSubMenuArrowVisible(boolean arg1) {
        ImageView v0 = this.mSubMenuArrowView;
        if(v0 != null) {
            int v1 = arg1 ? 0 : 8;
            v0.setVisibility(v1);
        }
    }

    public void setTitle(CharSequence arg2) {
        TextView v0 = this.mTitleView;
        if(arg2 != null) {
            v0.setText(arg2);
            if(this.mTitleView.getVisibility() != 0) {
                this.mTitleView.setVisibility(0);
                return;
            }
        }
        else {
            int v2 = v0.getVisibility();
            int v0_1 = 8;
            if(v2 != v0_1) {
                this.mTitleView.setVisibility(v0_1);
            }
        }
    }

    public boolean showsIcon() {
        return this.mForceShowIcon;
    }
}

