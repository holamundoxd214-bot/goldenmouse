package androidx.compose.ui.platform;

import androidx.customview.poolingcontainer.PoolingContainerListener;

public final class ViewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0 implements PoolingContainerListener {
    public ViewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0(AbstractComposeView arg1) {
        super();
        this.f$0 = arg1;
    }

    public final void onRelease() {
        DisposeOnDetachedFromWindowOrReleasedFromPool.installFor$lambda$0(this.f$0);
    }
}

