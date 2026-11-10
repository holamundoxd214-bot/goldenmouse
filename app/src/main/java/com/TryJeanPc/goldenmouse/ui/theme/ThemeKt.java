package com.TryJeanPc.goldenmouse.ui.theme;

import android.content.Context;
import android.os.Build$VERSION;
import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.material3.ColorScheme;
import androidx.compose.material3.ColorSchemeKt;
import androidx.compose.material3.DynamicTonalPaletteKt;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A4\u0010\u0003\u001A\u00020\u00042\b\b\u0002\u0010\u0005\u001A\u00020\u00062\b\b\u0002\u0010\u0007\u001A\u00020\u00062\u0011\u0010\b\u001A\r\u0012\u0004\u0012\u00020\u00040\t¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u000B\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010\u0002\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2={"DarkColorScheme", "Landroidx/compose/material3/ColorScheme;", "LightColorScheme", "GoldenMouseProTheme", "", "darkTheme", "", "dynamicColor", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(ZZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "app"}, k=2, mv={2, 2, 0}, xi=0x30) public final class ThemeKt {
    private static final ColorScheme DarkColorScheme;
    private static final ColorScheme LightColorScheme;

    static {
        ThemeKt.DarkColorScheme = ColorSchemeKt.darkColorScheme-_VG5OTI$default(ColorKt.getPurple80(), 0, 0, 0, 0, ColorKt.getPurpleGrey80(), 0, 0, 0, ColorKt.getPink80(), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -546, 0xFFFF, null);
        ThemeKt.LightColorScheme = ColorSchemeKt.lightColorScheme-_VG5OTI$default(ColorKt.getPurple40(), 0, 0, 0, 0, ColorKt.getPurpleGrey40(), 0, 0, 0, ColorKt.getPink40(), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -546, 0xFFFF, null);
    }

    public static final void GoldenMouseProTheme(boolean arg12, boolean arg13, Function2 arg14, Composer arg15, int arg16, int arg17) {
        ColorScheme v0_3;
        int v2;
        int v15;
        int v4 = arg16;
        Intrinsics.checkNotNullParameter(arg14, "content");
        int v0 = 0xD8C2A91E;
        Composer v9 = arg15.startRestartGroup(v0);
        ComposerKt.sourceInformation(v9, "C(GoldenMouseProTheme)N(darkTheme,dynamicColor,content)52@1591L114:Theme.kt#wd73mu");
        if((v4 & 6) == 0) {
            v15 = (arg17 & 1) != 0 || !v9.changed(arg12) ? 2 : 4;
            v15 |= v4;
        }
        else {
            v15 = v4;
        }

        if((arg17 & 2) != 0) {
            v15 |= 0x30;
        }
        else if((v4 & 0x30) == 0) {
            v2 = v9.changed(arg13) ? 0x20 : 16;
            v15 |= v2;
        }

        if((v4 & 0x180) == 0) {
            v2 = v9.changedInstance(arg14) ? 0x100 : 0x80;
            v15 |= v2;
        }

        boolean v2_1 = (v15 & 0x93) != 0x92 ? true : false;
        if(v9.shouldExecute(v2_1, v15 & 1)) {
            v9.startDefaults();
            ComposerKt.sourceInformation(v9, "37@1104L21");
            if((v4 & 1) != 0 && !v9.getDefaultsInvalid()) {
                v9.skipToGroupEnd();
                if((arg17 & 1) != 0) {
                    v15 &= -15;
                }
            }
            else if((arg17 & 1) != 0) {
                arg12 = DarkThemeKt.isSystemInDarkTheme(v9, 0);
                v15 &= -15;
            }

            v9.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v15, -1, "com.TryJeanPc.goldenmouse.ui.theme.GoldenMouseProTheme (Theme.kt:41)");
            }

            if(1 == 0 || Build$VERSION.SDK_INT < 0x1F) {
                if(arg12) {
                    v9.startReplaceGroup(-1296230707);
                    v9.endReplaceGroup();
                    v0_3 = ThemeKt.DarkColorScheme;
                    goto label_105;
                }

                v9.startReplaceGroup(0xB2BD1ACE);
                v9.endReplaceGroup();
                v0_3 = ThemeKt.LightColorScheme;
            }
            else {
                v9.startReplaceGroup(0xA4E32209);
                ComposerKt.sourceInformation(v9, "44@1394L7");
                ProvidableCompositionLocal v0_1 = AndroidCompositionLocals_androidKt.getLocalContext();
                ComposerKt.sourceInformationMarkerStart(v9, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object v0_2 = v9.consume(((CompositionLocal)v0_1));
                ComposerKt.sourceInformationMarkerEnd(v9);
                v0_3 = arg12 ? DynamicTonalPaletteKt.dynamicDarkColorScheme(((Context)v0_2)) : DynamicTonalPaletteKt.dynamicLightColorScheme(((Context)v0_2));
                v9.endReplaceGroup();
            }

        label_105:
            MaterialThemeKt.MaterialTheme(v0_3, null, TypeKt.getTypography(), arg14, v9, v15 << 3 & 0x1C00 | 0x180, 2);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_119;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v9.skipToGroupEnd();
        }

    label_119:
        boolean v1 = arg12;
        ScopeUpdateScope v12 = v9.endRestartGroup();
        if(v12 != null) {
            v12.updateScope(new ThemeKt$$ExternalSyntheticLambda0(v1, true, arg14, v4, arg17));
        }
    }

    static final Unit GoldenMouseProTheme$lambda$0(boolean arg6, boolean arg7, Function2 arg8, int arg9, int arg10, Composer arg11, int arg12) {
        ThemeKt.GoldenMouseProTheme(arg6, arg7, arg8, arg11, RecomposeScopeImplKt.updateChangedFlags(arg9 | 1), arg10);
        return Unit.INSTANCE;
    }
}

