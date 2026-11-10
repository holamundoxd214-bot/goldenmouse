package androidx.dynamicanimation.animation;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.View;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;

public abstract class DynamicAnimation implements AnimationFrameCallback {
    final class androidx.dynamicanimation.animation.DynamicAnimation$10 extends ViewProperty {
        androidx.dynamicanimation.animation.DynamicAnimation$10(String arg2) {
            super(arg2, null);
        }

        public float getValue(View arg1) {
            return arg1.getY();
        }

        public float getValue(Object arg1) {
            return this.getValue(((View)arg1));
        }

        public void setValue(View arg1, float arg2) {
            arg1.setY(arg2);
        }

        public void setValue(Object arg1, float arg2) {
            this.setValue(((View)arg1), arg2);
        }
    }

    final class androidx.dynamicanimation.animation.DynamicAnimation$11 extends ViewProperty {
        androidx.dynamicanimation.animation.DynamicAnimation$11(String arg2) {
            super(arg2, null);
        }

        public float getValue(View arg1) {
            return ViewCompat.getZ(arg1);
        }

        public float getValue(Object arg1) {
            return this.getValue(((View)arg1));
        }

        public void setValue(View arg1, float arg2) {
            ViewCompat.setZ(arg1, arg2);
        }

        public void setValue(Object arg1, float arg2) {
            this.setValue(((View)arg1), arg2);
        }
    }

    final class androidx.dynamicanimation.animation.DynamicAnimation$12 extends ViewProperty {
        androidx.dynamicanimation.animation.DynamicAnimation$12(String arg2) {
            super(arg2, null);
        }

        public float getValue(View arg1) {
            return arg1.getAlpha();
        }

        public float getValue(Object arg1) {
            return this.getValue(((View)arg1));
        }

        public void setValue(View arg1, float arg2) {
            arg1.setAlpha(arg2);
        }

        public void setValue(Object arg1, float arg2) {
            this.setValue(((View)arg1), arg2);
        }
    }

    final class androidx.dynamicanimation.animation.DynamicAnimation$13 extends ViewProperty {
        androidx.dynamicanimation.animation.DynamicAnimation$13(String arg2) {
            super(arg2, null);
        }

        public float getValue(View arg1) {
            return ((float)arg1.getScrollX());
        }

        public float getValue(Object arg1) {
            return this.getValue(((View)arg1));
        }

        public void setValue(View arg1, float arg2) {
            arg1.setScrollX(((int)arg2));
        }

        public void setValue(Object arg1, float arg2) {
            this.setValue(((View)arg1), arg2);
        }
    }

    final class androidx.dynamicanimation.animation.DynamicAnimation$14 extends ViewProperty {
        androidx.dynamicanimation.animation.DynamicAnimation$14(String arg2) {
            super(arg2, null);
        }

        public float getValue(View arg1) {
            return ((float)arg1.getScrollY());
        }

        public float getValue(Object arg1) {
            return this.getValue(((View)arg1));
        }

        public void setValue(View arg1, float arg2) {
            arg1.setScrollY(((int)arg2));
        }

        public void setValue(Object arg1, float arg2) {
            this.setValue(((View)arg1), arg2);
        }
    }

    final class androidx.dynamicanimation.animation.DynamicAnimation$1 extends ViewProperty {
        androidx.dynamicanimation.animation.DynamicAnimation$1(String arg2) {
            super(arg2, null);
        }

        public float getValue(View arg1) {
            return arg1.getTranslationX();
        }

        public float getValue(Object arg1) {
            return this.getValue(((View)arg1));
        }

        public void setValue(View arg1, float arg2) {
            arg1.setTranslationX(arg2);
        }

        public void setValue(Object arg1, float arg2) {
            this.setValue(((View)arg1), arg2);
        }
    }

    final class androidx.dynamicanimation.animation.DynamicAnimation$2 extends ViewProperty {
        androidx.dynamicanimation.animation.DynamicAnimation$2(String arg2) {
            super(arg2, null);
        }

        public float getValue(View arg1) {
            return arg1.getTranslationY();
        }

