package androidx.recyclerview.widget;

import android.util.Log;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;

public class AsyncListUtil {
    class androidx.recyclerview.widget.AsyncListUtil$1 implements MainThreadCallback {
        androidx.recyclerview.widget.AsyncListUtil$1(AsyncListUtil arg1) {
            AsyncListUtil.this = arg1;
            super();
        }

        public void addTile(int arg4, Tile arg5) {
            boolean v4 = this.isRequestedGeneration(arg4);
            AsyncListUtil v0 = AsyncListUtil.this;
            if(!v4) {
                v0.mBackgroundProxy.recycleTile(arg5);
                return;
            }

            Tile v4_1 = v0.mTileList.addOrReplace(arg5);
            if(v4_1 != null) {
                Log.e("AsyncListUtil", "duplicate tile @" + v4_1.mStartPosition);
                AsyncListUtil.this.mBackgroundProxy.recycleTile(v4_1);
            }

            arg4 = arg5.mStartPosition + arg5.mItemCount;
            int v0_1;
            for(v0_1 = 0; v0_1 < AsyncListUtil.this.mMissingPositions.size(); ++v0_1) {
                int v1 = AsyncListUtil.this.mMissingPositions.keyAt(v0_1);
                if(arg5.mStartPosition <= v1 && v1 < arg4) {
                    AsyncListUtil.this.mMissingPositions.removeAt(v0_1);
                    AsyncListUtil.this.mViewCallback.onItemLoaded(v1);
                    continue;
                }
            }
        }

        private boolean isRequestedGeneration(int arg1) {
            if(arg1 == AsyncListUtil.this.mRequestedGeneration) {
                return 1;
            }

            return 0;
        }

        private void recycleAllTiles() {
            AsyncListUtil v2;
            int v0;
            for(v0 = 0; true; ++v0) {
                int v1 = AsyncListUtil.this.mTileList.size();
                v2 = AsyncListUtil.this;
                if(v0 >= v1) {
                    break;
                }

                v2.mBackgroundProxy.recycleTile(AsyncListUtil.this.mTileList.getAtIndex(v0));
            }

            v2.mTileList.clear();
        }

        public void removeTile(int arg1, int arg2) {
            if(!this.isRequestedGeneration(arg1)) {
                return;
            }

            Tile v1 = AsyncListUtil.this.mTileList.removeAtPos(arg2);
            if(v1 == null) {
                Log.e("AsyncListUtil", "tile not found @" + arg2);
                return;
            }

            AsyncListUtil.this.mBackgroundProxy.recycleTile(v1);
        }

        public void updateItemCount(int arg1, int arg2) {
            if(!this.isRequestedGeneration(arg1)) {
                return;
            }

            AsyncListUtil.this.mItemCount = arg2;
            AsyncListUtil.this.mViewCallback.onDataRefresh();
            AsyncListUtil.this.mDisplayedGeneration = AsyncListUtil.this.mRequestedGeneration;
            this.recycleAllTiles();
            AsyncListUtil.this.mAllowScrollHints = false;
            AsyncListUtil.this.updateRange();
        }
    }

    class androidx.recyclerview.widget.AsyncListUtil$2 implements BackgroundCallback {
        private int mFirstRequiredTileStart;
        private int mGeneration;
        private int mItemCount;
        private int mLastRequiredTileStart;
        final SparseBooleanArray mLoadedTiles;
        private Tile mRecycledRoot;

        androidx.recyclerview.widget.AsyncListUtil$2(AsyncListUtil arg1) {
            AsyncListUtil.this = arg1;
            super();
            this.mLoadedTiles = new SparseBooleanArray();
        }

        private Tile acquireTile() {
            Tile v0 = this.mRecycledRoot;
            if(v0 != null) {
                this.mRecycledRoot = v0.mNext;
                return v0;
            }

            return new Tile(AsyncListUtil.this.mTClass, AsyncListUtil.this.mTileSize);
        }

        private void addTile(Tile arg4) {
            this.mLoadedTiles.put(arg4.mStartPosition, true);
            AsyncListUtil.this.mMainThreadProxy.addTile(this.mGeneration, arg4);
        }

        private void flushTileCache(int arg8) {
            int v0 = AsyncListUtil.this.mDataCallback.getMaxCachedTiles();
            while(this.mLoadedTiles.size() >= v0) {
                int v1 = this.mLoadedTiles.keyAt(0);
                int v2 = this.mLoadedTiles.keyAt(this.mLoadedTiles.size() - 1);
                int v3 = this.mFirstRequiredTileStart - v1;
                int v5 = v2 - this.mLastRequiredTileStart;
                if(v3 > 0 && (v3 >= v5 || arg8 == 2)) {
                    this.removeTile(v1);
                    continue;
                }

                if(v5 <= 0) {
                    return;
                }

                if(v3 >= v5 && arg8 != 1) {
                    return;
                }

                this.removeTile(v2);
            }
        }

