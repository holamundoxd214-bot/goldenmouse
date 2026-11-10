package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000\u001C\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001A-\u0010\u0000\u001A\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\t\u001A-\u0010\n\u001A\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u0007H\u0007¢\u0006\u0004\b\u000B\u0010\t\u001A-\u0010\f\u001A\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u0007H\u0007¢\u0006\u0004\b\r\u0010\t¨\u0006\u000E"}, d2={"HorizontalDivider", "", "modifier", "Landroidx/compose/ui/Modifier;", "thickness", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/ui/graphics/Color;", "HorizontalDivider-9IZ8Weo", "(Landroidx/compose/ui/Modifier;FJLandroidx/compose/runtime/Composer;II)V", "VerticalDivider", "VerticalDivider-9IZ8Weo", "Divider", "Divider-9IZ8Weo", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class DividerKt {
    @Deprecated(message="Renamed to HorizontalDivider", replaceWith="<_subannotation>") public static final void Divider-9IZ8Weo(Modifier arg14, float arg15, long arg16, Composer arg18, int arg19, int arg20) {
        float v0_3;
        float v3;
        Modifier v2_1;
        long v7;
        int v10;
        long v8_1;
        int v4;
        int v5 = arg19;
        int v0 = 0x5D216D69;
        Composer v1 = arg18.startRestartGroup(v0);
        ComposerKt.sourceInformation(v1, "C(Divider)N(modifier,thickness:c#ui.unit.Dp,color:c#ui.graphics.Color)106@3745L78:Divider.kt#uh7d8r");
        int v2 = arg20 & 1;
        if(v2 != 0) {
            v4 = v5 | 6;
        }
        else if((v5 & 6) == 0) {
            v4 = v1.changed(arg14) ? 4 : 2;
            v4 |= v5;
        }
        else {
            v4 = v5;
        }

        int v6 = arg20 & 2;
        if(v6 != 0) {
            v4 |= 0x30;
        }
        else if((v5 & 0x30) == 0) {
            int v8 = v1.changed(arg15) ? 0x20 : 16;
            v4 |= v8;
        }

        if((v5 & 0x180) == 0) {
            if((arg20 & 4) == 0) {
                v8_1 = arg16;
                if(v1.changed(v8_1)) {
                    v10 = 0x100;
                }
                else {
                    goto label_43;
                }
            }
            else {
                v8_1 = arg16;
            label_43:
                v10 = 0x80;
            }

            v4 |= v10;
        }
        else {
            v8_1 = arg16;
        }

        boolean v10_1 = (v4 & 0x93) != 0x92 ? true : false;
        if(v1.shouldExecute(v10_1, v4 & 1)) {
            v1.startDefaults();
            ComposerKt.sourceInformation(v1, "98@3564L5");
            if((v5 & 1) == 0 || (v1.getDefaultsInvalid())) {
                if(v2 != 0) {
                    Companion v2_2 = Modifier.Companion;
                }
                else {
                    v2_1 = arg14;
                }

                v3 = v6 != 0 ? DividerDefaults.INSTANCE.getThickness-D9Ej5fM() : arg15;
                if((arg20 & 4) != 0) {
                    v4 &= -897;
                    v7 = DividerDefaults.INSTANCE.getColor(v1, 6);
                    goto label_90;
                }

            label_72:
                v7 = v8_1;
            }
            else {
                v1.skipToGroupEnd();
                if((arg20 & 4) != 0) {
                    v4 &= -897;
                }

                v2_1 = arg14;
                v3 = arg15;
                goto label_72;
            }

        label_90:
            v1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v4, -1, "androidx.compose.material3.Divider (Divider.kt:99)");
            }

            if(Dp.equals-impl0(v3, Dp.Companion.getHairline-D9Ej5fM())) {
                v1.startReplaceGroup(0xB500A0BB);
                ComposerKt.sourceInformation(v1, "102@3672L7");
                ProvidableCompositionLocal v0_1 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(v1, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object v0_2 = v1.consume(((CompositionLocal)v0_1));
                ComposerKt.sourceInformationMarkerEnd(v1);
                v0_3 = Dp.constructor-impl(1f / ((Density)v0_2).getDensity());
                v1.endReplaceGroup();
            }
            else {
                v1.startReplaceGroup(0xB501A4B8);
                v1.endReplaceGroup();
                v0_3 = v3;
            }

            BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(v2_1, 0f, 1, null), v0_3), v7, null, 2, null), v1, 0);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_137;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v1.skipToGroupEnd();
            v2_1 = arg14;
            v3 = arg15;
            v7 = v8_1;
        }

    label_137:
        ScopeUpdateScope v9 = v1.endRestartGroup();
        if(v9 != null) {
            v9.updateScope(new DividerKt$$ExternalSyntheticLambda0(v2_1, v3, v7, v5, arg20));
        }
    }

    static final Unit Divider_9IZ8Weo$lambda$6(Modifier arg7, float arg8, long arg9, int arg11, int arg12, Composer arg13, int arg14) {
        DividerKt.Divider-9IZ8Weo(arg7, arg8, arg9, arg13, RecomposeScopeImplKt.updateChangedFlags(arg11 | 1), arg12);
        return Unit.INSTANCE;
    }

    public static final void HorizontalDivider-9IZ8Weo(Modifier arg16, float arg17, long arg18, Composer arg20, int arg21, int arg22) {
        float v3_1;
        Modifier v2_1;
        Companion v2_2;
        long v11;
        int v9;
        float v8;
        Modifier v3;
        int v4;
        int v5 = arg21;
        int v0 = 0x47A9D25;
        Composer v1 = arg20.startRestartGroup(v0);
        ComposerKt.sourceInformation(v1, "C(HorizontalDivider)N(modifier,thickness:c#ui.unit.Dp,color:c#ui.graphics.Color)53@2086L220,53@2036L270:Divider.kt#uh7d8r");
        int v2 = arg22 & 1;
        if(v2 != 0) {
            v4 = v5 | 6;
            v3 = arg16;
        }
        else if((v5 & 6) == 0) {
            v3 = arg16;
            v4 = v1.changed(v3) ? 4 : 2;
            v4 |= v5;
        }
        else {
            v3 = arg16;
            v4 = v5;
        }

        int v6 = arg22 & 2;
        int v7 = 0x20;
        if(v6 != 0) {
            v4 |= 0x30;
            goto label_39;
        }
        else if((v5 & 0x30) == 0) {
            v8 = arg17;
            v9 = v1.changed(v8) ? v7 : 16;
            v4 |= v9;
        }
        else {
        label_39:
            v8 = arg17;
        }

        int v10 = 0x100;
        if((v5 & 0x180) == 0) {
            v11 = arg18;
            v9 = (arg22 & 4) != 0 || !v1.changed(v11) ? 0x80 : v10;
            v4 |= v9;
        }
        else {
            v11 = arg18;
        }

        int v15 = 1;
        boolean v9_1 = (v4 & 0x93) != 0x92 ? true : false;
        if(v1.shouldExecute(v9_1, v4 & 1)) {
            v1.startDefaults();
            ComposerKt.sourceInformation(v1, "51@2021L5");
            if((v5 & 1) == 0 || (v1.getDefaultsInvalid())) {
                if(v2 != 0) {
                    v2_2 = Modifier.Companion;
                }
                else {
                    v2_1 = v3;
                }

                v3_1 = v6 != 0 ? DividerDefaults.INSTANCE.getThickness-D9Ej5fM() : v8;
                if((arg22 & 4) == 0) {
                    goto label_96;
                }

                v4 &= -897;
                v11 = DividerDefaults.INSTANCE.getColor(v1, 6);
            }
            else {
                v1.skipToGroupEnd();
                if((arg22 & 4) != 0) {
                    v4 &= -897;
                }

                v2_1 = v3;
                v3_1 = v8;
            }

        label_96:
            v1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v4, -1, "androidx.compose.material3.HorizontalDivider (Divider.kt:53)");
            }

            Modifier v0_1 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(((Modifier)v2_2), 0f, 1, null), v3_1);
            ComposerKt.sourceInformationMarkerStart(v1, 0xD04803E1, "CC(remember):Divider.kt#9igjgp");
            v6 = (v4 & 0x70) == v7 ? 1 : 0;
            if((v4 & 0x380 ^ 0x180) <= v10 || !v1.changed(v11)) {
                if((v4 & 0x180) == v10) {
                }
                else {
                    v15 = 0;
                }
            }

            v4 = v6 | v15;
            Object v6_1 = v1.rememberedValue();
            if(v4 != 0 || v6_1 == Composer.Companion.getEmpty()) {
                DividerKt$$ExternalSyntheticLambda3 v6_2 = new DividerKt$$ExternalSyntheticLambda3(v3_1, v11);
                v1.updateRememberedValue(v6_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v1);
            CanvasKt.Canvas(v0_1, ((Function1)v6_1), v1, 0);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_141;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v1.skipToGroupEnd();
            v2_1 = v3;
            v3_1 = v8;
        }

    label_141:
        ScopeUpdateScope v7_1 = v1.endRestartGroup();
        if(v7_1 != null) {
            v7_1.updateScope(new DividerKt$$ExternalSyntheticLambda4(((Modifier)v2_2), v3_1, v11, v5, arg22));
        }
    }

    static final Unit HorizontalDivider_9IZ8Weo$lambda$1$lambda$0(float arg17, long arg18, DrawScope arg20) {
        DrawScope.drawLine-NGM6Ib0$default(arg20, arg18, Offset.constructor-impl((((long)Float.floatToRawIntBits(0f))) << 0x20 | (((long)Float.floatToRawIntBits(arg20.toPx-0680j_4(arg17) / 2f))) & 0xFFFFFFFFL), Offset.constructor-impl((((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(arg20.getSize-NH-jbRc() >> 0x20)))))) << 0x20 | (((long)Float.floatToRawIntBits(arg20.toPx-0680j_4(arg17) / 2f))) & 0xFFFFFFFFL), arg20.toPx-0680j_4(arg17), 0, null, 0f, null, 0, 0x1F0, null);
        return Unit.INSTANCE;
    }

    static final Unit HorizontalDivider_9IZ8Weo$lambda$2(Modifier arg7, float arg8, long arg9, int arg11, int arg12, Composer arg13, int arg14) {
        DividerKt.HorizontalDivider-9IZ8Weo(arg7, arg8, arg9, arg13, RecomposeScopeImplKt.updateChangedFlags(arg11 | 1), arg12);
        return Unit.INSTANCE;
    }

    public static final void VerticalDivider-9IZ8Weo(Modifier arg16, float arg17, long arg18, Composer arg20, int arg21, int arg22) {
        DividerKt$$ExternalSyntheticLambda1 v6_2;
        float v3_1;
        Modifier v2_1;
        Companion v2_2;
        long v11;
        int v9;
        float v8;
        Modifier v3;
        int v4;
        int v5 = arg21;
        int v0 = 0xA4840393;
        Composer v1 = arg20.startRestartGroup(v0);
        ComposerKt.sourceInformation(v1, "C(VerticalDivider)N(modifier,thickness:c#ui.unit.Dp,color:c#ui.graphics.Color)81@3058L221,81@3008L271:Divider.kt#uh7d8r");
        int v2 = arg22 & 1;
        if(v2 != 0) {
            v4 = v5 | 6;
            v3 = arg16;
        }
        else if((v5 & 6) == 0) {
            v3 = arg16;
            v4 = v1.changed(v3) ? 4 : 2;
            v4 |= v5;
        }
        else {
            v3 = arg16;
            v4 = v5;
        }

        int v6 = arg22 & 2;
        int v7 = 0x20;
        if(v6 != 0) {
            v4 |= 0x30;
            goto label_39;
        }
        else if((v5 & 0x30) == 0) {
            v8 = arg17;
            v9 = v1.changed(v8) ? v7 : 16;
            v4 |= v9;
        }
        else {
        label_39:
            v8 = arg17;
        }

        int v10 = 0x100;
        if((v5 & 0x180) == 0) {
            v11 = arg18;
            v9 = (arg22 & 4) != 0 || !v1.changed(v11) ? 0x80 : v10;
            v4 |= v9;
        }
        else {
            v11 = arg18;
        }

        int v15 = 1;
        boolean v9_1 = (v4 & 0x93) != 0x92 ? true : false;
        if(v1.shouldExecute(v9_1, v4 & 1)) {
            v1.startDefaults();
            ComposerKt.sourceInformation(v1, "79@2993L5");
            if((v5 & 1) == 0 || (v1.getDefaultsInvalid())) {
                if(v2 != 0) {
                    v2_2 = Modifier.Companion;
                }
                else {
                    v2_1 = v3;
                }

                v3_1 = v6 != 0 ? DividerDefaults.INSTANCE.getThickness-D9Ej5fM() : v8;
                if((arg22 & 4) == 0) {
                    goto label_96;
                }

                v4 &= -897;
                v11 = DividerDefaults.INSTANCE.getColor(v1, 6);
            }
            else {
                v1.skipToGroupEnd();
                if((arg22 & 4) != 0) {
                    v4 &= -897;
                }

                v2_1 = v3;
                v3_1 = v8;
            }

        label_96:
            v1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v4, -1, "androidx.compose.material3.VerticalDivider (Divider.kt:81)");
            }

            Modifier v0_1 = SizeKt.width-3ABfNKs(SizeKt.fillMaxHeight$default(((Modifier)v2_2), 0f, 1, null), v3_1);
            ComposerKt.sourceInformationMarkerStart(v1, 0x93918690, "CC(remember):Divider.kt#9igjgp");
            v6 = (v4 & 0x70) == v7 ? 1 : 0;
            if((v4 & 0x380 ^ 0x180) <= v10 || !v1.changed(v11)) {
                if((v4 & 0x180) == v10) {
                }
                else {
                    v15 = 0;
                }
            }

            v4 = v6 | v15;
            Object v6_1 = v1.rememberedValue();
            if(v4 != 0 || v6_1 == Composer.Companion.getEmpty()) {
                v6_2 = new DividerKt$$ExternalSyntheticLambda1(v3_1, v11);
                v1.updateRememberedValue(v6_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v1);
            CanvasKt.Canvas(v0_1, ((Function1)v6_2), v1, 0);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_141;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v1.skipToGroupEnd();
            v2_1 = v3;
            v3_1 = v8;
        }

    label_141:
        ScopeUpdateScope v7_1 = v1.endRestartGroup();
        if(v7_1 != null) {
            v7_1.updateScope(new DividerKt$$ExternalSyntheticLambda2(((Modifier)v2_2), v3_1, v11, v5, arg22));
        }
    }

    static final Unit VerticalDivider_9IZ8Weo$lambda$4$lambda$3(float arg17, long arg18, DrawScope arg20) {
        DrawScope.drawLine-NGM6Ib0$default(arg20, arg18, Offset.constructor-impl((((long)Float.floatToRawIntBits(arg20.toPx-0680j_4(arg17) / 2f))) << 0x20 | (((long)Float.floatToRawIntBits(0f))) & 0xFFFFFFFFL), Offset.constructor-impl((((long)Float.floatToRawIntBits(arg20.toPx-0680j_4(arg17) / 2f))) << 0x20 | (((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(arg20.getSize-NH-jbRc() & 0xFFFFFFFFL)))))) & 0xFFFFFFFFL), arg20.toPx-0680j_4(arg17), 0, null, 0f, null, 0, 0x1F0, null);
        return Unit.INSTANCE;
    }

    static final Unit VerticalDivider_9IZ8Weo$lambda$5(Modifier arg7, float arg8, long arg9, int arg11, int arg12, Composer arg13, int arg14) {
        DividerKt.VerticalDivider-9IZ8Weo(arg7, arg8, arg9, arg13, RecomposeScopeImplKt.updateChangedFlags(arg11 | 1), arg12);
        return Unit.INSTANCE;
    }
}

