package androidx.compose.material3;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.material3.internal.CalendarMonth;
import androidx.compose.runtime.MutableState;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.CoroutineScope;

public final class DatePickerKt$DatePickerContent$2$4$2$$ExternalSyntheticLambda1 implements Function1 {
    public DatePickerKt$DatePickerContent$2$4$2$$ExternalSyntheticLambda1(CoroutineScope arg1, MutableState arg2, LazyListState arg3, IntRange arg4, CalendarMonth arg5) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
        this.f$4 = arg5;
    }

    public final Object invoke(Object arg7) {
        return DatePickerKt$DatePickerContent$2$4$2.invoke$lambda$4$lambda$3$lambda$2(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, ((Integer)arg7).intValue());
    }
}