        private int getTileStart(int arg1) {
            return arg1 - arg1 % AsyncListUtil.this.mTileSize;
        }

        private boolean isTileLoaded(int arg1) {
            return this.mLoadedTiles.get(arg1);
        }

        public void loadTile(int arg5, int arg6) {
            if(this.isTileLoaded(arg5)) {
                return;
            }

            Tile v0 = this.acquireTile();
            v0.mStartPosition = arg5;
            v0.mItemCount = Math.min(AsyncListUtil.this.mTileSize, this.mItemCount - v0.mStartPosition);
            AsyncListUtil.this.mDataCallback.fillData(v0.mItems, v0.mStartPosition, v0.mItemCount);
            this.flushTileCache(arg6);
            this.addTile(v0);
        }

        private void log(String arg2, Object[] arg3) {
            Log.d("AsyncListUtil", "[BKGR] " + String.format(arg2, arg3));
        }

        public void recycleTile(Tile arg4) {
            AsyncListUtil.this.mDataCallback.recycleData(arg4.mItems, arg4.mItemCount);
            arg4.mNext = this.mRecycledRoot;
            this.mRecycledRoot = arg4;
        }

        public void refresh(int arg2) {
            this.mGeneration = arg2;
            this.mLoadedTiles.clear();
            this.mItemCount = AsyncListUtil.this.mDataCallback.refreshData();
            AsyncListUtil.this.mMainThreadProxy.updateItemCount(this.mGeneration, this.mItemCount);
        }

        private void removeTile(int arg2) {
            this.mLoadedTiles.delete(arg2);
            AsyncListUtil.this.mMainThreadProxy.removeTile(this.mGeneration, arg2);
        }

        private void requestTiles(int arg4, int arg5, int arg6, boolean arg7) {
            int v0;
            for(v0 = arg4; v0 <= arg5; v0 += AsyncListUtil.this.mTileSize) {
                int v1 = arg7 ? arg5 + arg4 - v0 : v0;
                AsyncListUtil.this.mBackgroundProxy.loadTile(v1, arg6);
            }
        }

        public void updateRange(int arg2, int arg3, int arg4, int arg5, int arg6) {
            if(arg2 > arg3) {
                return;
            }

            arg2 = this.getTileStart(arg2);
            arg3 = this.getTileStart(arg3);
            this.mFirstRequiredTileStart = this.getTileStart(arg4);
            arg4 = this.getTileStart(arg5);
            this.mLastRequiredTileStart = arg4;
            if(arg6 == 1) {
                this.requestTiles(this.mFirstRequiredTileStart, arg3, arg6, true);
                this.requestTiles(arg3 + AsyncListUtil.this.mTileSize, this.mLastRequiredTileStart, arg6, false);
                return;
            }

            this.requestTiles(arg2, arg4, arg6, false);
            this.requestTiles(this.mFirstRequiredTileStart, arg2 - AsyncListUtil.this.mTileSize, arg6, true);
        }
    }

    public abstract class DataCallback {
        public DataCallback() {
            super();
        }

        public abstract void fillData(Object[] arg1, int arg2, int arg3);

        public int getMaxCachedTiles() {
            return 10;
        }

        public void recycleData(Object[] arg1, int arg2) {
        }

        public abstract int refreshData();
    }

    public abstract class ViewCallback {
        public static final int HINT_SCROLL_ASC = 2;
        public static final int HINT_SCROLL_DESC = 1;
        public static final int HINT_SCROLL_NONE;

        public ViewCallback() {
            super();
        }

        public void extendRangeInto(int[] arg6, int[] arg7, int arg8) {
            int v0 = arg6[1];
            int v6 = arg6[0];
            int v2 = v0 - v6 + 1;
            int v3 = v2 / 2;
            int v4 = arg8 == 1 ? v2 : v3;
            arg7[0] = v6 - v4;
            if(arg8 == 2) {
            }
            else {
                v2 = v3;
            }

            arg7[1] = v0 + v2;
        }

        public abstract void getItemRangeInto(int[] arg1);

        public abstract void onDataRefresh();

        public abstract void onItemLoaded(int arg1);
    }

