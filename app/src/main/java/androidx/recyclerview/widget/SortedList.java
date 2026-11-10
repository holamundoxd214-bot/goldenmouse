package androidx.recyclerview.widget;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class SortedList {
    public class BatchedCallback extends Callback {
        private final BatchingListUpdateCallback mBatchingListUpdateCallback;
        final Callback mWrappedCallback;

        public BatchedCallback(Callback arg2) {
            super();
            this.mWrappedCallback = arg2;
            this.mBatchingListUpdateCallback = new BatchingListUpdateCallback(((ListUpdateCallback)arg2));
        }

        public boolean areContentsTheSame(Object arg1, Object arg2) {
            return this.mWrappedCallback.areContentsTheSame(arg1, arg2);
        }

        public boolean areItemsTheSame(Object arg1, Object arg2) {
            return this.mWrappedCallback.areItemsTheSame(arg1, arg2);
        }

        public int compare(Object arg1, Object arg2) {
            return this.mWrappedCallback.compare(arg1, arg2);
        }

        public void dispatchLastEvent() {
            this.mBatchingListUpdateCallback.dispatchLastEvent();
        }

        public Object getChangePayload(Object arg1, Object arg2) {
            return this.mWrappedCallback.getChangePayload(arg1, arg2);
        }

        public void onChanged(int arg2, int arg3) {
            this.mBatchingListUpdateCallback.onChanged(arg2, arg3, null);
        }

        public void onChanged(int arg1, int arg2, Object arg3) {
            this.mBatchingListUpdateCallback.onChanged(arg1, arg2, arg3);
        }

        public void onInserted(int arg1, int arg2) {
            this.mBatchingListUpdateCallback.onInserted(arg1, arg2);
        }

        public void onMoved(int arg1, int arg2) {
            this.mBatchingListUpdateCallback.onMoved(arg1, arg2);
        }

        public void onRemoved(int arg1, int arg2) {
            this.mBatchingListUpdateCallback.onRemoved(arg1, arg2);
        }
    }

    public abstract class Callback implements ListUpdateCallback, Comparator {
        public Callback() {
            super();
        }

        public abstract boolean areContentsTheSame(Object arg1, Object arg2);

        public abstract boolean areItemsTheSame(Object arg1, Object arg2);

        public abstract int compare(Object arg1, Object arg2);

        public Object getChangePayload(Object arg1, Object arg2) {
            return null;
        }

        public void onChanged(int arg1, int arg2, Object arg3) {
            this.onChanged(arg1, arg2);
        }

        public abstract void onChanged(int arg1, int arg2);
    }

    private static final int CAPACITY_GROWTH = 10;
    private static final int DELETION = 2;
    private static final int INSERTION = 1;
    public static final int INVALID_POSITION = -1;
    private static final int LOOKUP = 4;
    private static final int MIN_CAPACITY = 10;
    private BatchedCallback mBatchedCallback;
    private Callback mCallback;
    Object[] mData;
    private int mNewDataStart;
    private Object[] mOldData;
    private int mOldDataSize;
    private int mOldDataStart;
    private int mSize;
    private final Class mTClass;

    public SortedList(Class arg2, Callback arg3) {
        this(arg2, arg3, 10);
    }

    public SortedList(Class arg1, Callback arg2, int arg3) {
        super();
        this.mTClass = arg1;
        this.mData = Array.newInstance(arg1, arg3);
        this.mCallback = arg2;
        this.mSize = 0;
    }

    private int add(Object arg7, boolean arg8) {
        SortedList v0 = this;
        Object v1 = arg7;
        int v6 = v0.findIndexOf(v1, this.mData, 0, this.mSize, 1);
        if(v6 == -1) {
            v6 = 0;
        }
        else if(v6 < v0.mSize) {
            arg7 = v0.mData[v6];
            if(v0.mCallback.areItemsTheSame(arg7, v1)) {
                arg8 = v0.mCallback.areContentsTheSame(arg7, v1);
                Object[] v3 = v0.mData;
                if(arg8) {
                    v3[v6] = v1;
                    return v6;
                }
                else {
                    v3[v6] = v1;
                    v0.mCallback.onChanged(v6, 1, v0.mCallback.getChangePayload(arg7, v1));
                    return v6;
                }
            }
        }

        v0.addToData(v6, v1);
        if(arg8) {
            v0.mCallback.onInserted(v6, 1);
        }

        return v6;
    }

    public int add(Object arg2) {
        this.throwIfInMutationOperation();
        return this.add(arg2, true);
    }

    public void addAll(Collection arg3) {
        this.addAll(arg3.toArray(Array.newInstance(this.mTClass, arg3.size())), true);
    }

    public void addAll(Object[] arg2, boolean arg3) {
        this.throwIfInMutationOperation();
        if(arg2.length == 0) {
            return;
        }

        if(arg3) {
            this.addAllInternal(arg2);
            return;
        }

        this.addAllInternal(this.copyArray(arg2));
    }

    public void addAll(Object[] arg2) {
        this.addAll(arg2, false);
    }

    private void addAllInternal(Object[] arg3) {
        if(arg3.length < 1) {
            return;
        }

        int v0 = this.sortAndDedup(arg3);
        if(this.mSize == 0) {
            this.mData = arg3;
            this.mSize = v0;
            this.mCallback.onInserted(0, v0);
            return;
        }

        this.merge(arg3, v0);
    }

    private void addToData(int arg4, Object arg5) {
        int v0 = this.mSize;
        if(arg4 <= v0) {
            Object[] v1 = this.mData;
            if(v0 == v1.length) {
                Object v0_1 = Array.newInstance(this.mTClass, v1.length + 10);
                System.arraycopy(this.mData, 0, v0_1, 0, arg4);
                v0_1[arg4] = arg5;
                System.arraycopy(this.mData, arg4, v0_1, arg4 + 1, this.mSize - arg4);
                this.mData = ((Object[])v0_1);
            }
            else {
                System.arraycopy(v1, arg4, v1, arg4 + 1, v0 - arg4);
                this.mData[arg4] = arg5;
            }

            ++this.mSize;
            return;
        }

        throw new IndexOutOfBoundsException("cannot add item to " + arg4 + " because size is " + this.mSize);
    }

    public void beginBatchedUpdates() {
        this.throwIfInMutationOperation();
        if((this.mCallback instanceof BatchedCallback)) {
            return;
        }

        BatchedCallback v0 = this.mBatchedCallback;
        if(v0 == null) {
            v0 = new BatchedCallback(this.mCallback);
            this.mBatchedCallback = v0;
        }

        this.mCallback = ((Callback)v0);
    }

    public void clear() {
        this.throwIfInMutationOperation();
        int v0 = this.mSize;
        if(v0 == 0) {
            return;
        }

        Arrays.fill(this.mData, 0, v0, null);
        this.mSize = 0;
        this.mCallback.onRemoved(0, v0);
    }

    private Object[] copyArray(Object[] arg3) {
        Object v2 = Array.newInstance(this.mTClass, arg3.length);
        System.arraycopy(arg3, 0, v2, 0, arg3.length);
        return ((Object[])v2);
    }

    public void endBatchedUpdates() {
        this.throwIfInMutationOperation();
        Callback v0 = this.mCallback;
        if((v0 instanceof BatchedCallback)) {
            ((BatchedCallback)v0).dispatchLastEvent();
        }

        v0 = this.mCallback;
        BatchedCallback v1 = this.mBatchedCallback;
        if(v0 == (((Callback)v1))) {
            this.mCallback = v1.mWrappedCallback;
        }
    }

    private int findIndexOf(Object arg6, Object[] arg7, int arg8, int arg9, int arg10) {
        int v0;
        while(true) {
            v0 = -1;
            if(arg8 >= arg9) {
                break;
            }

            int v2 = (arg8 + arg9) / 2;
            Object v3 = arg7[v2];
            int v4 = this.mCallback.compare(v3, arg6);
            if(v4 < 0) {
                arg8 = v2 + 1;
                continue;
            }

            if(v4 == 0) {
                if(this.mCallback.areItemsTheSame(v3, arg6)) {
                }
                else {
                    int v5 = this.linearEqualitySearch(arg6, v2, arg8, arg9);
                    if(arg10 == 1 && v5 == v0) {
                        return v2;
                    }

                    return v5;
                }

                return v2;
            }

            arg9 = v2;
        }

        if(arg10 == 1) {
            return arg8;
        }

        return v0;
    }

    private int findSameItem(Object arg3, Object[] arg4, int arg5, int arg6) {
        while(arg5 < arg6) {
            if(this.mCallback.areItemsTheSame(arg4[arg5], arg3)) {
                return arg5;
            }

            ++arg5;
        }

        return -1;
    }

    public Object get(int arg4) throws IndexOutOfBoundsException {
        if(arg4 < this.mSize && arg4 >= 0) {
            Object[] v0 = this.mOldData;
            if(v0 != null) {
                int v1 = this.mNewDataStart;
                if(arg4 >= v1) {
                    return v0[arg4 - v1 + this.mOldDataStart];
                }
            }

            return this.mData[arg4];
        }

        throw new IndexOutOfBoundsException("Asked to get item at " + arg4 + " but size is " + this.mSize);
    }

    public int indexOf(Object arg8) {
        Object[] v0 = this.mOldData;
        Object[] v3 = this.mData;
        if(v0 != null) {
            SortedList v1 = this;
            Object v2 = arg8;
            int v7 = v1.findIndexOf(v2, v3, 0, this.mNewDataStart, 4);
            int v8 = -1;
            if(v7 != v8) {
                return v7;
            }

            v7 = v1.findIndexOf(v2, v1.mOldData, v1.mOldDataStart, v1.mOldDataSize, 4);
            v1 = v1;
            if(v7 != v8) {
                return v7 - v1.mOldDataStart + v1.mNewDataStart;
            }

            return v8;
        }

        return this.findIndexOf(arg8, v3, 0, this.mSize, 4);
    }

    private int linearEqualitySearch(Object arg4, int arg5, int arg6, int arg7) {
        int v0 = arg5 - 1;
        while(v0 >= arg6) {
            Object v1 = this.mData[v0];
            if(this.mCallback.compare(v1, arg4) != 0) {
            }
            else if(this.mCallback.areItemsTheSame(v1, arg4)) {
                return v0;
            }
            else {
                --v0;
                continue;
            }

            break;
        }

        do {
            ++arg5;
            if(arg5 < arg7) {
                Object v6 = this.mData[arg5];
                if(this.mCallback.compare(v6, arg4) != 0) {
                }
                else {
                    if(!this.mCallback.areItemsTheSame(v6, arg4)) {
                        continue;
                    }

                    return arg5;
                }
            }

            return -1;
        }
        while(true);

        return arg5;
    }

    private void merge(Object[] arg9, int arg10) {
        Object[] v4;
        boolean v0 = this.mCallback instanceof BatchedCallback;
        if(!v0) {
            this.beginBatchedUpdates();
        }

        this.mOldData = this.mData;
        int v1 = 0;
        this.mOldDataStart = 0;
        int v2 = this.mSize;
        this.mOldDataSize = v2;
        this.mData = Array.newInstance(this.mTClass, v2 + arg10 + 10);
        this.mNewDataStart = 0;
        while(true) {
            v2 = this.mOldDataStart;
            int v3 = this.mOldDataSize;
            if(v2 < v3 || v1 < arg10) {
                if(v2 == v3) {
                    arg10 -= v1;
                    System.arraycopy(arg9, v1, this.mData, this.mNewDataStart, arg10);
                    int v9 = this.mNewDataStart + arg10;
                    this.mNewDataStart = v9;
                    this.mSize += arg10;
                    this.mCallback.onInserted(v9 - arg10, arg10);
                }
                else {
                    v4 = this.mOldData;
                    if(v1 == arg10) {
                        v3 -= v2;
                        System.arraycopy(v4, v2, this.mData, this.mNewDataStart, v3);
                        this.mNewDataStart += v3;
                    }
                    else {
                        goto label_49;
                    }
                }
            }

            this.mOldData = null;
            if(!v0) {
                this.endBatchedUpdates();
            }

            return;
        label_49:
            Object v2_1 = v4[v2];
            Object v3_1 = arg9[v1];
            int v4_1 = this.mCallback.compare(v2_1, v3_1);
            if(v4_1 > 0) {
                Object[] v2_2 = this.mData;
                v4_1 = this.mNewDataStart;
                this.mNewDataStart = v4_1 + 1;
                v2_2[v4_1] = v3_1;
                ++this.mSize;
                ++v1;
                this.mCallback.onInserted(v4_1, 1);
                continue;
            }

            if(v4_1 == 0 && (this.mCallback.areItemsTheSame(v2_1, v3_1))) {
                v4 = this.mData;
                int v6 = this.mNewDataStart;
                this.mNewDataStart = v6 + 1;
                v4[v6] = v3_1;
                ++v1;
                ++this.mOldDataStart;
                if(this.mCallback.areContentsTheSame(v2_1, v3_1)) {
                    continue;
                }

                this.mCallback.onChanged(this.mNewDataStart - 1, 1, this.mCallback.getChangePayload(v2_1, v3_1));
                continue;
            }

            Object[] v3_2 = this.mData;
            v4_1 = this.mNewDataStart;
            this.mNewDataStart = v4_1 + 1;
            v3_2[v4_1] = v2_1;
            ++this.mOldDataStart;
        }
    }

    public void recalculatePositionOfItemAt(int arg3) {
        this.throwIfInMutationOperation();
        Object v0 = this.get(arg3);
        this.removeItemAtIndex(arg3, false);
        int v0_1 = this.add(v0, false);
        if(arg3 != v0_1) {
            this.mCallback.onMoved(arg3, v0_1);
        }
    }

    private boolean remove(Object arg7, boolean arg8) {
        SortedList v0 = this;
        int v6 = v0.findIndexOf(arg7, this.mData, 0, this.mSize, 2);
        if(v6 == -1) {
            return 0;
        }

        v0.removeItemAtIndex(v6, arg8);
        return 1;
    }

    public boolean remove(Object arg2) {
        this.throwIfInMutationOperation();
        return this.remove(arg2, true);
    }

    public Object removeItemAt(int arg3) {
        this.throwIfInMutationOperation();
        Object v0 = this.get(arg3);
        this.removeItemAtIndex(arg3, true);
        return v0;
    }

    private void removeItemAtIndex(int arg5, boolean arg6) {
        System.arraycopy(this.mData, arg5 + 1, this.mData, arg5, this.mSize - arg5 - 1);
        int v0 = this.mSize - 1;
        this.mSize = v0;
        this.mData[v0] = null;
        if(arg6) {
            this.mCallback.onRemoved(arg5, 1);
        }
    }

    public void replaceAll(Collection arg3) {
        this.replaceAll(arg3.toArray(Array.newInstance(this.mTClass, arg3.size())), true);
    }

    public void replaceAll(Object[] arg1, boolean arg2) {
        this.throwIfInMutationOperation();
        if(arg2) {
            this.replaceAllInternal(arg1);
            return;
        }

        this.replaceAllInternal(this.copyArray(arg1));
    }

    public void replaceAll(Object[] arg2) {
        this.replaceAll(arg2, false);
    }

    private void replaceAllInsert(Object arg3) {
        Object[] v0 = this.mData;
        int v1 = this.mNewDataStart;
        v0[v1] = arg3;
        this.mNewDataStart = v1 + 1;
        ++this.mSize;
        this.mCallback.onInserted(v1, 1);
    }

    private void replaceAllInternal(Object[] arg8) {
        int v4;
        int v3;
        boolean v0 = this.mCallback instanceof BatchedCallback;
        if(!v0) {
            this.beginBatchedUpdates();
        }

        this.mOldDataStart = 0;
        this.mOldDataSize = this.mSize;
        this.mOldData = this.mData;
        this.mNewDataStart = 0;
        int v1 = this.sortAndDedup(arg8);
        this.mData = Array.newInstance(this.mTClass, v1);
        while(true) {
            int v2 = this.mNewDataStart;
            if(v2 < v1 || this.mOldDataStart < this.mOldDataSize) {
                v3 = this.mOldDataStart;
                v4 = this.mOldDataSize;
                if(v3 >= v4) {
                    v1 -= v2;
                    System.arraycopy(arg8, v2, this.mData, v2, v1);
                    this.mNewDataStart += v1;
                    this.mSize += v1;
                    this.mCallback.onInserted(v2, v1);
                }
                else if(v2 >= v1) {
                    v4 -= v3;
                    this.mSize -= v4;
                    this.mCallback.onRemoved(v2, v4);
                }
                else {
                    goto label_47;
                }
            }

            this.mOldData = null;
            if(!v0) {
                this.endBatchedUpdates();
            }

            return;
        label_47:
            Object v3_1 = this.mOldData[v3];
            Object v2_1 = arg8[v2];
            v4 = this.mCallback.compare(v3_1, v2_1);
            if(v4 < 0) {
                this.replaceAllRemove();
                continue;
            }

            if(v4 > 0) {
                this.replaceAllInsert(v2_1);
                continue;
            }

            if(!this.mCallback.areItemsTheSame(v3_1, v2_1)) {
                this.replaceAllRemove();
                this.replaceAllInsert(v2_1);
                continue;
            }

            Object[] v4_1 = this.mData;
            int v5 = this.mNewDataStart;
            v4_1[v5] = v2_1;
            ++this.mOldDataStart;
            this.mNewDataStart = v5 + 1;
            if(this.mCallback.areContentsTheSame(v3_1, v2_1)) {
                continue;
            }

            this.mCallback.onChanged(this.mNewDataStart - 1, 1, this.mCallback.getChangePayload(v3_1, v2_1));
        }
    }

    private void replaceAllRemove() {
        --this.mSize;
        ++this.mOldDataStart;
        this.mCallback.onRemoved(this.mNewDataStart, 1);
    }

    public int size() {
        return this.mSize;
    }

    private int sortAndDedup(Object[] arg8) {
        if(arg8.length == 0) {
            return 0;
        }

        Arrays.sort(arg8, this.mCallback);
        int v0 = 1;
        int v2 = 0;
        int v1 = 1;
        while(v0 < arg8.length) {
            Object v3 = arg8[v0];
            if(this.mCallback.compare(arg8[v2], v3) == 0) {
                int v4 = this.findSameItem(v3, arg8, v2, v1);
                if(v4 != -1) {
                    arg8[v4] = v3;
                }
                else {
                    if(v1 != v0) {
                        arg8[v1] = v3;
                    }

                    ++v1;
                }
            }
            else {
                if(v1 != v0) {
                    arg8[v1] = v3;
                }

                v2 = v1;
                ++v1;
            }

            ++v0;
        }

        return v1;
    }

    private void throwIfInMutationOperation() {
        if(this.mOldData == null) {
            return;
        }

        throw new IllegalStateException("Data cannot be mutated in the middle of a batch update operation such as addAll or replaceAll.");
    }

    public void updateItemAt(int arg6, Object arg7) {
        this.throwIfInMutationOperation();
        Object v0 = this.get(arg6);
        int v3 = v0 == arg7 || !this.mCallback.areContentsTheSame(v0, arg7) ? 1 : 0;
        if(v0 == arg7 || this.mCallback.compare(v0, arg7) != 0) {
            if(v3 != 0) {
                this.mCallback.onChanged(arg6, 1, this.mCallback.getChangePayload(v0, arg7));
            }

            this.removeItemAtIndex(arg6, false);
            int v7 = this.add(arg7, false);
            if(arg6 == v7) {
                return;
            }

            this.mCallback.onMoved(arg6, v7);
        }
        else {
            this.mData[arg6] = arg7;
            if(v3 != 0) {
                this.mCallback.onChanged(arg6, 1, this.mCallback.getChangePayload(v0, arg7));
                return;
            }
        }
    }
}

