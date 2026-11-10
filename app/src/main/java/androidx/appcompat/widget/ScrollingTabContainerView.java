package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils$TruncateAt;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View$MeasureSpec;
import android.view.View$OnClickListener;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView$LayoutParams;
import android.widget.AdapterView$OnItemSelectedListener;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout$LayoutParams;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.app.ActionBar$Tab;
import androidx.appcompat.view.ActionBarPolicy;

public class ScrollingTabContainerView extends HorizontalScrollView implements AdapterView$OnItemSelectedListener {
    class TabAdapter extends BaseAdapter {
        TabAdapter(ScrollingTabContainerView arg1) {
            ScrollingTabContainerView.this = arg1;
            super();
        }

        public int getCount() {
            return ScrollingTabContainerView.this.mTabLayout.getChildCount();
        }

        public Object getItem(int arg1) {
            return ScrollingTabContainerView.this.mTabLayout.getChildAt(arg1).getTab();
        }

        public long getItemId(int arg1) {
            return ((long)arg1);
        }

        public View getView(int arg1, View arg2, ViewGroup arg3) {
            if(arg2 == null) {
                return ScrollingTabContainerView.this.createTabView(this.getItem(arg1), true);
            }

            arg2.bindTab(this.getItem(arg1));
            return arg2;
        }
    }

    class TabClickListener implements View$OnClickListener {
        TabClickListener(ScrollingTabContainerView arg1) {
            ScrollingTabContainerView.this = arg1;
            super();
        }

        public void onClick(View arg6) {
            arg6.getTab().select();
            int v0 = ScrollingTabContainerView.this.mTabLayout.getChildCount();
            int v2;
            for(v2 = 0; v2 < v0; ++v2) {
                View v3 = ScrollingTabContainerView.this.mTabLayout.getChildAt(v2);
                boolean v4 = v3 == arg6 ? true : false;
                v3.setSelected(v4);
            }
        }
    }

    class TabView extends LinearLayout {
        private static final String ACCESSIBILITY_CLASS_NAME = "androidx.appcompat.app.ActionBar$Tab";
        private final int[] BG_ATTRS;
        private View mCustomView;
        private ImageView mIconView;
        private Tab mTab;
        private TextView mTextView;

        public TabView(ScrollingTabContainerView arg3, Context arg4, Tab arg5, boolean arg6) {
            ScrollingTabContainerView.this = arg3;
            super(arg4, null, attr.actionBarTabStyle);
            int[] v3 = new int[]{0x10100D4};
            this.BG_ATTRS = v3;
            this.mTab = arg5;
            TintTypedArray v3_1 = TintTypedArray.obtainStyledAttributes(arg4, null, v3, attr.actionBarTabStyle, 0);
            if(v3_1.hasValue(0)) {
                this.setBackgroundDrawable(v3_1.getDrawable(0));
            }

            v3_1.recycle();
            if(arg6) {
                this.setGravity(0x800013);
            }

            this.update();
        }

        public void bindTab(Tab arg1) {
            this.mTab = arg1;
            this.update();
        }

