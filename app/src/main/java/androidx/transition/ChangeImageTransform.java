package androidx.transition;

import android.animation.Animator$AnimatorListener;
import android.animation.Animator$AnimatorPauseListener;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView$ScaleType;
import android.widget.ImageView;
import java.util.Map;

public class ChangeImageTransform extends Transition {
    class androidx.transition.ChangeImageTransform$1 implements TypeEvaluator {
        androidx.transition.ChangeImageTransform$1() {
            super();
        }

        public Matrix evaluate(float arg1, Matrix arg2, Matrix arg3) {
            return null;
        }

        public Object evaluate(float arg1, Object arg2, Object arg3) {
            return this.evaluate(arg1, ((Matrix)arg2), ((Matrix)arg3));
        }
    }

    class androidx.transition.ChangeImageTransform$2 extends Property {
        androidx.transition.ChangeImageTransform$2(Class arg1, String arg2) {
            super(arg1, arg2);
        }

        public Matrix get(ImageView arg1) {
            return null;
        }

        public Object get(Object arg1) {
            return this.get(((ImageView)arg1));
        }

        public void set(ImageView arg1, Matrix arg2) {
            ImageViewUtils.animateTransform(arg1, arg2);
        }

        public void set(Object arg1, Object arg2) {
            this.set(((ImageView)arg1), ((Matrix)arg2));
        }
    }

    class androidx.transition.ChangeImageTransform$3 {
        static {
            int[] v0 = new int[ImageView$ScaleType.values().length];
            androidx.transition.ChangeImageTransform$3.$SwitchMap$android$widget$ImageView$ScaleType = v0;
            try {
                v0[ImageView$ScaleType.FIT_XY.ordinal()] = 1;
                goto label_8;
            }
            catch(NoSuchFieldError ) {
                try {
                label_8:
                    androidx.transition.ChangeImageTransform$3.$SwitchMap$android$widget$ImageView$ScaleType[ImageView$ScaleType.CENTER_CROP.ordinal()] = 2;
                    return;
                }
                catch(NoSuchFieldError ) {
                    return;
                }
            }
        }
    }

    class Listener extends AnimatorListenerAdapter implements TransitionListener {
        private final Matrix mEndMatrix;
        private final ImageView mImageView;
        private boolean mIsBeforeAnimator;
        private final Matrix mStartMatrix;

        Listener(ImageView arg2, Matrix arg3, Matrix arg4) {
            super();
            this.mIsBeforeAnimator = true;
            this.mImageView = arg2;
            this.mStartMatrix = arg3;
            this.mEndMatrix = arg4;
        }

        public void onAnimationEnd(Animator arg1) {
            this.mIsBeforeAnimator = false;
        }

        public void onAnimationEnd(Animator arg1, boolean arg2) {
            this.mIsBeforeAnimator = arg2;
        }

        public void onAnimationPause(Animator arg1) {
            this.saveMatrix(((ObjectAnimator)arg1).getAnimatedValue());
        }

        public void onAnimationResume(Animator arg1) {
            this.restoreMatrix();
        }

        public void onAnimationStart(Animator arg1) {
            this.mIsBeforeAnimator = false;
        }

        public void onAnimationStart(Animator arg1, boolean arg2) {
            this.mIsBeforeAnimator = false;
        }

        public void onTransitionCancel(Transition arg1) {
        }

        public void onTransitionEnd(Transition arg1) {
        }

        public void onTransitionPause(Transition arg1) {
            if(this.mIsBeforeAnimator) {
                this.saveMatrix(this.mStartMatrix);
            }
        }

        public void onTransitionResume(Transition arg1) {
            this.restoreMatrix();
        }

        public void onTransitionStart(Transition arg1) {
        }

        private void restoreMatrix() {
            Object v0 = this.mImageView.getTag(id.transition_image_transform);
            if(v0 != null) {
                ImageViewUtils.animateTransform(this.mImageView, ((Matrix)v0));
                this.mImageView.setTag(id.transition_image_transform, null);
            }
        }

        private void saveMatrix(Matrix arg3) {
            this.mImageView.setTag(id.transition_image_transform, arg3);
            ImageViewUtils.animateTransform(this.mImageView, this.mEndMatrix);
        }
    }

    private static final Property ANIMATED_TRANSFORM_PROPERTY = null;
    private static final TypeEvaluator NULL_MATRIX_EVALUATOR = null;
    private static final String PROPNAME_BOUNDS = "android:changeImageTransform:bounds";
    private static final String PROPNAME_MATRIX = "android:changeImageTransform:matrix";
    private static final String[] sTransitionProperties;

    static {
        ChangeImageTransform.sTransitionProperties = new String[]{"android:changeImageTransform:matrix", "android:changeImageTransform:bounds"};
        ChangeImageTransform.NULL_MATRIX_EVALUATOR = new androidx.transition.ChangeImageTransform$1();
        ChangeImageTransform.ANIMATED_TRANSFORM_PROPERTY = new androidx.transition.ChangeImageTransform$2(Matrix.class, "animatedTransform");
    }

    public ChangeImageTransform() {
        super();
    }

    public ChangeImageTransform(Context arg1, AttributeSet arg2) {
        super(arg1, arg2);
    }

    public void captureEndValues(TransitionValues arg2) {
        this.captureValues(arg2, false);
    }

    public void captureStartValues(TransitionValues arg2) {
        this.captureValues(arg2, true);
    }

