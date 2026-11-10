package androidx.transition;

public final class Transition$TransitionNotification$$ExternalSyntheticLambda1 implements TransitionNotification {
    public Transition$TransitionNotification$$ExternalSyntheticLambda1() {
        super();
    }

    public final void notifyListener(TransitionListener arg1, Transition arg2, boolean arg3) {
        arg1.onTransitionEnd(arg2, arg3);
    }
}

