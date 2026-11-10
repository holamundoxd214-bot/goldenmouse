package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View$MeasureSpec;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat$CollectionItemInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import java.util.Arrays;

public class GridLayoutManager extends LinearLayoutManager {
    public final class DefaultSpanSizeLookup extends SpanSizeLookup {
        public DefaultSpanSizeLookup() {
            super();
        }

        public int getSpanIndex(int arg1, int arg2) {
            return arg1 % arg2;
        }

        public int getSpanSize(int arg1) {
            return 1;
        }
    }

    public class LayoutParams extends androidx.recyclerview.widget.RecyclerView$LayoutParams {
        public static final int INVALID_SPAN_ID = -1;
        int mSpanIndex;
        int mSpanSize;

        public LayoutParams(int arg1, int arg2) {
            super(arg1, arg2);
            this.mSpanIndex = -1;
            this.mSpanSize = 0;
        }

        public LayoutParams(Context arg1, AttributeSet arg2) {
            super(arg1, arg2);
            this.mSpanIndex = -1;
            this.mSpanSize = 0;
        }

        public LayoutParams(ViewGroup$MarginLayoutParams arg1) {
            super(arg1);
            this.mSpanIndex = -1;
            this.mSpanSize = 0;
        }

        public LayoutParams(ViewGroup$LayoutParams arg1) {
            super(arg1);
            this.mSpanIndex = -1;
            this.mSpanSize = 0;
        }

        public LayoutParams(androidx.recyclerview.widget.RecyclerView$LayoutParams arg1) {
            super(arg1);
            this.mSpanIndex = -1;
            this.mSpanSize = 0;
        }

        public int getSpanIndex() {
            return this.mSpanIndex;
        }

        public int getSpanSize() {
            return this.mSpanSize;
        }
    }

    public abstract class SpanSizeLookup {
        private boolean mCacheSpanGroupIndices;
        private boolean mCacheSpanIndices;
        final SparseIntArray mSpanGroupIndexCache;
        final SparseIntArray mSpanIndexCache;

        public SpanSizeLookup() {
            super();
            this.mSpanIndexCache = new SparseIntArray();
            this.mSpanGroupIndexCache = new SparseIntArray();
            this.mCacheSpanIndices = false;
            this.mCacheSpanGroupIndices = false;
        }

        static int findFirstKeyLessThan(SparseIntArray arg4, int arg5) {
            int v0 = arg4.size() - 1;
            int v1 = 0;
            while(v1 <= v0) {
                int v2 = v1 + v0 >>> 1;
                if(arg4.keyAt(v2) < arg5) {
                    v1 = v2 + 1;
                    continue;
                }

                v0 = v2 - 1;
            }

            --v1;
            if(v1 >= 0 && v1 < arg4.size()) {
                return arg4.keyAt(v1);
            }

            return -1;
        }

        int getCachedSpanGroupIndex(int arg3, int arg4) {
            if(!this.mCacheSpanGroupIndices) {
                return this.getSpanGroupIndex(arg3, arg4);
            }

            int v0 = this.mSpanGroupIndexCache.get(arg3, -1);
            if(v0 != -1) {
                return v0;
            }

            arg4 = this.getSpanGroupIndex(arg3, arg4);
            this.mSpanGroupIndexCache.put(arg3, arg4);
            return arg4;
        }

        int getCachedSpanIndex(int arg3, int arg4) {
            if(!this.mCacheSpanIndices) {
                return this.getSpanIndex(arg3, arg4);
            }

            int v0 = this.mSpanIndexCache.get(arg3, -1);
            if(v0 != -1) {
                return v0;
            }

            arg4 = this.getSpanIndex(arg3, arg4);
            this.mSpanIndexCache.put(arg3, arg4);
            return arg4;
        }

        public int getSpanGroupIndex(int arg7, int arg8) {
            int v4;
            int v3;
            int v2;
            int v0;
            if(this.mCacheSpanGroupIndices) {
                v0 = SpanSizeLookup.findFirstKeyLessThan(this.mSpanGroupIndexCache, arg7);
                if(v0 != -1) {
                    v2 = this.mSpanGroupIndexCache.get(v0);
                    v3 = v0 + 1;
                    v4 = this.getCachedSpanIndex(v0, arg8) + this.getSpanSize(v0);
                    if(v4 == arg8) {
                        ++v2;
                        v4 = 0;
                    }
                }
                else {
                    goto label_17;
                }
            }
            else {
            label_17:
                v2 = 0;
                v3 = 0;
                v4 = 0;
            }

            v0 = this.getSpanSize(arg7);
            while(v3 < arg7) {
                int v5 = this.getSpanSize(v3);
                v4 += v5;
                if(v4 == arg8) {
                    ++v2;
                    v4 = 0;
                }
                else if(v4 > arg8) {
                    ++v2;
                    v4 = v5;
                }

                ++v3;
            }

            if(v4 + v0 > arg8) {
                ++v2;
            }

            return v2;
        }

