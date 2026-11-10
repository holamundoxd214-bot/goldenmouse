package androidx.compose.ui.input.pointer;

import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\u000E\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B!\b\u0010\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\b\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\tJ\b\u0010\u0010\u001A\u00020\u0011H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\r\u001A\u0004\b\f\u0010\u000BR \u0010\b\u001A\u00020\u00052\u0006\u0010\u000E\u001A\u00020\u0005@BX\u0080\u000E¢\u0006\n\n\u0002\u0010\r\u001A\u0004\b\u000F\u0010\u000B¨\u0006\u0012"}, d2={"Landroidx/compose/ui/input/pointer/HistoricalChange;", "", "uptimeMillis", "", "position", "Landroidx/compose/ui/geometry/Offset;", "<init>", "(JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "originalEventPosition", "(JJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getUptimeMillis", "()J", "getPosition-F1C5BW0", "J", "value", "getOriginalEventPosition-F1C5BW0$ui", "toString", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class HistoricalChange {
    public static final int $stable;
    private long originalEventPosition;
    private final long position;
    private final long uptimeMillis;

    static {
    }

    private HistoricalChange(long arg1, long arg3) {
        super();
        this.uptimeMillis = arg1;
        this.position = arg3;
        this.originalEventPosition = Offset.Companion.getZero-F1C5BW0();
    }

    private HistoricalChange(long arg7, long arg9, long arg11) {
        this(arg7, arg9, null);
        this.originalEventPosition = arg11;
    }

    public HistoricalChange(long arg1, long arg3, DefaultConstructorMarker arg5) {
        this(arg1, arg3);
    }

    public HistoricalChange(long arg1, long arg3, long arg5, DefaultConstructorMarker arg7) {
        this(arg1, arg3, arg5);
    }

    public final long getOriginalEventPosition-F1C5BW0$ui() {
        return this.originalEventPosition;
    }

    public final long getPosition-F1C5BW0() {
        return this.position;
    }

    public final long getUptimeMillis() {
        return this.uptimeMillis;
    }

    public String toString() {
        return "HistoricalChange(uptimeMillis=" + this.uptimeMillis + ", position=" + Offset.toString-impl(this.position) + ')';
    }
}

