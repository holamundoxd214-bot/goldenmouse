package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.DialogProperties;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001AB\u0010\u0000\u001A\u00020\u00012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\u0011\u0010\b\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\tH\u0007¢\u0006\u0002\u0010\n\u001AB\u0010\u000B\u001A\u00020\u00012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\u0011\u0010\b\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\tH\u0007¢\u0006\u0002\u0010\n\u001AÄ\u0001\u0010\f\u001A\u00020\u00012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\r\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\t2\u0006\u0010\u0004\u001A\u00020\u00052\u0013\u0010\u000E\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\t2\u0013\u0010\u000F\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\t2\u0013\u0010\u0010\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\t2\u0013\u0010\u0011\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\t2\u0006\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u0017\u001A\u00020\u00152\u0006\u0010\u0018\u001A\u00020\u00152\u0006\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u0006\u001A\u00020\u0007H\u0001¢\u0006\u0004\b\u001B\u0010\u001C\u001A£\u0001\u0010\u001D\u001A\u00020\u00012\u0011\u0010\u001E\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\t2\b\b\u0002\u0010\u0004\u001A\u00020\u00052\u0013\u0010\u000F\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\t2\u0013\u0010\u0010\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\t2\u0013\u0010\u0011\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\t2\u0006\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u001F\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u0017\u001A\u00020\u00152\u0006\u0010\u0018\u001A\u00020\u0015H\u0001¢\u0006\u0004\b \u0010!\u001A2\u0010\"\u001A\u00020\u00012\u0006\u0010#\u001A\u00020\u001A2\u0006\u0010$\u001A\u00020\u001A2\u0011\u0010\b\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\tH\u0001¢\u0006\u0004\b%\u0010&\"\u0016\u0010\'\u001A\u00020\u001AX\u0080\u0004¢\u0006\n\n\u0002\u0010*\u001A\u0004\b(\u0010)\"\u0016\u0010+\u001A\u00020\u001AX\u0080\u0004¢\u0006\n\n\u0002\u0010*\u001A\u0004\b,\u0010)\"\u0010\u0010-\u001A\u00020\u001AX\u0082\u0004¢\u0006\u0004\n\u0002\u0010*\"\u0010\u0010.\u001A\u00020\u001AX\u0082\u0004¢\u0006\u0004\n\u0002\u0010*\"\u000E\u0010/\u001A\u000200X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u00101\u001A\u000200X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u00102\u001A\u000200X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u00103\u001A\u000200X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001A\u00104\u001A\b\u0012\u0004\u0012\u00020605X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b7\u00108¨\u00069"}, d2={"BasicAlertDialog", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "properties", "Landroidx/compose/ui/window/DialogProperties;", "content", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/window/DialogProperties;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "AlertDialog", "AlertDialogImpl", "confirmButton", "dismissButton", "icon", "title", "text", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "iconContentColor", "titleContentColor", "textContentColor", "tonalElevation", "Landroidx/compose/ui/unit/Dp;", "AlertDialogImpl-wrnwzgE", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JJJJFLandroidx/compose/ui/window/DialogProperties;Landroidx/compose/runtime/Composer;II)V", "AlertDialogContent", "buttons", "buttonContentColor", "AlertDialogContent-4hvqGtA", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JFJJJJLandroidx/compose/runtime/Composer;III)V", "AlertDialogFlowRow", "mainAxisSpacing", "crossAxisSpacing", "AlertDialogFlowRow-ixp7dh8", "(FFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "DialogMinWidth", "getDialogMinWidth", "()F", "F", "DialogMaxWidth", "getDialogMaxWidth", "ButtonsMainAxisSpacing", "ButtonsCrossAxisSpacing", "DialogPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "IconPadding", "TitlePadding", "TextPadding", "LocalBasicAlertDialogOverride", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material3/BasicAlertDialogOverride;", "getLocalBasicAlertDialogOverride", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AlertDialogKt {
    private static final float ButtonsCrossAxisSpacing;
    private static final float ButtonsMainAxisSpacing;
    private static final float DialogMaxWidth;
    private static final float DialogMinWidth;
    private static final PaddingValues DialogPadding;
    private static final PaddingValues IconPadding;
    private static final ProvidableCompositionLocal LocalBasicAlertDialogOverride;
    private static final PaddingValues TextPadding;
    private static final PaddingValues TitlePadding;

    static {
        AlertDialogKt.DialogMinWidth = Dp.constructor-impl(280f);
        AlertDialogKt.DialogMaxWidth = Dp.constructor-impl(560f);
        AlertDialogKt.ButtonsMainAxisSpacing = Dp.constructor-impl(8f);
        AlertDialogKt.ButtonsCrossAxisSpacing = Dp.constructor-impl(12f);
        AlertDialogKt.DialogPadding = PaddingKt.PaddingValues-0680j_4(Dp.constructor-impl(24f));
        AlertDialogKt.IconPadding = PaddingKt.PaddingValues-a9UjIt4$default(0f, 0f, 0f, Dp.constructor-impl(16f), 7, null);
        AlertDialogKt.TitlePadding = PaddingKt.PaddingValues-a9UjIt4$default(0f, 0f, 0f, Dp.constructor-impl(16f), 7, null);
        AlertDialogKt.TextPadding = PaddingKt.PaddingValues-a9UjIt4$default(0f, 0f, 0f, Dp.constructor-impl(24f), 7, null);
        AlertDialogKt.LocalBasicAlertDialogOverride = CompositionLocalKt.compositionLocalOf$default(null, new AlertDialogKt$$ExternalSyntheticLambda5(), 1, null);
    }

    @Deprecated(message="Use BasicAlertDialog instead", replaceWith="<_subannotation>") public static final void AlertDialog(Function0 arg17, Modifier arg18, DialogProperties arg19, Function2 arg20, Composer arg21, int arg22, int arg23) {
        DialogProperties v3_1;
        Companion v2_1;
        Modifier v7_1;
        Function2 v9;
        int v8;
        int v6;
        Modifier v4;
        Function0 v1;
        int v2;
        int v5 = arg22;
        int v0 = 402506956;
        Composer v10 = arg21.startRestartGroup(v0);
        ComposerKt.sourceInformation(v10, "C(AlertDialog)N(onDismissRequest,modifier,properties,content)215@9651L65:AlertDialog.kt#uh7d8r");
        if((arg23 & 1) != 0) {
            v2 = v5 | 6;
            v1 = arg17;
        }
        else if((v5 & 6) == 0) {
            v1 = arg17;
            v2 = v10.changedInstance(v1) ? 4 : 2;
            v2 |= v5;
        }
        else {
            v1 = arg17;
            v2 = v5;
        }

        int v3 = arg23 & 2;
        if(v3 != 0) {
            v2 |= 0x30;
            goto label_38;
        }
        else if((v5 & 0x30) == 0) {
            v4 = arg18;
            v6 = v10.changed(v4) ? 0x20 : 16;
            v2 |= v6;
        }
        else {
        label_38:
            v4 = arg18;
        }

        v6 = arg23 & 4;
        if(v6 != 0) {
            v2 |= 0x180;
        }
        else if((v5 & 0x180) == 0) {
            v8 = v10.changed(arg19) ? 0x100 : 0x80;
            v2 |= v8;
        }

        if((arg23 & 8) != 0) {
            v2 |= 0xC00;
            v9 = arg20;
        }
        else {
            v9 = arg20;
            if((v5 & 0xC00) == 0) {
                v8 = v10.changedInstance(v9) ? 0x800 : 0x400;
                v2 |= v8;
            }
        }

        boolean v8_1 = (v2 & 0x493) != 1170 ? true : false;
        if(v10.shouldExecute(v8_1, v2 & 1)) {
            if(v3 != 0) {
                Companion v7 = Modifier.Companion;
            }
            else {
                v7_1 = v4;
            }

            DialogProperties v8_2 = v6 != 0 ? new DialogProperties(false, false, false, 7, null) : arg19;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v2, -1, "androidx.compose.material3.AlertDialog (AlertDialog.kt:215)");
            }

            AlertDialogKt.BasicAlertDialog(v1, v7_1, v8_2, v9, v10, v2 & 0x1FFE, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v2_1 = ((Companion)v7_1);
            v3_1 = v8_2;
        }
        else {
            v10.skipToGroupEnd();
            v3_1 = arg19;
            Modifier v2_2 = v4;
        }

        ScopeUpdateScope v7_2 = v10.endRestartGroup();
        if(v7_2 != null) {
            v7_2.updateScope(new AlertDialogKt$$ExternalSyntheticLambda0(arg17, ((Modifier)v2_1), v3_1, arg20, v5, arg23));
        }
    }

    static final Unit AlertDialog$lambda$2(Function0 arg7, Modifier arg8, DialogProperties arg9, Function2 arg10, int arg11, int arg12, Composer arg13, int arg14) {
        AlertDialogKt.AlertDialog(arg7, arg8, arg9, arg10, arg13, RecomposeScopeImplKt.updateChangedFlags(arg11 | 1), arg12);
        return Unit.INSTANCE;
    }

    public static final void AlertDialogContent-4hvqGtA(Function2 arg29, Modifier arg30, Function2 arg31, Function2 arg32, Function2 arg33, Shape arg34, long arg35, float arg37, long arg38, long arg40, long arg42, long arg44, Composer arg46, int arg47, int arg48, int arg49) {
        Companion v2_1;
        Modifier v3_1;
        int v9;
        long v2;
        long v4;
        Function2 v12_1;
        Function2 v11_1;
        Function2 v15;
        int v11;
        Modifier v10;
        int v6;
        int v0 = arg47;
        int v1 = arg49;
        Composer v13 = arg46.startRestartGroup(0x522D8AF1);
        ComposerKt.sourceInformation(v13, "C(AlertDialogContent)N(buttons,modifier,icon,title,text,shape,containerColor:c#ui.graphics.Color,tonalElevation:c#ui.unit.Dp,buttonContentColor:c#ui.graphics.Color,iconContentColor:c#ui.graphics.Color,titleContentColor:c#ui.graphics.Color,textContentColor:c#ui.graphics.Color)314@12992L2065,309@12852L2205:AlertDialog.kt#uh7d8r");
        if((v1 & 1) != 0) {
            v6 = v0 | 6;
        }
        else if((v0 & 6) == 0) {
            v6 = v13.changedInstance(arg29) ? 4 : 2;
            v6 |= v0;
        }
        else {
            v6 = v0;
        }

        int v7 = v1 & 2;
        if(v7 != 0) {
            v6 |= 0x30;
            goto label_39;
        }
        else if((v0 & 0x30) == 0) {
            v10 = arg30;
            v11 = v13.changed(v10) ? 0x20 : 16;
            v6 |= v11;
        }
        else {
        label_39:
            v10 = arg30;
        }

        if((v1 & 4) != 0) {
            v6 |= 0x180;
            v15 = arg31;
        }
        else {
            v15 = arg31;
            if((v0 & 0x180) == 0) {
                v11 = v13.changedInstance(v15) ? 0x100 : 0x80;
                v6 |= v11;
            }
        }

        if((v1 & 8) != 0) {
            v6 |= 0xC00;
            goto label_68;
        }
        else if((v0 & 0xC00) == 0) {
            v11_1 = arg32;
            int v12 = v13.changedInstance(v11_1) ? 0x800 : 0x400;
            v6 |= v12;
        }
        else {
        label_68:
            v11_1 = arg32;
        }

        if((v1 & 16) != 0) {
            v6 |= 0x6000;
            goto label_83;
        }
        else if((v0 & 0x6000) == 0) {
            v12_1 = arg33;
            int v14 = v13.changedInstance(v12_1) ? 0x4000 : 0x2000;
            v6 |= v14;
        }
        else {
        label_83:
            v12_1 = arg33;
        }

        int v16 = 0x30000;
        if((v1 & 0x20) != 0) {
            v6 |= v16;
        }
        else if((v0 & v16) == 0) {
            v16 = v13.changed(arg34) ? 0x20000 : 0x10000;
            v6 |= v16;
        }

        int v17 = 0x180000;
        if((v1 & 0x40) != 0) {
            v6 |= v17;
            v4 = arg35;
        }
        else {
            v4 = arg35;
            if((v0 & v17) == 0) {
                v17 = v13.changed(v4) ? 0x100000 : 0x80000;
                v6 |= v17;
            }
        }

        int v27 = 0xC00000;
        if((v1 & 0x80) != 0) {
            v6 |= v27;
        }
        else if((v0 & v27) == 0) {
            int v18 = v13.changed(arg37) ? 0x800000 : 0x400000;
            v6 |= v18;
        }

        int v19 = 0x6000000;
        if((v1 & 0x100) != 0) {
            v6 |= v19;
        }
        else {
            v2 = arg38;
            if((v0 & v19) == 0) {
                v19 = v13.changed(v2) ? 0x4000000 : 0x2000000;
                v6 |= v19;
            }
        }

        int v20 = 0x30000000;
        if((v1 & 0x200) != 0) {
            v6 |= v20;
        }
        else {
            v2 = arg40;
            if((v0 & v20) == 0) {
                v9 = v13.changed(v2) ? 0x20000000 : 0x10000000;
                v6 |= v9;
            }
        }

        if((v1 & 0x400) != 0) {
            v9 = arg48 | 6;
        }
        else {
            v2 = arg42;
            if((arg48 & 6) == 0) {
                v16 = v13.changed(v2) ? 4 : 2;
                v9 = arg48 | v16;
            }
            else {
                v9 = arg48;
            }
        }

        if((v1 & 0x800) != 0) {
            v9 |= 0x30;
        }
        else if((arg48 & 0x30) == 0) {
            v17 = v13.changed(arg44) ? 0x20 : 16;
            v9 |= v17;
        }

        boolean v0_1 = (v6 & 306783379) != 306783378 || (v9 & 19) != 18 ? true : false;
        if(v13.shouldExecute(v0_1, v6 & 1)) {
            if(v7 != 0) {
                Companion v3 = Modifier.Companion;
            }
            else {
                v3_1 = v10;
            }

            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x522D8AF1, v6, v9, "androidx.compose.material3.AlertDialogContent (AlertDialog.kt:308)");
            }

            v1 = v6 >> 12;
            SurfaceKt.Surface-T9BRK9s(v3_1, arg34, v4, 0, arg37, 0f, null, ComposableLambdaKt.rememberComposableLambda(0xD91714B6, true, new AlertDialogKt$AlertDialogContent$1(v15, v11_1, v12_1, arg40, arg42, arg44, arg38, arg29), v13, 54), v13, v6 >> 3 & 14 | v27 | v1 & 0x70 | v1 & 0x380 | v6 >> 9 & 0xE000, 104);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v2_1 = ((Companion)v3_1);
        }
        else {
            v13.skipToGroupEnd();
            Modifier v2_2 = v10;
        }

        ScopeUpdateScope v0_2 = v13.endRestartGroup();
        if(v0_2 != null) {
            v0_2.updateScope(new AlertDialogKt$$ExternalSyntheticLambda1(arg29, ((Modifier)v2_1), arg31, arg32, arg33, arg34, arg35, arg37, arg38, arg40, arg42, arg44, arg47, arg48, arg49));
        }
    }

    static final Unit AlertDialogContent_4hvqGtA$lambda$4(Function2 arg22, Modifier arg23, Function2 arg24, Function2 arg25, Function2 arg26, Shape arg27, long arg28, float arg30, long arg31, long arg33, long arg35, long arg37, int arg39, int arg40, int arg41, Composer arg42, int arg43) {
        AlertDialogKt.AlertDialogContent-4hvqGtA(arg22, arg23, arg24, arg25, arg26, arg27, arg28, arg30, arg31, arg33, arg35, arg37, arg42, RecomposeScopeImplKt.updateChangedFlags(arg39 | 1), RecomposeScopeImplKt.updateChangedFlags(arg40), arg41);
        return Unit.INSTANCE;
    }

    public static final void AlertDialogFlowRow-ixp7dh8(float arg8, float arg9, Function2 arg10, Composer arg11, int arg12) {
        AlertDialogKt$AlertDialogFlowRow$1$1 v2_2;
        int v3;
        int v1;
        int v0 = 0xC94DF5DC;
        arg11 = arg11.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg11, "C(AlertDialogFlowRow)N(mainAxisSpacing:c#ui.unit.Dp,crossAxisSpacing:c#ui.unit.Dp,content)380@15332L3365,380@15316L3381:AlertDialog.kt#uh7d8r");
        int v2 = 4;
        if((arg12 & 6) == 0) {
            v1 = arg11.changed(arg8) ? v2 : 2;
            v1 |= arg12;
        }
        else {
            v1 = arg12;
        }

        int v4 = 0x20;
        if((arg12 & 0x30) == 0) {
            v3 = arg11.changed(arg9) ? v4 : 16;
            v1 |= v3;
        }

        if((arg12 & 0x180) == 0) {
            v3 = arg11.changedInstance(arg10) ? 0x100 : 0x80;
            v1 |= v3;
        }

        int v6 = 1;
        boolean v3_1 = (v1 & 0x93) != 0x92 ? true : false;
        if(arg11.shouldExecute(v3_1, v1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.compose.material3.AlertDialogFlowRow (AlertDialog.kt:379)");
            }

            ComposerKt.sourceInformationMarkerStart(arg11, 0xADA80FA1, "CC(remember):AlertDialog.kt#9igjgp");
            v0 = (v1 & 14) == v2 ? 1 : 0;
            if((v1 & 0x70) == v4) {
            }
            else {
                v6 = 0;
            }

            Object v2_1 = arg11.rememberedValue();
            if((v0 | v6) != 0 || v2_1 == Composer.Companion.getEmpty()) {
                v2_2 = new AlertDialogKt$AlertDialogFlowRow$1$1(arg8, arg9);
                arg11.updateRememberedValue(v2_2);
            }

            ComposerKt.sourceInformationMarkerEnd(arg11);
            v0 = v1 >> 6 & 14;
            ComposerKt.sourceInformationMarkerStart(arg11, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            Companion v1_1 = Modifier.Companion;
            v3 = ComposablesKt.getCurrentCompositeKeyHash(arg11, 0);
            CompositionLocalMap v4_1 = arg11.getCurrentCompositionLocalMap();
            Modifier v1_2 = ComposedModifierKt.materializeModifier(arg11, ((Modifier)v1_1));
            Function0 v5 = ComposeUiNode.Companion.getConstructor();
            v0 = v0 << 6 & 0x380 | 6;
            ComposerKt.sourceInformationMarkerStart(arg11, 0xD6BD0031, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if(!(arg11.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            arg11.startReusableNode();
            if(arg11.getInserting()) {
                arg11.createNode(v5);
            }
            else {
                arg11.useNode();
            }

            Composer v5_1 = Updater.constructor-impl(arg11);
            Updater.set-impl(v5_1, v2_2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v5_1, v4_1, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v2_3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v5_1.getInserting()) || !Intrinsics.areEqual(v5_1.rememberedValue(), Integer.valueOf(v3))) {
                v5_1.updateRememberedValue(Integer.valueOf(v3));
                v5_1.apply(Integer.valueOf(v3), v2_3);
            }

            Updater.set-impl(v5_1, v1_2, ComposeUiNode.Companion.getSetModifier());
            arg10.invoke(arg11, Integer.valueOf(v0 >> 6 & 14));
            arg11.endNode();
            ComposerKt.sourceInformationMarkerEnd(arg11);
            ComposerKt.sourceInformationMarkerEnd(arg11);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_132;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg11.skipToGroupEnd();
        }

    label_132:
        ScopeUpdateScope v11 = arg11.endRestartGroup();
        if(v11 != null) {
            v11.updateScope(new AlertDialogKt$$ExternalSyntheticLambda4(arg8, arg9, arg10, arg12));
        }
    }

    static final Unit AlertDialogFlowRow_ixp7dh8$lambda$6(float arg0, float arg1, Function2 arg2, int arg3, Composer arg4, int arg5) {
        AlertDialogKt.AlertDialogFlowRow-ixp7dh8(arg0, arg1, arg2, arg4, RecomposeScopeImplKt.updateChangedFlags(arg3 | 1));
        return Unit.INSTANCE;
    }

    public static final void AlertDialogImpl-wrnwzgE(Function0 arg28, Function2 arg29, Modifier arg30, Function2 arg31, Function2 arg32, Function2 arg33, Function2 arg34, Shape arg35, long arg36, long arg38, long arg40, long arg42, float arg44, DialogProperties arg45, Composer arg46, int arg47, int arg48) {
        float v15;
        int v20;
        int v18;
        Function2 v4;
        int v17;
        Function2 v14_1;
        Function2 v8;
        int v6;
        int v0 = arg47;
        int v1 = arg48;
        Composer v7 = arg46.startRestartGroup(0xCC49399D);
        ComposerKt.sourceInformation(v7, "C(AlertDialogImpl)N(onDismissRequest,confirmButton,modifier,dismissButton,icon,title,text,shape,containerColor:c#ui.graphics.Color,iconContentColor:c#ui.graphics.Color,titleContentColor:c#ui.graphics.Color,textContentColor:c#ui.graphics.Color,tonalElevation:c#ui.unit.Dp,properties)265@11313L1110,261@11182L1241:AlertDialog.kt#uh7d8r");
        if((v0 & 6) == 0) {
            v6 = v7.changedInstance(arg28) ? 4 : 2;
            v6 |= v0;
        }
        else {
            v6 = v0;
        }

        if((v0 & 0x30) == 0) {
            v8 = arg29;
            int v11 = v7.changedInstance(v8) ? 0x20 : 16;
            v6 |= v11;
        }
        else {
            v8 = arg29;
        }

        if((v0 & 0x180) == 0) {
            int v14 = v7.changed(arg30) ? 0x100 : 0x80;
            v6 |= v14;
        }

        int v16 = 0x400;
        if((v0 & 0xC00) == 0) {
            v14_1 = arg31;
            v17 = v7.changedInstance(v14_1) ? 0x800 : v16;
            v6 |= v17;
        }
        else {
            v14_1 = arg31;
        }

        if((v0 & 0x6000) == 0) {
            v4 = arg32;
            v17 = v7.changedInstance(v4) ? 0x4000 : 0x2000;
            v6 |= v17;
        }
        else {
            v4 = arg32;
        }

        Function2 v5 = arg33;
        if((v0 & 0x30000) == 0) {
            v18 = v7.changedInstance(v5) ? 0x20000 : 0x10000;
            v6 |= v18;
        }

        Function2 v9 = arg34;
        if((v0 & 0x180000) == 0) {
            int v19 = v7.changedInstance(v9) ? 0x100000 : 0x80000;
            v6 |= v19;
        }

        Shape v10 = arg35;
        if((v0 & 0xC00000) == 0) {
            v20 = v7.changed(v10) ? 0x800000 : 0x400000;
            v6 |= v20;
        }

        long v12 = arg36;
        if((v0 & 0x6000000) == 0) {
            int v22 = v7.changed(v12) ? 0x4000000 : 0x2000000;
            v6 |= v22;
        }

        long v2 = arg38;
        if((v0 & 0x30000000) == 0) {
            int v23 = v7.changed(v2) ? 0x20000000 : 0x10000000;
            v6 |= v23;
        }

        v2 = arg40;
        if((v1 & 6) == 0) {
            v17 = v7.changed(v2) ? 4 : 2;
            v17 |= v1;
        }
        else {
            v17 = v1;
        }

        v2 = arg42;
        if((v1 & 0x30) == 0) {
            v18 = v7.changed(v2) ? 0x20 : 16;
            v17 |= v18;
        }

        if((v1 & 0x180) == 0) {
            v15 = arg44;
            v20 = v7.changed(v15) ? 0x100 : 0x80;
            v17 |= v20;
        }
        else {
            v15 = arg44;
        }

        if((v1 & 0xC00) == 0) {
            if(v7.changed(arg45)) {
                v16 = 0x800;
            }

            v17 |= v16;
        }

        v0 = v17;
        boolean v1_1 = (v6 & 306783379) != 306783378 || (v0 & 0x493) != 1170 ? true : false;
        if(v7.shouldExecute(v1_1, v6 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0xCC49399D, v6, v0, "androidx.compose.material3.AlertDialogImpl (AlertDialog.kt:260)");
            }

            AlertDialogKt.BasicAlertDialog(arg28, arg30, arg45, ComposableLambdaKt.rememberComposableLambda(0x1F6FCD57, true, new AlertDialogKt$AlertDialogImpl$1(v4, v5, v9, v10, v12, v15, arg38, arg40, arg42, v14_1, v8), v7, 54), v7, v6 & 14 | 0xC00 | v6 >> 3 & 0x70 | v0 >> 3 & 0x380, 0);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_210;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v7.skipToGroupEnd();
        }

    label_210:
        ScopeUpdateScope v0_1 = v7.endRestartGroup();
        if(v0_1 != null) {
            v0_1.updateScope(new AlertDialogKt$$ExternalSyntheticLambda2(arg28, arg29, arg30, arg31, arg32, arg33, arg34, arg35, arg36, arg38, arg40, arg42, arg44, arg45, arg47, arg48));
        }
    }

    static final Unit AlertDialogImpl_wrnwzgE$lambda$3(Function0 arg22, Function2 arg23, Modifier arg24, Function2 arg25, Function2 arg26, Function2 arg27, Function2 arg28, Shape arg29, long arg30, long arg32, long arg34, long arg36, float arg38, DialogProperties arg39, int arg40, int arg41, Composer arg42, int arg43) {
        AlertDialogKt.AlertDialogImpl-wrnwzgE(arg22, arg23, arg24, arg25, arg26, arg27, arg28, arg29, arg30, arg32, arg34, arg36, arg38, arg39, arg42, RecomposeScopeImplKt.updateChangedFlags(arg40 | 1), RecomposeScopeImplKt.updateChangedFlags(arg41));
        return Unit.INSTANCE;
    }

    public static final void BasicAlertDialog(Function0 arg19, Modifier arg20, DialogProperties arg21, Function2 arg22, Composer arg23, int arg24, int arg25) {
        Modifier v6_2;
        int v10;
        DialogProperties v9;
        int v8;
        Modifier v7;
        int v3;
        Function0 v1 = arg19;
        Function2 v4 = arg22;
        int v5 = arg24;
        int v0 = 0x17C55DA;
        Composer v2 = arg23.startRestartGroup(v0);
        ComposerKt.sourceInformation(v2, "C(BasicAlertDialog)N(onDismissRequest,modifier,properties,content)144@6884L7,*151@7127L18:AlertDialog.kt#uh7d8r");
        if((arg25 & 1) != 0) {
            v3 = v5 | 6;
        }
        else if((v5 & 6) == 0) {
            v3 = v2.changedInstance(v1) ? 4 : 2;
            v3 |= v5;
        }
        else {
            v3 = v5;
        }

        int v6 = arg25 & 2;
        if(v6 != 0) {
            v3 |= 0x30;
            goto label_36;
        }
        else if((v5 & 0x30) == 0) {
            v7 = arg20;
            v8 = v2.changed(v7) ? 0x20 : 16;
            v3 |= v8;
        }
        else {
        label_36:
            v7 = arg20;
        }

        v8 = arg25 & 4;
        if(v8 != 0) {
            v3 |= 0x180;
            goto label_51;
        }
        else if((v5 & 0x180) == 0) {
            v9 = arg21;
            v10 = v2.changed(v9) ? 0x100 : 0x80;
            v3 |= v10;
        }
        else {
        label_51:
            v9 = arg21;
        }

        if((arg25 & 8) != 0) {
            v3 |= 0xC00;
        }
        else if((v5 & 0xC00) == 0) {
            v10 = v2.changedInstance(v4) ? 0x800 : 0x400;
            v3 |= v10;
        }

        boolean v10_1 = (v3 & 0x493) != 1170 ? true : false;
        if(v2.shouldExecute(v10_1, v3 & 1)) {
            if(v6 != 0) {
                Companion v6_1 = Modifier.Companion;
            }
            else {
                v6_2 = v7;
            }

            if(v8 != 0) {
                v9 = new DialogProperties(false, false, false, 7, null);
            }

            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v3, -1, "androidx.compose.material3.BasicAlertDialog (AlertDialog.kt:143)");
            }

            ProvidableCompositionLocal v0_1 = AlertDialogKt.LocalBasicAlertDialogOverride;
            ComposerKt.sourceInformationMarkerStart(v2, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v0_2 = v2.consume(((CompositionLocal)v0_1));
            ComposerKt.sourceInformationMarkerEnd(v2);
            ((BasicAlertDialogOverride)v0_2).BasicAlertDialog(new BasicAlertDialogOverrideScope(v1, v6_2, v9, v4), v2, 0);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_107;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v2.skipToGroupEnd();
            v6_2 = v7;
        }

    label_107:
        DialogProperties v3_1 = v9;
        ScopeUpdateScope v7_1 = v2.endRestartGroup();
        if(v7_1 != null) {
            v7_1.updateScope(new AlertDialogKt$$ExternalSyntheticLambda3(v1, ((Companion)v6_2), v3_1, v4, v5, arg25));
        }
    }

    static final Unit BasicAlertDialog$lambda$1(Function0 arg7, Modifier arg8, DialogProperties arg9, Function2 arg10, int arg11, int arg12, Composer arg13, int arg14) {
        AlertDialogKt.BasicAlertDialog(arg7, arg8, arg9, arg10, arg13, RecomposeScopeImplKt.updateChangedFlags(arg11 | 1), arg12);
        return Unit.INSTANCE;
    }

    static final BasicAlertDialogOverride LocalBasicAlertDialogOverride$lambda$7() {
        return DefaultBasicAlertDialogOverride.INSTANCE;
    }

    public static final float access$getButtonsCrossAxisSpacing$p() {
        return AlertDialogKt.ButtonsCrossAxisSpacing;
    }

    public static final float access$getButtonsMainAxisSpacing$p() {
        return AlertDialogKt.ButtonsMainAxisSpacing;
    }

    public static final PaddingValues access$getDialogPadding$p() {
        return AlertDialogKt.DialogPadding;
    }

    public static final PaddingValues access$getIconPadding$p() {
        return AlertDialogKt.IconPadding;
    }

    public static final PaddingValues access$getTextPadding$p() {
        return AlertDialogKt.TextPadding;
    }

    public static final PaddingValues access$getTitlePadding$p() {
        return AlertDialogKt.TitlePadding;
    }

    public static final float getDialogMaxWidth() {
        return AlertDialogKt.DialogMaxWidth;
    }

    public static final float getDialogMinWidth() {
        return AlertDialogKt.DialogMinWidth;
    }

    public static final ProvidableCompositionLocal getLocalBasicAlertDialogOverride() {
        return AlertDialogKt.LocalBasicAlertDialogOverride;
    }
}

