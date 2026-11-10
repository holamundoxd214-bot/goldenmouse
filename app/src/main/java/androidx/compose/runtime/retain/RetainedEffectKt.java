package androidx.compose.runtime.retain;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import java.util.Arrays;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0002\u001A&\u0010\u0002\u001A\u00020\u00032\u0017\u0010\u0004\u001A\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007H\u0007¢\u0006\u0002\u0010\b\u001A0\u0010\u0002\u001A\u00020\u00032\b\u0010\u000B\u001A\u0004\u0018\u00010\f2\u0017\u0010\u0004\u001A\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007H\u0007¢\u0006\u0002\u0010\r\u001A:\u0010\u0002\u001A\u00020\u00032\b\u0010\u000B\u001A\u0004\u0018\u00010\f2\b\u0010\u000E\u001A\u0004\u0018\u00010\f2\u0017\u0010\u0004\u001A\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007H\u0007¢\u0006\u0002\u0010\u000F\u001AD\u0010\u0002\u001A\u00020\u00032\b\u0010\u000B\u001A\u0004\u0018\u00010\f2\b\u0010\u000E\u001A\u0004\u0018\u00010\f2\b\u0010\u0010\u001A\u0004\u0018\u00010\f2\u0017\u0010\u0004\u001A\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007H\u0007¢\u0006\u0002\u0010\u0011\u001A>\u0010\u0002\u001A\u00020\u00032\u0016\u0010\u0012\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\f0\u0013\"\u0004\u0018\u00010\f2\u0017\u0010\u0004\u001A\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007H\u0007¢\u0006\u0002\u0010\u0014\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010\t\u001A\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2={"InternalRetainedEffectScope", "Landroidx/compose/runtime/retain/RetainedEffectScope;", "RetainedEffect", "", "effect", "Lkotlin/Function1;", "Landroidx/compose/runtime/retain/RetainedEffectResult;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "RetainedEffectNoParamError", "", "key1", "", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "key2", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "key3", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "keys", "", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "runtime-retain"}, k=2, mv={2, 1, 0}, xi=0x30) public final class RetainedEffectKt {
    private static final RetainedEffectScope InternalRetainedEffectScope = null;
    private static final String RetainedEffectNoParamError = "RetainedEffect must provide one or more \'key\' parameters that define the identity of the RetainedEffect and determine when its previous effect should be disposed and a new effect started for the new key.";

    public static RetainedEffectImpl $r8$lambda$AlzYydFrcRIUfH5vXX3VHGNy2es(Function1 arg0) {
        return RetainedEffectKt.RetainedEffect$lambda$3$0(arg0);
    }

    public static RetainedEffectImpl $r8$lambda$JdoCXZSZdH0BeFQu6HSFsrNlUB8(Function1 arg0) {
        return RetainedEffectKt.RetainedEffect$lambda$0$0(arg0);
    }

    public static RetainedEffectImpl $r8$lambda$PHuGca6QqvgWQfn5FmRPgFG8Bw4(Function1 arg0) {
        return RetainedEffectKt.RetainedEffect$lambda$1$0(arg0);
    }

    public static RetainedEffectImpl $r8$lambda$X0tVzh811_5O716hMBVVEgjvF8k(Function1 arg0) {
        return RetainedEffectKt.RetainedEffect$lambda$2$0(arg0);
    }

    static {
        RetainedEffectKt.InternalRetainedEffectScope = new RetainedEffectScope();
    }

    public static final void RetainedEffect(Object arg3, Object arg4, Object arg5, Function1 arg6, Composer arg7, int arg8) {
        RetainedEffectKt$$ExternalSyntheticLambda2 v8_1;
        int v1 = 130977115;
        ComposerKt.sourceInformationMarkerStart(arg7, v1, "C(RetainedEffect)N(key1,key2,key3,effect)244@12015L30,244@11990L55:RetainedEffect.kt#3my55w");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg8, -1, "androidx.compose.runtime.retain.RetainedEffect (RetainedEffect.kt:243)");
        }

        Object[] v3 = new Object[]{arg3, arg4, arg5};
        ComposerKt.sourceInformationMarkerStart(arg7, 0x4E60B6D9, "CC(remember):RetainedEffect.kt#9igjgp");
        int v0 = 0x800;
        int v4 = (arg8 & 0x1C00 ^ 0xC00) > v0 && (arg7.changed(arg6)) || (arg8 & 0xC00) == v0 ? 1 : 0;
        Object v8 = arg7.rememberedValue();
        if(v4 != 0 || v8 == Composer.Companion.getEmpty()) {
            v8_1 = new RetainedEffectKt$$ExternalSyntheticLambda2(arg6);
            arg7.updateRememberedValue(v8_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg7);
        ComposerKt.sourceInformationMarkerStart(arg7, 0x63E524C9, "CC(retain)N(keys,calculation)190@11048L73:Retain.kt#3my55w");
        RetainKt.retain("androidx.compose.runtime.retain.RetainedEffectImpl".hashCode(), Arrays.copyOf(v3, 3), ((Function0)v8_1), arg7, 0);
        ComposerKt.sourceInformationMarkerEnd(arg7);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg7);
    }

    public static final void RetainedEffect(Object arg3, Object arg4, Function1 arg5, Composer arg6, int arg7) {
        int v1 = 0xDC9F2EBB;
        ComposerKt.sourceInformationMarkerStart(arg6, v1, "C(RetainedEffect)N(key1,key2,effect)191@9038L30,191@9019L49:RetainedEffect.kt#3my55w");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg7, -1, "androidx.compose.runtime.retain.RetainedEffect (RetainedEffect.kt:190)");
        }

        Object[] v3 = new Object[]{arg3, arg4};
        ComposerKt.sourceInformationMarkerStart(arg6, 0x318E7D79, "CC(remember):RetainedEffect.kt#9igjgp");
        v1 = 0x100;
        int v4 = (arg7 & 0x380 ^ 0x180) > v1 && (arg6.changed(arg5)) || (arg7 & 0x180) == v1 ? 1 : 0;
        Object v7 = arg6.rememberedValue();
        if(v4 != 0 || v7 == Composer.Companion.getEmpty()) {
            RetainedEffectKt$$ExternalSyntheticLambda0 v7_1 = new RetainedEffectKt$$ExternalSyntheticLambda0(arg5);
            arg6.updateRememberedValue(v7_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg6);
        ComposerKt.sourceInformationMarkerStart(arg6, 0x63E524C9, "CC(retain)N(keys,calculation)190@11048L73:Retain.kt#3my55w");
        RetainKt.retain("androidx.compose.runtime.retain.RetainedEffectImpl".hashCode(), Arrays.copyOf(v3, 2), ((Function0)v7), arg6, 0);
        ComposerKt.sourceInformationMarkerEnd(arg6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg6);
    }

    public static final void RetainedEffect(Object arg4, Function1 arg5, Composer arg6, int arg7) {
        int v1 = 0x2B7801B;
        ComposerKt.sourceInformationMarkerStart(arg6, v1, "C(RetainedEffect)N(key1,effect)139@6101L30,139@6088L43:RetainedEffect.kt#3my55w");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg7, -1, "androidx.compose.runtime.retain.RetainedEffect (RetainedEffect.kt:138)");
        }

        Object[] v4 = new Object[]{arg4};
        ComposerKt.sourceInformationMarkerStart(arg6, 0x32D7F2B9, "CC(remember):RetainedEffect.kt#9igjgp");
        int v2 = 0x20;
        arg7 = (arg7 & 0x70 ^ 0x30) > v2 && (arg6.changed(arg5)) || (arg7 & 0x30) == v2 ? 1 : 0;
        Object v0 = arg6.rememberedValue();
        if(arg7 != 0 || v0 == Composer.Companion.getEmpty()) {
            RetainedEffectKt$$ExternalSyntheticLambda1 v0_1 = new RetainedEffectKt$$ExternalSyntheticLambda1(arg5);
            arg6.updateRememberedValue(v0_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg6);
        ComposerKt.sourceInformationMarkerStart(arg6, 0x63E524C9, "CC(retain)N(keys,calculation)190@11048L73:Retain.kt#3my55w");
        RetainKt.retain("androidx.compose.runtime.retain.RetainedEffectImpl".hashCode(), Arrays.copyOf(v4, 1), ((Function0)v0), arg6, 0);
        ComposerKt.sourceInformationMarkerEnd(arg6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg6);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="RetainedEffect must provide one or more \'key\' parameters that define the identity of the RetainedEffect and determine when its previous effect should be disposed and a new effect started for the new key.") public static final void RetainedEffect(Function1 arg1, Composer arg2, int arg3) {
        int v0 = 0x316F817B;
        ComposerKt.sourceInformationMarkerStart(arg2, v0, "C(RetainedEffect)N(effect):RetainedEffect.kt#3my55w");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg3, -1, "androidx.compose.runtime.retain.RetainedEffect (RetainedEffect.kt:87)");
        }

        throw new IllegalStateException("RetainedEffect must provide one or more \'key\' parameters that define the identity of the RetainedEffect and determine when its previous effect should be disposed and a new effect started for the new key.".toString());
    }

    public static final void RetainedEffect(Object[] arg3, Function1 arg4, Composer arg5, int arg6) {
        int v1 = 0x2A7F6988;
        ComposerKt.sourceInformationMarkerStart(arg5, v1, "C(RetainedEffect)N(keys,effect)294@14888L30,294@14874L44:RetainedEffect.kt#3my55w");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg6, -1, "androidx.compose.runtime.retain.RetainedEffect (RetainedEffect.kt:293)");
        }

        arg3 = Arrays.copyOf(arg3, arg3.length);
        ComposerKt.sourceInformationMarkerStart(arg5, -2008336570, "CC(remember):RetainedEffect.kt#9igjgp");
        int v2 = 0x20;
        arg6 = (arg6 & 0x70 ^ 0x30) > v2 && (arg5.changed(arg4)) || (arg6 & 0x30) == v2 ? 1 : 0;
        Object v0 = arg5.rememberedValue();
        if(arg6 != 0 || v0 == Composer.Companion.getEmpty()) {
            RetainedEffectKt$$ExternalSyntheticLambda3 v0_1 = new RetainedEffectKt$$ExternalSyntheticLambda3(arg4);
            arg5.updateRememberedValue(v0_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg5);
        ComposerKt.sourceInformationMarkerStart(arg5, 0x63E524C9, "CC(retain)N(keys,calculation)190@11048L73:Retain.kt#3my55w");
        RetainKt.retain("androidx.compose.runtime.retain.RetainedEffectImpl".hashCode(), Arrays.copyOf(arg3, arg3.length), ((Function0)v0), arg5, 0);
        ComposerKt.sourceInformationMarkerEnd(arg5);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg5);
    }

    private static final RetainedEffectImpl RetainedEffect$lambda$0$0(Function1 arg1) {
        return new RetainedEffectImpl(arg1);
    }

    private static final RetainedEffectImpl RetainedEffect$lambda$1$0(Function1 arg1) {
        return new RetainedEffectImpl(arg1);
    }

    private static final RetainedEffectImpl RetainedEffect$lambda$2$0(Function1 arg1) {
        return new RetainedEffectImpl(arg1);
    }

    private static final RetainedEffectImpl RetainedEffect$lambda$3$0(Function1 arg1) {
        return new RetainedEffectImpl(arg1);
    }

    public static final RetainedEffectScope access$getInternalRetainedEffectScope$p() {
        return RetainedEffectKt.InternalRetainedEffectScope;
    }
}

