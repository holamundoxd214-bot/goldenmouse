package androidx.compose.material3;

import androidx.compose.material3.internal.CalendarDate;
import androidx.compose.material3.internal.DateInputFormat;
import androidx.compose.material3.internal.Strings_androidKt;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\u000B\u0012\u0006\u0010\f\u001A\u00020\u000B\u0012\u0006\u0010\r\u001A\u00020\u000B\u0012\u0006\u0010\u000E\u001A\u00020\u000B¢\u0006\u0004\b\u000F\u0010\u0010J+\u0010\u001B\u001A\u00020\u000B2\b\u0010\u001C\u001A\u0004\u0018\u00010\u001D2\u0006\u0010\u001E\u001A\u00020\u001F2\n\u0010 \u001A\u00060!j\u0002`\"¢\u0006\u0004\b#\u0010$R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u001E\u0010\u0011\u001A\u0004\u0018\u00010\u0012X\u0086\u000E¢\u0006\u0010\n\u0002\u0010\u0017\u001A\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001E\u0010\u0018\u001A\u0004\u0018\u00010\u0012X\u0086\u000E¢\u0006\u0010\n\u0002\u0010\u0017\u001A\u0004\b\u0019\u0010\u0014\"\u0004\b\u001A\u0010\u0016¨\u0006%"}, d2={"Landroidx/compose/material3/DateInputValidator;", "", "yearRange", "Lkotlin/ranges/IntRange;", "selectableDates", "Landroidx/compose/material3/SelectableDates;", "dateInputFormat", "Landroidx/compose/material3/internal/DateInputFormat;", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "errorDatePattern", "", "errorDateOutOfYearRange", "errorInvalidNotAllowed", "errorInvalidRangeInput", "<init>", "(Lkotlin/ranges/IntRange;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/internal/DateInputFormat;Landroidx/compose/material3/DatePickerFormatter;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "currentStartDateMillis", "", "getCurrentStartDateMillis", "()Ljava/lang/Long;", "setCurrentStartDateMillis", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "currentEndDateMillis", "getCurrentEndDateMillis", "setCurrentEndDateMillis", "validate", "dateToValidate", "Landroidx/compose/material3/internal/CalendarDate;", "inputIdentifier", "Landroidx/compose/material3/InputIdentifier;", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "validate-XivgLIo", "(Landroidx/compose/material3/internal/CalendarDate;ILjava/util/Locale;)Ljava/lang/String;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DateInputValidator {
    public static final int $stable;
    private Long currentEndDateMillis;
    private Long currentStartDateMillis;
    private final DatePickerFormatter dateFormatter;
    private final DateInputFormat dateInputFormat;
    private final String errorDateOutOfYearRange;
    private final String errorDatePattern;
    private final String errorInvalidNotAllowed;
    private final String errorInvalidRangeInput;
    private final SelectableDates selectableDates;
    private final IntRange yearRange;

    static {
    }

    public DateInputValidator(IntRange arg1, SelectableDates arg2, DateInputFormat arg3, DatePickerFormatter arg4, String arg5, String arg6, String arg7, String arg8) {
        super();
        this.yearRange = arg1;
        this.selectableDates = arg2;
        this.dateInputFormat = arg3;
        this.dateFormatter = arg4;
        this.errorDatePattern = arg5;
        this.errorDateOutOfYearRange = arg6;
        this.errorInvalidNotAllowed = arg7;
        this.errorInvalidRangeInput = arg8;
    }

    public final Long getCurrentEndDateMillis() {
        return this.currentEndDateMillis;
    }

    public final Long getCurrentStartDateMillis() {
        return this.currentStartDateMillis;
    }

    public final void setCurrentEndDateMillis(Long arg1) {
        this.currentEndDateMillis = arg1;
    }

    public final void setCurrentStartDateMillis(Long arg1) {
        this.currentStartDateMillis = arg1;
    }

    public final String validate-XivgLIo(CalendarDate arg8, int arg9, Locale arg10) {
        Long v10_1;
        long v0;
        if(arg8 == null) {
            String v8 = this.errorDatePattern;
            String v7 = this.dateInputFormat.getPatternWithDelimiters().toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(v7, "toUpperCase(...)");
            return Strings_androidKt.formatString(v8, new Object[]{v7});
        }

        if(!this.yearRange.contains(arg8.getYear())) {
            return Strings_androidKt.formatString(this.errorDateOutOfYearRange, new Object[]{CalendarLocale_jvmKt.toLocalString$default(this.yearRange.getFirst(), 0, 0, false, arg10, 7, null), CalendarLocale_jvmKt.toLocalString$default(this.yearRange.getLast(), 0, 0, false, arg10, 7, null)});
        }

        Locale v4 = arg10;
        SelectableDates v10 = this.selectableDates;
        if(v10.isSelectableYear(arg8.getYear())) {
            if(!v10.isSelectableDate(arg8.getUtcTimeMillis())) {
            }
            else {
                if(InputIdentifier.equals-impl0(arg9, InputIdentifier.Companion.getStartDateInput-J2x2o4M())) {
                    v0 = arg8.getUtcTimeMillis();
                    v10_1 = this.currentEndDateMillis;
                    long v2 = v10_1 != null ? v10_1.longValue() : 0x7FFFFFFFFFFFFFFFL;
                    if(v0 > v2) {
                        goto label_62;
                    }

                    goto label_51;
                }
                else {
                label_51:
                    if(InputIdentifier.equals-impl0(arg9, InputIdentifier.Companion.getEndDateInput-J2x2o4M())) {
                        long v8_1 = arg8.getUtcTimeMillis();
                        v10_1 = this.currentStartDateMillis;
                        v0 = v10_1 != null ? v10_1.longValue() : -9223372036854775808L;
                        if(v8_1 >= v0) {
                            return "";
                        }

                        goto label_62;
                    }

                    return "";
                }

            label_62:
                return this.errorInvalidRangeInput;
            }
        }

        return Strings_androidKt.formatString(this.errorInvalidNotAllowed, new Object[]{DatePickerFormatter.formatDate$default(this.dateFormatter, Long.valueOf(arg8.getUtcTimeMillis()), v4, false, 4, null)});
    }
}

