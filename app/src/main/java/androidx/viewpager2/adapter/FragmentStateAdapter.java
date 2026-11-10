package androidx.viewpager2.adapter;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View$OnLayoutChangeListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.collection.ArraySet;
import androidx.collection.LongSparseArray;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager$FragmentLifecycleCallbacks;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.Lifecycle$State;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$AdapterDataObserver;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2$OnPageChangeCallback;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Iterator;
import java.util.Set;

public abstract class FragmentStateAdapter extends Adapter implements StatefulAdapter {
    abstract class DataSetChangeObserver extends AdapterDataObserver {
        private DataSetChangeObserver() {
            super();
        }

        DataSetChangeObserver(androidx.viewpager2.adapter.FragmentStateAdapter$1 arg1) {
            this();
        }

        public abstract void onChanged();

        public final void onItemRangeChanged(int arg1, int arg2) {
            this.onChanged();
        }

        public final void onItemRangeChanged(int arg1, int arg2, Object arg3) {
            this.onChanged();
        }

        public final void onItemRangeInserted(int arg1, int arg2) {
            this.onChanged();
        }

        public final void onItemRangeMoved(int arg1, int arg2, int arg3) {
            this.onChanged();
        }

        public final void onItemRangeRemoved(int arg1, int arg2) {
            this.onChanged();
        }
    }

    class FragmentMaxLifecycleEnforcer {
        private AdapterDataObserver mDataObserver;
        private LifecycleEventObserver mLifecycleObserver;
        private OnPageChangeCallback mPageChangeCallback;
        private long mPrimaryItemId;
        private ViewPager2 mViewPager;

        FragmentMaxLifecycleEnforcer(FragmentStateAdapter arg3) {
            FragmentStateAdapter.this = arg3;
            super();
            this.mPrimaryItemId = -1;
        }

        private ViewPager2 inferViewPager(RecyclerView arg3) {
            ViewParent v2 = arg3.getParent();
            if((v2 instanceof ViewPager2)) {
                return ((ViewPager2)v2);
            }

            throw new IllegalStateException("Expected ViewPager2 instance. Got: " + v2);
        }

        void register(RecyclerView arg2) {
            this.mViewPager = this.inferViewPager(arg2);
            androidx.viewpager2.adapter.FragmentStateAdapter$FragmentMaxLifecycleEnforcer$1 v2 = new OnPageChangeCallback() {
                public void onPageScrollStateChanged(int arg1) {
                    this.this$1.updateFragmentMaxLifecycle(false);
                }

                public void onPageSelected(int arg1) {
                    this.this$1.updateFragmentMaxLifecycle(false);
                }
            };
            this.mPageChangeCallback = ((OnPageChangeCallback)v2);
            this.mViewPager.registerOnPageChangeCallback(((OnPageChangeCallback)v2));
            androidx.viewpager2.adapter.FragmentStateAdapter$FragmentMaxLifecycleEnforcer$2 v2_1 = new DataSetChangeObserver() {
                public void onChanged() {
                    this.this$1.updateFragmentMaxLifecycle(true);
                }
            };
            this.mDataObserver = ((AdapterDataObserver)v2_1);
            FragmentStateAdapter.this.registerAdapterDataObserver(((AdapterDataObserver)v2_1));
            this.mLifecycleObserver = new LifecycleEventObserver() {
                public void onStateChanged(LifecycleOwner arg1, Event arg2) {
                    this.this$1.updateFragmentMaxLifecycle(false);
                }
            };
            FragmentStateAdapter.this.mLifecycle.addObserver(this.mLifecycleObserver);
        }

        void unregister(RecyclerView arg2) {
            this.inferViewPager(arg2).unregisterOnPageChangeCallback(this.mPageChangeCallback);
            FragmentStateAdapter.this.unregisterAdapterDataObserver(this.mDataObserver);
            FragmentStateAdapter.this.mLifecycle.removeObserver(this.mLifecycleObserver);
            this.mViewPager = null;
        }

