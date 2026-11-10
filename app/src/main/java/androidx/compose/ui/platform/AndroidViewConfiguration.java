package androidx.compose.ui.platform;

import android.os.Build$VERSION;
import kotlin.Metadata;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u000B\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001A\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\tR\u0014\u0010\n\u001A\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000B\u0010\tR\u0014\u0010\f\u001A\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\r\u0010\tR\u0014\u0010\u000E\u001A\u00020\u000F8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001A\u00020\u000F8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0014\u001A\u00020\u000F8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0015\u0010\u0011R\u0014\u0010\u0016\u001A\u00020\u000F8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0017\u0010\u0011R\u0014\u0010\u0018\u001A\u00020\u000F8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0019\u0010\u0011¨\u0006\u001A"}, d2={"Landroidx/compose/ui/platform/AndroidViewConfiguration;", "Landroidx/compose/ui/platform/ViewConfiguration;", "viewConfiguration", "Landroid/view/ViewConfiguration;", "<init>", "(Landroid/view/ViewConfiguration;)V", "longPressTimeoutMillis", "", "getLongPressTimeoutMillis", "()J", "doubleTapTimeoutMillis", "getDoubleTapTimeoutMillis", "doubleTapMinTimeMillis", "getDoubleTapMinTimeMillis", "touchSlop", "", "getTouchSlop", "()F", "handwritingSlop", "getHandwritingSlop", "maximumFlingVelocity", "getMaximumFlingVelocity", "minimumFlingVelocity", "getMinimumFlingVelocity", "handwritingGestureLineMargin", "getHandwritingGestureLineMargin", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AndroidViewConfiguration implements ViewConfiguration {
    public static final int $stable = 8;
    private final android.view.ViewConfiguration viewConfiguration;

    static {
    }

    public AndroidViewConfiguration(android.view.ViewConfiguration arg1) {
        super();
        this.viewConfiguration = arg1;
    }

    public long getDoubleTapMinTimeMillis() {
        return 40;
    }

    public long getDoubleTapTimeoutMillis() {
        return ((long)android.view.ViewConfiguration.getDoubleTapTimeout());
    }

    public float getHandwritingGestureLineMargin() {
        if(Build$VERSION.SDK_INT >= 34) {
            return AndroidViewConfigurationApi34.INSTANCE.getScaledHandwritingGestureLineMargin(this.viewConfiguration);
        }

        return ViewConfiguration.super.getHandwritingGestureLineMargin();
    }

    public float getHandwritingSlop() {
        if(Build$VERSION.SDK_INT >= 34) {
            return AndroidViewConfigurationApi34.INSTANCE.getScaledHandwritingSlop(this.viewConfiguration);
        }

        return ViewConfiguration.super.getHandwritingSlop();
    }

    public long getLongPressTimeoutMillis() {
        return ((long)android.view.ViewConfiguration.getLongPressTimeout());
    }

    public float getMaximumFlingVelocity() {
        return ((float)this.viewConfiguration.getScaledMaximumFlingVelocity());
    }

    public float getMinimumFlingVelocity() {
        return ((float)this.viewConfiguration.getScaledMinimumFlingVelocity());
    }

    public float getTouchSlop() {
        return ((float)this.viewConfiguration.getScaledTouchSlop());
    }
}

