package androidx.compose.material3;

import androidx.compose.material3.internal.CalendarModel_androidKt;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\t\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\u000F\u001A\u0004\u0018\u00010\u00032\b\u0010\u0010\u001A\u0004\u0018\u00010\u00112\n\u0010\u0012\u001A\u00060\u0013j\u0002`\u0014H\u0016¢\u0006\u0002\u0010\u0015J-\u0010\u0016\u001A\u0004\u0018\u00010\u00032\b\u0010\u0017\u001A\u0004\u0018\u00010\u00112\n\u0010\u0012\u001A\u00060\u0013j\u0002`\u00142\u0006\u0010\u0018\u001A\u00020\u0019H\u0016¢\u0006\u0002\u0010\u001AJ\u0013\u0010\u001B\u001A\u00020\u00192\b\u0010\u001C\u001A\u0004\u0018\u00010\u000EH\u0096\u0002J\b\u0010\u001D\u001A\u00020\u001EH\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\tR\u001A\u0010\f\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000E0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001F"}, d2={"Landroidx/compose/material3/DatePickerFormatterImpl;", "Landroidx/compose/material3/DatePickerFormatter;", "yearSelectionSkeleton", "", "selectedDateSkeleton", "selectedDateDescriptionSkeleton", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getYearSelectionSkeleton", "()Ljava/lang/String;", "getSelectedDateSkeleton", "getSelectedDateDescriptionSkeleton", "formatterCache", "", "", "formatMonthYear", "monthMillis", "", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "(Ljava/lang/Long;Ljava/util/Locale;)Ljava/lang/String;", "formatDate", "dateMillis", "forContentDescription", "", "(Ljava/lang/Long;Ljava/util/Locale;Z)Ljava/lang/String;", "equals", "other", "hashCode", "", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) final class DatePickerFormatterImpl implements DatePickerFormatter {
    private final Map formatterCache;
    private final String selectedDateDescriptionSkeleton;
    private final String selectedDateSkeleton;
    private final String yearSelectionSkeleton;

    public DatePickerFormatterImpl(String arg1, String arg2, String arg3) {
        super();
        this.yearSelectionSkeleton = arg1;
        this.selectedDateSkeleton = arg2;
        this.selectedDateDescriptionSkeleton = arg3;
        this.formatterCache = new LinkedHashMap();
    }

    public boolean equals(Object arg4) {
        if(!(arg4 instanceof DatePickerFormatterImpl)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.yearSelectionSkeleton, ((DatePickerFormatterImpl)arg4).yearSelectionSkeleton)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.selectedDateSkeleton, ((DatePickerFormatterImpl)arg4).selectedDateSkeleton)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.selectedDateDescriptionSkeleton, ((DatePickerFormatterImpl)arg4).selectedDateDescriptionSkeleton)) {
            return 0;
        }

        return 1;
    }

    public String formatDate(Long arg3, Locale arg4, boolean arg5) {
        if(arg3 == null) {
            return null;
        }

        long v0 = arg3.longValue();
        String v3 = arg5 ? this.selectedDateDescriptionSkeleton : this.selectedDateSkeleton;
        return CalendarModel_androidKt.formatWithSkeleton(v0, v3, arg4, this.formatterCache);
    }

    public String formatMonthYear(Long arg3, Locale arg4) {
        if(arg3 == null) {
            return null;
        }

        return CalendarModel_androidKt.formatWithSkeleton(arg3.longValue(), this.yearSelectionSkeleton, arg4, this.formatterCache);
    }

    public final String getSelectedDateDescriptionSkeleton() {
        return this.selectedDateDescriptionSkeleton;
    }

    public final String getSelectedDateSkeleton() {
        return this.selectedDateSkeleton;
    }

    public final String getYearSelectionSkeleton() {
        return this.yearSelectionSkeleton;
    }

    public int hashCode() {
        return (this.yearSelectionSkeleton.hashCode() * 0x1F + this.selectedDateSkeleton.hashCode()) * 0x1F + this.selectedDateDescriptionSkeleton.hashCode();
    }
}