        public float getValue(Object arg1) {
            return this.getValue(((View)arg1));
        }

        public void setValue(View arg1, float arg2) {
            arg1.setTranslationY(arg2);
        }

        public void setValue(Object arg1, float arg2) {
            this.setValue(((View)arg1), arg2);
        }
    }

    final class androidx.dynamicanimation.animation.DynamicAnimation$3 extends ViewProperty {
        androidx.dynamicanimation.animation.DynamicAnimation$3(String arg2) {
            super(arg2, null);
        }

        public float getValue(View arg1) {
            return ViewCompat.getTranslationZ(arg1);
        }

        public float getValue(Object arg1) {
            return this.getValue(((View)arg1));
        }

        public void setValue(View arg1, float arg2) {
            ViewCompat.setTranslationZ(arg1, arg2);
        }

        public void setValue(Object arg1, float arg2) {
            this.setValue(((View)arg1), arg2);
        }
    }

    final class androidx.dynamicanimation.animation.DynamicAnimation$4 extends ViewProperty {
        androidx.dynamicanimation.animation.DynamicAnimation$4(String arg2) {
            super(arg2, null);
        }

        public float getValue(View arg1) {
            return arg1.getScaleX();
        }

        public float getValue(Object arg1) {
            return this.getValue(((View)arg1));
        }

        public void setValue(View arg1, float arg2) {
            arg1.setScaleX(arg2);
        }

        public void setValue(Object arg1, float arg2) {
            this.setValue(((View)arg1), arg2);
        }
    }

    final class androidx.dynamicanimation.animation.DynamicAnimation$5 extends ViewProperty {
        androidx.dynamicanimation.animation.DynamicAnimation$5(String arg2) {
            super(arg2, null);
        }

        public float getValue(View arg1) {
            return arg1.getScaleY();
        }

        public float getValue(Object arg1) {
            return this.getValue(((View)arg1));
        }

        public void setValue(View arg1, float arg2) {
            arg1.setScaleY(arg2);
        }

        public void setValue(Object arg1, float arg2) {
            this.setValue(((View)arg1), arg2);
        }
    }

    final class androidx.dynamicanimation.animation.DynamicAnimation$6 extends ViewProperty {
        androidx.dynamicanimation.animation.DynamicAnimation$6(String arg2) {
            super(arg2, null);
        }

        public float getValue(View arg1) {
            return arg1.getRotation();
        }

        public float getValue(Object arg1) {
            return this.getValue(((View)arg1));
        }

        public void setValue(View arg1, float arg2) {
            arg1.setRotation(arg2);
        }

        public void setValue(Object arg1, float arg2) {
            this.setValue(((View)arg1), arg2);
        }
    }

    final class androidx.dynamicanimation.animation.DynamicAnimation$7 extends ViewProperty {
        androidx.dynamicanimation.animation.DynamicAnimation$7(String arg2) {
            super(arg2, null);
        }

        public float getValue(View arg1) {
            return arg1.getRotationX();
        }

        public float getValue(Object arg1) {
            return this.getValue(((View)arg1));
        }

        public void setValue(View arg1, float arg2) {
            arg1.setRotationX(arg2);
        }

        public void setValue(Object arg1, float arg2) {
            this.setValue(((View)arg1), arg2);
        }
    }

    final class androidx.dynamicanimation.animation.DynamicAnimation$8 extends ViewProperty {
        androidx.dynamicanimation.animation.DynamicAnimation$8(String arg2) {
            super(arg2, null);
        }

        public float getValue(View arg1) {
            return arg1.getRotationY();
        }

        public float getValue(Object arg1) {
            return this.getValue(((View)arg1));
        }

        public void setValue(View arg1, float arg2) {
            arg1.setRotationY(arg2);
        }

        public void setValue(Object arg1, float arg2) {
            this.setValue(((View)arg1), arg2);
        }
    }

    final class androidx.dynamicanimation.animation.DynamicAnimation$9 extends ViewProperty {
        androidx.dynamicanimation.animation.DynamicAnimation$9(String arg2) {
            super(arg2, null);
        }

