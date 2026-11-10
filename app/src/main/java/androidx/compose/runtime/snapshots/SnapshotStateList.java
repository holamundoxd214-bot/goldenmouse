package androidx.compose.runtime.snapshots;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList$Builder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableList;

@Metadata(d1={"\u0000p\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\u001E\n\u0002\b\u0007\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010+\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 H*\u0004\b\u0000\u0010\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u00042\u00060\u0005j\u0002`\u0006:\u0001HB\u0017\b\u0000\u0012\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0004\b\t\u0010\nB\t\b\u0016¢\u0006\u0004\b\t\u0010\u000BJ\u0010\u0010\u0011\u001A\u00020\u00122\u0006\u0010\f\u001A\u00020\rH\u0016J\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00028\u00000\u0014J\u0016\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u001B\u001A\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u001CJ\u0016\u0010\u001D\u001A\u00020\u001A2\f\u0010\u001E\u001A\b\u0012\u0004\u0012\u00028\u00000\u001FH\u0016J\u0016\u0010 \u001A\u00028\u00002\u0006\u0010!\u001A\u00020\u0016H\u0096\u0002¢\u0006\u0002\u0010\"J\u0015\u0010#\u001A\u00020\u00162\u0006\u0010\u001B\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010$J\b\u0010%\u001A\u00020\u001AH\u0016J\u000F\u0010&\u001A\b\u0012\u0004\u0012\u00028\u00000\'H\u0096\u0002J\u0015\u0010(\u001A\u00020\u00162\u0006\u0010\u001B\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010$J\u000E\u0010)\u001A\b\u0012\u0004\u0012\u00028\u00000*H\u0016J\u0016\u0010)\u001A\b\u0012\u0004\u0012\u00028\u00000*2\u0006\u0010!\u001A\u00020\u0016H\u0016J\u001E\u0010+\u001A\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010,\u001A\u00020\u00162\u0006\u0010-\u001A\u00020\u0016H\u0016J\b\u0010.\u001A\u00020/H\u0016J\u0015\u00100\u001A\u00020\u001A2\u0006\u0010\u001B\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001CJ\u001D\u00100\u001A\u00020\u00122\u0006\u0010!\u001A\u00020\u00162\u0006\u0010\u001B\u001A\u00028\u0000H\u0016¢\u0006\u0002\u00101J\u001E\u00102\u001A\u00020\u001A2\u0006\u0010!\u001A\u00020\u00162\f\u0010\u001E\u001A\b\u0012\u0004\u0012\u00028\u00000\u001FH\u0016J\u0016\u00102\u001A\u00020\u001A2\f\u0010\u001E\u001A\b\u0012\u0004\u0012\u00028\u00000\u001FH\u0016J\b\u00103\u001A\u00020\u0012H\u0016J\u0015\u00104\u001A\u00020\u001A2\u0006\u0010\u001B\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001CJ\u0016\u00105\u001A\u00020\u001A2\f\u0010\u001E\u001A\b\u0012\u0004\u0012\u00028\u00000\u001FH\u0016J\u0015\u00106\u001A\u00028\u00002\u0006\u0010!\u001A\u00020\u0016H\u0016¢\u0006\u0002\u0010\"J\u0016\u00107\u001A\u00020\u001A2\f\u0010\u001E\u001A\b\u0012\u0004\u0012\u00028\u00000\u001FH\u0016J\u001E\u00108\u001A\u00028\u00002\u0006\u0010!\u001A\u00020\u00162\u0006\u0010\u001B\u001A\u00028\u0000H\u0096\u0002¢\u0006\u0002\u00109J\u0016\u0010:\u001A\u00020\u00122\u0006\u0010,\u001A\u00020\u00162\u0006\u0010-\u001A\u00020\u0016J+\u0010;\u001A\u00020\u00162\f\u0010\u001E\u001A\b\u0012\u0004\u0012\u00028\u00000\u001F2\u0006\u0010<\u001A\u00020\u00162\u0006\u0010=\u001A\u00020\u0016H\u0000¢\u0006\u0002\b>J\u0018\u0010C\u001A\u00020\u00122\u0006\u0010D\u001A\u00020E2\u0006\u0010F\u001A\u00020\u0016H\u0016J\b\u0010G\u001A\u00020\u0016H\u0016R\u001E\u0010\u000E\u001A\u00020\r2\u0006\u0010\f\u001A\u00020\r@RX\u0096\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0014\u0010\u0015\u001A\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0017\u0010\u0018R \u0010?\u001A\b\u0012\u0004\u0012\u00028\u00000\u00148AX\u0080\u0004¢\u0006\f\u0012\u0004\b@\u0010\u000B\u001A\u0004\bA\u0010B¨\u0006I"}, d2={"Landroidx/compose/runtime/snapshots/SnapshotStateList;", "T", "Landroid/os/Parcelable;", "Landroidx/compose/runtime/snapshots/StateObject;", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "persistentList", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "<init>", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;)V", "()V", "value", "Landroidx/compose/runtime/snapshots/StateRecord;", "firstStateRecord", "getFirstStateRecord", "()Landroidx/compose/runtime/snapshots/StateRecord;", "prependStateRecord", "", "toList", "", "size", "", "getSize", "()I", "contains", "", "element", "(Ljava/lang/Object;)Z", "containsAll", "elements", "", "get", "index", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "subList", "fromIndex", "toIndex", "toString", "", "add", "(ILjava/lang/Object;)V", "addAll", "clear", "remove", "removeAll", "removeAt", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "removeRange", "retainAllInRange", "start", "end", "retainAllInRange$runtime", "debuggerDisplayValue", "getDebuggerDisplayValue$annotations", "getDebuggerDisplayValue", "()Ljava/util/List;", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "describeContents", "Companion", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class SnapshotStateList implements Parcelable, StateObject, List, RandomAccess, KMutableList {
    @Metadata(d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001E\u0010\u0004\u001A\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2={"Landroidx/compose/runtime/snapshots/SnapshotStateList$Companion;", "", "<init>", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Companion {
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
        SnapshotStateList.Companion = new Companion(null);
        SnapshotStateList.CREATOR = new SnapshotStateList$Companion$CREATOR$1();
    }

    public SnapshotStateList() {
        this(ExtensionsKt.persistentListOf());
    }

    public SnapshotStateList(PersistentList arg1) {
        super();
        this.firstStateRecord = SnapshotStateListKt.stateRecordWith(this, arg1);
    }

    public boolean add(Object arg8) {
        Snapshot v5;
        PersistentList v1_1;
        int v2;
        StateRecord v1;
        do {
            Object v0 = SnapshotStateListKt.access$getSync$p();
            __monitor_enter(v0);
            try {
                v1 = this.getFirstStateRecord();
                Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");
                v1 = SnapshotKt.current(v1);
                v2 = ((StateListStateRecord)v1).getModification$runtime();
                v1_1 = ((StateListStateRecord)v1).getList$runtime();
            }
            catch(Throwable v7) {
                __monitor_exit(v0);
                throw v7;
            }

            __monitor_exit(v0);
            Intrinsics.checkNotNull(v1_1);
            PersistentList v0_1 = v1_1.add(arg8);
            if(Intrinsics.areEqual(v0_1, v1_1)) {
                return 0;
            }

            v1 = this.getFirstStateRecord();
            Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
            SnapshotStateList v3 = this;
            Object v4 = SnapshotKt.getLock();
            __monitor_enter(v4);
            try {
                v5 = Snapshot.Companion.getCurrent();
                boolean v0_2 = SnapshotStateListKt.attemptUpdate(SnapshotKt.writableRecord(v1, ((StateObject)v3), v5), v2, v0_1, true);
            }
            catch(Throwable v7) {
                __monitor_exit(v4);
                throw v7;
            }

            __monitor_exit(v4);
            SnapshotKt.notifyWrite(v5, ((StateObject)v3));
        }
        while(!v0_2);

        return 1;
    }

    public void add(int arg8, Object arg9) {
        Snapshot v5;
        PersistentList v1_1;
        int v2;
        StateRecord v1;
        do {
            Object v0 = SnapshotStateListKt.access$getSync$p();
            __monitor_enter(v0);
            try {
                v1 = this.getFirstStateRecord();
                Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");
                v1 = SnapshotKt.current(v1);
                v2 = ((StateListStateRecord)v1).getModification$runtime();
                v1_1 = ((StateListStateRecord)v1).getList$runtime();
            }
            catch(Throwable v7) {
                __monitor_exit(v0);
                throw v7;
            }

            __monitor_exit(v0);
            Intrinsics.checkNotNull(v1_1);
            PersistentList v0_1 = v1_1.add(arg8, arg9);
            if(Intrinsics.areEqual(v0_1, v1_1)) {
                return;
            }

            v1 = this.getFirstStateRecord();
            Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
            SnapshotStateList v3 = this;
            Object v4 = SnapshotKt.getLock();
            __monitor_enter(v4);
            try {
                v5 = Snapshot.Companion.getCurrent();
                boolean v0_2 = SnapshotStateListKt.attemptUpdate(SnapshotKt.writableRecord(v1, ((StateObject)v3), v5), v2, v0_1, true);
            }
            catch(Throwable v7) {
                __monitor_exit(v4);
                throw v7;
            }

            __monitor_exit(v4);
            SnapshotKt.notifyWrite(v5, ((StateObject)v3));
        }
        while(!v0_2);
    }

    public boolean addAll(Collection arg8) {
        Snapshot v5;
        PersistentList v1_1;
        int v2;
        StateRecord v1;
        do {
            Object v0 = SnapshotStateListKt.access$getSync$p();
            __monitor_enter(v0);
            try {
                v1 = this.getFirstStateRecord();
                Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");
                v1 = SnapshotKt.current(v1);
                v2 = ((StateListStateRecord)v1).getModification$runtime();
                v1_1 = ((StateListStateRecord)v1).getList$runtime();
            }
            catch(Throwable v7) {
                __monitor_exit(v0);
                throw v7;
            }

            __monitor_exit(v0);
            Intrinsics.checkNotNull(v1_1);
            PersistentList v0_1 = v1_1.addAll(arg8);
            if(Intrinsics.areEqual(v0_1, v1_1)) {
                return 0;
            }

            v1 = this.getFirstStateRecord();
            Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
            SnapshotStateList v3 = this;
            Object v4 = SnapshotKt.getLock();
            __monitor_enter(v4);
            try {
                v5 = Snapshot.Companion.getCurrent();
                boolean v0_2 = SnapshotStateListKt.attemptUpdate(SnapshotKt.writableRecord(v1, ((StateObject)v3), v5), v2, v0_1, true);
            }
            catch(Throwable v7) {
                __monitor_exit(v4);
                throw v7;
            }

            __monitor_exit(v4);
            SnapshotKt.notifyWrite(v5, ((StateObject)v3));
        }
        while(!v0_2);

        return 1;
    }

    public boolean addAll(int arg2, Collection arg3) {
        return SnapshotStateListKt.mutateBoolean(this, new SnapshotStateList$$ExternalSyntheticLambda1(arg2, arg3));
    }

    static final boolean addAll$lambda$0(int arg0, Collection arg1, List arg2) {
        return arg2.addAll(arg0, arg1);
    }

    public void clear() {
        Object v3;
        Snapshot v2;
        StateRecord v0 = this.getFirstStateRecord();
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
        Object v1 = SnapshotKt.getLock();
        __monitor_enter(v1);
        try {
            v2 = Snapshot.Companion.getCurrent();
            v0 = SnapshotKt.writableRecord(v0, ((StateObject)this), v2);
            v3 = SnapshotStateListKt.access$getSync$p();
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
        SnapshotKt.notifyWrite(v2, ((StateObject)this));
    }

    public boolean contains(Object arg1) {
        return SnapshotStateListKt.getReadable(this).getList$runtime().contains(arg1);
    }

    public boolean containsAll(Collection arg1) {
        return SnapshotStateListKt.getReadable(this).getList$runtime().containsAll(arg1);
    }

    public int describeContents() {
        return 0;
    }

    public Object get(int arg1) {
        return SnapshotStateListKt.getReadable(this).getList$runtime().get(arg1);
    }

    public final List getDebuggerDisplayValue() {
        StateRecord v1 = this.getFirstStateRecord();
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");
        return SnapshotKt.current(v1).getList$runtime();
    }

    public static void getDebuggerDisplayValue$annotations() {
    }

    public StateRecord getFirstStateRecord() {
        return this.firstStateRecord;
    }

    public int getSize() {
        return SnapshotStateListKt.getReadable(this).getList$runtime().size();
    }

    public int indexOf(Object arg1) {
        return SnapshotStateListKt.getReadable(this).getList$runtime().indexOf(arg1);
    }

    public boolean isEmpty() {
        return SnapshotStateListKt.getReadable(this).getList$runtime().isEmpty();
    }

    public Iterator iterator() {
        return this.listIterator();
    }

    public int lastIndexOf(Object arg1) {
        return SnapshotStateListKt.getReadable(this).getList$runtime().lastIndexOf(arg1);
    }

    public ListIterator listIterator() {
        return new StateListIterator(this, 0);
    }

    public ListIterator listIterator(int arg2) {
        return new StateListIterator(this, arg2);
    }

    public void prependStateRecord(StateRecord arg2) {
        arg2.setNext$runtime(this.getFirstStateRecord());
        Intrinsics.checkNotNull(arg2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        this.firstStateRecord = arg2;
    }

    public boolean remove(Object arg8) {
        Snapshot v5;
        PersistentList v1_1;
        int v2;
        StateRecord v1;
        do {
            Object v0 = SnapshotStateListKt.access$getSync$p();
            __monitor_enter(v0);
            try {
                v1 = this.getFirstStateRecord();
                Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");
                v1 = SnapshotKt.current(v1);
                v2 = ((StateListStateRecord)v1).getModification$runtime();
                v1_1 = ((StateListStateRecord)v1).getList$runtime();
            }
            catch(Throwable v7) {
                __monitor_exit(v0);
                throw v7;
            }

            __monitor_exit(v0);
            Intrinsics.checkNotNull(v1_1);
            PersistentList v0_1 = v1_1.remove(arg8);
            if(Intrinsics.areEqual(v0_1, v1_1)) {
                return 0;
            }

            v1 = this.getFirstStateRecord();
            Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
            SnapshotStateList v3 = this;
            Object v4 = SnapshotKt.getLock();
            __monitor_enter(v4);
            try {
                v5 = Snapshot.Companion.getCurrent();
                boolean v0_2 = SnapshotStateListKt.attemptUpdate(SnapshotKt.writableRecord(v1, ((StateObject)v3), v5), v2, v0_1, true);
            }
            catch(Throwable v7) {
                __monitor_exit(v4);
                throw v7;
            }

            __monitor_exit(v4);
            SnapshotKt.notifyWrite(v5, ((StateObject)v3));
        }
        while(!v0_2);

        return 1;
    }

    public final Object remove(int arg1) {
        return this.removeAt(arg1);
    }

    public boolean removeAll(Collection arg8) {
        Snapshot v5;
        PersistentList v1_1;
        int v2;
        StateRecord v1;
        do {
            Object v0 = SnapshotStateListKt.access$getSync$p();
            __monitor_enter(v0);
            try {
                v1 = this.getFirstStateRecord();
                Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");
                v1 = SnapshotKt.current(v1);
                v2 = ((StateListStateRecord)v1).getModification$runtime();
                v1_1 = ((StateListStateRecord)v1).getList$runtime();
            }
            catch(Throwable v7) {
                __monitor_exit(v0);
                throw v7;
            }

            __monitor_exit(v0);
            Intrinsics.checkNotNull(v1_1);
            PersistentList v0_1 = v1_1.removeAll(arg8);
            if(Intrinsics.areEqual(v0_1, v1_1)) {
                return 0;
            }

            v1 = this.getFirstStateRecord();
            Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
            SnapshotStateList v3 = this;
            Object v4 = SnapshotKt.getLock();
            __monitor_enter(v4);
            try {
                v5 = Snapshot.Companion.getCurrent();
                boolean v0_2 = SnapshotStateListKt.attemptUpdate(SnapshotKt.writableRecord(v1, ((StateObject)v3), v5), v2, v0_1, true);
            }
            catch(Throwable v7) {
                __monitor_exit(v4);
                throw v7;
            }

            __monitor_exit(v4);
            SnapshotKt.notifyWrite(v5, ((StateObject)v3));
        }
        while(!v0_2);

        return 1;
    }

    public Object removeAt(int arg9) {
        Snapshot v6;
        PersistentList v2_1;
        int v3;
        StateRecord v2;
        Object v0 = this.get(arg9);
        do {
            Object v1 = SnapshotStateListKt.access$getSync$p();
            __monitor_enter(v1);
            try {
                v2 = this.getFirstStateRecord();
                Intrinsics.checkNotNull(v2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");
                v2 = SnapshotKt.current(v2);
                v3 = ((StateListStateRecord)v2).getModification$runtime();
                v2_1 = ((StateListStateRecord)v2).getList$runtime();
            }
            catch(Throwable v8) {
                __monitor_exit(v1);
                throw v8;
            }

            __monitor_exit(v1);
            Intrinsics.checkNotNull(v2_1);
            PersistentList v1_1 = v2_1.removeAt(arg9);
            if(Intrinsics.areEqual(v1_1, v2_1)) {
                return v0;
            }

            v2 = this.getFirstStateRecord();
            Intrinsics.checkNotNull(v2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
            SnapshotStateList v4 = this;
            Object v5 = SnapshotKt.getLock();
            __monitor_enter(v5);
            try {
                v6 = Snapshot.Companion.getCurrent();
                boolean v1_2 = SnapshotStateListKt.attemptUpdate(SnapshotKt.writableRecord(v2, ((StateObject)v4), v6), v3, v1_1, true);
            }
            catch(Throwable v8) {
                __monitor_exit(v5);
                throw v8;
            }

            __monitor_exit(v5);
            SnapshotKt.notifyWrite(v6, ((StateObject)v4));
        }
        while(!v1_2);

        return v0;
    }

    public final void removeRange(int arg8, int arg9) {
        Snapshot v5;
        PersistentList v1_1;
        int v2;
        StateRecord v1;
        do {
            Object v0 = SnapshotStateListKt.access$getSync$p();
            __monitor_enter(v0);
            try {
                v1 = this.getFirstStateRecord();
                Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");
                v1 = SnapshotKt.current(v1);
                v2 = ((StateListStateRecord)v1).getModification$runtime();
                v1_1 = ((StateListStateRecord)v1).getList$runtime();
            }
            catch(Throwable v7) {
                __monitor_exit(v0);
                throw v7;
            }

            __monitor_exit(v0);
            Intrinsics.checkNotNull(v1_1);
            Builder v0_1 = v1_1.builder();
            v0_1.subList(arg8, arg9).clear();
            PersistentList v0_2 = v0_1.build();
            if(Intrinsics.areEqual(v0_2, v1_1)) {
                return;
            }

            v1 = this.getFirstStateRecord();
            Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
            SnapshotStateList v3 = this;
            Object v4 = SnapshotKt.getLock();
            __monitor_enter(v4);
            try {
                v5 = Snapshot.Companion.getCurrent();
                boolean v0_3 = SnapshotStateListKt.attemptUpdate(SnapshotKt.writableRecord(v1, ((StateObject)v3), v5), v2, v0_2, true);
            }
            catch(Throwable v7) {
                __monitor_exit(v4);
                throw v7;
            }

            __monitor_exit(v4);
            SnapshotKt.notifyWrite(v5, ((StateObject)v3));
        }
        while(!v0_3);
    }

    public boolean retainAll(Collection arg2) {
        return SnapshotStateListKt.mutateBoolean(this, new SnapshotStateList$$ExternalSyntheticLambda0(arg2));
    }

    static final boolean retainAll$lambda$0(Collection arg0, List arg1) {
        return arg1.retainAll(arg0);
    }

    public final int retainAllInRange$runtime(Collection arg9, int arg10, int arg11) {
        Snapshot v6;
        PersistentList v2_1;
        int v3;
        StateRecord v2;
        int v0 = this.size();
        do {
            Object v1 = SnapshotStateListKt.access$getSync$p();
            __monitor_enter(v1);
            try {
                v2 = this.getFirstStateRecord();
                Intrinsics.checkNotNull(v2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");
                v2 = SnapshotKt.current(v2);
                v3 = ((StateListStateRecord)v2).getModification$runtime();
                v2_1 = ((StateListStateRecord)v2).getList$runtime();
            }
            catch(Throwable v8) {
                __monitor_exit(v1);
                throw v8;
            }

            __monitor_exit(v1);
            Intrinsics.checkNotNull(v2_1);
            Builder v1_1 = v2_1.builder();
            v1_1.subList(arg10, arg11).retainAll(arg9);
            PersistentList v1_2 = v1_1.build();
            if(Intrinsics.areEqual(v1_2, v2_1)) {
                break;
            }

            v2 = this.getFirstStateRecord();
            Intrinsics.checkNotNull(v2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
            SnapshotStateList v4 = this;
            Object v5 = SnapshotKt.getLock();
            __monitor_enter(v5);
            try {
                v6 = Snapshot.Companion.getCurrent();
                boolean v1_3 = SnapshotStateListKt.attemptUpdate(SnapshotKt.writableRecord(v2, ((StateObject)v4), v6), v3, v1_2, true);
            }
            catch(Throwable v8) {
                __monitor_exit(v5);
                throw v8;
            }

            __monitor_exit(v5);
            SnapshotKt.notifyWrite(v6, ((StateObject)v4));
        }
        while(!v1_3);

        return v0 - this.size();
    }

    public Object set(int arg9, Object arg10) {
        Snapshot v6;
        PersistentList v2_1;
        int v3;
        StateRecord v2;
        Object v0 = this.get(arg9);
        do {
            Object v1 = SnapshotStateListKt.access$getSync$p();
            __monitor_enter(v1);
            try {
                v2 = this.getFirstStateRecord();
                Intrinsics.checkNotNull(v2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");
                v2 = SnapshotKt.current(v2);
                v3 = ((StateListStateRecord)v2).getModification$runtime();
                v2_1 = ((StateListStateRecord)v2).getList$runtime();
            }
            catch(Throwable v8) {
                __monitor_exit(v1);
                throw v8;
            }

            __monitor_exit(v1);
            Intrinsics.checkNotNull(v2_1);
            PersistentList v1_1 = v2_1.set(arg9, arg10);
            if(Intrinsics.areEqual(v1_1, v2_1)) {
                return v0;
            }

            v2 = this.getFirstStateRecord();
            Intrinsics.checkNotNull(v2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
            SnapshotStateList v4 = this;
            Object v5 = SnapshotKt.getLock();
            __monitor_enter(v5);
            try {
                v6 = Snapshot.Companion.getCurrent();
                boolean v1_2 = SnapshotStateListKt.attemptUpdate(SnapshotKt.writableRecord(v2, ((StateObject)v4), v6), v3, v1_1, false);
            }
            catch(Throwable v8) {
                __monitor_exit(v5);
                throw v8;
            }

            __monitor_exit(v5);
            SnapshotKt.notifyWrite(v6, ((StateObject)v4));
        }
        while(!v1_2);

        return v0;
    }

    public final int size() {
        return this.getSize();
    }

    public List subList(int arg2, int arg3) {
        int v0 = arg2 < 0 || arg2 > arg3 || arg3 > this.size() ? 0 : 1;
        if(v0 == 0) {
            PreconditionsKt.throwIllegalArgumentException("fromIndex or toIndex are out of bounds");
        }

        return new SubList(this, arg2, arg3);
    }

    public Object[] toArray() {
        return CollectionToArray.toArray(((Collection)this));
    }

    public Object[] toArray(Object[] arg1) {
        return CollectionToArray.toArray(((Collection)this), arg1);
    }

    public final List toList() {
        return SnapshotStateListKt.getReadable(this).getList$runtime();
    }

    public String toString() {
        StateRecord v0 = this.getFirstStateRecord();
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        return "SnapshotStateList(value=" + SnapshotKt.current(v0).getList$runtime() + ")@" + this.hashCode();
    }

    public void writeToParcel(Parcel arg3, int arg4) {
        List v2 = this.toList();
        arg4 = v2.size();
        arg3.writeInt(arg4);
        int v0;
        for(v0 = 0; v0 < arg4; ++v0) {
            arg3.writeValue(v2.get(v0));
        }
    }
}

