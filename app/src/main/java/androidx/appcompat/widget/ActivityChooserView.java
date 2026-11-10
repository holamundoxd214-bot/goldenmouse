package androidx.appcompat.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View$AccessibilityDelegate;
import android.view.View$MeasureSpec;
import android.view.View$OnClickListener;
import android.view.View$OnLongClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver$OnGlobalLayoutListener;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AdapterView$OnItemClickListener;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow$OnDismissListener;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$string;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.core.view.ActionProvider;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

public class ActivityChooserView extends ViewGroup implements ActivityChooserModelClient {
    class androidx.appcompat.widget.ActivityChooserView$1 extends DataSetObserver {
        androidx.appcompat.widget.ActivityChooserView$1(ActivityChooserView arg1) {
            ActivityChooserView.this = arg1;
            super();
        }

        public void onChanged() {
            super.onChanged();
            ActivityChooserView.this.mAdapter.notifyDataSetChanged();
        }

        public void onInvalidated() {
            super.onInvalidated();
            ActivityChooserView.this.mAdapter.notifyDataSetInvalidated();
        }
    }

    class androidx.appcompat.widget.ActivityChooserView$2 implements ViewTreeObserver$OnGlobalLayoutListener {
        androidx.appcompat.widget.ActivityChooserView$2(ActivityChooserView arg1) {
            ActivityChooserView.this = arg1;
            super();
        }

        public void onGlobalLayout() {
            if(ActivityChooserView.this.isShowingPopup()) {
                boolean v0 = ActivityChooserView.this.isShown();
                ActivityChooserView v1 = ActivityChooserView.this;
                if(!v0) {
                    v1.getListPopupWindow().dismiss();
                    return;
                }
                else {
                    v1.getListPopupWindow().show();
                    if(ActivityChooserView.this.mProvider != null) {
                        ActivityChooserView.this.mProvider.subUiVisibilityChanged(true);
                    }
                }
            }
        }
    }

    class ActivityChooserViewAdapter extends BaseAdapter {
        private static final int ITEM_VIEW_TYPE_ACTIVITY = 0;
        private static final int ITEM_VIEW_TYPE_COUNT = 3;
        private static final int ITEM_VIEW_TYPE_FOOTER = 1;
        public static final int MAX_ACTIVITY_COUNT_DEFAULT = 4;
        public static final int MAX_ACTIVITY_COUNT_UNLIMITED = 0x7FFFFFFF;
        private ActivityChooserModel mDataModel;
        private boolean mHighlightDefaultActivity;
        private int mMaxActivityCount;
        private boolean mShowDefaultActivity;
        private boolean mShowFooterView;

        ActivityChooserViewAdapter(ActivityChooserView arg1) {
            ActivityChooserView.this = arg1;
            super();
            this.mMaxActivityCount = 4;
        }

        public int getActivityCount() {
            return this.mDataModel.getActivityCount();
        }

        public int getCount() {
            int v0 = this.mDataModel.getActivityCount();
            if(!this.mShowDefaultActivity && this.mDataModel.getDefaultActivity() != null) {
                --v0;
            }

            v0 = Math.min(v0, this.mMaxActivityCount);
            if(this.mShowFooterView) {
                ++v0;
            }

            return v0;
        }

        public ActivityChooserModel getDataModel() {
            return this.mDataModel;
        }

        public ResolveInfo getDefaultActivity() {
            return this.mDataModel.getDefaultActivity();
        }

        public int getHistorySize() {
            return this.mDataModel.getHistorySize();
        }

        public Object getItem(int arg2) {
            int v0 = this.getItemViewType(arg2);
            if(v0 != 0) {
                if(v0 == 1) {
                    return null;
                }

                throw new IllegalArgumentException();
            }

            if(!this.mShowDefaultActivity && this.mDataModel.getDefaultActivity() != null) {
                ++arg2;
            }

            return this.mDataModel.getActivity(arg2);
        }

