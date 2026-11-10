package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.foundation.gestures.snapping.LazyListSnapLayoutInfoProviderKt;
import androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.DatePickerModalTokens;
import androidx.compose.material3.tokens.DividerTokens;
import androidx.compose.material3.tokens.ElevationTokens;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.semantics.LiveRegionMode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(d1={"\u0000\u008E\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001A\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006J\u008B\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\b2\b\b\u0002\u0010\n\u001A\u00020\b2\b\b\u0002\u0010\u000B\u001A\u00020\b2\b\b\u0002\u0010\f\u001A\u00020\b2\b\b\u0002\u0010\r\u001A\u00020\b2\b\b\u0002\u0010\u000E\u001A\u00020\b2\b\b\u0002\u0010\u000F\u001A\u00020\b2\b\b\u0002\u0010\u0010\u001A\u00020\b2\b\b\u0002\u0010\u0011\u001A\u00020\b2\b\b\u0002\u0010\u0012\u001A\u00020\b2\b\b\u0002\u0010\u0013\u001A\u00020\b2\b\b\u0002\u0010\u0014\u001A\u00020\b2\b\b\u0002\u0010\u0015\u001A\u00020\b2\b\b\u0002\u0010\u0016\u001A\u00020\b2\b\b\u0002\u0010\u0017\u001A\u00020\b2\b\b\u0002\u0010\u0018\u001A\u00020\b2\b\b\u0002\u0010\u0019\u001A\u00020\b2\b\b\u0002\u0010\u001A\u001A\u00020\b2\b\b\u0002\u0010\u001B\u001A\u00020\b2\b\b\u0002\u0010\u001C\u001A\u00020\b2\b\b\u0002\u0010\u001D\u001A\u00020\b2\b\b\u0002\u0010\u001E\u001A\u00020\b2\b\b\u0002\u0010\u001F\u001A\u00020\b2\n\b\u0002\u0010 \u001A\u0004\u0018\u00010!H\u0007¢\u0006\u0004\b\"\u0010#J$\u0010(\u001A\u00020)2\b\b\u0002\u0010*\u001A\u00020+2\b\b\u0002\u0010,\u001A\u00020+2\b\b\u0002\u0010-\u001A\u00020+J+\u0010.\u001A\u00020/2\u0006\u00100\u001A\u0002012\b\b\u0002\u00102\u001A\u0002032\b\b\u0002\u00104\u001A\u00020\bH\u0007¢\u0006\u0004\b5\u00106J=\u00107\u001A\u00020/2\b\u00108\u001A\u0004\u0018\u0001092\u0006\u00100\u001A\u0002012\u0006\u0010(\u001A\u00020)2\b\b\u0002\u00102\u001A\u0002032\b\b\u0002\u00104\u001A\u00020\bH\u0007¢\u0006\u0004\b:\u0010;J\'\u0010<\u001A\u00020=2\u0006\u0010>\u001A\u00020?2\u000E\b\u0002\u0010@\u001A\b\u0012\u0004\u0012\u00020B0AH\u0001¢\u0006\u0004\bC\u0010DR\u0018\u0010$\u001A\u00020\u0005*\u00020%8AX\u0080\u0004¢\u0006\u0006\u001A\u0004\b&\u0010\'R\u0011\u0010E\u001A\u00020F¢\u0006\b\n\u0000\u001A\u0004\bG\u0010HR\u0013\u0010I\u001A\u00020J¢\u0006\n\n\u0002\u0010M\u001A\u0004\bK\u0010LR\u0011\u0010N\u001A\u00020O8G¢\u0006\u0006\u001A\u0004\bP\u0010QR\u0011\u0010R\u001A\u00020S¢\u0006\b\n\u0000\u001A\u0004\bT\u0010UR\u000E\u0010V\u001A\u00020+X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010W\u001A\u00020+X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010X\u001A\u00020+X\u0086T¢\u0006\u0002\n\u0000¨\u0006Y"}, d2={"Landroidx/compose/material3/DatePickerDefaults;", "", "<init>", "()V", "colors", "Landroidx/compose/material3/DatePickerColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/DatePickerColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "titleContentColor", "headlineContentColor", "weekdayContentColor", "subheadContentColor", "navigationContentColor", "yearContentColor", "disabledYearContentColor", "currentYearContentColor", "selectedYearContentColor", "disabledSelectedYearContentColor", "selectedYearContainerColor", "disabledSelectedYearContainerColor", "dayContentColor", "disabledDayContentColor", "selectedDayContentColor", "disabledSelectedDayContentColor", "selectedDayContainerColor", "disabledSelectedDayContainerColor", "todayContentColor", "todayDateBorderColor", "dayInSelectionRangeContentColor", "dayInSelectionRangeContainerColor", "dividerColor", "dateTextFieldColors", "Landroidx/compose/material3/TextFieldColors;", "colors-bSRYm20", "(JJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)Landroidx/compose/material3/DatePickerColors;", "defaultDatePickerColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultDatePickerColors", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/DatePickerColors;", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "yearSelectionSkeleton", "", "selectedDateSkeleton", "selectedDateDescriptionSkeleton", "DatePickerTitle", "", "displayMode", "Landroidx/compose/material3/DisplayMode;", "modifier", "Landroidx/compose/ui/Modifier;", "contentColor", "DatePickerTitle-FNtVw6o", "(ILandroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "DatePickerHeadline", "selectedDateMillis", "", "DatePickerHeadline-ISIPfiY", "(Ljava/lang/Long;ILandroidx/compose/material3/DatePickerFormatter;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "rememberSnapFlingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "lazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "decayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "", "rememberSnapFlingBehavior$material3", "(Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/gestures/FlingBehavior;", "YearRange", "Lkotlin/ranges/IntRange;", "getYearRange", "()Lkotlin/ranges/IntRange;", "TonalElevation", "Landroidx/compose/ui/unit/Dp;", "getTonalElevation-D9Ej5fM", "()F", "F", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "AllDates", "Landroidx/compose/material3/SelectableDates;", "getAllDates", "()Landroidx/compose/material3/SelectableDates;", "YearMonthSkeleton", "YearAbbrMonthDaySkeleton", "YearMonthWeekdayDaySkeleton", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DatePickerDefaults {
    public static final int $stable = 0;
    private static final SelectableDates AllDates = null;
    public static final DatePickerDefaults INSTANCE = null;
    private static final float TonalElevation = 0f;
    public static final String YearAbbrMonthDaySkeleton = "yMMMd";
    public static final String YearMonthSkeleton = "yMMMM";
    public static final String YearMonthWeekdayDaySkeleton = "yMMMMEEEEd";
    private static final IntRange YearRange;

    static {
        DatePickerDefaults.INSTANCE = new DatePickerDefaults();
        DatePickerDefaults.YearRange = new IntRange(1900, 2100);
        DatePickerDefaults.TonalElevation = ElevationTokens.INSTANCE.getLevel0-D9Ej5fM();
        DatePickerDefaults.AllDates = new DatePickerDefaults$AllDates$1();
    }

    private DatePickerDefaults() {
        super();
    }

    public final void DatePickerHeadline-ISIPfiY(Long arg37, int arg38, DatePickerFormatter arg39, Modifier arg40, long arg41, Composer arg43, int arg44, int arg45) {
        long v6_5;
        Modifier v5_2;
        Composer v31;
        DatePickerDefaults$$ExternalSyntheticLambda0 v7_2;
        Modifier v10_2;
        long v11;
        Modifier v6_3;
        Companion v6_2;
        int v12;
        long v10_1;
        Modifier v7;
        boolean v6_1;
        int v6;
        int v5;
        DatePickerDefaults v1 = this;
        Long v2 = arg37;
        int v0 = arg38;
        DatePickerFormatter v4 = arg39;
        int v8 = arg44;
        int v3 = 0x72111F7C;
        Composer v9 = arg43.startRestartGroup(v3);
        ComposerKt.sourceInformation(v9, "C(DatePickerHeadline)N(selectedDateMillis,displayMode:c#material3.DisplayMode,dateFormatter,modifier,contentColor:c#ui.graphics.Color)685@33220L15,721@34641L135,718@34544L303:DatePicker.kt#uh7d8r");
        if((arg45 & 1) != 0) {
            v5 = v8 | 6;
        }
        else if((v8 & 6) == 0) {
            v5 = v9.changed(v2) ? 4 : 2;
            v5 |= v8;
        }
        else {
            v5 = v8;
        }

        if((arg45 & 2) != 0) {
            v5 |= 0x30;
        }
        else if((v8 & 0x30) == 0) {
            v6 = v9.changed(v0) ? 0x20 : 16;
            v5 |= v6;
        }

        if((arg45 & 4) != 0) {
            v5 |= 0x180;
        }
        else if((v8 & 0x180) == 0) {
            v6_1 = (v8 & 0x200) == 0 ? v9.changed(v4) : v9.changedInstance(v4);
            v6 = v6_1 ? 0x100 : 0x80;
            v5 |= v6;
        }

        v6 = arg45 & 8;
        if(v6 != 0) {
            v5 |= 0xC00;
            goto label_66;
        }
        else if((v8 & 0xC00) == 0) {
            v7 = arg40;
            int v10 = v9.changed(v7) ? 0x800 : 0x400;
            v5 |= v10;
        }
        else {
        label_66:
            v7 = arg40;
        }

        if((v8 & 0x6000) == 0) {
            if((arg45 & 16) == 0) {
                v10_1 = arg41;
                if(v9.changed(v10_1)) {
                    v12 = 0x4000;
                }
                else {
                    goto label_77;
                }
            }
            else {
                v10_1 = arg41;
            label_77:
                v12 = 0x2000;
            }

            v5 |= v12;
        }
        else {
            v10_1 = arg41;
        }

        int v13 = 0x30000;
        if((arg45 & 0x20) != 0) {
            v5 |= v13;
        }
        else if((v8 & v13) == 0) {
            v12 = v9.changed(v1) ? 0x20000 : 0x10000;
            v5 |= v12;
        }

        boolean v12_1 = (74899 & v5) != 74898 ? true : false;
        if(v9.shouldExecute(v12_1, v5 & 1)) {
            v9.startDefaults();
            ComposerKt.sourceInformation(v9, "683@33160L8");
            v13 = 0xFFFF1FFF;
            if((v8 & 1) == 0 || (v9.getDefaultsInvalid())) {
                if(v6 != 0) {
                    v6_2 = Modifier.Companion;
                }
                else {
                    v6_3 = v7;
                }

                if((arg45 & 16) != 0) {
                    v10_1 = v1.colors(v9, v5 >> 15 & 14).getHeadlineContentColor-0d7_KjU();
                    v5 &= v13;
                }

                v13 = v5;
                v11 = v10_1;
                Companion v10_3 = v6_2;
            }
            else {
                v9.skipToGroupEnd();
                if((arg45 & 16) != 0) {
                    v5 &= v13;
                }

                v13 = v5;
                v11 = v10_1;
                v10_2 = v7;
            }

            v9.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v3, v13, -1, "androidx.compose.material3.DatePickerDefaults.DatePickerHeadline (DatePicker.kt:684)");
            }

            Locale v4_1 = CalendarLocale_androidKt.defaultLocale(v9, 0);
            String v5_1 = DatePickerFormatter.formatDate$default(arg39, v2, v4_1, false, 4, null);
            Locale v35 = v4_1;
            v4 = arg39;
            v2 = v2;
            String v3_1 = v4.formatDate(v2, v35, true);
            String v6_4 = "";
            if(v3_1 == null) {
                v9.startReplaceGroup(380185931);
                ComposerKt.sourceInformation(v9, v6_4);
                if(DisplayMode.equals-impl0(v0, DisplayMode.Companion.getPicker-jFl-4v0())) {
                    v9.startReplaceGroup(0x32478CAF);
                    ComposerKt.sourceInformation(v9, "695@33650L51");
                    v3_1 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(string.m3c_date_picker_no_selection_description), v9, 0);
                    v9.endReplaceGroup();
                }
                else if(DisplayMode.equals-impl0(v0, DisplayMode.Companion.getInput-jFl-4v0())) {
                    v9.startReplaceGroup(0x3247984A);
                    ComposerKt.sourceInformation(v9, "696@33743L46");
                    v3_1 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(string.m3c_date_input_no_input_description), v9, 0);
                    v9.endReplaceGroup();
                }
                else {
                    v9.startReplaceGroup(380407362);
                    v9.endReplaceGroup();
                    v3_1 = v6_4;
                }

                v9.endReplaceGroup();
            }
            else {
                v9.startReplaceGroup(0x32476EF2);
                v9.endReplaceGroup();
            }

            if(v5_1 == null) {
                v9.startReplaceGroup(380507587);
                ComposerKt.sourceInformation(v9, v6_4);
                if(DisplayMode.equals-impl0(v0, DisplayMode.Companion.getPicker-jFl-4v0())) {
                    v9.startReplaceGroup(843560257);
                    ComposerKt.sourceInformation(v9, "703@33975L37");
                    v5_1 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(string.m3c_date_picker_headline), v9, 0);
                    v9.endReplaceGroup();
                }
                else if(DisplayMode.equals-impl0(v0, DisplayMode.Companion.getInput-jFl-4v0())) {
                    v9.startReplaceGroup(0x3247BF20);
                    ComposerKt.sourceInformation(v9, "704@34054L36");
                    v5_1 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(string.m3c_date_input_headline), v9, 0);
                    v9.endReplaceGroup();
                }
                else {
                    v9.startReplaceGroup(380705954);
                    v9.endReplaceGroup();
                    v5_1 = v6_4;
                }

                v9.endReplaceGroup();
            }
            else {
                v9.startReplaceGroup(0x3247AA20);
                v9.endReplaceGroup();
            }

            if(DisplayMode.equals-impl0(v0, DisplayMode.Companion.getPicker-jFl-4v0())) {
                v9.startReplaceGroup(0x3247DD0C);
                ComposerKt.sourceInformation(v9, "711@34293L48");
                v6_4 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(string.m3c_date_picker_headline_description), v9, 0);
                v9.endReplaceGroup();
            }
            else if(DisplayMode.equals-impl0(v0, DisplayMode.Companion.getInput-jFl-4v0())) {
                v9.startReplaceGroup(0x3247E84B);
                ComposerKt.sourceInformation(v9, "712@34383L47");
                v6_4 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(string.m3c_date_input_headline_description), v9, 0);
                v9.endReplaceGroup();
            }
            else {
                v9.startReplaceGroup(381043234);
                v9.endReplaceGroup();
            }

            v3_1 = String.format(v6_4, Arrays.copyOf(new Object[]{v3_1}, 1));
            Intrinsics.checkNotNullExpressionValue(v3_1, "format(...)");
            ComposerKt.sourceInformationMarkerStart(v9, 0x324808E3, "CC(remember):DatePicker.kt#9igjgp");
            v6_1 = v9.changed(v3_1);
            Object v7_1 = v9.rememberedValue();
            if((v6_1) || v7_1 == Composer.Companion.getEmpty()) {
                v7_2 = new DatePickerDefaults$$ExternalSyntheticLambda0(v3_1);
                v9.updateRememberedValue(v7_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v9);
            v31 = v9;
            v6_3 = v10_2;
            TextKt.Text-Nvy7gAk(v5_1, SemanticsModifierKt.semantics$default(v10_2, false, ((Function1)v7_2), 1, null), v11, null, 0, null, null, null, 0, null, null, 0, 0, false, 1, 0, null, null, v31, v13 >> 6 & 0x380, 0x6000, 0x3BFF8);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v5_2 = v6_3;
            v6_5 = v11;
        }
        else {
            v31 = v9;
            v31.skipToGroupEnd();
            v5_2 = v7;
            v6_5 = v10_1;
        }

        ScopeUpdateScope v10_4 = v31.endRestartGroup();
        if(v10_4 != null) {
            v10_4.updateScope(new DatePickerDefaults$$ExternalSyntheticLambda1(v1, v2, arg38, v4, v5_2, v6_5, v8, arg45));
        }
    }

    static final Unit DatePickerHeadline_ISIPfiY$lambda$3$lambda$2(String arg1, SemanticsPropertyReceiver arg2) {
        SemanticsPropertiesKt.setLiveRegion-hR3wRGc(arg2, LiveRegionMode.Companion.getPolite-0phEisY());
        SemanticsPropertiesKt.setContentDescription(arg2, arg1);
        return Unit.INSTANCE;
    }

    static final Unit DatePickerHeadline_ISIPfiY$lambda$4(DatePickerDefaults arg11, Long arg12, int arg13, DatePickerFormatter arg14, Modifier arg15, long arg16, int arg18, int arg19, Composer arg20, int arg21) {
        arg11.DatePickerHeadline-ISIPfiY(arg12, arg13, arg14, arg15, arg16, arg20, RecomposeScopeImplKt.updateChangedFlags(arg18 | 1), arg19);
        return Unit.INSTANCE;
    }

    public final void DatePickerTitle-FNtVw6o(int arg34, Modifier arg35, long arg36, Composer arg38, int arg39, int arg40) {
        long v4_1;
        Modifier v3_1;
        Composer v0_1;
        long v9;
        Companion v8_3;
        Modifier v5_2;
        int v10;
        long v8_1;
        Modifier v7;
        int v4;
        DatePickerDefaults v1 = this;
        int v2 = arg34;
        int v6 = arg39;
        int v0 = -390880814;
        Composer v3 = arg38.startRestartGroup(v0);
        ComposerKt.sourceInformation(v3, "C(DatePickerTitle)N(displayMode:c#material3.DisplayMode,modifier,contentColor:c#ui.graphics.Color):DatePicker.kt#uh7d8r");
        if((arg40 & 1) != 0) {
            v4 = v6 | 6;
        }
        else if((v6 & 6) == 0) {
            v4 = v3.changed(v2) ? 4 : 2;
            v4 |= v6;
        }
        else {
            v4 = v6;
        }

        int v5 = arg40 & 2;
        if(v5 != 0) {
            v4 |= 0x30;
            goto label_36;
        }
        else if((v6 & 0x30) == 0) {
            v7 = arg35;
            int v8 = v3.changed(v7) ? 0x20 : 16;
            v4 |= v8;
        }
        else {
        label_36:
            v7 = arg35;
        }

        if((v6 & 0x180) == 0) {
            if((arg40 & 4) == 0) {
                v8_1 = arg36;
                if(v3.changed(v8_1)) {
                    v10 = 0x100;
                }
                else {
                    goto label_47;
                }
            }
            else {
                v8_1 = arg36;
            label_47:
                v10 = 0x80;
            }

            v4 |= v10;
        }
        else {
            v8_1 = arg36;
        }

        if((arg40 & 8) != 0) {
            v4 |= 0xC00;
        }
        else if((v6 & 0xC00) == 0) {
            v10 = v3.changed(v1) ? 0x800 : 0x400;
            v4 |= v10;
        }

        boolean v10_1 = (v4 & 0x493) != 1170 ? true : false;
        if(v3.shouldExecute(v10_1, v4 & 1)) {
            v3.startDefaults();
            ComposerKt.sourceInformation(v3, "648@31804L8");
            if((v6 & 1) == 0 || (v3.getDefaultsInvalid())) {
                if(v5 != 0) {
                    Companion v5_1 = Modifier.Companion;
                }
                else {
                    v5_2 = v7;
                }

                if((arg40 & 4) != 0) {
                    long v7_1 = v1.colors(v3, v4 >> 9 & 14).getTitleContentColor-0d7_KjU();
                    v4 &= -897;
                    v9 = v7_1;
                }
                else {
                    v9 = v8_1;
                }

                v8_3 = ((Companion)v5_2);
            }
            else {
                v3.skipToGroupEnd();
                if((arg40 & 4) != 0) {
                    v4 &= -897;
                }

                v9 = v8_1;
                Modifier v8_2 = v7;
            }

            v3.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v4, -1, "androidx.compose.material3.DatePickerDefaults.DatePickerTitle (DatePicker.kt:649)");
            }

            if(DisplayMode.equals-impl0(v2, DisplayMode.Companion.getPicker-jFl-4v0())) {
                v3.startReplaceGroup(0x8A5295E4);
                ComposerKt.sourceInformation(v3, "653@31952L43,652@31919L178");
                TextKt.Text-Nvy7gAk(Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(string.m3c_date_picker_title), v3, 0), ((Modifier)v8_3), v9, null, 0, null, null, null, 0, null, null, 0, 0, false, 0, 0, null, null, v3, v4 & 0x3F0, 0, 0x3FFF8);
                v0_1 = v3;
                v0_1.endReplaceGroup();
            }
            else {
                v0_1 = v3;
                if(DisplayMode.equals-impl0(v2, DisplayMode.Companion.getInput-jFl-4v0())) {
                    v0_1.startReplaceGroup(0x8A52B263);
                    ComposerKt.sourceInformation(v0_1, "659@32180L42,658@32147L177");
                    TextKt.Text-Nvy7gAk(Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(string.m3c_date_input_title), v0_1, 0), ((Modifier)v8_3), v9, null, 0, null, null, null, 0, null, null, 0, 0, false, 0, 0, null, null, v0_1, v4 & 0x3F0, 0, 0x3FFF8);
                    v0_1.endReplaceGroup();
                }
                else {
                    v0_1.startReplaceGroup(0xC0065930);
                    v0_1.endReplaceGroup();
                }
            }

            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v3_1 = ((Modifier)v8_3);
            v4_1 = v9;
        }
        else {
            v0_1 = v3;
            v0_1.skipToGroupEnd();
            v3_1 = v7;
            v4_1 = v8_1;
        }

        ScopeUpdateScope v8_4 = v0_1.endRestartGroup();
        if(v8_4 != null) {
            v8_4.updateScope(new DatePickerDefaults$$ExternalSyntheticLambda2(v1, v2, v3_1, v4_1, v6, arg40));
        }
    }

    static final Unit DatePickerTitle_FNtVw6o$lambda$1(DatePickerDefaults arg8, int arg9, Modifier arg10, long arg11, int arg13, int arg14, Composer arg15, int arg16) {
        arg8.DatePickerTitle-FNtVw6o(arg9, arg10, arg11, arg15, RecomposeScopeImplKt.updateChangedFlags(arg13 | 1), arg14);
        return Unit.INSTANCE;
    }

    public final DatePickerColors colors(Composer arg4, int arg5) {
        int v1 = 0xEF987B65;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(colors)447@19770L11,447@19782L23:DatePicker.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.material3.DatePickerDefaults.colors (DatePicker.kt:447)");
        }

        DatePickerColors v3 = this.getDefaultDatePickerColors(MaterialTheme.INSTANCE.getColorScheme(arg4, 6), arg4, arg5 << 3 & 0x70);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return v3;
    }

    public final DatePickerColors colors-bSRYm20(long arg53, long arg55, long arg57, long arg59, long arg61, long arg63, long arg65, long arg67, long arg69, long arg71, long arg73, long arg75, long arg77, long arg79, long arg81, long arg83, long arg85, long arg87, long arg89, long arg91, long arg93, long arg95, long arg97, long arg99, TextFieldColors arg101, Composer arg102, int arg103, int arg104, int arg105, int arg106) {
        Composer v0 = arg102;
        int v1 = arg106;
        int v3 = 0x76B5CE76;
        ComposerKt.sourceInformationMarkerStart(v0, v3, "C(colors)N(containerColor:c#ui.graphics.Color,titleContentColor:c#ui.graphics.Color,headlineContentColor:c#ui.graphics.Color,weekdayContentColor:c#ui.graphics.Color,subheadContentColor:c#ui.graphics.Color,navigationContentColor:c#ui.graphics.Color,yearContentColor:c#ui.graphics.Color,disabledYearContentColor:c#ui.graphics.Color,currentYearContentColor:c#ui.graphics.Color,selectedYearContentColor:c#ui.graphics.Color,disabledSelectedYearContentColor:c#ui.graphics.Color,selectedYearContainerColor:c#ui.graphics.Color,disabledSelectedYearContainerColor:c#ui.graphics.Color,dayContentColor:c#ui.graphics.Color,disabledDayContentColor:c#ui.graphics.Color,selectedDayContentColor:c#ui.graphics.Color,disabledSelectedDayContentColor:c#ui.graphics.Color,selectedDayContainerColor:c#ui.graphics.Color,disabledSelectedDayContainerColor:c#ui.graphics.Color,todayContentColor:c#ui.graphics.Color,todayDateBorderColor:c#ui.graphics.Color,dayInSelectionRangeContentColor:c#ui.graphics.Color,dayInSelectionRangeContainerColor:c#ui.graphics.Color,dividerColor:c#ui.graphics.Color,dateTextFieldColors)516@24067L11,516@24079L23:DatePicker.kt#uh7d8r");
        long v4 = (v1 & 1) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg53;
        long v6 = (v1 & 2) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg55;
        long v8 = (v1 & 4) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg57;
        long v10 = (v1 & 8) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg59;
        long v12 = (v1 & 16) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg61;
        long v14 = (v1 & 0x20) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg63;
        long v16 = (v1 & 0x40) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg65;
        long v18 = (v1 & 0x80) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg67;
        long v20 = (v1 & 0x100) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg69;
        long v22 = (v1 & 0x200) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg71;
        long v24 = (v1 & 0x400) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg73;
        long v26 = (v1 & 0x800) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg75;
        long v28 = (v1 & 0x1000) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg77;
        long v30 = (v1 & 0x2000) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg79;
        long v32 = (v1 & 0x4000) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg81;
        long v34 = (0x8000 & v1) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg83;
        long v36 = (0x10000 & v1) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg85;
        long v38 = (0x20000 & v1) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg87;
        long v40 = (0x40000 & v1) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg89;
        long v42 = (0x80000 & v1) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg91;
        long v44 = (0x100000 & v1) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg93;
        long v46 = (0x200000 & v1) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg95;
        long v48 = (0x400000 & v1) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg97;
        long v50 = (0x800000 & v1) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg99;
        TextFieldColors v1_1 = (v1 & 0x1000000) != 0 ? null : arg101;
        if(ComposerKt.isTraceInProgress()) {
            arg101 = v1_1;
            arg53 = v4;
            ComposerKt.traceEventStart(v3, arg103, arg104, "androidx.compose.material3.DatePickerDefaults.colors (DatePicker.kt:516)");
        }
        else {
            arg101 = v1_1;
            arg53 = v4;
        }

        DatePickerColors v1_2 = this.getDefaultDatePickerColors(MaterialTheme.INSTANCE.getColorScheme(v0, 6), v0, arg105 >> 12 & 0x70).copy-tNwlRmA(arg53, v6, v8, v10, v12, v14, v16, v18, v20, v22, v24, v26, v28, v30, v32, v34, v36, v38, v40, v42, v44, v48, v46, v50, arg101);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        return v1_2;
    }

    public final DatePickerFormatter dateFormatter(String arg1, String arg2, String arg3) {
        return new DatePickerFormatterImpl(arg1, arg2, arg3);
    }

    public static DatePickerFormatter dateFormatter$default(DatePickerDefaults arg0, String arg1, String arg2, String arg3, int arg4, Object arg5) {
        if((arg4 & 1) != 0) {
            arg1 = "yMMMM";
        }

        if((arg4 & 2) != 0) {
            arg2 = "yMMMd";
        }

        if((arg4 & 4) != 0) {
            arg3 = "yMMMMEEEEd";
        }

        return arg0.dateFormatter(arg1, arg2, arg3);
    }

    public final SelectableDates getAllDates() {
        return DatePickerDefaults.AllDates;
    }

    public final DatePickerColors getDefaultDatePickerColors(ColorScheme arg56, Composer arg57, int arg58) {
        ColorScheme v0 = arg56;
        Composer v1 = arg57;
        int v2 = arg58;
        int v4 = 1180555308;
        ComposerKt.sourceInformationMarkerStart(v1, v4, "C(<get-defaultDatePickerColors>):DatePicker.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v4, v2, -1, "androidx.compose.material3.DatePickerDefaults.<get-defaultDatePickerColors> (DatePicker.kt:546)");
        }

        DatePickerColors v3 = v0.getDefaultDatePickerColorsCached$material3();
        if(v3 == null) {
            v1.startReplaceGroup(0x264A7F77);
            ComposerKt.sourceInformation(v1, "604@29806L30");
            DatePickerColors v4_1 = new DatePickerColors(ColorSchemeKt.fromToken(v0, DatePickerModalTokens.INSTANCE.getContainerColor()), ColorSchemeKt.fromToken(v0, DatePickerModalTokens.INSTANCE.getHeaderSupportingTextColor()), ColorSchemeKt.fromToken(v0, DatePickerModalTokens.INSTANCE.getHeaderHeadlineColor()), ColorSchemeKt.fromToken(v0, DatePickerModalTokens.INSTANCE.getWeekdaysLabelTextColor()), ColorSchemeKt.fromToken(v0, DatePickerModalTokens.INSTANCE.getRangeSelectionMonthSubheadColor()), v0.getOnSurfaceVariant-0d7_KjU(), ColorSchemeKt.fromToken(v0, DatePickerModalTokens.INSTANCE.getSelectionYearUnselectedLabelTextColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, DatePickerModalTokens.INSTANCE.getSelectionYearUnselectedLabelTextColor()), 0.38f, 0f, 0f, 0f, 14, null), ColorSchemeKt.fromToken(v0, DatePickerModalTokens.INSTANCE.getDateTodayLabelTextColor()), ColorSchemeKt.fromToken(v0, DatePickerModalTokens.INSTANCE.getSelectionYearSelectedLabelTextColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, DatePickerModalTokens.INSTANCE.getSelectionYearSelectedLabelTextColor()), 0.38f, 0f, 0f, 0f, 14, null), ColorSchemeKt.fromToken(v0, DatePickerModalTokens.INSTANCE.getSelectionYearSelectedContainerColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, DatePickerModalTokens.INSTANCE.getSelectionYearSelectedContainerColor()), 0.38f, 0f, 0f, 0f, 14, null), ColorSchemeKt.fromToken(v0, DatePickerModalTokens.INSTANCE.getDateUnselectedLabelTextColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, DatePickerModalTokens.INSTANCE.getDateUnselectedLabelTextColor()), 0.38f, 0f, 0f, 0f, 14, null), ColorSchemeKt.fromToken(v0, DatePickerModalTokens.INSTANCE.getDateSelectedLabelTextColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, DatePickerModalTokens.INSTANCE.getDateSelectedLabelTextColor()), 0.38f, 0f, 0f, 0f, 14, null), ColorSchemeKt.fromToken(v0, DatePickerModalTokens.INSTANCE.getDateSelectedContainerColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, DatePickerModalTokens.INSTANCE.getDateSelectedContainerColor()), 0.38f, 0f, 0f, 0f, 14, null), ColorSchemeKt.fromToken(v0, DatePickerModalTokens.INSTANCE.getDateTodayLabelTextColor()), ColorSchemeKt.fromToken(v0, DatePickerModalTokens.INSTANCE.getDateTodayContainerOutlineColor()), ColorSchemeKt.fromToken(v0, DatePickerModalTokens.INSTANCE.getRangeSelectionActiveIndicatorContainerColor()), ColorSchemeKt.fromToken(v0, DatePickerModalTokens.INSTANCE.getSelectionDateInRangeLabelTextColor()), ColorSchemeKt.fromToken(v0, DividerTokens.INSTANCE.getColor()), OutlinedTextFieldDefaults.INSTANCE.getDefaultOutlinedTextFieldColors(v0, v1, v2 & 14 | 0x30), null);
            v0.setDefaultDatePickerColorsCached$material3(v4_1);
            v1.endReplaceGroup();
            v3 = v4_1;
        }
        else {
            v1.startReplaceGroup(642290457);
            v1.endReplaceGroup();
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v1);
        return v3;
    }

    public final Shape getShape(Composer arg3, int arg4) {
        int v0 = 700927667;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-shape>)770@36532L5:DatePicker.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.DatePickerDefaults.<get-shape> (DatePicker.kt:770)");
        }

        Shape v2 = ShapesKt.getValue(DatePickerModalTokens.INSTANCE.getContainerShape(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v2;
    }

    public final float getTonalElevation-D9Ej5fM() {
        return DatePickerDefaults.TonalElevation;
    }

    public final IntRange getYearRange() {
        return DatePickerDefaults.YearRange;
    }

    public final FlingBehavior rememberSnapFlingBehavior$material3(LazyListState arg6, DecayAnimationSpec arg7, Composer arg8, int arg9, int arg10) {
        int v0 = -2036003494;
        ComposerKt.sourceInformationMarkerStart(arg8, v0, "C(rememberSnapFlingBehavior)N(lazyListState,decayAnimationSpec)743@35490L7,744@35513L639:DatePicker.kt#uh7d8r");
        int v5 = 2;
        Object v1 = null;
        if((arg10 & v5) != 0) {
            arg7 = DecayAnimationSpecKt.exponentialDecay$default(0f, 0f, 3, v1);
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg9, -1, "androidx.compose.material3.DatePickerDefaults.rememberSnapFlingBehavior (DatePicker.kt:741)");
        }

        v0 = 6;
        FiniteAnimationSpec v10 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, arg8, v0);
        ComposerKt.sourceInformationMarkerStart(arg8, 1905742201, "CC(remember):DatePicker.kt#9igjgp");
        boolean v2 = arg8.changed(arg7);
        int v4 = 4;
        arg9 = (arg9 & 14 ^ v0) > v4 && (arg8.changed(arg6)) || (arg9 & v0) == v4 ? 1 : 0;
        Object v0_1 = arg8.rememberedValue();
        if((arg9 | (((int)v2))) != 0 || v0_1 == Composer.Companion.getEmpty()) {
            TargetedFlingBehavior v0_2 = SnapFlingBehaviorKt.snapFlingBehavior(new DatePickerDefaults$rememberSnapFlingBehavior$1$snapLayoutInfoProvider$1(LazyListSnapLayoutInfoProviderKt.SnapLayoutInfoProvider$default(arg6, ((SnapPosition)v1), v5, v1)), arg7, ((AnimationSpec)v10));
            arg8.updateRememberedValue(v0_2);
        }

        ComposerKt.sourceInformationMarkerEnd(arg8);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg8);
        return ((FlingBehavior)v0_1);
    }
}

