package androidx.core.view;

import android.view.MotionEvent;
import android.view.View$OnTouchListener;
import android.view.View;

public final class DragStartHelper$$ExternalSyntheticLambda1 implements View$OnTouchListener {
    public DragStartHelper$$ExternalSyntheticLambda1(DragStartHelper arg1) {
        super();
        this.f$0 = arg1;
    }

    public final boolean onTouch(View arg1, MotionEvent arg2) {
        return this.f$0.onTouch(arg1, arg2);
    }
}

