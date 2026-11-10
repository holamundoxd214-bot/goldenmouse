package androidx.core.view.insets;

import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.core.graphics.Insets;

public abstract class Protection {
    class Attributes {
        interface Callback {
            default void onAlphaChanged(float arg1) {
            }

            default void onDrawableChanged(Drawable arg1) {
            }

            default void onHeightChanged(int arg1) {
            }

            default void onMarginChanged(Insets arg1) {
            }

            default void onTranslationXChanged(float arg1) {
            }

            default void onTranslationYChanged(float arg1) {
            }

            default void onVisibilityChanged(boolean arg1) {
            }

            default void onWidthChanged(int arg1) {
            }
        }

        private static final int UNSPECIFIED = -1;
        private float mAlpha;
        private Callback mCallback;
        private Drawable mDrawable;
        private int mHeight;
        private Insets mMargin;
        private float mTranslationX;
        private float mTranslationY;
        private boolean mVisible;
        private int mWidth;

        static int -$$Nest$fgetmHeight(Attributes arg0) {
            return arg0.mHeight;
        }

        static int -$$Nest$fgetmWidth(Attributes arg0) {
            return arg0.mWidth;
        }

        static void -$$Nest$msetAlpha(Attributes arg0, float arg1) {
            arg0.setAlpha(arg1);
        }

        static void -$$Nest$msetDrawable(Attributes arg0, Drawable arg1) {
            arg0.setDrawable(arg1);
        }

        static void -$$Nest$msetHeight(Attributes arg0, int arg1) {
            arg0.setHeight(arg1);
        }

        static void -$$Nest$msetMargin(Attributes arg0, Insets arg1) {
            arg0.setMargin(arg1);
        }

        static void -$$Nest$msetTranslationX(Attributes arg0, float arg1) {
            arg0.setTranslationX(arg1);
        }

        static void -$$Nest$msetTranslationY(Attributes arg0, float arg1) {
            arg0.setTranslationY(arg1);
        }

        static void -$$Nest$msetVisible(Attributes arg0, boolean arg1) {
            arg0.setVisible(arg1);
        }

        static void -$$Nest$msetWidth(Attributes arg0, int arg1) {
            arg0.setWidth(arg1);
        }

        Attributes() {
            super();
            this.mWidth = -1;
            this.mHeight = -1;
            this.mMargin = Insets.NONE;
            this.mVisible = false;
            this.mDrawable = null;
            this.mTranslationX = 0f;
            this.mTranslationY = 0f;
            this.mAlpha = 1f;
        }

        float getAlpha() {
            return this.mAlpha;
        }

        Drawable getDrawable() {
            return this.mDrawable;
        }

        int getHeight() {
            return this.mHeight;
        }

        Insets getMargin() {
            return this.mMargin;
        }

        float getTranslationX() {
            return this.mTranslationX;
        }

        float getTranslationY() {
            return this.mTranslationY;
        }

        int getWidth() {
            return this.mWidth;
        }

        boolean isVisible() {
            return this.mVisible;
        }

        private void setAlpha(float arg2) {
            if(this.mAlpha != arg2) {
                this.mAlpha = arg2;
                Callback v1 = this.mCallback;
                if(v1 != null) {
                    v1.onAlphaChanged(arg2);
                }
            }
        }

        void setCallback(Callback arg2) {
            if(this.mCallback != null) {
                if(arg2 == null) {
                }
                else {
                    throw new IllegalStateException("Trying to overwrite the existing callback. Did you send one protection to multiple ProtectionLayouts?");
                }
            }

            this.mCallback = arg2;
        }

        private void setDrawable(Drawable arg1) {
            this.mDrawable = arg1;
            Callback v0 = this.mCallback;
            if(v0 != null) {
                v0.onDrawableChanged(arg1);
            }
        }

        private void setHeight(int arg2) {
            if(this.mHeight != arg2) {
                this.mHeight = arg2;
                Callback v1 = this.mCallback;
                if(v1 != null) {
                    v1.onHeightChanged(arg2);
                }
            }
        }

