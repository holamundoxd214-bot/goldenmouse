package androidx.compose.foundation;

import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\u001A.\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0017\u0010\u0004\u001A\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0007H\u0007¢\u0006\u0002\u0010\b\u001A6\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\t\u001A\u00020\n2\u0017\u0010\u0004\u001A\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0007H\u0007¢\u0006\u0002\u0010\u000B¨\u0006\f"}, d2={"Canvas", "", "modifier", "Landroidx/compose/ui/Modifier;", "onDraw", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "contentDescription", "", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class CanvasKt {
    public static Unit $r8$lambda$gMi8_ZuJARs5UnAmqZPsPdSNZOI(String arg0, SemanticsPropertyReceiver arg1) {
        return CanvasKt.Canvas$lambda$1$0(arg0, arg1);
    }

    public static final void Canvas(Modifier arg7, String arg8, Function1 arg9, Composer arg10, int arg11) {
        CanvasKt$$ExternalSyntheticLambda1 v2_3;
        int v2;
        int v1;
        int v0 = 0xBAB206DD;
        arg10 = arg10.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg10, "C(Canvas)N(modifier,contentDescription,onDraw)60@3180L48,60@3135L94:Canvas.kt#71ulvw");
        if((arg11 & 6) == 0) {
            v1 = arg10.changed(arg7) ? 4 : 2;
            v1 |= arg11;
        }
        else {
            v1 = arg11;
        }

        int v3 = 0x20;
        if((arg11 & 0x30) == 0) {
            v2 = arg10.changed(arg8) ? v3 : 16;
            v1 |= v2;
        }

        if((arg11 & 0x180) == 0) {
            v2 = arg10.changedInstance(arg9) ? 0x100 : 0x80;
            v1 |= v2;
        }

        boolean v2_1 = (v1 & 0x93) != 0x92 ? true : false;
        if(arg10.shouldExecute(v2_1, v1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.compose.foundation.Canvas (Canvas.kt:60)");
            }

            Modifier v0_1 = DrawModifierKt.drawBehind(arg7, arg9);
            ComposerKt.sourceInformationMarkerStart(arg10, 0xD64BD54D, "CC(remember):Canvas.kt#9igjgp");
            v1 = (v1 & 0x70) == v3 ? 1 : 0;
            Object v2_2 = arg10.rememberedValue();
            if(v1 != 0 || v2_2 == Composer.Companion.getEmpty()) {
                v2_3 = new CanvasKt$$ExternalSyntheticLambda1(arg8);
                arg10.updateRememberedValue(v2_3);
            }

            ComposerKt.sourceInformationMarkerEnd(arg10);
            SpacerKt.Spacer(SemanticsModifierKt.semantics$default(v0_1, false, ((Function1)v2_3), 1, null), arg10, 0);
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
            v10.updateScope(new CanvasKt$$ExternalSyntheticLambda2(arg7, arg8, arg9, arg11));
        }
    }

    public static final void Canvas(Modifier arg5, Function1 arg6, Composer arg7, int arg8) {
        int v1;
        int v0 = 0xC8660B92;
        arg7 = arg7.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg7, "C(Canvas)N(modifier,onDraw)40@1873L35:Canvas.kt#71ulvw");
        if((arg8 & 6) == 0) {
            v1 = arg7.changed(arg5) ? 4 : 2;
            v1 |= arg8;
        }
        else {
            v1 = arg8;
        }

        if((arg8 & 0x30) == 0) {
            int v2 = arg7.changedInstance(arg6) ? 0x20 : 16;
            v1 |= v2;
        }

        boolean v2_1 = (v1 & 19) != 18 ? true : false;
        if(arg7.shouldExecute(v2_1, v1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.compose.foundation.Canvas (Canvas.kt:40)");
            }

            SpacerKt.Spacer(DrawModifierKt.drawBehind(arg5, arg6), arg7, 0);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_44;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg7.skipToGroupEnd();
        }

    label_44:
        ScopeUpdateScope v7 = arg7.endRestartGroup();
        if(v7 != null) {
            v7.updateScope(new CanvasKt$$ExternalSyntheticLambda0(arg5, arg6, arg8));
        }
    }

    static final Unit Canvas$lambda$0(Modifier arg0, Function1 arg1, int arg2, Composer arg3, int arg4) {
        CanvasKt.Canvas(arg0, arg1, arg3, RecomposeScopeImplKt.updateChangedFlags(arg2 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit Canvas$lambda$1$0(String arg0, SemanticsPropertyReceiver arg1) {
        SemanticsPropertiesKt.setContentDescription(arg1, arg0);
        return Unit.INSTANCE;
    }

    static final Unit Canvas$lambda$2(Modifier arg0, String arg1, Function1 arg2, int arg3, Composer arg4, int arg5) {
        CanvasKt.Canvas(arg0, arg1, arg2, arg4, RecomposeScopeImplKt.updateChangedFlags(arg3 | 1));
        return Unit.INSTANCE;
    }
}

