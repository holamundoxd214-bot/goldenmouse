package androidx.compose.ui.platform;

import androidx.collection.IntObjectMap;
import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableObjectList;
import androidx.collection.ObjectList;
import androidx.compose.runtime.CancellationHandle;
import androidx.compose.runtime.retain.RetainedValuesStore;
import androidx.lifecycle.ViewModel;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001:\u0002\r\u000EB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\b\u001A\u00020\u00072\u0006\u0010\t\u001A\u00020\nJ\b\u0010\u000B\u001A\u00020\fH\u0014R\u001A\u0010\u0004\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000F"}, d2={"Landroidx/compose/ui/platform/LifecycleRetainedValuesStoreOwner;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "scopes", "Landroidx/collection/MutableIntObjectMap;", "Landroidx/collection/MutableObjectList;", "Landroidx/compose/ui/platform/LifecycleRetainedValuesStoreOwner$RetainedValuesStoreEntry;", "getOrCreateRetainedValuesStoreEntry", "viewId", "", "onCleared", "", "RetainedValuesStoreEntry", "FrameEndScheduler", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LifecycleRetainedValuesStoreOwner extends ViewModel {
    @Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001A\u00020\u00032\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2={"Landroidx/compose/ui/platform/LifecycleRetainedValuesStoreOwner$FrameEndScheduler;", "", "scheduleFrameEndCallback", "Landroidx/compose/runtime/CancellationHandle;", "action", "Lkotlin/Function0;", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public interface FrameEndScheduler {
        CancellationHandle scheduleFrameEndCallback(Function0 arg1);
    }

    @Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0014\u001A\u00020\u0015J\u000E\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u0017\u001A\u00020\u0018J\u0006\u0010\u0019\u001A\u00020\u0015J\u0006\u0010\u001A\u001A\u00020\u0015R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u001A\u0010\n\u001A\u00020\u000BX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000ER\"\u0010\u0011\u001A\u0004\u0018\u00010\u00102\b\u0010\u000F\u001A\u0004\u0018\u00010\u0010@BX\u0082\u000E¢\u0006\b\n\u0000\"\u0004\b\u0012\u0010\u0013¨\u0006\u001B"}, d2={"Landroidx/compose/ui/platform/LifecycleRetainedValuesStoreOwner$RetainedValuesStoreEntry;", "", "<init>", "()V", "_retainedValuesStore", "Landroidx/compose/ui/platform/LifecycleRetainedValuesStore;", "retainedValuesStore", "Landroidx/compose/runtime/retain/RetainedValuesStore;", "getRetainedValuesStore", "()Landroidx/compose/runtime/retain/RetainedValuesStore;", "isInUse", "", "()Z", "setInUse", "(Z)V", "value", "Landroidx/compose/runtime/CancellationHandle;", "endRetainCancellationHandle", "setEndRetainCancellationHandle", "(Landroidx/compose/runtime/CancellationHandle;)V", "startRetainingExitedValues", "", "stopRetainingExitedValues", "frameEndScheduler", "Landroidx/compose/ui/platform/LifecycleRetainedValuesStoreOwner$FrameEndScheduler;", "onCleared", "release", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class RetainedValuesStoreEntry {
        public static final int $stable = 8;
        private final LifecycleRetainedValuesStore _retainedValuesStore;
        private CancellationHandle endRetainCancellationHandle;
        private boolean isInUse;
        private final RetainedValuesStore retainedValuesStore;

        static {
        }

        public RetainedValuesStoreEntry() {
            super();
            LifecycleRetainedValuesStore v0 = new LifecycleRetainedValuesStore(null, 1, null);
            this._retainedValuesStore = v0;
            this.retainedValuesStore = ((RetainedValuesStore)v0);
        }

        public static final LifecycleRetainedValuesStore access$get_retainedValuesStore$p(RetainedValuesStoreEntry arg0) {
            return arg0._retainedValuesStore;
        }

        public final RetainedValuesStore getRetainedValuesStore() {
            return this.retainedValuesStore;
        }

        public final boolean isInUse() {
            return this.isInUse;
        }

        public final void onCleared() {
            this.setEndRetainCancellationHandle(null);
            this._retainedValuesStore.dispose();
        }

        public final void release() {
            this.isInUse = false;
        }

        private final void setEndRetainCancellationHandle(CancellationHandle arg2) {
            CancellationHandle v0 = this.endRetainCancellationHandle;
            if(v0 != null) {
                v0.cancel();
            }

            this.endRetainCancellationHandle = arg2;
        }

        public final void setInUse(boolean arg1) {
            this.isInUse = arg1;
        }

        public final void startRetainingExitedValues() {
            if(!this._retainedValuesStore.isRetainingExitedValues()) {
                this._retainedValuesStore.startLifecycleTransition();
                return;
            }

            this.setEndRetainCancellationHandle(null);
        }

        public final void stopRetainingExitedValues(FrameEndScheduler arg2) {
            CancellationHandle v2;
            if(this._retainedValuesStore.isRetainingExitedValues()) {
                try {
                    v2 = arg2.scheduleFrameEndCallback(new LifecycleRetainedValuesStoreOwner$RetainedValuesStoreEntry$stopRetainingExitedValues$1(this));
                }
                catch(CancellationException ) {
                    this._retainedValuesStore.endLifecycleTransition();
                    v2 = null;
                }

                this.setEndRetainCancellationHandle(v2);
            }
        }
    }

    public static final int $stable = 8;
    private final MutableIntObjectMap scopes;

    static {
    }

    public LifecycleRetainedValuesStoreOwner() {
        super();
        this.scopes = IntObjectMapKt.mutableIntObjectMapOf();
    }

    public final RetainedValuesStoreEntry getOrCreateRetainedValuesStoreEntry(int arg6) {
        Object v3;
        MutableIntObjectMap v5 = this.scopes;
        Object v0 = v5.get(arg6);
        if(v0 == null) {
            MutableObjectList v0_1 = new MutableObjectList(1);
            v5.set(arg6, v0_1);
        }

        Object[] v6 = v0.content;
        int v5_1 = v0._size;
        int v2 = 0;
        while(true) {
            if(v2 < v5_1) {
                v3 = v6[v2];
                if(!v3.isInUse()) {
                }
                else {
                    ++v2;
                    continue;
                }
            }
            else {
                break;
            }

            goto label_20;
        }

        v3 = null;
    label_20:
        if(v3 == null) {
            RetainedValuesStoreEntry v3_1 = new RetainedValuesStoreEntry();
            ((MutableObjectList)v0).add(v3_1);
        }

        ((RetainedValuesStoreEntry)v3).setInUse(true);
        return ((RetainedValuesStoreEntry)v3);
    }

    protected void onCleared() {
        MutableIntObjectMap v14 = this.scopes;
        int[] v0 = ((IntObjectMap)v14).keys;
        Object[] v1 = ((IntObjectMap)v14).values;
        long[] v14_1 = ((IntObjectMap)v14).metadata;
        int v2 = v14_1.length - 2;
        if(v2 >= 0) {
            int v4;
            for(v4 = 0; true; ++v4) {
                long v5 = v14_1[v4];
                if((~v5 << 7 & v5 & -9187201950435737472L) != -9187201950435737472L) {
                    int v8 = 8;
                    int v7 = 8 - (~(v4 - v2) >>> 0x1F);
                    int v9;
                    for(v9 = 0; v9 < v7; ++v9) {
                        if((0xFF & v5) < 0x80) {
                            Object v10 = v1[(v4 << 3) + v9];
                            Object[] v11 = ((ObjectList)v10).content;
                            int v10_1 = ((ObjectList)v10)._size;
                            int v12;
                            for(v12 = 0; v12 < v10_1; ++v12) {
                                v11[v12].onCleared();
                            }
                        }

                        v5 >>= v8;
                    }

                    if(v7 != v8) {
                        return;
                    }
                }

                if(v4 == v2) {
                    return;
                }
            }
        }
    }
}

