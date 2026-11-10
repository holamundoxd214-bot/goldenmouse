package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View$BaseSavedState;
import android.view.View;
import android.widget.FrameLayout$LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout$LayoutParams;
import android.widget.LinearLayout;
import android.widget.TabHost$OnTabChangeListener;
import android.widget.TabHost$TabContentFactory;
import android.widget.TabHost$TabSpec;
import android.widget.TabHost;
import android.widget.TabWidget;
import java.util.ArrayList;

@Deprecated public class FragmentTabHost extends TabHost implements TabHost$OnTabChangeListener {
    class DummyTabFactory implements TabHost$TabContentFactory {
        private final Context mContext;

        public DummyTabFactory(Context arg1) {
            super();
            this.mContext = arg1;
        }

        public View createTabContent(String arg1) {
            View v1 = new View(this.mContext);
            v1.setMinimumWidth(0);
            v1.setMinimumHeight(0);
            return v1;
        }
    }

    class SavedState extends View$BaseSavedState {
        class androidx.fragment.app.FragmentTabHost$SavedState$1 implements Parcelable$Creator {
            androidx.fragment.app.FragmentTabHost$SavedState$1() {
                super();
            }

            public SavedState createFromParcel(Parcel arg1) {
                return new SavedState(arg1);
            }

            public Object createFromParcel(Parcel arg1) {
                return this.createFromParcel(arg1);
            }

            public SavedState[] newArray(int arg1) {
                return new SavedState[arg1];
            }

            public Object[] newArray(int arg1) {
                return this.newArray(arg1);
            }
        }

        public static final Parcelable$Creator CREATOR;
        String curTab;

        static {
            SavedState.CREATOR = new androidx.fragment.app.FragmentTabHost$SavedState$1();
        }

        SavedState(Parcelable arg1) {
            super(arg1);
        }

        SavedState(Parcel arg1) {
            super(arg1);
            this.curTab = arg1.readString();
        }

        public String toString() {
            return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.curTab + "}";
        }

        public void writeToParcel(Parcel arg1, int arg2) {
            super.writeToParcel(arg1, arg2);
            arg1.writeString(this.curTab);
        }
    }

    final class TabInfo {
        final Bundle args;
        final Class clss;
        Fragment fragment;
        final String tag;

        TabInfo(String arg1, Class arg2, Bundle arg3) {
            super();
            this.tag = arg1;
            this.clss = arg2;
            this.args = arg3;
        }
    }

    private boolean mAttached;
    private int mContainerId;
    private Context mContext;
    private FragmentManager mFragmentManager;
    private TabInfo mLastTab;
    private TabHost$OnTabChangeListener mOnTabChangeListener;
    private FrameLayout mRealTabContent;
    private final ArrayList mTabs;

    @Deprecated public FragmentTabHost(Context arg3) {
        super(arg3, null);
        this.mTabs = new ArrayList();
        this.initFragmentTabHost(arg3, null);
    }

    @Deprecated public FragmentTabHost(Context arg2, AttributeSet arg3) {
        super(arg2, arg3);
        this.mTabs = new ArrayList();
        this.initFragmentTabHost(arg2, arg3);
    }

    @Deprecated public void addTab(TabHost$TabSpec arg3, Class arg4, Bundle arg5) {
        arg3.setContent(new DummyTabFactory(this.mContext));
        String v0 = arg3.getTag();
        TabInfo v1 = new TabInfo(v0, arg4, arg5);
        if(this.mAttached) {
            v1.fragment = this.mFragmentManager.findFragmentByTag(v0);
            if(v1.fragment != null && !v1.fragment.isDetached()) {
                FragmentTransaction v4 = this.mFragmentManager.beginTransaction();
                v4.detach(v1.fragment);
                v4.commit();
            }
        }

        this.mTabs.add(v1);
        this.addTab(arg3);
    }

    private FragmentTransaction doTabChanged(String arg4, FragmentTransaction arg5) {
        TabInfo v4 = this.getTabInfoForTag(arg4);
        if(this.mLastTab != v4) {
            if(arg5 == null) {
                arg5 = this.mFragmentManager.beginTransaction();
            }

            TabInfo v0 = this.mLastTab;
            if(v0 != null && v0.fragment != null) {
                arg5.detach(this.mLastTab.fragment);
            }

            if(v4 != null) {
                if(v4.fragment == null) {
                    v4.fragment = this.mFragmentManager.getFragmentFactory().instantiate(this.mContext.getClassLoader(), v4.clss.getName());
                    v4.fragment.setArguments(v4.args);
                    arg5.add(this.mContainerId, v4.fragment, v4.tag);
                }
                else {
                    arg5.attach(v4.fragment);
                }
            }

            this.mLastTab = v4;
        }

        return arg5;
    }