    static final boolean DEBUG = false;
    static final String TAG = "AsyncListUtil";
    boolean mAllowScrollHints;
    private final BackgroundCallback mBackgroundCallback;
    final BackgroundCallback mBackgroundProxy;
    final DataCallback mDataCallback;
    int mDisplayedGeneration;
    int mItemCount;
    private final MainThreadCallback mMainThreadCallback;
    final MainThreadCallback mMainThreadProxy;
    final SparseIntArray mMissingPositions;
    final int[] mPrevRange;
    int mRequestedGeneration;
    private int mScrollHint;
    final Class mTClass;
    final TileList mTileList;
    final int mTileSize;
    final int[] mTmpRange;
    final int[] mTmpRangeExtended;
    final ViewCallback mViewCallback;

    public AsyncListUtil(Class arg3, int arg4, DataCallback arg5, ViewCallback arg6) {
        super();
        this.mTmpRange = new int[2];
        this.mPrevRange = new int[2];
        this.mTmpRangeExtended = new int[2];
        this.mScrollHint = 0;
        this.mItemCount = 0;
        this.mDisplayedGeneration = 0;
        this.mRequestedGeneration = 0;
        this.mMissingPositions = new SparseIntArray();
        androidx.recyclerview.widget.AsyncListUtil$1 v0 = new androidx.recyclerview.widget.AsyncListUtil$1(this);
        this.mMainThreadCallback = ((MainThreadCallback)v0);
        androidx.recyclerview.widget.AsyncListUtil$2 v1 = new androidx.recyclerview.widget.AsyncListUtil$2(this);
        this.mBackgroundCallback = ((BackgroundCallback)v1);
        this.mTClass = arg3;
        this.mTileSize = arg4;
        this.mDataCallback = arg5;
        this.mViewCallback = arg6;
        this.mTileList = new TileList(arg4);
        MessageThreadUtil v3 = new MessageThreadUtil();
        this.mMainThreadProxy = ((ThreadUtil)v3).getMainThreadProxy(((MainThreadCallback)v0));
        this.mBackgroundProxy = ((ThreadUtil)v3).getBackgroundProxy(((BackgroundCallback)v1));
        this.refresh();
    }

    public Object getItem(int arg3) {
        if(arg3 >= 0 && arg3 < this.mItemCount) {
            Object v0 = this.mTileList.getItemAt(arg3);
            if(v0 == null && !this.isRefreshPending()) {
                this.mMissingPositions.put(arg3, 0);
            }

            return v0;
        }

        throw new IndexOutOfBoundsException(arg3 + " is not within 0 and " + this.mItemCount);
    }

    public int getItemCount() {
        return this.mItemCount;
    }

    private boolean isRefreshPending() {
        if(this.mRequestedGeneration != this.mDisplayedGeneration) {
            return 1;
        }

        return 0;
    }

    void log(String arg2, Object[] arg3) {
        Log.d("AsyncListUtil", "[MAIN] " + String.format(arg2, arg3));
    }

    public void onRangeChanged() {
        if(this.isRefreshPending()) {
            return;
        }

        this.updateRange();
        this.mAllowScrollHints = true;
    }

    public void refresh() {
        this.mMissingPositions.clear();
        BackgroundCallback v0 = this.mBackgroundProxy;
        int v1 = this.mRequestedGeneration + 1;
        this.mRequestedGeneration = v1;
        v0.refresh(v1);
    }

    void updateRange() {
        int[] v5;
        this.mViewCallback.getItemRangeInto(this.mTmpRange);
        int[] v0 = this.mTmpRange;
        int v2 = v0[0];
        int v4 = v0[1];
        if(v2 <= v4) {
            if(v2 < 0) {
            }
            else if(v4 >= this.mItemCount) {
            }
            else {
                if(!this.mAllowScrollHints) {
                    this.mScrollHint = 0;
                }
                else {
                    v5 = this.mPrevRange;
                    if(v2 <= v5[1]) {
                        int v5_1 = v5[0];
                        if(v5_1 > v4) {
                        }
                        else {
                            if(v2 < v5_1) {
                                this.mScrollHint = 1;
                            }
                            else if(v2 > v5_1) {
                                this.mScrollHint = 2;
                            }
                            else {
                            }

                            goto label_32;
                        }
                    }

                    this.mScrollHint = 0;
                }

            label_32:
                v5 = this.mPrevRange;
                v5[0] = v2;
                v5[1] = v4;
                this.mViewCallback.extendRangeInto(v0, this.mTmpRangeExtended, this.mScrollHint);
                this.mTmpRangeExtended[0] = Math.min(this.mTmpRange[0], Math.max(this.mTmpRangeExtended[0], 0));
                this.mTmpRangeExtended[1] = Math.max(this.mTmpRange[1], Math.min(this.mTmpRangeExtended[1], this.mItemCount - 1));
                this.mBackgroundProxy.updateRange(this.mTmpRange[0], this.mTmpRange[1], this.mTmpRangeExtended[0], this.mTmpRangeExtended[1], this.mScrollHint);
            }
        }
    }
}

