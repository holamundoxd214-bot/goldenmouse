package androidx.compose.runtime;

import java.util.Arrays;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

@Metadata(d1={"\u0000d\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u001B\u0010\u0000\u001A\u00020\u00012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0004\u001A&\u0010\n\u001A\u00020\u00012\u0017\u0010\u0002\u001A\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f0\u000B¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010\u000E\u001A0\u0010\n\u001A\u00020\u00012\b\u0010\u000F\u001A\u0004\u0018\u00010\u00102\u0017\u0010\u0002\u001A\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f0\u000B¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010\u0011\u001A:\u0010\n\u001A\u00020\u00012\b\u0010\u000F\u001A\u0004\u0018\u00010\u00102\b\u0010\u0012\u001A\u0004\u0018\u00010\u00102\u0017\u0010\u0002\u001A\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f0\u000B¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010\u0013\u001AD\u0010\n\u001A\u00020\u00012\b\u0010\u000F\u001A\u0004\u0018\u00010\u00102\b\u0010\u0012\u001A\u0004\u0018\u00010\u00102\b\u0010\u0014\u001A\u0004\u0018\u00010\u00102\u0017\u0010\u0002\u001A\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f0\u000B¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010\u0015\u001A>\u0010\n\u001A\u00020\u00012\u0016\u0010\u0016\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00100\u0017\"\u0004\u0018\u00010\u00102\u0017\u0010\u0002\u001A\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f0\u000B¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010\u0018\u001A6\u0010\u0019\u001A\u00020\u00012\'\u0010\u001A\u001A#\b\u0001\u0012\u0004\u0012\u00020\u001C\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u001D\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u001B¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010\u001E\u001A@\u0010\u0019\u001A\u00020\u00012\b\u0010\u000F\u001A\u0004\u0018\u00010\u00102\'\u0010\u001A\u001A#\b\u0001\u0012\u0004\u0012\u00020\u001C\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u001D\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u001B¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010\u001F\u001AJ\u0010\u0019\u001A\u00020\u00012\b\u0010\u000F\u001A\u0004\u0018\u00010\u00102\b\u0010\u0012\u001A\u0004\u0018\u00010\u00102\'\u0010\u001A\u001A#\b\u0001\u0012\u0004\u0012\u00020\u001C\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u001D\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u001B¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010 \u001AT\u0010\u0019\u001A\u00020\u00012\b\u0010\u000F\u001A\u0004\u0018\u00010\u00102\b\u0010\u0012\u001A\u0004\u0018\u00010\u00102\b\u0010\u0014\u001A\u0004\u0018\u00010\u00102\'\u0010\u001A\u001A#\b\u0001\u0012\u0004\u0012\u00020\u001C\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u001D\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u001B¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010!\u001AN\u0010\u0019\u001A\u00020\u00012\u0016\u0010\u0016\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00100\u0017\"\u0004\u0018\u00010\u00102\'\u0010\u001A\u001A#\b\u0001\u0012\u0004\u0012\u00020\u001C\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u001D\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u001B¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010\"\u001A\u0018\u0010#\u001A\u00020\u001C2\u0006\u0010$\u001A\u00020%2\u0006\u0010&\u001A\u00020\'H\u0001\u001A#\u0010(\u001A\u00020\u001C2\u0013\b\u0006\u0010)\u001A\r\u0012\u0004\u0012\u00020%0\u0003¢\u0006\u0002\b*H\u0087\b¢\u0006\u0002\u0010+\"\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010\u0007\u001A\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\t\u001A\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006,"}, d2={"SideEffect", "", "effect", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "InternalDisposableEffectScope", "Landroidx/compose/runtime/DisposableEffectScope;", "DisposableEffectNoParamError", "", "LaunchedEffectNoParamError", "DisposableEffect", "Lkotlin/Function1;", "Landroidx/compose/runtime/DisposableEffectResult;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "key1", "", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "key2", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "key3", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "keys", "", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "LaunchedEffect", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "createCompositionCoroutineScope", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "composer", "Landroidx/compose/runtime/Composer;", "rememberCoroutineScope", "getContext", "Landroidx/compose/runtime/DisallowComposableCalls;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Lkotlinx/coroutines/CoroutineScope;", "runtime"}, k=2, mv={2, 1, 0}, xi=0x30) public final class EffectsKt {
    private static final String DisposableEffectNoParamError = "DisposableEffect must provide one or more \'key\' parameters that define the identity of the DisposableEffect and determine when its previous effect should be disposed and a new effect started for the new key.";
    private static final DisposableEffectScope InternalDisposableEffectScope = null;
    private static final String LaunchedEffectNoParamError = "LaunchedEffect must provide one or more \'key\' parameters that define the identity of the LaunchedEffect and determine when its previous effect coroutine should be cancelled and a new effect launched for the new key.";

    static {
        EffectsKt.InternalDisposableEffectScope = new DisposableEffectScope();
    }

    public static final void DisposableEffect(Object arg3, Object arg4, Object arg5, Function1 arg6, Composer arg7, int arg8) {
        int v1 = 0xB61E25A1;
        ComposerKt.sourceInformationMarkerStart(arg7, v1, "C(DisposableEffect)N(key1,key2,key3,effect)231@10542L59:Effects.kt#9igjgp");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg8, -1, "androidx.compose.runtime.DisposableEffect (Effects.kt:230)");
        }

        ComposerKt.sourceInformationMarkerStart(arg7, -1490332836, "CC(remember):Effects.kt#9igjgp");
        int v3 = arg7.changed(arg3) | arg7.changed(arg4) | arg7.changed(arg5);
        arg4 = arg7.rememberedValue();
        if(v3 != 0 || arg4 == Composer.Companion.getEmpty()) {
            arg7.updateRememberedValue(new DisposableEffectImpl(arg6));
        }

        ComposerKt.sourceInformationMarkerEnd(arg7);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg7);
    }

    public static final void DisposableEffect(Object arg3, Object arg4, Function1 arg5, Composer arg6, int arg7) {
        int v1 = 0x552E4D01;
        ComposerKt.sourceInformationMarkerStart(arg6, v1, "C(DisposableEffect)N(key1,key2,effect)193@8619L53:Effects.kt#9igjgp");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg7, -1, "androidx.compose.runtime.DisposableEffect (Effects.kt:192)");
        }

        ComposerKt.sourceInformationMarkerStart(arg6, 0xC2CF20B6, "CC(remember):Effects.kt#9igjgp");
        int v3 = arg6.changed(arg3) | arg6.changed(arg4);
        arg4 = arg6.rememberedValue();
        if(v3 != 0 || arg4 == Composer.Companion.getEmpty()) {
            arg6.updateRememberedValue(new DisposableEffectImpl(arg5));
        }

        ComposerKt.sourceInformationMarkerEnd(arg6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg6);
    }

    public static final void DisposableEffect(Object arg3, Function1 arg4, Composer arg5, int arg6) {
        int v1 = 0xAE392461;
        ComposerKt.sourceInformationMarkerStart(arg5, v1, "C(DisposableEffect)N(key1,effect)156@6734L47:Effects.kt#9igjgp");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg6, -1, "androidx.compose.runtime.DisposableEffect (Effects.kt:155)");
        }

        ComposerKt.sourceInformationMarkerStart(arg5, 0x4819E10, "CC(remember):Effects.kt#9igjgp");
        boolean v3 = arg5.changed(arg3);
        Object v6 = arg5.rememberedValue();
        if((v3) || v6 == Composer.Companion.getEmpty()) {
            arg5.updateRememberedValue(new DisposableEffectImpl(arg4));
        }

        ComposerKt.sourceInformationMarkerEnd(arg5);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg5);
    }

    public static final void DisposableEffect(Object[] arg3, Function1 arg4, Composer arg5, int arg6) {
        int v1 = 0xB20F318E;
        ComposerKt.sourceInformationMarkerStart(arg5, v1, "C(DisposableEffect)N(keys,effect)267@12434L48:Effects.kt#9igjgp");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg6, -1, "androidx.compose.runtime.DisposableEffect (Effects.kt:266)");
        }

        arg3 = Arrays.copyOf(arg3, arg3.length);
        ComposerKt.sourceInformationMarkerStart(arg5, 0xDE219177, "CC(remember)N(keys,calculation):Composables.kt#9igjgp");
        arg6 = arg3.length;
        int v0 = 0;
        v1 = 0;
        while(v0 < arg6) {
            v1 |= arg5.changed(arg3[v0]);
            ++v0;
        }

        Object v3 = arg5.rememberedValue();
        if(v1 != 0 || v3 == Composer.Companion.getEmpty()) {
            arg5.updateRememberedValue(new DisposableEffectImpl(arg4));
        }

        ComposerKt.sourceInformationMarkerEnd(arg5);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg5);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="DisposableEffect must provide one or more \'key\' parameters that define the identity of the DisposableEffect and determine when its previous effect should be disposed and a new effect started for the new key.") public static final void DisposableEffect(Function1 arg1, Composer arg2, int arg3) {
        int v0 = -904483903;
        ComposerKt.sourceInformationMarkerStart(arg2, v0, "C(DisposableEffect)N(effect):Effects.kt#9igjgp");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg3, -1, "androidx.compose.runtime.DisposableEffect (Effects.kt:122)");
        }

        throw new IllegalStateException("DisposableEffect must provide one or more \'key\' parameters that define the identity of the DisposableEffect and determine when its previous effect should be disposed and a new effect started for the new key.".toString());
    }

    public static final void LaunchedEffect(Object arg3, Object arg4, Function2 arg5, Composer arg6, int arg7) {
        int v1 = 590241125;
        ComposerKt.sourceInformationMarkerStart(arg6, v1, "C(LaunchedEffect)N(key1,key2,block)365@16604L64:Effects.kt#9igjgp");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg7, -1, "androidx.compose.runtime.LaunchedEffect (Effects.kt:363)");
        }

        CoroutineContext v7 = arg6.getApplyCoroutineContext();
        ComposerKt.sourceInformationMarkerStart(arg6, 0x110CAB65, "CC(remember):Effects.kt#9igjgp");
        int v3 = arg6.changed(arg3) | arg6.changed(arg4);
        arg4 = arg6.rememberedValue();
        if(v3 != 0 || arg4 == Composer.Companion.getEmpty()) {
            arg6.updateRememberedValue(new LaunchedEffectImpl(v7, arg5));
        }

        ComposerKt.sourceInformationMarkerEnd(arg6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg6);
    }

    public static final void LaunchedEffect(Object arg3, Function2 arg4, Composer arg5, int arg6) {
        int v1 = 0x4648F105;
        ComposerKt.sourceInformationMarkerStart(arg5, v1, "C(LaunchedEffect)N(key1,block)346@15603L58:Effects.kt#9igjgp");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg6, -1, "androidx.compose.runtime.LaunchedEffect (Effects.kt:344)");
        }

        CoroutineContext v6 = arg5.getApplyCoroutineContext();
        ComposerKt.sourceInformationMarkerStart(arg5, 0xD7D0D57F, "CC(remember):Effects.kt#9igjgp");
        boolean v3 = arg5.changed(arg3);
        Object v0 = arg5.rememberedValue();
        if((v3) || v0 == Composer.Companion.getEmpty()) {
            arg5.updateRememberedValue(new LaunchedEffectImpl(v6, arg4));
        }

        ComposerKt.sourceInformationMarkerEnd(arg5);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg5);
    }

    public static final void LaunchedEffect(Object arg3, Object arg4, Object arg5, Function2 arg6, Composer arg7, int arg8) {
        int v1 = -54093371;
        ComposerKt.sourceInformationMarkerStart(arg7, v1, "C(LaunchedEffect)N(key1,key2,key3,block)389@17650L70:Effects.kt#9igjgp");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg8, -1, "androidx.compose.runtime.LaunchedEffect (Effects.kt:387)");
        }

        CoroutineContext v8 = arg7.getApplyCoroutineContext();
        ComposerKt.sourceInformationMarkerStart(arg7, -444116053, "CC(remember):Effects.kt#9igjgp");
        int v3 = arg7.changed(arg3) | arg7.changed(arg4) | arg7.changed(arg5);
        arg4 = arg7.rememberedValue();
        if(v3 != 0 || arg4 == Composer.Companion.getEmpty()) {
            arg7.updateRememberedValue(new LaunchedEffectImpl(v8, arg6));
        }

        ComposerKt.sourceInformationMarkerEnd(arg7);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg7);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="LaunchedEffect must provide one or more \'key\' parameters that define the identity of the LaunchedEffect and determine when its previous effect coroutine should be cancelled and a new effect launched for the new key.") public static final void LaunchedEffect(Function2 arg3, Composer arg4, int arg5) {
        int v0 = 0xCFFE54A5;
        arg4 = arg4.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg4, "C(LaunchedEffect)N(block):Effects.kt#9igjgp");
        int v1 = arg5 & 1;
        boolean v2 = v1 != 0 ? true : false;
        if(arg4.shouldExecute(v2, v1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, arg5, -1, "androidx.compose.runtime.LaunchedEffect (Effects.kt:328)");
            }

            throw new IllegalStateException("LaunchedEffect must provide one or more \'key\' parameters that define the identity of the LaunchedEffect and determine when its previous effect coroutine should be cancelled and a new effect launched for the new key.".toString());
        }

        arg4.skipToGroupEnd();
        ScopeUpdateScope v4 = arg4.endRestartGroup();
        if(v4 != null) {
            v4.updateScope(new EffectsKt$$ExternalSyntheticLambda0(arg3, arg5));
        }
    }

    public static final void LaunchedEffect(Object[] arg4, Function2 arg5, Composer arg6, int arg7) {
        int v1 = -139560008;
        ComposerKt.sourceInformationMarkerStart(arg6, v1, "C(LaunchedEffect)N(keys,block)412@18816L59:Effects.kt#9igjgp");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg7, -1, "androidx.compose.runtime.LaunchedEffect (Effects.kt:410)");
        }

        CoroutineContext v7 = arg6.getApplyCoroutineContext();
        arg4 = Arrays.copyOf(arg4, arg4.length);
        ComposerKt.sourceInformationMarkerStart(arg6, 0xDE219177, "CC(remember)N(keys,calculation):Composables.kt#9igjgp");
        int v0 = arg4.length;
        v1 = 0;
        int v2 = 0;
        while(v1 < v0) {
            v2 |= arg6.changed(arg4[v1]);
            ++v1;
        }

        Object v4 = arg6.rememberedValue();
        if(v2 != 0 || v4 == Composer.Companion.getEmpty()) {
            arg6.updateRememberedValue(new LaunchedEffectImpl(v7, arg5));
        }

        ComposerKt.sourceInformationMarkerEnd(arg6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg6);
    }

    static final Unit LaunchedEffect$lambda$0(Function2 arg0, int arg1, Composer arg2, int arg3) {
        EffectsKt.LaunchedEffect(arg0, arg2, RecomposeScopeImplKt.updateChangedFlags(arg1 | 1));
        return Unit.INSTANCE;
    }

    public static final void SideEffect(Function0 arg3, Composer arg4, int arg5) {
        int v1 = 0xB3338EB7;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(SideEffect)N(effect):Effects.kt#9igjgp");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.runtime.SideEffect (Effects.kt:53)");
        }

        arg4.recordSideEffect(arg3);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
    }

    public static final DisposableEffectScope access$getInternalDisposableEffectScope$p() {
        return EffectsKt.InternalDisposableEffectScope;
    }

    public static final CoroutineScope createCompositionCoroutineScope(CoroutineContext arg1, Composer arg2) {
        if(arg1.get(Job.Key) != null) {
            CompletableJob v1 = JobKt.Job$default(null, 1, null);
            v1.completeExceptionally(new IllegalArgumentException("CoroutineContext supplied to rememberCoroutineScope may not include a parent job"));
            return CoroutineScopeKt.CoroutineScope(((CoroutineContext)v1));
        }

        return new RememberedCoroutineScope(arg2.getApplyCoroutineContext(), arg1);
    }

    public static final CoroutineScope rememberCoroutineScope(Function0 arg1, Composer arg2, int arg3, int arg4) {
        CoroutineScope v3_1;
        EffectsKt$rememberCoroutineScope$1 v1;
        ComposerKt.sourceInformationMarkerStart(arg2, 0x2E20B340, "CC(rememberCoroutineScope)N(getContext)616@28039L68:Effects.kt#9igjgp");
        if((arg4 & 1) != 0) {
            v1 = EffectsKt$rememberCoroutineScope$1.INSTANCE;
        }

        ComposerKt.sourceInformationMarkerStart(arg2, 0x28C0FDC4, "CC(remember):Effects.kt#9igjgp");
        Object v3 = arg2.rememberedValue();
        if(v3 == Composer.Companion.getEmpty()) {
            v3_1 = EffectsKt.createCompositionCoroutineScope(((Function0)v1).invoke(), arg2);
            arg2.updateRememberedValue(v3_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg2);
        ComposerKt.sourceInformationMarkerEnd(arg2);
        return v3_1;
    }
}

