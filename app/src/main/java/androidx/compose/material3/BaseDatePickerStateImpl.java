package androidx.compose.material3;

import androidx.compose.material3.internal.CalendarModel;
import androidx.compose.material3.internal.CalendarModel_androidKt;
import androidx.compose.material3.internal.CalendarMonth;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ranges.IntRange;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b!\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\n\u0010\b\u001A\u00060\tj\u0002`\n¢\u0006\u0004\b\u000B\u0010\fR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0017\u0010\b\u001A\u00060\tj\u0002`\n¢\u0006\n\n\u0002\u0010\u0011\u001A\u0004\b\u000F\u0010\u0010R\u0011\u0010\u0012\u001A\u00020\u0013¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015R+\u0010\u0006\u001A\u00020\u00072\u0006\u0010\u0016\u001A\u00020\u00078F@FX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b\u001B\u0010\u001C\u001A\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001AR\u0014\u0010\u001D\u001A\b\u0012\u0004\u0012\u00020\u001F0\u001EX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010!\u001A\u00020\u00032\u0006\u0010 \u001A\u00020\u00038F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006&"}, d2={"Landroidx/compose/material3/BaseDatePickerStateImpl;", "", "initialDisplayedMonthMillis", "", "yearRange", "Lkotlin/ranges/IntRange;", "selectableDates", "Landroidx/compose/material3/SelectableDates;", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "<init>", "(Ljava/lang/Long;Lkotlin/ranges/IntRange;Landroidx/compose/material3/SelectableDates;Ljava/util/Locale;)V", "getYearRange", "()Lkotlin/ranges/IntRange;", "getLocale", "()Ljava/util/Locale;", "Ljava/util/Locale;", "calendarModel", "Landroidx/compose/material3/internal/CalendarModel;", "getCalendarModel", "()Landroidx/compose/material3/internal/CalendarModel;", "<set-?>", "getSelectableDates", "()Landroidx/compose/material3/SelectableDates;", "setSelectableDates", "(Landroidx/compose/material3/SelectableDates;)V", "selectableDates$delegate", "Landroidx/compose/runtime/MutableState;", "_displayedMonth", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/material3/internal/CalendarMonth;", "monthMillis", "displayedMonthMillis", "getDisplayedMonthMillis", "()J", "setDisplayedMonthMillis", "(J)V", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class BaseDatePickerStateImpl {
    public static final int $stable;
    private final MutableState _displayedMonth;
    private final CalendarModel calendarModel;
    private final Locale locale;
    private final MutableState selectableDates$delegate;
    private final IntRange yearRange;

    static {
    }

    public BaseDatePickerStateImpl(Long arg5, IntRange arg6, SelectableDates arg7, Locale arg8) {
        CalendarMonth v5;
        super();
        this.yearRange = arg6;
        this.locale = arg8;
        CalendarModel v8 = CalendarModel_androidKt.createCalendarModel(arg8);
        this.calendarModel = v8;
        SnapshotMutationPolicy v0 = null;
        int v1 = 2;
        this.selectableDates$delegate = SnapshotStateKt.mutableStateOf$default(arg7, v0, v1, v0);
        if(arg5 != null) {
            v5 = v8.getMonth(arg5.longValue());
            if(!arg6.contains(v5.getYear())) {
                v5 = v8.getMonth(v8.getToday());
            }
        }
        else {
            v5 = v8.getMonth(v8.getToday());
        }

        this._displayedMonth = SnapshotStateKt.mutableStateOf$default(v5, v0, v1, v0);
    }

    public final CalendarModel getCalendarModel() {
        return this.calendarModel;
    }

    public final long getDisplayedMonthMillis() {
        return this._displayedMonth.getValue().getStartUtcTimeMillis();
    }

    public final Locale getLocale() {
        return this.locale;
    }

    public final SelectableDates getSelectableDates() {
        return this.selectableDates$delegate.getValue();
    }

    public final IntRange getYearRange() {
        return this.yearRange;
    }

    public final void setDisplayedMonthMillis(long arg2) {
        CalendarMonth v2 = this.calendarModel.getMonth(arg2);
        if(this.yearRange.contains(v2.getYear())) {
            this._displayedMonth.setValue(v2);
        }
    }

    public final void setSelectableDates(SelectableDates arg1) {
        this.selectableDates$delegate.setValue(arg1);
    }
}

