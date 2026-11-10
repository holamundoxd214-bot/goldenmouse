package androidx.compose.material3.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchGroup;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000\u001A\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u001A\u0010\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0000\"\u000E\u0010\u0004\u001A\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0006\u001A\u00020\u0007X\u0080T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2={"datePatternAsInputFormat", "Landroidx/compose/material3/internal/DateInputFormat;", "localeFormat", "", "DaysInWeek", "", "MillisecondsIn24Hours", "", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class CalendarModelKt {
    public static final int DaysInWeek = 7;
    public static final long MillisecondsIn24Hours = 86400000;

    public static final DateInputFormat datePatternAsInputFormat(String arg8) {
        arg8 = StringsKt.removeSuffix(StringsKt.replace$default(new Regex("y{1,4}").replace(new Regex("M{1,2}").replace(new Regex("d{1,2}").replace(new Regex("[^dMy/\\-.]").replace(((CharSequence)arg8), ""), "dd"), "MM"), "yyyy"), "My", "M/y", false, 4, null), ".");
        MatchResult v0 = Regex.find$default(new Regex("[/\\-.]"), arg8, 0, 2, null);
        Intrinsics.checkNotNull(v0);
        MatchGroup v0_1 = v0.getGroups().get(0);
        Intrinsics.checkNotNull(v0_1);
        return new DateInputFormat(arg8, v0_1.getValue().charAt(0));
    }
}