        private void setMargin(Insets arg2) {
            if(!this.mMargin.equals(arg2)) {
                this.mMargin = arg2;
                Callback v1 = this.mCallback;
                if(v1 != null) {
                    v1.onMarginChanged(arg2);
                }
            }
        }

        private void setTranslationX(float arg2) {
            if(this.mTranslationX != arg2) {
                this.mTranslationX = arg2;
                Callback v1 = this.mCallback;
                if(v1 != null) {
                    v1.onTranslationXChanged(arg2);
                }
            }
        }

        private void setTranslationY(float arg2) {
            if(this.mTranslationY != arg2) {
                this.mTranslationY = arg2;
                Callback v1 = this.mCallback;
                if(v1 != null) {
                    v1.onTranslationYChanged(arg2);
                }
            }
        }

        private void setVisible(boolean arg2) {
            if(this.mVisible != arg2) {
                this.mVisible = arg2;
                Callback v1 = this.mCallback;
                if(v1 != null) {
                    v1.onVisibilityChanged(arg2);
                }
            }
        }

        private void setWidth(int arg2) {
            if(this.mWidth != arg2) {
                this.mWidth = arg2;
                Callback v1 = this.mCallback;
                if(v1 != null) {
                    v1.onWidthChanged(arg2);
                }
            }
        }
    }

    private static final long DEFAULT_DURATION_IN = 333;
    private static final long DEFAULT_DURATION_OUT = 0xA6;
    private static final Interpolator DEFAULT_INTERPOLATOR_FADE_IN;
    private static final Interpolator DEFAULT_INTERPOLATOR_FADE_OUT;
    private static final Interpolator DEFAULT_INTERPOLATOR_MOVE_IN;
    private static final Interpolator DEFAULT_INTERPOLATOR_MOVE_OUT;
    private final Attributes mAttributes;
    private Object mController;
    private Insets mInsets;
    private Insets mInsetsIgnoringVisibility;
    private final int mSide;
    private float mSystemAlpha;
    private float mSystemInsetAmount;
    private float mUserAlpha;
    private ValueAnimator mUserAlphaAnimator;
    private float mUserInsetAmount;
    private ValueAnimator mUserInsetAmountAnimator;

    static {
        Protection.DEFAULT_INTERPOLATOR_MOVE_IN = new PathInterpolator(0f, 0f, 0f, 1f);
        Protection.DEFAULT_INTERPOLATOR_MOVE_OUT = new PathInterpolator(0.6f, 0f, 1f, 1f);
        Protection.DEFAULT_INTERPOLATOR_FADE_IN = new PathInterpolator(0f, 0f, 0.2f, 1f);
        Protection.DEFAULT_INTERPOLATOR_FADE_OUT = new PathInterpolator(0.4f, 0f, 1f, 1f);
    }

    public Protection(int arg3) {
        super();
        this.mAttributes = new Attributes();
        this.mInsets = Insets.NONE;
        this.mInsetsIgnoringVisibility = Insets.NONE;
        this.mSystemAlpha = 1f;
        this.mUserAlpha = 1f;
        this.mSystemInsetAmount = 1f;
        this.mUserInsetAmount = 1f;
        this.mController = null;
        this.mUserAlphaAnimator = null;
        this.mUserInsetAmountAnimator = null;
        if(arg3 != 1 && arg3 != 2 && arg3 != 4) {
            if(arg3 == 8) {
            }
            else {
                throw new IllegalArgumentException("Unexpected side: " + arg3);
            }
        }

        this.mSide = arg3;
    }

