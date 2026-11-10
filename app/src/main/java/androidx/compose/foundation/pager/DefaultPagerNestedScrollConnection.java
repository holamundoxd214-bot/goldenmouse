package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.unit.Velocity;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\f\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\f\u001A\u00020\r*\u00020\r2\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u000E\u0010\u000FJ\u001F\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0013\u001A\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0017\u001A\u00020\u0018*\u00020\u0011H\u0002¢\u0006\u0004\b\u0019\u0010\u001AJ\'\u0010\u001B\u001A\u00020\u00112\u0006\u0010\u001C\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0013\u001A\u00020\u0014H\u0016¢\u0006\u0004\b\u001D\u0010\u001EJ \u0010\u001F\u001A\u00020\r2\u0006\u0010\u001C\u001A\u00020\r2\u0006\u0010\u0012\u001A\u00020\rH\u0096@¢\u0006\u0004\b \u0010!J\u0013\u0010\"\u001A\u00020\u0018*\u00020\u0011H\u0002¢\u0006\u0004\b#\u0010\u001AR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006$"}, d2={"Landroidx/compose/foundation/pager/DefaultPagerNestedScrollConnection;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "state", "Landroidx/compose/foundation/pager/PagerState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "<init>", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/foundation/gestures/Orientation;)V", "getState", "()Landroidx/compose/foundation/pager/PagerState;", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "consumeOnOrientation", "Landroidx/compose/ui/unit/Velocity;", "consumeOnOrientation-QWom1Mo", "(JLandroidx/compose/foundation/gestures/Orientation;)J", "onPreScroll", "Landroidx/compose/ui/geometry/Offset;", "available", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPreScroll-OzD1aCk", "(JI)J", "toFloat", "", "toFloat-k-4lQ0M", "(J)F", "onPostScroll", "consumed", "onPostScroll-DzOQY0M", "(JJI)J", "onPostFling", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mainAxis", "mainAxis-k-4lQ0M", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class DefaultPagerNestedScrollConnection implements NestedScrollConnection {
    private final Orientation orientation;
    private final PagerState state;

    public DefaultPagerNestedScrollConnection(PagerState arg1, Orientation arg2) {
        super();
        this.state = arg1;
        this.orientation = arg2;
    }

    public final long consumeOnOrientation-QWom1Mo(long arg7, Orientation arg9) {
        if(arg9 == Orientation.Vertical) {
            return Velocity.copy-OhffZ5M$default(arg7, 0f, 0f, 2, null);
        }

        return Velocity.copy-OhffZ5M$default(arg7, 0f, 0f, 1, null);
    }

    public final Orientation getOrientation() {
        return this.orientation;
    }

    public final PagerState getState() {
        return this.state;
    }

    private final float mainAxis-k-4lQ0M(long arg3) {
        long v2 = this.orientation == Orientation.Horizontal ? arg3 >> 0x20 : arg3 & 0xFFFFFFFFL;
        return Float.intBitsToFloat(((int)v2));
    }

    public Object onPostFling-RZ2iAVY(long arg1, long arg3, Continuation arg5) {
        return Velocity.box-impl(this.consumeOnOrientation-QWom1Mo(arg3, this.orientation));
    }

    public long onPostScroll-DzOQY0M(long arg1, long arg3, int arg5) {
        if(NestedScrollSource.equals-impl0(arg5, NestedScrollSource.Companion.getSideEffect-WNlRxjI())) {
            if(this.mainAxis-k-4lQ0M(arg3) == 0f) {
            }
            else {
                throw new CancellationException("Scroll cancelled");
            }
        }

        return Offset.Companion.getZero-F1C5BW0();
    }

    public long onPreScroll-OzD1aCk(long arg6, int arg8) {
        if((NestedScrollSource.equals-impl0(arg8, NestedScrollSource.Companion.getUserInput-WNlRxjI())) && (((double)Math.abs(this.state.getCurrentPageOffsetFraction()))) > 0.000001 && Math.abs(this.toFloat-k-4lQ0M(arg6)) > 0f) {
            float v8 = this.state.getCurrentPageOffsetFraction() * (((float)this.state.getPageSize$foundation()));
            float v1 = (((float)(this.state.getLayoutInfo().getPageSize() + this.state.getLayoutInfo().getPageSpacing()))) * -Math.signum(this.state.getCurrentPageOffsetFraction()) + v8;
            if(this.state.getCurrentPageOffsetFraction() > 0f) {
                float v4 = v1;
                v1 = v8;
                v8 = v4;
            }

            v8 = -this.state.dispatchRawDelta(-RangesKt.coerceIn(this.toFloat-k-4lQ0M(arg6), v8, v1));
            float v0 = this.orientation == Orientation.Horizontal ? v8 : Float.intBitsToFloat(((int)(arg6 >> 0x20)));
            if(this.orientation == Orientation.Vertical) {
            }
            else {
                v8 = Float.intBitsToFloat(((int)(0xFFFFFFFFL & arg6)));
            }

            return Offset.copy-dBAh8RU(arg6, v0, v8);
        }

        return Offset.Companion.getZero-F1C5BW0();
    }

    private final float toFloat-k-4lQ0M(long arg3) {
        long v2 = this.orientation == Orientation.Horizontal ? arg3 >> 0x20 : arg3 & 0xFFFFFFFFL;
        return Float.intBitsToFloat(((int)v2));
    }
}

