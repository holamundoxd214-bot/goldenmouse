package androidx.compose.runtime.snapshots;

import androidx.collection.MutableObjectIntMap;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ObjectIntMap;
import androidx.collection.ScatterSet;
import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DerivedState$Record;
import androidx.compose.runtime.DerivedState;
import androidx.compose.runtime.DerivedStateObserver;
import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.collection.ScatterSetWrapper;
import androidx.compose.runtime.collection.ScopeMap;
import androidx.compose.runtime.internal.Thread_jvmKt;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Deprecated;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(d1={"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0014\b\u0007\u0018\u00002\u00020\u0001:\u0001>B0\u0012\'\u0010\u0002\u001A#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0015\u001A\u00020\u0010H\u0002J\b\u0010\u0016\u001A\u00020\u0005H\u0002J\u0016\u0010\u0017\u001A\u00020\u00052\f\u0010\u0018\u001A\b\u0012\u0004\u0012\u00020\u00010\u0013H\u0002J\u0010\u0010\u0019\u001A\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013H\u0002J\b\u0010\u001A\u001A\u00020\u001BH\u0002J\u001D\u0010#\u001A\u00020\u00052\u0012\u0010$\u001A\u000E\u0012\u0004\u0012\u00020\u001F\u0012\u0004\u0012\u00020\u00050\u0003H\u0082\bJ\u001D\u0010%\u001A\u00020\u00052\u0012\u0010$\u001A\u000E\u0012\u0004\u0012\u00020\u001F\u0012\u0004\u0012\u00020\u00100\u0003H\u0082\bJ?\u0010,\u001A\u00020\u0005\"\b\b\u0000\u0010-*\u00020\u00012\u0006\u0010.\u001A\u0002H-2\u0012\u0010/\u001A\u000E\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u00020\u00050\u00032\f\u0010$\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u00100J/\u00101\u001A\u0002H-\"\u0004\b\u0000\u0010-2\f\u0010$\u001A\b\u0012\u0004\u0012\u0002H-0\u0004H\u0082\b\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u00102J\u0016\u00103\u001A\u00020\u00052\f\u0010$\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007J\u000E\u00104\u001A\u00020\u00052\u0006\u0010.\u001A\u00020\u0001J)\u00105\u001A\u00020\u00052!\u00106\u001A\u001D\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u00100\u0003J\u0006\u00107\u001A\u00020\u0005J\u0006\u00108\u001A\u00020\u0005J\u001E\u00109\u001A\u00020\u00052\f\u0010:\u001A\b\u0012\u0004\u0012\u00020\u00010\u00132\u0006\u0010;\u001A\u00020\u0014H\u0007J\u0006\u00104\u001A\u00020\u0005J&\u0010<\u001A\u00020\u001F\"\b\b\u0000\u0010-*\u00020\u00012\u0012\u0010=\u001A\u000E\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u00020\u00050\u0003H\u0002R/\u0010\u0002\u001A#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u000B\u001A\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00010\fj\n\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000ER\u000E\u0010\u000F\u001A\u00020\u0010X\u0082\u000E¢\u0006\u0002\n\u0000R&\u0010\u0011\u001A\u001A\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00050\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u001C\u001A\u000E\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001D\u001A\b\u0012\u0004\u0012\u00020\u001F0\u001EX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010 \u001A\u00060\u0001j\u0002`!X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\"R\u0010\u0010&\u001A\u0004\u0018\u00010\'X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010(\u001A\u00020\u0010X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010)\u001A\u0004\u0018\u00010\u001FX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010*\u001A\u00020+X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006?"}, d2={"Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "", "onChangedExecutor", "Lkotlin/Function1;", "Lkotlin/Function0;", "", "Lkotlin/ParameterName;", "name", "callback", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "pendingChanges", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/runtime/internal/AtomicReference;", "Ljava/util/concurrent/atomic/AtomicReference;", "sendingNotifications", "", "applyObserver", "Lkotlin/Function2;", "", "Landroidx/compose/runtime/snapshots/Snapshot;", "drainChanges", "sendNotifications", "addChanges", "set", "removeChanges", "report", "", "readObserver", "observedScopeMaps", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/runtime/snapshots/SnapshotStateObserver$ObservedScopeMap;", "observedScopeMapsLock", "Landroidx/compose/runtime/platform/SynchronizedObject;", "Ljava/lang/Object;", "forEachScopeMap", "block", "removeScopeMapIf", "applyUnsubscribe", "Landroidx/compose/runtime/snapshots/ObserverHandle;", "isPaused", "currentMap", "currentMapThreadId", "", "observeReads", "T", "scope", "onValueChangedForScope", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "withScopeMapLock", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "withNoObservations", "clear", "clearIf", "predicate", "start", "stop", "notifyChanges", "changes", "snapshot", "ensureMap", "onChanged", "ObservedScopeMap", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class SnapshotStateObserver {
    @Metadata(d1={"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u001B\u0012\u0012\u0010\u0002\u001A\u000E\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000E\u0010\'\u001A\u00020\u00042\u0006\u0010(\u001A\u00020\u0001J.\u0010\'\u001A\u00020\u00042\u0006\u0010(\u001A\u00020\u00012\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\t\u001A\u00020\u00012\f\u0010)\u001A\b\u0012\u0004\u0012\u00020\u00010\u000BH\u0002J7\u0010*\u001A\u00020\u00042\u0006\u0010+\u001A\u00020\u00012\u0014\b\b\u0010,\u001A\u000E\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u00032\u000E\b\b\u0010-\u001A\b\u0012\u0004\u0012\u00020\u00040.H\u0086\bJ\u0010\u0010/\u001A\u00020\u00042\u0006\u0010+\u001A\u00020\u0001H\u0002J\u000E\u00100\u001A\u00020\u00042\u0006\u0010+\u001A\u00020\u0001J)\u00101\u001A\u00020\u00042!\u00102\u001A\u001D\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\u001D0\u0003J\u0006\u00105\u001A\u00020\u001DJ\u0018\u00106\u001A\u00020\u00042\u0006\u0010+\u001A\u00020\u00012\u0006\u0010(\u001A\u00020\u0001H\u0002J\u0006\u00107\u001A\u00020\u0004J\u0014\u00108\u001A\u00020\u001D2\f\u00109\u001A\b\u0012\u0004\u0012\u00020\u00010:J\u0012\u0010;\u001A\u00020\u00042\n\u0010<\u001A\u0006\u0012\u0002\b\u00030\u0017J\u0006\u0010=\u001A\u00020\u0004R\u001D\u0010\u0002\u001A\u000E\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001A\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0082\u000E¢\u0006\u0002\n\u0000R\u001C\u0010\u000E\u001A\u000E\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u000FX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R \u0010\u0011\u001A\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000B0\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\u00010\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0015\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0018\u001A\u00020\u0019¢\u0006\b\n\u0000\u001A\u0004\b\u001A\u0010\u001BR\u001A\u0010\u001C\u001A\u00020\u001DX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001E\u0010\u001F\"\u0004\b \u0010!R\u000E\u0010\"\u001A\u00020\rX\u0082\u000E¢\u0006\u0002\n\u0000R \u0010#\u001A\u0012\u0012\u0004\u0012\u00020\u0001\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00170\u000FX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R6\u0010$\u001A*\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00010%j\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u0001`&X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006>"}, d2={"Landroidx/compose/runtime/snapshots/SnapshotStateObserver$ObservedScopeMap;", "", "onChanged", "Lkotlin/Function1;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getOnChanged", "()Lkotlin/jvm/functions/Function1;", "currentScope", "currentScopeReads", "Landroidx/collection/MutableObjectIntMap;", "currentToken", "", "valueToScopes", "Landroidx/compose/runtime/collection/ScopeMap;", "Landroidx/collection/MutableScatterMap;", "scopeToValues", "Landroidx/collection/MutableScatterMap;", "invalidated", "Landroidx/collection/MutableScatterSet;", "statesToReread", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/runtime/DerivedState;", "derivedStateObserver", "Landroidx/compose/runtime/DerivedStateObserver;", "getDerivedStateObserver", "()Landroidx/compose/runtime/DerivedStateObserver;", "readingDerivedStates", "", "getReadingDerivedStates", "()Z", "setReadingDerivedStates", "(Z)V", "deriveStateScopeCount", "dependencyToDerivedStates", "recordedDerivedStateValues", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "recordRead", "value", "recordedValues", "observe", "scope", "readObserver", "block", "Lkotlin/Function0;", "clearObsoleteStateReads", "clearScopeObservations", "removeScopeIf", "predicate", "Lkotlin/ParameterName;", "name", "hasScopeObservations", "removeObservation", "clear", "recordInvalidation", "changes", "", "rereadDerivedState", "derivedState", "notifyInvalidatedScopes", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) final class ObservedScopeMap {
        private Object currentScope;
        private MutableObjectIntMap currentScopeReads;
        private int currentToken;
        private final MutableScatterMap dependencyToDerivedStates;
        private int deriveStateScopeCount;
        private final DerivedStateObserver derivedStateObserver;
        private final MutableScatterSet invalidated;
        private final Function1 onChanged;
        private boolean readingDerivedStates;
        private final HashMap recordedDerivedStateValues;
        private final MutableScatterMap scopeToValues;
        private final MutableVector statesToReread;
        private final MutableScatterMap valueToScopes;

        public ObservedScopeMap(Function1 arg5) {
            super();
            this.onChanged = arg5;
            this.currentToken = -1;
            this.valueToScopes = ScopeMap.constructor-impl$default(null, 1, null);
            this.scopeToValues = new MutableScatterMap(0, 1, null);
            this.invalidated = new MutableScatterSet(0, 1, null);
            this.statesToReread = new MutableVector(new DerivedState[16], 0);
            this.derivedStateObserver = new SnapshotStateObserver$ObservedScopeMap$derivedStateObserver$1(this);
            this.dependencyToDerivedStates = ScopeMap.constructor-impl$default(null, 1, null);
            this.recordedDerivedStateValues = new HashMap();
        }

        public static final void access$clearObsoleteStateReads(ObservedScopeMap arg0, Object arg1) {
            arg0.clearObsoleteStateReads(arg1);
        }

        public static final Object access$getCurrentScope$p(ObservedScopeMap arg0) {
            return arg0.currentScope;
        }

        public static final MutableObjectIntMap access$getCurrentScopeReads$p(ObservedScopeMap arg0) {
            return arg0.currentScopeReads;
        }

        public static final int access$getCurrentToken$p(ObservedScopeMap arg0) {
            return arg0.currentToken;
        }

        public static final int access$getDeriveStateScopeCount$p(ObservedScopeMap arg0) {
            return arg0.deriveStateScopeCount;
        }

        public static final MutableScatterMap access$getScopeToValues$p(ObservedScopeMap arg0) {
            return arg0.scopeToValues;
        }

        public static final void access$setCurrentScope$p(ObservedScopeMap arg0, Object arg1) {
            arg0.currentScope = arg1;
        }

        public static final void access$setCurrentScopeReads$p(ObservedScopeMap arg0, MutableObjectIntMap arg1) {
            arg0.currentScopeReads = arg1;
        }

        public static final void access$setCurrentToken$p(ObservedScopeMap arg0, int arg1) {
            arg0.currentToken = arg1;
        }

        public static final void access$setDeriveStateScopeCount$p(ObservedScopeMap arg0, int arg1) {
            arg0.deriveStateScopeCount = arg1;
        }

        public final void clear() {
            ScopeMap.clear-impl(this.valueToScopes);
            this.scopeToValues.clear();
            ScopeMap.clear-impl(this.dependencyToDerivedStates);
            this.recordedDerivedStateValues.clear();
        }

        private final void clearObsoleteStateReads(Object arg17) {
            ObservedScopeMap v0 = this;
            int v1 = v0.currentToken;
            MutableObjectIntMap v2 = v0.currentScopeReads;
            if(v2 != null) {
                long[] v3 = v2.metadata;
                int v4 = v3.length - 2;
                if(v4 >= 0) {
                    int v6;
                    for(v6 = 0; true; ++v6) {
                        long v7 = v3[v6];
                        if((~v7 << 7 & v7 & -9187201950435737472L) != -9187201950435737472L) {
                            int v10 = 8;
                            int v9 = 8 - (~(v6 - v4) >>> 0x1F);
                            int v11;
                            for(v11 = 0; v11 < v9; ++v11) {
                                if((0xFF & v7) < 0x80) {
                                    int v12 = (v6 << 3) + v11;
                                    Object v13 = v2.keys[v12];
                                    int v14 = v2.values[v12] != v1 ? 1 : 0;
                                    Object v15 = arg17;
                                    if(v14 != 0) {
                                        v0.removeObservation(v15, v13);
                                    }

                                    if(v14 == 0) {
                                        goto label_47;
                                    }

                                    v2.removeValueAt(v12);
                                }

                            label_47:
                                v7 >>= v10;
                            }

                            if(v9 != v10) {
                                return;
                            }
                        }

                        if(v6 == v4) {
                            return;
                        }
                    }
                }
            }
        }

        public final void clearScopeObservations(Object arg18) {
            ObservedScopeMap v0 = this;
            Object v1 = arg18;
            Object v2 = v0.scopeToValues.remove(v1);
            if(v2 == null) {
            }
            else {
                Object[] v3 = ((ObjectIntMap)v2).keys;
                int[] v4 = ((ObjectIntMap)v2).values;
                long[] v2_1 = ((ObjectIntMap)v2).metadata;
                int v5 = v2_1.length - 2;
                if(v5 >= 0) {
                    int v7;
                    for(v7 = 0; true; ++v7) {
                        long v8 = v2_1[v7];
                        if((~v8 << 7 & v8 & -9187201950435737472L) != -9187201950435737472L) {
                            int v11 = 8;
                            int v10 = 8 - (~(v7 - v5) >>> 0x1F);
                            int v12;
                            for(v12 = 0; v12 < v10; ++v12) {
                                if((0xFF & v8) < 0x80) {
                                    v0.removeObservation(v1, v3[(v7 << 3) + v12]);
                                }

                                v8 >>= v11;
                            }

                            if(v10 != v11) {
                                return;
                            }
                        }

                        if(v7 == v5) {
                            return;
                        }
                    }
                }
            }
        }

        public final DerivedStateObserver getDerivedStateObserver() {
            return this.derivedStateObserver;
        }

        public final Function1 getOnChanged() {
            return this.onChanged;
        }

        public final boolean getReadingDerivedStates() {
            return this.readingDerivedStates;
        }

        public final boolean hasScopeObservations() {
            return this.scopeToValues.isNotEmpty();
        }

        public final void notifyInvalidatedScopes() {
            MutableScatterSet v0 = this.invalidated;
            Function1 v15 = this.onChanged;
            Object[] v2 = v0.elements;
            long[] v1 = v0.metadata;
            int v3 = v1.length - 2;
            if(v3 >= 0) {
                int v5;
                for(v5 = 0; true; ++v5) {
                    long v6 = v1[v5];
                    if((~v6 << 7 & v6 & -9187201950435737472L) != -9187201950435737472L) {
                        int v9 = 8;
                        int v8 = 8 - (~(v5 - v3) >>> 0x1F);
                        int v10;
                        for(v10 = 0; v10 < v8; ++v10) {
                            if((0xFF & v6) < 0x80) {
                                v15.invoke(v2[(v5 << 3) + v10]);
                            }

                            v6 >>= v9;
                        }

                        if(v8 != v9) {
                            break;
                        }
                    }

                    if(v5 == v3) {
                        break;
                    }
                }
            }

            v0.clear();
        }

        public final void observe(Object arg13, Function1 arg14, Function0 arg15) {
            Snapshot v14;
            Snapshot v13_1;
            Function1 v6;
            Function1 v4;
            Function1 v9;
            Object v5;
            Object v0 = this.currentScope;
            MutableObjectIntMap v1 = this.currentScopeReads;
            int v2 = this.currentToken;
            this.currentScope = arg13;
            this.currentScopeReads = this.scopeToValues.get(arg13);
            if(this.currentToken == -1) {
                this.currentToken = Long.hashCode(SnapshotKt.currentSnapshot().getSnapshotId());
            }

            DerivedStateObserver v13 = this.getDerivedStateObserver();
            MutableVector v3 = SnapshotStateKt.derivedStateObservers();
            try {
                v3.add(v13);
                if(arg14 == null) {
                    arg15.invoke();
                }
                else {
                    arg13 = SnapshotKt.threadSnapshot.get();
                    v5 = null;
                    v9 = null;
                    if(((arg13 instanceof TransparentObserverMutableSnapshot)) && arg13.getThreadId$runtime() == Thread_jvmKt.currentThreadId()) {
                        v4 = arg13.getReadObserver$runtime();
                        v6 = arg13.getWriteObserver$runtime();
                        goto label_35;
                    }

                    goto label_54;
                }

                goto label_74;
            }
            catch(Throwable v0_1) {
                goto label_96;
            }

            try {
            label_35:
                arg13.setReadObserver$runtime(SnapshotKt.mergedReadObserver$default(arg14, v4, false, 4, v5));
                arg13.setWriteObserver$runtime(SnapshotKt.mergedWriteObserver(v9, v6));
                arg15.invoke();
                goto label_44;
            }
            catch(Throwable v0_1) {
                try {
                    arg13.setReadObserver$runtime(v4);
                    ((TransparentObserverMutableSnapshot)arg13).setWriteObserver$runtime(v6);
                    throw v0_1;
                label_44:
                    arg13.setReadObserver$runtime(v4);
                    ((TransparentObserverMutableSnapshot)arg13).setWriteObserver$runtime(v6);
                    goto label_74;
                label_54:
                    if(arg13 == null || ((arg13 instanceof MutableSnapshot))) {
                        if((arg13 instanceof MutableSnapshot)) {
                            v5 = arg13;
                        }

                        Object v7 = v5;
                        TransparentObserverMutableSnapshot v13_2 = new TransparentObserverMutableSnapshot(((MutableSnapshot)v7), arg14, v9, true, false);
                    }
                    else {
                        v13_1 = ((Snapshot)arg13).takeNestedSnapshot(arg14);
                    }

                    try {
                        v14 = v13_1.makeCurrent();
                    }
                    catch(Throwable v0_1) {
                        goto label_89;
                    }
                }
                catch(Throwable v0_1) {
                    goto label_96;
                }
            }

            try {
                arg15.invoke();
                goto label_72;
            }
            catch(Throwable v0_1) {
                Throwable v12 = v0_1;
                try {
                    v13_1.restoreCurrent(v14);
                    throw v12;
                label_72:
                    v13_1.restoreCurrent(v14);
                    goto label_73;
                }
                catch(Throwable v0_1) {
                label_89:
                    v12 = v0_1;
                    try {
                        v13_1.dispose();
                        throw v12;
                    label_73:
                        v13_1.dispose();
                    }
                    catch(Throwable v0_1) {
                    label_96:
                        v3.removeAt(v3.getSize() - 1);
                        throw v0_1;
                    }
                }
            }

        label_74:
            v3.removeAt(v3.getSize() - 1);
            arg13 = this.currentScope;
            Intrinsics.checkNotNull(arg13);
            this.clearObsoleteStateReads(arg13);
            this.currentScope = v0;
            this.currentScopeReads = v1;
            this.currentToken = v2;
        }

        public final boolean recordInvalidation(Set arg45) {
            String v31;
            MutableScatterMap v30_1;
            Iterator v45_1;
            boolean v8_4;
            long v9_4;
            long[] v35_1;
            long v33_1;
            int v7_1;
            Object[] v28_3;
            int v32_1;
            Object[] v2_1;
            long v30;
            int v36;
            int v34;
            int v40;
            Object[] v29;
            long[] v28;
            long v10_1;
            Object v0_5;
            int v42;
            long v11_3;
            int v14;
            Object[] v11_2;
            long v37;
            int v35;
            int v9_1;
            int v6_1;
            int v0_4;
            Object v8_1;
            int v10;
            long v23;
            boolean v21;
            int v20;
            int v12;
            int v22;
            int v11;
            long[] v0_2;
            ObservedScopeMap v1 = this;
            Set v0 = arg45;
            MutableScatterMap v2 = v1.dependencyToDerivedStates;
            HashMap v3 = v1.recordedDerivedStateValues;
            MutableScatterMap v4 = v1.valueToScopes;
            MutableScatterSet v5 = v1.invalidated;
            String v7 = "null cannot be cast to non-null type androidx.compose.runtime.DerivedState<kotlin.Any?>";
            int v13 = 2;
            long v16 = 0x80;
            int v8 = 8;
            long v18 = 0xFF;
            if((v0 instanceof ScatterSetWrapper)) {
                ScatterSet v0_1 = ((ScatterSetWrapper)v0).getSet$runtime();
                Object[] v6 = v0_1.elements;
                v0_2 = v0_1.metadata;
                v11 = v0_2.length - v13;
                if(v11 >= 0) {
                    v22 = v13;
                    v12 = 0;
                    v20 = 7;
                    v21 = false;
                    v23 = -9187201950435737472L;
                    while(true) {
                        long v13_1 = v0_2[v12];
                        int v45 = v11;
                        if((~v13_1 << v20 & v13_1 & v23) != v23) {
                            v10 = 8 - (~(v12 - v45) >>> 0x1F);
                            v11 = 0;
                            while(v11 < v10) {
                                if((v13_1 & v18) < v16) {
                                    Object v15 = v6[(v12 << 3) + v11];
                                    int v25 = v8;
                                    if(!(v15 instanceof StateObjectImpl) || (v15.isReadIn-h_f27i8$runtime(ReaderKind.constructor-impl(v22)))) {
                                        if((v1.readingDerivedStates) || !ScopeMap.contains-impl(v2, v15)) {
                                            v28 = v0_2;
                                            v29 = v6;
                                            v40 = v10;
                                            v34 = v11;
                                            v36 = v12;
                                            v30 = v13_1;
                                        }
                                        else {
                                            v1.readingDerivedStates = true;
                                            try {
                                                v8_1 = v2.get(v15);
                                                if(v8_1 == null) {
                                                    goto label_263;
                                                }
                                                else if((v8_1 instanceof MutableScatterSet)) {
                                                    Object[] v9 = ((ScatterSet)v8_1).elements;
                                                    long[] v8_2 = ((ScatterSet)v8_1).metadata;
                                                    v28 = v0_2;
                                                    v0_4 = v8_2.length - 2;
                                                    v29 = v6;
                                                    if(v0_4 >= 0) {
                                                        v30 = v13_1;
                                                        v6_1 = 0;
                                                        while(true) {
                                                            v13_1 = v8_2[v6_1];
                                                            long[] v33 = v8_2;
                                                            Object[] v32 = v9;
                                                            if((~v13_1 << v20 & v13_1 & v23) != v23) {
                                                                v8 = 8 - (~(v6_1 - v0_4) >>> 0x1F);
                                                                v9_1 = 0;
                                                                while(v9_1 < v8) {
                                                                    if((v13_1 & v18) < v16) {
                                                                        v35 = v9_1;
                                                                        Object v9_2 = v32[(v6_1 << 3) + v9_1];
                                                                        Intrinsics.checkNotNull(v9_2, v7);
                                                                        v34 = v11;
                                                                        Object v11_1 = v3.get(v9_2);
                                                                        SnapshotMutationPolicy v36_1 = ((DerivedState)v9_2).getPolicy();
                                                                        if(v36_1 == null) {
                                                                            v36_1 = SnapshotStateKt.structuralEqualityPolicy();
                                                                        }

                                                                        v37 = v13_1;
                                                                        if(!v36_1.equivalent(((DerivedState)v9_2).getCurrentRecord().getCurrentValue(), v11_1)) {
                                                                            v9_2 = v4.get(v9_2);
                                                                            if(v9_2 == null) {
                                                                            label_161:
                                                                                v40 = v10;
                                                                                v36 = v12;
                                                                            }
                                                                            else if((v9_2 instanceof MutableScatterSet)) {
                                                                                v11_2 = ((ScatterSet)v9_2).elements;
                                                                                long[] v9_3 = ((ScatterSet)v9_2).metadata;
                                                                                v13 = v9_3.length - 2;
                                                                                if(v13 >= 0) {
                                                                                    Object[] v39 = v11_2;
                                                                                    v36 = v12;
                                                                                    v14 = 0;
                                                                                    while(true) {
                                                                                        v11_3 = v9_3[v14];
                                                                                        long[] v41 = v9_3;
                                                                                        v40 = v10;
                                                                                        if((~v11_3 << v20 & v11_3 & v23) != v23) {
                                                                                            v9_1 = 8 - (~(v14 - v13) >>> 0x1F);
                                                                                            for(v10 = 0; v10 < v9_1; v10 = v42 + 1) {
                                                                                                if((v11_3 & v18) < v16) {
                                                                                                    v42 = v10;
                                                                                                    v5.add(v39[(v14 << 3) + v10]);
                                                                                                    v21 = true;
                                                                                                }
                                                                                                else {
                                                                                                    v42 = v10;
                                                                                                }

                                                                                                v11_3 >>= v25;
                                                                                            }

                                                                                            if(v9_1 != v25) {
                                                                                                break;
                                                                                            }
                                                                                        }

                                                                                        if(v14 == v13) {
                                                                                            break;
                                                                                        }

                                                                                        ++v14;
                                                                                        v10 = v40;
                                                                                        v9_3 = v41;
                                                                                        v25 = 8;
                                                                                    }
                                                                                }
                                                                                else {
                                                                                    goto label_161;
                                                                                }
                                                                            }
                                                                            else {
                                                                                v40 = v10;
                                                                                v36 = v12;
                                                                                v5.add(v9_2);
                                                                                v21 = true;
                                                                            }

                                                                            goto label_176;
                                                                        }

                                                                        v40 = v10;
                                                                        v36 = v12;
                                                                        Boolean.valueOf(v1.statesToReread.add(v9_2));
                                                                    }
                                                                    else {
                                                                        v35 = v9_1;
                                                                        v40 = v10;
                                                                        v34 = v11;
                                                                        v36 = v12;
                                                                        v37 = v13_1;
                                                                    }

                                                                label_176:
                                                                    v13_1 = v37 >> 8;
                                                                    v9_1 = v35 + 1;
                                                                    v25 = 8;
                                                                    v11 = v34;
                                                                    v12 = v36;
                                                                    v10 = v40;
                                                                }

                                                                v40 = v10;
                                                                v34 = v11;
                                                                v36 = v12;
                                                                if(v8 != v25) {
                                                                    goto label_269;
                                                                }
                                                            }
                                                            else {
                                                                v40 = v10;
                                                                v34 = v11;
                                                                v36 = v12;
                                                            }

                                                            if(v6_1 == v0_4) {
                                                                goto label_269;
                                                            }

                                                            ++v6_1;
                                                            v9 = v32;
                                                            v8_2 = v33;
                                                            v11 = v34;
                                                            v12 = v36;
                                                            v10 = v40;
                                                            v25 = 8;
                                                        }
                                                    }
                                                    else {
                                                        goto label_265;
                                                    }
                                                }
                                                else {
                                                    v28 = v0_2;
                                                    v29 = v6;
                                                    v40 = v10;
                                                    v34 = v11;
                                                    v36 = v12;
                                                    v30 = v13_1;
                                                    v0_5 = v3.get(v8_1);
                                                    SnapshotMutationPolicy v6_2 = ((DerivedState)v8_1).getPolicy();
                                                    if(v6_2 == null) {
                                                        v6_2 = SnapshotStateKt.structuralEqualityPolicy();
                                                    }

                                                    if(!v6_2.equivalent(((DerivedState)v8_1).getCurrentRecord().getCurrentValue(), v0_5)) {
                                                        v0_5 = v4.get(v8_1);
                                                        if(v0_5 != null) {
                                                            if((v0_5 instanceof MutableScatterSet)) {
                                                                v6 = ((ScatterSet)v0_5).elements;
                                                                v0_2 = ((ScatterSet)v0_5).metadata;
                                                                v8 = v0_2.length - 2;
                                                                if(v8 >= 0) {
                                                                    for(v9_1 = 0; true; ++v9_1) {
                                                                        v10_1 = v0_2[v9_1];
                                                                        if((~v10_1 << v20 & v10_1 & v23) != v23) {
                                                                            v12 = 8 - (~(v9_1 - v8) >>> 0x1F);
                                                                            for(v13 = 0; v13 < v12; ++v13) {
                                                                                if((v10_1 & v18) < v16) {
                                                                                    v5.add(v6[(v9_1 << 3) + v13]);
                                                                                    v21 = true;
                                                                                }

                                                                                v10_1 >>= 8;
                                                                            }

                                                                            if(v12 != 8) {
                                                                                break;
                                                                            }
                                                                        }

                                                                        if(v9_1 == v8) {
                                                                            break;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            else {
                                                                v5.add(v0_5);
                                                                v21 = true;
                                                            }
                                                        }

                                                        goto label_269;
                                                    }

                                                    Boolean.valueOf(v1.statesToReread.add(v8_1));
                                                }

                                                goto label_269;
                                            }
                                            catch(Throwable v0_3) {
                                                v1.readingDerivedStates = false;
                                                throw v0_3;
                                            }

                                        label_263:
                                            v28 = v0_2;
                                            v29 = v6;
                                        label_265:
                                            v40 = v10;
                                            v34 = v11;
                                            v36 = v12;
                                            v30 = v13_1;
                                        label_269:
                                            v1.readingDerivedStates = false;
                                        }

                                        v0_5 = v4.get(v15);
                                        if(v0_5 == null) {
                                            goto label_323;
                                        }

                                        if((v0_5 instanceof MutableScatterSet)) {
                                            Object[] v8_3 = ((ScatterSet)v0_5).elements;
                                            v0_2 = ((ScatterSet)v0_5).metadata;
                                            v9_1 = v0_2.length - 2;
                                            if(v9_1 < 0) {
                                                goto label_323;
                                            }

                                            for(v10 = 0; true; ++v10) {
                                                v11_3 = v0_2[v10];
                                                if((~v11_3 << v20 & v11_3 & v23) != v23) {
                                                    v13 = 8 - (~(v10 - v9_1) >>> 0x1F);
                                                    for(v14 = 0; v14 < v13; ++v14) {
                                                        if((v11_3 & v18) < v16) {
                                                            v5.add(v8_3[(v10 << 3) + v14]);
                                                            v21 = true;
                                                        }

                                                        v11_3 >>= 8;
                                                    }

                                                    if(v13 != 8) {
                                                        goto label_323;
                                                    }
                                                }

                                                if(v10 == v9_1) {
                                                    goto label_323;
                                                }
                                            }
                                        }

                                        v5.add(v0_5);
                                        v21 = true;
                                    }
                                    else {
                                        v28 = v0_2;
                                        v29 = v6;
                                        v40 = v10;
                                        v34 = v11;
                                        v36 = v12;
                                        v30 = v13_1;
                                    }

                                label_323:
                                    v10 = 8;
                                }
                                else {
                                    v28 = v0_2;
                                    v29 = v6;
                                    v40 = v10;
                                    v34 = v11;
                                    v36 = v12;
                                    v30 = v13_1;
                                    v10 = v8;
                                }

                                v13_1 = v30 >> v10;
                                v11 = v34 + 1;
                                v8 = v10;
                                v0_2 = v28;
                                v6 = v29;
                                v12 = v36;
                                v10 = v40;
                            }

                            int v28_1 = v10;
                            v10 = v8;
                            v8 = v28_1;
                            v28 = v0_2;
                            v29 = v6;
                            v36 = v12;
                            if(v8 != v10) {
                                break;
                            }

                            v10 = v36;
                        }
                        else {
                            v28 = v0_2;
                            v29 = v6;
                            v10 = v12;
                        }

                        v11 = v45;
                        if(v10 == v11) {
                            break;
                        }

                        v12 = v10 + 1;
                        v0_2 = v28;
                        v6 = v29;
                        v8 = 8;
                    }
                }
                else {
                    v21 = false;
                }
            }
            else {
                v22 = v13;
                v20 = 7;
                v23 = -9187201950435737472L;
                Iterator v0_6 = ((Iterable)v0).iterator();
                boolean v26 = false;
                while(v0_6.hasNext()) {
                    v8_1 = v0_6.next();
                    if(!(v8_1 instanceof StateObjectImpl) || (v8_1.isReadIn-h_f27i8$runtime(ReaderKind.constructor-impl(v22)))) {
                        if((v1.readingDerivedStates) || !ScopeMap.contains-impl(v2, v8_1)) {
                            v45_1 = v0_6;
                            v30_1 = v2;
                            v31 = v7;
                            v6_1 = 0;
                        }
                        else {
                            v1.readingDerivedStates = true;
                            try {
                                Object v10_2 = v2.get(v8_1);
                                if(v10_2 == null) {
                                    goto label_593;
                                }
                                else if((v10_2 instanceof MutableScatterSet)) {
                                    v11_2 = ((ScatterSet)v10_2).elements;
                                    long[] v10_3 = ((ScatterSet)v10_2).metadata;
                                    v12 = v10_3.length - 2;
                                    if(v12 >= 0) {
                                        v13 = 0;
                                        while(true) {
                                            long v14_1 = v10_3[v13];
                                            long[] v21_1 = v10_3;
                                            if((~v14_1 << v20 & v14_1 & v23) != v23) {
                                                v9_1 = 8 - (~(v13 - v12) >>> 0x1F);
                                                v10 = 0;
                                                while(v10 < v9_1) {
                                                    if((v14_1 & v18) < v16) {
                                                        Object v6_3 = v11_2[(v13 << 3) + v10];
                                                        Intrinsics.checkNotNull(v6_3, v7);
                                                        v45_1 = v0_6;
                                                        v0_5 = v3.get(v6_3);
                                                        SnapshotMutationPolicy v28_2 = ((DerivedState)v6_3).getPolicy();
                                                        if(v28_2 == null) {
                                                            v28_2 = SnapshotStateKt.structuralEqualityPolicy();
                                                        }

                                                        v30_1 = v2;
                                                        v31 = v7;
                                                        if(!v28_2.equivalent(((DerivedState)v6_3).getCurrentRecord().getCurrentValue(), v0_5)) {
                                                            v0_5 = v4.get(v6_3);
                                                            if(v0_5 == null) {
                                                            label_488:
                                                                v32_1 = v10;
                                                                v28_3 = v11_2;
                                                                v33_1 = v14_1;
                                                            }
                                                            else if((v0_5 instanceof MutableScatterSet)) {
                                                                v2_1 = ((ScatterSet)v0_5).elements;
                                                                v0_2 = ((ScatterSet)v0_5).metadata;
                                                                v6_1 = v0_2.length - 2;
                                                                if(v6_1 >= 0) {
                                                                    v32_1 = v10;
                                                                    v28_3 = v11_2;
                                                                    v7_1 = 0;
                                                                    while(true) {
                                                                        v10_1 = v0_2[v7_1];
                                                                        v33_1 = v14_1;
                                                                        if((~v10_1 << v20 & v10_1 & v23) != v23) {
                                                                            v14 = 8 - (~(v7_1 - v6_1) >>> 0x1F);
                                                                            int v15_1 = 0;
                                                                            while(v15_1 < v14) {
                                                                                if((v10_1 & v18) < v16) {
                                                                                    v35_1 = v0_2;
                                                                                    v5.add(v2_1[(v7_1 << 3) + v15_1]);
                                                                                    v26 = true;
                                                                                }
                                                                                else {
                                                                                    v35_1 = v0_2;
                                                                                }

                                                                                v10_1 >>= 8;
                                                                                ++v15_1;
                                                                                v0_2 = v35_1;
                                                                            }

                                                                            v35_1 = v0_2;
                                                                            if(v14 != 8) {
                                                                                break;
                                                                            }
                                                                        }
                                                                        else {
                                                                            v35_1 = v0_2;
                                                                        }

                                                                        if(v7_1 == v6_1) {
                                                                            break;
                                                                        }

                                                                        ++v7_1;
                                                                        v14_1 = v33_1;
                                                                        v0_2 = v35_1;
                                                                    }
                                                                }
                                                                else {
                                                                    goto label_488;
                                                                }
                                                            }
                                                            else {
                                                                v32_1 = v10;
                                                                v28_3 = v11_2;
                                                                v33_1 = v14_1;
                                                                v5.add(v0_5);
                                                                v26 = true;
                                                            }

                                                            goto label_506;
                                                        }

                                                        v32_1 = v10;
                                                        v28_3 = v11_2;
                                                        v33_1 = v14_1;
                                                        Boolean.valueOf(v1.statesToReread.add(v6_3));
                                                    }
                                                    else {
                                                        v45_1 = v0_6;
                                                        v30_1 = v2;
                                                        v31 = v7;
                                                        v32_1 = v10;
                                                        v28_3 = v11_2;
                                                        v33_1 = v14_1;
                                                    }

                                                label_506:
                                                    v14_1 = v33_1 >> 8;
                                                    v10 = v32_1 + 1;
                                                    v11_2 = v28_3;
                                                    v2 = v30_1;
                                                    v7 = v31;
                                                    v0_6 = v45_1;
                                                }

                                                v45_1 = v0_6;
                                                v30_1 = v2;
                                                v31 = v7;
                                                v28_3 = v11_2;
                                                if(v9_1 != 8) {
                                                    goto label_596;
                                                }
                                            }
                                            else {
                                                v45_1 = v0_6;
                                                v30_1 = v2;
                                                v31 = v7;
                                                v28_3 = v11_2;
                                            }

                                            if(v13 == v12) {
                                                goto label_596;
                                            }

                                            ++v13;
                                            v0_6 = v45_1;
                                            v10_3 = v21_1;
                                            v11_2 = v28_3;
                                            v2 = v30_1;
                                            v7 = v31;
                                        }
                                    }
                                    else {
                                        goto label_593;
                                    }
                                }
                                else {
                                    v45_1 = v0_6;
                                    v30_1 = v2;
                                    v31 = v7;
                                    v0_5 = v3.get(v10_2);
                                    SnapshotMutationPolicy v2_2 = ((DerivedState)v10_2).getPolicy();
                                    if(v2_2 == null) {
                                        v2_2 = SnapshotStateKt.structuralEqualityPolicy();
                                    }

                                    if(!v2_2.equivalent(((DerivedState)v10_2).getCurrentRecord().getCurrentValue(), v0_5)) {
                                        v0_5 = v4.get(v10_2);
                                        if(v0_5 != null) {
                                            if((v0_5 instanceof MutableScatterSet)) {
                                                v2_1 = ((ScatterSet)v0_5).elements;
                                                v0_2 = ((ScatterSet)v0_5).metadata;
                                                v6_1 = v0_2.length - 2;
                                                if(v6_1 >= 0) {
                                                    for(v7_1 = 0; true; ++v7_1) {
                                                        v9_4 = v0_2[v7_1];
                                                        if((~v9_4 << v20 & v9_4 & v23) != v23) {
                                                            v11 = 8 - (~(v7_1 - v6_1) >>> 0x1F);
                                                            for(v12 = 0; v12 < v11; ++v12) {
                                                                if((v9_4 & v18) < v16) {
                                                                    v5.add(v2_1[(v7_1 << 3) + v12]);
                                                                    v26 = true;
                                                                }

                                                                v9_4 >>= 8;
                                                            }

                                                            if(v11 != 8) {
                                                                break;
                                                            }
                                                        }

                                                        if(v7_1 == v6_1) {
                                                            break;
                                                        }
                                                    }
                                                }
                                            }
                                            else {
                                                v5.add(v0_5);
                                                v26 = true;
                                            }
                                        }

                                        goto label_596;
                                    }

                                    Boolean.valueOf(v1.statesToReread.add(v10_2));
                                }

                                goto label_596;
                            }
                            catch(Throwable v0_3) {
                                v1.readingDerivedStates = false;
                                throw v0_3;
                            }

                        label_593:
                            v45_1 = v0_6;
                            v30_1 = v2;
                            v31 = v7;
                        label_596:
                            v6_1 = 0;
                            v1.readingDerivedStates = false;
                        }

                        v0_5 = v4.get(v8_1);
                        if(v0_5 == null) {
                        label_653:
                            v8_4 = v26;
                        }
                        else if((v0_5 instanceof MutableScatterSet)) {
                            v2_1 = ((ScatterSet)v0_5).elements;
                            v0_2 = ((ScatterSet)v0_5).metadata;
                            v7_1 = v0_2.length - 2;
                            if(v7_1 >= 0) {
                                for(v8 = v6_1; true; ++v8) {
                                    v9_4 = v0_2[v8];
                                    if((~v9_4 << v20 & v9_4 & v23) != v23) {
                                        v11 = 8 - (~(v8 - v7_1) >>> 0x1F);
                                        for(v12 = v6_1; v12 < v11; ++v12) {
                                            if((v9_4 & v18) < v16) {
                                                v5.add(v2_1[(v8 << 3) + v12]);
                                                v26 = true;
                                            }

                                            v9_4 >>= 8;
                                        }

                                        if(v11 != 8) {
                                            goto label_653;
                                        }
                                    }

                                    if(v8 == v7_1) {
                                        goto label_653;
                                    }
                                }
                            }
                            else {
                                goto label_653;
                            }
                        }
                        else {
                            v5.add(v0_5);
                            v8_4 = true;
                        }

                        v26 = v8_4;
                    }
                    else {
                        v45_1 = v0_6;
                        v30_1 = v2;
                        v31 = v7;
                    }

                    v0_6 = v45_1;
                    v2 = v30_1;
                    v7 = v31;
                }

                v21 = v26;
            }

            if(!v1.readingDerivedStates && v1.statesToReread.getSize() != 0) {
                MutableVector v0_7 = v1.statesToReread;
                v2_1 = v0_7.content;
                v0_4 = v0_7.getSize();
                for(v10 = 0; v10 < v0_4; ++v10) {
                    v1.rereadDerivedState(v2_1[v10]);
                }

                v1.statesToReread.clear();
            }

            return v21;
        }

        public final void recordRead(Object arg7) {
            Object v0 = this.currentScope;
            Intrinsics.checkNotNull(v0);
            int v1 = this.currentToken;
            MutableObjectIntMap v2 = this.currentScopeReads;
            if(v2 == null) {
                v2 = new MutableObjectIntMap(0, 1, null);
                this.currentScopeReads = v2;
                this.scopeToValues.set(v0, v2);
            }

            this.recordRead(arg7, v1, v0, v2);
        }

        private final void recordRead(Object arg21, int arg22, Object arg23, MutableObjectIntMap arg24) {
            int v24;
            ObservedScopeMap v0 = this;
            Object v1 = arg21;
            int v2 = arg22;
            if(v0.deriveStateScopeCount > 0) {
            }
            else {
                int v3 = -1;
                int v4 = arg24.put(v1, v2, v3);
                int v6 = 2;
                if(!(v1 instanceof DerivedState) || v4 == v2) {
                    v24 = v6;
                    v2 = v3;
                }
                else {
                    Record v2_1 = v1.getCurrentRecord();
                    v0.recordedDerivedStateValues.put(v1, v2_1.getCurrentValue());
                    ObjectIntMap v2_2 = v2_1.getDependencies();
                    MutableScatterMap v5 = v0.dependencyToDerivedStates;
                    ScopeMap.removeScope-impl(v5, v1);
                    Object[] v7 = v2_2.keys;
                    long[] v2_3 = v2_2.metadata;
                    int v8 = v2_3.length - v6;
                    if(v8 >= 0) {
                        int v10 = 0;
                        while(true) {
                            long v11 = v2_3[v10];
                            if((~v11 << 7 & v11 & -9187201950435737472L) != -9187201950435737472L) {
                                int v14 = 8;
                                int v13 = 8 - (~(v10 - v8) >>> 0x1F);
                                int v15 = 0;
                                while(v15 < v13) {
                                    if((v11 & 0xFF) < 0x80) {
                                        v24 = v6;
                                        Object v6_1 = v7[(v10 << 3) + v15];
                                        if((v6_1 instanceof StateObjectImpl)) {
                                            v6_1.recordReadIn-h_f27i8$runtime(ReaderKind.constructor-impl(v24));
                                        }

                                        ScopeMap.add-impl(v5, v6_1, v1);
                                    }
                                    else {
                                        v24 = v6;
                                    }

                                    v11 >>= v14;
                                    ++v15;
                                    v6 = v24;
                                }

                                v24 = v6;
                                if(v13 != v14) {
                                    break;
                                }
                            }
                            else {
                                v24 = v6;
                            }

                            if(v10 == v8) {
                                break;
                            }

                            ++v10;
                            v6 = v24;
                        }
                    }
                    else {
                        v24 = v6;
                    }

                    v2 = -1;
                }

                if(v4 != v2) {
                    return;
                }

                if((v1 instanceof StateObjectImpl)) {
                    v1.recordReadIn-h_f27i8$runtime(ReaderKind.constructor-impl(v24));
                }

                ScopeMap.add-impl(v0.valueToScopes, v1, arg23);
            }
        }

        private final void removeObservation(Object arg2, Object arg3) {
            ScopeMap.remove-impl(this.valueToScopes, arg3, arg2);
            if(((arg3 instanceof DerivedState)) && !ScopeMap.contains-impl(this.valueToScopes, arg3)) {
                ScopeMap.removeScope-impl(this.dependencyToDerivedStates, arg3);
                this.recordedDerivedStateValues.remove(arg3);
            }
        }

        public final void removeScopeIf(Function1 arg34) {
            int v6_1;
            long v31;
            long v27;
            long[] v26;
            long v20;
            int v16;
            ObservedScopeMap v0 = this;
            MutableScatterMap v1 = v0.scopeToValues;
            long[] v2 = v1.metadata;
            int v3 = v2.length - 2;
            if(v3 >= 0) {
                int v5 = 0;
                while(true) {
                    long v6 = v2[v5];
                    int v10 = 7;
                    long v11 = -9187201950435737472L;
                    if((~v6 << v10 & v6 & v11) != v11) {
                        int v9 = 8;
                        int v8 = 8 - (~(v5 - v3) >>> 0x1F);
                        int v13 = 0;
                        while(v13 < v8) {
                            long v14 = 0xFF;
                            long v18 = 0x80;
                            if((v6 & v14) < v18) {
                                int v4 = (v5 << 3) + v13;
                                v16 = v10;
                                Object v10_1 = v1.keys[v4];
                                v20 = v11;
                                Object v11_1 = v1.values[v4];
                                Object v22 = arg34.invoke(v10_1);
                                if(((Boolean)v22).booleanValue()) {
                                    long v23 = v14;
                                    Object[] v14_1 = ((ObjectIntMap)v11_1).keys;
                                    int[] v15 = ((ObjectIntMap)v11_1).values;
                                    long[] v11_2 = ((ObjectIntMap)v11_1).metadata;
                                    int v25 = v9;
                                    v9 = v11_2.length - 2;
                                    if(v9 >= 0) {
                                        v26 = v2;
                                        v27 = v6;
                                        int v2_1 = 0;
                                        while(true) {
                                            v6 = v11_2[v2_1];
                                            long[] v29 = v11_2;
                                            if((~v6 << v16 & v6 & v20) != v20) {
                                                int v11_3 = 8 - (~(v2_1 - v9) >>> 0x1F);
                                                int v12;
                                                for(v12 = 0; v12 < v11_3; ++v12) {
                                                    if((v6 & v23) < v18) {
                                                        v31 = v6;
                                                        v0.removeObservation(v10_1, v14_1[(v2_1 << 3) + v12]);
                                                    }
                                                    else {
                                                        v31 = v6;
                                                    }

                                                    v6 = v31 >> v25;
                                                }

                                                if(v11_3 != v25) {
                                                    break;
                                                }
                                            }

                                            if(v2_1 == v9) {
                                                break;
                                            }

                                            ++v2_1;
                                            v11_2 = v29;
                                            v25 = 8;
                                        }
                                    }
                                    else {
                                        goto label_84;
                                    }
                                }
                                else {
                                label_84:
                                    v26 = v2;
                                    v27 = v6;
                                }

                                if(((Boolean)v22).booleanValue()) {
                                    v1.removeValueAt(v4);
                                }

                                v6_1 = 8;
                            }
                            else {
                                v26 = v2;
                                v27 = ((long)v6_1);
                                v16 = v10;
                                v20 = v11;
                                v6_1 = v9;
                            }

                            ++v13;
                            v9 = v6_1;
                            v6 = v27 >> v6_1;
                            v10 = v16;
                            v11 = v20;
                            v2 = v26;
                        }

                        v26 = v2;
                        if(v8 != v9) {
                            return;
                        }
                    }
                    else {
                        v26 = v2;
                    }

                    if(v5 == v3) {
                        return;
                    }

                    ++v5;
                    v2 = v26;
                }
            }
        }

        public final void rereadDerivedState(DerivedState arg21) {
            long[] v18;
            int v17;
            ObservedScopeMap v0 = this;
            DerivedState v1 = arg21;
            MutableScatterMap v2 = v0.scopeToValues;
            int v3 = Long.hashCode(SnapshotKt.currentSnapshot().getSnapshotId());
            Object v4 = v0.valueToScopes.get(v1);
            if(v4 != null) {
                DefaultConstructorMarker v6 = null;
                if((v4 instanceof MutableScatterSet)) {
                    Object[] v5 = ((ScatterSet)v4).elements;
                    long[] v4_1 = ((ScatterSet)v4).metadata;
                    int v9 = v4_1.length - 2;
                    if(v9 >= 0) {
                        int v10 = 0;
                        while(true) {
                            long v11 = v4_1[v10];
                            if((~v11 << 7 & v11 & -9187201950435737472L) != -9187201950435737472L) {
                                int v14 = 8;
                                int v13 = 8 - (~(v10 - v9) >>> 0x1F);
                                int v15 = 0;
                                while(v15 < v13) {
                                    if((v11 & 0xFF) < 0x80) {
                                        v17 = v14;
                                        Object v14_1 = v5[(v10 << 3) + v15];
                                        Object v16 = v2.get(v14_1);
                                        v18 = v4_1;
                                        if(v16 == null) {
                                            MutableObjectIntMap v4_2 = new MutableObjectIntMap(0, 1, v6);
                                            v2.set(v14_1, v4_2);
                                        }
                                        else {
                                            v4 = v16;
                                        }

                                        v0.recordRead(v1, v3, v14_1, ((MutableObjectIntMap)v4));
                                    }
                                    else {
                                        v18 = v4_1;
                                        v17 = v14;
                                    }

                                    v11 >>= v17;
                                    ++v15;
                                    v14 = v17;
                                    v4_1 = v18;
                                }

                                v18 = v4_1;
                                if(v13 != v14) {
                                    return;
                                }
                            }
                            else {
                                v18 = v4_1;
                            }

                            if(v10 == v9) {
                                return;
                            }

                            ++v10;
                            v4_1 = v18;
                        }
                    }
                }
                else {
                    Object v5_1 = v2.get(v4);
                    if(v5_1 == null) {
                        MutableObjectIntMap v5_2 = new MutableObjectIntMap(0, 1, v6);
                        v2.set(v4, v5_2);
                    }

                    v0.recordRead(v1, v3, v4, ((MutableObjectIntMap)v5_1));
                }
            }
        }

        public final void setReadingDerivedStates(boolean arg1) {
            this.readingDerivedStates = arg1;
        }
    }

    public static final int $stable = 8;
    private final Function2 applyObserver;
    private ObserverHandle applyUnsubscribe;
    private ObservedScopeMap currentMap;
    private long currentMapThreadId;
    private boolean isPaused;
    private final MutableVector observedScopeMaps;
    private final Object observedScopeMapsLock;
    private final Function1 onChangedExecutor;
    private final AtomicReference pendingChanges;
    private final Function1 readObserver;
    private boolean sendingNotifications;

    static {
    }

    public SnapshotStateObserver(Function1 arg3) {
        super();
        this.onChangedExecutor = arg3;
        this.pendingChanges = new AtomicReference(null);
        this.applyObserver = new SnapshotStateObserver$$ExternalSyntheticLambda1(this);
        this.readObserver = new SnapshotStateObserver$$ExternalSyntheticLambda2(this);
        this.observedScopeMaps = new MutableVector(new ObservedScopeMap[16], 0);
        this.observedScopeMapsLock = new Object();
        this.currentMapThreadId = -1;
    }

    private final void addChanges(Set arg4) {
        List v1_1;
        do {
            Object v0 = this.pendingChanges.get();
            if(v0 == null) {
                Set v1 = arg4;
            }
            else if((v0 instanceof Set)) {
                v1_1 = CollectionsKt.listOf(new Set[]{v0, arg4});
            }
            else if((v0 instanceof List)) {
                v1_1 = CollectionsKt.plus(v0, CollectionsKt.listOf(arg4));
            }
            else {
                goto label_24;
            }
        }
        while(!MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(this.pendingChanges, v0, v1));

        return;
    label_24:
        this.report();
        throw new KotlinNothingValueException();
    }

    static final Unit applyObserver$lambda$0(SnapshotStateObserver arg0, Set arg1, Snapshot arg2) {
        arg0.addChanges(arg1);
        if(arg0.drainChanges()) {
            arg0.sendNotifications();
        }

        return Unit.INSTANCE;
    }

    public final void clear() {
        Object v0 = this.observedScopeMapsLock;
        __monitor_enter(v0);
        try {
            MutableVector v4_1 = this.observedScopeMaps;
            Object[] v1 = v4_1.content;
            int v4_2 = v4_1.getSize();
            int v2;
            for(v2 = 0; v2 < v4_2; ++v2) {
                v1[v2].clear();
            }
        }
        catch(Throwable v4) {
            goto label_15;
        }

        __monitor_exit(v0);
        return;
    label_15:
        __monitor_exit(v0);
        throw v4;
    }

    public final void clear(Object arg8) {
        Object v0 = this.observedScopeMapsLock;
        __monitor_enter(v0);
        try {
            MutableVector v7_1 = this.observedScopeMaps;
            int v1 = v7_1.getSize();
            int v2 = 0;
            int v3 = 0;
            while(v2 < v1) {
                Object v4 = v7_1.content[v2];
                ((ObservedScopeMap)v4).clearScopeObservations(arg8);
                if(!((ObservedScopeMap)v4).hasScopeObservations()) {
                    ++v3;
                }
                else if(v3 > 0) {
                    v7_1.content[v2 - v3] = v7_1.content[v2];
                }

                ++v2;
            }

            v2 = v1 - v3;
            ArraysKt.fill(v7_1.content, null, v2, v1);
            v7_1.setSize(v2);
        }
        catch(Throwable v7) {
            goto label_31;
        }

        __monitor_exit(v0);
        return;
    label_31:
        __monitor_exit(v0);
        throw v7;
    }

    public final void clearIf(Function1 arg8) {
        Object v0 = this.observedScopeMapsLock;
        __monitor_enter(v0);
        try {
            MutableVector v7_1 = this.observedScopeMaps;
            int v1 = v7_1.getSize();
            int v2 = 0;
            int v3 = 0;
            while(v2 < v1) {
                Object v4 = v7_1.content[v2];
                ((ObservedScopeMap)v4).removeScopeIf(arg8);
                if(!((ObservedScopeMap)v4).hasScopeObservations()) {
                    ++v3;
                }
                else if(v3 > 0) {
                    v7_1.content[v2 - v3] = v7_1.content[v2];
                }

                ++v2;
            }

            v2 = v1 - v3;
            ArraysKt.fill(v7_1.content, null, v2, v1);
            v7_1.setSize(v2);
        }
        catch(Throwable v7) {
            goto label_31;
        }

        __monitor_exit(v0);
        return;
    label_31:
        __monitor_exit(v0);
        throw v7;
    }

    private final boolean drainChanges() {
        Object v3;
        boolean v1;
        Object v0 = this.observedScopeMapsLock;
        __monitor_enter(v0);
        try {
            v1 = this.sendingNotifications;
        }
        catch(Throwable v8) {
            __monitor_exit(v0);
            throw v8;
        }

        __monitor_exit(v0);
        if(v1) {
            return 0;
        }

        v1 = false;
        while(true) {
            Set v2 = this.removeChanges();
            if(v2 == null) {
                return v1;
            }

            v3 = this.observedScopeMapsLock;
            __monitor_enter(v3);
            try {
                MutableVector v4 = this.observedScopeMaps;
                Object[] v5 = v4.content;
                int v4_1 = v4.getSize();
                int v6;
                for(v6 = 0; v6 < v4_1; ++v6) {
                    v1 = (v5[v6].recordInvalidation(v2)) || (v1) ? true : false;
                }
            }
            catch(Throwable v8) {
                break;
            }

            __monitor_exit(v3);
        }

        __monitor_exit(v3);
        throw v8;
        return v1;
    }

    private final ObservedScopeMap ensureMap(Function1 arg6) {
        Object v3;
        MutableVector v0 = this.observedScopeMaps;
        Object[] v1 = v0.content;
        int v0_1 = v0.getSize();
        int v2 = 0;
        while(true) {
            if(v2 < v0_1) {
                v3 = v1[v2];
                if(v3.getOnChanged() == arg6) {
                }
                else {
                    ++v2;
                    continue;
                }
            }
            else {
                break;
            }

            goto label_13;
        }

        v3 = null;
    label_13:
        if(v3 == null) {
            Intrinsics.checkNotNull(arg6, "null cannot be cast to non-null type kotlin.Function1<kotlin.Any, kotlin.Unit>");
            ObservedScopeMap v0_2 = new ObservedScopeMap(TypeIntrinsics.beforeCheckcastToFunctionOfArity(arg6, 1));
            this.observedScopeMaps.add(v0_2);
            return v0_2;
        }

        return ((ObservedScopeMap)v3);
    }

    private final void forEachScopeMap(Function1 arg5) {
        Object v0 = this.observedScopeMapsLock;
        __monitor_enter(v0);
        try {
            MutableVector v4_1 = this.observedScopeMaps;
            Object[] v1 = v4_1.content;
            int v4_2 = v4_1.getSize();
            int v2;
            for(v2 = 0; v2 < v4_2; ++v2) {
                arg5.invoke(v1[v2]);
            }
        }
        catch(Throwable v4) {
            goto label_15;
        }

        __monitor_exit(v0);
        return;
    label_15:
        __monitor_exit(v0);
        throw v4;
    }

    public final void notifyChanges(Set arg1, Snapshot arg2) {
        this.applyObserver.invoke(arg1, arg2);
    }

    public final void observeReads(Object arg23, Function1 arg24, Function0 arg25) {
        Snapshot v10_1;
        Snapshot v0_3;
        Function1 v15_1;
        Function1 v11;
        Function1 v10;
        Object v15;
        Object v13;
        MutableVector v9;
        long v18;
        MutableVector v12;
        DerivedStateObserver v0_2;
        MutableObjectIntMap v3;
        Object v2_1;
        Function1 v14;
        int v4_1;
        long v8;
        ObservedScopeMap v7;
        boolean v6;
        ObservedScopeMap v5_1;
        SnapshotStateObserver v1 = this;
        Object v0 = arg23;
        long v2 = Thread_jvmKt.currentThreadId();
        Object v4 = v1.observedScopeMapsLock;
        __monitor_enter(v4);
        Function1 v5 = arg24;
        try {
            v5_1 = v1.ensureMap(v5);
            v6 = v1.isPaused;
            v7 = v1.currentMap;
            v8 = v1.currentMapThreadId;
        }
        catch(Throwable v0_1) {
            goto label_212;
        }

        __monitor_exit(v4);
        if(Long.compare(v8, -1) != 0) {
            v4_1 = v8 == v2 ? 1 : 0;
            if(v4_1 != 0) {
                goto label_36;
            }

            PreconditionsKt.throwIllegalArgumentException("Detected multithreaded access to SnapshotStateObserver: previousThreadId=" + v8 + "), currentThread={id=" + v2 + ", name=" + Thread_jvmKt.currentThreadName() + "}. Note that observation on multiple threads in layout/draw is not supported. Make sure your measure/layout/draw for each Owner (AndroidComposeView) is executed on the same thread.");
        }

        try {
        label_36:
            v4 = v1.observedScopeMapsLock;
            __monitor_enter(v4);
        }
        catch(Throwable v0_1) {
            goto label_198;
        }

        try {
            v1.isPaused = false;
            v1.currentMap = v5_1;
            v1.currentMapThreadId = v2;
        }
        catch(Throwable v0_1) {
            goto label_192;
        }

        try {
            __monitor_exit(v4);
            v14 = v1.readObserver;
            v2_1 = ObservedScopeMap.access$getCurrentScope$p(v5_1);
            v3 = ObservedScopeMap.access$getCurrentScopeReads$p(v5_1);
            v4_1 = ObservedScopeMap.access$getCurrentToken$p(v5_1);
            ObservedScopeMap.access$setCurrentScope$p(v5_1, v0);
            ObservedScopeMap.access$setCurrentScopeReads$p(v5_1, ObservedScopeMap.access$getScopeToValues$p(v5_1).get(v0));
            if(ObservedScopeMap.access$getCurrentToken$p(v5_1) == -1) {
                ObservedScopeMap.access$setCurrentToken$p(v5_1, Long.hashCode(SnapshotKt.currentSnapshot().getSnapshotId()));
            }

            v0_2 = v5_1.getDerivedStateObserver();
            v12 = SnapshotStateKt.derivedStateObservers();
        }
        catch(Throwable v0_1) {
            goto label_198;
        }

        try {
            v12.add(v0_2);
            if(v14 == null) {
                arg25.invoke();
                v18 = v8;
                v9 = v12;
            }
            else {
                v13 = SnapshotKt.threadSnapshot.get();
                v15 = null;
                if((v13 instanceof TransparentObserverMutableSnapshot)) {
                    goto label_75;
                }

                goto label_115;
            }

            goto label_142;
        }
        catch(Throwable v0_1) {
            goto label_183;
        }

        try {
        label_75:
            if(v13.getThreadId$runtime() == Thread_jvmKt.currentThreadId()) {
                v10 = v13.getReadObserver$runtime();
                v11 = v13.getWriteObserver$runtime();
                goto label_83;
            }

            goto label_115;
        }
        catch(Throwable v0_1) {
            goto label_110;
        }

    label_83:
        v0 = v13;
        MutableVector v17 = v12;
        int v12_1 = 4;
        v18 = v8;
        int v8_1 = 0;
        try {
            ((TransparentObserverMutableSnapshot)v0).setReadObserver$runtime(SnapshotKt.mergedReadObserver$default(v14, v10, false, v12_1, v15));
            v13.setWriteObserver$runtime(SnapshotKt.mergedWriteObserver(null, v11));
            arg25.invoke();
        }
        catch(Throwable v0_1) {
            goto label_101;
        }

        try {
            v13.setReadObserver$runtime(v10);
            ((TransparentObserverMutableSnapshot)v13).setWriteObserver$runtime(v11);
            v9 = v17;
            goto label_142;
        label_101:
            goto label_105;
            v18 = ((long)v8_1);
            v17 = ((MutableVector)v12_1);
        label_105:
            v13.setReadObserver$runtime(v10);
            ((TransparentObserverMutableSnapshot)v13).setWriteObserver$runtime(v11);
            throw v0_1;
        label_110:
            v18 = v8;
            v17 = v12;
            goto label_112;
        label_115:
            v18 = v8;
            v17 = v12;
            Function1 v8_2 = null;
            if(v13 == null || ((v13 instanceof MutableSnapshot))) {
                if((v13 instanceof MutableSnapshot)) {
                    v15 = v13;
                }

                v13 = v15;
                v9 = v17;
                v17 = null;
                v15_1 = v8_2;
                goto label_135;
            }
            else {
                v0_3 = ((Snapshot)v13).takeNestedSnapshot(v14);
                v9 = v17;
            }

            goto label_124;
        }
        catch(Throwable v0_1) {
            goto label_181;
        }

        try {
        label_135:
            TransparentObserverMutableSnapshot v0_4 = new TransparentObserverMutableSnapshot(((MutableSnapshot)v13), v14, v15_1, true, false);
            goto label_124;
        }
        catch(Throwable v0_1) {
            goto label_179;
        }

    label_183:
        long v20 = v8;
        v9 = v12;
        long v11_1 = v20;
        goto label_187;
        try {
        label_192:
            v11_1 = v8;
            __monitor_exit(v4);
            throw v0_1;
        }
        catch(Throwable v0_1) {
            goto label_196;
        }

    label_198:
        v11_1 = v8;
        goto label_199;
    label_212:
        __monitor_exit(v4);
        throw v0_1;
    label_124:
        Snapshot v8_3 = v0_3;
        try {
            v10_1 = v8_3.makeCurrent();
        }
        catch(Throwable v0_1) {
            goto label_173;
        }

        try {
            arg25.invoke();
        }
        catch(Throwable v0_1) {
            goto label_167;
        }

        try {
            v8_3.restoreCurrent(v10_1);
        }
        catch(Throwable v0_1) {
            goto label_173;
        }

        try {
            v8_3.dispose();
        }
        catch(Throwable v0_1) {
            goto label_179;
        }

        try {
        label_142:
            v9.removeAt(v9.getSize() - 1);
            v0 = ObservedScopeMap.access$getCurrentScope$p(v5_1);
            Intrinsics.checkNotNull(v0);
            ObservedScopeMap.access$clearObsoleteStateReads(v5_1, v0);
            ObservedScopeMap.access$setCurrentScope$p(v5_1, v2_1);
            ObservedScopeMap.access$setCurrentScopeReads$p(v5_1, v3);
            ObservedScopeMap.access$setCurrentToken$p(v5_1, v4_1);
        }
        catch(Throwable v0_1) {
            goto label_164;
        }

        v2_1 = v1.observedScopeMapsLock;
        __monitor_enter(v2_1);
        try {
            v1.currentMap = v7;
            v1.isPaused = v6;
            v1.currentMapThreadId = v18;
        }
        catch(Throwable v0_1) {
            goto label_161;
        }

        __monitor_exit(v2_1);
        return;
    label_161:
        __monitor_exit(v2_1);
        throw v0_1;
    label_164:
        v11_1 = v18;
        goto label_199;
    label_167:
        v11_1 = v18;
        try {
            v8_3.restoreCurrent(v10_1);
            throw v0_1;
        }
        catch(Throwable v0_1) {
            goto label_174;
        }

    label_173:
        v11_1 = v18;
        try {
        label_174:
            v8_3.dispose();
            throw v0_1;
        }
        catch(Throwable v0_1) {
            goto label_187;
        }

    label_179:
        goto label_113;
    label_199:
        v2_1 = v1.observedScopeMapsLock;
        __monitor_enter(v2_1);
        try {
            v1.currentMap = v7;
            v1.isPaused = v6;
            v1.currentMapThreadId = v11_1;
        }
        catch(Throwable v0_1) {
            goto label_209;
        }

        __monitor_exit(v2_1);
        throw v0_1;
    label_209:
        __monitor_exit(v2_1);
        throw v0_1;
    label_196:
        goto label_199;
        try {
        label_187:
            v9.removeAt(v9.getSize() - 1);
            throw v0_1;
        }
        catch(Throwable v0_1) {
            goto label_196;
        }

    label_181:
        goto label_112;
    label_113:
        v11_1 = v18;
        goto label_187;
    label_112:
        v9 = v17;
        goto label_113;
    }

    static final Unit readObserver$lambda$0(SnapshotStateObserver arg1, Object arg2) {
        if(!arg1.isPaused) {
            Object v0 = arg1.observedScopeMapsLock;
            __monitor_enter(v0);
            try {
                ObservedScopeMap v1_1 = arg1.currentMap;
                Intrinsics.checkNotNull(v1_1);
                v1_1.recordRead(arg2);
            }
            catch(Throwable v1) {
                __monitor_exit(v0);
                throw v1;
            }

            __monitor_exit(v0);
        }

        return Unit.INSTANCE;
    }

    private final Set removeChanges() {
        Object v2;
        Set v1;
        do {
            Object v0 = this.pendingChanges.get();
            v1 = null;
            if(v0 == null) {
                return v1;
            }

            if((v0 instanceof Set)) {
                v2 = v0;
            }
            else if((v0 instanceof List)) {
                v2 = v0;
                Object v3 = ((List)v2).get(0);
                int v6 = 2;
                if(((List)v2).size() == v6) {
                    Object v1_1 = ((List)v2).get(1);
                }
                else if(((List)v2).size() > v6) {
                    List v1_2 = ((List)v2).subList(1, ((List)v2).size());
                }

                v2 = v3;
            }
            else {
                goto label_29;
            }
        }
        while(!MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(this.pendingChanges, v0, v1_2));

        return ((Set)v2);
    label_29:
        this.report();
        throw new KotlinNothingValueException();
        return v1;
    }

    private final void removeScopeMapIf(Function1 arg8) {
        Object v0 = this.observedScopeMapsLock;
        __monitor_enter(v0);
        try {
            MutableVector v7_1 = this.observedScopeMaps;
            int v1 = v7_1.getSize();
            int v2 = 0;
            int v3 = 0;
            while(v2 < v1) {
                if(arg8.invoke(v7_1.content[v2]).booleanValue()) {
                    ++v3;
                }
                else if(v3 > 0) {
                    v7_1.content[v2 - v3] = v7_1.content[v2];
                }

                ++v2;
            }

            v2 = v1 - v3;
            ArraysKt.fill(v7_1.content, null, v2, v1);
            v7_1.setSize(v2);
        }
        catch(Throwable v7) {
            goto label_31;
        }

        __monitor_exit(v0);
        return;
    label_31:
        __monitor_exit(v0);
        throw v7;
    }

    private final Void report() {
        ComposerKt.composeRuntimeError("Unexpected notification");
        throw new KotlinNothingValueException();
    }

    private final void sendNotifications() {
        this.onChangedExecutor.invoke(new SnapshotStateObserver$$ExternalSyntheticLambda0(this));
    }

    static final Unit sendNotifications$lambda$0(SnapshotStateObserver arg6) {
        do {
            Object v0 = arg6.observedScopeMapsLock;
            __monitor_enter(v0);
            try {
                if(!arg6.sendingNotifications) {
                    arg6.sendingNotifications = true;
                    goto label_7;
                }

                goto label_21;
            }
            catch(Throwable v6) {
                goto label_28;
            }

            try {
            label_7:
                MutableVector v2_1 = arg6.observedScopeMaps;
                Object[] v3 = v2_1.content;
                int v2_2 = v2_1.getSize();
                int v4;
                for(v4 = 0; v4 < v2_2; ++v4) {
                    v3[v4].notifyInvalidatedScopes();
                }
            }
            catch(Throwable v2) {
                goto label_19;
            }

            try {
                arg6.sendingNotifications = false;
                goto label_21;
            label_19:
                arg6.sendingNotifications = false;
                throw v2;
            label_21:
            }
            catch(Throwable v6) {
            label_28:
                __monitor_exit(v0);
                throw v6;
            }

            __monitor_exit(v0);
        }
        while(arg6.drainChanges());

        return Unit.INSTANCE;
    }

    public final void start() {
        this.applyUnsubscribe = Snapshot.Companion.registerApplyObserver(this.applyObserver);
    }

    public final void stop() {
        ObserverHandle v0 = this.applyUnsubscribe;
        if(v0 != null) {
            v0.dispose();
        }
    }

    @Deprecated(message="Replace with Snapshot.withoutReadObservation()", replaceWith="<_subannotation>") public final void withNoObservations(Function0 arg3) {
        boolean v0 = this.isPaused;
        this.isPaused = true;
        try {
            arg3.invoke();
        }
        catch(Throwable v3) {
            this.isPaused = v0;
            throw v3;
        }

        this.isPaused = v0;
    }

    private final Object withScopeMapLock(Function0 arg1) {
        Object v1_1;
        Object v0 = this.observedScopeMapsLock;
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
}

