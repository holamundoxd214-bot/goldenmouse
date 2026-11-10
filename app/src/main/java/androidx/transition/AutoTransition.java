package androidx.transition;

import android.content.Context;
import android.util.AttributeSet;

public class AutoTransition extends TransitionSet {
    public AutoTransition() {
        super();
        this.init();
    }

    public AutoTransition(Context arg1, AttributeSet arg2) {
        super(arg1, arg2);
        this.init();
    }

    private void init() {
        this.setOrdering(1);
        this.addTransition(new Fade(2)).addTransition(new ChangeBounds()).addTransition(new Fade(1));
    }
}