        void updateFragmentMaxLifecycle(boolean arg9) {
            if(FragmentStateAdapter.this.shouldDelayFragmentTransactions()) {
            }
            else if(this.mViewPager.getScrollState() != 0) {
            }
            else if(!FragmentStateAdapter.this.mFragments.isEmpty()) {
                if(FragmentStateAdapter.this.getItemCount() == 0) {
                }
                else {
                    int v0 = this.mViewPager.getCurrentItem();
                    if(v0 >= FragmentStateAdapter.this.getItemCount()) {
                    }
                    else {
                        long v0_1 = FragmentStateAdapter.this.getItemId(v0);
                        if(v0_1 == this.mPrimaryItemId && !arg9) {
                            return;
                        }

                        Object v9 = FragmentStateAdapter.this.mFragments.get(v0_1);
                        if(v9 == null) {
                            return;
                        }

                        if(!((Fragment)v9).isAdded()) {
                            return;
                        }

                        this.mPrimaryItemId = v0_1;
                        FragmentTransaction v9_1 = FragmentStateAdapter.this.mFragmentManager.beginTransaction();
                        Object v1 = null;
                        int v2;
                        for(v2 = 0; v2 < FragmentStateAdapter.this.mFragments.size(); ++v2) {
                            long v3 = FragmentStateAdapter.this.mFragments.keyAt(v2);
                            Object v5 = FragmentStateAdapter.this.mFragments.valueAt(v2);
                            if(!((Fragment)v5).isAdded()) {
                            }
                            else {
                                if(v3 != this.mPrimaryItemId) {
                                    v9_1.setMaxLifecycle(((Fragment)v5), State.STARTED);
                                }
                                else {
                                    v1 = v5;
                                }

                                boolean v3_1 = v3 == this.mPrimaryItemId ? true : false;
                                ((Fragment)v5).setMenuVisibility(v3_1);
                            }
                        }

                        if(v1 != null) {
                            v9_1.setMaxLifecycle(((Fragment)v1), State.RESUMED);
                        }

                        if(v9_1.isEmpty()) {
                            return;
                        }

                        v9_1.commitNow();
                    }
                }
            }
        }
    }

    private static final long GRACE_WINDOW_TIME_MS = 10000;
    private static final String KEY_PREFIX_FRAGMENT = "f#";
    private static final String KEY_PREFIX_STATE = "s#";
    final FragmentManager mFragmentManager;
    private FragmentMaxLifecycleEnforcer mFragmentMaxLifecycleEnforcer;
    final LongSparseArray mFragments;
    private boolean mHasStaleFragments;
    boolean mIsInGracePeriod;
    private final LongSparseArray mItemIdToViewHolder;
    final Lifecycle mLifecycle;
    private final LongSparseArray mSavedStates;

    public FragmentStateAdapter(Fragment arg2) {
        this(arg2.getChildFragmentManager(), arg2.getLifecycle());
    }

    public FragmentStateAdapter(FragmentManager arg2, Lifecycle arg3) {
        super();
        this.mFragments = new LongSparseArray();
        this.mSavedStates = new LongSparseArray();
        this.mItemIdToViewHolder = new LongSparseArray();
        this.mIsInGracePeriod = false;
        this.mHasStaleFragments = false;
        this.mFragmentManager = arg2;
        this.mLifecycle = arg3;
        super.setHasStableIds(true);
    }

    public FragmentStateAdapter(FragmentActivity arg2) {
        this(arg2.getSupportFragmentManager(), arg2.getLifecycle());
    }

    void addViewToContainer(View arg2, FrameLayout arg3) {
        if(arg3.getChildCount() <= 1) {
            if(arg2.getParent() == arg3) {
                return;
            }

            if(arg3.getChildCount() > 0) {
                arg3.removeAllViews();
            }

            if(arg2.getParent() != null) {
                arg2.getParent().removeView(arg2);
            }

            arg3.addView(arg2);
            return;
        }

        throw new IllegalStateException("Design assumption violated.");
    }

    public boolean containsItem(long arg3) {
        if(arg3 >= 0 && arg3 < (((long)this.getItemCount()))) {
            return 1;
        }

        return 0;
    }

    public abstract Fragment createFragment(int arg1);

    private static String createKey(String arg1, long arg2) {
        return arg1 + arg2;
    }

    private void ensureFragment(int arg4) {
        long v0 = this.getItemId(arg4);
        if(!this.mFragments.containsKey(v0)) {
            Fragment v4 = this.createFragment(arg4);
            v4.setInitialSavedState(this.mSavedStates.get(v0));
            this.mFragments.put(v0, v4);
        }
    }

