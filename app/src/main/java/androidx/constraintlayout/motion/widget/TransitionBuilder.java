package androidx.constraintlayout.motion.widget;

import androidx.constraintlayout.widget.ConstraintSet;

public class TransitionBuilder {
    private static final String TAG = "TransitionBuilder";

    public TransitionBuilder() {
        super();
    }

    public static Transition buildTransition(MotionScene arg1, int arg2, int arg3, ConstraintSet arg4, int arg5, ConstraintSet arg6) {
        Transition v0 = new Transition(arg2, arg1, arg3, arg5);
        TransitionBuilder.updateConstraintSetInMotionScene(arg1, v0, arg4, arg6);
        return v0;
    }

    private static void updateConstraintSetInMotionScene(MotionScene arg1, Transition arg2, ConstraintSet arg3, ConstraintSet arg4) {
        int v0 = arg2.getStartConstraintSetId();
        int v2 = arg2.getEndConstraintSetId();
        arg1.setConstraintSet(v0, arg3);
        arg1.setConstraintSet(v2, arg4);
    }

    public static void validate(MotionLayout arg1) {
        if(arg1.mScene != null) {
            MotionScene v0 = arg1.mScene;
            if(v0.validateLayout(arg1)) {
                if(v0.mCurrentTransition != null && !v0.getDefinedTransitions().isEmpty()) {
                    return;
                }

                throw new RuntimeException("Invalid motion layout. Motion Scene doesn\'t have any transition.");
            }

            throw new RuntimeException("MotionLayout doesn\'t have the right motion scene.");
        }

        throw new RuntimeException("Invalid motion layout. Layout missing Motion Scene.");
    }
}

