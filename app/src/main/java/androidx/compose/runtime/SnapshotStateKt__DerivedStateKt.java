package androidx.compose.runtime;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.IntRef;
import androidx.compose.runtime.internal.SnapshotThreadLocal;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u001A*\u0010\u0003\u001A\u0002H\u0004\"\u0004\b\u0000\u0010\u00042\u0012\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u00040\u0006H\u0082\b¢\u0006\u0004\b\u0007\u0010\b\u001A\"\u0010\t\u001A\b\u0012\u0004\u0012\u0002H\u00040\n\"\u0004\b\u0000\u0010\u00042\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u0002H\u00040\fH\u0007\u001A0\u0010\t\u001A\b\u0012\u0004\u0012\u0002H\u00040\n\"\u0004\b\u0000\u0010\u00042\f\u0010\r\u001A\b\u0012\u0004\u0012\u0002H\u00040\u000E2\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u0002H\u00040\fH\u0007\u001A\u000E\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0000\u001A0\u0010\u0012\u001A\u0002H\u0013\"\u0004\b\u0000\u0010\u00132\n\u0010\u0014\u001A\u0006\u0012\u0002\b\u00030\u00152\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u0002H\u00130\fH\u0082\b¢\u0006\u0004\b\u0016\u0010\u0017\u001A%\u0010\u0018\u001A\u00020\u0019\"\u0004\b\u0000\u0010\u00132\u0006\u0010\u001A\u001A\u00020\u00112\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u0002H\u00130\fH\u0080\b\"\u0014\u0010\u0000\u001A\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001A\u0010\u000F\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001B"}, d2={"calculationBlockNestedLevel", "Landroidx/compose/runtime/internal/SnapshotThreadLocal;", "Landroidx/compose/runtime/internal/IntRef;", "withCalculationNestedLevel", "T", "block", "Lkotlin/Function1;", "withCalculationNestedLevel$SnapshotStateKt__DerivedStateKt", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "derivedStateOf", "Landroidx/compose/runtime/State;", "calculation", "Lkotlin/Function0;", "policy", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "derivedStateObservers", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/runtime/DerivedStateObserver;", "notifyObservers", "R", "derivedState", "Landroidx/compose/runtime/DerivedState;", "notifyObservers$SnapshotStateKt__DerivedStateKt", "(Landroidx/compose/runtime/DerivedState;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "observeDerivedStateRecalculations", "", "observer", "runtime"}, k=5, mv={2, 1, 0}, xi=0x30, xs="androidx/compose/runtime/SnapshotStateKt") final class SnapshotStateKt__DerivedStateKt {
    private static final SnapshotThreadLocal calculationBlockNestedLevel;
    private static final SnapshotThreadLocal derivedStateObservers;

    static {
        SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel = new SnapshotThreadLocal();
        SnapshotStateKt__DerivedStateKt.derivedStateObservers = new SnapshotThreadLocal();
    }

    public static final SnapshotThreadLocal access$getCalculationBlockNestedLevel$p() {
        return SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel;
    }

    public static final MutableVector derivedStateObservers() {
        SnapshotThreadLocal v0 = SnapshotStateKt__DerivedStateKt.derivedStateObservers;
        Object v1 = v0.get();
        if(v1 == null) {
            MutableVector v1_1 = new MutableVector(new DerivedStateObserver[0], 0);
            v0.set(v1_1);
        }

        return ((MutableVector)v1);
    }

    public static final State derivedStateOf(SnapshotMutationPolicy arg1, Function0 arg2) {
        return new DerivedSnapshotState(arg2, arg1);
    }

    public static final State derivedStateOf(Function0 arg2) {
        return new DerivedSnapshotState(arg2, null);
    }

    private static final Object notifyObservers$SnapshotStateKt__DerivedStateKt(DerivedState arg6, Function0 arg7) {
        int v0_1;
        Object v7_1;
        MutableVector v0 = SnapshotStateKt.derivedStateObservers();
        Object[] v1 = v0.content;
        int v2 = v0.getSize();
        int v3 = 0;
        int v4;
        for(v4 = 0; v4 < v2; ++v4) {
            v1[v4].start(arg6);
        }

        try {
            v7_1 = arg7.invoke();
        }
        catch(Throwable v7) {
            v1 = v0.content;
            v0_1 = v0.getSize();
            goto label_22;
        }

        v1 = v0.content;
        v0_1 = v0.getSize();
        goto label_13;
    label_22:
        while(v3 < v0_1) {
            v1[v3].done(arg6);
            ++v3;
        }

        throw v7;
    label_13:
        while(v3 < v0_1) {
            v1[v3].done(arg6);
            ++v3;
        }

        return v7_1;
    }

    public static final void observeDerivedStateRecalculations(DerivedStateObserver arg1, Function0 arg2) {
        MutableVector v0 = SnapshotStateKt.derivedStateObservers();
        try {
            v0.add(arg1);
            arg2.invoke();
        }
        catch(Throwable v1) {
            v0.removeAt(v0.getSize() - 1);
            throw v1;
        }

        v0.removeAt(v0.getSize() - 1);
    }

    private static final Object withCalculationNestedLevel$SnapshotStateKt__DerivedStateKt(Function1 arg2) {
        IntRef v0_1;
        Object v0 = SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel.get();
        if(v0 == null) {
            v0_1 = new IntRef(0);
            SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel.set(v0_1);
        }

        return arg2.invoke(v0_1);
    }
}