    void gcFragments() {
        if(this.mHasStaleFragments) {
            if(this.shouldDelayFragmentTransactions()) {
            }
            else {
                ArraySet v0 = new ArraySet();
                int v1 = 0;
                int v2;
                for(v2 = 0; v2 < this.mFragments.size(); ++v2) {
                    long v3 = this.mFragments.keyAt(v2);
                    if(!this.containsItem(v3)) {
                        ((Set)v0).add(Long.valueOf(v3));
                        this.mItemIdToViewHolder.remove(v3);
                    }
                }

                if(!this.mIsInGracePeriod) {
                    this.mHasStaleFragments = false;
                    while(v1 < this.mFragments.size()) {
                        long v2_1 = this.mFragments.keyAt(v1);
                        if(!this.isFragmentViewBound(v2_1)) {
                            ((Set)v0).add(Long.valueOf(v2_1));
                        }

                        ++v1;
                    }
                }

                Iterator v0_1 = ((Set)v0).iterator();
                while(v0_1.hasNext()) {
                    this.removeFragment(v0_1.next().longValue());
                }
            }
        }
    }

    public long getItemId(int arg1) {
        return ((long)arg1);
    }

    private boolean isFragmentViewBound(long arg3) {
        if(this.mItemIdToViewHolder.containsKey(arg3)) {
            return 1;
        }

        Object v2 = this.mFragments.get(arg3);
        if(v2 == null) {
            return 0;
        }

        View v2_1 = ((Fragment)v2).getView();
        if(v2_1 == null) {
            return 0;
        }

        if(v2_1.getParent() != null) {
            return 1;
        }

        return 0;
    }

    private static boolean isValidKey(String arg1, String arg2) {
        if((arg1.startsWith(arg2)) && arg1.length() > arg2.length()) {
            return 1;
        }

        return 0;
    }

    private Long itemForViewHolder(int arg5) {
        Long v0 = null;
        int v1;
        for(v1 = 0; v1 < this.mItemIdToViewHolder.size(); ++v1) {
            if(this.mItemIdToViewHolder.valueAt(v1).intValue() == arg5) {
                if(v0 == null) {
                    v0 = Long.valueOf(this.mItemIdToViewHolder.keyAt(v1));
                }
                else {
                    throw new IllegalStateException("Design assumption violated: a ViewHolder can only be bound to one item at a time.");
                }
            }
        }

        return v0;
    }

    public void onAttachedToRecyclerView(RecyclerView arg2) {
        boolean v0 = this.mFragmentMaxLifecycleEnforcer == null ? true : false;
        Preconditions.checkArgument(v0);
        FragmentMaxLifecycleEnforcer v0_1 = new FragmentMaxLifecycleEnforcer(this);
        this.mFragmentMaxLifecycleEnforcer = v0_1;
        v0_1.register(arg2);
    }

    public void onBindViewHolder(ViewHolder arg1, int arg2) {
        this.onBindViewHolder(((FragmentViewHolder)arg1), arg2);
    }

    public final void onBindViewHolder(FragmentViewHolder arg8, int arg9) {
        long v0 = arg8.getItemId();
        int v2 = arg8.getContainer().getId();
        Long v3 = this.itemForViewHolder(v2);
        if(v3 != null && v3.longValue() != v0) {
            this.removeFragment(v3.longValue());
            this.mItemIdToViewHolder.remove(v3.longValue());
        }

        this.mItemIdToViewHolder.put(v0, Integer.valueOf(v2));
        this.ensureFragment(arg9);
        FrameLayout v9 = arg8.getContainer();
        if(ViewCompat.isAttachedToWindow(((View)v9))) {
            if(v9.getParent() == null) {
                v9.addOnLayoutChangeListener(new View$OnLayoutChangeListener(v9, arg8) {
                    public void onLayoutChange(View arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9) {
                        if(this.val$container.getParent() != null) {
                            this.val$container.removeOnLayoutChangeListener(((View$OnLayoutChangeListener)this));
                            FragmentStateAdapter.this.placeFragmentInViewHolder(this.val$holder);
                        }
                    }
                });
            }
            else {
                throw new IllegalStateException("Design assumption violated.");
            }
        }

        this.gcFragments();
    }

    public ViewHolder onCreateViewHolder(ViewGroup arg1, int arg2) {
        return this.onCreateViewHolder(arg1, arg2);
    }

    public final FragmentViewHolder onCreateViewHolder(ViewGroup arg1, int arg2) {
        return FragmentViewHolder.create(arg1);
    }

    public void onDetachedFromRecyclerView(RecyclerView arg2) {
        this.mFragmentMaxLifecycleEnforcer.unregister(arg2);
        this.mFragmentMaxLifecycleEnforcer = null;
    }

