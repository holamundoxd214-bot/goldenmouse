package androidx.compose.runtime;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import androidx.compose.runtime.snapshots.SnapshotStateSet;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlow;

@Metadata(d1={"androidx/compose/runtime/SnapshotStateKt__DerivedStateKt", "androidx/compose/runtime/SnapshotStateKt__ProduceStateKt", "androidx/compose/runtime/SnapshotStateKt__SnapshotFlowKt", "androidx/compose/runtime/SnapshotStateKt__SnapshotMutationPolicyKt", "androidx/compose/runtime/SnapshotStateKt__SnapshotStateKt"}, k=4, mv={2, 1, 0}, xi=0x30) public final class SnapshotStateKt {
    public static final State collectAsState(Flow arg0, Object arg1, CoroutineContext arg2, Composer arg3, int arg4, int arg5) {
        return SnapshotStateKt__SnapshotFlowKt.collectAsState(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    public static final State collectAsState(StateFlow arg0, CoroutineContext arg1, Composer arg2, int arg3, int arg4) {
        return SnapshotStateKt__SnapshotFlowKt.collectAsState(arg0, arg1, arg2, arg3, arg4);
    }

    public static final MutableVector derivedStateObservers() {
        return SnapshotStateKt__DerivedStateKt.derivedStateObservers();
    }

    public static final State derivedStateOf(Function0 arg0) {
        return SnapshotStateKt__DerivedStateKt.derivedStateOf(arg0);
    }

    public static final State derivedStateOf(SnapshotMutationPolicy arg0, Function0 arg1) {
        return SnapshotStateKt__DerivedStateKt.derivedStateOf(arg0, arg1);
    }

    public static final Object getValue(State arg0, Object arg1, KProperty arg2) {
        return SnapshotStateKt__SnapshotStateKt.getValue(arg0, arg1, arg2);
    }

    public static final SnapshotStateList mutableStateListOf(Object[] arg0) {
        return SnapshotStateKt__SnapshotStateKt.mutableStateListOf(arg0);
    }

    public static final SnapshotStateList mutableStateListOf() {
        return SnapshotStateKt__SnapshotStateKt.mutableStateListOf();
    }

    public static final SnapshotStateMap mutableStateMapOf() {
        return SnapshotStateKt__SnapshotStateKt.mutableStateMapOf();
    }

    public static final SnapshotStateMap mutableStateMapOf(Pair[] arg0) {
        return SnapshotStateKt__SnapshotStateKt.mutableStateMapOf(arg0);
    }

    public static final MutableState mutableStateOf(Object arg0, SnapshotMutationPolicy arg1) {
        return SnapshotStateKt__SnapshotStateKt.mutableStateOf(arg0, arg1);
    }

    public static MutableState mutableStateOf$default(Object arg0, SnapshotMutationPolicy arg1, int arg2, Object arg3) {
        return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(arg0, arg1, arg2, arg3);
    }

    public static final SnapshotStateSet mutableStateSetOf() {
        return SnapshotStateKt__SnapshotStateKt.mutableStateSetOf();
    }

    public static final SnapshotStateSet mutableStateSetOf(Object[] arg0) {
        return SnapshotStateKt__SnapshotStateKt.mutableStateSetOf(arg0);
    }

    public static final SnapshotMutationPolicy neverEqualPolicy() {
        return SnapshotStateKt__SnapshotMutationPolicyKt.neverEqualPolicy();
    }

    public static final void observeDerivedStateRecalculations(DerivedStateObserver arg0, Function0 arg1) {
        SnapshotStateKt__DerivedStateKt.observeDerivedStateRecalculations(arg0, arg1);
    }

    public static final State produceState(Object arg0, Function2 arg1, Composer arg2, int arg3) {
        return SnapshotStateKt__ProduceStateKt.produceState(arg0, arg1, arg2, arg3);
    }

    public static final State produceState(Object arg0, Object arg1, Object arg2, Object arg3, Function2 arg4, Composer arg5, int arg6) {
        return SnapshotStateKt__ProduceStateKt.produceState(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
    }

    public static final State produceState(Object arg0, Object arg1, Object arg2, Function2 arg3, Composer arg4, int arg5) {
        return SnapshotStateKt__ProduceStateKt.produceState(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    public static final State produceState(Object arg0, Object arg1, Function2 arg2, Composer arg3, int arg4) {
        return SnapshotStateKt__ProduceStateKt.produceState(arg0, arg1, arg2, arg3, arg4);
    }

    public static final State produceState(Object arg0, Object[] arg1, Function2 arg2, Composer arg3, int arg4) {
        return SnapshotStateKt__ProduceStateKt.produceState(arg0, arg1, arg2, arg3, arg4);
    }

    public static final SnapshotMutationPolicy referentialEqualityPolicy() {
        return SnapshotStateKt__SnapshotMutationPolicyKt.referentialEqualityPolicy();
    }

    public static final State rememberUpdatedState(Object arg0, Composer arg1, int arg2) {
        return SnapshotStateKt__SnapshotStateKt.rememberUpdatedState(arg0, arg1, arg2);
    }

    public static final void setValue(MutableState arg0, Object arg1, KProperty arg2, Object arg3) {
        SnapshotStateKt__SnapshotStateKt.setValue(arg0, arg1, arg2, arg3);
    }

    public static final Flow snapshotFlow(Function0 arg0) {
        return SnapshotStateKt__SnapshotFlowKt.snapshotFlow(arg0);
    }

    public static final Flow snapshotFlow(SnapshotFlowManager arg0, Function0 arg1) {
        return SnapshotStateKt__SnapshotFlowKt.snapshotFlow(arg0, arg1);
    }

    public static final SnapshotMutationPolicy structuralEqualityPolicy() {
        return SnapshotStateKt__SnapshotMutationPolicyKt.structuralEqualityPolicy();
    }

    public static final SnapshotStateList toMutableStateList(Collection arg0) {
        return SnapshotStateKt__SnapshotStateKt.toMutableStateList(arg0);
    }

    public static final SnapshotStateMap toMutableStateMap(Iterable arg0) {
        return SnapshotStateKt__SnapshotStateKt.toMutableStateMap(arg0);
    }
}

