package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet$Builder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000R\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001AC\u0010\f\u001A\u0002H\r\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u001D\u0010\u000E\u001A\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0007\u0012\u0004\u0012\u0002H\r0\u000F¢\u0006\u0002\b\u0010H\u0080\b¢\u0006\u0002\u0010\u0011\u001AC\u0010\u0012\u001A\u0002H\r\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u001D\u0010\u000E\u001A\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0007\u0012\u0004\u0012\u0002H\r0\u000F¢\u0006\u0002\b\u0010H\u0080\b¢\u0006\u0002\u0010\u0011\u001A2\u0010\u0013\u001A\u00020\u0014\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0018\u0010\u000E\u001A\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0015\u0012\u0004\u0012\u00020\u00140\u000FH\u0000\u001A>\u0010\u0016\u001A\u0002H\r\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0018\u0010\u000E\u001A\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0015\u0012\u0004\u0012\u0002H\r0\u000FH\u0080\b¢\u0006\u0002\u0010\u0011\u001A9\u0010\u0017\u001A\u00020\u0014\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u001E\u0010\u000E\u001A\u001A\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00180\u000FH\u0080\b\u001A\u0019\u0010\u0019\u001A\u00020\u001A\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0080\b\u001A.\u0010\u001B\u001A\u00020\u0014\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00072\u0006\u0010\u001C\u001A\u00020\u00012\f\u0010\u001D\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0018H\u0000\u001A&\u0010\u001E\u001A\u00020\u001F\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\f\u0010 \u001A\b\u0012\u0004\u0012\u0002H\u00020\u0018H\u0000\"$\u0010\u0000\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005\"0\u0010\u0006\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00038@X\u0080\u0004¢\u0006\f\u0012\u0004\b\b\u0010\t\u001A\u0004\b\n\u0010\u000B\"\u0014\u0010!\u001A\u00060\"j\u0002`#X\u0082\u0004¢\u0006\u0004\n\u0002\u0010$¨\u0006%"}, d2={"modification", "", "T", "Landroidx/compose/runtime/snapshots/SnapshotStateSet;", "getModification", "(Landroidx/compose/runtime/snapshots/SnapshotStateSet;)I", "readable", "Landroidx/compose/runtime/snapshots/StateSetStateRecord;", "getReadable$annotations", "(Landroidx/compose/runtime/snapshots/SnapshotStateSet;)V", "getReadable", "(Landroidx/compose/runtime/snapshots/SnapshotStateSet;)Landroidx/compose/runtime/snapshots/StateSetStateRecord;", "writable", "R", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/runtime/snapshots/SnapshotStateSet;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "withCurrent", "mutateBoolean", "", "", "mutate", "conditionalUpdate", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "clearImpl", "", "attemptUpdate", "currentModification", "newSet", "stateRecordWith", "Landroidx/compose/runtime/snapshots/StateRecord;", "set", "sync", "", "Landroidx/compose/runtime/platform/SynchronizedObject;", "Ljava/lang/Object;", "runtime"}, k=2, mv={2, 1, 0}, xi=0x30) public final class SnapshotStateSetKt {
    private static final Object sync;

    static {
        SnapshotStateSetKt.sync = new Object();
    }

    public static final Object access$getSync$p() {
        return SnapshotStateSetKt.sync;
    }

    public static final boolean attemptUpdate(StateSetStateRecord arg2, int arg3, PersistentSet arg4) {
        boolean v4;
        Object v0 = SnapshotStateSetKt.sync;
        __monitor_enter(v0);
        try {
            if(arg2.getModification$runtime() == arg3) {
                arg2.setSet$runtime(arg4);
                v4 = true;
                arg2.setModification$runtime(arg2.getModification$runtime() + 1);
            }
            else {
                goto label_10;
            }

            goto label_11;
        }
        catch(Throwable v2) {
            __monitor_exit(v0);
            throw v2;
        }

    label_10:
        v4 = false;
    label_11:
        __monitor_exit(v0);
        return v4;
    }

    public static final void clearImpl(SnapshotStateSet arg5) {
        Object v3;
        Snapshot v2;
        StateRecord v0 = arg5.getFirstStateRecord();
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.writable>");
        Object v1 = SnapshotKt.getLock();
        __monitor_enter(v1);
        try {
            v2 = Snapshot.Companion.getCurrent();
            v0 = SnapshotKt.writableRecord(v0, ((StateObject)arg5), v2);
            v3 = SnapshotStateSetKt.sync;
            __monitor_enter(v3);
        }
        catch(Throwable v5) {
            goto label_23;
        }

        try {
            ((StateSetStateRecord)v0).setSet$runtime(ExtensionsKt.persistentSetOf());
            ((StateSetStateRecord)v0).setModification$runtime(((StateSetStateRecord)v0).getModification$runtime() + 1);
            goto label_15;
        }
        catch(Throwable v5) {
            try {
                __monitor_exit(v3);
                throw v5;
            label_15:
                __monitor_exit(v3);
            }
            catch(Throwable v5) {
            label_23:
                __monitor_exit(v1);
                throw v5;
            }
        }

        __monitor_exit(v1);
        SnapshotKt.notifyWrite(v2, ((StateObject)arg5));
    }

    public static final boolean conditionalUpdate(SnapshotStateSet arg6, Function1 arg7) {
        Snapshot v5;
        PersistentSet v1_1;
        int v2;
        StateRecord v1;
        do {
            Object v0 = SnapshotStateSetKt.sync;
            __monitor_enter(v0);
            try {
                v1 = arg6.getFirstStateRecord();
                Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.withCurrent>");
                v1 = SnapshotKt.current(v1);
                v2 = ((StateSetStateRecord)v1).getModification$runtime();
                v1_1 = ((StateSetStateRecord)v1).getSet$runtime();
            }
            catch(Throwable v6) {
                __monitor_exit(v0);
                throw v6;
            }

            __monitor_exit(v0);
            Intrinsics.checkNotNull(v1_1);
            v0 = arg7.invoke(v1_1);
            if(Intrinsics.areEqual(v0, v1_1)) {
                return 0;
            }

            v1 = arg6.getFirstStateRecord();
            Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.writable>");
            SnapshotStateSet v3 = arg6;
            Object v4 = SnapshotKt.getLock();
            __monitor_enter(v4);
            try {
                v5 = Snapshot.Companion.getCurrent();
                boolean v0_1 = SnapshotStateSetKt.attemptUpdate(SnapshotKt.writableRecord(v1, ((StateObject)v3), v5), v2, ((PersistentSet)v0));
            }
            catch(Throwable v6) {
                __monitor_exit(v4);
                throw v6;
            }

            __monitor_exit(v4);
            SnapshotKt.notifyWrite(v5, ((StateObject)v3));
        }
        while(!v0_1);

        return 1;
    }

    public static final int getModification(SnapshotStateSet arg1) {
        StateRecord v1 = arg1.getFirstStateRecord();
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.withCurrent>");
        return SnapshotKt.current(v1).getModification$runtime();
    }

    public static final StateSetStateRecord getReadable(SnapshotStateSet arg2) {
        StateRecord v0 = arg2.getFirstStateRecord();
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.<get-readable>>");
        return SnapshotKt.readable(v0, ((StateObject)arg2));
    }

    public static void getReadable$annotations(SnapshotStateSet arg0) {
    }

    public static final Object mutate(SnapshotStateSet arg7, Function1 arg8) {
        Snapshot v6;
        Object v3;
        PersistentSet v1_1;
        int v2;
        StateRecord v1;
        do {
            Object v0 = SnapshotStateSetKt.sync;
            __monitor_enter(v0);
            try {
                v1 = arg7.getFirstStateRecord();
                Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.withCurrent>");
                v1 = SnapshotKt.current(v1);
                v2 = ((StateSetStateRecord)v1).getModification$runtime();
                v1_1 = ((StateSetStateRecord)v1).getSet$runtime();
            }
            catch(Throwable v7) {
                __monitor_exit(v0);
                throw v7;
            }

            __monitor_exit(v0);
            if(v1_1 != null) {
                Builder v0_1 = v1_1.builder();
                if(v0_1 != null) {
                    v3 = arg8.invoke(v0_1);
                    PersistentSet v0_2 = v0_1.build();
                    if(!Intrinsics.areEqual(v0_2, v1_1)) {
                        v1 = arg7.getFirstStateRecord();
                        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.writable>");
                        SnapshotStateSet v4 = arg7;
                        Object v5 = SnapshotKt.getLock();
                        __monitor_enter(v5);
                        try {
                            v6 = Snapshot.Companion.getCurrent();
                            boolean v0_3 = SnapshotStateSetKt.attemptUpdate(SnapshotKt.writableRecord(v1, ((StateObject)v4), v6), v2, v0_2);
                        }
                        catch(Throwable v7) {
                            __monitor_exit(v5);
                            throw v7;
                        }

                        __monitor_exit(v5);
                        SnapshotKt.notifyWrite(v6, ((StateObject)v4));
                        if(!v0_3) {
                            continue;
                        }
                    }

                    return v3;
                }
            }

            goto label_35;
        }
        while(true);

        return v3;
    label_35:
        throw new IllegalStateException("No set to mutate".toString());
    }

    public static final boolean mutateBoolean(SnapshotStateSet arg7, Function1 arg8) {
        Snapshot v6;
        Object v3;
        PersistentSet v1_1;
        int v2;
        StateRecord v1;
        do {
            Object v0 = SnapshotStateSetKt.sync;
            __monitor_enter(v0);
            try {
                v1 = arg7.getFirstStateRecord();
                Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.withCurrent>");
                v1 = SnapshotKt.current(v1);
                v2 = ((StateSetStateRecord)v1).getModification$runtime();
                v1_1 = ((StateSetStateRecord)v1).getSet$runtime();
            }
            catch(Throwable v7) {
                __monitor_exit(v0);
                throw v7;
            }

            __monitor_exit(v0);
            if(v1_1 != null) {
                Builder v0_1 = v1_1.builder();
                if(v0_1 != null) {
                    v3 = arg8.invoke(v0_1);
                    PersistentSet v0_2 = v0_1.build();
                    if(!Intrinsics.areEqual(v0_2, v1_1)) {
                        v1 = arg7.getFirstStateRecord();
                        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.writable>");
                        SnapshotStateSet v4 = arg7;
                        Object v5 = SnapshotKt.getLock();
                        __monitor_enter(v5);
                        try {
                            v6 = Snapshot.Companion.getCurrent();
                            boolean v0_3 = SnapshotStateSetKt.attemptUpdate(SnapshotKt.writableRecord(v1, ((StateObject)v4), v6), v2, v0_2);
                        }
                        catch(Throwable v7) {
                            __monitor_exit(v5);
                            throw v7;
                        }

                        __monitor_exit(v5);
                        SnapshotKt.notifyWrite(v6, ((StateObject)v4));
                        if(!v0_3) {
                            continue;
                        }
                    }

                    break;
                }
            }

            goto label_36;
        }
        while(true);

        return ((Boolean)v3).booleanValue();
    label_36:
        throw new IllegalStateException("No set to mutate".toString());
    }

    public static final StateRecord stateRecordWith(SnapshotStateSet arg3, PersistentSet arg4) {
        StateSetStateRecord v3 = new StateSetStateRecord(SnapshotKt.currentSnapshot().getSnapshotId(), arg4);
        if(Snapshot.Companion.isInSnapshot()) {
            v3.setNext$runtime(new StateSetStateRecord(SnapshotId_jvmKt.toSnapshotId(1), arg4));
        }

        return ((StateRecord)v3);
    }

    public static final Object withCurrent(SnapshotStateSet arg1, Function1 arg2) {
        StateRecord v1 = arg1.getFirstStateRecord();
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.withCurrent>");
        return arg2.invoke(SnapshotKt.current(v1));
    }

    public static final Object writable(SnapshotStateSet arg3, Function1 arg4) {
        Object v4;
        Snapshot v2;
        StateRecord v0 = arg3.getFirstStateRecord();
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.writable>");
        Object v1 = SnapshotKt.getLock();
        __monitor_enter(v1);
        try {
            v2 = Snapshot.Companion.getCurrent();
            v4 = arg4.invoke(SnapshotKt.writableRecord(v0, ((StateObject)arg3), v2));
        }
        catch(Throwable v3) {
            __monitor_exit(v1);
            throw v3;
        }

        __monitor_exit(v1);
        SnapshotKt.notifyWrite(v2, ((StateObject)arg3));
        return v4;
    }
}

