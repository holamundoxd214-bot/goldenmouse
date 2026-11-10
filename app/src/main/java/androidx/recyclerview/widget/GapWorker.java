package androidx.recyclerview.widget;

import androidx.core.os.TraceCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

final class GapWorker implements Runnable {
    final class androidx.recyclerview.widget.GapWorker$1 implements Comparator {
        androidx.recyclerview.widget.GapWorker$1() {
            super();
        }

        public int compare(Task arg5, Task arg6) {
            int v4 = arg5.view == null ? 1 : 0;
            int v2 = arg6.view == null ? 1 : 0;
            int v3 = -1;
            if(v4 != v2) {
                if(arg5.view == null) {
                    return 1;
                }

                return v3;
            }

            if(arg5.immediate != arg6.immediate) {
                if(arg5.immediate) {
                    return v3;
                }

                return 1;
            }

            v4 = arg6.viewVelocity - arg5.viewVelocity;
            if(v4 != 0) {
                return v4;
            }

            v4 = arg5.distanceToItem - arg6.distanceToItem;
            if(v4 != 0) {
                return v4;
            }

            return 0;
        }

        public int compare(Object arg1, Object arg2) {
            return this.compare(((Task)arg1), ((Task)arg2));
        }
    }

    class LayoutPrefetchRegistryImpl implements LayoutPrefetchRegistry {
        int mCount;
        int[] mPrefetchArray;
        int mPrefetchDx;
        int mPrefetchDy;

        LayoutPrefetchRegistryImpl() {
            super();
        }

        public void addPosition(int arg6, int arg7) {
            int[] v0_1;
            if(arg6 >= 0) {
                if(arg7 >= 0) {
                    int v0 = this.mCount;
                    int v1 = v0 * 2;
                    int[] v2 = this.mPrefetchArray;
                    int v3 = 4;
                    if(v2 == null) {
                        v0_1 = new int[v3];
                        this.mPrefetchArray = v0_1;
                        Arrays.fill(v0_1, -1);
                    }
                    else if(v1 >= v2.length) {
                        v0_1 = new int[v0 * v3];
                        this.mPrefetchArray = v0_1;
                        System.arraycopy(v2, 0, v0_1, 0, v2.length);
                    }

                    v0_1 = this.mPrefetchArray;
                    v0_1[v1] = arg6;
                    v0_1[v1 + 1] = arg7;
                    ++this.mCount;
                    return;
                }

                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }

            throw new IllegalArgumentException("Layout positions must be non-negative");
        }

        void clearPrefetchPositions() {
            int[] v0 = this.mPrefetchArray;
            if(v0 != null) {
                Arrays.fill(v0, -1);
            }

            this.mCount = 0;
        }

        void collectPrefetchPositionsFromView(RecyclerView arg5, boolean arg6) {
            this.mCount = 0;
            int[] v0 = this.mPrefetchArray;
            if(v0 != null) {
                Arrays.fill(v0, -1);
            }

            LayoutManager v0_1 = arg5.mLayout;
            if(arg5.mAdapter != null && v0_1 != null && (v0_1.isItemPrefetchEnabled())) {
                if(arg6) {
                    if(!arg5.mAdapterHelper.hasPendingUpdates()) {
                        v0_1.collectInitialPrefetchPositions(arg5.mAdapter.getItemCount(), ((LayoutPrefetchRegistry)this));
                    }
                }
                else if(!arg5.hasPendingAdapterUpdates()) {
                    v0_1.collectAdjacentPrefetchPositions(this.mPrefetchDx, this.mPrefetchDy, arg5.mState, ((LayoutPrefetchRegistry)this));
                }

                if(this.mCount <= v0_1.mPrefetchMaxCountObserved) {
                    return;
                }

                v0_1.mPrefetchMaxCountObserved = this.mCount;
                v0_1.mPrefetchMaxObservedInInitialPrefetch = arg6;
                arg5.mRecycler.updateViewCacheSize();
            }
        }

