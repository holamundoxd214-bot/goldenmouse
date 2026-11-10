package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build$VERSION;
import android.os.Parcel;
import android.os.Parcelable$ClassLoaderCreator;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextUtils$TruncateAt;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View$MeasureSpec;
import android.view.View$OnClickListener;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$styleable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.CollapsibleActionView;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter$Callback;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.core.view.GravityCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.MenuHost;
import androidx.core.view.MenuHostHelper;
import androidx.core.view.MenuProvider;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import androidx.lifecycle.Lifecycle$State;
import androidx.lifecycle.LifecycleOwner;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Toolbar extends ViewGroup implements MenuHost {
    class androidx.appcompat.widget.Toolbar$1 implements OnMenuItemClickListener {
        androidx.appcompat.widget.Toolbar$1(Toolbar arg1) {
            Toolbar.this = arg1;
            super();
        }

        public boolean onMenuItemClick(MenuItem arg2) {
            if(Toolbar.this.mMenuHostHelper.onMenuItemSelected(arg2)) {
                return 1;
            }

            if(Toolbar.this.mOnMenuItemClickListener != null) {
                return Toolbar.this.mOnMenuItemClickListener.onMenuItemClick(arg2);
            }

            return 0;
        }
    }

    class androidx.appcompat.widget.Toolbar$2 implements Runnable {
        androidx.appcompat.widget.Toolbar$2(Toolbar arg1) {
            Toolbar.this = arg1;
            super();
        }

        public void run() {
            Toolbar.this.showOverflowMenu();
        }
    }

    class Api33Impl {
        private Api33Impl() {
            super();
        }

        static OnBackInvokedDispatcher findOnBackInvokedDispatcher(View arg0) {
            return arg0.findOnBackInvokedDispatcher();
        }

        static OnBackInvokedCallback newOnBackInvokedCallback(Runnable arg1) {
            Objects.requireNonNull(arg1);
            return new Toolbar$Api33Impl$$ExternalSyntheticLambda0(arg1);
        }

        static void tryRegisterOnBackInvokedCallback(Object arg1, Object arg2) {
            ((OnBackInvokedDispatcher)arg1).registerOnBackInvokedCallback(1000000, ((OnBackInvokedCallback)arg2));
        }

        static void tryUnregisterOnBackInvokedCallback(Object arg0, Object arg1) {
            ((OnBackInvokedDispatcher)arg0).unregisterOnBackInvokedCallback(((OnBackInvokedCallback)arg1));
        }
    }

    class ExpandedActionViewMenuPresenter implements MenuPresenter {
        MenuItemImpl mCurrentExpandedItem;
        MenuBuilder mMenu;

        ExpandedActionViewMenuPresenter(Toolbar arg1) {
            Toolbar.this = arg1;
            super();
        }

        public boolean collapseItemActionView(MenuBuilder arg2, MenuItemImpl arg3) {
            if((Toolbar.this.mExpandedActionView instanceof CollapsibleActionView)) {
                Toolbar.this.mExpandedActionView.onActionViewCollapsed();
            }

            Toolbar.this.removeView(Toolbar.this.mExpandedActionView);
            Toolbar.this.removeView(Toolbar.this.mCollapseButtonView);
            Toolbar.this.mExpandedActionView = null;
            Toolbar.this.addChildrenForExpandedActionView();
            this.mCurrentExpandedItem = null;
            Toolbar.this.requestLayout();
            arg3.setActionViewExpanded(false);
            Toolbar.this.updateBackInvokedCallbackState();
            return 1;
        }

        public boolean expandItemActionView(MenuBuilder arg3, MenuItemImpl arg4) {
            Toolbar.this.ensureCollapseButtonView();
            ViewParent v3 = Toolbar.this.mCollapseButtonView.getParent();
            Toolbar v0 = Toolbar.this;
            if(v3 != (((ViewParent)v0))) {
                if((v3 instanceof ViewGroup)) {
                    ((ViewGroup)v3).removeView(v0.mCollapseButtonView);
                }

                Toolbar.this.addView(Toolbar.this.mCollapseButtonView);
            }

            Toolbar.this.mExpandedActionView = arg4.getActionView();
            this.mCurrentExpandedItem = arg4;
            v3 = Toolbar.this.mExpandedActionView.getParent();
            v0 = Toolbar.this;
            if(v3 != (((ViewParent)v0))) {
                if((v3 instanceof ViewGroup)) {
                    ((ViewGroup)v3).removeView(v0.mExpandedActionView);
                }

                LayoutParams v3_1 = Toolbar.this.generateDefaultLayoutParams();
                v3_1.gravity = Toolbar.this.mButtonGravity & 0x70 | 0x800003;
                v3_1.mViewType = 2;
                Toolbar.this.mExpandedActionView.setLayoutParams(((ViewGroup$LayoutParams)v3_1));
                Toolbar.this.addView(Toolbar.this.mExpandedActionView);
            }

            Toolbar.this.removeChildrenForExpandedActionView();
            Toolbar.this.requestLayout();
            arg4.setActionViewExpanded(true);
            if((Toolbar.this.mExpandedActionView instanceof CollapsibleActionView)) {
                Toolbar.this.mExpandedActionView.onActionViewExpanded();
            }

            Toolbar.this.updateBackInvokedCallbackState();
            return 1;
        }

        public boolean flagActionItems() {
            return 0;
        }

        public int getId() {
            return 0;
        }

        public MenuView getMenuView(ViewGroup arg1) {
            return null;
        }

        public void initForMenu(Context arg2, MenuBuilder arg3) {
            MenuBuilder v2 = this.mMenu;
            if(v2 != null) {
                MenuItemImpl v0 = this.mCurrentExpandedItem;
                if(v0 != null) {
                    v2.collapseItemActionView(v0);
                }
            }

            this.mMenu = arg3;
        }

        public void onCloseMenu(MenuBuilder arg1, boolean arg2) {
        }

        public void onRestoreInstanceState(Parcelable arg1) {
        }

        public Parcelable onSaveInstanceState() {
            return null;
        }

        public boolean onSubMenuSelected(SubMenuBuilder arg1) {
            return 0;
        }

        public void setCallback(Callback arg1) {
        }

        public void updateMenuView(boolean arg4) {
            if(this.mCurrentExpandedItem != null) {
                MenuBuilder v4 = this.mMenu;
                if(v4 != null) {
                    int v4_1 = v4.size();
                    int v0 = 0;
                    while(v0 < v4_1) {
                        if(this.mMenu.getItem(v0) == this.mCurrentExpandedItem) {
                            return;
                        }
                        else {
                            ++v0;
                            continue;
                        }

                        break;
                    }
                }

                this.collapseItemActionView(this.mMenu, this.mCurrentExpandedItem);
            }
        }
    }

    public class LayoutParams extends androidx.appcompat.app.ActionBar$LayoutParams {
        static final int CUSTOM = 0;
        static final int EXPANDED = 2;
        static final int SYSTEM = 1;
        int mViewType;

        public LayoutParams(int arg1, int arg2) {
            super(arg1, arg2);
            this.mViewType = 0;
            this.gravity = 0x800013;
        }

        public LayoutParams(Context arg1, AttributeSet arg2) {
            super(arg1, arg2);
            this.mViewType = 0;
        }

        public LayoutParams(LayoutParams arg2) {
            super(((androidx.appcompat.app.ActionBar$LayoutParams)arg2));
            this.mViewType = 0;
            this.mViewType = arg2.mViewType;
        }

        public LayoutParams(androidx.appcompat.app.ActionBar$LayoutParams arg1) {
            super(arg1);
            this.mViewType = 0;
        }

        public LayoutParams(ViewGroup$MarginLayoutParams arg2) {
            super(((ViewGroup$LayoutParams)arg2));
            this.mViewType = 0;
            this.copyMarginsFromCompat(arg2);
        }

        public LayoutParams(ViewGroup$LayoutParams arg1) {
            super(arg1);
            this.mViewType = 0;
        }

        public LayoutParams(int arg3) {
            this(-2, -1, arg3);
        }

        public LayoutParams(int arg1, int arg2, int arg3) {
            super(arg1, arg2);
            this.mViewType = 0;
            this.gravity = arg3;
        }

        void copyMarginsFromCompat(ViewGroup$MarginLayoutParams arg2) {
            this.leftMargin = arg2.leftMargin;
            this.topMargin = arg2.topMargin;
            this.rightMargin = arg2.rightMargin;
            this.bottomMargin = arg2.bottomMargin;
        }
    }

    public interface androidx.appcompat.widget.Toolbar$OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem arg1);
    }

    public class SavedState extends AbsSavedState {
        class androidx.appcompat.widget.Toolbar$SavedState$1 implements Parcelable$ClassLoaderCreator {
            androidx.appcompat.widget.Toolbar$SavedState$1() {
                super();
            }

            public SavedState createFromParcel(Parcel arg2) {
                return new SavedState(arg2, null);
            }

            public SavedState createFromParcel(Parcel arg1, ClassLoader arg2) {
                return new SavedState(arg1, arg2);
            }

            public Object createFromParcel(Parcel arg1) {
                return this.createFromParcel(arg1);
            }

            public Object createFromParcel(Parcel arg1, ClassLoader arg2) {
                return this.createFromParcel(arg1, arg2);
            }

            public SavedState[] newArray(int arg1) {
                return new SavedState[arg1];
            }

            public Object[] newArray(int arg1) {
                return this.newArray(arg1);
            }
        }

        public static final Parcelable$Creator CREATOR;
        int expandedMenuItemId;
        boolean isOverflowOpen;

        static {
            SavedState.CREATOR = new androidx.appcompat.widget.Toolbar$SavedState$1();
        }

        public SavedState(Parcelable arg1) {
            super(arg1);
        }

        public SavedState(Parcel arg2) {
            this(arg2, null);
        }

        public SavedState(Parcel arg1, ClassLoader arg2) {
            super(arg1, arg2);
            this.expandedMenuItemId = arg1.readInt();
            boolean v1 = arg1.readInt() != 0 ? true : false;
            this.isOverflowOpen = v1;
        }

        public void writeToParcel(Parcel arg1, int arg2) {
            super.writeToParcel(arg1, arg2);
            arg1.writeInt(this.expandedMenuItemId);
            arg1.writeInt(this.isOverflowOpen);
        }
    }

    private static final String TAG = "Toolbar";
    private Callback mActionMenuPresenterCallback;
    private OnBackInvokedCallback mBackInvokedCallback;
    private boolean mBackInvokedCallbackEnabled;
    private OnBackInvokedDispatcher mBackInvokedDispatcher;
    int mButtonGravity;
    ImageButton mCollapseButtonView;
    private CharSequence mCollapseDescription;
    private Drawable mCollapseIcon;
    private boolean mCollapsible;
    private int mContentInsetEndWithActions;
    private int mContentInsetStartWithNavigation;
    private RtlSpacingHelper mContentInsets;
    private boolean mEatingHover;
    private boolean mEatingTouch;
    View mExpandedActionView;
    private ExpandedActionViewMenuPresenter mExpandedMenuPresenter;
    private int mGravity;
    private final ArrayList mHiddenViews;
    private ImageView mLogoView;
    private int mMaxButtonHeight;
    androidx.appcompat.view.menu.MenuBuilder$Callback mMenuBuilderCallback;
    final MenuHostHelper mMenuHostHelper;
    ActionMenuView mMenuView;
    private final OnMenuItemClickListener mMenuViewItemClickListener;
    private ImageButton mNavButtonView;
    androidx.appcompat.widget.Toolbar$OnMenuItemClickListener mOnMenuItemClickListener;
    private ActionMenuPresenter mOuterActionMenuPresenter;
    private Context mPopupContext;
    private int mPopupTheme;
    private ArrayList mProvidedMenuItems;
    private final Runnable mShowOverflowMenuRunnable;
    private CharSequence mSubtitleText;
    private int mSubtitleTextAppearance;
    private ColorStateList mSubtitleTextColor;
    private TextView mSubtitleTextView;
    private final int[] mTempMargins;
    private final ArrayList mTempViews;
    private int mTitleMarginBottom;
    private int mTitleMarginEnd;
    private int mTitleMarginStart;
    private int mTitleMarginTop;
    private CharSequence mTitleText;
    private int mTitleTextAppearance;
    private ColorStateList mTitleTextColor;
    private TextView mTitleTextView;
    private ToolbarWidgetWrapper mWrapper;

    public Toolbar(Context arg2) {
        this(arg2, null);
    }

    public Toolbar(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, attr.toolbarStyle);
    }

    public Toolbar(Context arg11, AttributeSet arg12, int arg13) {
        super(arg11, arg12, arg13);
        this.mGravity = 0x800013;
        this.mTempViews = new ArrayList();
        this.mHiddenViews = new ArrayList();
        this.mTempMargins = new int[2];
        this.mMenuHostHelper = new MenuHostHelper(new Toolbar$$ExternalSyntheticLambda1(this));
        this.mProvidedMenuItems = new ArrayList();
        this.mMenuViewItemClickListener = new androidx.appcompat.widget.Toolbar$1(this);
        this.mShowOverflowMenuRunnable = new androidx.appcompat.widget.Toolbar$2(this);
        TintTypedArray v0 = TintTypedArray.obtainStyledAttributes(this.getContext(), arg12, styleable.Toolbar, arg13, 0);
        Toolbar v3 = this;
        ViewCompat.saveAttributeDataForStyleable(((View)v3), arg11, styleable.Toolbar, arg12, v0.getWrappedTypeArray(), arg13, 0);
        v3.mTitleTextAppearance = v0.getResourceId(styleable.Toolbar_titleTextAppearance, 0);
        v3.mSubtitleTextAppearance = v0.getResourceId(styleable.Toolbar_subtitleTextAppearance, 0);
        v3.mGravity = v0.getInteger(styleable.Toolbar_android_gravity, v3.mGravity);
        v3.mButtonGravity = v0.getInteger(styleable.Toolbar_buttonGravity, 0x30);
        int v10 = v0.getDimensionPixelOffset(styleable.Toolbar_titleMargin, 0);
        if(v0.hasValue(styleable.Toolbar_titleMargins)) {
            v10 = v0.getDimensionPixelOffset(styleable.Toolbar_titleMargins, v10);
        }

        v3.mTitleMarginBottom = v10;
        v3.mTitleMarginTop = v10;
        v3.mTitleMarginEnd = v10;
        v3.mTitleMarginStart = v10;
        int v11 = -1;
        v10 = v0.getDimensionPixelOffset(styleable.Toolbar_titleMarginStart, v11);
        if(v10 >= 0) {
            v3.mTitleMarginStart = v10;
        }

        v10 = v0.getDimensionPixelOffset(styleable.Toolbar_titleMarginEnd, v11);
        if(v10 >= 0) {
            v3.mTitleMarginEnd = v10;
        }

        v10 = v0.getDimensionPixelOffset(styleable.Toolbar_titleMarginTop, v11);
        if(v10 >= 0) {
            v3.mTitleMarginTop = v10;
        }

        v10 = v0.getDimensionPixelOffset(styleable.Toolbar_titleMarginBottom, v11);
        if(v10 >= 0) {
            v3.mTitleMarginBottom = v10;
        }

        v3.mMaxButtonHeight = v0.getDimensionPixelSize(styleable.Toolbar_maxButtonHeight, v11);
        v11 = 0x80000000;
        v10 = v0.getDimensionPixelOffset(styleable.Toolbar_contentInsetStart, v11);
        int v12 = v0.getDimensionPixelOffset(styleable.Toolbar_contentInsetEnd, v11);
        arg13 = v0.getDimensionPixelSize(styleable.Toolbar_contentInsetLeft, 0);
        int v1 = v0.getDimensionPixelSize(styleable.Toolbar_contentInsetRight, 0);
        v3.ensureContentInsets();
        v3.mContentInsets.setAbsolute(arg13, v1);
        if(v10 != v11 || v12 != v11) {
            v3.mContentInsets.setRelative(v10, v12);
        }

        v3.mContentInsetStartWithNavigation = v0.getDimensionPixelOffset(styleable.Toolbar_contentInsetStartWithNavigation, v11);
        v3.mContentInsetEndWithActions = v0.getDimensionPixelOffset(styleable.Toolbar_contentInsetEndWithActions, v11);
        v3.mCollapseIcon = v0.getDrawable(styleable.Toolbar_collapseIcon);
        v3.mCollapseDescription = v0.getText(styleable.Toolbar_collapseContentDescription);
        CharSequence v10_1 = v0.getText(styleable.Toolbar_title);
        if(!TextUtils.isEmpty(v10_1)) {
            v3.setTitle(v10_1);
        }

        v10_1 = v0.getText(styleable.Toolbar_subtitle);
        if(!TextUtils.isEmpty(v10_1)) {
            v3.setSubtitle(v10_1);
        }

        v3.mPopupContext = v3.getContext();
        v3.setPopupTheme(v0.getResourceId(styleable.Toolbar_popupTheme, 0));
        Drawable v10_2 = v0.getDrawable(styleable.Toolbar_navigationIcon);
        if(v10_2 != null) {
            v3.setNavigationIcon(v10_2);
        }

        v10_1 = v0.getText(styleable.Toolbar_navigationContentDescription);
        if(!TextUtils.isEmpty(v10_1)) {
            v3.setNavigationContentDescription(v10_1);
        }

        v10_2 = v0.getDrawable(styleable.Toolbar_logo);
        if(v10_2 != null) {
            v3.setLogo(v10_2);
        }

        v10_1 = v0.getText(styleable.Toolbar_logoDescription);
        if(!TextUtils.isEmpty(v10_1)) {
            v3.setLogoDescription(v10_1);
        }

        if(v0.hasValue(styleable.Toolbar_titleTextColor)) {
            v3.setTitleTextColor(v0.getColorStateList(styleable.Toolbar_titleTextColor));
        }

        if(v0.hasValue(styleable.Toolbar_subtitleTextColor)) {
            v3.setSubtitleTextColor(v0.getColorStateList(styleable.Toolbar_subtitleTextColor));
        }

        if(v0.hasValue(styleable.Toolbar_menu)) {
            v3.inflateMenu(v0.getResourceId(styleable.Toolbar_menu, 0));
        }

        v0.recycle();
    }

    void addChildrenForExpandedActionView() {
        ArrayList v1;
        int v0;
        for(v0 = this.mHiddenViews.size() - 1; true; --v0) {
            v1 = this.mHiddenViews;
            if(v0 < 0) {
                break;
            }

            this.addView(v1.get(v0));
        }

        v1.clear();
    }

    private void addCustomViewsWithGravity(List arg6, int arg7) {
        View v0_1;
        int v1 = 0;
        int v0 = ViewCompat.getLayoutDirection(((View)this)) == 1 ? 1 : 0;
        int v3 = this.getChildCount();
        arg7 = GravityCompat.getAbsoluteGravity(arg7, ViewCompat.getLayoutDirection(((View)this)));
        arg6.clear();
        if(v0 != 0) {
            --v3;
            while(v3 >= 0) {
                v0_1 = this.getChildAt(v3);
                ViewGroup$LayoutParams v1_1 = v0_1.getLayoutParams();
                if(((LayoutParams)v1_1).mViewType == 0 && (this.shouldLayout(v0_1)) && this.getChildHorizontalGravity(((LayoutParams)v1_1).gravity) == arg7) {
                    arg6.add(v0_1);
                }

                --v3;
            }
        }
        else {
            while(v1 < v3) {
                v0_1 = this.getChildAt(v1);
                ViewGroup$LayoutParams v2 = v0_1.getLayoutParams();
                if(((LayoutParams)v2).mViewType == 0 && (this.shouldLayout(v0_1)) && this.getChildHorizontalGravity(((LayoutParams)v2).gravity) == arg7) {
                    arg6.add(v0_1);
                }

                ++v1;
            }
        }
    }

    public void addMenuProvider(MenuProvider arg1) {
        this.mMenuHostHelper.addMenuProvider(arg1);
    }

    public void addMenuProvider(MenuProvider arg1, LifecycleOwner arg2) {
        this.mMenuHostHelper.addMenuProvider(arg1, arg2);
    }

    public void addMenuProvider(MenuProvider arg1, LifecycleOwner arg2, State arg3) {
        this.mMenuHostHelper.addMenuProvider(arg1, arg2, arg3);
    }

    private void addSystemView(View arg3, boolean arg4) {
        LayoutParams v0_1;
        ViewGroup$LayoutParams v0 = arg3.getLayoutParams();
        if(v0 == null) {
            v0_1 = this.generateDefaultLayoutParams();
        }
        else if(!this.checkLayoutParams(v0)) {
            v0_1 = this.generateLayoutParams(v0);
        }

        v0_1.mViewType = 1;
        if((arg4) && this.mExpandedActionView != null) {
            arg3.setLayoutParams(((ViewGroup$LayoutParams)v0_1));
            this.mHiddenViews.add(arg3);
            return;
        }

        this.addView(arg3, ((ViewGroup$LayoutParams)v0_1));
    }

    public boolean canShowOverflowMenu() {
        if(this.getVisibility() == 0) {
            ActionMenuView v1 = this.mMenuView;
            if(v1 != null && (v1.isOverflowReserved())) {
                return 1;
            }
        }

        return 0;
    }

    protected boolean checkLayoutParams(ViewGroup$LayoutParams arg1) {
        if((super.checkLayoutParams(arg1)) && ((arg1 instanceof LayoutParams))) {
            return 1;
        }

        return 0;
    }

    public void collapseActionView() {
        ExpandedActionViewMenuPresenter v0 = this.mExpandedMenuPresenter;
        MenuItemImpl v0_1 = v0 == null ? null : v0.mCurrentExpandedItem;
        if(v0_1 != null) {
            v0_1.collapseActionView();
        }
    }

    public void dismissPopupMenus() {
        ActionMenuView v0 = this.mMenuView;
        if(v0 != null) {
            v0.dismissPopupMenus();
        }
    }

    void ensureCollapseButtonView() {
        if(this.mCollapseButtonView == null) {
            AppCompatImageButton v0 = new AppCompatImageButton(this.getContext(), null, attr.toolbarNavigationButtonStyle);
            this.mCollapseButtonView = ((ImageButton)v0);
            ((ImageButton)v0).setImageDrawable(this.mCollapseIcon);
            this.mCollapseButtonView.setContentDescription(this.mCollapseDescription);
            LayoutParams v0_1 = this.generateDefaultLayoutParams();
            v0_1.gravity = this.mButtonGravity & 0x70 | 0x800003;
            v0_1.mViewType = 2;
            this.mCollapseButtonView.setLayoutParams(((ViewGroup$LayoutParams)v0_1));
            this.mCollapseButtonView.setOnClickListener(new View$OnClickListener() {
                public void onClick(View arg1) {
                    Toolbar.this.collapseActionView();
                }
            });
        }
    }

    private void ensureContentInsets() {
        if(this.mContentInsets == null) {
            this.mContentInsets = new RtlSpacingHelper();
        }
    }

    private void ensureLogoView() {
        if(this.mLogoView == null) {
            this.mLogoView = new AppCompatImageView(this.getContext());
        }
    }

    private void ensureMenu() {
        this.ensureMenuView();
        if(this.mMenuView.peekMenu() == null) {
            Menu v0 = this.mMenuView.getMenu();
            if(this.mExpandedMenuPresenter == null) {
                this.mExpandedMenuPresenter = new ExpandedActionViewMenuPresenter(this);
            }

            this.mMenuView.setExpandedActionViewsExclusive(true);
            ((MenuBuilder)v0).addMenuPresenter(this.mExpandedMenuPresenter, this.mPopupContext);
            this.updateBackInvokedCallbackState();
        }
    }

    private void ensureMenuView() {
        if(this.mMenuView == null) {
            ActionMenuView v0 = new ActionMenuView(this.getContext());
            this.mMenuView = v0;
            v0.setPopupTheme(this.mPopupTheme);
            this.mMenuView.setOnMenuItemClickListener(this.mMenuViewItemClickListener);
            this.mMenuView.setMenuCallbacks(this.mActionMenuPresenterCallback, new androidx.appcompat.view.menu.MenuBuilder$Callback() {
                public boolean onMenuItemSelected(MenuBuilder arg2, MenuItem arg3) {
                    if(Toolbar.this.mMenuBuilderCallback != null && (Toolbar.this.mMenuBuilderCallback.onMenuItemSelected(arg2, arg3))) {
                        return 1;
                    }

                    return 0;
                }

                public void onMenuModeChange(MenuBuilder arg2) {
                    if(!Toolbar.this.mMenuView.isOverflowMenuShowing()) {
                        Toolbar.this.mMenuHostHelper.onPrepareMenu(((Menu)arg2));
                    }

                    if(Toolbar.this.mMenuBuilderCallback != null) {
                        Toolbar.this.mMenuBuilderCallback.onMenuModeChange(arg2);
                    }
                }
            });
            LayoutParams v0_1 = this.generateDefaultLayoutParams();
            v0_1.gravity = this.mButtonGravity & 0x70 | 0x800005;
            this.mMenuView.setLayoutParams(((ViewGroup$LayoutParams)v0_1));
            this.addSystemView(this.mMenuView, false);
        }
    }

    private void ensureNavButtonView() {
        if(this.mNavButtonView == null) {
            this.mNavButtonView = new AppCompatImageButton(this.getContext(), null, attr.toolbarNavigationButtonStyle);
            LayoutParams v0 = this.generateDefaultLayoutParams();
            v0.gravity = this.mButtonGravity & 0x70 | 0x800003;
            this.mNavButtonView.setLayoutParams(((ViewGroup$LayoutParams)v0));
        }
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    protected ViewGroup$LayoutParams generateDefaultLayoutParams() {
        return this.generateDefaultLayoutParams();
    }

    protected LayoutParams generateLayoutParams(ViewGroup$LayoutParams arg1) {
        if((arg1 instanceof LayoutParams)) {
            return new LayoutParams(((LayoutParams)arg1));
        }

        if((arg1 instanceof androidx.appcompat.app.ActionBar$LayoutParams)) {
            return new LayoutParams(((androidx.appcompat.app.ActionBar$LayoutParams)arg1));
        }

        if((arg1 instanceof ViewGroup$MarginLayoutParams)) {
            return new LayoutParams(((ViewGroup$MarginLayoutParams)arg1));
        }

        return new LayoutParams(arg1);
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

    private int getChildHorizontalGravity(int arg4) {
        int v3 = ViewCompat.getLayoutDirection(((View)this));
        arg4 = GravityCompat.getAbsoluteGravity(arg4, v3) & 7;
        if(arg4 != 1) {
            int v1 = 3;
            if(arg4 != v1) {
                int v2 = 5;
                if(arg4 != v2) {
                    if(v3 == 1) {
                        return v2;
                    }
                    else {
                        return v1;
                    }
                }
            }
        }

        return arg4;
    }

    private int getChildTop(View arg6, int arg7) {
        ViewGroup$LayoutParams v0 = arg6.getLayoutParams();
        int v6 = arg6.getMeasuredHeight();
        arg7 = arg7 > 0 ? (v6 - arg7) / 2 : 0;
        int v2 = this.getChildVerticalGravity(((LayoutParams)v0).gravity);
        if(v2 != 0x30) {
            if(v2 != 80) {
                arg7 = this.getPaddingTop();
                v2 = this.getPaddingBottom();
                int v5 = this.getHeight();
                int v3 = (v5 - arg7 - v2 - v6) / 2;
                if(v3 < ((LayoutParams)v0).topMargin) {
                    v3 = ((LayoutParams)v0).topMargin;
                }
                else {
                    v5 = v5 - v2 - v6 - v3 - arg7;
                    if(v5 < ((LayoutParams)v0).bottomMargin) {
                        v3 = Math.max(0, v3 - (((LayoutParams)v0).bottomMargin - v5));
                    }
                }

                return arg7 + v3;
            }

            return this.getHeight() - this.getPaddingBottom() - v6 - ((LayoutParams)v0).bottomMargin - arg7;
        }

        return this.getPaddingTop() - arg7;
    }

    private int getChildVerticalGravity(int arg2) {
        arg2 &= 0x70;
        if(arg2 != 16 && arg2 != 0x30 && arg2 != 80) {
            return this.mGravity & 0x70;
        }

        return arg2;
    }

    public CharSequence getCollapseContentDescription() {
        ImageButton v0 = this.mCollapseButtonView;
        if(v0 != null) {
            return v0.getContentDescription();
        }

        return null;
    }

    public Drawable getCollapseIcon() {
        ImageButton v0 = this.mCollapseButtonView;
        if(v0 != null) {
            return v0.getDrawable();
        }

        return null;
    }

    public int getContentInsetEnd() {
        RtlSpacingHelper v0 = this.mContentInsets;
        if(v0 != null) {
            return v0.getEnd();
        }

        return 0;
    }

    public int getContentInsetEndWithActions() {
        int v0 = this.mContentInsetEndWithActions;
        if(v0 != 0x80000000) {
            return v0;
        }

        return this.getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        RtlSpacingHelper v0 = this.mContentInsets;
        if(v0 != null) {
            return v0.getLeft();
        }

        return 0;
    }

    public int getContentInsetRight() {
        RtlSpacingHelper v0 = this.mContentInsets;
        if(v0 != null) {
            return v0.getRight();
        }

        return 0;
    }

    public int getContentInsetStart() {
        RtlSpacingHelper v0 = this.mContentInsets;
        if(v0 != null) {
            return v0.getStart();
        }

        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int v0 = this.mContentInsetStartWithNavigation;
        if(v0 != 0x80000000) {
            return v0;
        }

        return this.getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        ActionMenuView v0 = this.mMenuView;
        if(v0 != null) {
            MenuBuilder v0_1 = v0.peekMenu();
            if(v0_1 != null && (v0_1.hasVisibleItems())) {
                return Math.max(this.getContentInsetEnd(), Math.max(this.mContentInsetEndWithActions, 0));
            }
        }

        return this.getContentInsetEnd();
    }

    public int getCurrentContentInsetLeft() {
        if(ViewCompat.getLayoutDirection(((View)this)) == 1) {
            return this.getCurrentContentInsetEnd();
        }

        return this.getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        if(ViewCompat.getLayoutDirection(((View)this)) == 1) {
            return this.getCurrentContentInsetStart();
        }

        return this.getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        if(this.getNavigationIcon() != null) {
            return Math.max(this.getContentInsetStart(), Math.max(this.mContentInsetStartWithNavigation, 0));
        }

        return this.getContentInsetStart();
    }

    private ArrayList getCurrentMenuItems() {
        ArrayList v0 = new ArrayList();
        Menu v3 = this.getMenu();
        int v1;
        for(v1 = 0; v1 < v3.size(); ++v1) {
            v0.add(v3.getItem(v1));
        }

        return v0;
    }

    private int getHorizontalMargins(View arg1) {
        ViewGroup$LayoutParams v0 = arg1.getLayoutParams();
        return MarginLayoutParamsCompat.getMarginStart(((ViewGroup$MarginLayoutParams)v0)) + MarginLayoutParamsCompat.getMarginEnd(((ViewGroup$MarginLayoutParams)v0));
    }

    public Drawable getLogo() {
        ImageView v0 = this.mLogoView;
        if(v0 != null) {
            return v0.getDrawable();
        }

        return null;
    }

    public CharSequence getLogoDescription() {
        ImageView v0 = this.mLogoView;
        if(v0 != null) {
            return v0.getContentDescription();
        }

        return null;
    }

    public Menu getMenu() {
        this.ensureMenu();
        return this.mMenuView.getMenu();
    }

    private MenuInflater getMenuInflater() {
        return new SupportMenuInflater(this.getContext());
    }

    View getNavButtonView() {
        return this.mNavButtonView;
    }

    public CharSequence getNavigationContentDescription() {
        ImageButton v0 = this.mNavButtonView;
        if(v0 != null) {
            return v0.getContentDescription();
        }

        return null;
    }

    public Drawable getNavigationIcon() {
        ImageButton v0 = this.mNavButtonView;
        if(v0 != null) {
            return v0.getDrawable();
        }

        return null;
    }

    ActionMenuPresenter getOuterActionMenuPresenter() {
        return this.mOuterActionMenuPresenter;
    }

    public Drawable getOverflowIcon() {
        this.ensureMenu();
        return this.mMenuView.getOverflowIcon();
    }

    Context getPopupContext() {
        return this.mPopupContext;
    }

    public int getPopupTheme() {
        return this.mPopupTheme;
    }

    public CharSequence getSubtitle() {
        return this.mSubtitleText;
    }

    final TextView getSubtitleTextView() {
        return this.mSubtitleTextView;
    }

    public CharSequence getTitle() {
        return this.mTitleText;
    }

    public int getTitleMarginBottom() {
        return this.mTitleMarginBottom;
    }

    public int getTitleMarginEnd() {
        return this.mTitleMarginEnd;
    }

    public int getTitleMarginStart() {
        return this.mTitleMarginStart;
    }

    public int getTitleMarginTop() {
        return this.mTitleMarginTop;
    }

    final TextView getTitleTextView() {
        return this.mTitleTextView;
    }

    private int getVerticalMargins(View arg1) {
        ViewGroup$LayoutParams v0 = arg1.getLayoutParams();
        return ((ViewGroup$MarginLayoutParams)v0).topMargin + ((ViewGroup$MarginLayoutParams)v0).bottomMargin;
    }

    private int getViewListMeasuredWidth(List arg8, int[] arg9) {
        int v0 = arg9[0];
        int v9 = arg9[1];
        int v1 = arg8.size();
        int v2 = 0;
        int v3 = 0;
        while(v2 < v1) {
            Object v4 = arg8.get(v2);
            ViewGroup$LayoutParams v5 = ((View)v4).getLayoutParams();
            int v6 = ((LayoutParams)v5).leftMargin - v0;
            v0 = ((LayoutParams)v5).rightMargin - v9;
            v9 = Math.max(0, v6);
            int v5_1 = Math.max(0, v0);
            v6 = Math.max(0, -v6);
            v0 = Math.max(0, -v0);
            v3 += v9 + ((View)v4).getMeasuredWidth() + v5_1;
            ++v2;
            v9 = v0;
            v0 = v6;
        }

        return v3;
    }

    public DecorToolbar getWrapper() {
        ToolbarWidgetWrapper v0 = this.mWrapper;
        if(v0 == null) {
            v0 = new ToolbarWidgetWrapper(this, true);
            this.mWrapper = v0;
        }

        return ((DecorToolbar)v0);
    }

    public boolean hasExpandedActionView() {
        ExpandedActionViewMenuPresenter v0 = this.mExpandedMenuPresenter;
        if(v0 != null && v0.mCurrentExpandedItem != null) {
            return 1;
        }

        return 0;
    }

    public boolean hideOverflowMenu() {
        ActionMenuView v0 = this.mMenuView;
        if(v0 != null && (v0.hideOverflowMenu())) {
            return 1;
        }

        return 0;
    }

    public void inflateMenu(int arg2) {
        this.getMenuInflater().inflate(arg2, this.getMenu());
    }

    public void invalidateMenu() {
        Iterator v0 = this.mProvidedMenuItems.iterator();
        while(v0.hasNext()) {
            this.getMenu().removeItem(v0.next().getItemId());
        }

        this.onCreateMenu();
    }

    public boolean isBackInvokedCallbackEnabled() {
        return this.mBackInvokedCallbackEnabled;
    }

    private boolean isChildOrHidden(View arg2) {
        if(arg2.getParent() != this) {
            if(this.mHiddenViews.contains(arg2)) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public boolean isOverflowMenuShowPending() {
        ActionMenuView v0 = this.mMenuView;
        if(v0 != null && (v0.isOverflowMenuShowPending())) {
            return 1;
        }

        return 0;
    }

    public boolean isOverflowMenuShowing() {
        ActionMenuView v0 = this.mMenuView;
        if(v0 != null && (v0.isOverflowMenuShowing())) {
            return 1;
        }

        return 0;
    }

    public boolean isTitleTruncated() {
        TextView v4 = this.mTitleTextView;
        if(v4 == null) {
            return 0;
        }

        Layout v4_1 = v4.getLayout();
        if(v4_1 == null) {
            return 0;
        }

        int v1 = v4_1.getLineCount();
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            if(v4_1.getEllipsisCount(v2) > 0) {
                return 1;
            }
        }

        return 0;
    }

    private int layoutChildLeft(View arg5, int arg6, int[] arg7, int arg8) {
        ViewGroup$LayoutParams v0 = arg5.getLayoutParams();
        int v1 = ((LayoutParams)v0).leftMargin - arg7[0];
        arg6 += Math.max(0, v1);
        arg7[0] = Math.max(0, -v1);
        int v4 = this.getChildTop(arg5, arg8);
        int v7 = arg5.getMeasuredWidth();
        arg5.layout(arg6, v4, arg6 + v7, arg5.getMeasuredHeight() + v4);
        return arg6 + (v7 + ((LayoutParams)v0).rightMargin);
    }

    private int layoutChildRight(View arg6, int arg7, int[] arg8, int arg9) {
        ViewGroup$LayoutParams v0 = arg6.getLayoutParams();
        int v1 = ((LayoutParams)v0).rightMargin - arg8[1];
        arg7 -= Math.max(0, v1);
        arg8[1] = Math.max(0, -v1);
        int v5 = this.getChildTop(arg6, arg9);
        int v8 = arg6.getMeasuredWidth();
        arg6.layout(arg7 - v8, v5, arg7, arg6.getMeasuredHeight() + v5);
        return arg7 - (v8 + ((LayoutParams)v0).leftMargin);
    }

    private int measureChildCollapseMargins(View arg8, int arg9, int arg10, int arg11, int arg12, int[] arg13) {
        ViewGroup$LayoutParams v0 = arg8.getLayoutParams();
        int v1 = ((ViewGroup$MarginLayoutParams)v0).leftMargin - arg13[0];
        int v3 = ((ViewGroup$MarginLayoutParams)v0).rightMargin - arg13[1];
        int v5 = Math.max(0, v1) + Math.max(0, v3);
        arg13[0] = Math.max(0, -v1);
        arg13[1] = Math.max(0, -v3);
        arg8.measure(Toolbar.getChildMeasureSpec(arg9, this.getPaddingLeft() + this.getPaddingRight() + v5 + arg10, ((ViewGroup$MarginLayoutParams)v0).width), Toolbar.getChildMeasureSpec(arg11, this.getPaddingTop() + this.getPaddingBottom() + ((ViewGroup$MarginLayoutParams)v0).topMargin + ((ViewGroup$MarginLayoutParams)v0).bottomMargin + arg12, ((ViewGroup$MarginLayoutParams)v0).height));
        return arg8.getMeasuredWidth() + v5;
    }

    private void measureChildConstrained(View arg4, int arg5, int arg6, int arg7, int arg8, int arg9) {
        ViewGroup$LayoutParams v0 = arg4.getLayoutParams();
        arg5 = Toolbar.getChildMeasureSpec(arg5, this.getPaddingLeft() + this.getPaddingRight() + ((ViewGroup$MarginLayoutParams)v0).leftMargin + ((ViewGroup$MarginLayoutParams)v0).rightMargin + arg6, ((ViewGroup$MarginLayoutParams)v0).width);
        int v3 = Toolbar.getChildMeasureSpec(arg7, this.getPaddingTop() + this.getPaddingBottom() + ((ViewGroup$MarginLayoutParams)v0).topMargin + ((ViewGroup$MarginLayoutParams)v0).bottomMargin + arg8, ((ViewGroup$MarginLayoutParams)v0).height);
        arg6 = View$MeasureSpec.getMode(v3);
        arg7 = 0x40000000;
        if(arg6 != arg7 && arg9 >= 0) {
            if(arg6 != 0) {
                arg9 = Math.min(View$MeasureSpec.getSize(v3), arg9);
            }

            v3 = View$MeasureSpec.makeMeasureSpec(arg9, arg7);
        }

        arg4.measure(arg5, v3);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.updateBackInvokedCallbackState();
    }

    private void onCreateMenu() {
        Menu v0 = this.getMenu();
        ArrayList v1 = this.getCurrentMenuItems();
        this.mMenuHostHelper.onCreateMenu(v0, this.getMenuInflater());
        ArrayList v0_1 = this.getCurrentMenuItems();
        v0_1.removeAll(((Collection)v1));
        this.mProvidedMenuItems = v0_1;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.removeCallbacks(this.mShowOverflowMenuRunnable);
        this.updateBackInvokedCallbackState();
    }

    public boolean onHoverEvent(MotionEvent arg6) {
        int v0 = arg6.getActionMasked();
        int v2 = 9;
        if(v0 == v2) {
            this.mEatingHover = false;
        }

        if(!this.mEatingHover) {
            boolean v6 = super.onHoverEvent(arg6);
            if(v0 == v2 && !v6) {
                this.mEatingHover = true;
            }
        }

        if(v0 == 10 || v0 == 3) {
            this.mEatingHover = false;
        }

        return 1;
    }

    protected void onLayout(boolean arg19, int arg20, int arg21, int arg22, int arg23) {
        ArrayList v3_1;
        ArrayList v8_1;
        int v2_2;
        ViewGroup$LayoutParams v2;
        ViewGroup$LayoutParams v15_3;
        int v13_1;
        int v14;
        Toolbar v0 = this;
        int v1 = ViewCompat.getLayoutDirection(((View)v0)) == 1 ? 1 : 0;
        int v4 = v0.getWidth();
        int v5 = v0.getHeight();
        int v6 = v0.getPaddingLeft();
        int v7 = v0.getPaddingRight();
        int v8 = v0.getPaddingTop();
        int v9 = v0.getPaddingBottom();
        int v10 = v4 - v7;
        int[] v11 = v0.mTempMargins;
        v11[1] = 0;
        v11[0] = 0;
        int v12 = ViewCompat.getMinimumHeight(((View)v0));
        v12 = v12 >= 0 ? Math.min(v12, arg23 - arg21) : 0;
        if(v0.shouldLayout(v0.mNavButtonView)) {
            ImageButton v13 = v0.mNavButtonView;
            if(v1 != 0) {
                v14 = v0.layoutChildRight(((View)v13), v10, v11, v12);
                v13_1 = v6;
            }
            else {
                v13_1 = v0.layoutChildLeft(((View)v13), v6, v11, v12);
                goto label_36;
            }
        }
        else {
            v13_1 = v6;
        label_36:
            v14 = v10;
        }

        if(v0.shouldLayout(v0.mCollapseButtonView)) {
            ImageButton v15 = v0.mCollapseButtonView;
            if(v1 != 0) {
                v14 = v0.layoutChildRight(((View)v15), v14, v11, v12);
            }
            else {
                v13_1 = v0.layoutChildLeft(((View)v15), v13_1, v11, v12);
            }
        }

        if(v0.shouldLayout(v0.mMenuView)) {
            ActionMenuView v15_1 = v0.mMenuView;
            if(v1 != 0) {
                v13_1 = v0.layoutChildLeft(((View)v15_1), v13_1, v11, v12);
            }
            else {
                v14 = v0.layoutChildRight(((View)v15_1), v14, v11, v12);
            }
        }

        int v15_2 = v0.getCurrentContentInsetLeft();
        int v16 = v0.getCurrentContentInsetRight();
        v11[0] = Math.max(0, v15_2 - v13_1);
        v11[1] = Math.max(0, v16 - (v10 - v14));
        int v3 = Math.max(v13_1, v15_2);
        v10 = Math.min(v14, v10 - v16);
        if(v0.shouldLayout(v0.mExpandedActionView)) {
            View v13_2 = v0.mExpandedActionView;
            if(v1 != 0) {
                v10 = v0.layoutChildRight(v13_2, v10, v11, v12);
            }
            else {
                v3 = v0.layoutChildLeft(v13_2, v3, v11, v12);
            }
        }

        if(v0.shouldLayout(v0.mLogoView)) {
            ImageView v13_3 = v0.mLogoView;
            if(v1 != 0) {
                v10 = v0.layoutChildRight(((View)v13_3), v10, v11, v12);
            }
            else {
                v3 = v0.layoutChildLeft(((View)v13_3), v3, v11, v12);
            }
        }

        boolean v13_4 = v0.shouldLayout(v0.mTitleTextView);
        boolean v14_1 = v0.shouldLayout(v0.mSubtitleTextView);
        if(v13_4) {
            v15_3 = v0.mTitleTextView.getLayoutParams();
            arg22 = v1;
            v1 = ((LayoutParams)v15_3).bottomMargin + (((LayoutParams)v15_3).topMargin + v0.mTitleTextView.getMeasuredHeight());
        }
        else {
            arg22 = v1;
            v1 = 0;
        }

        if(v14_1) {
            v2 = v0.mSubtitleTextView.getLayoutParams();
            v1 += ((LayoutParams)v2).topMargin + v0.mSubtitleTextView.getMeasuredHeight() + ((LayoutParams)v2).bottomMargin;
        }

        if((v13_4) || (v14_1)) {
            TextView v2_1 = v13_4 ? v0.mTitleTextView : v0.mSubtitleTextView;
            TextView v15_4 = v14_1 ? v0.mSubtitleTextView : v0.mTitleTextView;
            v2 = ((View)v2_1).getLayoutParams();
            v15_3 = ((View)v15_4).getLayoutParams();
            arg21 = v1;
            if(!v13_4 || v0.mTitleTextView.getMeasuredWidth() <= 0) {
                if((v14_1) && v0.mSubtitleTextView.getMeasuredWidth() > 0) {
                label_136:
                    arg23 = 1;
                    goto label_139;
                }

                arg23 = 0;
            }
            else {
                goto label_136;
            }

        label_139:
            v1 = v0.mGravity & 0x70;
            v16 = v3;
            if(v1 == 0x30) {
                v8 = v0.getPaddingTop() + ((LayoutParams)v2).topMargin + v0.mTitleMarginTop;
            }
            else if(v1 != 80) {
                v1 = (v5 - v8 - v9 - arg21) / 2;
                if(v1 < ((LayoutParams)v2).topMargin + v0.mTitleMarginTop) {
                    v1 = ((LayoutParams)v2).topMargin + v0.mTitleMarginTop;
                }
                else {
                    v5 = v5 - v9 - arg21 - v1 - v8;
                    if(v5 < ((LayoutParams)v2).bottomMargin + v0.mTitleMarginBottom) {
                        v1 = Math.max(0, v1 - (((LayoutParams)v15_3).bottomMargin + v0.mTitleMarginBottom - v5));
                    }
                }

                v8 += v1;
            }
            else {
                v8 = v5 - v9 - ((LayoutParams)v15_3).bottomMargin - v0.mTitleMarginBottom - arg21;
            }

            if(arg22 != 0) {
                v1 = arg23 != 0 ? v0.mTitleMarginStart : 0;
                v1 -= v11[1];
                v10 -= Math.max(0, v1);
                v11[1] = Math.max(0, -v1);
                if(v13_4) {
                    ViewGroup$LayoutParams v1_1 = v0.mTitleTextView.getLayoutParams();
                    v2_2 = v10 - v0.mTitleTextView.getMeasuredWidth();
                    v3 = v0.mTitleTextView.getMeasuredHeight() + v8;
                    v0.mTitleTextView.layout(v2_2, v8, v10, v3);
                    v2_2 -= v0.mTitleMarginEnd;
                    v8 = v3 + ((LayoutParams)v1_1).bottomMargin;
                }
                else {
                    v2_2 = v10;
                }

                if(v14_1) {
                    v8 += v0.mSubtitleTextView.getLayoutParams().topMargin;
                    v0.mSubtitleTextView.layout(v10 - v0.mSubtitleTextView.getMeasuredWidth(), v8, v10, v0.mSubtitleTextView.getMeasuredHeight() + v8);
                    v3 = v10 - v0.mTitleMarginEnd;
                }
                else {
                    v3 = v10;
                }

                if(arg23 != 0) {
                    v10 = Math.min(v2_2, v3);
                }

                v3 = v16;
            label_115:
                v1 = 0;
                goto label_290;
            }

            v2_2 = arg23 != 0 ? v0.mTitleMarginStart : 0;
            v1 = 0;
            v2_2 -= v11[0];
            v3 = v16 + Math.max(0, v2_2);
            v11[0] = Math.max(0, -v2_2);
            if(v13_4) {
                v2 = v0.mTitleTextView.getLayoutParams();
                v5 = v0.mTitleTextView.getMeasuredWidth() + v3;
                v9 = v0.mTitleTextView.getMeasuredHeight() + v8;
                v0.mTitleTextView.layout(v3, v8, v5, v9);
                v5 += v0.mTitleMarginEnd;
                v8 = v9 + ((LayoutParams)v2).bottomMargin;
            }
            else {
                v5 = v3;
            }

            if(v14_1) {
                v8 += v0.mSubtitleTextView.getLayoutParams().topMargin;
                v9 = v0.mSubtitleTextView.getMeasuredWidth() + v3;
                v0.mSubtitleTextView.layout(v3, v8, v9, v0.mSubtitleTextView.getMeasuredHeight() + v8);
                v9 += v0.mTitleMarginEnd;
            }
            else {
                v9 = v3;
            }

            if(arg23 == 0) {
                goto label_290;
            }

            v3 = Math.max(v5, v9);
        }
        else {
            goto label_115;
        }

    label_290:
        v0.addCustomViewsWithGravity(v0.mTempViews, 3);
        v2_2 = v0.mTempViews.size();
        v5 = v3;
        for(v3 = v1; true; ++v3) {
            v8_1 = v0.mTempViews;
            if(v3 >= v2_2) {
                break;
            }

            v5 = v0.layoutChildLeft(v8_1.get(v3), v5, v11, v12);
        }

        v0.addCustomViewsWithGravity(((List)v8_1), 5);
        v2_2 = v0.mTempViews.size();
        for(v3 = v1; true; ++v3) {
            v8_1 = v0.mTempViews;
            if(v3 >= v2_2) {
                break;
            }

            v10 = v0.layoutChildRight(v8_1.get(v3), v10, v11, v12);
        }

        v0.addCustomViewsWithGravity(((List)v8_1), 1);
        v2_2 = v0.getViewListMeasuredWidth(v0.mTempViews, v11);
        v6 = v6 + (v4 - v6 - v7) / 2 - v2_2 / 2;
        v2_2 += v6;
        if(v6 < v5) {
        }
        else if(v2_2 > v10) {
            v5 = v6 - (v2_2 - v10);
        }
        else {
            v5 = v6;
        }

        v2_2 = v0.mTempViews.size();
        while(true) {
            v3_1 = v0.mTempViews;
            if(v1 >= v2_2) {
                break;
            }

            v5 = v0.layoutChildLeft(v3_1.get(v1), v5, v11, v12);
            ++v1;
        }

        v3_1.clear();
    }

    protected void onMeasure(int arg15, int arg16) {
        int v13;
        int[] v6;
        int v12;
        int v11;
        int v1;
        int[] v7 = this.mTempMargins;
        boolean v8 = ViewUtils.isLayoutRtl(((View)this));
        int v9 = 0;
        int v10 = (((int)v8)) ^ 1;
        if(this.shouldLayout(this.mNavButtonView)) {
            this.measureChildConstrained(this.mNavButtonView, arg15, 0, arg16, 0, this.mMaxButtonHeight);
            v1 = this.mNavButtonView.getMeasuredWidth() + this.getHorizontalMargins(this.mNavButtonView);
            v11 = Math.max(0, this.mNavButtonView.getMeasuredHeight() + this.getVerticalMargins(this.mNavButtonView));
            v12 = View.combineMeasuredStates(0, this.mNavButtonView.getMeasuredState());
        }
        else {
            v1 = 0;
            v11 = 0;
            v12 = 0;
        }

        if(this.shouldLayout(this.mCollapseButtonView)) {
            this.measureChildConstrained(this.mCollapseButtonView, arg15, 0, arg16, 0, this.mMaxButtonHeight);
            v1 = this.mCollapseButtonView.getMeasuredWidth() + this.getHorizontalMargins(this.mCollapseButtonView);
            v11 = Math.max(v11, this.mCollapseButtonView.getMeasuredHeight() + this.getVerticalMargins(this.mCollapseButtonView));
            v12 = View.combineMeasuredStates(v12, this.mCollapseButtonView.getMeasuredState());
        }

        int v2 = this.getCurrentContentInsetStart();
        int v3 = Math.max(v2, v1);
        v7[((int)v8)] = Math.max(0, v2 - v1);
        if(this.shouldLayout(this.mMenuView)) {
            this.measureChildConstrained(this.mMenuView, arg15, v3, arg16, 0, this.mMaxButtonHeight);
            v1 = this.mMenuView.getMeasuredWidth() + this.getHorizontalMargins(this.mMenuView);
            v11 = Math.max(v11, this.mMenuView.getMeasuredHeight() + this.getVerticalMargins(this.mMenuView));
            v12 = View.combineMeasuredStates(v12, this.mMenuView.getMeasuredState());
        }
        else {
            v1 = 0;
        }

        v2 = this.getCurrentContentInsetEnd();
        v3 += Math.max(v2, v1);
        v7[v10] = Math.max(0, v2 - v1);
        if(this.shouldLayout(this.mExpandedActionView)) {
            v6 = v7;
            v3 += this.measureChildCollapseMargins(this.mExpandedActionView, arg15, v3, arg16, 0, v6);
            v11 = Math.max(v11, this.mExpandedActionView.getMeasuredHeight() + this.getVerticalMargins(this.mExpandedActionView));
            v12 = View.combineMeasuredStates(v12, this.mExpandedActionView.getMeasuredState());
        }
        else {
            v6 = v7;
        }

        if(this.shouldLayout(this.mLogoView)) {
            v3 += this.measureChildCollapseMargins(this.mLogoView, arg15, v3, arg16, 0, v6);
            v11 = Math.max(v11, this.mLogoView.getMeasuredHeight() + this.getVerticalMargins(this.mLogoView));
            v12 = View.combineMeasuredStates(v12, this.mLogoView.getMeasuredState());
        }

        int v7_1 = this.getChildCount();
        int v8_1;
        for(v8_1 = 0; v8_1 < v7_1; ++v8_1) {
            View v1_1 = this.getChildAt(v8_1);
            if(v1_1.getLayoutParams().mViewType != 0 || !this.shouldLayout(v1_1)) {
                v3 = v3;
            }
            else {
                v3 += this.measureChildCollapseMargins(v1_1, arg15, v3, arg16, 0, v6);
                v2 = Math.max(v11, v1_1.getMeasuredHeight() + this.getVerticalMargins(v1_1));
                v12 = View.combineMeasuredStates(v12, v1_1.getMeasuredState());
                v11 = v2;
            }
        }

        v10 = v3;
        int v5 = this.mTitleMarginTop + this.mTitleMarginBottom;
        v7_1 = this.mTitleMarginStart + this.mTitleMarginEnd;
        if(this.shouldLayout(this.mTitleTextView)) {
            this.measureChildCollapseMargins(this.mTitleTextView, arg15, v10 + v7_1, arg16, v5, v6);
            v1 = this.mTitleTextView.getMeasuredWidth() + this.getHorizontalMargins(this.mTitleTextView);
            v2 = this.mTitleTextView.getMeasuredHeight() + this.getVerticalMargins(this.mTitleTextView);
            v8_1 = v1;
            v13 = View.combineMeasuredStates(v12, this.mTitleTextView.getMeasuredState());
            v12 = v2;
        }
        else {
            v8_1 = 0;
            v13 = v12;
            v12 = 0;
        }

        if(this.shouldLayout(this.mSubtitleTextView)) {
            v8_1 = Math.max(v8_1, this.measureChildCollapseMargins(this.mSubtitleTextView, arg15, v10 + v7_1, arg16, v5 + v12, v6));
            v12 += this.mSubtitleTextView.getMeasuredHeight() + this.getVerticalMargins(this.mSubtitleTextView);
            v13 = View.combineMeasuredStates(v13, this.mSubtitleTextView.getMeasuredState());
        }

        v1 = Math.max(v11, v12);
        v3 = v10 + v8_1 + (this.getPaddingLeft() + this.getPaddingRight());
        v1 += this.getPaddingTop() + this.getPaddingBottom();
        v2 = View.resolveSizeAndState(Math.max(v3, this.getSuggestedMinimumWidth()), arg15, 0xFF000000 & v13);
        v1 = View.resolveSizeAndState(Math.max(v1, this.getSuggestedMinimumHeight()), arg16, v13 << 16);
        if(this.shouldCollapse()) {
        }
        else {
            v9 = v1;
        }

        this.setMeasuredDimension(v2, v9);
    }

    protected void onRestoreInstanceState(Parcelable arg3) {
        if(!(arg3 instanceof SavedState)) {
            super.onRestoreInstanceState(arg3);
            return;
        }

        super.onRestoreInstanceState(((SavedState)arg3).getSuperState());
        ActionMenuView v0 = this.mMenuView;
        MenuBuilder v0_1 = v0 != null ? v0.peekMenu() : null;
        if(((SavedState)arg3).expandedMenuItemId != 0 && this.mExpandedMenuPresenter != null && v0_1 != null) {
            MenuItem v0_2 = ((Menu)v0_1).findItem(((SavedState)arg3).expandedMenuItemId);
            if(v0_2 != null) {
                v0_2.expandActionView();
            }
        }

        if(((SavedState)arg3).isOverflowOpen) {
            this.postShowOverflowMenu();
        }
    }

    public void onRtlPropertiesChanged(int arg2) {
        super.onRtlPropertiesChanged(arg2);
        this.ensureContentInsets();
        RtlSpacingHelper v1 = this.mContentInsets;
        boolean v0 = true;
        if(arg2 == 1) {
        }
        else {
            v0 = false;
        }

        v1.setDirection(v0);
    }

    protected Parcelable onSaveInstanceState() {
        SavedState v0 = new SavedState(super.onSaveInstanceState());
        ExpandedActionViewMenuPresenter v1 = this.mExpandedMenuPresenter;
        if(v1 != null && v1.mCurrentExpandedItem != null) {
            v0.expandedMenuItemId = this.mExpandedMenuPresenter.mCurrentExpandedItem.getItemId();
        }

        v0.isOverflowOpen = this.isOverflowMenuShowing();
        return ((Parcelable)v0);
    }

    public boolean onTouchEvent(MotionEvent arg5) {
        int v0 = arg5.getActionMasked();
        if(v0 == 0) {
            this.mEatingTouch = false;
        }

        if(!this.mEatingTouch) {
            boolean v5 = super.onTouchEvent(arg5);
            if(v0 == 0 && !v5) {
                this.mEatingTouch = true;
            }
        }

        if(v0 == 1 || v0 == 3) {
            this.mEatingTouch = false;
        }

        return 1;
    }

    private void postShowOverflowMenu() {
        this.removeCallbacks(this.mShowOverflowMenuRunnable);
        this.post(this.mShowOverflowMenuRunnable);
    }

    void removeChildrenForExpandedActionView() {
        int v0;
        for(v0 = this.getChildCount() - 1; v0 >= 0; --v0) {
            View v1 = this.getChildAt(v0);
            if(v1.getLayoutParams().mViewType != 2 && v1 != this.mMenuView) {
                this.removeViewAt(v0);
                this.mHiddenViews.add(v1);
            }
        }
    }

    public void removeMenuProvider(MenuProvider arg1) {
        this.mMenuHostHelper.removeMenuProvider(arg1);
    }

    public void setBackInvokedCallbackEnabled(boolean arg2) {
        if(this.mBackInvokedCallbackEnabled != arg2) {
            this.mBackInvokedCallbackEnabled = arg2;
            this.updateBackInvokedCallbackState();
        }
    }

    public void setCollapseContentDescription(int arg2) {
        CharSequence v2 = arg2 != 0 ? this.getContext().getText(arg2) : null;
        this.setCollapseContentDescription(v2);
    }

    public void setCollapseContentDescription(CharSequence arg2) {
        if(!TextUtils.isEmpty(arg2)) {
            this.ensureCollapseButtonView();
        }

        ImageButton v1 = this.mCollapseButtonView;
        if(v1 != null) {
            v1.setContentDescription(arg2);
        }
    }

    public void setCollapseIcon(int arg2) {
        this.setCollapseIcon(AppCompatResources.getDrawable(this.getContext(), arg2));
    }

    public void setCollapseIcon(Drawable arg1) {
        if(arg1 != null) {
            this.ensureCollapseButtonView();
            this.mCollapseButtonView.setImageDrawable(arg1);
            return;
        }

        ImageButton v1 = this.mCollapseButtonView;
        if(v1 != null) {
            v1.setImageDrawable(this.mCollapseIcon);
        }
    }

    public void setCollapsible(boolean arg1) {
        this.mCollapsible = arg1;
        this.requestLayout();
    }

    public void setContentInsetEndWithActions(int arg2) {
        if(arg2 < 0) {
            arg2 = 0x80000000;
        }

        if(arg2 != this.mContentInsetEndWithActions) {
            this.mContentInsetEndWithActions = arg2;
            if(this.getNavigationIcon() != null) {
                this.requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int arg2) {
        if(arg2 < 0) {
            arg2 = 0x80000000;
        }

        if(arg2 != this.mContentInsetStartWithNavigation) {
            this.mContentInsetStartWithNavigation = arg2;
            if(this.getNavigationIcon() != null) {
                this.requestLayout();
            }
        }
    }

    public void setContentInsetsAbsolute(int arg1, int arg2) {
        this.ensureContentInsets();
        this.mContentInsets.setAbsolute(arg1, arg2);
    }

    public void setContentInsetsRelative(int arg1, int arg2) {
        this.ensureContentInsets();
        this.mContentInsets.setRelative(arg1, arg2);
    }

    public void setLogo(Drawable arg3) {
        if(arg3 != null) {
            this.ensureLogoView();
            if(!this.isChildOrHidden(this.mLogoView)) {
                this.addSystemView(this.mLogoView, true);
            }
        }
        else {
            ImageView v0 = this.mLogoView;
            if(v0 != null && (this.isChildOrHidden(((View)v0)))) {
                this.removeView(this.mLogoView);
                this.mHiddenViews.remove(this.mLogoView);
            }
        }

        ImageView v2 = this.mLogoView;
        if(v2 != null) {
            v2.setImageDrawable(arg3);
        }
    }

    public void setLogo(int arg2) {
        this.setLogo(AppCompatResources.getDrawable(this.getContext(), arg2));
    }

    public void setLogoDescription(CharSequence arg2) {
        if(!TextUtils.isEmpty(arg2)) {
            this.ensureLogoView();
        }

        ImageView v1 = this.mLogoView;
        if(v1 != null) {
            v1.setContentDescription(arg2);
        }
    }

    public void setLogoDescription(int arg2) {
        this.setLogoDescription(this.getContext().getText(arg2));
    }

    public void setMenu(MenuBuilder arg4, ActionMenuPresenter arg5) {
        MenuBuilder v0;
        if(arg4 != null || this.mMenuView != null) {
            this.ensureMenuView();
            v0 = this.mMenuView.peekMenu();
            if(v0 == arg4) {
                return;
            }

            goto label_9;
        }
        else {
        }

        return;
    label_9:
        if(v0 != null) {
            v0.removeMenuPresenter(this.mOuterActionMenuPresenter);
            v0.removeMenuPresenter(this.mExpandedMenuPresenter);
        }

        if(this.mExpandedMenuPresenter == null) {
            this.mExpandedMenuPresenter = new ExpandedActionViewMenuPresenter(this);
        }

        arg5.setExpandedActionViewsExclusive(true);
        Context v1 = this.mPopupContext;
        if(arg4 != null) {
            arg4.addMenuPresenter(((MenuPresenter)arg5), v1);
            arg4.addMenuPresenter(this.mExpandedMenuPresenter, this.mPopupContext);
        }
        else {
            arg5.initForMenu(v1, null);
            this.mExpandedMenuPresenter.initForMenu(this.mPopupContext, null);
            arg5.updateMenuView(true);
            this.mExpandedMenuPresenter.updateMenuView(true);
        }

        this.mMenuView.setPopupTheme(this.mPopupTheme);
        this.mMenuView.setPresenter(arg5);
        this.mOuterActionMenuPresenter = arg5;
        this.updateBackInvokedCallbackState();
    }

    public void setMenuCallbacks(Callback arg1, androidx.appcompat.view.menu.MenuBuilder$Callback arg2) {
        this.mActionMenuPresenterCallback = arg1;
        this.mMenuBuilderCallback = arg2;
        ActionMenuView v0 = this.mMenuView;
        if(v0 != null) {
            v0.setMenuCallbacks(arg1, arg2);
        }
    }

    public void setNavigationContentDescription(CharSequence arg2) {
        if(!TextUtils.isEmpty(arg2)) {
            this.ensureNavButtonView();
        }

        ImageButton v0 = this.mNavButtonView;
        if(v0 != null) {
            v0.setContentDescription(arg2);
            TooltipCompat.setTooltipText(this.mNavButtonView, arg2);
        }
    }

    public void setNavigationContentDescription(int arg2) {
        CharSequence v2 = arg2 != 0 ? this.getContext().getText(arg2) : null;
        this.setNavigationContentDescription(v2);
    }

    public void setNavigationIcon(Drawable arg3) {
        if(arg3 != null) {
            this.ensureNavButtonView();
            if(!this.isChildOrHidden(this.mNavButtonView)) {
                this.addSystemView(this.mNavButtonView, true);
            }
        }
        else {
            ImageButton v0 = this.mNavButtonView;
            if(v0 != null && (this.isChildOrHidden(((View)v0)))) {
                this.removeView(this.mNavButtonView);
                this.mHiddenViews.remove(this.mNavButtonView);
            }
        }

        ImageButton v2 = this.mNavButtonView;
        if(v2 != null) {
            v2.setImageDrawable(arg3);
        }
    }

    public void setNavigationIcon(int arg2) {
        this.setNavigationIcon(AppCompatResources.getDrawable(this.getContext(), arg2));
    }

    public void setNavigationOnClickListener(View$OnClickListener arg1) {
        this.ensureNavButtonView();
        this.mNavButtonView.setOnClickListener(arg1);
    }

    public void setOnMenuItemClickListener(androidx.appcompat.widget.Toolbar$OnMenuItemClickListener arg1) {
        this.mOnMenuItemClickListener = arg1;
    }

    public void setOverflowIcon(Drawable arg1) {
        this.ensureMenu();
        this.mMenuView.setOverflowIcon(arg1);
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

    public void setSubtitle(CharSequence arg4) {
        boolean v0 = TextUtils.isEmpty(arg4);
        TextView v1 = this.mSubtitleTextView;
        if(!v0) {
            if(v1 == null) {
                Context v0_1 = this.getContext();
                AppCompatTextView v1_1 = new AppCompatTextView(v0_1);
                this.mSubtitleTextView = ((TextView)v1_1);
                ((TextView)v1_1).setSingleLine();
                this.mSubtitleTextView.setEllipsize(TextUtils$TruncateAt.END);
                int v1_2 = this.mSubtitleTextAppearance;
                if(v1_2 != 0) {
                    this.mSubtitleTextView.setTextAppearance(v0_1, v1_2);
                }

                ColorStateList v0_2 = this.mSubtitleTextColor;
                if(v0_2 == null) {
                    goto label_20;
                }

                this.mSubtitleTextView.setTextColor(v0_2);
            }

        label_20:
            if(this.isChildOrHidden(this.mSubtitleTextView)) {
                goto label_35;
            }

            this.addSystemView(this.mSubtitleTextView, true);
        }
        else {
            if(v1 == null) {
                goto label_35;
            }

            if(!this.isChildOrHidden(((View)v1))) {
                goto label_35;
            }

            this.removeView(this.mSubtitleTextView);
            this.mHiddenViews.remove(this.mSubtitleTextView);
        }

    label_35:
        TextView v0_3 = this.mSubtitleTextView;
        if(v0_3 != null) {
            v0_3.setText(arg4);
        }

        this.mSubtitleText = arg4;
    }

    public void setSubtitle(int arg2) {
        this.setSubtitle(this.getContext().getText(arg2));
    }

    public void setSubtitleTextAppearance(Context arg1, int arg2) {
        this.mSubtitleTextAppearance = arg2;
        TextView v0 = this.mSubtitleTextView;
        if(v0 != null) {
            v0.setTextAppearance(arg1, arg2);
        }
    }

    public void setSubtitleTextColor(ColorStateList arg1) {
        this.mSubtitleTextColor = arg1;
        TextView v0 = this.mSubtitleTextView;
        if(v0 != null) {
            v0.setTextColor(arg1);
        }
    }

    public void setSubtitleTextColor(int arg1) {
        this.setSubtitleTextColor(ColorStateList.valueOf(arg1));
    }

    public void setTitle(CharSequence arg4) {
        boolean v0 = TextUtils.isEmpty(arg4);
        TextView v1 = this.mTitleTextView;
        if(!v0) {
            if(v1 == null) {
                Context v0_1 = this.getContext();
                AppCompatTextView v1_1 = new AppCompatTextView(v0_1);
                this.mTitleTextView = ((TextView)v1_1);
                ((TextView)v1_1).setSingleLine();
                this.mTitleTextView.setEllipsize(TextUtils$TruncateAt.END);
                int v1_2 = this.mTitleTextAppearance;
                if(v1_2 != 0) {
                    this.mTitleTextView.setTextAppearance(v0_1, v1_2);
                }

                ColorStateList v0_2 = this.mTitleTextColor;
                if(v0_2 == null) {
                    goto label_20;
                }

                this.mTitleTextView.setTextColor(v0_2);
            }

        label_20:
            if(this.isChildOrHidden(this.mTitleTextView)) {
                goto label_35;
            }

            this.addSystemView(this.mTitleTextView, true);
        }
        else {
            if(v1 == null) {
                goto label_35;
            }

            if(!this.isChildOrHidden(((View)v1))) {
                goto label_35;
            }

            this.removeView(this.mTitleTextView);
            this.mHiddenViews.remove(this.mTitleTextView);
        }

    label_35:
        TextView v0_3 = this.mTitleTextView;
        if(v0_3 != null) {
            v0_3.setText(arg4);
        }

        this.mTitleText = arg4;
    }

    public void setTitle(int arg2) {
        this.setTitle(this.getContext().getText(arg2));
    }

    public void setTitleMargin(int arg1, int arg2, int arg3, int arg4) {
        this.mTitleMarginStart = arg1;
        this.mTitleMarginTop = arg2;
        this.mTitleMarginEnd = arg3;
        this.mTitleMarginBottom = arg4;
        this.requestLayout();
    }

    public void setTitleMarginBottom(int arg1) {
        this.mTitleMarginBottom = arg1;
        this.requestLayout();
    }

    public void setTitleMarginEnd(int arg1) {
        this.mTitleMarginEnd = arg1;
        this.requestLayout();
    }

    public void setTitleMarginStart(int arg1) {
        this.mTitleMarginStart = arg1;
        this.requestLayout();
    }

    public void setTitleMarginTop(int arg1) {
        this.mTitleMarginTop = arg1;
        this.requestLayout();
    }

    public void setTitleTextAppearance(Context arg1, int arg2) {
        this.mTitleTextAppearance = arg2;
        TextView v0 = this.mTitleTextView;
        if(v0 != null) {
            v0.setTextAppearance(arg1, arg2);
        }
    }

    public void setTitleTextColor(ColorStateList arg1) {
        this.mTitleTextColor = arg1;
        TextView v0 = this.mTitleTextView;
        if(v0 != null) {
            v0.setTextColor(arg1);
        }
    }

    public void setTitleTextColor(int arg1) {
        this.setTitleTextColor(ColorStateList.valueOf(arg1));
    }

    private boolean shouldCollapse() {
        if(!this.mCollapsible) {
            return 0;
        }

        int v0 = this.getChildCount();
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            View v3 = this.getChildAt(v2);
            if((this.shouldLayout(v3)) && v3.getMeasuredWidth() > 0 && v3.getMeasuredHeight() > 0) {
                return 0;
            }
        }

        return 1;
    }

    private boolean shouldLayout(View arg2) {
        if(arg2 != null && arg2.getParent() == this && arg2.getVisibility() != 8) {
            return 1;
        }

        return 0;
    }

    public boolean showOverflowMenu() {
        ActionMenuView v0 = this.mMenuView;
        if(v0 != null && (v0.showOverflowMenu())) {
            return 1;
        }

        return 0;
    }

    void updateBackInvokedCallbackState() {
        if(Build$VERSION.SDK_INT >= 33) {
            OnBackInvokedDispatcher v0 = Api33Impl.findOnBackInvokedDispatcher(((View)this));
            int v1 = !this.hasExpandedActionView() || v0 == null || !ViewCompat.isAttachedToWindow(((View)this)) || !this.mBackInvokedCallbackEnabled ? 0 : 1;
            if(v1 != 0 && this.mBackInvokedDispatcher == null) {
                OnBackInvokedCallback v1_1 = this.mBackInvokedCallback;
                if(v1_1 == null) {
                    v1_1 = Api33Impl.newOnBackInvokedCallback(new Toolbar$$ExternalSyntheticLambda0(this));
                    this.mBackInvokedCallback = v1_1;
                }

                Api33Impl.tryRegisterOnBackInvokedCallback(v0, v1_1);
                this.mBackInvokedDispatcher = v0;
                return;
            }

            if(v1 != 0) {
                return;
            }

            v0 = this.mBackInvokedDispatcher;
            if(v0 == null) {
                return;
            }

            Api33Impl.tryUnregisterOnBackInvokedCallback(v0, this.mBackInvokedCallback);
            this.mBackInvokedDispatcher = null;
        }
    }
}

