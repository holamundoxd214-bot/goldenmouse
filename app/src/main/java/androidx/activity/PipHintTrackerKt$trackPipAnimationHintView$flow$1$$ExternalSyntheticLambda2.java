package androidx.activity;

import android.view.View$OnLayoutChangeListener;
import android.view.View;
import android.view.ViewTreeObserver$OnScrollChangedListener;
import kotlin.jvm.functions.Function0;

public final class PipHintTrackerKt$trackPipAnimationHintView$flow$1$$ExternalSyntheticLambda2 implements Function0 {
    public PipHintTrackerKt$trackPipAnimationHintView$flow$1$$ExternalSyntheticLambda2(View arg1, ViewTreeObserver$OnScrollChangedListener arg2, View$OnLayoutChangeListener arg3, PipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1 arg4) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
    }

    public final Object invoke() {
        return PipHintTrackerKt$trackPipAnimationHintView$flow$1.invokeSuspend$lambda$2(this.f$0, this.f$1, this.f$2, this.f$3);
    }
}