    public void animateAlpha(float arg4) {
        this.cancelUserAlphaAnimation();
        float v0 = this.mUserAlpha;
        if(arg4 == v0) {
            return;
        }

        ValueAnimator v0_1 = ValueAnimator.ofFloat(new float[]{v0, arg4});
        this.mUserAlphaAnimator = v0_1;
        if(this.mUserAlpha < arg4) {
            v0_1.setDuration(333);
            this.mUserAlphaAnimator.setInterpolator(Protection.DEFAULT_INTERPOLATOR_FADE_IN);
        }
        else {
            v0_1.setDuration(0xA6);
            this.mUserAlphaAnimator.setInterpolator(Protection.DEFAULT_INTERPOLATOR_FADE_OUT);
        }

        this.mUserAlphaAnimator.addUpdateListener(new Protection$$ExternalSyntheticLambda1(this));
        this.mUserAlphaAnimator.start();
    }

    public void animateInsetsAmount(float arg4) {
        this.cancelUserInsetsAmountAnimation();
        float v0 = this.mUserInsetAmount;
        if(arg4 == v0) {
            return;
        }

        ValueAnimator v0_1 = ValueAnimator.ofFloat(new float[]{v0, arg4});
        this.mUserInsetAmountAnimator = v0_1;
        if(this.mUserInsetAmount < arg4) {
            v0_1.setDuration(333);
            this.mUserInsetAmountAnimator.setInterpolator(Protection.DEFAULT_INTERPOLATOR_MOVE_IN);
        }
        else {
            v0_1.setDuration(0xA6);
            this.mUserInsetAmountAnimator.setInterpolator(Protection.DEFAULT_INTERPOLATOR_MOVE_OUT);
        }

        this.mUserInsetAmountAnimator.addUpdateListener(new Protection$$ExternalSyntheticLambda0(this));
        this.mUserInsetAmountAnimator.start();
    }

    private void cancelUserAlphaAnimation() {
        ValueAnimator v0 = this.mUserAlphaAnimator;
        if(v0 != null) {
            v0.cancel();
            this.mUserAlphaAnimator = null;
        }
    }

    private void cancelUserInsetsAmountAnimation() {
        ValueAnimator v0 = this.mUserInsetAmountAnimator;
        if(v0 != null) {
            v0.cancel();
            this.mUserInsetAmountAnimator = null;
        }
    }

    void dispatchColorHint(int arg1) {
    }

    Insets dispatchInsets(Insets arg1, Insets arg2, Insets arg3) {
        this.mInsets = arg1;
        this.mInsetsIgnoringVisibility = arg2;
        Attributes.-$$Nest$msetMargin(this.mAttributes, arg3);
        return this.updateLayout();
    }

    public float getAlpha() {
        return this.mUserAlpha;
    }

    Attributes getAttributes() {
        return this.mAttributes;
    }

    Object getController() {
        return this.mController;
    }

    public float getInsetAmount() {
        return this.mUserInsetAmount;
    }

    public int getSide() {
        return this.mSide;
    }

    int getThickness(int arg1) {
        return arg1;
    }

    void lambda$animateAlpha$0$androidx-core-view-insets-Protection(ValueAnimator arg1) {
        this.setAlphaInternal(arg1.getAnimatedValue().floatValue());
    }

    void lambda$animateInsetsAmount$1$androidx-core-view-insets-Protection(ValueAnimator arg1) {
        this.setAlphaInternal(arg1.getAnimatedValue().floatValue());
    }

    boolean occupiesCorners() {
        return 0;
    }

    public void setAlpha(float arg3) {
        if(arg3 >= 0f && arg3 <= 1f) {
            this.cancelUserAlphaAnimation();
            this.setAlphaInternal(arg3);
            return;
        }

        throw new IllegalArgumentException("Alpha must in a range of [0, 1]. Got: " + arg3);
    }

    private void setAlphaInternal(float arg1) {
        this.mUserAlpha = arg1;
        this.updateAlpha();
    }

    void setController(Object arg1) {
        this.mController = arg1;
    }

    void setDrawable(Drawable arg1) {
        Attributes.-$$Nest$msetDrawable(this.mAttributes, arg1);
    }

