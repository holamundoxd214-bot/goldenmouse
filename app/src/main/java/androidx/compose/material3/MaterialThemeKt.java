package androidx.compose.material3;

import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.IndicationNodeFactory;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000J\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\u001A>\u0010\u0000\u001A\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\u0011\u0010\b\u001A\r\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u000B\u001AH\u0010\u0000\u001A\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\u0011\u0010\b\u001A\r\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\nH\u0001¢\u0006\u0002\u0010\u000E\u001AP\u0010\u000F\u001A\u00020\u00012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u00072\u0011\u0010\b\u001A\r\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\nH\u0001¢\u0006\u0002\u0010\u000E\u001A\u0015\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0002\u001A\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0017\"\u001A\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014\"\u000E\u0010\u0018\u001A\u00020\u0019X\u0080T¢\u0006\u0002\n\u0000\"\u001A\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\r0\u0011X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001B\u0010\u001C¨\u0006\u001D"}, d2={"MaterialTheme", "", "colorScheme", "Landroidx/compose/material3/ColorScheme;", "shapes", "Landroidx/compose/material3/Shapes;", "typography", "Landroidx/compose/material3/Typography;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/material3/Shapes;Landroidx/compose/material3/Typography;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "motionScheme", "Landroidx/compose/material3/MotionScheme;", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/material3/MotionScheme;Landroidx/compose/material3/Shapes;Landroidx/compose/material3/Typography;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "MaterialExpressiveTheme", "LocalUsingExpressiveTheme", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "", "getLocalUsingExpressiveTheme", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "rememberTextSelectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/text/selection/TextSelectionColors;", "TextSelectionBackgroundOpacity", "", "_localMotionScheme", "get_localMotionScheme$annotations", "()V", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class MaterialThemeKt {
    private static final ProvidableCompositionLocal LocalUsingExpressiveTheme = null;
    public static final float TextSelectionBackgroundOpacity = 0.4f;
    private static final ProvidableCompositionLocal _localMotionScheme;

    static {
        MaterialThemeKt.LocalUsingExpressiveTheme = CompositionLocalKt.staticCompositionLocalOf(new MaterialThemeKt$$ExternalSyntheticLambda2());
        MaterialThemeKt._localMotionScheme = CompositionLocalKt.staticCompositionLocalOf(new MaterialThemeKt$$ExternalSyntheticLambda3());
    }

    static final boolean LocalUsingExpressiveTheme$lambda$3() {
        return 0;
    }

    public static final void MaterialExpressiveTheme(ColorScheme arg19, MotionScheme arg20, Shapes arg21, Typography arg22, Function2 arg23, Composer arg24, int arg25, int arg26) {
        Typography v4_2;
        Shapes v3_1;
        MotionScheme v2_1;
        ColorScheme v14;
        Shapes v9_1;
        MotionScheme v8_1;
        ColorScheme v7_1;
        ColorScheme v1_1;
        Function2 v11_1;
        Typography v10;
        int v9;
        Shapes v8;
        int v7;
        MotionScheme v5;
        ColorScheme v2;
        int v3;
        int v6 = arg25;
        int v0 = 0x4E84DBDC;
        Composer v12 = arg24.startRestartGroup(v0);
        ComposerKt.sourceInformation(v12, "C(MaterialExpressiveTheme)N(colorScheme,motionScheme,shapes,typography,content)191@8447L7:MaterialTheme.kt#uh7d8r");
        int v1 = arg26 & 1;
        if(v1 != 0) {
            v3 = v6 | 6;
            v2 = arg19;
        }
        else if((v6 & 6) == 0) {
            v2 = arg19;
            v3 = v12.changed(v2) ? 4 : 2;
            v3 |= v6;
        }
        else {
            v2 = arg19;
            v3 = v6;
        }

        int v4 = arg26 & 2;
        if(v4 != 0) {
            v3 |= 0x30;
            goto label_38;
        }
        else if((v6 & 0x30) == 0) {
            v5 = arg20;
            v7 = v12.changed(v5) ? 0x20 : 16;
            v3 |= v7;
        }
        else {
        label_38:
            v5 = arg20;
        }

        v7 = arg26 & 4;
        if(v7 != 0) {
            v3 |= 0x180;
            goto label_53;
        }
        else if((v6 & 0x180) == 0) {
            v8 = arg21;
            v9 = v12.changed(v8) ? 0x100 : 0x80;
            v3 |= v9;
        }
        else {
        label_53:
            v8 = arg21;
        }

        v9 = arg26 & 8;
        if(v9 != 0) {
            v3 |= 0xC00;
            goto label_68;
        }
        else if((v6 & 0xC00) == 0) {
            v10 = arg22;
            int v11 = v12.changed(v10) ? 0x800 : 0x400;
            v3 |= v11;
        }
        else {
        label_68:
            v10 = arg22;
        }

        if((arg26 & 16) != 0) {
            v3 |= 0x6000;
            goto label_83;
        }
        else if((v6 & 0x6000) == 0) {
            v11_1 = arg23;
            int v13 = v12.changedInstance(v11_1) ? 0x4000 : 0x2000;
            v3 |= v13;
        }
        else {
        label_83:
            v11_1 = arg23;
        }

        boolean v13_1 = (v3 & 9363) != 9362 ? true : false;
        if(v12.shouldExecute(v13_1, v3 & 1)) {
            ColorScheme v13_2 = null;
            if(v1 != 0) {
                v2 = v13_2;
            }

            MotionScheme v15 = v4 != 0 ? ((MotionScheme)v13_2) : v5;
            Shapes v16 = v7 != 0 ? ((Shapes)v13_2) : v8;
            Typography v17 = v9 != 0 ? ((Typography)v13_2) : v10;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v3, -1, "androidx.compose.material3.MaterialExpressiveTheme (MaterialTheme.kt:190)");
            }

            ProvidableCompositionLocal v0_1 = MaterialThemeKt.LocalUsingExpressiveTheme;
            ComposerKt.sourceInformationMarkerStart(v12, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v4_1 = v12.consume(v0_1);
            ComposerKt.sourceInformationMarkerEnd(v12);
            if(((Boolean)v4_1).booleanValue()) {
                v12.startReplaceGroup(0x56F19BDE);
                ComposerKt.sourceInformation(v12, "192@8466L312");
                v0 = 6;
                if(v2 == null) {
                    v12.startReplaceGroup(0xC0BD8167);
                    ComposerKt.sourceInformation(v12, "193@8536L11");
                    v1_1 = MaterialTheme.INSTANCE.getColorScheme(v12, v0);
                    v12.endReplaceGroup();
                    v7_1 = v1_1;
                }
                else {
                    v12.startReplaceGroup(0xC0BD7DE4);
                    v12.endReplaceGroup();
                    v7_1 = v2;
                }

                if(v15 == null) {
                    v12.startReplaceGroup(-1061320152);
                    ComposerKt.sourceInformation(v12, "194@8606L12");
                    MotionScheme v1_2 = MaterialTheme.INSTANCE.getMotionScheme(v12, v0);
                    v12.endReplaceGroup();
                    v8_1 = v1_2;
                }
                else {
                    v12.startReplaceGroup(-1061321082);
                    v12.endReplaceGroup();
                    v8_1 = v15;
                }

                if(v17 == null) {
                    v12.startReplaceGroup(-1061318010);
                    ComposerKt.sourceInformation(v12, "195@8673L10");
                    Typography v1_3 = MaterialTheme.INSTANCE.getTypography(v12, v0);
                    v12.endReplaceGroup();
                    v10 = v1_3;
                }
                else {
                    v12.startReplaceGroup(0xC0BD8F22);
                    v12.endReplaceGroup();
                    v10 = v17;
                }

                if(v16 == null) {
                    v12.startReplaceGroup(-1061316190);
                    ComposerKt.sourceInformation(v12, "196@8730L6");
                    Shapes v0_2 = MaterialTheme.INSTANCE.getShapes(v12, v0);
                    v12.endReplaceGroup();
                    v9_1 = v0_2;
                }
                else {
                    v12.startReplaceGroup(0xC0BD96BA);
                    v12.endReplaceGroup();
                    v9_1 = v16;
                }

                MaterialThemeKt.MaterialTheme(v7_1, v8_1, v9_1, v10, v11_1, v12, v3 & 0xE000, 0);
                v12.endReplaceGroup();
                v14 = v2;
            }
            else {
                v12.startReplaceGroup(0x56F6BE95);
                ComposerKt.sourceInformation(v12, "200@8866L415,200@8800L481");
                v14 = v2;
                CompositionLocalKt.CompositionLocalProvider(v0_1.provides(Boolean.valueOf(true)), ComposableLambdaKt.rememberComposableLambda(0x5B8825F8, true, new MaterialThemeKt$MaterialExpressiveTheme$1(v14, v15, v16, v17, arg23), v12, 54), v12, ProvidedValue.$stable | 0x30);
                v12.endReplaceGroup();
            }

            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v1_1 = v14;
            v2_1 = v15;
            v3_1 = v16;
            v4_2 = v17;
        }
        else {
            v12.skipToGroupEnd();
            v1_1 = v2;
            v2_1 = v5;
            v3_1 = v8;
            v4_2 = v10;
        }

        ScopeUpdateScope v8_2 = v12.endRestartGroup();
        if(v8_2 != null) {
            v8_2.updateScope(new MaterialThemeKt$$ExternalSyntheticLambda4(v1_1, v2_1, v3_1, v4_2, arg23, v6, arg26));
        }
    }

    static final Unit MaterialExpressiveTheme$lambda$2(ColorScheme arg8, MotionScheme arg9, Shapes arg10, Typography arg11, Function2 arg12, int arg13, int arg14, Composer arg15, int arg16) {
        MaterialThemeKt.MaterialExpressiveTheme(arg8, arg9, arg10, arg11, arg12, arg15, RecomposeScopeImplKt.updateChangedFlags(arg13 | 1), arg14);
        return Unit.INSTANCE;
    }

    public static final void MaterialTheme(ColorScheme arg22, MotionScheme arg23, Shapes arg24, Typography arg25, Function2 arg26, Composer arg27, int arg28, int arg29) {
        int v11;
        Typography v10_1;
        int v10;
        Shapes v9_1;
        int v9;
        MotionScheme v8;
        int v7;
        ColorScheme v2;
        Function2 v5 = arg26;
        int v6 = arg28;
        int v0 = 0x35E9C094;
        Composer v1 = arg27.startRestartGroup(v0);
        ComposerKt.sourceInformation(v1, "C(MaterialTheme)N(colorScheme,motionScheme,shapes,typography,content)97@4480L40,105@4846L81,98@4525L402:MaterialTheme.kt#uh7d8r");
        int v3 = 4;
        int v4 = 2;
        if((v6 & 6) == 0) {
            if((arg29 & 1) == 0) {
                v2 = arg22;
                if(v1.changed(v2)) {
                    v7 = v3;
                }
                else {
                    goto label_19;
                }
            }
            else {
                v2 = arg22;
            label_19:
                v7 = v4;
            }

            v7 |= v6;
        }
        else {
            v2 = arg22;
            v7 = v6;
        }

        if((v6 & 0x30) == 0) {
            if((arg29 & 2) == 0) {
                v8 = arg23;
                if(v1.changed(v8)) {
                    v9 = 0x20;
                }
                else {
                    goto label_34;
                }
            }
            else {
                v8 = arg23;
            label_34:
                v9 = 16;
            }

            v7 |= v9;
        }
        else {
            v8 = arg23;
        }

        if((v6 & 0x180) == 0) {
            if((arg29 & 4) == 0) {
                v9_1 = arg24;
                if(v1.changed(v9_1)) {
                    v10 = 0x100;
                }
                else {
                    goto label_48;
                }
            }
            else {
                v9_1 = arg24;
            label_48:
                v10 = 0x80;
            }

            v7 |= v10;
        }
        else {
            v9_1 = arg24;
        }

        if((v6 & 0xC00) == 0) {
            if((arg29 & 8) == 0) {
                v10_1 = arg25;
                if(v1.changed(v10_1)) {
                    v11 = 0x800;
                }
                else {
                    goto label_62;
                }
            }
            else {
                v10_1 = arg25;
            label_62:
                v11 = 0x400;
            }

            v7 |= v11;
        }
        else {
            v10_1 = arg25;
        }

        if((arg29 & 16) != 0) {
            v7 |= 0x6000;
        }
        else if((v6 & 0x6000) == 0) {
            v11 = v1.changedInstance(v5) ? 0x4000 : 0x2000;
            v7 |= v11;
        }

        boolean v11_1 = (v7 & 9363) != 9362 ? true : false;
        if(v1.shouldExecute(v11_1, v7 & 1)) {
            v1.startDefaults();
            ComposerKt.sourceInformation(v1, "90@4205L11,91@4265L12,92@4314L6,93@4365L10");
            int v12 = 6;
            if((v6 & 1) == 0 || (v1.getDefaultsInvalid())) {
                if((arg29 & 1) != 0) {
                    v2 = MaterialTheme.INSTANCE.getColorScheme(v1, v12);
                    v7 &= -15;
                }

                if((arg29 & 2) != 0) {
                    v8 = MaterialTheme.INSTANCE.getMotionScheme(v1, v12);
                    v7 &= 0xFFFFFF8F;
                }

                if((arg29 & 4) != 0) {
                    v9_1 = MaterialTheme.INSTANCE.getShapes(v1, v12);
                    v7 &= -897;
                }

                if((arg29 & 8) == 0) {
                    goto label_131;
                }

                v10_1 = MaterialTheme.INSTANCE.getTypography(v1, v12);
            label_130:
                v7 &= 0xFFFFE3FF;
            }
            else {
                v1.skipToGroupEnd();
                if((arg29 & 1) != 0) {
                    v7 &= -15;
                }

                if((arg29 & 2) != 0) {
                    v7 &= 0xFFFFFF8F;
                }

                if((arg29 & 4) != 0) {
                    v7 &= -897;
                }

                if((arg29 & 8) == 0) {
                    goto label_131;
                }

                goto label_130;
            }

        label_131:
            v1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v7, -1, "androidx.compose.material3.MaterialTheme (MaterialTheme.kt:95)");
            }

            IndicationNodeFactory v0_1 = RippleKt.ripple-H2RKhps$default(false, 0f, 0, 7, null);
            TextSelectionColors v7_1 = MaterialThemeKt.rememberTextSelectionColors(v2, v1, v7 & 14);
            ProvidedValue[] v11_2 = new ProvidedValue[v12];
            v11_2[0] = ColorSchemeKt.getLocalColorScheme().provides(v2);
            v11_2[1] = MaterialThemeKt._localMotionScheme.provides(v8);
            v11_2[v4] = IndicationKt.getLocalIndication().provides(v0_1);
            v11_2[3] = ShapesKt.getLocalShapes().provides(v9_1);
            v11_2[v3] = TextSelectionColorsKt.getLocalTextSelectionColors().provides(v7_1);
            v11_2[5] = TypographyKt.getLocalTypography().provides(v10_1);
            CompositionLocalKt.CompositionLocalProvider(v11_2, ComposableLambdaKt.rememberComposableLambda(-1750539308, true, new MaterialThemeKt$MaterialTheme$2(v10_1, v5), v1, 54), v1, ProvidedValue.$stable | 0x30);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_179;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v1.skipToGroupEnd();
        }

    label_179:
        Shapes v3_1 = v9_1;
        Typography v4_1 = v10_1;
        ScopeUpdateScope v9_2 = v1.endRestartGroup();
        if(v9_2 != null) {
            v9_2.updateScope(new MaterialThemeKt$$ExternalSyntheticLambda0(v2, v8, v3_1, v4_1, v5, v6, arg29));
        }
    }

    public static final void MaterialTheme(ColorScheme arg9, Shapes arg10, Typography arg11, Function2 arg12, Composer arg13, int arg14, int arg15) {
        Typography v12;
        Shapes v11;
        ColorScheme v10_1;
        Function2 v13_1;
        int v1;
        int v13;
        int v0 = 0xE531D1F5;
        Composer v6 = arg13.startRestartGroup(v0);
        ComposerKt.sourceInformation(v6, "C(MaterialTheme)N(colorScheme,shapes,typography,content)61@2821L12,59@2734L191:MaterialTheme.kt#uh7d8r");
        if((arg14 & 6) == 0) {
            v13 = (arg15 & 1) != 0 || !v6.changed(arg9) ? 2 : 4;
            v13 |= arg14;
        }
        else {
            v13 = arg14;
        }

        if((arg14 & 0x30) == 0) {
            v1 = (arg15 & 2) != 0 || !v6.changed(arg10) ? 16 : 0x20;
            v13 |= v1;
        }

        if((arg14 & 0x180) == 0) {
            v1 = (arg15 & 4) != 0 || !v6.changed(arg11) ? 0x80 : 0x100;
            v13 |= v1;
        }

        if((arg15 & 8) != 0) {
            v13 |= 0xC00;
        }
        else if((arg14 & 0xC00) == 0) {
            v1 = v6.changedInstance(arg12) ? 0x800 : 0x400;
            v13 |= v1;
        }

        boolean v1_1 = (v13 & 0x493) != 1170 ? true : false;
        if(v6.shouldExecute(v1_1, v13 & 1)) {
            v6.startDefaults();
            ComposerKt.sourceInformation(v6, "54@2578L11,55@2626L6,56@2677L10");
            int v2 = 6;
            if((arg14 & 1) == 0 || (v6.getDefaultsInvalid())) {
                if((arg15 & 1) != 0) {
                    arg9 = MaterialTheme.INSTANCE.getColorScheme(v6, v2);
                    v13 &= -15;
                }

                if((arg15 & 2) != 0) {
                    arg10 = MaterialTheme.INSTANCE.getShapes(v6, v2);
                    v13 &= 0xFFFFFF8F;
                }

                if((arg15 & 4) == 0) {
                    goto label_91;
                }

                arg11 = MaterialTheme.INSTANCE.getTypography(v6, v2);
            label_90:
                v13 &= -897;
            }
            else {
                v6.skipToGroupEnd();
                if((arg15 & 1) != 0) {
                    v13 &= -15;
                }

                if((arg15 & 2) != 0) {
                    v13 &= 0xFFFFFF8F;
                }

                if((arg15 & 4) == 0) {
                    goto label_91;
                }

                goto label_90;
            }

        label_91:
            ColorScheme v1_2 = arg9;
            Shapes v3 = arg10;
            Typography v4 = arg11;
            v6.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v13, -1, "androidx.compose.material3.MaterialTheme (MaterialTheme.kt:59)");
            }

            int v10 = v13 << 3;
            MaterialThemeKt.MaterialTheme(v1_2, MaterialTheme.INSTANCE.getMotionScheme(v6, v2), v3, v4, arg12, v6, v13 & 14 | v10 & 0x380 | v10 & 0x1C00 | v10 & 0xE000, 0);
            v13_1 = arg12;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v10_1 = v1_2;
            v11 = v3;
            v12 = v4;
        }
        else {
            v13_1 = arg12;
            v6.skipToGroupEnd();
            v12 = arg11;
            v11 = arg10;
            v10_1 = arg9;
        }

        ScopeUpdateScope v0_1 = v6.endRestartGroup();
        if(v0_1 != null) {
            v0_1.updateScope(new MaterialThemeKt$$ExternalSyntheticLambda1(v10_1, v11, v12, v13_1, arg14, arg15));
        }
    }

    static final Unit MaterialTheme$lambda$0(ColorScheme arg7, Shapes arg8, Typography arg9, Function2 arg10, int arg11, int arg12, Composer arg13, int arg14) {
        MaterialThemeKt.MaterialTheme(arg7, arg8, arg9, arg10, arg13, RecomposeScopeImplKt.updateChangedFlags(arg11 | 1), arg12);
        return Unit.INSTANCE;
    }

    static final Unit MaterialTheme$lambda$1(ColorScheme arg8, MotionScheme arg9, Shapes arg10, Typography arg11, Function2 arg12, int arg13, int arg14, Composer arg15, int arg16) {
        MaterialThemeKt.MaterialTheme(arg8, arg9, arg10, arg11, arg12, arg15, RecomposeScopeImplKt.updateChangedFlags(arg13 | 1), arg14);
        return Unit.INSTANCE;
    }

    static final MotionScheme _localMotionScheme$lambda$5() {
        return MotionScheme.Companion.standard$material3();
    }

    public static final ProvidableCompositionLocal access$get_localMotionScheme$p() {
        return MaterialThemeKt._localMotionScheme;
    }

    public static final ProvidableCompositionLocal getLocalUsingExpressiveTheme() {
        return MaterialThemeKt.LocalUsingExpressiveTheme;
    }

    private static void get_localMotionScheme$annotations() {
    }

    public static final TextSelectionColors rememberTextSelectionColors(ColorScheme arg11, Composer arg12, int arg13) {
        int v1 = 0x6F3FD9D8;
        ComposerKt.sourceInformationMarkerStart(arg12, v1, "C(rememberTextSelectionColors)N(colorScheme)219@9547L198:MaterialTheme.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg13, -1, "androidx.compose.material3.rememberTextSelectionColors (MaterialTheme.kt:217)");
        }

        long v3 = arg11.getPrimary-0d7_KjU();
        ComposerKt.sourceInformationMarkerStart(arg12, 0x9EB0DAFE, "CC(remember):MaterialTheme.kt#9igjgp");
        boolean v11 = arg12.changed(v3);
        Object v13 = arg12.rememberedValue();
        if((v11) || v13 == Composer.Companion.getEmpty()) {
            TextSelectionColors v3_1 = new TextSelectionColors(v3, Color.copy-wmQWz5c$default(v3, 0.4f, 0f, 0f, 0f, 14, null), null);
            arg12.updateRememberedValue(v3_1);
            TextSelectionColors v13_1 = v3_1;
        }

        ComposerKt.sourceInformationMarkerEnd(arg12);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg12);
        return ((TextSelectionColors)v13);
    }
}

