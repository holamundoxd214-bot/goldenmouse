package androidx.recyclerview.widget;

import androidx.core.util.Pools$Pool;
import androidx.core.util.Pools$SimplePool;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class AdapterHelper implements Callback {
    interface androidx.recyclerview.widget.AdapterHelper$Callback {
        ViewHolder findViewHolder(int arg1);

        void markViewHoldersUpdated(int arg1, int arg2, Object arg3);

        void offsetPositionsForAdd(int arg1, int arg2);

        void offsetPositionsForMove(int arg1, int arg2);

        void offsetPositionsForRemovingInvisible(int arg1, int arg2);

        void offsetPositionsForRemovingLaidOutOrNewView(int arg1, int arg2);

        void onDispatchFirstPass(UpdateOp arg1);

        void onDispatchSecondPass(UpdateOp arg1);
    }

    class UpdateOp {
        static final int ADD = 1;
        static final int MOVE = 8;
        static final int POOL_SIZE = 30;
        static final int REMOVE = 2;
        static final int UPDATE = 4;
        int cmd;
        int itemCount;
        Object payload;
        int positionStart;

        UpdateOp(int arg1, int arg2, int arg3, Object arg4) {
            super();
            this.cmd = arg1;
            this.positionStart = arg2;
            this.itemCount = arg3;
            this.payload = arg4;
        }

        String cmdToString() {
            int v1 = this.cmd;
            if(v1 != 1) {
                if(v1 != 2) {
                    if(v1 != 4) {
                        if(v1 != 8) {
                            return "??";
                        }

                        return "mv";
                    }

                    return "up";
                }

                return "rm";
            }

            return "add";
        }

        public boolean equals(Object arg5) {
            if(this == (((UpdateOp)arg5))) {
                return 1;
            }

            if(arg5 != null) {
                if(this.getClass() != arg5.getClass()) {
                }
                else {
                    int v2 = this.cmd;
                    if(v2 != ((UpdateOp)arg5).cmd) {
                        return 0;
                    }
                    else {
                        if(v2 == 8 && Math.abs(this.itemCount - this.positionStart) == 1 && this.itemCount == ((UpdateOp)arg5).positionStart && this.positionStart == ((UpdateOp)arg5).itemCount) {
                            return 1;
                        }

                        if(this.itemCount != ((UpdateOp)arg5).itemCount) {
                            return 0;
                        }

                        if(this.positionStart != ((UpdateOp)arg5).positionStart) {
                            return 0;
                        }

                        Object v4 = this.payload;
                        if(v4 != null) {
                            if(!v4.equals(((UpdateOp)arg5).payload)) {
                                return 0;
                            }
                        }
                        else if(((UpdateOp)arg5).payload != null) {
                            return 0;
                        }

                        return 1;
                    }
                }
            }

            return 0;
        }

        public int hashCode() {
            return (this.cmd * 0x1F + this.positionStart) * 0x1F + this.itemCount;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + this.cmdToString() + ",s:" + this.positionStart + "c:" + this.itemCount + ",p:" + this.payload + "]";
        }
    }

    private static final boolean DEBUG = false;
    static final int POSITION_TYPE_INVISIBLE = 0;
    static final int POSITION_TYPE_NEW_OR_LAID_OUT = 1;
    private static final String TAG = "AHT";
    final androidx.recyclerview.widget.AdapterHelper$Callback mCallback;
    final boolean mDisableRecycler;
    private int mExistingUpdateTypes;
    Runnable mOnItemProcessedCallback;
    final OpReorderer mOpReorderer;
    final ArrayList mPendingUpdates;
    final ArrayList mPostponedList;
    private Pool mUpdateOpPool;

    AdapterHelper(androidx.recyclerview.widget.AdapterHelper$Callback arg2) {
        this(arg2, false);
    }

    AdapterHelper(androidx.recyclerview.widget.AdapterHelper$Callback arg3, boolean arg4) {
        super();
        this.mUpdateOpPool = new SimplePool(30);
        this.mPendingUpdates = new ArrayList();
        this.mPostponedList = new ArrayList();
        this.mExistingUpdateTypes = 0;
        this.mCallback = arg3;
        this.mDisableRecycler = arg4;
        this.mOpReorderer = new OpReorderer(((Callback)this));
    }

    AdapterHelper addUpdateOp(UpdateOp[] arg2) {
        Collections.addAll(this.mPendingUpdates, ((Object[])arg2));
        return this;
    }

    private void applyAdd(UpdateOp arg1) {
        this.postponeAndUpdateViewHolders(arg1);
    }

    private void applyMove(UpdateOp arg1) {
        this.postponeAndUpdateViewHolders(arg1);
    }

    public int applyPendingUpdatesToPosition(int arg6) {
        int v0 = this.mPendingUpdates.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            Object v2 = this.mPendingUpdates.get(v1);
            int v3 = ((UpdateOp)v2).cmd;
            if(v3 == 1) {
                if(((UpdateOp)v2).positionStart > arg6) {
                    goto label_40;
                }

                arg6 += ((UpdateOp)v2).itemCount;
            }
            else if(v3 == 2) {
                if(((UpdateOp)v2).positionStart > arg6) {
                    goto label_40;
                }

                if(((UpdateOp)v2).positionStart + ((UpdateOp)v2).itemCount > arg6) {
                    return -1;
                }

                arg6 -= ((UpdateOp)v2).itemCount;
            }
            else if(v3 != 8) {
            }
            else if(((UpdateOp)v2).positionStart == arg6) {
                arg6 = ((UpdateOp)v2).itemCount;
            }
            else {
                if(((UpdateOp)v2).positionStart < arg6) {
                    --arg6;
                }

                if(((UpdateOp)v2).itemCount > arg6) {
                    goto label_40;
                }

                ++arg6;
            }

        label_40:
        }

        return arg6;
    }

    private void applyRemove(UpdateOp arg11) {
        int v6_1;
        int v7;
        Object v6;
        int v0 = arg11.positionStart;
        int v1 = arg11.positionStart + arg11.itemCount;
        int v2 = arg11.positionStart;
        int v4 = -1;
        int v5 = 0;
        while(true) {
            v6 = null;
            v7 = 2;
            if(v2 >= v1) {
                break;
            }

            if(this.mCallback.findViewHolder(v2) != null || (this.canFindInPreLayout(v2))) {
                if(v4 == 0) {
                    this.dispatchAndUpdateViewHolders(this.obtainUpdateOp(v7, v0, v5, v6));
                    v4 = 1;
                }
                else {
                    v4 = 0;
                }

                v6_1 = 1;
            }
            else {
                if(v4 == 1) {
                    this.postponeAndUpdateViewHolders(this.obtainUpdateOp(v7, v0, v5, v6));
                    v4 = 1;
                }
                else {
                    v4 = 0;
                }

                v6_1 = 0;
            }

            if(v4 != 0) {
                v2 -= v5;
                v1 -= v5;
                v5 = 1;
            }
            else {
                ++v5;
            }

            ++v2;
            v4 = v6_1;
        }

        if(v5 != arg11.itemCount) {
            this.recycleUpdateOp(arg11);
            arg11 = this.obtainUpdateOp(v7, v0, v5, v6);
        }

        if(v4 == 0) {
            this.dispatchAndUpdateViewHolders(arg11);
            return;
        }

        this.postponeAndUpdateViewHolders(arg11);
    }

    private void applyUpdate(UpdateOp arg10) {
        int v6;
        int v0 = arg10.positionStart;
        int v1 = arg10.positionStart + arg10.itemCount;
        int v2 = arg10.positionStart;
        int v4 = -1;
        int v5 = 0;
        while(true) {
            v6 = 4;
            if(v2 >= v1) {
                break;
            }

            if(this.mCallback.findViewHolder(v2) != null || (this.canFindInPreLayout(v2))) {
                if(v4 == 0) {
                    this.dispatchAndUpdateViewHolders(this.obtainUpdateOp(v6, v0, v5, arg10.payload));
                    v0 = v2;
                    v5 = 0;
                }

                v4 = 1;
            }
            else {
                if(v4 == 1) {
                    this.postponeAndUpdateViewHolders(this.obtainUpdateOp(v6, v0, v5, arg10.payload));
                    v0 = v2;
                    v5 = 0;
                }

                v4 = 0;
            }

            ++v5;
            ++v2;
        }

        if(v5 != arg10.itemCount) {
            Object v1_1 = arg10.payload;
            this.recycleUpdateOp(arg10);
            arg10 = this.obtainUpdateOp(v6, v0, v5, v1_1);
        }

        if(v4 == 0) {
            this.dispatchAndUpdateViewHolders(arg10);
            return;
        }

        this.postponeAndUpdateViewHolders(arg10);
    }

    private boolean canFindInPreLayout(int arg8) {
        int v0 = this.mPostponedList.size();
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            Object v3 = this.mPostponedList.get(v2);
            if(((UpdateOp)v3).cmd == 8) {
                if(this.findPositionOffset(((UpdateOp)v3).itemCount, v2 + 1) == arg8) {
                    return 1;
                }
            }
            else if(((UpdateOp)v3).cmd == 1) {
                int v4 = ((UpdateOp)v3).positionStart + ((UpdateOp)v3).itemCount;
                int v3_1 = ((UpdateOp)v3).positionStart;
                while(v3_1 < v4) {
                    if(this.findPositionOffset(v3_1, v2 + 1) == arg8) {
                        return 1;
                    }
                    else {
                        ++v3_1;
                        continue;
                    }

                    break;
                }
            }
        }

        return 0;
    }

    void consumePostponedUpdates() {
        int v0 = this.mPostponedList.size();
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            this.mCallback.onDispatchSecondPass(this.mPostponedList.get(v2));
        }

        this.recycleUpdateOpsAndClearList(this.mPostponedList);
        this.mExistingUpdateTypes = 0;
    }

    void consumeUpdatesInOnePass() {
        ArrayList v3;
        this.consumePostponedUpdates();
        int v0 = this.mPendingUpdates.size();
        int v2;
        for(v2 = 0; true; ++v2) {
            v3 = this.mPendingUpdates;
            if(v2 >= v0) {
                break;
            }

            Object v3_1 = v3.get(v2);
            int v4 = ((UpdateOp)v3_1).cmd;
            if(v4 == 1) {
                this.mCallback.onDispatchSecondPass(((UpdateOp)v3_1));
                this.mCallback.offsetPositionsForAdd(((UpdateOp)v3_1).positionStart, ((UpdateOp)v3_1).itemCount);
            }
            else if(v4 == 2) {
                this.mCallback.onDispatchSecondPass(((UpdateOp)v3_1));
                this.mCallback.offsetPositionsForRemovingInvisible(((UpdateOp)v3_1).positionStart, ((UpdateOp)v3_1).itemCount);
            }
            else if(v4 == 4) {
                this.mCallback.onDispatchSecondPass(((UpdateOp)v3_1));
                this.mCallback.markViewHoldersUpdated(((UpdateOp)v3_1).positionStart, ((UpdateOp)v3_1).itemCount, ((UpdateOp)v3_1).payload);
            }
            else if(v4 != 8) {
            }
            else {
                this.mCallback.onDispatchSecondPass(((UpdateOp)v3_1));
                this.mCallback.offsetPositionsForMove(((UpdateOp)v3_1).positionStart, ((UpdateOp)v3_1).itemCount);
            }

            Runnable v3_2 = this.mOnItemProcessedCallback;
            if(v3_2 != null) {
                v3_2.run();
            }
        }

        this.recycleUpdateOpsAndClearList(((List)v3));
        this.mExistingUpdateTypes = 0;
    }

    private void dispatchAndUpdateViewHolders(UpdateOp arg12) {
        if(arg12.cmd != 1 && arg12.cmd != 8) {
            int v0 = this.updatePositionWithPostponed(arg12.positionStart, arg12.cmd);
            int v2 = arg12.positionStart;
            int v3 = arg12.cmd;
            int v4 = 2;
            int v5 = 4;
            if(v3 == v4) {
                v3 = 0;
            }
            else if(v3 == v5) {
                v3 = 1;
            }
            else {
                throw new IllegalArgumentException("op should be remove or update." + arg12);
            }

            int v6 = 1;
            int v7 = 1;
            while(v6 < arg12.itemCount) {
                int v8 = this.updatePositionWithPostponed(arg12.positionStart + v3 * v6, arg12.cmd);
                int v9 = arg12.cmd;
                if(v9 != v4) {
                    if(v9 != v5) {
                        goto label_45;
                    }
                    else if(v8 == v0 + 1) {
                        goto label_43;
                    }
                    else {
                        goto label_45;
                    }
                }
                else if(v8 == v0) {
                label_43:
                    ++v7;
                }
                else {
                label_45:
                    UpdateOp v0_1 = this.obtainUpdateOp(arg12.cmd, v0, v7, arg12.payload);
                    this.dispatchFirstPassAndUpdateViewHolders(v0_1, v2);
                    this.recycleUpdateOp(v0_1);
                    if(arg12.cmd == v5) {
                        v2 += v7;
                    }

                    v7 = 1;
                    v0 = v8;
                }

                ++v6;
            }

            Object v1 = arg12.payload;
            this.recycleUpdateOp(arg12);
            if(v7 > 0) {
                arg12 = this.obtainUpdateOp(arg12.cmd, v0, v7, v1);
                this.dispatchFirstPassAndUpdateViewHolders(arg12, v2);
                this.recycleUpdateOp(arg12);
            }

            return;
        }

        throw new IllegalArgumentException("should not dispatch add or move for pre layout");
    }

    void dispatchFirstPassAndUpdateViewHolders(UpdateOp arg3, int arg4) {
        this.mCallback.onDispatchFirstPass(arg3);
        int v0 = arg3.cmd;
        if(v0 != 2) {
            if(v0 == 4) {
                this.mCallback.markViewHoldersUpdated(arg4, arg3.itemCount, arg3.payload);
                return;
            }

            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }

        this.mCallback.offsetPositionsForRemovingInvisible(arg4, arg3.itemCount);
    }

    int findPositionOffset(int arg5, int arg6) {
        int v0 = this.mPostponedList.size();
        while(arg6 < v0) {
            Object v1 = this.mPostponedList.get(arg6);
            if(((UpdateOp)v1).cmd != 8) {
                if(((UpdateOp)v1).positionStart > arg5) {
                    goto label_38;
                }

                if(((UpdateOp)v1).cmd == 2) {
                    if(arg5 < ((UpdateOp)v1).positionStart + ((UpdateOp)v1).itemCount) {
                        return -1;
                    }

                    arg5 -= ((UpdateOp)v1).itemCount;
                    goto label_38;
                }

                if(((UpdateOp)v1).cmd != 1) {
                    goto label_38;
                }

                arg5 += ((UpdateOp)v1).itemCount;
            }
            else if(((UpdateOp)v1).positionStart == arg5) {
                arg5 = ((UpdateOp)v1).itemCount;
            }
            else {
                if(((UpdateOp)v1).positionStart < arg5) {
                    --arg5;
                }

                if(((UpdateOp)v1).itemCount > arg5) {
                    goto label_38;
                }

                ++arg5;
            }

        label_38:
            ++arg6;
        }

        return arg5;
    }

    int findPositionOffset(int arg2) {
        return this.findPositionOffset(arg2, 0);
    }

    boolean hasAnyUpdateTypes(int arg1) {
        if((this.mExistingUpdateTypes & arg1) != 0) {
            return 1;
        }

        return 0;
    }

    boolean hasPendingUpdates() {
        if(this.mPendingUpdates.size() > 0) {
            return 1;
        }

        return 0;
    }

    boolean hasUpdates() {
        if(!this.mPostponedList.isEmpty() && !this.mPendingUpdates.isEmpty()) {
            return 1;
        }

        return 0;
    }

    public UpdateOp obtainUpdateOp(int arg1, int arg2, int arg3, Object arg4) {
        Object v0 = this.mUpdateOpPool.acquire();
        if(v0 == null) {
            return new UpdateOp(arg1, arg2, arg3, arg4);
        }

        ((UpdateOp)v0).cmd = arg1;
        ((UpdateOp)v0).positionStart = arg2;
        ((UpdateOp)v0).itemCount = arg3;
        ((UpdateOp)v0).payload = arg4;
        return ((UpdateOp)v0);
    }

    boolean onItemRangeChanged(int arg5, int arg6, Object arg7) {
        if(arg6 < 1) {
            return 0;
        }

        this.mPendingUpdates.add(this.obtainUpdateOp(4, arg5, arg6, arg7));
        this.mExistingUpdateTypes |= 4;
        if(this.mPendingUpdates.size() == 1) {
            return 1;
        }

        return 0;
    }

    boolean onItemRangeInserted(int arg5, int arg6) {
        if(arg6 < 1) {
            return 0;
        }

        this.mPendingUpdates.add(this.obtainUpdateOp(1, arg5, arg6, null));
        this.mExistingUpdateTypes |= 1;
        if(this.mPendingUpdates.size() == 1) {
            return 1;
        }

        return 0;
    }

    boolean onItemRangeMoved(int arg5, int arg6, int arg7) {
        if(arg5 == arg6) {
            return 0;
        }

        if(arg7 == 1) {
            this.mPendingUpdates.add(this.obtainUpdateOp(8, arg5, arg6, null));
            this.mExistingUpdateTypes |= 8;
            if(this.mPendingUpdates.size() == 1) {
                return 1;
            }

            return 0;
        }

        throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
    }

    boolean onItemRangeRemoved(int arg6, int arg7) {
        if(arg7 < 1) {
            return 0;
        }

        this.mPendingUpdates.add(this.obtainUpdateOp(2, arg6, arg7, null));
        this.mExistingUpdateTypes |= 2;
        if(this.mPendingUpdates.size() == 1) {
            return 1;
        }

        return 0;
    }

    private void postponeAndUpdateViewHolders(UpdateOp arg3) {
        this.mPostponedList.add(arg3);
        int v0 = arg3.cmd;
        if(v0 != 1) {
            if(v0 != 2) {
                if(v0 != 4) {
                    if(v0 == 8) {
                        this.mCallback.offsetPositionsForMove(arg3.positionStart, arg3.itemCount);
                        return;
                    }

                    throw new IllegalArgumentException("Unknown update op type for " + arg3);
                }

                this.mCallback.markViewHoldersUpdated(arg3.positionStart, arg3.itemCount, arg3.payload);
                return;
            }

            this.mCallback.offsetPositionsForRemovingLaidOutOrNewView(arg3.positionStart, arg3.itemCount);
            return;
        }

        this.mCallback.offsetPositionsForAdd(arg3.positionStart, arg3.itemCount);
    }

    void preProcess() {
        ArrayList v2;
        this.mOpReorderer.reorderOps(this.mPendingUpdates);
        int v0 = this.mPendingUpdates.size();
        int v1;
        for(v1 = 0; true; ++v1) {
            v2 = this.mPendingUpdates;
            if(v1 >= v0) {
                break;
            }

            Object v2_1 = v2.get(v1);
            int v3 = ((UpdateOp)v2_1).cmd;
            if(v3 == 1) {
                this.applyAdd(((UpdateOp)v2_1));
            }
            else if(v3 == 2) {
                this.applyRemove(((UpdateOp)v2_1));
            }
            else if(v3 == 4) {
                this.applyUpdate(((UpdateOp)v2_1));
            }
            else if(v3 != 8) {
            }
            else {
                this.applyMove(((UpdateOp)v2_1));
            }

            Runnable v2_2 = this.mOnItemProcessedCallback;
            if(v2_2 != null) {
                v2_2.run();
            }
        }

        v2.clear();
    }

    public void recycleUpdateOp(UpdateOp arg2) {
        if(!this.mDisableRecycler) {
            arg2.payload = null;
            this.mUpdateOpPool.release(arg2);
        }
    }

    void recycleUpdateOpsAndClearList(List arg4) {
        int v0 = arg4.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            this.recycleUpdateOp(arg4.get(v1));
        }

        arg4.clear();
    }

    void reset() {
        this.recycleUpdateOpsAndClearList(this.mPendingUpdates);
        this.recycleUpdateOpsAndClearList(this.mPostponedList);
        this.mExistingUpdateTypes = 0;
    }

    private int updatePositionWithPostponed(int arg7, int arg8) {
        int v4;
        int v0;
        for(v0 = this.mPostponedList.size() - 1; true; --v0) {
            ArrayList v2 = this.mPostponedList;
            int v3 = 8;
            if(v0 < 0) {
                break;
            }

            Object v2_1 = v2.get(v0);
            int v5 = 2;
            if(((UpdateOp)v2_1).cmd == v3) {
                if(((UpdateOp)v2_1).positionStart < ((UpdateOp)v2_1).itemCount) {
                    v3 = ((UpdateOp)v2_1).positionStart;
                    v4 = ((UpdateOp)v2_1).itemCount;
                }
                else {
                    v3 = ((UpdateOp)v2_1).itemCount;
                    v4 = ((UpdateOp)v2_1).positionStart;
                }

                if(arg7 >= v3 && arg7 <= v4) {
                    if(v3 == ((UpdateOp)v2_1).positionStart) {
                        if(arg8 == 1) {
                            ++((UpdateOp)v2_1).itemCount;
                        }
                        else if(arg8 == v5) {
                            --((UpdateOp)v2_1).itemCount;
                        }

                        ++arg7;
                    }
                    else {
                        if(arg8 == 1) {
                            ++((UpdateOp)v2_1).positionStart;
                        }
                        else if(arg8 == v5) {
                            --((UpdateOp)v2_1).positionStart;
                        }

                        --arg7;
                    }

                    goto label_84;
                }

                if(arg7 >= ((UpdateOp)v2_1).positionStart) {
                    goto label_84;
                }

                if(arg8 == 1) {
                    ++((UpdateOp)v2_1).positionStart;
                    ++((UpdateOp)v2_1).itemCount;
                    goto label_84;
                }

                if(arg8 != v5) {
                    goto label_84;
                }

                --((UpdateOp)v2_1).positionStart;
                --((UpdateOp)v2_1).itemCount;
            }
            else {
                if(((UpdateOp)v2_1).positionStart <= arg7) {
                    if(((UpdateOp)v2_1).cmd == 1) {
                        arg7 -= ((UpdateOp)v2_1).itemCount;
                        goto label_84;
                    }

                    if(((UpdateOp)v2_1).cmd != v5) {
                        goto label_84;
                    }

                    arg7 += ((UpdateOp)v2_1).itemCount;
                    goto label_84;
                }

                if(arg8 == 1) {
                    ++((UpdateOp)v2_1).positionStart;
                    goto label_84;
                }

                if(arg8 != v5) {
                    goto label_84;
                }

                --((UpdateOp)v2_1).positionStart;
            }

        label_84:
        }

        for(arg8 = v2.size() - 1; arg8 >= 0; --arg8) {
            Object v0_1 = this.mPostponedList.get(arg8);
            if(((UpdateOp)v0_1).cmd == v3) {
                if(((UpdateOp)v0_1).itemCount != ((UpdateOp)v0_1).positionStart && ((UpdateOp)v0_1).itemCount >= 0) {
                    goto label_107;
                }

                this.mPostponedList.remove(arg8);
                this.recycleUpdateOp(((UpdateOp)v0_1));
            }
            else {
                if(((UpdateOp)v0_1).itemCount > 0) {
                    goto label_107;
                }

                this.mPostponedList.remove(arg8);
                this.recycleUpdateOp(((UpdateOp)v0_1));
            }

        label_107:
        }

        return arg7;
    }
}

