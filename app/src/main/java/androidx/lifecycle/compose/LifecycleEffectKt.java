package androidx.lifecycle.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.SpreadBuilder;

@Metadata(d1={"\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001A-\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007¢\u0006\u0002\u0010\b\u001A:\u0010\t\u001A\u00020\u00012\b\u0010\n\u001A\u0004\u0018\u00010\u000B2\b\b\u0002\u0010\u0004\u001A\u00020\u00052\u0017\u0010\f\u001A\u0013\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u000F0\r¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0011\u001AD\u0010\t\u001A\u00020\u00012\b\u0010\n\u001A\u0004\u0018\u00010\u000B2\b\u0010\u0012\u001A\u0004\u0018\u00010\u000B2\b\b\u0002\u0010\u0004\u001A\u00020\u00052\u0017\u0010\f\u001A\u0013\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u000F0\r¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0013\u001AN\u0010\t\u001A\u00020\u00012\b\u0010\n\u001A\u0004\u0018\u00010\u000B2\b\u0010\u0012\u001A\u0004\u0018\u00010\u000B2\b\u0010\u0014\u001A\u0004\u0018\u00010\u000B2\b\b\u0002\u0010\u0004\u001A\u00020\u00052\u0017\u0010\f\u001A\u0013\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u000F0\r¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0015\u001AH\u0010\t\u001A\u00020\u00012\u0016\u0010\u0016\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000B0\u0017\"\u0004\u0018\u00010\u000B2\b\b\u0002\u0010\u0004\u001A\u00020\u00052\u0017\u0010\f\u001A\u0013\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u000F0\r¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0018\u001A0\u0010\t\u001A\u00020\u00012\b\b\u0002\u0010\u0004\u001A\u00020\u00052\u0017\u0010\f\u001A\u0013\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u000F0\r¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u001B\u001A6\u0010\u001C\u001A\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u001D\u001A\u00020\u000E2\u0017\u0010\f\u001A\u0013\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u000F0\r¢\u0006\u0002\b\u0010H\u0003¢\u0006\u0002\u0010\u001E\u001A:\u0010\u001F\u001A\u00020\u00012\b\u0010\n\u001A\u0004\u0018\u00010\u000B2\b\b\u0002\u0010\u0004\u001A\u00020\u00052\u0017\u0010\f\u001A\u0013\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\r¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0011\u001AD\u0010\u001F\u001A\u00020\u00012\b\u0010\n\u001A\u0004\u0018\u00010\u000B2\b\u0010\u0012\u001A\u0004\u0018\u00010\u000B2\b\b\u0002\u0010\u0004\u001A\u00020\u00052\u0017\u0010\f\u001A\u0013\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\r¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0013\u001AN\u0010\u001F\u001A\u00020\u00012\b\u0010\n\u001A\u0004\u0018\u00010\u000B2\b\u0010\u0012\u001A\u0004\u0018\u00010\u000B2\b\u0010\u0014\u001A\u0004\u0018\u00010\u000B2\b\b\u0002\u0010\u0004\u001A\u00020\u00052\u0017\u0010\f\u001A\u0013\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\r¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0015\u001AH\u0010\u001F\u001A\u00020\u00012\u0016\u0010\u0016\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000B0\u0017\"\u0004\u0018\u00010\u000B2\b\b\u0002\u0010\u0004\u001A\u00020\u00052\u0017\u0010\f\u001A\u0013\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\r¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0018\u001A0\u0010\u001F\u001A\u00020\u00012\b\b\u0002\u0010\u0004\u001A\u00020\u00052\u0017\u0010\f\u001A\u0013\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\r¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u001B\u001A6\u0010#\u001A\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u001D\u001A\u00020 2\u0017\u0010\f\u001A\u0013\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\r¢\u0006\u0002\b\u0010H\u0003¢\u0006\u0002\u0010$\"\u000E\u0010\u0019\u001A\u00020\u001AX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\"\u001A\u00020\u001AX\u0082T¢\u0006\u0002\n\u0000¨\u0006%²\u0006\u0010\u0010&\u001A\b\u0012\u0004\u0012\u00020\u00010\u0007X\u008A\u0084\u0002"}, d2={"LifecycleEventEffect", "", "event", "Landroidx/lifecycle/Lifecycle$Event;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "onEvent", "Lkotlin/Function0;", "(Landroidx/lifecycle/Lifecycle$Event;Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "LifecycleStartEffect", "key1", "", "effects", "Lkotlin/Function1;", "Landroidx/lifecycle/compose/LifecycleStartStopEffectScope;", "Landroidx/lifecycle/compose/LifecycleStopOrDisposeEffectResult;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "key2", "(Ljava/lang/Object;Ljava/lang/Object;Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "key3", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "keys", "", "([Ljava/lang/Object;Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "LifecycleStartEffectNoParamError", "", "(Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "LifecycleStartEffectImpl", "scope", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/compose/LifecycleStartStopEffectScope;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "LifecycleResumeEffect", "Landroidx/lifecycle/compose/LifecycleResumePauseEffectScope;", "Landroidx/lifecycle/compose/LifecyclePauseOrDisposeEffectResult;", "LifecycleResumeEffectNoParamError", "LifecycleResumeEffectImpl", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/compose/LifecycleResumePauseEffectScope;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "lifecycle-runtime-compose", "currentOnEvent"}, k=2, mv={2, 1, 0}, xi=0x30) public final class LifecycleEffectKt {
    @Metadata(k=3, mv={2, 1, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[Event.values().length];
            try {
                v0[Event.ON_START.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[Event.ON_STOP.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[Event.ON_RESUME.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_15:
                            v0[Event.ON_PAUSE.ordinal()] = 4;
                            goto label_19;
                        }
                        catch(NoSuchFieldError ) {
                        label_19:
                            WhenMappings.$EnumSwitchMapping$0 = v0;
                            return;
                        }
                    }
                }
            }
        }
    }

    private static final String LifecycleResumeEffectNoParamError = "LifecycleResumeEffect must provide one or more \'key\' parameters that define the identity of the LifecycleResumeEffect and determine when its previous effect coroutine should be cancelled and a new effect launched for the new key.";
    private static final String LifecycleStartEffectNoParamError = "LifecycleStartEffect must provide one or more \'key\' parameters that define the identity of the LifecycleStartEffect and determine when its previous effect coroutine should be cancelled and a new effect launched for the new key.";

    public static void $r8$lambda$A6QyfzS99xVcWsa9fXn_JRBHe1Q(Event arg0, State arg1, LifecycleOwner arg2, Event arg3) {
        LifecycleEffectKt.LifecycleEventEffect$lambda$1$0$0(arg0, arg1, arg2, arg3);
    }

    public static void $r8$lambda$QY7v88a473xDOMs5julNK5kYLk8(LifecycleStartStopEffectScope arg0, ObjectRef arg1, Function1 arg2, LifecycleOwner arg3, Event arg4) {
        LifecycleEffectKt.LifecycleStartEffectImpl$lambda$0$0$0(arg0, arg1, arg2, arg3, arg4);
    }

    public static DisposableEffectResult $r8$lambda$hYU7toFu4qU05Pf6QAbM48SVc_g(LifecycleOwner arg0, LifecycleResumePauseEffectScope arg1, Function1 arg2, DisposableEffectScope arg3) {
        return LifecycleEffectKt.LifecycleResumeEffectImpl$lambda$0$0(arg0, arg1, arg2, arg3);
    }

    public static DisposableEffectResult $r8$lambda$m_Wt9UeoYDVeEVo103zbUcK2P9k(LifecycleOwner arg0, Event arg1, State arg2, DisposableEffectScope arg3) {
        return LifecycleEffectKt.LifecycleEventEffect$lambda$1$0(arg0, arg1, arg2, arg3);
    }

    public static DisposableEffectResult $r8$lambda$rlZyutedMG1g8pVxZ1Fy--51L3Q(LifecycleOwner arg0, LifecycleStartStopEffectScope arg1, Function1 arg2, DisposableEffectScope arg3) {
        return LifecycleEffectKt.LifecycleStartEffectImpl$lambda$0$0(arg0, arg1, arg2, arg3);
    }

    public static void $r8$lambda$xvRAndsrGZrddWkbn-5_Rv6CkvU(LifecycleResumePauseEffectScope arg0, ObjectRef arg1, Function1 arg2, LifecycleOwner arg3, Event arg4) {
        LifecycleEffectKt.LifecycleResumeEffectImpl$lambda$0$0$0(arg0, arg1, arg2, arg3, arg4);
    }

    public static final void LifecycleEventEffect(Event arg7, LifecycleOwner arg8, Function0 arg9, Composer arg10, int arg11, int arg12) {
        LifecycleEffectKt$$ExternalSyntheticLambda5 v3_3;
        Object v8_1;
        int v3;
        int v1;
        int v0 = -709389590;
        arg10 = arg10.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg10, "C(LifecycleEventEffect)N(event,lifecycleOwner,onEvent)65@2873L29,66@2940L279,66@2907L312:LifecycleEffect.kt#2vxrgp");
        int v2 = 4;
        if((arg11 & 6) == 0) {
            v1 = arg10.changed(arg7.ordinal()) ? v2 : 2;
            v1 |= arg11;
        }
        else {
            v1 = arg11;
        }

        if((arg11 & 0x30) == 0) {
            v3 = (arg12 & 2) != 0 || !arg10.changedInstance(arg8) ? 16 : 0x20;
            v1 |= v3;
        }

        if((arg11 & 0x180) == 0) {
            v3 = arg10.changedInstance(arg9) ? 0x100 : 0x80;
            v1 |= v3;
        }

        int v5 = 0;
        boolean v3_1 = (v1 & 0x93) != 0x92 ? true : false;
        if(arg10.shouldExecute(v3_1, v1 & 1)) {
            arg10.startDefaults();
            ComposerKt.sourceInformation(arg10, "53@2411L7");
            if((arg11 & 1) != 0 && !arg10.getDefaultsInvalid()) {
                arg10.skipToGroupEnd();
                if((arg12 & 2) != 0) {
                    goto label_66;
                }
            }
            else if((arg12 & 2) != 0) {
                ProvidableCompositionLocal v8 = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
                ComposerKt.sourceInformationMarkerStart(arg10, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                v8_1 = arg10.consume(((CompositionLocal)v8));
                ComposerKt.sourceInformationMarkerEnd(arg10);
            label_66:
                v1 &= 0xFFFFFF8F;
            }

            arg10.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.lifecycle.compose.LifecycleEventEffect (LifecycleEffect.kt:55)");
            }

            if(arg7 != Event.ON_DESTROY) {
                State v0_1 = SnapshotStateKt.rememberUpdatedState(arg9, arg10, v1 >> 6 & 14);
                ComposerKt.sourceInformationMarkerStart(arg10, 0x461ED181, "CC(remember):LifecycleEffect.kt#9igjgp");
                if((v1 & 14) == v2) {
                    v5 = 1;
                }

                v2 = arg10.changed(v0_1) | v5 | arg10.changedInstance(v8_1);
                Object v3_2 = arg10.rememberedValue();
                if(v2 != 0 || v3_2 == Composer.Companion.getEmpty()) {
                    v3_3 = new LifecycleEffectKt$$ExternalSyntheticLambda5(((LifecycleOwner)v8_1), arg7, v0_1);
                    arg10.updateRememberedValue(v3_3);
                }

                ComposerKt.sourceInformationMarkerEnd(arg10);
                EffectsKt.DisposableEffect(v8_1, ((Function1)v3_3), arg10, v1 >> 3 & 14);
                if(!ComposerKt.isTraceInProgress()) {
                    goto label_109;
                }

                ComposerKt.traceEventEnd();
                goto label_109;
            }

            throw new IllegalArgumentException("LifecycleEventEffect cannot be used to listen for Lifecycle.Event.ON_DESTROY, since Compose disposes of the composition before ON_DESTROY observers are invoked.");
        }
        else {
            arg10.skipToGroupEnd();
        }

    label_109:
        LifecycleOwner v2_1 = ((LifecycleOwner)v8_1);
        ScopeUpdateScope v8_2 = arg10.endRestartGroup();
        if(v8_2 != null) {
            v8_2.updateScope(new LifecycleEffectKt$$ExternalSyntheticLambda6(arg7, v2_1, arg9, arg11, arg12));
        }
    }

    private static final Function0 LifecycleEventEffect$lambda$0(State arg0) {
        return arg0.getValue();
    }

    private static final DisposableEffectResult LifecycleEventEffect$lambda$1$0(LifecycleOwner arg0, Event arg1, State arg2, DisposableEffectScope arg3) {
        LifecycleEffectKt$$ExternalSyntheticLambda2 v3 = new LifecycleEffectKt$$ExternalSyntheticLambda2(arg1, arg2);
        arg0.getLifecycle().addObserver(v3);
        return new LifecycleEffectKt$LifecycleEventEffect$lambda$1$0$$inlined$onDispose$1(arg0, ((LifecycleEventObserver)v3));
    }

    private static final void LifecycleEventEffect$lambda$1$0$0(Event arg0, State arg1, LifecycleOwner arg2, Event arg3) {
        if(arg3 == arg0) {
            LifecycleEffectKt.LifecycleEventEffect$lambda$0(arg1).invoke();
        }
    }

    static final Unit LifecycleEventEffect$lambda$2(Event arg6, LifecycleOwner arg7, Function0 arg8, int arg9, int arg10, Composer arg11, int arg12) {
        LifecycleEffectKt.LifecycleEventEffect(arg6, arg7, arg8, arg11, RecomposeScopeImplKt.updateChangedFlags(arg9 | 1), arg10);
        return Unit.INSTANCE;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="LifecycleResumeEffect must provide one or more \'key\' parameters that define the identity of the LifecycleResumeEffect and determine when its previous effect coroutine should be cancelled and a new effect launched for the new key.") public static final void LifecycleResumeEffect(LifecycleOwner arg4, Function1 arg5, Composer arg6, int arg7, int arg8) {
        int v0 = 0xD3726B0E;
        arg6 = arg6.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg6, "C(LifecycleResumeEffect)N(lifecycleOwner,effects):LifecycleEffect.kt#2vxrgp");
        int v1 = arg7 & 1;
        boolean v3 = v1 != 0 ? true : false;
        if(arg6.shouldExecute(v3, v1)) {
            arg6.startDefaults();
            ComposerKt.sourceInformation(arg6, "654@31689L7");
            if(v1 != 0 && !arg6.getDefaultsInvalid()) {
                arg6.skipToGroupEnd();
                if((arg8 & 1) != 0) {
                    goto label_31;
                }
            }
            else if((arg8 & 1) != 0) {
                ProvidableCompositionLocal v4 = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
                ComposerKt.sourceInformationMarkerStart(arg6, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                arg6.consume(((CompositionLocal)v4));
                ComposerKt.sourceInformationMarkerEnd(arg6);
            label_31:
                arg7 &= -15;
            }

            arg6.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, arg7, -1, "androidx.lifecycle.compose.LifecycleResumeEffect (LifecycleEffect.kt:656)");
            }

            throw new IllegalStateException("LifecycleResumeEffect must provide one or more \'key\' parameters that define the identity of the LifecycleResumeEffect and determine when its previous effect coroutine should be cancelled and a new effect launched for the new key.".toString());
        }

        arg6.skipToGroupEnd();
        ScopeUpdateScope v6 = arg6.endRestartGroup();
        if(v6 != null) {
            v6.updateScope(new LifecycleEffectKt$$ExternalSyntheticLambda15(arg4, arg5, arg7, arg8));
        }
    }

    public static final void LifecycleResumeEffect(Object arg7, LifecycleOwner arg8, Function1 arg9, Composer arg10, int arg11, int arg12) {
        LifecycleResumePauseEffectScope v2_3;
        Object v8_1;
        int v2;
        int v1;
        int v0 = 1220373486;
        arg10 = arg10.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg10, "C(LifecycleResumeEffect)N(key1,lifecycleOwner,effects)449@21391L92,450@21488L83:LifecycleEffect.kt#2vxrgp");
        if((arg11 & 6) == 0) {
            v1 = arg10.changedInstance(arg7) ? 4 : 2;
            v1 |= arg11;
        }
        else {
            v1 = arg11;
        }

        if((arg11 & 0x30) == 0) {
            v2 = (arg12 & 2) != 0 || !arg10.changedInstance(arg8) ? 16 : 0x20;
            v1 |= v2;
        }

        if((arg11 & 0x180) == 0) {
            v2 = arg10.changedInstance(arg9) ? 0x100 : 0x80;
            v1 |= v2;
        }

        boolean v2_1 = (v1 & 0x93) != 0x92 ? true : false;
        if(arg10.shouldExecute(v2_1, v1 & 1)) {
            arg10.startDefaults();
            ComposerKt.sourceInformation(arg10, "445@21240L7");
            if((arg11 & 1) != 0 && !arg10.getDefaultsInvalid()) {
                arg10.skipToGroupEnd();
                if((arg12 & 2) != 0) {
                    goto label_61;
                }
            }
            else if((arg12 & 2) != 0) {
                ProvidableCompositionLocal v8 = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
                ComposerKt.sourceInformationMarkerStart(arg10, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                v8_1 = arg10.consume(((CompositionLocal)v8));
                ComposerKt.sourceInformationMarkerEnd(arg10);
            label_61:
                v1 &= 0xFFFFFF8F;
            }

            arg10.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.lifecycle.compose.LifecycleResumeEffect (LifecycleEffect.kt:447)");
            }

            ComposerKt.sourceInformationMarkerStart(arg10, 0xF12482A, "CC(remember):LifecycleEffect.kt#9igjgp");
            v0 = arg10.changed(arg7) | arg10.changed(v8_1);
            Object v2_2 = arg10.rememberedValue();
            if(v0 != 0 || v2_2 == Composer.Companion.getEmpty()) {
                v2_3 = new LifecycleResumePauseEffectScope(((LifecycleOwner)v8_1).getLifecycle());
                arg10.updateRememberedValue(v2_3);
            }

            ComposerKt.sourceInformationMarkerEnd(arg10);
            LifecycleEffectKt.LifecycleResumeEffectImpl(((LifecycleOwner)v8_1), v2_3, arg9, arg10, v1 >> 3 & 14 | v1 & 0x380);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_94;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg10.skipToGroupEnd();
        }

    label_94:
        LifecycleOwner v3 = ((LifecycleOwner)v8_1);
        ScopeUpdateScope v8_2 = arg10.endRestartGroup();
        if(v8_2 != null) {
            v8_2.updateScope(new LifecycleEffectKt$$ExternalSyntheticLambda4(arg7, v3, arg9, arg11, arg12));
        }
    }

    public static final void LifecycleResumeEffect(Object arg8, Object arg9, LifecycleOwner arg10, Function1 arg11, Composer arg12, int arg13, int arg14) {
        Object v10_1;
        int v2;
        int v1;
        int v0 = 0x2CDCFCCE;
        arg12 = arg12.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg12, "C(LifecycleResumeEffect)N(key1,key2,lifecycleOwner,effects)508@24468L118,511@24591L83:LifecycleEffect.kt#2vxrgp");
        if((arg13 & 6) == 0) {
            v1 = arg12.changedInstance(arg8) ? 4 : 2;
            v1 |= arg13;
        }
        else {
            v1 = arg13;
        }

        if((arg13 & 0x30) == 0) {
            v2 = arg12.changedInstance(arg9) ? 0x20 : 16;
            v1 |= v2;
        }

        if((arg13 & 0x180) == 0) {
            v2 = (arg14 & 4) != 0 || !arg12.changedInstance(arg10) ? 0x80 : 0x100;
            v1 |= v2;
        }

        if((arg13 & 0xC00) == 0) {
            v2 = arg12.changedInstance(arg11) ? 0x800 : 0x400;
            v1 |= v2;
        }

        boolean v2_1 = (v1 & 0x493) != 1170 ? true : false;
        if(arg12.shouldExecute(v2_1, v1 & 1)) {
            arg12.startDefaults();
            ComposerKt.sourceInformation(arg12, "504@24317L7");
            if((arg13 & 1) != 0 && !arg12.getDefaultsInvalid()) {
                arg12.skipToGroupEnd();
                if((arg14 & 4) != 0) {
                    goto label_69;
                }
            }
            else if((arg14 & 4) != 0) {
                ProvidableCompositionLocal v10 = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
                ComposerKt.sourceInformationMarkerStart(arg12, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                v10_1 = arg12.consume(((CompositionLocal)v10));
                ComposerKt.sourceInformationMarkerEnd(arg12);
            label_69:
                v1 &= -897;
            }

            arg12.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.lifecycle.compose.LifecycleResumeEffect (LifecycleEffect.kt:506)");
            }

            ComposerKt.sourceInformationMarkerStart(arg12, 0x69912324, "CC(remember):LifecycleEffect.kt#9igjgp");
            v0 = arg12.changed(arg8) | arg12.changed(arg9) | arg12.changed(v10_1);
            Object v2_2 = arg12.rememberedValue();
            if(v0 != 0 || v2_2 == Composer.Companion.getEmpty()) {
                LifecycleResumePauseEffectScope v2_3 = new LifecycleResumePauseEffectScope(((LifecycleOwner)v10_1).getLifecycle());
                arg12.updateRememberedValue(v2_3);
            }

            ComposerKt.sourceInformationMarkerEnd(arg12);
            LifecycleEffectKt.LifecycleResumeEffectImpl(((LifecycleOwner)v10_1), ((LifecycleResumePauseEffectScope)v2_2), arg11, arg12, v1 >> 6 & 14 | v1 >> 3 & 0x380);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_105;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg12.skipToGroupEnd();
        }

    label_105:
        LifecycleOwner v4 = ((LifecycleOwner)v10_1);
        ScopeUpdateScope v10_2 = arg12.endRestartGroup();
        if(v10_2 != null) {
            v10_2.updateScope(new LifecycleEffectKt$$ExternalSyntheticLambda14(arg8, arg9, v4, arg11, arg13, arg14));
        }
    }

    public static final void LifecycleResumeEffect(Object arg8, Object arg9, Object arg10, LifecycleOwner arg11, Function1 arg12, Composer arg13, int arg14, int arg15) {
        Object v11_1;
        int v3;
        int v2;
        int v0 = 0xE3091DAE;
        Composer v1 = arg13.startRestartGroup(v0);
        ComposerKt.sourceInformation(v1, "C(LifecycleResumeEffect)N(key1,key2,key3,lifecycleOwner,effects)572@27667L124,575@27796L83:LifecycleEffect.kt#2vxrgp");
        if((arg14 & 6) == 0) {
            v2 = v1.changedInstance(arg8) ? 4 : 2;
            v2 |= arg14;
        }
        else {
            v2 = arg14;
        }

        if((arg14 & 0x30) == 0) {
            v3 = v1.changedInstance(arg9) ? 0x20 : 16;
            v2 |= v3;
        }

        if((arg14 & 0x180) == 0) {
            v3 = v1.changedInstance(arg10) ? 0x100 : 0x80;
            v2 |= v3;
        }

        if((arg14 & 0xC00) == 0) {
            v3 = (arg15 & 8) != 0 || !v1.changedInstance(arg11) ? 0x400 : 0x800;
            v2 |= v3;
        }

        if((arg14 & 0x6000) == 0) {
            v3 = v1.changedInstance(arg12) ? 0x4000 : 0x2000;
            v2 |= v3;
        }

        boolean v3_1 = (v2 & 9363) != 9362 ? true : false;
        if(v1.shouldExecute(v3_1, v2 & 1)) {
            v1.startDefaults();
            ComposerKt.sourceInformation(v1, "568@27516L7");
            if((arg14 & 1) != 0 && !v1.getDefaultsInvalid()) {
                v1.skipToGroupEnd();
                if((arg15 & 8) != 0) {
                    goto label_77;
                }
            }
            else if((arg15 & 8) != 0) {
                ProvidableCompositionLocal v11 = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
                ComposerKt.sourceInformationMarkerStart(v1, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                v11_1 = v1.consume(((CompositionLocal)v11));
                ComposerKt.sourceInformationMarkerEnd(v1);
            label_77:
                v2 &= 0xFFFFE3FF;
            }

            v1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v2, -1, "androidx.lifecycle.compose.LifecycleResumeEffect (LifecycleEffect.kt:570)");
            }

            ComposerKt.sourceInformationMarkerStart(v1, 0x45388E0A, "CC(remember):LifecycleEffect.kt#9igjgp");
            v0 = v1.changed(arg8) | v1.changed(arg9) | v1.changed(arg10) | v1.changed(v11_1);
            Object v3_2 = v1.rememberedValue();
            if(v0 != 0 || v3_2 == Composer.Companion.getEmpty()) {
                LifecycleResumePauseEffectScope v3_3 = new LifecycleResumePauseEffectScope(((LifecycleOwner)v11_1).getLifecycle());
                v1.updateRememberedValue(v3_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v1);
            LifecycleEffectKt.LifecycleResumeEffectImpl(((LifecycleOwner)v11_1), ((LifecycleResumePauseEffectScope)v3_2), arg12, v1, v2 >> 9 & 14 | v2 >> 6 & 0x380);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_115;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v1.skipToGroupEnd();
        }

    label_115:
        LifecycleOwner v4 = ((LifecycleOwner)v11_1);
        ScopeUpdateScope v11_2 = v1.endRestartGroup();
        if(v11_2 != null) {
            v11_2.updateScope(new LifecycleEffectKt$$ExternalSyntheticLambda11(arg8, arg9, arg10, v4, arg12, arg14, arg15));
        }
    }

    public static final void LifecycleResumeEffect(Object[] arg7, LifecycleOwner arg8, Function1 arg9, Composer arg10, int arg11, int arg12) {
        LifecycleResumePauseEffectScope v0_4;
        Object[] v0_2;
        Object v8_1;
        int v2;
        int v1;
        int v0 = 0xD1675621;
        arg10 = arg10.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg10, "C(LifecycleResumeEffect)N(keys,lifecycleOwner,effects)631@30694L113,634@30812L83:LifecycleEffect.kt#2vxrgp");
        if((arg11 & 0x30) == 0) {
            v1 = (arg12 & 2) != 0 || !arg10.changedInstance(arg8) ? 16 : 0x20;
            v1 |= arg11;
        }
        else {
            v1 = arg11;
        }

        if((arg11 & 0x180) == 0) {
            v2 = arg10.changedInstance(arg9) ? 0x100 : 0x80;
            v1 |= v2;
        }

        arg10.startMovableGroup(350901714, Integer.valueOf(arg7.length));
        ComposerKt.sourceInformation(arg10, "627@30543L7");
        int v3 = 4;
        int v4 = 0;
        v2 = arg10.changed(arg7.length) ? v3 : 0;
        v1 |= v2;
        v2 = arg7.length;
        int v5;
        for(v5 = 0; v5 < v2; ++v5) {
            int v6 = arg10.changedInstance(arg7[v5]) ? v3 : 0;
            v1 |= v6;
        }

        arg10.endMovableGroup();
        if((v1 & 14) == 0) {
            v1 |= 2;
        }

        boolean v2_1 = (v1 & 0x93) != 0x92 ? true : false;
        if(arg10.shouldExecute(v2_1, v1 & 1)) {
            arg10.startDefaults();
            ComposerKt.sourceInformation(arg10, "");
            if((arg11 & 1) != 0 && !arg10.getDefaultsInvalid()) {
                arg10.skipToGroupEnd();
                if((arg12 & 2) != 0) {
                    goto label_84;
                }
            }
            else if((arg12 & 2) != 0) {
                ProvidableCompositionLocal v8 = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
                ComposerKt.sourceInformationMarkerStart(arg10, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                v8_1 = arg10.consume(((CompositionLocal)v8));
                ComposerKt.sourceInformationMarkerEnd(arg10);
            label_84:
                v1 &= 0xFFFFFF8F;
            }

            arg10.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.lifecycle.compose.LifecycleResumeEffect (LifecycleEffect.kt:629)");
            }

            SpreadBuilder v0_1 = new SpreadBuilder(2);
            v0_1.addSpread(arg7);
            v0_1.add(v8_1);
            v0_2 = v0_1.toArray(new Object[v0_1.size()]);
            ComposerKt.sourceInformationMarkerStart(arg10, 0xDE219177, "CC(remember)N(keys,calculation):Composables.kt#9igjgp");
            v2 = v0_2.length;
            v3 = 0;
            goto label_104;
        }
        else {
            arg10.skipToGroupEnd();
            goto label_130;
        label_104:
            while(v4 < v2) {
                v3 |= arg10.changed(v0_2[v4]);
                ++v4;
            }

            Object v0_3 = arg10.rememberedValue();
            if(v3 != 0 || v0_3 == Composer.Companion.getEmpty()) {
                v0_4 = new LifecycleResumePauseEffectScope(((LifecycleOwner)v8_1).getLifecycle());
                arg10.updateRememberedValue(v0_4);
            }

            ComposerKt.sourceInformationMarkerEnd(arg10);
            LifecycleEffectKt.LifecycleResumeEffectImpl(((LifecycleOwner)v8_1), v0_4, arg9, arg10, v1 & 0x380 | v1 >> 3 & 14);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_130;
            }

            ComposerKt.traceEventEnd();
        }

    label_130:
        LifecycleOwner v3_1 = ((LifecycleOwner)v8_1);
        ScopeUpdateScope v8_2 = arg10.endRestartGroup();
        if(v8_2 != null) {
            v8_2.updateScope(new LifecycleEffectKt$$ExternalSyntheticLambda7(arg7, v3_1, arg9, arg11, arg12));
        }
    }

    static final Unit LifecycleResumeEffect$lambda$1(Object arg6, LifecycleOwner arg7, Function1 arg8, int arg9, int arg10, Composer arg11, int arg12) {
        LifecycleEffectKt.LifecycleResumeEffect(arg6, arg7, arg8, arg11, RecomposeScopeImplKt.updateChangedFlags(arg9 | 1), arg10);
        return Unit.INSTANCE;
    }

    static final Unit LifecycleResumeEffect$lambda$3(Object arg7, Object arg8, LifecycleOwner arg9, Function1 arg10, int arg11, int arg12, Composer arg13, int arg14) {
        LifecycleEffectKt.LifecycleResumeEffect(arg7, arg8, arg9, arg10, arg13, RecomposeScopeImplKt.updateChangedFlags(arg11 | 1), arg12);
        return Unit.INSTANCE;
    }

    static final Unit LifecycleResumeEffect$lambda$5(Object arg8, Object arg9, Object arg10, LifecycleOwner arg11, Function1 arg12, int arg13, int arg14, Composer arg15, int arg16) {
        LifecycleEffectKt.LifecycleResumeEffect(arg8, arg9, arg10, arg11, arg12, arg15, RecomposeScopeImplKt.updateChangedFlags(arg13 | 1), arg14);
        return Unit.INSTANCE;
    }

    static final Unit LifecycleResumeEffect$lambda$7(Object[] arg6, LifecycleOwner arg7, Function1 arg8, int arg9, int arg10, Composer arg11, int arg12) {
        LifecycleEffectKt.LifecycleResumeEffect(arg6, arg7, arg8, arg11, RecomposeScopeImplKt.updateChangedFlags(arg9 | 1), arg10);
        return Unit.INSTANCE;
    }

    static final Unit LifecycleResumeEffect$lambda$8(LifecycleOwner arg0, Function1 arg1, int arg2, int arg3, Composer arg4, int arg5) {
        LifecycleEffectKt.LifecycleResumeEffect(arg0, arg1, arg4, RecomposeScopeImplKt.updateChangedFlags(arg2 | 1), arg3);
        return Unit.INSTANCE;
    }

    private static final void LifecycleResumeEffectImpl(LifecycleOwner arg7, LifecycleResumePauseEffectScope arg8, Function1 arg9, Composer arg10, int arg11) {
        LifecycleEffectKt$$ExternalSyntheticLambda18 v2_3;
        int v2;
        int v1;
        int v0 = 0x366893C6;
        arg10 = arg10.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg10, "C(LifecycleResumeEffectImpl)N(lifecycleOwner,scope,effects)664@32105L670,664@32065L710:LifecycleEffect.kt#2vxrgp");
        if((arg11 & 6) == 0) {
            v1 = arg10.changedInstance(arg7) ? 4 : 2;
            v1 |= arg11;
        }
        else {
            v1 = arg11;
        }

        if((arg11 & 0x30) == 0) {
            v2 = arg10.changedInstance(arg8) ? 0x20 : 16;
            v1 |= v2;
        }

        int v3 = 0x100;
        if((arg11 & 0x180) == 0) {
            v2 = arg10.changedInstance(arg9) ? v3 : 0x80;
            v1 |= v2;
        }

        int v5 = 0;
        boolean v2_1 = (v1 & 0x93) != 0x92 ? true : false;
        if(arg10.shouldExecute(v2_1, v1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.lifecycle.compose.LifecycleResumeEffectImpl (LifecycleEffect.kt:663)");
            }

            ComposerKt.sourceInformationMarkerStart(arg10, 1049811908, "CC(remember):LifecycleEffect.kt#9igjgp");
            boolean v0_1 = arg10.changedInstance(arg8);
            if((v1 & 0x380) == v3) {
                v5 = 1;
            }

            v0 = (((int)v0_1)) | v5 | arg10.changedInstance(arg7);
            Object v2_2 = arg10.rememberedValue();
            if(v0 != 0 || v2_2 == Composer.Companion.getEmpty()) {
                v2_3 = new LifecycleEffectKt$$ExternalSyntheticLambda18(arg7, arg8, arg9);
                arg10.updateRememberedValue(v2_3);
            }

            ComposerKt.sourceInformationMarkerEnd(arg10);
            EffectsKt.DisposableEffect(arg7, arg8, ((Function1)v2_3), arg10, v1 & 0x7E);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_73;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg10.skipToGroupEnd();
        }

    label_73:
        ScopeUpdateScope v10 = arg10.endRestartGroup();
        if(v10 != null) {
            v10.updateScope(new LifecycleEffectKt$$ExternalSyntheticLambda1(arg7, arg8, arg9, arg11));
        }
    }

    private static final DisposableEffectResult LifecycleResumeEffectImpl$lambda$0$0(LifecycleOwner arg1, LifecycleResumePauseEffectScope arg2, Function1 arg3, DisposableEffectScope arg4) {
        ObjectRef v4 = new ObjectRef();
        LifecycleEffectKt$$ExternalSyntheticLambda13 v0 = new LifecycleEffectKt$$ExternalSyntheticLambda13(arg2, v4, arg3);
        arg1.getLifecycle().addObserver(v0);
        return new LifecycleEffectKt$LifecycleResumeEffectImpl$lambda$0$0$$inlined$onDispose$1(arg1, ((LifecycleEventObserver)v0), v4);
    }

    private static final void LifecycleResumeEffectImpl$lambda$0$0$0(LifecycleResumePauseEffectScope arg0, ObjectRef arg1, Function1 arg2, LifecycleOwner arg3, Event arg4) {
        int v3 = WhenMappings.$EnumSwitchMapping$0[arg4.ordinal()];
        if(v3 != 3) {
            if(v3 != 4) {
                return;
            }

            Object v0 = arg1.element;
            if(v0 != null) {
                ((LifecyclePauseOrDisposeEffectResult)v0).runPauseOrOnDisposeEffect();
            }

            arg1.element = null;
            return;
        }

        arg1.element = arg2.invoke(arg0);
    }

    static final Unit LifecycleResumeEffectImpl$lambda$1(LifecycleOwner arg0, LifecycleResumePauseEffectScope arg1, Function1 arg2, int arg3, Composer arg4, int arg5) {
        LifecycleEffectKt.LifecycleResumeEffectImpl(arg0, arg1, arg2, arg4, RecomposeScopeImplKt.updateChangedFlags(arg3 | 1));
        return Unit.INSTANCE;
    }

    public static final void LifecycleStartEffect(Object arg8, Object arg9, LifecycleOwner arg10, Function1 arg11, Composer arg12, int arg13, int arg14) {
        LifecycleStartStopEffectScope v2_3;
        Object v10_1;
        int v2;
        int v1;
        int v0 = 0x298A3A31;
        arg12 = arg12.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg12, "C(LifecycleStartEffect)N(key1,key2,lifecycleOwner,effects)189@9011L116,192@9132L80:LifecycleEffect.kt#2vxrgp");
        if((arg13 & 6) == 0) {
            v1 = arg12.changedInstance(arg8) ? 4 : 2;
            v1 |= arg13;
        }
        else {
            v1 = arg13;
        }

        if((arg13 & 0x30) == 0) {
            v2 = arg12.changedInstance(arg9) ? 0x20 : 16;
            v1 |= v2;
        }

        if((arg13 & 0x180) == 0) {
            v2 = (arg14 & 4) != 0 || !arg12.changedInstance(arg10) ? 0x80 : 0x100;
            v1 |= v2;
        }

        if((arg13 & 0xC00) == 0) {
            v2 = arg12.changedInstance(arg11) ? 0x800 : 0x400;
            v1 |= v2;
        }

        boolean v2_1 = (v1 & 0x493) != 1170 ? true : false;
        if(arg12.shouldExecute(v2_1, v1 & 1)) {
            arg12.startDefaults();
            ComposerKt.sourceInformation(arg12, "185@8865L7");
            if((arg13 & 1) != 0 && !arg12.getDefaultsInvalid()) {
                arg12.skipToGroupEnd();
                if((arg14 & 4) != 0) {
                    goto label_69;
                }
            }
            else if((arg14 & 4) != 0) {
                ProvidableCompositionLocal v10 = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
                ComposerKt.sourceInformationMarkerStart(arg12, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                v10_1 = arg12.consume(((CompositionLocal)v10));
                ComposerKt.sourceInformationMarkerEnd(arg12);
            label_69:
                v1 &= -897;
            }

            arg12.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.lifecycle.compose.LifecycleStartEffect (LifecycleEffect.kt:187)");
            }

            ComposerKt.sourceInformationMarkerStart(arg12, 0xEFE49305, "CC(remember):LifecycleEffect.kt#9igjgp");
            v0 = arg12.changed(arg8) | arg12.changed(arg9) | arg12.changed(v10_1);
            Object v2_2 = arg12.rememberedValue();
            if(v0 != 0 || v2_2 == Composer.Companion.getEmpty()) {
                v2_3 = new LifecycleStartStopEffectScope(((LifecycleOwner)v10_1).getLifecycle());
                arg12.updateRememberedValue(v2_3);
            }

            ComposerKt.sourceInformationMarkerEnd(arg12);
            LifecycleEffectKt.LifecycleStartEffectImpl(((LifecycleOwner)v10_1), v2_3, arg11, arg12, v1 >> 6 & 14 | v1 >> 3 & 0x380);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_105;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg12.skipToGroupEnd();
        }

    label_105:
        LifecycleOwner v4 = ((LifecycleOwner)v10_1);
        ScopeUpdateScope v10_2 = arg12.endRestartGroup();
        if(v10_2 != null) {
            v10_2.updateScope(new LifecycleEffectKt$$ExternalSyntheticLambda10(arg8, arg9, v4, arg11, arg13, arg14));
        }
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="LifecycleStartEffect must provide one or more \'key\' parameters that define the identity of the LifecycleStartEffect and determine when its previous effect coroutine should be cancelled and a new effect launched for the new key.") public static final void LifecycleStartEffect(LifecycleOwner arg4, Function1 arg5, Composer arg6, int arg7, int arg8) {
        int v0 = 0xFCF8BB71;
        arg6 = arg6.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg6, "C(LifecycleStartEffect)N(lifecycleOwner,effects):LifecycleEffect.kt#2vxrgp");
        int v1 = arg7 & 1;
        boolean v3 = v1 != 0 ? true : false;
        if(arg6.shouldExecute(v3, v1)) {
            arg6.startDefaults();
            ComposerKt.sourceInformation(arg6, "331@16109L7");
            if(v1 != 0 && !arg6.getDefaultsInvalid()) {
                arg6.skipToGroupEnd();
                if((arg8 & 1) != 0) {
                    goto label_31;
                }
            }
            else if((arg8 & 1) != 0) {
                ProvidableCompositionLocal v4 = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
                ComposerKt.sourceInformationMarkerStart(arg6, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                arg6.consume(((CompositionLocal)v4));
                ComposerKt.sourceInformationMarkerEnd(arg6);
            label_31:
                arg7 &= -15;
            }

            arg6.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, arg7, -1, "androidx.lifecycle.compose.LifecycleStartEffect (LifecycleEffect.kt:333)");
            }

            throw new IllegalStateException("LifecycleStartEffect must provide one or more \'key\' parameters that define the identity of the LifecycleStartEffect and determine when its previous effect coroutine should be cancelled and a new effect launched for the new key.".toString());
        }

        arg6.skipToGroupEnd();
        ScopeUpdateScope v6 = arg6.endRestartGroup();
        if(v6 != null) {
            v6.updateScope(new LifecycleEffectKt$$ExternalSyntheticLambda3(arg4, arg5, arg7, arg8));
        }
    }

    public static final void LifecycleStartEffect(Object arg7, LifecycleOwner arg8, Function1 arg9, Composer arg10, int arg11, int arg12) {
        Object v8_1;
        int v2;
        int v1;
        int v0 = 0xAC0ED2D1;
        arg10 = arg10.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg10, "C(LifecycleStartEffect)N(key1,lifecycleOwner,effects)131@5983L90,132@6078L80:LifecycleEffect.kt#2vxrgp");
        if((arg11 & 6) == 0) {
            v1 = arg10.changedInstance(arg7) ? 4 : 2;
            v1 |= arg11;
        }
        else {
            v1 = arg11;
        }

        if((arg11 & 0x30) == 0) {
            v2 = (arg12 & 2) != 0 || !arg10.changedInstance(arg8) ? 16 : 0x20;
            v1 |= v2;
        }

        if((arg11 & 0x180) == 0) {
            v2 = arg10.changedInstance(arg9) ? 0x100 : 0x80;
            v1 |= v2;
        }

        boolean v2_1 = (v1 & 0x93) != 0x92 ? true : false;
        if(arg10.shouldExecute(v2_1, v1 & 1)) {
            arg10.startDefaults();
            ComposerKt.sourceInformation(arg10, "127@5837L7");
            if((arg11 & 1) != 0 && !arg10.getDefaultsInvalid()) {
                arg10.skipToGroupEnd();
                if((arg12 & 2) != 0) {
                    goto label_61;
                }
            }
            else if((arg12 & 2) != 0) {
                ProvidableCompositionLocal v8 = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
                ComposerKt.sourceInformationMarkerStart(arg10, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                v8_1 = arg10.consume(((CompositionLocal)v8));
                ComposerKt.sourceInformationMarkerEnd(arg10);
            label_61:
                v1 &= 0xFFFFFF8F;
            }

            arg10.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.lifecycle.compose.LifecycleStartEffect (LifecycleEffect.kt:129)");
            }

            ComposerKt.sourceInformationMarkerStart(arg10, 0xE3A5818B, "CC(remember):LifecycleEffect.kt#9igjgp");
            v0 = arg10.changed(arg7) | arg10.changed(v8_1);
            Object v2_2 = arg10.rememberedValue();
            if(v0 != 0 || v2_2 == Composer.Companion.getEmpty()) {
                LifecycleStartStopEffectScope v2_3 = new LifecycleStartStopEffectScope(((LifecycleOwner)v8_1).getLifecycle());
                arg10.updateRememberedValue(v2_3);
            }

            ComposerKt.sourceInformationMarkerEnd(arg10);
            LifecycleEffectKt.LifecycleStartEffectImpl(((LifecycleOwner)v8_1), ((LifecycleStartStopEffectScope)v2_2), arg9, arg10, v1 >> 3 & 14 | v1 & 0x380);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_94;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg10.skipToGroupEnd();
        }

    label_94:
        LifecycleOwner v3 = ((LifecycleOwner)v8_1);
        ScopeUpdateScope v8_2 = arg10.endRestartGroup();
        if(v8_2 != null) {
            v8_2.updateScope(new LifecycleEffectKt$$ExternalSyntheticLambda0(arg7, v3, arg9, arg11, arg12));
        }
    }

    public static final void LifecycleStartEffect(Object arg8, Object arg9, Object arg10, LifecycleOwner arg11, Function1 arg12, Composer arg13, int arg14, int arg15) {
        LifecycleStartStopEffectScope v3_3;
        Object v11_1;
        int v3;
        int v2;
        int v0 = 0x2242F191;
        Composer v1 = arg13.startRestartGroup(v0);
        ComposerKt.sourceInformation(v1, "C(LifecycleStartEffect)N(key1,key2,key3,lifecycleOwner,effects)252@12167L122,255@12294L80:LifecycleEffect.kt#2vxrgp");
        if((arg14 & 6) == 0) {
            v2 = v1.changedInstance(arg8) ? 4 : 2;
            v2 |= arg14;
        }
        else {
            v2 = arg14;
        }

        if((arg14 & 0x30) == 0) {
            v3 = v1.changedInstance(arg9) ? 0x20 : 16;
            v2 |= v3;
        }

        if((arg14 & 0x180) == 0) {
            v3 = v1.changedInstance(arg10) ? 0x100 : 0x80;
            v2 |= v3;
        }

        if((arg14 & 0xC00) == 0) {
            v3 = (arg15 & 8) != 0 || !v1.changedInstance(arg11) ? 0x400 : 0x800;
            v2 |= v3;
        }

        if((arg14 & 0x6000) == 0) {
            v3 = v1.changedInstance(arg12) ? 0x4000 : 0x2000;
            v2 |= v3;
        }

        boolean v3_1 = (v2 & 9363) != 9362 ? true : false;
        if(v1.shouldExecute(v3_1, v2 & 1)) {
            v1.startDefaults();
            ComposerKt.sourceInformation(v1, "248@12021L7");
            if((arg14 & 1) != 0 && !v1.getDefaultsInvalid()) {
                v1.skipToGroupEnd();
                if((arg15 & 8) != 0) {
                    goto label_77;
                }
            }
            else if((arg15 & 8) != 0) {
                ProvidableCompositionLocal v11 = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
                ComposerKt.sourceInformationMarkerStart(v1, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                v11_1 = v1.consume(((CompositionLocal)v11));
                ComposerKt.sourceInformationMarkerEnd(v1);
            label_77:
                v2 &= 0xFFFFE3FF;
            }

            v1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v2, -1, "androidx.lifecycle.compose.LifecycleStartEffect (LifecycleEffect.kt:250)");
            }

            ComposerKt.sourceInformationMarkerStart(v1, -1655901077, "CC(remember):LifecycleEffect.kt#9igjgp");
            v0 = v1.changed(arg8) | v1.changed(arg9) | v1.changed(arg10) | v1.changed(v11_1);
            Object v3_2 = v1.rememberedValue();
            if(v0 != 0 || v3_2 == Composer.Companion.getEmpty()) {
                v3_3 = new LifecycleStartStopEffectScope(((LifecycleOwner)v11_1).getLifecycle());
                v1.updateRememberedValue(v3_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v1);
            LifecycleEffectKt.LifecycleStartEffectImpl(((LifecycleOwner)v11_1), v3_3, arg12, v1, v2 >> 9 & 14 | v2 >> 6 & 0x380);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_115;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v1.skipToGroupEnd();
        }

    label_115:
        LifecycleOwner v4 = ((LifecycleOwner)v11_1);
        ScopeUpdateScope v11_2 = v1.endRestartGroup();
        if(v11_2 != null) {
            v11_2.updateScope(new LifecycleEffectKt$$ExternalSyntheticLambda16(arg8, arg9, arg10, v4, arg12, arg14, arg15));
        }
    }

    public static final void LifecycleStartEffect(Object[] arg7, LifecycleOwner arg8, Function1 arg9, Composer arg10, int arg11, int arg12) {
        Object[] v0_2;
        Object v8_1;
        int v2;
        int v1;
        int v0 = 0xA5FA9044;
        arg10 = arg10.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg10, "C(LifecycleStartEffect)N(keys,lifecycleOwner,effects)310@15145L91,311@15241L80:LifecycleEffect.kt#2vxrgp");
        if((arg11 & 0x30) == 0) {
            v1 = (arg12 & 2) != 0 || !arg10.changedInstance(arg8) ? 16 : 0x20;
            v1 |= arg11;
        }
        else {
            v1 = arg11;
        }

        if((arg11 & 0x180) == 0) {
            v2 = arg10.changedInstance(arg9) ? 0x100 : 0x80;
            v1 |= v2;
        }

        arg10.startMovableGroup(0x11979315, Integer.valueOf(arg7.length));
        ComposerKt.sourceInformation(arg10, "306@14999L7");
        int v3 = 4;
        int v4 = 0;
        v2 = arg10.changed(arg7.length) ? v3 : 0;
        v1 |= v2;
        v2 = arg7.length;
        int v5;
        for(v5 = 0; v5 < v2; ++v5) {
            int v6 = arg10.changedInstance(arg7[v5]) ? v3 : 0;
            v1 |= v6;
        }

        arg10.endMovableGroup();
        if((v1 & 14) == 0) {
            v1 |= 2;
        }

        boolean v2_1 = (v1 & 0x93) != 0x92 ? true : false;
        if(arg10.shouldExecute(v2_1, v1 & 1)) {
            arg10.startDefaults();
            ComposerKt.sourceInformation(arg10, "");
            if((arg11 & 1) != 0 && !arg10.getDefaultsInvalid()) {
                arg10.skipToGroupEnd();
                if((arg12 & 2) != 0) {
                    goto label_84;
                }
            }
            else if((arg12 & 2) != 0) {
                ProvidableCompositionLocal v8 = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
                ComposerKt.sourceInformationMarkerStart(arg10, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                v8_1 = arg10.consume(((CompositionLocal)v8));
                ComposerKt.sourceInformationMarkerEnd(arg10);
            label_84:
                v1 &= 0xFFFFFF8F;
            }

            arg10.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.lifecycle.compose.LifecycleStartEffect (LifecycleEffect.kt:308)");
            }

            SpreadBuilder v0_1 = new SpreadBuilder(2);
            v0_1.addSpread(arg7);
            v0_1.add(v8_1);
            v0_2 = v0_1.toArray(new Object[v0_1.size()]);
            ComposerKt.sourceInformationMarkerStart(arg10, 0xDE219177, "CC(remember)N(keys,calculation):Composables.kt#9igjgp");
            v2 = v0_2.length;
            v3 = 0;
            goto label_104;
        }
        else {
            arg10.skipToGroupEnd();
            goto label_130;
        label_104:
            while(v4 < v2) {
                v3 |= arg10.changed(v0_2[v4]);
                ++v4;
            }

            Object v0_3 = arg10.rememberedValue();
            if(v3 != 0 || v0_3 == Composer.Companion.getEmpty()) {
                LifecycleStartStopEffectScope v0_4 = new LifecycleStartStopEffectScope(((LifecycleOwner)v8_1).getLifecycle());
                arg10.updateRememberedValue(v0_4);
            }

            ComposerKt.sourceInformationMarkerEnd(arg10);
            LifecycleEffectKt.LifecycleStartEffectImpl(((LifecycleOwner)v8_1), ((LifecycleStartStopEffectScope)v0_3), arg9, arg10, v1 & 0x380 | v1 >> 3 & 14);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_130;
            }

            ComposerKt.traceEventEnd();
        }

    label_130:
        LifecycleOwner v3_1 = ((LifecycleOwner)v8_1);
        ScopeUpdateScope v8_2 = arg10.endRestartGroup();
        if(v8_2 != null) {
            v8_2.updateScope(new LifecycleEffectKt$$ExternalSyntheticLambda17(arg7, v3_1, arg9, arg11, arg12));
        }
    }

    static final Unit LifecycleStartEffect$lambda$1(Object arg6, LifecycleOwner arg7, Function1 arg8, int arg9, int arg10, Composer arg11, int arg12) {
        LifecycleEffectKt.LifecycleStartEffect(arg6, arg7, arg8, arg11, RecomposeScopeImplKt.updateChangedFlags(arg9 | 1), arg10);
        return Unit.INSTANCE;
    }

    static final Unit LifecycleStartEffect$lambda$3(Object arg7, Object arg8, LifecycleOwner arg9, Function1 arg10, int arg11, int arg12, Composer arg13, int arg14) {
        LifecycleEffectKt.LifecycleStartEffect(arg7, arg8, arg9, arg10, arg13, RecomposeScopeImplKt.updateChangedFlags(arg11 | 1), arg12);
        return Unit.INSTANCE;
    }

    static final Unit LifecycleStartEffect$lambda$5(Object arg8, Object arg9, Object arg10, LifecycleOwner arg11, Function1 arg12, int arg13, int arg14, Composer arg15, int arg16) {
        LifecycleEffectKt.LifecycleStartEffect(arg8, arg9, arg10, arg11, arg12, arg15, RecomposeScopeImplKt.updateChangedFlags(arg13 | 1), arg14);
        return Unit.INSTANCE;
    }

    static final Unit LifecycleStartEffect$lambda$7(Object[] arg6, LifecycleOwner arg7, Function1 arg8, int arg9, int arg10, Composer arg11, int arg12) {
        LifecycleEffectKt.LifecycleStartEffect(arg6, arg7, arg8, arg11, RecomposeScopeImplKt.updateChangedFlags(arg9 | 1), arg10);
        return Unit.INSTANCE;
    }

    static final Unit LifecycleStartEffect$lambda$8(LifecycleOwner arg0, Function1 arg1, int arg2, int arg3, Composer arg4, int arg5) {
        LifecycleEffectKt.LifecycleStartEffect(arg0, arg1, arg4, RecomposeScopeImplKt.updateChangedFlags(arg2 | 1), arg3);
        return Unit.INSTANCE;
    }

    private static final void LifecycleStartEffectImpl(LifecycleOwner arg7, LifecycleStartStopEffectScope arg8, Function1 arg9, Composer arg10, int arg11) {
        int v2;
        int v1;
        int v0 = 0xD9CAC4E;
        arg10 = arg10.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg10, "C(LifecycleStartEffectImpl)N(lifecycleOwner,scope,effects)341@16515L661,341@16475L701:LifecycleEffect.kt#2vxrgp");
        if((arg11 & 6) == 0) {
            v1 = arg10.changedInstance(arg7) ? 4 : 2;
            v1 |= arg11;
        }
        else {
            v1 = arg11;
        }

        if((arg11 & 0x30) == 0) {
            v2 = arg10.changedInstance(arg8) ? 0x20 : 16;
            v1 |= v2;
        }

        int v3 = 0x100;
        if((arg11 & 0x180) == 0) {
            v2 = arg10.changedInstance(arg9) ? v3 : 0x80;
            v1 |= v2;
        }

        int v5 = 0;
        boolean v2_1 = (v1 & 0x93) != 0x92 ? true : false;
        if(arg10.shouldExecute(v2_1, v1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.lifecycle.compose.LifecycleStartEffectImpl (LifecycleEffect.kt:340)");
            }

            ComposerKt.sourceInformationMarkerStart(arg10, 0x1922F183, "CC(remember):LifecycleEffect.kt#9igjgp");
            boolean v0_1 = arg10.changedInstance(arg8);
            if((v1 & 0x380) == v3) {
                v5 = 1;
            }

            v0 = (((int)v0_1)) | v5 | arg10.changedInstance(arg7);
            Object v2_2 = arg10.rememberedValue();
            if(v0 != 0 || v2_2 == Composer.Companion.getEmpty()) {
                LifecycleEffectKt$$ExternalSyntheticLambda8 v2_3 = new LifecycleEffectKt$$ExternalSyntheticLambda8(arg7, arg8, arg9);
                arg10.updateRememberedValue(v2_3);
            }

            ComposerKt.sourceInformationMarkerEnd(arg10);
            EffectsKt.DisposableEffect(arg7, arg8, ((Function1)v2_2), arg10, v1 & 0x7E);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_73;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg10.skipToGroupEnd();
        }

    label_73:
        ScopeUpdateScope v10 = arg10.endRestartGroup();
        if(v10 != null) {
            v10.updateScope(new LifecycleEffectKt$$ExternalSyntheticLambda9(arg7, arg8, arg9, arg11));
        }
    }

    private static final DisposableEffectResult LifecycleStartEffectImpl$lambda$0$0(LifecycleOwner arg1, LifecycleStartStopEffectScope arg2, Function1 arg3, DisposableEffectScope arg4) {
        ObjectRef v4 = new ObjectRef();
        LifecycleEffectKt$$ExternalSyntheticLambda12 v0 = new LifecycleEffectKt$$ExternalSyntheticLambda12(arg2, v4, arg3);
        arg1.getLifecycle().addObserver(v0);
        return new LifecycleEffectKt$LifecycleStartEffectImpl$lambda$0$0$$inlined$onDispose$1(arg1, ((LifecycleEventObserver)v0), v4);
    }

    private static final void LifecycleStartEffectImpl$lambda$0$0$0(LifecycleStartStopEffectScope arg0, ObjectRef arg1, Function1 arg2, LifecycleOwner arg3, Event arg4) {
        int v3 = WhenMappings.$EnumSwitchMapping$0[arg4.ordinal()];
        if(v3 != 1) {
            if(v3 != 2) {
                return;
            }

            Object v0 = arg1.element;
            if(v0 != null) {
                ((LifecycleStopOrDisposeEffectResult)v0).runStopOrDisposeEffect();
            }

            arg1.element = null;
            return;
        }

        arg1.element = arg2.invoke(arg0);
    }

    static final Unit LifecycleStartEffectImpl$lambda$1(LifecycleOwner arg0, LifecycleStartStopEffectScope arg1, Function1 arg2, int arg3, Composer arg4, int arg5) {
        LifecycleEffectKt.LifecycleStartEffectImpl(arg0, arg1, arg2, arg4, RecomposeScopeImplKt.updateChangedFlags(arg3 | 1));
        return Unit.INSTANCE;
    }
}