    public boolean onFailedToRecycleView(ViewHolder arg1) {
        return this.onFailedToRecycleView(((FragmentViewHolder)arg1));
    }

    public final boolean onFailedToRecycleView(FragmentViewHolder arg1) {
        return 1;
    }

    public void onViewAttachedToWindow(ViewHolder arg1) {
        this.onViewAttachedToWindow(((FragmentViewHolder)arg1));
    }

    public final void onViewAttachedToWindow(FragmentViewHolder arg1) {
        this.placeFragmentInViewHolder(arg1);
        this.gcFragments();
    }

    public void onViewRecycled(ViewHolder arg1) {
        this.onViewRecycled(((FragmentViewHolder)arg1));
    }

    public final void onViewRecycled(FragmentViewHolder arg3) {
        Long v3 = this.itemForViewHolder(arg3.getContainer().getId());
        if(v3 != null) {
            this.removeFragment(v3.longValue());
            this.mItemIdToViewHolder.remove(v3.longValue());
        }
    }

    private static long parseIdFromKey(String arg0, String arg1) {
        return Long.parseLong(arg0.substring(arg1.length()));
    }

    void placeFragmentInViewHolder(FragmentViewHolder arg6) {
        Object v0 = this.mFragments.get(arg6.getItemId());
        String v1 = "Design assumption violated.";
        if(v0 == null) {
            goto label_59;
        }

        FrameLayout v2 = arg6.getContainer();
        View v3 = ((Fragment)v0).getView();
        if(!((Fragment)v0).isAdded()) {
            if(v3 == null) {
            }
            else {
                throw new IllegalStateException(v1);
            }
        }

        if((((Fragment)v0).isAdded()) && v3 == null) {
            this.scheduleViewAttach(((Fragment)v0), v2);
            return;
        }

        if(!((Fragment)v0).isAdded() || v3.getParent() == null) {
            if(((Fragment)v0).isAdded()) {
                this.addViewToContainer(v3, v2);
                return;
            }
            else if(!this.shouldDelayFragmentTransactions()) {
                this.scheduleViewAttach(((Fragment)v0), v2);
                this.mFragmentManager.beginTransaction().add(((Fragment)v0), "f" + arg6.getItemId()).setMaxLifecycle(((Fragment)v0), State.STARTED).commitNow();
                this.mFragmentMaxLifecycleEnforcer.updateFragmentMaxLifecycle(false);
                return;
            }
            else {
                if(this.mFragmentManager.isDestroyed()) {
                    return;
                }

                goto label_54;
            }
        }
        else if(v3.getParent() != v2) {
            this.addViewToContainer(v3, v2);
            return;
        }

        return;
    label_54:
        this.mLifecycle.addObserver(new LifecycleEventObserver(arg6) {
            public void onStateChanged(LifecycleOwner arg1, Event arg2) {
                if(FragmentStateAdapter.this.shouldDelayFragmentTransactions()) {
                }
                else {
                    arg1.getLifecycle().removeObserver(((LifecycleObserver)this));
                    if(ViewCompat.isAttachedToWindow(this.val$holder.getContainer())) {
                        FragmentStateAdapter.this.placeFragmentInViewHolder(this.val$holder);
                    }
                }
            }
        });
        return;
    label_59:
        throw new IllegalStateException(v1);
    }

    private void removeFragment(long arg4) {
        Object v0 = this.mFragments.get(arg4);
        if(v0 == null) {
            return;
        }

        if(((Fragment)v0).getView() != null) {
            ViewParent v1 = ((Fragment)v0).getView().getParent();
            if(v1 != null) {
                ((FrameLayout)v1).removeAllViews();
            }
        }

        if(!this.containsItem(arg4)) {
            this.mSavedStates.remove(arg4);
        }

        if(!((Fragment)v0).isAdded()) {
            this.mFragments.remove(arg4);
            return;
        }

        if(this.shouldDelayFragmentTransactions()) {
            this.mHasStaleFragments = true;
            return;
        }

        if((((Fragment)v0).isAdded()) && (this.containsItem(arg4))) {
            this.mSavedStates.put(arg4, this.mFragmentManager.saveFragmentInstanceState(((Fragment)v0)));
        }

        this.mFragmentManager.beginTransaction().remove(((Fragment)v0)).commitNow();
        this.mFragments.remove(arg4);
    }

