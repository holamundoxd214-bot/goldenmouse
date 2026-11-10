package androidx.compose.runtime.snapshots;

import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSet;
import androidx.compose.runtime.collection.ScatterSetWrapperKt;
import androidx.compose.runtime.internal.AtomicInt;
import androidx.compose.runtime.internal.SnapshotThreadLocal;
import androidx.compose.runtime.internal.Trace;
import androidx.compose.runtime.internal.WeakReference;
import androidx.compose.runtime.tooling.ComposeToolingFlags;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000°\u0001\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0001\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u001A!\u0010\u0000\u001A\u00020\u00012\n\u0010\u0002\u001A\u00060\u0003j\u0002`\u00042\u0006\u0010\u0005\u001A\u00020\u0006H\u0000¢\u0006\u0002\u0010\u0007\u001A\u0010\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u0001H\u0000\u001A\b\u0010\u000B\u001A\u00020\fH\u0000\u001A4\u0010\u0011\u001A\u00020\f2\b\u0010\u0012\u001A\u0004\u0018\u00010\f2\u0016\b\u0002\u0010\u0013\u001A\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\t\u0018\u00010\u000E2\b\b\u0002\u0010\u0015\u001A\u00020\u0016H\u0002\u001AL\u0010\u0017\u001A\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\t\u0018\u00010\u000E2\u0014\u0010\u0013\u001A\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\t\u0018\u00010\u000E2\u0014\u0010\u0018\u001A\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\t\u0018\u00010\u000E2\b\b\u0002\u0010\u0019\u001A\u00020\u0016H\u0000\u001AB\u0010\u001A\u001A\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\t\u0018\u00010\u000E2\u0014\u0010\u001B\u001A\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\t\u0018\u00010\u000E2\u0014\u0010\u0018\u001A\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\t\u0018\u00010\u000EH\u0000\u001A/\u0010\'\u001A\u0002H(\"\u0004\b\u0000\u0010(2\f\u0010)\u001A\b\u0012\u0004\u0012\u0002H(0*H\u0081\b\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010+\u001A>\u0010>\u001A\u0002H(\"\u0004\b\u0000\u0010(2\u0006\u00108\u001A\u0002092!\u0010)\u001A\u001D\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u000F\u0012\b\b\u0010\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u0002H(0\u000EH\u0002¢\u0006\u0002\u0010?\u001A6\u0010B\u001A\u0002H(\"\u0004\b\u0000\u0010(2!\u0010)\u001A\u001D\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u000F\u0012\b\b\u0010\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u0002H(0\u000EH\u0002¢\u0006\u0002\u0010C\u001A\b\u0010B\u001A\u00020\tH\u0002\u001A:\u0010D\u001A\u0002H(\"\b\b\u0000\u0010(*\u00020\f2!\u0010)\u001A\u001D\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u000F\u0012\b\b\u0010\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u0002H(0\u000EH\u0002¢\u0006\u0002\u0010E\u001A\u0010\u0010F\u001A\u00020\t2\u0006\u0010G\u001A\u00020\fH\u0002\u001A-\u0010H\u001A\u00020\u00162\n\u0010\u000B\u001A\u00060\u0003j\u0002`\u00042\n\u0010I\u001A\u00060\u0003j\u0002`\u00042\u0006\u0010\u0005\u001A\u00020\u0006H\u0002¢\u0006\u0002\u0010J\u001A)\u0010H\u001A\u00020\u00162\u0006\u0010K\u001A\u00020L2\n\u0010G\u001A\u00060\u0003j\u0002`\u00042\u0006\u0010\u0005\u001A\u00020\u0006H\u0002¢\u0006\u0002\u0010M\u001A5\u0010N\u001A\u0004\u0018\u0001H(\"\b\b\u0000\u0010(*\u00020L2\u0006\u0010O\u001A\u0002H(2\n\u0010P\u001A\u00060\u0003j\u0002`\u00042\u0006\u0010\u0005\u001A\u00020\u0006H\u0002¢\u0006\u0002\u0010Q\u001A!\u0010N\u001A\u0002H(\"\b\b\u0000\u0010(*\u00020L*\u0002H(2\u0006\u0010R\u001A\u000202¢\u0006\u0002\u0010S\u001A)\u0010N\u001A\u0002H(\"\b\b\u0000\u0010(*\u00020L*\u0002H(2\u0006\u0010R\u001A\u0002022\u0006\u0010G\u001A\u00020\f¢\u0006\u0002\u0010T\u001A\b\u0010U\u001A\u00020VH\u0002\u001A\u0012\u0010W\u001A\u0004\u0018\u00010L2\u0006\u0010R\u001A\u000202H\u0002\u001A\u0010\u0010X\u001A\u00020\u00162\u0006\u0010R\u001A\u000202H\u0002\u001A!\u0010Y\u001A\u00020L*\u00020L2\u0012\u0010Z\u001A\u000E\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020\u00160\u000EH\u0082\b\u001A\b\u0010[\u001A\u00020\tH\u0002\u001A\u0010\u0010\\\u001A\u00020\t2\u0006\u0010R\u001A\u000202H\u0002\u001A+\u0010]\u001A\u0002H(\"\b\b\u0000\u0010(*\u00020L*\u0002H(2\u0006\u0010R\u001A\u0002022\u0006\u0010G\u001A\u00020\fH\u0001¢\u0006\u0002\u0010T\u001A3\u0010^\u001A\u0002H(\"\b\b\u0000\u0010(*\u00020L*\u0002H(2\u0006\u0010R\u001A\u0002022\u0006\u0010G\u001A\u00020\f2\u0006\u0010_\u001A\u0002H(H\u0000¢\u0006\u0002\u0010`\u001A+\u0010a\u001A\u0002H(\"\b\b\u0000\u0010(*\u00020L*\u0002H(2\u0006\u0010R\u001A\u0002022\u0006\u0010G\u001A\u00020\fH\u0000¢\u0006\u0002\u0010T\u001A+\u0010b\u001A\u0002H(\"\b\b\u0000\u0010(*\u00020L*\u0002H(2\u0006\u0010R\u001A\u0002022\u0006\u0010G\u001A\u00020\fH\u0002¢\u0006\u0002\u0010T\u001A#\u0010c\u001A\u0002H(\"\b\b\u0000\u0010(*\u00020L*\u0002H(2\u0006\u0010R\u001A\u000202H\u0000¢\u0006\u0002\u0010S\u001A\u0018\u0010d\u001A\u00020\t2\u0006\u0010G\u001A\u00020\f2\u0006\u0010R\u001A\u000202H\u0001\u001AK\u0010e\u001A\u0002Hf\"\b\b\u0000\u0010(*\u00020L\"\u0004\b\u0001\u0010f*\u0002H(2\u0006\u0010R\u001A\u0002022\u0006\u0010G\u001A\u00020\f2\u0017\u0010)\u001A\u0013\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u0002Hf0\u000E¢\u0006\u0002\bgH\u0086\b¢\u0006\u0002\u0010h\u001AC\u0010e\u001A\u0002Hf\"\b\b\u0000\u0010(*\u00020L\"\u0004\b\u0001\u0010f*\u0002H(2\u0006\u0010R\u001A\u0002022\u0017\u0010)\u001A\u0013\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u0002Hf0\u000E¢\u0006\u0002\bgH\u0086\b¢\u0006\u0002\u0010i\u001AK\u0010j\u001A\u0002Hf\"\b\b\u0000\u0010(*\u00020L\"\u0004\b\u0001\u0010f*\u0002H(2\u0006\u0010R\u001A\u0002022\u0006\u0010_\u001A\u0002H(2\u0017\u0010)\u001A\u0013\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u0002Hf0\u000E¢\u0006\u0002\bgH\u0080\b¢\u0006\u0002\u0010k\u001A7\u0010l\u001A\u0010\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020L\u0018\u00010m2\n\u0010n\u001A\u00060\u0003j\u0002`\u00042\u0006\u0010o\u001A\u00020p2\u0006\u0010q\u001A\u00020\u0006H\u0002¢\u0006\u0002\u0010r\u001A\b\u0010s\u001A\u00020VH\u0002\u001A\'\u0010t\u001A\u0002H(\"\b\b\u0000\u0010(*\u00020L2\u0006\u0010O\u001A\u0002H(2\u0006\u0010G\u001A\u00020\fH\u0001¢\u0006\u0002\u0010u\u001A\u001F\u0010t\u001A\u0002H(\"\b\b\u0000\u0010(*\u00020L2\u0006\u0010O\u001A\u0002H(H\u0001¢\u0006\u0002\u0010v\u001AE\u0010w\u001A\u0002Hf\"\b\b\u0000\u0010(*\u00020L\"\u0004\b\u0001\u0010f*\u0002H(2!\u0010)\u001A\u001D\u0012\u0013\u0012\u0011H(¢\u0006\f\b\u000F\u0012\b\b\u0010\u0012\u0004\b\b(O\u0012\u0004\u0012\u0002Hf0\u000EH\u0086\b¢\u0006\u0002\u0010x\u001A)\u0010y\u001A\u00020\u0006*\u00020\u00062\n\u0010z\u001A\u00060\u0003j\u0002`\u00042\n\u0010{\u001A\u00060\u0003j\u0002`\u0004H\u0000¢\u0006\u0002\u0010|\")\u0010\r\u001A\u001D\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u000F\u0012\b\b\u0010\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\t0\u000EX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u001C\u001A\u00060\u0003j\u0002`\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001D\"\u0014\u0010\u001E\u001A\b\u0012\u0004\u0012\u00020\f0\u001FX\u0082\u0004¢\u0006\u0002\n\u0000\"\"\u0010 \u001A\u00060\u0014j\u0002`!8\u0000X\u0081\u0004¢\u0006\u0010\n\u0002\u0010&\u0012\u0004\b\"\u0010#\u001A\u0004\b$\u0010%\"\u000E\u0010,\u001A\u00020\u0006X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0014\u0010-\u001A\u00060\u0003j\u0002`\u0004X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u001D\"\u000E\u0010.\u001A\u00020/X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u00100\u001A\b\u0012\u0004\u0012\u00020201X\u0082\u0004¢\u0006\u0002\n\u0000\",\u00103\u001A \u0012\u001C\u0012\u001A\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001406\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0504X\u0082\u000E¢\u0006\u0002\n\u0000\" \u00107\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\t0\u000E04X\u0082\u000E¢\u0006\u0002\n\u0000\"\u000E\u00108\u001A\u000209X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001C\u0010:\u001A\u00020\f8\u0000X\u0081\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b;\u0010#\u001A\u0004\b<\u0010=\"\u000E\u0010@\u001A\u00020AX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006}"}, d2={"trackPinning", "", "snapshotId", "", "Landroidx/compose/runtime/snapshots/SnapshotId;", "invalid", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "(JLandroidx/compose/runtime/snapshots/SnapshotIdSet;)I", "releasePinningLocked", "", "handle", "currentSnapshot", "Landroidx/compose/runtime/snapshots/Snapshot;", "emptyLambda", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "createTransparentSnapshotWithNoParentReadObserver", "previousSnapshot", "readObserver", "", "ownsPreviousSnapshot", "", "mergedReadObserver", "parentObserver", "mergeReadObserver", "mergedWriteObserver", "writeObserver", "INVALID_SNAPSHOT", "J", "threadSnapshot", "Landroidx/compose/runtime/internal/SnapshotThreadLocal;", "lock", "Landroidx/compose/runtime/platform/SynchronizedObject;", "getLock$annotations", "()V", "getLock", "()Ljava/lang/Object;", "Ljava/lang/Object;", "sync", "T", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "openSnapshots", "nextSnapshotId", "pinningTable", "Landroidx/compose/runtime/snapshots/SnapshotDoubleIndexHeap;", "extraStateObjects", "Landroidx/compose/runtime/snapshots/SnapshotWeakSet;", "Landroidx/compose/runtime/snapshots/StateObject;", "applyObservers", "", "Lkotlin/Function2;", "", "globalWriteObservers", "globalSnapshot", "Landroidx/compose/runtime/snapshots/GlobalSnapshot;", "snapshotInitializer", "getSnapshotInitializer$annotations", "getSnapshotInitializer", "()Landroidx/compose/runtime/snapshots/Snapshot;", "resetGlobalSnapshotLocked", "(Landroidx/compose/runtime/snapshots/GlobalSnapshot;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "pendingApplyObserverCount", "Landroidx/compose/runtime/internal/AtomicInt;", "advanceGlobalSnapshot", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "takeNewSnapshot", "(Lkotlin/jvm/functions/Function1;)Landroidx/compose/runtime/snapshots/Snapshot;", "validateOpen", "snapshot", "valid", "candidateSnapshot", "(JJLandroidx/compose/runtime/snapshots/SnapshotIdSet;)Z", "data", "Landroidx/compose/runtime/snapshots/StateRecord;", "(Landroidx/compose/runtime/snapshots/StateRecord;JLandroidx/compose/runtime/snapshots/SnapshotIdSet;)Z", "readable", "r", "id", "(Landroidx/compose/runtime/snapshots/StateRecord;JLandroidx/compose/runtime/snapshots/SnapshotIdSet;)Landroidx/compose/runtime/snapshots/StateRecord;", "state", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;)Landroidx/compose/runtime/snapshots/StateRecord;", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;Landroidx/compose/runtime/snapshots/Snapshot;)Landroidx/compose/runtime/snapshots/StateRecord;", "readError", "", "usedLocked", "overwriteUnusedRecordsLocked", "findYoungestOr", "predicate", "checkAndOverwriteUnusedRecordsLocked", "processForUnusedRecordsLocked", "writableRecord", "overwritableRecord", "candidate", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;Landroidx/compose/runtime/snapshots/Snapshot;Landroidx/compose/runtime/snapshots/StateRecord;)Landroidx/compose/runtime/snapshots/StateRecord;", "newWritableRecord", "newWritableRecordLocked", "newOverwritableRecordLocked", "notifyWrite", "writable", "R", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;Landroidx/compose/runtime/snapshots/Snapshot;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "overwritable", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;Landroidx/compose/runtime/snapshots/StateRecord;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "optimisticMerges", "", "currentSnapshotId", "applyingSnapshot", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "invalidSnapshots", "(JLandroidx/compose/runtime/snapshots/MutableSnapshot;Landroidx/compose/runtime/snapshots/SnapshotIdSet;)Ljava/util/Map;", "reportReadonlySnapshotWrite", "current", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/Snapshot;)Landroidx/compose/runtime/snapshots/StateRecord;", "(Landroidx/compose/runtime/snapshots/StateRecord;)Landroidx/compose/runtime/snapshots/StateRecord;", "withCurrent", "(Landroidx/compose/runtime/snapshots/StateRecord;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "addRange", "from", "until", "(Landroidx/compose/runtime/snapshots/SnapshotIdSet;JJ)Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "runtime"}, k=2, mv={2, 1, 0}, xi=0x30) public final class SnapshotKt {
    private static final long INVALID_SNAPSHOT;
    private static List applyObservers;
    private static final Function1 emptyLambda;
    private static final SnapshotWeakSet extraStateObjects;
    private static final GlobalSnapshot globalSnapshot;
    private static List globalWriteObservers;
    private static final Object lock;
    private static long nextSnapshotId;
    private static SnapshotIdSet openSnapshots;
    private static AtomicInt pendingApplyObserverCount;
    private static final SnapshotDoubleIndexHeap pinningTable;
    private static final Snapshot snapshotInitializer;
    private static final SnapshotThreadLocal threadSnapshot;

    static {
        SnapshotKt.emptyLambda = new SnapshotKt$$ExternalSyntheticLambda1();
        SnapshotKt.threadSnapshot = new SnapshotThreadLocal();
        SnapshotKt.lock = new Object();
        SnapshotKt.openSnapshots = SnapshotIdSet.Companion.getEMPTY();
        SnapshotKt.nextSnapshotId = SnapshotId_jvmKt.toSnapshotId(1) + 1;
        SnapshotKt.pinningTable = new SnapshotDoubleIndexHeap();
        SnapshotKt.extraStateObjects = new SnapshotWeakSet();
        SnapshotKt.applyObservers = CollectionsKt.emptyList();
        SnapshotKt.globalWriteObservers = CollectionsKt.emptyList();
        long v0 = SnapshotKt.nextSnapshotId;
        SnapshotKt.nextSnapshotId = 1 + v0;
        GlobalSnapshot v3 = new GlobalSnapshot(v0, SnapshotIdSet.Companion.getEMPTY());
        SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(v3.getSnapshotId());
        SnapshotKt.globalSnapshot = v3;
        SnapshotKt.snapshotInitializer = ((Snapshot)v3);
        SnapshotKt.pendingApplyObserverCount = new AtomicInt(0);
    }

    public static final void access$advanceGlobalSnapshot() {
        SnapshotKt.advanceGlobalSnapshot();
    }

    public static final Object access$advanceGlobalSnapshot(Function1 arg0) {
        return SnapshotKt.advanceGlobalSnapshot(arg0);
    }

    public static final void access$checkAndOverwriteUnusedRecordsLocked() {
        SnapshotKt.checkAndOverwriteUnusedRecordsLocked();
    }

    public static final Snapshot access$createTransparentSnapshotWithNoParentReadObserver(Snapshot arg0, Function1 arg1, boolean arg2) {
        return SnapshotKt.createTransparentSnapshotWithNoParentReadObserver(arg0, arg1, arg2);
    }

    public static final List access$getApplyObservers$p() {
        return SnapshotKt.applyObservers;
    }

    public static final Function1 access$getEmptyLambda$p() {
        return SnapshotKt.emptyLambda;
    }

    public static final GlobalSnapshot access$getGlobalSnapshot$p() {
        return SnapshotKt.globalSnapshot;
    }

    public static final List access$getGlobalWriteObservers$p() {
        return SnapshotKt.globalWriteObservers;
    }

    public static final long access$getINVALID_SNAPSHOT$p() {
        return SnapshotKt.INVALID_SNAPSHOT;
    }

    public static final long access$getNextSnapshotId$p() {
        return SnapshotKt.nextSnapshotId;
    }

    public static final SnapshotIdSet access$getOpenSnapshots$p() {
        return SnapshotKt.openSnapshots;
    }

    public static final AtomicInt access$getPendingApplyObserverCount$p() {
        return SnapshotKt.pendingApplyObserverCount;
    }

    public static final SnapshotThreadLocal access$getThreadSnapshot$p() {
        return SnapshotKt.threadSnapshot;
    }

    public static final Map access$optimisticMerges(long arg0, MutableSnapshot arg2, SnapshotIdSet arg3) {
        return SnapshotKt.optimisticMerges(arg0, arg2, arg3);
    }

    public static final void access$processForUnusedRecordsLocked(StateObject arg0) {
        SnapshotKt.processForUnusedRecordsLocked(arg0);
    }

    public static final Void access$readError() {
        return SnapshotKt.readError();
    }

    public static final StateRecord access$readable(StateRecord arg0, long arg1, SnapshotIdSet arg3) {
        return SnapshotKt.readable(arg0, arg1, arg3);
    }

    public static final Void access$reportReadonlySnapshotWrite() {
        return SnapshotKt.reportReadonlySnapshotWrite();
    }

    public static final Object access$resetGlobalSnapshotLocked(GlobalSnapshot arg0, Function1 arg1) {
        return SnapshotKt.resetGlobalSnapshotLocked(arg0, arg1);
    }

    public static final void access$setApplyObservers$p(List arg0) {
        SnapshotKt.applyObservers = arg0;
    }

    public static final void access$setGlobalWriteObservers$p(List arg0) {
        SnapshotKt.globalWriteObservers = arg0;
    }

    public static final void access$setNextSnapshotId$p(long arg0) {
        SnapshotKt.nextSnapshotId = arg0;
    }

    public static final void access$setOpenSnapshots$p(SnapshotIdSet arg0) {
        SnapshotKt.openSnapshots = arg0;
    }

    public static final Snapshot access$takeNewSnapshot(Function1 arg0) {
        return SnapshotKt.takeNewSnapshot(arg0);
    }

    public static final void access$validateOpen(Snapshot arg0) {
        SnapshotKt.validateOpen(arg0);
    }

    public static final SnapshotIdSet addRange(SnapshotIdSet arg2, long arg3, long arg5) {
        while(Intrinsics.compare(arg3, arg5) < 0) {
            arg2 = arg2.set(arg3);
            ++arg3;
        }

        return arg2;
    }

    private static final Object advanceGlobalSnapshot(Function1 arg15) {
        int v7;
        Object v6_1;
        Set v5;
        List v4;
        Object v15_1;
        MutableScatterSet v2;
        GlobalSnapshot v0 = SnapshotKt.globalSnapshot;
        Object v1 = SnapshotKt.getLock();
        __monitor_enter(v1);
        try {
            v2 = v0.getModified$runtime();
            if(v2 != null) {
                SnapshotKt.pendingApplyObserverCount.add(1);
            }

            v15_1 = SnapshotKt.resetGlobalSnapshotLocked(v0, arg15);
        }
        catch(Throwable v15) {
            __monitor_exit(v1);
            throw v15;
        }

        __monitor_exit(v1);
        if(v2 != null) {
            int v3 = -1;
            try {
                v4 = SnapshotKt.applyObservers;
                v5 = ScatterSetWrapperKt.wrapIntoSet(v2);
                String v6 = "Compose:applyObservers";
                if(ComposeToolingFlags.isVerboseTracingEnabled) {
                    v6_1 = Trace.INSTANCE.beginSection(v6);
                }
                else {
                    goto label_37;
                }
            }
            catch(Throwable v15) {
                goto label_50;
            }

            try {
                v7 = v4.size();
                int v8;
                for(v8 = 0; v8 < v7; ++v8) {
                    v4.get(v8).invoke(v5, v0);
                }
            }
            catch(Throwable v15) {
                goto label_35;
            }

            try {
                Trace.INSTANCE.endSection(v6_1);
                goto label_45;
            label_35:
                Trace.INSTANCE.endSection(v6_1);
                throw v15;
            label_37:
                int v6_2 = v4.size();
                for(v7 = 0; v7 < v6_2; ++v7) {
                    v4.get(v7).invoke(v5, v0);
                }
            }
            catch(Throwable v15) {
            label_50:
                SnapshotKt.pendingApplyObserverCount.add(v3);
                throw v15;
            }

        label_45:
            SnapshotKt.pendingApplyObserverCount.add(v3);
        }

        Object v0_1 = SnapshotKt.getLock();
        __monitor_enter(v0_1);
        try {
            SnapshotKt.checkAndOverwriteUnusedRecordsLocked();
            if(v2 != null) {
                Object[] v3_1 = ((ScatterSet)v2).elements;
                long[] v2_1 = ((ScatterSet)v2).metadata;
                int v4_1 = v2_1.length - 2;
                if(v4_1 >= 0) {
                    int v5_1;
                    for(v5_1 = 0; true; ++v5_1) {
                        long v6_3 = v2_1[v5_1];
                        if((~v6_3 << 7 & v6_3 & -9187201950435737472L) != -9187201950435737472L) {
                            int v9 = 8;
                            v8 = 8 - (~(v5_1 - v4_1) >>> 0x1F);
                            int v10;
                            for(v10 = 0; v10 < v8; ++v10) {
                                if((0xFF & v6_3) < 0x80) {
                                    SnapshotKt.processForUnusedRecordsLocked(v3_1[(v5_1 << 3) + v10]);
                                }

                                v6_3 >>= v9;
                            }

                            if(v8 != v9) {
                                break;
                            }
                        }

                        if(v5_1 == v4_1) {
                            break;
                        }
                    }
                }
            }
        }
        catch(Throwable v15) {
            __monitor_exit(v0_1);
            throw v15;
        }

        __monitor_exit(v0_1);
        return v15_1;
    }

    private static final void advanceGlobalSnapshot() {
        SnapshotKt.advanceGlobalSnapshot(SnapshotKt.emptyLambda);
    }

    private static final void checkAndOverwriteUnusedRecordsLocked() {
        Object v5;
        SnapshotWeakSet v0 = SnapshotKt.extraStateObjects;
        int v1 = v0.getSize$runtime();
        int v3 = 0;
        int v4 = 0;
        while(true) {
            v5 = null;
            if(v3 >= v1) {
                break;
            }

            WeakReference v6 = v0.getValues$runtime()[v3];
            if(v6 != null) {
                v5 = v6.get();
            }

            if(v5 != null && (SnapshotKt.overwriteUnusedRecordsLocked(((StateObject)v5)))) {
                if(v4 != v3) {
                    v0.getValues$runtime()[v4] = v6;
                    v0.getHashes$runtime()[v4] = v0.getHashes$runtime()[v3];
                }

                ++v4;
            }

            ++v3;
        }

        for(v3 = v4; v3 < v1; ++v3) {
            v0.getValues$runtime()[v3] = ((WeakReference)v5);
            v0.getHashes$runtime()[v3] = 0;
        }

        if(v4 != v1) {
            v0.setSize$runtime(v4);
        }
    }

    private static final Snapshot createTransparentSnapshotWithNoParentReadObserver(Snapshot arg7, Function1 arg8, boolean arg9) {
        boolean v0 = arg7 instanceof MutableSnapshot;
        if(!v0) {
            if(arg7 == null) {
            }
            else {
                return new TransparentObserverSnapshot(arg7, arg8, false, arg9);
            }
        }

        if(v0) {
        }
        else {
            arg7 = null;
        }

        return new TransparentObserverMutableSnapshot(arg7, arg8, null, false, arg9);
    }

    static Snapshot createTransparentSnapshotWithNoParentReadObserver$default(Snapshot arg0, Function1 arg1, boolean arg2, int arg3, Object arg4) {
        if((arg3 & 2) != 0) {
            arg1 = null;
        }

        return SnapshotKt.createTransparentSnapshotWithNoParentReadObserver(arg0, arg1, false);
    }

    public static final StateRecord current(StateRecord arg4) {
        Snapshot v0 = Snapshot.Companion.getCurrent();
        StateRecord v0_1 = SnapshotKt.readable(arg4, v0.getSnapshotId(), v0.getInvalid$runtime());
        if(v0_1 == null) {
            Object v0_2 = SnapshotKt.getLock();
            __monitor_enter(v0_2);
            try {
                Snapshot v1 = Snapshot.Companion.getCurrent();
                arg4 = SnapshotKt.readable(arg4, v1.getSnapshotId(), v1.getInvalid$runtime());
            }
            catch(Throwable v4) {
                __monitor_exit(v0_2);
                throw v4;
            }

            __monitor_exit(v0_2);
            if(arg4 != null) {
                return arg4;
            }

            SnapshotKt.readError();
            throw new KotlinNothingValueException();
        }

        return v0_1;
    }

    public static final StateRecord current(StateRecord arg3, Snapshot arg4) {
        StateRecord v0 = SnapshotKt.readable(arg3, arg4.getSnapshotId(), arg4.getInvalid$runtime());
        if(v0 == null) {
            Object v0_1 = SnapshotKt.getLock();
            __monitor_enter(v0_1);
            try {
                arg3 = SnapshotKt.readable(arg3, arg4.getSnapshotId(), arg4.getInvalid$runtime());
            }
            catch(Throwable v3) {
                __monitor_exit(v0_1);
                throw v3;
            }

            __monitor_exit(v0_1);
            if(arg3 != null) {
                return arg3;
            }

            SnapshotKt.readError();
            throw new KotlinNothingValueException();
        }

        return v0;
    }

    public static final Snapshot currentSnapshot() {
        Object v0 = SnapshotKt.threadSnapshot.get();
        if(v0 == null) {
            GlobalSnapshot v0_1 = SnapshotKt.globalSnapshot;
        }

        return ((Snapshot)v0);
    }

    static final Unit emptyLambda$lambda$0(SnapshotIdSet arg0) {
        return Unit.INSTANCE;
    }

    private static final StateRecord findYoungestOr(StateRecord arg5, Function1 arg6) {
        StateRecord v0 = arg5;
        while(arg5 != null) {
            if(arg6.invoke(arg5).booleanValue()) {
                return arg5;
            }

            if(Intrinsics.compare(v0.getSnapshotId$runtime(), arg5.getSnapshotId$runtime()) < 0) {
                v0 = arg5;
            }

            arg5 = arg5.getNext$runtime();
        }

        return v0;
    }

    public static final Object getLock() {
        return SnapshotKt.lock;
    }

    public static void getLock$annotations() {
    }

    public static final Snapshot getSnapshotInitializer() {
        return SnapshotKt.snapshotInitializer;
    }

    public static void getSnapshotInitializer$annotations() {
    }

    public static final Function1 mergedReadObserver(Function1 arg0, Function1 arg1, boolean arg2) {
        if(arg2) {
        }
        else {
            arg1 = null;
        }

        if(arg0 != null && 0 != 0 && arg0 != null) {
            return new SnapshotKt$$ExternalSyntheticLambda0(arg0, arg1);
        }

        if(arg0 == null) {
            return arg1;
        }

        return arg0;
    }

    public static Function1 mergedReadObserver$default(Function1 arg0, Function1 arg1, boolean arg2, int arg3, Object arg4) {
        return SnapshotKt.mergedReadObserver(arg0, arg1, true);
    }

    static final Unit mergedReadObserver$lambda$0(Function1 arg0, Function1 arg1, Object arg2) {
        arg0.invoke(arg2);
        arg1.invoke(arg2);
        return Unit.INSTANCE;
    }

    public static final Function1 mergedWriteObserver(Function1 arg1, Function1 arg2) {
        if(arg1 != null && arg2 != null && arg1 != arg2) {
            return new SnapshotKt$$ExternalSyntheticLambda2(arg1, arg2);
        }

        if(arg1 == null) {
            return arg2;
        }

        return arg1;
    }

    static final Unit mergedWriteObserver$lambda$0(Function1 arg0, Function1 arg1, Object arg2) {
        arg0.invoke(arg2);
        arg1.invoke(arg2);
        return Unit.INSTANCE;
    }

    public static final StateRecord newOverwritableRecordLocked(StateRecord arg3, StateObject arg4) {
        StateRecord v0 = SnapshotKt.usedLocked(arg4);
        long v1 = 0x7FFFFFFFFFFFFFFFL;
        if(v0 != null) {
            v0.setSnapshotId$runtime(v1);
            return v0;
        }

        arg3 = arg3.create(v1);
        arg3.setNext$runtime(arg4.getFirstStateRecord());
        Intrinsics.checkNotNull(arg3, "null cannot be cast to non-null type T of androidx.compose.runtime.snapshots.SnapshotKt.newOverwritableRecordLocked");
        arg4.prependStateRecord(arg3);
        Intrinsics.checkNotNull(arg3, "null cannot be cast to non-null type T of androidx.compose.runtime.snapshots.SnapshotKt.newOverwritableRecordLocked");
        return arg3;
    }

    public static final StateRecord newWritableRecord(StateRecord arg1, StateObject arg2, Snapshot arg3) {
        Object v0 = SnapshotKt.getLock();
        __monitor_enter(v0);
        try {
            arg1 = SnapshotKt.newWritableRecordLocked(arg1, arg2, arg3);
        }
        catch(Throwable v1) {
            __monitor_exit(v0);
            throw v1;
        }

        __monitor_exit(v0);
        return arg1;
    }

    private static final StateRecord newWritableRecordLocked(StateRecord arg2, StateObject arg3, Snapshot arg4) {
        StateRecord v3 = SnapshotKt.newOverwritableRecordLocked(arg2, arg3);
        v3.assign(arg2);
        v3.setSnapshotId$runtime(arg4.getSnapshotId());
        return v3;
    }

    public static final void notifyWrite(Snapshot arg1, StateObject arg2) {
        arg1.setWriteCount$runtime(arg1.getWriteCount$runtime() + 1);
        Function1 v1 = arg1.getWriteObserver$runtime();
        if(v1 != null) {
            v1.invoke(arg2);
        }
    }

    private static final Map optimisticMerges(long arg23, MutableSnapshot arg25, SnapshotIdSet arg26) {
        SnapshotIdSet v22;
        Object[] v21;
        int v19;
        int v18;
        long[] v20;
        Map v16;
        HashMap v9;
        MutableScatterSet v0 = arg25.getModified$runtime();
        Map v1 = null;
        if(v0 == null) {
            return v1;
        }

        long v2 = arg25.getSnapshotId();
        SnapshotIdSet v4 = arg25.getInvalid$runtime().set(v2).or(arg25.getPreviousIds$runtime());
        Object[] v5 = ((ScatterSet)v0).elements;
        long[] v0_1 = ((ScatterSet)v0).metadata;
        int v6 = v0_1.length - 2;
        if(v6 >= 0) {
            v9 = ((HashMap)v1);
            int v8 = 0;
            while(true) {
                long v10 = v0_1[v8];
                if((~v10 << 7 & v10 & -9187201950435737472L) != -9187201950435737472L) {
                    int v13 = 8;
                    int v12 = 8 - (~(v8 - v6) >>> 0x1F);
                    int v14 = 0;
                    while(v14 < v12) {
                        if((0xFF & v10) < 0x80) {
                            Object v15 = v5[(v8 << 3) + v14];
                            v16 = v1;
                            StateRecord v1_1 = ((StateObject)v15).getFirstStateRecord();
                            v20 = v0_1;
                            v18 = v8;
                            v19 = v13;
                            StateRecord v0_2 = SnapshotKt.readable(v1_1, arg23, arg26);
                            if(v0_2 == null) {
                                v21 = v5;
                            }
                            else {
                                v21 = v5;
                                StateRecord v5_1 = SnapshotKt.readable(v1_1, v2, v4);
                                if(v5_1 == null) {
                                }
                                else if(!Intrinsics.areEqual(v0_2, v5_1)) {
                                    v22 = v4;
                                    v1_1 = SnapshotKt.readable(v1_1, v2, arg25.getInvalid$runtime());
                                    if(v1_1 != null) {
                                        v1_1 = ((StateObject)v15).mergeRecords(v5_1, v0_2, v1_1);
                                        if(v1_1 != null) {
                                            HashMap v4_1 = v9;
                                            if(v4_1 == null) {
                                                v4_1 = new HashMap();
                                                v9 = v4_1;
                                                v4_1 = v4_1;
                                            }

                                            ((Map)v4_1).put(v0_2, v1_1);
                                            goto label_85;
                                        }
                                        else {
                                            return v16;
                                        }
                                    }
                                    else {
                                        SnapshotKt.readError();
                                        throw new KotlinNothingValueException();
                                    }
                                }
                            }

                            v22 = v4;
                        }
                        else {
                            v20 = v0_1;
                            v16 = v1;
                            v22 = v4;
                            v21 = v5;
                            v18 = v8;
                            v19 = v13;
                        }

                    label_85:
                        v10 >>= v19;
                        ++v14;
                        v1 = v16;
                        v8 = v18;
                        v13 = v19;
                        v0_1 = v20;
                        v5 = v21;
                        v4 = v22;
                    }

                    v20 = v0_1;
                    v16 = v1;
                    v22 = v4;
                    v21 = v5;
                    v18 = v8;
                    if(v12 != v13) {
                        goto label_124;
                    }
                }
                else {
                    v20 = v0_1;
                    v16 = v1;
                    v22 = v4;
                    v21 = v5;
                    v18 = v8;
                }

                int v0_3 = v18;
                if(v0_3 == v6) {
                    break;
                }

                v8 = v0_3 + 1;
                v1 = v16;
                v0_1 = v20;
                v5 = v21;
                v4 = v22;
            }

            HashMap v1_2 = v9;
            goto label_123;
        }
        else {
        label_123:
            v9 = ((HashMap)v1);
        }

    label_124:
        return ((Map)v9);
    }

    public static final Object overwritable(StateRecord arg2, StateObject arg3, StateRecord arg4, Function1 arg5) {
        Object v2_1;
        Snapshot v1;
        Object v0 = SnapshotKt.getLock();
        __monitor_enter(v0);
        try {
            v1 = Snapshot.Companion.getCurrent();
            v2_1 = arg5.invoke(SnapshotKt.overwritableRecord(arg2, arg3, v1, arg4));
        }
        catch(Throwable v2) {
            __monitor_exit(v0);
            throw v2;
        }

        __monitor_exit(v0);
        SnapshotKt.notifyWrite(v1, arg3);
        return v2_1;
    }

    public static final StateRecord overwritableRecord(StateRecord arg4, StateObject arg5, Snapshot arg6, StateRecord arg7) {
        if(arg6.getReadOnly()) {
            arg6.recordModified$runtime(arg5);
        }

        long v0 = arg6.getSnapshotId();
        if(arg7.getSnapshotId$runtime() == v0) {
            return arg7;
        }

        Object v2 = SnapshotKt.getLock();
        __monitor_enter(v2);
        try {
            arg4 = SnapshotKt.newOverwritableRecordLocked(arg4, arg5);
        }
        catch(Throwable v4) {
            __monitor_exit(v2);
            throw v4;
        }

        __monitor_exit(v2);
        arg4.setSnapshotId$runtime(v0);
        if(arg7.getSnapshotId$runtime() != SnapshotId_jvmKt.toSnapshotId(1)) {
            arg6.recordModified$runtime(arg5);
        }

        return arg4;
    }

    private static final boolean overwriteUnusedRecordsLocked(StateObject arg13) {
        StateRecord v7_1;
        StateRecord v0 = arg13.getFirstStateRecord();
        long v1 = SnapshotKt.pinningTable.lowestOrDefault(SnapshotKt.nextSnapshotId);
        StateRecord v3 = null;
        StateRecord v5 = v3;
        int v6 = 0;
        while(v0 != null) {
            long v7 = v0.getSnapshotId$runtime();
            if(v7 != SnapshotKt.INVALID_SNAPSHOT) {
                if(Intrinsics.compare(v7, v1) >= 0) {
                    ++v6;
                }
                else if(v3 == null) {
                    ++v6;
                    v3 = v0;
                }
                else {
                    if(Intrinsics.compare(v0.getSnapshotId$runtime(), v3.getSnapshotId$runtime()) < 0) {
                        v7_1 = v3;
                        v3 = v0;
                    }
                    else {
                        v7_1 = v0;
                    }

                    if(v5 == null) {
                        v5 = arg13.getFirstStateRecord();
                        StateRecord v8 = v5;
                        while(true) {
                            if(v5 == null) {
                                break;
                            }
                            else if(Intrinsics.compare(v5.getSnapshotId$runtime(), v1) >= 0) {
                            }
                            else {
                                if(Intrinsics.compare(v8.getSnapshotId$runtime(), v5.getSnapshotId$runtime()) < 0) {
                                    v8 = v5;
                                }

                                v5 = v5.getNext$runtime();
                                continue;
                            }

                            goto label_42;
                        }

                        v5 = v8;
                    }

                label_42:
                    v3.setSnapshotId$runtime(SnapshotKt.INVALID_SNAPSHOT);
                    v3.assign(v5);
                    v3 = v7_1;
                }
            }

            v0 = v0.getNext$runtime();
        }

        if(v6 > 1) {
            return 1;
        }

        return 0;
    }

    private static final void processForUnusedRecordsLocked(StateObject arg1) {
        if(SnapshotKt.overwriteUnusedRecordsLocked(arg1)) {
            SnapshotKt.extraStateObjects.add(arg1);
        }
    }

    private static final Void readError() {
        throw new IllegalStateException("Reading a state that was created after the snapshot was taken or in a snapshot that has not yet been applied".toString());
    }

    public static final StateRecord readable(StateRecord arg3, StateObject arg4) {
        StateRecord v4_1;
        Snapshot v0 = Snapshot.Companion.getCurrent();
        Function1 v1 = v0.getReadObserver();
        if(v1 != null) {
            v1.invoke(arg4);
        }

        arg3 = SnapshotKt.readable(arg3, v0.getSnapshotId(), v0.getInvalid$runtime());
        if(arg3 != null) {
            return arg3;
        }

        Object v3 = SnapshotKt.getLock();
        __monitor_enter(v3);
        try {
            v0 = Snapshot.Companion.getCurrent();
            v4_1 = arg4.getFirstStateRecord();
            Intrinsics.checkNotNull(v4_1, "null cannot be cast to non-null type T of androidx.compose.runtime.snapshots.SnapshotKt.readable");
            v4_1 = SnapshotKt.readable(v4_1, v0.getSnapshotId(), v0.getInvalid$runtime());
            if(v4_1 == null) {
                goto label_22;
            }
        }
        catch(Throwable v4) {
            goto label_27;
        }

        __monitor_exit(v3);
        return v4_1;
        try {
        label_22:
            SnapshotKt.readError();
            throw new KotlinNothingValueException();
        }
        catch(Throwable v4) {
        label_27:
            __monitor_exit(v3);
            throw v4;
        }

        return arg3;
    }

    private static final StateRecord readable(StateRecord arg6, long arg7, SnapshotIdSet arg9) {
        StateRecord v0 = null;
        StateRecord v1 = v0;
        while(arg6 != null) {
            if(SnapshotKt.valid(arg6, arg7, arg9)) {
                if(v1 == null) {
                }
                else {
                    if(Intrinsics.compare(v1.getSnapshotId$runtime(), arg6.getSnapshotId$runtime()) < 0) {
                        goto label_11;
                    }

                    goto label_12;
                }

            label_11:
                v1 = arg6;
            }

        label_12:
            arg6 = arg6.getNext$runtime();
        }

        if(v1 != null) {
            return v1;
        }

        return v0;
    }

    public static final StateRecord readable(StateRecord arg2, StateObject arg3, Snapshot arg4) {
        StateRecord v3_1;
        Function1 v0 = arg4.getReadObserver();
        if(v0 != null) {
            v0.invoke(arg3);
        }

        arg2 = SnapshotKt.readable(arg2, arg4.getSnapshotId(), arg4.getInvalid$runtime());
        if(arg2 != null) {
            return arg2;
        }

        Object v2 = SnapshotKt.getLock();
        __monitor_enter(v2);
        try {
            arg4 = Snapshot.Companion.getCurrent();
            v3_1 = arg3.getFirstStateRecord();
            Intrinsics.checkNotNull(v3_1, "null cannot be cast to non-null type T of androidx.compose.runtime.snapshots.SnapshotKt.readable");
            v3_1 = SnapshotKt.readable(v3_1, arg4.getSnapshotId(), arg4.getInvalid$runtime());
            if(v3_1 == null) {
                goto label_20;
            }
        }
        catch(Throwable v3) {
            goto label_25;
        }

        __monitor_exit(v2);
        return v3_1;
        try {
        label_20:
            SnapshotKt.readError();
            throw new KotlinNothingValueException();
        }
        catch(Throwable v3) {
        label_25:
            __monitor_exit(v2);
            throw v3;
        }

        return arg2;
    }

    public static final void releasePinningLocked(int arg1) {
        SnapshotKt.pinningTable.remove(arg1);
    }

    private static final Void reportReadonlySnapshotWrite() {
        throw new IllegalStateException("Cannot modify a state object in a read-only snapshot".toString());
    }

    private static final Object resetGlobalSnapshotLocked(GlobalSnapshot arg6, Function1 arg7) {
        long v0 = arg6.getSnapshotId();
        Object v7 = arg7.invoke(SnapshotKt.openSnapshots.clear(v0));
        long v2 = SnapshotKt.nextSnapshotId;
        SnapshotKt.nextSnapshotId = 1 + v2;
        SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.clear(v0);
        arg6.setSnapshotId$runtime(v2);
        arg6.setInvalid$runtime(SnapshotKt.openSnapshots);
        arg6.setWriteCount$runtime(0);
        arg6.setModified$runtime(null);
        arg6.releasePinnedSnapshotLocked$runtime();
        SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(v2);
        return v7;
    }

    public static final Object sync(Function0 arg1) {
        Object v1_1;
        Object v0 = SnapshotKt.getLock();
        __monitor_enter(v0);
        try {
            v1_1 = arg1.invoke();
        }
        catch(Throwable v1) {
            __monitor_exit(v0);
            throw v1;
        }

        __monitor_exit(v0);
        return v1_1;
    }

    private static final Snapshot takeNewSnapshot(Function1 arg1) {
        return SnapshotKt.advanceGlobalSnapshot(new SnapshotKt$$ExternalSyntheticLambda3(arg1));
    }

    static final Snapshot takeNewSnapshot$lambda$0(Function1 arg3, SnapshotIdSet arg4) {
        Object v3 = arg3.invoke(arg4);
        Object v4 = SnapshotKt.getLock();
        __monitor_enter(v4);
        try {
            SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(((Snapshot)v3).getSnapshotId());
        }
        catch(Throwable v3_1) {
            __monitor_exit(v4);
            throw v3_1;
        }

        __monitor_exit(v4);
        return ((Snapshot)v3);
    }

    public static final int trackPinning(long arg1, SnapshotIdSet arg3) {
        int v1_1;
        arg1 = arg3.lowest(arg1);
        Object v3 = SnapshotKt.getLock();
        __monitor_enter(v3);
        try {
            v1_1 = SnapshotKt.pinningTable.add(arg1);
        }
        catch(Throwable v1) {
            __monitor_exit(v3);
            throw v1;
        }

        __monitor_exit(v3);
        return v1_1;
    }

    private static final StateRecord usedLocked(StateObject arg9) {
        StateRecord v9 = arg9.getFirstStateRecord();
        long v0 = SnapshotKt.pinningTable.lowestOrDefault(SnapshotKt.nextSnapshotId) - 1;
        SnapshotIdSet v2 = SnapshotIdSet.Companion.getEMPTY();
        StateRecord v3 = null;
        StateRecord v4 = v3;
        while(v9 != null) {
            if(v9.getSnapshotId$runtime() == SnapshotKt.INVALID_SNAPSHOT) {
            }
            else {
                if(SnapshotKt.valid(v9, v0, v2)) {
                    if(v4 == null) {
                        v4 = v9;
                    }
                    else if(Intrinsics.compare(v9.getSnapshotId$runtime(), v4.getSnapshotId$runtime()) < 0) {
                        return v9;
                    }
                    else {
                        return v4;
                    }
                }

                goto label_26;
            }

            return v9;
        label_26:
            v9 = v9.getNext$runtime();
        }

        return v3;
    }

    private static final boolean valid(StateRecord arg2, long arg3, SnapshotIdSet arg5) {
        return SnapshotKt.valid(arg3, arg2.getSnapshotId$runtime(), arg5);
    }

    private static final boolean valid(long arg2, long arg4, SnapshotIdSet arg6) {
        if(arg4 != SnapshotKt.INVALID_SNAPSHOT && Intrinsics.compare(arg4, arg2) <= 0 && !arg6.get(arg4)) {
            return 1;
        }

        return 0;
    }

    private static final void validateOpen(Snapshot arg4) {
        long v1;
        String v4_2;
        MutableSnapshot v4;
        if(!SnapshotKt.openSnapshots.get(arg4.getSnapshotId())) {
            StringBuilder v0 = new StringBuilder("Snapshot is not open: snapshotId=").append(arg4.getSnapshotId()).append(", disposed=").append(arg4.getDisposed$runtime()).append(", applied=");
            if((arg4 instanceof MutableSnapshot)) {
            }
            else {
                v4 = null;
            }

            if(0 != 0) {
                Boolean v4_1 = Boolean.valueOf(v4.getApplied$runtime());
            }
            else {
                v4_2 = "read-only";
            }

            StringBuilder v4_3 = v0.append(v4_2).append(", lowestPin=");
            Object v0_1 = SnapshotKt.getLock();
            __monitor_enter(v0_1);
            try {
                v1 = SnapshotKt.pinningTable.lowestOrDefault(-1);
            }
            catch(Throwable v4_4) {
                __monitor_exit(v0_1);
                throw v4_4;
            }

            __monitor_exit(v0_1);
            throw new IllegalStateException(v4_3.append(v1).toString().toString());
        }
    }

    public static final Object withCurrent(StateRecord arg0, Function1 arg1) {
        return arg1.invoke(SnapshotKt.current(arg0));
    }

    public static final Object writable(StateRecord arg1, StateObject arg2, Snapshot arg3, Function1 arg4) {
        Object v1_1;
        Object v0 = SnapshotKt.getLock();
        __monitor_enter(v0);
        try {
            v1_1 = arg4.invoke(SnapshotKt.writableRecord(arg1, arg2, arg3));
        }
        catch(Throwable v1) {
            __monitor_exit(v0);
            throw v1;
        }

        __monitor_exit(v0);
        SnapshotKt.notifyWrite(arg3, arg2);
        return v1_1;
    }

    public static final Object writable(StateRecord arg2, StateObject arg3, Function1 arg4) {
        Object v2_1;
        Snapshot v1;
        Object v0 = SnapshotKt.getLock();
        __monitor_enter(v0);
        try {
            v1 = Snapshot.Companion.getCurrent();
            v2_1 = arg4.invoke(SnapshotKt.writableRecord(arg2, arg3, v1));
        }
        catch(Throwable v2) {
            __monitor_exit(v0);
            throw v2;
        }

        __monitor_exit(v0);
        SnapshotKt.notifyWrite(v1, arg3);
        return v2_1;
    }

    public static final StateRecord writableRecord(StateRecord arg6, StateObject arg7, Snapshot arg8) {
        StateRecord v3;
        if(arg8.getReadOnly()) {
            arg8.recordModified$runtime(arg7);
        }

        long v0 = arg8.getSnapshotId();
        arg6 = SnapshotKt.readable(arg6, v0, arg8.getInvalid$runtime());
        if(arg6 == null) {
            goto label_37;
        }

        if(arg6.getSnapshotId$runtime() == arg8.getSnapshotId()) {
            return arg6;
        }

        Object v2 = SnapshotKt.getLock();
        __monitor_enter(v2);
        try {
            v3 = SnapshotKt.readable(arg7.getFirstStateRecord(), v0, arg8.getInvalid$runtime());
            if(v3 == null) {
                goto label_30;
            }

            if(v3.getSnapshotId$runtime() == v0) {
            }
            else {
                v3 = SnapshotKt.newWritableRecordLocked(v3, arg7, arg8);
            }
        }
        catch(Throwable v6) {
            goto label_35;
        }

        __monitor_exit(v2);
        Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type T of androidx.compose.runtime.snapshots.SnapshotKt.writableRecord");
        if(arg6.getSnapshotId$runtime() != SnapshotId_jvmKt.toSnapshotId(1)) {
            arg8.recordModified$runtime(arg7);
        }

        return v3;
        try {
        label_30:
            SnapshotKt.readError();
            throw new KotlinNothingValueException();
        }
        catch(Throwable v6) {
        label_35:
            __monitor_exit(v2);
            throw v6;
        }

    label_37:
        SnapshotKt.readError();
        throw new KotlinNothingValueException();
    }
}

