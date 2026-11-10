package androidx.compose.material3;

import androidx.compose.material3.internal.CalendarDate;
import androidx.compose.material3.internal.CalendarMonth;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\f\b\u0001\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\'\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0013\u0010\u0002\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\n\u0010\u000BR\u0013\u0010\u0004\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\r\u0010\u000BR\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0011\u0010\u0007\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u000F¨\u0006\u0012"}, d2={"Landroidx/compose/material3/SelectedRangeInfo;", "", "gridStartCoordinates", "Landroidx/compose/ui/unit/IntOffset;", "gridEndCoordinates", "firstIsSelectionStart", "", "lastIsSelectionEnd", "<init>", "(JJZZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getGridStartCoordinates-nOcc-ac", "()J", "J", "getGridEndCoordinates-nOcc-ac", "getFirstIsSelectionStart", "()Z", "getLastIsSelectionEnd", "Companion", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SelectedRangeInfo {
    @Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\t¨\u0006\u000B"}, d2={"Landroidx/compose/material3/SelectedRangeInfo$Companion;", "", "<init>", "()V", "calculateRangeInfo", "Landroidx/compose/material3/SelectedRangeInfo;", "month", "Landroidx/compose/material3/internal/CalendarMonth;", "startDate", "Landroidx/compose/material3/internal/CalendarDate;", "endDate", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final SelectedRangeInfo calculateRangeInfo(CalendarMonth arg11, CalendarDate arg12, CalendarDate arg13) {
            if(arg12.getUtcTimeMillis() <= arg11.getEndUtcTimeMillis()) {
                if(arg13.getUtcTimeMillis() < arg11.getStartUtcTimeMillis()) {
                }
                else {
                    boolean v7 = Long.compare(arg12.getUtcTimeMillis(), arg11.getStartUtcTimeMillis()) >= 0 ? true : false;
                    boolean v8 = arg13.getUtcTimeMillis() <= arg11.getEndUtcTimeMillis() ? true : false;
                    int v10 = v7 ? arg11.getDaysFromStartOfWeekToFirstOfMonth() + arg12.getDayOfMonth() - 1 : arg11.getDaysFromStartOfWeekToFirstOfMonth();
                    int v11 = v8 ? arg11.getDaysFromStartOfWeekToFirstOfMonth() + arg13.getDayOfMonth() - 1 : arg11.getDaysFromStartOfWeekToFirstOfMonth() + arg11.getNumberOfDays() - 1;
                    return new SelectedRangeInfo(IntOffset.constructor-impl((((long)(v10 % 7))) << 0x20 | (((long)(v10 / 7))) & 0xFFFFFFFFL), IntOffset.constructor-impl((((long)(v11 / 7))) & 0xFFFFFFFFL | (((long)(v11 % 7))) << 0x20), v7, v8, null);
                }
            }

            return null;
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private final boolean firstIsSelectionStart;
    private final long gridEndCoordinates;
    private final long gridStartCoordinates;
    private final boolean lastIsSelectionEnd;

    static {
        SelectedRangeInfo.Companion = new Companion(null);
    }

    private SelectedRangeInfo(long arg1, long arg3, boolean arg5, boolean arg6) {
        super();
        this.gridStartCoordinates = arg1;
        this.gridEndCoordinates = arg3;
        this.firstIsSelectionStart = arg5;
        this.lastIsSelectionEnd = arg6;
    }

    public SelectedRangeInfo(long arg1, long arg3, boolean arg5, boolean arg6, DefaultConstructorMarker arg7) {
        this(arg1, arg3, arg5, arg6);
    }

    public final boolean getFirstIsSelectionStart() {
        return this.firstIsSelectionStart;
    }

    public final long getGridEndCoordinates-nOcc-ac() {
        return this.gridEndCoordinates;
    }

    public final long getGridStartCoordinates-nOcc-ac() {
        return this.gridStartCoordinates;
    }

    public final boolean getLastIsSelectionEnd() {
        return this.lastIsSelectionEnd;
    }
}

