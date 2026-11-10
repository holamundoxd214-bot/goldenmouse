package com.google.android.material.circularreveal;

import android.animation.TypeEvaluator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.Property;
import com.google.android.material.math.MathUtils;

public interface CircularRevealWidget extends Delegate {
    class com.google.android.material.circularreveal.CircularRevealWidget$1 {
    }

    public class CircularRevealEvaluator implements TypeEvaluator {
        public static final TypeEvaluator CIRCULAR_REVEAL;
        private final RevealInfo revealInfo;

        static {
            CircularRevealEvaluator.CIRCULAR_REVEAL = new CircularRevealEvaluator();
        }

        public CircularRevealEvaluator() {
            super();
            this.revealInfo = new RevealInfo(null);
        }

        public RevealInfo evaluate(float arg5, RevealInfo arg6, RevealInfo arg7) {
            this.revealInfo.set(MathUtils.lerp(arg6.centerX, arg7.centerX, arg5), MathUtils.lerp(arg6.centerY, arg7.centerY, arg5), MathUtils.lerp(arg6.radius, arg7.radius, arg5));
            return this.revealInfo;
        }

        public Object evaluate(float arg1, Object arg2, Object arg3) {
            return this.evaluate(arg1, ((RevealInfo)arg2), ((RevealInfo)arg3));
        }
    }

    public class CircularRevealProperty extends Property {
        public static final Property CIRCULAR_REVEAL;

        static {
            CircularRevealProperty.CIRCULAR_REVEAL = new CircularRevealProperty("circularReveal");
        }

        private CircularRevealProperty(String arg2) {
            super(RevealInfo.class, arg2);
        }

        public RevealInfo get(CircularRevealWidget arg1) {
            return arg1.getRevealInfo();
        }

        public Object get(Object arg1) {
            return this.get(((CircularRevealWidget)arg1));
        }

        public void set(CircularRevealWidget arg1, RevealInfo arg2) {
            arg1.setRevealInfo(arg2);
        }

        public void set(Object arg1, Object arg2) {
            this.set(((CircularRevealWidget)arg1), ((RevealInfo)arg2));
        }
    }

    public class CircularRevealScrimColorProperty extends Property {
        public static final Property CIRCULAR_REVEAL_SCRIM_COLOR;

        static {
            CircularRevealScrimColorProperty.CIRCULAR_REVEAL_SCRIM_COLOR = new CircularRevealScrimColorProperty("circularRevealScrimColor");
        }

        private CircularRevealScrimColorProperty(String arg2) {
            super(Integer.class, arg2);
        }

        public Integer get(CircularRevealWidget arg1) {
            return Integer.valueOf(arg1.getCircularRevealScrimColor());
        }

        public Object get(Object arg1) {
            return this.get(((CircularRevealWidget)arg1));
        }

        public void set(CircularRevealWidget arg1, Integer arg2) {
            arg1.setCircularRevealScrimColor(arg2.intValue());
        }

        public void set(Object arg1, Object arg2) {
            this.set(((CircularRevealWidget)arg1), ((Integer)arg2));
        }
    }

    public class RevealInfo {
        public static final float INVALID_RADIUS = 3.402823E+38f;
        public float centerX;
        public float centerY;
        public float radius;

        public RevealInfo(float arg1, float arg2, float arg3) {
            super();
            this.centerX = arg1;
            this.centerY = arg2;
            this.radius = arg3;
        }

        RevealInfo(com.google.android.material.circularreveal.CircularRevealWidget$1 arg1) {
            this();
        }

        private RevealInfo() {
            super();
        }

        public RevealInfo(RevealInfo arg3) {
            this(arg3.centerX, arg3.centerY, arg3.radius);
        }

        public boolean isInvalid() {
            if(this.radius == 3.402823E+38f) {
                return 1;
            }

            return 0;
        }

        public void set(float arg1, float arg2, float arg3) {
            this.centerX = arg1;
            this.centerY = arg2;
            this.radius = arg3;
        }

        public void set(RevealInfo arg3) {
            this.set(arg3.centerX, arg3.centerY, arg3.radius);
        }
    }

    void buildCircularRevealCache();

    void destroyCircularRevealCache();

    void draw(Canvas arg1);

    Drawable getCircularRevealOverlayDrawable();

    int getCircularRevealScrimColor();

    RevealInfo getRevealInfo();

    boolean isOpaque();

    void setCircularRevealOverlayDrawable(Drawable arg1);

    void setCircularRevealScrimColor(int arg1);

    void setRevealInfo(RevealInfo arg1);
}

