package androidx.compose.material3;

import androidx.compose.material3.internal.CalendarModel;
import androidx.compose.ui.Modifier;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.IntRange;

public final class DatePickerKt$$ExternalSyntheticLambda3 implements Function2 {
    public DatePickerKt$$ExternalSyntheticLambda3(Modifier arg1, long arg2, Function1 arg4, SelectableDates arg5, CalendarModel arg6, IntRange arg7, DatePickerColors arg8, int arg9) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg4;
        this.f$3 = arg5;
        this.f$4 = arg6;
        this.f$5 = arg7;
        this.f$6 = arg8;
        this.f$7 = arg9;
    }

    public final Object invoke(Object arg12, Object arg13) {
        return DatePickerKt.YearPicker$lambda$63(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, arg12, ((Integer)arg13).intValue());
    }
}

