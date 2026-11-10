package androidx.compose.ui.platform;

import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\t\u0010\u0005R\u0012\u0010\n\u001A\u00020\u000BX¦\u0004¢\u0006\u0006\u001A\u0004\b\f\u0010\rR\u0014\u0010\u000E\u001A\u00020\u000B8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000F\u0010\rR\u0014\u0010\u0010\u001A\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0005R\u0014\u0010\u0013\u001A\u00020\u000B8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0014\u0010\rR\u0014\u0010\u0015\u001A\u00020\u000B8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0016\u0010\rR\u0014\u0010\u0017\u001A\u00020\u000B8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0018\u0010\rø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0019À\u0006\u0003"}, d2={"Landroidx/compose/ui/platform/ViewConfiguration;", "", "longPressTimeoutMillis", "", "getLongPressTimeoutMillis", "()J", "doubleTapTimeoutMillis", "getDoubleTapTimeoutMillis", "doubleTapMinTimeMillis", "getDoubleTapMinTimeMillis", "touchSlop", "", "getTouchSlop", "()F", "handwritingSlop", "getHandwritingSlop", "minimumTouchTargetSize", "Landroidx/compose/ui/unit/DpSize;", "getMinimumTouchTargetSize-MYxV2XQ", "maximumFlingVelocity", "getMaximumFlingVelocity", "minimumFlingVelocity", "getMinimumFlingVelocity", "handwritingGestureLineMargin", "getHandwritingGestureLineMargin", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public interface ViewConfiguration {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class DefaultImpls {
        @Deprecated public static float getHandwritingGestureLineMargin(ViewConfiguration arg0) {
            return arg0.getHandwritingGestureLineMargin();
        }

        @Deprecated public static float getHandwritingSlop(ViewConfiguration arg0) {
            return arg0.getHandwritingSlop();
        }

        @Deprecated public static float getMaximumFlingVelocity(ViewConfiguration arg0) {
            return arg0.getMaximumFlingVelocity();
        }

        @Deprecated public static float getMinimumFlingVelocity(ViewConfiguration arg0) {
            return arg0.getMinimumFlingVelocity();
        }

        @Deprecated public static long getMinimumTouchTargetSize-MYxV2XQ(ViewConfiguration arg2) {
            return arg2.getMinimumTouchTargetSize-MYxV2XQ();
        }
    }

    static float access$getHandwritingGestureLineMargin$jd(ViewConfiguration arg0) {
        return super.getHandwritingGestureLineMargin();
    }

    static float access$getHandwritingSlop$jd(ViewConfiguration arg0) {
        return super.getHandwritingSlop();
    }

    static float access$getMaximumFlingVelocity$jd(ViewConfiguration arg0) {
        return super.getMaximumFlingVelocity();
    }

    static float access$getMinimumFlingVelocity$jd(ViewConfiguration arg0) {
        return super.getMinimumFlingVelocity();
    }

    static long access$getMinimumTouchTargetSize-MYxV2XQ$jd(ViewConfiguration arg2) {
        return super.getMinimumTouchTargetSize-MYxV2XQ();
    }

    long getDoubleTapMinTimeMillis();

    long getDoubleTapTimeoutMillis();

    default float getHandwritingGestureLineMargin() {
        return 16f;
    }

    default float getHandwritingSlop() {
        return 2f;
    }

    long getLongPressTimeoutMillis();

    default float getMaximumFlingVelocity() {
        return 3.402823E+38f;
    }

    default float getMinimumFlingVelocity() {
        return 0;
    }

    default long getMinimumTouchTargetSize-MYxV2XQ() {
        return DpKt.DpSize-YgX7TsA(Dp.constructor-impl(48f), Dp.constructor-impl(48f));
    }

    float getTouchSlop();
}

