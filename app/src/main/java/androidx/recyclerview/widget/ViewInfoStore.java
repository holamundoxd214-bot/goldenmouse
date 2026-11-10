package androidx.recyclerview.widget;

import androidx.collection.LongSparseArray;
import androidx.collection.SimpleArrayMap;
import androidx.core.util.Pools$Pool;
import androidx.core.util.Pools$SimplePool;

class ViewInfoStore {
    class InfoRecord {
        static final int FLAG_APPEAR = 2;
        static final int FLAG_APPEAR_AND_DISAPPEAR = 3;
        static final int FLAG_APPEAR_PRE_AND_POST = 14;
        static final int FLAG_DISAPPEARED = 1;
        static final int FLAG_POST = 8;
        static final int FLAG_PRE = 4;
        static final int FLAG_PRE_AND_POST = 12;
        int flags;
        ItemHolderInfo postInfo;
        ItemHolderInfo preInfo;
        static Pool sPool;

        static {
            InfoRecord.sPool = new SimplePool(20);
        }

        private InfoRecord() {
            super();
        }

        static void drainCache() {
            while(InfoRecord.sPool.acquire() != null) {
            }
        }

        static InfoRecord obtain() {
            InfoRecord v0_1;
            Object v0 = InfoRecord.sPool.acquire();
            if(v0 == null) {
                v0_1 = new InfoRecord();
            }

            return v0_1;
        }

        static void recycle(InfoRecord arg1) {
            arg1.flags = 0;
            arg1.preInfo = null;
            arg1.postInfo = null;
            InfoRecord.sPool.release(arg1);
        }
    }

    interface ProcessCallback {
        void processAppeared(ViewHolder arg1, ItemHolderInfo arg2, ItemHolderInfo arg3);

        void processDisappeared(ViewHolder arg1, ItemHolderInfo arg2, ItemHolderInfo arg3);

        void processPersistent(ViewHolder arg1, ItemHolderInfo arg2, ItemHolderInfo arg3);

        void unused(ViewHolder arg1);
    }

    private static final boolean DEBUG = false;
    final SimpleArrayMap mLayoutHolderMap;
    final LongSparseArray mOldChangedHolders;

    ViewInfoStore() {
        super();
        this.mLayoutHolderMap = new SimpleArrayMap();
        this.mOldChangedHolders = new LongSparseArray();
    }

    void addToAppearedInPreLayoutHolders(ViewHolder arg2, ItemHolderInfo arg3) {
        Object v0 = this.mLayoutHolderMap.get(arg2);
        if(v0 == null) {
            InfoRecord v0_1 = InfoRecord.obtain();
            this.mLayoutHolderMap.put(arg2, v0_1);
        }

        ((InfoRecord)v0).flags |= 2;
        ((InfoRecord)v0).preInfo = arg3;
    }

    void addToDisappearedInLayout(ViewHolder arg2) {
        Object v0 = this.mLayoutHolderMap.get(arg2);
        if(v0 == null) {
            InfoRecord v0_1 = InfoRecord.obtain();
            this.mLayoutHolderMap.put(arg2, v0_1);
        }

        ((InfoRecord)v0).flags |= 1;
    }

    void addToOldChangeHolders(long arg1, ViewHolder arg3) {
        this.mOldChangedHolders.put(arg1, arg3);
    }

    void addToPostLayout(ViewHolder arg2, ItemHolderInfo arg3) {
        Object v0 = this.mLayoutHolderMap.get(arg2);
        if(v0 == null) {
            InfoRecord v0_1 = InfoRecord.obtain();
            this.mLayoutHolderMap.put(arg2, v0_1);
        }

        ((InfoRecord)v0).postInfo = arg3;
        ((InfoRecord)v0).flags |= 8;
    }

    void addToPreLayout(ViewHolder arg2, ItemHolderInfo arg3) {
        Object v0 = this.mLayoutHolderMap.get(arg2);
        if(v0 == null) {
            InfoRecord v0_1 = InfoRecord.obtain();
            this.mLayoutHolderMap.put(arg2, v0_1);
        }

        ((InfoRecord)v0).preInfo = arg3;
        ((InfoRecord)v0).flags |= 4;
    }

    void clear() {
        this.mLayoutHolderMap.clear();
        this.mOldChangedHolders.clear();
    }

    ViewHolder getFromOldChangeHolders(long arg1) {
        return this.mOldChangedHolders.get(arg1);
    }

