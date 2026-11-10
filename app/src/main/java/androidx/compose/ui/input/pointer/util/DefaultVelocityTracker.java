package androidx.compose.ui.input.pointer.util;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.HistoricalChange;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001F\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u00112\u0006\u0010\u0017\u001A\u00020\nH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u001BH\u0016¢\u0006\u0004\b\u001D\u0010\u001EJ\u001F\u0010\u001F\u001A\u00020\u00152\u0006\u0010 \u001A\u00020!2\u0006\u0010\"\u001A\u00020\nH\u0016¢\u0006\u0004\b#\u0010$J\b\u0010%\u001A\u00020\u0015H\u0016J\u001F\u0010&\u001A\u00020\u00152\u0006\u0010 \u001A\u00020!2\u0006\u0010\"\u001A\u00020\nH\u0002¢\u0006\u0004\b\'\u0010$J\u001F\u0010(\u001A\u00020\u00152\u0006\u0010 \u001A\u00020!2\u0006\u0010\"\u001A\u00020\nH\u0002¢\u0006\u0004\b)\u0010$R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001C\u0010\t\u001A\u00020\nX\u0080\u000E¢\u0006\u0010\n\u0002\u0010\u000F\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000ER\u001A\u0010\u0010\u001A\u00020\u0011X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0012\u0010\f\"\u0004\b\u0013\u0010\u000E¨\u0006*"}, d2={"Landroidx/compose/ui/input/pointer/util/DefaultVelocityTracker;", "Landroidx/compose/ui/input/pointer/util/PlatformVelocityTracker;", "<init>", "()V", "strategy", "Landroidx/compose/ui/input/pointer/util/VelocityTracker1D$Strategy;", "xVelocityTracker", "Landroidx/compose/ui/input/pointer/util/VelocityTracker1D;", "yVelocityTracker", "currentPointerPositionAccumulator", "Landroidx/compose/ui/geometry/Offset;", "getCurrentPointerPositionAccumulator-F1C5BW0$ui", "()J", "setCurrentPointerPositionAccumulator-k-4lQ0M$ui", "(J)V", "J", "lastMoveEventTimeStamp", "", "getLastMoveEventTimeStamp$ui", "setLastMoveEventTimeStamp$ui", "addPosition", "", "timeMillis", "position", "addPosition-Uv8p0NA", "(JJ)V", "calculateVelocity", "Landroidx/compose/ui/unit/Velocity;", "maximumVelocity", "calculateVelocity-AH228Gc", "(J)J", "addPointerInputChange", "event", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "offset", "addPointerInputChange-Uv8p0NA", "(Landroidx/compose/ui/input/pointer/PointerInputChange;J)V", "resetTracking", "addPointerInputChangeLegacy", "addPointerInputChangeLegacy-Uv8p0NA", "addPointerInputChangeWithFix", "addPointerInputChangeWithFix-Uv8p0NA", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DefaultVelocityTracker implements PlatformVelocityTracker {
    public static final int $stable = 8;
    private long currentPointerPositionAccumulator;
    private long lastMoveEventTimeStamp;
    private final Strategy strategy;
    private final VelocityTracker1D xVelocityTracker;
    private final VelocityTracker1D yVelocityTracker;

    static {
    }

    public DefaultVelocityTracker() {
        super();
        Strategy v0 = Strategy.Lsq2;
        this.strategy = v0;
        this.xVelocityTracker = new VelocityTracker1D(false, v0, 1, null);
        this.yVelocityTracker = new VelocityTracker1D(false, v0, 1, null);
        this.currentPointerPositionAccumulator = Offset.Companion.getZero-F1C5BW0();
    }

    public void addPointerInputChange-Uv8p0NA(PointerInputChange arg2, long arg3) {
        if(VelocityTrackerKt.getVelocityTrackerAddPointsFix()) {
            this.addPointerInputChangeWithFix-Uv8p0NA(arg2, arg3);
            return;
        }

        this.addPointerInputChangeLegacy-Uv8p0NA(arg2, arg3);
    }

    private final void addPointerInputChangeLegacy-Uv8p0NA(PointerInputChange arg11, long arg12) {
        if(PointerEventKt.changedToDownIgnoreConsumed(arg11)) {
            this.currentPointerPositionAccumulator = arg11.getPosition-F1C5BW0();
            this.resetTracking();
        }

        long v0 = arg11.getPreviousPosition-F1C5BW0();
        List v2 = arg11.getHistorical();
        int v3 = v2.size();
        int v4 = 0;
        while(v4 < v3) {
            Object v5 = v2.get(v4);
            v0 = Offset.minus-MK-Hz9U(((HistoricalChange)v5).getPosition-F1C5BW0(), v0);
            long v6 = ((HistoricalChange)v5).getPosition-F1C5BW0();
            this.currentPointerPositionAccumulator = Offset.plus-MK-Hz9U(this.currentPointerPositionAccumulator, v0);
            this.addPosition-Uv8p0NA(((HistoricalChange)v5).getUptimeMillis(), Offset.plus-MK-Hz9U(this.currentPointerPositionAccumulator, arg12));
            ++v4;
            v0 = v6;
        }

        this.currentPointerPositionAccumulator = Offset.plus-MK-Hz9U(this.currentPointerPositionAccumulator, Offset.minus-MK-Hz9U(arg11.getPosition-F1C5BW0(), v0));
        this.addPosition-Uv8p0NA(arg11.getUptimeMillis(), Offset.plus-MK-Hz9U(this.currentPointerPositionAccumulator, arg12));
    }

    private final void addPointerInputChangeWithFix-Uv8p0NA(PointerInputChange arg9, long arg10) {
        if(PointerEventKt.changedToDownIgnoreConsumed(arg9)) {
            this.resetTracking();
        }

        if(!PointerEventKt.changedToUpIgnoreConsumed(arg9)) {
            List v0 = arg9.getHistorical();
            int v1 = v0.size();
            int v2;
            for(v2 = 0; v2 < v1; ++v2) {
                Object v3 = v0.get(v2);
                this.addPosition-Uv8p0NA(((HistoricalChange)v3).getUptimeMillis(), Offset.plus-MK-Hz9U(((HistoricalChange)v3).getOriginalEventPosition-F1C5BW0$ui(), arg10));
            }

            this.addPosition-Uv8p0NA(arg9.getUptimeMillis(), Offset.plus-MK-Hz9U(arg9.getOriginalEventPosition-F1C5BW0$ui(), arg10));
        }

        if((PointerEventKt.changedToUpIgnoreConsumed(arg9)) && arg9.getUptimeMillis() - this.lastMoveEventTimeStamp > 40) {
            this.resetTracking();
        }

        this.lastMoveEventTimeStamp = arg9.getUptimeMillis();
    }

    public void addPosition-Uv8p0NA(long arg4, long arg6) {
        this.xVelocityTracker.addDataPoint(arg4, Float.intBitsToFloat(((int)(arg6 >> 0x20))));
        this.yVelocityTracker.addDataPoint(arg4, Float.intBitsToFloat(((int)(arg6 & 0xFFFFFFFFL))));
    }

    public long calculateVelocity-AH228Gc(long arg3) {
        int v0 = Velocity.getX-impl(arg3) <= 0f || Velocity.getY-impl(arg3) <= 0f ? 0 : 1;
        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalStateException("maximumVelocity should be a positive value. You specified=" + Velocity.toString-impl(arg3));
        }

        return VelocityKt.Velocity(this.xVelocityTracker.calculateVelocity(Velocity.getX-impl(arg3)), this.yVelocityTracker.calculateVelocity(Velocity.getY-impl(arg3)));
    }

    public final long getCurrentPointerPositionAccumulator-F1C5BW0$ui() {
        return this.currentPointerPositionAccumulator;
    }

    public final long getLastMoveEventTimeStamp$ui() {
        return this.lastMoveEventTimeStamp;
    }

    public void resetTracking() {
        this.xVelocityTracker.resetTracking();
        this.yVelocityTracker.resetTracking();
        this.lastMoveEventTimeStamp = 0;
    }

    public final void setCurrentPointerPositionAccumulator-k-4lQ0M$ui(long arg1) {
        this.currentPointerPositionAccumulator = arg1;
    }

    public final void setLastMoveEventTimeStamp$ui(long arg1) {
        this.lastMoveEventTimeStamp = arg1;
    }
}

