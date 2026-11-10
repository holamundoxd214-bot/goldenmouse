package androidx.fragment.app;

import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle$State;
import androidx.viewpager.widget.PagerAdapter;

@Deprecated public abstract class FragmentPagerAdapter extends PagerAdapter {
    public static final int BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT = 1;
    @Deprecated public static final int BEHAVIOR_SET_USER_VISIBLE_HINT = 0;
    private static final boolean DEBUG = false;
    private static final String TAG = "FragmentPagerAdapter";
    private final int mBehavior;
    private FragmentTransaction mCurTransaction;
    private Fragment mCurrentPrimaryItem;
    private boolean mExecutingFinishUpdate;
    private final FragmentManager mFragmentManager;

    @Deprecated public FragmentPagerAdapter(FragmentManager arg2) {
        this(arg2, 0);
    }

    public FragmentPagerAdapter(FragmentManager arg2, int arg3) {
        super();
        this.mCurTransaction = null;
        this.mCurrentPrimaryItem = null;
        this.mFragmentManager = arg2;
        this.mBehavior = arg3;
    }

    public void destroyItem(ViewGroup arg1, int arg2, Object arg3) {
        FragmentTransaction v1 = this.mCurTransaction;
        if(v1 == null) {
            v1 = this.mFragmentManager.beginTransaction();
            this.mCurTransaction = v1;
        }

        v1.detach(((Fragment)arg3));
        if(((Fragment)arg3).equals(this.mCurrentPrimaryItem)) {
            this.mCurrentPrimaryItem = null;
        }
    }

    public void finishUpdate(ViewGroup arg3) {
        FragmentTransaction v3 = this.mCurTransaction;
        if(v3 != null) {
            if(!this.mExecutingFinishUpdate) {
                try {
                    this.mExecutingFinishUpdate = true;
                    v3.commitNowAllowingStateLoss();
                }
                catch(Throwable v3_1) {
                    this.mExecutingFinishUpdate = false;
                    throw v3_1;
                }

                this.mExecutingFinishUpdate = false;
            }

            this.mCurTransaction = null;
        }
    }

    public abstract Fragment getItem(int arg1);

    public long getItemId(int arg1) {
        return ((long)arg1);
    }

    public Object instantiateItem(ViewGroup arg5, int arg6) {
        if(this.mCurTransaction == null) {
            this.mCurTransaction = this.mFragmentManager.beginTransaction();
        }

        long v0 = this.getItemId(arg6);
        Fragment v2 = this.mFragmentManager.findFragmentByTag(FragmentPagerAdapter.makeFragmentName(arg5.getId(), v0));
        if(v2 != null) {
            this.mCurTransaction.attach(v2);
        }
        else {
            v2 = this.getItem(arg6);
            this.mCurTransaction.add(arg5.getId(), v2, FragmentPagerAdapter.makeFragmentName(arg5.getId(), v0));
        }

        if(v2 != this.mCurrentPrimaryItem) {
            v2.setMenuVisibility(false);
            if(this.mBehavior == 1) {
                this.mCurTransaction.setMaxLifecycle(v2, State.STARTED);
                return v2;
            }
            else {
                v2.setUserVisibleHint(false);
            }
        }

        return v2;
    }

    public boolean isViewFromObject(View arg1, Object arg2) {
        if(((Fragment)arg2).getView() == arg1) {
            return 1;
        }

        return 0;
    }

    private static String makeFragmentName(int arg2, long arg3) {
        return "android:switcher:" + arg2 + ":" + arg3;
    }

    public void restoreState(Parcelable arg1, ClassLoader arg2) {
    }

    public Parcelable saveState() {
        return null;
    }

    public void setPrimaryItem(ViewGroup arg3, int arg4, Object arg5) {
        FragmentTransaction v3_1;
        Fragment v3 = this.mCurrentPrimaryItem;
        if(arg5 != v3) {
            if(v3 != null) {
                v3.setMenuVisibility(false);
                if(this.mBehavior == 1) {
                    v3_1 = this.mCurTransaction;
                    if(v3_1 == null) {
                        v3_1 = this.mFragmentManager.beginTransaction();
                        this.mCurTransaction = v3_1;
                    }

                    v3_1.setMaxLifecycle(this.mCurrentPrimaryItem, State.STARTED);
                }
                else {
                    this.mCurrentPrimaryItem.setUserVisibleHint(false);
                }
            }

            ((Fragment)arg5).setMenuVisibility(true);
            if(this.mBehavior == 1) {
                v3_1 = this.mCurTransaction;
                if(v3_1 == null) {
                    v3_1 = this.mFragmentManager.beginTransaction();
                    this.mCurTransaction = v3_1;
                }

                v3_1.setMaxLifecycle(((Fragment)arg5), State.RESUMED);
            }
            else {
                ((Fragment)arg5).setUserVisibleHint(true);
            }

            this.mCurrentPrimaryItem = ((Fragment)arg5);
        }
    }

    public void startUpdate(ViewGroup arg3) {
        if(arg3.getId() != -1) {
            return;
        }

        throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
    }
}

