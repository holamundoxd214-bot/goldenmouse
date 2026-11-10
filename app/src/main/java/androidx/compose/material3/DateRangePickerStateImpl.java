package androidx.compose.material3;

import androidx.compose.material3.internal.CalendarDate;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverScope;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\b\b\u0003\u0018\u0000 )2\u00020\u00012\u00020\u0002:\u0001)BI\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\n\u0012\u0006\u0010\u000B\u001A\u00020\f\u0012\n\u0010\r\u001A\u00060\u000Ej\u0002`\u000F¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010!\u001A\u00020\"2\b\u0010#\u001A\u0004\u0018\u00010\u00042\b\u0010$\u001A\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0002\u0010%J\u0019\u0010&\u001A\u0004\u0018\u00010\u00142\b\u0010\'\u001A\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0002\u0010(R\u0016\u0010\u0012\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0013X\u0082\u000E¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0013X\u0082\u000E¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001A\u0004\u0018\u00010\u00048VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001A\u0004\u0018\u00010\u00048VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001A\u0010\u0018R\u0014\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\n0\u0013X\u0082\u000E¢\u0006\u0002\n\u0000R$\u0010\u001C\u001A\u00020\n2\u0006\u0010\u001C\u001A\u00020\n8V@VX\u0096\u000E¢\u0006\f\u001A\u0004\b\u001D\u0010\u001E\"\u0004\b\u001F\u0010 ¨\u0006*"}, d2={"Landroidx/compose/material3/DateRangePickerStateImpl;", "Landroidx/compose/material3/BaseDatePickerStateImpl;", "Landroidx/compose/material3/DateRangePickerState;", "initialSelectedStartDateMillis", "", "initialSelectedEndDateMillis", "initialDisplayedMonthMillis", "yearRange", "Lkotlin/ranges/IntRange;", "initialDisplayMode", "Landroidx/compose/material3/DisplayMode;", "selectableDates", "Landroidx/compose/material3/SelectableDates;", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Lkotlin/ranges/IntRange;ILandroidx/compose/material3/SelectableDates;Ljava/util/Locale;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "_selectedStartDate", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/material3/internal/CalendarDate;", "_selectedEndDate", "selectedStartDateMillis", "getSelectedStartDateMillis", "()Ljava/lang/Long;", "selectedEndDateMillis", "getSelectedEndDateMillis", "_displayMode", "displayMode", "getDisplayMode-jFl-4v0", "()I", "setDisplayMode-vCnGnXg", "(I)V", "setSelection", "", "startDateMillis", "endDateMillis", "(Ljava/lang/Long;Ljava/lang/Long;)V", "getDate", "dateMillis", "(Ljava/lang/Long;)Landroidx/compose/material3/internal/CalendarDate;", "Companion", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) final class DateRangePickerStateImpl extends BaseDatePickerStateImpl implements DateRangePickerState {
    @Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\u0007\u001A\u00020\b2\n\u0010\t\u001A\u00060\nj\u0002`\u000B¢\u0006\u0002\u0010\f¨\u0006\r"}, d2={"Landroidx/compose/material3/DateRangePickerStateImpl$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/DateRangePickerStateImpl;", "selectableDates", "Landroidx/compose/material3/SelectableDates;", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "(Landroidx/compose/material3/SelectableDates;Ljava/util/Locale;)Landroidx/compose/runtime/saveable/Saver;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final Saver Saver(SelectableDates arg2, Locale arg3) {
            return ListSaverKt.listSaver(new DateRangePickerStateImpl$Companion$$ExternalSyntheticLambda0(), new DateRangePickerStateImpl$Companion$$ExternalSyntheticLambda1(arg2, arg3));
        }

        static final List Saver$lambda$0(SaverScope arg6, DateRangePickerStateImpl arg7) {
            return CollectionsKt.listOf(new Object[]{arg7.getSelectedStartDateMillis(), arg7.getSelectedEndDateMillis(), Long.valueOf(arg7.getDisplayedMonthMillis()), Integer.valueOf(arg7.getYearRange().getFirst()), Integer.valueOf(arg7.getYearRange().getLast()), Integer.valueOf(arg7.getDisplayMode-jFl-4v0())});
        }

        static final DateRangePickerStateImpl Saver$lambda$1(SelectableDates arg9, Locale arg10, List arg11) {
            Object v1 = arg11.get(0);
            Object v2 = arg11.get(1);
            Object v3 = arg11.get(2);
            Object v5 = arg11.get(3);
            Intrinsics.checkNotNull(v5, "null cannot be cast to non-null type kotlin.Int");
            int v5_1 = ((Integer)v5).intValue();
            Object v7 = arg11.get(4);
            Intrinsics.checkNotNull(v7, "null cannot be cast to non-null type kotlin.Int");
            IntRange v4 = new IntRange(v5_1, ((Integer)v7).intValue());
            Object v11 = arg11.get(5);
            Intrinsics.checkNotNull(v11, "null cannot be cast to non-null type kotlin.Int");
            return new DateRangePickerStateImpl(((Long)v1), ((Long)v2), ((Long)v3), v4, DisplayMode.constructor-impl(((Integer)v11).intValue()), arg9, arg10, null);
        }
    }

    public static final Companion Companion;
    private MutableState _displayMode;
    private MutableState _selectedEndDate;
    private MutableState _selectedStartDate;

    static {
        DateRangePickerStateImpl.Companion = new Companion(null);
    }

    public DateRangePickerStateImpl(Long arg1, Long arg2, Long arg3, IntRange arg4, int arg5, SelectableDates arg6, Locale arg7, DefaultConstructorMarker arg8) {
        this(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    private DateRangePickerStateImpl(Long arg1, Long arg2, Long arg3, IntRange arg4, int arg5, SelectableDates arg6, Locale arg7) {
        super(arg3, arg4, arg6, arg7);
        this._selectedStartDate = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this._selectedEndDate = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.setSelection(arg1, arg2);
        this._displayMode = SnapshotStateKt.mutableStateOf$default(DisplayMode.box-impl(arg5), null, 2, null);
    }

    private final CalendarDate getDate(Long arg5) {
        CalendarDate v0 = null;
        if(arg5 != null) {
            CalendarDate v5 = this.getCalendarModel().getCanonicalDate(arg5.longValue());
            if(this.getYearRange().contains(v5.getYear())) {
                return v5;
            }
        }

        return v0;
    }

    public int getDisplayMode-jFl-4v0() {
        return this._displayMode.getValue().unbox-impl();
    }

    public Long getSelectedEndDateMillis() {
        Object v2 = this._selectedEndDate.getValue();
        if(v2 != null) {
            return Long.valueOf(((CalendarDate)v2).getUtcTimeMillis());
        }

        return null;
    }

    public Long getSelectedStartDateMillis() {
        Object v2 = this._selectedStartDate.getValue();
        if(v2 != null) {
            return Long.valueOf(((CalendarDate)v2).getUtcTimeMillis());
        }

        return null;
    }

    public void setDisplayMode-vCnGnXg(int arg4) {
        Long v0 = this.getSelectedStartDateMillis();
        if(v0 != null) {
            this.setDisplayedMonthMillis(this.getCalendarModel().getMonth(((Number)v0).longValue()).getStartUtcTimeMillis());
        }

        this._displayMode.setValue(DisplayMode.box-impl(arg4));
    }

    public void setSelection(Long arg5, Long arg6) {
        CalendarDate v5 = this.getDate(arg5);
        CalendarDate v6 = this.getDate(arg6);
        if(v5 != null && (v6 == null || v5.getUtcTimeMillis() <= v6.getUtcTimeMillis())) {
            this._selectedStartDate.setValue(v5);
            this._selectedEndDate.setValue(v6);
            return;
        }

        this._selectedStartDate.setValue(null);
        this._selectedEndDate.setValue(null);
    }
}

