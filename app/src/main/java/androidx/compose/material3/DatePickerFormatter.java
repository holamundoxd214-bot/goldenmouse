package androidx.compose.material3;

import java.util.Locale;
import kotlin.Metadata;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J%\u0010\u0002\u001A\u0004\u0018\u00010\u00032\b\u0010\u0004\u001A\u0004\u0018\u00010\u00052\n\u0010\u0006\u001A\u00060\u0007j\u0002`\bH&¢\u0006\u0002\u0010\tJ/\u0010\n\u001A\u0004\u0018\u00010\u00032\b\u0010\u000B\u001A\u0004\u0018\u00010\u00052\n\u0010\u0006\u001A\u00060\u0007j\u0002`\b2\b\b\u0002\u0010\f\u001A\u00020\rH&¢\u0006\u0002\u0010\u000Eø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000FÀ\u0006\u0001"}, d2={"Landroidx/compose/material3/DatePickerFormatter;", "", "formatMonthYear", "", "monthMillis", "", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "(Ljava/lang/Long;Ljava/util/Locale;)Ljava/lang/String;", "formatDate", "dateMillis", "forContentDescription", "", "(Ljava/lang/Long;Ljava/util/Locale;Z)Ljava/lang/String;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public interface DatePickerFormatter {
    String formatDate(Long arg1, Locale arg2, boolean arg3);

    static String formatDate$default(DatePickerFormatter arg0, Long arg1, Locale arg2, boolean arg3, int arg4, Object arg5) {
        if(arg5 == null) {
            return arg0.formatDate(arg1, arg2, false);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: formatDate");
    }

    String formatMonthYear(Long arg1, Locale arg2);
}

