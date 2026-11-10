package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap$Builder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map$Entry;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\'\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0010\u001E\n\u0000\n\u0002\u0010)\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022 \u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00040\u0003B\u001B\u0012\u0012\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001C\u0010\t\u001A\u00020\n2\u0012\u0010\u000B\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0016J\"\u0010\f\u001A\u00020\n2\u0018\u0010\r\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\u000EH\u0016J\u001B\u0010\u000F\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\u0010H\u0096\u0002J\u001C\u0010\u0011\u001A\u00020\u00122\u0012\u0010\u000B\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0016J\"\u0010\u0013\u001A\u00020\u00122\u0018\u0010\r\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\u000EH\u0016J\"\u0010\u0014\u001A\u00020\u00122\u0018\u0010\r\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\u000EH\u0016J\u001D\u0010\u0015\u001A\u00020\u00122\u0012\u0010\u000B\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0096\u0002J\"\u0010\u0016\u001A\u00020\u00122\u0018\u0010\r\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\u000EH\u0016¨\u0006\u0017"}, d2={"Landroidx/compose/runtime/snapshots/SnapshotMapEntrySet;", "K", "V", "Landroidx/compose/runtime/snapshots/SnapshotMapSet;", "", "map", "Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "<init>", "(Landroidx/compose/runtime/snapshots/SnapshotStateMap;)V", "add", "", "element", "addAll", "elements", "", "iterator", "", "remove", "", "removeAll", "retainAll", "contains", "containsAll", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) final class SnapshotMapEntrySet extends SnapshotMapSet {
    public SnapshotMapEntrySet(SnapshotStateMap arg1) {
        super(arg1);
    }

    public Void add(Map$Entry arg1) {
        SnapshotStateMapKt.unsupported();
        throw new KotlinNothingValueException();
    }

    public boolean add(Object arg1) {
        return this.add(((Map$Entry)arg1)).booleanValue();
    }

    public Void addAll(Collection arg1) {
        SnapshotStateMapKt.unsupported();
        throw new KotlinNothingValueException();
    }

    public boolean addAll(Collection arg1) {
        return this.addAll(arg1).booleanValue();
    }

    public final boolean contains(Object arg2) {
        if(!TypeIntrinsics.isMutableMapEntry(arg2)) {
            return 0;
        }

        return this.contains(((Map$Entry)arg2));
    }

    public boolean contains(Map$Entry arg2) {
        return Intrinsics.areEqual(this.getMap().get(arg2.getKey()), arg2.getValue());
    }

    public boolean containsAll(Collection arg3) {
        if(((arg3 instanceof Collection)) && (arg3.isEmpty())) {
            return 1;
        }

        Iterator v3 = ((Iterable)arg3).iterator();
        do {
            if(!v3.hasNext()) {
                return 1;
            }
        }
        while(this.contains(v3.next()));

        return 0;
    }

    public Iterator iterator() {
        return new StateMapMutableEntriesIterator(this.getMap(), this.getMap().getReadable$runtime().getMap$runtime().entrySet().iterator());
    }

    public final boolean remove(Object arg2) {
        if(!TypeIntrinsics.isMutableMapEntry(arg2)) {
            return 0;
        }

        return this.remove(((Map$Entry)arg2));
    }

    public boolean remove(Map$Entry arg1) {
        if(this.getMap().remove(arg1.getKey()) != null) {
            return 1;
        }

        return 0;
    }

    public boolean removeAll(Collection arg5) {
        boolean v1;
        Iterator v5 = arg5.iterator();
        do {
        label_2:
            v1 = false;
            while(true) {
            label_3:
                if(!v5.hasNext()) {
                    return v1;
                }

                if(this.getMap().remove(v5.next().getKey()) == null && !v1) {
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

    public boolean retainAll(Collection arg10) {
        Snapshot v6_1;
        int v2_1;
        PersistentMap v3;
        Object v0;
        LinkedHashMap v1 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(((Iterable)arg10), 10)), 16));
        Iterator v10 = ((Iterable)arg10).iterator();
        while(v10.hasNext()) {
            v0 = v10.next();
            Pair v0_1 = TuplesKt.to(((Map$Entry)v0).getKey(), ((Map$Entry)v0).getValue());
            ((Map)v1).put(v0_1.getFirst(), v0_1.getSecond());
        }

        SnapshotStateMap v9 = this.getMap();
        boolean v10_1 = false;
        do {
            v0 = SnapshotStateMapKt.access$getSync$p();
            __monitor_enter(v0);
            try {
                StateRecord v2 = v9.getFirstStateRecord();
                Intrinsics.checkNotNull(v2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
                v2 = SnapshotKt.current(v2);
                v3 = ((StateMapStateRecord)v2).getMap$runtime();
                v2_1 = ((StateMapStateRecord)v2).getModification$runtime();
            }
            catch(Throwable v9_1) {
                __monitor_exit(v0);
                throw v9_1;
            }

            __monitor_exit(v0);
            Intrinsics.checkNotNull(v3);
            Builder v0_2 = v3.builder();
            Builder v4 = v0_2;
            Iterator v5 = v9.entrySet().iterator();
            while(v5.hasNext()) {
                Object v6 = v5.next();
                if((((Map)v1).containsKey(((Map$Entry)v6).getKey())) && (Intrinsics.areEqual(((Map)v1).get(((Map$Entry)v6).getKey()), ((Map$Entry)v6).getValue()))) {
                    continue;
                }

                ((Map)v4).remove(((Map$Entry)v6).getKey());
                v10_1 = true;
            }

            PersistentMap v0_3 = v0_2.build();
            if(Intrinsics.areEqual(v0_3, v3)) {
                return v10_1;
            }

            StateRecord v3_1 = v9.getFirstStateRecord();
            Intrinsics.checkNotNull(v3_1, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
            SnapshotStateMap v4_1 = v9;
            Object v5_1 = SnapshotKt.getLock();
            __monitor_enter(v5_1);
            try {
                v6_1 = Snapshot.Companion.getCurrent();
                boolean v0_4 = SnapshotStateMap.access$attemptUpdate(v9, SnapshotKt.writableRecord(v3_1, ((StateObject)v4_1), v6_1), v2_1, v0_3);
            }
            catch(Throwable v9_1) {
                __monitor_exit(v5_1);
                throw v9_1;
            }

            __monitor_exit(v5_1);
            SnapshotKt.notifyWrite(v6_1, ((StateObject)v4_1));
        }
        while(!v0_4);

        return v10_1;
    }
}

