package androidx.compose.foundation.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

@Metadata(d1={"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001AN\u0010\u0000\u001A\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072!\u0010\b\u001A\u001D\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u000B¢\u0006\u0002\b\f¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010\u000E¨\u0006\u000F"}, d2={"BoxWithConstraints", "", "modifier", "Landroidx/compose/ui/Modifier;", "contentAlignment", "Landroidx/compose/ui/Alignment;", "propagateMinConstraints", "", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/BoxWithConstraintsScope;", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/ui/UiComposable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;ZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "foundation-layout"}, k=2, mv={2, 0, 0}, xi=0x30) public final class BoxWithConstraintsKt {
    public static Unit $r8$lambda$1A634V3dbtgdJDPDrBAXdX_KRvw(Function3 arg0, BoxWithConstraintsScopeImpl arg1, Composer arg2, int arg3) {
        return BoxWithConstraintsKt.BoxWithConstraints$lambda$0$0$0(arg0, arg1, arg2, arg3);
    }

    public static MeasureResult $r8$lambda$p9yh-8kbO_kwrsRP1ZyRK8puGy8(MeasurePolicy arg0, Function3 arg1, SubcomposeMeasureScope arg2, Constraints arg3) {
        return BoxWithConstraintsKt.BoxWithConstraints$lambda$0$0(arg0, arg1, arg2, arg3);
    }

    public static final void BoxWithConstraints(Modifier arg16, Alignment arg17, boolean arg18, Function3 arg19, Composer arg20, int arg21, int arg22) {
        BoxWithConstraintsKt$$ExternalSyntheticLambda0 v8_2;
        Alignment v3_1;
        Modifier v2_2;
        Companion v2_1;
        int v11;
        boolean v10;
        int v9;
        Alignment v8;
        Modifier v3;
        int v6;
        Function3 v4 = arg19;
        int v5 = arg21;
        int v0 = 380139498;
        Composer v1 = arg20.startRestartGroup(v0);
        ComposerKt.sourceInformation(v1, "C(BoxWithConstraints)N(modifier,contentAlignment,propagateMinConstraints,content)63@3275L271,63@3248L298:BoxWithConstraints.kt#2w3rfo");
        int v2 = arg22 & 1;
        if(v2 != 0) {
            v6 = v5 | 6;
            v3 = arg16;
        }
        else if((v5 & 6) == 0) {
            v3 = arg16;
            v6 = v1.changed(v3) ? 4 : 2;
            v6 |= v5;
        }
        else {
            v3 = arg16;
            v6 = v5;
        }

        int v7 = arg22 & 2;
        if(v7 != 0) {
            v6 |= 0x30;
            goto label_39;
        }
        else if((v5 & 0x30) == 0) {
            v8 = arg17;
            v9 = v1.changed(v8) ? 0x20 : 16;
            v6 |= v9;
        }
        else {
        label_39:
            v8 = arg17;
        }

        v9 = arg22 & 4;
        if(v9 != 0) {
            v6 |= 0x180;
            goto label_54;
        }
        else if((v5 & 0x180) == 0) {
            v10 = arg18;
            v11 = v1.changed(v10) ? 0x100 : 0x80;
            v6 |= v11;
        }
        else {
        label_54:
            v10 = arg18;
        }

        int v12 = 0x800;
        if((v5 & 0xC00) == 0) {
            v11 = v1.changedInstance(v4) ? v12 : 0x400;
            v6 |= v11;
        }

        int v15 = 1;
        boolean v11_1 = (v6 & 0x493) != 1170 ? true : false;
        if(v1.shouldExecute(v11_1, v6 & 1)) {
            if(v2 != 0) {
                v2_1 = Modifier.Companion;
            }
            else {
                v2_2 = v3;
            }

            v3_1 = v7 != 0 ? Alignment.Companion.getTopStart() : v8;
            if(v9 != 0) {
                v10 = false;
            }

            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v6, -1, "androidx.compose.foundation.layout.BoxWithConstraints (BoxWithConstraints.kt:61)");
            }

            MeasurePolicy v0_1 = BoxKt.maybeCachedBoxMeasurePolicy(v3_1, v10);
            ComposerKt.sourceInformationMarkerStart(v1, 0xE6A53F9, "CC(remember):BoxWithConstraints.kt#9igjgp");
            if((v6 & 0x1C00) == v12) {
            }
            else {
                v15 = 0;
            }

            v7 = v1.changed(v0_1) | v15;
            Object v8_1 = v1.rememberedValue();
            if(v7 != 0 || v8_1 == Composer.Companion.getEmpty()) {
                v8_2 = new BoxWithConstraintsKt$$ExternalSyntheticLambda0(v0_1, v4);
                v1.updateRememberedValue(v8_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v1);
            SubcomposeLayoutKt.SubcomposeLayout(((Modifier)v2_1), ((Function2)v8_2), v1, v6 & 14, 0);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_119;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v1.skipToGroupEnd();
            v2_2 = v3;
            v3_1 = v8;
        }

    label_119:
        ScopeUpdateScope v7_1 = v1.endRestartGroup();
        if(v7_1 != null) {
            v7_1.updateScope(new BoxWithConstraintsKt$$ExternalSyntheticLambda1(v2_1, v3_1, v10, v4, v5, arg22));
        }
    }

    private static final MeasureResult BoxWithConstraints$lambda$0$0(MeasurePolicy arg5, Function3 arg6, SubcomposeMeasureScope arg7, Constraints arg8) {
        return arg5.measure-3p2s80s(((MeasureScope)arg7), arg7.subcompose(Unit.INSTANCE, ComposableLambdaKt.composableLambdaInstance(0xE6406926, true, new BoxWithConstraintsKt$$ExternalSyntheticLambda2(arg6, new BoxWithConstraintsScopeImpl(arg7, arg8.unbox-impl(), null)))), arg8.unbox-impl());
    }

    private static final Unit BoxWithConstraints$lambda$0$0$0(Function3 arg4, BoxWithConstraintsScopeImpl arg5, Composer arg6, int arg7) {
        ComposerKt.sourceInformation(arg6, "C66@3463L9:BoxWithConstraints.kt#2w3rfo");
        boolean v0 = (arg7 & 3) != 2 ? true : false;
        if(arg6.shouldExecute(v0, arg7 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0xE6406926, arg7, -1, "androidx.compose.foundation.layout.BoxWithConstraints.<anonymous>.<anonymous>.<anonymous> (BoxWithConstraints.kt:66)");
            }

            arg4.invoke(arg5, arg6, Integer.valueOf(0));
            if(!ComposerKt.isTraceInProgress()) {
                goto label_25;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg6.skipToGroupEnd();
        }

    label_25:
        return Unit.INSTANCE;
    }

    static final Unit BoxWithConstraints$lambda$1(Modifier arg7, Alignment arg8, boolean arg9, Function3 arg10, int arg11, int arg12, Composer arg13, int arg14) {
        BoxWithConstraintsKt.BoxWithConstraints(arg7, arg8, arg9, arg10, arg13, RecomposeScopeImplKt.updateChangedFlags(arg11 | 1), arg12);
        return Unit.INSTANCE;
    }
}

