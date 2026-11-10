package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import androidx.compose.runtime.snapshots.SnapshotStateSet;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.reflect.KProperty;

@Metadata(d1={"\u0000`\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u001E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001C\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001A1\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001A\u0002H\u00022\u000E\b\u0002\u0010\u0004\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006\u001A4\u0010\u0007\u001A\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\b2\b\u0010\t\u001A\u0004\u0018\u00010\n2\n\u0010\u000B\u001A\u0006\u0012\u0002\b\u00030\fH\u0086\n¢\u0006\u0002\u0010\r\u001A<\u0010\u000E\u001A\u00020\u000F\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\b\u0010\t\u001A\u0004\u0018\u00010\n2\n\u0010\u000B\u001A\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\u0003\u001A\u0002H\u0002H\u0086\n¢\u0006\u0002\u0010\u0010\u001A\u0014\u0010\u0011\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0012\"\u0004\b\u0000\u0010\u0002H\u0007\u001A-\u0010\u0011\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0012\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0013\u001A\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0014\"\u0002H\u0002H\u0007¢\u0006\u0002\u0010\u0015\u001A\u001C\u0010\u0016\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0012\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0017\u001A \u0010\u0018\u001A\u000E\u0012\u0004\u0012\u0002H\u001A\u0012\u0004\u0012\u0002H\u001B0\u0019\"\u0004\b\u0000\u0010\u001A\"\u0004\b\u0001\u0010\u001BH\u0007\u001AQ\u0010\u0018\u001A\u000E\u0012\u0004\u0012\u0002H\u001A\u0012\u0004\u0012\u0002H\u001B0\u0019\"\u0004\b\u0000\u0010\u001A\"\u0004\b\u0001\u0010\u001B2*\u0010\u001C\u001A\u0016\u0012\u0012\b\u0001\u0012\u000E\u0012\u0004\u0012\u0002H\u001A\u0012\u0004\u0012\u0002H\u001B0\u001D0\u0014\"\u000E\u0012\u0004\u0012\u0002H\u001A\u0012\u0004\u0012\u0002H\u001B0\u001DH\u0007¢\u0006\u0002\u0010\u001E\u001A4\u0010\u001F\u001A\u000E\u0012\u0004\u0012\u0002H\u001A\u0012\u0004\u0012\u0002H\u001B0\u0019\"\u0004\b\u0000\u0010\u001A\"\u0004\b\u0001\u0010\u001B*\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u001A\u0012\u0004\u0012\u0002H\u001B0\u001D0 \u001A\u0014\u0010!\u001A\b\u0012\u0004\u0012\u0002H\u00020\"\"\u0004\b\u0000\u0010\u0002H\u0007\u001A-\u0010!\u001A\b\u0012\u0004\u0012\u0002H\u00020\"\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0013\u001A\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0014\"\u0002H\u0002H\u0007¢\u0006\u0002\u0010#\u001A!\u0010$\u001A\b\u0012\u0004\u0012\u0002H\u00020\b\"\u0004\b\u0000\u0010\u00022\u0006\u0010%\u001A\u0002H\u0002H\u0007¢\u0006\u0002\u0010&¨\u0006\'"}, d2={"mutableStateOf", "Landroidx/compose/runtime/MutableState;", "T", "value", "policy", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "(Ljava/lang/Object;Landroidx/compose/runtime/SnapshotMutationPolicy;)Landroidx/compose/runtime/MutableState;", "getValue", "Landroidx/compose/runtime/State;", "thisObj", "", "property", "Lkotlin/reflect/KProperty;", "(Landroidx/compose/runtime/State;Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "", "(Landroidx/compose/runtime/MutableState;Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "mutableStateListOf", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "elements", "", "([Ljava/lang/Object;)Landroidx/compose/runtime/snapshots/SnapshotStateList;", "toMutableStateList", "", "mutableStateMapOf", "Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "K", "V", "pairs", "Lkotlin/Pair;", "([Lkotlin/Pair;)Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "toMutableStateMap", "", "mutableStateSetOf", "Landroidx/compose/runtime/snapshots/SnapshotStateSet;", "([Ljava/lang/Object;)Landroidx/compose/runtime/snapshots/SnapshotStateSet;", "rememberUpdatedState", "newValue", "(Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "runtime"}, k=5, mv={2, 1, 0}, xi=0x30, xs="androidx/compose/runtime/SnapshotStateKt") final class SnapshotStateKt__SnapshotStateKt {
    public static final Object getValue(State arg0, Object arg1, KProperty arg2) {
        return arg0.getValue();
    }

    public static final SnapshotStateList mutableStateListOf() {
        return new SnapshotStateList();
    }

    public static final SnapshotStateList mutableStateListOf(Object[] arg1) {
        SnapshotStateList v0 = new SnapshotStateList();
        v0.addAll(ArraysKt.toList(arg1));
        return v0;
    }

    public static final SnapshotStateMap mutableStateMapOf() {
        return new SnapshotStateMap();
    }

    public static final SnapshotStateMap mutableStateMapOf(Pair[] arg1) {
        SnapshotStateMap v0 = new SnapshotStateMap();
        v0.putAll(MapsKt.toMap(arg1));
        return v0;
    }

    public static final MutableState mutableStateOf(Object arg0, SnapshotMutationPolicy arg1) {
        return SnapshotState_androidKt.createSnapshotMutableState(arg0, arg1);
    }

    public static MutableState mutableStateOf$default(Object arg0, SnapshotMutationPolicy arg1, int arg2, Object arg3) {
        if((arg2 & 2) != 0) {
            arg1 = SnapshotStateKt.structuralEqualityPolicy();
        }

        return SnapshotStateKt.mutableStateOf(arg0, arg1);
    }

    public static final SnapshotStateSet mutableStateSetOf() {
        return new SnapshotStateSet();
    }

    public static final SnapshotStateSet mutableStateSetOf(Object[] arg1) {
        SnapshotStateSet v0 = new SnapshotStateSet();
        v0.addAll(ArraysKt.toSet(arg1));
        return v0;
    }

    public static final State rememberUpdatedState(Object arg3, Composer arg4, int arg5) {
        int v1 = 0xC0EB518E;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(rememberUpdatedState)N(newValue)340@11995L37:SnapshotState.kt#9igjgp");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.runtime.rememberUpdatedState (SnapshotState.kt:340)");
        }

        ComposerKt.sourceInformationMarkerStart(arg4, 0x335D2D73, "CC(remember):SnapshotState.kt#9igjgp");
        Object v5 = arg4.rememberedValue();
        if(v5 == Composer.Companion.getEmpty()) {
            MutableState v5_1 = SnapshotStateKt.mutableStateOf$default(arg3, null, 2, null);
            arg4.updateRememberedValue(v5_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        ((MutableState)v5).setValue(arg3);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return ((State)v5);
    }

    public static final void setValue(MutableState arg0, Object arg1, KProperty arg2, Object arg3) {
        arg0.setValue(arg3);
    }

    public static final SnapshotStateList toMutableStateList(Collection arg1) {
        SnapshotStateList v0 = new SnapshotStateList();
        v0.addAll(arg1);
        return v0;
    }

    public static final SnapshotStateMap toMutableStateMap(Iterable arg1) {
        SnapshotStateMap v0 = new SnapshotStateMap();
        v0.putAll(MapsKt.toMap(arg1));
        return v0;
    }
}