        public int getSpanIndex(int arg6, int arg7) {
            int v3;
            int v2;
            int v0 = this.getSpanSize(arg6);
            if(v0 == arg7) {
                return 0;
            }

            if(this.mCacheSpanIndices) {
                v2 = SpanSizeLookup.findFirstKeyLessThan(this.mSpanIndexCache, arg6);
                if(v2 >= 0) {
                    v3 = this.mSpanIndexCache.get(v2) + this.getSpanSize(v2);
                    goto label_24;
                }
                else {
                    goto label_14;
                }
            }
            else {
            label_14:
                v2 = 0;
                v3 = 0;
                goto label_16;
            label_24:
                ++v2;
            }

        label_16:
            if(v2 < arg6) {
                int v4 = this.getSpanSize(v2);
                v3 += v4;
                if(v3 == arg7) {
                    v3 = 0;
                    goto label_24;
                }

                if(v3 <= arg7) {
                    goto label_24;
                }

                v3 = v4;
                goto label_24;
            }

            if(v0 + v3 <= arg7) {
                return v3;
            }

            return 0;
        }

        public abstract int getSpanSize(int arg1);

        public void invalidateSpanGroupIndexCache() {
            this.mSpanGroupIndexCache.clear();
        }

        public void invalidateSpanIndexCache() {
            this.mSpanIndexCache.clear();
        }

        public boolean isSpanGroupIndexCacheEnabled() {
            return this.mCacheSpanGroupIndices;
        }

        public boolean isSpanIndexCacheEnabled() {
            return this.mCacheSpanIndices;
        }

        public void setSpanGroupIndexCacheEnabled(boolean arg2) {
            if(!arg2) {
                this.mSpanGroupIndexCache.clear();
            }

            this.mCacheSpanGroupIndices = arg2;
        }

        public void setSpanIndexCacheEnabled(boolean arg2) {
            if(!arg2) {
                this.mSpanGroupIndexCache.clear();
            }

            this.mCacheSpanIndices = arg2;
        }
    }

    private static final boolean DEBUG = false;
    public static final int DEFAULT_SPAN_COUNT = -1;
    private static final String TAG = "GridLayoutManager";
    int[] mCachedBorders;
    final Rect mDecorInsets;
    boolean mPendingSpanCountChange;
    final SparseIntArray mPreLayoutSpanIndexCache;
    final SparseIntArray mPreLayoutSpanSizeCache;
    View[] mSet;
    int mSpanCount;
    SpanSizeLookup mSpanSizeLookup;
    private boolean mUsingSpansToEstimateScrollBarDimensions;

    public GridLayoutManager(Context arg1, int arg2) {
        super(arg1);
        this.mPendingSpanCountChange = false;
        this.mSpanCount = -1;
        this.mPreLayoutSpanSizeCache = new SparseIntArray();
        this.mPreLayoutSpanIndexCache = new SparseIntArray();
        this.mSpanSizeLookup = new DefaultSpanSizeLookup();
        this.mDecorInsets = new Rect();
        this.setSpanCount(arg2);
    }

    public GridLayoutManager(Context arg1, int arg2, int arg3, boolean arg4) {
        super(arg1, arg3, arg4);
        this.mPendingSpanCountChange = false;
        this.mSpanCount = -1;
        this.mPreLayoutSpanSizeCache = new SparseIntArray();
        this.mPreLayoutSpanIndexCache = new SparseIntArray();
        this.mSpanSizeLookup = new DefaultSpanSizeLookup();
        this.mDecorInsets = new Rect();
        this.setSpanCount(arg2);
    }

    public GridLayoutManager(Context arg2, AttributeSet arg3, int arg4, int arg5) {
        super(arg2, arg3, arg4, arg5);
        this.mPendingSpanCountChange = false;
        this.mSpanCount = -1;
        this.mPreLayoutSpanSizeCache = new SparseIntArray();
        this.mPreLayoutSpanIndexCache = new SparseIntArray();
        this.mSpanSizeLookup = new DefaultSpanSizeLookup();
        this.mDecorInsets = new Rect();
        this.setSpanCount(GridLayoutManager.getProperties(arg2, arg3, arg4, arg5).spanCount);
    }

    private void assignSpans(Recycler arg5, State arg6, int arg7, boolean arg8) {
        int v8;
        int v1;
        int v0 = 0;
        if(arg8) {
            v1 = 1;
            v8 = arg7;
            arg7 = 0;
        }
        else {
            --arg7;
            v8 = -1;
            v1 = v8;
        }

        while(arg7 != v8) {
            View v2 = this.mSet[arg7];
            ViewGroup$LayoutParams v3 = v2.getLayoutParams();
            ((LayoutParams)v3).mSpanSize = this.getSpanSize(arg5, arg6, this.getPosition(v2));
            ((LayoutParams)v3).mSpanIndex = v0;
            v0 += ((LayoutParams)v3).mSpanSize;
            arg7 += v1;
        }
    }

