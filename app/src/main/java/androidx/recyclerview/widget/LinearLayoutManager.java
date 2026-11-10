package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

public class LinearLayoutManager extends LayoutManager implements ViewDropHandler, ScrollVectorProvider {
    class AnchorInfo {
        int mCoordinate;
        boolean mLayoutFromEnd;
        OrientationHelper mOrientationHelper;
        int mPosition;
        boolean mValid;

        AnchorInfo() {
            super();
            this.reset();
        }

        void assignCoordinateFromPadding() {
            boolean v0 = this.mLayoutFromEnd;
            OrientationHelper v1 = this.mOrientationHelper;
            int v0_1 = v0 ? v1.getEndAfterPadding() : v1.getStartAfterPadding();
            this.mCoordinate = v0_1;
        }

        public void assignFromView(View arg3, int arg4) {
            boolean v0 = this.mLayoutFromEnd;
            OrientationHelper v1 = this.mOrientationHelper;
            this.mCoordinate = v0 ? v1.getDecoratedEnd(arg3) + this.mOrientationHelper.getTotalSpaceChange() : v1.getDecoratedStart(arg3);
            this.mPosition = arg4;
        }

        public void assignFromViewAndKeepVisibleRect(View arg5, int arg6) {
            int v1_1;
            int v0 = this.mOrientationHelper.getTotalSpaceChange();
            if(v0 >= 0) {
                this.assignFromView(arg5, arg6);
                return;
            }

            this.mPosition = arg6;
            boolean v6 = this.mLayoutFromEnd;
            OrientationHelper v1 = this.mOrientationHelper;
            if(v6) {
                arg6 = v1.getEndAfterPadding() - v0 - this.mOrientationHelper.getDecoratedEnd(arg5);
                this.mCoordinate = this.mOrientationHelper.getEndAfterPadding() - arg6;
                if(arg6 > 0) {
                    v1_1 = this.mCoordinate - this.mOrientationHelper.getDecoratedMeasurement(arg5);
                    v0 = this.mOrientationHelper.getStartAfterPadding();
                    v1_1 -= v0 + Math.min(this.mOrientationHelper.getDecoratedStart(arg5) - v0, 0);
                    if(v1_1 < 0) {
                        this.mCoordinate += Math.min(arg6, -v1_1);
                        return;
                    }
                }
            }
            else {
                arg6 = v1.getDecoratedStart(arg5);
                v1_1 = arg6 - this.mOrientationHelper.getStartAfterPadding();
                this.mCoordinate = arg6;
                if(v1_1 > 0) {
                    int v5 = this.mOrientationHelper.getEndAfterPadding() - Math.min(0, this.mOrientationHelper.getEndAfterPadding() - v0 - this.mOrientationHelper.getDecoratedEnd(arg5)) - (arg6 + this.mOrientationHelper.getDecoratedMeasurement(arg5));
                    if(v5 < 0) {
                        this.mCoordinate -= Math.min(v1_1, -v5);
                    }
                }
            }
        }

        boolean isViewValidAsAnchor(View arg1, State arg2) {
            ViewGroup$LayoutParams v0 = arg1.getLayoutParams();
            if(!((LayoutParams)v0).isItemRemoved() && ((LayoutParams)v0).getViewLayoutPosition() >= 0 && ((LayoutParams)v0).getViewLayoutPosition() < arg2.getItemCount()) {
                return 1;
            }

            return 0;
        }

        void reset() {
            this.mPosition = -1;
            this.mCoordinate = 0x80000000;
            this.mLayoutFromEnd = false;
            this.mValid = false;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.mPosition + ", mCoordinate=" + this.mCoordinate + ", mLayoutFromEnd=" + this.mLayoutFromEnd + ", mValid=" + this.mValid + '}';
        }
    }

    public class LayoutChunkResult {
        public int mConsumed;
        public boolean mFinished;
        public boolean mFocusable;
        public boolean mIgnoreConsumed;

        protected LayoutChunkResult() {
            super();
        }

        void resetInternal() {
            this.mConsumed = 0;
            this.mFinished = false;
            this.mIgnoreConsumed = false;
            this.mFocusable = false;
        }
    }

    class LayoutState {
        static final int INVALID_LAYOUT = 0x80000000;
        static final int ITEM_DIRECTION_HEAD = -1;
        static final int ITEM_DIRECTION_TAIL = 1;
        static final int LAYOUT_END = 1;
        static final int LAYOUT_START = -1;
        static final int SCROLLING_OFFSET_NaN = 0x80000000;
        static final String TAG = "LLM#LayoutState";
        int mAvailable;
        int mCurrentPosition;
        int mExtraFillSpace;
        boolean mInfinite;
        boolean mIsPreLayout;
        int mItemDirection;
        int mLastScrollDelta;
        int mLayoutDirection;
        int mNoRecycleSpace;
        int mOffset;
        boolean mRecycle;
        List mScrapList;
        int mScrollingOffset;

        LayoutState() {
            super();
            this.mRecycle = true;
            this.mExtraFillSpace = 0;
            this.mNoRecycleSpace = 0;
            this.mIsPreLayout = false;
            this.mScrapList = null;
        }

        public void assignPositionFromScrapList() {
            this.assignPositionFromScrapList(null);
        }

        public void assignPositionFromScrapList(View arg1) {
            arg1 = this.nextViewInLimitedList(arg1);
            if(arg1 == null) {
                this.mCurrentPosition = -1;
                return;
            }

            this.mCurrentPosition = arg1.getLayoutParams().getViewLayoutPosition();
        }

        boolean hasMore(State arg1) {
            int v0 = this.mCurrentPosition;
            if(v0 >= 0 && v0 < arg1.getItemCount()) {
                return 1;
            }

            return 0;
        }

        void log() {
            Log.d("LLM#LayoutState", "avail:" + this.mAvailable + ", ind:" + this.mCurrentPosition + ", dir:" + this.mItemDirection + ", offset:" + this.mOffset + ", layoutDir:" + this.mLayoutDirection);
        }

        View next(Recycler arg3) {
            if(this.mScrapList != null) {
                return this.nextViewFromScrapList();
            }

            View v3 = arg3.getViewForPosition(this.mCurrentPosition);
            this.mCurrentPosition += this.mItemDirection;
            return v3;
        }

        private View nextViewFromScrapList() {
            int v0 = this.mScrapList.size();
            int v1;
            for(v1 = 0; v1 < v0; ++v1) {
                View v2 = this.mScrapList.get(v1).itemView;
                ViewGroup$LayoutParams v3 = v2.getLayoutParams();
                if(((LayoutParams)v3).isItemRemoved()) {
                }
                else if(this.mCurrentPosition == ((LayoutParams)v3).getViewLayoutPosition()) {
                    this.assignPositionFromScrapList(v2);
                    return v2;
                }
            }

            return null;
        }

        public View nextViewInLimitedList(View arg8) {
            int v0 = this.mScrapList.size();
            View v1 = null;
            int v2 = 0x7FFFFFFF;
            int v3;
            for(v3 = 0; v3 < v0; ++v3) {
                View v4 = this.mScrapList.get(v3).itemView;
                ViewGroup$LayoutParams v5 = v4.getLayoutParams();
                if(v4 != arg8) {
                    if(((LayoutParams)v5).isItemRemoved()) {
                    }
                    else {
                        int v5_1 = (((LayoutParams)v5).getViewLayoutPosition() - this.mCurrentPosition) * this.mItemDirection;
                        if(v5_1 < 0) {
                        }
                        else if(v5_1 < v2) {
                            if(v5_1 == 0) {
                                return v4;
                            }
                            else {
                                v1 = v4;
                                v2 = v5_1;
                            }
                        }
                    }
                }
            }

            return v1;
        }
    }

