package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.DialogTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\u0011\u001A\u00020\u00122\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\u00120\u00142\u0006\u0010\u0015\u001A\u00020\u00162\b\b\u0002\u0010\u0017\u001A\u00020\u0018H\u0007¢\u0006\u0004\b\u0019\u0010\u001AJ!\u0010\u001B\u001A\u00020\u00122\u0006\u0010\u0015\u001A\u00020\u00162\b\b\u0002\u0010\u0017\u001A\u00020\u0018H\u0007¢\u0006\u0004\b\u001C\u0010\u001DR\u0011\u0010\u0004\u001A\u00020\u00058G¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001A\u00020\t8G¢\u0006\u0006\u001A\u0004\b\n\u0010\u000BR\u0013\u0010\f\u001A\u00020\r¢\u0006\n\n\u0002\u0010\u0010\u001A\u0004\b\u000E\u0010\u000F¨\u0006\u001E"}, d2={"Landroidx/compose/material3/TimePickerDialogDefaults;", "", "<init>", "()V", "containerColor", "Landroidx/compose/ui/graphics/Color;", "getContainerColor", "(Landroidx/compose/runtime/Composer;I)J", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "MinHeightForTimePicker", "Landroidx/compose/ui/unit/Dp;", "getMinHeightForTimePicker-D9Ej5fM", "()F", "F", "DisplayModeToggle", "", "onDisplayModeChange", "Lkotlin/Function0;", "displayMode", "Landroidx/compose/material3/TimePickerDisplayMode;", "modifier", "Landroidx/compose/ui/Modifier;", "DisplayModeToggle-S7Bxtbk", "(Lkotlin/jvm/functions/Function0;ILandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "Title", "Title-pK_nZyw", "(ILandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TimePickerDialogDefaults {
    public static final int $stable;
    public static final TimePickerDialogDefaults INSTANCE;
    private static final float MinHeightForTimePicker;

    static {
        TimePickerDialogDefaults.INSTANCE = new TimePickerDialogDefaults();
        TimePickerDialogDefaults.MinHeightForTimePicker = Dp.constructor-impl(300f);
    }

    private TimePickerDialogDefaults() {
        super();
    }

    public final void DisplayModeToggle-S7Bxtbk(Function0 arg17, int arg18, Modifier arg19, Composer arg20, int arg21, int arg22) {
        Companion v4_1;
        Companion v7_2;
        Modifier v6;
        int v4;
        Function0 v2;
        int v1;
        int v3 = arg18;
        int v5 = arg21;
        int v0 = -1283607635;
        Composer v13 = arg20.startRestartGroup(v0);
        ComposerKt.sourceInformation(v13, "C(DisplayModeToggle)N(onDisplayModeChange,displayMode:c#material3.TimePickerDisplayMode,modifier)265@11164L645,265@11101L708:TimePickerDialog.kt#uh7d8r");
        if((arg22 & 1) != 0) {
            v1 = v5 | 6;
            v2 = arg17;
        }
        else {
            v2 = arg17;
            if((v5 & 6) == 0) {
                v1 = v13.changedInstance(v2) ? 4 : 2;
                v1 |= v5;
            }
            else {
                v1 = v5;
            }
        }

        if((arg22 & 2) != 0) {
            v1 |= 0x30;
        }
        else if((v5 & 0x30) == 0) {
            v4 = v13.changed(v3) ? 0x20 : 16;
            v1 |= v4;
        }

        v4 = arg22 & 4;
        if(v4 != 0) {
            v1 |= 0x180;
            goto label_49;
        }
        else if((v5 & 0x180) == 0) {
            v6 = arg19;
            int v7 = v13.changed(v6) ? 0x100 : 0x80;
            v1 |= v7;
        }
        else {
        label_49:
            v6 = arg19;
        }

        boolean v7_1 = (v1 & 0x93) != 0x92 ? true : false;
        if(v13.shouldExecute(v7_1, v1 & 1)) {
            if(v4 != 0) {
                v7_2 = Modifier.Companion;
            }
            else {
                Modifier v7_3 = v6;
            }

            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.compose.material3.TimePickerDialogDefaults.DisplayModeToggle (TimePickerDialog.kt:264)");
            }

            IconButtonKt.IconButton(v2, ((Modifier)v7_2), false, null, null, null, ComposableLambdaKt.rememberComposableLambda(0xD664F74F, true, new TimePickerDialogDefaults$DisplayModeToggle$1(v3), v13, 54), v13, v1 & 14 | 0x180000 | v1 >> 3 & 0x70, 60);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v4_1 = v7_2;
        }
        else {
            v13.skipToGroupEnd();
            Modifier v4_2 = v6;
        }

        ScopeUpdateScope v7_4 = v13.endRestartGroup();
        if(v7_4 != null) {
            v7_4.updateScope(new TimePickerDialogDefaults$$ExternalSyntheticLambda1(this, arg17, v3, ((Modifier)v4_1), v5, arg22));
        }
    }

    static final Unit DisplayModeToggle_S7Bxtbk$lambda$0(TimePickerDialogDefaults arg7, Function0 arg8, int arg9, Modifier arg10, int arg11, int arg12, Composer arg13, int arg14) {
        arg7.DisplayModeToggle-S7Bxtbk(arg8, arg9, arg10, arg13, RecomposeScopeImplKt.updateChangedFlags(arg11 | 1), arg12);
        return Unit.INSTANCE;
    }

    public final void Title-pK_nZyw(int arg30, Modifier arg31, Composer arg32, int arg33, int arg34) {
        Modifier v3_2;
        Composer v25;
        Companion v9;
        Modifier v5;
        int v3;
        int v2 = arg30;
        int v0 = 0x5C2EB57A;
        Composer v1 = arg32.startRestartGroup(v0);
        ComposerKt.sourceInformation(v1, "C(Title)N(displayMode:c#material3.TimePickerDisplayMode,modifier)297@12224L10,299@12283L257,295@12127L424:TimePickerDialog.kt#uh7d8r");
        if((arg34 & 1) != 0) {
            v3 = arg33 | 6;
        }
        else if((arg33 & 6) == 0) {
            v3 = v1.changed(v2) ? 4 : 2;
            v3 |= arg33;
        }
        else {
            v3 = arg33;
        }

        int v4 = arg34 & 2;
        if(v4 != 0) {
            v3 |= 0x30;
            goto label_34;
        }
        else if((arg33 & 0x30) == 0) {
            v5 = arg31;
            int v6 = v1.changed(v5) ? 0x20 : 16;
            v3 |= v6;
        }
        else {
        label_34:
            v5 = arg31;
        }

        boolean v6_1 = (v3 & 19) != 18 ? true : false;
        if(v1.shouldExecute(v6_1, v3 & 1)) {
            if(v4 != 0) {
                v9 = Modifier.Companion;
            }
            else {
                Modifier v9_1 = v5;
            }

            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v3, -1, "androidx.compose.material3.TimePickerDialogDefaults.Title (TimePickerDialog.kt:294)");
            }

            Modifier v4_1 = PaddingKt.padding-qDBjuR0$default(((Modifier)v9), 0f, 0f, 0f, Dp.constructor-impl(20f), 7, null);
            Companion v0_1 = v9;
            TextStyle v24 = MaterialTheme.INSTANCE.getTypography(v1, 6).getLabelMedium();
            v3 = TimePickerDisplayMode.equals-impl0(v2, TimePickerDisplayMode.Companion.getPicker--ONbchU()) ? Strings.constructor-impl(string.m3c_time_picker_dialog_title) : Strings.constructor-impl(string.m3c_time_input_dialog_title);
            v25 = v1;
            TextKt.Text-Nvy7gAk(Strings_androidKt.getString-2EP1pXo(v3, v1, 0), v4_1, 0, null, 0, null, null, null, 0, null, null, 0, 0, false, 0, 0, null, v24, v25, 0, 0, 0x1FFFC);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            Companion v3_1 = v0_1;
        }
        else {
            v25 = v1;
            v25.skipToGroupEnd();
            v3_2 = v5;
        }

        ScopeUpdateScope v6_2 = v25.endRestartGroup();
        if(v6_2 != null) {
            v6_2.updateScope(new TimePickerDialogDefaults$$ExternalSyntheticLambda0(this, v2, v3_2, arg33, arg34));
        }
    }

    static final Unit Title_pK_nZyw$lambda$1(TimePickerDialogDefaults arg6, int arg7, Modifier arg8, int arg9, int arg10, Composer arg11, int arg12) {
        arg6.Title-pK_nZyw(arg7, arg8, arg11, RecomposeScopeImplKt.updateChangedFlags(arg9 | 1), arg10);
        return Unit.INSTANCE;
    }

    public final long getContainerColor(Composer arg3, int arg4) {
        int v0 = 0xE58C8627;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-containerColor>)242@10289L5:TimePickerDialog.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.TimePickerDialogDefaults.<get-containerColor> (TimePickerDialog.kt:242)");
        }

        long v0_1 = ColorSchemeKt.getValue(DialogTokens.INSTANCE.getContainerColor(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v0_1;
    }

    public final float getMinHeightForTimePicker-D9Ej5fM() {
        return TimePickerDialogDefaults.MinHeightForTimePicker;
    }

    public final Shape getShape(Composer arg3, int arg4) {
        int v0 = 0x49F9A213;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-shape>)246@10412L5:TimePickerDialog.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.TimePickerDialogDefaults.<get-shape> (TimePickerDialog.kt:246)");
        }

        Shape v2 = ShapesKt.getValue(DialogTokens.INSTANCE.getContainerShape(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v2;
    }
}