        public Tab getTab() {
            return this.mTab;
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent arg1) {
            super.onInitializeAccessibilityEvent(arg1);
            arg1.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo arg1) {
            super.onInitializeAccessibilityNodeInfo(arg1);
            arg1.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        public void onMeasure(int arg2, int arg3) {
            super.onMeasure(arg2, arg3);
            if(ScrollingTabContainerView.this.mMaxTabWidth > 0 && this.getMeasuredWidth() > ScrollingTabContainerView.this.mMaxTabWidth) {
                super.onMeasure(View$MeasureSpec.makeMeasureSpec(ScrollingTabContainerView.this.mMaxTabWidth, 0x40000000), arg3);
            }
        }

        public void setSelected(boolean arg2) {
            int v0 = this.isSelected() != arg2 ? 1 : 0;
            super.setSelected(arg2);
            if(v0 != 0 && (arg2)) {
                this.sendAccessibilityEvent(4);
            }
        }

        public void update() {
            CharSequence v3_1;
            Tab v0 = this.mTab;
            View v1 = v0.getCustomView();
            int v2 = 8;
            Drawable v3 = null;
            if(v1 != null) {
                ViewParent v0_1 = v1.getParent();
                if((((TabView)v0_1)) != this) {
                    if(v0_1 != null) {
                        ((ViewGroup)v0_1).removeView(v1);
                    }

                    this.addView(v1);
                }

                this.mCustomView = v1;
                TextView v0_2 = this.mTextView;
                if(v0_2 != null) {
                    v0_2.setVisibility(v2);
                }

                ImageView v0_3 = this.mIconView;
                if(v0_3 != null) {
                    v0_3.setVisibility(v2);
                    this.mIconView.setImageDrawable(v3);
                }

                return;
            }

            v1 = this.mCustomView;
            if(v1 != null) {
                this.removeView(v1);
                this.mCustomView = ((View)v3);
            }

            Drawable v1_1 = v0.getIcon();
            CharSequence v4 = v0.getText();
            ImageView v5 = this.mIconView;
            int v6 = 16;
            int v8 = -2;
            if(v1_1 != null) {
                if(v5 == null) {
                    AppCompatImageView v5_1 = new AppCompatImageView(this.getContext());
                    LinearLayout$LayoutParams v9 = new LinearLayout$LayoutParams(v8, v8);
                    v9.gravity = v6;
                    ((ImageView)v5_1).setLayoutParams(((ViewGroup$LayoutParams)v9));
                    this.addView(((View)v5_1), 0);
                    this.mIconView = ((ImageView)v5_1);
                }

                this.mIconView.setImageDrawable(v1_1);
                this.mIconView.setVisibility(0);
            }
            else {
                if(v5 == null) {
                    goto label_50;
                }

                v5.setVisibility(v2);
                this.mIconView.setImageDrawable(v3);
            }

        label_50:
            boolean v1_2 = TextUtils.isEmpty(v4);
            TextView v5_2 = this.mTextView;
            if(!v1_2) {
                if(v5_2 == null) {
                    AppCompatTextView v2_1 = new AppCompatTextView(this.getContext(), ((AttributeSet)v3), attr.actionBarTabTextStyle);
                    ((TextView)v2_1).setEllipsize(TextUtils$TruncateAt.END);
                    LinearLayout$LayoutParams v5_3 = new LinearLayout$LayoutParams(v8, v8);
                    v5_3.gravity = v6;
                    ((TextView)v2_1).setLayoutParams(((ViewGroup$LayoutParams)v5_3));
                    this.addView(((View)v2_1));
                    this.mTextView = ((TextView)v2_1);
                }

                this.mTextView.setText(v4);
                this.mTextView.setVisibility(0);
            }
            else {
                if(v5_2 == null) {
                    goto label_75;
                }

                v5_2.setVisibility(v2);
                this.mTextView.setText(((CharSequence)v3));
            }

        label_75:
            ImageView v2_2 = this.mIconView;
            if(v2_2 != null) {
                v2_2.setContentDescription(v0.getContentDescription());
            }

            if(!v1_2) {
            }
            else {
                v3_1 = v0.getContentDescription();
            }

            TooltipCompat.setTooltipText(((View)this), v3_1);
        }
    }

    public class VisibilityAnimListener extends AnimatorListenerAdapter {
        private boolean mCanceled;
        private int mFinalVisibility;

        protected VisibilityAnimListener(ScrollingTabContainerView arg1) {
            ScrollingTabContainerView.this = arg1;
            super();
            this.mCanceled = false;
        }

        public void onAnimationCancel(Animator arg1) {
            this.mCanceled = true;
        }

        public void onAnimationEnd(Animator arg2) {
            if(this.mCanceled) {
                return;
            }

            ScrollingTabContainerView.this.mVisibilityAnim = null;
            ScrollingTabContainerView.this.setVisibility(this.mFinalVisibility);
        }

        public void onAnimationStart(Animator arg2) {
            ScrollingTabContainerView.this.setVisibility(0);
            this.mCanceled = false;
        }

        public VisibilityAnimListener withFinalVisibility(ViewPropertyAnimator arg1, int arg2) {
            this.mFinalVisibility = arg2;
            ScrollingTabContainerView.this.mVisibilityAnim = arg1;
            return this;
        }
    }

    private static final int FADE_DURATION = 200;
    private static final String TAG = "ScrollingTabContainerView";
    private boolean mAllowCollapse;
    private int mContentHeight;
    int mMaxTabWidth;
    private int mSelectedTabIndex;
    int mStackedTabMaxWidth;
    private TabClickListener mTabClickListener;
    LinearLayoutCompat mTabLayout;
    Runnable mTabSelector;
    private Spinner mTabSpinner;
    protected final VisibilityAnimListener mVisAnimListener;
    protected ViewPropertyAnimator mVisibilityAnim;
    private static final Interpolator sAlphaInterpolator;

    static {
        ScrollingTabContainerView.sAlphaInterpolator = new DecelerateInterpolator();
    }

    public ScrollingTabContainerView(Context arg4) {
        super(arg4);
        this.mVisAnimListener = new VisibilityAnimListener(this);
        this.setHorizontalScrollBarEnabled(false);
        ActionBarPolicy v4 = ActionBarPolicy.get(arg4);
        this.setContentHeight(v4.getTabContainerHeight());
        this.mStackedTabMaxWidth = v4.getStackedTabMaxWidth();
        LinearLayoutCompat v4_1 = this.createTabLayout();
        this.mTabLayout = v4_1;
        this.addView(((View)v4_1), new ViewGroup$LayoutParams(-2, -1));
    }

