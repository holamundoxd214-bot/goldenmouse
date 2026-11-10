package androidx.compose.material3;

import androidx.compose.material3.tokens.TimePickerTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001A\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006J\u009B\u0001\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\b2\b\b\u0002\u0010\n\u001A\u00020\b2\b\b\u0002\u0010\u000B\u001A\u00020\b2\b\b\u0002\u0010\f\u001A\u00020\b2\b\b\u0002\u0010\r\u001A\u00020\b2\b\b\u0002\u0010\u000E\u001A\u00020\b2\b\b\u0002\u0010\u000F\u001A\u00020\b2\b\b\u0002\u0010\u0010\u001A\u00020\b2\b\b\u0002\u0010\u0011\u001A\u00020\b2\b\b\u0002\u0010\u0012\u001A\u00020\b2\b\b\u0002\u0010\u0013\u001A\u00020\b2\b\b\u0002\u0010\u0014\u001A\u00020\b2\b\b\u0002\u0010\u0015\u001A\u00020\bH\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u000F\u0010\u001C\u001A\u00020\u001DH\u0007¢\u0006\u0004\b\u001E\u0010\u001FR\u0018\u0010\u0018\u001A\u00020\u0005*\u00020\u00198@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u001A\u0010\u001B¨\u0006 "}, d2={"Landroidx/compose/material3/TimePickerDefaults;", "", "<init>", "()V", "colors", "Landroidx/compose/material3/TimePickerColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/TimePickerColors;", "clockDialColor", "Landroidx/compose/ui/graphics/Color;", "clockDialSelectedContentColor", "clockDialUnselectedContentColor", "selectorColor", "containerColor", "periodSelectorBorderColor", "periodSelectorSelectedContainerColor", "periodSelectorUnselectedContainerColor", "periodSelectorSelectedContentColor", "periodSelectorUnselectedContentColor", "timeSelectorSelectedContainerColor", "timeSelectorUnselectedContainerColor", "timeSelectorSelectedContentColor", "timeSelectorUnselectedContentColor", "colors-u3YEpmA", "(JJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/TimePickerColors;", "defaultTimePickerColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultTimePickerColors$material3", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/TimePickerColors;", "layoutType", "Landroidx/compose/material3/TimePickerLayoutType;", "layoutType-sDNSZnc", "(Landroidx/compose/runtime/Composer;I)I", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TimePickerDefaults {
    public static final int $stable;
    public static final TimePickerDefaults INSTANCE;

    static {
        TimePickerDefaults.INSTANCE = new TimePickerDefaults();
    }

    private TimePickerDefaults() {
        super();
    }

    public final TimePickerColors colors(Composer arg4, int arg5) {
        int v1 = -2085808058;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(colors)284@13803L11:TimePicker.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.material3.TimePickerDefaults.colors (TimePicker.kt:284)");
        }

        TimePickerColors v3 = this.getDefaultTimePickerColors$material3(MaterialTheme.INSTANCE.getColorScheme(arg4, 6));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return v3;
    }

    public final TimePickerColors colors-u3YEpmA(long arg32, long arg34, long arg36, long arg38, long arg40, long arg42, long arg44, long arg46, long arg48, long arg50, long arg52, long arg54, long arg56, long arg58, Composer arg60, int arg61, int arg62, int arg63) {
        Composer v0 = arg60;
        int v1 = arg63;
        int v3 = 0xD9797260;
        ComposerKt.sourceInformationMarkerStart(v0, v3, "C(colors)N(clockDialColor:c#ui.graphics.Color,clockDialSelectedContentColor:c#ui.graphics.Color,clockDialUnselectedContentColor:c#ui.graphics.Color,selectorColor:c#ui.graphics.Color,containerColor:c#ui.graphics.Color,periodSelectorBorderColor:c#ui.graphics.Color,periodSelectorSelectedContainerColor:c#ui.graphics.Color,periodSelectorUnselectedContainerColor:c#ui.graphics.Color,periodSelectorSelectedContentColor:c#ui.graphics.Color,periodSelectorUnselectedContentColor:c#ui.graphics.Color,timeSelectorSelectedContainerColor:c#ui.graphics.Color,timeSelectorUnselectedContainerColor:c#ui.graphics.Color,timeSelectorSelectedContentColor:c#ui.graphics.Color,timeSelectorUnselectedContentColor:c#ui.graphics.Color)331@16569L11:TimePicker.kt#uh7d8r");
        long v4 = (v1 & 1) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg32;
        long v6 = (v1 & 2) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg34;
        long v8 = (v1 & 4) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg36;
        long v10 = (v1 & 8) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg38;
        long v12 = (v1 & 16) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg40;
        long v14 = (v1 & 0x20) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg42;
        long v16 = (v1 & 0x40) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg44;
        long v18 = (v1 & 0x80) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg46;
        long v20 = (v1 & 0x100) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg48;
        long v22 = (v1 & 0x200) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg50;
        long v24 = (v1 & 0x400) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg52;
        long v26 = (v1 & 0x800) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg54;
        long v28 = (v1 & 0x1000) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg56;
        long v1_1 = (v1 & 0x2000) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg58;
        arg58 = v1_1;
        if(ComposerKt.isTraceInProgress()) {
            arg32 = v4;
            ComposerKt.traceEventStart(v3, arg61, arg62, "androidx.compose.material3.TimePickerDefaults.colors (TimePicker.kt:331)");
        }
        else {
            arg32 = v4;
        }

        TimePickerColors v1_2 = this.getDefaultTimePickerColors$material3(MaterialTheme.INSTANCE.getColorScheme(v0, 6)).copy-dVHXu7A(arg32, v10, v12, v14, v6, v8, v16, v18, v20, v22, v24, v26, v28, arg58);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        return v1_2;
    }

    public final TimePickerColors getDefaultTimePickerColors$material3(ColorScheme arg33) {
        ColorScheme v0 = arg33;
        TimePickerColors v1 = v0.getDefaultTimePickerColorsCached$material3();
        if(v1 == null) {
            TimePickerColors v2 = new TimePickerColors(ColorSchemeKt.fromToken(v0, TimePickerTokens.INSTANCE.getClockDialColor()), ColorSchemeKt.fromToken(v0, TimePickerTokens.INSTANCE.getClockDialSelectorHandleContainerColor()), ColorSchemeKt.fromToken(v0, TimePickerTokens.INSTANCE.getContainerColor()), ColorSchemeKt.fromToken(v0, TimePickerTokens.INSTANCE.getPeriodSelectorOutlineColor()), ColorSchemeKt.fromToken(v0, TimePickerTokens.INSTANCE.getClockDialSelectedLabelTextColor()), ColorSchemeKt.fromToken(v0, TimePickerTokens.INSTANCE.getClockDialUnselectedLabelTextColor()), ColorSchemeKt.fromToken(v0, TimePickerTokens.INSTANCE.getPeriodSelectorSelectedContainerColor()), Color.Companion.getTransparent-0d7_KjU(), ColorSchemeKt.fromToken(v0, TimePickerTokens.INSTANCE.getPeriodSelectorSelectedLabelTextColor()), ColorSchemeKt.fromToken(v0, TimePickerTokens.INSTANCE.getPeriodSelectorUnselectedLabelTextColor()), ColorSchemeKt.fromToken(v0, TimePickerTokens.INSTANCE.getTimeSelectorSelectedContainerColor()), ColorSchemeKt.fromToken(v0, TimePickerTokens.INSTANCE.getTimeSelectorUnselectedContainerColor()), ColorSchemeKt.fromToken(v0, TimePickerTokens.INSTANCE.getTimeSelectorSelectedLabelTextColor()), ColorSchemeKt.fromToken(v0, TimePickerTokens.INSTANCE.getTimeSelectorUnselectedLabelTextColor()), null);
            v0.setDefaultTimePickerColorsCached$material3(v2);
            return v2;
        }

        return v1;
    }

    public final int layoutType-sDNSZnc(Composer arg3, int arg4) {
        int v0 = 517161502;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(layoutType)381@19721L27:TimePicker.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.TimePickerDefaults.layoutType (TimePicker.kt:381)");
        }

        int v2 = TimePickerKt.getDefaultTimePickerLayoutType(arg3, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v2;
    }
}