        public long getItemId(int arg1) {
            return ((long)arg1);
        }

        public int getItemViewType(int arg2) {
            if((this.mShowFooterView) && arg2 == this.getCount() - 1) {
                return 1;
            }

            return 0;
        }

        public boolean getShowDefaultActivity() {
            return this.mShowDefaultActivity;
        }

        public View getView(int arg6, View arg7, ViewGroup arg8) {
            int v0 = this.getItemViewType(arg6);
            if(v0 != 0) {
                if(v0 == 1) {
                    if(arg7 != null) {
                        if(arg7.getId() != 1) {
                        }
                        else {
                            return arg7;
                        }
                    }

                    View v6 = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(layout.abc_activity_chooser_view_list_item, arg8, false);
                    v6.setId(1);
                    v6.findViewById(id.title).setText(ActivityChooserView.this.getContext().getString(string.abc_activity_chooser_view_see_all));
                    return v6;
                }

                throw new IllegalArgumentException();
            }

            if(arg7 == null || arg7.getId() != id.list_item) {
                arg7 = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(layout.abc_activity_chooser_view_list_item, arg8, false);
            }

            PackageManager v8 = ActivityChooserView.this.getContext().getPackageManager();
            View v0_1 = arg7.findViewById(id.icon);
            Object v3 = this.getItem(arg6);
            ((ImageView)v0_1).setImageDrawable(((ResolveInfo)v3).loadIcon(v8));
            arg7.findViewById(id.title).setText(((ResolveInfo)v3).loadLabel(v8));
            if((this.mShowDefaultActivity) && arg6 == 0 && (this.mHighlightDefaultActivity)) {
                arg7.setActivated(true);
                return arg7;
            }

            arg7.setActivated(false);
            return arg7;
        }

        public int getViewTypeCount() {
            return 3;
        }

        public int measureContentWidth() {
            int v0 = this.mMaxActivityCount;
            this.mMaxActivityCount = 0x7FFFFFFF;
            int v1 = 0;
            int v2 = View$MeasureSpec.makeMeasureSpec(0, 0);
            int v3 = View$MeasureSpec.makeMeasureSpec(0, 0);
            int v4 = this.getCount();
            ViewGroup v5 = null;
            int v6 = 0;
            View v7 = ((View)v5);
            while(v1 < v4) {
                v7 = this.getView(v1, v7, v5);
                v7.measure(v2, v3);
                v6 = Math.max(v6, v7.getMeasuredWidth());
                ++v1;
            }

            this.mMaxActivityCount = v0;
            return v6;
        }

        public void setDataModel(ActivityChooserModel arg3) {
            ActivityChooserModel v0 = ActivityChooserView.this.mAdapter.getDataModel();
            if(v0 != null && (ActivityChooserView.this.isShown())) {
                v0.unregisterObserver(ActivityChooserView.this.mModelDataSetObserver);
            }

            this.mDataModel = arg3;
            if(arg3 != null && (ActivityChooserView.this.isShown())) {
                arg3.registerObserver(ActivityChooserView.this.mModelDataSetObserver);
            }

            this.notifyDataSetChanged();
        }

        public void setMaxActivityCount(int arg2) {
            if(this.mMaxActivityCount != arg2) {
                this.mMaxActivityCount = arg2;
                this.notifyDataSetChanged();
            }
        }

        public void setShowDefaultActivity(boolean arg2, boolean arg3) {
            if(this.mShowDefaultActivity == arg2) {
                if(this.mHighlightDefaultActivity != arg3) {
                }
                else {
                    return;
                }
            }

            this.mShowDefaultActivity = arg2;
            this.mHighlightDefaultActivity = arg3;
            this.notifyDataSetChanged();
        }

        public void setShowFooterView(boolean arg2) {
            if(this.mShowFooterView != arg2) {
                this.mShowFooterView = arg2;
                this.notifyDataSetChanged();
            }
        }
    }

