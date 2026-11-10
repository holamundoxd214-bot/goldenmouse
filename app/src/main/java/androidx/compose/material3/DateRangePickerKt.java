package androidx.compose.material3;

import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.material3.internal.CalendarDate;
import androidx.compose.material3.internal.CalendarModel;
import androidx.compose.material3.internal.CalendarModel_androidKt;
import androidx.compose.material3.internal.CalendarMonth;
import androidx.compose.material3.tokens.DatePickerModalTokens;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.CustomAccessibilityAction;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1={"\u0000Â\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001Aw\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\u0015\b\u0002\u0010\n\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000B¢\u0006\u0002\b\f2\u0015\b\u0002\u0010\r\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000B¢\u0006\u0002\b\f2\b\b\u0002\u0010\u000E\u001A\u00020\u000F2\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0002\u0010\u0012\u001AQ\u0010\u0013\u001A\u00020\u00032\n\b\u0002\u0010\u0014\u001A\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001A\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0017\u001A\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0018\u001A\u00020\u00192\b\b\u0002\u0010\u001A\u001A\u00020\u001B2\b\b\u0002\u0010\u001C\u001A\u00020\u001DH\u0007¢\u0006\u0004\b\u001E\u0010\u001F\u001A[\u0010 \u001A\u00020\u00032\n\u0010!\u001A\u00060\"j\u0002`#2\n\b\u0002\u0010\u0014\u001A\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001A\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0017\u001A\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0018\u001A\u00020\u00192\b\b\u0002\u0010\u001A\u001A\u00020\u001B2\b\b\u0002\u0010\u001C\u001A\u00020\u001D¢\u0006\u0004\b$\u0010%\u001AÄ\u0001\u0010&\u001A\u00020\u00012\b\u0010\'\u001A\u0004\u0018\u00010\u00152\b\u0010(\u001A\u0004\u0018\u00010\u00152\u0006\u0010)\u001A\u00020\u00152\u0006\u0010*\u001A\u00020\u001B2:\u0010+\u001A6\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\u00010,2!\u00101\u001A\u001D\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(3\u0012\u0004\u0012\u00020\u0001022\u0006\u00104\u001A\u0002052\u0006\u0010\u0018\u001A\u00020\u00192\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\u001C\u001A\u00020\u001D2\u0006\u0010\b\u001A\u00020\t2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0011H\u0003¢\u0006\u0004\b6\u00107\u001A°\u0001\u00108\u001A\u00020\u00012\b\u0010\'\u001A\u0004\u0018\u00010\u00152\b\u0010(\u001A\u0004\u0018\u00010\u00152\u0006\u0010)\u001A\u00020\u00152:\u0010+\u001A6\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\u00010,2!\u00101\u001A\u001D\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(3\u0012\u0004\u0012\u00020\u0001022\u0006\u00104\u001A\u0002052\u0006\u0010\u0018\u001A\u00020\u00192\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\u001C\u001A\u00020\u001D2\u0006\u0010\b\u001A\u00020\tH\u0003¢\u0006\u0002\u00109\u001A°\u0001\u0010:\u001A\u00020\u00012\u0006\u0010;\u001A\u00020<2\b\u0010\'\u001A\u0004\u0018\u00010\u00152\b\u0010(\u001A\u0004\u0018\u00010\u00152:\u0010+\u001A6\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\u00010,2!\u00101\u001A\u001D\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(3\u0012\u0004\u0012\u00020\u0001022\u0006\u00104\u001A\u0002052\u0006\u0010\u0018\u001A\u00020\u00192\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\u001C\u001A\u00020\u001D2\u0006\u0010\b\u001A\u00020\tH\u0003¢\u0006\u0002\u0010=\u001Ae\u0010>\u001A\u00020\u00012\u0006\u0010?\u001A\u00020\u00152\b\u0010@\u001A\u0004\u0018\u00010\u00152\b\u0010A\u001A\u0004\u0018\u00010\u00152:\u0010+\u001A6\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\u00010,H\u0002¢\u0006\u0002\u0010B\u001A#\u0010G\u001A\u00020\u0001*\u00020H2\u0006\u0010I\u001A\u00020J2\u0006\u0010K\u001A\u00020LH\u0000¢\u0006\u0004\bM\u0010N\u001A.\u0010O\u001A\b\u0012\u0004\u0012\u00020Q0P2\u0006\u0010\u0002\u001A\u00020<2\u0006\u0010R\u001A\u00020S2\u0006\u0010T\u001A\u00020U2\u0006\u0010V\u001A\u00020UH\u0002\"\u0014\u0010C\u001A\u00020DX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\bE\u0010F\"\u000E\u0010W\u001A\u00020DX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010X\u001A\u00020DX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010Y\u001A\u00020ZX\u0082\u0004¢\u0006\u0004\n\u0002\u0010[¨\u0006\\"}, d2={"DateRangePicker", "", "state", "Landroidx/compose/material3/DateRangePickerState;", "modifier", "Landroidx/compose/ui/Modifier;", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "colors", "Landroidx/compose/material3/DatePickerColors;", "title", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "headline", "showModeToggle", "", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "(Landroidx/compose/material3/DateRangePickerState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/DatePickerColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/focus/FocusRequester;Landroidx/compose/runtime/Composer;II)V", "rememberDateRangePickerState", "initialSelectedStartDateMillis", "", "initialSelectedEndDateMillis", "initialDisplayedMonthMillis", "yearRange", "Lkotlin/ranges/IntRange;", "initialDisplayMode", "Landroidx/compose/material3/DisplayMode;", "selectableDates", "Landroidx/compose/material3/SelectableDates;", "rememberDateRangePickerState-IlFM19s", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Lkotlin/ranges/IntRange;ILandroidx/compose/material3/SelectableDates;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/DateRangePickerState;", "DateRangePickerState", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "DateRangePickerState-HVP43zI", "(Ljava/util/Locale;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Lkotlin/ranges/IntRange;ILandroidx/compose/material3/SelectableDates;)Landroidx/compose/material3/DateRangePickerState;", "SwitchableDateEntryContent", "selectedStartDateMillis", "selectedEndDateMillis", "displayedMonthMillis", "displayMode", "onDatesSelectionChange", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "startDateMillis", "endDateMillis", "onDisplayedMonthChange", "Lkotlin/Function1;", "monthInMillis", "calendarModel", "Landroidx/compose/material3/internal/CalendarModel;", "SwitchableDateEntryContent-eVtQiho", "(Ljava/lang/Long;Ljava/lang/Long;JILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/internal/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/ui/focus/FocusRequester;Landroidx/compose/runtime/Composer;II)V", "DateRangePickerContent", "(Ljava/lang/Long;Ljava/lang/Long;JLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/internal/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "VerticalMonthsList", "lazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "(Landroidx/compose/foundation/lazy/LazyListState;Ljava/lang/Long;Ljava/lang/Long;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/internal/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "updateDateSelection", "dateInMillis", "currentStartDateMillis", "currentEndDateMillis", "(JLjava/lang/Long;Ljava/lang/Long;Lkotlin/jvm/functions/Function2;)V", "CalendarMonthSubheadPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getCalendarMonthSubheadPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "drawRangeBackground", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "selectedRangeInfo", "Landroidx/compose/material3/SelectedRangeInfo;", "color", "Landroidx/compose/ui/graphics/Color;", "drawRangeBackground-mxwnekA", "(Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;Landroidx/compose/material3/SelectedRangeInfo;J)V", "customScrollActions", "", "Landroidx/compose/ui/semantics/CustomAccessibilityAction;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "scrollUpLabel", "", "scrollDownLabel", "DateRangePickerTitlePadding", "DateRangePickerHeadlinePadding", "HeaderHeightOffset", "Landroidx/compose/ui/unit/Dp;", "F", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class DateRangePickerKt {
    private static final PaddingValues CalendarMonthSubheadPadding;
    private static final PaddingValues DateRangePickerHeadlinePadding;
    private static final PaddingValues DateRangePickerTitlePadding;
    private static final float HeaderHeightOffset;

    static {
        DateRangePickerKt.CalendarMonthSubheadPadding = PaddingKt.PaddingValues-a9UjIt4$default(Dp.constructor-impl(24f), Dp.constructor-impl(20f), 0f, Dp.constructor-impl(8f), 4, null);
        DateRangePickerKt.DateRangePickerTitlePadding = PaddingKt.PaddingValues-a9UjIt4$default(Dp.constructor-impl(64f), 0f, Dp.constructor-impl(12f), 0f, 10, null);
        DateRangePickerKt.DateRangePickerHeadlinePadding = PaddingKt.PaddingValues-a9UjIt4$default(Dp.constructor-impl(64f), 0f, Dp.constructor-impl(12f), Dp.constructor-impl(12f), 2, null);
        DateRangePickerKt.HeaderHeightOffset = Dp.constructor-impl(60f);
    }

    public static final void DateRangePicker(DateRangePickerState arg27, Modifier arg28, DatePickerFormatter arg29, DatePickerColors arg30, Function2 arg31, Function2 arg32, boolean arg33, FocusRequester arg34, Composer arg35, int arg36, int arg37) {
        DatePickerColors v4_4;
        Function2 v5_4;
        Modifier v2_6;
        FocusRequester v8_1;
        DatePickerFormatter v3_1;
        Composer v19;
        ComposableLambda v2_4;
        DatePickerFormatter v31;
        DatePickerColors v15_2;
        boolean v4_1;
        int v6_1;
        Modifier v11_1;
        Function2 v12_1;
        FocusRequester v5_1;
        FocusRequester v4_3;
        ComposableLambda v13_2;
        ComposableLambda v11_2;
        int v28;
        DatePickerColors v5_2;
        Object v0_3;
        boolean v15_1;
        int v14;
        Function2 v13_1;
        int v12;
        Function2 v11;
        int v8;
        DatePickerColors v7_2;
        boolean v7_1;
        int v7;
        Modifier v6;
        int v4;
        DateRangePickerState v1 = arg27;
        DatePickerFormatter v0 = arg29;
        int v9 = arg36;
        int v10 = arg37;
        Composer v3 = arg35.startRestartGroup(0x7567A3A0);
        ComposerKt.sourceInformation(v3, "C(DateRangePicker)N(state,modifier,dateFormatter,colors,title,headline,showModeToggle,focusRequester)125@5861L207,149@6756L5,153@6912L1186,132@6073L2025:DateRangePicker.kt#uh7d8r");
        if((v10 & 1) != 0) {
            v4 = v9 | 6;
        }
        else if((v9 & 6) == 0) {
            v4 = v3.changed(v1) ? 4 : 2;
            v4 |= v9;
        }
        else {
            v4 = v9;
        }

        int v5 = v10 & 2;
        if(v5 != 0) {
            v4 |= 0x30;
            goto label_37;
        }
        else if((v9 & 0x30) == 0) {
            v6 = arg28;
            v7 = v3.changed(v6) ? 0x20 : 16;
            v4 |= v7;
        }
        else {
        label_37:
            v6 = arg28;
        }

        if((v9 & 0x180) == 0) {
            if((v10 & 4) == 0) {
                v7_1 = (v9 & 0x200) == 0 ? v3.changed(v0) : v3.changedInstance(v0);
                if(!v7_1) {
                    goto label_50;
                }

                v7 = 0x100;
            }
            else {
            label_50:
                v7 = 0x80;
            }

            v4 |= v7;
        }

        if((v9 & 0xC00) == 0) {
            if((v10 & 8) == 0) {
                v7_2 = arg30;
                if(v3.changed(v7_2)) {
                    v8 = 0x800;
                }
                else {
                    goto label_62;
                }
            }
            else {
                v7_2 = arg30;
            label_62:
                v8 = 0x400;
            }

            v4 |= v8;
        }
        else {
            v7_2 = arg30;
        }

        v8 = v10 & 16;
        if(v8 != 0) {
            v4 |= 0x6000;
            goto label_80;
        }
        else if((v9 & 0x6000) == 0) {
            v11 = arg31;
            v12 = v3.changedInstance(v11) ? 0x4000 : 0x2000;
            v4 |= v12;
        }
        else {
        label_80:
            v11 = arg31;
        }

        v12 = v10 & 0x20;
        int v13 = 0x30000;
        if(v12 != 0) {
            v4 |= v13;
            goto label_96;
        }
        else if((v13 & v9) == 0) {
            v13_1 = arg32;
            v14 = v3.changedInstance(v13_1) ? 0x20000 : 0x10000;
            v4 |= v14;
        }
        else {
        label_96:
            v13_1 = arg32;
        }

        v14 = v10 & 0x40;
        int v15 = 0x180000;
        if(v14 != 0) {
            v4 |= v15;
            goto label_112;
        }
        else if((v15 & v9) == 0) {
            v15_1 = arg33;
            int v16 = v3.changed(v15_1) ? 0x100000 : 0x80000;
            v4 |= v16;
        }
        else {
        label_112:
            v15_1 = arg33;
        }

        int v2 = v10 & 0x80;
        int v17 = 0xC00000;
        if(v2 != 0) {
            v4 |= v17;
        }
        else {
            FocusRequester v0_1 = arg34;
            if((v9 & v17) == 0) {
                v17 = v3.changed(v0_1) ? 0x800000 : 0x400000;
                v4 |= v17;
            }
        }

        v17 = v2;
        int v35 = v5;
        boolean v0_2 = (v4 & 0x492493) != 4793490 ? true : false;
        if(v3.shouldExecute(v0_2, v4 & 1)) {
            v3.startDefaults();
            ComposerKt.sourceInformation(v3, "102@4878L47,103@4977L8,104@5026L239,111@5309L409,122@5794L29");
            String v2_1 = "CC(remember):DateRangePicker.kt#9igjgp";
            if((v9 & 1) == 0 || (v3.getDefaultsInvalid())) {
                if(v35 != 0) {
                    Companion v6_2 = Modifier.Companion;
                }

                if((v10 & 4) != 0) {
                    ComposerKt.sourceInformationMarkerStart(v3, 0xBA0D4D8F, v2_1);
                    v0_3 = v3.rememberedValue();
                    if(v0_3 == Composer.Companion.getEmpty()) {
                        v0 = DatePickerDefaults.dateFormatter$default(DatePickerDefaults.INSTANCE, null, null, null, 7, null);
                        v3.updateRememberedValue(v0);
                    }

                    ComposerKt.sourceInformationMarkerEnd(v3);
                    v4 &= -897;
                }
                else {
                    v0 = arg29;
                }

                if((v10 & 8) != 0) {
                    v5_2 = DatePickerDefaults.INSTANCE.colors(v3, 6);
                    v4 &= 0xFFFFE3FF;
                }
                else {
                    v5_2 = v7_2;
                }

                if(v8 != 0) {
                    v28 = v4;
                    v4_1 = true;
                    v11_2 = ComposableLambdaKt.rememberComposableLambda(0xD02302AC, true, new DateRangePickerKt$DateRangePicker$2(v1, v5_2), v3, 54);
                    v7 = 54;
                }
                else {
                    v28 = v4;
                    v4_1 = true;
                    v7 = 54;
                }

                if(v12 != 0) {
                    v13_2 = ComposableLambdaKt.rememberComposableLambda(0xEC3F7642, v4_1, new DateRangePickerKt$DateRangePicker$3(v1, ((DatePickerFormatter)v0_3), v5_2), v3, v7);
                }

                if(v14 != 0) {
                    v15_1 = true;
                }

                if(v17 != 0) {
                    ComposerKt.sourceInformationMarkerStart(v3, 0xBA0DBFFD, v2_1);
                    Object v4_2 = v3.rememberedValue();
                    if(v4_2 == Composer.Companion.getEmpty()) {
                        v4_3 = new FocusRequester();
                        v3.updateRememberedValue(v4_3);
                    }

                    ComposerKt.sourceInformationMarkerEnd(v3);
                    DatePickerColors v12_2 = v5_2;
                    Object v5_3 = v4_3;
                    v4_1 = v15_1;
                    v15_2 = v12_2;
                    v12_1 = ((Function2)v11_2);
                    v11_1 = v6;
                    v6_1 = v28;
                    goto label_244;
                }

                v12_1 = ((Function2)v11_2);
                v4_1 = v15_1;
                v15_2 = v5_2;
                v11_1 = v6;
                v6_1 = v28;
                v5_1 = arg34;
            }
            else {
                v3.skipToGroupEnd();
                if((v10 & 4) != 0) {
                    v4 &= -897;
                }

                if((v10 & 8) != 0) {
                    v4 &= 0xFFFFE3FF;
                }

                v0 = arg29;
                v5_1 = arg34;
                v12_1 = v11;
                v11_1 = v6;
                v6_1 = v4;
                v4_1 = v15_1;
                v15_2 = v7_2;
            }

        label_244:
            v3.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x7567A3A0, v6_1, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:123)");
            }

            Locale v7_3 = v1.getLocale();
            ComposerKt.sourceInformationMarkerStart(v3, 0xBA0DC90F, v2_1);
            boolean v2_2 = v3.changed(v7_3);
            Object v7_4 = v3.rememberedValue();
            if((v2_2) || v7_4 == Composer.Companion.getEmpty()) {
                CalendarModel v2_3 = (v1 instanceof BaseDatePickerStateImpl) ? v1.getCalendarModel() : CalendarModel_androidKt.createCalendarModel(v1.getLocale());
                CalendarModel v7_5 = v2_3;
                v3.updateRememberedValue(v7_5);
            }

            ComposerKt.sourceInformationMarkerEnd(v3);
            if(v4_1) {
                v3.startReplaceGroup(-2018438858);
                ComposerKt.sourceInformation(v3, "138@6251L364");
                v31 = ((DatePickerFormatter)v0_3);
                v2_4 = ComposableLambdaKt.rememberComposableLambda(0x50102AB2, true, new DateRangePickerKt$DateRangePicker$5(v1, v15_2), v3, 54);
                v3.endReplaceGroup();
            }
            else {
                v31 = ((DatePickerFormatter)v0_3);
                v3.startReplaceGroup(-2018051234);
                v3.endReplaceGroup();
                v2_4 = null;
            }

            ComposableLambda v14_1 = v2_4;
            TextStyle v16_1 = TypographyKt.getValue(DatePickerModalTokens.INSTANCE.getRangeSelectionHeaderHeadlineFont(), v3, 6);
            float v17_1 = Dp.constructor-impl(DatePickerModalTokens.INSTANCE.getRangeSelectionHeaderContainerHeight-D9Ej5fM() - DateRangePickerKt.HeaderHeightOffset);
            DateRangePickerKt$DateRangePicker$6 v0_4 = new DateRangePickerKt$DateRangePicker$6(v1, v7_4, v31, v15_2, v5_1);
            DatePickerFormatter v1_1 = v31;
            FocusRequester v2_5 = v5_1;
            v5 = v6_1 >> 9;
            v19 = v3;
            DatePickerKt.DateEntryContainer-au3_HiA(v11_1, v12_1, ((Function2)v13_2), ((Function2)v14_1), v15_2, v16_1, v17_1, ComposableLambdaKt.rememberComposableLambda(684885105, true, v0_4, v3, 54), v19, v6_1 >> 3 & 14 | 0xD80000 | v5 & 0x70 | v5 & 0x380 | 0xE000 & v6_1 << 3);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v3_1 = v1_1;
            v8_1 = v2_5;
            v7_1 = v4_1;
            v2_6 = v11_1;
            v5_4 = v12_1;
            v4_4 = v15_2;
        }
        else {
            v19 = v3;
            v19.skipToGroupEnd();
            v3_1 = arg29;
            v8_1 = arg34;
            v2_6 = v6;
            v4_4 = v7_2;
            v5_4 = v11;
            v7_1 = v15_1;
        }

        Function2 v6_3 = ((Function2)v13_2);
        ScopeUpdateScope v11_3 = v19.endRestartGroup();
        if(v11_3 != null) {
            v11_3.updateScope(new DateRangePickerKt$$ExternalSyntheticLambda7(arg27, v2_6, v3_1, v4_4, v5_4, v6_3, v7_1, v8_1, v9, v10));
        }
    }

    static final Unit DateRangePicker$lambda$3(DateRangePickerState arg12, Modifier arg13, DatePickerFormatter arg14, DatePickerColors arg15, Function2 arg16, Function2 arg17, boolean arg18, FocusRequester arg19, int arg20, int arg21, Composer arg22, int arg23) {
        DateRangePickerKt.DateRangePicker(arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg22, RecomposeScopeImplKt.updateChangedFlags(arg20 | 1), arg21);
        return Unit.INSTANCE;
    }

    private static final void DateRangePickerContent(Long arg17, Long arg18, long arg19, Function2 arg21, Function1 arg22, CalendarModel arg23, IntRange arg24, DatePickerFormatter arg25, SelectableDates arg26, DatePickerColors arg27, Composer arg28, int arg29) {
        Object v0_1;
        Continuation v5_1;
        int v16;
        SelectableDates v14_2;
        int v14;
        Function1 v13_1;
        Function2 v12_1;
        int v12;
        Long v10;
        int v2;
        long v3 = arg19;
        CalendarModel v7 = arg23;
        IntRange v8 = arg24;
        DatePickerFormatter v9 = arg25;
        DatePickerColors v11 = arg27;
        int v0 = arg29;
        Composer v15 = arg28.startRestartGroup(-787063721);
        ComposerKt.sourceInformation(v15, "C(DateRangePickerContent)N(selectedStartDateMillis,selectedEndDateMillis,displayedMonthMillis,onDatesSelectionChange,onDisplayedMonthChange,calendarModel,yearRange,dateFormatter,selectableDates,colors)767@34501L64,770@34655L309,770@34628L336,778@34970L649:DateRangePicker.kt#uh7d8r");
        Long v6 = arg17;
        if((v0 & 6) == 0) {
            v2 = v15.changed(v6) ? 4 : 2;
            v2 |= v0;
        }
        else {
            v2 = v0;
        }

        if((v0 & 0x30) == 0) {
            v10 = arg18;
            v12 = v15.changed(v10) ? 0x20 : 16;
            v2 |= v12;
        }
        else {
            v10 = arg18;
        }

        if((v0 & 0x180) == 0) {
            v12 = v15.changed(v3) ? 0x100 : 0x80;
            v2 |= v12;
        }

        if((v0 & 0xC00) == 0) {
            v12_1 = arg21;
            int v13 = v15.changedInstance(v12_1) ? 0x800 : 0x400;
            v2 |= v13;
        }
        else {
            v12_1 = arg21;
        }

        if((v0 & 0x6000) == 0) {
            v13_1 = arg22;
            v14 = v15.changedInstance(v13_1) ? 0x4000 : 0x2000;
            v2 |= v14;
        }
        else {
            v13_1 = arg22;
        }

        if((0x30000 & v0) == 0) {
            v14 = v15.changedInstance(v7) ? 0x20000 : 0x10000;
            v2 |= v14;
        }

        if((0x180000 & v0) == 0) {
            v14 = v15.changedInstance(v8) ? 0x100000 : 0x80000;
            v2 |= v14;
        }

        if((0xC00000 & v0) == 0) {
            boolean v14_1 = (0x1000000 & v0) == 0 ? v15.changed(v9) : v15.changedInstance(v9);
            v14 = v14_1 ? 0x800000 : 0x400000;
            v2 |= v14;
        }

        if((0x6000000 & v0) == 0) {
            v14_2 = arg26;
            v16 = v15.changed(v14_2) ? 0x4000000 : 0x2000000;
            v2 |= v16;
        }
        else {
            v14_2 = arg26;
        }

        if((v0 & 0x30000000) == 0) {
            v16 = v15.changed(v11) ? 0x20000000 : 0x10000000;
            v2 |= v16;
        }

        boolean v1 = (v2 & 306783379) != 306783378 ? true : false;
        if(v15.shouldExecute(v1, v2 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-787063721, v2, -1, "androidx.compose.material3.DateRangePickerContent (DateRangePicker.kt:764)");
            }

            v0 = RangesKt.coerceAtLeast(v7.getMonth(v3).indexIn(v8), 0);
            LazyListState v3_1 = LazyListStateKt.rememberLazyListState(v0, 0, v15, 0, 2);
            Integer v1_1 = Integer.valueOf(v0);
            ComposerKt.sourceInformationMarkerStart(v15, 0xE4F10B0C, "CC(remember):DateRangePicker.kt#9igjgp");
            int v4 = v15.changed(v3_1) | v15.changed(v0);
            Object v5 = v15.rememberedValue();
            if(v4 != 0 || v5 == Composer.Companion.getEmpty()) {
                v5_1 = null;
                DateRangePickerKt$DateRangePickerContent$1$1 v0_2 = new DateRangePickerKt$DateRangePickerContent$1$1(v3_1, v0, v5_1);
                v15.updateRememberedValue(v0_2);
            }
            else {
                v0_1 = v5;
                v5 = null;
            }

            ComposerKt.sourceInformationMarkerEnd(v15);
            EffectsKt.LaunchedEffect(v1_1, ((Function2)v0_1), v15, 0);
            LazyListState v16_1 = v3_1;
            Modifier v0_3 = PaddingKt.padding-VpY3zN4$default(Modifier.Companion, DatePickerKt.getDatePickerHorizontalPadding(), 0f, 2, v5_1);
            ComposerKt.sourceInformationMarkerStart(v15, 0xE32F0E82, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy v1_2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), v15, 0);
            ComposerKt.sourceInformationMarkerStart(v15, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int v3_2 = ComposablesKt.getCurrentCompositeKeyHash(v15, 0);
            CompositionLocalMap v4_1 = v15.getCurrentCompositionLocalMap();
            v0_3 = ComposedModifierKt.materializeModifier(v15, v0_3);
            Function0 v5_2 = ComposeUiNode.Companion.getConstructor();
            int v28 = v3_2;
            ComposerKt.sourceInformationMarkerStart(v15, 0xD6BD0031, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if(!(v15.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v15.startReusableNode();
            if(v15.getInserting()) {
                v15.createNode(v5_2);
            }
            else {
                v15.useNode();
            }

            Composer v3_3 = Updater.constructor-impl(v15);
            Updater.set-impl(v3_3, v1_2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v3_3, v4_1, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v1_3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v3_3.getInserting()) || !Intrinsics.areEqual(v3_3.rememberedValue(), Integer.valueOf(v28))) {
                v3_3.updateRememberedValue(Integer.valueOf(v28));
                v3_3.apply(Integer.valueOf(v28), v1_3);
            }

            Updater.set-impl(v3_3, v0_3, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v15, 0xE9125B67, "C89@4556L9:Column.kt#2w3rfo");
            ComposerKt.sourceInformationMarkerStart(v15, 0x729ABE0B, "C779@35058L31,780@35098L515:DateRangePicker.kt#uh7d8r");
            DatePickerKt.WeekDays(v11, v7, v15, v2 >> 27 & 14 | v2 >> 12 & 0x70);
            DateRangePickerKt.VerticalMonthsList(v16_1, arg17, v10, v12_1, v13_1, v7, v8, v9, v14_2, v11, v15, v2 << 3 & 0x3F0 | v2 & 0x1C00 | 0xE000 & v2 | 0x70000 & v2 | 0x380000 & v2 | 0x1C00000 & v2 | 0xE000000 & v2 | 0x70000000 & v2);
            ComposerKt.sourceInformationMarkerEnd(v15);
            ComposerKt.sourceInformationMarkerEnd(v15);
            v15.endNode();
            ComposerKt.sourceInformationMarkerEnd(v15);
            ComposerKt.sourceInformationMarkerEnd(v15);
            ComposerKt.sourceInformationMarkerEnd(v15);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_282;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v15.skipToGroupEnd();
        }

    label_282:
        ScopeUpdateScope v13_2 = v15.endRestartGroup();
        if(v13_2 != null) {
            v13_2.updateScope(new DateRangePickerKt$$ExternalSyntheticLambda5(arg17, arg18, arg19, arg21, arg22, arg23, arg24, arg25, arg26, arg27, arg29));
        }
    }

    static final Unit DateRangePickerContent$lambda$12(Long arg14, Long arg15, long arg16, Function2 arg18, Function1 arg19, CalendarModel arg20, IntRange arg21, DatePickerFormatter arg22, SelectableDates arg23, DatePickerColors arg24, int arg25, Composer arg26, int arg27) {
        DateRangePickerKt.DateRangePickerContent(arg14, arg15, arg16, arg18, arg19, arg20, arg21, arg22, arg23, arg24, arg26, RecomposeScopeImplKt.updateChangedFlags(arg25 | 1));
        return Unit.INSTANCE;
    }

    public static final DateRangePickerState DateRangePickerState-HVP43zI(Locale arg9, Long arg10, Long arg11, Long arg12, IntRange arg13, int arg14, SelectableDates arg15) {
        return new DateRangePickerStateImpl(arg10, arg11, arg12, arg13, arg14, arg15, arg9, null);
    }

    public static DateRangePickerState DateRangePickerState-HVP43zI$default(Locale arg1, Long arg2, Long arg3, Long arg4, IntRange arg5, int arg6, SelectableDates arg7, int arg8, Object arg9) {
        Long v0 = null;
        if((arg8 & 2) != 0) {
            arg2 = v0;
        }

        if((arg8 & 4) != 0) {
            arg3 = v0;
        }

        if((arg8 & 8) != 0) {
            arg4 = arg2;
        }

        if((arg8 & 16) != 0) {
            arg5 = DatePickerDefaults.INSTANCE.getYearRange();
        }

        if((arg8 & 0x20) != 0) {
            arg6 = DisplayMode.Companion.getPicker-jFl-4v0();
        }

        if((arg8 & 0x40) != 0) {
            arg7 = DatePickerDefaults.INSTANCE.getAllDates();
        }

        return DateRangePickerKt.DateRangePickerState-HVP43zI(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    private static final void SwitchableDateEntryContent-eVtQiho(Long arg22, Long arg23, long arg24, int arg26, Function2 arg27, Function1 arg28, CalendarModel arg29, IntRange arg30, DatePickerFormatter arg31, SelectableDates arg32, DatePickerColors arg33, FocusRequester arg34, Composer arg35, int arg36, int arg37) {
        Composer v6_1;
        DateRangePickerKt$$ExternalSyntheticLambda0 v1_2;
        int v17;
        int v16;
        Function1 v12_1;
        Function2 v8_1;
        int v8;
        Long v5;
        int v4;
        DatePickerFormatter v9 = arg31;
        int v14 = arg36;
        Composer v13 = arg35.startRestartGroup(621028059);
        ComposerKt.sourceInformation(v13, "C(SwitchableDateEntryContent)N(selectedStartDateMillis,selectedEndDateMillis,displayedMonthMillis,displayMode:c#material3.DisplayMode,onDatesSelectionChange,onDisplayedMonthChange,calendarModel,yearRange,dateFormatter,selectableDates,colors,focusRequester)714@32363L7,716@32422L91,720@32521L1304,712@32259L1566:DateRangePicker.kt#uh7d8r");
        if((v14 & 6) == 0) {
            v4 = v13.changed(arg22) ? 4 : 2;
            v4 |= v14;
        }
        else {
            v4 = v14;
        }

        if((v14 & 0x30) == 0) {
            v5 = arg23;
            v8 = v13.changed(v5) ? 0x20 : 16;
            v4 |= v8;
        }
        else {
            v5 = arg23;
        }

        long v10 = arg24;
        if((v14 & 0x180) == 0) {
            v8 = v13.changed(v10) ? 0x100 : 0x80;
            v4 |= v8;
        }

        int v15 = arg26;
        if((v14 & 0xC00) == 0) {
            v8 = v13.changed(v15) ? 0x800 : 0x400;
            v4 |= v8;
        }

        if((v14 & 0x6000) == 0) {
            v8_1 = arg27;
            int v12 = v13.changedInstance(v8_1) ? 0x4000 : 0x2000;
            v4 |= v12;
        }
        else {
            v8_1 = arg27;
        }

        if((0x30000 & v14) == 0) {
            v12_1 = arg28;
            v16 = v13.changedInstance(v12_1) ? 0x20000 : 0x10000;
            v4 |= v16;
        }
        else {
            v12_1 = arg28;
        }

        CalendarModel v2 = arg29;
        if((v14 & 0x180000) == 0) {
            v16 = v13.changedInstance(v2) ? 0x100000 : 0x80000;
            v4 |= v16;
        }

        IntRange v3 = arg30;
        if((v14 & 0xC00000) == 0) {
            v17 = v13.changedInstance(v3) ? 0x800000 : 0x400000;
            v4 |= v17;
        }

        if((v14 & 0x6000000) == 0) {
            boolean v17_1 = (v14 & 0x8000000) == 0 ? v13.changed(v9) : v13.changedInstance(v9);
            v17 = v17_1 ? 0x4000000 : 0x2000000;
            v4 |= v17;
        }

        SelectableDates v6 = arg32;
        if((v14 & 0x30000000) == 0) {
            int v18 = v13.changed(v6) ? 0x20000000 : 0x10000000;
            v4 |= v18;
        }

        DatePickerColors v7 = arg33;
        if((arg37 & 6) == 0) {
            v16 = v13.changed(v7) ? 4 : 2;
            v16 |= arg37;
        }
        else {
            v16 = arg37;
        }

        FocusRequester v0 = arg34;
        if((arg37 & 0x30) == 0) {
            v17 = v13.changed(v0) ? 0x20 : 16;
            v16 |= v17;
        }

        int v0_1 = v16;
        boolean v1 = (v4 & 306783379) != 306783378 || (v0_1 & 19) != 18 ? true : false;
        if(v13.shouldExecute(v1, v4 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(621028059, v4, v0_1, "androidx.compose.material3.SwitchableDateEntryContent (DateRangePicker.kt:708)");
            }

            FiniteAnimationSpec v16_1 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, v13, 6);
            Companion v0_2 = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart(v13, 0xF4875756, "CC(remember):DateRangePicker.kt#9igjgp");
            Object v1_1 = v13.rememberedValue();
            if(v1_1 == Composer.Companion.getEmpty()) {
                v1_2 = new DateRangePickerKt$$ExternalSyntheticLambda0();
                v13.updateRememberedValue(v1_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v13);
            v17 = v4;
            long v3_1 = v10;
            SelectableDates v10_1 = v6;
            v6_1 = v13;
            CrossfadeKt.Crossfade(DisplayMode.box-impl(v15), SemanticsModifierKt.semantics$default(((Modifier)v0_2), false, ((Function1)v1_2), 1, null), v16_1, null, ComposableLambdaKt.rememberComposableLambda(0xD1E051BF, true, new DateRangePickerKt$SwitchableDateEntryContent$2(arg22, v5, v3_1, v8_1, v12_1, arg29, arg30, v9, v10_1, v7, arg34), v13, 54), v6_1, v17 >> 9 & 14 | 0x6000, 8);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_209;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v6_1 = v13;
            v6_1.skipToGroupEnd();
        }

    label_209:
        ScopeUpdateScope v0_3 = v6_1.endRestartGroup();
        if(v0_3 != null) {
            v0_3.updateScope(new DateRangePickerKt$$ExternalSyntheticLambda1(arg22, arg23, arg24, v15, arg27, arg28, arg29, arg30, arg31, arg32, arg33, arg34, arg36, arg37));
        }
    }

    static final Unit SwitchableDateEntryContent_eVtQiho$lambda$8$lambda$7(SemanticsPropertyReceiver arg1) {
        SemanticsPropertiesKt.setContainer(arg1, true);
        return Unit.INSTANCE;
    }

    static final Unit SwitchableDateEntryContent_eVtQiho$lambda$9(Long arg17, Long arg18, long arg19, int arg21, Function2 arg22, Function1 arg23, CalendarModel arg24, IntRange arg25, DatePickerFormatter arg26, SelectableDates arg27, DatePickerColors arg28, FocusRequester arg29, int arg30, int arg31, Composer arg32, int arg33) {
        DateRangePickerKt.SwitchableDateEntryContent-eVtQiho(arg17, arg18, arg19, arg21, arg22, arg23, arg24, arg25, arg26, arg27, arg28, arg29, arg32, RecomposeScopeImplKt.updateChangedFlags(arg30 | 1), RecomposeScopeImplKt.updateChangedFlags(arg31));
        return Unit.INSTANCE;
    }

    private static final void VerticalMonthsList(LazyListState arg19, Long arg20, Long arg21, Function2 arg22, Function1 arg23, CalendarModel arg24, IntRange arg25, DatePickerFormatter arg26, SelectableDates arg27, DatePickerColors arg28, Composer arg29, int arg30) {
        DateRangePickerKt$VerticalMonthsList$2$1 v0_4;
        Object v0_1;
        CalendarMonth v0_2;
        int v10;
        Function2 v7_1;
        int v7;
        Long v5_1;
        Long v3;
        int v2;
        LazyListState v1 = arg19;
        CalendarModel v6 = arg24;
        IntRange v4 = arg25;
        DatePickerFormatter v8 = arg26;
        int v12 = arg30;
        Composer v13 = arg29.startRestartGroup(0x4AF1DE09);
        ComposerKt.sourceInformation(v13, "C(VerticalMonthsList)N(lazyListState,selectedStartDateMillis,selectedEndDateMillis,onDatesSelectionChange,onDisplayedMonthChange,calendarModel,yearRange,dateFormatter,selectableDates,colors)815@36348L159,821@36569L5,821@36576L3838,821@36512L3902,899@40449L229,899@40419L259:DateRangePicker.kt#uh7d8r");
        if((v12 & 6) == 0) {
            v2 = v13.changed(v1) ? 4 : 2;
            v2 |= v12;
        }
        else {
            v2 = v12;
        }

        if((v12 & 0x30) == 0) {
            v3 = arg20;
            int v5 = v13.changed(v3) ? 0x20 : 16;
            v2 |= v5;
        }
        else {
            v3 = arg20;
        }

        if((v12 & 0x180) == 0) {
            v5_1 = arg21;
            v7 = v13.changed(v5_1) ? 0x100 : 0x80;
            v2 |= v7;
        }
        else {
            v5_1 = arg21;
        }

        if((v12 & 0xC00) == 0) {
            v7_1 = arg22;
            int v9 = v13.changedInstance(v7_1) ? 0x800 : 0x400;
            v2 |= v9;
        }
        else {
            v7_1 = arg22;
        }

        if((v12 & 0x6000) == 0) {
            v10 = v13.changedInstance(arg23) ? 0x4000 : 0x2000;
            v2 |= v10;
        }

        if((0x30000 & v12) == 0) {
            v10 = v13.changedInstance(v6) ? 0x20000 : 0x10000;
            v2 |= v10;
        }

        if((0x180000 & v12) == 0) {
            v10 = v13.changedInstance(v4) ? 0x100000 : 0x80000;
            v2 |= v10;
        }

        if((0xC00000 & v12) == 0) {
            boolean v10_1 = (0x1000000 & v12) == 0 ? v13.changed(v8) : v13.changedInstance(v8);
            v10 = v10_1 ? 0x800000 : 0x400000;
            v2 |= v10;
        }

        SelectableDates v11 = arg27;
        if((0x6000000 & v12) == 0) {
            v10 = v13.changed(v11) ? 0x4000000 : 0x2000000;
            v2 |= v10;
        }

        if((0x30000000 & v12) == 0) {
            int v16 = v13.changed(arg28) ? 0x20000000 : 0x10000000;
            v2 |= v16;
        }

        int v17 = 0;
        boolean v14 = (v2 & 306783379) != 306783378 ? true : false;
        if(v13.shouldExecute(v14, v2 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x4AF1DE09, v2, -1, "androidx.compose.material3.VerticalMonthsList (DateRangePicker.kt:812)");
            }

            CalendarDate v10_2 = v6.getToday();
            String v14_1 = "CC(remember):DateRangePicker.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v13, 0x55F2C748, v14_1);
            boolean v0 = v13.changed(v4);
            Object v15 = v13.rememberedValue();
            if((v0) || v15 == Composer.Companion.getEmpty()) {
                v0_2 = v6.getMonth(v4.getFirst(), 1);
                v13.updateRememberedValue(v0_2);
            }
            else {
                v0_1 = v15;
            }

            ComposerKt.sourceInformationMarkerEnd(v13);
            IntRange v9_1 = v4;
            int v18 = v2;
            v4 = v9_1;
            TextKt.ProvideTextStyle(TypographyKt.getValue(DatePickerModalTokens.INSTANCE.getDateLabelTextFont(), v13, 6), ComposableLambdaKt.rememberComposableLambda(1090773432, true, new DateRangePickerKt$VerticalMonthsList$1(v3, v5_1, v7_1, v1, v9_1, v6, v0_2, v8, arg28, v10_2, v11), v13, 54), v13, 0x30);
            ComposerKt.sourceInformationMarkerStart(v13, 1442105390, v14_1);
            v7 = v18 & 14;
            int v0_3 = v7 == 4 ? 1 : 0;
            if((v18 & 0xE000) == 0x4000) {
                v17 = 1;
            }

            v0_3 = v0_3 | v17 | v13.changedInstance(v6) | v13.changedInstance(v4);
            Object v1_1 = v13.rememberedValue();
            if(v0_3 != 0 || v1_1 == Composer.Companion.getEmpty()) {
                v1 = arg19;
                v0_4 = new DateRangePickerKt$VerticalMonthsList$2$1(v1, arg23, v6, v4, null);
                v13.updateRememberedValue(v0_4);
            }
            else {
                v0_1 = v1_1;
                v1 = arg19;
            }

            ComposerKt.sourceInformationMarkerEnd(v13);
            EffectsKt.LaunchedEffect(v1, ((Function2)v0_4), v13, v7);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_218;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v13.skipToGroupEnd();
        }

    label_218:
        ScopeUpdateScope v12_1 = v13.endRestartGroup();
        if(v12_1 != null) {
            v12_1.updateScope(new DateRangePickerKt$$ExternalSyntheticLambda6(v1, arg20, arg21, arg22, arg23, arg24, arg25, arg26, arg27, arg28, arg30));
        }
    }

    static final Unit VerticalMonthsList$lambda$15(LazyListState arg13, Long arg14, Long arg15, Function2 arg16, Function1 arg17, CalendarModel arg18, IntRange arg19, DatePickerFormatter arg20, SelectableDates arg21, DatePickerColors arg22, int arg23, Composer arg24, int arg25) {
        DateRangePickerKt.VerticalMonthsList(arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg22, arg24, RecomposeScopeImplKt.updateChangedFlags(arg23 | 1));
        return Unit.INSTANCE;
    }

    public static final void access$DateRangePickerContent(Long arg0, Long arg1, long arg2, Function2 arg4, Function1 arg5, CalendarModel arg6, IntRange arg7, DatePickerFormatter arg8, SelectableDates arg9, DatePickerColors arg10, Composer arg11, int arg12) {
        DateRangePickerKt.DateRangePickerContent(arg0, arg1, arg2, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12);
    }

    public static final void access$SwitchableDateEntryContent-eVtQiho(Long arg0, Long arg1, long arg2, int arg4, Function2 arg5, Function1 arg6, CalendarModel arg7, IntRange arg8, DatePickerFormatter arg9, SelectableDates arg10, DatePickerColors arg11, FocusRequester arg12, Composer arg13, int arg14, int arg15) {
        DateRangePickerKt.SwitchableDateEntryContent-eVtQiho(arg0, arg1, arg2, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15);
    }

    public static final List access$customScrollActions(LazyListState arg0, CoroutineScope arg1, String arg2, String arg3) {
        return DateRangePickerKt.customScrollActions(arg0, arg1, arg2, arg3);
    }

    public static final PaddingValues access$getDateRangePickerHeadlinePadding$p() {
        return DateRangePickerKt.DateRangePickerHeadlinePadding;
    }

    public static final PaddingValues access$getDateRangePickerTitlePadding$p() {
        return DateRangePickerKt.DateRangePickerTitlePadding;
    }

    public static final void access$updateDateSelection(long arg0, Long arg2, Long arg3, Function2 arg4) {
        DateRangePickerKt.updateDateSelection(arg0, arg2, arg3, arg4);
    }

    private static final List customScrollActions(LazyListState arg2, CoroutineScope arg3, String arg4, String arg5) {
        return CollectionsKt.listOf(new CustomAccessibilityAction[]{new CustomAccessibilityAction(arg4, new DateRangePickerKt$$ExternalSyntheticLambda2(arg2, arg3)), new CustomAccessibilityAction(arg5, new DateRangePickerKt$$ExternalSyntheticLambda3(arg2, arg3))});
    }

    static final boolean customScrollActions$lambda$16(LazyListState arg8, CoroutineScope arg9) {
        if(!arg8.getCanScrollBackward()) {
            return 0;
        }

        BuildersKt.launch$default(arg9, null, null, new DateRangePickerKt$customScrollActions$scrollUpAction$1$1(arg8, null), 3, null);
        return 1;
    }

    static final boolean customScrollActions$lambda$17(LazyListState arg8, CoroutineScope arg9) {
        if(!arg8.getCanScrollForward()) {
            return 0;
        }

        BuildersKt.launch$default(arg9, null, null, new DateRangePickerKt$customScrollActions$scrollDownAction$1$1(arg8, null), 3, null);
        return 1;
    }

    public static final void drawRangeBackground-mxwnekA(ContentDrawScope arg31, SelectedRangeInfo arg32, long arg33) {
        ContentDrawScope v0 = arg31;
        float v1 = v0.toPx-0680j_4(DatePickerKt.getRecommendedSizeForAccessibility());
        float v2 = v0.toPx-0680j_4(DatePickerKt.getRecommendedSizeForAccessibility());
        float v3 = v0.toPx-0680j_4(DatePickerModalTokens.INSTANCE.getDateStateLayerHeight-D9Ej5fM());
        float v5 = 2f;
        float v4 = (v2 - v3) / v5;
        int v8 = 0x20;
        float v6 = (Float.intBitsToFloat(((int)(v0.getSize-NH-jbRc() >> v8))) - 7f * v1) / 7f;
        long v9 = arg32.getGridStartCoordinates-nOcc-ac();
        int v7 = IntOffset.getX-impl(v9);
        int v9_1 = IntOffset.getY-impl(v9);
        long v10 = arg32.getGridEndCoordinates-nOcc-ac();
        int v12 = IntOffset.getX-impl(v10);
        int v10_1 = IntOffset.getY-impl(v10);
        float v11 = v1 + v6;
        float v7_1 = (((float)v7)) * v11;
        float v13 = arg32.getFirstIsSelectionStart() ? v1 / v5 : 0f;
        v6 /= v5;
        v7_1 = v7_1 + v13 + v6;
        v13 = (((float)v9_1)) * v2 + v4;
        float v12_1 = (((float)v12)) * v11;
        if(arg32.getLastIsSelectionEnd()) {
            v1 /= v5;
        }

        v12_1 = v12_1 + v1 + v6;
        v1 = (((float)v10_1)) * v2 + v4;
        int v4_1 = v0.getLayoutDirection() == LayoutDirection.Rtl ? 1 : 0;
        if(v4_1 != 0) {
            v7_1 = Float.intBitsToFloat(((int)(v0.getSize-NH-jbRc() >> v8))) - v7_1;
            v12_1 = Float.intBitsToFloat(((int)(v0.getSize-NH-jbRc() >> v8))) - v12_1;
        }

        ContentDrawScope v16 = v0;
        long v29 = 0xFFFFFFFFL;
        long v18 = Offset.constructor-impl((((long)Float.floatToRawIntBits(v7_1))) << v8 | (((long)Float.floatToRawIntBits(v13))) & v29);
        if(v9_1 == v10_1) {
            v5 = v12_1 - v7_1;
        }
        else if(v4_1 != 0) {
            v5 = -v7_1;
        }
        else {
            v5 = Float.intBitsToFloat(((int)(v0.getSize-NH-jbRc() >> v8))) - v7_1;
        }

        ContentDrawScope v15 = v16;
        DrawScope.drawRect-n-J9OG0$default(((DrawScope)v15), arg33, v18, Size.constructor-impl((((long)Float.floatToRawIntBits(v5))) << v8 | (((long)Float.floatToRawIntBits(v3))) & v29), 0f, null, null, 0, 120, null);
        if(v9_1 != v10_1) {
            v10_1 = v10_1 - v9_1 - 1;
            while(v10_1 > 0) {
                DrawScope.drawRect-n-J9OG0$default(((DrawScope)v15), arg33, Offset.constructor-impl((((long)Float.floatToRawIntBits(0f))) << v8 | (((long)Float.floatToRawIntBits((((float)v10_1)) * v2 + v13))) & v29), Size.constructor-impl((((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v0.getSize-NH-jbRc() >> v8)))))) << v8 | (((long)Float.floatToRawIntBits(v3))) & v29), 0f, null, null, 0, 120, null);
                --v10_1;
                v8 = v8;
            }

            int v11_1 = v8;
            float v14 = v0.getLayoutDirection() == LayoutDirection.Ltr ? 0f : Float.intBitsToFloat(((int)(v0.getSize-NH-jbRc() >> v11_1)));
            v18 = Offset.constructor-impl((((long)Float.floatToRawIntBits(v1))) & v29 | (((long)Float.floatToRawIntBits(v14))) << v11_1);
            if(v4_1 != 0) {
                v12_1 -= Float.intBitsToFloat(((int)(v0.getSize-NH-jbRc() >> v11_1)));
            }

            DrawScope.drawRect-n-J9OG0$default(((DrawScope)v15), arg33, v18, Size.constructor-impl((((long)Float.floatToRawIntBits(v12_1))) << v11_1 | (((long)Float.floatToRawIntBits(v3))) & v29), 0f, null, null, 0, 120, null);
        }
    }

    public static final PaddingValues getCalendarMonthSubheadPadding() {
        return DateRangePickerKt.CalendarMonthSubheadPadding;
    }

    public static final DateRangePickerState rememberDateRangePickerState-IlFM19s(Long arg16, Long arg17, Long arg18, IntRange arg19, int arg20, SelectableDates arg21, Composer arg22, int arg23, int arg24) {
        Object v7;
        Composer v0 = arg22;
        int v1 = arg23;
        int v3 = -2012087461;
        ComposerKt.sourceInformationMarkerStart(v0, v3, "C(rememberDateRangePickerState)N(initialSelectedStartDateMillis,initialSelectedEndDateMillis,initialDisplayedMonthMillis,yearRange,initialDisplayMode:c#material3.DisplayMode,selectableDates)284@12718L15,285@12827L476,285@12745L558:DateRangePicker.kt#uh7d8r");
        Long v4 = null;
        Long v6 = (arg24 & 1) != 0 ? v4 : arg16;
        if((arg24 & 2) != 0) {
            v7 = v4;
        }
        else {
            Long v7_1 = arg17;
        }

        Long v8 = (arg24 & 4) != 0 ? v6 : arg18;
        IntRange v9 = (arg24 & 8) != 0 ? DatePickerDefaults.INSTANCE.getYearRange() : arg19;
        int v10 = (arg24 & 16) != 0 ? DisplayMode.Companion.getPicker-jFl-4v0() : arg20;
        int v2 = 0x20;
        SelectableDates v11 = (arg24 & 0x20) != 0 ? DatePickerDefaults.INSTANCE.getAllDates() : arg21;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v3, v1, -1, "androidx.compose.material3.rememberDateRangePickerState (DateRangePicker.kt:283)");
        }

        Locale v12 = CalendarLocale_androidKt.defaultLocale(v0, 0);
        Object[] v4_1 = new Object[0];
        Saver v13 = DateRangePickerStateImpl.Companion.Saver(v11, v12);
        ComposerKt.sourceInformationMarkerStart(v0, 0xCB80E057, "CC(remember):DateRangePicker.kt#9igjgp");
        int v14 = 4;
        int v15 = 1;
        int v5 = (v1 & 14 ^ 6) > v14 && (v0.changed(v6)) || (v1 & 6) == v14 ? 1 : 0;
        v2 = (v1 & 0x70 ^ 0x30) > v2 && (v0.changed(v7)) || (v1 & 0x30) == v2 ? 1 : 0;
        v2 |= v5;
        v14 = 0x100;
        v5 = (v1 & 0x380 ^ 0x180) > v14 && (v0.changed(v8)) || (v1 & 0x180) == v14 ? 1 : 0;
        v2 = v2 | v5 | v0.changedInstance(v9);
        v14 = 0x4000;
        v5 = (0xE000 & v1 ^ 0x6000) > v14 && (v0.changed(v10)) || (v1 & 0x6000) == v14 ? 1 : 0;
        v2 |= v5;
        int v16 = 0x30000;
        v14 = 0x20000;
        if((0x70000 & v1 ^ 0x30000) <= v14 || !v0.changed(v11)) {
            if((v1 & v16) == v14) {
            }
            else {
                v15 = 0;
            }
        }

        v1 = v2 | v15 | v0.changedInstance(v12);
        Object v2_1 = v0.rememberedValue();
        if(v1 != 0 || v2_1 == Composer.Companion.getEmpty()) {
            DateRangePickerKt$$ExternalSyntheticLambda4 v5_1 = new DateRangePickerKt$$ExternalSyntheticLambda4(v6, ((Long)v7), v8, v9, v10, v11, v12);
            v0.updateRememberedValue(v5_1);
            DateRangePickerKt$$ExternalSyntheticLambda4 v2_2 = v5_1;
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        Object v1_1 = RememberSaveableKt.rememberSaveable(v4_1, v13, ((Function0)v2_1), v0, 0);
        ((DateRangePickerStateImpl)v1_1).setSelectableDates(v11);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        return ((DateRangePickerState)v1_1);
    }

    static final DateRangePickerStateImpl rememberDateRangePickerState_IlFM19s$lambda$5$lambda$4(Long arg9, Long arg10, Long arg11, IntRange arg12, int arg13, SelectableDates arg14, Locale arg15) {
        return new DateRangePickerStateImpl(arg9, arg10, arg11, arg12, arg13, arg14, arg15, null);
    }

    private static final void updateDateSelection(long arg3, Long arg5, Long arg6, Function2 arg7) {
        Object v0 = null;
        if(arg5 == null && arg6 == null || arg5 != null && arg6 != null) {
            arg7.invoke(Long.valueOf(arg3), v0);
            return;
        }

        if(arg5 != null && arg3 >= arg5.longValue()) {
            arg7.invoke(arg5, Long.valueOf(arg3));
            return;
        }

        arg7.invoke(Long.valueOf(arg3), v0);
    }
}