    private void ensureContent() {
        if(this.mRealTabContent == null) {
            View v0 = this.findViewById(this.mContainerId);
            this.mRealTabContent = ((FrameLayout)v0);
            if(v0 != null) {
            }
            else {
                throw new IllegalStateException("No tab content FrameLayout found for id " + this.mContainerId);
            }
        }
    }

    private void ensureHierarchy(Context arg8) {
        int v0 = 0x1020013;
        if(this.findViewById(v0) == null) {
            LinearLayout v1 = new LinearLayout(arg8);
            v1.setOrientation(1);
            this.addView(((View)v1), new FrameLayout$LayoutParams(-1, -1));
            TabWidget v2 = new TabWidget(arg8);
            v2.setId(v0);
            v2.setOrientation(0);
            v1.addView(((View)v2), new LinearLayout$LayoutParams(-1, -2, 0f));
            FrameLayout v2_1 = new FrameLayout(arg8);
            v2_1.setId(0x1020011);
            v1.addView(((View)v2_1), new LinearLayout$LayoutParams(0, 0, 0f));
            v2_1 = new FrameLayout(arg8);
            this.mRealTabContent = v2_1;
            v2_1.setId(this.mContainerId);
            v1.addView(((View)v2_1), new LinearLayout$LayoutParams(-1, 0, 1f));
        }
    }

    private TabInfo getTabInfoForTag(String arg5) {
        int v0 = this.mTabs.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            Object v2 = this.mTabs.get(v1);
            if(((TabInfo)v2).tag.equals(arg5)) {
                return ((TabInfo)v2);
            }
        }

        return null;
    }

    private void initFragmentTabHost(Context arg3, AttributeSet arg4) {
        TypedArray v3 = arg3.obtainStyledAttributes(arg4, new int[]{0x10100F3}, 0, 0);
        this.mContainerId = v3.getResourceId(0, 0);
        v3.recycle();
        super.setOnTabChangedListener(((TabHost$OnTabChangeListener)this));
    }

    @Deprecated protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        String v0 = this.getCurrentTabTag();
        int v1 = this.mTabs.size();
        FragmentTransaction v2 = null;
        int v3;
        for(v3 = 0; v3 < v1; ++v3) {
            Object v4 = this.mTabs.get(v3);
            ((TabInfo)v4).fragment = this.mFragmentManager.findFragmentByTag(((TabInfo)v4).tag);
            if(((TabInfo)v4).fragment != null && !((TabInfo)v4).fragment.isDetached()) {
                if(((TabInfo)v4).tag.equals(v0)) {
                    this.mLastTab = ((TabInfo)v4);
                }
                else {
                    if(v2 == null) {
                        v2 = this.mFragmentManager.beginTransaction();
                    }

                    v2.detach(((TabInfo)v4).fragment);
                }
            }
        }

        this.mAttached = true;
        FragmentTransaction v0_1 = this.doTabChanged(v0, v2);
        if(v0_1 != null) {
            v0_1.commit();
            this.mFragmentManager.executePendingTransactions();
        }
    }

    @Deprecated protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mAttached = false;
    }

    @Deprecated protected void onRestoreInstanceState(Parcelable arg2) {
        if(!(arg2 instanceof SavedState)) {
            super.onRestoreInstanceState(arg2);
            return;
        }

        super.onRestoreInstanceState(((SavedState)arg2).getSuperState());
        this.setCurrentTabByTag(((SavedState)arg2).curTab);
    }

    @Deprecated protected Parcelable onSaveInstanceState() {
        SavedState v1 = new SavedState(super.onSaveInstanceState());
        v1.curTab = this.getCurrentTabTag();
        return ((Parcelable)v1);
    }

    @Deprecated public void onTabChanged(String arg2) {
        if(this.mAttached) {
            FragmentTransaction v0 = this.doTabChanged(arg2, null);
            if(v0 != null) {
                v0.commit();
            }
        }

        TabHost$OnTabChangeListener v1 = this.mOnTabChangeListener;
        if(v1 != null) {
            v1.onTabChanged(arg2);
        }
    }

    @Deprecated public void setOnTabChangedListener(TabHost$OnTabChangeListener arg1) {
        this.mOnTabChangeListener = arg1;
    }

    @Deprecated public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    @Deprecated public void setup(Context arg1, FragmentManager arg2) {
        this.ensureHierarchy(arg1);
        super.setup();
        this.mContext = arg1;
        this.mFragmentManager = arg2;
        this.ensureContent();
    }

    @Deprecated public void setup(Context arg1, FragmentManager arg2, int arg3) {
        this.ensureHierarchy(arg1);
        super.setup();
        this.mContext = arg1;
        this.mFragmentManager = arg2;
        this.mContainerId = arg3;
        this.ensureContent();
        this.mRealTabContent.setId(arg3);
        if(this.getId() == -1) {
            this.setId(0x1020012);
        }
    }
}