        public float getValue(View arg1) {
            return arg1.getX();
        }

        public float getValue(Object arg1) {
            return this.getValue(((View)arg1));
        }

        public void setValue(View arg1, float arg2) {
            arg1.setX(arg2);
        }

        public void setValue(Object arg1, float arg2) {
            this.setValue(((View)arg1), arg2);
        }
    }

    class MassState {
        float mValue;
        float mVelocity;

        MassState() {
            super();
        }
    }

    public interface OnAnimationEndListener {
        void onAnimationEnd(DynamicAnimation arg1, boolean arg2, float arg3, float arg4);
    }

    public interface OnAnimationUpdateListener {
        void onAnimationUpdate(DynamicAnimation arg1, float arg2, float arg3);
    }

    public abstract class ViewProperty extends FloatPropertyCompat {
        private ViewProperty(String arg1) {
            super(arg1);
        }

        ViewProperty(String arg1, androidx.dynamicanimation.animation.DynamicAnimation$1 arg2) {
            this(arg1);
        }
    }

    public static final ViewProperty ALPHA = null;
    public static final float MIN_VISIBLE_CHANGE_ALPHA = 0.003906f;
    public static final float MIN_VISIBLE_CHANGE_PIXELS = 1f;
    public static final float MIN_VISIBLE_CHANGE_ROTATION_DEGREES = 0.1f;
    public static final float MIN_VISIBLE_CHANGE_SCALE = 0.002f;
    public static final ViewProperty ROTATION = null;
    public static final ViewProperty ROTATION_X = null;
    public static final ViewProperty ROTATION_Y = null;
    public static final ViewProperty SCALE_X = null;
    public static final ViewProperty SCALE_Y = null;
    public static final ViewProperty SCROLL_X = null;
    public static final ViewProperty SCROLL_Y = null;
    private static final float THRESHOLD_MULTIPLIER = 0.75f;
    public static final ViewProperty TRANSLATION_X = null;
    public static final ViewProperty TRANSLATION_Y = null;
    public static final ViewProperty TRANSLATION_Z = null;
    private static final float UNSET = 3.402823E+38f;
    public static final ViewProperty X;
    public static final ViewProperty Y;
    public static final ViewProperty Z;
    private final ArrayList mEndListeners;
    private long mLastFrameTime;
    float mMaxValue;
    float mMinValue;
    private float mMinVisibleChange;
    final FloatPropertyCompat mProperty;
    boolean mRunning;
    boolean mStartValueIsSet;
    final Object mTarget;
    private final ArrayList mUpdateListeners;
    float mValue;
    float mVelocity;

    static {
        DynamicAnimation.TRANSLATION_X = new androidx.dynamicanimation.animation.DynamicAnimation$1("translationX");
        DynamicAnimation.TRANSLATION_Y = new androidx.dynamicanimation.animation.DynamicAnimation$2("translationY");
        DynamicAnimation.TRANSLATION_Z = new androidx.dynamicanimation.animation.DynamicAnimation$3("translationZ");
        DynamicAnimation.SCALE_X = new androidx.dynamicanimation.animation.DynamicAnimation$4("scaleX");
        DynamicAnimation.SCALE_Y = new androidx.dynamicanimation.animation.DynamicAnimation$5("scaleY");
        DynamicAnimation.ROTATION = new androidx.dynamicanimation.animation.DynamicAnimation$6("rotation");
        DynamicAnimation.ROTATION_X = new androidx.dynamicanimation.animation.DynamicAnimation$7("rotationX");
        DynamicAnimation.ROTATION_Y = new androidx.dynamicanimation.animation.DynamicAnimation$8("rotationY");
        DynamicAnimation.X = new androidx.dynamicanimation.animation.DynamicAnimation$9("x");
        DynamicAnimation.Y = new androidx.dynamicanimation.animation.DynamicAnimation$10("y");
        DynamicAnimation.Z = new androidx.dynamicanimation.animation.DynamicAnimation$11("z");
        DynamicAnimation.ALPHA = new androidx.dynamicanimation.animation.DynamicAnimation$12("alpha");
        DynamicAnimation.SCROLL_X = new androidx.dynamicanimation.animation.DynamicAnimation$13("scrollX");
        DynamicAnimation.SCROLL_Y = new androidx.dynamicanimation.animation.DynamicAnimation$14("scrollY");
    }