        boolean lastPrefetchIncludedPosition(int arg5) {
            if(this.mPrefetchArray != null) {
                int v0 = this.mCount * 2;
                int v2 = 0;
                while(v2 < v0) {
                    if(this.mPrefetchArray[v2] == arg5) {
                        return 1;
                    }
                    else {
                        v2 += 2;
                        continue;
                    }

                    return 0;
                }
            }

            return 0;
        }

        void setPrefetchVector(int arg1, int arg2) {
            this.mPrefetchDx = arg1;
            this.mPrefetchDy = arg2;
        }
    }

    class Task {
        public int distanceToItem;
        public boolean immediate;
        public int position;
        public RecyclerView view;
        public int viewVelocity;

        Task() {
            super();
        }

        public void clear() {
            this.immediate = false;
            this.viewVelocity = 0;
            this.distanceToItem = 0;
            this.view = null;
            this.position = 0;
        }
    }

    long mFrameIntervalNs;
    long mPostTimeNs;
    ArrayList mRecyclerViews;
    private ArrayList mTasks;
    static final ThreadLocal sGapWorker;
    static Comparator sTaskComparator;

    static {
        GapWorker.sGapWorker = new ThreadLocal();
        GapWorker.sTaskComparator = new androidx.recyclerview.widget.GapWorker$1();
    }

    GapWorker() {
        super();
        this.mRecyclerViews = new ArrayList();
        this.mTasks = new ArrayList();
    }

    public void add(RecyclerView arg1) {
        this.mRecyclerViews.add(arg1);
    }

    private void buildTaskList() {
        Task v8;
        Object v4;
        int v0 = this.mRecyclerViews.size();
        int v2 = 0;
        int v3 = 0;
        while(v2 < v0) {
            v4 = this.mRecyclerViews.get(v2);
            if(((RecyclerView)v4).getWindowVisibility() == 0) {
                ((RecyclerView)v4).mPrefetchRegistry.collectPrefetchPositionsFromView(((RecyclerView)v4), false);
                v3 += ((RecyclerView)v4).mPrefetchRegistry.mCount;
            }

            ++v2;
        }

        this.mTasks.ensureCapacity(v3);
        v2 = 0;
        v3 = 0;
        while(v2 < v0) {
            v4 = this.mRecyclerViews.get(v2);
            if(((RecyclerView)v4).getWindowVisibility() != 0) {
            }
            else {
                LayoutPrefetchRegistryImpl v5 = ((RecyclerView)v4).mPrefetchRegistry;
                int v6 = Math.abs(v5.mPrefetchDx) + Math.abs(v5.mPrefetchDy);
                int v7;
                for(v7 = 0; v7 < v5.mCount * 2; v7 += 2) {
                    if(v3 >= this.mTasks.size()) {
                        v8 = new Task();
                        this.mTasks.add(v8);
                    }
                    else {
                        Object v8_1 = this.mTasks.get(v3);
                    }

                    int v9 = v5.mPrefetchArray[v7 + 1];
                    boolean v10 = v9 <= v6 ? true : false;
                    v8.immediate = v10;
                    v8.viewVelocity = v6;
                    v8.distanceToItem = v9;
                    v8.view = ((RecyclerView)v4);
                    v8.position = v5.mPrefetchArray[v7];
                    ++v3;
                }
            }

            ++v2;
        }

        Collections.sort(this.mTasks, GapWorker.sTaskComparator);
    }

    private void flushTaskWithDeadline(Task arg4, long arg5) {
        long v0 = arg4.immediate ? 0x7FFFFFFFFFFFFFFFL : arg5;
        ViewHolder v4 = this.prefetchPositionWithDeadline(arg4.view, arg4.position, v0);
        if(v4 != null && v4.mNestedRecyclerView != null && (v4.isBound()) && !v4.isInvalid()) {
            this.prefetchInnerRecyclerViewWithDeadline(v4.mNestedRecyclerView.get(), arg5);
        }
    }

    private void flushTasksWithDeadline(long arg4) {
        int v0 = 0;
        while(v0 < this.mTasks.size()) {
            Object v1 = this.mTasks.get(v0);
            if(((Task)v1).view == null) {
            }
            else {
                this.flushTaskWithDeadline(((Task)v1), arg4);
                ((Task)v1).clear();
                ++v0;
                continue;
            }

            return;
        }
    }

