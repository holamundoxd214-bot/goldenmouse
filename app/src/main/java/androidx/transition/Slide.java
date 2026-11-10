package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.core.content.res.TypedArrayUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.xmlpull.v1.XmlPullParser;

public class Slide extends Visibility {
    class androidx.transition.Slide$1 extends CalculateSlideHorizontal {
        androidx.transition.Slide$1() {
            super(null);
        }

        public float getGoneX(ViewGroup arg1, View arg2) {
            return arg2.getTranslationX() - (((float)arg1.getWidth()));
        }
    }

    class androidx.transition.Slide$2 extends CalculateSlideHorizontal {
        androidx.transition.Slide$2() {
            super(null);
        }

        public float getGoneX(ViewGroup arg2, View arg3) {
            if(arg2.getLayoutDirection() == 1) {
                return arg3.getTranslationX() + (((float)arg2.getWidth()));
            }

            return arg3.getTranslationX() - (((float)arg2.getWidth()));
        }
    }

    class androidx.transition.Slide$3 extends CalculateSlideVertical {
        androidx.transition.Slide$3() {
            super(null);
        }

        public float getGoneY(ViewGroup arg1, View arg2) {
            return arg2.getTranslationY() - (((float)arg1.getHeight()));
        }
    }

    class androidx.transition.Slide$4 extends CalculateSlideHorizontal {
        androidx.transition.Slide$4() {
            super(null);
        }

        public float getGoneX(ViewGroup arg1, View arg2) {
            return arg2.getTranslationX() + (((float)arg1.getWidth()));
        }
    }

    class androidx.transition.Slide$5 extends CalculateSlideHorizontal {
        androidx.transition.Slide$5() {
            super(null);
        }

        public float getGoneX(ViewGroup arg2, View arg3) {
            if(arg2.getLayoutDirection() == 1) {
                return arg3.getTranslationX() - (((float)arg2.getWidth()));
            }

            return arg3.getTranslationX() + (((float)arg2.getWidth()));
        }
    }

    class androidx.transition.Slide$6 extends CalculateSlideVertical {
        androidx.transition.Slide$6() {
            super(null);
        }

        public float getGoneY(ViewGroup arg1, View arg2) {
            return arg2.getTranslationY() + (((float)arg1.getHeight()));
        }
    }

    interface CalculateSlide {
        float getGoneX(ViewGroup arg1, View arg2);

        float getGoneY(ViewGroup arg1, View arg2);
    }

    abstract class CalculateSlideHorizontal implements CalculateSlide {
        private CalculateSlideHorizontal() {
            super();
        }

        CalculateSlideHorizontal(androidx.transition.Slide$1 arg1) {
            this();
        }

        public float getGoneY(ViewGroup arg1, View arg2) {
            return arg2.getTranslationY();
        }
    }

    abstract class CalculateSlideVertical implements CalculateSlide {
        private CalculateSlideVertical() {
            super();
        }

        CalculateSlideVertical(androidx.transition.Slide$1 arg1) {
            this();
        }

        public float getGoneX(ViewGroup arg1, View arg2) {
            return arg2.getTranslationX();
        }
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface GravityFlag {
    }

    private static final String PROPNAME_SCREEN_POSITION = "android:slide:screenPosition";
    private CalculateSlide mSlideCalculator;
    private int mSlideEdge;
    private static final TimeInterpolator sAccelerate;
    private static final CalculateSlide sCalculateBottom;
    private static final CalculateSlide sCalculateEnd;
    private static final CalculateSlide sCalculateLeft;
    private static final CalculateSlide sCalculateRight;
    private static final CalculateSlide sCalculateStart;
    private static final CalculateSlide sCalculateTop;
    private static final TimeInterpolator sDecelerate;