    boolean isDisappearing(ViewHolder arg1) {
        Object v0 = this.mLayoutHolderMap.get(arg1);
        if(v0 != null && (((InfoRecord)v0).flags & 1) != 0) {
            return 1;
        }

        return 0;
    }

    boolean isInPreLayout(ViewHolder arg1) {
        Object v0 = this.mLayoutHolderMap.get(arg1);
        if(v0 != null && (((InfoRecord)v0).flags & 4) != 0) {
            return 1;
        }

        return 0;
    }

    void onDetach() {
        InfoRecord.drainCache();
    }

    public void onViewDetached(ViewHolder arg1) {
        this.removeFromDisappearedInLayout(arg1);
    }

    private ItemHolderInfo popFromLayoutStep(ViewHolder arg4, int arg5) {
        ItemHolderInfo v5;
        int v4 = this.mLayoutHolderMap.indexOfKey(arg4);
        ItemHolderInfo v0 = null;
        if(v4 < 0) {
            return v0;
        }

        Object v1 = this.mLayoutHolderMap.valueAt(v4);
        if(v1 != null && (((InfoRecord)v1).flags & arg5) != 0) {
            ((InfoRecord)v1).flags &= ~arg5;
            if(arg5 == 4) {
                v5 = ((InfoRecord)v1).preInfo;
            }
            else if(arg5 == 8) {
                v5 = ((InfoRecord)v1).postInfo;
            }
            else {
                goto label_29;
            }

            if((((InfoRecord)v1).flags & 12) == 0) {
                this.mLayoutHolderMap.removeAt(v4);
                InfoRecord.recycle(((InfoRecord)v1));
            }

            return v5;
        label_29:
            throw new IllegalArgumentException("Must provide flag PRE or POST");
        }

        return v0;
    }

    ItemHolderInfo popFromPostLayout(ViewHolder arg2) {
        return this.popFromLayoutStep(arg2, 8);
    }

    ItemHolderInfo popFromPreLayout(ViewHolder arg2) {
        return this.popFromLayoutStep(arg2, 4);
    }

    void process(ProcessCallback arg6) {
        int v0;
        for(v0 = this.mLayoutHolderMap.size() - 1; v0 >= 0; --v0) {
            Object v1 = this.mLayoutHolderMap.keyAt(v0);
            Object v2 = this.mLayoutHolderMap.removeAt(v0);
            if((((InfoRecord)v2).flags & 3) == 3) {
                arg6.unused(((ViewHolder)v1));
            }
            else if((((InfoRecord)v2).flags & 1) != 0) {
                if(((InfoRecord)v2).preInfo == null) {
                    arg6.unused(((ViewHolder)v1));
                }
                else {
                    arg6.processDisappeared(((ViewHolder)v1), ((InfoRecord)v2).preInfo, ((InfoRecord)v2).postInfo);
                }
            }
            else if((((InfoRecord)v2).flags & 14) == 14) {
                arg6.processAppeared(((ViewHolder)v1), ((InfoRecord)v2).preInfo, ((InfoRecord)v2).postInfo);
            }
            else if((((InfoRecord)v2).flags & 12) == 12) {
                arg6.processPersistent(((ViewHolder)v1), ((InfoRecord)v2).preInfo, ((InfoRecord)v2).postInfo);
            }
            else if((((InfoRecord)v2).flags & 4) != 0) {
                arg6.processDisappeared(((ViewHolder)v1), ((InfoRecord)v2).preInfo, null);
            }
            else if((((InfoRecord)v2).flags & 8) != 0) {
                arg6.processAppeared(((ViewHolder)v1), ((InfoRecord)v2).preInfo, ((InfoRecord)v2).postInfo);
            }

            InfoRecord.recycle(((InfoRecord)v2));
        }
    }

    void removeFromDisappearedInLayout(ViewHolder arg1) {
        Object v0 = this.mLayoutHolderMap.get(arg1);
        if(v0 == null) {
            return;
        }

        ((InfoRecord)v0).flags &= -2;
    }

    void removeViewHolder(ViewHolder arg3) {
        int v0 = this.mOldChangedHolders.size() - 1;
        while(v0 >= 0) {
            if(arg3 == this.mOldChangedHolders.valueAt(v0)) {
                this.mOldChangedHolders.removeAt(v0);
            }
            else {
                --v0;
                continue;
            }

            break;
        }

        Object v2 = this.mLayoutHolderMap.remove(arg3);
        if(v2 != null) {
            InfoRecord.recycle(((InfoRecord)v2));
        }
    }
}

