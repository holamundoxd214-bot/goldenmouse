package androidx.transition;

import androidx.core.os.CancellationSignal$OnCancelListener;

public final class FragmentTransitionSupport$$ExternalSyntheticLambda0 implements OnCancelListener {
    public FragmentTransitionSupport$$ExternalSyntheticLambda0(Runnable arg1, Transition arg2, Runnable arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final void onCancel() {
        FragmentTransitionSupport.lambda$setListenerForTransitionEnd$0(this.f$0, this.f$1, this.f$2);
    }
}