    static {
        Slide.sDecelerate = new DecelerateInterpolator();
        Slide.sAccelerate = new AccelerateInterpolator();
        Slide.sCalculateLeft = new androidx.transition.Slide$1();
        Slide.sCalculateStart = new androidx.transition.Slide$2();
        Slide.sCalculateTop = new androidx.transition.Slide$3();
        Slide.sCalculateRight = new androidx.transition.Slide$4();
        Slide.sCalculateEnd = new androidx.transition.Slide$5();
        Slide.sCalculateBottom = new androidx.transition.Slide$6();
    }

    public Slide() {
        super();
        this.mSlideCalculator = Slide.sCalculateBottom;
        this.mSlideEdge = 80;
        this.setSlideEdge(80);
    }

    public Slide(int arg2) {
        super();
        this.mSlideCalculator = Slide.sCalculateBottom;
        this.mSlideEdge = 80;
        this.setSlideEdge(arg2);
    }

    public Slide(Context arg4, AttributeSet arg5) {
        super(arg4, arg5);
        this.mSlideCalculator = Slide.sCalculateBottom;
        this.mSlideEdge = 80;
        TypedArray v4 = arg4.obtainStyledAttributes(arg5, Styleable.SLIDE);
        int v5 = TypedArrayUtils.getNamedInt(v4, ((XmlPullParser)arg5), "slideEdge", 0, 80);
        v4.recycle();
        this.setSlideEdge(v5);
    }

    public void captureEndValues(TransitionValues arg1) {
        super.captureEndValues(arg1);
        this.captureValues(arg1);
    }

    public void captureStartValues(TransitionValues arg1) {
        super.captureStartValues(arg1);
        this.captureValues(arg1);
    }

    private void captureValues(TransitionValues arg2) {
        View v1 = arg2.view;
        int[] v0 = new int[2];
        v1.getLocationOnScreen(v0);
        arg2.values.put("android:slide:screenPosition", v0);
    }

    public int getSlideEdge() {
        return this.mSlideEdge;
    }

    public boolean isSeekingSupported() {
        return 1;
    }

    public Animator onAppear(ViewGroup arg11, View arg12, TransitionValues arg13, TransitionValues arg14) {
        if(arg14 == null) {
            return null;
        }

        Object v13 = arg14.values.get("android:slide:screenPosition");
        return TranslationAnimationCreator.createAnimation(arg12, arg14, v13[0], v13[1], this.mSlideCalculator.getGoneX(arg11, arg12), this.mSlideCalculator.getGoneY(arg11, arg12), arg12.getTranslationX(), arg12.getTranslationY(), Slide.sDecelerate, this);
    }

    public Animator onDisappear(ViewGroup arg11, View arg12, TransitionValues arg13, TransitionValues arg14) {
        if(arg13 == null) {
            return null;
        }

        Object v14 = arg13.values.get("android:slide:screenPosition");
        return TranslationAnimationCreator.createAnimation(arg12, arg13, v14[0], v14[1], arg12.getTranslationX(), arg12.getTranslationY(), this.mSlideCalculator.getGoneX(arg11, arg12), this.mSlideCalculator.getGoneY(arg11, arg12), Slide.sAccelerate, this);
    }

    public void setSlideEdge(int arg2) {
        if(arg2 == 3) {
            this.mSlideCalculator = Slide.sCalculateLeft;
        }
        else if(arg2 == 5) {
            this.mSlideCalculator = Slide.sCalculateRight;
        }
        else if(arg2 == 0x30) {
            this.mSlideCalculator = Slide.sCalculateTop;
        }
        else if(arg2 == 80) {
            this.mSlideCalculator = Slide.sCalculateBottom;
        }
        else if(arg2 == 0x800003) {
            this.mSlideCalculator = Slide.sCalculateStart;
        }
        else if(arg2 == 0x800005) {
            this.mSlideCalculator = Slide.sCalculateEnd;
        }
        else {
            throw new IllegalArgumentException("Invalid slide direction");
        }

        this.mSlideEdge = arg2;
        SidePropagation v0 = new SidePropagation();
        v0.setSide(arg2);
        this.setPropagation(((TransitionPropagation)v0));
    }
}

