package androidx.constraintlayout.motion.widget;

public abstract class TransitionAdapter implements TransitionListener {
    public TransitionAdapter() {
        super();
    }

    public void onTransitionChange(MotionLayout arg1, int arg2, int arg3, float arg4) {
    }

    public void onTransitionCompleted(MotionLayout arg1, int arg2) {
    }

    public void onTransitionStarted(MotionLayout arg1, int arg2, int arg3) {
    }

    public void onTransitionTrigger(MotionLayout arg1, int arg2, boolean arg3, float arg4) {
    }
}

