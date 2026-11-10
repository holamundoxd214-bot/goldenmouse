package androidx.compose.foundation.lazy.layout;

import android.os.Trace;
import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.SubcomposeLayoutState$PausedPrecomposition;
import androidx.compose.ui.layout.SubcomposeLayoutState$PrecomposedSlotHandle;
import androidx.compose.ui.layout.SubcomposeLayoutState;
import androidx.compose.ui.node.TraversableNode$Companion$TraverseDescendantsAction;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.util.AndroidTrace_androidKt;
import java.util.Collection;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.time.Duration;
import kotlin.time.TimeSource$Monotonic$ValueTimeMark;
import kotlin.time.TimeSource$Monotonic;

@Metadata(d1={"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001:\u0001+B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001E\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u000B2\u0006\u0010\u0018\u001A\u00020\u0019J\u0006\u0010\u001A\u001A\u00020\u001BJH\u0010\u001C\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u001D\u001A\u00020\u001E2\u0006\u0010\u0018\u001A\u00020\u00192\u0006\u0010\u0017\u001A\u00020\u000B2\u0019\u0010\u001F\u001A\u0015\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u001B\u0018\u00010 ¢\u0006\u0002\b\"¢\u0006\u0004\b#\u0010$J\u001A\u0010%\u001A\u00020\u001B*\u00020\u00072\u0006\u0010&\u001A\u00020\'2\u0006\u0010\u0017\u001A\u00020\u000BJ%\u0010(\u001A\u00020\'2\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u001D\u001A\u00020\u001E2\u0006\u0010\u0018\u001A\u00020\u0019¢\u0006\u0004\b)\u0010*J\u0016\u0010(\u001A\u00020\'2\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0018\u001A\u00020\u0019R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R$\u0010\f\u001A\u00020\u000B8\u0000@\u0000X\u0081\u000E¢\u0006\u0014\n\u0000\u0012\u0004\b\r\u0010\u000E\u001A\u0004\b\u000F\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006,"}, d2={"Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider;", "", "itemContentFactory", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory;", "subcomposeLayoutState", "Landroidx/compose/ui/layout/SubcomposeLayoutState;", "executor", "Landroidx/compose/foundation/lazy/layout/PrefetchScheduler;", "<init>", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory;Landroidx/compose/ui/layout/SubcomposeLayoutState;Landroidx/compose/foundation/lazy/layout/PrefetchScheduler;)V", "isStateActive", "", "shouldPauseBetweenPrecompositionAndPremeasure", "getShouldPauseBetweenPrecompositionAndPremeasure$foundation$annotations", "()V", "getShouldPauseBetweenPrecompositionAndPremeasure$foundation", "()Z", "setShouldPauseBetweenPrecompositionAndPremeasure$foundation", "(Z)V", "schedulePrecomposition", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "index", "", "isHighPriority", "prefetchMetrics", "Landroidx/compose/foundation/lazy/layout/PrefetchMetrics;", "onDisposed", "", "schedulePremeasure", "constraints", "Landroidx/compose/ui/unit/Constraints;", "onItemPremeasured", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchResultScope;", "Lkotlin/ExtensionFunctionType;", "schedulePremeasure-m8Kt_7k", "(IJLandroidx/compose/foundation/lazy/layout/PrefetchMetrics;ZLkotlin/jvm/functions/Function1;)Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "executeWithPriority", "request", "Landroidx/compose/foundation/lazy/layout/PrefetchRequest;", "createNestedPrefetchRequest", "createNestedPrefetchRequest-VKLhPVY", "(IJLandroidx/compose/foundation/lazy/layout/PrefetchMetrics;)Landroidx/compose/foundation/lazy/layout/PrefetchRequest;", "HandleAndRequestImpl", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class PrefetchHandleProvider {
    @Metadata(d1={"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0083\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001MB<\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\b\u0010\b\u001A\u0004\u0018\u00010\t\u0012\u0019\u0010\n\u001A\u0015\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f\u0018\u00010\u000B¢\u0006\u0002\b\r¢\u0006\u0004\b\u000E\u0010\u000FBF\b\u0016\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0010\u001A\u00020\u0011\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\b\u0010\b\u001A\u0004\u0018\u00010\t\u0012\u0019\u0010\n\u001A\u0015\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f\u0018\u00010\u000B¢\u0006\u0002\b\r¢\u0006\u0004\b\u000E\u0010\u0012J\b\u0010\'\u001A\u00020\fH\u0016J\b\u0010(\u001A\u00020\fH\u0016J\u0017\u0010+\u001A\u00020,2\u0006\u0010-\u001A\u00020\u0005H\u0016¢\u0006\u0004\b.\u0010/J\u0018\u00100\u001A\u00020\u001B2\u0006\u00101\u001A\u0002022\u0006\u00103\u001A\u000202H\u0002J\u0010\u00109\u001A\u00020\f2\u0006\u00104\u001A\u000202H\u0002J\b\u0010:\u001A\u00020\fH\u0002J\f\u0010;\u001A\u00020\u001B*\u00020<H\u0016J\b\u0010=\u001A\u00020\fH\u0002J\f\u0010>\u001A\u00020\u001B*\u00020<H\u0002J&\u0010@\u001A\u00020\f*\u00020<2\u0006\u0010A\u001A\u00020\u001F2\b\u0010B\u001A\u0004\u0018\u00010\u001F2\u0006\u0010C\u001A\u00020DH\u0002J\u001A\u0010E\u001A\u00020\f2\u0006\u0010A\u001A\u00020\u001F2\b\u0010B\u001A\u0004\u0018\u00010\u001FH\u0002J\b\u0010F\u001A\u00020\fH\u0002J\u0017\u0010G\u001A\u00020\f2\u0006\u0010\u0010\u001A\u00020\u0011H\u0002¢\u0006\u0004\bH\u0010IJ\u0012\u0010J\u001A\f\u0018\u00010\"R\u00060\u0000R\u00020#H\u0002J\b\u0010K\u001A\u00020LH\u0016R\u0014\u0010\u0004\u001A\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001A\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\n\u001A\u0015\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f\u0018\u00010\u000B¢\u0006\u0002\b\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001A\u0004\u0018\u00010\u0011X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001A\u0004\u0018\u00010\u0017X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001A\u0004\u0018\u00010\u0019X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001A\u001A\u00020\u001BX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001C\u001A\u00020\u001BX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001D\u001A\u00020\u001BX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u001E\u001A\u0004\u0018\u00010\u001FX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010 \u001A\u00020\u001BX\u0082\u000E¢\u0006\u0002\n\u0000R\u0018\u0010!\u001A\f\u0018\u00010\"R\u00060\u0000R\u00020#X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010$\u001A\u00020\u001BX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010%\u001A\u00020\u001B8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b%\u0010&R\u0014\u0010)\u001A\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b*\u0010\u0014R\u000E\u00104\u001A\u000202X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u00105\u001A\u000202X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u00106\u001A\u000207X\u0082\u000E¢\u0006\u0004\n\u0002\u00108R\u000E\u0010?\u001A\u00020\u001BX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006N"}, d2={"Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider$HandleAndRequestImpl;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "Landroidx/compose/foundation/lazy/layout/PrefetchRequest;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchResultScope;", "index", "", "prefetchMetrics", "Landroidx/compose/foundation/lazy/layout/PrefetchMetrics;", "priorityPrefetchScheduler", "Landroidx/compose/foundation/lazy/layout/PriorityPrefetchScheduler;", "onItemPremeasured", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider;ILandroidx/compose/foundation/lazy/layout/PrefetchMetrics;Landroidx/compose/foundation/lazy/layout/PriorityPrefetchScheduler;Lkotlin/jvm/functions/Function1;)V", "constraints", "Landroidx/compose/ui/unit/Constraints;", "(Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider;IJLandroidx/compose/foundation/lazy/layout/PrefetchMetrics;Landroidx/compose/foundation/lazy/layout/PriorityPrefetchScheduler;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getIndex", "()I", "premeasureConstraints", "precomposeHandle", "Landroidx/compose/ui/layout/SubcomposeLayoutState$PrecomposedSlotHandle;", "pausedPrecomposition", "Landroidx/compose/ui/layout/SubcomposeLayoutState$PausedPrecomposition;", "isMeasured", "", "isCanceled", "isApplied", "keyUsedForComposition", "", "hasResolvedNestedPrefetches", "nestedPrefetchController", "Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider$HandleAndRequestImpl$NestedPrefetchController;", "Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider;", "isUrgent", "isComposed", "()Z", "cancel", "markAsUrgent", "placeablesCount", "getPlaceablesCount", "getSize", "Landroidx/compose/ui/unit/IntSize;", "placeableIndex", "getSize-YEO4UFw", "(I)J", "shouldExecute", "available", "", "average", "availableTimeNanos", "elapsedTimeNanos", "startTime", "Lkotlin/time/TimeSource$Monotonic$ValueTimeMark;", "J", "resetAvailableTimeTo", "updateElapsedAndAvailableTime", "execute", "Landroidx/compose/foundation/lazy/layout/PrefetchRequestScope;", "cleanUp", "executeRequest", "pauseRequested", "performPausableComposition", "key", "contentType", "averages", "Landroidx/compose/foundation/lazy/layout/Averages;", "performFullComposition", "performApply", "performMeasure", "performMeasure-BRTryo0", "(J)V", "resolveNestedPrefetchStates", "toString", "", "NestedPrefetchController", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class HandleAndRequestImpl implements PrefetchHandle, PrefetchResultScope, PrefetchRequest {
        @Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001A\u0010\u0014\u001A\u00020\u000F*\u00020\u00152\u0006\u0010\u0016\u001A\u00020\f2\u0006\u0010\u0017\u001A\u00020\u000FJ\u0006\u0010\u0018\u001A\u00020\fJ\u0006\u0010\u0019\u001A\u00020\fR\u0014\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001E\u0010\u0007\u001A\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00030\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u000E\u0010\u000B\u001A\u00020\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u001A\u0010\u000E\u001A\u00020\u000FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001A"}, d2={"Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider$HandleAndRequestImpl$NestedPrefetchController;", "", "states", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "<init>", "(Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider$HandleAndRequestImpl;Ljava/util/List;)V", "requestsByState", "", "Landroidx/compose/foundation/lazy/layout/PrefetchRequest;", "[Ljava/util/List;", "stateIndex", "", "requestIndex", "executedNestedPrefetch", "", "getExecutedNestedPrefetch", "()Z", "setExecutedNestedPrefetch", "(Z)V", "executeNestedPrefetches", "Landroidx/compose/foundation/lazy/layout/PrefetchRequestScope;", "nestedPrefetchCount", "isUrgent", "collectIdealNestedPrefetchCount", "collectNestedPrefetchedItemsCount", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class NestedPrefetchController {
            private boolean executedNestedPrefetch;
            private int requestIndex;
            private final List[] requestsByState;
            private int stateIndex;
            private final List states;

            public NestedPrefetchController(HandleAndRequestImpl arg1, List arg2) {
                HandleAndRequestImpl.this = arg1;
                super();
                this.states = arg2;
                this.requestsByState = new List[arg2.size()];
                if(((Collection)arg2).isEmpty()) {
                    InlineClassHelperKt.throwIllegalArgumentException("NestedPrefetchController shouldn\'t be created with no states");
                }
            }

            public final int collectIdealNestedPrefetchCount() {
                List v6 = this.states;
                int v0 = v6.size();
                int v1 = 0x7FFFFFFF;
                int v4 = v1;
                int v3;
                for(v3 = 0; v3 < v0; ++v3) {
                    v4 = Math.min(v4, v6.get(v3).getIdealNestedPrefetchCount$foundation());
                }

                if(v4 == v1) {
                    return 0;
                }

                return v4;
            }

            public final int collectNestedPrefetchedItemsCount() {
                List v6 = this.states;
                int v0 = v6.size();
                int v1 = 0x7FFFFFFF;
                int v4 = v1;
                int v3;
                for(v3 = 0; v3 < v0; ++v3) {
                    v4 = Math.min(v4, v6.get(v3).getLastNumberOfNestedPrefetchItems$foundation());
                }

                if(v4 == v1) {
                    return 0;
                }

                return v4;
            }

            public final boolean executeNestedPrefetches(PrefetchRequestScope arg8, int arg9, boolean arg10) {
                if(this.stateIndex >= this.states.size()) {
                    return 0;
                }

                if(HandleAndRequestImpl.this.isCanceled) {
                    InlineClassHelperKt.throwIllegalStateException("Should not execute nested prefetch on canceled request");
                }

                Trace.beginSection("compose:lazy:prefetch:update_nested_prefetch_count");
                try {
                    List v0 = this.states;
                    int v1 = v0.size();
                    int v3;
                    for(v3 = 0; v3 < v1; ++v3) {
                        v0.get(v3).setRealizedNestedPrefetchCount$foundation(arg9);
                    }
                }
                catch(Throwable v7) {
                    goto label_84;
                }

                Trace.endSection();
                Trace.beginSection("compose:lazy:prefetch:nested");
                try {
                    while(true) {
                    label_26:
                        if(this.stateIndex >= this.states.size()) {
                            goto label_77;
                        }

                        if(this.requestsByState[this.stateIndex] == null) {
                            if(arg8.availableTimeNanos() <= 0) {
                                break;
                            }
                            else {
                                goto label_40;
                            }
                        }

                        goto label_46;
                    }
                }
                catch(Throwable v7) {
                    goto label_81;
                }

                Trace.endSection();
                return 1;
                try {
                label_40:
                    this.requestsByState[this.stateIndex] = this.states.get(this.stateIndex).collectNestedPrefetchRequests$foundation();
                label_46:
                    List v9 = this.requestsByState[this.stateIndex];
                    Intrinsics.checkNotNull(v9);
                    while(true) {
                    label_50:
                        if(this.requestIndex >= v9.size()) {
                            goto label_72;
                        }

                        Object v1_1 = v9.get(this.requestIndex);
                        if(arg10) {
                            Object v3_1 = (v1_1 instanceof HandleAndRequestImpl) ? v1_1 : null;
                            if(v3_1 == null) {
                                goto label_63;
                            }

                            ((HandleAndRequestImpl)v3_1).markAsUrgent();
                        }

                    label_63:
                        this.executedNestedPrefetch = true;
                        if(!((PrefetchRequest)v1_1).execute(arg8)) {
                            goto label_68;
                        }

                        break;
                    }
                }
                catch(Throwable v7) {
                    goto label_81;
                }

                Trace.endSection();
                return 1;
                try {
                label_68:
                    ++this.requestIndex;
                    goto label_50;
                label_72:
                    this.requestIndex = 0;
                    ++this.stateIndex;
                    goto label_26;
                label_77:
                }
                catch(Throwable v7) {
                label_81:
                    Trace.endSection();
                    throw v7;
                }

                Trace.endSection();
                return 0;
            label_84:
                Trace.endSection();
                throw v7;
            }

            public final boolean getExecutedNestedPrefetch() {
                return this.executedNestedPrefetch;
            }

            public final void setExecutedNestedPrefetch(boolean arg1) {
                this.executedNestedPrefetch = arg1;
            }
        }

        private long availableTimeNanos;
        private long elapsedTimeNanos;
        private boolean hasResolvedNestedPrefetches;
        private final int index;
        private boolean isApplied;
        private boolean isCanceled;
        private boolean isMeasured;
        private boolean isUrgent;
        private Object keyUsedForComposition;
        private NestedPrefetchController nestedPrefetchController;
        private final Function1 onItemPremeasured;
        private boolean pauseRequested;
        private PausedPrecomposition pausedPrecomposition;
        private PrecomposedSlotHandle precomposeHandle;
        private final PrefetchMetrics prefetchMetrics;
        private Constraints premeasureConstraints;
        private final PriorityPrefetchScheduler priorityPrefetchScheduler;
        private long startTime;

        public HandleAndRequestImpl(PrefetchHandleProvider arg1, int arg2, PrefetchMetrics arg3, PriorityPrefetchScheduler arg4, Function1 arg5) {
            PrefetchHandleProvider.this = arg1;
            super();
            this.index = arg2;
            this.prefetchMetrics = arg3;
            this.priorityPrefetchScheduler = arg4;
            this.onItemPremeasured = arg5;
            this.startTime = Monotonic.INSTANCE.markNow-z9LOYto();
        }

        public HandleAndRequestImpl(PrefetchHandleProvider arg1, int arg2, long arg3, PrefetchMetrics arg5, PriorityPrefetchScheduler arg6, Function1 arg7, DefaultConstructorMarker arg8) {
            this(arg1, arg2, arg3, arg5, arg6, arg7);
        }

        private HandleAndRequestImpl(PrefetchHandleProvider arg7, int arg8, long arg9, PrefetchMetrics arg11, PriorityPrefetchScheduler arg12, Function1 arg13) {
            this(arg7, arg8, arg11, arg12, arg13);
            this.premeasureConstraints = Constraints.box-impl(arg9);
        }

        public static final boolean access$isCanceled$p(HandleAndRequestImpl arg0) {
            return arg0.isCanceled;
        }

        public void cancel() {
            if(!this.isCanceled) {
                this.isCanceled = true;
                this.cleanUp();
            }
        }

        private final void cleanUp() {
            PausedPrecomposition v0 = this.pausedPrecomposition;
            if(v0 != null) {
                v0.cancel();
            }

            v0 = null;
            this.pausedPrecomposition = v0;
            PrecomposedSlotHandle v1 = this.precomposeHandle;
            if(v1 != null) {
                v1.dispose();
            }

            this.precomposeHandle = ((PrecomposedSlotHandle)v0);
            this.nestedPrefetchController = ((NestedPrefetchController)v0);
        }

        public boolean execute(PrefetchRequestScope arg3) {
            boolean v2_1;
            if(!PrefetchHandleProvider.this.isStateActive) {
                return 0;
            }

            if(this.isUrgent) {
                Trace.beginSection("compose:lazy:prefetch:execute:urgent");
                try {
                    v2_1 = this.executeRequest(arg3);
                }
                catch(Throwable v2) {
                    Trace.endSection();
                    throw v2;
                }

                Trace.endSection();
            }
            else {
                v2_1 = this.executeRequest(arg3);
            }

            AndroidTrace_androidKt.traceValue("compose:lazy:prefetch:execute:item", -1);
            return v2_1;
        }

        private final boolean executeRequest(PrefetchRequestScope arg18) {
            HandleAndRequestImpl v0 = this;
            PrefetchRequestScope v1 = arg18;
            String v4 = "compose:lazy:prefetch:execute:item";
            AndroidTrace_androidKt.traceValue(v4, ((long)v0.getIndex()));
            Object v2 = v0.this$0.itemContentFactory.getItemProvider().invoke();
            if(!v0.isCanceled) {
                int v3 = ((LazyLayoutItemProvider)v2).getItemCount();
                int v6 = v0.getIndex();
                if(v6 >= 0 && v6 < v3) {
                    Object v3_1 = ((LazyLayoutItemProvider)v2).getKey(v0.getIndex());
                    Object v6_1 = v0.keyUsedForComposition;
                    if(v6_1 != null && !Intrinsics.areEqual(v3_1, v6_1)) {
                        v0.cleanUp();
                        return 0;
                    }

                    v2 = ((LazyLayoutItemProvider)v2).getContentType(v0.getIndex());
                    Averages v6_2 = v0.prefetchMetrics.getAverage(v2);
                    boolean v7 = v0.isComposed();
                    v0.resetAvailableTimeTo(v1.availableTimeNanos());
                    if(!v0.isComposed()) {
                        boolean v8 = ComposeFoundationFlags.isPausableCompositionInPrefetchEnabled;
                        long v10 = v0.availableTimeNanos;
                        String v12 = "compose:lazy:prefetch:compose";
                        if(v8) {
                            if(v0.shouldExecute(v10, v6_2.getResumeTimeNanos() + v6_2.getPauseTimeNanos())) {
                                Trace.beginSection(v12);
                                try {
                                    v0.performPausableComposition(v1, v3_1, v2, v6_2);
                                }
                                catch(Throwable v0_1) {
                                    Trace.endSection();
                                    throw v0_1;
                                }

                                Trace.endSection();
                            }
                        }
                        else if(v0.shouldExecute(v10, v6_2.getCompositionTimeNanos())) {
                            Trace.beginSection(v12);
                            try {
                                v0.performFullComposition(v3_1, v2);
                            }
                            catch(Throwable v0_1) {
                                Trace.endSection();
                                throw v0_1;
                            }

                            Trace.endSection();
                            v0.updateElapsedAndAvailableTime();
                            v6_2.saveCompositionTimeNanos(v0.elapsedTimeNanos);
                        }

                        if(v0.isComposed()) {
                            goto label_69;
                        }

                        return 1;
                    }

                label_69:
                    if(v0.pausedPrecomposition != null) {
                        if(v0.shouldExecute(v0.availableTimeNanos, v6_2.getApplyTimeNanos())) {
                            Trace.beginSection("compose:lazy:prefetch:apply");
                            try {
                                v0.performApply();
                            }
                            catch(Throwable v0_1) {
                                Trace.endSection();
                                throw v0_1;
                            }

                            Trace.endSection();
                            v0.updateElapsedAndAvailableTime();
                            v6_2.saveApplyTimeNanos(v0.elapsedTimeNanos);
                        }
                        else {
                            return 1;
                        }
                    }

                    if(!v0.hasResolvedNestedPrefetches) {
                        if(v0.availableTimeNanos > 0) {
                            Trace.beginSection("compose:lazy:prefetch:resolve-nested");
                            try {
                                v0.nestedPrefetchController = v0.resolveNestedPrefetchStates();
                                v0.hasResolvedNestedPrefetches = true;
                            }
                            catch(Throwable v0_1) {
                                Trace.endSection();
                                throw v0_1;
                            }

                            Trace.endSection();
                        }
                        else {
                            return 1;
                        }
                    }

                    NestedPrefetchController v2_1 = v0.nestedPrefetchController;
                    boolean v1_1 = v2_1 != null ? v2_1.executeNestedPrefetches(v1, v6_2.getNestedPrefetchCount(), v0.isUrgent) : false;
                    if(v1_1) {
                        return 1;
                    }

                    NestedPrefetchController v1_2 = v0.nestedPrefetchController;
                    if(v1_2 != null && (v1_2.getExecutedNestedPrefetch())) {
                        v0.updateElapsedAndAvailableTime();
                        AndroidTrace_androidKt.traceValue(v4, ((long)v0.getIndex()));
                        v1_2 = v0.nestedPrefetchController;
                        if(v1_2 != null) {
                            v1_2.setExecutedNestedPrefetch(false);
                        }
                    }

                    Constraints v1_3 = v0.premeasureConstraints;
                    if(!v0.isMeasured && v1_3 != null) {
                        if((v0.this$0.getShouldPauseBetweenPrecompositionAndPremeasure$foundation()) && !v7) {
                            return 1;
                        }

                        if(v0.shouldExecute(v0.availableTimeNanos, v6_2.getMeasureTimeNanos())) {
                            Trace.beginSection("compose:lazy:prefetch:measure");
                            try {
                                v0.performMeasure-BRTryo0(v1_3.unbox-impl());
                            }
                            catch(Throwable v0_1) {
                                Trace.endSection();
                                throw v0_1;
                            }

                            Trace.endSection();
                            v0.updateElapsedAndAvailableTime();
                            v6_2.saveMeasureTimeNanos(v0.elapsedTimeNanos);
                            Function1 v1_4 = v0.onItemPremeasured;
                            if(v1_4 == null) {
                                goto label_155;
                            }

                            v1_4.invoke(v0);
                            goto label_155;
                        }

                        return 1;
                    }

                label_155:
                    v1_2 = v0.nestedPrefetchController;
                    if((v0.isMeasured) && (v0.hasResolvedNestedPrefetches) && v1_2 != null) {
                        int v0_2 = v1_2.collectIdealNestedPrefetchCount();
                        v6_2.saveNestedPrefetchCount(v0_2);
                        if(v1_2.collectNestedPrefetchedItemsCount() < v0_2) {
                            v6_2.clearMeasureTime();
                        }
                    }

                    return 0;
                }
            }

            v0.cleanUp();
            return 0;
        }

        public int getIndex() {
            return this.index;
        }

        public int getPlaceablesCount() {
            PrecomposedSlotHandle v0 = this.precomposeHandle;
            if(v0 != null) {
                return v0.getPlaceablesCount();
            }

            return 0;
        }

        public long getSize-YEO4UFw(int arg1) {
            PrecomposedSlotHandle v0 = this.precomposeHandle;
            if(v0 != null) {
                return v0.getSize-YEO4UFw(arg1);
            }

            return IntSize.Companion.getZero-YbymL2g();
        }

        private final boolean isComposed() {
            if(!this.isApplied) {
                PausedPrecomposition v2 = this.pausedPrecomposition;
                if(v2 != null && (v2.isComplete())) {
                    return 1;
                }

                return 0;
            }

            return 1;
        }

        public void markAsUrgent() {
            this.isUrgent = true;
        }

        private final void performApply() {
            PausedPrecomposition v0 = this.pausedPrecomposition;
            if(v0 != null) {
                this.precomposeHandle = v0.apply();
                this.pausedPrecomposition = null;
                this.isApplied = true;
                return;
            }

            throw new IllegalArgumentException("Nothing to apply!".toString());
        }

        private final void performFullComposition(Object arg4, Object arg5) {
            int v0 = this.precomposeHandle == null ? 1 : 0;
            if(v0 == 0) {
                InlineClassHelperKt.throwIllegalArgumentException("Request was already composed!");
            }

            Function2 v5 = PrefetchHandleProvider.this.itemContentFactory.getContent(this.getIndex(), arg4, arg5);
            this.keyUsedForComposition = arg4;
            this.precomposeHandle = PrefetchHandleProvider.this.subcomposeLayoutState.precompose(arg4, v5);
            this.isApplied = true;
        }

        private final void performMeasure-BRTryo0(long arg3) {
            if(this.isCanceled) {
                InlineClassHelperKt.throwIllegalArgumentException("Callers should check whether the request is still valid before calling performMeasure()");
            }

            if(this.isMeasured) {
                InlineClassHelperKt.throwIllegalArgumentException("Request was already measured!");
            }

            this.isMeasured = true;
            PrecomposedSlotHandle v2 = this.precomposeHandle;
            if(v2 != null) {
                int v0 = v2.getPlaceablesCount();
                int v1;
                for(v1 = 0; v1 < v0; ++v1) {
                    v2.premeasure-0kLqBqw(v1, arg3);
                }

                return;
            }

            InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("performComposition() must be called before performMeasure()");
            throw new KotlinNothingValueException();
        }

        private final void performPausableComposition(PrefetchRequestScope arg3, Object arg4, Object arg5, Averages arg6) {
            PausedPrecomposition v3 = this.pausedPrecomposition;
            if(v3 == null) {
                v3 = PrefetchHandleProvider.this.subcomposeLayoutState.createPausedPrecomposition(arg4, PrefetchHandleProvider.this.itemContentFactory.getContent(this.getIndex(), arg4, arg5));
                this.pausedPrecomposition = v3;
                this.keyUsedForComposition = arg4;
            }

            this.pauseRequested = false;
            while(!v3.isComplete()) {
                if(this.pauseRequested) {
                    break;
                }

                v3.resume(new PrefetchHandleProvider$HandleAndRequestImpl$$ExternalSyntheticLambda1(this, arg6));
            }

            this.updateElapsedAndAvailableTime();
            boolean v3_1 = this.pauseRequested;
            long v4 = this.elapsedTimeNanos;
            if(v3_1) {
                arg6.savePauseTimeNanos(v4);
                return;
            }

            arg6.saveResumeTimeNanos(v4);
        }

        static final boolean performPausableComposition$lambda$1(HandleAndRequestImpl arg6, Averages arg7) {
            boolean v0 = arg6.pauseRequested;
            if(!v0) {
                arg6.updateElapsedAndAvailableTime();
                arg7.saveResumeTimeNanos(arg6.elapsedTimeNanos);
                int v7 = arg6.shouldExecute(arg6.availableTimeNanos, arg7.getResumeTimeNanos() + arg7.getPauseTimeNanos()) ^ 1;
                arg6.pauseRequested = ((boolean)v7);
                return ((boolean)v7);
            }

            return v0;
        }

        private final void resetAvailableTimeTo(long arg3) {
            this.availableTimeNanos = arg3;
            this.startTime = Monotonic.INSTANCE.markNow-z9LOYto();
            this.elapsedTimeNanos = 0;
            AndroidTrace_androidKt.traceValue("compose:lazy:prefetch:available_time_nanos", arg3);
        }

        private final NestedPrefetchController resolveNestedPrefetchStates() {
            PrecomposedSlotHandle v0 = this.precomposeHandle;
            if(v0 != null) {
                ObjectRef v1 = new ObjectRef();
                v0.traverseDescendants("androidx.compose.foundation.lazy.layout.TraversablePrefetchStateNode", new PrefetchHandleProvider$HandleAndRequestImpl$$ExternalSyntheticLambda0(v1));
                Object v0_1 = v1.element;
                if(v0_1 != null) {
                    return new NestedPrefetchController(this, ((List)v0_1));
                }

                return null;
            }

            InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("Should precompose before resolving nested prefetch states");
            throw new KotlinNothingValueException();
        }

        static final TraverseDescendantsAction resolveNestedPrefetchStates$lambda$1(ObjectRef arg2, TraversableNode arg3) {
            List v0_1;
            Intrinsics.checkNotNull(arg3, "null cannot be cast to non-null type androidx.compose.foundation.lazy.layout.TraversablePrefetchStateNode");
            LazyLayoutPrefetchState v3 = ((TraversablePrefetchStateNode)arg3).getPrefetchState();
            Object v0 = arg2.element;
            if(v0 != null) {
                ((List)v0).add(v3);
            }
            else {
                v0_1 = CollectionsKt.mutableListOf(new LazyLayoutPrefetchState[]{v3});
            }

            arg2.element = v0_1;
            return TraverseDescendantsAction.SkipSubtreeAndContinueTraversal;
        }

        private final boolean shouldExecute(long arg1, long arg3) {
            if(this.isUrgent) {
                arg3 = 0;
            }

            if(arg1 > arg3) {
                return 1;
            }

            return 0;
        }

        public String toString() {
            return "HandleAndRequestImpl { index = " + this.getIndex() + ", constraints = " + this.premeasureConstraints + ", isComposed = " + this.isComposed() + ", isMeasured = " + this.isMeasured + ", isCanceled = " + this.isCanceled + " }";
        }

        private final void updateElapsedAndAvailableTime() {
            long v0 = Monotonic.INSTANCE.markNow-z9LOYto();
            long v2 = Duration.getInWholeNanoseconds-impl(ValueTimeMark.minus-6eNON_k(v0, this.startTime));
            this.elapsedTimeNanos = v2;
            long v4 = this.availableTimeNanos - v2;
            this.availableTimeNanos = v4;
            this.startTime = v0;
            AndroidTrace_androidKt.traceValue("compose:lazy:prefetch:available_time_nanos", v4);
        }
    }

    public static final int $stable = 8;
    private final PrefetchScheduler executor;
    private boolean isStateActive;
    private final LazyLayoutItemContentFactory itemContentFactory;
    private boolean shouldPauseBetweenPrecompositionAndPremeasure;
    private final SubcomposeLayoutState subcomposeLayoutState;

    static {
    }

    public PrefetchHandleProvider(LazyLayoutItemContentFactory arg1, SubcomposeLayoutState arg2, PrefetchScheduler arg3) {
        super();
        this.itemContentFactory = arg1;
        this.subcomposeLayoutState = arg2;
        this.executor = arg3;
        this.isStateActive = true;
    }

    public static final LazyLayoutItemContentFactory access$getItemContentFactory$p(PrefetchHandleProvider arg0) {
        return arg0.itemContentFactory;
    }

    public static final SubcomposeLayoutState access$getSubcomposeLayoutState$p(PrefetchHandleProvider arg0) {
        return arg0.subcomposeLayoutState;
    }

    public static final boolean access$isStateActive$p(PrefetchHandleProvider arg0) {
        return arg0.isStateActive;
    }

    public final PrefetchRequest createNestedPrefetchRequest(int arg7, PrefetchMetrics arg8) {
        PrefetchScheduler v1 = this.executor;
        if((v1 instanceof PriorityPrefetchScheduler)) {
        }
        else {
            v1 = null;
        }

        return new HandleAndRequestImpl(this, arg7, arg8, v1, null);
    }

    public final PrefetchRequest createNestedPrefetchRequest-VKLhPVY(int arg10, long arg11, PrefetchMetrics arg13) {
        PrefetchScheduler v1 = this.executor;
        if((v1 instanceof PriorityPrefetchScheduler)) {
        }
        else {
            v1 = null;
        }

        return new HandleAndRequestImpl(this, arg10, arg11, arg13, v1, null, null);
    }

    public final void executeWithPriority(PrefetchScheduler arg1, PrefetchRequest arg2, boolean arg3) {
        if((arg1 instanceof PriorityPrefetchScheduler)) {
            if(arg3) {
                ((PriorityPrefetchScheduler)arg1).scheduleHighPriorityPrefetch(arg2);
                return;
            }

            ((PriorityPrefetchScheduler)arg1).scheduleLowPriorityPrefetch(arg2);
            return;
        }

        arg1.schedulePrefetch(arg2);
    }

    public final boolean getShouldPauseBetweenPrecompositionAndPremeasure$foundation() {
        return this.shouldPauseBetweenPrecompositionAndPremeasure;
    }

    public static void getShouldPauseBetweenPrecompositionAndPremeasure$foundation$annotations() {
    }

    public final void onDisposed() {
        this.isStateActive = false;
    }

    public final PrefetchHandle schedulePrecomposition(int arg7, boolean arg8, PrefetchMetrics arg9) {
        PrefetchScheduler v1 = this.executor;
        if((v1 instanceof PriorityPrefetchScheduler)) {
        }
        else {
            v1 = null;
        }

        HandleAndRequestImpl v0 = new HandleAndRequestImpl(this, arg7, arg9, v1, null);
        this.executeWithPriority(this.executor, v0, arg8);
        AndroidTrace_androidKt.traceValue("compose:lazy:schedule_prefetch:index", ((long)arg7));
        return ((PrefetchHandle)v0);
    }

    public final PrefetchHandle schedulePremeasure-m8Kt_7k(int arg10, long arg11, PrefetchMetrics arg13, boolean arg14, Function1 arg15) {
        PrefetchScheduler v1 = this.executor;
        if((v1 instanceof PriorityPrefetchScheduler)) {
        }
        else {
            v1 = null;
        }

        HandleAndRequestImpl v0 = new HandleAndRequestImpl(this, arg10, arg11, arg13, v1, arg15, null);
        this.executeWithPriority(this.executor, v0, arg14);
        AndroidTrace_androidKt.traceValue("compose:lazy:schedule_prefetch:index", ((long)arg10));
        return ((PrefetchHandle)v0);
    }

    public final void setShouldPauseBetweenPrecompositionAndPremeasure$foundation(boolean arg1) {
        this.shouldPauseBetweenPrecompositionAndPremeasure = arg1;
    }
}

