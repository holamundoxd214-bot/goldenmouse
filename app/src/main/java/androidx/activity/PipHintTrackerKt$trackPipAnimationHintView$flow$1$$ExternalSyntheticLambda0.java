package androidx.activity;

import android.view.View$OnLayoutChangeListener;
import android.view.View;
import kotlinx.coroutines.channels.ProducerScope;

public final class PipHintTrackerKt$trackPipAnimationHintView$flow$1$$ExternalSyntheticLambda0 implements View$OnLayoutChangeListener {
    public PipHintTrackerKt$trackPipAnimationHintView$flow$1$$ExternalSyntheticLambda0(ProducerScope arg1) {
        super();
        this.f$0 = arg1;
    }

    public final void onLayoutChange(View arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9) {
        PipHintTrackerKt$trackPipAnimationHintView$flow$1.invokeSuspend$lambda$0(this.f$0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
    }
}

