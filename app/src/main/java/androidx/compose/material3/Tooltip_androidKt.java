package androidx.compose.material3;

import androidx.compose.material3.tokens.ElevationTokens;
import androidx.compose.material3.tokens.RichTooltipTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpSize;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000B\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u001Al\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001A\u00020\u00042\b\b\u0002\u0010\u0005\u001A\u00020\u00062\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\n2\b\b\u0002\u0010\u000B\u001A\u00020\n2\b\b\u0002\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\r2\u0011\u0010\u000F\u001A\r\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0004\b\u0012\u0010\u0013\u001Av\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001A\u00020\u00042\b\b\u0002\u0010\u0005\u001A\u00020\u00062\b\b\u0002\u0010\u0014\u001A\u00020\r2\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\n2\b\b\u0002\u0010\u000B\u001A\u00020\n2\b\b\u0002\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\r2\u0011\u0010\u000F\u001A\r\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0004\b\u0012\u0010\u0015\u001A\u0090\u0001\u0010\u0016\u001A\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001A\u00020\u00042\u0015\b\u0002\u0010\u0017\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0010¢\u0006\u0002\b\u00112\u0015\b\u0002\u0010\u0018\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0010¢\u0006\u0002\b\u00112\b\b\u0002\u0010\u0005\u001A\u00020\u00062\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\u0019\u001A\u00020\u001A2\b\b\u0002\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\r2\u0011\u0010\u001B\u001A\r\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0004\b\u001C\u0010\u001D\u001A\u009A\u0001\u0010\u0016\u001A\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001A\u00020\u00042\u0015\b\u0002\u0010\u0017\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0010¢\u0006\u0002\b\u00112\u0015\b\u0002\u0010\u0018\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0010¢\u0006\u0002\b\u00112\b\b\u0002\u0010\u0005\u001A\u00020\u00062\b\b\u0002\u0010\u0014\u001A\u00020\r2\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\u0019\u001A\u00020\u001A2\b\b\u0002\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\r2\u0011\u0010\u001B\u001A\r\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0004\b\u001C\u0010\u001E¨\u0006\u001F"}, d2={"PlainTooltipAndroid", "", "Landroidx/compose/material3/TooltipScope;", "modifier", "Landroidx/compose/ui/Modifier;", "caretSize", "Landroidx/compose/ui/unit/DpSize;", "shape", "Landroidx/compose/ui/graphics/Shape;", "contentColor", "Landroidx/compose/ui/graphics/Color;", "containerColor", "tonalElevation", "Landroidx/compose/ui/unit/Dp;", "shadowElevation", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "PlainTooltip", "(Landroidx/compose/material3/TooltipScope;Landroidx/compose/ui/Modifier;JLandroidx/compose/ui/graphics/Shape;JJFFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "maxWidth", "(Landroidx/compose/material3/TooltipScope;Landroidx/compose/ui/Modifier;JFLandroidx/compose/ui/graphics/Shape;JJFFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "RichTooltipAndroid", "title", "action", "colors", "Landroidx/compose/material3/RichTooltipColors;", "text", "RichTooltip", "(Landroidx/compose/material3/TooltipScope;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;JLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/RichTooltipColors;FFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/material3/TooltipScope;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;JFLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/RichTooltipColors;FFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class Tooltip_androidKt {
    @Deprecated(level=DeprecationLevel.HIDDEN, message="Maintained for binary compatibility.") public static final void PlainTooltip(TooltipScope arg23, Modifier arg24, long arg25, float arg27, Shape arg28, long arg29, long arg31, float arg33, float arg34, Function2 arg35, Composer arg36, int arg37, int arg38) {
        long v3_3;
        Shape v6_3;
        float v5_3;
        float v12_1;
        Composer v0_4;
        Modifier v2_2;
        float v24;
        long v7;
        long v9_1;
        Shape v4_1;
        float v6_2;
        Modifier v1_2;
        float v0_2;
        int v5_1;
        float v3_2;
        Shape v7_1;
        long v4_2;
        int v19;
        float v11_1;
        int v16;
        long v2;
        long v13;
        int v11;
        Shape v10_1;
        float v9;
        int v8;
        long v6_1;
        Modifier v5;
        int v3;
        TooltipScope v0 = arg23;
        int v15 = arg37;
        int v1 = arg38;
        Composer v12 = arg36.startRestartGroup(0x56D63FBC);
        ComposerKt.sourceInformation(v12, "C(PlainTooltipAndroid)N(modifier,caretSize:c#ui.unit.DpSize,maxWidth:c#ui.unit.Dp,shape,contentColor:c#ui.graphics.Color,containerColor:c#ui.graphics.Color,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,content)105@4515L349:Tooltip.android.kt#uh7d8r");
        if((0x80000000 & v1) != 0) {
            v3 = v15 | 6;
        }
        else if((v15 & 6) == 0) {
            boolean v3_1 = (v15 & 8) == 0 ? v12.changed(v0) : v12.changedInstance(v0);
            v3 = v3_1 ? 4 : 2;
            v3 |= v15;
        }
        else {
            v3 = v15;
        }

        int v4 = v1 & 1;
        if(v4 != 0) {
            v3 |= 0x30;
            goto label_41;
        }
        else if((v15 & 0x30) == 0) {
            v5 = arg24;
            int v6 = v12.changed(v5) ? 0x20 : 16;
            v3 |= v6;
        }
        else {
        label_41:
            v5 = arg24;
        }

        if((v15 & 0x180) == 0) {
            if((v1 & 2) == 0) {
                v6_1 = arg25;
                if(v12.changed(v6_1)) {
                    v8 = 0x100;
                }
                else {
                    goto label_52;
                }
            }
            else {
                v6_1 = arg25;
            label_52:
                v8 = 0x80;
            }

            v3 |= v8;
        }
        else {
            v6_1 = arg25;
        }

        v8 = v1 & 4;
        if(v8 != 0) {
            v3 |= 0xC00;
            goto label_70;
        }
        else if((v15 & 0xC00) == 0) {
            v9 = arg27;
            int v10 = v12.changed(v9) ? 0x800 : 0x400;
            v3 |= v10;
        }
        else {
        label_70:
            v9 = arg27;
        }

        if((v15 & 0x6000) == 0) {
            if((v1 & 8) == 0) {
                v10_1 = arg28;
                if(v12.changed(v10_1)) {
                    v11 = 0x4000;
                }
                else {
                    goto label_81;
                }
            }
            else {
                v10_1 = arg28;
            label_81:
                v11 = 0x2000;
            }

            v3 |= v11;
        }
        else {
            v10_1 = arg28;
        }

        if((0x30000 & v15) == 0) {
            v13 = arg29;
            v11 = (v1 & 16) != 0 || !v12.changed(v13) ? 0x10000 : 0x20000;
            v3 |= v11;
        }
        else {
            v13 = arg29;
        }

        if((0x180000 & v15) == 0) {
            int v36 = v3;
            v2 = arg31;
            v16 = (v1 & 0x20) != 0 || !v12.changed(v2) ? 0x80000 : 0x100000;
            v16 |= v36;
        }
        else {
            v16 = v3;
        }

        int v17 = v1 & 0x40;
        int v18 = 0xC00000;
        if(v17 != 0) {
            v16 |= v18;
            v11_1 = arg33;
        }
        else {
            v11_1 = arg33;
            if((v15 & v18) == 0) {
                v18 = v12.changed(v11_1) ? 0x800000 : 0x400000;
                v16 |= v18;
            }
        }

        int v0_1 = v1 & 0x80;
        v18 = 0x6000000;
        if(v0_1 != 0) {
            v16 |= v18;
            goto label_147;
        }
        else if((v15 & v18) == 0) {
            v18 = v0_1;
            v19 = v12.changed(arg34) ? 0x4000000 : 0x2000000;
            v16 |= v19;
        }
        else {
        label_147:
            v18 = v0_1;
        }

        v19 = 0x30000000;
        if((v1 & 0x100) != 0) {
        label_152:
            v16 |= v19;
        }
        else if((v15 & v19) == 0) {
            v19 = v12.changedInstance(arg35) ? 0x20000000 : 0x10000000;
            goto label_152;
        }

        v0_1 = v16;
        boolean v1_1 = (v0_1 & 306783379) != 306783378 ? true : false;
        if(v12.shouldExecute(v1_1, v0_1 & 1)) {
            v12.startDefaults();
            ComposerKt.sourceInformation(v12, "98@4239L26,99@4309L24,100@4379L26");
            int v2_1 = 0xFFC7FFFF;
            v3 = 0xFFF8FFFF;
            v16 = 0xFFFF1FFF;
            if((v15 & 1) == 0 || (v12.getDefaultsInvalid())) {
                if(v4 != 0) {
                    Companion v1_3 = Modifier.Companion;
                }
                else {
                    v1_2 = v5;
                }

                if((arg38 & 2) != 0) {
                    v4_2 = DpSize.Companion.getUnspecified-MYxV2XQ();
                    v0_1 &= -897;
                }
                else {
                    v4_2 = v6_1;
                }

                v6_2 = v8 != 0 ? TooltipDefaults.INSTANCE.getPlainTooltipMaxWidth-D9Ej5fM() : v9;
                v8 = 6;
                if((arg38 & 8) != 0) {
                    v7_1 = TooltipDefaults.INSTANCE.getPlainTooltipContainerShape(v12, v8);
                    v0_1 &= v16;
                }
                else {
                    v7_1 = v10_1;
                }

                if((arg38 & 16) != 0) {
                    v9_1 = TooltipDefaults.INSTANCE.getPlainTooltipContentColor(v12, v8);
                    v0_1 &= v3;
                }
                else {
                    v9_1 = v13;
                }

                if((arg38 & 0x20) != 0) {
                    v13 = TooltipDefaults.INSTANCE.getPlainTooltipContainerColor(v12, v8);
                    v0_1 &= v2_1;
                }
                else {
                    v13 = arg31;
                }

                v3_2 = v17 != 0 ? Dp.constructor-impl(0f) : v11_1;
                if(v18 != 0) {
                    v11_1 = v3_2;
                    long v21 = v4_2;
                    v5_1 = v0_1;
                    v0_2 = Dp.constructor-impl(0f);
                    v2 = v21;
                    v4_1 = v7_1;
                    v7 = v13;
                    goto label_266;
                }

                v11_1 = v3_2;
                v2 = v4_2;
                v4_1 = v7_1;
                v7 = v13;
            label_205:
                v5_1 = v0_1;
                v0_2 = arg34;
            }
            else {
                v12.skipToGroupEnd();
                if((arg38 & 2) != 0) {
                    v0_1 &= -897;
                }

                if((arg38 & 8) != 0) {
                    v0_1 &= v16;
                }

                if((arg38 & 16) != 0) {
                    v0_1 &= v3;
                }

                if((arg38 & 0x20) != 0) {
                    v0_1 &= v2_1;
                }

                v1_2 = v5;
                v2 = v6_1;
                v6_2 = v9;
                v4_1 = v10_1;
                v9_1 = v13;
                v7 = arg31;
                goto label_205;
            }

        label_266:
            v12.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                v24 = v0_2;
                ComposerKt.traceEventStart(0x56D63FBC, v5_1, -1, "androidx.compose.material3.PlainTooltipAndroid (Tooltip.android.kt:104)");
            }
            else {
                v24 = v0_2;
            }

            Shape v0_3 = TooltipDefaults.INSTANCE.caretShape-EaSLcWc(v2);
            int v13_1 = 0x7FFFFC7E & v5_1;
            long v16_1 = v2;
            v3_2 = v6_2;
            long v5_2 = v9_1;
            v9 = v11_1;
            float v10_2 = v24;
            TooltipKt.PlainTooltip-gv3ox5I(arg23, v1_2, v0_3, v3_2, v4_1, v5_2, v7, v9, v10_2, arg35, v12, v13_1, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v2_2 = v1_2;
            v11_1 = v9;
            v0_4 = v12;
            v12_1 = v10_2;
            v9_1 = v7;
            v7 = v5_2;
            v5_3 = v3_2;
            v6_3 = v4_1;
            v3_3 = v16_1;
        }
        else {
            v12.skipToGroupEnd();
            v2_2 = v5;
            v3_3 = v6_1;
            v5_3 = v9;
            v6_3 = v10_1;
            v0_4 = v12;
            v7 = v13;
            v9_1 = arg31;
            v12_1 = arg34;
        }

        ScopeUpdateScope v0_5 = v0_4.endRestartGroup();
        if(v0_5 != null) {
            v0_5.updateScope(new Tooltip_androidKt$$ExternalSyntheticLambda3(arg23, v2_2, v3_3, v5_3, v6_3, v7, v9_1, v11_1, v12_1, arg35, v15, arg38));
        }
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Maintained for binary compatibility. Use overload with maxWidth parameter.") public static final void PlainTooltip(TooltipScope arg21, Modifier arg22, long arg23, Shape arg25, long arg26, long arg28, float arg30, float arg31, Function2 arg32, Composer arg33, int arg34, int arg35) {
        long v3_2;
        Shape v5_3;
        long v8_2;
        float v11_1;
        Modifier v2_2;
        float v9_2;
        float v10;
        long v19;
        Shape v4_1;
        Modifier v1_3;
        long v7;
        long v5_2;
        long v2_1;
        Companion v5_1;
        float v1_1;
        int v17;
        float v2;
        long v13;
        int v11;
        long v9_1;
        int v9;
        Shape v8_1;
        int v8;
        long v6_1;
        Modifier v5;
        int v3;
        TooltipScope v1 = arg21;
        int v15 = arg34;
        int v0 = arg35;
        Composer v12 = arg33.startRestartGroup(0x7E0EE086);
        ComposerKt.sourceInformation(v12, "C(PlainTooltipAndroid)N(modifier,caretSize:c#ui.unit.DpSize,shape,contentColor:c#ui.graphics.Color,containerColor:c#ui.graphics.Color,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,content)61@2558L377:Tooltip.android.kt#uh7d8r");
        if((0x80000000 & v0) != 0) {
            v3 = v15 | 6;
        }
        else if((v15 & 6) == 0) {
            boolean v3_1 = (v15 & 8) == 0 ? v12.changed(v1) : v12.changedInstance(v1);
            v3 = v3_1 ? 4 : 2;
            v3 |= v15;
        }
        else {
            v3 = v15;
        }

        int v4 = v0 & 1;
        if(v4 != 0) {
            v3 |= 0x30;
            goto label_41;
        }
        else if((v15 & 0x30) == 0) {
            v5 = arg22;
            int v6 = v12.changed(v5) ? 0x20 : 16;
            v3 |= v6;
        }
        else {
        label_41:
            v5 = arg22;
        }

        if((v15 & 0x180) == 0) {
            if((v0 & 2) == 0) {
                v6_1 = arg23;
                if(v12.changed(v6_1)) {
                    v8 = 0x100;
                }
                else {
                    goto label_52;
                }
            }
            else {
                v6_1 = arg23;
            label_52:
                v8 = 0x80;
            }

            v3 |= v8;
        }
        else {
            v6_1 = arg23;
        }

        if((v15 & 0xC00) == 0) {
            if((v0 & 4) == 0) {
                v8_1 = arg25;
                if(v12.changed(v8_1)) {
                    v9 = 0x800;
                }
                else {
                    goto label_66;
                }
            }
            else {
                v8_1 = arg25;
            label_66:
                v9 = 0x400;
            }

            v3 |= v9;
        }
        else {
            v8_1 = arg25;
        }

        if((v15 & 0x6000) == 0) {
            if((v0 & 8) == 0) {
                v9_1 = arg26;
                if(v12.changed(v9_1)) {
                    v11 = 0x4000;
                }
                else {
                    goto label_80;
                }
            }
            else {
                v9_1 = arg26;
            label_80:
                v11 = 0x2000;
            }

            v3 |= v11;
        }
        else {
            v9_1 = arg26;
        }

        if((0x30000 & v15) == 0) {
            v13 = arg28;
            v11 = (v0 & 16) != 0 || !v12.changed(v13) ? 0x10000 : 0x20000;
            v3 |= v11;
        }
        else {
            v13 = arg28;
        }

        v11 = v0 & 0x20;
        int v16 = 0x180000;
        if(v11 != 0) {
            v3 |= v16;
            v2 = arg30;
        }
        else {
            v2 = arg30;
            if((v15 & v16) == 0) {
                v17 = v12.changed(v2) ? 0x100000 : 0x80000;
                v3 |= v17;
            }
        }

        v17 = v0 & 0x40;
        int v18 = 0xC00000;
        if(v17 != 0) {
            v3 |= v18;
        }
        else {
            v1_1 = arg31;
            if((v15 & v18) == 0) {
                v18 = v12.changed(v1_1) ? 0x800000 : 0x400000;
                v3 |= v18;
            }
        }

        v18 = 0x6000000;
        if((v0 & 0x80) != 0) {
            v3 |= v18;
        }
        else if((v15 & v18) == 0) {
            v18 = v12.changedInstance(arg32) ? 0x4000000 : 0x2000000;
            v3 |= v18;
        }

        boolean v0_1 = (v3 & 0x2492493) != 0x2492492 ? true : false;
        if(v12.shouldExecute(v0_1, v3 & 1)) {
            v12.startDefaults();
            ComposerKt.sourceInformation(v12, "54@2282L26,55@2352L24,56@2422L26");
            int v1_2 = 0xFFF8FFFF;
            v18 = 0xFFFF1FFF;
            if((v15 & 1) == 0 || (v12.getDefaultsInvalid())) {
                if(v4 != 0) {
                    v5_1 = Modifier.Companion;
                }

                if((arg35 & 2) != 0) {
                    v6_1 = DpSize.Companion.getUnspecified-MYxV2XQ();
                    v3 &= -897;
                }

                v4 = 6;
                if((arg35 & 4) != 0) {
                    v3 &= 0xFFFFE3FF;
                    v8_1 = TooltipDefaults.INSTANCE.getPlainTooltipContainerShape(v12, v4);
                }

                if((arg35 & 8) != 0) {
                    v9_1 = TooltipDefaults.INSTANCE.getPlainTooltipContentColor(v12, v4);
                    v3 &= v18;
                }

                if((arg35 & 16) != 0) {
                    v13 = TooltipDefaults.INSTANCE.getPlainTooltipContainerColor(v12, v4);
                    v3 &= v1_2;
                }

                v1_1 = v11 != 0 ? Dp.constructor-impl(0f) : v2;
                if(v17 != 0) {
                    v4_1 = v8_1;
                    v19 = v9_1;
                    v10 = Dp.constructor-impl(0f);
                    v9_2 = v1_1;
                    v0 = v3;
                    v1_3 = ((Modifier)v5_1);
                label_183:
                    v2_1 = v6_1;
                    v5_2 = v19;
                    v7 = v13;
                    goto label_236;
                }

                v0 = v3;
                v2_1 = v6_1;
                v4_1 = v8_1;
                v7 = v13;
                v19 = v9_1;
                v10 = arg31;
                v9_2 = v1_1;
                v1_3 = ((Modifier)v5_1);
                v5_2 = v19;
            }
            else {
                v12.skipToGroupEnd();
                if((arg35 & 2) != 0) {
                    v3 &= -897;
                }

                if((arg35 & 4) != 0) {
                    v3 &= 0xFFFFE3FF;
                }

                if((arg35 & 8) != 0) {
                    v3 &= v18;
                }

                if((arg35 & 16) != 0) {
                    v3 &= v1_2;
                }

                v0 = v3;
                v1_3 = v5;
                v4_1 = v8_1;
                v19 = v9_1;
                v10 = arg31;
                v9_2 = v2;
                goto label_183;
            }

        label_236:
            v12.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x7E0EE086, v0, -1, "androidx.compose.material3.PlainTooltipAndroid (Tooltip.android.kt:61)");
            }

            int v14 = v0 & 14 | 0xC00 | v0 & 0x70;
            v0 <<= 3;
            long v16_1 = v2_1;
            TooltipKt.PlainTooltip-gv3ox5I(arg21, v1_3, TooltipDefaults.INSTANCE.caretShape-EaSLcWc(v2_1), TooltipDefaults.INSTANCE.getPlainTooltipMaxWidth-D9Ej5fM(), v4_1, v5_2, v7, v9_2, v10, arg32, v12, v0 & 0x70000000 | (v14 | v0 & 0xE000 | v0 & 0x70000 | v0 & 0x380000 | v0 & 0x1C00000 | v0 & 0xE000000), 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v2_2 = v1_3;
            v11_1 = v10;
            v10 = v9_2;
            v8_2 = v7;
            v6_1 = v5_2;
            v5_3 = v4_1;
            v3_2 = v16_1;
        }
        else {
            v12.skipToGroupEnd();
            v11_1 = arg31;
            v3_2 = v6_1;
            v6_1 = v9_1;
            v10 = v2;
            v2_2 = v5;
            v5_3 = v8_1;
            v8_2 = v13;
        }

        ScopeUpdateScope v0_2 = v12.endRestartGroup();
        if(v0_2 != null) {
            v0_2.updateScope(new Tooltip_androidKt$$ExternalSyntheticLambda2(arg21, v2_2, v3_2, v5_3, v6_1, v8_2, v10, v11_1, arg32, v15, arg35));
        }
    }

    static final Unit PlainTooltipAndroid_7QI4Sbk$lambda$0(TooltipScope arg16, Modifier arg17, long arg18, Shape arg20, long arg21, long arg23, float arg25, float arg26, Function2 arg27, int arg28, int arg29, Composer arg30, int arg31) {
        Tooltip_androidKt.PlainTooltip(arg16, arg17, arg18, arg20, arg21, arg23, arg25, arg26, arg27, arg30, RecomposeScopeImplKt.updateChangedFlags(arg28 | 1), arg29);
        return Unit.INSTANCE;
    }

    static final Unit PlainTooltipAndroid_m9Er_Xc$lambda$1(TooltipScope arg17, Modifier arg18, long arg19, float arg21, Shape arg22, long arg23, long arg25, float arg27, float arg28, Function2 arg29, int arg30, int arg31, Composer arg32, int arg33) {
        Tooltip_androidKt.PlainTooltip(arg17, arg18, arg19, arg21, arg22, arg23, arg25, arg27, arg28, arg29, arg32, RecomposeScopeImplKt.updateChangedFlags(arg30 | 1), arg31);
        return Unit.INSTANCE;
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Maintained for binary compatibility.") public static final void RichTooltip(TooltipScope arg26, Modifier arg27, Function2 arg28, Function2 arg29, long arg30, float arg32, Shape arg33, RichTooltipColors arg34, float arg35, float arg36, Function2 arg37, Composer arg38, int arg39, int arg40, int arg41) {
        long v5_2;
        float v7_3;
        RichTooltipColors v9_2;
        Modifier v2_4;
        float v11_1;
        Shape v8_2;
        Composer v0_2;
        float v10_2;
        Function2 v4_2;
        long v4_1;
        RichTooltipColors v7_1;
        float v9_1;
        Function2 v2_2;
        Modifier v1_3;
        float v6_1;
        float v8_1;
        Shape v10_1;
        Function2 v3_2;
        int v12_1;
        long v7_2;
        int v21;
        int v20;
        int v19;
        RichTooltipColors v5;
        int v18;
        float v4;
        int v16;
        long v13_1;
        Function2 v12;
        int v10;
        Function2 v9;
        int v8;
        Modifier v7;
        int v3;
        TooltipScope v0 = arg26;
        int v15 = arg39;
        int v1 = arg41;
        Composer v11 = arg38.startRestartGroup(0xCA007987);
        ComposerKt.sourceInformation(v11, "C(RichTooltipAndroid)N(modifier,title,action,caretSize:c#ui.unit.DpSize,maxWidth:c#ui.unit.Dp,shape,colors,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,text)202@8696L337:Tooltip.android.kt#uh7d8r");
        if((0x80000000 & v1) != 0) {
            v3 = v15 | 6;
        }
        else if((v15 & 6) == 0) {
            boolean v3_1 = (v15 & 8) == 0 ? v11.changed(v0) : v11.changedInstance(v0);
            v3 = v3_1 ? 4 : 2;
            v3 |= v15;
        }
        else {
            v3 = v15;
        }

        int v6 = v1 & 1;
        if(v6 != 0) {
            v3 |= 0x30;
            goto label_41;
        }
        else if((v15 & 0x30) == 0) {
            v7 = arg27;
            v8 = v11.changed(v7) ? 0x20 : 16;
            v3 |= v8;
        }
        else {
        label_41:
            v7 = arg27;
        }

        v8 = v1 & 2;
        if(v8 != 0) {
            v3 |= 0x180;
            goto label_56;
        }
        else if((v15 & 0x180) == 0) {
            v9 = arg28;
            v10 = v11.changedInstance(v9) ? 0x100 : 0x80;
            v3 |= v10;
        }
        else {
        label_56:
            v9 = arg28;
        }

        v10 = v1 & 4;
        if(v10 != 0) {
            v3 |= 0xC00;
            goto label_71;
        }
        else if((v15 & 0xC00) == 0) {
            v12 = arg29;
            int v13 = v11.changedInstance(v12) ? 0x800 : 0x400;
            v3 |= v13;
        }
        else {
        label_71:
            v12 = arg29;
        }

        if((v15 & 0x6000) == 0) {
            if((v1 & 8) == 0) {
                v13_1 = arg30;
                if(v11.changed(v13_1)) {
                    v16 = 0x4000;
                }
                else {
                    goto label_82;
                }
            }
            else {
                v13_1 = arg30;
            label_82:
                v16 = 0x2000;
            }

            v3 |= v16;
        }
        else {
            v13_1 = arg30;
        }

        v16 = v1 & 16;
        int v17 = 0x30000;
        if(v16 != 0) {
            v3 |= v17;
            v4 = arg32;
        }
        else {
            v4 = arg32;
            if((v15 & v17) == 0) {
                v17 = v11.changed(v4) ? 0x20000 : 0x10000;
                v3 |= v17;
            }
        }

        if((v15 & 0x180000) == 0) {
            Shape v2 = arg33;
            v18 = (v1 & 0x20) != 0 || !v11.changed(v2) ? 0x80000 : 0x100000;
            v3 |= v18;
        }

        if((v15 & 0xC00000) == 0) {
            v5 = arg34;
            v19 = (v1 & 0x40) != 0 || !v11.changed(v5) ? 0x400000 : 0x800000;
            v3 |= v19;
        }
        else {
            v5 = arg34;
        }

        int v0_1 = v1 & 0x80;
        v19 = 0x6000000;
        if(v0_1 != 0) {
            v3 |= v19;
            goto label_145;
        }
        else if((v15 & v19) == 0) {
            v19 = v0_1;
            v20 = v11.changed(arg35) ? 0x4000000 : 0x2000000;
            v3 |= v20;
        }
        else {
        label_145:
            v19 = v0_1;
        }

        v0_1 = v1 & 0x100;
        v20 = 0x30000000;
        if(v0_1 != 0) {
            v3 |= v20;
            goto label_163;
        }
        else if((v15 & v20) == 0) {
            v20 = v0_1;
            v21 = v11.changed(arg36) ? 0x20000000 : 0x10000000;
            v3 |= v21;
        }
        else {
        label_163:
            v20 = v0_1;
        }

        if((v1 & 0x200) != 0) {
            v0_1 = arg40 | 6;
        }
        else if((arg40 & 6) == 0) {
            v21 = v11.changedInstance(arg37) ? 4 : 2;
            v0_1 = arg40 | v21;
        }
        else {
            v0_1 = arg40;
        }

        boolean v1_1 = (v3 & 306783379) != 306783378 || (v0_1 & 3) != 2 ? true : false;
        if(v11.shouldExecute(v1_1, v3 & 1)) {
            v11.startDefaults();
            ComposerKt.sourceInformation(v11, "196@8445L25,197@8520L19");
            int v2_1 = 0xFE3FFFFF;
            v18 = 0xFFC7FFFF;
            v21 = 0xFFFF1FFF;
            if((v15 & 1) == 0 || (v11.getDefaultsInvalid())) {
                if(v6 != 0) {
                    Companion v1_4 = Modifier.Companion;
                }
                else {
                    v1_3 = v7;
                }

                Function2 v6_2 = null;
                if(v8 != 0) {
                    v9 = v6_2;
                }

                if(v10 != 0) {
                }
                else {
                    v6_2 = v12;
                }

                if((arg41 & 8) != 0) {
                    v7_2 = DpSize.Companion.getUnspecified-MYxV2XQ();
                    v3 &= v21;
                }
                else {
                    v7_2 = v13_1;
                }

                if(v16 != 0) {
                    v4 = TooltipDefaults.INSTANCE.getRichTooltipMaxWidth-D9Ej5fM();
                }

                v12_1 = 6;
                if((arg41 & 0x20) != 0) {
                    v10_1 = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(v11, v12_1);
                    v3 &= v18;
                }
                else {
                    v10_1 = arg33;
                }

                if((arg41 & 0x40) != 0) {
                    v5 = TooltipDefaults.INSTANCE.richTooltipColors(v11, v12_1);
                    v3 &= v2_1;
                }

                float v2_3 = v19 != 0 ? ElevationTokens.INSTANCE.getLevel0-D9Ej5fM() : arg35;
                if(v20 != 0) {
                    long v23 = v7_2;
                    v8_1 = v2_3;
                    v7_1 = v5;
                    v2_2 = v9;
                    v9_1 = RichTooltipTokens.INSTANCE.getContainerElevation-D9Ej5fM();
                    v12_1 = v3;
                    v3_2 = v6_2;
                    v6_1 = v4;
                    v4_1 = v23;
                    goto label_291;
                }

                v12_1 = v3;
                v3_2 = v6_2;
                v6_1 = v4;
                Function2 v23_1 = v9;
                v9_1 = arg36;
                long v24 = v7_2;
                v8_1 = v2_3;
                v7_1 = v5;
                v4_1 = v24;
                v2_2 = v23_1;
            }
            else {
                v11.skipToGroupEnd();
                if((arg41 & 8) != 0) {
                    v3 &= v21;
                }

                if((arg41 & 0x20) != 0) {
                    v3 &= v18;
                }

                if((arg41 & 0x40) != 0) {
                    v3 &= v2_1;
                }

                Function2 v1_2 = v12;
                v12_1 = v3;
                v3_2 = v1_2;
                v10_1 = arg33;
                v8_1 = arg35;
                v6_1 = v4;
                v1_3 = v7;
                v2_2 = v9;
                v9_1 = arg36;
                v7_1 = v5;
                v4_1 = v13_1;
            }

        label_291:
            v11.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0xCA007987, v12_1, v0_1, "androidx.compose.material3.RichTooltipAndroid (Tooltip.android.kt:201)");
            }

            Shape v13_2 = TooltipDefaults.INSTANCE.caretShape-EaSLcWc(v4_1);
            long v16_1 = v4_1;
            float v5_1 = v6_1;
            Shape v6_3 = v10_1;
            TooltipKt.RichTooltip-EkvW5A0(arg26, v1_3, v2_2, v3_2, v13_2, v5_1, v6_3, v7_1, v8_1, v9_1, arg37, v11, v12_1 & 0x7FFF1FFE, v0_1 & 14, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v4_2 = v3_2;
            v10_2 = v8_1;
            v0_2 = v11;
            v3_2 = v2_2;
            v8_2 = v6_3;
            v11_1 = v9_1;
            v2_4 = v1_3;
            v9_2 = v7_1;
            v7_3 = v5_1;
            v5_2 = v16_1;
        }
        else {
            v11.skipToGroupEnd();
            v8_2 = arg33;
            v10_2 = arg35;
            v2_4 = v7;
            v3_2 = v9;
            v0_2 = v11;
            v11_1 = arg36;
            v7_3 = v4;
            v9_2 = v5;
            v4_2 = v12;
            v5_2 = v13_1;
        }

        ScopeUpdateScope v0_3 = v0_2.endRestartGroup();
        if(v0_3 != null) {
            v0_3.updateScope(new Tooltip_androidKt$$ExternalSyntheticLambda0(arg26, v2_4, v3_2, v4_2, v5_2, v7_3, v8_2, v9_2, v10_2, v11_1, arg37, v15, arg40, arg41));
        }
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Maintained for binary compatibility. Use overload with maxWidth parameter.") public static final void RichTooltip(TooltipScope arg21, Modifier arg22, Function2 arg23, Function2 arg24, long arg25, Shape arg27, RichTooltipColors arg28, float arg29, float arg30, Function2 arg31, Composer arg32, int arg33, int arg34) {
        long v5_2;
        Shape v7_2;
        RichTooltipColors v8_2;
        Modifier v2_2;
        float v10_2;
        Function2 v4_2;
        Shape v6_1;
        long v4_1;
        RichTooltipColors v7_1;
        Function2 v2_1;
        Modifier v1_2;
        float v8_1;
        Function2 v3_2;
        float v9_1;
        Companion v5_1;
        int v19;
        int v18;
        float v2;
        RichTooltipColors v10_1;
        int v32;
        int v16;
        Shape v14;
        long v12;
        int v10;
        Function2 v9;
        int v8;
        Function2 v7;
        int v6;
        Modifier v5;
        int v3;
        TooltipScope v0 = arg21;
        int v15 = arg33;
        int v1 = arg34;
        Composer v11 = arg32.startRestartGroup(0xF166FEB5);
        ComposerKt.sourceInformation(v11, "C(RichTooltipAndroid)N(modifier,title,action,caretSize:c#ui.unit.DpSize,shape,colors,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,text)154@6569L364:Tooltip.android.kt#uh7d8r");
        if((0x80000000 & v1) != 0) {
            v3 = v15 | 6;
        }
        else if((v15 & 6) == 0) {
            boolean v3_1 = (v15 & 8) == 0 ? v11.changed(v0) : v11.changedInstance(v0);
            v3 = v3_1 ? 4 : 2;
            v3 |= v15;
        }
        else {
            v3 = v15;
        }

        int v4 = v1 & 1;
        if(v4 != 0) {
            v3 |= 0x30;
            goto label_41;
        }
        else if((v15 & 0x30) == 0) {
            v5 = arg22;
            v6 = v11.changed(v5) ? 0x20 : 16;
            v3 |= v6;
        }
        else {
        label_41:
            v5 = arg22;
        }

        v6 = v1 & 2;
        if(v6 != 0) {
            v3 |= 0x180;
            goto label_56;
        }
        else if((v15 & 0x180) == 0) {
            v7 = arg23;
            v8 = v11.changedInstance(v7) ? 0x100 : 0x80;
            v3 |= v8;
        }
        else {
        label_56:
            v7 = arg23;
        }

        v8 = v1 & 4;
        if(v8 != 0) {
            v3 |= 0xC00;
            goto label_71;
        }
        else if((v15 & 0xC00) == 0) {
            v9 = arg24;
            v10 = v11.changedInstance(v9) ? 0x800 : 0x400;
            v3 |= v10;
        }
        else {
        label_71:
            v9 = arg24;
        }

        if((v15 & 0x6000) == 0) {
            v12 = arg25;
            v10 = (v1 & 8) != 0 || !v11.changed(v12) ? 0x2000 : 0x4000;
            v3 |= v10;
        }
        else {
            v12 = arg25;
        }

        v10 = 0x30000;
        if((v15 & v10) == 0) {
            if((v1 & 16) == 0) {
                v14 = arg27;
                if(v11.changed(v14)) {
                    v16 = 0x20000;
                }
                else {
                    goto label_96;
                }
            }
            else {
                v14 = arg27;
            label_96:
                v16 = 0x10000;
            }

            v3 |= v16;
        }
        else {
            v14 = arg27;
        }

        if((v15 & 0x180000) == 0) {
            v32 = v10;
            v10_1 = arg28;
            v16 = (v1 & 0x20) != 0 || !v11.changed(v10_1) ? 0x80000 : 0x100000;
            v3 |= v16;
        }
        else {
            v32 = v10;
            v10_1 = arg28;
        }

        v16 = v1 & 0x40;
        int v17 = 0xC00000;
        if(v16 != 0) {
            v3 |= v17;
            v2 = arg29;
        }
        else {
            v2 = arg29;
            if((v15 & v17) == 0) {
                v18 = v11.changed(v2) ? 0x800000 : 0x400000;
                v3 |= v18;
            }
        }

        int v0_1 = v1 & 0x80;
        v18 = 0x6000000;
        if(v0_1 != 0) {
            v3 |= v18;
            goto label_147;
        }
        else if((v15 & v18) == 0) {
            v18 = v0_1;
            v19 = v11.changed(arg30) ? 0x4000000 : 0x2000000;
            v3 |= v19;
        }
        else {
        label_147:
            v18 = v0_1;
        }

        v19 = 0x30000000;
        if((v1 & 0x100) != 0) {
            v3 |= v19;
        }
        else if((v15 & v19) == 0) {
            v19 = v11.changedInstance(arg31) ? 0x20000000 : 0x10000000;
            v3 |= v19;
        }

        boolean v0_2 = (v3 & 306783379) != 306783378 ? true : false;
        if(v11.shouldExecute(v0_2, v3 & 1)) {
            v11.startDefaults();
            ComposerKt.sourceInformation(v11, "148@6318L25,149@6393L19");
            v1 = 0xFFC7FFFF;
            v19 = 0xFFF8FFFF;
            int v20 = 0xFFFF1FFF;
            if((v15 & 1) == 0 || (v11.getDefaultsInvalid())) {
                if(v4 != 0) {
                    v5_1 = Modifier.Companion;
                }

                Function2 v0_3 = null;
                if(v6 != 0) {
                    v7 = v0_3;
                }

                if(v8 != 0) {
                    v9 = v0_3;
                }

                if((arg34 & 8) != 0) {
                    v12 = DpSize.Companion.getUnspecified-MYxV2XQ();
                    v3 &= v20;
                }

                v4 = 6;
                if((arg34 & 16) != 0) {
                    v3 &= v19;
                    v14 = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(v11, v4);
                }

                if((arg34 & 0x20) != 0) {
                    v10_1 = TooltipDefaults.INSTANCE.richTooltipColors(v11, v4);
                    v3 &= v1;
                }

                if(v16 != 0) {
                    v2 = ElevationTokens.INSTANCE.getLevel0-D9Ej5fM();
                }

                if(v18 != 0) {
                    Function2 v1_1 = v9;
                    v9_1 = RichTooltipTokens.INSTANCE.getContainerElevation-D9Ej5fM();
                    v0_1 = v3;
                    v3_2 = v1_1;
                    v8_1 = v2;
                    v1_2 = ((Modifier)v5_1);
                    v2_1 = v7;
                    v7_1 = v10_1;
                    v4_1 = v12;
                    v6_1 = v14;
                    goto label_250;
                }

            label_196:
                v8_1 = v2;
                v0_1 = v3;
                v1_2 = ((Modifier)v5_1);
                v2_1 = v7;
                v3_2 = v9;
                v7_1 = v10_1;
                v4_1 = v12;
                v6_1 = v14;
                v9_1 = arg30;
            }
            else {
                v11.skipToGroupEnd();
                if((arg34 & 8) != 0) {
                    v3 &= v20;
                }

                if((arg34 & 16) != 0) {
                    v3 &= v19;
                }

                if((arg34 & 0x20) == 0) {
                    goto label_196;
                }

                v3 &= v1;
                goto label_196;
            }

        label_250:
            v11.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0xF166FEB5, v0_1, -1, "androidx.compose.material3.RichTooltipAndroid (Tooltip.android.kt:154)");
            }

            int v14_1 = v0_1 << 3;
            long v16_1 = v4_1;
            TooltipKt.RichTooltip-EkvW5A0(arg21, v1_2, v2_1, v3_2, TooltipDefaults.INSTANCE.caretShape-EaSLcWc(v4_1), TooltipDefaults.INSTANCE.getRichTooltipMaxWidth-D9Ej5fM(), v6_1, v7_1, v8_1, v9_1, arg31, v11, v0_1 & 14 | v32 | v0_1 & 0x70 | v0_1 & 0x380 | v0_1 & 0x1C00 | v14_1 & 0x380000 | v14_1 & 0x1C00000 | v14_1 & 0xE000000 | v14_1 & 0x70000000, v0_1 >> 27 & 14, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v4_2 = v3_2;
            v10_2 = v9_1;
            v3_2 = v2_1;
            v9_1 = v8_1;
            v2_2 = v1_2;
            v8_2 = v7_1;
            v7_2 = v6_1;
            v5_2 = v16_1;
        }
        else {
            v11.skipToGroupEnd();
            v3_2 = v7;
            v4_2 = v9;
            v8_2 = v10_1;
            v7_2 = v14;
            v10_2 = arg30;
            v9_1 = v2;
            v2_2 = v5;
            v5_2 = v12;
        }

        ScopeUpdateScope v14_2 = v11.endRestartGroup();
        if(v14_2 != null) {
            v14_2.updateScope(new Tooltip_androidKt$$ExternalSyntheticLambda1(arg21, v2_2, v3_2, v4_2, v5_2, v7_2, v8_2, v9_1, v10_2, arg31, v15, arg34));
        }
    }

    static final Unit RichTooltipAndroid_ZuUcA3Q$lambda$3(TooltipScope arg17, Modifier arg18, Function2 arg19, Function2 arg20, long arg21, float arg23, Shape arg24, RichTooltipColors arg25, float arg26, float arg27, Function2 arg28, int arg29, int arg30, int arg31, Composer arg32, int arg33) {
        Tooltip_androidKt.RichTooltip(arg17, arg18, arg19, arg20, arg21, arg23, arg24, arg25, arg26, arg27, arg28, arg32, RecomposeScopeImplKt.updateChangedFlags(arg29 | 1), RecomposeScopeImplKt.updateChangedFlags(arg30), arg31);
        return Unit.INSTANCE;
    }

    static final Unit RichTooltipAndroid_yDvdmqw$lambda$2(TooltipScope arg15, Modifier arg16, Function2 arg17, Function2 arg18, long arg19, Shape arg21, RichTooltipColors arg22, float arg23, float arg24, Function2 arg25, int arg26, int arg27, Composer arg28, int arg29) {
        Tooltip_androidKt.RichTooltip(arg15, arg16, arg17, arg18, arg19, arg21, arg22, arg23, arg24, arg25, arg28, RecomposeScopeImplKt.updateChangedFlags(arg26 | 1), arg27);
        return Unit.INSTANCE;
    }
}