    public final void restoreState(Parcelable arg6) {
        Object v1;
        if((this.mSavedStates.isEmpty()) && (this.mFragments.isEmpty())) {
            if(((Bundle)arg6).getClassLoader() == null) {
                ((Bundle)arg6).setClassLoader(this.getClass().getClassLoader());
            }

            Iterator v0 = ((Bundle)arg6).keySet().iterator();
            while(true) {
                if(!v0.hasNext()) {
                    goto label_43;
                }

                v1 = v0.next();
                String v2 = "f#";
                if(FragmentStateAdapter.isValidKey(((String)v1), v2)) {
                    this.mFragments.put(FragmentStateAdapter.parseIdFromKey(((String)v1), v2), this.mFragmentManager.getFragment(((Bundle)arg6), ((String)v1)));
                    continue;
                }

                v2 = "s#";
                if(!FragmentStateAdapter.isValidKey(((String)v1), v2)) {
                    break;
                }

                long v2_1 = FragmentStateAdapter.parseIdFromKey(((String)v1), v2);
                Parcelable v1_1 = ((Bundle)arg6).getParcelable(((String)v1));
                if(!this.containsItem(v2_1)) {
                    continue;
                }

                this.mSavedStates.put(v2_1, v1_1);
            }

            throw new IllegalArgumentException("Unexpected key in savedState: " + (((String)v1)));
        label_43:
            if(!this.mFragments.isEmpty()) {
                this.mHasStaleFragments = true;
                this.mIsInGracePeriod = true;
                this.gcFragments();
                this.scheduleGracePeriodEnd();
            }

            return;
        }

        throw new IllegalStateException("Expected the adapter to be \'fresh\' while restoring state.");
    }

    public final Parcelable saveState() {
        Bundle v0 = new Bundle(this.mFragments.size() + this.mSavedStates.size());
        int v1 = 0;
        int v2;
        for(v2 = 0; v2 < this.mFragments.size(); ++v2) {
            long v3 = this.mFragments.keyAt(v2);
            Object v5 = this.mFragments.get(v3);
            if(v5 != null && (((Fragment)v5).isAdded())) {
                this.mFragmentManager.putFragment(v0, FragmentStateAdapter.createKey("f#", v3), ((Fragment)v5));
            }
        }

        while(v1 < this.mSavedStates.size()) {
            long v2_1 = this.mSavedStates.keyAt(v1);
            if(this.containsItem(v2_1)) {
                v0.putParcelable(FragmentStateAdapter.createKey("s#", v2_1), this.mSavedStates.get(v2_1));
            }

            ++v1;
        }

        return ((Parcelable)v0);
    }

    private void scheduleGracePeriodEnd() {
        Handler v0 = new Handler(Looper.getMainLooper());
        androidx.viewpager2.adapter.FragmentStateAdapter$4 v1 = new Runnable() {
            public void run() {
                FragmentStateAdapter.this.mIsInGracePeriod = false;
                FragmentStateAdapter.this.gcFragments();
            }
        };
        this.mLifecycle.addObserver(new LifecycleEventObserver(v0, ((Runnable)v1)) {
            public void onStateChanged(LifecycleOwner arg2, Event arg3) {
                if(arg3 == Event.ON_DESTROY) {
                    this.val$handler.removeCallbacks(this.val$runnable);
                    arg2.getLifecycle().removeObserver(((LifecycleObserver)this));
                }
            }
        });
        v0.postDelayed(((Runnable)v1), 10000);
    }

    private void scheduleViewAttach(Fragment arg3, FrameLayout arg4) {
        this.mFragmentManager.registerFragmentLifecycleCallbacks(new FragmentLifecycleCallbacks(arg3, arg4) {
            public void onFragmentViewCreated(FragmentManager arg1, Fragment arg2, View arg3, Bundle arg4) {
                if(arg2 == this.val$fragment) {
                    arg1.unregisterFragmentLifecycleCallbacks(((FragmentLifecycleCallbacks)this));
                    FragmentStateAdapter.this.addViewToContainer(arg3, this.val$container);
                }
            }
        }, false);
    }

    public final void setHasStableIds(boolean arg1) {
        throw new UnsupportedOperationException("Stable Ids are required for the adapter to function properly, and the adapter takes care of setting the flag.");
    }

    boolean shouldDelayFragmentTransactions() {
        return this.mFragmentManager.isStateSaved();
    }
}

