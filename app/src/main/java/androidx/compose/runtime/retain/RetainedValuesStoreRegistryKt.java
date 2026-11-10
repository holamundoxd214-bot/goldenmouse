package androidx.compose.runtime.retain;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\r\u0010\u0000\u001A\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2={"retainRetainedValuesStoreRegistry", "Landroidx/compose/runtime/retain/RetainedValuesStoreRegistry;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/retain/RetainedValuesStoreRegistry;", "runtime-retain"}, k=2, mv={2, 1, 0}, xi=0x30) public final class RetainedValuesStoreRegistryKt {
    public static RetainedValuesStoreRegistryWrapper $r8$lambda$XmK5EVT5ZmVv2MNTDNRECFWB58E() {
        return RetainedValuesStoreRegistryKt.retainRetainedValuesStoreRegistry$lambda$0$0();
    }

    public static final RetainedValuesStoreRegistry retainRetainedValuesStoreRegistry(Composer arg3, int arg4) {
        RetainedValuesStoreRegistryKt$$ExternalSyntheticLambda0 v4_1;
        int v1 = -1800021473;
        ComposerKt.sourceInformationMarkerStart(arg3, v1, "C(retainRetainedValuesStoreRegistry)146@7406L40,146@7399L47:RetainedValuesStoreRegistry.kt#3my55w");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg4, -1, "androidx.compose.runtime.retain.retainRetainedValuesStoreRegistry (RetainedValuesStoreRegistry.kt:145)");
        }

        ComposerKt.sourceInformationMarkerStart(arg3, 1051187623, "CC(remember):RetainedValuesStoreRegistry.kt#9igjgp");
        Object v4 = arg3.rememberedValue();
        if(v4 == Composer.Companion.getEmpty()) {
            v4_1 = new RetainedValuesStoreRegistryKt$$ExternalSyntheticLambda0();
            arg3.updateRememberedValue(v4_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        ComposerKt.sourceInformationMarkerStart(arg3, -1709446474, "CC(retain)N(calculation)99@5407L60:Retain.kt#3my55w");
        v4 = RetainKt.retain("androidx.compose.runtime.retain.RetainedValuesStoreRegistryWrapper".hashCode(), ((Function0)v4_1), arg3, 0x30);
        ComposerKt.sourceInformationMarkerEnd(arg3);
        RetainedValuesStoreRegistry v4_2 = ((RetainedValuesStoreRegistryWrapper)v4).getRetainedValuesStoreRegistry();
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v4_2;
    }

    private static final RetainedValuesStoreRegistryWrapper retainRetainedValuesStoreRegistry$lambda$0$0() {
        return new RetainedValuesStoreRegistryWrapper();
    }
}

