package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.BringIntoViewSpec;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006J \u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u000E\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\fH\u0016J\u0010\u0010\u0010\u001A\u00020\f2\u0006\u0010\u0011\u001A\u00020\fH\u0002R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001A\u00020\u0001¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\n¨\u0006\u0012"}, d2={"Landroidx/compose/foundation/pager/PagerBringIntoViewSpec;", "Landroidx/compose/foundation/gestures/BringIntoViewSpec;", "pagerState", "Landroidx/compose/foundation/pager/PagerState;", "defaultBringIntoViewSpec", "<init>", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/foundation/gestures/BringIntoViewSpec;)V", "getPagerState", "()Landroidx/compose/foundation/pager/PagerState;", "getDefaultBringIntoViewSpec", "()Landroidx/compose/foundation/gestures/BringIntoViewSpec;", "calculateScrollDistance", "", "offset", "size", "containerSize", "overrideProposedOffsetMove", "proposedOffsetMove", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class PagerBringIntoViewSpec implements BringIntoViewSpec {
    private final BringIntoViewSpec defaultBringIntoViewSpec;
    private final PagerState pagerState;

    public PagerBringIntoViewSpec(PagerState arg1, BringIntoViewSpec arg2) {
        super();
        this.pagerState = arg1;
        this.defaultBringIntoViewSpec = arg2;
    }

    public float calculateScrollDistance(float arg6, float arg7, float arg8) {
        float v0 = this.defaultBringIntoViewSpec.calculateScrollDistance(arg6, arg7, arg8);
        int v3 = 1;
        if(Float.compare(arg6, 0f) > 0) {
            if(arg6 + arg7 > arg8) {
            }
            else {
                goto label_13;
            }
        }
        else if(arg6 + arg7 <= 0f) {
        }
        else {
        label_13:
            v3 = 0;
        }

        if(Math.abs(v0) == 0f) {
        }
        else if(v3 != 0) {
            return this.overrideProposedOffsetMove(v0);
        }

        if((((double)Math.abs(this.pagerState.getFirstVisiblePageOffset$foundation()))) < 0.000001) {
            return 0;
        }

        arg6 = (((float)this.pagerState.getFirstVisiblePageOffset$foundation())) * -1f;
        if(this.pagerState.getLastScrolledForward()) {
            arg6 += ((float)this.pagerState.getPageSizeWithSpacing$foundation());
        }

        return RangesKt.coerceIn(arg6, -arg8, arg8);
    }

    public final BringIntoViewSpec getDefaultBringIntoViewSpec() {
        return this.defaultBringIntoViewSpec;
    }

    public final PagerState getPagerState() {
        return this.pagerState;
    }

    private final float overrideProposedOffsetMove(float arg4) {
        float v0;
        for(v0 = (((float)this.pagerState.getFirstVisiblePageOffset$foundation())) * -1f; arg4 > 0f; v0 += ((float)this.pagerState.getPageSizeWithSpacing$foundation())) {
            if(v0 >= arg4) {
                break;
            }
        }

        while(arg4 < 0f) {
            if(v0 <= arg4) {
                return v0;
            }

            v0 -= ((float)this.pagerState.getPageSizeWithSpacing$foundation());
        }

        return v0;
    }
}

