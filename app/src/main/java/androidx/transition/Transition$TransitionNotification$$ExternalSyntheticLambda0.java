package androidx.transition;

public final class Transition$TransitionNotification$$ExternalSyntheticLambda0 implements TransitionNotification {
    public Transition$TransitionNotification$$ExternalSyntheticLambda0() {
        super();
    }

    public final void notifyListener(TransitionListener arg1, Transition arg2, boolean arg3) {
        arg1.onTransitionStart(arg2, arg3);
    }
}