    private void captureValues(TransitionValues arg6, boolean arg7) {
        Matrix v5_2;
        View v5 = arg6.view;
        if((v5 instanceof ImageView)) {
            if(v5.getVisibility() != 0) {
            }
            else {
                View v0 = v5;
                if(((ImageView)v0).getDrawable() == null) {
                }
                else {
                    Map v6 = arg6.values;
                    v6.put("android:changeImageTransform:bounds", new Rect(v5.getLeft(), v5.getTop(), v5.getRight(), v5.getBottom()));
                    Object v5_1 = arg7 ? ((ImageView)v0).getTag(id.transition_image_transform) : null;
                    if(v5_1 == null) {
                        v5_2 = ChangeImageTransform.copyImageMatrix(((ImageView)v0));
                    }

                    v6.put("android:changeImageTransform:matrix", v5_2);
                }
            }
        }
    }

    private static Matrix centerCropMatrix(ImageView arg5) {
        Drawable v0 = arg5.getDrawable();
        int v1 = v0.getIntrinsicWidth();
        float v2 = ((float)arg5.getWidth());
        float v1_1 = ((float)v1);
        int v0_1 = v0.getIntrinsicHeight();
        float v5 = ((float)arg5.getHeight());
        float v0_2 = ((float)v0_1);
        float v3 = Math.max(v2 / v1_1, v5 / v0_2);
        int v2_1 = Math.round((v2 - v1_1 * v3) / 2f);
        int v5_1 = Math.round((v5 - v0_2 * v3) / 2f);
        Matrix v0_3 = new Matrix();
        v0_3.postScale(v3, v3);
        v0_3.postTranslate(((float)v2_1), ((float)v5_1));
        return v0_3;
    }

    private static Matrix copyImageMatrix(ImageView arg2) {
        Drawable v0 = arg2.getDrawable();
        if(v0.getIntrinsicWidth() > 0 && v0.getIntrinsicHeight() > 0) {
            int v0_1 = androidx.transition.ChangeImageTransform$3.$SwitchMap$android$widget$ImageView$ScaleType[arg2.getScaleType().ordinal()];
            if(v0_1 == 1) {
                return ChangeImageTransform.fitXYMatrix(arg2);
            }
            else if(v0_1 != 2) {
                return new Matrix(arg2.getImageMatrix());
            }
            else {
                return ChangeImageTransform.centerCropMatrix(arg2);
            }
        }

        return new Matrix(arg2.getImageMatrix());
    }

    public Animator createAnimator(ViewGroup arg5, TransitionValues arg6, TransitionValues arg7) {
        int v3;
        Animator v5 = null;
        if(arg6 != null) {
            if(arg7 == null) {
            }
            else {
                Object v0 = arg6.values.get("android:changeImageTransform:bounds");
                Object v1 = arg7.values.get("android:changeImageTransform:bounds");
                if(v0 != null) {
                    if(v1 == null) {
                    }
                    else {
                        Object v6 = arg6.values.get("android:changeImageTransform:matrix");
                        Object v2 = arg7.values.get("android:changeImageTransform:matrix");
                        if(v6 != null || v2 != null) {
                            if(v6 != null && (((Matrix)v6).equals(v2))) {
                            label_22:
                                v3 = 1;
                                goto label_25;
                            }

                            v3 = 0;
                        }
                        else {
                            goto label_22;
                        }

                    label_25:
                        if((((Rect)v0).equals(v1)) && v3 != 0) {
                            return v5;
                        }

                        View v5_1 = arg7.view;
                        Drawable v7 = ((ImageView)v5_1).getDrawable();
                        int v0_1 = v7.getIntrinsicWidth();
                        int v7_1 = v7.getIntrinsicHeight();
                        if(v0_1 > 0) {
                            if(v7_1 <= 0) {
                            }
                            else {
                                if(v6 == null) {
                                    Matrix v6_1 = MatrixUtils.IDENTITY_MATRIX;
                                }

                                if(v2 == null) {
                                    Matrix v2_1 = MatrixUtils.IDENTITY_MATRIX;
                                }

                                ChangeImageTransform.ANIMATED_TRANSFORM_PROPERTY.set(v5_1, v6);
                                ObjectAnimator v7_2 = this.createMatrixAnimator(((ImageView)v5_1), ((Matrix)v6), ((Matrix)v2));
                                Listener v0_2 = new Listener(((ImageView)v5_1), ((Matrix)v6), ((Matrix)v2));
                                v7_2.addListener(((Animator$AnimatorListener)v0_2));
                                v7_2.addPauseListener(((Animator$AnimatorPauseListener)v0_2));
                                this.addListener(((TransitionListener)v0_2));
                                return ((Animator)v7_2);
                            }
                        }

                        return this.createNullAnimator(((ImageView)v5_1));
                    }
                }
            }
        }

        return v5;
    }

    private ObjectAnimator createMatrixAnimator(ImageView arg4, Matrix arg5, Matrix arg6) {
        return ObjectAnimator.ofObject(arg4, ChangeImageTransform.ANIMATED_TRANSFORM_PROPERTY, new MatrixEvaluator(), new Matrix[]{arg5, arg6});
    }

    private ObjectAnimator createNullAnimator(ImageView arg5) {
        return ObjectAnimator.ofObject(arg5, ChangeImageTransform.ANIMATED_TRANSFORM_PROPERTY, ChangeImageTransform.NULL_MATRIX_EVALUATOR, new Matrix[]{MatrixUtils.IDENTITY_MATRIX, MatrixUtils.IDENTITY_MATRIX});
    }

    private static Matrix fitXYMatrix(ImageView arg4) {
        Drawable v0 = arg4.getDrawable();
        Matrix v1 = new Matrix();
        v1.postScale((((float)arg4.getWidth())) / (((float)v0.getIntrinsicWidth())), (((float)arg4.getHeight())) / (((float)v0.getIntrinsicHeight())));
        return v1;
    }

    public String[] getTransitionProperties() {
        return ChangeImageTransform.sTransitionProperties;
    }

    public boolean isSeekingSupported() {
        return 1;
    }
}

