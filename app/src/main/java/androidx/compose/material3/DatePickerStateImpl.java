package androidx.compose.material3;

import androidx.compose.material3.internal.CalendarDate;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
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

@Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000E\b\u0003\u0018\u0000  2\u00020\u00012\u00020\u0002:\u0001 B?\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\u000B\u0012\n\u0010\f\u001A\u00060\rj\u0002`\u000E¢\u0006\u0004\b\u000F\u0010\u0010R\u0016\u0010\u0011\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012X\u0082\u000E¢\u0006\u0002\n\u0000R(\u0010\u0015\u001A\u0004\u0018\u00010\u00042\b\u0010\u0014\u001A\u0004\u0018\u00010\u00048V@VX\u0096\u000E¢\u0006\f\u001A\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\t0\u0012X\u0082\u000E¢\u0006\u0002\n\u0000R$\u0010\u001B\u001A\u00020\t2\u0006\u0010\u001B\u001A\u00020\t8V@VX\u0096\u000E¢\u0006\f\u001A\u0004\b\u001C\u0010\u001D\"\u0004\b\u001E\u0010\u001F¨\u0006!"}, d2={"Landroidx/compose/material3/DatePickerStateImpl;", "Landroidx/compose/material3/BaseDatePickerStateImpl;", "Landroidx/compose/material3/DatePickerState;", "initialSelectedDateMillis", "", "initialDisplayedMonthMillis", "yearRange", "Lkotlin/ranges/IntRange;", "initialDisplayMode", "Landroidx/compose/material3/DisplayMode;", "selectableDates", "Landroidx/compose/material3/SelectableDates;", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Lkotlin/ranges/IntRange;ILandroidx/compose/material3/SelectableDates;Ljava/util/Locale;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "_selectedDate", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/material3/internal/CalendarDate;", "dateMillis", "selectedDateMillis", "getSelectedDateMillis", "()Ljava/lang/Long;", "setSelectedDateMillis", "(Ljava/lang/Long;)V", "_displayMode", "displayMode", "getDisplayMode-jFl-4v0", "()I", "setDisplayMode-vCnGnXg", "(I)V", "Companion", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) final class DatePickerStateImpl extends BaseDatePickerStateImpl implements DatePickerState {
    @Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\u0007\u001A\u00020\b2\n\u0010\t\u001A\u00060\nj\u0002`\u000B¢\u0006\u0002\u0010\f¨\u0006\r"}, d2={"Landroidx/compose/material3/DatePickerStateImpl$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/DatePickerStateImpl;", "selectableDates", "Landroidx/compose/material3/SelectableDates;", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "(Landroidx/compose/material3/SelectableDates;Ljava/util/Locale;)Landroidx/compose/runtime/saveable/Saver;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final Saver Saver(SelectableDates arg2, Locale arg3) {
            return ListSaverKt.listSaver(new DatePickerStateImpl$Companion$$ExternalSyntheticLambda0(), new DatePickerStateImpl$Companion$$ExternalSyntheticLambda1(arg2, arg3));
        }

        static final List Saver$lambda$0(SaverScope arg3, DatePickerStateImpl arg4) {
            return CollectionsKt.listOf(new Object[]{arg4.getSelectedDateMillis(), Long.valueOf(arg4.getDisplayedMonthMillis()), Integer.valueOf(arg4.getYearRange().getFirst()), Integer.valueOf(arg4.getYearRange().getLast()), Integer.valueOf(arg4.getDisplayMode-jFl-4v0())});
        }

        static final DatePickerStateImpl Saver$lambda$1(SelectableDates arg8, Locale arg9, List arg10) {
            Object v1 = arg10.get(0);
            Object v2 = arg10.get(1);
            Object v4 = arg10.get(2);
            Intrinsics.checkNotNull(v4, "null cannot be cast to non-null type kotlin.Int");
            int v4_1 = ((Integer)v4).intValue();
            Object v6 = arg10.get(3);
            Intrinsics.checkNotNull(v6, "null cannot be cast to non-null type kotlin.Int");
            IntRange v3 = new IntRange(v4_1, ((Integer)v6).intValue());
            Object v10 = arg10.get(4);
            Intrinsics.checkNotNull(v10, "null cannot be cast to non-null type kotlin.Int");
            return new DatePickerStateImpl(((Long)v1), ((Long)v2), v3, DisplayMode.constructor-impl(((Integer)v10).intValue()), arg8, arg9, null);
        }
    }

    public static final Companion Companion;
    private MutableState _displayMode;
    private MutableState _selectedDate;

    static {
        DatePickerStateImpl.Companion = new Companion(null);
    }

    public DatePickerStateImpl(Long arg1, Long arg2, IntRange arg3, int arg4, SelectableDates arg5, Locale arg6, DefaultConstructorMarker arg7) {
        this(arg1, arg2, arg3, arg4, arg5, arg6);
    }

    private DatePickerStateImpl(Long arg3, Long arg4, IntRange arg5, int arg6, SelectableDates arg7, Locale arg8) {
        Object v3_1;
        super(arg4, arg5, arg7, arg8);
        SnapshotMutationPolicy v4 = null;
        if(arg3 != null) {
            CalendarDate v3 = this.getCalendarModel().getCanonicalDate(arg3.longValue());
            if(arg5.contains(v3.getYear())) {
            }
            else {
                goto label_10;
            }
        }
        else {
        label_10:
            v3_1 = v4;
        }

        this._selectedDate = SnapshotStateKt.mutableStateOf$default(v3_1, v4, 2, v4);
        this._displayMode = SnapshotStateKt.mutableStateOf$default(DisplayMode.box-impl(arg6), v4, 2, v4);
    }

    public int getDisplayMode-jFl-4v0() {
        return this._displayMode.getValue().unbox-impl();
    }

    public Long getSelectedDateMillis() {
        Object v2 = this._selectedDate.getValue();
        if(v2 != null) {
            return Long.valueOf(((CalendarDate)v2).getUtcTimeMillis());
        }

        return null;
    }

    public void setDisplayMode-vCnGnXg(int arg4) {
        Long v0 = this.getSelectedDateMillis();
        if(v0 != null) {
            this.setDisplayedMonthMillis(this.getCalendarModel().getMonth(((Number)v0).longValue()).getStartUtcTimeMillis());
        }

        this._displayMode.setValue(DisplayMode.box-impl(arg4));
    }

    public void setSelectedDateMillis(Long arg5) {
        CalendarDate v0_1;
        Object v0 = null;
        if(arg5 != null) {
            CalendarDate v5 = this.getCalendarModel().getCanonicalDate(arg5.longValue());
            MutableState v1 = this._selectedDate;
            if(this.getYearRange().contains(v5.getYear())) {
                v0_1 = v5;
            }

            v1.setValue(v0_1);
            return;
        }

        this._selectedDate.setValue(v0);
    }
}