    private void cachePreLayoutSpanMapping() {
        int v0 = this.getChildCount();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            ViewGroup$LayoutParams v2 = this.getChildAt(v1).getLayoutParams();
            int v3 = ((LayoutParams)v2).getViewLayoutPosition();
            this.mPreLayoutSpanSizeCache.put(v3, ((LayoutParams)v2).getSpanSize());
            this.mPreLayoutSpanIndexCache.put(v3, ((LayoutParams)v2).getSpanIndex());
        }
    }

    private void calculateItemBorders(int arg3) {
        this.mCachedBorders = GridLayoutManager.calculateItemBorders(this.mCachedBorders, this.mSpanCount, arg3);
    }

    static int[] calculateItemBorders(int[] arg5, int arg6, int arg7) {
        int v4;
        int v0 = 1;
        if(arg5 == null || arg5.length != arg6 + 1 || arg5[arg5.length - 1] != arg7) {
            arg5 = new int[arg6 + 1];
        }

        int v1 = 0;
        arg5[v1] = v1;
        int v2 = arg7 / arg6;
        arg7 %= arg6;
        int v3 = 0;
        while(v0 <= arg6) {
            v1 += arg7;
            if(v1 <= 0 || arg6 - v1 >= arg7) {
                v4 = v2;
            }
            else {
                v4 = v2 + 1;
                v1 -= arg6;
            }

            v3 += v4;
            arg5[v0] = v3;
            ++v0;
        }

        return arg5;
    }

    public boolean checkLayoutParams(androidx.recyclerview.widget.RecyclerView$LayoutParams arg1) {
        return arg1 instanceof LayoutParams;
    }

    private void clearPreLayoutSpanMappingCache() {
        this.mPreLayoutSpanSizeCache.clear();
        this.mPreLayoutSpanIndexCache.clear();
    }

    void collectPrefetchPositionsForLayoutState(State arg6, LayoutState arg7, LayoutPrefetchRegistry arg8) {
        int v0 = this.mSpanCount;
        int v2;
        for(v2 = 0; v2 < this.mSpanCount; ++v2) {
            if(!arg7.hasMore(arg6)) {
                return;
            }

            if(v0 <= 0) {
                return;
            }

            int v3 = arg7.mCurrentPosition;
            arg8.addPosition(v3, Math.max(0, arg7.mScrollingOffset));
            v0 -= this.mSpanSizeLookup.getSpanSize(v3);
            arg7.mCurrentPosition += arg7.mItemDirection;
        }
    }

    public int computeHorizontalScrollOffset(State arg2) {
        if(this.mUsingSpansToEstimateScrollBarDimensions) {
            return this.computeScrollOffsetWithSpanInfo(arg2);
        }

        return super.computeHorizontalScrollOffset(arg2);
    }

    public int computeHorizontalScrollRange(State arg2) {
        if(this.mUsingSpansToEstimateScrollBarDimensions) {
            return this.computeScrollRangeWithSpanInfo(arg2);
        }

        return super.computeHorizontalScrollRange(arg2);
    }

    private int computeScrollOffsetWithSpanInfo(State arg10) {
        if(this.getChildCount() != 0) {
            if(arg10.getItemCount() == 0) {
            }
            else {
                this.ensureLayoutState();
                boolean v0 = this.isSmoothScrollbarEnabled();
                View v2 = this.findFirstVisibleChildClosestToStart((((int)v0)) ^ 1, true);
                View v4 = this.findFirstVisibleChildClosestToEnd((((int)v0)) ^ 1, true);
                if(v2 != null) {
                    if(v4 == null) {
                    }
                    else {
                        int v5 = this.mSpanSizeLookup.getCachedSpanGroupIndex(this.getPosition(v2), this.mSpanCount);
                        int v6 = this.mSpanSizeLookup.getCachedSpanGroupIndex(this.getPosition(v4), this.mSpanCount);
                        int v7 = Math.min(v5, v6);
                        v5 = Math.max(v5, v6);
                        int v10 = this.mSpanSizeLookup.getCachedSpanGroupIndex(arg10.getItemCount() - 1, this.mSpanCount) + 1;
                        v10 = this.mShouldReverseLayout ? Math.max(0, v10 - v5 - 1) : Math.max(0, v7);
                        if(!v0) {
                            return v10;
                        }

                        return Math.round((((float)v10)) * ((((float)Math.abs(this.mOrientationHelper.getDecoratedEnd(v4) - this.mOrientationHelper.getDecoratedStart(v2)))) / (((float)(this.mSpanSizeLookup.getCachedSpanGroupIndex(this.getPosition(v4), this.mSpanCount) - this.mSpanSizeLookup.getCachedSpanGroupIndex(this.getPosition(v2), this.mSpanCount) + 1)))) + (((float)(this.mOrientationHelper.getStartAfterPadding() - this.mOrientationHelper.getDecoratedStart(v2)))));
                    }
                }
            }
        }

        return 0;
    }

    private int computeScrollRangeWithSpanInfo(State arg7) {
        if(this.getChildCount() != 0) {
            if(arg7.getItemCount() == 0) {
            }
            else {
                this.ensureLayoutState();
                View v0 = this.findFirstVisibleChildClosestToStart(this.isSmoothScrollbarEnabled() ^ 1, true);
                View v3 = this.findFirstVisibleChildClosestToEnd(this.isSmoothScrollbarEnabled() ^ 1, true);
                if(v0 != null) {
                    if(v3 == null) {
                    }
                    else if(!this.isSmoothScrollbarEnabled()) {
                        return this.mSpanSizeLookup.getCachedSpanGroupIndex(arg7.getItemCount() - 1, this.mSpanCount) + 1;
                    }
                    else {
                        return ((int)((((float)(this.mOrientationHelper.getDecoratedEnd(v3) - this.mOrientationHelper.getDecoratedStart(v0)))) / (((float)(this.mSpanSizeLookup.getCachedSpanGroupIndex(this.getPosition(v3), this.mSpanCount) - this.mSpanSizeLookup.getCachedSpanGroupIndex(this.getPosition(v0), this.mSpanCount) + 1))) * (((float)(this.mSpanSizeLookup.getCachedSpanGroupIndex(arg7.getItemCount() - 1, this.mSpanCount) + 1)))));
                    }
                }
            }
        }

        return 0;
    }

    public int computeVerticalScrollOffset(State arg2) {
        if(this.mUsingSpansToEstimateScrollBarDimensions) {
            return this.computeScrollOffsetWithSpanInfo(arg2);
        }

        return super.computeVerticalScrollOffset(arg2);
    }

    public int computeVerticalScrollRange(State arg2) {
        if(this.mUsingSpansToEstimateScrollBarDimensions) {
            return this.computeScrollRangeWithSpanInfo(arg2);
        }

        return super.computeVerticalScrollRange(arg2);
    }

    private void ensureAnchorIsInCorrectSpan(Recycler arg5, State arg6, AnchorInfo arg7, int arg8) {
        arg8 = arg8 == 1 ? 1 : 0;
        int v1 = this.getSpanIndex(arg5, arg6, arg7.mPosition);
        if(arg8 != 0) {
            while(v1 > 0) {
                if(arg7.mPosition <= 0) {
                    return;
                }

                --arg7.mPosition;
                v1 = this.getSpanIndex(arg5, arg6, arg7.mPosition);
            }

            return;
        }

        arg8 = arg6.getItemCount() - 1;
        int v0 = arg7.mPosition;
        while(v0 < arg8) {
            int v2 = v0 + 1;
            int v3 = this.getSpanIndex(arg5, arg6, v2);
            if(v3 <= v1) {
                break;
            }

            v0 = v2;
            v1 = v3;
        }

        arg7.mPosition = v0;
    }

    private void ensureViewSet() {
        View[] v0 = this.mSet;
        if(v0 != null) {
            if(v0.length != this.mSpanCount) {
            }
            else {
                return;
            }
        }

        this.mSet = new View[this.mSpanCount];
    }

    View findReferenceChild(Recycler arg8, State arg9, int arg10, int arg11, int arg12) {
        this.ensureLayoutState();
        int v0 = this.mOrientationHelper.getStartAfterPadding();
        int v1 = this.mOrientationHelper.getEndAfterPadding();
        int v2 = arg11 > arg10 ? 1 : -1;
        View v3 = null;
        View v4 = v3;
        while(arg10 != arg11) {
            View v5 = this.getChildAt(arg10);
            int v6 = this.getPosition(v5);
            if(v6 >= 0 && v6 < arg12) {
                if(this.getSpanIndex(arg8, arg9, v6) != 0) {
                }
                else if(!v5.getLayoutParams().isItemRemoved()) {
                    if(this.mOrientationHelper.getDecoratedStart(v5) < v1) {
                        if(this.mOrientationHelper.getDecoratedEnd(v5) < v0) {
                        }
                        else {
                            return v5;
                        }
                    }

                    if(v3 != null) {
                        goto label_35;
                    }

                    v3 = v5;
                }
                else if(v4 == null) {
                    v4 = v5;
                }
            }

        label_35:
            arg10 += v2;
        }

        if(v3 != null) {
            return v3;
        }

        return v4;
    }

    public androidx.recyclerview.widget.RecyclerView$LayoutParams generateDefaultLayoutParams() {
        int v0 = -2;
        int v1 = -1;
        if(this.mOrientation == 0) {
            return new LayoutParams(v0, v1);
        }

        return new LayoutParams(v1, v0);
    }

    public androidx.recyclerview.widget.RecyclerView$LayoutParams generateLayoutParams(Context arg1, AttributeSet arg2) {
        return new LayoutParams(arg1, arg2);
    }

    public androidx.recyclerview.widget.RecyclerView$LayoutParams generateLayoutParams(ViewGroup$LayoutParams arg1) {
        if((arg1 instanceof ViewGroup$MarginLayoutParams)) {
            return new LayoutParams(((ViewGroup$MarginLayoutParams)arg1));
        }

        return new LayoutParams(arg1);
    }

    public int getColumnCountForAccessibility(Recycler arg3, State arg4) {
        if(this.mOrientation == 1) {
            return this.mSpanCount;
        }

        if(arg4.getItemCount() < 1) {
            return 0;
        }

        return this.getSpanGroupIndex(arg3, arg4, arg4.getItemCount() - 1) + 1;
    }

    public int getRowCountForAccessibility(Recycler arg3, State arg4) {
        if(this.mOrientation == 0) {
            return this.mSpanCount;
        }

        if(arg4.getItemCount() < 1) {
            return 0;
        }

        return this.getSpanGroupIndex(arg3, arg4, arg4.getItemCount() - 1) + 1;
    }

    int getSpaceForSpanRange(int arg3, int arg4) {
        if(this.mOrientation == 1 && (this.isLayoutRTL())) {
            return this.mCachedBorders[this.mSpanCount - arg3] - this.mCachedBorders[this.mSpanCount - arg3 - arg4];
        }

        return this.mCachedBorders[arg4 + arg3] - this.mCachedBorders[arg3];
    }

    public int getSpanCount() {
        return this.mSpanCount;
    }

    private int getSpanGroupIndex(Recycler arg1, State arg2, int arg3) {
        if(!arg2.isPreLayout()) {
            return this.mSpanSizeLookup.getCachedSpanGroupIndex(arg3, this.mSpanCount);
        }

        int v1 = arg1.convertPreLayoutPositionToPostLayout(arg3);
        if(v1 == -1) {
            Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + arg3);
            return 0;
        }

        return this.mSpanSizeLookup.getCachedSpanGroupIndex(v1, this.mSpanCount);
    }

    private int getSpanIndex(Recycler arg2, State arg3, int arg4) {
        if(!arg3.isPreLayout()) {
            return this.mSpanSizeLookup.getCachedSpanIndex(arg4, this.mSpanCount);
        }

        int v0 = -1;
        int v3 = this.mPreLayoutSpanIndexCache.get(arg4, v0);
        if(v3 != v0) {
            return v3;
        }

        int v2 = arg2.convertPreLayoutPositionToPostLayout(arg4);
        if(v2 == v0) {
            Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + arg4);
            return 0;
        }

        return this.mSpanSizeLookup.getCachedSpanIndex(v2, this.mSpanCount);
    }

    private int getSpanSize(Recycler arg2, State arg3, int arg4) {
        if(!arg3.isPreLayout()) {
            return this.mSpanSizeLookup.getSpanSize(arg4);
        }

        int v0 = -1;
        int v3 = this.mPreLayoutSpanSizeCache.get(arg4, v0);
        if(v3 != v0) {
            return v3;
        }

        int v2 = arg2.convertPreLayoutPositionToPostLayout(arg4);
        if(v2 == v0) {
            Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + arg4);
            return 1;
        }

        return this.mSpanSizeLookup.getSpanSize(v2);
    }

    public SpanSizeLookup getSpanSizeLookup() {
        return this.mSpanSizeLookup;
    }

    private void guessMeasurement(float arg2, int arg3) {
        this.calculateItemBorders(Math.max(Math.round(arg2 * (((float)this.mSpanCount))), arg3));
    }

    public boolean isUsingSpansToEstimateScrollbarDimensions() {
        return this.mUsingSpansToEstimateScrollBarDimensions;
    }

    void layoutChunk(Recycler arg18, State arg19, LayoutState arg20, LayoutChunkResult arg21) {
        int v5_1;
        View[] v5;
        int v3_1;
        View v2_2;
        int v1_2;
        int v15;
        int v14;
        GridLayoutManager v0 = this;
        Recycler v1 = arg18;
        State v2 = arg19;
        LayoutState v3 = arg20;
        LayoutChunkResult v6 = arg21;
        int v4 = v0.mOrientationHelper.getModeInOther();
        int v9 = v4 != 0x40000000 ? 1 : 0;
        int v10 = v0.getChildCount() > 0 ? v0.mCachedBorders[v0.mSpanCount] : 0;
        if(v9 != 0) {
            v0.updateMeasurements();
        }

        boolean v11 = v3.mItemDirection == 1 ? true : false;
        int v12 = v0.mSpanCount;
        if(!v11) {
            v12 = v0.getSpanIndex(v1, v2, v3.mCurrentPosition) + v0.getSpanSize(v1, v2, v3.mCurrentPosition);
        }

        int v13 = 0;
        while(true) {
            if(v13 < v0.mSpanCount && (v3.hasMore(v2)) && v12 > 0) {
                v14 = v3.mCurrentPosition;
                v15 = v0.getSpanSize(v1, v2, v14);
                if(v15 <= v0.mSpanCount) {
                    v12 -= v15;
                    if(v12 < 0) {
                    }
                    else {
                        View v8 = v3.next(v1);
                        if(v8 == null) {
                        }
                        else {
                            v0.mSet[v13] = v8;
                            ++v13;
                            continue;
                        }
                    }
                }
                else {
                    break;
                }
            }

            goto label_73;
        }

        throw new IllegalArgumentException("Item at position " + v14 + " requires " + v15 + " spans but GridLayoutManager has only " + v0.mSpanCount + " spans.");
    label_73:
        if(v13 == 0) {
            v6.mFinished = true;
            return;
        }

        v0.assignSpans(v1, v2, v13, v11);
        float v1_1 = 0f;
        int v2_1 = 0;
        int v8_1 = 0;
        while(v2_1 < v13) {
            View v12_1 = v0.mSet[v2_1];
            if(v3.mScrapList == null) {
                if(v11) {
                    v0.addView(v12_1);
                }
                else {
                    v0.addView(v12_1, 0);
                }
            }
            else if(v11) {
                v0.addDisappearingView(v12_1);
            }
            else {
                v0.addDisappearingView(v12_1, 0);
            }

            v0.calculateItemDecorationsForChild(v12_1, v0.mDecorInsets);
            v0.measureChild(v12_1, v4, false);
            v14 = v0.mOrientationHelper.getDecoratedMeasurement(v12_1);
            if(v14 > v8_1) {
                v8_1 = v14;
            }

            float v12_2 = (((float)v0.mOrientationHelper.getDecoratedMeasurementInOther(v12_1))) * 1f / (((float)v12_1.getLayoutParams().mSpanSize));
            if(v12_2 > v1_1) {
                v1_1 = v12_2;
            }

            ++v2_1;
        }

        if(v9 != 0) {
            v0.guessMeasurement(v1_1, v10);
            v1_2 = 0;
            v8_1 = 0;
            while(v1_2 < v13) {
                v2_2 = v0.mSet[v1_2];
                v0.measureChild(v2_2, 0x40000000, true);
                v2_1 = v0.mOrientationHelper.getDecoratedMeasurement(v2_2);
                if(v2_1 > v8_1) {
                    v8_1 = v2_1;
                }

                ++v1_2;
            }
        }

        for(v1_2 = 0; v1_2 < v13; ++v1_2) {
            v2_2 = v0.mSet[v1_2];
            if(v0.mOrientationHelper.getDecoratedMeasurement(v2_2) != v8_1) {
                ViewGroup$LayoutParams v4_1 = v2_2.getLayoutParams();
                Rect v9_1 = ((LayoutParams)v4_1).mDecorInsets;
                v10 = v9_1.top + v9_1.bottom + ((LayoutParams)v4_1).topMargin + ((LayoutParams)v4_1).bottomMargin;
                int v11_1 = v9_1.left + v9_1.right + ((LayoutParams)v4_1).leftMargin + ((LayoutParams)v4_1).rightMargin;
                v9 = v0.getSpaceForSpanRange(((LayoutParams)v4_1).mSpanIndex, ((LayoutParams)v4_1).mSpanSize);
                if(v0.mOrientation == 1) {
                    v4 = GridLayoutManager.getChildMeasureSpec(v9, 0x40000000, v11_1, ((LayoutParams)v4_1).width, false);
                    v9 = View$MeasureSpec.makeMeasureSpec(v8_1 - v10, 0x40000000);
                }
                else {
                    v11_1 = View$MeasureSpec.makeMeasureSpec(v8_1 - v11_1, 0x40000000);
                    v9 = GridLayoutManager.getChildMeasureSpec(v9, 0x40000000, v10, ((LayoutParams)v4_1).height, false);
                    v4 = v11_1;
                }

                v0.measureChildWithDecorationsAndMargin(v2_2, v4, v9, true);
            }
        }

        v6.mConsumed = v8_1;
        v2_1 = -1;
        if(v0.mOrientation == 1) {
            if(v3.mLayoutDirection == v2_1) {
                v1_2 = v3.mOffset;
                v2_1 = v1_2 - v8_1;
            }
            else {
                v2_1 = v3.mOffset;
                v1_2 = v2_1 + v8_1;
            }

            v3_1 = v2_1;
            v2_1 = 0;
            v4 = 0;
        }
        else {
            if(v3.mLayoutDirection == v2_1) {
                v1_2 = v3.mOffset;
                v2_1 = v1_2 - v8_1;
            }
            else {
                v2_1 = v3.mOffset;
                v1_2 = v2_1 + v8_1;
            }

            v4 = v2_1;
            v3_1 = 0;
            v2_1 = v1_2;
            v1_2 = 0;
        }

        v8_1 = 0;
        while(true) {
            v5 = v0.mSet;
            if(v8_1 >= v13) {
                break;
            }

            v9 = v1_2;
            View v1_3 = v5[v8_1];
            ViewGroup$LayoutParams v10_1 = v1_3.getLayoutParams();
            if(v0.mOrientation == 1) {
                if(v0.isLayoutRTL()) {
                    v2_1 = v0.getPaddingLeft() + v0.mCachedBorders[v0.mSpanCount - ((LayoutParams)v10_1).mSpanIndex];
                    v4 = v2_1 - v0.mOrientationHelper.getDecoratedMeasurementInOther(v1_3);
                }
                else {
                    v4 = v0.mCachedBorders[((LayoutParams)v10_1).mSpanIndex] + v0.getPaddingLeft();
                    v2_1 = v0.mOrientationHelper.getDecoratedMeasurementInOther(v1_3) + v4;
                }

                v5_1 = v4;
                v4 = v2_1;
                v2_1 = v5_1;
                v5_1 = v9;
            }
            else {
                v3_1 = v0.getPaddingTop() + v0.mCachedBorders[((LayoutParams)v10_1).mSpanIndex];
                v5_1 = v0.mOrientationHelper.getDecoratedMeasurementInOther(v1_3) + v3_1;
                int v16 = v4;
                v4 = v2_1;
                v2_1 = v16;
            }

            v0.layoutDecoratedWithMargins(v1_3, v2_1, v3_1, v4, v5_1);
            int v0_1 = v4;
            v4 = v2_1;
            v2_1 = v0_1;
            View v0_2 = v1_3;
            v1_2 = v5_1;
            if((((LayoutParams)v10_1).isItemRemoved()) || (((LayoutParams)v10_1).isItemChanged())) {
                v6.mIgnoreConsumed = true;
            }

            v6.mFocusable |= v0_2.hasFocusable();
            ++v8_1;
            v0 = this;
        }

        Arrays.fill(((Object[])v5), null);
    }

    private void measureChild(View arg9, int arg10, boolean arg11) {
        int v0_1;
        ViewGroup$LayoutParams v0 = arg9.getLayoutParams();
        Rect v1 = ((LayoutParams)v0).mDecorInsets;
        int v2 = v1.top + v1.bottom + ((LayoutParams)v0).topMargin + ((LayoutParams)v0).bottomMargin;
        int v3 = v1.left + v1.right + ((LayoutParams)v0).leftMargin + ((LayoutParams)v0).rightMargin;
        int v1_1 = this.getSpaceForSpanRange(((LayoutParams)v0).mSpanIndex, ((LayoutParams)v0).mSpanSize);
        if(this.mOrientation == 1) {
            arg10 = GridLayoutManager.getChildMeasureSpec(v1_1, arg10, v3, ((LayoutParams)v0).width, false);
            v0_1 = GridLayoutManager.getChildMeasureSpec(this.mOrientationHelper.getTotalSpace(), this.getHeightMode(), v2, ((LayoutParams)v0).height, true);
        }
        else {
            arg10 = GridLayoutManager.getChildMeasureSpec(v1_1, arg10, v2, ((LayoutParams)v0).height, false);
            int v7 = GridLayoutManager.getChildMeasureSpec(this.mOrientationHelper.getTotalSpace(), this.getWidthMode(), v3, ((LayoutParams)v0).width, true);
            v0_1 = arg10;
            arg10 = v7;
        }

        this.measureChildWithDecorationsAndMargin(arg9, arg10, v0_1, arg11);
    }

    private void measureChildWithDecorationsAndMargin(View arg2, int arg3, int arg4, boolean arg5) {
        ViewGroup$LayoutParams v0 = arg2.getLayoutParams();
        boolean v1 = arg5 ? this.shouldReMeasureChild(arg2, arg3, arg4, ((androidx.recyclerview.widget.RecyclerView$LayoutParams)v0)) : this.shouldMeasureChild(arg2, arg3, arg4, ((androidx.recyclerview.widget.RecyclerView$LayoutParams)v0));
        if(v1) {
            arg2.measure(arg3, arg4);
        }
    }

    void onAnchorReady(Recycler arg2, State arg3, AnchorInfo arg4, int arg5) {
        super.onAnchorReady(arg2, arg3, arg4, arg5);
        this.updateMeasurements();
        if(arg3.getItemCount() > 0 && !arg3.isPreLayout()) {
            this.ensureAnchorIsInCorrectSpan(arg2, arg3, arg4, arg5);
        }

        this.ensureViewSet();
    }

    public View onFocusSearchFailed(View arg24, int arg25, Recycler arg26, State arg27) {
        View v21;
        View v18;
        int v20;
        View v19;
        int v4_1;
        int v12;
        int v10;
        int v5_2;
        GridLayoutManager v0 = this;
        Recycler v1 = arg26;
        State v2 = arg27;
        View v3 = this.findContainingItemView(arg24);
        View v4 = null;
        if(v3 == null) {
            return v4;
        }

        ViewGroup$LayoutParams v5 = v3.getLayoutParams();
        int v6 = ((LayoutParams)v5).mSpanIndex;
        int v7 = ((LayoutParams)v5).mSpanIndex + ((LayoutParams)v5).mSpanSize;
        if(super.onFocusSearchFailed(arg24, arg25, arg26, arg27) == null) {
            return v4;
        }

        boolean v5_1 = v0.convertFocusDirectionToLayoutDirection(arg25) == 1 ? true : false;
        int v11 = -1;
        if(v5_1 != v0.mShouldReverseLayout) {
            v5_2 = v0.getChildCount() - 1;
            v10 = v11;
            v12 = v10;
        }
        else {
            v10 = v0.getChildCount();
            v12 = 1;
            v5_2 = 0;
        }

        int v13 = v0.mOrientation != 1 || !v0.isLayoutRTL() ? 0 : 1;
        int v14 = v0.getSpanGroupIndex(v1, v2, v5_2);
        int v15 = v11;
        int v16 = v15;
        int v8 = 0;
        int v17 = 0;
        v11 = v5_2;
        View v5_3 = v4;
        while(v11 != v10) {
            int v9 = v0.getSpanGroupIndex(v1, v2, v11);
            View v1_1 = v0.getChildAt(v11);
            if(v1_1 == v3) {
            }
            else {
                if(!v1_1.hasFocusable() || v9 == v14) {
                    ViewGroup$LayoutParams v9_1 = v1_1.getLayoutParams();
                    int v2_1 = ((LayoutParams)v9_1).mSpanIndex;
                    v18 = v3;
                    int v3_1 = ((LayoutParams)v9_1).mSpanIndex + ((LayoutParams)v9_1).mSpanSize;
                    if((v1_1.hasFocusable()) && v2_1 == v6 && v3_1 == v7) {
                        return v1_1;
                    }

                    if(!v1_1.hasFocusable() || v4 != null) {
                        if(!v1_1.hasFocusable() && v5_3 == null) {
                        label_83:
                            v21 = v4;
                            goto label_84;
                        }

                        v21 = v4;
                        v4_1 = Math.min(v3_1, v7) - Math.max(v2_1, v6);
                        if(v1_1.hasFocusable()) {
                            if(v4_1 <= v8) {
                                if(v4_1 != v8) {
                                    goto label_60;
                                }

                                v4_1 = v2_1 > v15 ? 1 : 0;
                                if(v13 != v4_1) {
                                    goto label_60;
                                }
                            }

                        label_84:
                            v19 = v5_3;
                            v20 = v8;
                            v4_1 = v16;
                            v5_2 = v17;
                            goto label_121;
                        }

                        if(v21 != null) {
                            goto label_60;
                        }

                        v19 = v5_3;
                        v20 = v8;
                        v8 = 1;
                        if(!v0.isViewPartiallyVisible(v1_1, false, true)) {
                            goto label_62;
                        }

                        v5_2 = v17;
                        if(v4_1 > v5_2) {
                            v4_1 = v16;
                            goto label_121;
                        }

                        if(v4_1 != v5_2) {
                            goto label_141;
                        }

                        v4_1 = v16;
                        if(v2_1 > v4_1) {
                        }
                        else {
                            v8 = 0;
                        }

                        if(v13 != v8) {
                            goto label_142;
                        }
                    }
                    else {
                        goto label_83;
                    }

                label_121:
                    if(v1_1.hasFocusable()) {
                        v16 = v4_1;
                        v17 = v5_2;
                        v15 = ((LayoutParams)v9_1).mSpanIndex;
                        v5_3 = v19;
                        v4 = v1_1;
                        v8 = Math.min(v3_1, v7) - Math.max(v2_1, v6);
                        goto label_147;
                    }

                    v4_1 = ((LayoutParams)v9_1).mSpanIndex;
                    v17 = Math.min(v3_1, v7) - Math.max(v2_1, v6);
                    v5_3 = v1_1;
                    v16 = v4_1;
                    goto label_145;
                label_141:
                    v4_1 = v16;
                    goto label_142;
                label_60:
                    v19 = v5_3;
                    v20 = v8;
                label_62:
                    v4_1 = v16;
                    v5_2 = v17;
                label_142:
                    v16 = v4_1;
                    v17 = v5_2;
                    v5_3 = v19;
                label_145:
                    v8 = v20;
                    v4 = v21;
                }
                else if(v4 != null) {
                    break;
                }
                else {
                    v18 = v3;
                    v21 = v4;
                    goto label_60;
                }

            label_147:
                v11 += v12;
                v1 = arg26;
                v2 = arg27;
                v3 = v18;
                continue;
            }

            break;
        }

        v21 = v4;
        v19 = v5_3;
        if(v21 != null) {
            return v21;
        }

        return v19;
    }

    public void onInitializeAccessibilityNodeInfoForItem(Recycler arg8, State arg9, View arg10, AccessibilityNodeInfoCompat arg11) {
        ViewGroup$LayoutParams v0 = arg10.getLayoutParams();
        if(!(v0 instanceof LayoutParams)) {
            super.onInitializeAccessibilityNodeInfoForItem(arg10, arg11);
            return;
        }

        int v1 = this.getSpanGroupIndex(arg8, arg9, ((LayoutParams)v0).getViewLayoutPosition());
        if(this.mOrientation == 0) {
            arg11.setCollectionItemInfo(CollectionItemInfoCompat.obtain(((LayoutParams)v0).getSpanIndex(), ((LayoutParams)v0).getSpanSize(), v1, 1, false, false));
            return;
        }

        arg11.setCollectionItemInfo(CollectionItemInfoCompat.obtain(v1, 1, ((LayoutParams)v0).getSpanIndex(), ((LayoutParams)v0).getSpanSize(), false, false));
    }

    public void onItemsAdded(RecyclerView arg1, int arg2, int arg3) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    public void onItemsChanged(RecyclerView arg1) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    public void onItemsMoved(RecyclerView arg1, int arg2, int arg3, int arg4) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    public void onItemsRemoved(RecyclerView arg1, int arg2, int arg3) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    public void onItemsUpdated(RecyclerView arg1, int arg2, int arg3, Object arg4) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    public void onLayoutChildren(Recycler arg2, State arg3) {
        if(arg3.isPreLayout()) {
            this.cachePreLayoutSpanMapping();
        }

        super.onLayoutChildren(arg2, arg3);
        this.clearPreLayoutSpanMappingCache();
    }

    public void onLayoutCompleted(State arg1) {
        super.onLayoutCompleted(arg1);
        this.mPendingSpanCountChange = false;
    }

    public int scrollHorizontallyBy(int arg1, Recycler arg2, State arg3) {
        this.updateMeasurements();
        this.ensureViewSet();
        return super.scrollHorizontallyBy(arg1, arg2, arg3);
    }

    public int scrollVerticallyBy(int arg1, Recycler arg2, State arg3) {
        this.updateMeasurements();
        this.ensureViewSet();
        return super.scrollVerticallyBy(arg1, arg2, arg3);
    }

    public void setMeasuredDimension(Rect arg5, int arg6, int arg7) {
        int v5;
        if(this.mCachedBorders == null) {
            super.setMeasuredDimension(arg5, arg6, arg7);
        }

        int v0 = this.getPaddingLeft() + this.getPaddingRight();
        int v1 = this.getPaddingTop() + this.getPaddingBottom();
        if(this.mOrientation == 1) {
            v5 = GridLayoutManager.chooseSize(arg7, arg5.height() + v1, this.getMinimumHeight());
            arg6 = GridLayoutManager.chooseSize(arg6, this.mCachedBorders[this.mCachedBorders.length - 1] + v0, this.getMinimumWidth());
        }
        else {
            arg6 = GridLayoutManager.chooseSize(arg6, arg5.width() + v0, this.getMinimumWidth());
            v5 = GridLayoutManager.chooseSize(arg7, this.mCachedBorders[this.mCachedBorders.length - 1] + v1, this.getMinimumHeight());
        }

        this.setMeasuredDimension(arg6, v5);
    }

    public void setSpanCount(int arg3) {
        if(arg3 == this.mSpanCount) {
            return;
        }

        this.mPendingSpanCountChange = true;
        if(arg3 >= 1) {
            this.mSpanCount = arg3;
            this.mSpanSizeLookup.invalidateSpanIndexCache();
            this.requestLayout();
            return;
        }

        throw new IllegalArgumentException("Span count should be at least 1. Provided " + arg3);
    }

    public void setSpanSizeLookup(SpanSizeLookup arg1) {
        this.mSpanSizeLookup = arg1;
    }

    public void setStackFromEnd(boolean arg1) {
        if(!arg1) {
            super.setStackFromEnd(false);
            return;
        }

        throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
    }

    public void setUsingSpansToEstimateScrollbarDimensions(boolean arg1) {
        this.mUsingSpansToEstimateScrollBarDimensions = arg1;
    }

    public boolean supportsPredictiveItemAnimations() {
        if(this.mPendingSavedState == null && !this.mPendingSpanCountChange) {
            return 1;
        }

        return 0;
    }

    private void updateMeasurements() {
        int v1;
        int v0;
        if(this.getOrientation() == 1) {
            v0 = this.getWidth() - this.getPaddingRight();
            v1 = this.getPaddingLeft();
        }
        else {
            v0 = this.getHeight() - this.getPaddingBottom();
            v1 = this.getPaddingTop();
        }

        this.calculateItemBorders(v0 - v1);
    }
}

