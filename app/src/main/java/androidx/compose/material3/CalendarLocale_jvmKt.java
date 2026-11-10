package androidx.compose.material3;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Metadata;

@Metadata(d1={"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A<\u0010\u0002\u001A\u00020\u0003*\u00020\u00042\b\b\u0002\u0010\u0005\u001A\u00020\u00042\b\b\u0002\u0010\u0006\u001A\u00020\u00042\b\b\u0002\u0010\u0007\u001A\u00020\b2\u0010\b\u0002\u0010\t\u001A\n\u0018\u00010\u0001j\u0004\u0018\u0001`\nH\u0000\u001A,\u0010\u000E\u001A\u00020\r2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0006\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\b2\n\u0010\t\u001A\u00060\u0001j\u0002`\nH\u0002\"\u001A\u0010\u000B\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000*\n\u0010\u0000\"\u00020\u00012\u00020\u0001¨\u0006\u000F"}, d2={"CalendarLocale", "Ljava/util/Locale;", "toLocalString", "", "", "minDigits", "maxDigits", "isGroupingUsed", "", "locale", "Landroidx/compose/material3/CalendarLocale;", "cachedFormatters", "Ljava/util/WeakHashMap;", "Ljava/text/NumberFormat;", "getCachedDateTimeFormatter", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class CalendarLocale_jvmKt {
    private static final WeakHashMap cachedFormatters;

    static {
        CalendarLocale_jvmKt.cachedFormatters = new WeakHashMap();
    }

    private static final NumberFormat getCachedDateTimeFormatter(int arg3, int arg4, boolean arg5, Locale arg6) {
        NumberFormat v2_1;
        String v0 = arg3 + '.' + arg4 + '.' + arg5 + '.' + arg6.toLanguageTag();
        WeakHashMap v1 = CalendarLocale_jvmKt.cachedFormatters;
        Object v2 = ((Map)v1).get(v0);
        if(v2 == null) {
            v2_1 = NumberFormat.getIntegerInstance(arg6);
            v2_1.setGroupingUsed(arg5);
            v2_1.setMinimumIntegerDigits(arg3);
            v2_1.setMaximumIntegerDigits(arg4);
            ((Map)v1).put(v0, v2_1);
        }

        return v2_1;
    }

    public static final String toLocalString(int arg0, int arg1, int arg2, boolean arg3, Locale arg4) {
        if(arg4 == null) {
            arg4 = Locale.getDefault();
        }

        return CalendarLocale_jvmKt.getCachedDateTimeFormatter(arg1, arg2, arg3, arg4).format(Integer.valueOf(arg0));
    }

    public static String toLocalString$default(int arg0, int arg1, int arg2, boolean arg3, Locale arg4, int arg5, Object arg6) {
        if((arg5 & 2) != 0) {
            arg2 = 40;
        }

        if((arg5 & 8) != 0) {
            arg4 = null;
        }

        return CalendarLocale_jvmKt.toLocalString(arg0, 1, arg2, false, arg4);
    }
}

