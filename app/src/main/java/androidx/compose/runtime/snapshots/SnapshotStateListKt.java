package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList$Builder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000`\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\u001AC\u0010\u0000\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u001D\u0010\u0004\u001A\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0006\u0012\u0004\u0012\u0002H\u00010\u0005¢\u0006\u0002\b\u0007H\u0080\b¢\u0006\u0002\u0010\b\u001AC\u0010\t\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u001D\u0010\u0004\u001A\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0006\u0012\u0004\u0012\u0002H\u00010\u0005¢\u0006\u0002\b\u0007H\u0080\b¢\u0006\u0002\u0010\b\u001A2\u0010\n\u001A\u00020\u000B\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0018\u0010\u0004\u001A\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\f\u0012\u0004\u0012\u00020\u000B0\u0005H\u0000\u001A>\u0010\r\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0018\u0010\u0004\u001A\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\f\u0012\u0004\u0012\u0002H\u00010\u0005H\u0080\b¢\u0006\u0002\u0010\b\u001AC\u0010\u000E\u001A\u00020\u000F\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\b\b\u0002\u0010\u0010\u001A\u00020\u000B2\u001E\u0010\u0004\u001A\u001A\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00110\u0005H\u0080\b\u001A\u0019\u0010\u0012\u001A\u00020\u000F\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0080\b\u001AC\u0010\u0013\u001A\u00020\u000B\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\b\b\u0002\u0010\u0010\u001A\u00020\u000B2\u001E\u0010\u0004\u001A\u001A\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00110\u0005H\u0080\b\u001A6\u0010\u0014\u001A\u00020\u000B\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00062\u0006\u0010\u0015\u001A\u00020\u00162\f\u0010\u0017\u001A\b\u0012\u0004\u0012\u0002H\u00020\u00112\u0006\u0010\u0010\u001A\u00020\u000BH\u0000\u001A&\u0010\u0018\u001A\u00020\u0019\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\f\u0010\u001A\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0011H\u0000\u001A=\u0010#\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u00022\u0006\u0010$\u001A\u00020\u00162!\u0010%\u001A\u001D\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b&\u0012\b\b\'\u0012\u0004\b\b((\u0012\u0004\u0012\u0002H\u00020\u0005\u001A\b\u0010-\u001A\u00020.H\u0002\u001A\u0018\u0010/\u001A\u00020\u000F2\u0006\u0010(\u001A\u00020\u00162\u0006\u0010$\u001A\u00020\u0016H\u0002\u001A\b\u00100\u001A\u00020.H\u0002\"$\u0010\u001B\u001A\u00020\u0016\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u001C\u0010\u001D\"0\u0010\u001E\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0006\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00038@X\u0080\u0004¢\u0006\f\u0012\u0004\b\u001F\u0010 \u001A\u0004\b!\u0010\"\"\u0014\u0010)\u001A\u00060*j\u0002`+X\u0082\u0004¢\u0006\u0004\n\u0002\u0010,¨\u00061"}, d2={"writable", "R", "T", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "block", "Lkotlin/Function1;", "Landroidx/compose/runtime/snapshots/StateListStateRecord;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/runtime/snapshots/SnapshotStateList;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "withCurrent", "mutateBoolean", "", "", "mutate", "update", "", "structural", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "clearImpl", "conditionalUpdate", "attemptUpdate", "currentModification", "", "newList", "stateRecordWith", "Landroidx/compose/runtime/snapshots/StateRecord;", "list", "structure", "getStructure", "(Landroidx/compose/runtime/snapshots/SnapshotStateList;)I", "readable", "getReadable$annotations", "(Landroidx/compose/runtime/snapshots/SnapshotStateList;)V", "getReadable", "(Landroidx/compose/runtime/snapshots/SnapshotStateList;)Landroidx/compose/runtime/snapshots/StateListStateRecord;", "SnapshotStateList", "size", "init", "Lkotlin/ParameterName;", "name", "index", "sync", "", "Landroidx/compose/runtime/platform/SynchronizedObject;", "Ljava/lang/Object;", "modificationError", "", "validateRange", "invalidIteratorSet", "runtime"}, k=2, mv={2, 1, 0}, xi=0x30) public final class SnapshotStateListKt {
    private static final Object sync;

    static {
        SnapshotStateListKt.sync = new Object();
    }

    public static final SnapshotStateList SnapshotStateList(int arg3, Function1 arg4) {
        if(arg3 == 0) {
            return new SnapshotStateList();
        }

        Builder v0 = ExtensionsKt.persistentListOf().builder();
        int v1;
        for(v1 = 0; v1 < arg3; ++v1) {
            v0.add(arg4.invoke(Integer.valueOf(v1)));
        }

        return new SnapshotStateList(v0.build());
    }

    public static final Object access$getSync$p() {
        return SnapshotStateListKt.sync;
    }

    public static final Void access$invalidIteratorSet() {
        return SnapshotStateListKt.invalidIteratorSet();
    }

    public static final Void access$modificationError() {
        return SnapshotStateListKt.modificationError();
    }

    public static final void access$validateRange(int arg0, int arg1) {
        SnapshotStateListKt.validateRange(arg0, arg1);
    }

    public static final boolean attemptUpdate(StateListStateRecord arg2, int arg3, PersistentList arg4, boolean arg5) {
        boolean v3;
        Object v0 = SnapshotStateListKt.sync;
        __monitor_enter(v0);
        try {
            if(arg2.getModification$runtime() == arg3) {
                arg2.setList$runtime(arg4);
                v3 = true;
                if(arg5) {
                    arg2.setStructuralChange$runtime(arg2.getStructuralChange$runtime() + 1);
                }

                arg2.setModification$runtime(arg2.getModification$runtime() + 1);
            }
            else {
                goto label_14;
            }

            goto label_15;
        }
        catch(Throwable v2) {
            __monitor_exit(v0);
            throw v2;
        }

    label_14:
        v3 = false;
    label_15:
        __monitor_exit(v0);
        return v3;
    }

    public static final void clearImpl(SnapshotStateList arg5) {
        Object v3;
        Snapshot v2;
        StateRecord v0 = arg5.getFirstStateRecord();
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
        Object v1 = SnapshotKt.getLock();
        __monitor_enter(v1);
        try {
            v2 = Snapshot.Companion.getCurrent();
            v0 = SnapshotKt.writableRecord(v0, ((StateObject)arg5), v2);
            v3 = SnapshotStateListKt.sync;
            __monitor_enter(v3);
        }
        catch(Throwable v5) {
            goto label_26;
        }

        try {
            ((StateListStateRecord)v0).setList$runtime(ExtensionsKt.persistentListOf());
            ((StateListStateRecord)v0).setModification$runtime(((StateListStateRecord)v0).getModification$runtime() + 1);
            ((StateListStateRecord)v0).setStructuralChange$runtime(((StateListStateRecord)v0).getStructuralChange$runtime() + 1);
            goto label_18;
        }
        catch(Throwable v5) {
            try {
                __monitor_exit(v3);
                throw v5;
            label_18:
                __monitor_exit(v3);
            }
            catch(Throwable v5) {
            label_26:
                __monitor_exit(v1);
                throw v5;
            }
        }

        __monitor_exit(v1);
        SnapshotKt.notifyWrite(v2, ((StateObject)arg5));
    }

    public static final boolean conditionalUpdate(SnapshotStateList arg6, boolean arg7, Function1 arg8) {
        Snapshot v5;
        PersistentList v1_1;
        int v2;
        StateRecord v1;
        do {
            Object v0 = SnapshotStateListKt.sync;
            __monitor_enter(v0);
            try {
                v1 = arg6.getFirstStateRecord();
                Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");
                v1 = SnapshotKt.current(v1);
                v2 = ((StateListStateRecord)v1).getModification$runtime();
                v1_1 = ((StateListStateRecord)v1).getList$runtime();
            }
            catch(Throwable v6) {
                __monitor_exit(v0);
                throw v6;
            }

            __monitor_exit(v0);
            Intrinsics.checkNotNull(v1_1);
            v0 = arg8.invoke(v1_1);
            if(Intrinsics.areEqual(v0, v1_1)) {
                return 0;
            }

            v1 = arg6.getFirstStateRecord();
            Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
            SnapshotStateList v3 = arg6;
            Object v4 = SnapshotKt.getLock();
            __monitor_enter(v4);
            try {
                v5 = Snapshot.Companion.getCurrent();
                boolean v0_1 = SnapshotStateListKt.attemptUpdate(SnapshotKt.writableRecord(v1, ((StateObject)v3), v5), v2, ((PersistentList)v0), arg7);
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

    public static boolean conditionalUpdate$default(SnapshotStateList arg5, boolean arg6, Function1 arg7, int arg8, Object arg9) {
        Snapshot v4;
        PersistentList v0_1;
        int v1;
        StateRecord v0;
        do {
            Object v8 = SnapshotStateListKt.sync;
            __monitor_enter(v8);
            try {
                v0 = arg5.getFirstStateRecord();
                Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");
                v0 = SnapshotKt.current(v0);
                v1 = ((StateListStateRecord)v0).getModification$runtime();
                v0_1 = ((StateListStateRecord)v0).getList$runtime();
            }
            catch(Throwable v5) {
                __monitor_exit(v8);
                throw v5;
            }

            __monitor_exit(v8);
            Intrinsics.checkNotNull(v0_1);
            v8 = arg7.invoke(v0_1);
            if(Intrinsics.areEqual(v8, v0_1)) {
                return 0;
            }

            v0 = arg5.getFirstStateRecord();
            Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
            SnapshotStateList v2 = arg5;
            Object v3 = SnapshotKt.getLock();
            __monitor_enter(v3);
            try {
                v4 = Snapshot.Companion.getCurrent();
                boolean v8_1 = SnapshotStateListKt.attemptUpdate(SnapshotKt.writableRecord(v0, ((StateObject)v2), v4), v1, ((PersistentList)v8), true);
            }
            catch(Throwable v5) {
                __monitor_exit(v3);
                throw v5;
            }

            __monitor_exit(v3);
            SnapshotKt.notifyWrite(v4, ((StateObject)v2));
        }
        while(!v8_1);

        return 1;
    }

    public static final StateListStateRecord getReadable(SnapshotStateList arg2) {
        StateRecord v0 = arg2.getFirstStateRecord();
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.<get-readable>>");
        return SnapshotKt.readable(v0, ((StateObject)arg2));
    }

    public static void getReadable$annotations(SnapshotStateList arg0) {
    }

    public static final int getStructure(SnapshotStateList arg1) {
        StateRecord v1 = arg1.getFirstStateRecord();
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");
        return SnapshotKt.current(v1).getStructuralChange$runtime();
    }

    private static final Void invalidIteratorSet() {
        throw new IllegalStateException("Cannot call set before the first call to next() or previous() or immediately after a call to add() or remove()".toString());
    }

    private static final Void modificationError() {
        throw new IllegalStateException("Cannot modify a state list through an iterator".toString());
    }

    public static final Object mutate(SnapshotStateList arg8, Function1 arg9) {
        Snapshot v6;
        Object v3;
        PersistentList v1_1;
        int v2;
        StateRecord v1;
        do {
            Object v0 = SnapshotStateListKt.sync;
            __monitor_enter(v0);
            try {
                v1 = arg8.getFirstStateRecord();
                Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");
                v1 = SnapshotKt.current(v1);
                v2 = ((StateListStateRecord)v1).getModification$runtime();
                v1_1 = ((StateListStateRecord)v1).getList$runtime();
            }
            catch(Throwable v8) {
                __monitor_exit(v0);
                throw v8;
            }

            __monitor_exit(v0);
            Intrinsics.checkNotNull(v1_1);
            Builder v0_1 = v1_1.builder();
            v3 = arg9.invoke(v0_1);
            PersistentList v0_2 = v0_1.build();
            if(Intrinsics.areEqual(v0_2, v1_1)) {
                return v3;
            }

            v1 = arg8.getFirstStateRecord();
            Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
            SnapshotStateList v4 = arg8;
            Object v5 = SnapshotKt.getLock();
            __monitor_enter(v5);
            try {
                v6 = Snapshot.Companion.getCurrent();
                boolean v0_3 = SnapshotStateListKt.attemptUpdate(SnapshotKt.writableRecord(v1, ((StateObject)v4), v6), v2, v0_2, true);
            }
            catch(Throwable v8) {
                __monitor_exit(v5);
                throw v8;
            }

            __monitor_exit(v5);
            SnapshotKt.notifyWrite(v6, ((StateObject)v4));
        }
        while(!v0_3);

        return v3;
    }

    public static final boolean mutateBoolean(SnapshotStateList arg8, Function1 arg9) {
        Snapshot v6;
        Object v3;
        PersistentList v1_1;
        int v2;
        StateRecord v1;
        do {
            Object v0 = SnapshotStateListKt.sync;
            __monitor_enter(v0);
            try {
                v1 = arg8.getFirstStateRecord();
                Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");
                v1 = SnapshotKt.current(v1);
                v2 = ((StateListStateRecord)v1).getModification$runtime();
                v1_1 = ((StateListStateRecord)v1).getList$runtime();
            }
            catch(Throwable v8) {
                __monitor_exit(v0);
                throw v8;
            }

            __monitor_exit(v0);
            Intrinsics.checkNotNull(v1_1);
            Builder v0_1 = v1_1.builder();
            v3 = arg9.invoke(v0_1);
            PersistentList v0_2 = v0_1.build();
            if(Intrinsics.areEqual(v0_2, v1_1)) {
                break;
            }

            v1 = arg8.getFirstStateRecord();
            Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
            SnapshotStateList v4 = arg8;
            Object v5 = SnapshotKt.getLock();
            __monitor_enter(v5);
            try {
                v6 = Snapshot.Companion.getCurrent();
                boolean v0_3 = SnapshotStateListKt.attemptUpdate(SnapshotKt.writableRecord(v1, ((StateObject)v4), v6), v2, v0_2, true);
            }
            catch(Throwable v8) {
                __monitor_exit(v5);
                throw v8;
            }

            __monitor_exit(v5);
            SnapshotKt.notifyWrite(v6, ((StateObject)v4));
        }
        while(!v0_3);

        return ((Boolean)v3).booleanValue();
    }

    public static final StateRecord stateRecordWith(SnapshotStateList arg3, PersistentList arg4) {
        Snapshot v3 = SnapshotKt.currentSnapshot();
        StateListStateRecord v0 = new StateListStateRecord(v3.getSnapshotId(), arg4);
        if(!(v3 instanceof GlobalSnapshot)) {
            v0.setNext$runtime(new StateListStateRecord(SnapshotId_jvmKt.toSnapshotId(1), arg4));
        }

        return ((StateRecord)v0);
    }

    public static final void update(SnapshotStateList arg6, boolean arg7, Function1 arg8) {
        Snapshot v5;
        PersistentList v1_1;
        int v2;
        StateRecord v1;
        do {
            Object v0 = SnapshotStateListKt.sync;
            __monitor_enter(v0);
            try {
                v1 = arg6.getFirstStateRecord();
                Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");
                v1 = SnapshotKt.current(v1);
                v2 = ((StateListStateRecord)v1).getModification$runtime();
                v1_1 = ((StateListStateRecord)v1).getList$runtime();
            }
            catch(Throwable v6) {
                __monitor_exit(v0);
                throw v6;
            }

            __monitor_exit(v0);
            Intrinsics.checkNotNull(v1_1);
            v0 = arg8.invoke(v1_1);
            if(Intrinsics.areEqual(v0, v1_1)) {
                return;
            }

            v1 = arg6.getFirstStateRecord();
            Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
            SnapshotStateList v3 = arg6;
            Object v4 = SnapshotKt.getLock();
            __monitor_enter(v4);
            try {
                v5 = Snapshot.Companion.getCurrent();
                boolean v0_1 = SnapshotStateListKt.attemptUpdate(SnapshotKt.writableRecord(v1, ((StateObject)v3), v5), v2, ((PersistentList)v0), arg7);
            }
            catch(Throwable v6) {
                __monitor_exit(v4);
                throw v6;
            }

            __monitor_exit(v4);
            SnapshotKt.notifyWrite(v5, ((StateObject)v3));
        }
        while(!v0_1);
    }

    public static void update$default(SnapshotStateList arg4, boolean arg5, Function1 arg6, int arg7, Object arg8) {
        Snapshot v3;
        PersistentList v8_1;
        int v0;
        StateRecord v8;
        do {
            Object v7 = SnapshotStateListKt.sync;
            __monitor_enter(v7);
            try {
                v8 = arg4.getFirstStateRecord();
                Intrinsics.checkNotNull(v8, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");
                v8 = SnapshotKt.current(v8);
                v0 = ((StateListStateRecord)v8).getModification$runtime();
                v8_1 = ((StateListStateRecord)v8).getList$runtime();
            }
            catch(Throwable v4) {
                __monitor_exit(v7);
                throw v4;
            }

            __monitor_exit(v7);
            Intrinsics.checkNotNull(v8_1);
            v7 = arg6.invoke(v8_1);
            if(Intrinsics.areEqual(v7, v8_1)) {
                return;
            }

            v8 = arg4.getFirstStateRecord();
            Intrinsics.checkNotNull(v8, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
            SnapshotStateList v1 = arg4;
            Object v2 = SnapshotKt.getLock();
            __monitor_enter(v2);
            try {
                v3 = Snapshot.Companion.getCurrent();
                boolean v7_1 = SnapshotStateListKt.attemptUpdate(SnapshotKt.writableRecord(v8, ((StateObject)v1), v3), v0, ((PersistentList)v7), true);
            }
            catch(Throwable v4) {
                __monitor_exit(v2);
                throw v4;
            }

            __monitor_exit(v2);
            SnapshotKt.notifyWrite(v3, ((StateObject)v1));
        }
        while(!v7_1);
    }

    private static final void validateRange(int arg3, int arg4) {
        if(arg3 >= 0 && arg3 < arg4) {
            return;
        }

        throw new IndexOutOfBoundsException("index (" + arg3 + ") is out of bound of [0, " + arg4 + ')');
    }

    public static final Object withCurrent(SnapshotStateList arg1, Function1 arg2) {
        StateRecord v1 = arg1.getFirstStateRecord();
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");
        return arg2.invoke(SnapshotKt.current(v1));
    }

    public static final Object writable(SnapshotStateList arg3, Function1 arg4) {
        Object v4;
        Snapshot v2;
        StateRecord v0 = arg3.getFirstStateRecord();
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
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

