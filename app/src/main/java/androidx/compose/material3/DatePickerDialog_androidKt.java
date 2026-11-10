package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment$Vertical;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.DialogProperties;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

@Metadata(d1={"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001A\u0097\u0001\u0010\u0000\u001A\u00020\u00012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\u0015\b\u0002\u0010\b\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\t\u001A\u00020\n2\b\b\u0002\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\r\u001A\u00020\u000E2\b\b\u0002\u0010\u000F\u001A\u00020\u00102\u001C\u0010\u0011\u001A\u0018\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u0014H\u0007¢\u0006\u0004\b\u0015\u0010\u0016\"\u000E\u0010\u0017\u001A\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0019\u001A\u00020\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001A\"\u0010\u0010\u001B\u001A\u00020\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001A¨\u0006\u001C"}, d2={"DatePickerDialog", "", "onDismissRequest", "Lkotlin/Function0;", "confirmButton", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "dismissButton", "shape", "Landroidx/compose/ui/graphics/Shape;", "tonalElevation", "Landroidx/compose/ui/unit/Dp;", "colors", "Landroidx/compose/material3/DatePickerColors;", "properties", "Landroidx/compose/ui/window/DialogProperties;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "DatePickerDialog-GmEhDVc", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;FLandroidx/compose/material3/DatePickerColors;Landroidx/compose/ui/window/DialogProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DialogButtonsPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "DialogButtonsMainAxisSpacing", "F", "DialogButtonsCrossAxisSpacing", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class DatePickerDialog_androidKt {
    private static final float DialogButtonsCrossAxisSpacing;
    private static final float DialogButtonsMainAxisSpacing;
    private static final PaddingValues DialogButtonsPadding;

    static {
        DatePickerDialog_androidKt.DialogButtonsPadding = PaddingKt.PaddingValues-a9UjIt4$default(0f, 0f, Dp.constructor-impl(6f), Dp.constructor-impl(8f), 3, null);
        DatePickerDialog_androidKt.DialogButtonsMainAxisSpacing = Dp.constructor-impl(8f);
        DatePickerDialog_androidKt.DialogButtonsCrossAxisSpacing = Dp.constructor-impl(12f);
    }

    public static final void DatePickerDialog-GmEhDVc(Function0 arg20, Function2 arg21, Modifier arg22, Function2 arg23, Shape arg24, float arg25, DatePickerColors arg26, DialogProperties arg27, Function3 arg28, Composer arg29, int arg30, int arg31) {
        Shape v5_1;
        Composer v0_4;
        Modifier v3_1;
        Function2 v4_1;
        float v6_3;
        DialogProperties v8_1;
        int v0_2;
        boolean v6_2;
        Shape v13_2;
        Modifier v0_3;
        float v15_1;
        Function2 v17_1;
        DialogProperties v3;
        Companion v6_1;
        int v17;
        int v15;
        DatePickerColors v14_1;
        float v13_1;
        int v12;
        Shape v9_1;
        Function2 v8;
        int v7;
        Modifier v6;
        int v4;
        int v2;
        int v10 = arg30;
        int v11 = arg31;
        Composer v5 = arg29.startRestartGroup(0xD18A3F1);
        ComposerKt.sourceInformation(v5, "C(DatePickerDialog)N(onDismissRequest,confirmButton,modifier,dismissButton,shape,tonalElevation:c#ui.unit.Dp,colors,properties,content)79@3746L1617,75@3595L1768:DatePickerDialog.android.kt#uh7d8r");
        if((v11 & 1) != 0) {
            v2 = v10 | 6;
        }
        else if((v10 & 6) == 0) {
            v2 = v5.changedInstance(arg20) ? 4 : 2;
            v2 |= v10;
        }
        else {
            v2 = v10;
        }

        if((v11 & 2) != 0) {
            v2 |= 0x30;
        }
        else if((v10 & 0x30) == 0) {
            v4 = v5.changedInstance(arg21) ? 0x20 : 16;
            v2 |= v4;
        }

        v4 = v11 & 4;
        if(v4 != 0) {
            v2 |= 0x180;
            goto label_54;
        }
        else if((v10 & 0x180) == 0) {
            v6 = arg22;
            v7 = v5.changed(v6) ? 0x100 : 0x80;
            v2 |= v7;
        }
        else {
        label_54:
            v6 = arg22;
        }

        v7 = v11 & 8;
        if(v7 != 0) {
            v2 |= 0xC00;
            goto label_69;
        }
        else if((v10 & 0xC00) == 0) {
            v8 = arg23;
            int v9 = v5.changedInstance(v8) ? 0x800 : 0x400;
            v2 |= v9;
        }
        else {
        label_69:
            v8 = arg23;
        }

        if((v10 & 0x6000) == 0) {
            if((v11 & 16) == 0) {
                v9_1 = arg24;
                if(v5.changed(v9_1)) {
                    v12 = 0x4000;
                }
                else {
                    goto label_80;
                }
            }
            else {
                v9_1 = arg24;
            label_80:
                v12 = 0x2000;
            }

            v2 |= v12;
        }
        else {
            v9_1 = arg24;
        }

        v12 = v11 & 0x20;
        int v13 = 0x30000;
        if(v12 != 0) {
            v2 |= v13;
            goto label_99;
        }
        else if((v13 & v10) == 0) {
            v13_1 = arg25;
            int v14 = v5.changed(v13_1) ? 0x20000 : 0x10000;
            v2 |= v14;
        }
        else {
        label_99:
            v13_1 = arg25;
        }

        if((0x180000 & v10) == 0) {
            if((v11 & 0x40) == 0) {
                v14_1 = arg26;
                if(v5.changed(v14_1)) {
                    v15 = 0x100000;
                }
                else {
                    goto label_111;
                }
            }
            else {
                v14_1 = arg26;
            label_111:
                v15 = 0x80000;
            }

            v2 |= v15;
        }
        else {
            v14_1 = arg26;
        }

        v15 = v11 & 0x80;
        int v16 = 0xC00000;
        if(v15 != 0) {
            v2 |= v16;
        }
        else {
            DialogProperties v0 = arg27;
            if((v10 & v16) == 0) {
                v17 = v5.changed(v0) ? 0x800000 : 0x400000;
                v2 |= v17;
            }
        }

        v17 = 0x6000000;
        if((v11 & 0x100) != 0) {
            v2 |= v17;
        }
        else if((v10 & v17) == 0) {
            v17 = v5.changedInstance(arg28) ? 0x4000000 : 0x2000000;
            v2 |= v17;
        }

        int v29 = v2;
        boolean v0_1 = (v2 & 0x2492493) != 0x2492492 ? true : false;
        if(v5.shouldExecute(v0_1, v29 & 1)) {
            v5.startDefaults();
            ComposerKt.sourceInformation(v5, "55@2765L5,57@2882L8");
            int v18 = 0xFFFF1FFF;
            int v19 = 0xFFC7FFFF;
            Function2 v1 = null;
            if((v10 & 1) == 0 || (v5.getDefaultsInvalid())) {
                if(v4 != 0) {
                    v6_1 = Modifier.Companion;
                }

                if(v7 != 0) {
                    v8 = v1;
                }

                v4 = 6;
                if((v11 & 16) != 0) {
                    v7 = v29 & v18;
                    v9_1 = DatePickerDefaults.INSTANCE.getShape(v5, v4);
                }
                else {
                    v7 = v29;
                }

                if(v12 != 0) {
                    v13_1 = DatePickerDefaults.INSTANCE.getTonalElevation-D9Ej5fM();
                }

                if((v11 & 0x40) != 0) {
                    v14_1 = DatePickerDefaults.INSTANCE.colors(v5, v4);
                    v0_2 = v7 & v19;
                }
                else {
                    v0_2 = v7;
                }

                if(v15 != 0) {
                    v3 = new DialogProperties(false, false, false, 3, null);
                    v17_1 = v8;
                    v15_1 = v13_1;
                    v4 = v0_2;
                    v0_3 = ((Modifier)v6_1);
                    v13_2 = v9_1;
                    v6_2 = false;
                    goto label_235;
                }

            label_178:
                v3 = arg27;
                v4 = v0_2;
                v0_3 = ((Modifier)v6_1);
                v17_1 = v8;
                v15_1 = v13_1;
                v6_2 = false;
                v13_2 = v9_1;
            }
            else {
                v5.skipToGroupEnd();
                v0_2 = (v11 & 16) != 0 ? v29 & v18 : v29;
                if((v11 & 0x40) == 0) {
                    goto label_178;
                }

                v0_2 &= v19;
                goto label_178;
            }

        label_235:
            v5.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0xD18A3F1, v4, -1, "androidx.compose.material3.DatePickerDialog (DatePickerDialog.android.kt:74)");
            }

            AlertDialogKt.BasicAlertDialog(arg20, SizeKt.wrapContentHeight$default(v0_3, ((Vertical)v1), v6_2, 3, v1), v3, ComposableLambdaKt.rememberComposableLambda(0x421948F7, true, new DatePickerDialog_androidKt$DatePickerDialog$1(v13_2, v14_1, v15_1, arg28, v17_1, arg21), v5, 54), v5, v4 & 14 | 0xC00 | v4 >> 15 & 0x380, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v8_1 = v3;
            v6_3 = v15_1;
            v4_1 = v17_1;
            v3_1 = v0_3;
            v0_4 = v5;
            v5_1 = v13_2;
        }
        else {
            v5.skipToGroupEnd();
            v0_4 = v5;
            v3_1 = v6;
            v4_1 = v8;
            v5_1 = v9_1;
            v6_3 = v13_1;
            v8_1 = arg27;
        }

        DatePickerColors v7_1 = v14_1;
        ScopeUpdateScope v12_1 = v0_4.endRestartGroup();
        if(v12_1 != null) {
            v12_1.updateScope(new DatePickerDialog_androidKt$$ExternalSyntheticLambda0(arg20, arg21, v3_1, v4_1, v5_1, v6_3, v7_1, v8_1, arg28, v10, v11));
        }
    }

    static final Unit DatePickerDialog_GmEhDVc$lambda$0(Function0 arg13, Function2 arg14, Modifier arg15, Function2 arg16, Shape arg17, float arg18, DatePickerColors arg19, DialogProperties arg20, Function3 arg21, int arg22, int arg23, Composer arg24, int arg25) {
        DatePickerDialog_androidKt.DatePickerDialog-GmEhDVc(arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg24, RecomposeScopeImplKt.updateChangedFlags(arg22 | 1), arg23);
        return Unit.INSTANCE;
    }

    public static final float access$getDialogButtonsCrossAxisSpacing$p() {
        return DatePickerDialog_androidKt.DialogButtonsCrossAxisSpacing;
    }

    public static final float access$getDialogButtonsMainAxisSpacing$p() {
        return DatePickerDialog_androidKt.DialogButtonsMainAxisSpacing;
    }

    public static final PaddingValues access$getDialogButtonsPadding$p() {
        return DatePickerDialog_androidKt.DialogButtonsPadding;
    }
}

