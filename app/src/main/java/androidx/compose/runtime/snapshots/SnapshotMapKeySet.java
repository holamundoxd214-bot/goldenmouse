package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap$Builder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map$Entry;
import java.util.Map;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0004\n\u0002\u0010\u001E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u0003B\u001B\u0012\u0012\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000BJ\u0016\u0010\f\u001A\u00020\t2\f\u0010\r\u001A\b\u0012\u0004\u0012\u00028\u00000\u000EH\u0016J\u0015\u0010\u000F\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0010H\u0096\u0002J\u0015\u0010\u0011\u001A\u00020\u00122\u0006\u0010\n\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0013J\u0016\u0010\u0014\u001A\u00020\u00122\f\u0010\r\u001A\b\u0012\u0004\u0012\u00028\u00000\u000EH\u0016J\u0016\u0010\u0015\u001A\u00020\u00122\f\u0010\r\u001A\b\u0012\u0004\u0012\u00028\u00000\u000EH\u0016J\u0016\u0010\u0016\u001A\u00020\u00122\u0006\u0010\n\u001A\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0013J\u0016\u0010\u0017\u001A\u00020\u00122\f\u0010\r\u001A\b\u0012\u0004\u0012\u00028\u00000\u000EH\u0016¨\u0006\u0018"}, d2={"Landroidx/compose/runtime/snapshots/SnapshotMapKeySet;", "K", "V", "Landroidx/compose/runtime/snapshots/SnapshotMapSet;", "map", "Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "<init>", "(Landroidx/compose/runtime/snapshots/SnapshotStateMap;)V", "add", "", "element", "(Ljava/lang/Object;)Ljava/lang/Void;", "addAll", "elements", "", "iterator", "Landroidx/compose/runtime/snapshots/StateMapMutableKeysIterator;", "remove", "", "(Ljava/lang/Object;)Z", "removeAll", "retainAll", "contains", "containsAll", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) final class SnapshotMapKeySet extends SnapshotMapSet {
    public SnapshotMapKeySet(SnapshotStateMap arg1) {
        super(arg1);
    }

    public Void add(Object arg1) {
        SnapshotStateMapKt.unsupported();
        throw new KotlinNothingValueException();
    }

    public boolean add(Object arg1) {
        return this.add(arg1).booleanValue();
    }

    public Void addAll(Collection arg1) {
        SnapshotStateMapKt.unsupported();
        throw new KotlinNothingValueException();
    }

    public boolean addAll(Collection arg1) {
        return this.addAll(arg1).booleanValue();
    }

    public boolean contains(Object arg1) {
        return this.getMap().containsKey(arg1);
    }

    public boolean containsAll(Collection arg4) {
        if(((arg4 instanceof Collection)) && (arg4.isEmpty())) {
            return 1;
        }

        Iterator v4 = ((Iterable)arg4).iterator();
        do {
            if(!v4.hasNext()) {
                return 1;
            }
        }
        while(this.getMap().containsKey(v4.next()));

        return 0;
    }

    public StateMapMutableKeysIterator iterator() {
        return new StateMapMutableKeysIterator(this.getMap(), this.getMap().getReadable$runtime().getMap$runtime().entrySet().iterator());
    }

    public Iterator iterator() {
        return this.iterator();
    }

    public boolean remove(Object arg1) {
        if(this.getMap().remove(arg1) != null) {
            return 1;
        }

        return 0;
    }

    public boolean removeAll(Collection arg5) {
        boolean v1;
        Iterator v5 = ((Iterable)arg5).iterator();
        do {
        label_2:
            v1 = false;
            while(true) {
            label_3:
                if(!v5.hasNext()) {
                    return v1;
                }

                if(this.getMap().remove(v5.next()) == null && !v1) {
                    goto label_2;
                }

                break;
            }
        }
        while(true);

        v1 = true;
        goto label_3;
        return v1;
    }

    public boolean retainAll(Collection arg9) {
        Snapshot v6_1;
        int v2_1;
        PersistentMap v3;
        Set v9 = CollectionsKt.toSet(((Iterable)arg9));
        SnapshotStateMap v8 = this.getMap();
        boolean v0 = false;
        do {
            Object v1 = SnapshotStateMapKt.access$getSync$p();
            __monitor_enter(v1);
            try {
                StateRecord v2 = v8.getFirstStateRecord();
                Intrinsics.checkNotNull(v2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
                v2 = SnapshotKt.current(v2);
                v3 = ((StateMapStateRecord)v2).getMap$runtime();
                v2_1 = ((StateMapStateRecord)v2).getModification$runtime();
            }
            catch(Throwable v8_1) {
                __monitor_exit(v1);
                throw v8_1;
            }

            __monitor_exit(v1);
            Intrinsics.checkNotNull(v3);
            Builder v1_1 = v3.builder();
            Builder v4 = v1_1;
            Iterator v5 = v8.entrySet().iterator();
            while(v5.hasNext()) {
                Object v6 = v5.next();
                if(v9.contains(((Map$Entry)v6).getKey())) {
                    continue;
                }

                ((Map)v4).remove(((Map$Entry)v6).getKey());
                v0 = true;
            }

            PersistentMap v1_2 = v1_1.build();
            if(Intrinsics.areEqual(v1_2, v3)) {
                return v0;
            }

            StateRecord v3_1 = v8.getFirstStateRecord();
            Intrinsics.checkNotNull(v3_1, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
            SnapshotStateMap v4_1 = v8;
            Object v5_1 = SnapshotKt.getLock();
            __monitor_enter(v5_1);
            try {
                v6_1 = Snapshot.Companion.getCurrent();
                boolean v1_3 = SnapshotStateMap.access$attemptUpdate(v8, SnapshotKt.writableRecord(v3_1, ((StateObject)v4_1), v6_1), v2_1, v1_2);
            }
            catch(Throwable v8_1) {
                __monitor_exit(v5_1);
                throw v8_1;
            }

            __monitor_exit(v5_1);
            SnapshotKt.notifyWrite(v6_1, ((StateObject)v4_1));
        }
        while(!v1_3);

        return v0;
    }
}

