package androidx.compose.runtime;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u0002\u001AP\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001A\u0002H\u00022-\u0010\u0004\u001A)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0005¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u000B\u001AZ\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001A\u0002H\u00022\b\u0010\f\u001A\u0004\u0018\u00010\t2-\u0010\u0004\u001A)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0005¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\r\u001Ad\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001A\u0002H\u00022\b\u0010\f\u001A\u0004\u0018\u00010\t2\b\u0010\u000E\u001A\u0004\u0018\u00010\t2-\u0010\u0004\u001A)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0005¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u000F\u001An\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001A\u0002H\u00022\b\u0010\f\u001A\u0004\u0018\u00010\t2\b\u0010\u000E\u001A\u0004\u0018\u00010\t2\b\u0010\u0010\u001A\u0004\u0018\u00010\t2-\u0010\u0004\u001A)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0005¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u0011\u001Ah\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001A\u0002H\u00022\u0016\u0010\u0012\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t0\u0013\"\u0004\u0018\u00010\t2-\u0010\u0004\u001A)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0005¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2={"produceState", "Landroidx/compose/runtime/State;", "T", "initialValue", "producer", "Lkotlin/Function2;", "Landroidx/compose/runtime/ProduceStateScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "key1", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "key2", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "key3", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "keys", "", "(Ljava/lang/Object;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "runtime"}, k=5, mv={2, 1, 0}, xi=0x30, xs="androidx/compose/runtime/SnapshotStateKt") final class SnapshotStateKt__ProduceStateKt {
    public static final State produceState(Object arg4, Object arg5, Object arg6, Object arg7, Function2 arg8, Composer arg9, int arg10) {
        MutableState v0_1;
        int v1 = 1807205155;
        ComposerKt.sourceInformationMarkerStart(arg9, v1, "C(produceState)N(initialValue,key1,key2,key3,producer)171@6951L41,172@7030L62,172@6997L95:ProduceState.kt#9igjgp");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg10, -1, "androidx.compose.runtime.produceState (ProduceState.kt:170)");
        }

        String v1_1 = "CC(remember):ProduceState.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(arg9, 1557372076, v1_1);
        Object v0 = arg9.rememberedValue();
        SnapshotMutationPolicy v3 = null;
        if(v0 == Composer.Companion.getEmpty()) {
            v0_1 = SnapshotStateKt.mutableStateOf$default(arg4, v3, 2, v3);
            arg9.updateRememberedValue(v0_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg9);
        ComposerKt.sourceInformationMarkerStart(arg9, 0x5CD3A6A1, v1_1);
        boolean v4 = arg9.changedInstance(arg8);
        Object v1_2 = arg9.rememberedValue();
        if((v4) || v1_2 == Composer.Companion.getEmpty()) {
            SnapshotStateKt__ProduceStateKt$produceState$4$1 v1_3 = new SnapshotStateKt__ProduceStateKt$produceState$4$1(arg8, v0_1, ((Continuation)v3));
            arg9.updateRememberedValue(v1_3);
        }

        ComposerKt.sourceInformationMarkerEnd(arg9);
        Composer v8 = arg9;
        EffectsKt.LaunchedEffect(arg5, arg6, arg7, v1_2, v8, arg10 >> 3 & 0x3FE);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v8);
        return ((State)v0_1);
    }

    public static final State produceState(Object arg4, Object arg5, Object arg6, Function2 arg7, Composer arg8, int arg9) {
        MutableState v0_1;
        int v1 = -1703169085;
        ComposerKt.sourceInformationMarkerStart(arg8, v1, "C(produceState)N(initialValue,key1,key2,producer)139@5573L41,140@5646L62,140@5619L89:ProduceState.kt#9igjgp");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg9, -1, "androidx.compose.runtime.produceState (ProduceState.kt:138)");
        }

        String v1_1 = "CC(remember):ProduceState.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(arg8, 0xEA5DE34C, v1_1);
        Object v0 = arg8.rememberedValue();
        SnapshotMutationPolicy v3 = null;
        if(v0 == Composer.Companion.getEmpty()) {
            v0_1 = SnapshotStateKt.mutableStateOf$default(arg4, v3, 2, v3);
            arg8.updateRememberedValue(v0_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg8);
        ComposerKt.sourceInformationMarkerStart(arg8, 0xEA5DEC81, v1_1);
        boolean v4 = arg8.changedInstance(arg7);
        Object v1_2 = arg8.rememberedValue();
        if((v4) || v1_2 == Composer.Companion.getEmpty()) {
            SnapshotStateKt__ProduceStateKt$produceState$3$1 v1_3 = new SnapshotStateKt__ProduceStateKt$produceState$3$1(arg7, v0_1, ((Continuation)v3));
            arg8.updateRememberedValue(v1_3);
        }

        ComposerKt.sourceInformationMarkerEnd(arg8);
        EffectsKt.LaunchedEffect(arg5, arg6, ((Function2)v1_2), arg8, arg9 >> 3 & 0x7E);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg8);
        return ((State)v0_1);
    }

    public static final State produceState(Object arg4, Object arg5, Function2 arg6, Composer arg7, int arg8) {
        SnapshotStateKt__ProduceStateKt$produceState$2$1 v1_3;
        MutableState v0_1;
        int v1 = 0x8D10F463;
        ComposerKt.sourceInformationMarkerStart(arg7, v1, "C(produceState)N(initialValue,key1,producer)108@4232L41,109@4299L62,109@4278L83:ProduceState.kt#9igjgp");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg8, -1, "androidx.compose.runtime.produceState (ProduceState.kt:107)");
        }

        String v1_1 = "CC(remember):ProduceState.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(arg7, -1935312404, v1_1);
        Object v0 = arg7.rememberedValue();
        SnapshotMutationPolicy v3 = null;
        if(v0 == Composer.Companion.getEmpty()) {
            v0_1 = SnapshotStateKt.mutableStateOf$default(arg4, v3, 2, v3);
            arg7.updateRememberedValue(v0_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg7);
        ComposerKt.sourceInformationMarkerStart(arg7, 0x8CA58261, v1_1);
        boolean v4 = arg7.changedInstance(arg6);
        Object v1_2 = arg7.rememberedValue();
        if((v4) || v1_2 == Composer.Companion.getEmpty()) {
            v1_3 = new SnapshotStateKt__ProduceStateKt$produceState$2$1(arg6, v0_1, ((Continuation)v3));
            arg7.updateRememberedValue(v1_3);
        }

        ComposerKt.sourceInformationMarkerEnd(arg7);
        EffectsKt.LaunchedEffect(arg5, ((Function2)v1_3), arg7, arg8 >> 3 & 14);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg7);
        return ((State)v0_1);
    }

    public static final State produceState(Object arg3, Function2 arg4, Composer arg5, int arg6) {
        int v1 = 0x9F8503;
        ComposerKt.sourceInformationMarkerStart(arg5, v1, "C(produceState)N(initialValue,producer)78@2927L41,79@2994L62,79@2973L83:ProduceState.kt#9igjgp");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg6, -1, "androidx.compose.runtime.produceState (ProduceState.kt:77)");
        }

        String v0 = "CC(remember):ProduceState.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(arg5, 0x56D2608C, v0);
        Object v6 = arg5.rememberedValue();
        SnapshotMutationPolicy v2 = null;
        if(v6 == Composer.Companion.getEmpty()) {
            MutableState v6_1 = SnapshotStateKt.mutableStateOf$default(arg3, v2, 2, v2);
            arg5.updateRememberedValue(v6_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg5);
        Unit v3 = Unit.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(arg5, 1456630017, v0);
        boolean v0_1 = arg5.changedInstance(arg4);
        Object v1_1 = arg5.rememberedValue();
        if((v0_1) || v1_1 == Composer.Companion.getEmpty()) {
            SnapshotStateKt__ProduceStateKt$produceState$1$1 v1_2 = new SnapshotStateKt__ProduceStateKt$produceState$1$1(arg4, ((MutableState)v6), ((Continuation)v2));
            arg5.updateRememberedValue(v1_2);
        }

        ComposerKt.sourceInformationMarkerEnd(arg5);
        EffectsKt.LaunchedEffect(v3, ((Function2)v1_1), arg5, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg5);
        return ((State)v6);
    }

    public static final State produceState(Object arg3, Object[] arg4, Function2 arg5, Composer arg6, int arg7) {
        MutableState v7_1;
        int v1 = 490154582;
        ComposerKt.sourceInformationMarkerStart(arg6, v1, "C(produceState)N(initialValue,keys,producer)201@8274L41,203@8418L62,203@8390L90:ProduceState.kt#9igjgp");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg7, -1, "androidx.compose.runtime.produceState (ProduceState.kt:200)");
        }

        String v0 = "CC(remember):ProduceState.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(arg6, 0xAC15FFFF, v0);
        Object v7 = arg6.rememberedValue();
        SnapshotMutationPolicy v2 = null;
        if(v7 == Composer.Companion.getEmpty()) {
            v7_1 = SnapshotStateKt.mutableStateOf$default(arg3, v2, 2, v2);
            arg6.updateRememberedValue(v7_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg6);
        Object[] v3 = Arrays.copyOf(arg4, arg4.length);
        ComposerKt.sourceInformationMarkerStart(arg6, -1407839724, v0);
        boolean v4 = arg6.changedInstance(arg5);
        Object v0_1 = arg6.rememberedValue();
        if((v4) || v0_1 == Composer.Companion.getEmpty()) {
            SnapshotStateKt__ProduceStateKt$produceState$5$1 v0_2 = new SnapshotStateKt__ProduceStateKt$produceState$5$1(arg5, v7_1, ((Continuation)v2));
            arg6.updateRememberedValue(v0_2);
        }

        ComposerKt.sourceInformationMarkerEnd(arg6);
        EffectsKt.LaunchedEffect(v3, ((Function2)v0_1), arg6, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg6);
        return ((State)v7_1);
    }
}

