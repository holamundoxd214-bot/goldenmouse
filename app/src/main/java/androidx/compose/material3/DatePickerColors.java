package androidx.compose.material3;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001BÏ\u0001\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003\u0012\u0006\u0010\u0007\u001A\u00020\u0003\u0012\u0006\u0010\b\u001A\u00020\u0003\u0012\u0006\u0010\t\u001A\u00020\u0003\u0012\u0006\u0010\n\u001A\u00020\u0003\u0012\u0006\u0010\u000B\u001A\u00020\u0003\u0012\u0006\u0010\f\u001A\u00020\u0003\u0012\u0006\u0010\r\u001A\u00020\u0003\u0012\u0006\u0010\u000E\u001A\u00020\u0003\u0012\u0006\u0010\u000F\u001A\u00020\u0003\u0012\u0006\u0010\u0010\u001A\u00020\u0003\u0012\u0006\u0010\u0011\u001A\u00020\u0003\u0012\u0006\u0010\u0012\u001A\u00020\u0003\u0012\u0006\u0010\u0013\u001A\u00020\u0003\u0012\u0006\u0010\u0014\u001A\u00020\u0003\u0012\u0006\u0010\u0015\u001A\u00020\u0003\u0012\u0006\u0010\u0016\u001A\u00020\u0003\u0012\u0006\u0010\u0017\u001A\u00020\u0003\u0012\u0006\u0010\u0018\u001A\u00020\u0003\u0012\u0006\u0010\u0019\u001A\u00020\u0003\u0012\u0006\u0010\u001A\u001A\u00020\u0003\u0012\u0006\u0010\u001B\u001A\u00020\u001C¢\u0006\u0004\b\u001D\u0010\u001EJ\u0089\u0002\u0010;\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u00032\b\b\u0002\u0010\u0007\u001A\u00020\u00032\b\b\u0002\u0010\b\u001A\u00020\u00032\b\b\u0002\u0010\t\u001A\u00020\u00032\b\b\u0002\u0010\n\u001A\u00020\u00032\b\b\u0002\u0010\u000B\u001A\u00020\u00032\b\b\u0002\u0010\f\u001A\u00020\u00032\b\b\u0002\u0010\r\u001A\u00020\u00032\b\b\u0002\u0010\u000E\u001A\u00020\u00032\b\b\u0002\u0010\u000F\u001A\u00020\u00032\b\b\u0002\u0010\u0010\u001A\u00020\u00032\b\b\u0002\u0010\u0011\u001A\u00020\u00032\b\b\u0002\u0010\u0012\u001A\u00020\u00032\b\b\u0002\u0010\u0013\u001A\u00020\u00032\b\b\u0002\u0010\u0014\u001A\u00020\u00032\b\b\u0002\u0010\u0015\u001A\u00020\u00032\b\b\u0002\u0010\u0016\u001A\u00020\u00032\b\b\u0002\u0010\u0017\u001A\u00020\u00032\b\b\u0002\u0010\u0018\u001A\u00020\u00032\b\b\u0002\u0010\u0019\u001A\u00020\u00032\b\b\u0002\u0010\u001A\u001A\u00020\u00032\n\b\u0002\u0010\u001B\u001A\u0004\u0018\u00010\u001C¢\u0006\u0004\b<\u0010=J!\u0010>\u001A\u00020\u001C*\u0004\u0018\u00010\u001C2\f\u0010?\u001A\b\u0012\u0004\u0012\u00020\u001C0@H\u0000¢\u0006\u0002\bAJ5\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u00030B2\u0006\u0010C\u001A\u00020D2\u0006\u0010E\u001A\u00020D2\u0006\u0010F\u001A\u00020D2\u0006\u0010G\u001A\u00020DH\u0001¢\u0006\u0004\bH\u0010IJ-\u0010J\u001A\b\u0012\u0004\u0012\u00020\u00030B2\u0006\u0010E\u001A\u00020D2\u0006\u0010G\u001A\u00020D2\u0006\u0010K\u001A\u00020DH\u0001¢\u0006\u0004\bL\u0010MJ-\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u00030B2\u0006\u0010N\u001A\u00020D2\u0006\u0010E\u001A\u00020D2\u0006\u0010G\u001A\u00020DH\u0001¢\u0006\u0004\bO\u0010MJ%\u0010P\u001A\b\u0012\u0004\u0012\u00020\u00030B2\u0006\u0010E\u001A\u00020D2\u0006\u0010G\u001A\u00020DH\u0001¢\u0006\u0004\bQ\u0010RJ\u0013\u0010S\u001A\u00020D2\b\u0010T\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010U\u001A\u00020VH\u0016R\u0013\u0010\u0002\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010!\u001A\u0004\b\u001F\u0010 R\u0013\u0010\u0004\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010!\u001A\u0004\b\"\u0010 R\u0013\u0010\u0005\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010!\u001A\u0004\b#\u0010 R\u0013\u0010\u0006\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010!\u001A\u0004\b$\u0010 R\u0013\u0010\u0007\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010!\u001A\u0004\b%\u0010 R\u0013\u0010\b\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010!\u001A\u0004\b&\u0010 R\u0013\u0010\t\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010!\u001A\u0004\b\'\u0010 R\u0013\u0010\n\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010!\u001A\u0004\b(\u0010 R\u0013\u0010\u000B\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010!\u001A\u0004\b)\u0010 R\u0013\u0010\f\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010!\u001A\u0004\b*\u0010 R\u0013\u0010\r\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010!\u001A\u0004\b+\u0010 R\u0013\u0010\u000E\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010!\u001A\u0004\b,\u0010 R\u0013\u0010\u000F\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010!\u001A\u0004\b-\u0010 R\u0013\u0010\u0010\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010!\u001A\u0004\b.\u0010 R\u0013\u0010\u0011\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010!\u001A\u0004\b/\u0010 R\u0013\u0010\u0012\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010!\u001A\u0004\b0\u0010 R\u0013\u0010\u0013\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010!\u001A\u0004\b1\u0010 R\u0013\u0010\u0014\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010!\u001A\u0004\b2\u0010 R\u0013\u0010\u0015\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010!\u001A\u0004\b3\u0010 R\u0013\u0010\u0016\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010!\u001A\u0004\b4\u0010 R\u0013\u0010\u0017\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010!\u001A\u0004\b5\u0010 R\u0013\u0010\u0018\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010!\u001A\u0004\b6\u0010 R\u0013\u0010\u0019\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010!\u001A\u0004\b7\u0010 R\u0013\u0010\u001A\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010!\u001A\u0004\b8\u0010 R\u0011\u0010\u001B\u001A\u00020\u001C¢\u0006\b\n\u0000\u001A\u0004\b9\u0010:¨\u0006W"}, d2={"Landroidx/compose/material3/DatePickerColors;", "", "containerColor", "Landroidx/compose/ui/graphics/Color;", "titleContentColor", "headlineContentColor", "weekdayContentColor", "subheadContentColor", "navigationContentColor", "yearContentColor", "disabledYearContentColor", "currentYearContentColor", "selectedYearContentColor", "disabledSelectedYearContentColor", "selectedYearContainerColor", "disabledSelectedYearContainerColor", "dayContentColor", "disabledDayContentColor", "selectedDayContentColor", "disabledSelectedDayContentColor", "selectedDayContainerColor", "disabledSelectedDayContainerColor", "todayContentColor", "todayDateBorderColor", "dayInSelectionRangeContainerColor", "dayInSelectionRangeContentColor", "dividerColor", "dateTextFieldColors", "Landroidx/compose/material3/TextFieldColors;", "<init>", "(JJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/material3/TextFieldColors;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getContainerColor-0d7_KjU", "()J", "J", "getTitleContentColor-0d7_KjU", "getHeadlineContentColor-0d7_KjU", "getWeekdayContentColor-0d7_KjU", "getSubheadContentColor-0d7_KjU", "getNavigationContentColor-0d7_KjU", "getYearContentColor-0d7_KjU", "getDisabledYearContentColor-0d7_KjU", "getCurrentYearContentColor-0d7_KjU", "getSelectedYearContentColor-0d7_KjU", "getDisabledSelectedYearContentColor-0d7_KjU", "getSelectedYearContainerColor-0d7_KjU", "getDisabledSelectedYearContainerColor-0d7_KjU", "getDayContentColor-0d7_KjU", "getDisabledDayContentColor-0d7_KjU", "getSelectedDayContentColor-0d7_KjU", "getDisabledSelectedDayContentColor-0d7_KjU", "getSelectedDayContainerColor-0d7_KjU", "getDisabledSelectedDayContainerColor-0d7_KjU", "getTodayContentColor-0d7_KjU", "getTodayDateBorderColor-0d7_KjU", "getDayInSelectionRangeContainerColor-0d7_KjU", "getDayInSelectionRangeContentColor-0d7_KjU", "getDividerColor-0d7_KjU", "getDateTextFieldColors", "()Landroidx/compose/material3/TextFieldColors;", "copy", "copy-tNwlRmA", "(JJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/material3/TextFieldColors;)Landroidx/compose/material3/DatePickerColors;", "takeOrElse", "block", "Lkotlin/Function0;", "takeOrElse$material3", "Landroidx/compose/runtime/State;", "isToday", "", "selected", "inRange", "enabled", "dayContentColor$material3", "(ZZZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "dayContainerColor", "animate", "dayContainerColor$material3", "(ZZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "currentYear", "yearContentColor$material3", "yearContainerColor", "yearContainerColor$material3", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "equals", "other", "hashCode", "", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DatePickerColors {
    public static final int $stable;
    private final long containerColor;
    private final long currentYearContentColor;
    private final TextFieldColors dateTextFieldColors;
    private final long dayContentColor;
    private final long dayInSelectionRangeContainerColor;
    private final long dayInSelectionRangeContentColor;
    private final long disabledDayContentColor;
    private final long disabledSelectedDayContainerColor;
    private final long disabledSelectedDayContentColor;
    private final long disabledSelectedYearContainerColor;
    private final long disabledSelectedYearContentColor;
    private final long disabledYearContentColor;
    private final long dividerColor;
    private final long headlineContentColor;
    private final long navigationContentColor;
    private final long selectedDayContainerColor;
    private final long selectedDayContentColor;
    private final long selectedYearContainerColor;
    private final long selectedYearContentColor;
    private final long subheadContentColor;
    private final long titleContentColor;
    private final long todayContentColor;
    private final long todayDateBorderColor;
    private final long weekdayContentColor;
    private final long yearContentColor;

    static {
    }

    private DatePickerColors(long arg1, long arg3, long arg5, long arg7, long arg9, long arg11, long arg13, long arg15, long arg17, long arg19, long arg21, long arg23, long arg25, long arg27, long arg29, long arg31, long arg33, long arg35, long arg37, long arg39, long arg41, long arg43, long arg45, long arg47, TextFieldColors arg49) {
        super();
        this.containerColor = arg1;
        this.titleContentColor = arg3;
        this.headlineContentColor = arg5;
        this.weekdayContentColor = arg7;
        this.subheadContentColor = arg9;
        this.navigationContentColor = arg11;
        this.yearContentColor = arg13;
        this.disabledYearContentColor = arg15;
        this.currentYearContentColor = arg17;
        this.selectedYearContentColor = arg19;
        this.disabledSelectedYearContentColor = arg21;
        this.selectedYearContainerColor = arg23;
        this.disabledSelectedYearContainerColor = arg25;
        this.dayContentColor = arg27;
        this.disabledDayContentColor = arg29;
        this.selectedDayContentColor = arg31;
        this.disabledSelectedDayContentColor = arg33;
        this.selectedDayContainerColor = arg35;
        this.disabledSelectedDayContainerColor = arg37;
        this.todayContentColor = arg39;
        this.todayDateBorderColor = arg41;
        this.dayInSelectionRangeContainerColor = arg43;
        this.dayInSelectionRangeContentColor = arg45;
        this.dividerColor = arg47;
        this.dateTextFieldColors = arg49;
    }

    public DatePickerColors(long arg1, long arg3, long arg5, long arg7, long arg9, long arg11, long arg13, long arg15, long arg17, long arg19, long arg21, long arg23, long arg25, long arg27, long arg29, long arg31, long arg33, long arg35, long arg37, long arg39, long arg41, long arg43, long arg45, long arg47, TextFieldColors arg49, DefaultConstructorMarker arg50) {
        this(arg1, arg3, arg5, arg7, arg9, arg11, arg13, arg15, arg17, arg19, arg21, arg23, arg25, arg27, arg29, arg31, arg33, arg35, arg37, arg39, arg41, arg43, arg45, arg47, arg49);
    }

    public final DatePickerColors copy-tNwlRmA(long arg57, long arg59, long arg61, long arg63, long arg65, long arg67, long arg69, long arg71, long arg73, long arg75, long arg77, long arg79, long arg81, long arg83, long arg85, long arg87, long arg89, long arg91, long arg93, long arg95, long arg97, long arg99, long arg101, long arg103, TextFieldColors arg105) {
        DatePickerColors v0 = this;
        long v1 = 16;
        long v6 = arg57 != v1 ? arg57 : v0.containerColor;
        long v8 = arg59 != v1 ? arg59 : v0.titleContentColor;
        long v10 = arg61 != v1 ? arg61 : v0.headlineContentColor;
        long v12 = arg63 != v1 ? arg63 : v0.weekdayContentColor;
        long v14 = arg65 != v1 ? arg65 : v0.subheadContentColor;
        long v16 = arg67 != v1 ? arg67 : v0.navigationContentColor;
        long v18 = arg69 != v1 ? arg69 : v0.yearContentColor;
        long v20 = arg71 != v1 ? arg71 : v0.disabledYearContentColor;
        long v22 = arg73 != v1 ? arg73 : v0.currentYearContentColor;
        long v24 = arg75 != v1 ? arg75 : v0.selectedYearContentColor;
        long v26 = arg77 != v1 ? arg77 : v0.disabledSelectedYearContentColor;
        long v28 = arg79 != v1 ? arg79 : v0.selectedYearContainerColor;
        long v30 = arg81 != v1 ? arg81 : v0.disabledSelectedYearContainerColor;
        long v32 = arg83 != v1 ? arg83 : v0.dayContentColor;
        long v34 = arg85 != v1 ? arg85 : v0.disabledDayContentColor;
        long v36 = arg87 != v1 ? arg87 : v0.selectedDayContentColor;
        long v38 = arg89 != v1 ? arg89 : v0.disabledSelectedDayContentColor;
        long v40 = arg91 != v1 ? arg91 : v0.selectedDayContainerColor;
        long v42 = arg93 != v1 ? arg93 : v0.disabledSelectedDayContainerColor;
        long v44 = arg95 != v1 ? arg95 : v0.todayContentColor;
        long v46 = arg97 != v1 ? arg97 : v0.todayDateBorderColor;
        long v48 = arg99 != v1 ? arg99 : v0.dayInSelectionRangeContainerColor;
        long v50 = arg101 != v1 ? arg101 : v0.dayInSelectionRangeContentColor;
        long v52 = arg103 != v1 ? arg103 : v0.dividerColor;
        return new DatePickerColors(v6, v8, v10, v12, v14, v16, v18, v20, v22, v24, v26, v28, v30, v32, v34, v36, v38, v40, v42, v44, v46, v48, v50, v52, v0.takeOrElse$material3(arg105, new DatePickerColors$$ExternalSyntheticLambda0(v0)), null);
    }

    public static DatePickerColors copy-tNwlRmA$default(DatePickerColors arg19, long arg20, long arg22, long arg24, long arg26, long arg28, long arg30, long arg32, long arg34, long arg36, long arg38, long arg40, long arg42, long arg44, long arg46, long arg48, long arg50, long arg52, long arg54, long arg56, long arg58, long arg60, long arg62, long arg64, long arg66, TextFieldColors arg68, int arg69, Object arg70) {
        DatePickerColors v0 = arg19;
        int v1 = arg69;
        long v2 = (v1 & 1) != 0 ? v0.containerColor : arg20;
        long v4 = (v1 & 2) != 0 ? v0.titleContentColor : arg22;
        long v6 = (v1 & 4) != 0 ? v0.headlineContentColor : arg24;
        long v8 = (v1 & 8) != 0 ? v0.weekdayContentColor : arg26;
        long v10 = (v1 & 16) != 0 ? v0.subheadContentColor : arg28;
        long v12 = (v1 & 0x20) != 0 ? v0.navigationContentColor : arg30;
        long v14 = (v1 & 0x40) != 0 ? v0.yearContentColor : arg32;
        long v16 = v2;
        v2 = (v1 & 0x80) != 0 ? v0.disabledYearContentColor : arg34;
        arg20 = v2;
        v2 = (v1 & 0x100) != 0 ? v0.currentYearContentColor : arg36;
        arg22 = v2;
        v2 = (v1 & 0x200) != 0 ? v0.selectedYearContentColor : arg38;
        arg24 = v2;
        v2 = (v1 & 0x400) != 0 ? v0.disabledSelectedYearContentColor : arg40;
        arg26 = v2;
        v2 = (v1 & 0x800) != 0 ? v0.selectedYearContainerColor : arg42;
        arg28 = v2;
        v2 = (v1 & 0x1000) != 0 ? v0.disabledSelectedYearContainerColor : arg44;
        arg30 = v2;
        v2 = (v1 & 0x2000) != 0 ? v0.dayContentColor : arg46;
        arg32 = v2;
        v2 = (v1 & 0x4000) != 0 ? v0.disabledDayContentColor : arg48;
        arg34 = v2;
        long v1_1 = (v1 & 0x8000) != 0 ? v0.selectedDayContentColor : arg50;
        arg36 = v1_1;
        v1_1 = (arg69 & 0x10000) != 0 ? v0.disabledSelectedDayContentColor : arg52;
        arg38 = v1_1;
        v1_1 = (arg69 & 0x20000) != 0 ? v0.selectedDayContainerColor : arg54;
        arg40 = v1_1;
        v1_1 = (arg69 & 0x40000) != 0 ? v0.disabledSelectedDayContainerColor : arg56;
        arg42 = v1_1;
        v1_1 = (arg69 & 0x80000) != 0 ? v0.todayContentColor : arg58;
        arg44 = v1_1;
        v1_1 = (arg69 & 0x100000) != 0 ? v0.todayDateBorderColor : arg60;
        arg46 = v1_1;
        v1_1 = (arg69 & 0x200000) != 0 ? v0.dayInSelectionRangeContainerColor : arg62;
        arg48 = v1_1;
        v1_1 = (arg69 & 0x400000) != 0 ? v0.dayInSelectionRangeContentColor : arg64;
        arg50 = v1_1;
        v1_1 = (arg69 & 0x800000) != 0 ? v0.dividerColor : arg66;
        TextFieldColors v69 = (arg69 & 0x1000000) != 0 ? v0.dateTextFieldColors : arg68;
        return v0.copy-tNwlRmA(v16, v4, v6, v8, v10, v12, v14, arg20, arg22, arg24, arg26, arg28, arg30, arg32, arg34, arg36, arg38, arg40, arg42, arg44, arg46, arg48, arg50, v1_1, v69);
    }

    static final TextFieldColors copy_tNwlRmA$lambda$24(DatePickerColors arg0) {
        return arg0.dateTextFieldColors;
    }

    public final State dayContainerColor$material3(boolean arg9, boolean arg10, boolean arg11, Composer arg12, int arg13) {
        State v8_1;
        Composer v5;
        long v8;
        int v1 = 0xB60FBC9E;
        ComposerKt.sourceInformationMarkerStart(arg12, v1, "C(dayContainerColor)N(selected,enabled,animate):DatePicker.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg13, -1, "androidx.compose.material3.DatePickerColors.dayContainerColor (DatePicker.kt:976)");
        }

        if(!arg9) {
            v8 = Color.Companion.getTransparent-0d7_KjU();
        }
        else if(arg10) {
            v8 = this.selectedDayContainerColor;
        }
        else {
            v8 = this.disabledSelectedDayContainerColor;
        }

        long v0 = v8;
        if(arg11) {
            arg12.startReplaceGroup(0xB15495A0);
            ComposerKt.sourceInformation(arg12, "987@47597L7,984@47415L204");
            v5 = arg12;
            v8_1 = SingleValueAnimationKt.animateColorAsState-euL9pac(v0, MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, arg12, 6), null, null, v5, 0, 12);
            v5.endReplaceGroup();
        }
        else {
            v5 = arg12;
            v5.startReplaceGroup(0xB1580B10);
            ComposerKt.sourceInformation(v5, "990@47649L28");
            v8_1 = SnapshotStateKt.rememberUpdatedState(Color.box-impl(v0), v5, 0);
            v5.endReplaceGroup();
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v5);
        return v8_1;
    }

    public final State dayContentColor$material3(boolean arg9, boolean arg10, boolean arg11, boolean arg12, Composer arg13, int arg14) {
        Composer v5;
        State v8_1;
        long v8;
        int v1 = 0xB6774F3A;
        ComposerKt.sourceInformationMarkerStart(arg13, v1, "C(dayContentColor)N(isToday,selected,inRange,enabled):DatePicker.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg14, -1, "androidx.compose.material3.DatePickerColors.dayContentColor (DatePicker.kt:940)");
        }

        if(!arg10 || !arg12) {
            if((arg10) && !arg12) {
                v8 = this.disabledSelectedDayContentColor;
                goto label_11;
            }

            if((arg11) && (arg12)) {
                v8 = this.dayInSelectionRangeContentColor;
                goto label_11;
            }

            if((arg11) && !arg12) {
                v8 = this.disabledDayContentColor;
                goto label_11;
            }

            if((arg9) && (arg12)) {
                v8 = this.todayContentColor;
                goto label_11;
            }

            if(arg12) {
                v8 = this.dayContentColor;
                goto label_11;
            }

            v8 = this.disabledDayContentColor;
        }
        else {
            v8 = this.selectedDayContentColor;
        }

    label_11:
        long v0 = v8;
        if(arg11) {
            arg13.startReplaceGroup(-969483020);
            ComposerKt.sourceInformation(arg13, "953@46356L28");
            v8_1 = SnapshotStateKt.rememberUpdatedState(Color.box-impl(v0), arg13, 0);
            arg13.endReplaceGroup();
            v5 = arg13;
        }
        else {
            arg13.startReplaceGroup(-969417610);
            ComposerKt.sourceInformation(arg13, "959@46674L7,956@46492L204");
            v5 = arg13;
            v8_1 = SingleValueAnimationKt.animateColorAsState-euL9pac(v0, MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, arg13, 6), null, null, v5, 0, 12);
            v5.endReplaceGroup();
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v5);
        return v8_1;
    }

    public boolean equals(Object arg7) {
        if(!(arg7 instanceof DatePickerColors)) {
            return 0;
        }

        if(!Color.equals-impl0(this.containerColor, ((DatePickerColors)arg7).containerColor)) {
            return 0;
        }

        if(!Color.equals-impl0(this.titleContentColor, ((DatePickerColors)arg7).titleContentColor)) {
            return 0;
        }

        if(!Color.equals-impl0(this.headlineContentColor, ((DatePickerColors)arg7).headlineContentColor)) {
            return 0;
        }

        if(!Color.equals-impl0(this.weekdayContentColor, ((DatePickerColors)arg7).weekdayContentColor)) {
            return 0;
        }

        if(!Color.equals-impl0(this.subheadContentColor, ((DatePickerColors)arg7).subheadContentColor)) {
            return 0;
        }

        if(!Color.equals-impl0(this.yearContentColor, ((DatePickerColors)arg7).yearContentColor)) {
            return 0;
        }

        if(!Color.equals-impl0(this.disabledYearContentColor, ((DatePickerColors)arg7).disabledYearContentColor)) {
            return 0;
        }

        if(!Color.equals-impl0(this.currentYearContentColor, ((DatePickerColors)arg7).currentYearContentColor)) {
            return 0;
        }

        if(!Color.equals-impl0(this.selectedYearContentColor, ((DatePickerColors)arg7).selectedYearContentColor)) {
            return 0;
        }

        if(!Color.equals-impl0(this.disabledSelectedYearContentColor, ((DatePickerColors)arg7).disabledSelectedYearContentColor)) {
            return 0;
        }

        if(!Color.equals-impl0(this.selectedYearContainerColor, ((DatePickerColors)arg7).selectedYearContainerColor)) {
            return 0;
        }

        if(!Color.equals-impl0(this.disabledSelectedYearContainerColor, ((DatePickerColors)arg7).disabledSelectedYearContainerColor)) {
            return 0;
        }

        if(!Color.equals-impl0(this.dayContentColor, ((DatePickerColors)arg7).dayContentColor)) {
            return 0;
        }

        if(!Color.equals-impl0(this.disabledDayContentColor, ((DatePickerColors)arg7).disabledDayContentColor)) {
            return 0;
        }

        if(!Color.equals-impl0(this.selectedDayContentColor, ((DatePickerColors)arg7).selectedDayContentColor)) {
            return 0;
        }

        if(!Color.equals-impl0(this.disabledSelectedDayContentColor, ((DatePickerColors)arg7).disabledSelectedDayContentColor)) {
            return 0;
        }

        if(!Color.equals-impl0(this.selectedDayContainerColor, ((DatePickerColors)arg7).selectedDayContainerColor)) {
            return 0;
        }

        if(!Color.equals-impl0(this.disabledSelectedDayContainerColor, ((DatePickerColors)arg7).disabledSelectedDayContainerColor)) {
            return 0;
        }

        if(!Color.equals-impl0(this.todayContentColor, ((DatePickerColors)arg7).todayContentColor)) {
            return 0;
        }

        if(!Color.equals-impl0(this.todayDateBorderColor, ((DatePickerColors)arg7).todayDateBorderColor)) {
            return 0;
        }

        if(!Color.equals-impl0(this.dayInSelectionRangeContainerColor, ((DatePickerColors)arg7).dayInSelectionRangeContainerColor)) {
            return 0;
        }

        if(!Color.equals-impl0(this.dayInSelectionRangeContentColor, ((DatePickerColors)arg7).dayInSelectionRangeContentColor)) {
            return 0;
        }

        return 1;
    }

    public final long getContainerColor-0d7_KjU() {
        return this.containerColor;
    }

    public final long getCurrentYearContentColor-0d7_KjU() {
        return this.currentYearContentColor;
    }

    public final TextFieldColors getDateTextFieldColors() {
        return this.dateTextFieldColors;
    }

    public final long getDayContentColor-0d7_KjU() {
        return this.dayContentColor;
    }

    public final long getDayInSelectionRangeContainerColor-0d7_KjU() {
        return this.dayInSelectionRangeContainerColor;
    }

    public final long getDayInSelectionRangeContentColor-0d7_KjU() {
        return this.dayInSelectionRangeContentColor;
    }

    public final long getDisabledDayContentColor-0d7_KjU() {
        return this.disabledDayContentColor;
    }

    public final long getDisabledSelectedDayContainerColor-0d7_KjU() {
        return this.disabledSelectedDayContainerColor;
    }

    public final long getDisabledSelectedDayContentColor-0d7_KjU() {
        return this.disabledSelectedDayContentColor;
    }

    public final long getDisabledSelectedYearContainerColor-0d7_KjU() {
        return this.disabledSelectedYearContainerColor;
    }

    public final long getDisabledSelectedYearContentColor-0d7_KjU() {
        return this.disabledSelectedYearContentColor;
    }

    public final long getDisabledYearContentColor-0d7_KjU() {
        return this.disabledYearContentColor;
    }

    public final long getDividerColor-0d7_KjU() {
        return this.dividerColor;
    }

    public final long getHeadlineContentColor-0d7_KjU() {
        return this.headlineContentColor;
    }

    public final long getNavigationContentColor-0d7_KjU() {
        return this.navigationContentColor;
    }

    public final long getSelectedDayContainerColor-0d7_KjU() {
        return this.selectedDayContainerColor;
    }

    public final long getSelectedDayContentColor-0d7_KjU() {
        return this.selectedDayContentColor;
    }

    public final long getSelectedYearContainerColor-0d7_KjU() {
        return this.selectedYearContainerColor;
    }

    public final long getSelectedYearContentColor-0d7_KjU() {
        return this.selectedYearContentColor;
    }

    public final long getSubheadContentColor-0d7_KjU() {
        return this.subheadContentColor;
    }

    public final long getTitleContentColor-0d7_KjU() {
        return this.titleContentColor;
    }

    public final long getTodayContentColor-0d7_KjU() {
        return this.todayContentColor;
    }

    public final long getTodayDateBorderColor-0d7_KjU() {
        return this.todayDateBorderColor;
    }

    public final long getWeekdayContentColor-0d7_KjU() {
        return this.weekdayContentColor;
    }

    public final long getYearContentColor-0d7_KjU() {
        return this.yearContentColor;
    }

    public int hashCode() {
        return ((((((((((((((((((((Color.hashCode-impl(this.containerColor) * 0x1F + Color.hashCode-impl(this.titleContentColor)) * 0x1F + Color.hashCode-impl(this.headlineContentColor)) * 0x1F + Color.hashCode-impl(this.weekdayContentColor)) * 0x1F + Color.hashCode-impl(this.subheadContentColor)) * 0x1F + Color.hashCode-impl(this.yearContentColor)) * 0x1F + Color.hashCode-impl(this.disabledYearContentColor)) * 0x1F + Color.hashCode-impl(this.currentYearContentColor)) * 0x1F + Color.hashCode-impl(this.selectedYearContentColor)) * 0x1F + Color.hashCode-impl(this.disabledSelectedYearContentColor)) * 0x1F + Color.hashCode-impl(this.selectedYearContainerColor)) * 0x1F + Color.hashCode-impl(this.disabledSelectedYearContainerColor)) * 0x1F + Color.hashCode-impl(this.dayContentColor)) * 0x1F + Color.hashCode-impl(this.disabledDayContentColor)) * 0x1F + Color.hashCode-impl(this.selectedDayContentColor)) * 0x1F + Color.hashCode-impl(this.disabledSelectedDayContentColor)) * 0x1F + Color.hashCode-impl(this.selectedDayContainerColor)) * 0x1F + Color.hashCode-impl(this.disabledSelectedDayContainerColor)) * 0x1F + Color.hashCode-impl(this.todayContentColor)) * 0x1F + Color.hashCode-impl(this.todayDateBorderColor)) * 0x1F + Color.hashCode-impl(this.dayInSelectionRangeContainerColor)) * 0x1F + Color.hashCode-impl(this.dayInSelectionRangeContentColor);
    }

    public final TextFieldColors takeOrElse$material3(TextFieldColors arg1, Function0 arg2) {
        if(arg1 == null) {
            return arg2.invoke();
        }

        return arg1;
    }

    public final State yearContainerColor$material3(boolean arg9, boolean arg10, Composer arg11, int arg12) {
        long v8;
        int v1 = -1306331107;
        ComposerKt.sourceInformationMarkerStart(arg11, v1, "C(yearContainerColor)N(selected,enabled)1040@49460L7,1037@49290L188:DatePicker.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg12, -1, "androidx.compose.material3.DatePickerColors.yearContainerColor (DatePicker.kt:1030)");
        }

        if(!arg9) {
            v8 = Color.Companion.getTransparent-0d7_KjU();
        }
        else if(arg10) {
            v8 = this.selectedYearContainerColor;
        }
        else {
            v8 = this.disabledSelectedYearContainerColor;
        }

        Composer v5 = arg11;
        State v8_1 = SingleValueAnimationKt.animateColorAsState-euL9pac(v8, MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, arg11, 6), null, null, v5, 0, 12);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v5);
        return v8_1;
    }

    public final State yearContentColor$material3(boolean arg9, boolean arg10, boolean arg11, Composer arg12, int arg13) {
        long v8;
        int v1 = 0x3419E079;
        ComposerKt.sourceInformationMarkerStart(arg12, v1, "C(yearContentColor)N(currentYear,selected,enabled)1019@48707L7,1016@48537L188:DatePicker.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg13, -1, "androidx.compose.material3.DatePickerColors.yearContentColor (DatePicker.kt:1006)");
        }

        if(!arg10 || !arg11) {
            if((arg10) && !arg11) {
                v8 = this.disabledSelectedYearContentColor;
                goto label_11;
            }

            if((arg9) && (arg11)) {
                v8 = this.currentYearContentColor;
                goto label_11;
            }

            if(arg11) {
                v8 = this.yearContentColor;
                goto label_11;
            }

            v8 = this.disabledYearContentColor;
        }
        else {
            v8 = this.selectedYearContentColor;
        }

    label_11:
        long v0 = v8;
        Composer v5 = arg12;
        State v8_1 = SingleValueAnimationKt.animateColorAsState-euL9pac(v0, MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, arg12, 6), null, null, v5, 0, 12);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v5);
        return v8_1;
    }
}

