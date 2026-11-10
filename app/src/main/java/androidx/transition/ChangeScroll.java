package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class ChangeScroll extends Transition {
    private static final String[] PROPERTIES = null;
    private static final String PROPNAME_SCROLL_X = "android:changeScroll:x";
    private static final String PROPNAME_SCROLL_Y = "android:changeScroll:y";

    static {
        ChangeScroll.PROPERTIES = new String[]{"android:changeScroll:x", "android:changeScroll:y"};
    }

    public ChangeScroll() {
        super();
    }

    public ChangeScroll(Context arg1, AttributeSet arg2) {
        super(arg1, arg2);
    }

    public void captureEndValues(TransitionValues arg1) {
        this.captureValues(arg1);
    }

    public void captureStartValues(TransitionValues arg1) {
        this.captureValues(arg1);
    }

    private void captureValues(TransitionValues arg3) {
        arg3.values.put("android:changeScroll:x", Integer.valueOf(arg3.view.getScrollX()));
        arg3.values.put("android:changeScroll:y", Integer.valueOf(arg3.view.getScrollY()));
    }

    public Animator createAnimator(ViewGroup arg4, TransitionValues arg5, TransitionValues arg6) {
        ObjectAnimator v3_1;
        Animator v0_2;
        Animator v3 = null;
        if(arg5 != null) {
            if(arg6 == null) {
            }
            else {
                View v4 = arg6.view;
                int v0 = arg5.values.get("android:changeScroll:x").intValue();
                int v1 = arg6.values.get("android:changeScroll:x").intValue();
                int v5 = arg5.values.get("android:changeScroll:y").intValue();
                int v6 = arg6.values.get("android:changeScroll:y").intValue();
                if(v0 != v1) {
                    v4.setScrollX(v0);
                    ObjectAnimator v0_1 = ObjectAnimator.ofInt(v4, "scrollX", new int[]{v0, v1});
                }
                else {
                    v0_2 = v3;
                }

                if(v5 != v6) {
                    v4.setScrollY(v5);
                    v3_1 = ObjectAnimator.ofInt(v4, "scrollY", new int[]{v5, v6});
                }

                v3 = TransitionUtils.mergeAnimators(v0_2, ((Animator)v3_1));
            }
        }

        return v3;
    }

    public String[] getTransitionProperties() {
        return ChangeScroll.PROPERTIES;
    }

    public boolean isSeekingSupported() {
        return 1;
    }
}