    DynamicAnimation(FloatValueHolder arg3) {
        super();
        this.mVelocity = 0f;
        this.mValue = 3.402823E+38f;
        this.mStartValueIsSet = false;
        this.mRunning = false;
        this.mMaxValue = 3.402823E+38f;
        this.mMinValue = -3.402823E+38f;
        this.mLastFrameTime = 0;
        this.mEndListeners = new ArrayList();
        this.mUpdateListeners = new ArrayList();
        this.mTarget = null;
        this.mProperty = new FloatPropertyCompat("FloatValueHolder", arg3) {
            public float getValue(Object arg1) {
                return this.val$floatValueHolder.getValue();
            }

            public void setValue(Object arg1, float arg2) {
                this.val$floatValueHolder.setValue(arg2);
            }
        };
        this.mMinVisibleChange = 1f;
    }

    DynamicAnimation(Object arg3, FloatPropertyCompat arg4) {
        super();
        this.mVelocity = 0f;
        this.mValue = 3.402823E+38f;
        this.mStartValueIsSet = false;
        this.mRunning = false;
        this.mMaxValue = 3.402823E+38f;
        this.mMinValue = -3.402823E+38f;
        this.mLastFrameTime = 0;
        this.mEndListeners = new ArrayList();
        this.mUpdateListeners = new ArrayList();
        this.mTarget = arg3;
        this.mProperty = arg4;
        if(arg4 != DynamicAnimation.ROTATION && arg4 != DynamicAnimation.ROTATION_X) {
            if(arg4 == DynamicAnimation.ROTATION_Y) {
            }
            else {
                float v0 = 0.003906f;
                if(arg4 == DynamicAnimation.ALPHA) {
                    this.mMinVisibleChange = v0;
                    return;
                }
                else {
                    if(arg4 != DynamicAnimation.SCALE_X) {
                        if(arg4 == DynamicAnimation.SCALE_Y) {
                        }
                        else {
                            this.mMinVisibleChange = 1f;
                            return;
                        }
                    }

                    this.mMinVisibleChange = v0;
                    return;
                }
            }
        }

        this.mMinVisibleChange = 0.1f;
    }

    public DynamicAnimation addEndListener(OnAnimationEndListener arg2) {
        if(!this.mEndListeners.contains(arg2)) {
            this.mEndListeners.add(arg2);
        }

        return this;
    }

    public DynamicAnimation addUpdateListener(OnAnimationUpdateListener arg2) {
        if(!this.isRunning()) {
            if(!this.mUpdateListeners.contains(arg2)) {
                this.mUpdateListeners.add(arg2);
            }

            return this;
        }

        throw new UnsupportedOperationException("Error: Update listeners must be added beforethe animation.");
    }

    public void cancel() {
        if(Looper.myLooper() == Looper.getMainLooper()) {
            if(this.mRunning) {
                this.endAnimationInternal(true);
            }

            return;
        }

        throw new AndroidRuntimeException("Animations may only be canceled on the main thread");
    }

    public boolean doAnimationFrame(long arg5) {
        long v0 = this.mLastFrameTime;
        if(Long.compare(v0, 0) == 0) {
            this.mLastFrameTime = arg5;
            this.setPropertyValue(this.mValue);
            return 0;
        }

        this.mLastFrameTime = arg5;
        boolean v5 = this.updateValueAndVelocity(arg5 - v0);
        float v6 = Math.min(this.mValue, this.mMaxValue);
        this.mValue = v6;
        v6 = Math.max(v6, this.mMinValue);
        this.mValue = v6;
        this.setPropertyValue(v6);
        if(v5) {
            this.endAnimationInternal(false);
        }

        return v5;
    }

