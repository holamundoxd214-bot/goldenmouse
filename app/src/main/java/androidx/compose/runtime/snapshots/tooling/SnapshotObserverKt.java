package androidx.compose.runtime.snapshots.tooling;

import androidx.collection.ScatterSet;
import androidx.compose.runtime.collection.ScatterSetWrapperKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import androidx.compose.runtime.snapshots.ObserverHandle;
import androidx.compose.runtime.snapshots.Snapshot$Companion;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotKt;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000^\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001A\u0014\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0004H\u0007\u001A°\u0001\u0010\t\u001A\u0002H\n\"\b\b\u0000\u0010\n*\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\u000B2\u0016\b\b\u0010\r\u001A\u0010\u0012\u0004\u0012\u00020\u000F\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000E2\u0016\b\b\u0010\u0011\u001A\u0010\u0012\u0004\u0012\u00020\u000F\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000E2\u0006\u0010\u0012\u001A\u00020\u00132T\b\u0004\u0010\u0014\u001AN\u0012!\u0012\u001F\u0012\u0004\u0012\u00020\u000F\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000E¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\r\u0012!\u0012\u001F\u0012\u0004\u0012\u00020\u000F\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000E¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u0002H\n0\u0015H\u0081\b¢\u0006\u0002\u0010\u0018\u001Aj\u0010\u0019\u001A\u001C\u0012\u0004\u0012\u00020\u001B\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001B\u0018\u00010\u001C0\u001A*\b\u0012\u0004\u0012\u00020\u00040\u00062\b\u0010\f\u001A\u0004\u0018\u00010\u000B2\u0006\u0010\u0012\u001A\u00020\u00132\u0014\u0010\r\u001A\u0010\u0012\u0004\u0012\u00020\u000F\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000E2\u0014\u0010\u0011\u001A\u0010\u0012\u0004\u0012\u00020\u000F\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000EH\u0001\u001AB\u0010\u0019\u001A\u0010\u0012\u0004\u0012\u00020\u000F\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000E2\u0014\u0010\u001D\u001A\u0010\u0012\u0004\u0012\u00020\u000F\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000E2\u0014\u0010\u001E\u001A\u0010\u0012\u0004\u0012\u00020\u000F\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000EH\u0002\u001A:\u0010\u001F\u001A\u00020\u0010*\b\u0012\u0004\u0012\u00020\u00040\u00062\b\u0010\f\u001A\u0004\u0018\u00010\u000B2\u0006\u0010 \u001A\u00020\u000B2\u0014\u0010!\u001A\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001B\u0018\u00010\u001CH\u0001\u001A\u0010\u0010\"\u001A\u00020\u00102\u0006\u0010#\u001A\u00020\u000BH\u0000\u001A \u0010$\u001A\u00020\u00102\u0006\u0010#\u001A\u00020\u000B2\u000E\u0010%\u001A\n\u0012\u0004\u0012\u00020\'\u0018\u00010&H\u0000\" \u0010\u0005\u001A\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00068\u0002@\u0002X\u0083\u000E¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\b¨\u0006("}, d2={"observeSnapshots", "Landroidx/compose/runtime/snapshots/ObserverHandle;", "Landroidx/compose/runtime/snapshots/Snapshot$Companion;", "snapshotObserver", "Landroidx/compose/runtime/snapshots/tooling/SnapshotObserver;", "observers", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "getObservers$annotations", "()V", "creatingSnapshot", "R", "Landroidx/compose/runtime/snapshots/Snapshot;", "parent", "readObserver", "Lkotlin/Function1;", "", "", "writeObserver", "readonly", "", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "(Landroidx/compose/runtime/snapshots/Snapshot;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZLkotlin/jvm/functions/Function2;)Landroidx/compose/runtime/snapshots/Snapshot;", "mergeObservers", "Lkotlin/Pair;", "Landroidx/compose/runtime/snapshots/tooling/SnapshotInstanceObservers;", "", "a", "b", "dispatchCreatedObservers", "result", "observerMap", "dispatchObserverOnPreDispose", "snapshot", "dispatchObserverOnApplied", "changes", "Landroidx/collection/ScatterSet;", "Landroidx/compose/runtime/snapshots/StateObject;", "runtime"}, k=2, mv={2, 1, 0}, xi=0x30) public final class SnapshotObserverKt {
    private static PersistentList observers;

    static {
    }

    public static final PersistentList access$getObservers$p() {
        return SnapshotObserverKt.observers;
    }

    public static final Snapshot creatingSnapshot(Snapshot arg2, Function1 arg3, Function1 arg4, boolean arg5, Function2 arg6) {
        Map v5_2;
        PersistentList v0 = SnapshotObserverKt.observers;
        if(v0 != null) {
            Pair v3 = SnapshotObserverKt.mergeObservers(v0, arg2, arg5, arg3, arg4);
            Object v4 = v3.getFirst();
            Function1 v5 = ((SnapshotInstanceObservers)v4).getReadObserver();
            arg4 = ((SnapshotInstanceObservers)v4).getWriteObserver();
            Function1 v1 = v5;
            Object v5_1 = v3.getSecond();
            arg3 = v1;
        }
        else {
            v5_2 = null;
        }

        Object v3_1 = arg6.invoke(arg3, arg4);
        if(v0 != null) {
            SnapshotObserverKt.dispatchCreatedObservers(v0, arg2, ((Snapshot)v3_1), v5_2);
        }

        return ((Snapshot)v3_1);
    }

    public static final void dispatchCreatedObservers(PersistentList arg4, Snapshot arg5, Snapshot arg6, Map arg7) {
        SnapshotInstanceObservers v3_1;
        int v0 = arg4.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            Object v2 = ((List)arg4).get(v1);
            if(arg7 != null) {
                Object v3 = arg7.get(v2);
            }
            else {
                v3_1 = null;
            }

            ((SnapshotObserver)v2).onCreated(arg6, arg5, v3_1);
        }
    }

    public static final void dispatchObserverOnApplied(Snapshot arg4, ScatterSet arg5) {
        Set v5;
        PersistentList v0 = SnapshotObserverKt.observers;
        PersistentList v1 = v0;
        if(v1 != null) {
            if(((Collection)v1).isEmpty()) {
            }
            else {
                if(arg5 != null) {
                    v5 = ScatterSetWrapperKt.wrapIntoSet(arg5);
                    if(v5 == null) {
                        goto label_9;
                    }
                }
                else {
                label_9:
                    v5 = SetsKt.emptySet();
                }

                int v1_1 = v0.size();
                int v2;
                for(v2 = 0; v2 < v1_1; ++v2) {
                    ((List)v0).get(v2).onApplied(arg4, v5);
                }
            }
        }
    }

    public static final void dispatchObserverOnPreDispose(Snapshot arg4) {
        PersistentList v0 = SnapshotObserverKt.observers;
        if(v0 != null) {
            int v1 = v0.size();
            int v2;
            for(v2 = 0; v2 < v1; ++v2) {
                ((List)v0).get(v2).onPreDispose(arg4);
            }
        }
    }

    private static void getObservers$annotations() {
    }

    public static final Pair mergeObservers(PersistentList arg6, Snapshot arg7, boolean arg8, Function1 arg9, Function1 arg10) {
        int v0 = arg6.size();
        LinkedHashMap v1 = null;
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            Object v3 = ((List)arg6).get(v2);
            SnapshotInstanceObservers v4 = ((SnapshotObserver)v3).onPreCreate(arg7, arg8);
            if(v4 != null) {
                arg9 = SnapshotObserverKt.mergeObservers(v4.getReadObserver(), arg9);
                arg10 = SnapshotObserverKt.mergeObservers(v4.getWriteObserver(), arg10);
                if(v1 == null) {
                    v1 = new LinkedHashMap();
                }

                ((Map)v1).put(v3, v4);
            }
        }

        return TuplesKt.to(new SnapshotInstanceObservers(arg9, arg10), v1);
    }

    private static final Function1 mergeObservers(Function1 arg1, Function1 arg2) {
        if(arg1 != null && arg2 != null) {
            return new SnapshotObserverKt$$ExternalSyntheticLambda0(arg1, arg2);
        }

        if(arg1 == null) {
            return arg2;
        }

        return arg1;
    }

    static final Unit mergeObservers$lambda$1(Function1 arg0, Function1 arg1, Object arg2) {
        arg0.invoke(arg2);
        arg1.invoke(arg2);
        return Unit.INSTANCE;
    }

    public static final ObserverHandle observeSnapshots(Companion arg1, SnapshotObserver arg2) {
        Object v1 = SnapshotKt.getLock();
        __monitor_enter(v1);
        try {
            PersistentList v0 = SnapshotObserverKt.observers;
            if(v0 == null) {
                v0 = ExtensionsKt.persistentListOf();
            }

            SnapshotObserverKt.observers = v0.add(arg2);
        }
        catch(Throwable v2) {
            __monitor_exit(v1);
            throw v2;
        }

        __monitor_exit(v1);
        return new SnapshotObserverKt$$ExternalSyntheticLambda1(arg2);
    }

    static final void observeSnapshots$lambda$1(SnapshotObserver arg3) {
        Object v0 = SnapshotKt.getLock();
        __monitor_enter(v0);
        try {
            PersistentList v1 = SnapshotObserverKt.observers;
            PersistentList v2 = null;
            PersistentList v3_1 = v1 != null ? v1.remove(arg3) : v2;
            if(v3_1 != null && !v3_1.isEmpty()) {
                v2 = v3_1;
            }

            SnapshotObserverKt.observers = v2;
        }
        catch(Throwable v3) {
            __monitor_exit(v0);
            throw v3;
        }

        __monitor_exit(v0);
    }
}

