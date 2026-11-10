package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.unit.Velocity;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ViewCompat;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;

@Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001F\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\'\u0010\u0013\u001A\u00020\r2\u0006\u0010\u0014\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\u0010H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u000E\u001A\u00020\u0018H\u0096@¢\u0006\u0004\b\u0019\u0010\u001AJ \u0010\u001B\u001A\u00020\u00182\u0006\u0010\u0014\u001A\u00020\u00182\u0006\u0010\u000E\u001A\u00020\u0018H\u0096@¢\u0006\u0004\b\u001C\u0010\u001DJ\b\u0010\u001E\u001A\u00020\u001FH\u0002R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2={"Landroidx/compose/ui/platform/NestedScrollInteropConnection;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "view", "Landroid/view/View;", "minFlingVelocity", "", "<init>", "(Landroid/view/View;F)V", "nestedScrollChildHelper", "Landroidx/core/view/NestedScrollingChildHelper;", "consumedScrollCache", "", "onPreScroll", "Landroidx/compose/ui/geometry/Offset;", "available", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPreScroll-OzD1aCk", "(JI)J", "onPostScroll", "consumed", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "Landroidx/compose/ui/unit/Velocity;", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostFling", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stopNestedScrolls", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class NestedScrollInteropConnection implements NestedScrollConnection {
    public static final int $stable = 8;
    private final int[] consumedScrollCache;
    private final float minFlingVelocity;
    private final NestedScrollingChildHelper nestedScrollChildHelper;
    private final View view;

    static {
    }

    public NestedScrollInteropConnection(View arg2, float arg3) {
        super();
        this.view = arg2;
        this.minFlingVelocity = arg3;
        NestedScrollingChildHelper v3 = new NestedScrollingChildHelper(arg2);
        v3.setNestedScrollingEnabled(true);
        this.nestedScrollChildHelper = v3;
        this.consumedScrollCache = new int[2];
        ViewCompat.setNestedScrollingEnabled(arg2, true);
    }

    public Object onPostFling-RZ2iAVY(long arg1, long arg3, Continuation arg5) {
        this.stopNestedScrolls();
        return Velocity.box-impl(Velocity.Companion.getZero-9UxMQ8M());
    }

    public long onPostScroll-DzOQY0M(long arg11, long arg13, int arg15) {
        if(this.nestedScrollChildHelper.startNestedScroll(NestedScrollInteropConnectionKt.access$getScrollAxes-k-4lQ0M(arg13), NestedScrollInteropConnectionKt.access$toViewType-GyEprt8(arg15))) {
            ArraysKt.fill$default(this.consumedScrollCache, 0, 0, 0, 6, null);
            int v5 = NestedScrollInteropConnectionKt.composeToViewOffset(Float.intBitsToFloat(((int)(arg13 >> 0x20))));
            int v6 = NestedScrollInteropConnectionKt.composeToViewOffset(Float.intBitsToFloat(((int)(arg13 & 0xFFFFFFFFL))));
            this.nestedScrollChildHelper.dispatchNestedScroll(NestedScrollInteropConnectionKt.composeToViewOffset(Float.intBitsToFloat(((int)(arg11 >> 0x20)))), NestedScrollInteropConnectionKt.composeToViewOffset(Float.intBitsToFloat(((int)(arg11 & 0xFFFFFFFFL)))), v5, v6, null, NestedScrollInteropConnectionKt.access$toViewType-GyEprt8(arg15), this.consumedScrollCache);
            return NestedScrollInteropConnectionKt.access$toOffset-moWRBKg(v5, v6, this.consumedScrollCache, arg13);
        }

        return Offset.Companion.getZero-F1C5BW0();
    }

    public Object onPreFling-QWom1Mo(long arg3, Continuation arg5) {
        if(!this.nestedScrollChildHelper.dispatchNestedPreFling(NestedScrollInteropConnectionKt.access$toViewVelocity(Velocity.getX-impl(arg3)), NestedScrollInteropConnectionKt.access$toViewVelocity(Velocity.getY-impl(arg3)))) {
            if(this.nestedScrollChildHelper.dispatchNestedFling(NestedScrollInteropConnectionKt.access$toViewVelocity(Velocity.getX-impl(arg3)), NestedScrollInteropConnectionKt.access$toViewVelocity(Velocity.getY-impl(arg3)), true)) {
            }
            else {
                arg3 = Velocity.Companion.getZero-9UxMQ8M();
            }
        }

        return Velocity.box-impl(arg3);
    }

    public long onPreScroll-OzD1aCk(long arg8, int arg10) {
        if(this.nestedScrollChildHelper.startNestedScroll(NestedScrollInteropConnectionKt.access$getScrollAxes-k-4lQ0M(arg8), NestedScrollInteropConnectionKt.access$toViewType-GyEprt8(arg10))) {
            ArraysKt.fill$default(this.consumedScrollCache, 0, 0, 0, 6, null);
            int v2 = NestedScrollInteropConnectionKt.composeToViewOffset(Float.intBitsToFloat(((int)(arg8 >> 0x20))));
            int v3 = NestedScrollInteropConnectionKt.composeToViewOffset(Float.intBitsToFloat(((int)(0xFFFFFFFFL & arg8))));
            this.nestedScrollChildHelper.dispatchNestedPreScroll(v2, v3, this.consumedScrollCache, null, NestedScrollInteropConnectionKt.access$toViewType-GyEprt8(arg10));
            return NestedScrollInteropConnectionKt.access$toOffset-moWRBKg(v2, v3, this.consumedScrollCache, arg8);
        }

        return Offset.Companion.getZero-F1C5BW0();
    }

    private final void stopNestedScrolls() {
        if(this.nestedScrollChildHelper.hasNestedScrollingParent(0)) {
            this.nestedScrollChildHelper.stopNestedScroll(0);
        }

        if(this.nestedScrollChildHelper.hasNestedScrollingParent(1)) {
            this.nestedScrollChildHelper.stopNestedScroll(1);
        }
    }
}

