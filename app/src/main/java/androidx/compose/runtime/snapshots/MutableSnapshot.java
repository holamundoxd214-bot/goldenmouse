package androidx.compose.runtime.snapshots;

import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.collection.ScatterSetWrapperKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import androidx.compose.runtime.internal.Trace;
import androidx.compose.runtime.snapshots.tooling.SnapshotInstanceObservers;
import androidx.compose.runtime.snapshots.tooling.SnapshotObserverKt;
import androidx.compose.runtime.tooling.ComposeToolingFlags;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0012\n\u0002\u0010 \n\u0002\b\u0014\b\u0017\u0018\u0000 l2\u00020\u0001:\u0001lBI\b\u0000\u0012\n\u0010\u0002\u001A\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0014\u0010\u0007\u001A\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b\u0012\u0014\u0010\u000B\u001A\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0011\u001A\u00020\u0012H\u0016J8\u0010\u0013\u001A\u00020\u00002\u0016\b\u0002\u0010\u0007\u001A\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b2\u0016\b\u0002\u0010\u000B\u001A\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bH\u0016J\b\u0010\u0014\u001A\u00020\u0015H\u0016J\b\u0010\u001C\u001A\u00020\nH\u0016J\u001E\u0010\u001D\u001A\u00020\u00012\u0014\u0010\u0007\u001A\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bH\u0016J\u0015\u0010\u001E\u001A\u00020\n2\u0006\u0010\u001F\u001A\u00020\u0001H\u0010¢\u0006\u0002\b J\u0015\u0010!\u001A\u00020\n2\u0006\u0010\u001F\u001A\u00020\u0001H\u0010¢\u0006\u0002\b\"J\r\u0010#\u001A\u00020\nH\u0010¢\u0006\u0002\b$J\r\u0010%\u001A\u00020\nH\u0010¢\u0006\u0002\b&J\r\u0010\'\u001A\u00020\nH\u0010¢\u0006\u0002\b(J\b\u0010)\u001A\u00020\nH\u0002J\b\u0010*\u001A\u00020\nH\u0002J\b\u0010+\u001A\u00020\nH\u0002JG\u0010,\u001A\u00020\u00152\n\u0010-\u001A\u00060\u0003j\u0002`\u00042\f\u0010.\u001A\b\u0012\u0004\u0012\u0002000/2\u0014\u00101\u001A\u0010\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u000203\u0018\u0001022\u0006\u00104\u001A\u00020\u0006H\u0000¢\u0006\u0004\b5\u00106J$\u00107\u001A\u0002H8\"\u0004\b\u0000\u001082\f\u00109\u001A\b\u0012\u0004\u0012\u0002H80:H\u0080\b¢\u0006\u0004\b;\u0010<J\r\u00107\u001A\u00020\nH\u0000¢\u0006\u0002\b;J\u001B\u0010=\u001A\u00020\n2\n\u0010>\u001A\u00060\u0003j\u0002`\u0004H\u0000¢\u0006\u0004\b?\u0010@J\u0015\u0010A\u001A\u00020\n2\u0006\u0010>\u001A\u00020BH\u0000¢\u0006\u0002\bCJ\u0015\u0010D\u001A\u00020\n2\u0006\u0010E\u001A\u00020FH\u0000¢\u0006\u0002\bGJ\b\u0010H\u001A\u00020\nH\u0002J\u0015\u0010I\u001A\u00020\n2\u0006\u0010J\u001A\u00020\u0006H\u0000¢\u0006\u0002\bKJ\u0015\u0010L\u001A\u00020\n2\u0006\u0010M\u001A\u000200H\u0010¢\u0006\u0002\bNR\"\u0010\u0007\u001A\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bX\u0090\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\"\u0010\u000B\u001A\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bX\u0090\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u000FR\u0014\u0010\u0016\u001A\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001A\u00020\u00018VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001A\u0010\u001BR\u001A\u0010O\u001A\u00020BX\u0090\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bP\u0010Q\"\u0004\bR\u0010SR\"\u0010.\u001A\n\u0012\u0004\u0012\u000200\u0018\u00010/X\u0090\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bT\u0010U\"\u0004\bV\u0010WR\"\u0010X\u001A\n\u0012\u0004\u0012\u000200\u0018\u00010YX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u001A\u0010^\u001A\u00020\u0006X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b_\u0010`\"\u0004\ba\u0010bR\u001A\u0010c\u001A\u00020FX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bd\u0010e\"\u0004\bf\u0010gR\u000E\u0010J\u001A\u00020BX\u0082\u000E¢\u0006\u0002\n\u0000R\u001A\u0010h\u001A\u00020\u0012X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bi\u0010\u0018\"\u0004\bj\u0010k¨\u0006m"}, d2={"Landroidx/compose/runtime/snapshots/MutableSnapshot;", "Landroidx/compose/runtime/snapshots/Snapshot;", "snapshotId", "", "Landroidx/compose/runtime/snapshots/SnapshotId;", "invalid", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "readObserver", "Lkotlin/Function1;", "", "", "writeObserver", "<init>", "(JLandroidx/compose/runtime/snapshots/SnapshotIdSet;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getReadObserver$runtime", "()Lkotlin/jvm/functions/Function1;", "getWriteObserver$runtime", "hasPendingChanges", "", "takeNestedMutableSnapshot", "apply", "Landroidx/compose/runtime/snapshots/SnapshotApplyResult;", "readOnly", "getReadOnly", "()Z", "root", "getRoot", "()Landroidx/compose/runtime/snapshots/Snapshot;", "dispose", "takeNestedSnapshot", "nestedActivated", "snapshot", "nestedActivated$runtime", "nestedDeactivated", "nestedDeactivated$runtime", "notifyObjectsInitialized", "notifyObjectsInitialized$runtime", "closeLocked", "closeLocked$runtime", "releasePinnedSnapshotsForCloseLocked", "releasePinnedSnapshotsForCloseLocked$runtime", "validateNotApplied", "validateNotAppliedOrPinned", "abandon", "innerApplyLocked", "nextId", "modified", "Landroidx/collection/MutableScatterSet;", "Landroidx/compose/runtime/snapshots/StateObject;", "optimisticMerges", "", "Landroidx/compose/runtime/snapshots/StateRecord;", "invalidSnapshots", "innerApplyLocked$runtime", "(JLandroidx/collection/MutableScatterSet;Ljava/util/Map;Landroidx/compose/runtime/snapshots/SnapshotIdSet;)Landroidx/compose/runtime/snapshots/SnapshotApplyResult;", "advance", "T", "block", "Lkotlin/Function0;", "advance$runtime", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "recordPrevious", "id", "recordPrevious$runtime", "(J)V", "recordPreviousPinnedSnapshot", "", "recordPreviousPinnedSnapshot$runtime", "recordPreviousPinnedSnapshots", "handles", "", "recordPreviousPinnedSnapshots$runtime", "releasePreviouslyPinnedSnapshotsLocked", "recordPreviousList", "snapshots", "recordPreviousList$runtime", "recordModified", "state", "recordModified$runtime", "writeCount", "getWriteCount$runtime", "()I", "setWriteCount$runtime", "(I)V", "getModified$runtime", "()Landroidx/collection/MutableScatterSet;", "setModified$runtime", "(Landroidx/collection/MutableScatterSet;)V", "merged", "", "getMerged$runtime", "()Ljava/util/List;", "setMerged$runtime", "(Ljava/util/List;)V", "previousIds", "getPreviousIds$runtime", "()Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "setPreviousIds$runtime", "(Landroidx/compose/runtime/snapshots/SnapshotIdSet;)V", "previousPinnedSnapshots", "getPreviousPinnedSnapshots$runtime", "()[I", "setPreviousPinnedSnapshots$runtime", "([I)V", "applied", "getApplied$runtime", "setApplied$runtime", "(Z)V", "Companion", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public class MutableSnapshot extends Snapshot {
    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2={"Landroidx/compose/runtime/snapshots/MutableSnapshot$Companion;", "", "<init>", "()V", "EmptyIntArray", "", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    public static final int $stable;
    private static final Companion Companion;
    private static final int[] EmptyIntArray;
    private boolean applied;
    private List merged;
    private MutableScatterSet modified;
    private SnapshotIdSet previousIds;
    private int[] previousPinnedSnapshots;
    private final Function1 readObserver;
    private int snapshots;
    private int writeCount;
    private final Function1 writeObserver;

    static {
        MutableSnapshot.Companion = new Companion(null);
        MutableSnapshot.$stable = 8;
        MutableSnapshot.EmptyIntArray = new int[0];
    }

    public MutableSnapshot(long arg2, SnapshotIdSet arg4, Function1 arg5, Function1 arg6) {
        super(arg2, arg4, null);
        this.readObserver = arg5;
        this.writeObserver = arg6;
        this.previousIds = SnapshotIdSet.Companion.getEMPTY();
        this.previousPinnedSnapshots = MutableSnapshot.EmptyIntArray;
        this.snapshots = 1;
    }

    private final void abandon() {
        MutableSnapshot v0 = this;
        MutableScatterSet v1 = v0.getModified$runtime();
        if(v1 != null) {
            v0.validateNotApplied();
            v0.setModified$runtime(null);
            long v2 = v0.getSnapshotId();
            Object[] v4 = ((ScatterSet)v1).elements;
            long[] v1_1 = ((ScatterSet)v1).metadata;
            int v5 = v1_1.length - 2;
            if(v5 >= 0) {
                int v7;
                for(v7 = 0; true; ++v7) {
                    long v8 = v1_1[v7];
                    if((~v8 << 7 & v8 & -9187201950435737472L) != -9187201950435737472L) {
                        int v11 = 8;
                        int v10 = 8 - (~(v7 - v5) >>> 0x1F);
                        int v12;
                        for(v12 = 0; v12 < v10; ++v12) {
                            if((0xFF & v8) < 0x80) {
                                StateRecord v13;
                                for(v13 = v4[(v7 << 3) + v12].getFirstStateRecord(); v13 != null; v13 = v13.getNext$runtime()) {
                                    if(v13.getSnapshotId$runtime() == v2 || (CollectionsKt.contains(v0.previousIds, Long.valueOf(v13.getSnapshotId$runtime())))) {
                                        v13.setSnapshotId$runtime(SnapshotKt.access$getINVALID_SNAPSHOT$p());
                                    }
                                }
                            }

                            v8 >>= v11;
                        }

                        if(v10 != v11) {
                            break;
                        }
                    }

                    if(v7 == v5) {
                        break;
                    }
                }
            }
        }

        v0.closeAndReleasePinning$runtime();
    }

    public final Object advance$runtime(Function0 arg10) {
        long v7;
        this.recordPrevious$runtime(this.getSnapshotId());
        Object v10 = arg10.invoke();
        if(!this.getApplied$runtime() && !this.getDisposed$runtime()) {
            long v0 = this.getSnapshotId();
            Object v2 = SnapshotKt.getLock();
            __monitor_enter(v2);
            try {
                long v3 = SnapshotKt.access$getNextSnapshotId$p();
                v7 = 1;
                SnapshotKt.access$setNextSnapshotId$p(SnapshotKt.access$getNextSnapshotId$p() + v7);
                this.setSnapshotId$runtime(v3);
                SnapshotKt.access$setOpenSnapshots$p(SnapshotKt.access$getOpenSnapshots$p().set(this.getSnapshotId()));
            }
            catch(Throwable v9) {
                __monitor_exit(v2);
                throw v9;
            }

            __monitor_exit(v2);
            this.setInvalid$runtime(SnapshotKt.addRange(this.getInvalid$runtime(), v0 + v7, this.getSnapshotId()));
            return v10;
        }

        return v10;
    }

    public final void advance$runtime() {
        long v7;
        this.recordPrevious$runtime(this.getSnapshotId());
        if(!this.getApplied$runtime() && !this.getDisposed$runtime()) {
            long v0 = this.getSnapshotId();
            Object v2 = SnapshotKt.getLock();
            __monitor_enter(v2);
            try {
                long v3 = SnapshotKt.access$getNextSnapshotId$p();
                v7 = 1;
                SnapshotKt.access$setNextSnapshotId$p(SnapshotKt.access$getNextSnapshotId$p() + v7);
                this.setSnapshotId$runtime(v3);
                SnapshotKt.access$setOpenSnapshots$p(SnapshotKt.access$getOpenSnapshots$p().set(this.getSnapshotId()));
            }
            catch(Throwable v9) {
                __monitor_exit(v2);
                throw v9;
            }

            __monitor_exit(v2);
            this.setInvalid$runtime(SnapshotKt.addRange(this.getInvalid$runtime(), v0 + v7, this.getSnapshotId()));
            return;
        }
    }

    public SnapshotApplyResult apply() {
        long v18;
        long v16;
        int v4_2;
        int v7_2;
        int v8_1;
        String v7_1;
        Set v5;
        List v2;
        MutableScatterSet v1_3;
        SnapshotApplyResult v1_2;
        GlobalSnapshot v8;
        Map v4;
        MutableSnapshot v0 = this;
        MutableScatterSet v3 = v0.getModified$runtime();
        MutableScatterSet v6 = null;
        if(v3 != null) {
            GlobalSnapshot v1 = SnapshotKt.access$getGlobalSnapshot$p();
            v4 = SnapshotKt.access$optimisticMerges(v1.getSnapshotId(), v0, SnapshotKt.access$getOpenSnapshots$p().clear(v1.getSnapshotId()));
        }
        else {
            v4 = ((Map)v6);
        }

        List v1_1 = CollectionsKt.emptyList();
        Object v7 = SnapshotKt.getLock();
        __monitor_enter(v7);
        try {
            SnapshotKt.access$validateOpen(v0);
            if(v3 == null) {
                goto label_41;
            }
            else if(v3.getSize() == 0) {
                goto label_41;
            }
            else {
                v8 = SnapshotKt.access$getGlobalSnapshot$p();
                v1_2 = v0.innerApplyLocked$runtime(SnapshotKt.access$getNextSnapshotId$p(), v3, v4, SnapshotKt.access$getOpenSnapshots$p().clear(v8.getSnapshotId()));
                if(!Intrinsics.areEqual(v1_2, Success.INSTANCE)) {
                    goto label_31;
                }
                else {
                    goto label_33;
                }
            }

            goto label_55;
        }
        catch(Throwable v0_1) {
            goto label_225;
        }

    label_31:
        __monitor_exit(v7);
        return v1_2;
        try {
        label_33:
            v0.closeLocked$runtime();
            v1_3 = v8.getModified$runtime();
            SnapshotKt.access$resetGlobalSnapshotLocked(v8, SnapshotKt.access$getEmptyLambda$p());
            v0.setModified$runtime(v6);
            v8.setModified$runtime(v6);
            v2 = SnapshotKt.access$getApplyObservers$p();
            goto label_55;
        label_41:
            v0.closeLocked$runtime();
            GlobalSnapshot v2_1 = SnapshotKt.access$getGlobalSnapshot$p();
            MutableScatterSet v4_1 = v2_1.getModified$runtime();
            SnapshotKt.access$resetGlobalSnapshotLocked(v2_1, SnapshotKt.access$getEmptyLambda$p());
            if(v4_1 != null && (v4_1.isNotEmpty())) {
                v2 = SnapshotKt.access$getApplyObservers$p();
                v1_3 = v4_1;
            }
            else {
                v2 = v1_1;
                v1_3 = v6;
            }

        label_55:
        }
        catch(Throwable v0_1) {
        label_225:
            __monitor_exit(v7);
            throw v0_1;
        }

        __monitor_exit(v7);
        v0.applied = true;
        if(v1_3 != null) {
            v5 = ScatterSetWrapperKt.wrapIntoSet(v1_3);
            if(!v5.isEmpty()) {
                v7_1 = "Compose:applyObservers";
                if(ComposeToolingFlags.isVerboseTracingEnabled) {
                    v7 = Trace.INSTANCE.beginSection(v7_1);
                    try {
                        v8_1 = v2.size();
                        int v9;
                        for(v9 = 0; v9 < v8_1; ++v9) {
                            v2.get(v9).invoke(v5, v0);
                        }
                    }
                    catch(Throwable v0_1) {
                        goto label_84;
                    }

                    Trace.INSTANCE.endSection(v7);
                    goto label_94;
                label_84:
                    Trace.INSTANCE.endSection(v7);
                    throw v0_1;
                }
                else {
                    v7_2 = v2.size();
                    for(v8_1 = 0; v8_1 < v7_2; ++v8_1) {
                        v2.get(v8_1).invoke(v5, v0);
                    }
                }
            }
        }

    label_94:
        if(v3 != null && (v3.isNotEmpty())) {
            v5 = ScatterSetWrapperKt.wrapIntoSet(v3);
            v7_1 = "Compose:applyObservers";
            if(ComposeToolingFlags.isVerboseTracingEnabled) {
                v7 = Trace.INSTANCE.beginSection(v7_1);
                try {
                    v8_1 = v2.size();
                    for(v9 = 0; v9 < v8_1; ++v9) {
                        v2.get(v9).invoke(v5, v0);
                    }
                }
                catch(Throwable v0_1) {
                    goto label_118;
                }

                Trace.INSTANCE.endSection(v7);
                goto label_128;
            label_118:
                Trace.INSTANCE.endSection(v7);
                throw v0_1;
            }
            else {
                v7_2 = v2.size();
                for(v8_1 = 0; v8_1 < v7_2; ++v8_1) {
                    v2.get(v8_1).invoke(v5, v0);
                }
            }
        }

    label_128:
        SnapshotObserverKt.dispatchObserverOnApplied(v0, v3);
        Object v2_2 = SnapshotKt.getLock();
        __monitor_enter(v2_2);
        try {
            v0.releasePinnedSnapshotsForCloseLocked$runtime();
            SnapshotKt.access$checkAndOverwriteUnusedRecordsLocked();
            int v5_1 = 7;
            long v11 = -9187201950435737472L;
            int v13 = 8;
            if(v1_3 != null) {
                Object[] v14 = ((ScatterSet)v1_3).elements;
                long[] v1_4 = ((ScatterSet)v1_3).metadata;
                int v15 = v1_4.length - 2;
                if(v15 >= 0) {
                    v4_2 = 0;
                    v16 = 0x80;
                    while(true) {
                        long v7_3 = v1_4[v4_2];
                        v18 = 0xFF;
                        if((~v7_3 << v5_1 & v7_3 & v11) != v11) {
                            v9 = 8 - (~(v4_2 - v15) >>> 0x1F);
                            int v10;
                            for(v10 = 0; v10 < v9; ++v10) {
                                if((v7_3 & v18) < v16) {
                                    SnapshotKt.access$processForUnusedRecordsLocked(v14[(v4_2 << 3) + v10]);
                                }

                                v7_3 >>= v13;
                            }

                            if(v9 != v13) {
                                break;
                            }
                        }

                        if(v4_2 == v15) {
                            break;
                        }

                        ++v4_2;
                    }
                }
                else {
                    goto label_172;
                }
            }
            else {
            label_172:
                v16 = 0x80;
                v18 = 0xFF;
            }

            if(v3 != null) {
                Object[] v1_5 = ((ScatterSet)v3).elements;
                long[] v3_1 = ((ScatterSet)v3).metadata;
                v4_2 = v3_1.length - 2;
                if(v4_2 >= 0) {
                    for(v7_2 = 0; true; ++v7_2) {
                        long v8_2 = v3_1[v7_2];
                        if((~v8_2 << v5_1 & v8_2 & v11) != v11) {
                            v10 = 8 - (~(v7_2 - v4_2) >>> 0x1F);
                            int v14_1;
                            for(v14_1 = 0; v14_1 < v10; ++v14_1) {
                                if((v8_2 & v18) < v16) {
                                    SnapshotKt.access$processForUnusedRecordsLocked(v1_5[(v7_2 << 3) + v14_1]);
                                }

                                v8_2 >>= v13;
                            }

                            if(v10 != v13) {
                                break;
                            }
                        }

                        if(v7_2 == v4_2) {
                            break;
                        }
                    }
                }
            }

            v1_1 = v0.merged;
            if(v1_1 != null) {
                int v3_2 = v1_1.size();
                for(v4_2 = 0; v4_2 < v3_2; ++v4_2) {
                    SnapshotKt.access$processForUnusedRecordsLocked(v1_1.get(v4_2));
                }
            }

            v0.merged = ((List)v6);
        }
        catch(Throwable v0_1) {
            __monitor_exit(v2_2);
            throw v0_1;
        }

        __monitor_exit(v2_2);
        return Success.INSTANCE;
    }

    public void closeLocked$runtime() {
        SnapshotKt.access$setOpenSnapshots$p(SnapshotKt.access$getOpenSnapshots$p().clear(this.getSnapshotId()).andNot(this.previousIds));
    }

    public void dispose() {
        if(!this.getDisposed$runtime()) {
            super.dispose();
            this.nestedDeactivated$runtime(this);
            SnapshotObserverKt.dispatchObserverOnPreDispose(this);
        }
    }

    public final boolean getApplied$runtime() {
        return this.applied;
    }

    public final List getMerged$runtime() {
        return this.merged;
    }

    public MutableScatterSet getModified$runtime() {
        return this.modified;
    }

    public final SnapshotIdSet getPreviousIds$runtime() {
        return this.previousIds;
    }

    public final int[] getPreviousPinnedSnapshots$runtime() {
        return this.previousPinnedSnapshots;
    }

    public Function1 getReadObserver() {
        return this.getReadObserver$runtime();
    }

    public Function1 getReadObserver$runtime() {
        return this.readObserver;
    }

    public boolean getReadOnly() {
        return 0;
    }

    public Snapshot getRoot() {
        return this;
    }

    public int getWriteCount$runtime() {
        return this.writeCount;
    }

    public Function1 getWriteObserver$runtime() {
        return this.writeObserver;
    }

    public boolean hasPendingChanges() {
        MutableScatterSet v2 = this.getModified$runtime();
        if(v2 != null && (v2.isNotEmpty())) {
            return 1;
        }

        return 0;
    }

    public final SnapshotApplyResult innerApplyLocked$runtime(long arg29, MutableScatterSet arg31, Map arg32, SnapshotIdSet arg33) {
        List v5_3;
        Object v6_2;
        SnapshotIdSet v25;
        int v24;
        long v22;
        ArrayList v21;
        Object[] v20;
        long[] v18;
        int v19;
        int v10;
        MutableSnapshot v0 = this;
        long v1 = arg29;
        MutableScatterSet v3 = arg31;
        Map v4 = arg32;
        SnapshotIdSet v5 = v0.getInvalid$runtime().set(v0.getSnapshotId()).or(v0.previousIds);
        Object[] v7 = v3.elements;
        long[] v6 = v3.metadata;
        int v8 = v6.length - 2;
        ArrayList v9 = null;
        ArrayList v11 = v9;
        if(v8 >= 0) {
            int v12 = 0;
            while(true) {
                long v13 = v6[v12];
                ArrayList v16 = v11;
                if((~v13 << 7 & v13 & -9187201950435737472L) != -9187201950435737472L) {
                    int v11_1 = 8;
                    v10 = 8 - (~(v12 - v8) >>> 0x1F);
                    int v15 = 0;
                    while(v15 < v10) {
                        if((v13 & 0xFF) < 0x80) {
                            v19 = v11_1;
                            Object v11_2 = v7[(v12 << 3) + v15];
                            v18 = v6;
                            StateRecord v6_1 = ((StateObject)v11_2).getFirstStateRecord();
                            v20 = v7;
                            v21 = v9;
                            StateRecord v9_1 = SnapshotKt.access$readable(v6_1, v1, arg33);
                            if(v9_1 == null) {
                                v22 = v13;
                                goto label_61;
                            }
                            else {
                                v22 = v13;
                                StateRecord v13_1 = SnapshotKt.access$readable(v6_1, v0.getSnapshotId(), v5);
                                if(v13_1 == null || v13_1.getSnapshotId$runtime() == SnapshotId_jvmKt.toSnapshotId(1) || (Intrinsics.areEqual(v9_1, v13_1))) {
                                label_61:
                                    v25 = v5;
                                    v24 = v15;
                                }
                                else {
                                    v24 = v15;
                                    v25 = v5;
                                    StateRecord v5_1 = SnapshotKt.access$readable(v6_1, v0.getSnapshotId(), v0.getInvalid$runtime());
                                    if(v5_1 != null) {
                                        if(v4 != null) {
                                            v6_2 = v4.get(v9_1);
                                            if(v6_2 == null) {
                                                goto label_75;
                                            }
                                        }
                                        else {
                                        label_75:
                                            v6_1 = ((StateObject)v11_2).mergeRecords(v13_1, v9_1, v5_1);
                                        }

                                        if(v6_1 == null) {
                                            return new Failure(((Snapshot)v0));
                                        }

                                        if(Intrinsics.areEqual(v6_1, v5_1)) {
                                            goto label_122;
                                        }

                                        if(Intrinsics.areEqual(v6_1, v9_1)) {
                                            if(v21 == null) {
                                                ArrayList v5_2 = new ArrayList();
                                            }
                                            else {
                                                v5_3 = ((List)v21);
                                            }

                                            v5_3.add(TuplesKt.to(v11_2, v9_1.create(v0.getSnapshotId())));
                                            if(v16 == null) {
                                                v16 = new ArrayList();
                                            }

                                            v16.add(v11_2);
                                            v9 = ((ArrayList)v5_3);
                                            v16 = v16;
                                            goto label_132;
                                        }

                                        v9 = v21 == null ? new ArrayList() : v21;
                                        Pair v5_4 = !Intrinsics.areEqual(v6_1, v13_1) ? TuplesKt.to(v11_2, v6_1) : TuplesKt.to(v11_2, v13_1.create(v0.getSnapshotId()));
                                        ((List)v9).add(v5_4);
                                        goto label_132;
                                    }
                                    else {
                                        SnapshotKt.access$readError();
                                        throw new KotlinNothingValueException();
                                    }
                                }
                            }

                        label_122:
                            v9 = v21;
                        }
                        else {
                            v25 = v5;
                            v18 = v6;
                            v20 = v7;
                            v19 = v11_1;
                            v22 = v13;
                            v24 = v15;
                        }

                    label_132:
                        v13 = v22 >> v19;
                        v15 = v24 + 1;
                        v6 = v18;
                        v11_1 = v19;
                        v7 = v20;
                        v5 = v25;
                    }

                    v25 = v5;
                    v18 = v6;
                    v20 = v7;
                    v21 = v9;
                    if(v10 == v11_1) {
                        v9 = v21;
                        goto label_155;
                    }

                    v11 = v16;
                    v9 = v21;
                    break;
                }
                else {
                    v25 = v5;
                    v18 = v6;
                    v20 = v7;
                }

            label_155:
                v11 = v16;
                if(v12 == v8) {
                    break;
                }

                ++v12;
                v6 = v18;
                v7 = v20;
                v5 = v25;
            }
        }

        if(v9 != null) {
            v0.advance$runtime();
            int v4_1 = v9.size();
            int v5_5;
            for(v5_5 = 0; v5_5 < v4_1; ++v5_5) {
                v6_2 = ((List)v9).get(v5_5);
                Object v7_1 = ((Pair)v6_2).component1();
                v6_2 = ((Pair)v6_2).component2();
                ((StateRecord)v6_2).setSnapshotId$runtime(v1);
                Object v8_1 = SnapshotKt.getLock();
                __monitor_enter(v8_1);
                try {
                    ((StateRecord)v6_2).setNext$runtime(((StateObject)v7_1).getFirstStateRecord());
                    ((StateObject)v7_1).prependStateRecord(((StateRecord)v6_2));
                }
                catch(Throwable v0_1) {
                    __monitor_exit(v8_1);
                    throw v0_1;
                }

                __monitor_exit(v8_1);
            }
        }

        if(v11 != null) {
            int v1_1 = v11.size();
            for(v10 = 0; v10 < v1_1; ++v10) {
                v3.remove(((List)v11).get(v10));
            }

            List v1_2 = v0.merged;
            if(v1_2 == null) {
            }
            else {
                List v11_3 = CollectionsKt.plus(((Collection)v1_2), ((Iterable)v11));
            }

            v0.merged = ((List)v11);
        }

        return Success.INSTANCE;
    }

    public void nestedActivated$runtime(Snapshot arg1) {
        ++this.snapshots;
    }

    public void nestedDeactivated$runtime(Snapshot arg1) {
        int v1 = this.snapshots > 0 ? 1 : 0;
        if(v1 == 0) {
            PreconditionsKt.throwIllegalArgumentException("no pending nested snapshots");
        }

        v1 = this.snapshots - 1;
        this.snapshots = v1;
        if(v1 == 0 && !this.applied) {
            this.abandon();
        }
    }

    public void notifyObjectsInitialized$runtime() {
        if(!this.applied) {
            if(this.getDisposed$runtime()) {
            }
            else {
                this.advance$runtime();
            }
        }
    }

    public void recordModified$runtime(StateObject arg2) {
        MutableScatterSet v0 = this.getModified$runtime();
        if(v0 == null) {
            v0 = ScatterSetKt.mutableScatterSetOf();
            this.setModified$runtime(v0);
        }

        v0.add(arg2);
    }

    public final void recordPrevious$runtime(long arg3) {
        Object v0 = SnapshotKt.getLock();
        __monitor_enter(v0);
        try {
            this.previousIds = this.previousIds.set(arg3);
        }
        catch(Throwable v2) {
            __monitor_exit(v0);
            throw v2;
        }

        __monitor_exit(v0);
    }

    public final void recordPreviousList$runtime(SnapshotIdSet arg3) {
        Object v0 = SnapshotKt.getLock();
        __monitor_enter(v0);
        try {
            this.previousIds = this.previousIds.or(arg3);
        }
        catch(Throwable v2) {
            __monitor_exit(v0);
            throw v2;
        }

        __monitor_exit(v0);
    }

    public final void recordPreviousPinnedSnapshot$runtime(int arg2) {
        if(arg2 >= 0) {
            this.previousPinnedSnapshots = ArraysKt.plus(this.previousPinnedSnapshots, arg2);
        }
    }

    public final void recordPreviousPinnedSnapshots$runtime(int[] arg3) {
        if(arg3.length == 0) {
            return;
        }

        int[] v0 = this.previousPinnedSnapshots;
        if(v0.length == 0) {
        }
        else {
            arg3 = ArraysKt.plus(v0, arg3);
        }

        this.previousPinnedSnapshots = arg3;
    }

    public void releasePinnedSnapshotsForCloseLocked$runtime() {
        this.releasePreviouslyPinnedSnapshotsLocked();
        super.releasePinnedSnapshotsForCloseLocked$runtime();
    }

    private final void releasePreviouslyPinnedSnapshotsLocked() {
        int v0 = this.previousPinnedSnapshots.length;
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            SnapshotKt.releasePinningLocked(this.previousPinnedSnapshots[v1]);
        }
    }

    public final void setApplied$runtime(boolean arg1) {
        this.applied = arg1;
    }

    public final void setMerged$runtime(List arg1) {
        this.merged = arg1;
    }

    public void setModified$runtime(MutableScatterSet arg1) {
        this.modified = arg1;
    }

    public final void setPreviousIds$runtime(SnapshotIdSet arg1) {
        this.previousIds = arg1;
    }

    public final void setPreviousPinnedSnapshots$runtime(int[] arg1) {
        this.previousPinnedSnapshots = arg1;
    }

    public void setWriteCount$runtime(int arg1) {
        this.writeCount = arg1;
    }

    public MutableSnapshot takeNestedMutableSnapshot(Function1 arg20, Function1 arg21) {
        NestedMutableSnapshot v0_1;
        long v20;
        long v4_1;
        Map v9_1;
        Object v3_1;
        MutableSnapshot v6 = this;
        v6.validateNotDisposed$runtime();
        v6.validateNotAppliedOrPinned();
        MutableSnapshot v7 = v6;
        PersistentList v8 = SnapshotObserverKt.access$getObservers$p();
        Object v1 = null;
        Function1 v2 = arg20;
        Function1 v3 = arg21;
        if(v8 != null) {
            Pair v2_1 = SnapshotObserverKt.mergeObservers(v8, ((Snapshot)v7), false, v2, v3);
            v3_1 = v2_1.getFirst();
            Function1 v4 = ((SnapshotInstanceObservers)v3_1).getReadObserver();
            v3 = ((SnapshotInstanceObservers)v3_1).getWriteObserver();
            Object v9 = v2_1.getSecond();
            v2 = v4;
        }
        else {
            v9_1 = ((Map)v1);
        }

        v6.recordPrevious$runtime(v6.getSnapshotId());
        Object v10 = SnapshotKt.getLock();
        __monitor_enter(v10);
        try {
            v4_1 = SnapshotKt.access$getNextSnapshotId$p();
            SnapshotKt.access$setNextSnapshotId$p(SnapshotKt.access$getNextSnapshotId$p() + 1);
            SnapshotKt.access$setOpenSnapshots$p(SnapshotKt.access$getOpenSnapshots$p().set(v4_1));
            SnapshotIdSet v11 = v6.getInvalid$runtime();
            v6.setInvalid$runtime(v11.set(v4_1));
            v20 = 1;
            v0_1 = new NestedMutableSnapshot(v4_1, SnapshotKt.addRange(v11, v6.getSnapshotId() + v20, v4_1), SnapshotKt.mergedReadObserver$default(v2, v6.getReadObserver$runtime(), false, 4, v1), SnapshotKt.mergedWriteObserver(v3, v6.getWriteObserver$runtime()), v6);
        }
        catch(Throwable v0) {
            __monitor_exit(v10);
            throw v0;
        }

        __monitor_exit(v10);
        if(!v6.getApplied$runtime() && !v6.getDisposed$runtime()) {
            long v1_1 = v6.getSnapshotId();
            v3_1 = SnapshotKt.getLock();
            __monitor_enter(v3_1);
            try {
                v4_1 = SnapshotKt.access$getNextSnapshotId$p();
                SnapshotKt.access$setNextSnapshotId$p(SnapshotKt.access$getNextSnapshotId$p() + v20);
                v6.setSnapshotId$runtime(v4_1);
                SnapshotKt.access$setOpenSnapshots$p(SnapshotKt.access$getOpenSnapshots$p().set(v6.getSnapshotId()));
            }
            catch(Throwable v0) {
                __monitor_exit(v3_1);
                throw v0;
            }

            __monitor_exit(v3_1);
            v6.setInvalid$runtime(SnapshotKt.addRange(v6.getInvalid$runtime(), v1_1 + v20, v6.getSnapshotId()));
        }

        NestedMutableSnapshot v12 = v0_1;
        if(v8 != null) {
            SnapshotObserverKt.dispatchCreatedObservers(v8, ((Snapshot)v7), ((Snapshot)v12), v9_1);
        }

        return ((MutableSnapshot)v12);
    }

    public static MutableSnapshot takeNestedMutableSnapshot$default(MutableSnapshot arg1, Function1 arg2, Function1 arg3, int arg4, Object arg5) {
        if(arg5 == null) {
            Function1 v0 = null;
            if((arg4 & 1) != 0) {
                arg2 = v0;
            }

            if((arg4 & 2) != 0) {
                arg3 = v0;
            }

            return arg1.takeNestedMutableSnapshot(arg2, arg3);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: takeNestedMutableSnapshot");
    }

    public Snapshot takeNestedSnapshot(Function1 arg18) {
        NestedReadonlySnapshot v9;
        long v15;
        Function1 v7_1;
        Object v6_1;
        MutableSnapshot v3_1;
        MutableSnapshot v0 = this;
        v0.validateNotDisposed$runtime();
        v0.validateNotAppliedOrPinned();
        long v1 = v0.getSnapshotId();
        Function1 v4 = null;
        if((v0 instanceof GlobalSnapshot)) {
            Snapshot v3 = ((Snapshot)v4);
        }
        else {
            v3_1 = v0;
        }

        PersistentList v5 = SnapshotObserverKt.access$getObservers$p();
        if(v5 != null) {
            Pair v6 = SnapshotObserverKt.mergeObservers(v5, ((Snapshot)v3_1), true, arg18, v4);
            Object v7 = v6.getFirst();
            Function1 v8 = ((SnapshotInstanceObservers)v7).getReadObserver();
            ((SnapshotInstanceObservers)v7).getWriteObserver();
            v6_1 = v6.getSecond();
            v7_1 = v8;
        }
        else {
            v7_1 = arg18;
            Map v6_2 = ((Map)v4);
        }

        v0.recordPrevious$runtime(v0.getSnapshotId());
        Object v8_1 = SnapshotKt.getLock();
        __monitor_enter(v8_1);
        try {
            long v10 = SnapshotKt.access$getNextSnapshotId$p();
            v15 = 1;
            SnapshotKt.access$setNextSnapshotId$p(SnapshotKt.access$getNextSnapshotId$p() + v15);
            SnapshotKt.access$setOpenSnapshots$p(SnapshotKt.access$getOpenSnapshots$p().set(v10));
            v9 = new NestedReadonlySnapshot(v10, SnapshotKt.addRange(v0.getInvalid$runtime(), v1 + v15, v10), SnapshotKt.mergedReadObserver$default(v7_1, v0.getReadObserver$runtime(), false, 4, v4), v0);
        }
        catch(Throwable v0_1) {
            __monitor_exit(v8_1);
            throw v0_1;
        }

        __monitor_exit(v8_1);
        if(!v0.getApplied$runtime() && !v0.getDisposed$runtime()) {
            v1 = v0.getSnapshotId();
            Object v4_1 = SnapshotKt.getLock();
            __monitor_enter(v4_1);
            try {
                long v7_2 = SnapshotKt.access$getNextSnapshotId$p();
                SnapshotKt.access$setNextSnapshotId$p(SnapshotKt.access$getNextSnapshotId$p() + v15);
                v0.setSnapshotId$runtime(v7_2);
                SnapshotKt.access$setOpenSnapshots$p(SnapshotKt.access$getOpenSnapshots$p().set(v0.getSnapshotId()));
            }
            catch(Throwable v0_1) {
                __monitor_exit(v4_1);
                throw v0_1;
            }

            __monitor_exit(v4_1);
            v0.setInvalid$runtime(SnapshotKt.addRange(v0.getInvalid$runtime(), v1 + v15, v0.getSnapshotId()));
        }

        if(v5 != null) {
            SnapshotObserverKt.dispatchCreatedObservers(v5, ((Snapshot)v3_1), ((Snapshot)v9), ((Map)v6_1));
        }

        return ((Snapshot)v9);
    }

    private final void validateNotApplied() {
        if(this.applied) {
            PreconditionsKt.throwIllegalStateException("Unsupported operation on a snapshot that has been applied");
        }
    }

    private final void validateNotAppliedOrPinned() {
        int v1 = !this.applied || ((Snapshot)this).pinningTrackingHandle >= 0 ? 1 : 0;
        if(v1 == 0) {
            PreconditionsKt.throwIllegalStateException("Unsupported operation on a disposed or applied snapshot");
        }
    }
}