    class Callbacks implements View$OnClickListener, View$OnLongClickListener, AdapterView$OnItemClickListener, PopupWindow$OnDismissListener {
        Callbacks(ActivityChooserView arg1) {
            ActivityChooserView.this = arg1;
            super();
        }

        private void notifyOnDismissListener() {
            if(ActivityChooserView.this.mOnDismissListener != null) {
                ActivityChooserView.this.mOnDismissListener.onDismiss();
            }
        }

        public void onClick(View arg3) {
            FrameLayout v0 = ActivityChooserView.this.mDefaultActivityButton;
            ActivityChooserView v1 = ActivityChooserView.this;
            if(arg3 == (((View)v0))) {
                v1.dismissPopup();
                Intent v3 = ActivityChooserView.this.mAdapter.getDataModel().chooseActivity(ActivityChooserView.this.mAdapter.getDataModel().getActivityIndex(ActivityChooserView.this.mAdapter.getDefaultActivity()));
                if(v3 != null) {
                    v3.addFlags(0x80000);
                    ActivityChooserView.this.getContext().startActivity(v3);
                }

                return;
            }

            if(arg3 == v1.mExpandActivityOverflowButton) {
                ActivityChooserView.this.mIsSelectingDefaultActivity = false;
                ActivityChooserView.this.showPopupUnchecked(ActivityChooserView.this.mInitialActivityCount);
                return;
            }

            throw new IllegalArgumentException();
        }

        public void onDismiss() {
            this.notifyOnDismissListener();
            if(ActivityChooserView.this.mProvider != null) {
                ActivityChooserView.this.mProvider.subUiVisibilityChanged(false);
            }
        }

        public void onItemClick(AdapterView arg1, View arg2, int arg3, long arg4) {
            int v1 = arg1.getAdapter().getItemViewType(arg3);
            if(v1 != 0) {
                if(v1 == 1) {
                    ActivityChooserView.this.showPopupUnchecked(0x7FFFFFFF);
                    return;
                }

                throw new IllegalArgumentException();
            }

            ActivityChooserView.this.dismissPopup();
            if(!ActivityChooserView.this.mIsSelectingDefaultActivity) {
                if(ActivityChooserView.this.mAdapter.getShowDefaultActivity()) {
                }
                else {
                    ++arg3;
                }

                Intent v1_1 = ActivityChooserView.this.mAdapter.getDataModel().chooseActivity(arg3);
                if(v1_1 == null) {
                    return;
                }

                v1_1.addFlags(0x80000);
                ActivityChooserView.this.getContext().startActivity(v1_1);
            }
            else if(arg3 > 0) {
                ActivityChooserView.this.mAdapter.getDataModel().setDefaultActivity(arg3);
                return;
            }
        }

        public boolean onLongClick(View arg2) {
            if(arg2 == ActivityChooserView.this.mDefaultActivityButton) {
                if(ActivityChooserView.this.mAdapter.getCount() > 0) {
                    ActivityChooserView.this.mIsSelectingDefaultActivity = true;
                    ActivityChooserView.this.showPopupUnchecked(ActivityChooserView.this.mInitialActivityCount);
                }

                return 1;
            }

            throw new IllegalArgumentException();
        }
    }

    public class InnerLayout extends LinearLayout {
        private static final int[] TINT_ATTRS;

        static {
            InnerLayout.TINT_ATTRS = new int[]{0x10100D4};
        }

        public InnerLayout(Context arg2, AttributeSet arg3) {
            super(arg2, arg3);
            TintTypedArray v2 = TintTypedArray.obtainStyledAttributes(arg2, arg3, InnerLayout.TINT_ATTRS);
            this.setBackgroundDrawable(v2.getDrawable(0));
            v2.recycle();
        }
    }

