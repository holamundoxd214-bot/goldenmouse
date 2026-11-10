package androidx.compose.material3.internal;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.chrono.Chronology;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.format.DecimalStyle;
import java.time.format.FormatStyle;
import java.time.format.TextStyle;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u0000 -2\u00020\u0001:\u0001-B\u0013\u0012\n\u0010\u0002\u001A\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\u0015\u001A\u00020\u00162\n\u0010\u0002\u001A\u00060\u0003j\u0002`\u0004H\u0016J\u0010\u0010\u0017\u001A\u00020\b2\u0006\u0010\u0018\u001A\u00020\u0019H\u0016J\u0010\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\u0018\u001A\u00020\u0019H\u0016J\u0010\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\bH\u0016J\u0018\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\u001D\u001A\u00020\f2\u0006\u0010\u001E\u001A\u00020\fH\u0016J\u0010\u0010\u001F\u001A\u00020\f2\u0006\u0010\u001C\u001A\u00020\bH\u0016J\u0018\u0010 \u001A\u00020\u001B2\u0006\u0010!\u001A\u00020\u001B2\u0006\u0010\"\u001A\u00020\fH\u0016J\u0018\u0010#\u001A\u00020\u001B2\u0006\u0010!\u001A\u00020\u001B2\u0006\u0010$\u001A\u00020\fH\u0016J$\u0010%\u001A\u00020\u00122\u0006\u0010&\u001A\u00020\u00192\u0006\u0010\'\u001A\u00020\u00122\n\u0010\u0002\u001A\u00060\u0003j\u0002`\u0004H\u0016J&\u0010(\u001A\u0004\u0018\u00010\b2\u0006\u0010\u001C\u001A\u00020\u00122\u0006\u0010\'\u001A\u00020\u00122\n\u0010\u0002\u001A\u00060\u0003j\u0002`\u0004H\u0016J\b\u0010)\u001A\u00020\u0012H\u0016J\u0010\u0010\u001A\u001A\u00020\u001B2\u0006\u0010*\u001A\u00020+H\u0002J\f\u0010,\u001A\u00020+*\u00020\u001BH\u0002J\f\u0010,\u001A\u00020+*\u00020\bH\u0002R\u0014\u0010\u0007\u001A\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\t\u0010\nR\u0014\u0010\u000B\u001A\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER&\u0010\u000F\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u00110\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014¨\u0006."}, d2={"Landroidx/compose/material3/internal/CalendarModelImpl;", "Landroidx/compose/material3/internal/CalendarModel;", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "<init>", "(Ljava/util/Locale;)V", "today", "Landroidx/compose/material3/internal/CalendarDate;", "getToday", "()Landroidx/compose/material3/internal/CalendarDate;", "firstDayOfWeek", "", "getFirstDayOfWeek", "()I", "weekdayNames", "", "Lkotlin/Pair;", "", "getWeekdayNames", "()Ljava/util/List;", "getDateInputFormat", "Landroidx/compose/material3/internal/DateInputFormat;", "getCanonicalDate", "timeInMillis", "", "getMonth", "Landroidx/compose/material3/internal/CalendarMonth;", "date", "year", "month", "getDayOfWeek", "plusMonths", "from", "addedMonthsCount", "minusMonths", "subtractedMonthsCount", "formatWithPattern", "utcTimeMillis", "pattern", "parse", "toString", "firstDayLocalDate", "Ljava/time/LocalDate;", "toLocalDate", "Companion", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class CalendarModelImpl extends CalendarModel {
    @Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J6\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u00052\n\u0010\t\u001A\u00060\nj\u0002`\u000B2\u0012\u0010\f\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\rJ0\u0010\u0012\u001A\u00020\u00132\u0006\u0010\b\u001A\u00020\u00052\n\u0010\t\u001A\u00060\nj\u0002`\u000B2\u0012\u0010\f\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\rH\u0002R\u0014\u0010\u000E\u001A\u00020\u000FX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2={"Landroidx/compose/material3/internal/CalendarModelImpl$Companion;", "", "<init>", "()V", "formatWithPattern", "", "utcTimeMillis", "", "pattern", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "cache", "", "utcTimeZoneId", "Ljava/time/ZoneId;", "getUtcTimeZoneId$material3", "()Ljava/time/ZoneId;", "getCachedDateTimeFormatter", "Ljava/time/format/DateTimeFormatter;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public static final DateTimeFormatter access$getCachedDateTimeFormatter(Companion arg0, String arg1, Locale arg2, Map arg3) {
            return arg0.getCachedDateTimeFormatter(arg1, arg2, arg3);
        }

        public final String formatWithPattern(long arg1, String arg3, Locale arg4, Map arg5) {
            return Instant.ofEpochMilli(arg1).atZone(this.getUtcTimeZoneId$material3()).toLocalDate().format(this.getCachedDateTimeFormatter(arg3, arg4, arg5));
        }

        private final DateTimeFormatter getCachedDateTimeFormatter(String arg2, Locale arg3, Map arg4) {
            DateTimeFormatter v0_1;
            String v1 = "P:" + arg2 + arg3.toLanguageTag();
            Object v0 = arg4.get(v1);
            if(v0 == null) {
                v0_1 = DateTimeFormatter.ofPattern(arg2, arg3).withDecimalStyle(DecimalStyle.of(arg3));
                arg4.put(v1, v0_1);
            }

            Intrinsics.checkNotNull(v0_1, "null cannot be cast to non-null type java.time.format.DateTimeFormatter");
            return v0_1;
        }

        public final ZoneId getUtcTimeZoneId$material3() {
            return CalendarModelImpl.utcTimeZoneId;
        }
    }

    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class EntriesMappings {
        static {
            EntriesMappings.entries$0 = EnumEntriesKt.enumEntries(DayOfWeek.values());
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private final int firstDayOfWeek;
    private static final ZoneId utcTimeZoneId;
    private final List weekdayNames;

    static {
        CalendarModelImpl.Companion = new Companion(null);
        CalendarModelImpl.$stable = 8;
        CalendarModelImpl.utcTimeZoneId = ZoneId.of("UTC");
    }

    public CalendarModelImpl(Locale arg9) {
        super(arg9);
        this.firstDayOfWeek = WeekFields.of(arg9).getFirstDayOfWeek().getValue();
        EnumEntries v0 = EntriesMappings.entries$0;
        ArrayList v1 = new ArrayList(((List)v0).size());
        int v2 = v0.size();
        int v3;
        for(v3 = 0; v3 < v2; ++v3) {
            Object v4 = ((List)v0).get(v3);
            v1.add(TuplesKt.to(((DayOfWeek)v4).getDisplayName(TextStyle.FULL_STANDALONE, arg9), ((DayOfWeek)v4).getDisplayName(TextStyle.NARROW_STANDALONE, arg9)));
        }

        this.weekdayNames = ((List)v1);
    }

    public static final ZoneId access$getUtcTimeZoneId$cp() {
        return CalendarModelImpl.utcTimeZoneId;
    }

    public String formatWithPattern(long arg7, String arg9, Locale arg10) {
        return CalendarModelImpl.Companion.formatWithPattern(arg7, arg9, arg10, this.getFormatterCache$material3());
    }

    public CalendarDate getCanonicalDate(long arg7) {
        LocalDate v6 = Instant.ofEpochMilli(arg7).atZone(CalendarModelImpl.utcTimeZoneId).toLocalDate();
        return new CalendarDate(v6.getYear(), v6.getMonthValue(), v6.getDayOfMonth(), 1000 * v6.atStartOfDay().toEpochSecond(ZoneOffset.UTC));
    }

    public DateInputFormat getDateInputFormat(Locale arg3) {
        return CalendarModelKt.datePatternAsInputFormat(DateTimeFormatterBuilder.getLocalizedDateTimePattern(FormatStyle.SHORT, null, Chronology.ofLocale(arg3), arg3));
    }

    public int getDayOfWeek(CalendarDate arg1) {
        return this.toLocalDate(arg1).getDayOfWeek().getValue();
    }

    public int getFirstDayOfWeek() {
        return this.firstDayOfWeek;
    }

    private final CalendarMonth getMonth(LocalDate arg9) {
        int v0 = arg9.getDayOfWeek().getValue() - this.getFirstDayOfWeek();
        if(v0 < 0) {
            v0 += 7;
        }

        return new CalendarMonth(arg9.getYear(), arg9.getMonthValue(), arg9.lengthOfMonth(), v0, arg9.atTime(LocalTime.MIDNIGHT).atZone(CalendarModelImpl.utcTimeZoneId).toInstant().toEpochMilli());
    }

    public CalendarMonth getMonth(int arg2, int arg3) {
        return this.getMonth(LocalDate.of(arg2, arg3, 1));
    }

    public CalendarMonth getMonth(long arg1) {
        return this.getMonth(Instant.ofEpochMilli(arg1).atZone(CalendarModelImpl.utcTimeZoneId).withDayOfMonth(1).toLocalDate());
    }

    public CalendarMonth getMonth(CalendarDate arg3) {
        return this.getMonth(LocalDate.of(arg3.getYear(), arg3.getMonth(), 1));
    }

    public CalendarDate getToday() {
        LocalDate v6 = LocalDate.now();
        return new CalendarDate(v6.getYear(), v6.getMonthValue(), v6.getDayOfMonth(), v6.atTime(LocalTime.MIDNIGHT).atZone(CalendarModelImpl.utcTimeZoneId).toInstant().toEpochMilli());
    }

    public List getWeekdayNames() {
        return this.weekdayNames;
    }

    public CalendarMonth minusMonths(CalendarMonth arg3, int arg4) {
        if(arg4 <= 0) {
            return arg3;
        }

        return this.getMonth(this.toLocalDate(arg3).minusMonths(((long)arg4)));
    }

    public CalendarDate parse(String arg7, String arg8, Locale arg9) {
        DateTimeFormatter v6 = Companion.access$getCachedDateTimeFormatter(CalendarModelImpl.Companion, arg8, arg9, this.getFormatterCache$material3());
        try {
            LocalDate v6_1 = LocalDate.parse(((CharSequence)arg7), v6);
            return new CalendarDate(v6_1.getYear(), v6_1.getMonth().getValue(), v6_1.getDayOfMonth(), v6_1.atTime(LocalTime.MIDNIGHT).atZone(CalendarModelImpl.utcTimeZoneId).toInstant().toEpochMilli());
        }
        catch(DateTimeParseException ) {
            return null;
        }
    }

    public CalendarMonth plusMonths(CalendarMonth arg3, int arg4) {
        if(arg4 <= 0) {
            return arg3;
        }

        return this.getMonth(this.toLocalDate(arg3).plusMonths(((long)arg4)));
    }

    private final LocalDate toLocalDate(CalendarDate arg2) {
        return LocalDate.of(arg2.getYear(), arg2.getMonth(), arg2.getDayOfMonth());
    }

    private final LocalDate toLocalDate(CalendarMonth arg1) {
        return Instant.ofEpochMilli(arg1.getStartUtcTimeMillis()).atZone(CalendarModelImpl.utcTimeZoneId).toLocalDate();
    }

    public String toString() {
        return "CalendarModel";
    }
}

