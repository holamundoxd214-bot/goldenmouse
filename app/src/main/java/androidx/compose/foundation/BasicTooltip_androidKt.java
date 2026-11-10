package androidx.compose.foundation;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.window.PopupPositionProvider;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0005\u001Ac\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0011\u0010\u0004\u001A\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0006\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\n2\b\b\u0002\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\r\u001A\u00020\f2\u0011\u0010\u000E\u001A\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0007¢\u0006\u0004\b\u000F\u0010\u0010¨\u0006\u0011"}, d2={"BasicTooltipBoxAndroid", "", "positionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "tooltip", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "state", "Landroidx/compose/foundation/BasicTooltipState;", "modifier", "Landroidx/compose/ui/Modifier;", "focusable", "", "enableUserInput", "content", "BasicTooltipBox", "(Landroidx/compose/ui/window/PopupPositionProvider;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/BasicTooltipState;Landroidx/compose/ui/Modifier;ZZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class BasicTooltip_androidKt {
    @Deprecated(level=DeprecationLevel.HIDDEN, message="Maintained for binary compatibility.") public static final void BasicTooltipBox(PopupPositionProvider arg19, Function2 arg20, BasicTooltipState arg21, Modifier arg22, boolean arg23, boolean arg24, Function2 arg25, Composer arg26, int arg27, int arg28) {
        boolean v5_1;
        Composer v16;
        Companion v12_1;
        int v13;
        int v7;
        boolean v6;
        int v5;
        Modifier v4;
        int v3;
        int v2;
        int v8 = arg27;
        int v0 = 0xAE73E4B4;
        Composer v1 = arg26.startRestartGroup(v0);
        ComposerKt.sourceInformation(v1, "C(BasicTooltipBoxAndroid)N(positionProvider,tooltip,state,modifier,focusable,enableUserInput,content)62@2703L247:BasicTooltip.android.kt#71ulvw");
        PopupPositionProvider v9 = arg19;
        if((v8 & 6) == 0) {
            v2 = v1.changed(v9) ? 4 : 2;
            v2 |= v8;
        }
        else {
            v2 = v8;
        }

        Function2 v10 = arg20;
        if((v8 & 0x30) == 0) {
            v3 = v1.changedInstance(v10) ? 0x20 : 16;
            v2 |= v3;
        }

        BasicTooltipState v11 = arg21;
        if((v8 & 0x180) == 0) {
            v3 = v1.changed(v11) ? 0x100 : 0x80;
            v2 |= v3;
        }

        v3 = arg28 & 8;
        if(v3 != 0) {
            v2 |= 0xC00;
            goto label_49;
        }
        else if((v8 & 0xC00) == 0) {
            v4 = arg22;
            v5 = v1.changed(v4) ? 0x800 : 0x400;
            v2 |= v5;
        }
        else {
        label_49:
            v4 = arg22;
        }

        v5 = arg28 & 16;
        if(v5 != 0) {
            v2 |= 0x6000;
            goto label_64;
        }
        else if((v8 & 0x6000) == 0) {
            v6 = arg23;
            v7 = v1.changed(v6) ? 0x4000 : 0x2000;
            v2 |= v7;
        }
        else {
        label_64:
            v6 = arg23;
        }

        v7 = arg28 & 0x20;
        int v12 = 0x30000;
        if(v7 != 0) {
            v2 |= v12;
        }
        else if((v12 & v8) == 0) {
            v13 = v1.changed(arg24) ? 0x20000 : 0x10000;
            v2 |= v13;
        }

        Function2 v15 = arg25;
        if((0x180000 & v8) == 0) {
            v13 = v1.changedInstance(v15) ? 0x100000 : 0x80000;
            v2 |= v13;
        }

        boolean v13_1 = (0x92493 & v2) != 0x92492 ? true : false;
        if(v1.shouldExecute(v13_1, v2 & 1)) {
            if(v3 != 0) {
                v12_1 = Modifier.Companion;
            }
            else {
                Modifier v12_2 = v4;
            }

            v13_1 = v5 != 0 ? true : v6;
            boolean v14 = v7 != 0 ? true : arg24;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v2, -1, "androidx.compose.foundation.BasicTooltipBoxAndroid (BasicTooltip.android.kt:61)");
            }

            v16 = v1;
            BasicTooltipKt.BasicTooltipBox(v9, v10, v11, ((Modifier)v12_1), v13_1, v14, v15, v16, v2 & 0x3FFFFE, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            Companion v4_1 = v12_1;
            v5_1 = v13_1;
            v6 = v14;
        }
        else {
            v16 = v1;
            v16.skipToGroupEnd();
            v5_1 = v6;
            v6 = arg24;
        }

        ScopeUpdateScope v10_1 = v16.endRestartGroup();
        if(v10_1 != null) {
            v10_1.updateScope(new BasicTooltip_androidKt$$ExternalSyntheticLambda0(arg19, arg20, arg21, v4, v5_1, v6, arg25, v8, arg28));
        }
    }

    static final Unit BasicTooltipBoxAndroid$lambda$0(PopupPositionProvider arg11, Function2 arg12, BasicTooltipState arg13, Modifier arg14, boolean arg15, boolean arg16, Function2 arg17, int arg18, int arg19, Composer arg20, int arg21) {
        BasicTooltip_androidKt.BasicTooltipBox(arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg20, RecomposeScopeImplKt.updateChangedFlags(arg18 | 1), arg19);
        return Unit.INSTANCE;
    }
}

