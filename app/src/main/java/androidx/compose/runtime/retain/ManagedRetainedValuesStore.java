package androidx.compose.runtime.retain;

import androidx.collection.MutableObjectList;
import androidx.collection.MutableScatterMap;
import androidx.collection.ObjectList;
import androidx.collection.ScatterMap;
import androidx.compose.runtime.retain.impl.PreconditionsKt;
import androidx.compose.runtime.retain.impl.SafeMultiValueMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000B\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000E\u001A\u00020\u000FJ\u0006\u0010\u0010\u001A\u00020\u000FJ\u0006\u0010\u0011\u001A\u00020\u000FJ\b\u0010\u0012\u001A\u00020\u000FH\u0016J\b\u0010\u0013\u001A\u00020\u000FH\u0016J\b\u0010\u0014\u001A\u00020\u000FH\u0002J\u001C\u0010\u0015\u001A\u0004\u0018\u00010\n2\u0006\u0010\u0016\u001A\u00020\n2\b\u0010\u0017\u001A\u0004\u0018\u00010\nH\u0016J\u001A\u0010\u0018\u001A\u00020\u000F2\u0006\u0010\u0016\u001A\u00020\n2\b\u0010\u0019\u001A\u0004\u0018\u00010\nH\u0016R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u001E\u0010\b\u001A\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000BR\u0011\u0010\f\u001A\u00020\u00058F¢\u0006\u0006\u001A\u0004\b\f\u0010\r¨\u0006\u001A"}, d2={"Landroidx/compose/runtime/retain/ManagedRetainedValuesStore;", "Landroidx/compose/runtime/retain/RetainedValuesStore;", "<init>", "()V", "isEnabled", "", "isDisposed", "isContentComposed", "keptExitedValues", "Landroidx/compose/runtime/retain/impl/SafeMultiValueMap;", "", "Landroidx/collection/MutableScatterMap;", "isRetainingExitedValues", "()Z", "enableRetainingExitedValues", "", "disableRetainingExitedValues", "dispose", "onContentExitComposition", "onContentEnteredComposition", "purgeUnusedExitedValues", "consumeExitedValueOrDefault", "key", "defaultValue", "saveExitingValue", "value", "runtime-retain"}, k=1, mv={2, 1, 0}, xi=0x30) public final class ManagedRetainedValuesStore implements RetainedValuesStore {
    public static final int $stable = 8;
    private boolean isContentComposed;
    private boolean isDisposed;
    private boolean isEnabled;
    private final MutableScatterMap keptExitedValues;

    static {
    }

    public ManagedRetainedValuesStore() {
        super();
        this.isEnabled = true;
        this.keptExitedValues = SafeMultiValueMap.constructor-impl$default(null, 1, null);
    }

    public Object consumeExitedValueOrDefault(Object arg1, Object arg2) {
        return SafeMultiValueMap.removeLast-impl(this.keptExitedValues, arg1, arg2);
    }

    public final void disableRetainingExitedValues() {
        this.isEnabled = false;
        this.purgeUnusedExitedValues();
    }

    public final void dispose() {
        this.isDisposed = true;
        this.disableRetainingExitedValues();
    }

    public final void enableRetainingExitedValues() {
        if(this.isDisposed) {
            PreconditionsKt.throwIllegalStateException("Cannot call enableRetainingExitedValues on a disposed store");
        }

        this.isEnabled = true;
    }

    public final boolean isRetainingExitedValues() {
        if((this.isEnabled) && !this.isContentComposed) {
            return 1;
        }

        return 0;
    }

    public void onContentEnteredComposition() {
        if(this.isDisposed) {
            return;
        }

        if(this.isContentComposed) {
            PreconditionsKt.throwIllegalStateException("ManagedValuesStore tried to enter composition twice. Did you attempt to install the same store multiple times or into two compositions?");
        }

        this.purgeUnusedExitedValues();
        this.isContentComposed = true;
    }

    public void onContentExitComposition() {
        if(this.isDisposed) {
            return;
        }

        if(!this.isContentComposed) {
            PreconditionsKt.throwIllegalStateException("ManagedValuesStore tried to leave composition twice. Is the store installed in multiple places?");
        }

        if(!SafeMultiValueMap.isEmpty-impl(this.keptExitedValues)) {
            PreconditionsKt.throwIllegalStateException("Attempted to start retaining exited values with pending exited values");
        }

        this.isContentComposed = false;
    }

    private final void purgeUnusedExitedValues() {
        MutableScatterMap v0 = this.keptExitedValues;
        Object[] v1 = ((ScatterMap)v0).values;
        long[] v0_1 = ((ScatterMap)v0).metadata;
        int v2 = v0_1.length - 2;
        if(v2 >= 0) {
            int v4;
            for(v4 = 0; true; ++v4) {
                long v5 = v0_1[v4];
                if((~v5 << 7 & v5 & -9187201950435737472L) != -9187201950435737472L) {
                    int v8 = 8;
                    int v7 = 8 - (~(v4 - v2) >>> 0x1F);
                    int v9;
                    for(v9 = 0; v9 < v7; ++v9) {
                        if((0xFF & v5) < 0x80) {
                            Object v10 = v1[(v4 << 3) + v9];
                            if((v10 instanceof MutableObjectList)) {
                                Intrinsics.checkNotNull(v10, "null cannot be cast to non-null type androidx.collection.MutableObjectList<V of androidx.compose.runtime.retain.impl.SafeMultiValueMap>");
                                Object[] v11 = ((ObjectList)v10).content;
                                int v10_1 = ((ObjectList)v10)._size;
                                int v12;
                                for(v12 = 0; v12 < v10_1; ++v12) {
                                    Object v13 = v11[v12];
                                    if((v13 instanceof RetainObserver)) {
                                        ((RetainObserver)v13).onRetired();
                                    }
                                }
                            }
                            else {
                                if(!(v10 instanceof RetainObserver)) {
                                    goto label_47;
                                }

                                ((RetainObserver)v10).onRetired();
                            }
                        }

                    label_47:
                        v5 >>= v8;
                    }

                    if(v7 != v8) {
                        break;
                    }
                }

                if(v4 == v2) {
                    break;
                }
            }
        }

        SafeMultiValueMap.clear-impl(this.keptExitedValues);
    }

    public void saveExitingValue(Object arg2, Object arg3) {
        if(this.isRetainingExitedValues()) {
            SafeMultiValueMap.add-impl(this.keptExitedValues, arg2, arg3);
            return;
        }

        if((arg3 instanceof RetainObserver)) {
            ((RetainObserver)arg3).onRetired();
        }
    }
}

