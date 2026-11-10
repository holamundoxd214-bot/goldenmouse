package androidx.recyclerview.widget;

import android.util.SparseArray;
import java.lang.reflect.Array;

class TileList {
    public class Tile {
        public int mItemCount;
        public final Object[] mItems;
        Tile mNext;
        public int mStartPosition;

        public Tile(Class arg1, int arg2) {
            super();
            this.mItems = Array.newInstance(arg1, arg2);
        }

        boolean containsPosition(int arg2) {
            int v0 = this.mStartPosition;
            if(v0 <= arg2 && arg2 < v0 + this.mItemCount) {
                return 1;
            }

            return 0;
        }

        Object getByPosition(int arg2) {
            return this.mItems[arg2 - this.mStartPosition];
        }
    }

    Tile mLastAccessedTile;
    final int mTileSize;
    private final SparseArray mTiles;

    public TileList(int arg3) {
        super();
        this.mTiles = new SparseArray(10);
        this.mTileSize = arg3;
    }

    public Tile addOrReplace(Tile arg4) {
        int v0 = this.mTiles.indexOfKey(arg4.mStartPosition);
        SparseArray v1 = this.mTiles;
        if(v0 < 0) {
            v1.put(arg4.mStartPosition, arg4);
            return null;
        }

        Object v1_1 = v1.valueAt(v0);
        this.mTiles.setValueAt(v0, arg4);
        if(this.mLastAccessedTile == v1_1) {
            this.mLastAccessedTile = arg4;
        }

        return ((Tile)v1_1);
    }

    public void clear() {
        this.mTiles.clear();
    }

    public Tile getAtIndex(int arg1) {
        return this.mTiles.valueAt(arg1);
    }

    public Object getItemAt(int arg3) {
        Tile v0 = this.mLastAccessedTile;
        if(v0 == null || !v0.containsPosition(arg3)) {
            int v0_1 = this.mTiles.indexOfKey(arg3 - arg3 % this.mTileSize);
            if(v0_1 < 0) {
                return null;
            }
            else {
                this.mLastAccessedTile = this.mTiles.valueAt(v0_1);
            }
        }

        return this.mLastAccessedTile.getByPosition(arg3);
    }

    public Tile removeAtPos(int arg3) {
        Object v0 = this.mTiles.get(arg3);
        if(this.mLastAccessedTile == v0) {
            this.mLastAccessedTile = null;
        }

        this.mTiles.delete(arg3);
        return ((Tile)v0);
    }

    public int size() {
        return this.mTiles.size();
    }
}

