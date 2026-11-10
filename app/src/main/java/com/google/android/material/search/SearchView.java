package com.google.android.material.search;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build$VERSION;
import android.os.Parcel;
import android.os.Parcelable$ClassLoaderCreator;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.activity.BackEventCompat;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.appcompat.widget.Toolbar$OnMenuItemClickListener;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout$AttachedBehavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$drawable;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.internal.ClippableRoundedCornerLayout;
import com.google.android.material.internal.ContextUtils;
import com.google.android.material.internal.FadeThroughDrawable;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ToolbarUtils;
import com.google.android.material.internal.TouchObserverFrameLayout;
import com.google.android.material.internal.ViewUtils$RelativePadding;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.motion.MaterialBackHandler;
import com.google.android.material.motion.MaterialBackOrchestrator;
import com.google.android.material.motion.MaterialMainContainerBackHelper;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class SearchView extends FrameLayout implements AttachedBehavior, MaterialBackHandler {
    public class Behavior extends androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior {
        public Behavior() {
            super();
        }

        public Behavior(Context arg1, AttributeSet arg2) {
            super(arg1, arg2);
        }

        public boolean onDependentViewChanged(CoordinatorLayout arg1, View arg2, View arg3) {
            return this.onDependentViewChanged(arg1, ((SearchView)arg2), arg3);
        }

        public boolean onDependentViewChanged(CoordinatorLayout arg1, SearchView arg2, View arg3) {
            if(!arg2.isSetupWithSearchBar() && ((arg3 instanceof SearchBar))) {
                arg2.setupWithSearchBar(((SearchBar)arg3));
            }

            return 0;
        }
    }

    class SavedState extends AbsSavedState {
        class com.google.android.material.search.SearchView$SavedState$1 implements Parcelable$ClassLoaderCreator {
            com.google.android.material.search.SearchView$SavedState$1() {
                super();
            }

            public SavedState createFromParcel(Parcel arg1) {
                return new SavedState(arg1);
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
        String text;
        int visibility;

        static {
            SavedState.CREATOR = new com.google.android.material.search.SearchView$SavedState$1();
        }

        public SavedState(Parcelable arg1) {
            super(arg1);
        }

        public SavedState(Parcel arg2) {
            this(arg2, null);
        }

        public SavedState(Parcel arg1, ClassLoader arg2) {
            super(arg1, arg2);
            this.text = arg1.readString();
            this.visibility = arg1.readInt();
        }

        public void writeToParcel(Parcel arg1, int arg2) {
            super.writeToParcel(arg1, arg2);
            arg1.writeString(this.text);
            arg1.writeInt(this.visibility);
        }
    }

    public interface TransitionListener {
        void onStateChanged(SearchView arg1, TransitionState arg2, TransitionState arg3);
    }

    public enum TransitionState {
        public static final enum TransitionState HIDDEN;
        public static final enum TransitionState HIDING;
        public static final enum TransitionState SHOWING;
        public static final enum TransitionState SHOWN;

        static {
            TransitionState v0 = new TransitionState("HIDING", 0);
            TransitionState.HIDING = v0;
            TransitionState v1 = new TransitionState("HIDDEN", 1);
            TransitionState.HIDDEN = v1;
            TransitionState v2 = new TransitionState("SHOWING", 2);
            TransitionState.SHOWING = v2;
            TransitionState v3 = new TransitionState("SHOWN", 3);
            TransitionState.SHOWN = v3;
            TransitionState.$VALUES = new TransitionState[]{v0, v1, v2, v3};
        }

        private TransitionState(String arg1, int arg2) {
            super(arg1, arg2);
        }

        public static TransitionState valueOf(String arg1) {
            return Enum.valueOf(TransitionState.class, arg1);
        }

        public static TransitionState[] values() {
            return TransitionState.$VALUES.clone();
        }
    }

    private static final int DEF_STYLE_RES = 0;
    private static final long TALKBACK_FOCUS_CHANGE_DELAY_MS = 100;
    private boolean animatedMenuItems;
    private boolean animatedNavigationIcon;
    private boolean autoShowKeyboard;
    private final boolean backHandlingEnabled;
    private final MaterialBackOrchestrator backOrchestrator;
    private final int backgroundColor;
    final View backgroundView;
    private Map childImportantForAccessibilityMap;
    final ImageButton clearButton;
    final TouchObserverFrameLayout contentContainer;
    private TransitionState currentTransitionState;
    final View divider;
    final Toolbar dummyToolbar;
    final EditText editText;
    private final ElevationOverlayProvider elevationOverlayProvider;
    final FrameLayout headerContainer;
    private final boolean layoutInflated;
    final ClippableRoundedCornerLayout rootView;
    final View scrim;
    private SearchBar searchBar;
    final TextView searchPrefix;
    private final SearchViewAnimationHelper searchViewAnimationHelper;
    private int softInputMode;
    final View statusBarSpacer;
    private boolean statusBarSpacerEnabledOverride;
    final MaterialToolbar toolbar;
    final FrameLayout toolbarContainer;
    private final Set transitionListeners;
    private boolean useWindowInsetsController;

    static {
        SearchView.DEF_STYLE_RES = style.Widget_Material3_SearchView;
    }

    public SearchView(Context arg2) {
        this(arg2, null);
    }

    public SearchView(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, attr.materialSearchViewStyle);
    }

    public SearchView(Context arg9, AttributeSet arg10, int arg11) {
        int v4 = SearchView.DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(arg9, arg10, arg11, v4), arg10, arg11);
        this.backOrchestrator = new MaterialBackOrchestrator(((View)this));
        this.transitionListeners = new LinkedHashSet();
        this.softInputMode = 16;
        this.currentTransitionState = TransitionState.HIDDEN;
        Context v0 = this.getContext();
        TypedArray v10 = ThemeEnforcement.obtainStyledAttributes(v0, arg10, styleable.SearchView, arg11, v4, new int[0]);
        this.backgroundColor = v10.getColor(styleable.SearchView_backgroundTint, 0);
        arg11 = v10.getResourceId(styleable.SearchView_headerLayout, -1);
        int v1 = v10.getResourceId(styleable.SearchView_android_textAppearance, -1);
        String v2 = v10.getString(styleable.SearchView_android_text);
        String v3 = v10.getString(styleable.SearchView_android_hint);
        String v4_1 = v10.getString(styleable.SearchView_searchPrefixText);
        boolean v5 = v10.getBoolean(styleable.SearchView_useDrawerArrowDrawable, false);
        this.animatedNavigationIcon = v10.getBoolean(styleable.SearchView_animateNavigationIcon, true);
        this.animatedMenuItems = v10.getBoolean(styleable.SearchView_animateMenuItems, true);
        boolean v9 = v10.getBoolean(styleable.SearchView_hideNavigationIcon, false);
        this.autoShowKeyboard = v10.getBoolean(styleable.SearchView_autoShowKeyboard, true);
        this.backHandlingEnabled = v10.getBoolean(styleable.SearchView_backHandlingEnabled, true);
        v10.recycle();
        LayoutInflater.from(v0).inflate(layout.mtrl_search_view, ((ViewGroup)this));
        this.layoutInflated = true;
        this.scrim = this.findViewById(id.open_search_view_scrim);
        this.rootView = this.findViewById(id.open_search_view_root);
        this.backgroundView = this.findViewById(id.open_search_view_background);
        this.statusBarSpacer = this.findViewById(id.open_search_view_status_bar_spacer);
        this.headerContainer = this.findViewById(id.open_search_view_header_container);
        this.toolbarContainer = this.findViewById(id.open_search_view_toolbar_container);
        this.toolbar = this.findViewById(id.open_search_view_toolbar);
        this.dummyToolbar = this.findViewById(id.open_search_view_dummy_toolbar);
        this.searchPrefix = this.findViewById(id.open_search_view_search_prefix);
        this.editText = this.findViewById(id.open_search_view_edit_text);
        this.clearButton = this.findViewById(id.open_search_view_clear_button);
        this.divider = this.findViewById(id.open_search_view_divider);
        this.contentContainer = this.findViewById(id.open_search_view_content_container);
        this.searchViewAnimationHelper = new SearchViewAnimationHelper(this);
        this.elevationOverlayProvider = new ElevationOverlayProvider(v0);
        this.setUpRootView();
        this.setUpBackgroundViewElevationOverlay();
        this.setUpHeaderLayout(arg11);
        this.setSearchPrefixText(((CharSequence)v4_1));
        this.setUpEditText(v1, v2, v3);
        this.setUpBackButton(v5, v9);
        this.setUpClearButton();
        this.setUpContentOnTouchListener();
        this.setUpInsetListeners();
    }

    public void addHeaderView(View arg2) {
        this.headerContainer.addView(arg2);
        this.headerContainer.setVisibility(0);
    }

    public void addTransitionListener(TransitionListener arg1) {
        this.transitionListeners.add(arg1);
    }

    public void addView(View arg2, int arg3, ViewGroup$LayoutParams arg4) {
        if(this.layoutInflated) {
            this.contentContainer.addView(arg2, arg3, arg4);
            return;
        }

        super.addView(arg2, arg3, arg4);
    }

    public void cancelBackProgress() {
        if(!this.isHiddenOrHiding() && this.searchBar != null) {
            if(Build$VERSION.SDK_INT < 34) {
            }
            else {
                this.searchViewAnimationHelper.cancelBackProgress();
            }
        }
    }

    public void clearFocusAndHideKeyboard() {
        this.editText.post(new SearchView$$ExternalSyntheticLambda10(this));
    }

    public void clearText() {
        this.editText.setText("");
    }

    private Window getActivityWindow() {
        Activity v0 = ContextUtils.getActivity(this.getContext());
        if(v0 == null) {
            return null;
        }

        return v0.getWindow();
    }

    MaterialMainContainerBackHelper getBackHelper() {
        return this.searchViewAnimationHelper.getBackHelper();
    }

    public androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior getBehavior() {
        return new Behavior();
    }

    public TransitionState getCurrentTransitionState() {
        return this.currentTransitionState;
    }

    protected int getDefaultNavigationIconResource() {
        return drawable.ic_arrow_back_black_24;
    }

    public EditText getEditText() {
        return this.editText;
    }

    public CharSequence getHint() {
        return this.editText.getHint();
    }

    private float getOverlayElevation() {
        SearchBar v0 = this.searchBar;
        if(v0 != null) {
            return v0.getCompatElevation();
        }

        return this.getResources().getDimension(dimen.m3_searchview_elevation);
    }

    public TextView getSearchPrefix() {
        return this.searchPrefix;
    }

    public CharSequence getSearchPrefixText() {
        return this.searchPrefix.getText();
    }

    public int getSoftInputMode() {
        return this.softInputMode;
    }

    private int getStatusBarHeight() {
        int v0 = this.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if(v0 > 0) {
            return this.getResources().getDimensionPixelSize(v0);
        }

        return 0;
    }

    public Editable getText() {
        return this.editText.getText();
    }

    public Toolbar getToolbar() {
        return this.toolbar;
    }

    public void handleBackInvoked() {
        if(this.isHiddenOrHiding()) {
            return;
        }

        BackEventCompat v0 = this.searchViewAnimationHelper.onHandleBackInvoked();
        if(Build$VERSION.SDK_INT >= 34 && this.searchBar != null && v0 != null) {
            this.searchViewAnimationHelper.finishBackProgress();
            return;
        }

        this.hide();
    }

    public void hide() {
        if(!this.currentTransitionState.equals(TransitionState.HIDDEN)) {
            if(this.currentTransitionState.equals(TransitionState.HIDING)) {
            }
            else {
                this.searchViewAnimationHelper.hide();
            }
        }
    }

    public void inflateMenu(int arg1) {
        this.toolbar.inflateMenu(arg1);
    }

    boolean isAdjustNothingSoftInputMode() {
        if(this.softInputMode == 0x30) {
            return 1;
        }

        return 0;
    }

    public boolean isAnimatedNavigationIcon() {
        return this.animatedNavigationIcon;
    }

    public boolean isAutoShowKeyboard() {
        return this.autoShowKeyboard;
    }

    private boolean isHiddenOrHiding() {
        if(!this.currentTransitionState.equals(TransitionState.HIDDEN)) {
            if(this.currentTransitionState.equals(TransitionState.HIDING)) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public boolean isMenuItemsAnimated() {
        return this.animatedMenuItems;
    }

    private boolean isNavigationIconDrawerArrowDrawable(Toolbar arg1) {
        return DrawableCompat.unwrap(arg1.getNavigationIcon()) instanceof DrawerArrowDrawable;
    }

    public boolean isSetupWithSearchBar() {
        if(this.searchBar != null) {
            return 1;
        }

        return 0;
    }

    public boolean isShowing() {
        if(!this.currentTransitionState.equals(TransitionState.SHOWN)) {
            if(this.currentTransitionState.equals(TransitionState.SHOWING)) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public boolean isUseWindowInsetsController() {
        return this.useWindowInsetsController;
    }

    void lambda$clearFocusAndHideKeyboard$9$com-google-android-material-search-SearchView() {
        this.editText.clearFocus();
        SearchBar v0 = this.searchBar;
        if(v0 != null) {
            v0.requestFocus();
        }

        ViewUtils.hideKeyboard(this.editText, this.useWindowInsetsController);
    }

    void lambda$requestFocusAndShowKeyboard$8$com-google-android-material-search-SearchView() {
        if(this.editText.requestFocus()) {
            this.editText.sendAccessibilityEvent(8);
        }

        ViewUtils.showKeyboard(this.editText, this.useWindowInsetsController);
    }

    void lambda$setUpBackButton$1$com-google-android-material-search-SearchView(View arg1) {
        this.hide();
    }

    void lambda$setUpClearButton$2$com-google-android-material-search-SearchView(View arg1) {
        this.clearText();
        this.requestFocusAndShowKeyboardIfNeeded();
    }

    boolean lambda$setUpContentOnTouchListener$3$com-google-android-material-search-SearchView(View arg1, MotionEvent arg2) {
        if(this.isAdjustNothingSoftInputMode()) {
            this.clearFocusAndHideKeyboard();
        }

        return 0;
    }

    static WindowInsetsCompat lambda$setUpDividerInsetListener$6(ViewGroup$MarginLayoutParams arg0, int arg1, int arg2, View arg3, WindowInsetsCompat arg4) {
        arg0.leftMargin = arg1 + arg4.getSystemWindowInsetLeft();
        arg0.rightMargin = arg2 + arg4.getSystemWindowInsetRight();
        return arg4;
    }

    static boolean lambda$setUpRootView$0(View arg0, MotionEvent arg1) {
        return 1;
    }

    WindowInsetsCompat lambda$setUpStatusBarSpacerInsetListener$5$com-google-android-material-search-SearchView(View arg2, WindowInsetsCompat arg3) {
        int v2 = arg3.getSystemWindowInsetTop();
        this.setUpStatusBarSpacer(v2);
        if(!this.statusBarSpacerEnabledOverride) {
            boolean v2_1 = v2 > 0 ? true : false;
            this.setStatusBarSpacerEnabledInternal(v2_1);
        }

        return arg3;
    }

    WindowInsetsCompat lambda$setUpToolbarInsetListener$4$com-google-android-material-search-SearchView(View arg4, WindowInsetsCompat arg5, RelativePadding arg6) {
        boolean v4 = ViewUtils.isLayoutRtl(this.toolbar);
        int v0 = v4 ? arg6.end : arg6.start;
        int v4_1 = v4 ? arg6.start : arg6.end;
        this.toolbar.setPadding(v0 + arg5.getSystemWindowInsetLeft(), arg6.top, v4_1 + arg5.getSystemWindowInsetRight(), arg6.bottom);
        return arg5;
    }

    void lambda$setupWithSearchBar$7$com-google-android-material-search-SearchView(View arg1) {
        this.show();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(((View)this));
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.updateSoftInputMode();
    }

    protected void onRestoreInstanceState(Parcelable arg2) {
        if(!(arg2 instanceof SavedState)) {
            super.onRestoreInstanceState(arg2);
            return;
        }

        super.onRestoreInstanceState(((SavedState)arg2).getSuperState());
        this.setText(((SavedState)arg2).text);
        boolean v2 = ((SavedState)arg2).visibility == 0 ? true : false;
        this.setVisible(v2);
    }

    protected Parcelable onSaveInstanceState() {
        SavedState v0 = new SavedState(super.onSaveInstanceState());
        Editable v1 = this.getText();
        String v1_1 = v1 == null ? null : v1.toString();
        v0.text = v1_1;
        v0.visibility = this.rootView.getVisibility();
        return ((Parcelable)v0);
    }

    public void removeAllHeaderViews() {
        this.headerContainer.removeAllViews();
        this.headerContainer.setVisibility(8);
    }

    public void removeHeaderView(View arg2) {
        this.headerContainer.removeView(arg2);
        if(this.headerContainer.getChildCount() == 0) {
            this.headerContainer.setVisibility(8);
        }
    }

    public void removeTransitionListener(TransitionListener arg1) {
        this.transitionListeners.remove(arg1);
    }

    public void requestFocusAndShowKeyboard() {
        this.editText.postDelayed(new SearchView$$ExternalSyntheticLambda2(this), 100);
    }

    void requestFocusAndShowKeyboardIfNeeded() {
        if(this.autoShowKeyboard) {
            this.requestFocusAndShowKeyboard();
        }
    }

    public void setAnimatedNavigationIcon(boolean arg1) {
        this.animatedNavigationIcon = arg1;
    }

    public void setAutoShowKeyboard(boolean arg1) {
        this.autoShowKeyboard = arg1;
    }

    public void setElevation(float arg1) {
        super.setElevation(arg1);
        this.setUpBackgroundViewElevationOverlay(arg1);
    }

    public void setHint(int arg1) {
        this.editText.setHint(arg1);
    }

    public void setHint(CharSequence arg1) {
        this.editText.setHint(arg1);
    }

    public void setMenuItemsAnimated(boolean arg1) {
        this.animatedMenuItems = arg1;
    }

    public void setModalForAccessibility(boolean arg4) {
        View v0 = this.getRootView();
        if(arg4) {
            this.childImportantForAccessibilityMap = new HashMap(((ViewGroup)v0).getChildCount());
        }

        this.updateChildImportantForAccessibility(((ViewGroup)v0), arg4);
        if(!arg4) {
            this.childImportantForAccessibilityMap = null;
        }
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener arg1) {
        this.toolbar.setOnMenuItemClickListener(arg1);
    }

    public void setSearchPrefixText(CharSequence arg2) {
        this.searchPrefix.setText(arg2);
        TextView v1 = this.searchPrefix;
        int v2 = TextUtils.isEmpty(arg2) ? 8 : 0;
        v1.setVisibility(v2);
    }

    public void setStatusBarSpacerEnabled(boolean arg2) {
        this.statusBarSpacerEnabledOverride = true;
        this.setStatusBarSpacerEnabledInternal(arg2);
    }

    private void setStatusBarSpacerEnabledInternal(boolean arg1) {
        View v0 = this.statusBarSpacer;
        int v1 = arg1 ? 0 : 8;
        v0.setVisibility(v1);
    }

    public void setText(CharSequence arg1) {
        this.editText.setText(arg1);
    }

    public void setText(int arg1) {
        this.editText.setText(arg1);
    }

    public void setToolbarTouchscreenBlocksFocus(boolean arg1) {
        this.toolbar.setTouchscreenBlocksFocus(arg1);
    }

    private void setTransitionState(TransitionState arg3, boolean arg4) {
        if(this.currentTransitionState.equals(arg3)) {
            return;
        }

        if(arg4) {
            if(arg3 == TransitionState.SHOWN) {
                this.setModalForAccessibility(true);
            }
            else if(arg3 == TransitionState.HIDDEN) {
                this.setModalForAccessibility(false);
            }
        }

        TransitionState v4 = this.currentTransitionState;
        this.currentTransitionState = arg3;
        Iterator v0 = new LinkedHashSet(this.transitionListeners).iterator();
        while(v0.hasNext()) {
            v0.next().onStateChanged(this, v4, arg3);
        }

        this.updateListeningForBackCallbacks(arg3);
    }

    void setTransitionState(TransitionState arg2) {
        this.setTransitionState(arg2, true);
    }

    private void setUpBackButton(boolean arg2, boolean arg3) {
        MaterialToolbar v0 = this.toolbar;
        if(arg3) {
            v0.setNavigationIcon(null);
            return;
        }

        v0.setNavigationOnClickListener(new SearchView$$ExternalSyntheticLambda9(this));
        if(arg2) {
            DrawerArrowDrawable v2 = new DrawerArrowDrawable(this.getContext());
            v2.setColor(MaterialColors.getColor(((View)this), attr.colorOnSurface));
            this.toolbar.setNavigationIcon(((Drawable)v2));
        }
    }

    private void setUpBackgroundViewElevationOverlay() {
        this.setUpBackgroundViewElevationOverlay(this.getOverlayElevation());
    }

    private void setUpBackgroundViewElevationOverlay(float arg3) {
        ElevationOverlayProvider v0 = this.elevationOverlayProvider;
        if(v0 != null) {
            if(this.backgroundView == null) {
            }
            else {
                this.backgroundView.setBackgroundColor(v0.compositeOverlayIfNeeded(this.backgroundColor, arg3));
            }
        }
    }

    private void setUpClearButton() {
        this.clearButton.setOnClickListener(new SearchView$$ExternalSyntheticLambda1(this));
        this.editText.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable arg1) {
            }

            public void beforeTextChanged(CharSequence arg1, int arg2, int arg3, int arg4) {
            }

            public void onTextChanged(CharSequence arg1, int arg2, int arg3, int arg4) {
                ImageButton v0 = SearchView.this.clearButton;
                int v1 = arg1.length() > 0 ? 0 : 8;
                v0.setVisibility(v1);
            }
        });
    }

    private void setUpContentOnTouchListener() {
        this.contentContainer.setOnTouchListener(new SearchView$$ExternalSyntheticLambda8(this));
    }

    private void setUpDividerInsetListener() {
        ViewGroup$LayoutParams v0 = this.divider.getLayoutParams();
        ViewCompat.setOnApplyWindowInsetsListener(this.divider, new SearchView$$ExternalSyntheticLambda0(((ViewGroup$MarginLayoutParams)v0), ((ViewGroup$MarginLayoutParams)v0).leftMargin, ((ViewGroup$MarginLayoutParams)v0).rightMargin));
    }

    private void setUpEditText(int arg2, String arg3, String arg4) {
        if(arg2 != -1) {
            TextViewCompat.setTextAppearance(this.editText, arg2);
        }

        this.editText.setText(((CharSequence)arg3));
        this.editText.setHint(((CharSequence)arg4));
    }

    private void setUpHeaderLayout(int arg4) {
        if(arg4 != -1) {
            this.addHeaderView(LayoutInflater.from(this.getContext()).inflate(arg4, this.headerContainer, false));
        }
    }

    private void setUpInsetListeners() {
        this.setUpToolbarInsetListener();
        this.setUpDividerInsetListener();
        this.setUpStatusBarSpacerInsetListener();
    }

    private void setUpRootView() {
        this.rootView.setOnTouchListener(new SearchView$$ExternalSyntheticLambda7());
    }

    private void setUpStatusBarSpacer(int arg2) {
        if(this.statusBarSpacer.getLayoutParams().height != arg2) {
            this.statusBarSpacer.getLayoutParams().height = arg2;
            this.statusBarSpacer.requestLayout();
        }
    }

    private void setUpStatusBarSpacerInsetListener() {
        this.setUpStatusBarSpacer(this.getStatusBarHeight());
        ViewCompat.setOnApplyWindowInsetsListener(this.statusBarSpacer, new SearchView$$ExternalSyntheticLambda4(this));
    }

    private void setUpToolbarInsetListener() {
        ViewUtils.doOnApplyWindowInsets(this.toolbar, new SearchView$$ExternalSyntheticLambda3(this));
    }

    public void setUseWindowInsetsController(boolean arg1) {
        this.useWindowInsetsController = arg1;
    }

    public void setVisible(boolean arg6) {
        boolean v1 = true;
        boolean v0 = this.rootView.getVisibility() == 0 ? true : false;
        ClippableRoundedCornerLayout v3 = this.rootView;
        int v4 = arg6 ? 0 : 8;
        v3.setVisibility(v4);
        this.updateNavigationIconProgressIfNeeded();
        TransitionState v3_1 = arg6 ? TransitionState.SHOWN : TransitionState.HIDDEN;
        if(v0 != arg6) {
        }
        else {
            v1 = false;
        }

        this.setTransitionState(v3_1, v1);
    }

    public void setupWithSearchBar(SearchBar arg3) {
        this.searchBar = arg3;
        this.searchViewAnimationHelper.setSearchBar(arg3);
        if(arg3 != null) {
            arg3.setOnClickListener(new SearchView$$ExternalSyntheticLambda5(this));
            if(Build$VERSION.SDK_INT >= 34) {
                try {
                    arg3.setHandwritingDelegatorCallback(new SearchView$$ExternalSyntheticLambda6(this));
                    this.editText.setIsHandwritingDelegate(true);
                    goto label_16;
                }
                catch(LinkageError ) {
                label_16:
                    this.updateNavigationIconIfNeeded();
                    this.setUpBackgroundViewElevationOverlay();
                    this.updateListeningForBackCallbacks(this.getCurrentTransitionState());
                    return;
                }
            }
        }

        goto label_16;
    }

    public void show() {
        if(!this.currentTransitionState.equals(TransitionState.SHOWN)) {
            if(this.currentTransitionState.equals(TransitionState.SHOWING)) {
            }
            else {
                this.searchViewAnimationHelper.show();
            }
        }
    }

    public void startBackProgress(BackEventCompat arg2) {
        if(!this.isHiddenOrHiding()) {
            if(this.searchBar == null) {
            }
            else {
                this.searchViewAnimationHelper.startBackProgress(arg2);
            }
        }
    }

    public void updateBackProgress(BackEventCompat arg3) {
        if(!this.isHiddenOrHiding() && this.searchBar != null) {
            if(Build$VERSION.SDK_INT < 34) {
            }
            else {
                this.searchViewAnimationHelper.updateBackProgress(arg3);
            }
        }
    }

    private void updateChildImportantForAccessibility(ViewGroup arg5, boolean arg6) {
        int v0;
        for(v0 = 0; v0 < arg5.getChildCount(); ++v0) {
            View v1 = arg5.getChildAt(v0);
            if((((SearchView)v1)) == this) {
            }
            else if(v1.findViewById(this.rootView.getId()) != null) {
                this.updateChildImportantForAccessibility(((ViewGroup)v1), arg6);
            }
            else {
                Map v2 = this.childImportantForAccessibilityMap;
                if(arg6) {
                    v2.put(v1, Integer.valueOf(v1.getImportantForAccessibility()));
                    ViewCompat.setImportantForAccessibility(v1, 4);
                }
                else if(v2 != null && (v2.containsKey(v1))) {
                    ViewCompat.setImportantForAccessibility(v1, this.childImportantForAccessibilityMap.get(v1).intValue());
                }
            }
        }
    }

    private void updateListeningForBackCallbacks(TransitionState arg2) {
        if(this.searchBar != null && (this.backHandlingEnabled)) {
            if(arg2.equals(TransitionState.SHOWN)) {
                this.backOrchestrator.startListeningForBackCallbacks();
                return;
            }
            else if(arg2.equals(TransitionState.HIDDEN)) {
                this.backOrchestrator.stopListeningForBackCallbacks();
            }
        }
    }

    private void updateNavigationIconIfNeeded() {
        MaterialToolbar v0 = this.toolbar;
        if(v0 == null) {
        }
        else {
            if(this.isNavigationIconDrawerArrowDrawable(((Toolbar)v0))) {
                return;
            }

            goto label_6;
        }

        return;
    label_6:
        int v0_1 = this.getDefaultNavigationIconResource();
        if(this.searchBar == null) {
            this.toolbar.setNavigationIcon(v0_1);
            return;
        }

        Drawable v0_2 = DrawableCompat.wrap(AppCompatResources.getDrawable(this.getContext(), v0_1).mutate());
        if(this.toolbar.getNavigationIconTint() != null) {
            DrawableCompat.setTint(v0_2, this.toolbar.getNavigationIconTint().intValue());
        }

        this.toolbar.setNavigationIcon(new FadeThroughDrawable(this.searchBar.getNavigationIcon(), v0_2));
        this.updateNavigationIconProgressIfNeeded();
    }

    private void updateNavigationIconProgressIfNeeded() {
        ImageButton v0 = ToolbarUtils.getNavigationIconButton(this.toolbar);
        if(v0 == null) {
        }
        else {
            int v3 = this.rootView.getVisibility() == 0 ? 1 : 0;
            Drawable v0_1 = DrawableCompat.unwrap(v0.getDrawable());
            if((v0_1 instanceof DrawerArrowDrawable)) {
                v0_1.setProgress(((float)v3));
            }

            if(!(v0_1 instanceof FadeThroughDrawable)) {
                return;
            }

            ((FadeThroughDrawable)v0_1).setProgress(((float)v3));
        }
    }

    public void updateSoftInputMode() {
        Window v0 = this.getActivityWindow();
        if(v0 != null) {
            this.softInputMode = v0.getAttributes().softInputMode;
        }
    }
}

