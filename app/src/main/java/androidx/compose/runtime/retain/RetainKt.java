package androidx.compose.runtime.retain;

import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000(\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A&\u0010\u0000\u001A\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u00012\u000E\b\b\u0010\u0002\u001A\b\u0012\u0004\u0012\u0002H\u00010\u0003H\u0087\b¢\u0006\u0002\u0010\u0004\u001A>\u0010\u0000\u001A\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u00012\u0016\u0010\u0005\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00070\u0006\"\u0004\u0018\u00010\u00072\u000E\b\b\u0010\u0002\u001A\b\u0012\u0004\u0012\u0002H\u00010\u0003H\u0087\b¢\u0006\u0002\u0010\b\u001A)\u0010\u0000\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\t\u001A\u00020\n2\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u0002H\u00010\u0003H\u0001¢\u0006\u0002\u0010\u000B\u001AA\u0010\u0000\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\t\u001A\u00020\n2\u0016\u0010\u0005\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00070\u0006\"\u0004\u0018\u00010\u00072\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u0002H\u00010\u0003H\u0001¢\u0006\u0002\u0010\f\u001A)\u0010\r\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u000E\u001A\u00020\u000F2\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u0002H\u00010\u0003H\u0003¢\u0006\u0002\u0010\u0010\"\u000E\u0010\u0011\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2={"retain", "T", "calculation", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Ljava/lang/Object;", "keys", "", "", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Ljava/lang/Object;", "typeHash", "", "(ILkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Ljava/lang/Object;", "(I[Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Ljava/lang/Object;", "retainImpl", "key", "Landroidx/compose/runtime/retain/RetainKeys;", "(Landroidx/compose/runtime/retain/RetainKeys;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Ljava/lang/Object;", "RetainedValuesStoreMissingValue", "runtime-retain"}, k=2, mv={2, 1, 0}, xi=0x30) public final class RetainKt {
    private static final Object RetainedValuesStoreMissingValue;

    public static Unit $r8$lambda$fRDZK3WeXVGFDPV5GVDN5_QvoPk(RetainedValueHolder arg0, RetainedValuesStore arg1) {
        return RetainKt.retainImpl$lambda$1$0(arg0, arg1);
    }

    static {
        RetainKt.RetainedValuesStoreMissingValue = new Object();
    }

    public static final Object retain(int arg4, Function0 arg5, Composer arg6, int arg7) {
        int v1 = 663053747;
        ComposerKt.sourceInformationMarkerStart(arg6, v1, "C(retain)N(typeHash,calculation)200@11339L27,196@11228L232:Retain.kt#3my55w");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg7, -1, "androidx.compose.runtime.retain.retain (Retain.kt:195)");
        }

        Object v4 = RetainKt.retainImpl(new RetainKeys(null, ComposablesKt.getCurrentCompositeKeyHashCode(arg6, 0), arg4), arg5, arg6, arg7 & 0x70);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg6);
        return v4;
    }

    public static final Object retain(int arg3, Object[] arg4, Function0 arg5, Composer arg6, int arg7) {
        int v1 = 0x7E53AE06;
        ComposerKt.sourceInformationMarkerStart(arg6, v1, "C(retain)N(typeHash,keys,calculation)214@11697L27,210@11586L232:Retain.kt#3my55w");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg7, -1, "androidx.compose.runtime.retain.retain (Retain.kt:209)");
        }

        Object v3 = RetainKt.retainImpl(new RetainKeys(arg4, ComposablesKt.getCurrentCompositeKeyHashCode(arg6, 0), arg3), arg5, arg6, arg7 >> 3 & 0x70);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg6);
        return v3;
    }

    public static final Object retain(Function0 arg2, Composer arg3, int arg4) {
        ComposerKt.sourceInformationMarkerStart(arg3, -1709446474, "CC(retain)N(calculation)99@5407L60:Retain.kt#3my55w");
        Intrinsics.reifiedOperationMarker(4, "T");
        Object v2 = RetainKt.retain(Object.class.getName().hashCode(), arg2, arg3, arg4 << 3 & 0x70);
        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v2;
    }

    public static final Object retain(Object[] arg2, Function0 arg3, Composer arg4, int arg5) {
        ComposerKt.sourceInformationMarkerStart(arg4, 0x63E524C9, "CC(retain)N(keys,calculation)190@11048L73:Retain.kt#3my55w");
        Intrinsics.reifiedOperationMarker(4, "T");
        Object v2 = RetainKt.retain(Object.class.getName().hashCode(), Arrays.copyOf(arg2, arg2.length), arg3, arg4, arg5 << 3 & 0x380);
        ComposerKt.sourceInformationMarkerEnd(arg4);
        return v2;
    }

    private static final Object retainImpl(RetainKeys arg6, Function0 arg7, Composer arg8, int arg9) {
        RetainKt$$ExternalSyntheticLambda0 v7_1;
        int v1 = 0x22C19A3F;
        ComposerKt.sourceInformationMarkerStart(arg8, v1, "C(retainImpl)N(key,calculation)223@11960L7,225@11993L824:Retain.kt#3my55w");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg9, -1, "androidx.compose.runtime.retain.retainImpl (Retain.kt:222)");
        }

        ProvidableCompositionLocal v0 = LocalRetainedValuesStoreKt.getLocalRetainedValuesStore();
        ComposerKt.sourceInformationMarkerStart(arg8, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v0_1 = arg8.consume(((CompositionLocal)v0));
        ComposerKt.sourceInformationMarkerEnd(arg8);
        String v2 = "CC(remember):Retain.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(arg8, 2026118295, v2);
        int v4 = 4;
        arg9 = (arg9 & 14 ^ 6) > v4 && (arg8.changed(arg6)) || (arg9 & 6) == v4 ? 1 : 0;
        Object v1_1 = arg8.rememberedValue();
        if(arg9 != 0 || v1_1 == Composer.Companion.getEmpty()) {
            Object v9 = RetainKt.RetainedValuesStoreMissingValue;
            v1_1 = ((RetainedValuesStore)v0_1).consumeExitedValueOrDefault(arg6, v9);
            RetainedValueHolder v1_2 = v1_1 != v9 ? new RetainedValueHolder(arg6, v1_1, ((RetainedValuesStore)v0_1), false) : new RetainedValueHolder(arg6, arg7.invoke(), ((RetainedValuesStore)v0_1), true);
            arg8.updateRememberedValue(v1_2);
        }

        ComposerKt.sourceInformationMarkerEnd(arg8);
        if(((RetainedValueHolder)v1_1).getOwner() != v0_1) {
            arg8.startReplaceGroup(-1614000612);
            ComposerKt.sourceInformation(arg8, "250@12886L44,250@12875L55");
            ComposerKt.sourceInformationMarkerStart(arg8, 2026146091, v2);
            int v6 = arg8.changedInstance(v1_1) | arg8.changedInstance(v0_1);
            Object v7 = arg8.rememberedValue();
            if(v6 != 0 || v7 == Composer.Companion.getEmpty()) {
                v7_1 = new RetainKt$$ExternalSyntheticLambda0(((RetainedValueHolder)v1_1), ((RetainedValuesStore)v0_1));
                arg8.updateRememberedValue(v7_1);
            }

            ComposerKt.sourceInformationMarkerEnd(arg8);
            EffectsKt.SideEffect(((Function0)v7_1), arg8, 0);
            arg8.endReplaceGroup();
        }
        else {
            arg8.startReplaceGroup(0x9FCD58A3);
            arg8.endReplaceGroup();
        }

        Object v6_1 = ((RetainedValueHolder)v1_1).getValue();
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg8);
        return v6_1;
    }

    private static final Unit retainImpl$lambda$1$0(RetainedValueHolder arg0, RetainedValuesStore arg1) {
        arg0.readoptUnder$runtime_retain(arg1);
        return Unit.INSTANCE;
    }
}

