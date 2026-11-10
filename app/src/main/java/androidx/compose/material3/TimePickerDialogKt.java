package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.material3.tokens.DialogTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.compose.ui.window.DialogProperties;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001A·\u0001\u0010\u0000\u001A\u00020\u00012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\u0011\u0010\u0006\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\n2\u0015\b\u0002\u0010\u000B\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\f\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\r\u001A\u00020\u000E2\b\b\u0002\u0010\u000F\u001A\u00020\u00102\u001C\u0010\u0011\u001A\u0018\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u0014H\u0007¢\u0006\u0004\b\u0015\u0010\u0016\u001A\u009F\u0001\u0010\u0017\u001A\u00020\u00012\u0011\u0010\u0004\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\u0011\u0010\u0006\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0007\u001A\u00020\b2\u0015\b\u0002\u0010\u000B\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\f\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\r\u001A\u00020\u000E2\b\b\u0002\u0010\u000F\u001A\u00020\u00102\u001C\u0010\u0011\u001A\u0018\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u0014H\u0001¢\u0006\u0004\b\u0018\u0010\u0019\u001AQ\u0010\u001A\u001A\u00020\u00012\u0011\u0010\u0006\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\u0011\u0010\u001B\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\u001C\u0010\u0011\u001A\u0018\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u0014H\u0001¢\u0006\u0002\u0010\u001C¨\u0006\u001D"}, d2={"TimePickerDialog", "", "onDismissRequest", "Lkotlin/Function0;", "confirmButton", "Landroidx/compose/runtime/Composable;", "title", "modifier", "Landroidx/compose/ui/Modifier;", "properties", "Landroidx/compose/ui/window/DialogProperties;", "modeToggleButton", "dismissButton", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "TimePickerDialog-FItCLgY", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/window/DialogProperties;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "TimePickerDialogLayout", "TimePickerDialogLayout-3csKH6Y", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "TimePickerCustomLayout", "actions", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TimePickerDialogKt {
    public static final void TimePickerCustomLayout(Function2 arg8, Function2 arg9, Function3 arg10, Composer arg11, int arg12) {
        TimePickerDialogKt$TimePickerCustomLayout$measurePolicy$1$1 v1_2;
        int v2;
        int v1;
        int v0 = 0xE2961B1E;
        arg11 = arg11.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg11, "C(TimePickerCustomLayout)N(title,actions,content)132@5459L238,138@5723L4285,234@10014L56:TimePickerDialog.kt#uh7d8r");
        if((arg12 & 6) == 0) {
            v1 = arg11.changedInstance(arg8) ? 4 : 2;
            v1 |= arg12;
        }
        else {
            v1 = arg12;
        }

        if((arg12 & 0x30) == 0) {
            v2 = arg11.changedInstance(arg9) ? 0x20 : 16;
            v1 |= v2;
        }

        if((arg12 & 0x180) == 0) {
            v2 = arg11.changedInstance(arg10) ? 0x100 : 0x80;
            v1 |= v2;
        }

        boolean v2_1 = (v1 & 0x93) != 0x92 ? true : false;
        if(arg11.shouldExecute(v2_1, v1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.compose.material3.TimePickerCustomLayout (TimePickerDialog.kt:130)");
            }

            ComposableLambda v0_1 = ComposableLambdaKt.rememberComposableLambda(0x1BE9C75F, true, new TimePickerDialogKt$TimePickerCustomLayout$content$1(arg10, arg8, arg9), arg11, 54);
            ComposerKt.sourceInformationMarkerStart(arg11, -1787029541, "CC(remember):TimePickerDialog.kt#9igjgp");
            Object v1_1 = arg11.rememberedValue();
            if(v1_1 == Composer.Companion.getEmpty()) {
                v1_2 = TimePickerDialogKt$TimePickerCustomLayout$measurePolicy$1$1.INSTANCE;
                arg11.updateRememberedValue(v1_2);
            }

            ComposerKt.sourceInformationMarkerEnd(arg11);
            ComposerKt.sourceInformationMarkerStart(arg11, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            Companion v2_2 = Modifier.Companion;
            int v3 = ComposablesKt.getCurrentCompositeKeyHash(arg11, 0);
            CompositionLocalMap v4 = arg11.getCurrentCompositionLocalMap();
            Modifier v2_3 = ComposedModifierKt.materializeModifier(arg11, ((Modifier)v2_2));
            Function0 v5 = ComposeUiNode.Companion.getConstructor();
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
            Updater.set-impl(v5_1, v1_2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v5_1, v4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v1_3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v5_1.getInserting()) || !Intrinsics.areEqual(v5_1.rememberedValue(), Integer.valueOf(v3))) {
                v5_1.updateRememberedValue(Integer.valueOf(v3));
                v5_1.apply(Integer.valueOf(v3), v1_3);
            }

            Updater.set-impl(v5_1, v2_3, ComposeUiNode.Companion.getSetModifier());
            ((Function2)v0_1).invoke(arg11, Integer.valueOf(6));
            arg11.endNode();
            ComposerKt.sourceInformationMarkerEnd(arg11);
            ComposerKt.sourceInformationMarkerEnd(arg11);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_116;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg11.skipToGroupEnd();
        }

    label_116:
        ScopeUpdateScope v11 = arg11.endRestartGroup();
        if(v11 != null) {
            v11.updateScope(new TimePickerDialogKt$$ExternalSyntheticLambda0(arg8, arg9, arg10, arg12));
        }
    }

    static final Unit TimePickerCustomLayout$lambda$3(Function2 arg0, Function2 arg1, Function3 arg2, int arg3, Composer arg4, int arg5) {
        TimePickerDialogKt.TimePickerCustomLayout(arg0, arg1, arg2, arg4, RecomposeScopeImplKt.updateChangedFlags(arg3 | 1));
        return Unit.INSTANCE;
    }

    public static final void TimePickerDialog-FItCLgY(Function0 arg25, Function2 arg26, Function2 arg27, Modifier arg28, DialogProperties arg29, Function2 arg30, Function2 arg31, Shape arg32, long arg33, Function3 arg35, Composer arg36, int arg37, int arg38) {
        long v9_1;
        Shape v8_1;
        Function2 v7_1;
        Function2 v6_2;
        Modifier v4_2;
        DialogProperties v5_1;
        Composer v0_4;
        Modifier v17_1;
        Function2 v19;
        Function2 v18_1;
        long v21;
        Shape v20;
        Shape v0_3;
        int v0;
        int v36;
        int v17;
        Function2 v14_1;
        int v11;
        Function2 v10_1;
        int v9;
        DialogProperties v8;
        int v7;
        Modifier v6;
        int v5;
        Function2 v4_1;
        Function2 v15;
        int v3;
        int v12 = arg37;
        int v13 = arg38;
        Composer v1 = arg36.startRestartGroup(951250327);
        ComposerKt.sourceInformation(v1, "C(TimePickerDialog)N(onDismissRequest,confirmButton,title,modifier,properties,modeToggleButton,dismissButton,shape,containerColor:c#ui.graphics.Color,content)80@3861L347,80@3792L416:TimePickerDialog.kt#uh7d8r");
        if((v13 & 1) != 0) {
            v3 = v12 | 6;
        }
        else if((v12 & 6) == 0) {
            v3 = v1.changedInstance(arg25) ? 4 : 2;
            v3 |= v12;
        }
        else {
            v3 = v12;
        }

        if((v13 & 2) != 0) {
            v3 |= 0x30;
            v15 = arg26;
        }
        else {
            v15 = arg26;
            if((v12 & 0x30) == 0) {
                int v4 = v1.changedInstance(v15) ? 0x20 : 16;
                v3 |= v4;
            }
        }

        if((v13 & 4) != 0) {
            v3 |= 0x180;
            goto label_53;
        }
        else if((v12 & 0x180) == 0) {
            v4_1 = arg27;
            v5 = v1.changedInstance(v4_1) ? 0x100 : 0x80;
            v3 |= v5;
        }
        else {
        label_53:
            v4_1 = arg27;
        }

        v5 = v13 & 8;
        if(v5 != 0) {
            v3 |= 0xC00;
            goto label_68;
        }
        else if((v12 & 0xC00) == 0) {
            v6 = arg28;
            v7 = v1.changed(v6) ? 0x800 : 0x400;
            v3 |= v7;
        }
        else {
        label_68:
            v6 = arg28;
        }

        v7 = v13 & 16;
        if(v7 != 0) {
            v3 |= 0x6000;
            goto label_83;
        }
        else if((v12 & 0x6000) == 0) {
            v8 = arg29;
            v9 = v1.changed(v8) ? 0x4000 : 0x2000;
            v3 |= v9;
        }
        else {
        label_83:
            v8 = arg29;
        }

        v9 = v13 & 0x20;
        int v10 = 0x30000;
        if(v9 != 0) {
            v3 |= v10;
            goto label_99;
        }
        else if((v10 & v12) == 0) {
            v10_1 = arg30;
            v11 = v1.changedInstance(v10_1) ? 0x20000 : 0x10000;
            v3 |= v11;
        }
        else {
        label_99:
            v10_1 = arg30;
        }

        v11 = v13 & 0x40;
        int v14 = 0x180000;
        if(v11 != 0) {
            v3 |= v14;
            goto label_115;
        }
        else if((v14 & v12) == 0) {
            v14_1 = arg31;
            int v16 = v1.changedInstance(v14_1) ? 0x100000 : 0x80000;
            v3 |= v16;
        }
        else {
        label_115:
            v14_1 = arg31;
        }

        if((v12 & 0xC00000) == 0) {
            v17 = (v13 & 0x80) != 0 || !v1.changed(arg32) ? 0x400000 : 0x800000;
            v3 |= v17;
        }

        if((v12 & 0x6000000) == 0) {
            v36 = v3;
            long v2 = arg33;
            v0 = (v13 & 0x100) != 0 || !v1.changed(v2) ? 0x2000000 : 0x4000000;
            v0 |= v36;
        }
        else {
            v0 = v3;
        }

        v36 = v0;
        v17 = 0x30000000;
        if((v13 & 0x200) != 0) {
            v17 |= v36;
        }
        else if((v12 & v17) == 0) {
            v17 = v1.changedInstance(arg35) ? 0x20000000 : 0x10000000;
            v17 |= v36;
        }
        else {
            v17 = v36;
        }

        boolean v0_1 = (v17 & 306783379) != 306783378 ? true : false;
        if(v1.shouldExecute(v0_1, v17 & 1)) {
            v1.startDefaults();
            ComposerKt.sourceInformation(v1, "76@3659L5,77@3719L14");
            int v2_1 = 0xF1FFFFFF;
            int v18 = 0xFE3FFFFF;
            if((v12 & 1) == 0 || (v1.getDefaultsInvalid())) {
                if(v5 != 0) {
                    Companion v6_1 = Modifier.Companion;
                }

                DialogProperties v19_1 = v7 != 0 ? new DialogProperties(false, false, false, 3, null) : v8;
                Function2 v0_2 = null;
                if(v9 != 0) {
                    v10_1 = v0_2;
                }

                if(v11 != 0) {
                    v14_1 = v0_2;
                }

                v5 = 6;
                if((v13 & 0x80) != 0) {
                    v0_3 = TimePickerDialogDefaults.INSTANCE.getShape(v1, v5);
                    v17 &= v18;
                }
                else {
                    v0_3 = arg32;
                }

                if((v13 & 0x100) != 0) {
                    v17 &= v2_1;
                    v20 = v0_3;
                    v21 = TimePickerDialogDefaults.INSTANCE.getContainerColor(v1, v5);
                }
                else {
                    v21 = arg33;
                    v20 = v0_3;
                }

                v18_1 = v10_1;
                v0 = v17;
                v8 = v19_1;
                v17_1 = v6;
                v19 = v14_1;
            }
            else {
                v1.skipToGroupEnd();
                if((v13 & 0x80) != 0) {
                    v17 &= v18;
                }

                if((v13 & 0x100) != 0) {
                    v17 &= v2_1;
                }

                v20 = arg32;
                v21 = arg33;
                v18_1 = v10_1;
                v19 = v14_1;
                v0 = v17;
                v17_1 = v6;
            }

            v1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(951250327, v0, -1, "androidx.compose.material3.TimePickerDialog (TimePickerDialog.kt:79)");
            }

            AndroidDialog_androidKt.Dialog(arg25, v8, ComposableLambdaKt.rememberComposableLambda(0x11A9A92E, true, new TimePickerDialogKt$TimePickerDialog$1(v15, v4_1, v17_1, v18_1, v19, v20, v21, arg35), v1, 54), v1, v0 >> 9 & 0x70 | (v0 & 14 | 0x180), 0);
            v0_4 = v1;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v5_1 = v8;
            v4_2 = v17_1;
            v6_2 = v18_1;
            v7_1 = v19;
            v8_1 = v20;
            v9_1 = v21;
        }
        else {
            v0_4 = v1;
            v0_4.skipToGroupEnd();
            v4_2 = v6;
            v5_1 = v8;
            v6_2 = v10_1;
            v7_1 = v14_1;
            v8_1 = arg32;
            v9_1 = arg33;
        }

        ScopeUpdateScope v14_2 = v0_4.endRestartGroup();
        if(v14_2 != null) {
            v14_2.updateScope(new TimePickerDialogKt$$ExternalSyntheticLambda2(arg25, arg26, arg27, v4_2, v5_1, v6_2, v7_1, v8_1, v9_1, arg35, v12, v13));
        }
    }

    public static final void TimePickerDialogLayout-3csKH6Y(Function2 arg25, Function2 arg26, Modifier arg27, Function2 arg28, Function2 arg29, Shape arg30, long arg31, Function3 arg33, Composer arg34, int arg35, int arg36) {
        long v7_1;
        Function2 v5_1;
        Composer v22;
        int v0_1;
        int v16;
        long v14_1;
        int v14;
        Shape v13_1;
        Function2 v12;
        int v9;
        Function2 v8;
        int v7;
        Modifier v6;
        int v5;
        Function2 v4;
        int v3;
        int v10 = arg35;
        int v11 = arg36;
        Composer v1 = arg34.startRestartGroup(0xE80BE514);
        ComposerKt.sourceInformation(v1, "C(TimePickerDialogLayout)N(confirmButton,title,modifier,modeToggleButton,dismissButton,shape,containerColor:c#ui.graphics.Color,content)109@4835L408,105@4660L583:TimePickerDialog.kt#uh7d8r");
        if((v11 & 1) != 0) {
            v3 = v10 | 6;
        }
        else if((v10 & 6) == 0) {
            v3 = v1.changedInstance(arg25) ? 4 : 2;
            v3 |= v10;
        }
        else {
            v3 = v10;
        }

        if((v11 & 2) != 0) {
            v3 |= 0x30;
            goto label_39;
        }
        else if((v10 & 0x30) == 0) {
            v4 = arg26;
            v5 = v1.changedInstance(v4) ? 0x20 : 16;
            v3 |= v5;
        }
        else {
        label_39:
            v4 = arg26;
        }

        v5 = v11 & 4;
        if(v5 != 0) {
            v3 |= 0x180;
            goto label_54;
        }
        else if((v10 & 0x180) == 0) {
            v6 = arg27;
            v7 = v1.changed(v6) ? 0x100 : 0x80;
            v3 |= v7;
        }
        else {
        label_54:
            v6 = arg27;
        }

        v7 = v11 & 8;
        if(v7 != 0) {
            v3 |= 0xC00;
            goto label_69;
        }
        else if((v10 & 0xC00) == 0) {
            v8 = arg28;
            v9 = v1.changedInstance(v8) ? 0x800 : 0x400;
            v3 |= v9;
        }
        else {
        label_69:
            v8 = arg28;
        }

        v9 = v11 & 16;
        if(v9 != 0) {
            v3 |= 0x6000;
            goto label_84;
        }
        else if((v10 & 0x6000) == 0) {
            v12 = arg29;
            int v13 = v1.changedInstance(v12) ? 0x4000 : 0x2000;
            v3 |= v13;
        }
        else {
        label_84:
            v12 = arg29;
        }

        if((0x30000 & v10) == 0) {
            if((v11 & 0x20) == 0) {
                v13_1 = arg30;
                if(v1.changed(v13_1)) {
                    v14 = 0x20000;
                }
                else {
                    goto label_96;
                }
            }
            else {
                v13_1 = arg30;
            label_96:
                v14 = 0x10000;
            }

            v3 |= v14;
        }
        else {
            v13_1 = arg30;
        }

        if((0x180000 & v10) == 0) {
            if((v11 & 0x40) == 0) {
                v14_1 = arg31;
                if(v1.changed(v14_1)) {
                    v16 = 0x100000;
                }
                else {
                    goto label_111;
                }
            }
            else {
                v14_1 = arg31;
            label_111:
                v16 = 0x80000;
            }

            v3 |= v16;
        }
        else {
            v14_1 = arg31;
        }

        int v17 = 0xC00000;
        if((v11 & 0x80) != 0) {
            v3 |= v17;
        }
        else if((v10 & v17) == 0) {
            v17 = v1.changedInstance(arg33) ? 0x800000 : 0x400000;
            v3 |= v17;
        }

        int v34 = v3;
        boolean v0 = (v3 & 0x492493) != 4793490 ? true : false;
        if(v1.shouldExecute(v0, v34 & 1)) {
            v1.startDefaults();
            ComposerKt.sourceInformation(v1, "101@4527L5,102@4587L14");
            int v2 = 0xFFC7FFFF;
            v17 = 0xFFF8FFFF;
            if((v10 & 1) == 0 || (v1.getDefaultsInvalid())) {
                if(v5 != 0) {
                    Companion v6_1 = Modifier.Companion;
                }

                Function2 v0_2 = null;
                if(v7 != 0) {
                    v8 = v0_2;
                }

                if(v9 != 0) {
                    v12 = v0_2;
                }

                v5 = 6;
                if((v11 & 0x20) != 0) {
                    v7 = v34 & v17;
                    v13_1 = TimePickerDialogDefaults.INSTANCE.getShape(v1, v5);
                }
                else {
                    v7 = v34;
                }

                if((v11 & 0x40) != 0) {
                    v14_1 = TimePickerDialogDefaults.INSTANCE.getContainerColor(v1, v5);
                    v0_1 = v7 & v2;
                    goto label_187;
                }

                v0_1 = v7;
            }
            else {
                v1.skipToGroupEnd();
                v0_1 = (v11 & 0x20) != 0 ? v34 & v17 : v34;
                if((v11 & 0x40) == 0) {
                    goto label_187;
                }

                v0_1 &= v2;
            }

        label_187:
            v1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0xE80BE514, v0_1, -1, "androidx.compose.material3.TimePickerDialogLayout (TimePickerDialog.kt:104)");
            }

            float v18 = DialogTokens.INSTANCE.getContainerElevation-D9Ej5fM();
            Function2 v2_1 = v12;
            Modifier v12_1 = BackgroundKt.background-bw27NRU(v6, v14_1, v13_1);
            Function2 v31 = v2_1;
            TimePickerDialogKt$TimePickerDialogLayout$1 v2_2 = new TimePickerDialogKt$TimePickerDialogLayout$1(v4, arg33, v8, v31, arg25);
            v4 = v31;
            ComposableLambda v21 = ComposableLambdaKt.rememberComposableLambda(0x5ABA1199, true, v2_2, v1, 54);
            long v2_3 = v14_1;
            v22 = v1;
            SurfaceKt.Surface-T9BRK9s(v12_1, v13_1, 0, 0, v18, 0f, null, ((Function2)v21), v22, v0_1 >> 12 & 0x70 | 0xC06000, 108);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v5_1 = v4;
            v4 = v8;
            v7_1 = v2_3;
        }
        else {
            v22 = v1;
            v22.skipToGroupEnd();
            v4 = v8;
            v5_1 = v12;
            v7_1 = v14_1;
        }

        Modifier v3_1 = v6;
        Shape v6_2 = v13_1;
        ScopeUpdateScope v12_2 = v22.endRestartGroup();
        if(v12_2 != null) {
            v12_2.updateScope(new TimePickerDialogKt$$ExternalSyntheticLambda1(arg25, arg26, v3_1, v4, v5_1, v6_2, v7_1, arg33, v10, v11));
        }
    }

    static final Unit TimePickerDialogLayout_3csKH6Y$lambda$1(Function2 arg13, Function2 arg14, Modifier arg15, Function2 arg16, Function2 arg17, Shape arg18, long arg19, Function3 arg21, int arg22, int arg23, Composer arg24, int arg25) {
        TimePickerDialogKt.TimePickerDialogLayout-3csKH6Y(arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg21, arg24, RecomposeScopeImplKt.updateChangedFlags(arg22 | 1), arg23);
        return Unit.INSTANCE;
    }

    static final Unit TimePickerDialog_FItCLgY$lambda$0(Function0 arg15, Function2 arg16, Function2 arg17, Modifier arg18, DialogProperties arg19, Function2 arg20, Function2 arg21, Shape arg22, long arg23, Function3 arg25, int arg26, int arg27, Composer arg28, int arg29) {
        TimePickerDialogKt.TimePickerDialog-FItCLgY(arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg22, arg23, arg25, arg28, RecomposeScopeImplKt.updateChangedFlags(arg26 | 1), arg27);
        return Unit.INSTANCE;
    }
}