    public void setInsetAmount(float arg3) {
        if(arg3 >= 0f && arg3 <= 1f) {
            this.cancelUserInsetsAmountAnimation();
            this.setInsetAmountInternal(arg3);
            return;
        }

        throw new IllegalArgumentException("Inset amount must in a range of [0, 1]. Got: " + arg3);
    }

    private void setInsetAmountInternal(float arg1) {
        this.mUserInsetAmount = arg1;
        this.updateInsetAmount();
    }

    void setSystemAlpha(float arg1) {
        this.mSystemAlpha = arg1;
        this.updateAlpha();
    }

    void setSystemInsetAmount(float arg1) {
        this.mSystemInsetAmount = arg1;
        this.updateInsetAmount();
    }

    void setSystemVisible(boolean arg1) {
        Attributes.-$$Nest$msetVisible(this.mAttributes, arg1);
    }

    private void updateAlpha() {
        Attributes.-$$Nest$msetAlpha(this.mAttributes, this.mSystemAlpha * this.mUserAlpha);
    }

    private void updateInsetAmount() {
        float v0 = this.mUserInsetAmount * this.mSystemInsetAmount;
        int v1 = this.mSide;
        float v3 = 1f;
        if(v1 != 1) {
            if(v1 != 2) {
                if(v1 != 4) {
                    if(v1 != 8) {
                        return;
                    }

                    Attributes.-$$Nest$msetTranslationY(this.mAttributes, (v3 - v0) * (((float)Attributes.-$$Nest$fgetmHeight(this.mAttributes))));
                    return;
                }

                Attributes.-$$Nest$msetTranslationX(this.mAttributes, (v3 - v0) * (((float)Attributes.-$$Nest$fgetmWidth(this.mAttributes))));
                return;
            }

            Attributes.-$$Nest$msetTranslationY(this.mAttributes, -(v3 - v0) * (((float)Attributes.-$$Nest$fgetmHeight(this.mAttributes))));
            return;
        }

        Attributes.-$$Nest$msetTranslationX(this.mAttributes, -(v3 - v0) * (((float)Attributes.-$$Nest$fgetmWidth(this.mAttributes))));
    }

    Insets updateLayout() {
        Insets v0 = Insets.NONE;
        int v1 = this.mSide;
        boolean v2 = false;
        if(v1 == 1) {
            v1 = this.mInsets.left;
            Attributes.-$$Nest$msetWidth(this.mAttributes, this.getThickness(this.mInsetsIgnoringVisibility.left));
            if(this.occupiesCorners()) {
                v0 = Insets.of(this.getThickness(v1), 0, 0, 0);
            }
        }
        else if(v1 == 2) {
            v1 = this.mInsets.top;
            Attributes.-$$Nest$msetHeight(this.mAttributes, this.getThickness(this.mInsetsIgnoringVisibility.top));
            if(this.occupiesCorners()) {
                v0 = Insets.of(0, this.getThickness(v1), 0, 0);
            }
        }
        else if(v1 == 4) {
            v1 = this.mInsets.right;
            Attributes.-$$Nest$msetWidth(this.mAttributes, this.getThickness(this.mInsetsIgnoringVisibility.right));
            if(this.occupiesCorners()) {
                v0 = Insets.of(0, 0, this.getThickness(v1), 0);
            }
        }
        else if(v1 != 8) {
            v1 = 0;
        }
        else {
            v1 = this.mInsets.bottom;
            Attributes.-$$Nest$msetHeight(this.mAttributes, this.getThickness(this.mInsetsIgnoringVisibility.bottom));
            if(this.occupiesCorners()) {
                v0 = Insets.of(0, 0, 0, this.getThickness(v1));
            }
        }

        if(v1 > 0) {
            v2 = true;
        }

        this.setSystemVisible(v2);
        float v2_1 = 1f;
        float v4 = v1 > 0 ? v2_1 : 0f;
        this.setSystemAlpha(v4);
        if(v1 > 0) {
        }
        else {
            v2_1 = 0f;
        }

        this.setSystemInsetAmount(v2_1);
        return v0;
    }
}