    public void addTab(Tab arg6, int arg7, boolean arg8) {
        TabView v6 = this.createTabView(arg6, false);
        this.mTabLayout.addView(((View)v6), arg7, new LayoutParams(0, -1, 1f));
        Spinner v7 = this.mTabSpinner;
        if(v7 != null) {
            v7.getAdapter().notifyDataSetChanged();
        }

        if(arg8) {
            v6.setSelected(true);
        }

        if(this.mAllowCollapse) {
            this.requestLayout();
        }
    }

    public void addTab(Tab arg6, boolean arg7) {
        TabView v6 = this.createTabView(arg6, false);
        this.mTabLayout.addView(((View)v6), new LayoutParams(0, -1, 1f));
        Spinner v0 = this.mTabSpinner;
        if(v0 != null) {
            v0.getAdapter().notifyDataSetChanged();
        }

        if(arg7) {
            v6.setSelected(true);
        }

        if(this.mAllowCollapse) {
            this.requestLayout();
        }
    }

    public void animateToTab(int arg2) {
        View v2 = this.mTabLayout.getChildAt(arg2);
        Runnable v0 = this.mTabSelector;
        if(v0 != null) {
            this.removeCallbacks(v0);
        }

        androidx.appcompat.widget.ScrollingTabContainerView$1 v0_1 = new Runnable(v2) {
            public void run() {
                ScrollingTabContainerView.this.smoothScrollTo(this.val$tabView.getLeft() - (ScrollingTabContainerView.this.getWidth() - this.val$tabView.getWidth()) / 2, 0);
                ScrollingTabContainerView.this.mTabSelector = null;
            }
        };
        this.mTabSelector = ((Runnable)v0_1);
        this.post(((Runnable)v0_1));
    }

    public void animateToVisibility(int arg5) {
        ViewPropertyAnimator v2;
        ViewPropertyAnimator v0 = this.mVisibilityAnim;
        if(v0 != null) {
            v0.cancel();
        }

        long v0_1 = 200;
        if(arg5 == 0) {
            if(this.getVisibility() != 0) {
                this.setAlpha(0f);
            }

            v2 = this.animate().alpha(1f);
            v2.setDuration(v0_1);
            v2.setInterpolator(ScrollingTabContainerView.sAlphaInterpolator);
            v2.setListener(this.mVisAnimListener.withFinalVisibility(v2, arg5));
            v2.start();
            return;
        }

        v2 = this.animate().alpha(0f);
        v2.setDuration(v0_1);
        v2.setInterpolator(ScrollingTabContainerView.sAlphaInterpolator);
        v2.setListener(this.mVisAnimListener.withFinalVisibility(v2, arg5));
        v2.start();
    }

    private Spinner createSpinner() {
        AppCompatSpinner v0 = new AppCompatSpinner(this.getContext(), null, attr.actionDropDownStyle);
        ((Spinner)v0).setLayoutParams(new LayoutParams(-2, -1));
        ((Spinner)v0).setOnItemSelectedListener(((AdapterView$OnItemSelectedListener)this));
        return ((Spinner)v0);
    }

    private LinearLayoutCompat createTabLayout() {
        LinearLayoutCompat v0 = new LinearLayoutCompat(this.getContext(), null, attr.actionBarTabBarStyle);
        v0.setMeasureWithLargestChildEnabled(true);
        v0.setGravity(17);
        v0.setLayoutParams(new LayoutParams(-2, -1));
        return v0;
    }

    TabView createTabView(Tab arg3, boolean arg4) {
        TabView v0 = new TabView(this, this.getContext(), arg3, arg4);
        if(arg4) {
            v0.setBackgroundDrawable(null);
            v0.setLayoutParams(new AbsListView$LayoutParams(-1, this.mContentHeight));
            return v0;
        }

        v0.setFocusable(true);
        TabClickListener v3 = this.mTabClickListener;
        if(v3 == null) {
            v3 = new TabClickListener(this);
            this.mTabClickListener = v3;
        }

        v0.setOnClickListener(((View$OnClickListener)v3));
        return v0;
    }

    private boolean isCollapsed() {
        Spinner v0 = this.mTabSpinner;
        if(v0 != null && v0.getParent() == this) {
            return 1;
        }

        return 0;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable v0 = this.mTabSelector;
        if(v0 != null) {
            this.post(v0);
        }
    }