    public class SavedState implements Parcelable {
        final class androidx.recyclerview.widget.LinearLayoutManager$SavedState$1 implements Parcelable$Creator {
            androidx.recyclerview.widget.LinearLayoutManager$SavedState$1() {
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
        boolean mAnchorLayoutFromEnd;
        int mAnchorOffset;
        int mAnchorPosition;

        static {
            SavedState.CREATOR = new androidx.recyclerview.widget.LinearLayoutManager$SavedState$1();
        }

        public SavedState(SavedState arg2) {
            super();
            this.mAnchorPosition = arg2.mAnchorPosition;
            this.mAnchorOffset = arg2.mAnchorOffset;
            this.mAnchorLayoutFromEnd = arg2.mAnchorLayoutFromEnd;
        }

        public SavedState() {
            super();
        }

        SavedState(Parcel arg2) {
            super();
            this.mAnchorPosition = arg2.readInt();
            this.mAnchorOffset = arg2.readInt();
            boolean v0 = true;
            if(arg2.readInt() == 1) {
            }
            else {
                v0 = false;
            }

            this.mAnchorLayoutFromEnd = v0;
        }

        public int describeContents() {
            return 0;
        }

        boolean hasValidAnchor() {
            if(this.mAnchorPosition >= 0) {
                return 1;
            }

            return 0;
        }

        void invalidateAnchor() {
            this.mAnchorPosition = -1;
        }

        public void writeToParcel(Parcel arg1, int arg2) {
            arg1.writeInt(this.mAnchorPosition);
            arg1.writeInt(this.mAnchorOffset);
            arg1.writeInt(this.mAnchorLayoutFromEnd);
        }
    }

    static final boolean DEBUG = false;
    public static final int HORIZONTAL = 0;
    public static final int INVALID_OFFSET = 0x80000000;
    private static final float MAX_SCROLL_FACTOR = 0.333333f;
    private static final String TAG = "LinearLayoutManager";
    public static final int VERTICAL = 1;
    final AnchorInfo mAnchorInfo;
    private int mInitialPrefetchItemCount;
    private boolean mLastStackFromEnd;
    private final LayoutChunkResult mLayoutChunkResult;
    private LayoutState mLayoutState;
    int mOrientation;
    OrientationHelper mOrientationHelper;
    SavedState mPendingSavedState;
    int mPendingScrollPosition;
    int mPendingScrollPositionOffset;
    private boolean mRecycleChildrenOnDetach;
    private int[] mReusableIntPair;
    private boolean mReverseLayout;
    boolean mShouldReverseLayout;
    private boolean mSmoothScrollbarEnabled;
    private boolean mStackFromEnd;

    public LinearLayoutManager(Context arg3) {
        this(arg3, 1, false);
    }

    public LinearLayoutManager(Context arg2, int arg3, boolean arg4) {
        super();
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = 0x80000000;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new AnchorInfo();
        this.mLayoutChunkResult = new LayoutChunkResult();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        this.setOrientation(arg3);
        this.setReverseLayout(arg4);
    }

    public LinearLayoutManager(Context arg3, AttributeSet arg4, int arg5, int arg6) {
        super();
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = 0x80000000;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new AnchorInfo();
        this.mLayoutChunkResult = new LayoutChunkResult();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        Properties v3 = LinearLayoutManager.getProperties(arg3, arg4, arg5, arg6);
        this.setOrientation(v3.orientation);
        this.setReverseLayout(v3.reverseLayout);
        this.setStackFromEnd(v3.stackFromEnd);
    }

    public void assertNotInLayoutOrScroll(String arg2) {
        if(this.mPendingSavedState == null) {
            super.assertNotInLayoutOrScroll(arg2);
        }
    }

    protected void calculateExtraLayoutSpace(State arg3, int[] arg4) {
        int v2;
        int v3 = this.getExtraLayoutSpace(arg3);
        if(this.mLayoutState.mLayoutDirection == -1) {
            v2 = 0;
        }
        else {
            v2 = v3;
            v3 = 0;
        }

        arg4[0] = v3;
        arg4[1] = v2;
    }

    public boolean canScrollHorizontally() {
        if(this.mOrientation == 0) {
            return 1;
        }

        return 0;
    }

    public boolean canScrollVertically() {
        if(this.mOrientation == 1) {
            return 1;
        }

        return 0;
    }

    public void collectAdjacentPrefetchPositions(int arg2, int arg3, State arg4, LayoutPrefetchRegistry arg5) {
        if(this.mOrientation == 0) {
        }
        else {
            arg2 = arg3;
        }

        if(this.getChildCount() != 0) {
            if(arg2 == 0) {
            }
            else {
                this.ensureLayoutState();
                int v0 = arg2 > 0 ? 1 : -1;
                this.updateLayoutState(v0, Math.abs(arg2), true, arg4);
                this.collectPrefetchPositionsForLayoutState(arg4, this.mLayoutState, arg5);
            }
        }
    }

    public void collectInitialPrefetchPositions(int arg6, LayoutPrefetchRegistry arg7) {
        int v3;
        boolean v0_1;
        SavedState v0 = this.mPendingSavedState;
        int v1 = -1;
        if(v0 == null || !v0.hasValidAnchor()) {
            this.resolveShouldLayoutReverse();
            v0_1 = this.mShouldReverseLayout;
            v3 = this.mPendingScrollPosition;
            if(v3 == v1) {
                v3 = v0_1 ? arg6 - 1 : 0;
            }
        }
        else {
            v0_1 = this.mPendingSavedState.mAnchorLayoutFromEnd;
            v3 = this.mPendingSavedState.mAnchorPosition;
        }

        if(v0_1) {
        }
        else {
            v1 = 1;
        }

        int v0_2;
        for(v0_2 = 0; v0_2 < this.mInitialPrefetchItemCount; ++v0_2) {
            if(v3 < 0) {
                return;
            }

            if(v3 >= arg6) {
                return;
            }

            arg7.addPosition(v3, 0);
            v3 += v1;
        }
    }

    void collectPrefetchPositionsForLayoutState(State arg1, LayoutState arg2, LayoutPrefetchRegistry arg3) {
        int v0 = arg2.mCurrentPosition;
        if(v0 >= 0 && v0 < arg1.getItemCount()) {
            arg3.addPosition(v0, Math.max(0, arg2.mScrollingOffset));
        }
    }

    public int computeHorizontalScrollExtent(State arg1) {
        return this.computeScrollExtent(arg1);
    }

    public int computeHorizontalScrollOffset(State arg1) {
        return this.computeScrollOffset(arg1);
    }

    public int computeHorizontalScrollRange(State arg1) {
        return this.computeScrollRange(arg1);
    }

    private int computeScrollExtent(State arg7) {
        if(this.getChildCount() == 0) {
            return 0;
        }

        this.ensureLayoutState();
        return ScrollbarHelper.computeScrollExtent(arg7, this.mOrientationHelper, this.findFirstVisibleChildClosestToStart(this.mSmoothScrollbarEnabled ^ 1, true), this.findFirstVisibleChildClosestToEnd(this.mSmoothScrollbarEnabled ^ 1, true), this, this.mSmoothScrollbarEnabled);
    }

