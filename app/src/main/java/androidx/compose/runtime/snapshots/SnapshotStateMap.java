package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap$Builder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map$Entry;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;

@Metadata(d1={"\u0000|\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0010#\n\u0002\u0010\'\n\u0002\b\u0005\n\u0002\u0010\u001F\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010&\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u00032\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004:\u0001RB\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\f\u001A\u00020\r2\u0006\u0010\u0007\u001A\u00020\bH\u0016J\u0012\u0010\u000E\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000FJ\u0015\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0017J\u0015\u0010\u0018\u001A\u00020\u00152\u0006\u0010\u0007\u001A\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0017J\u0018\u0010\u0019\u001A\u0004\u0018\u00018\u00012\u0006\u0010\u0016\u001A\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u001AJ\b\u0010\u001B\u001A\u00020\u0015H\u0016J\b\u0010\'\u001A\u00020(H\u0016J\b\u0010)\u001A\u00020\rH\u0016J\u001F\u0010*\u001A\u0004\u0018\u00018\u00012\u0006\u0010\u0016\u001A\u00028\u00002\u0006\u0010\u0007\u001A\u00028\u0001H\u0016¢\u0006\u0002\u0010+J\u001E\u0010,\u001A\u00020\r2\u0014\u0010-\u001A\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000FH\u0016J\u0017\u0010.\u001A\u0004\u0018\u00018\u00012\u0006\u0010\u0016\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001AJ\u0017\u00101\u001A\u00020\u00152\u0006\u0010\u0007\u001A\u00028\u0001H\u0000¢\u0006\u0004\b2\u0010\u0017J.\u00108\u001A\u00020\u00152\u001E\u00109\u001A\u001A\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001E\u0012\u0004\u0012\u00020\u00150:H\u0080\b¢\u0006\u0002\b;J.\u0010<\u001A\u00020\u00152\u001E\u00109\u001A\u001A\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010=\u0012\u0004\u0012\u00020\u00150:H\u0080\b¢\u0006\u0002\b>J.\u0010?\u001A\u00020\u00152\u001E\u00109\u001A\u001A\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010=\u0012\u0004\u0012\u00020\u00150:H\u0080\b¢\u0006\u0002\b@J9\u0010E\u001A\u0002HF\"\u0004\b\u0002\u0010F2#\u0010G\u001A\u001F\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000104\u0012\u0004\u0012\u0002HF0:¢\u0006\u0002\bHH\u0082\b¢\u0006\u0002\u0010IJ9\u0010J\u001A\u0002HF\"\u0004\b\u0002\u0010F2#\u0010G\u001A\u001F\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000104\u0012\u0004\u0012\u0002HF0:¢\u0006\u0002\bHH\u0082\b¢\u0006\u0002\u0010IJ4\u0010K\u001A\u0002HF\"\u0004\b\u0002\u0010F2\u001E\u0010G\u001A\u001A\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0004\u0012\u0002HF0:H\u0082\b¢\u0006\u0002\u0010IJ4\u0010L\u001A\u00020\u0015*\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001042\u0006\u0010M\u001A\u00020\u00112\u0012\u0010N\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010OH\u0002J5\u0010P\u001A\u00020\r2*\u0010G\u001A&\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010O\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010O0:H\u0082\bJ,\u0010Q\u001A\u00020\u0011*\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001042\u0012\u0010N\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010OH\u0002R\u001E\u0010\t\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\b@RX\u0096\u000E¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0014\u0010\u0010\u001A\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0013R&\u0010\u001C\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001E0\u001DX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u001F\u0010 R\u001A\u0010!\u001A\b\u0012\u0004\u0012\u00028\u00000\u001DX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\"\u0010 R\u001A\u0010#\u001A\b\u0012\u0004\u0012\u00028\u00010$X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b%\u0010&R\u0014\u0010/\u001A\u00020\u00118@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b0\u0010\u0013R&\u00103\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001048@X\u0080\u0004¢\u0006\f\u0012\u0004\b5\u0010\u0006\u001A\u0004\b6\u00107R&\u0010A\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000F8AX\u0080\u0004¢\u0006\f\u0012\u0004\bB\u0010\u0006\u001A\u0004\bC\u0010D¨\u0006S"}, d2={"Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "K", "V", "Landroidx/compose/runtime/snapshots/StateObject;", "", "<init>", "()V", "value", "Landroidx/compose/runtime/snapshots/StateRecord;", "firstStateRecord", "getFirstStateRecord", "()Landroidx/compose/runtime/snapshots/StateRecord;", "prependStateRecord", "", "toMap", "", "size", "", "getSize", "()I", "containsKey", "", "key", "(Ljava/lang/Object;)Z", "containsValue", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "isEmpty", "entries", "", "", "getEntries", "()Ljava/util/Set;", "keys", "getKeys", "values", "", "getValues", "()Ljava/util/Collection;", "toString", "", "clear", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "putAll", "from", "remove", "modification", "getModification$runtime", "removeValue", "removeValue$runtime", "readable", "Landroidx/compose/runtime/snapshots/SnapshotStateMap$StateMapStateRecord;", "getReadable$runtime$annotations", "getReadable$runtime", "()Landroidx/compose/runtime/snapshots/SnapshotStateMap$StateMapStateRecord;", "removeIf", "predicate", "Lkotlin/Function1;", "removeIf$runtime", "any", "", "any$runtime", "all", "all$runtime", "debuggerDisplayValue", "getDebuggerDisplayValue$annotations", "getDebuggerDisplayValue", "()Ljava/util/Map;", "withCurrent", "R", "block", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "writable", "mutate", "attemptUpdate", "currentModification", "newMap", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "update", "commitUpdate", "StateMapStateRecord", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class SnapshotStateMap implements StateObject, Map, KMutableMap {
    @Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u00020\u0003B)\b\u0000\u0012\n\u0010\u0004\u001A\u00060\u0005j\u0002`\u0006\u0012\u0012\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u0003H\u0016J\b\u0010\u0018\u001A\u00020\u0003H\u0016J\u0019\u0010\u0018\u001A\u00020\u00032\n\u0010\u0004\u001A\u00060\u0005j\u0002`\u0006H\u0016¢\u0006\u0002\u0010\u0019R&\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\bX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000ER\u001A\u0010\u000F\u001A\u00020\u0010X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001A"}, d2={"Landroidx/compose/runtime/snapshots/SnapshotStateMap$StateMapStateRecord;", "K", "V", "Landroidx/compose/runtime/snapshots/StateRecord;", "snapshotId", "", "Landroidx/compose/runtime/snapshots/SnapshotId;", "map", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "<init>", "(JLandroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;)V", "getMap$runtime", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "setMap$runtime", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;)V", "modification", "", "getModification$runtime", "()I", "setModification$runtime", "(I)V", "assign", "", "value", "create", "(J)Landroidx/compose/runtime/snapshots/StateRecord;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class StateMapStateRecord extends StateRecord {
        public static final int $stable = 8;
        private PersistentMap map;
        private int modification;

        static {
        }

        public StateMapStateRecord(long arg1, PersistentMap arg3) {
            super(arg1);
            this.map = arg3;
        }

        public void assign(StateRecord arg3) {
            Intrinsics.checkNotNull(arg3, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord, V of androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord>");
            Object v0 = SnapshotStateMapKt.access$getSync$p();
            __monitor_enter(v0);
            try {
                this.map = ((StateMapStateRecord)arg3).map;
                this.modification = ((StateMapStateRecord)arg3).modification;
            }
            catch(Throwable v2) {
                __monitor_exit(v0);
                throw v2;
            }

            __monitor_exit(v0);
        }

        public StateRecord create() {
            return new StateMapStateRecord(SnapshotKt.currentSnapshot().getSnapshotId(), this.map);
        }

        public StateRecord create(long arg2) {
            return new StateMapStateRecord(arg2, this.map);
        }

        public final PersistentMap getMap$runtime() {
            return this.map;
        }

        public final int getModification$runtime() {
            return this.modification;
        }

        public final void setMap$runtime(PersistentMap arg1) {
            this.map = arg1;
        }

        public final void setModification$runtime(int arg1) {
            this.modification = arg1;
        }
    }

    public static final int $stable;
    private final Set entries;
    private StateRecord firstStateRecord;
    private final Set keys;
    private final Collection values;

    static {
    }

    public SnapshotStateMap() {
        super();
        PersistentMap v0 = ExtensionsKt.persistentHashMapOf();
        Snapshot v1 = SnapshotKt.currentSnapshot();
        StateMapStateRecord v2 = new StateMapStateRecord(v1.getSnapshotId(), v0);
        if(!(v1 instanceof GlobalSnapshot)) {
            v2.setNext$runtime(new StateMapStateRecord(SnapshotId_jvmKt.toSnapshotId(1), v0));
        }

        this.firstStateRecord = ((StateRecord)v2);
        this.entries = new SnapshotMapEntrySet(this);
        this.keys = new SnapshotMapKeySet(this);
        this.values = new SnapshotMapValueSet(this);
    }

    public static final boolean access$attemptUpdate(SnapshotStateMap arg0, StateMapStateRecord arg1, int arg2, PersistentMap arg3) {
        return arg0.attemptUpdate(arg1, arg2, arg3);
    }

    public final boolean all$runtime(Function1 arg2) {
        Iterator v1 = this.getReadable$runtime().getMap$runtime().entrySet().iterator();
        do {
            if(!v1.hasNext()) {
                return 1;
            }
        }
        while(arg2.invoke(v1.next()).booleanValue());

        return 0;
    }

    public final boolean any$runtime(Function1 arg2) {
        Iterator v1 = this.getReadable$runtime().getMap$runtime().entrySet().iterator();
        do {
            if(!v1.hasNext()) {
                return 0;
            }
        }
        while(!arg2.invoke(v1.next()).booleanValue());

        return 1;
    }

    private final boolean attemptUpdate(StateMapStateRecord arg2, int arg3, PersistentMap arg4) {
        boolean v4;
        Object v1 = SnapshotStateMapKt.access$getSync$p();
        __monitor_enter(v1);
        try {
            if(arg2.getModification$runtime() == arg3) {
                arg2.setMap$runtime(arg4);
                v4 = true;
                arg2.setModification$runtime(arg2.getModification$runtime() + 1);
            }
            else {
                goto label_10;
            }

            goto label_11;
        }
        catch(Throwable v2) {
            __monitor_exit(v1);
            throw v2;
        }

    label_10:
        v4 = false;
    label_11:
        __monitor_exit(v1);
        return v4;
    }

    public void clear() {
        Snapshot v4;
        StateRecord v0 = this.getFirstStateRecord();
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        v0 = SnapshotKt.current(v0);
        ((StateMapStateRecord)v0).getMap$runtime();
        PersistentMap v1 = ExtensionsKt.persistentHashMapOf();
        if(v1 != ((StateMapStateRecord)v0).getMap$runtime()) {
            v0 = this.getFirstStateRecord();
            Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
            SnapshotStateMap v2 = this;
            Object v3 = SnapshotKt.getLock();
            __monitor_enter(v3);
            try {
                v4 = Snapshot.Companion.getCurrent();
                this.commitUpdate(SnapshotKt.writableRecord(v0, ((StateObject)v2), v4), v1);
            }
            catch(Throwable v5) {
                __monitor_exit(v3);
                throw v5;
            }

            __monitor_exit(v3);
            SnapshotKt.notifyWrite(v4, ((StateObject)v2));
            return;
        }
    }

    private final int commitUpdate(StateMapStateRecord arg2, PersistentMap arg3) {
        int v3;
        Object v1 = SnapshotStateMapKt.access$getSync$p();
        __monitor_enter(v1);
        try {
            arg2.setMap$runtime(arg3);
            v3 = arg2.getModification$runtime();
            arg2.setModification$runtime(v3 + 1);
        }
        catch(Throwable v2) {
            __monitor_exit(v1);
            throw v2;
        }

        __monitor_exit(v1);
        return v3;
    }

    public boolean containsKey(Object arg1) {
        return this.getReadable$runtime().getMap$runtime().containsKey(arg1);
    }

    public boolean containsValue(Object arg1) {
        return this.getReadable$runtime().getMap$runtime().containsValue(arg1);
    }

    public final Set entrySet() {
        return this.getEntries();
    }

    public Object get(Object arg1) {
        return this.getReadable$runtime().getMap$runtime().get(arg1);
    }

    public final Map getDebuggerDisplayValue() {
        StateRecord v1 = this.getFirstStateRecord();
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        return SnapshotKt.current(v1).getMap$runtime();
    }

    public static void getDebuggerDisplayValue$annotations() {
    }

    public Set getEntries() {
        return this.entries;
    }

    public StateRecord getFirstStateRecord() {
        return this.firstStateRecord;
    }

    public Set getKeys() {
        return this.keys;
    }

    public final int getModification$runtime() {
        return this.getReadable$runtime().getModification$runtime();
    }

    public final StateMapStateRecord getReadable$runtime() {
        StateRecord v0 = this.getFirstStateRecord();
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        return SnapshotKt.readable(v0, ((StateObject)this));
    }

    public static void getReadable$runtime$annotations() {
    }

    public int getSize() {
        return this.getReadable$runtime().getMap$runtime().size();
    }

    public Collection getValues() {
        return this.values;
    }

    public boolean isEmpty() {
        return this.getReadable$runtime().getMap$runtime().isEmpty();
    }

    public final Set keySet() {
        return this.getKeys();
    }

    private final Object mutate(Function1 arg8) {
        Snapshot v6;
        Object v3;
        int v1_1;
        PersistentMap v2;
        do {
            Object v0 = SnapshotStateMapKt.access$getSync$p();
            __monitor_enter(v0);
            try {
                StateRecord v1 = this.getFirstStateRecord();
                Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
                v1 = SnapshotKt.current(v1);
                v2 = ((StateMapStateRecord)v1).getMap$runtime();
                v1_1 = ((StateMapStateRecord)v1).getModification$runtime();
            }
            catch(Throwable v7) {
                __monitor_exit(v0);
                throw v7;
            }

            __monitor_exit(v0);
            Intrinsics.checkNotNull(v2);
            Builder v0_1 = v2.builder();
            v3 = arg8.invoke(v0_1);
            PersistentMap v0_2 = v0_1.build();
            if(Intrinsics.areEqual(v0_2, v2)) {
                return v3;
            }

            StateRecord v2_1 = this.getFirstStateRecord();
            Intrinsics.checkNotNull(v2_1, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
            SnapshotStateMap v4 = this;
            Object v5 = SnapshotKt.getLock();
            __monitor_enter(v5);
            try {
                v6 = Snapshot.Companion.getCurrent();
                boolean v0_3 = this.attemptUpdate(SnapshotKt.writableRecord(v2_1, ((StateObject)v4), v6), v1_1, v0_2);
            }
            catch(Throwable v7) {
                __monitor_exit(v5);
                throw v7;
            }

            __monitor_exit(v5);
            SnapshotKt.notifyWrite(v6, ((StateObject)v4));
        }
        while(!v0_3);

        return v3;
    }

    public void prependStateRecord(StateRecord arg2) {
        Intrinsics.checkNotNull(arg2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        this.firstStateRecord = arg2;
    }

    public Object put(Object arg8, Object arg9) {
        Snapshot v6;
        Object v3;
        int v1_1;
        PersistentMap v2;
        do {
            Object v0 = SnapshotStateMapKt.access$getSync$p();
            __monitor_enter(v0);
            try {
                StateRecord v1 = this.getFirstStateRecord();
                Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
                v1 = SnapshotKt.current(v1);
                v2 = ((StateMapStateRecord)v1).getMap$runtime();
                v1_1 = ((StateMapStateRecord)v1).getModification$runtime();
            }
            catch(Throwable v7) {
                __monitor_exit(v0);
                throw v7;
            }

            __monitor_exit(v0);
            Intrinsics.checkNotNull(v2);
            Builder v0_1 = v2.builder();
            v3 = v0_1.put(arg8, arg9);
            PersistentMap v0_2 = v0_1.build();
            if(Intrinsics.areEqual(v0_2, v2)) {
                return v3;
            }

            StateRecord v2_1 = this.getFirstStateRecord();
            Intrinsics.checkNotNull(v2_1, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
            SnapshotStateMap v4 = this;
            Object v5 = SnapshotKt.getLock();
            __monitor_enter(v5);
            try {
                v6 = Snapshot.Companion.getCurrent();
                boolean v0_3 = this.attemptUpdate(SnapshotKt.writableRecord(v2_1, ((StateObject)v4), v6), v1_1, v0_2);
            }
            catch(Throwable v7) {
                __monitor_exit(v5);
                throw v7;
            }

            __monitor_exit(v5);
            SnapshotKt.notifyWrite(v6, ((StateObject)v4));
        }
        while(!v0_3);

        return v3;
    }

    public void putAll(Map arg7) {
        Snapshot v5;
        int v1_1;
        PersistentMap v2;
        do {
            Object v0 = SnapshotStateMapKt.access$getSync$p();
            __monitor_enter(v0);
            try {
                StateRecord v1 = this.getFirstStateRecord();
                Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
                v1 = SnapshotKt.current(v1);
                v2 = ((StateMapStateRecord)v1).getMap$runtime();
                v1_1 = ((StateMapStateRecord)v1).getModification$runtime();
            }
            catch(Throwable v6) {
                __monitor_exit(v0);
                throw v6;
            }

            __monitor_exit(v0);
            Intrinsics.checkNotNull(v2);
            Builder v0_1 = v2.builder();
            v0_1.putAll(arg7);
            PersistentMap v0_2 = v0_1.build();
            if(Intrinsics.areEqual(v0_2, v2)) {
                return;
            }

            StateRecord v2_1 = this.getFirstStateRecord();
            Intrinsics.checkNotNull(v2_1, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
            SnapshotStateMap v3 = this;
            Object v4 = SnapshotKt.getLock();
            __monitor_enter(v4);
            try {
                v5 = Snapshot.Companion.getCurrent();
                boolean v0_3 = this.attemptUpdate(SnapshotKt.writableRecord(v2_1, ((StateObject)v3), v5), v1_1, v0_2);
            }
            catch(Throwable v6) {
                __monitor_exit(v4);
                throw v6;
            }

            __monitor_exit(v4);
            SnapshotKt.notifyWrite(v5, ((StateObject)v3));
        }
        while(!v0_3);
    }

    public Object remove(Object arg8) {
        Snapshot v6;
        Object v3;
        int v1_1;
        PersistentMap v2;
        do {
            Object v0 = SnapshotStateMapKt.access$getSync$p();
            __monitor_enter(v0);
            try {
                StateRecord v1 = this.getFirstStateRecord();
                Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
                v1 = SnapshotKt.current(v1);
                v2 = ((StateMapStateRecord)v1).getMap$runtime();
                v1_1 = ((StateMapStateRecord)v1).getModification$runtime();
            }
            catch(Throwable v7) {
                __monitor_exit(v0);
                throw v7;
            }

            __monitor_exit(v0);
            Intrinsics.checkNotNull(v2);
            Builder v0_1 = v2.builder();
            v3 = v0_1.remove(arg8);
            PersistentMap v0_2 = v0_1.build();
            if(Intrinsics.areEqual(v0_2, v2)) {
                return v3;
            }

            StateRecord v2_1 = this.getFirstStateRecord();
            Intrinsics.checkNotNull(v2_1, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
            SnapshotStateMap v4 = this;
            Object v5 = SnapshotKt.getLock();
            __monitor_enter(v5);
            try {
                v6 = Snapshot.Companion.getCurrent();
                boolean v0_3 = this.attemptUpdate(SnapshotKt.writableRecord(v2_1, ((StateObject)v4), v6), v1_1, v0_2);
            }
            catch(Throwable v7) {
                __monitor_exit(v5);
                throw v7;
            }

            __monitor_exit(v5);
            SnapshotKt.notifyWrite(v6, ((StateObject)v4));
        }
        while(!v0_3);

        return v3;
    }

    public final boolean removeIf$runtime(Function1 arg9) {
        Snapshot v6_1;
        int v2_1;
        PersistentMap v3;
        boolean v0 = false;
        do {
            Object v1 = SnapshotStateMapKt.access$getSync$p();
            __monitor_enter(v1);
            try {
                StateRecord v2 = this.getFirstStateRecord();
                Intrinsics.checkNotNull(v2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
                v2 = SnapshotKt.current(v2);
                v3 = ((StateMapStateRecord)v2).getMap$runtime();
                v2_1 = ((StateMapStateRecord)v2).getModification$runtime();
            }
            catch(Throwable v8) {
                __monitor_exit(v1);
                throw v8;
            }

            __monitor_exit(v1);
            Intrinsics.checkNotNull(v3);
            Builder v1_1 = v3.builder();
            Builder v4 = v1_1;
            Iterator v5 = this.entrySet().iterator();
            while(v5.hasNext()) {
                Object v6 = v5.next();
                if(!arg9.invoke(v6).booleanValue()) {
                    continue;
                }

                ((Map)v4).remove(((Map$Entry)v6).getKey());
                v0 = true;
            }

            PersistentMap v1_2 = v1_1.build();
            if(Intrinsics.areEqual(v1_2, v3)) {
                return v0;
            }

            StateRecord v3_1 = this.getFirstStateRecord();
            Intrinsics.checkNotNull(v3_1, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
            SnapshotStateMap v4_1 = this;
            Object v5_1 = SnapshotKt.getLock();
            __monitor_enter(v5_1);
            try {
                v6_1 = Snapshot.Companion.getCurrent();
                boolean v1_3 = this.attemptUpdate(SnapshotKt.writableRecord(v3_1, ((StateObject)v4_1), v6_1), v2_1, v1_2);
            }
            catch(Throwable v8) {
                __monitor_exit(v5_1);
                throw v8;
            }

            __monitor_exit(v5_1);
            SnapshotKt.notifyWrite(v6_1, ((StateObject)v4_1));
        }
        while(!v1_3);

        return v0;
    }

    public final boolean removeValue$runtime(Object arg4) {
        Object v1;
        Iterator v0 = this.entrySet().iterator();
        do {
            if(v0.hasNext()) {
                v1 = v0.next();
                if(!Intrinsics.areEqual(v1.getValue(), arg4)) {
                    continue;
                }

                break;
            }
            else {
                goto label_10;
            }
        }
        while(true);

        goto label_11;
    label_10:
        v1 = null;
    label_11:
        if(v1 != null) {
            this.remove(((Map$Entry)v1).getKey());
            return 1;
        }

        return 0;
    }

    public final int size() {
        return this.getSize();
    }

    public final Map toMap() {
        return this.getReadable$runtime().getMap$runtime();
    }

    public String toString() {
        StateRecord v0 = this.getFirstStateRecord();
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        return "SnapshotStateMap(value=" + SnapshotKt.current(v0).getMap$runtime() + ")@" + this.hashCode();
    }

    private final void update(Function1 arg5) {
        Snapshot v3;
        StateRecord v0 = this.getFirstStateRecord();
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        v0 = SnapshotKt.current(v0);
        Object v5 = arg5.invoke(((StateMapStateRecord)v0).getMap$runtime());
        if(v5 != ((StateMapStateRecord)v0).getMap$runtime()) {
            v0 = this.getFirstStateRecord();
            Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
            SnapshotStateMap v1 = this;
            Object v2 = SnapshotKt.getLock();
            __monitor_enter(v2);
            try {
                v3 = Snapshot.Companion.getCurrent();
                this.commitUpdate(SnapshotKt.writableRecord(v0, ((StateObject)v1), v3), ((PersistentMap)v5));
            }
            catch(Throwable v4) {
                __monitor_exit(v2);
                throw v4;
            }

            __monitor_exit(v2);
            SnapshotKt.notifyWrite(v3, ((StateObject)v1));
            return;
        }
    }

    public final Collection values() {
        return this.getValues();
    }

    private final Object withCurrent(Function1 arg2) {
        StateRecord v1 = this.getFirstStateRecord();
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        return arg2.invoke(SnapshotKt.current(v1));
    }

    private final Object writable(Function1 arg4) {
        Object v4;
        Snapshot v2;
        StateRecord v0 = this.getFirstStateRecord();
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        Object v1 = SnapshotKt.getLock();
        __monitor_enter(v1);
        try {
            v2 = Snapshot.Companion.getCurrent();
            v4 = arg4.invoke(SnapshotKt.writableRecord(v0, ((StateObject)this), v2));
        }
        catch(Throwable v3) {
            __monitor_exit(v1);
            throw v3;
        }

        __monitor_exit(v1);
        SnapshotKt.notifyWrite(v2, ((StateObject)this));
        return v4;
    }
}

