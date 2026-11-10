package androidx.activity;

import android.view.View;
import android.view.ViewTreeObserver$OnScrollChangedListener;
import kotlinx.coroutines.channels.ProducerScope;

public final class PipHintTrackerKt$trackPipAnimationHintView$flow$1$$ExternalSyntheticLambda1 implements ViewTreeObserver$OnScrollChangedListener {
    public PipHintTrackerKt$trackPipAnimationHintView$flow$1$$ExternalSyntheticLambda1(ProducerScope arg1, View arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final void onScrollChanged() {
        PipHintTrackerKt$trackPipAnimationHintView$flow$1.invokeSuspend$lambda$1(this.f$0, this.f$1);
    }
}