    protected void onConfigurationChanged(Configuration arg2) {
        super.onConfigurationChanged(arg2);
        ActionBarPolicy v2 = ActionBarPolicy.get(this.getContext());
        this.setContentHeight(v2.getTabContainerHeight());
        this.mStackedTabMaxWidth = v2.getStackedTabMaxWidth();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable v0 = this.mTabSelector;
        if(v0 != null) {
            this.removeCallbacks(v0);
        }
    }

    public void onItemSelected(AdapterView arg1, View arg2, int arg3, long arg4) {
        ((TabView)arg2).getTab().select();
    }

    public void onMeasure(int arg6, int arg7) {
        arg7 = View$MeasureSpec.getMode(arg6);
        int v2 = 0x40000000;
        boolean v3 = arg7 == v2 ? true : false;
        this.setFillViewport(v3);
        int v4 = this.mTabLayout.getChildCount();
        if(v4 > 1) {
            if(arg7 != v2 && arg7 != 0x80000000) {
                goto label_31;
            }

            if(v4 > 2) {
                arg7 = ((int)((((float)View$MeasureSpec.getSize(arg6))) * 0.4f));
                this.mMaxTabWidth = arg7;
            }
            else {
                arg7 = View$MeasureSpec.getSize(arg6) / 2;
                this.mMaxTabWidth = arg7;
            }

            this.mMaxTabWidth = Math.min(arg7, this.mStackedTabMaxWidth);
        }
        else {
        label_31:
            this.mMaxTabWidth = -1;
        }

        arg7 = View$MeasureSpec.makeMeasureSpec(this.mContentHeight, v2);
        if((v3) || !this.mAllowCollapse) {
            this.performExpand();
        }
        else {
            this.mTabLayout.measure(0, arg7);
            if(this.mTabLayout.getMeasuredWidth() > View$MeasureSpec.getSize(arg6)) {
                this.performCollapse();
            }
            else {
                this.performExpand();
            }
        }

        int v0 = this.getMeasuredWidth();
        super.onMeasure(arg6, arg7);
        arg6 = this.getMeasuredWidth();
        if((v3) && v0 != arg6) {
            this.setTabSelected(this.mSelectedTabIndex);
        }
    }

    public void onNothingSelected(AdapterView arg1) {
    }

    private void performCollapse() {
        if(this.isCollapsed()) {
            return;
        }

        if(this.mTabSpinner == null) {
            this.mTabSpinner = this.createSpinner();
        }

        this.removeView(this.mTabLayout);
        this.addView(this.mTabSpinner, new ViewGroup$LayoutParams(-2, -1));
        if(this.mTabSpinner.getAdapter() == null) {
            this.mTabSpinner.setAdapter(new TabAdapter(this));
        }

        Runnable v0 = this.mTabSelector;
        if(v0 != null) {
            this.removeCallbacks(v0);
            this.mTabSelector = null;
        }

        this.mTabSpinner.setSelection(this.mSelectedTabIndex);
    }

    private boolean performExpand() {
        if(!this.isCollapsed()) {
            return 0;
        }

        this.removeView(this.mTabSpinner);
        this.addView(this.mTabLayout, new ViewGroup$LayoutParams(-2, -1));
        this.setTabSelected(this.mTabSpinner.getSelectedItemPosition());
        return 0;
    }

    public void removeAllTabs() {
        this.mTabLayout.removeAllViews();
        Spinner v0 = this.mTabSpinner;
        if(v0 != null) {
            v0.getAdapter().notifyDataSetChanged();
        }

        if(this.mAllowCollapse) {
            this.requestLayout();
        }
    }

    public void removeTabAt(int arg2) {
        this.mTabLayout.removeViewAt(arg2);
        Spinner v2 = this.mTabSpinner;
        if(v2 != null) {
            v2.getAdapter().notifyDataSetChanged();
        }

        if(this.mAllowCollapse) {
            this.requestLayout();
        }
    }

    public void setAllowCollapse(boolean arg1) {
        this.mAllowCollapse = arg1;
    }

    public void setContentHeight(int arg1) {
        this.mContentHeight = arg1;
        this.requestLayout();
    }

    public void setTabSelected(int arg6) {
        this.mSelectedTabIndex = arg6;
        int v0 = this.mTabLayout.getChildCount();
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            View v3 = this.mTabLayout.getChildAt(v2);
            boolean v4 = v2 == arg6 ? true : false;
            v3.setSelected(v4);
            if(v4) {
                this.animateToTab(arg6);
            }
        }

        Spinner v5 = this.mTabSpinner;
        if(v5 != null && arg6 >= 0) {
            v5.setSelection(arg6);
        }
    }

    public void updateTab(int arg2) {
        this.mTabLayout.getChildAt(arg2).update();
        Spinner v2 = this.mTabSpinner;
        if(v2 != null) {
            v2.getAdapter().notifyDataSetChanged();
        }

        if(this.mAllowCollapse) {
            this.requestLayout();
        }
    }
}

