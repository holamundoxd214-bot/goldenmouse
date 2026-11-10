package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle$State;
import androidx.viewpager.widget.PagerAdapter;
import java.util.ArrayList;
import java.util.Iterator;

@Deprecated public abstract class FragmentStatePagerAdapter extends PagerAdapter {
    public static final int BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT = 1;
    @Deprecated public static final int BEHAVIOR_SET_USER_VISIBLE_HINT = 0;
    private static final boolean DEBUG = false;
    private static final String TAG = "FragmentStatePagerAdapt";
    private final int mBehavior;
    private FragmentTransaction mCurTransaction;
    private Fragment mCurrentPrimaryItem;
    private boolean mExecutingFinishUpdate;
    private final FragmentManager mFragmentManager;
    private ArrayList mFragments;
    private ArrayList mSavedState;

    @Deprecated public FragmentStatePagerAdapter(FragmentManager arg2) {
        this(arg2, 0);
    }

    public FragmentStatePagerAdapter(FragmentManager arg3, int arg4) {
        super();
        this.mCurTransaction = null;
        this.mSavedState = new ArrayList();
        this.mFragments = new ArrayList();
        this.mCurrentPrimaryItem = null;
        this.mFragmentManager = arg3;
        this.mBehavior = arg4;
    }

    public void destroyItem(ViewGroup arg3, int arg4, Object arg5) {
        SavedState v3_1;
        Object v1;
        ArrayList v0;
        if(this.mCurTransaction == null) {
            this.mCurTransaction = this.mFragmentManager.beginTransaction();
        }

        while(true) {
            int v3 = this.mSavedState.size();
            v0 = this.mSavedState;
            v1 = null;
            if(v3 > arg4) {
                break;
            }

            v0.add(v1);
        }

        if(((Fragment)arg5).isAdded()) {
            v3_1 = this.mFragmentManager.saveFragmentInstanceState(((Fragment)arg5));
        }
        else {
            Object v3_2 = v1;
        }

        v0.set(arg4, v3_1);
        this.mFragments.set(arg4, v1);
        this.mCurTransaction.remove(((Fragment)arg5));
        if(((Fragment)arg5).equals(this.mCurrentPrimaryItem)) {
            this.mCurrentPrimaryItem = ((Fragment)v1);
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

    public Object instantiateItem(ViewGroup arg4, int arg5) {
        if(this.mFragments.size() > arg5) {
            Object v0 = this.mFragments.get(arg5);
            if(v0 != null) {
                return v0;
            }
        }

        if(this.mCurTransaction == null) {
            this.mCurTransaction = this.mFragmentManager.beginTransaction();
        }

        Fragment v0_1 = this.getItem(arg5);
        if(this.mSavedState.size() > arg5) {
            Object v1 = this.mSavedState.get(arg5);
            if(v1 != null) {
                v0_1.setInitialSavedState(((SavedState)v1));
            }
        }

        while(this.mFragments.size() <= arg5) {
            this.mFragments.add(null);
        }

        v0_1.setMenuVisibility(false);
        if(this.mBehavior == 0) {
            v0_1.setUserVisibleHint(false);
        }

        this.mFragments.set(arg5, v0_1);
        this.mCurTransaction.add(arg4.getId(), v0_1);
        if(this.mBehavior == 1) {
            this.mCurTransaction.setMaxLifecycle(v0_1, State.STARTED);
        }

        return v0_1;
    }

    public boolean isViewFromObject(View arg1, Object arg2) {
        if(((Fragment)arg2).getView() == arg1) {
            return 1;
        }

        return 0;
    }

    public void restoreState(Parcelable arg6, ClassLoader arg7) {
        Fragment v3;
        int v2;
        if(arg6 != null) {
            ((Bundle)arg6).setClassLoader(arg7);
            Parcelable[] v7 = ((Bundle)arg6).getParcelableArray("states");
            this.mSavedState.clear();
            this.mFragments.clear();
            if(v7 != null) {
                int v1;
                for(v1 = 0; v1 < v7.length; ++v1) {
                    this.mSavedState.add(v7[v1]);
                }
            }

            Iterator v7_1 = ((Bundle)arg6).keySet().iterator();
            while(true) {
            label_20:
                if(!v7_1.hasNext()) {
                    return;
                }

                Object v1_1 = v7_1.next();
                if(!((String)v1_1).startsWith("f")) {
                    continue;
                }

                v2 = Integer.parseInt(((String)v1_1).substring(1));
                v3 = this.mFragmentManager.getFragment(((Bundle)arg6), ((String)v1_1));
                if(v3 == null) {
                    Log.w("FragmentStatePagerAdapt", "Bad fragment at key " + (((String)v1_1)));
                    continue;
                }

                break;
            }

            while(this.mFragments.size() <= v2) {
                this.mFragments.add(null);
            }

            v3.setMenuVisibility(false);
            this.mFragments.set(v2, v3);
            goto label_20;
        }
    }

    public Parcelable saveState() {
        Bundle v0;
        if(this.mSavedState.size() > 0) {
            v0 = new Bundle();
            SavedState[] v1 = new SavedState[this.mSavedState.size()];
            this.mSavedState.toArray(((Object[])v1));
            v0.putParcelableArray("states", ((Parcelable[])v1));
        }
        else {
            v0 = null;
        }

        int v1_1;
        for(v1_1 = 0; v1_1 < this.mFragments.size(); ++v1_1) {
            Object v2 = this.mFragments.get(v1_1);
            if(v2 != null && (((Fragment)v2).isAdded())) {
                if(v0 == null) {
                    v0 = new Bundle();
                }

                this.mFragmentManager.putFragment(v0, "f" + v1_1, ((Fragment)v2));
            }
        }

        return ((Parcelable)v0);
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

