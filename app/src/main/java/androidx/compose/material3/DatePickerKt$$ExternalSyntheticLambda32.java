package androidx.compose.material3;

import androidx.compose.material3.internal.CalendarModel;
import androidx.compose.runtime.Composer;
import kotlin.jvm.functions.Function2;

public final class DatePickerKt$$ExternalSyntheticLambda32 implements Function2 {
    public DatePickerKt$$ExternalSyntheticLambda32(DatePickerColors arg1, CalendarModel arg2, int arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final Object invoke(Object arg3, Object arg4) {
        return DatePickerKt.WeekDays$lambda$49(this.f$0, this.f$1, this.f$2, ((Composer)arg3), ((Integer)arg4).intValue());
    }
}

