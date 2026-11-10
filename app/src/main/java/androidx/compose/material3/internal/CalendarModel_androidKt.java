package androidx.compose.material3.internal;

import android.icu.text.DateFormat;
import android.icu.text.DisplayContext;
import android.icu.util.TimeZone;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\u001A\u0014\u0010\u0000\u001A\u00020\u00012\n\u0010\u0002\u001A\u00060\u0003j\u0002`\u0004H\u0000\u001A8\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\u00062\n\u0010\u0002\u001A\u00060\u0003j\u0002`\u00042\u0012\u0010\n\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f0\u000BH\u0000¨\u0006\r"}, d2={"createCalendarModel", "Landroidx/compose/material3/internal/CalendarModel;", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "formatWithSkeleton", "", "utcTimeMillis", "", "skeleton", "cache", "", "", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class CalendarModel_androidKt {
    public static final CalendarModel createCalendarModel(Locale arg1) {
        return new CalendarModelImpl(arg1);
    }

    public static final String formatWithSkeleton(long arg2, String arg4, Locale arg5, Map arg6) {
        DateFormat v1_1;
        String v0 = "S:" + arg4 + arg5.toLanguageTag();
        Object v1 = arg6.get(v0);
        if(v1 == null) {
            v1_1 = DateFormat.getInstanceForSkeleton(arg4, arg5);
            v1_1.setContext(DisplayContext.CAPITALIZATION_FOR_STANDALONE);
            v1_1.setTimeZone(TimeZone.GMT_ZONE);
            arg6.put(v0, v1_1);
        }

        Intrinsics.checkNotNull(v1_1, "null cannot be cast to non-null type android.icu.text.DateFormat");
        return v1_1.format(new Date(arg2));
    }
}

