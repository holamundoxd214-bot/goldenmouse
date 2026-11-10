package androidx.compose.material3;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.material3.internal.CalendarModel;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.IntRange;

public final class DatePickerKt$$ExternalSyntheticLambda16 implements Function2 {
    public DatePickerKt$$ExternalSyntheticLambda16(LazyListState arg1, Long arg2, Function1 arg3, Function1 arg4, CalendarModel arg5, IntRange arg6, DatePickerFormatter arg7, SelectableDates arg8, DatePickerColors arg9, int arg10) {
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
    }

    public final Object invoke(Object arg13, Object arg14) {
        return DatePickerKt.HorizontalMonthsList$lambda$42(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, this.f$8, this.f$9, arg13, ((Integer)arg14).intValue());
    }
}

