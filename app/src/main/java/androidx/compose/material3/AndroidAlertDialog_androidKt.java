package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.window.DialogProperties;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001AÜ\u0001\u0010\u0000\u001A\u00020\u00012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\u0015\b\u0002\u0010\b\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\t\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\n\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\u000B\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\u000F2\b\b\u0002\u0010\u0010\u001A\u00020\u000F2\b\b\u0002\u0010\u0011\u001A\u00020\u000F2\b\b\u0002\u0010\u0012\u001A\u00020\u000F2\b\b\u0002\u0010\u0013\u001A\u00020\u00142\b\b\u0002\u0010\u0015\u001A\u00020\u0016H\u0007¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2={"AlertDialog", "", "onDismissRequest", "Lkotlin/Function0;", "confirmButton", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "dismissButton", "icon", "title", "text", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "iconContentColor", "titleContentColor", "textContentColor", "tonalElevation", "Landroidx/compose/ui/unit/Dp;", "properties", "Landroidx/compose/ui/window/DialogProperties;", "AlertDialog-Oix01E0", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JJJJFLandroidx/compose/ui/window/DialogProperties;Landroidx/compose/runtime/Composer;III)V", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AndroidAlertDialog_androidKt {
    public static final void AlertDialog-Oix01E0(Function0 arg31, Function2 arg32, Modifier arg33, Function2 arg34, Function2 arg35, Function2 arg36, Function2 arg37, Shape arg38, long arg39, long arg41, long arg43, long arg45, float arg47, DialogProperties arg48, Composer arg49, int arg50, int arg51, int arg52) {
        DialogProperties v18_2;
        float v17_1;
        long v15_2;
        long v13_1;
        long v11_2;
        long v9_1;
        Shape v8_2;
        Function2 v6_1;
        Function2 v5_1;
        Function2 v4_1;
        Modifier v3_2;
        Composer v22_1;
        Function2 v8_1;
        long v14_1;
        long v12_1;
        Modifier v6;
        Shape v11_1;
        Function2 v9;
        long v18_1;
        DialogProperties v21_1;
        float v20_1;
        long v16_1;
        long v0_3;
        long v23_1;
        Companion v15_1;
        int v14;
        long v5;
        int v26;
        Shape v13;
        Function2 v11;
        int v23;
        Function2 v10;
        int v21;
        Function2 v7;
        int v19;
        int v16;
        Modifier v15;
        int v12;
        int v8;
        int v0 = arg50;
        int v1 = arg51;
        int v2 = arg52;
        Composer v4 = arg49.startRestartGroup(0x5A1A0B7);
        ComposerKt.sourceInformation(v4, "C(AlertDialog)N(onDismissRequest,confirmButton,modifier,dismissButton,icon,title,text,shape,containerColor:c#ui.graphics.Color,iconContentColor:c#ui.graphics.Color,titleContentColor:c#ui.graphics.Color,textContentColor:c#ui.graphics.Color,tonalElevation:c#ui.unit.Dp,properties)46@1649L514:AndroidAlertDialog.android.kt#uh7d8r");
        if((v2 & 1) != 0) {
            v8 = v0 | 6;
        }
        else if((v0 & 6) == 0) {
            v8 = v4.changedInstance(arg31) ? 4 : 2;
            v8 |= v0;
        }
        else {
            v8 = v0;
        }

        if((v2 & 2) != 0) {
            v8 |= 0x30;
        }
        else if((v0 & 0x30) == 0) {
            v12 = v4.changedInstance(arg32) ? 0x20 : 16;
            v8 |= v12;
        }

        v12 = v2 & 4;
        if(v12 != 0) {
            v8 |= 0x180;
            goto label_55;
        }
        else if((v0 & 0x180) == 0) {
            v15 = arg33;
            v16 = v4.changed(v15) ? 0x100 : 0x80;
            v8 |= v16;
        }
        else {
        label_55:
            v15 = arg33;
        }

        v16 = v2 & 8;
        int v17 = 0x800;
        int v18 = 0x400;
        if(v16 != 0) {
            v8 |= 0xC00;
        }
        else if((v0 & 0xC00) == 0) {
            v19 = v4.changedInstance(arg34) ? v17 : v18;
            v8 |= v19;
        }

        v19 = v2 & 16;
        if(v19 != 0) {
            v8 |= 0x6000;
            goto label_87;
        }
        else if((v0 & 0x6000) == 0) {
            v7 = arg35;
            v21 = v4.changedInstance(v7) ? 0x4000 : 0x2000;
            v8 |= v21;
        }
        else {
        label_87:
            v7 = arg35;
        }

        v21 = v2 & 0x20;
        int v22 = 0x30000;
        if(v21 != 0) {
            v8 |= v22;
            v10 = arg36;
        }
        else {
            v10 = arg36;
            if((v0 & v22) == 0) {
                v23 = v4.changedInstance(v10) ? 0x20000 : 0x10000;
                v8 |= v23;
            }
        }

        v23 = v2 & 0x40;
        int v24 = 0x180000;
        if(v23 != 0) {
            v8 |= v24;
            v11 = arg37;
        }
        else {
            v11 = arg37;
            if((v0 & v24) == 0) {
                int v25 = v4.changedInstance(v11) ? 0x100000 : 0x80000;
                v8 |= v25;
            }
        }

        if((v0 & 0xC00000) == 0) {
            if((v2 & 0x80) == 0) {
                v13 = arg38;
                if(v4.changed(v13)) {
                    v26 = 0x800000;
                }
                else {
                    goto label_129;
                }
            }
            else {
                v13 = arg38;
            label_129:
                v26 = 0x400000;
            }

            v8 |= v26;
        }
        else {
            v13 = arg38;
        }

        if((v0 & 0x6000000) == 0) {
            v5 = arg39;
            v14 = (v2 & 0x100) != 0 || !v4.changed(v5) ? 0x2000000 : 0x4000000;
            v8 |= v14;
        }

        if((0x30000000 & v0) == 0) {
            v5 = arg41;
            v14 = (v2 & 0x200) != 0 || !v4.changed(v5) ? 0x10000000 : 0x20000000;
            v8 |= v14;
        }

        if((v1 & 6) == 0) {
            v5 = arg43;
            int v20 = (v2 & 0x400) != 0 || !v4.changed(v5) ? 2 : 4;
            v14 = v1 | v20;
        }
        else {
            v14 = v1;
        }

        if((v1 & 0x30) == 0) {
            v5 = arg45;
            v22 = (v2 & 0x800) != 0 || !v4.changed(v5) ? 16 : 0x20;
            v14 |= v22;
        }
        else {
            v5 = arg45;
        }

        int v3 = v2 & 0x1000;
        if(v3 != 0) {
            v14 |= 0x180;
        }
        else if((v1 & 0x180) == 0) {
            v26 = v4.changed(arg47) ? 0x100 : 0x80;
            v14 |= v26;
        }

        v0 = v2 & 0x2000;
        if(v0 != 0) {
            v14 |= 0xC00;
            v22 = v0;
        }
        else {
            v22 = v0;
            if((v1 & 0xC00) == 0) {
                if(v4.changed(arg48)) {
                }
                else {
                    v17 = v18;
                }

                v14 |= v17;
            }
        }

        boolean v0_1 = (v8 & 306783379) != 306783378 || (v14 & 0x493) != 1170 ? true : false;
        if(v4.shouldExecute(v0_1, v8 & 1)) {
            v4.startDefaults();
            ComposerKt.sourceInformation(v4, "62@4977L5,62@5032L14,62@5098L16,62@5167L17,62@5236L16");
            v1 = 0xF1FFFFFF;
            v17 = 0xFE3FFFFF;
            if((arg50 & 1) == 0 || (v4.getDefaultsInvalid())) {
                if(v12 != 0) {
                    v15_1 = Modifier.Companion;
                }

                Function2 v0_2 = null;
                Function2 v12_2 = v16 != 0 ? v0_2 : arg34;
                if(v19 != 0) {
                    v7 = v0_2;
                }

                if(v21 != 0) {
                    v10 = v0_2;
                }

                if(v23 != 0) {
                    v11 = v0_2;
                }

                int v49 = v1;
                v1 = 6;
                if((v2 & 0x80) != 0) {
                    v8 &= v17;
                    v13 = AlertDialogDefaults.INSTANCE.getShape(v4, v1);
                }

                if((v2 & 0x100) != 0) {
                    v16_1 = AlertDialogDefaults.INSTANCE.getContainerColor(v4, v1);
                    v8 &= v49;
                }
                else {
                    v16_1 = arg39;
                }

                if((v2 & 0x200) != 0) {
                    v18_1 = AlertDialogDefaults.INSTANCE.getIconContentColor(v4, v1);
                    v8 &= 0x8FFFFFFF;
                }
                else {
                    v18_1 = arg41;
                }

                if((v2 & 0x400) != 0) {
                    v23_1 = AlertDialogDefaults.INSTANCE.getTitleContentColor(v4, v1);
                    v14 &= -15;
                }
                else {
                    v23_1 = arg43;
                }

                if((v2 & 0x800) != 0) {
                    v0_3 = AlertDialogDefaults.INSTANCE.getTextContentColor(v4, v1);
                    v14 &= 0xFFFFFF8F;
                }
                else {
                    v0_3 = v5;
                }

                float v3_1 = v3 != 0 ? AlertDialogDefaults.INSTANCE.getTonalElevation-D9Ej5fM() : arg47;
                if(v22 != 0) {
                    v20_1 = v3_1;
                    v21_1 = new DialogProperties(false, false, false, 7, null);
                }
                else {
                    v21_1 = arg48;
                    v20_1 = v3_1;
                }

                v9 = v10;
                v10 = v11;
                v11_1 = v13;
                v6 = ((Modifier)v15_1);
                v3 = 0x5A1A0B7;
                int v28 = v8;
                v8_1 = v7;
                v7 = v12_2;
                v12_1 = v16_1;
                v16_1 = v23_1;
                long v29 = v0_3;
                v0 = v28;
                v1 = v14;
                v14_1 = v18_1;
                v18_1 = v29;
            }
            else {
                v4.skipToGroupEnd();
                if((v2 & 0x80) != 0) {
                    v8 &= v17;
                }

                if((v2 & 0x100) != 0) {
                    v8 &= v1;
                }

                if((v2 & 0x200) != 0) {
                    v8 &= 0x8FFFFFFF;
                }

                if((v2 & 0x400) != 0) {
                    v14 &= -15;
                }

                if((v2 & 0x800) != 0) {
                    v14 &= 0xFFFFFF8F;
                }

                v16_1 = arg43;
                v20_1 = arg47;
                v21_1 = arg48;
                v18_1 = v5;
                v0 = v8;
                v9 = v10;
                v10 = v11;
                v11_1 = v13;
                v1 = v14;
                v6 = v15;
                v3 = 0x5A1A0B7;
                v12_1 = arg39;
                v14_1 = arg41;
                v8_1 = v7;
                v7 = arg34;
            }

            v4.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v3, v0, v1, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:46)");
            }

            v22_1 = v4;
            AlertDialogKt.AlertDialogImpl-wrnwzgE(arg31, arg32, v6, v7, v8_1, v9, v10, v11_1, v12_1, v14_1, v16_1, v18_1, v20_1, v21_1, v22_1, v0 & 0x7FFFFFFE, v1 & 0x1FFE);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v3_2 = v6;
            v4_1 = v7;
            v5_1 = v8_1;
            v6_1 = v9;
            v7 = v10;
            v8_2 = v11_1;
            v9_1 = v12_1;
            v11_2 = v14_1;
            v13_1 = v16_1;
            v15_2 = v18_1;
            v17_1 = v20_1;
            v18_2 = v21_1;
        }
        else {
            v22_1 = v4;
            v22_1.skipToGroupEnd();
            v4_1 = arg34;
            v17_1 = arg47;
            v18_2 = arg48;
            v8_2 = v13;
            v3_2 = v15;
            v13_1 = arg43;
            v15_2 = v5;
            v5_1 = v7;
            v6_1 = v10;
            v7 = v11;
            v9_1 = arg39;
            v11_2 = arg41;
        }

        ScopeUpdateScope v0_4 = v22_1.endRestartGroup();
        if(v0_4 != null) {
            v0_4.updateScope(new AndroidAlertDialog_androidKt$$ExternalSyntheticLambda0(arg31, arg32, v3_2, v4_1, v5_1, v6_1, v7, v8_2, v9_1, v11_2, v13_1, v15_2, v17_1, v18_2, arg50, arg51, v2));
        }
    }

    static final Unit AlertDialog_Oix01E0$lambda$0(Function0 arg23, Function2 arg24, Modifier arg25, Function2 arg26, Function2 arg27, Function2 arg28, Function2 arg29, Shape arg30, long arg31, long arg33, long arg35, long arg37, float arg39, DialogProperties arg40, int arg41, int arg42, int arg43, Composer arg44, int arg45) {
        AndroidAlertDialog_androidKt.AlertDialog-Oix01E0(arg23, arg24, arg25, arg26, arg27, arg28, arg29, arg30, arg31, arg33, arg35, arg37, arg39, arg40, arg44, RecomposeScopeImplKt.updateChangedFlags(arg41 | 1), RecomposeScopeImplKt.updateChangedFlags(arg42), arg43);
        return Unit.INSTANCE;
    }
}

