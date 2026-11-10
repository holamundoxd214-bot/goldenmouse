package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.SpinnerAdapter;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$styleable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ActionBarPolicy;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.ViewPropertyAnimatorCompatSet;
import androidx.appcompat.view.menu.MenuBuilder$Callback;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout$ActionBarVisibilityCallback;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.DecorToolbar;
import androidx.appcompat.widget.ScrollingTabContainerView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import androidx.core.view.ViewPropertyAnimatorUpdateListener;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class WindowDecorActionBar extends ActionBar implements ActionBarVisibilityCallback {
    class androidx.appcompat.app.WindowDecorActionBar$1 extends ViewPropertyAnimatorListenerAdapter {
        androidx.appcompat.app.WindowDecorActionBar$1(WindowDecorActionBar arg1) {
            WindowDecorActionBar.this = arg1;
            super();
        }

        public void onAnimationEnd(View arg2) {
            if((WindowDecorActionBar.this.mContentAnimations) && WindowDecorActionBar.this.mContentView != null) {
                WindowDecorActionBar.this.mContentView.setTranslationY(0f);
                WindowDecorActionBar.this.mContainerView.setTranslationY(0f);
            }

            WindowDecorActionBar.this.mContainerView.setVisibility(8);
            WindowDecorActionBar.this.mContainerView.setTransitioning(false);
            WindowDecorActionBar.this.mCurrentShowAnim = null;
            WindowDecorActionBar.this.completeDeferredDestroyActionMode();
            if(WindowDecorActionBar.this.mOverlayLayout != null) {
                ViewCompat.requestApplyInsets(WindowDecorActionBar.this.mOverlayLayout);
            }
        }
    }

    class androidx.appcompat.app.WindowDecorActionBar$2 extends ViewPropertyAnimatorListenerAdapter {
        androidx.appcompat.app.WindowDecorActionBar$2(WindowDecorActionBar arg1) {
            WindowDecorActionBar.this = arg1;
            super();
        }

        public void onAnimationEnd(View arg2) {
            WindowDecorActionBar.this.mCurrentShowAnim = null;
            WindowDecorActionBar.this.mContainerView.requestLayout();
        }
    }

    class androidx.appcompat.app.WindowDecorActionBar$3 implements ViewPropertyAnimatorUpdateListener {
        androidx.appcompat.app.WindowDecorActionBar$3(WindowDecorActionBar arg1) {
            WindowDecorActionBar.this = arg1;
            super();
        }

        public void onAnimationUpdate(View arg1) {
            WindowDecorActionBar.this.mContainerView.getParent().invalidate();
        }
    }

    public class ActionModeImpl extends ActionMode implements Callback {
        private final Context mActionModeContext;
        private androidx.appcompat.view.ActionMode$Callback mCallback;
        private WeakReference mCustomView;
        private final MenuBuilder mMenu;

        public ActionModeImpl(WindowDecorActionBar arg1, Context arg2, androidx.appcompat.view.ActionMode$Callback arg3) {
            WindowDecorActionBar.this = arg1;
            super();
            this.mActionModeContext = arg2;
            this.mCallback = arg3;
            MenuBuilder v1 = new MenuBuilder(arg2).setDefaultShowAsAction(1);
            this.mMenu = v1;
            v1.setCallback(((Callback)this));
        }

        public boolean dispatchOnCreate() {
            boolean v0_1;
            this.mMenu.stopDispatchingItemsChanged();
            try {
                v0_1 = this.mCallback.onCreateActionMode(((ActionMode)this), this.mMenu);
            }
            catch(Throwable v0) {
                this.mMenu.startDispatchingItemsChanged();
                throw v0;
            }

            this.mMenu.startDispatchingItemsChanged();
            return v0_1;
        }

        public void finish() {
            if(WindowDecorActionBar.this.mActionMode != this) {
                return;
            }

            if(!WindowDecorActionBar.checkShowingFlags(WindowDecorActionBar.this.mHiddenByApp, WindowDecorActionBar.this.mHiddenBySystem, false)) {
                WindowDecorActionBar.this.mDeferredDestroyActionMode = ((ActionMode)this);
                WindowDecorActionBar.this.mDeferredModeDestroyCallback = this.mCallback;
            }
            else {
                this.mCallback.onDestroyActionMode(((ActionMode)this));
            }

            this.mCallback = null;
            WindowDecorActionBar.this.animateToMode(false);
            WindowDecorActionBar.this.mContextView.closeMode();
            WindowDecorActionBar.this.mOverlayLayout.setHideOnContentScrollEnabled(WindowDecorActionBar.this.mHideOnContentScroll);
            WindowDecorActionBar.this.mActionMode = null;
        }

        public View getCustomView() {
            WeakReference v0 = this.mCustomView;
            if(v0 != null) {
                return v0.get();
            }

            return null;
        }

        public Menu getMenu() {
            return this.mMenu;
        }

        public MenuInflater getMenuInflater() {
            return new SupportMenuInflater(this.mActionModeContext);
        }

        public CharSequence getSubtitle() {
            return WindowDecorActionBar.this.mContextView.getSubtitle();
        }

        public CharSequence getTitle() {
            return WindowDecorActionBar.this.mContextView.getTitle();
        }

        public void invalidate() {
            if(WindowDecorActionBar.this.mActionMode != this) {
                return;
            }

            this.mMenu.stopDispatchingItemsChanged();
            try {
                this.mCallback.onPrepareActionMode(((ActionMode)this), this.mMenu);
            }
            catch(Throwable v0) {
                this.mMenu.startDispatchingItemsChanged();
                throw v0;
            }

            this.mMenu.startDispatchingItemsChanged();
        }

        public boolean isTitleOptional() {
            return WindowDecorActionBar.this.mContextView.isTitleOptional();
        }

        public void onCloseMenu(MenuBuilder arg1, boolean arg2) {
        }

        public void onCloseSubMenu(SubMenuBuilder arg1) {
        }

        public boolean onMenuItemSelected(MenuBuilder arg1, MenuItem arg2) {
            androidx.appcompat.view.ActionMode$Callback v1 = this.mCallback;
            if(v1 != null) {
                return v1.onActionItemClicked(((ActionMode)this), arg2);
            }

            return 0;
        }

        public void onMenuModeChange(MenuBuilder arg1) {
            if(this.mCallback == null) {
                return;
            }

            this.invalidate();
            WindowDecorActionBar.this.mContextView.showOverflowMenu();
        }

        public boolean onSubMenuSelected(SubMenuBuilder arg3) {
            if(this.mCallback == null) {
                return 0;
            }

            if(!arg3.hasVisibleItems()) {
                return 1;
            }

            new MenuPopupHelper(WindowDecorActionBar.this.getThemedContext(), ((MenuBuilder)arg3)).show();
            return 1;
        }

        public void setCustomView(View arg2) {
            WindowDecorActionBar.this.mContextView.setCustomView(arg2);
            this.mCustomView = new WeakReference(arg2);
        }

        public void setSubtitle(int arg2) {
            this.setSubtitle(WindowDecorActionBar.this.mContext.getResources().getString(arg2));
        }

        public void setSubtitle(CharSequence arg1) {
            WindowDecorActionBar.this.mContextView.setSubtitle(arg1);
        }

        public void setTitle(int arg2) {
            this.setTitle(WindowDecorActionBar.this.mContext.getResources().getString(arg2));
        }

        public void setTitle(CharSequence arg1) {
            WindowDecorActionBar.this.mContextView.setTitle(arg1);
        }

        public void setTitleOptionalHint(boolean arg1) {
            super.setTitleOptionalHint(arg1);
            WindowDecorActionBar.this.mContextView.setTitleOptional(arg1);
        }
    }

    public class TabImpl extends Tab {
        private TabListener mCallback;
        private CharSequence mContentDesc;
        private View mCustomView;
        private Drawable mIcon;
        private int mPosition;
        private Object mTag;
        private CharSequence mText;

        public TabImpl(WindowDecorActionBar arg1) {
            WindowDecorActionBar.this = arg1;
            super();
            this.mPosition = -1;
        }

        public TabListener getCallback() {
            return this.mCallback;
        }

        public CharSequence getContentDescription() {
            return this.mContentDesc;
        }

        public View getCustomView() {
            return this.mCustomView;
        }

        public Drawable getIcon() {
            return this.mIcon;
        }

        public int getPosition() {
            return this.mPosition;
        }

        public Object getTag() {
            return this.mTag;
        }

        public CharSequence getText() {
            return this.mText;
        }

        public void select() {
            WindowDecorActionBar.this.selectTab(((Tab)this));
        }

        public Tab setContentDescription(int arg2) {
            return this.setContentDescription(WindowDecorActionBar.this.mContext.getResources().getText(arg2));
        }

        public Tab setContentDescription(CharSequence arg2) {
            this.mContentDesc = arg2;
            if(this.mPosition >= 0) {
                WindowDecorActionBar.this.mTabScrollView.updateTab(this.mPosition);
            }

            return this;
        }

        public Tab setCustomView(int arg3) {
            return this.setCustomView(LayoutInflater.from(WindowDecorActionBar.this.getThemedContext()).inflate(arg3, null));
        }

        public Tab setCustomView(View arg2) {
            this.mCustomView = arg2;
            if(this.mPosition >= 0) {
                WindowDecorActionBar.this.mTabScrollView.updateTab(this.mPosition);
            }

            return this;
        }

        public Tab setIcon(int arg2) {
            return this.setIcon(AppCompatResources.getDrawable(WindowDecorActionBar.this.mContext, arg2));
        }

        public Tab setIcon(Drawable arg2) {
            this.mIcon = arg2;
            if(this.mPosition >= 0) {
                WindowDecorActionBar.this.mTabScrollView.updateTab(this.mPosition);
            }

            return this;
        }

        public void setPosition(int arg1) {
            this.mPosition = arg1;
        }

        public Tab setTabListener(TabListener arg1) {
            this.mCallback = arg1;
            return this;
        }

        public Tab setTag(Object arg1) {
            this.mTag = arg1;
            return this;
        }

        public Tab setText(int arg2) {
            return this.setText(WindowDecorActionBar.this.mContext.getResources().getText(arg2));
        }

        public Tab setText(CharSequence arg2) {
            this.mText = arg2;
            if(this.mPosition >= 0) {
                WindowDecorActionBar.this.mTabScrollView.updateTab(this.mPosition);
            }

            return this;
        }
    }

    private static final long FADE_IN_DURATION_MS = 200;
    private static final long FADE_OUT_DURATION_MS = 100;
    private static final int INVALID_POSITION = -1;
    private static final String TAG = "WindowDecorActionBar";
    ActionModeImpl mActionMode;
    private Activity mActivity;
    ActionBarContainer mContainerView;
    boolean mContentAnimations;
    View mContentView;
    Context mContext;
    ActionBarContextView mContextView;
    private int mCurWindowVisibility;
    ViewPropertyAnimatorCompatSet mCurrentShowAnim;
    DecorToolbar mDecorToolbar;
    ActionMode mDeferredDestroyActionMode;
    androidx.appcompat.view.ActionMode$Callback mDeferredModeDestroyCallback;
    private boolean mDisplayHomeAsUpSet;
    private boolean mHasEmbeddedTabs;
    boolean mHiddenByApp;
    boolean mHiddenBySystem;
    final ViewPropertyAnimatorListener mHideListener;
    boolean mHideOnContentScroll;
    private boolean mLastMenuVisibility;
    private ArrayList mMenuVisibilityListeners;
    private boolean mNowShowing;
    ActionBarOverlayLayout mOverlayLayout;
    private int mSavedTabPosition;
    private TabImpl mSelectedTab;
    private boolean mShowHideAnimationEnabled;
    final ViewPropertyAnimatorListener mShowListener;
    private boolean mShowingForMode;
    ScrollingTabContainerView mTabScrollView;
    private ArrayList mTabs;
    private Context mThemedContext;
    final ViewPropertyAnimatorUpdateListener mUpdateListener;
    private static final Interpolator sHideInterpolator;
    private static final Interpolator sShowInterpolator;

    static {
        WindowDecorActionBar.sHideInterpolator = new AccelerateInterpolator();
        WindowDecorActionBar.sShowInterpolator = new DecelerateInterpolator();
    }

    public WindowDecorActionBar(Activity arg2, boolean arg3) {
        super();
        this.mTabs = new ArrayList();
        this.mSavedTabPosition = -1;
        this.mMenuVisibilityListeners = new ArrayList();
        this.mCurWindowVisibility = 0;
        this.mContentAnimations = true;
        this.mNowShowing = true;
        this.mHideListener = new androidx.appcompat.app.WindowDecorActionBar$1(this);
        this.mShowListener = new androidx.appcompat.app.WindowDecorActionBar$2(this);
        this.mUpdateListener = new androidx.appcompat.app.WindowDecorActionBar$3(this);
        this.mActivity = arg2;
        View v2 = arg2.getWindow().getDecorView();
        this.init(v2);
        if(!arg3) {
            this.mContentView = v2.findViewById(0x1020002);
        }
    }

    public WindowDecorActionBar(Dialog arg2) {
        super();
        this.mTabs = new ArrayList();
        this.mSavedTabPosition = -1;
        this.mMenuVisibilityListeners = new ArrayList();
        this.mCurWindowVisibility = 0;
        this.mContentAnimations = true;
        this.mNowShowing = true;
        this.mHideListener = new androidx.appcompat.app.WindowDecorActionBar$1(this);
        this.mShowListener = new androidx.appcompat.app.WindowDecorActionBar$2(this);
        this.mUpdateListener = new androidx.appcompat.app.WindowDecorActionBar$3(this);
        this.init(arg2.getWindow().getDecorView());
    }

    public WindowDecorActionBar(View arg2) {
        super();
        this.mTabs = new ArrayList();
        this.mSavedTabPosition = -1;
        this.mMenuVisibilityListeners = new ArrayList();
        this.mCurWindowVisibility = 0;
        this.mContentAnimations = true;
        this.mNowShowing = true;
        this.mHideListener = new androidx.appcompat.app.WindowDecorActionBar$1(this);
        this.mShowListener = new androidx.appcompat.app.WindowDecorActionBar$2(this);
        this.mUpdateListener = new androidx.appcompat.app.WindowDecorActionBar$3(this);
        this.init(arg2);
    }

    public void addOnMenuVisibilityListener(OnMenuVisibilityListener arg1) {
        this.mMenuVisibilityListeners.add(arg1);
    }

    public void addTab(Tab arg2) {
        this.addTab(arg2, this.mTabs.isEmpty());
    }

    public void addTab(Tab arg2, boolean arg3) {
        this.ensureTabsExist();
        this.mTabScrollView.addTab(arg2, arg3);
        this.configureTab(arg2, this.mTabs.size());
        if(arg3) {
            this.selectTab(arg2);
        }
    }

    public void addTab(Tab arg2, int arg3) {
        this.addTab(arg2, arg3, this.mTabs.isEmpty());
    }

    public void addTab(Tab arg2, int arg3, boolean arg4) {
        this.ensureTabsExist();
        this.mTabScrollView.addTab(arg2, arg3, arg4);
        this.configureTab(arg2, arg3);
        if(arg4) {
            this.selectTab(arg2);
        }
    }

    public void animateToMode(boolean arg10) {
        ViewPropertyAnimatorCompat v9;
        ViewPropertyAnimatorCompat v10;
        DecorToolbar v0;
        if(arg10) {
            this.showForActionMode();
        }
        else {
            this.hideForActionMode();
        }

        int v1 = 4;
        int v2 = 8;
        if(this.shouldAnimateContextView()) {
            v0 = this.mDecorToolbar;
            long v4 = 100;
            long v6 = 200;
            if(arg10) {
                v10 = v0.setupAnimatorToVisibility(v1, v4);
                v9 = this.mContextView.setupAnimatorToVisibility(0, v6);
            }
            else {
                ViewPropertyAnimatorCompat v8 = v0.setupAnimatorToVisibility(0, v6);
                v10 = this.mContextView.setupAnimatorToVisibility(v2, v4);
                v9 = v8;
            }

            ViewPropertyAnimatorCompatSet v0_1 = new ViewPropertyAnimatorCompatSet();
            v0_1.playSequentially(v10, v9);
            v0_1.start();
            return;
        }

        v0 = this.mDecorToolbar;
        if(arg10) {
            v0.setVisibility(v1);
            this.mContextView.setVisibility(0);
            return;
        }

        v0.setVisibility(0);
        this.mContextView.setVisibility(v2);
    }

    static boolean checkShowingFlags(boolean arg1, boolean arg2, boolean arg3) {
        if(arg3) {
            return 1;
        }

        if(!arg1) {
            if(arg2) {
            }
            else {
                return 1;
            }
        }

        return 0;
    }

    private void cleanupTabs() {
        if(this.mSelectedTab != null) {
            this.selectTab(null);
        }

        this.mTabs.clear();
        ScrollingTabContainerView v0 = this.mTabScrollView;
        if(v0 != null) {
            v0.removeAllTabs();
        }

        this.mSavedTabPosition = -1;
    }

    public boolean collapseActionView() {
        DecorToolbar v0 = this.mDecorToolbar;
        if(v0 != null && (v0.hasExpandedActionView())) {
            this.mDecorToolbar.collapseActionView();
            return 1;
        }

        return 0;
    }

    void completeDeferredDestroyActionMode() {
        androidx.appcompat.view.ActionMode$Callback v0 = this.mDeferredModeDestroyCallback;
        if(v0 != null) {
            v0.onDestroyActionMode(this.mDeferredDestroyActionMode);
            this.mDeferredDestroyActionMode = null;
            this.mDeferredModeDestroyCallback = null;
        }
    }

    private void configureTab(Tab arg2, int arg3) {
        if(((TabImpl)arg2).getCallback() != null) {
            ((TabImpl)arg2).setPosition(arg3);
            this.mTabs.add(arg3, arg2);
            int v2 = this.mTabs.size();
            while(true) {
                ++arg3;
                if(arg3 >= v2) {
                    return;
                }

                this.mTabs.get(arg3).setPosition(arg3);
            }

            return;
        }

        throw new IllegalStateException("Action Bar Tab must have a Callback");
    }

    public void dispatchMenuVisibilityChanged(boolean arg4) {
        if(arg4 == this.mLastMenuVisibility) {
        }
        else {
            this.mLastMenuVisibility = arg4;
            int v0 = this.mMenuVisibilityListeners.size();
            int v1;
            for(v1 = 0; v1 < v0; ++v1) {
                this.mMenuVisibilityListeners.get(v1).onMenuVisibilityChanged(arg4);
            }
        }
    }

    public void doHide(boolean arg5) {
        ViewPropertyAnimatorCompatSet v0 = this.mCurrentShowAnim;
        if(v0 != null) {
            v0.cancel();
        }

        if(this.mCurWindowVisibility == 0 && ((this.mShowHideAnimationEnabled) || (arg5))) {
            this.mContainerView.setAlpha(1f);
            this.mContainerView.setTransitioning(true);
            v0 = new ViewPropertyAnimatorCompatSet();
            float v2 = ((float)(-this.mContainerView.getHeight()));
            if(arg5) {
                int[] v5 = new int[]{0, 0};
                this.mContainerView.getLocationInWindow(v5);
                v2 -= ((float)v5[1]);
            }

            ViewPropertyAnimatorCompat v5_1 = ViewCompat.animate(this.mContainerView).translationY(v2);
            v5_1.setUpdateListener(this.mUpdateListener);
            v0.play(v5_1);
            if(this.mContentAnimations) {
                View v5_2 = this.mContentView;
                if(v5_2 != null) {
                    v0.play(ViewCompat.animate(v5_2).translationY(v2));
                }
            }

            v0.setInterpolator(WindowDecorActionBar.sHideInterpolator);
            v0.setDuration(0xFA);
            v0.setListener(this.mHideListener);
            this.mCurrentShowAnim = v0;
            v0.start();
            return;
        }

        this.mHideListener.onAnimationEnd(null);
    }

    public void doShow(boolean arg5) {
        ViewPropertyAnimatorCompatSet v0 = this.mCurrentShowAnim;
        if(v0 != null) {
            v0.cancel();
        }

        this.mContainerView.setVisibility(0);
        if(this.mCurWindowVisibility == 0) {
            if(!this.mShowHideAnimationEnabled && !arg5) {
                goto label_54;
            }

            this.mContainerView.setTranslationY(0f);
            float v0_1 = ((float)(-this.mContainerView.getHeight()));
            if(arg5) {
                int[] v5 = new int[]{0, 0};
                this.mContainerView.getLocationInWindow(v5);
                v0_1 -= ((float)v5[1]);
            }

            this.mContainerView.setTranslationY(v0_1);
            ViewPropertyAnimatorCompatSet v5_1 = new ViewPropertyAnimatorCompatSet();
            ViewPropertyAnimatorCompat v1 = ViewCompat.animate(this.mContainerView).translationY(0f);
            v1.setUpdateListener(this.mUpdateListener);
            v5_1.play(v1);
            if(this.mContentAnimations) {
                View v1_1 = this.mContentView;
                if(v1_1 != null) {
                    v1_1.setTranslationY(v0_1);
                    v5_1.play(ViewCompat.animate(this.mContentView).translationY(0f));
                }
            }

            v5_1.setInterpolator(WindowDecorActionBar.sShowInterpolator);
            v5_1.setDuration(0xFA);
            v5_1.setListener(this.mShowListener);
            this.mCurrentShowAnim = v5_1;
            v5_1.start();
        }
        else {
        label_54:
            this.mContainerView.setAlpha(1f);
            this.mContainerView.setTranslationY(0f);
            if(this.mContentAnimations) {
                View v5_2 = this.mContentView;
                if(v5_2 != null) {
                    v5_2.setTranslationY(0f);
                }
            }

            this.mShowListener.onAnimationEnd(null);
        }

        ActionBarOverlayLayout v4 = this.mOverlayLayout;
        if(v4 != null) {
            ViewCompat.requestApplyInsets(((View)v4));
        }
    }

    public void enableContentAnimations(boolean arg1) {
        this.mContentAnimations = arg1;
    }

    private void ensureTabsExist() {
        if(this.mTabScrollView != null) {
            return;
        }

        ScrollingTabContainerView v0 = new ScrollingTabContainerView(this.mContext);
        if(this.mHasEmbeddedTabs) {
            v0.setVisibility(0);
            this.mDecorToolbar.setEmbeddedTabView(v0);
        }
        else {
            if(this.getNavigationMode() == 2) {
                v0.setVisibility(0);
                ActionBarOverlayLayout v1 = this.mOverlayLayout;
                if(v1 != null) {
                    ViewCompat.requestApplyInsets(((View)v1));
                }
            }
            else {
                v0.setVisibility(8);
            }

            this.mContainerView.setTabContainer(v0);
        }

        this.mTabScrollView = v0;
    }

    public View getCustomView() {
        return this.mDecorToolbar.getCustomView();
    }

    private DecorToolbar getDecorToolbar(View arg3) {
        if((arg3 instanceof DecorToolbar)) {
            return arg3;
        }

        if((arg3 instanceof Toolbar)) {
            return ((Toolbar)arg3).getWrapper();
        }

        StringBuilder v0 = new StringBuilder("Can\'t make a decor toolbar out of ");
        String v3 = arg3 != null ? arg3.getClass().getSimpleName() : "null";
        throw new IllegalStateException(v0.append(v3).toString());
    }

    public int getDisplayOptions() {
        return this.mDecorToolbar.getDisplayOptions();
    }

    public float getElevation() {
        return ViewCompat.getElevation(this.mContainerView);
    }

    public int getHeight() {
        return this.mContainerView.getHeight();
    }

    public int getHideOffset() {
        return this.mOverlayLayout.getActionBarHideOffset();
    }

    public int getNavigationItemCount() {
        int v0 = this.mDecorToolbar.getNavigationMode();
        if(v0 != 1) {
            if(v0 != 2) {
                return 0;
            }

            return this.mTabs.size();
        }

        return this.mDecorToolbar.getDropdownItemCount();
    }

    public int getNavigationMode() {
        return this.mDecorToolbar.getNavigationMode();
    }

    public int getSelectedNavigationIndex() {
        int v0 = this.mDecorToolbar.getNavigationMode();
        if(v0 != 1) {
            int v2 = -1;
            if(v0 != 2) {
                return v2;
            }

            TabImpl v3 = this.mSelectedTab;
            if(v3 != null) {
                return v3.getPosition();
            }

            return v2;
        }

        return this.mDecorToolbar.getDropdownSelectedPosition();
    }

    public Tab getSelectedTab() {
        return this.mSelectedTab;
    }

    public CharSequence getSubtitle() {
        return this.mDecorToolbar.getSubtitle();
    }

    public Tab getTabAt(int arg1) {
        return this.mTabs.get(arg1);
    }

    public int getTabCount() {
        return this.mTabs.size();
    }

    public Context getThemedContext() {
        if(this.mThemedContext == null) {
            TypedValue v0 = new TypedValue();
            this.mContext.getTheme().resolveAttribute(attr.actionBarWidgetTheme, v0, true);
            int v0_1 = v0.resourceId;
            this.mThemedContext = v0_1 != 0 ? new ContextThemeWrapper(this.mContext, v0_1) : this.mContext;
        }

        return this.mThemedContext;
    }

    public CharSequence getTitle() {
        return this.mDecorToolbar.getTitle();
    }

    public boolean hasIcon() {
        return this.mDecorToolbar.hasIcon();
    }

    public boolean hasLogo() {
        return this.mDecorToolbar.hasLogo();
    }

    public void hide() {
        if(!this.mHiddenByApp) {
            this.mHiddenByApp = true;
            this.updateVisibility(false);
        }
    }

    private void hideForActionMode() {
        if(this.mShowingForMode) {
            this.mShowingForMode = false;
            ActionBarOverlayLayout v1 = this.mOverlayLayout;
            if(v1 != null) {
                v1.setShowingForActionMode(false);
            }

            this.updateVisibility(false);
        }
    }

    public void hideForSystem() {
        if(!this.mHiddenBySystem) {
            this.mHiddenBySystem = true;
            this.updateVisibility(true);
        }
    }

    private void init(View arg6) {
        View v0 = arg6.findViewById(id.decor_content_parent);
        this.mOverlayLayout = ((ActionBarOverlayLayout)v0);
        if(v0 != null) {
            ((ActionBarOverlayLayout)v0).setActionBarVisibilityCallback(((ActionBarVisibilityCallback)this));
        }

        this.mDecorToolbar = this.getDecorToolbar(arg6.findViewById(id.action_bar));
        this.mContextView = arg6.findViewById(id.action_context_bar);
        arg6 = arg6.findViewById(id.action_bar_container);
        this.mContainerView = ((ActionBarContainer)arg6);
        DecorToolbar v0_1 = this.mDecorToolbar;
        if(v0_1 != null && this.mContextView != null && arg6 != null) {
            this.mContext = v0_1.getContext();
            int v6 = (this.mDecorToolbar.getDisplayOptions() & 4) != 0 ? 1 : 0;
            if(v6 != 0) {
                this.mDisplayHomeAsUpSet = true;
            }

            ActionBarPolicy v2 = ActionBarPolicy.get(this.mContext);
            boolean v6_1 = (v2.enableHomeButtonByDefault()) || v6 != 0 ? true : false;
            this.setHomeButtonEnabled(v6_1);
            this.setHasEmbeddedTabs(v2.hasEmbeddedTabs());
            TypedArray v6_2 = this.mContext.obtainStyledAttributes(null, styleable.ActionBar, attr.actionBarStyle, 0);
            if(v6_2.getBoolean(styleable.ActionBar_hideOnContentScroll, false)) {
                this.setHideOnContentScrollEnabled(true);
            }

            int v0_2 = v6_2.getDimensionPixelSize(styleable.ActionBar_elevation, 0);
            if(v0_2 != 0) {
                this.setElevation(((float)v0_2));
            }

            v6_2.recycle();
            return;
        }

        throw new IllegalStateException(this.getClass().getSimpleName() + " can only be used with a compatible window decor layout");
    }

    public boolean isHideOnContentScrollEnabled() {
        return this.mOverlayLayout.isHideOnContentScrollEnabled();
    }

    public boolean isShowing() {
        int v0 = this.getHeight();
        if((this.mNowShowing) && (v0 == 0 || this.getHideOffset() < v0)) {
            return 1;
        }

        return 0;
    }

    public boolean isTitleTruncated() {
        DecorToolbar v0 = this.mDecorToolbar;
        if(v0 != null && (v0.isTitleTruncated())) {
            return 1;
        }

        return 0;
    }

    public Tab newTab() {
        return new TabImpl(this);
    }

    public void onConfigurationChanged(Configuration arg1) {
        this.setHasEmbeddedTabs(ActionBarPolicy.get(this.mContext).hasEmbeddedTabs());
    }

    public void onContentScrollStarted() {
        ViewPropertyAnimatorCompatSet v0 = this.mCurrentShowAnim;
        if(v0 != null) {
            v0.cancel();
            this.mCurrentShowAnim = null;
        }
    }

    public void onContentScrollStopped() {
    }

    public boolean onKeyShortcut(int arg4, KeyEvent arg5) {
        ActionModeImpl v3 = this.mActionMode;
        if(v3 == null) {
            return 0;
        }

        Menu v3_1 = v3.getMenu();
        if(v3_1 != null) {
            int v1 = arg5 != null ? arg5.getDeviceId() : -1;
            boolean v2 = true;
            if(KeyCharacterMap.load(v1).getKeyboardType() != 1) {
            }
            else {
                v2 = false;
            }

            v3_1.setQwertyMode(v2);
            return v3_1.performShortcut(arg4, arg5, 0);
        }

        return 0;
    }

    public void onWindowVisibilityChanged(int arg1) {
        this.mCurWindowVisibility = arg1;
    }

    public void removeAllTabs() {
        this.cleanupTabs();
    }

    public void removeOnMenuVisibilityListener(OnMenuVisibilityListener arg1) {
        this.mMenuVisibilityListeners.remove(arg1);
    }

    public void removeTab(Tab arg1) {
        this.removeTabAt(arg1.getPosition());
    }

    public void removeTabAt(int arg5) {
        Object v5_1;
        if(this.mTabScrollView == null) {
        }
        else {
            TabImpl v0 = this.mSelectedTab;
            int v0_1 = v0 != null ? v0.getPosition() : this.mSavedTabPosition;
            this.mTabScrollView.removeTabAt(arg5);
            Object v1 = this.mTabs.remove(arg5);
            if(v1 != null) {
                ((TabImpl)v1).setPosition(-1);
            }

            int v1_1 = this.mTabs.size();
            int v2;
            for(v2 = arg5; v2 < v1_1; ++v2) {
                this.mTabs.get(v2).setPosition(v2);
            }

            if(v0_1 != arg5) {
                return;
            }

            if(this.mTabs.isEmpty()) {
                Tab v5 = null;
            }
            else {
                v5_1 = this.mTabs.get(Math.max(0, arg5 - 1));
            }

            this.selectTab(((Tab)v5_1));
        }
    }

    public boolean requestFocus() {
        ViewGroup v1 = this.mDecorToolbar.getViewGroup();
        if(v1 != null && !v1.hasFocus()) {
            v1.requestFocus();
            return 1;
        }

        return 0;
    }

    public void selectTab(Tab arg4) {
        int v2 = -1;
        if(this.getNavigationMode() != 2) {
            if(arg4 != null) {
                v2 = arg4.getPosition();
            }

            this.mSavedTabPosition = v2;
            return;
        }

        FragmentTransaction v0 = !(this.mActivity instanceof FragmentActivity) || (this.mDecorToolbar.getViewGroup().isInEditMode()) ? null : this.mActivity.getSupportFragmentManager().beginTransaction().disallowAddToBackStack();
        TabImpl v1 = this.mSelectedTab;
        if((((Tab)v1)) != arg4) {
            ScrollingTabContainerView v1_1 = this.mTabScrollView;
            if(arg4 != null) {
                v2 = arg4.getPosition();
            }

            v1_1.setTabSelected(v2);
            v1 = this.mSelectedTab;
            if(v1 != null) {
                v1.getCallback().onTabUnselected(this.mSelectedTab, v0);
            }

            this.mSelectedTab = ((TabImpl)arg4);
            if(arg4 == null) {
                goto label_45;
            }

            ((TabImpl)arg4).getCallback().onTabSelected(this.mSelectedTab, v0);
        }
        else if(v1 != null) {
            v1.getCallback().onTabReselected(this.mSelectedTab, v0);
            this.mTabScrollView.animateToTab(arg4.getPosition());
        }

    label_45:
        if(v0 != null && !v0.isEmpty()) {
            v0.commit();
        }
    }

    public void setBackgroundDrawable(Drawable arg1) {
        this.mContainerView.setPrimaryBackground(arg1);
    }

    public void setCustomView(int arg4) {
        this.setCustomView(LayoutInflater.from(this.getThemedContext()).inflate(arg4, this.mDecorToolbar.getViewGroup(), false));
    }

    public void setCustomView(View arg1) {
        this.mDecorToolbar.setCustomView(arg1);
    }

    public void setCustomView(View arg1, LayoutParams arg2) {
        arg1.setLayoutParams(((ViewGroup$LayoutParams)arg2));
        this.mDecorToolbar.setCustomView(arg1);
    }

    public void setDefaultDisplayHomeAsUpEnabled(boolean arg2) {
        if(!this.mDisplayHomeAsUpSet) {
            this.setDisplayHomeAsUpEnabled(arg2);
        }
    }

    public void setDisplayHomeAsUpEnabled(boolean arg2) {
        int v0 = 4;
        int v2 = arg2 ? v0 : 0;
        this.setDisplayOptions(v2, v0);
    }

    public void setDisplayOptions(int arg3, int arg4) {
        int v0 = this.mDecorToolbar.getDisplayOptions();
        if((arg4 & 4) != 0) {
            this.mDisplayHomeAsUpSet = true;
        }

        this.mDecorToolbar.setDisplayOptions(arg3 & arg4 | ~arg4 & v0);
    }

    public void setDisplayOptions(int arg2) {
        if((arg2 & 4) != 0) {
            this.mDisplayHomeAsUpSet = true;
        }

        this.mDecorToolbar.setDisplayOptions(arg2);
    }

    public void setDisplayShowCustomEnabled(boolean arg2) {
        int v0 = 16;
        int v2 = arg2 ? v0 : 0;
        this.setDisplayOptions(v2, v0);
    }

    public void setDisplayShowHomeEnabled(boolean arg2) {
        int v0 = 2;
        int v2 = arg2 ? v0 : 0;
        this.setDisplayOptions(v2, v0);
    }

    public void setDisplayShowTitleEnabled(boolean arg2) {
        int v0 = 8;
        int v2 = arg2 ? v0 : 0;
        this.setDisplayOptions(v2, v0);
    }

    public void setDisplayUseLogoEnabled(boolean arg2) {
        this.setDisplayOptions(((int)arg2), 1);
    }

    public void setElevation(float arg1) {
        ViewCompat.setElevation(this.mContainerView, arg1);
    }

    private void setHasEmbeddedTabs(boolean arg5) {
        ActionBarOverlayLayout v0_1;
        this.mHasEmbeddedTabs = arg5;
        ScrollingTabContainerView v0 = null;
        if(!arg5) {
            this.mDecorToolbar.setEmbeddedTabView(v0);
            this.mContainerView.setTabContainer(this.mTabScrollView);
        }
        else {
            this.mContainerView.setTabContainer(v0);
            this.mDecorToolbar.setEmbeddedTabView(this.mTabScrollView);
        }

        boolean v1 = true;
        int v5 = this.getNavigationMode() == 2 ? 1 : 0;
        v0 = this.mTabScrollView;
        if(v0 != null) {
            if(v5 != 0) {
                v0.setVisibility(0);
                v0_1 = this.mOverlayLayout;
                if(v0_1 != null) {
                    ViewCompat.requestApplyInsets(((View)v0_1));
                }
            }
            else {
                v0.setVisibility(8);
            }
        }

        DecorToolbar v0_2 = this.mDecorToolbar;
        boolean v3 = (this.mHasEmbeddedTabs) || v5 == 0 ? false : true;
        v0_2.setCollapsible(v3);
        v0_1 = this.mOverlayLayout;
        if((this.mHasEmbeddedTabs) || v5 == 0) {
            v1 = false;
        }
        else {
        }

        v0_1.setHasNonEmbeddedTabs(v1);
    }

    public void setHideOffset(int arg2) {
        if(arg2 != 0) {
            if(this.mOverlayLayout.isInOverlayMode()) {
            }
            else {
                throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to set a non-zero hide offset");
            }
        }

        this.mOverlayLayout.setActionBarHideOffset(arg2);
    }

    public void setHideOnContentScrollEnabled(boolean arg2) {
        if(arg2) {
            if(this.mOverlayLayout.isInOverlayMode()) {
            }
            else {
                throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
            }
        }

        this.mHideOnContentScroll = arg2;
        this.mOverlayLayout.setHideOnContentScrollEnabled(arg2);
    }

    public void setHomeActionContentDescription(int arg1) {
        this.mDecorToolbar.setNavigationContentDescription(arg1);
    }

    public void setHomeActionContentDescription(CharSequence arg1) {
        this.mDecorToolbar.setNavigationContentDescription(arg1);
    }

    public void setHomeAsUpIndicator(int arg1) {
        this.mDecorToolbar.setNavigationIcon(arg1);
    }

    public void setHomeAsUpIndicator(Drawable arg1) {
        this.mDecorToolbar.setNavigationIcon(arg1);
    }

    public void setHomeButtonEnabled(boolean arg1) {
        this.mDecorToolbar.setHomeButtonEnabled(arg1);
    }

    public void setIcon(int arg1) {
        this.mDecorToolbar.setIcon(arg1);
    }

    public void setIcon(Drawable arg1) {
        this.mDecorToolbar.setIcon(arg1);
    }

    public void setListNavigationCallbacks(SpinnerAdapter arg2, OnNavigationListener arg3) {
        this.mDecorToolbar.setDropdownParams(arg2, new NavItemSelectedListener(arg3));
    }

    public void setLogo(int arg1) {
        this.mDecorToolbar.setLogo(arg1);
    }

    public void setLogo(Drawable arg1) {
        this.mDecorToolbar.setLogo(arg1);
    }

    public void setNavigationMode(int arg6) {
        int v0 = this.mDecorToolbar.getNavigationMode();
        int v1 = 2;
        if(v0 != v1) {
        }
        else {
            this.mSavedTabPosition = this.getSelectedNavigationIndex();
            this.selectTab(null);
            this.mTabScrollView.setVisibility(8);
        }

        if(v0 != arg6 && !this.mHasEmbeddedTabs) {
            ActionBarOverlayLayout v0_1 = this.mOverlayLayout;
            if(v0_1 != null) {
                ViewCompat.requestApplyInsets(((View)v0_1));
            }
        }

        this.mDecorToolbar.setNavigationMode(arg6);
        boolean v0_2 = false;
        if(arg6 != v1) {
        }
        else {
            this.ensureTabsExist();
            this.mTabScrollView.setVisibility(0);
            int v2 = this.mSavedTabPosition;
            int v3 = -1;
            if(v2 != v3) {
                this.setSelectedNavigationItem(v2);
                this.mSavedTabPosition = v3;
            }
        }

        DecorToolbar v2_1 = this.mDecorToolbar;
        boolean v4 = arg6 != v1 || (this.mHasEmbeddedTabs) ? false : true;
        v2_1.setCollapsible(v4);
        ActionBarOverlayLayout v2_2 = this.mOverlayLayout;
        if(arg6 == v1 && !this.mHasEmbeddedTabs) {
            v0_2 = true;
        }

        v2_2.setHasNonEmbeddedTabs(v0_2);
    }

    public void setSelectedNavigationItem(int arg3) {
        int v0 = this.mDecorToolbar.getNavigationMode();
        if(v0 != 1) {
            if(v0 == 2) {
                this.selectTab(this.mTabs.get(arg3));
                return;
            }

            throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
        }

        this.mDecorToolbar.setDropdownSelectedPosition(arg3);
    }

    public void setShowHideAnimationEnabled(boolean arg1) {
        this.mShowHideAnimationEnabled = arg1;
        if(!arg1) {
            ViewPropertyAnimatorCompatSet v0 = this.mCurrentShowAnim;
            if(v0 != null) {
                v0.cancel();
            }
        }
    }

    public void setSplitBackgroundDrawable(Drawable arg1) {
    }

    public void setStackedBackgroundDrawable(Drawable arg1) {
        this.mContainerView.setStackedBackground(arg1);
    }

    public void setSubtitle(int arg2) {
        this.setSubtitle(this.mContext.getString(arg2));
    }

    public void setSubtitle(CharSequence arg1) {
        this.mDecorToolbar.setSubtitle(arg1);
    }

    public void setTitle(int arg2) {
        this.setTitle(this.mContext.getString(arg2));
    }

    public void setTitle(CharSequence arg1) {
        this.mDecorToolbar.setTitle(arg1);
    }

    public void setWindowTitle(CharSequence arg1) {
        this.mDecorToolbar.setWindowTitle(arg1);
    }

    private boolean shouldAnimateContextView() {
        return ViewCompat.isLaidOut(this.mContainerView);
    }

    public void show() {
        if(this.mHiddenByApp) {
            this.mHiddenByApp = false;
            this.updateVisibility(false);
        }
    }

    private void showForActionMode() {
        if(!this.mShowingForMode) {
            this.mShowingForMode = true;
            ActionBarOverlayLayout v1 = this.mOverlayLayout;
            if(v1 != null) {
                v1.setShowingForActionMode(true);
            }

            this.updateVisibility(false);
        }
    }

    public void showForSystem() {
        if(this.mHiddenBySystem) {
            this.mHiddenBySystem = false;
            this.updateVisibility(true);
        }
    }

    public ActionMode startActionMode(androidx.appcompat.view.ActionMode$Callback arg3) {
        ActionModeImpl v0 = this.mActionMode;
        if(v0 != null) {
            v0.finish();
        }

        this.mOverlayLayout.setHideOnContentScrollEnabled(false);
        this.mContextView.killMode();
        v0 = new ActionModeImpl(this, this.mContextView.getContext(), arg3);
        if(v0.dispatchOnCreate()) {
            this.mActionMode = v0;
            v0.invalidate();
            this.mContextView.initForMode(((ActionMode)v0));
            this.animateToMode(true);
            return ((ActionMode)v0);
        }

        return null;
    }

    private void updateVisibility(boolean arg4) {
        boolean v0 = WindowDecorActionBar.checkShowingFlags(this.mHiddenByApp, this.mHiddenBySystem, this.mShowingForMode);
        boolean v1 = this.mNowShowing;
        if(v0) {
            if(!v1) {
                this.mNowShowing = true;
                this.doShow(arg4);
                return;
            }
        }
        else if(v1) {
            this.mNowShowing = false;
            this.doHide(arg4);
        }
    }
}

