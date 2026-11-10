package androidx.compose.runtime.snapshots;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.RandomAccess;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableSet;

@Metadata(d1={"\u0000`\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\u001E\n\u0002\b\u0002\n\u0002\u0010)\n\u0000\n\u0002\u0010\u000E\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 1*\u0004\b\u0000\u0010\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u00042\u00060\u0005j\u0002`\u0006:\u00011B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\t\u001A\u00020\nH\u0016J\f\u0010\u0010\u001A\b\u0012\u0004\u0012\u00028\u00000\u0011J\u0016\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0019J\u0016\u0010\u001A\u001A\u00020\u00172\f\u0010\u001B\u001A\b\u0012\u0004\u0012\u00028\u00000\u001CH\u0016J\b\u0010\u001D\u001A\u00020\u0017H\u0016J\u000F\u0010\u001E\u001A\b\u0012\u0004\u0012\u00028\u00000\u001FH\u0096\u0002J\b\u0010 \u001A\u00020!H\u0016J\u0015\u0010\"\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0019J\u0016\u0010#\u001A\u00020\u00172\f\u0010\u001B\u001A\b\u0012\u0004\u0012\u00028\u00000\u001CH\u0016J\b\u0010$\u001A\u00020\u000FH\u0016J\u0015\u0010%\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0019J\u0016\u0010&\u001A\u00020\u00172\f\u0010\u001B\u001A\b\u0012\u0004\u0012\u00028\u00000\u001CH\u0016J\u0016\u0010\'\u001A\u00020\u00172\f\u0010\u001B\u001A\b\u0012\u0004\u0012\u00028\u00000\u001CH\u0016J\u0018\u0010,\u001A\u00020\u000F2\u0006\u0010-\u001A\u00020.2\u0006\u0010/\u001A\u00020\u0013H\u0016J\b\u00100\u001A\u00020\u0013H\u0016R\u001E\u0010\u000B\u001A\u00020\n2\u0006\u0010\t\u001A\u00020\n@RX\u0096\u000E¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001A\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015R \u0010(\u001A\b\u0012\u0004\u0012\u00028\u00000\u00118AX\u0080\u0004¢\u0006\f\u0012\u0004\b)\u0010\b\u001A\u0004\b*\u0010+¨\u00062"}, d2={"Landroidx/compose/runtime/snapshots/SnapshotStateSet;", "T", "Landroid/os/Parcelable;", "Landroidx/compose/runtime/snapshots/StateObject;", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "<init>", "()V", "value", "Landroidx/compose/runtime/snapshots/StateRecord;", "firstStateRecord", "getFirstStateRecord", "()Landroidx/compose/runtime/snapshots/StateRecord;", "prependStateRecord", "", "toSet", "", "size", "", "getSize", "()I", "contains", "", "element", "(Ljava/lang/Object;)Z", "containsAll", "elements", "", "isEmpty", "iterator", "", "toString", "", "add", "addAll", "clear", "remove", "removeAll", "retainAll", "debuggerDisplayValue", "getDebuggerDisplayValue$annotations", "getDebuggerDisplayValue", "()Ljava/util/Set;", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "describeContents", "Companion", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class SnapshotStateSet implements Parcelable, StateObject, RandomAccess, Set, KMutableSet {
    @Metadata(d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001E\u0010\u0004\u001A\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2={"Landroidx/compose/runtime/snapshots/SnapshotStateSet$Companion;", "", "<init>", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Landroidx/compose/runtime/snapshots/SnapshotStateSet;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    public static final int $stable;
    public static final Parcelable$Creator CREATOR;
    public static final Companion Companion;
    private StateRecord firstStateRecord;

    static {
        SnapshotStateSet.Companion = new Companion(null);
        SnapshotStateSet.CREATOR = new SnapshotStateSet$Companion$CREATOR$1();
    }

    public SnapshotStateSet() {
        super();
        this.firstStateRecord = SnapshotStateSetKt.stateRecordWith(this, ExtensionsKt.persistentSetOf());
    }

    public boolean add(Object arg7) {
        Snapshot v5;
        PersistentSet v1_1;
        int v2;
        StateRecord v1;
        do {
            Object v0 = SnapshotStateSetKt.access$getSync$p();
            __monitor_enter(v0);
            try {
                v1 = this.getFirstStateRecord();
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
            PersistentSet v0_1 = v1_1.add(arg7);
            if(Intrinsics.areEqual(v0_1, v1_1)) {
                return 0;
            }

            v1 = this.getFirstStateRecord();
            Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.writable>");
            SnapshotStateSet v3 = this;
            Object v4 = SnapshotKt.getLock();
            __monitor_enter(v4);
            try {
                v5 = Snapshot.Companion.getCurrent();
                boolean v0_2 = SnapshotStateSetKt.attemptUpdate(SnapshotKt.writableRecord(v1, ((StateObject)v3), v5), v2, v0_1);
            }
            catch(Throwable v6) {
                __monitor_exit(v4);
                throw v6;
            }

            __monitor_exit(v4);
            SnapshotKt.notifyWrite(v5, ((StateObject)v3));
        }
        while(!v0_2);

        return 1;
    }

    public boolean addAll(Collection arg7) {
        Snapshot v5;
        PersistentSet v1_1;
        int v2;
        StateRecord v1;
        do {
            Object v0 = SnapshotStateSetKt.access$getSync$p();
            __monitor_enter(v0);
            try {
                v1 = this.getFirstStateRecord();
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
            PersistentSet v0_1 = v1_1.addAll(arg7);
            if(Intrinsics.areEqual(v0_1, v1_1)) {
                return 0;
            }

            v1 = this.getFirstStateRecord();
            Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.writable>");
            SnapshotStateSet v3 = this;
            Object v4 = SnapshotKt.getLock();
            __monitor_enter(v4);
            try {
                v5 = Snapshot.Companion.getCurrent();
                boolean v0_2 = SnapshotStateSetKt.attemptUpdate(SnapshotKt.writableRecord(v1, ((StateObject)v3), v5), v2, v0_1);
            }
            catch(Throwable v6) {
                __monitor_exit(v4);
                throw v6;
            }

            __monitor_exit(v4);
            SnapshotKt.notifyWrite(v5, ((StateObject)v3));
        }
        while(!v0_2);

        return 1;
    }

    public void clear() {
        Object v3;
        Snapshot v2;
        StateRecord v0 = this.getFirstStateRecord();
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.writable>");
        Object v1 = SnapshotKt.getLock();
        __monitor_enter(v1);
        try {
            v2 = Snapshot.Companion.getCurrent();
            v0 = SnapshotKt.writableRecord(v0, ((StateObject)this), v2);
            v3 = SnapshotStateSetKt.access$getSync$p();
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
        SnapshotKt.notifyWrite(v2, ((StateObject)this));
    }

    public boolean contains(Object arg1) {
        return SnapshotStateSetKt.getReadable(this).getSet$runtime().contains(arg1);
    }

    public boolean containsAll(Collection arg1) {
        return SnapshotStateSetKt.getReadable(this).getSet$runtime().containsAll(arg1);
    }

    public int describeContents() {
        return 0;
    }

    public final Set getDebuggerDisplayValue() {
        StateRecord v1 = this.getFirstStateRecord();
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.withCurrent>");
        return SnapshotKt.current(v1).getSet$runtime();
    }

    public static void getDebuggerDisplayValue$annotations() {
    }

    public StateRecord getFirstStateRecord() {
        return this.firstStateRecord;
    }

    public int getSize() {
        return SnapshotStateSetKt.getReadable(this).getSet$runtime().size();
    }

    public boolean isEmpty() {
        return SnapshotStateSetKt.getReadable(this).getSet$runtime().isEmpty();
    }

    public Iterator iterator() {
        return new StateSetIterator(this, SnapshotStateSetKt.getReadable(this).getSet$runtime().iterator());
    }

    public void prependStateRecord(StateRecord arg2) {
        arg2.setNext$runtime(this.getFirstStateRecord());
        Intrinsics.checkNotNull(arg2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSet>");
        this.firstStateRecord = arg2;
    }

    public boolean remove(Object arg7) {
        Snapshot v5;
        PersistentSet v1_1;
        int v2;
        StateRecord v1;
        do {
            Object v0 = SnapshotStateSetKt.access$getSync$p();
            __monitor_enter(v0);
            try {
                v1 = this.getFirstStateRecord();
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
            PersistentSet v0_1 = v1_1.remove(arg7);
            if(Intrinsics.areEqual(v0_1, v1_1)) {
                return 0;
            }

            v1 = this.getFirstStateRecord();
            Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.writable>");
            SnapshotStateSet v3 = this;
            Object v4 = SnapshotKt.getLock();
            __monitor_enter(v4);
            try {
                v5 = Snapshot.Companion.getCurrent();
                boolean v0_2 = SnapshotStateSetKt.attemptUpdate(SnapshotKt.writableRecord(v1, ((StateObject)v3), v5), v2, v0_1);
            }
            catch(Throwable v6) {
                __monitor_exit(v4);
                throw v6;
            }

            __monitor_exit(v4);
            SnapshotKt.notifyWrite(v5, ((StateObject)v3));
        }
        while(!v0_2);

        return 1;
    }

    public boolean removeAll(Collection arg7) {
        Snapshot v5;
        PersistentSet v1_1;
        int v2;
        StateRecord v1;
        do {
            Object v0 = SnapshotStateSetKt.access$getSync$p();
            __monitor_enter(v0);
            try {
                v1 = this.getFirstStateRecord();
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
            PersistentSet v0_1 = v1_1.removeAll(arg7);
            if(Intrinsics.areEqual(v0_1, v1_1)) {
                return 0;
            }

            v1 = this.getFirstStateRecord();
            Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.writable>");
            SnapshotStateSet v3 = this;
            Object v4 = SnapshotKt.getLock();
            __monitor_enter(v4);
            try {
                v5 = Snapshot.Companion.getCurrent();
                boolean v0_2 = SnapshotStateSetKt.attemptUpdate(SnapshotKt.writableRecord(v1, ((StateObject)v3), v5), v2, v0_1);
            }
            catch(Throwable v6) {
                __monitor_exit(v4);
                throw v6;
            }

            __monitor_exit(v4);
            SnapshotKt.notifyWrite(v5, ((StateObject)v3));
        }
        while(!v0_2);

        return 1;
    }

    public boolean retainAll(Collection arg2) {
        return SnapshotStateSetKt.mutateBoolean(this, new SnapshotStateSet$$ExternalSyntheticLambda0(arg2));
    }

    static final boolean retainAll$lambda$0(Collection arg0, Set arg1) {
        return arg1.retainAll(CollectionsKt.toSet(((Iterable)arg0)));
    }

    public final int size() {
        return this.getSize();
    }

    public Object[] toArray() {
        return CollectionToArray.toArray(((Collection)this));
    }

    public Object[] toArray(Object[] arg1) {
        return CollectionToArray.toArray(((Collection)this), arg1);
    }

    public final Set toSet() {
        return SnapshotStateSetKt.getReadable(this).getSet$runtime();
    }

    public String toString() {
        StateRecord v0 = this.getFirstStateRecord();
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSet>");
        return "SnapshotStateSet(value=" + SnapshotKt.current(v0).getSet$runtime() + ")@" + this.hashCode();
    }

    public void writeToParcel(Parcel arg1, int arg2) {
        Set v2 = this.toSet();
        arg1.writeInt(this.size());
        Iterator v0 = v2.iterator();
        if(v0.hasNext()) {
            arg1.writeValue(v0.next());
        }
    }
}

