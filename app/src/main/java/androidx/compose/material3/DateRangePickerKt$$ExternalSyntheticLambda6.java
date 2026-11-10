package androidx.compose.material3;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.material3.internal.CalendarModel;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.IntRange;

public final class DateRangePickerKt$$ExternalSyntheticLambda6 implements Function2 {
    public DateRangePickerKt$$ExternalSyntheticLambda6(LazyListState arg1, Long arg2, Long arg3, Function2 arg4, Function1 arg5, CalendarModel arg6, IntRange arg7, DatePickerFormatter arg8, SelectableDates arg9, DatePickerColors arg10, int arg11) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
        this.f$4 = arg5;
        this.f$5 = arg6;
        this.f$6 = arg7;
        this.f$7 = arg8;
        this.f$8 = arg9;
        this.f$9 = arg10;
        this.f$10 = arg11;
    }

    public final Object invoke(Object arg14, Object arg15) {
        return DateRangePickerKt.VerticalMonthsList$lambda$15(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, this.f$8, this.f$9, this.f$10, arg14, ((Integer)arg15).intValue());
    }
}

