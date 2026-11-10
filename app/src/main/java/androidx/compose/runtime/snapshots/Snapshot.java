package androidx.compose.runtime.snapshots;

import androidx.collection.MutableScatterSet;
import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.internal.Thread_jvmKt;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001A\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 ]2\u00020\u0001:\u0001]B\u001D\b\u0004\u0012\n\u0010\u0002\u001A\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bB\u0019\b\u0015\u0012\u0006\u0010\t\u001A\u00020\n\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\u000BJ\b\u0010%\u001A\u00020&H\u0016J \u0010\'\u001A\u00020\u00002\u0016\b\u0002\u0010(\u001A\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020&\u0018\u00010)H&J\b\u0010*\u001A\u00020\"H&J\"\u0010+\u001A\u0002H,\"\u0004\b\u0000\u0010,2\f\u0010-\u001A\b\u0012\u0004\u0012\u0002H,0.H\u0086\b¢\u0006\u0002\u0010/J\n\u00100\u001A\u0004\u0018\u00010\u0000H\u0011J\u0012\u00101\u001A\u00020&2\b\u00102\u001A\u0004\u0018\u00010\u0000H\u0011J\b\u00103\u001A\u0004\u0018\u00010\u0000J\u0010\u00104\u001A\u00020&2\b\u00105\u001A\u0004\u0018\u00010\u0000J\u0015\u0010C\u001A\u00020&2\u0006\u00102\u001A\u00020\u0000H ¢\u0006\u0002\bDJ\u0015\u0010E\u001A\u00020&2\u0006\u00102\u001A\u00020\u0000H ¢\u0006\u0002\bFJ\u0015\u0010G\u001A\u00020&2\u0006\u0010H\u001A\u00020IH ¢\u0006\u0002\bJJ\r\u0010O\u001A\u00020&H ¢\u0006\u0002\bPJ\r\u0010Q\u001A\u00020&H\u0000¢\u0006\u0002\bRJ\r\u0010S\u001A\u00020&H\u0010¢\u0006\u0002\bTJ\r\u0010U\u001A\u00020&H\u0010¢\u0006\u0002\bVJ\r\u0010W\u001A\u00020&H\u0000¢\u0006\u0002\bXJ\r\u0010Y\u001A\u00020&H\u0000¢\u0006\u0002\bZJ\r\u0010[\u001A\u00020\nH\u0000¢\u0006\u0002\b\\R\u001A\u0010\u0005\u001A\u00020\u0006X\u0090\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000FR\u001A\u0010\t\u001A\u00020\n8VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0011\u001A\u0004\b\u0012\u0010\u0013R.\u0010\u0002\u001A\u00060\u0003j\u0002`\u00042\n\u0010\u0014\u001A\u00060\u0003j\u0002`\u0004@PX\u0096\u000E¢\u0006\u0010\n\u0002\u0010\u0019\u001A\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u001A\u001A\u00020\n2\u0006\u0010\u0014\u001A\u00020\n8P@PX\u0090\u000E¢\u0006\f\u001A\u0004\b\u001B\u0010\u0013\"\u0004\b\u001C\u0010\u001DR\u0012\u0010\u001E\u001A\u00020\u0000X¦\u0004¢\u0006\u0006\u001A\u0004\b\u001F\u0010 R\u0012\u0010!\u001A\u00020\"X¦\u0004¢\u0006\u0006\u001A\u0004\b#\u0010$R\u001A\u00106\u001A\u00020\"X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b7\u0010$\"\u0004\b8\u00109R\u0014\u0010:\u001A\u00020\nX\u0082\u000E¢\u0006\b\n\u0000\u0012\u0004\b;\u0010\u0011R\u0015\u0010<\u001A\u00020\"8À\u0002X\u0080\u0004¢\u0006\u0006\u001A\u0004\b=\u0010$R(\u0010(\u001A\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020&\u0018\u00010)8 X¡\u0004¢\u0006\f\u0012\u0004\b>\u0010\u0011\u001A\u0004\b?\u0010@R \u0010A\u001A\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020&\u0018\u00010)X \u0004¢\u0006\u0006\u001A\u0004\bB\u0010@R\u001A\u0010K\u001A\n\u0012\u0004\u0012\u00020I\u0018\u00010LX \u0004¢\u0006\u0006\u001A\u0004\bM\u0010N\u0082\u0001\u0004^_`a¨\u0006b"}, d2={"Landroidx/compose/runtime/snapshots/Snapshot;", "", "snapshotId", "", "Landroidx/compose/runtime/snapshots/SnapshotId;", "invalid", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "<init>", "(JLandroidx/compose/runtime/snapshots/SnapshotIdSet;)V", "id", "", "(ILandroidx/compose/runtime/snapshots/SnapshotIdSet;)V", "getInvalid$runtime", "()Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "setInvalid$runtime", "(Landroidx/compose/runtime/snapshots/SnapshotIdSet;)V", "getId$annotations", "()V", "getId", "()I", "value", "getSnapshotId", "()J", "setSnapshotId$runtime", "(J)V", "J", "writeCount", "getWriteCount$runtime", "setWriteCount$runtime", "(I)V", "root", "getRoot", "()Landroidx/compose/runtime/snapshots/Snapshot;", "readOnly", "", "getReadOnly", "()Z", "dispose", "", "takeNestedSnapshot", "readObserver", "Lkotlin/Function1;", "hasPendingChanges", "enter", "T", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "makeCurrent", "restoreCurrent", "snapshot", "unsafeEnter", "unsafeLeave", "oldSnapshot", "disposed", "getDisposed$runtime", "setDisposed$runtime", "(Z)V", "pinningTrackingHandle", "getPinningTrackingHandle$annotations", "isPinned", "isPinned$runtime", "getReadObserver$annotations", "getReadObserver", "()Lkotlin/jvm/functions/Function1;", "writeObserver", "getWriteObserver$runtime", "nestedActivated", "nestedActivated$runtime", "nestedDeactivated", "nestedDeactivated$runtime", "recordModified", "state", "Landroidx/compose/runtime/snapshots/StateObject;", "recordModified$runtime", "modified", "Landroidx/collection/MutableScatterSet;", "getModified$runtime", "()Landroidx/collection/MutableScatterSet;", "notifyObjectsInitialized", "notifyObjectsInitialized$runtime", "closeAndReleasePinning", "closeAndReleasePinning$runtime", "closeLocked", "closeLocked$runtime", "releasePinnedSnapshotsForCloseLocked", "releasePinnedSnapshotsForCloseLocked$runtime", "validateNotDisposed", "validateNotDisposed$runtime", "releasePinnedSnapshotLocked", "releasePinnedSnapshotLocked$runtime", "takeoverPinnedSnapshot", "takeoverPinnedSnapshot$runtime", "Companion", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "Landroidx/compose/runtime/snapshots/NestedReadonlySnapshot;", "Landroidx/compose/runtime/snapshots/ReadonlySnapshot;", "Landroidx/compose/runtime/snapshots/TransparentObserverSnapshot;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public abstract class Snapshot {
    @Metadata(d1={"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001E\u0010\u000F\u001A\u00020\u00052\u0016\b\u0002\u0010\u0010\u001A\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011J6\u0010\u0013\u001A\u00020\u00142\u0016\b\u0002\u0010\u0010\u001A\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00112\u0016\b\u0002\u0010\u0015\u001A\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011J\"\u0010\u0016\u001A\u0002H\u0017\"\u0004\b\u0000\u0010\u00172\f\u0010\u0018\u001A\b\u0012\u0004\u0012\u0002H\u00170\u0019H\u0086\b¢\u0006\u0002\u0010\u001AJ\"\u0010\u001B\u001A\u0002H\u001C\"\u0004\b\u0000\u0010\u001C2\f\u0010\u0018\u001A\b\u0012\u0004\u0012\u0002H\u001C0\u0019H\u0086\b¢\u0006\u0002\u0010\u001AJO\u0010\u001D\u001A\u0002H\u0017\"\u0004\b\u0000\u0010\u00172\u0016\b\u0002\u0010\u0010\u001A\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00112\u0016\b\u0002\u0010\u0015\u001A\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00112\f\u0010\u0018\u001A\b\u0012\u0004\u0012\u0002H\u00170\u0019¢\u0006\u0002\u0010\u001EJV\u0010\u001F\u001A\u0002H\u0017\"\u0004\b\u0000\u0010\u00172\u0016\b\n\u0010\u0010\u001A\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00112\u0016\b\n\u0010\u0015\u001A\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00112\u000E\b\b\u0010\u0018\u001A\b\u0012\u0004\u0012\u0002H\u00170\u0019H\u0080\b¢\u0006\u0004\b \u0010\u001EJ\b\u0010!\u001A\u00020\u0005H\u0001J\u0012\u0010+\u001A\u00020\u00052\b\u0010,\u001A\u0004\u0018\u00010\u0005H\u0001J0\u0010-\u001A\u00020\u00122\b\u0010,\u001A\u0004\u0018\u00010\u00052\u0006\u0010.\u001A\u00020\u00052\u0014\u0010/\u001A\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0001J4\u00100\u001A\u0002H\u0017\"\u0004\b\u0000\u0010\u00172\u0011\u0010\u0018\u001A\r\u0012\u0004\u0012\u0002H\u00170\u0019¢\u0006\u0002\b1H\u0086\b\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u001AJ&\u00102\u001A\u0002032\u001E\u0010/\u001A\u001A\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000105\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001204J\u001A\u00106\u001A\u0002032\u0012\u0010/\u001A\u000E\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00120\u0011J\u0006\u00107\u001A\u00020\u0012J\u0006\u00108\u001A\u00020\u0012J\b\u00109\u001A\u00020\rH\u0007J\n\u0010:\u001A\u0004\u0018\u00010\u0005H\u0001J\u0012\u0010;\u001A\u00020\u00122\b\u0010,\u001A\u0004\u0018\u00010\u0005H\u0001R\u0011\u0010\u0004\u001A\u00020\u00058F¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001A\u00020\t8F¢\u0006\u0006\u001A\u0004\b\b\u0010\nR\u0011\u0010\u000B\u001A\u00020\t8F¢\u0006\u0006\u001A\u0004\b\u000B\u0010\nR\u0014\u0010\f\u001A\u00020\rX\u0086T¢\u0006\b\n\u0000\u0012\u0004\b\u000E\u0010\u0003R\u001C\u0010\"\u001A\u0004\u0018\u00010\u00058@X\u0081\u0004¢\u0006\f\u0012\u0004\b#\u0010\u0003\u001A\u0004\b$\u0010\u0007R\u0019\u0010%\u001A\u00020\t*\u00020&8Â\u0002X\u0082\u0004¢\u0006\u0006\u001A\u0004\b\'\u0010(R\u0019\u0010%\u001A\u00020\t*\u00020)8Â\u0002X\u0082\u0004¢\u0006\u0006\u001A\u0004\b\'\u0010*¨\u0006<"}, d2={"Landroidx/compose/runtime/snapshots/Snapshot$Companion;", "", "<init>", "()V", "current", "Landroidx/compose/runtime/snapshots/Snapshot;", "getCurrent", "()Landroidx/compose/runtime/snapshots/Snapshot;", "isInSnapshot", "", "()Z", "isApplyObserverNotificationPending", "PreexistingSnapshotId", "", "getPreexistingSnapshotId$annotations", "takeSnapshot", "readObserver", "Lkotlin/Function1;", "", "takeMutableSnapshot", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "writeObserver", "global", "T", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "withMutableSnapshot", "R", "observe", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "observeInternal", "observeInternal$runtime", "createNonObservableSnapshot", "currentThreadSnapshot", "getCurrentThreadSnapshot$annotations", "getCurrentThreadSnapshot", "canBeReused", "Landroidx/compose/runtime/snapshots/TransparentObserverMutableSnapshot;", "getCanBeReused", "(Landroidx/compose/runtime/snapshots/TransparentObserverMutableSnapshot;)Z", "Landroidx/compose/runtime/snapshots/TransparentObserverSnapshot;", "(Landroidx/compose/runtime/snapshots/TransparentObserverSnapshot;)Z", "makeCurrentNonObservable", "previous", "restoreNonObservable", "nonObservable", "observer", "withoutReadObservation", "Landroidx/compose/runtime/DisallowComposableCalls;", "registerApplyObserver", "Landroidx/compose/runtime/snapshots/ObserverHandle;", "Lkotlin/Function2;", "", "registerGlobalWriteObserver", "notifyObjectsInitialized", "sendApplyNotifications", "openSnapshotCount", "removeCurrent", "restoreCurrent", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final Snapshot createNonObservableSnapshot() {
            return SnapshotKt.createTransparentSnapshotWithNoParentReadObserver$default(SnapshotKt.access$getThreadSnapshot$p().get(), null, false, 6, null);
        }

        private final boolean getCanBeReused(TransparentObserverMutableSnapshot arg3) {
            if(arg3.getThreadId$runtime() == Thread_jvmKt.currentThreadId()) {
                return 1;
            }

            return 0;
        }

        private final boolean getCanBeReused(TransparentObserverSnapshot arg3) {
            if(arg3.getThreadId$runtime() == Thread_jvmKt.currentThreadId()) {
                return 1;
            }

            return 0;
        }

        public final Snapshot getCurrent() {
            return SnapshotKt.currentSnapshot();
        }

        public final Snapshot getCurrentThreadSnapshot() {
            return SnapshotKt.access$getThreadSnapshot$p().get();
        }

        public static void getCurrentThreadSnapshot$annotations() {
        }

        public static void getPreexistingSnapshotId$annotations() {
        }

        public final Object global(Function0 arg2) {
            Object v2_1;
            Snapshot v0 = this.removeCurrent();
            try {
                v2_1 = arg2.invoke();
            }
            catch(Throwable v2) {
                this.restoreCurrent(v0);
                throw v2;
            }

            this.restoreCurrent(v0);
            return v2_1;
        }

        public final boolean isApplyObserverNotificationPending() {
            if(SnapshotKt.access$getPendingApplyObserverCount$p().get() > 0) {
                return 1;
            }

            return 0;
        }

        public final boolean isInSnapshot() {
            if(SnapshotKt.access$getThreadSnapshot$p().get() != null) {
                return 1;
            }

            return 0;
        }

        public final Snapshot makeCurrentNonObservable(Snapshot arg6) {
            Snapshot v5;
            Function1 v0 = null;
            if((arg6 instanceof TransparentObserverMutableSnapshot)) {
                v5 = arg6;
                if(((TransparentObserverMutableSnapshot)v5).getThreadId$runtime() == Thread_jvmKt.currentThreadId()) {
                    ((TransparentObserverMutableSnapshot)v5).setReadObserver$runtime(v0);
                    return arg6;
                }
            }

            if((arg6 instanceof TransparentObserverSnapshot)) {
                v5 = arg6;
                if(((TransparentObserverSnapshot)v5).getThreadId$runtime() == Thread_jvmKt.currentThreadId()) {
                    ((TransparentObserverSnapshot)v5).setReadObserver$runtime(v0);
                    return arg6;
                }
            }

            v5 = SnapshotKt.createTransparentSnapshotWithNoParentReadObserver$default(arg6, v0, false, 6, v0);
            v5.makeCurrent();
            return v5;
        }

        public final void notifyObjectsInitialized() {
            SnapshotKt.currentSnapshot().notifyObjectsInitialized$runtime();
        }

        public final Object observe(Function1 arg8, Function1 arg9, Function0 arg10) {
            Object v9;
            Snapshot v8;
            TransparentObserverMutableSnapshot v7_2;
            if(arg8 == null && arg9 == null) {
                return arg10.invoke();
            }

            Object v7 = SnapshotKt.access$getThreadSnapshot$p().get();
            Object v1 = null;
            if((v7 instanceof TransparentObserverMutableSnapshot)) {
                Object v2 = v7;
                if(((TransparentObserverMutableSnapshot)v2).getThreadId$runtime() == Thread_jvmKt.currentThreadId()) {
                    Function1 v3 = ((TransparentObserverMutableSnapshot)v2).getReadObserver$runtime();
                    Function1 v4 = ((TransparentObserverMutableSnapshot)v2).getWriteObserver$runtime();
                    try {
                        v7.setReadObserver$runtime(SnapshotKt.mergedReadObserver$default(arg8, v3, false, 4, v1));
                        ((TransparentObserverMutableSnapshot)v7).setWriteObserver$runtime(SnapshotKt.mergedWriteObserver(arg9, v4));
                        v7 = arg10.invoke();
                    }
                    catch(Throwable v0) {
                        ((TransparentObserverMutableSnapshot)v2).setReadObserver$runtime(v3);
                        ((TransparentObserverMutableSnapshot)v2).setWriteObserver$runtime(v4);
                        throw v0;
                    }

                    ((TransparentObserverMutableSnapshot)v2).setReadObserver$runtime(v3);
                    ((TransparentObserverMutableSnapshot)v2).setWriteObserver$runtime(v4);
                    return v7;
                }
            }

            if(v7 == null || ((v7 instanceof MutableSnapshot))) {
                if((v7 instanceof MutableSnapshot)) {
                    v1 = v7;
                }

                v7_2 = new TransparentObserverMutableSnapshot(((MutableSnapshot)v1), arg8, arg9, true, false);
            }
            else if(arg8 == null) {
                return arg10.invoke();
            }
            else {
                Snapshot v7_1 = ((Snapshot)v7).takeNestedSnapshot(arg8);
            }

            try {
                v8 = ((Snapshot)v7_2).makeCurrent();
            }
            catch(Throwable v0) {
                goto label_61;
            }

            try {
                v9 = arg10.invoke();
                goto label_52;
            }
            catch(Throwable v0) {
                Throwable v9_1 = v0;
                try {
                    ((Snapshot)v7_2).restoreCurrent(v8);
                    throw v9_1;
                label_52:
                    ((Snapshot)v7_2).restoreCurrent(v8);
                }
                catch(Throwable v0) {
                label_61:
                    ((Snapshot)v7_2).dispose();
                    throw v0;
                }
            }

            ((Snapshot)v7_2).dispose();
            return v9;
        }

        public static Object observe$default(Companion arg1, Function1 arg2, Function1 arg3, Function0 arg4, int arg5, Object arg6) {
            Function1 v0 = null;
            if((arg5 & 1) != 0) {
                arg2 = v0;
            }

            if((arg5 & 2) != 0) {
                arg3 = v0;
            }

            return arg1.observe(arg2, arg3, arg4);
        }

        public final Object observeInternal$runtime(Function1 arg8, Function1 arg9, Function0 arg10) {
            Object v9;
            Snapshot v8;
            TransparentObserverMutableSnapshot v7_2;
            if(arg8 == null && arg9 == null) {
                return arg10.invoke();
            }

            Object v7 = SnapshotKt.access$getThreadSnapshot$p().get();
            Object v1 = null;
            if((v7 instanceof TransparentObserverMutableSnapshot)) {
                Object v2 = v7;
                if(((TransparentObserverMutableSnapshot)v2).getThreadId$runtime() == Thread_jvmKt.currentThreadId()) {
                    Function1 v3 = ((TransparentObserverMutableSnapshot)v2).getReadObserver$runtime();
                    Function1 v4 = ((TransparentObserverMutableSnapshot)v2).getWriteObserver$runtime();
                    try {
                        v7.setReadObserver$runtime(SnapshotKt.mergedReadObserver$default(arg8, v3, false, 4, v1));
                        ((TransparentObserverMutableSnapshot)v7).setWriteObserver$runtime(SnapshotKt.mergedWriteObserver(arg9, v4));
                        v7 = arg10.invoke();
                    }
                    catch(Throwable v0) {
                        ((TransparentObserverMutableSnapshot)v2).setReadObserver$runtime(v3);
                        ((TransparentObserverMutableSnapshot)v2).setWriteObserver$runtime(v4);
                        throw v0;
                    }

                    ((TransparentObserverMutableSnapshot)v2).setReadObserver$runtime(v3);
                    ((TransparentObserverMutableSnapshot)v2).setWriteObserver$runtime(v4);
                    return v7;
                }
            }

            if(v7 == null || ((v7 instanceof MutableSnapshot))) {
                if((v7 instanceof MutableSnapshot)) {
                    v1 = v7;
                }

                v7_2 = new TransparentObserverMutableSnapshot(((MutableSnapshot)v1), arg8, arg9, true, false);
            }
            else if(arg8 == null) {
                return arg10.invoke();
            }
            else {
                Snapshot v7_1 = ((Snapshot)v7).takeNestedSnapshot(arg8);
            }

            try {
                v8 = ((Snapshot)v7_2).makeCurrent();
            }
            catch(Throwable v0) {
                goto label_61;
            }

            try {
                v9 = arg10.invoke();
                goto label_52;
            }
            catch(Throwable v0) {
                Throwable v9_1 = v0;
                try {
                    ((Snapshot)v7_2).restoreCurrent(v8);
                    throw v9_1;
                label_52:
                    ((Snapshot)v7_2).restoreCurrent(v8);
                }
                catch(Throwable v0) {
                label_61:
                    ((Snapshot)v7_2).dispose();
                    throw v0;
                }
            }

            ((Snapshot)v7_2).dispose();
            return v9;
        }

        public static Object observeInternal$runtime$default(Companion arg6, Function1 arg7, Function1 arg8, Function0 arg9, int arg10, Object arg11) {
            Object v8;
            Snapshot v7_1;
            TransparentObserverMutableSnapshot v6_2;
            arg11 = null;
            Function1 v2 = (arg10 & 1) != 0 ? ((Function1)arg11) : arg7;
            Function1 v3 = (arg10 & 2) != 0 ? ((Function1)arg11) : arg8;
            if(v2 == null && v3 == null) {
                return arg9.invoke();
            }

            Object v6 = SnapshotKt.access$getThreadSnapshot$p().get();
            if((v6 instanceof TransparentObserverMutableSnapshot)) {
                Object v7 = v6;
                if(((TransparentObserverMutableSnapshot)v7).getThreadId$runtime() == Thread_jvmKt.currentThreadId()) {
                    arg8 = ((TransparentObserverMutableSnapshot)v7).getReadObserver$runtime();
                    Function1 v10 = ((TransparentObserverMutableSnapshot)v7).getWriteObserver$runtime();
                    try {
                        v6.setReadObserver$runtime(SnapshotKt.mergedReadObserver$default(v2, arg8, false, 4, arg11));
                        ((TransparentObserverMutableSnapshot)v6).setWriteObserver$runtime(SnapshotKt.mergedWriteObserver(v3, v10));
                        v6 = arg9.invoke();
                    }
                    catch(Throwable v0) {
                        ((TransparentObserverMutableSnapshot)v7).setReadObserver$runtime(arg8);
                        ((TransparentObserverMutableSnapshot)v7).setWriteObserver$runtime(v10);
                        throw v0;
                    }

                    ((TransparentObserverMutableSnapshot)v7).setReadObserver$runtime(arg8);
                    ((TransparentObserverMutableSnapshot)v7).setWriteObserver$runtime(v10);
                    return v6;
                }
            }

            if(v6 == null || ((v6 instanceof MutableSnapshot))) {
                if((v6 instanceof MutableSnapshot)) {
                    arg11 = v6;
                }

                v6_2 = new TransparentObserverMutableSnapshot(arg11, v2, v3, true, false);
            }
            else if(v2 == null) {
                return arg9.invoke();
            }
            else {
                Snapshot v6_1 = ((Snapshot)v6).takeNestedSnapshot(v2);
            }

            try {
                v7_1 = ((Snapshot)v6_2).makeCurrent();
            }
            catch(Throwable v0) {
                goto label_70;
            }

            try {
                v8 = arg9.invoke();
                goto label_61;
            }
            catch(Throwable v0) {
                Throwable v8_1 = v0;
                try {
                    ((Snapshot)v6_2).restoreCurrent(v7_1);
                    throw v8_1;
                label_61:
                    ((Snapshot)v6_2).restoreCurrent(v7_1);
                }
                catch(Throwable v0) {
                label_70:
                    ((Snapshot)v6_2).dispose();
                    throw v0;
                }
            }

            ((Snapshot)v6_2).dispose();
            return v8;
        }

        public final int openSnapshotCount() {
            return CollectionsKt.toList(SnapshotKt.access$getOpenSnapshots$p()).size();
        }

        public final ObserverHandle registerApplyObserver(Function2 arg2) {
            SnapshotKt.access$advanceGlobalSnapshot(SnapshotKt.access$getEmptyLambda$p());
            Object v1 = SnapshotKt.getLock();
            __monitor_enter(v1);
            try {
                SnapshotKt.access$setApplyObservers$p(CollectionsKt.plus(SnapshotKt.access$getApplyObservers$p(), arg2));
            }
            catch(Throwable v2) {
                __monitor_exit(v1);
                throw v2;
            }

            __monitor_exit(v1);
            return new Snapshot$Companion$$ExternalSyntheticLambda0(arg2);
        }

        static final void registerApplyObserver$lambda$1(Function2 arg2) {
            Object v0 = SnapshotKt.getLock();
            __monitor_enter(v0);
            try {
                SnapshotKt.access$setApplyObservers$p(CollectionsKt.minus(SnapshotKt.access$getApplyObservers$p(), arg2));
            }
            catch(Throwable v2) {
                __monitor_exit(v0);
                throw v2;
            }

            __monitor_exit(v0);
        }

        public final ObserverHandle registerGlobalWriteObserver(Function1 arg2) {
            Object v1 = SnapshotKt.getLock();
            __monitor_enter(v1);
            try {
                SnapshotKt.access$setGlobalWriteObservers$p(CollectionsKt.plus(SnapshotKt.access$getGlobalWriteObservers$p(), arg2));
            }
            catch(Throwable v2) {
                __monitor_exit(v1);
                throw v2;
            }

            __monitor_exit(v1);
            SnapshotKt.access$advanceGlobalSnapshot();
            return new Snapshot$Companion$$ExternalSyntheticLambda1(arg2);
        }

        static final void registerGlobalWriteObserver$lambda$1(Function1 arg2) {
            Object v0 = SnapshotKt.getLock();
            __monitor_enter(v0);
            try {
                SnapshotKt.access$setGlobalWriteObservers$p(CollectionsKt.minus(SnapshotKt.access$getGlobalWriteObservers$p(), arg2));
            }
            catch(Throwable v2) {
                __monitor_exit(v0);
                throw v2;
            }

            __monitor_exit(v0);
            SnapshotKt.access$advanceGlobalSnapshot();
        }

        public final Snapshot removeCurrent() {
            Object v2 = SnapshotKt.access$getThreadSnapshot$p().get();
            if(v2 != null) {
                SnapshotKt.access$getThreadSnapshot$p().set(null);
            }

            return ((Snapshot)v2);
        }

        public final void restoreCurrent(Snapshot arg1) {
            if(arg1 != null) {
                SnapshotKt.access$getThreadSnapshot$p().set(arg1);
            }
        }

        public final void restoreNonObservable(Snapshot arg1, Snapshot arg2, Function1 arg3) {
            if(arg1 == arg2) {
                if((arg1 instanceof TransparentObserverMutableSnapshot)) {
                    ((TransparentObserverMutableSnapshot)arg1).setReadObserver$runtime(arg3);
                    return;
                }

                if((arg1 instanceof TransparentObserverSnapshot)) {
                    ((TransparentObserverSnapshot)arg1).setReadObserver$runtime(arg3);
                    return;
                }

                throw new IllegalStateException("Non-transparent snapshot was reused: " + arg1.toString());
            }

            arg2.restoreCurrent(arg1);
            arg2.dispose();
        }

        public final void sendApplyNotifications() {
            Object v1 = SnapshotKt.getLock();
            __monitor_enter(v1);
            try {
                boolean v0_1 = SnapshotKt.access$getGlobalSnapshot$p().hasPendingChanges();
            }
            catch(Throwable v0) {
                __monitor_exit(v1);
                throw v0;
            }

            __monitor_exit(v1);
            if(v0_1) {
                SnapshotKt.access$advanceGlobalSnapshot();
            }
        }

        public final MutableSnapshot takeMutableSnapshot(Function1 arg2, Function1 arg3) {
            Snapshot v1 = SnapshotKt.currentSnapshot();
            if((v1 instanceof MutableSnapshot)) {
            }
            else {
                v1 = null;
            }

            if(v1 != null) {
                MutableSnapshot v1_1 = ((MutableSnapshot)v1).takeNestedMutableSnapshot(arg2, arg3);
                if(v1_1 != null) {
                    return v1_1;
                }
            }

            throw new IllegalStateException("Cannot create a mutable snapshot of an read-only snapshot".toString());
        }

        public static MutableSnapshot takeMutableSnapshot$default(Companion arg1, Function1 arg2, Function1 arg3, int arg4, Object arg5) {
            Function1 v0 = null;
            if((arg4 & 1) != 0) {
                arg2 = v0;
            }

            if((arg4 & 2) != 0) {
                arg3 = v0;
            }

            return arg1.takeMutableSnapshot(arg2, arg3);
        }

        public final Snapshot takeSnapshot(Function1 arg1) {
            return SnapshotKt.currentSnapshot().takeNestedSnapshot(arg1);
        }

        public static Snapshot takeSnapshot$default(Companion arg0, Function1 arg1, int arg2, Object arg3) {
            if((arg2 & 1) != 0) {
                arg1 = null;
            }

            return arg0.takeSnapshot(arg1);
        }

        public final Object withMutableSnapshot(Function0 arg3) {
            Object v3_1;
            Snapshot v1;
            MutableSnapshot v0;
            MutableSnapshot v2 = Companion.takeMutableSnapshot$default(this, null, null, 3, null);
            try {
                v0 = v2;
                v1 = ((Snapshot)v0).makeCurrent();
            }
            catch(Throwable v3) {
                goto label_15;
            }

            try {
                v3_1 = arg3.invoke();
                goto label_6;
            }
            catch(Throwable v3) {
                try {
                    ((Snapshot)v0).restoreCurrent(v1);
                    throw v3;
                label_6:
                    ((Snapshot)v0).restoreCurrent(v1);
                }
                catch(Throwable v3) {
                    try {
                    label_15:
                        throw v3;
                    }
                    catch(Throwable v3) {
                        v2.dispose();
                        throw v3;
                    }
                }
            }

            v2.apply().check();
            v2.dispose();
            return v3_1;
        }

        public final Object withoutReadObservation(Function0 arg4) {
            Object v4_1;
            Snapshot v0 = this.getCurrentThreadSnapshot();
            Function1 v1 = v0 != null ? v0.getReadObserver() : null;
            Snapshot v2 = this.makeCurrentNonObservable(v0);
            try {
                v4_1 = arg4.invoke();
            }
            catch(Throwable v4) {
                this.restoreNonObservable(v0, v2, v1);
                throw v4;
            }

            this.restoreNonObservable(v0, v2, v1);
            return v4_1;
        }
    }

    public static final int $stable = 0;
    public static final Companion Companion = null;
    public static final int PreexistingSnapshotId = 1;
    private boolean disposed;
    private SnapshotIdSet invalid;
    private int pinningTrackingHandle;
    private long snapshotId;

    static {
        Snapshot.Companion = new Companion(null);
        Snapshot.$stable = 8;
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Use id: Long constructor instead") private Snapshot(int arg3, SnapshotIdSet arg4) {
        this(SnapshotId_jvmKt.toSnapshotId(arg3), arg4, null);
    }

    public Snapshot(long arg1, SnapshotIdSet arg3, DefaultConstructorMarker arg4) {
        this(arg1, arg3);
    }

    public Snapshot(int arg1, SnapshotIdSet arg2, DefaultConstructorMarker arg3) {
        this(arg1, arg2);
    }

    private Snapshot(long arg3, SnapshotIdSet arg5) {
        super();
        this.invalid = arg5;
        this.snapshotId = arg3;
        int v3 = arg3 != SnapshotKt.access$getINVALID_SNAPSHOT$p() ? SnapshotKt.trackPinning(arg3, this.getInvalid$runtime()) : -1;
        this.pinningTrackingHandle = v3;
    }

    public static final int access$getPinningTrackingHandle$p(Snapshot arg0) {
        return arg0.pinningTrackingHandle;
    }

    public final void closeAndReleasePinning$runtime() {
        Object v0 = SnapshotKt.getLock();
        __monitor_enter(v0);
        try {
            this.closeLocked$runtime();
            this.releasePinnedSnapshotsForCloseLocked$runtime();
        }
        catch(Throwable v1) {
            __monitor_exit(v0);
            throw v1;
        }

        __monitor_exit(v0);
    }

    public void closeLocked$runtime() {
        SnapshotKt.access$setOpenSnapshots$p(SnapshotKt.access$getOpenSnapshots$p().clear(this.getSnapshotId()));
    }

    public void dispose() {
        this.disposed = true;
        Object v0 = SnapshotKt.getLock();
        __monitor_enter(v0);
        try {
            this.releasePinnedSnapshotLocked$runtime();
        }
        catch(Throwable v1) {
            __monitor_exit(v0);
            throw v1;
        }

        __monitor_exit(v0);
    }

    public final Object enter(Function0 arg2) {
        Object v2_1;
        Snapshot v0 = this.makeCurrent();
        try {
            v2_1 = arg2.invoke();
        }
        catch(Throwable v2) {
            this.restoreCurrent(v0);
            throw v2;
        }

        this.restoreCurrent(v0);
        return v2_1;
    }

    public final boolean getDisposed$runtime() {
        return this.disposed;
    }

    public int getId() {
        return ((int)this.getSnapshotId());
    }

    @Deprecated(message="Use snapshotId instead", replaceWith="<_subannotation>") public static void getId$annotations() {
    }

    public SnapshotIdSet getInvalid$runtime() {
        return this.invalid;
    }

    public abstract MutableScatterSet getModified$runtime();

    private static void getPinningTrackingHandle$annotations() {
    }

    public abstract Function1 getReadObserver();

    public static void getReadObserver$annotations() {
    }

    public abstract boolean getReadOnly();

    public abstract Snapshot getRoot();

    public long getSnapshotId() {
        return this.snapshotId;
    }

    public int getWriteCount$runtime() {
        return 0;
    }

    public abstract Function1 getWriteObserver$runtime();

    public abstract boolean hasPendingChanges();

    public final boolean isPinned$runtime() {
        if(this.pinningTrackingHandle >= 0) {
            return 1;
        }

        return 0;
    }

    public Snapshot makeCurrent() {
        Object v0 = SnapshotKt.access$getThreadSnapshot$p().get();
        SnapshotKt.access$getThreadSnapshot$p().set(this);
        return ((Snapshot)v0);
    }

    public abstract void nestedActivated$runtime(Snapshot arg1);

    public abstract void nestedDeactivated$runtime(Snapshot arg1);

    public abstract void notifyObjectsInitialized$runtime();

    public abstract void recordModified$runtime(StateObject arg1);

    public final void releasePinnedSnapshotLocked$runtime() {
        int v0 = this.pinningTrackingHandle;
        if(v0 >= 0) {
            SnapshotKt.releasePinningLocked(v0);
            this.pinningTrackingHandle = -1;
        }
    }

    public void releasePinnedSnapshotsForCloseLocked$runtime() {
        this.releasePinnedSnapshotLocked$runtime();
    }

    public void restoreCurrent(Snapshot arg1) {
        SnapshotKt.access$getThreadSnapshot$p().set(arg1);
    }

    public final void setDisposed$runtime(boolean arg1) {
        this.disposed = arg1;
    }

    public void setInvalid$runtime(SnapshotIdSet arg1) {
        this.invalid = arg1;
    }

    public void setSnapshotId$runtime(long arg1) {
        this.snapshotId = arg1;
    }

    public void setWriteCount$runtime(int arg1) {
        throw new IllegalStateException("Updating write count is not supported for this snapshot".toString());
    }

    public abstract Snapshot takeNestedSnapshot(Function1 arg1);

    public static Snapshot takeNestedSnapshot$default(Snapshot arg0, Function1 arg1, int arg2, Object arg3) {
        if(arg3 == null) {
            if((arg2 & 1) != 0) {
                arg1 = null;
            }

            return arg0.takeNestedSnapshot(arg1);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: takeNestedSnapshot");
    }

    public final int takeoverPinnedSnapshot$runtime() {
        int v0 = this.pinningTrackingHandle;
        this.pinningTrackingHandle = -1;
        return v0;
    }

    public final Snapshot unsafeEnter() {
        return this.makeCurrent();
    }

    public final void unsafeLeave(Snapshot arg3) {
        int v0 = SnapshotKt.access$getThreadSnapshot$p().get() == this ? 1 : 0;
        if(v0 == 0) {
            PreconditionsKt.throwIllegalStateException("Cannot leave snapshot; " + this + " is not the current snapshot");
        }

        this.restoreCurrent(arg3);
    }

    public final void validateNotDisposed$runtime() {
        if(this.disposed) {
            PreconditionsKt.throwIllegalArgumentException("Cannot use a disposed snapshot");
        }
    }
}