    private void endAnimationInternal(boolean arg5) {
        ArrayList v2;
        int v0 = 0;
        this.mRunning = false;
        AnimationHandler.getInstance().removeCallback(((AnimationFrameCallback)this));
        this.mLastFrameTime = 0;
        this.mStartValueIsSet = false;
        while(true) {
            int v1 = this.mEndListeners.size();
            v2 = this.mEndListeners;
            if(v0 >= v1) {
                break;
            }

            if(v2.get(v0) != null) {
                this.mEndListeners.get(v0).onAnimationEnd(this, arg5, this.mValue, this.mVelocity);
            }

            ++v0;
        }

        DynamicAnimation.removeNullEntries(v2);
    }

    abstract float getAcceleration(float arg1, float arg2);

    public float getMinimumVisibleChange() {
        return this.mMinVisibleChange;
    }

    private float getPropertyValue() {
        return this.mProperty.getValue(this.mTarget);
    }

    float getValueThreshold() {
        return this.mMinVisibleChange * 0.75f;
    }

    abstract boolean isAtEquilibrium(float arg1, float arg2);

    public boolean isRunning() {
        return this.mRunning;
    }

    public void removeEndListener(OnAnimationEndListener arg1) {
        DynamicAnimation.removeEntry(this.mEndListeners, arg1);
    }

    private static void removeEntry(ArrayList arg1, Object arg2) {
        int v2 = arg1.indexOf(arg2);
        if(v2 >= 0) {
            arg1.set(v2, null);
        }
    }

    private static void removeNullEntries(ArrayList arg2) {
        int v0;
        for(v0 = arg2.size() - 1; v0 >= 0; --v0) {
            if(arg2.get(v0) == null) {
                arg2.remove(v0);
            }
        }
    }

    public void removeUpdateListener(OnAnimationUpdateListener arg1) {
        DynamicAnimation.removeEntry(this.mUpdateListeners, arg1);
    }

    public DynamicAnimation setMaxValue(float arg1) {
        this.mMaxValue = arg1;
        return this;
    }

    public DynamicAnimation setMinValue(float arg1) {
        this.mMinValue = arg1;
        return this;
    }

    public DynamicAnimation setMinimumVisibleChange(float arg2) {
        if(arg2 > 0f) {
            this.mMinVisibleChange = arg2;
            this.setValueThreshold(arg2 * 0.75f);
            return this;
        }

        throw new IllegalArgumentException("Minimum visible change must be positive.");
    }

    void setPropertyValue(float arg4) {
        ArrayList v1;
        this.mProperty.setValue(this.mTarget, arg4);
        int v4;
        for(v4 = 0; true; ++v4) {
            int v0 = this.mUpdateListeners.size();
            v1 = this.mUpdateListeners;
            if(v4 >= v0) {
                break;
            }

            if(v1.get(v4) != null) {
                this.mUpdateListeners.get(v4).onAnimationUpdate(this, this.mValue, this.mVelocity);
            }
        }

        DynamicAnimation.removeNullEntries(v1);
    }

    public DynamicAnimation setStartValue(float arg1) {
        this.mValue = arg1;
        this.mStartValueIsSet = true;
        return this;
    }

    public DynamicAnimation setStartVelocity(float arg1) {
        this.mVelocity = arg1;
        return this;
    }

    abstract void setValueThreshold(float arg1);

    public void start() {
        if(Looper.myLooper() == Looper.getMainLooper()) {
            if(!this.mRunning) {
                this.startAnimationInternal();
            }

            return;
        }

        throw new AndroidRuntimeException("Animations may only be started on the main thread");
    }

    private void startAnimationInternal() {
        if(!this.mRunning) {
            this.mRunning = true;
            if(!this.mStartValueIsSet) {
                this.mValue = this.getPropertyValue();
            }

            float v0 = this.mValue;
            if(v0 <= this.mMaxValue && v0 >= this.mMinValue) {
                AnimationHandler.getInstance().addAnimationFrameCallback(((AnimationFrameCallback)this), 0);
                return;
            }

            throw new IllegalArgumentException("Starting value need to be in between min value and max value");
        }
    }

    abstract boolean updateValueAndVelocity(long arg1);
}

