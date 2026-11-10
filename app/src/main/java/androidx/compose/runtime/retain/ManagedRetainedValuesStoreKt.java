package androidx.compose.runtime.retain;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\r\u0010\u0000\u001A\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2={"retainManagedRetainedValuesStore", "Landroidx/compose/runtime/retain/ManagedRetainedValuesStore;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/retain/ManagedRetainedValuesStore;", "runtime-retain"}, k=2, mv={2, 1, 0}, xi=0x30) public final class ManagedRetainedValuesStoreKt {
    public static RetainManagedRetainedValuesStoreWrapper $r8$lambda$1qtlAUVzXpfX3iO2uw0YvjAW-_E() {
        return ManagedRetainedValuesStoreKt.retainManagedRetainedValuesStore$lambda$0$0();
    }

    public static final ManagedRetainedValuesStore retainManagedRetainedValuesStore(Composer arg3, int arg4) {
        ManagedRetainedValuesStoreKt$$ExternalSyntheticLambda0 v4_1;
        int v1 = 0x327F3E81;
        ComposerKt.sourceInformationMarkerStart(arg3, v1, "C(retainManagedRetainedValuesStore)173@7355L45,173@7348L52:ManagedRetainedValuesStore.kt#3my55w");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg4, -1, "androidx.compose.runtime.retain.retainManagedRetainedValuesStore (ManagedRetainedValuesStore.kt:172)");
        }

        ComposerKt.sourceInformationMarkerStart(arg3, 0x8FA9AD4E, "CC(remember):ManagedRetainedValuesStore.kt#9igjgp");
        Object v4 = arg3.rememberedValue();
        if(v4 == Composer.Companion.getEmpty()) {
            v4_1 = new ManagedRetainedValuesStoreKt$$ExternalSyntheticLambda0();
            arg3.updateRememberedValue(v4_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        ComposerKt.sourceInformationMarkerStart(arg3, -1709446474, "CC(retain)N(calculation)99@5407L60:Retain.kt#3my55w");
        v4 = RetainKt.retain("androidx.compose.runtime.retain.RetainManagedRetainedValuesStoreWrapper".hashCode(), ((Function0)v4_1), arg3, 0x30);
        ComposerKt.sourceInformationMarkerEnd(arg3);
        ManagedRetainedValuesStore v4_2 = ((RetainManagedRetainedValuesStoreWrapper)v4).getRetainedValuesStore();
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v4_2;
    }

    private static final RetainManagedRetainedValuesStoreWrapper retainManagedRetainedValuesStore$lambda$0$0() {
        return new RetainManagedRetainedValuesStoreWrapper();
    }
}

