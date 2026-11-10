package androidx.activity;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1={"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u001A\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0004H\u0087@¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2={"trackPipAnimationHintView", "", "Landroid/app/Activity;", "view", "Landroid/view/View;", "(Landroid/app/Activity;Landroid/view/View;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "activity"}, k=2, mv={2, 1, 0}, xi=0x30) public final class PipHintTrackerKt {
    public static final Rect access$trackPipAnimationHintView$positionInWindow(View arg0) {
        return PipHintTrackerKt.trackPipAnimationHintView$positionInWindow(arg0);
    }

    public static final Object trackPipAnimationHintView(Activity arg2, View arg3, Continuation arg4) {
        Object v2 = FlowKt.callbackFlow(new PipHintTrackerKt$trackPipAnimationHintView$flow$1(arg3, null)).collect(new PipHintTrackerKt$trackPipAnimationHintView$2(arg2), arg4);
        if(v2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v2;
        }

        return Unit.INSTANCE;
    }

    private static final Rect trackPipAnimationHintView$positionInWindow(View arg1) {
        Rect v0 = new Rect();
        arg1.getGlobalVisibleRect(v0);
        return v0;
    }
}

