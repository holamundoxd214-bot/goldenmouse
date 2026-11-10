package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\'\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u0011\u001A\u00020\u000F2\u0006\u0010\u0012\u001A\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J \u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0010\u001A\u00020\u00172\u0006\u0010\u0011\u001A\u00020\u0017H\u0096@¢\u0006\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u001A\u0010\u0004\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\n\u0010\u000B\"\u0004\b\f\u0010\r¨\u0006\u001A"}, d2={"Landroidx/compose/foundation/gestures/ScrollableNestedScrollConnection;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "scrollingLogic", "Landroidx/compose/foundation/gestures/ScrollLogic;", "enabled", "", "<init>", "(Landroidx/compose/foundation/gestures/ScrollLogic;Z)V", "getScrollingLogic", "()Landroidx/compose/foundation/gestures/ScrollLogic;", "getEnabled", "()Z", "setEnabled", "(Z)V", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "consumed", "available", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ScrollableNestedScrollConnection implements NestedScrollConnection {
    public static final int $stable = 8;
    private boolean enabled;
    private final ScrollLogic scrollingLogic;

    static {
    }

    public ScrollableNestedScrollConnection(ScrollLogic arg1, boolean arg2) {
        super();
        this.scrollingLogic = arg1;
        this.enabled = arg2;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final ScrollLogic getScrollingLogic() {
        return this.scrollingLogic;
    }

    public Object onPostFling-RZ2iAVY(long arg3, long arg5, Continuation arg7) {
        long v2;
        ScrollableNestedScrollConnection$onPostFling$1 v3_1;
        int v0;
        if((arg7 instanceof ScrollableNestedScrollConnection$onPostFling$1)) {
            Continuation v3 = arg7;
            v0 = 0x80000000;
            if((((ScrollableNestedScrollConnection$onPostFling$1)v3).label & v0) != 0) {
                ((ScrollableNestedScrollConnection$onPostFling$1)v3).label -= v0;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v3_1 = new ScrollableNestedScrollConnection$onPostFling$1(this, arg7);
        }

        Object v4 = v3_1.result;
        Object v7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v0 = v3_1.label;
        if(v0 == 0) {
            ResultKt.throwOnFailure(v4);
            if(!this.enabled) {
                v2 = Velocity.Companion.getZero-9UxMQ8M();
            }
            else if(this.scrollingLogic.isFlinging()) {
                v2 = Velocity.Companion.getZero-9UxMQ8M();
                goto label_43;
            }
            else {
                ScrollLogic v2_1 = this.scrollingLogic;
                v3_1.J$0 = arg5;
                v3_1.label = 1;
                v4 = v2_1.doFlingAnimation-QWom1Mo(arg5, ((Continuation)v3_1));
                if(v4 == v7) {
                    return v7;
                }
                else {
                label_42:
                    v2 = ((Velocity)v4).unbox-impl();
                label_43:
                    v2 = Velocity.minus-AH228Gc(arg5, v2);
                }
            }
        }
        else if(v0 == 1) {
            v2 = v3_1.J$0;
            ResultKt.throwOnFailure(v4);
            arg5 = v2;
            goto label_42;
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        return Velocity.box-impl(v2);
    }

    public long onPostScroll-DzOQY0M(long arg1, long arg3, int arg5) {
        if(this.enabled) {
            return this.scrollingLogic.performRawScroll-MK-Hz9U(arg3);
        }

        return Offset.Companion.getZero-F1C5BW0();
    }

    public final void setEnabled(boolean arg1) {
        this.enabled = arg1;
    }
}

