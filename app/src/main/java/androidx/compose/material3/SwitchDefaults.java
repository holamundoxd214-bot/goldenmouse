package androidx.compose.material3;

import androidx.compose.material3.tokens.SwitchTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001A\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006J¯\u0001\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\b2\b\b\u0002\u0010\n\u001A\u00020\b2\b\b\u0002\u0010\u000B\u001A\u00020\b2\b\b\u0002\u0010\f\u001A\u00020\b2\b\b\u0002\u0010\r\u001A\u00020\b2\b\b\u0002\u0010\u000E\u001A\u00020\b2\b\b\u0002\u0010\u000F\u001A\u00020\b2\b\b\u0002\u0010\u0010\u001A\u00020\b2\b\b\u0002\u0010\u0011\u001A\u00020\b2\b\b\u0002\u0010\u0012\u001A\u00020\b2\b\b\u0002\u0010\u0013\u001A\u00020\b2\b\b\u0002\u0010\u0014\u001A\u00020\b2\b\b\u0002\u0010\u0015\u001A\u00020\b2\b\b\u0002\u0010\u0016\u001A\u00020\b2\b\b\u0002\u0010\u0017\u001A\u00020\bH\u0007¢\u0006\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001A\u001A\u00020\u0005*\u00020\u001B8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u001C\u0010\u001DR\u0013\u0010\u001E\u001A\u00020\u001F¢\u0006\n\n\u0002\u0010\"\u001A\u0004\b \u0010!¨\u0006#"}, d2={"Landroidx/compose/material3/SwitchDefaults;", "", "<init>", "()V", "colors", "Landroidx/compose/material3/SwitchColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/SwitchColors;", "checkedThumbColor", "Landroidx/compose/ui/graphics/Color;", "checkedTrackColor", "checkedBorderColor", "checkedIconColor", "uncheckedThumbColor", "uncheckedTrackColor", "uncheckedBorderColor", "uncheckedIconColor", "disabledCheckedThumbColor", "disabledCheckedTrackColor", "disabledCheckedBorderColor", "disabledCheckedIconColor", "disabledUncheckedThumbColor", "disabledUncheckedTrackColor", "disabledUncheckedBorderColor", "disabledUncheckedIconColor", "colors-V1nXRL4", "(JJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/SwitchColors;", "defaultSwitchColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultSwitchColors$material3", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/SwitchColors;", "IconSize", "Landroidx/compose/ui/unit/Dp;", "getIconSize-D9Ej5fM", "()F", "F", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SwitchDefaults {
    public static final int $stable;
    public static final SwitchDefaults INSTANCE;
    private static final float IconSize;

    static {
        SwitchDefaults.INSTANCE = new SwitchDefaults();
        SwitchDefaults.IconSize = Dp.constructor-impl(16f);
    }

    private SwitchDefaults() {
        super();
    }

    public final SwitchColors colors(Composer arg4, int arg5) {
        int v1 = 0x19F6020D;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(colors)306@11856L11:Switch.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.material3.SwitchDefaults.colors (Switch.kt:306)");
        }

        SwitchColors v3 = this.getDefaultSwitchColors$material3(MaterialTheme.INSTANCE.getColorScheme(arg4, 6));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return v3;
    }

    public final SwitchColors colors-V1nXRL4(long arg42, long arg44, long arg46, long arg48, long arg50, long arg52, long arg54, long arg56, long arg58, long arg60, long arg62, long arg64, long arg66, long arg68, long arg70, long arg72, Composer arg74, int arg75, int arg76, int arg77) {
        long v30;
        int v7;
        Composer v0 = arg74;
        int v1 = arg77;
        ComposerKt.sourceInformationMarkerStart(v0, 0x73826915, "C(colors)N(checkedThumbColor:c#ui.graphics.Color,checkedTrackColor:c#ui.graphics.Color,checkedBorderColor:c#ui.graphics.Color,checkedIconColor:c#ui.graphics.Color,uncheckedThumbColor:c#ui.graphics.Color,uncheckedTrackColor:c#ui.graphics.Color,uncheckedBorderColor:c#ui.graphics.Color,uncheckedIconColor:c#ui.graphics.Color,disabledCheckedThumbColor:c#ui.graphics.Color,disabledCheckedTrackColor:c#ui.graphics.Color,disabledCheckedBorderColor:c#ui.graphics.Color,disabledCheckedIconColor:c#ui.graphics.Color,disabledUncheckedThumbColor:c#ui.graphics.Color,disabledUncheckedTrackColor:c#ui.graphics.Color,disabledUncheckedBorderColor:c#ui.graphics.Color,disabledUncheckedIconColor:c#ui.graphics.Color)331@13608L5,332@13682L5,334@13809L5,335@13888L5,336@13966L5,337@14057L5,338@14133L5,340@14236L5,342@14361L11,344@14478L5,346@14594L11,349@14772L5,351@14895L11,353@15017L5,355@15144L11,357@15265L5,359@15381L11,361@15510L5,363@15626L11,365@15745L5,367@15870L11:Switch.kt#uh7d8r");
        int v4 = 6;
        long v8 = (v1 & 1) != 0 ? ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getSelectedHandleColor(), v0, v4) : arg42;
        long v10 = (v1 & 2) != 0 ? ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getSelectedTrackColor(), v0, v4) : arg44;
        long v12 = (v1 & 4) != 0 ? Color.Companion.getTransparent-0d7_KjU() : arg46;
        long v14 = (v1 & 8) != 0 ? ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getSelectedIconColor(), v0, v4) : arg48;
        long v16 = (v1 & 16) != 0 ? ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getUnselectedHandleColor(), v0, v4) : arg50;
        long v18 = (v1 & 0x20) != 0 ? ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getUnselectedTrackColor(), v0, v4) : arg52;
        long v20 = (v1 & 0x40) != 0 ? ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getUnselectedFocusTrackOutlineColor(), v0, v4) : arg54;
        long v22 = (v1 & 0x80) != 0 ? ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getUnselectedIconColor(), v0, v4) : arg56;
        long v24 = (v1 & 0x100) != 0 ? ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getDisabledSelectedHandleColor(), v0, v4), SwitchTokens.INSTANCE.getDisabledSelectedHandleOpacity(), 0f, 0f, 0f, 14, null), MaterialTheme.INSTANCE.getColorScheme(v0, v4).getSurface-0d7_KjU()) : arg58;
        long v26 = (v1 & 0x200) != 0 ? ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getDisabledSelectedTrackColor(), v0, 6), SwitchTokens.INSTANCE.getDisabledTrackOpacity(), 0f, 0f, 0f, 14, null), MaterialTheme.INSTANCE.getColorScheme(v0, 6).getSurface-0d7_KjU()) : arg60;
        long v28 = (v1 & 0x400) != 0 ? Color.Companion.getTransparent-0d7_KjU() : arg62;
        if((v1 & 0x800) != 0) {
            v7 = 6;
            v30 = ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getDisabledSelectedIconColor(), v0, v7), SwitchTokens.INSTANCE.getDisabledSelectedIconOpacity(), 0f, 0f, 0f, 14, null), MaterialTheme.INSTANCE.getColorScheme(v0, v7).getSurface-0d7_KjU());
        }
        else {
            v7 = 6;
            v30 = arg64;
        }

        long v32 = (v1 & 0x1000) != 0 ? ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getDisabledUnselectedHandleColor(), v0, v7), SwitchTokens.INSTANCE.getDisabledUnselectedHandleOpacity(), 0f, 0f, 0f, 14, null), MaterialTheme.INSTANCE.getColorScheme(v0, v7).getSurface-0d7_KjU()) : arg66;
        long v34 = (v1 & 0x2000) != 0 ? ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getDisabledUnselectedTrackColor(), v0, v7), SwitchTokens.INSTANCE.getDisabledTrackOpacity(), 0f, 0f, 0f, 14, null), MaterialTheme.INSTANCE.getColorScheme(v0, v7).getSurface-0d7_KjU()) : arg68;
        long v36 = (v1 & 0x4000) != 0 ? ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getDisabledUnselectedTrackOutlineColor(), v0, v7), SwitchTokens.INSTANCE.getDisabledTrackOpacity(), 0f, 0f, 0f, 14, null), MaterialTheme.INSTANCE.getColorScheme(v0, v7).getSurface-0d7_KjU()) : arg70;
        long v38 = (v1 & 0x8000) != 0 ? ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getDisabledUnselectedIconColor(), v0, v7), SwitchTokens.INSTANCE.getDisabledUnselectedIconOpacity(), 0f, 0f, 0f, 14, null), MaterialTheme.INSTANCE.getColorScheme(v0, v7).getSurface-0d7_KjU()) : arg72;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(0x73826915, arg75, arg76, "androidx.compose.material3.SwitchDefaults.colors (Switch.kt:369)");
        }

        SwitchColors v7_1 = new SwitchColors(v8, v10, v12, v14, v16, v18, v20, v22, v24, v26, v28, v30, v32, v34, v36, v38, null);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        return v7_1;
    }

    public final SwitchColors getDefaultSwitchColors$material3(ColorScheme arg42) {
        ColorScheme v0 = arg42;
        SwitchColors v1 = v0.getDefaultSwitchColorsCached$material3();
        if(v1 == null) {
            SwitchColors v2 = new SwitchColors(ColorSchemeKt.fromToken(v0, SwitchTokens.INSTANCE.getSelectedHandleColor()), ColorSchemeKt.fromToken(v0, SwitchTokens.INSTANCE.getSelectedTrackColor()), Color.Companion.getTransparent-0d7_KjU(), ColorSchemeKt.fromToken(v0, SwitchTokens.INSTANCE.getSelectedIconColor()), ColorSchemeKt.fromToken(v0, SwitchTokens.INSTANCE.getUnselectedHandleColor()), ColorSchemeKt.fromToken(v0, SwitchTokens.INSTANCE.getUnselectedTrackColor()), ColorSchemeKt.fromToken(v0, SwitchTokens.INSTANCE.getUnselectedFocusTrackOutlineColor()), ColorSchemeKt.fromToken(v0, SwitchTokens.INSTANCE.getUnselectedIconColor()), ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, SwitchTokens.INSTANCE.getDisabledSelectedHandleColor()), SwitchTokens.INSTANCE.getDisabledSelectedHandleOpacity(), 0f, 0f, 0f, 14, null), v0.getSurface-0d7_KjU()), ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, SwitchTokens.INSTANCE.getDisabledSelectedTrackColor()), SwitchTokens.INSTANCE.getDisabledTrackOpacity(), 0f, 0f, 0f, 14, null), v0.getSurface-0d7_KjU()), Color.Companion.getTransparent-0d7_KjU(), ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, SwitchTokens.INSTANCE.getDisabledSelectedIconColor()), SwitchTokens.INSTANCE.getDisabledSelectedIconOpacity(), 0f, 0f, 0f, 14, null), v0.getSurface-0d7_KjU()), ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, SwitchTokens.INSTANCE.getDisabledUnselectedHandleColor()), SwitchTokens.INSTANCE.getDisabledUnselectedHandleOpacity(), 0f, 0f, 0f, 14, null), v0.getSurface-0d7_KjU()), ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, SwitchTokens.INSTANCE.getDisabledUnselectedTrackColor()), SwitchTokens.INSTANCE.getDisabledTrackOpacity(), 0f, 0f, 0f, 14, null), v0.getSurface-0d7_KjU()), ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, SwitchTokens.INSTANCE.getDisabledUnselectedTrackOutlineColor()), SwitchTokens.INSTANCE.getDisabledTrackOpacity(), 0f, 0f, 0f, 14, null), v0.getSurface-0d7_KjU()), ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, SwitchTokens.INSTANCE.getDisabledUnselectedIconColor()), SwitchTokens.INSTANCE.getDisabledUnselectedIconOpacity(), 0f, 0f, 0f, 14, null), v0.getSurface-0d7_KjU()), null);
            v0.setDefaultSwitchColorsCached$material3(v2);
            return v2;
        }

        return v1;
    }

    public final float getIconSize-D9Ej5fM() {
        return SwitchDefaults.IconSize;
    }
}