    private int computeScrollOffset(State arg8) {
        if(this.getChildCount() == 0) {
            return 0;
        }

        this.ensureLayoutState();
        return ScrollbarHelper.computeScrollOffset(arg8, this.mOrientationHelper, this.findFirstVisibleChildClosestToStart(this.mSmoothScrollbarEnabled ^ 1, true), this.findFirstVisibleChildClosestToEnd(this.mSmoothScrollbarEnabled ^ 1, true), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
    }

    private int computeScrollRange(State arg7) {
        if(this.getChildCount() == 0) {
            return 0;
        }

        this.ensureLayoutState();
        return ScrollbarHelper.computeScrollRange(arg7, this.mOrientationHelper, this.findFirstVisibleChildClosestToStart(this.mSmoothScrollbarEnabled ^ 1, true), this.findFirstVisibleChildClosestToEnd(this.mSmoothScrollbarEnabled ^ 1, true), this, this.mSmoothScrollbarEnabled);
    }

    public PointF computeScrollVectorForPosition(int arg4) {
        if(this.getChildCount() == 0) {
            return null;
        }

        boolean v0 = false;
        int v2 = 1;
        if(arg4 < this.getPosition(this.getChildAt(0))) {
            v0 = true;
        }

        if(v0 != this.mShouldReverseLayout) {
            v2 = -1;
        }

        if(this.mOrientation == 0) {
            return new PointF(((float)v2), 0f);
        }

        return new PointF(0f, ((float)v2));
    }

    public int computeVerticalScrollExtent(State arg1) {
        return this.computeScrollExtent(arg1);
    }

    public int computeVerticalScrollOffset(State arg1) {
        return this.computeScrollOffset(arg1);
    }

    public int computeVerticalScrollRange(State arg1) {
        return this.computeScrollRange(arg1);
    }

    int convertFocusDirectionToLayoutDirection(int arg5) {
        int v0 = -1;
        if(arg5 != 1) {
            if(arg5 != 2) {
                int v3 = 0x80000000;
                if(arg5 != 17) {
                    if(arg5 != 33) {
                        if(arg5 != 66) {
                            if(arg5 != 130) {
                                return v3;
                            }

                            if(this.mOrientation == 1) {
                                return 1;
                            }

                            return v3;
                        }

                        if(this.mOrientation == 0) {
                            return 1;
                        }

                        return v3;
                    }

                    if(this.mOrientation == 1) {
                        return v0;
                    }

                    return v3;
                }

                if(this.mOrientation == 0) {
                    return v0;
                }

                return v3;
            }

            if(this.mOrientation == 1) {
                return 1;
            }

            if(this.isLayoutRTL()) {
                return v0;
            }

            return 1;
        }

        if(this.mOrientation == 1) {
            return v0;
        }

        if(this.isLayoutRTL()) {
            return 1;
        }

        return v0;
    }

    LayoutState createLayoutState() {
        return new LayoutState();
    }

    void ensureLayoutState() {
        if(this.mLayoutState == null) {
            this.mLayoutState = this.createLayoutState();
        }
    }

    int fill(Recycler arg8, LayoutState arg9, State arg10, boolean arg11) {
        int v0 = arg9.mAvailable;
        int v2 = 0x80000000;
        if(arg9.mScrollingOffset != v2) {
            if(arg9.mAvailable < 0) {
                arg9.mScrollingOffset += arg9.mAvailable;
            }

            this.recycleByLayoutState(arg8, arg9);
        }

        int v1 = arg9.mAvailable + arg9.mExtraFillSpace;
        LayoutChunkResult v3 = this.mLayoutChunkResult;
        do {
            if(!arg9.mInfinite && v1 <= 0) {
                break;
            }

            if(!arg9.hasMore(arg10)) {
                break;
            }

            v3.resetInternal();
            this.layoutChunk(arg8, arg10, arg9, v3);
            if(v3.mFinished) {
            }
            else {
                arg9.mOffset += v3.mConsumed * arg9.mLayoutDirection;
                if(!v3.mIgnoreConsumed || arg9.mScrapList != null || !arg10.isPreLayout()) {
                    arg9.mAvailable -= v3.mConsumed;
                    v1 -= v3.mConsumed;
                }

                if(arg9.mScrollingOffset != v2) {
                    arg9.mScrollingOffset += v3.mConsumed;
                    if(arg9.mAvailable < 0) {
                        arg9.mScrollingOffset += arg9.mAvailable;
                    }

                    this.recycleByLayoutState(arg8, arg9);
                }

                if(!arg11) {
                    continue;
                }

                if(!v3.mFocusable) {
                    continue;
                }
            }

            break;
        }
        while(true);

        return v0 - arg9.mAvailable;
    }

    public int findFirstCompletelyVisibleItemPosition() {
        View v0 = this.findOneVisibleChild(0, this.getChildCount(), true, false);
        if(v0 == null) {
            return -1;
        }

        return this.getPosition(v0);
    }

    private View findFirstPartiallyOrCompletelyInvisibleChild() {
        return this.findOnePartiallyOrCompletelyInvisibleChild(0, this.getChildCount());
    }

    private View findFirstReferenceChild(Recycler arg7, State arg8) {
        return this.findReferenceChild(arg7, arg8, 0, this.getChildCount(), arg8.getItemCount());
    }

    View findFirstVisibleChildClosestToEnd(boolean arg3, boolean arg4) {
        if(this.mShouldReverseLayout) {
            return this.findOneVisibleChild(0, this.getChildCount(), arg3, arg4);
        }

        return this.findOneVisibleChild(this.getChildCount() - 1, -1, arg3, arg4);
    }

    View findFirstVisibleChildClosestToStart(boolean arg3, boolean arg4) {
        if(this.mShouldReverseLayout) {
            return this.findOneVisibleChild(this.getChildCount() - 1, -1, arg3, arg4);
        }

        return this.findOneVisibleChild(0, this.getChildCount(), arg3, arg4);
    }

    public int findFirstVisibleItemPosition() {
        View v0 = this.findOneVisibleChild(0, this.getChildCount(), false, true);
        if(v0 == null) {
            return -1;
        }

        return this.getPosition(v0);
    }

    public int findLastCompletelyVisibleItemPosition() {
        int v3 = -1;
        View v0 = this.findOneVisibleChild(this.getChildCount() - 1, v3, true, false);
        if(v0 == null) {
            return v3;
        }

        return this.getPosition(v0);
    }

    private View findLastPartiallyOrCompletelyInvisibleChild() {
        return this.findOnePartiallyOrCompletelyInvisibleChild(this.getChildCount() - 1, -1);
    }

    private View findLastReferenceChild(Recycler arg8, State arg9) {
        return this.findReferenceChild(arg8, arg9, this.getChildCount() - 1, -1, arg9.getItemCount());
    }

    public int findLastVisibleItemPosition() {
        int v3 = -1;
        View v0 = this.findOneVisibleChild(this.getChildCount() - 1, v3, false, true);
        if(v0 == null) {
            return v3;
        }

        return this.getPosition(v0);
    }

    View findOnePartiallyOrCompletelyInvisibleChild(int arg4, int arg5) {
        int v1;
        int v0;
        this.ensureLayoutState();
        if(arg5 > arg4) {
        }
        else {
            if(arg5 < arg4) {
                goto label_4;
            }

            goto label_23;
        }

    label_4:
        if(this.mOrientationHelper.getDecoratedStart(this.getChildAt(arg4)) < this.mOrientationHelper.getStartAfterPadding()) {
            v0 = 0x4104;
            v1 = 0x4004;
        }
        else {
            v0 = 0x1041;
            v1 = 0x1001;
        }

        if(this.mOrientation == 0) {
            return this.mHorizontalBoundCheck.findOneViewWithinBoundFlags(arg4, arg5, v0, v1);
        }

        return this.mVerticalBoundCheck.findOneViewWithinBoundFlags(arg4, arg5, v0, v1);
    label_23:
        return this.getChildAt(arg4);
    }

    View findOneVisibleChild(int arg2, int arg3, boolean arg4, boolean arg5) {
        this.ensureLayoutState();
        int v0 = 320;
        int v4 = arg4 ? 0x6003 : v0;
        if(arg5) {
        }
        else {
            v0 = 0;
        }

        if(this.mOrientation == 0) {
            return this.mHorizontalBoundCheck.findOneViewWithinBoundFlags(arg2, arg3, v4, v0);
        }

        return this.mVerticalBoundCheck.findOneViewWithinBoundFlags(arg2, arg3, v4, v0);
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToEnd() {
        if(this.mShouldReverseLayout) {
            return this.findFirstPartiallyOrCompletelyInvisibleChild();
        }

        return this.findLastPartiallyOrCompletelyInvisibleChild();
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToStart() {
        if(this.mShouldReverseLayout) {
            return this.findLastPartiallyOrCompletelyInvisibleChild();
        }

        return this.findFirstPartiallyOrCompletelyInvisibleChild();
    }

    View findReferenceChild(Recycler arg6, State arg7, int arg8, int arg9, int arg10) {
        this.ensureLayoutState();
        int v6 = this.mOrientationHelper.getStartAfterPadding();
        int v7 = this.mOrientationHelper.getEndAfterPadding();
        int v0 = arg9 > arg8 ? 1 : -1;
        View v1 = null;
        View v2 = v1;
        while(arg8 != arg9) {
            View v3 = this.getChildAt(arg8);
            int v4 = this.getPosition(v3);
            if(v4 >= 0 && v4 < arg10) {
                if(!v3.getLayoutParams().isItemRemoved()) {
                    if(this.mOrientationHelper.getDecoratedStart(v3) < v7) {
                        if(this.mOrientationHelper.getDecoratedEnd(v3) < v6) {
                        }
                        else {
                            return v3;
                        }
                    }

                    if(v1 != null) {
                        goto label_32;
                    }

                    v1 = v3;
                }
                else if(v2 == null) {
                    v2 = v3;
                }
            }

        label_32:
            arg8 += v0;
        }

        if(v1 != null) {
            return v1;
        }

        return v2;
    }

    private View findReferenceChildClosestToEnd(Recycler arg2, State arg3) {
        if(this.mShouldReverseLayout) {
            return this.findFirstReferenceChild(arg2, arg3);
        }

        return this.findLastReferenceChild(arg2, arg3);
    }

    private View findReferenceChildClosestToStart(Recycler arg2, State arg3) {
        if(this.mShouldReverseLayout) {
            return this.findLastReferenceChild(arg2, arg3);
        }

        return this.findFirstReferenceChild(arg2, arg3);
    }

    public View findViewByPosition(int arg3) {
        int v0 = this.getChildCount();
        if(v0 == 0) {
            return null;
        }

        int v1 = arg3 - this.getPosition(this.getChildAt(0));
        if(v1 >= 0 && v1 < v0) {
            View v0_1 = this.getChildAt(v1);
            if(this.getPosition(v0_1) == arg3) {
                return v0_1;
            }
        }

        return super.findViewByPosition(arg3);
    }

    private int fixLayoutEndGap(int arg2, Recycler arg3, State arg4, boolean arg5) {
        int v0 = this.mOrientationHelper.getEndAfterPadding() - arg2;
        if(v0 > 0) {
            int v3 = -this.scrollBy(-v0, arg3, arg4);
            arg2 += v3;
            if(arg5) {
                int v4 = this.mOrientationHelper.getEndAfterPadding() - arg2;
                if(v4 > 0) {
                    this.mOrientationHelper.offsetChildren(v4);
                    return v4 + v3;
                }
            }

            return v3;
        }

        return 0;
    }

    private int fixLayoutStartGap(int arg2, Recycler arg3, State arg4, boolean arg5) {
        int v0 = arg2 - this.mOrientationHelper.getStartAfterPadding();
        if(v0 > 0) {
            int v3 = -this.scrollBy(v0, arg3, arg4);
            arg2 += v3;
            if(arg5) {
                arg2 -= this.mOrientationHelper.getStartAfterPadding();
                if(arg2 > 0) {
                    this.mOrientationHelper.offsetChildren(-arg2);
                    v3 -= arg2;
                }
            }

            return v3;
        }

        return 0;
    }

    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    private View getChildClosestToEnd() {
        int v0 = this.mShouldReverseLayout ? 0 : this.getChildCount() - 1;
        return this.getChildAt(v0);
    }

    private View getChildClosestToStart() {
        int v0 = this.mShouldReverseLayout ? this.getChildCount() - 1 : 0;
        return this.getChildAt(v0);
    }

    @Deprecated protected int getExtraLayoutSpace(State arg1) {
        if(arg1.hasTargetScrollPosition()) {
            return this.mOrientationHelper.getTotalSpace();
        }

        return 0;
    }

    public int getInitialPrefetchItemCount() {
        return this.mInitialPrefetchItemCount;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public boolean getRecycleChildrenOnDetach() {
        return this.mRecycleChildrenOnDetach;
    }

    public boolean getReverseLayout() {
        return this.mReverseLayout;
    }

    public boolean getStackFromEnd() {
        return this.mStackFromEnd;
    }

    public boolean isAutoMeasureEnabled() {
        return 1;
    }

    protected boolean isLayoutRTL() {
        if(this.getLayoutDirection() == 1) {
            return 1;
        }

        return 0;
    }

    public boolean isSmoothScrollbarEnabled() {
        return this.mSmoothScrollbarEnabled;
    }

    void layoutChunk(Recycler arg7, State arg8, LayoutState arg9, LayoutChunkResult arg10) {
        LinearLayoutManager v0_3;
        int v5;
        int v4;
        int v2_1;
        int v0_2;
        boolean v0_1;
        View v1 = arg9.next(arg7);
        if(v1 == null) {
            arg10.mFinished = true;
            return;
        }

        ViewGroup$LayoutParams v8 = v1.getLayoutParams();
        List v0 = arg9.mScrapList;
        boolean v2 = this.mShouldReverseLayout;
        int v3 = -1;
        if(v0 == null) {
            v0_1 = arg9.mLayoutDirection == v3 ? true : false;
            if(v2 == v0_1) {
                this.addView(v1);
                goto label_30;
            }

            this.addView(v1, 0);
        }
        else {
            v0_1 = arg9.mLayoutDirection == v3 ? true : false;
            if(v2 == v0_1) {
                this.addDisappearingView(v1);
                goto label_30;
            }

            this.addDisappearingView(v1, 0);
        }

    label_30:
        this.measureChildWithMargins(v1, 0, 0);
        arg10.mConsumed = this.mOrientationHelper.getDecoratedMeasurement(v1);
        if(this.mOrientation == 1) {
            if(this.isLayoutRTL()) {
                v0_2 = this.getWidth() - this.getPaddingRight();
                v2_1 = v0_2 - this.mOrientationHelper.getDecoratedMeasurementInOther(v1);
            }
            else {
                v2_1 = this.getPaddingLeft();
                v0_2 = this.mOrientationHelper.getDecoratedMeasurementInOther(v1) + v2_1;
            }

            if(arg9.mLayoutDirection == v3) {
                v4 = v0_2;
                v5 = arg9.mOffset;
                v0_3 = this;
                v3 = arg9.mOffset - arg10.mConsumed;
                goto label_90;
            }

            v3 = arg9.mOffset;
            v5 = arg9.mOffset + arg10.mConsumed;
            v4 = v0_2;
            goto label_89;
        }
        else {
            v0_2 = this.getPaddingTop();
            v2_1 = this.mOrientationHelper.getDecoratedMeasurementInOther(v1) + v0_2;
            if(arg9.mLayoutDirection == v3) {
                v5 = v2_1;
                v4 = arg9.mOffset;
                v2_1 = arg9.mOffset - arg10.mConsumed;
            }
            else {
                v3 = arg9.mOffset;
                v4 = arg9.mOffset + arg10.mConsumed;
                v5 = v2_1;
                v2_1 = v3;
            }

            v3 = v0_2;
        label_89:
            v0_3 = this;
        }

    label_90:
        v0_3.layoutDecoratedWithMargins(v1, v2_1, v3, v4, v5);
        if((((LayoutParams)v8).isItemRemoved()) || (((LayoutParams)v8).isItemChanged())) {
            arg10.mIgnoreConsumed = true;
        }

        arg10.mFocusable = v1.hasFocusable();
    }

    private void layoutForPredictiveAnimations(Recycler arg12, State arg13, int arg14, int arg15) {
        if((arg13.willRunPredictiveAnimations()) && this.getChildCount() != 0 && !arg13.isPreLayout()) {
            if(!this.supportsPredictiveItemAnimations()) {
            }
            else {
                List v0 = arg12.getScrapList();
                int v1 = v0.size();
                int v3 = this.getPosition(this.getChildAt(0));
                int v4 = 0;
                int v5 = 0;
                int v6 = 0;
                while(v4 < v1) {
                    Object v7 = v0.get(v4);
                    if(((ViewHolder)v7).isRemoved()) {
                    }
                    else {
                        boolean v8 = ((ViewHolder)v7).getLayoutPosition() < v3 ? true : false;
                        boolean v9 = this.mShouldReverseLayout;
                        OrientationHelper v10 = this.mOrientationHelper;
                        if(v8 != v9) {
                            v5 += v10.getDecoratedMeasurement(((ViewHolder)v7).itemView);
                            goto label_37;
                        }

                        v6 += v10.getDecoratedMeasurement(((ViewHolder)v7).itemView);
                    }

                label_37:
                    ++v4;
                }

                this.mLayoutState.mScrapList = v0;
                if(v5 > 0) {
                    this.updateLayoutStateToFillStart(this.getPosition(this.getChildClosestToStart()), arg14);
                    this.mLayoutState.mExtraFillSpace = v5;
                    this.mLayoutState.mAvailable = 0;
                    this.mLayoutState.assignPositionFromScrapList();
                    this.fill(arg12, this.mLayoutState, arg13, false);
                }

                if(v6 > 0) {
                    this.updateLayoutStateToFillEnd(this.getPosition(this.getChildClosestToEnd()), arg15);
                    this.mLayoutState.mExtraFillSpace = v6;
                    this.mLayoutState.mAvailable = 0;
                    this.mLayoutState.assignPositionFromScrapList();
                    this.fill(arg12, this.mLayoutState, arg13, false);
                }

                this.mLayoutState.mScrapList = null;
            }
        }
    }

    private void logChildren() {
        String v1 = "LinearLayoutManager";
        Log.d(v1, "internal representation of views on the screen");
        int v0;
        for(v0 = 0; v0 < this.getChildCount(); ++v0) {
            View v2 = this.getChildAt(v0);
            Log.d(v1, "item " + this.getPosition(v2) + ", coord:" + this.mOrientationHelper.getDecoratedStart(v2));
        }

        Log.d(v1, "==============");
    }

    void onAnchorReady(Recycler arg1, State arg2, AnchorInfo arg3, int arg4) {
    }

    public void onDetachedFromWindow(RecyclerView arg1, Recycler arg2) {
        super.onDetachedFromWindow(arg1, arg2);
        if(this.mRecycleChildrenOnDetach) {
            this.removeAndRecycleAllViews(arg2);
            arg2.clear();
        }
    }

    public View onFocusSearchFailed(View arg4, int arg5, Recycler arg6, State arg7) {
        this.resolveShouldLayoutReverse();
        View v0 = null;
        if(this.getChildCount() == 0) {
            return v0;
        }

        int v4 = this.convertFocusDirectionToLayoutDirection(arg5);
        arg5 = 0x80000000;
        if(v4 == arg5) {
            return v0;
        }

        this.ensureLayoutState();
        this.updateLayoutState(v4, ((int)((((float)this.mOrientationHelper.getTotalSpace())) * 0.333333f)), false, arg7);
        this.mLayoutState.mScrollingOffset = arg5;
        this.mLayoutState.mRecycle = false;
        this.fill(arg6, this.mLayoutState, arg7, true);
        arg5 = -1;
        View v6 = v4 == arg5 ? this.findPartiallyOrCompletelyInvisibleChildClosestToStart() : this.findPartiallyOrCompletelyInvisibleChildClosestToEnd();
        View v3 = v4 == arg5 ? this.getChildClosestToStart() : this.getChildClosestToEnd();
        if(v3.hasFocusable()) {
            if(v6 == null) {
                return v0;
            }

            return v3;
        }

        return v6;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent arg2) {
        super.onInitializeAccessibilityEvent(arg2);
        if(this.getChildCount() > 0) {
            arg2.setFromIndex(this.findFirstVisibleItemPosition());
            arg2.setToIndex(this.findLastVisibleItemPosition());
        }
    }

    public void onLayoutChildren(Recycler arg9, State arg10) {
        int v6_1;
        boolean v6;
        int v5;
        int v1 = -1;
        if((this.mPendingSavedState != null || this.mPendingScrollPosition != v1) && arg10.getItemCount() == 0) {
            this.removeAndRecycleAllViews(arg9);
            return;
        }

        SavedState v0 = this.mPendingSavedState;
        if(v0 != null && (v0.hasValidAnchor())) {
            this.mPendingScrollPosition = this.mPendingSavedState.mAnchorPosition;
        }

        this.ensureLayoutState();
        this.mLayoutState.mRecycle = false;
        this.resolveShouldLayoutReverse();
        View v0_1 = this.getFocusedChild();
        if(!this.mAnchorInfo.mValid || this.mPendingScrollPosition != v1 || this.mPendingSavedState != null) {
            this.mAnchorInfo.reset();
            this.mAnchorInfo.mLayoutFromEnd = this.mShouldReverseLayout ^ this.mStackFromEnd;
            this.updateAnchorInfoForLayout(arg9, arg10, this.mAnchorInfo);
            this.mAnchorInfo.mValid = true;
        }
        else if(v0_1 != null) {
            if(this.mOrientationHelper.getDecoratedStart(v0_1) < this.mOrientationHelper.getEndAfterPadding() && this.mOrientationHelper.getDecoratedEnd(v0_1) > this.mOrientationHelper.getStartAfterPadding()) {
                goto label_57;
            }

            this.mAnchorInfo.assignFromViewAndKeepVisibleRect(v0_1, this.getPosition(v0_1));
        }

    label_57:
        LayoutState v0_2 = this.mLayoutState;
        int v3 = v0_2.mLastScrollDelta >= 0 ? 1 : v1;
        v0_2.mLayoutDirection = v3;
        int[] v0_3 = this.mReusableIntPair;
        v0_3[0] = 0;
        v0_3[1] = 0;
        this.calculateExtraLayoutSpace(arg10, v0_3);
        int v0_4 = Math.max(0, this.mReusableIntPair[0]) + this.mOrientationHelper.getStartAfterPadding();
        v3 = Math.max(0, this.mReusableIntPair[1]) + this.mOrientationHelper.getEndPadding();
        if(arg10.isPreLayout()) {
            v5 = this.mPendingScrollPosition;
            if(v5 != v1 && this.mPendingScrollPositionOffset != 0x80000000) {
                View v5_1 = this.findViewByPosition(v5);
                if(v5_1 != null) {
                    v6 = this.mShouldReverseLayout;
                    OrientationHelper v7 = this.mOrientationHelper;
                    if(v6) {
                        v6_1 = v7.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(v5_1);
                        v5 = this.mPendingScrollPositionOffset;
                    }
                    else {
                        v5 = v7.getDecoratedStart(v5_1) - this.mOrientationHelper.getStartAfterPadding();
                        v6_1 = this.mPendingScrollPositionOffset;
                    }

                    v6_1 -= v5;
                    if(v6_1 > 0) {
                        v0_4 += v6_1;
                        goto label_108;
                    }

                    v3 -= v6_1;
                }
            }
        }

    label_108:
        boolean v5_2 = this.mAnchorInfo.mLayoutFromEnd;
        v6 = this.mShouldReverseLayout;
        if(v5_2) {
            if(!v6) {
                goto label_116;
            }

            goto label_113;
        }
        else if(!v6) {
        label_113:
            v1 = 1;
        }

    label_116:
        this.onAnchorReady(arg9, arg10, this.mAnchorInfo, v1);
        this.detachAndScrapAttachedViews(arg9);
        this.mLayoutState.mInfinite = this.resolveIsInfinite();
        this.mLayoutState.mIsPreLayout = arg10.isPreLayout();
        this.mLayoutState.mNoRecycleSpace = 0;
        boolean v1_1 = this.mAnchorInfo.mLayoutFromEnd;
        AnchorInfo v5_3 = this.mAnchorInfo;
        if(v1_1) {
            this.updateLayoutStateToFillStart(v5_3);
            this.mLayoutState.mExtraFillSpace = v0_4;
            this.fill(arg9, this.mLayoutState, arg10, false);
            v0_4 = this.mLayoutState.mOffset;
            v1 = this.mLayoutState.mCurrentPosition;
            if(this.mLayoutState.mAvailable > 0) {
                v3 += this.mLayoutState.mAvailable;
            }

            this.updateLayoutStateToFillEnd(this.mAnchorInfo);
            this.mLayoutState.mExtraFillSpace = v3;
            this.mLayoutState.mCurrentPosition += this.mLayoutState.mItemDirection;
            this.fill(arg9, this.mLayoutState, arg10, false);
            v3 = this.mLayoutState.mOffset;
            if(this.mLayoutState.mAvailable <= 0) {
                goto label_214;
            }

            v5 = this.mLayoutState.mAvailable;
            this.updateLayoutStateToFillStart(v1, v0_4);
            this.mLayoutState.mExtraFillSpace = v5;
            this.fill(arg9, this.mLayoutState, arg10, false);
            v0_4 = this.mLayoutState.mOffset;
        }
        else {
            this.updateLayoutStateToFillEnd(v5_3);
            this.mLayoutState.mExtraFillSpace = v3;
            this.fill(arg9, this.mLayoutState, arg10, false);
            v3 = this.mLayoutState.mOffset;
            v1 = this.mLayoutState.mCurrentPosition;
            if(this.mLayoutState.mAvailable > 0) {
                v0_4 += this.mLayoutState.mAvailable;
            }

            this.updateLayoutStateToFillStart(this.mAnchorInfo);
            this.mLayoutState.mExtraFillSpace = v0_4;
            this.mLayoutState.mCurrentPosition += this.mLayoutState.mItemDirection;
            this.fill(arg9, this.mLayoutState, arg10, false);
            v0_4 = this.mLayoutState.mOffset;
            if(this.mLayoutState.mAvailable <= 0) {
                goto label_214;
            }

            v5 = this.mLayoutState.mAvailable;
            this.updateLayoutStateToFillEnd(v1, v3);
            this.mLayoutState.mExtraFillSpace = v5;
            this.fill(arg9, this.mLayoutState, arg10, false);
            v3 = this.mLayoutState.mOffset;
        }

    label_214:
        if(this.getChildCount() > 0) {
            if((this.mShouldReverseLayout ^ this.mStackFromEnd) != 0) {
                v1 = this.fixLayoutEndGap(v3, arg9, arg10, true);
                v0_4 += v1;
                v3 += v1;
                v1 = this.fixLayoutStartGap(v0_4, arg9, arg10, false);
            }
            else {
                v1 = this.fixLayoutStartGap(v0_4, arg9, arg10, true);
                v0_4 += v1;
                v3 += v1;
                v1 = this.fixLayoutEndGap(v3, arg9, arg10, false);
            }

            v0_4 += v1;
            v3 += v1;
        }

        this.layoutForPredictiveAnimations(arg9, arg10, v0_4, v3);
        if(!arg10.isPreLayout()) {
            this.mOrientationHelper.onLayoutComplete();
        }
        else {
            this.mAnchorInfo.reset();
        }

        this.mLastStackFromEnd = this.mStackFromEnd;
    }

    public void onLayoutCompleted(State arg1) {
        super.onLayoutCompleted(arg1);
        this.mPendingSavedState = null;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = 0x80000000;
        this.mAnchorInfo.reset();
    }

    public void onRestoreInstanceState(Parcelable arg2) {
        if((arg2 instanceof SavedState)) {
            this.mPendingSavedState = ((SavedState)arg2);
            this.requestLayout();
        }
    }

    public Parcelable onSaveInstanceState() {
        View v1_1;
        if(this.mPendingSavedState != null) {
            return new SavedState(this.mPendingSavedState);
        }

        SavedState v0 = new SavedState();
        if(this.getChildCount() > 0) {
            this.ensureLayoutState();
            int v1 = this.mLastStackFromEnd ^ this.mShouldReverseLayout;
            v0.mAnchorLayoutFromEnd = ((boolean)v1);
            if(v1 != 0) {
                v1_1 = this.getChildClosestToEnd();
                v0.mAnchorOffset = this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(v1_1);
                v0.mAnchorPosition = this.getPosition(v1_1);
                return ((Parcelable)v0);
            }

            v1_1 = this.getChildClosestToStart();
            v0.mAnchorPosition = this.getPosition(v1_1);
            v0.mAnchorOffset = this.mOrientationHelper.getDecoratedStart(v1_1) - this.mOrientationHelper.getStartAfterPadding();
            return ((Parcelable)v0);
        }

        v0.invalidateAnchor();
        return ((Parcelable)v0);
    }

    public void prepareForDrop(View arg4, View arg5, int arg6, int arg7) {
        this.assertNotInLayoutOrScroll("Cannot drop a view during a scroll or layout calculation");
        this.ensureLayoutState();
        this.resolveShouldLayoutReverse();
        arg6 = this.getPosition(arg4);
        arg7 = this.getPosition(arg5);
        int v1 = -1;
        arg6 = arg6 < arg7 ? 1 : v1;
        if(this.mShouldReverseLayout) {
            OrientationHelper v1_1 = this.mOrientationHelper;
            if(arg6 == 1) {
                this.scrollToPositionWithOffset(arg7, v1_1.getEndAfterPadding() - (this.mOrientationHelper.getDecoratedStart(arg5) + this.mOrientationHelper.getDecoratedMeasurement(arg4)));
                return;
            }

            this.scrollToPositionWithOffset(arg7, v1_1.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(arg5));
            return;
        }

        OrientationHelper v0 = this.mOrientationHelper;
        if(arg6 == v1) {
            this.scrollToPositionWithOffset(arg7, v0.getDecoratedStart(arg5));
            return;
        }

        this.scrollToPositionWithOffset(arg7, v0.getDecoratedEnd(arg5) - this.mOrientationHelper.getDecoratedMeasurement(arg4));
    }

    private void recycleByLayoutState(Recycler arg4, LayoutState arg5) {
        if(arg5.mRecycle) {
            if(arg5.mInfinite) {
            }
            else {
                int v0 = arg5.mScrollingOffset;
                int v1 = arg5.mNoRecycleSpace;
                if(arg5.mLayoutDirection == -1) {
                    this.recycleViewsFromEnd(arg4, v0, v1);
                    return;
                }
                else {
                    this.recycleViewsFromStart(arg4, v0, v1);
                }
            }
        }
    }

    private void recycleChildren(Recycler arg1, int arg2, int arg3) {
        if(arg2 == arg3) {
        }
        else {
            if(arg3 > arg2) {
                --arg3;
                while(true) {
                    if(arg3 >= arg2) {
                        this.removeAndRecycleViewAt(arg3, arg1);
                        --arg3;
                        continue;
                    }
                    else {
                        return;
                    }
                }
            }

            while(arg2 > arg3) {
                this.removeAndRecycleViewAt(arg2, arg1);
                --arg2;
            }
        }
    }

    private void recycleViewsFromEnd(Recycler arg5, int arg6, int arg7) {
        int v0 = this.getChildCount();
        if(arg6 < 0) {
        }
        else {
            int v1 = this.mOrientationHelper.getEnd() - arg6 + arg7;
            if(this.mShouldReverseLayout) {
                arg7 = 0;
                while(true) {
                    if(arg7 < v0) {
                        View v2 = this.getChildAt(arg7);
                        if(this.mOrientationHelper.getDecoratedStart(v2) >= v1) {
                            if(this.mOrientationHelper.getTransformedStartWithDecoration(v2) < v1) {
                            }
                            else {
                                ++arg7;
                                continue;
                            }
                        }

                        break;
                    }

                    return;
                }

                this.recycleChildren(arg5, 0, arg7);
                return;
            }
            else {
                --v0;
                arg6 = v0;
                while(true) {
                    if(arg6 < 0) {
                        return;
                    }

                    View v7 = this.getChildAt(arg6);
                    if(this.mOrientationHelper.getDecoratedStart(v7) >= v1) {
                        if(this.mOrientationHelper.getTransformedStartWithDecoration(v7) < v1) {
                        }
                        else {
                            --arg6;
                            continue;
                        }
                    }

                    break;
                }

                this.recycleChildren(arg5, v0, arg6);
            }
        }
    }

    private void recycleViewsFromStart(Recycler arg5, int arg6, int arg7) {
        if(arg6 < 0) {
        }
        else {
            arg6 -= arg7;
            arg7 = this.getChildCount();
            if(this.mShouldReverseLayout) {
                --arg7;
                int v0 = arg7;
                while(true) {
                    if(v0 >= 0) {
                        View v1 = this.getChildAt(v0);
                        if(this.mOrientationHelper.getDecoratedEnd(v1) <= arg6) {
                            if(this.mOrientationHelper.getTransformedEndWithDecoration(v1) > arg6) {
                            }
                            else {
                                --v0;
                                continue;
                            }
                        }

                        break;
                    }

                    return;
                }

                this.recycleChildren(arg5, arg7, v0);
                return;
            }
            else {
                int v1_1 = 0;
                while(true) {
                    if(v1_1 >= arg7) {
                        return;
                    }

                    View v2 = this.getChildAt(v1_1);
                    if(this.mOrientationHelper.getDecoratedEnd(v2) <= arg6) {
                        if(this.mOrientationHelper.getTransformedEndWithDecoration(v2) > arg6) {
                        }
                        else {
                            ++v1_1;
                            continue;
                        }
                    }

                    break;
                }

                this.recycleChildren(arg5, 0, v1_1);
            }
        }
    }

    boolean resolveIsInfinite() {
        if(this.mOrientationHelper.getMode() == 0 && this.mOrientationHelper.getEnd() == 0) {
            return 1;
        }

        return 0;
    }

    private void resolveShouldLayoutReverse() {
        if(this.mOrientation != 1) {
            if(!this.isLayoutRTL()) {
            }
            else {
                this.mShouldReverseLayout = this.mReverseLayout ^ 1;
                return;
            }
        }

        this.mShouldReverseLayout = this.mReverseLayout;
    }

    int scrollBy(int arg6, Recycler arg7, State arg8) {
        if(this.getChildCount() != 0) {
            if(arg6 == 0) {
            }
            else {
                this.ensureLayoutState();
                this.mLayoutState.mRecycle = true;
                int v0 = arg6 > 0 ? 1 : -1;
                int v3 = Math.abs(arg6);
                this.updateLayoutState(v0, v3, true, arg8);
                int v2 = this.mLayoutState.mScrollingOffset + this.fill(arg7, this.mLayoutState, arg8, false);
                if(v2 < 0) {
                    return 0;
                }

                if(v3 > v2) {
                    arg6 = v0 * v2;
                }

                this.mOrientationHelper.offsetChildren(-arg6);
                this.mLayoutState.mLastScrollDelta = arg6;
                return arg6;
            }
        }

        return 0;
    }

    public int scrollHorizontallyBy(int arg3, Recycler arg4, State arg5) {
        if(this.mOrientation == 1) {
            return 0;
        }

        return this.scrollBy(arg3, arg4, arg5);
    }

    public void scrollToPosition(int arg1) {
        this.mPendingScrollPosition = arg1;
        this.mPendingScrollPositionOffset = 0x80000000;
        SavedState v1 = this.mPendingSavedState;
        if(v1 != null) {
            v1.invalidateAnchor();
        }

        this.requestLayout();
    }

    public void scrollToPositionWithOffset(int arg1, int arg2) {
        this.mPendingScrollPosition = arg1;
        this.mPendingScrollPositionOffset = arg2;
        SavedState v1 = this.mPendingSavedState;
        if(v1 != null) {
            v1.invalidateAnchor();
        }

        this.requestLayout();
    }

    public int scrollVerticallyBy(int arg2, Recycler arg3, State arg4) {
        if(this.mOrientation == 0) {
            return 0;
        }

        return this.scrollBy(arg2, arg3, arg4);
    }

    public void setInitialPrefetchItemCount(int arg1) {
        this.mInitialPrefetchItemCount = arg1;
    }

    public void setOrientation(int arg3) {
        if(arg3 != 0) {
            if(arg3 == 1) {
            }
            else {
                throw new IllegalArgumentException("invalid orientation:" + arg3);
            }
        }

        this.assertNotInLayoutOrScroll(null);
        if(arg3 == this.mOrientation) {
            if(this.mOrientationHelper == null) {
            }
            else {
                return;
            }
        }

        OrientationHelper v0 = OrientationHelper.createOrientationHelper(((LayoutManager)this), arg3);
        this.mOrientationHelper = v0;
        this.mAnchorInfo.mOrientationHelper = v0;
        this.mOrientation = arg3;
        this.requestLayout();
    }

    public void setRecycleChildrenOnDetach(boolean arg1) {
        this.mRecycleChildrenOnDetach = arg1;
    }

    public void setReverseLayout(boolean arg2) {
        this.assertNotInLayoutOrScroll(null);
        if(arg2 == this.mReverseLayout) {
            return;
        }

        this.mReverseLayout = arg2;
        this.requestLayout();
    }

    public void setSmoothScrollbarEnabled(boolean arg1) {
        this.mSmoothScrollbarEnabled = arg1;
    }

    public void setStackFromEnd(boolean arg2) {
        this.assertNotInLayoutOrScroll(null);
        if(this.mStackFromEnd == arg2) {
            return;
        }

        this.mStackFromEnd = arg2;
        this.requestLayout();
    }

    boolean shouldMeasureTwice() {
        int v1 = 0x40000000;
        if(this.getHeightMode() != v1 && this.getWidthMode() != v1 && (this.hasFlexibleChildInBothOrientations())) {
            return 1;
        }

        return 0;
    }

    public void smoothScrollToPosition(RecyclerView arg1, State arg2, int arg3) {
        LinearSmoothScroller v2 = new LinearSmoothScroller(arg1.getContext());
        v2.setTargetPosition(arg3);
        this.startSmoothScroll(((SmoothScroller)v2));
    }

    public boolean supportsPredictiveItemAnimations() {
        if(this.mPendingSavedState == null && this.mLastStackFromEnd == this.mStackFromEnd) {
            return 1;
        }

        return 0;
    }

    private boolean updateAnchorFromChildren(Recycler arg5, State arg6, AnchorInfo arg7) {
        if(this.getChildCount() == 0) {
            return 0;
        }

        View v0 = this.getFocusedChild();
        if(v0 != null && (arg7.isViewValidAsAnchor(v0, arg6))) {
            arg7.assignFromViewAndKeepVisibleRect(v0, this.getPosition(v0));
            return 1;
        }

        if(this.mLastStackFromEnd != this.mStackFromEnd) {
            return 0;
        }

        View v5 = arg7.mLayoutFromEnd ? this.findReferenceChildClosestToEnd(arg5, arg6) : this.findReferenceChildClosestToStart(arg5, arg6);
        if(v5 != null) {
            arg7.assignFromView(v5, this.getPosition(v5));
            if(!arg6.isPreLayout() && (this.supportsPredictiveItemAnimations()) && (this.mOrientationHelper.getDecoratedStart(v5) >= this.mOrientationHelper.getEndAfterPadding() || this.mOrientationHelper.getDecoratedEnd(v5) < this.mOrientationHelper.getStartAfterPadding())) {
                boolean v5_1 = arg7.mLayoutFromEnd;
                OrientationHelper v4 = this.mOrientationHelper;
                int v4_1 = v5_1 ? v4.getEndAfterPadding() : v4.getStartAfterPadding();
                arg7.mCoordinate = v4_1;
            }

            return 1;
        }

        return 0;
    }

    private boolean updateAnchorFromPendingData(State arg5, AnchorInfo arg6) {
        OrientationHelper v1_1;
        boolean v5_1;
        boolean v1 = false;
        if(!arg5.isPreLayout()) {
            int v0 = this.mPendingScrollPosition;
            int v2 = -1;
            if(v0 == v2) {
            }
            else {
                int v3 = 0x80000000;
                if(v0 >= 0) {
                    if(v0 >= arg5.getItemCount()) {
                    }
                    else {
                        arg6.mPosition = this.mPendingScrollPosition;
                        SavedState v5 = this.mPendingSavedState;
                        if(v5 != null && (v5.hasValidAnchor())) {
                            arg6.mLayoutFromEnd = this.mPendingSavedState.mAnchorLayoutFromEnd;
                            v5_1 = arg6.mLayoutFromEnd;
                            v1_1 = this.mOrientationHelper;
                            arg6.mCoordinate = v5_1 ? v1_1.getEndAfterPadding() - this.mPendingSavedState.mAnchorOffset : v1_1.getStartAfterPadding() + this.mPendingSavedState.mAnchorOffset;
                            return 1;
                        }

                        if(this.mPendingScrollPositionOffset == v3) {
                            View v5_2 = this.findViewByPosition(this.mPendingScrollPosition);
                            if(v5_2 == null) {
                                if(this.getChildCount() > 0) {
                                    v5_1 = this.mPendingScrollPosition < this.getPosition(this.getChildAt(0)) ? true : false;
                                    if(v5_1 == this.mShouldReverseLayout) {
                                        v1 = true;
                                    }

                                    arg6.mLayoutFromEnd = v1;
                                }

                                arg6.assignCoordinateFromPadding();
                            }
                            else if(this.mOrientationHelper.getDecoratedMeasurement(v5_2) > this.mOrientationHelper.getTotalSpace()) {
                                arg6.assignCoordinateFromPadding();
                                return 1;
                            }
                            else {
                                v2 = this.mOrientationHelper.getDecoratedStart(v5_2) - this.mOrientationHelper.getStartAfterPadding();
                                OrientationHelper v3_1 = this.mOrientationHelper;
                                if(v2 < 0) {
                                    arg6.mCoordinate = v3_1.getStartAfterPadding();
                                    arg6.mLayoutFromEnd = false;
                                    return 1;
                                }
                                else if(v3_1.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(v5_2) < 0) {
                                    arg6.mCoordinate = this.mOrientationHelper.getEndAfterPadding();
                                    arg6.mLayoutFromEnd = true;
                                    return 1;
                                }
                                else {
                                    v1 = arg6.mLayoutFromEnd;
                                    OrientationHelper v2_1 = this.mOrientationHelper;
                                    int v5_3 = v1 ? v2_1.getDecoratedEnd(v5_2) + this.mOrientationHelper.getTotalSpaceChange() : v2_1.getDecoratedStart(v5_2);
                                    arg6.mCoordinate = v5_3;
                                }
                            }

                            return 1;
                        }

                        arg6.mLayoutFromEnd = this.mShouldReverseLayout;
                        v5_1 = this.mShouldReverseLayout;
                        v1_1 = this.mOrientationHelper;
                        arg6.mCoordinate = v5_1 ? v1_1.getEndAfterPadding() - this.mPendingScrollPositionOffset : v1_1.getStartAfterPadding() + this.mPendingScrollPositionOffset;
                        return 1;
                    }
                }

                this.mPendingScrollPosition = v2;
                this.mPendingScrollPositionOffset = v3;
            }
        }

        return 0;
    }

    private void updateAnchorInfoForLayout(Recycler arg2, State arg3, AnchorInfo arg4) {
        if(this.updateAnchorFromPendingData(arg3, arg4)) {
        }
        else {
            if(this.updateAnchorFromChildren(arg2, arg3, arg4)) {
                return;
            }

            goto label_6;
        }

        return;
    label_6:
        arg4.assignCoordinateFromPadding();
        int v1 = this.mStackFromEnd ? arg3.getItemCount() - 1 : 0;
        arg4.mPosition = v1;
    }

    private void updateLayoutState(int arg5, int arg6, boolean arg7, State arg8) {
        // Method was not decompiled
    }

    private void updateLayoutStateToFillEnd(int arg4, int arg5) {
        this.mLayoutState.mAvailable = this.mOrientationHelper.getEndAfterPadding() - arg5;
        LayoutState v0 = this.mLayoutState;
        int v1 = this.mShouldReverseLayout ? -1 : 1;
        v0.mItemDirection = v1;
        this.mLayoutState.mCurrentPosition = arg4;
        this.mLayoutState.mLayoutDirection = 1;
        this.mLayoutState.mOffset = arg5;
        this.mLayoutState.mScrollingOffset = 0x80000000;
    }

    private void updateLayoutStateToFillEnd(AnchorInfo arg2) {
        this.updateLayoutStateToFillEnd(arg2.mPosition, arg2.mCoordinate);
    }

    private void updateLayoutStateToFillStart(int arg3, int arg4) {
        this.mLayoutState.mAvailable = arg4 - this.mOrientationHelper.getStartAfterPadding();
        this.mLayoutState.mCurrentPosition = arg3;
        LayoutState v3 = this.mLayoutState;
        int v1 = -1;
        int v0 = this.mShouldReverseLayout ? 1 : v1;
        v3.mItemDirection = v0;
        this.mLayoutState.mLayoutDirection = v1;
        this.mLayoutState.mOffset = arg4;
        this.mLayoutState.mScrollingOffset = 0x80000000;
    }

    private void updateLayoutStateToFillStart(AnchorInfo arg2) {
        this.updateLayoutStateToFillStart(arg2.mPosition, arg2.mCoordinate);
    }

    void validateChildOrder() {
        StringBuilder v2_1;
        int v7_1;
        int v8;
        View v7;
        int v4;
        Log.d("LinearLayoutManager", "validating child count " + this.getChildCount());
        boolean v1 = true;
        if(this.getChildCount() < 1) {
        }
        else {
            int v2 = this.getPosition(this.getChildAt(0));
            int v3 = this.mOrientationHelper.getDecoratedStart(this.getChildAt(0));
            String v5 = "detected invalid location";
            String v6 = "detected invalid position. loc invalid? ";
            if(this.mShouldReverseLayout) {
                v4 = 1;
                while(true) {
                    if(v4 < this.getChildCount()) {
                        v7 = this.getChildAt(v4);
                        v8 = this.getPosition(v7);
                        v7_1 = this.mOrientationHelper.getDecoratedStart(v7);
                        if(v8 < v2) {
                            this.logChildren();
                            v2_1 = new StringBuilder(v6);
                            if(v7_1 < v3) {
                            }
                            else {
                                v1 = false;
                            }

                            throw new RuntimeException(v2_1.append(v1).toString());
                        }
                        else {
                            if(v7_1 > v3) {
                                break;
                            }

                            ++v4;
                            continue;
                        }
                    }

                    return;
                }

                this.logChildren();
                throw new RuntimeException(v5);
            }
            else {
                for(v4 = 1; true; ++v4) {
                    if(v4 >= this.getChildCount()) {
                        return;
                    }

                    v7 = this.getChildAt(v4);
                    v8 = this.getPosition(v7);
                    v7_1 = this.mOrientationHelper.getDecoratedStart(v7);
                    if(v8 < v2) {
                        this.logChildren();
                        v2_1 = new StringBuilder(v6);
                        if(v7_1 < v3) {
                        }
                        else {
                            v1 = false;
                        }

                        throw new RuntimeException(v2_1.append(v1).toString());
                    }

                    if(v7_1 < v3) {
                        break;
                    }
                }

                this.logChildren();
                throw new RuntimeException(v5);
            }
        }
    }
}