    static boolean isPrefetchPositionAttached(RecyclerView arg5, int arg6) {
        int v0 = arg5.mChildHelper.getUnfilteredChildCount();
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            ViewHolder v3 = RecyclerView.getChildViewHolderInt(arg5.mChildHelper.getUnfilteredChildAt(v2));
            if(v3.mPosition == arg6 && !v3.isInvalid()) {
                return 1;
            }
        }

        return 0;
    }

    void postFromTraversal(RecyclerView arg5, int arg6, int arg7) {
        if((arg5.isAttachedToWindow()) && this.mPostTimeNs == 0) {
            this.mPostTimeNs = arg5.getNanoTime();
            arg5.post(((Runnable)this));
        }

        arg5.mPrefetchRegistry.setPrefetchVector(arg6, arg7);
    }

    void prefetch(long arg1) {
        this.buildTaskList();
        this.flushTasksWithDeadline(arg1);
    }

    private void prefetchInnerRecyclerViewWithDeadline(RecyclerView arg4, long arg5) {
        if(arg4 == null) {
        }
        else {
            if((arg4.mDataSetHasChangedAfterLayout) && arg4.mChildHelper.getUnfilteredChildCount() != 0) {
                arg4.removeAndRecycleViews();
            }

            LayoutPrefetchRegistryImpl v0 = arg4.mPrefetchRegistry;
            v0.collectPrefetchPositionsFromView(arg4, true);
            if(v0.mCount == 0) {
                return;
            }

            try {
                TraceCompat.beginSection("RV Nested Prefetch");
                arg4.mState.prepareForNestedPrefetch(arg4.mAdapter);
                int v1;
                for(v1 = 0; v1 < v0.mCount * 2; v1 += 2) {
                    this.prefetchPositionWithDeadline(arg4, v0.mPrefetchArray[v1], arg5);
                }
            }
            catch(Throwable v3) {
                goto label_30;
            }

            TraceCompat.endSection();
            return;
        label_30:
            TraceCompat.endSection();
            throw v3;
        }
    }

    private ViewHolder prefetchPositionWithDeadline(RecyclerView arg2, int arg3, long arg4) {
        ViewHolder v3;
        if(GapWorker.isPrefetchPositionAttached(arg2, arg3)) {
            return null;
        }

        Recycler v1 = arg2.mRecycler;
        try {
            arg2.onEnterLayoutOrScroll();
            v3 = v1.tryGetViewHolderForPositionByDeadline(arg3, false, arg4);
            if(v3 != null) {
                if((v3.isBound()) && !v3.isInvalid()) {
                    v1.recycleView(v3.itemView);
                    goto label_17;
                }

                v1.addViewHolderToRecycledViewPool(v3, false);
            }
        }
        catch(Throwable v1_1) {
            arg2.onExitLayoutOrScroll(false);
            throw v1_1;
        }

    label_17:
        arg2.onExitLayoutOrScroll(false);
        return v3;
    }

    public void remove(RecyclerView arg1) {
        this.mRecyclerViews.remove(arg1);
    }

    public void run() {
        long v0 = 0;
        try {
            TraceCompat.beginSection("RV Prefetch");
            if(!this.mRecyclerViews.isEmpty()) {
                int v2_1 = this.mRecyclerViews.size();
                int v3 = 0;
                long v4 = v0;
                while(v3 < v2_1) {
                    Object v6 = this.mRecyclerViews.get(v3);
                    if(((RecyclerView)v6).getWindowVisibility() == 0) {
                        v4 = Math.max(((RecyclerView)v6).getDrawingTime(), v4);
                    }

                    ++v3;
                }

                if(v4 == v0) {
                    goto label_6;
                }

                this.prefetch(TimeUnit.MILLISECONDS.toNanos(v4) + this.mFrameIntervalNs);
            }
        }
        catch(Throwable v2) {
            goto label_31;
        }

    label_6:
        this.mPostTimeNs = v0;
        TraceCompat.endSection();
        return;
    label_31:
        this.mPostTimeNs = v0;
        TraceCompat.endSection();
        throw v2;
    }
}

