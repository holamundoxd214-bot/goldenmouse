package androidx.activity.compose;

import androidx.activity.FullyDrawnReporter;
import androidx.activity.FullyDrawnReporterOwner;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001A\u001B\u0010\u0000\u001A\u00020\u00012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0007¢\u0006\u0002\u0010\u0005\u001A\r\u0010\u0006\u001A\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0007\u001A+\u0010\b\u001A\u00020\u00012\u001C\u0010\t\u001A\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000B\u0012\u0006\u0012\u0004\u0018\u00010\f0\nH\u0007¢\u0006\u0002\u0010\r¨\u0006\u000E"}, d2={"ReportDrawnWhen", "", "predicate", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "ReportDrawn", "(Landroidx/compose/runtime/Composer;I)V", "ReportDrawnAfter", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "activity-compose"}, k=2, mv={2, 1, 0}, xi=0x30) public final class ReportDrawnKt {
    public static DisposableEffectResult $r8$lambda$NS-qDQDsxdIf4sa0UaGdo4nx3oM(FullyDrawnReporter arg0, Function0 arg1, DisposableEffectScope arg2) {
        return ReportDrawnKt.ReportDrawnWhen$lambda$1$0(arg0, arg1, arg2);
    }

    public static boolean $r8$lambda$XEPgOM60FcttXLEQnmibtGAxavE() {
        return ReportDrawnKt.ReportDrawn$lambda$0$0();
    }

    public static final void ReportDrawn(Composer arg3, int arg4) {
        int v0 = 0xAF1DA058;
        arg3 = arg3.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg3, "C(ReportDrawn)135@5039L8,135@5023L24:ReportDrawn.kt#q1dkbc");
        boolean v1 = arg4 != 0 ? true : false;
        if(arg3.shouldExecute(v1, arg4 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, arg4, -1, "androidx.activity.compose.ReportDrawn (ReportDrawn.kt:135)");
            }

            ComposerKt.sourceInformationMarkerStart(arg3, 0x5E36EFA0, "CC(remember):ReportDrawn.kt#9igjgp");
            Object v0_1 = arg3.rememberedValue();
            if(v0_1 == Composer.Companion.getEmpty()) {
                ReportDrawnKt$$ExternalSyntheticLambda3 v0_2 = new ReportDrawnKt$$ExternalSyntheticLambda3();
                arg3.updateRememberedValue(v0_2);
            }

            ComposerKt.sourceInformationMarkerEnd(arg3);
            ReportDrawnKt.ReportDrawnWhen(((Function0)v0_1), arg3, 6);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_34;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg3.skipToGroupEnd();
        }

    label_34:
        ScopeUpdateScope v3 = arg3.endRestartGroup();
        if(v3 != null) {
            v3.updateScope(new ReportDrawnKt$$ExternalSyntheticLambda4(arg4));
        }
    }

    private static final boolean ReportDrawn$lambda$0$0() {
        return 1;
    }

    static final Unit ReportDrawn$lambda$1(int arg0, Composer arg1, int arg2) {
        ReportDrawnKt.ReportDrawn(arg1, RecomposeScopeImplKt.updateChangedFlags(arg0 | 1));
        return Unit.INSTANCE;
    }

    public static final void ReportDrawnAfter(Function1 arg4, Composer arg5, int arg6) {
        ScopeUpdateScope v5;
        int v1;
        int v0 = 0x38584E28;
        arg5 = arg5.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg5, "C(ReportDrawnAfter)N(block)149@5544L7,150@5628L48,150@5586L90:ReportDrawn.kt#q1dkbc");
        int v2 = 2;
        if((arg6 & 6) == 0) {
            v1 = arg5.changedInstance(arg4) ? 4 : v2;
            v1 |= arg6;
        }
        else {
            v1 = arg6;
        }

        boolean v2_1 = (v1 & 3) != v2 ? true : false;
        if(arg5.shouldExecute(v2_1, v1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.activity.compose.ReportDrawnAfter (ReportDrawn.kt:148)");
            }

            FullyDrawnReporterOwner v0_1 = LocalFullyDrawnReporterOwner.INSTANCE.getCurrent(arg5, 6);
            if(v0_1 != null) {
                FullyDrawnReporter v0_2 = v0_1.getFullyDrawnReporter();
                if(v0_2 == null) {
                }
                else {
                    ComposerKt.sourceInformationMarkerStart(arg5, -2088928168, "CC(remember):ReportDrawn.kt#9igjgp");
                    v2 = arg5.changedInstance(v0_2) | arg5.changedInstance(arg4);
                    Object v3 = arg5.rememberedValue();
                    if(v2 != 0 || v3 == Composer.Companion.getEmpty()) {
                        ReportDrawnKt$ReportDrawnAfter$1$1 v3_1 = new ReportDrawnKt$ReportDrawnAfter$1$1(v0_2, arg4, null);
                        arg5.updateRememberedValue(v3_1);
                    }

                    ComposerKt.sourceInformationMarkerEnd(arg5);
                    EffectsKt.LaunchedEffect(arg4, v0_2, ((Function2)v3), arg5, v1 & 14);
                    if(!ComposerKt.isTraceInProgress()) {
                        goto label_68;
                    }

                    ComposerKt.traceEventEnd();
                    goto label_68;
                }
            }

            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v5 = arg5.endRestartGroup();
            if(v5 == null) {
                return;
            }

            ReportDrawnKt$$ExternalSyntheticLambda5 v0_3 = new ReportDrawnKt$$ExternalSyntheticLambda5(arg4, arg6);
            goto label_65;
        }
        else {
            arg5.skipToGroupEnd();
        label_68:
            v5 = arg5.endRestartGroup();
            if(v5 == null) {
                return;
            }

            ReportDrawnKt$$ExternalSyntheticLambda6 v0_4 = new ReportDrawnKt$$ExternalSyntheticLambda6(arg4, arg6);
        label_65:
            v5.updateScope(((Function2)v0_4));
            return;
        }
    }

    static final Unit ReportDrawnAfter$lambda$0(Function1 arg0, int arg1, Composer arg2, int arg3) {
        ReportDrawnKt.ReportDrawnAfter(arg0, arg2, RecomposeScopeImplKt.updateChangedFlags(arg1 | 1));
        return Unit.INSTANCE;
    }

    static final Unit ReportDrawnAfter$lambda$2(Function1 arg0, int arg1, Composer arg2, int arg3) {
        ReportDrawnKt.ReportDrawnAfter(arg0, arg2, RecomposeScopeImplKt.updateChangedFlags(arg1 | 1));
        return Unit.INSTANCE;
    }

    public static final void ReportDrawnWhen(Function0 arg7, Composer arg8, int arg9) {
        ScopeUpdateScope v8;
        ReportDrawnKt$$ExternalSyntheticLambda1 v3_3;
        int v1;
        int v0 = 0x85FB6D86;
        arg8 = arg8.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg8, "C(ReportDrawnWhen)N(predicate)117@4402L7,118@4492L263,118@4444L311:ReportDrawn.kt#q1dkbc");
        int v2 = 4;
        int v3 = 2;
        if((arg9 & 6) == 0) {
            v1 = arg8.changedInstance(arg7) ? v2 : v3;
            v1 |= arg9;
        }
        else {
            v1 = arg9;
        }

        int v5 = 0;
        boolean v3_1 = (v1 & 3) != v3 ? true : false;
        if(arg8.shouldExecute(v3_1, v1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.activity.compose.ReportDrawnWhen (ReportDrawn.kt:116)");
            }

            FullyDrawnReporterOwner v0_1 = LocalFullyDrawnReporterOwner.INSTANCE.getCurrent(arg8, 6);
            if(v0_1 != null) {
                FullyDrawnReporter v0_2 = v0_1.getFullyDrawnReporter();
                if(v0_2 == null) {
                }
                else {
                    ComposerKt.sourceInformationMarkerStart(arg8, 0xF4D63D8D, "CC(remember):ReportDrawn.kt#9igjgp");
                    v3_1 = arg8.changedInstance(v0_2);
                    if((v1 & 14) == v2) {
                        v5 = 1;
                    }

                    v2 = (((int)v3_1)) | v5;
                    Object v3_2 = arg8.rememberedValue();
                    if(v2 != 0 || v3_2 == Composer.Companion.getEmpty()) {
                        v3_3 = new ReportDrawnKt$$ExternalSyntheticLambda1(v0_2, arg7);
                        arg8.updateRememberedValue(v3_3);
                    }

                    ComposerKt.sourceInformationMarkerEnd(arg8);
                    EffectsKt.DisposableEffect(v0_2, arg7, ((Function1)v3_3), arg8, v1 << 3 & 0x70);
                    if(!ComposerKt.isTraceInProgress()) {
                        goto label_72;
                    }

                    ComposerKt.traceEventEnd();
                    goto label_72;
                }
            }

            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v8 = arg8.endRestartGroup();
            if(v8 == null) {
                return;
            }

            ReportDrawnKt$$ExternalSyntheticLambda0 v0_3 = new ReportDrawnKt$$ExternalSyntheticLambda0(arg7, arg9);
            goto label_69;
        }
        else {
            arg8.skipToGroupEnd();
        label_72:
            v8 = arg8.endRestartGroup();
            if(v8 == null) {
                return;
            }

            ReportDrawnKt$$ExternalSyntheticLambda2 v0_4 = new ReportDrawnKt$$ExternalSyntheticLambda2(arg7, arg9);
        label_69:
            v8.updateScope(((Function2)v0_4));
            return;
        }
    }

    static final Unit ReportDrawnWhen$lambda$0(Function0 arg0, int arg1, Composer arg2, int arg3) {
        ReportDrawnKt.ReportDrawnWhen(arg0, arg2, RecomposeScopeImplKt.updateChangedFlags(arg1 | 1));
        return Unit.INSTANCE;
    }

    private static final DisposableEffectResult ReportDrawnWhen$lambda$1$0(FullyDrawnReporter arg0, Function0 arg1, DisposableEffectScope arg2) {
        if(arg0.isFullyDrawnReported()) {
            return new ReportDrawnKt$ReportDrawnWhen$lambda$1$0$$inlined$onDispose$1();
        }

        return new ReportDrawnKt$ReportDrawnWhen$lambda$1$0$$inlined$onDispose$2(new ReportDrawnComposition(arg0, arg1));
    }

    static final Unit ReportDrawnWhen$lambda$2(Function0 arg0, int arg1, Composer arg2, int arg3) {
        ReportDrawnKt.ReportDrawnWhen(arg0, arg2, RecomposeScopeImplKt.updateChangedFlags(arg1 | 1));
        return Unit.INSTANCE;
    }
}