    private final View mActivityChooserContent;
    private final Drawable mActivityChooserContentBackground;
    final ActivityChooserViewAdapter mAdapter;
    private final Callbacks mCallbacks;
    private int mDefaultActionButtonContentDescription;
    final FrameLayout mDefaultActivityButton;
    private final ImageView mDefaultActivityButtonImage;
    final FrameLayout mExpandActivityOverflowButton;
    private final ImageView mExpandActivityOverflowButtonImage;
    int mInitialActivityCount;
    private boolean mIsAttachedToWindow;
    boolean mIsSelectingDefaultActivity;
    private final int mListPopupMaxWidth;
    private ListPopupWindow mListPopupWindow;
    final DataSetObserver mModelDataSetObserver;
    PopupWindow$OnDismissListener mOnDismissListener;
    private final ViewTreeObserver$OnGlobalLayoutListener mOnGlobalLayoutListener;
    ActionProvider mProvider;

    public ActivityChooserView(Context arg2) {
        this(arg2, null);
    }

    public ActivityChooserView(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, 0);
    }

    public ActivityChooserView(Context arg11, AttributeSet arg12, int arg13) {
        super(arg11, arg12, arg13);
        this.mModelDataSetObserver = new androidx.appcompat.widget.ActivityChooserView$1(this);
        this.mOnGlobalLayoutListener = new androidx.appcompat.widget.ActivityChooserView$2(this);
        this.mInitialActivityCount = 4;
        TypedArray v7 = arg11.obtainStyledAttributes(arg12, styleable.ActivityChooserView, arg13, 0);
        ActivityChooserView v3 = this;
        Context v4 = arg11;
        ViewCompat.saveAttributeDataForStyleable(((View)v3), v4, styleable.ActivityChooserView, arg12, v7, arg13, 0);
        v3.mInitialActivityCount = v7.getInt(styleable.ActivityChooserView_initialActivityCount, 4);
        Drawable v10 = v7.getDrawable(styleable.ActivityChooserView_expandActivityOverflowButtonDrawable);
        v7.recycle();
        LayoutInflater.from(v3.getContext()).inflate(layout.abc_activity_chooser_view, ((ViewGroup)v3), true);
        Callbacks v11 = new Callbacks(v3);
        v3.mCallbacks = v11;
        View v12 = v3.findViewById(id.activity_chooser_view_content);
        v3.mActivityChooserContent = v12;
        v3.mActivityChooserContentBackground = v12.getBackground();
        v12 = v3.findViewById(id.default_activity_button);
        v3.mDefaultActivityButton = ((FrameLayout)v12);
        ((FrameLayout)v12).setOnClickListener(((View$OnClickListener)v11));
        ((FrameLayout)v12).setOnLongClickListener(((View$OnLongClickListener)v11));
        v3.mDefaultActivityButtonImage = ((FrameLayout)v12).findViewById(id.image);
        v12 = v3.findViewById(id.expand_activities_button);
        ((FrameLayout)v12).setOnClickListener(((View$OnClickListener)v11));
        ((FrameLayout)v12).setAccessibilityDelegate(new View$AccessibilityDelegate() {
            public void onInitializeAccessibilityNodeInfo(View arg1, AccessibilityNodeInfo arg2) {
                super.onInitializeAccessibilityNodeInfo(arg1, arg2);
                AccessibilityNodeInfoCompat.wrap(arg2).setCanOpenPopup(true);
            }
        });
        ((FrameLayout)v12).setOnTouchListener(new ForwardingListener(v12) {
            public ShowableListMenu getPopup() {
                return ActivityChooserView.this.getListPopupWindow();
            }

            protected boolean onForwardingStarted() {
                ActivityChooserView.this.showPopup();
                return 1;
            }

            protected boolean onForwardingStopped() {
                ActivityChooserView.this.dismissPopup();
                return 1;
            }
        });
        v3.mExpandActivityOverflowButton = ((FrameLayout)v12);
        View v11_1 = ((FrameLayout)v12).findViewById(id.image);
        v3.mExpandActivityOverflowButtonImage = ((ImageView)v11_1);
        ((ImageView)v11_1).setImageDrawable(v10);
        ActivityChooserViewAdapter v10_1 = new ActivityChooserViewAdapter(v3);
        v3.mAdapter = v10_1;
        v10_1.registerDataSetObserver(new DataSetObserver() {
            public void onChanged() {
                super.onChanged();
                ActivityChooserView.this.updateAppearance();
            }
        });
        Resources v10_2 = v4.getResources();
        v3.mListPopupMaxWidth = Math.max(v10_2.getDisplayMetrics().widthPixels / 2, v10_2.getDimensionPixelSize(dimen.abc_config_prefDialogWidth));
    }

    public boolean dismissPopup() {
        if(this.isShowingPopup()) {
            this.getListPopupWindow().dismiss();
            ViewTreeObserver v0 = this.getViewTreeObserver();
            if(v0.isAlive()) {
                v0.removeGlobalOnLayoutListener(this.mOnGlobalLayoutListener);
            }
        }

        return 1;
    }

    public ActivityChooserModel getDataModel() {
        return this.mAdapter.getDataModel();
    }

    ListPopupWindow getListPopupWindow() {
        if(this.mListPopupWindow == null) {
            ListPopupWindow v0 = new ListPopupWindow(this.getContext());
            this.mListPopupWindow = v0;
            v0.setAdapter(this.mAdapter);
            this.mListPopupWindow.setAnchorView(((View)this));
            this.mListPopupWindow.setModal(true);
            this.mListPopupWindow.setOnItemClickListener(this.mCallbacks);
            this.mListPopupWindow.setOnDismissListener(this.mCallbacks);
        }

        return this.mListPopupWindow;
    }

    public boolean isShowingPopup() {
        return this.getListPopupWindow().isShowing();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ActivityChooserModel v0 = this.mAdapter.getDataModel();
        if(v0 != null) {
            v0.registerObserver(this.mModelDataSetObserver);
        }

        this.mIsAttachedToWindow = true;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActivityChooserModel v0 = this.mAdapter.getDataModel();
        if(v0 != null) {
            v0.unregisterObserver(this.mModelDataSetObserver);
        }

        ViewTreeObserver v0_1 = this.getViewTreeObserver();
        if(v0_1.isAlive()) {
            v0_1.removeGlobalOnLayoutListener(this.mOnGlobalLayoutListener);
        }

        if(this.isShowingPopup()) {
            this.dismissPopup();
        }

        this.mIsAttachedToWindow = false;
    }

    protected void onLayout(boolean arg1, int arg2, int arg3, int arg4, int arg5) {
        this.mActivityChooserContent.layout(0, 0, arg4 - arg2, arg5 - arg3);
        if(!this.isShowingPopup()) {
            this.dismissPopup();
        }
    }

    protected void onMeasure(int arg3, int arg4) {
        View v0 = this.mActivityChooserContent;
        if(this.mDefaultActivityButton.getVisibility() != 0) {
            arg4 = View$MeasureSpec.makeMeasureSpec(View$MeasureSpec.getSize(arg4), 0x40000000);
        }

        this.measureChild(v0, arg3, arg4);
        this.setMeasuredDimension(v0.getMeasuredWidth(), v0.getMeasuredHeight());
    }

    public void setActivityChooserModel(ActivityChooserModel arg2) {
        this.mAdapter.setDataModel(arg2);
        if(this.isShowingPopup()) {
            this.dismissPopup();
            this.showPopup();
        }
    }

    public void setDefaultActionButtonContentDescription(int arg1) {
        this.mDefaultActionButtonContentDescription = arg1;
    }

    public void setExpandActivityOverflowButtonContentDescription(int arg2) {
        this.mExpandActivityOverflowButtonImage.setContentDescription(this.getContext().getString(arg2));
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable arg1) {
        this.mExpandActivityOverflowButtonImage.setImageDrawable(arg1);
    }

    public void setInitialActivityCount(int arg1) {
        this.mInitialActivityCount = arg1;
    }

    public void setOnDismissListener(PopupWindow$OnDismissListener arg1) {
        this.mOnDismissListener = arg1;
    }

    public void setProvider(ActionProvider arg1) {
        this.mProvider = arg1;
    }

    public boolean showPopup() {
        if(!this.isShowingPopup()) {
            if(!this.mIsAttachedToWindow) {
            }
            else {
                this.mIsSelectingDefaultActivity = false;
                this.showPopupUnchecked(this.mInitialActivityCount);
                return 1;
            }
        }

        return 0;
    }

    void showPopupUnchecked(int arg6) {
        if(this.mAdapter.getDataModel() != null) {
            this.getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
            int v0 = this.mDefaultActivityButton.getVisibility() == 0 ? 1 : 0;
            int v3 = this.mAdapter.getActivityCount();
            if(arg6 == 0x7FFFFFFF || v3 <= arg6 + v0) {
                this.mAdapter.setShowFooterView(false);
                this.mAdapter.setMaxActivityCount(arg6);
            }
            else {
                this.mAdapter.setShowFooterView(true);
                this.mAdapter.setMaxActivityCount(arg6 - 1);
            }

            ListPopupWindow v6 = this.getListPopupWindow();
            if(!v6.isShowing()) {
                if((this.mIsSelectingDefaultActivity) || v0 == 0) {
                    this.mAdapter.setShowDefaultActivity(true, ((boolean)v0));
                }
                else {
                    this.mAdapter.setShowDefaultActivity(false, false);
                }

                v6.setContentWidth(Math.min(this.mAdapter.measureContentWidth(), this.mListPopupMaxWidth));
                v6.show();
                ActionProvider v0_1 = this.mProvider;
                if(v0_1 != null) {
                    v0_1.subUiVisibilityChanged(true);
                }

                v6.getListView().setContentDescription(this.getContext().getString(string.abc_activitychooserview_choose_application));
                v6.getListView().setSelector(new ColorDrawable(0));
            }

            return;
        }

        throw new IllegalStateException("No data model. Did you call #setDataModel?");
    }

    void updateAppearance() {
        int v0 = this.mAdapter.getCount();
        FrameLayout v1 = this.mExpandActivityOverflowButton;
        if(v0 > 0) {
            v1.setEnabled(true);
        }
        else {
            v1.setEnabled(false);
        }

        v0 = this.mAdapter.getActivityCount();
        int v1_1 = this.mAdapter.getHistorySize();
        if(v0 != 1) {
            if(v0 > 1 && v1_1 > 0) {
                goto label_21;
            }

            this.mDefaultActivityButton.setVisibility(8);
        }
        else {
        label_21:
            this.mDefaultActivityButton.setVisibility(0);
            ResolveInfo v0_1 = this.mAdapter.getDefaultActivity();
            PackageManager v1_2 = this.getContext().getPackageManager();
            this.mDefaultActivityButtonImage.setImageDrawable(v0_1.loadIcon(v1_2));
            if(this.mDefaultActionButtonContentDescription == 0) {
                goto label_39;
            }

            this.mDefaultActivityButton.setContentDescription(this.getContext().getString(this.mDefaultActionButtonContentDescription, new Object[]{v0_1.loadLabel(v1_2)}));
        }

    label_39:
        v0 = this.mDefaultActivityButton.getVisibility();
        View v1_3 = this.mActivityChooserContent;
        if(v0 == 0) {
            v1_3.setBackgroundDrawable(this.mActivityChooserContentBackground);
            return;
        }

        v1_3.setBackgroundDrawable(null);
    }
}

