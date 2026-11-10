package androidx.compose.material3;

import androidx.compose.material3.internal.CalendarModel;
import androidx.compose.ui.focus.FocusRequester;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.IntRange;

public final class DateInputKt$$ExternalSyntheticLambda0 implements Function2 {
    public DateInputKt$$ExternalSyntheticLambda0(Long arg1, Function1 arg2, CalendarModel arg3, IntRange arg4, DatePickerFormatter arg5, SelectableDates arg6, DatePickerColors arg7, FocusRequester arg8, int arg9) {
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
    }

    public final Object invoke(Object arg12, Object arg13) {
        return DateInputKt.DateInputContent$lambda$3(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, this.f$8, arg12, ((Integer)arg13).intValue());
    }
}

