package androidx.transition;

import android.animation.Animator$AnimatorListener;
import android.animation.Animator$AnimatorPauseListener;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.ViewCompat;
import org.xmlpull.v1.XmlPullParser;

public class ChangeTransform extends Transition {
    class androidx.transition.ChangeTransform$1 extends Property {
        androidx.transition.ChangeTransform$1(Class arg1, String arg2) {
            super(arg1, arg2);
        }

        public Object get(Object arg1) {
            return this.get(((PathAnimatorMatrix)arg1));
        }

        public float[] get(PathAnimatorMatrix arg1) {
            return null;
        }

        public void set(PathAnimatorMatrix arg1, float[] arg2) {
            arg1.setValues(arg2);
        }

        public void set(Object arg1, Object arg2) {
            this.set(((PathAnimatorMatrix)arg1), ((float[])arg2));
        }
    }

    class androidx.transition.ChangeTransform$2 extends Property {
        androidx.transition.ChangeTransform$2(Class arg1, String arg2) {
            super(arg1, arg2);
        }

        public PointF get(PathAnimatorMatrix arg1) {
            return null;
        }

        public Object get(Object arg1) {
            return this.get(((PathAnimatorMatrix)arg1));
        }

        public void set(PathAnimatorMatrix arg1, PointF arg2) {
            arg1.setTranslation(arg2);
        }

        public void set(Object arg1, Object arg2) {
            this.set(((PathAnimatorMatrix)arg1), ((PointF)arg2));
        }
    }

    class GhostListener extends TransitionListenerAdapter {
        private GhostView mGhostView;
        private View mView;

        GhostListener(View arg1, GhostView arg2) {
            super();
            this.mView = arg1;
            this.mGhostView = arg2;
        }

        public void onTransitionEnd(Transition arg3) {
            arg3.removeListener(((TransitionListener)this));
            GhostViewUtils.removeGhost(this.mView);
            this.mView.setTag(id.transition_transform, null);
            this.mView.setTag(id.parent_matrix, null);
        }

        public void onTransitionPause(Transition arg1) {
            this.mGhostView.setVisibility(4);
        }

        public void onTransitionResume(Transition arg1) {
            this.mGhostView.setVisibility(0);
        }
    }

    class Listener extends AnimatorListenerAdapter {
        private final Matrix mEndMatrix;
        private final boolean mHandleParentChange;
        private boolean mIsCanceled;
        private final PathAnimatorMatrix mPathAnimatorMatrix;
        private final Matrix mTempMatrix;
        private final Transforms mTransforms;
        private final boolean mUseOverlay;
        private final View mView;

        Listener(View arg2, Transforms arg3, PathAnimatorMatrix arg4, Matrix arg5, boolean arg6, boolean arg7) {
            super();
            this.mTempMatrix = new Matrix();
            this.mHandleParentChange = arg6;
            this.mUseOverlay = arg7;
            this.mView = arg2;
            this.mTransforms = arg3;
            this.mPathAnimatorMatrix = arg4;
            this.mEndMatrix = arg5;
        }

        public void onAnimationCancel(Animator arg1) {
            this.mIsCanceled = true;
        }

        public void onAnimationEnd(Animator arg3) {
            Object v0 = null;
            if(!this.mIsCanceled) {
                if((this.mHandleParentChange) && (this.mUseOverlay)) {
                    this.setCurrentMatrix(this.mEndMatrix);
                    goto label_16;
                }

                this.mView.setTag(id.transition_transform, v0);
                this.mView.setTag(id.parent_matrix, v0);
            }

        label_16:
            ViewUtils.setAnimationMatrix(this.mView, ((Matrix)v0));
            this.mTransforms.restore(this.mView);
        }

        public void onAnimationPause(Animator arg1) {
            this.setCurrentMatrix(this.mPathAnimatorMatrix.getMatrix());
        }

        public void onAnimationResume(Animator arg1) {
            ChangeTransform.setIdentityTransforms(this.mView);
        }

        private void setCurrentMatrix(Matrix arg3) {
            this.mTempMatrix.set(arg3);
            this.mView.setTag(id.transition_transform, this.mTempMatrix);
            this.mTransforms.restore(this.mView);
        }
    }

    class PathAnimatorMatrix {
        private final Matrix mMatrix;
        private float mTranslationX;
        private float mTranslationY;
        private final float[] mValues;
        private final View mView;

        PathAnimatorMatrix(View arg2, float[] arg3) {
            super();
            this.mMatrix = new Matrix();
            this.mView = arg2;
            Object v2 = arg3.clone();
            this.mValues = ((float[])v2);
            this.mTranslationX = v2[2];
            this.mTranslationY = v2[5];
            this.setAnimationMatrix();
        }

        Matrix getMatrix() {
            return this.mMatrix;
        }

        private void setAnimationMatrix() {
            float[] v0 = this.mValues;
            v0[2] = this.mTranslationX;
            v0[5] = this.mTranslationY;
            this.mMatrix.setValues(v0);
            ViewUtils.setAnimationMatrix(this.mView, this.mMatrix);
        }

        void setTranslation(PointF arg2) {
            this.mTranslationX = arg2.x;
            this.mTranslationY = arg2.y;
            this.setAnimationMatrix();
        }

        void setValues(float[] arg4) {
            System.arraycopy(arg4, 0, this.mValues, 0, arg4.length);
            this.setAnimationMatrix();
        }
    }

    class Transforms {
        final float mRotationX;
        final float mRotationY;
        final float mRotationZ;
        final float mScaleX;
        final float mScaleY;
        final float mTranslationX;
        final float mTranslationY;
        final float mTranslationZ;

        Transforms(View arg2) {
            super();
            this.mTranslationX = arg2.getTranslationX();
            this.mTranslationY = arg2.getTranslationY();
            this.mTranslationZ = ViewCompat.getTranslationZ(arg2);
            this.mScaleX = arg2.getScaleX();
            this.mScaleY = arg2.getScaleY();
            this.mRotationX = arg2.getRotationX();
            this.mRotationY = arg2.getRotationY();
            this.mRotationZ = arg2.getRotation();
        }

        public boolean equals(Object arg4) {
            if(!(arg4 instanceof Transforms)) {
                return 0;
            }

            if(((Transforms)arg4).mTranslationX == this.mTranslationX && ((Transforms)arg4).mTranslationY == this.mTranslationY && ((Transforms)arg4).mTranslationZ == this.mTranslationZ && ((Transforms)arg4).mScaleX == this.mScaleX && ((Transforms)arg4).mScaleY == this.mScaleY && ((Transforms)arg4).mRotationX == this.mRotationX && ((Transforms)arg4).mRotationY == this.mRotationY && ((Transforms)arg4).mRotationZ == this.mRotationZ) {
                return 1;
            }

            return 0;
        }

        public int hashCode() {
            float v0 = this.mTranslationX;
            int v3 = 0;
            int v0_1 = Float.compare(v0, 0f) != 0 ? Float.floatToIntBits(v0) : 0;
            v0_1 *= 0x1F;
            float v2 = this.mTranslationY;
            int v2_1 = v2 != 0f ? Float.floatToIntBits(v2) : 0;
            v0_1 = (v0_1 + v2_1) * 0x1F;
            v2 = this.mTranslationZ;
            v2_1 = v2 != 0f ? Float.floatToIntBits(v2) : 0;
            v0_1 = (v0_1 + v2_1) * 0x1F;
            v2 = this.mScaleX;
            v2_1 = v2 != 0f ? Float.floatToIntBits(v2) : 0;
            v0_1 = (v0_1 + v2_1) * 0x1F;
            v2 = this.mScaleY;
            v2_1 = v2 != 0f ? Float.floatToIntBits(v2) : 0;
            v0_1 = (v0_1 + v2_1) * 0x1F;
            v2 = this.mRotationX;
            v2_1 = v2 != 0f ? Float.floatToIntBits(v2) : 0;
            v0_1 = (v0_1 + v2_1) * 0x1F;
            v2 = this.mRotationY;
            v2_1 = v2 != 0f ? Float.floatToIntBits(v2) : 0;
            v0_1 = (v0_1 + v2_1) * 0x1F;
            float v5 = this.mRotationZ;
            if(v5 != 0f) {
                v3 = Float.floatToIntBits(v5);
            }

            return v0_1 + v3;
        }

        public void restore(View arg10) {
            ChangeTransform.setTransforms(arg10, this.mTranslationX, this.mTranslationY, this.mTranslationZ, this.mScaleX, this.mScaleY, this.mRotationX, this.mRotationY, this.mRotationZ);
        }
    }

    private static final Property NON_TRANSLATIONS_PROPERTY = null;
    private static final String PROPNAME_INTERMEDIATE_MATRIX = "android:changeTransform:intermediateMatrix";
    private static final String PROPNAME_INTERMEDIATE_PARENT_MATRIX = "android:changeTransform:intermediateParentMatrix";
    private static final String PROPNAME_MATRIX = "android:changeTransform:matrix";
    private static final String PROPNAME_PARENT = "android:changeTransform:parent";
    private static final String PROPNAME_PARENT_MATRIX = "android:changeTransform:parentMatrix";
    private static final String PROPNAME_TRANSFORMS = "android:changeTransform:transforms";
    private static final boolean SUPPORTS_VIEW_REMOVAL_SUPPRESSION;
    private static final Property TRANSLATIONS_PROPERTY;
    private boolean mReparent;
    private Matrix mTempMatrix;
    boolean mUseOverlay;
    private static final String[] sTransitionProperties;

    static {
        ChangeTransform.sTransitionProperties = new String[]{"android:changeTransform:matrix", "android:changeTransform:transforms", "android:changeTransform:parentMatrix"};
        ChangeTransform.NON_TRANSLATIONS_PROPERTY = new androidx.transition.ChangeTransform$1(float[].class, "nonTranslations");
        ChangeTransform.TRANSLATIONS_PROPERTY = new androidx.transition.ChangeTransform$2(PointF.class, "translations");
        ChangeTransform.SUPPORTS_VIEW_REMOVAL_SUPPRESSION = true;
    }

    public ChangeTransform() {
        super();
        this.mUseOverlay = true;
        this.mReparent = true;
        this.mTempMatrix = new Matrix();
    }

    public ChangeTransform(Context arg4, AttributeSet arg5) {
        super(arg4, arg5);
        this.mUseOverlay = true;
        this.mReparent = true;
        this.mTempMatrix = new Matrix();
        TypedArray v4 = arg4.obtainStyledAttributes(arg5, Styleable.CHANGE_TRANSFORM);
        this.mUseOverlay = TypedArrayUtils.getNamedBoolean(v4, ((XmlPullParser)arg5), "reparentWithOverlay", 1, true);
        this.mReparent = TypedArrayUtils.getNamedBoolean(v4, ((XmlPullParser)arg5), "reparent", 0, true);
        v4.recycle();
    }

    public void captureEndValues(TransitionValues arg1) {
        this.captureValues(arg1);
    }

    public void captureStartValues(TransitionValues arg1) {
        this.captureValues(arg1);
        if(!ChangeTransform.SUPPORTS_VIEW_REMOVAL_SUPPRESSION) {
            arg1.view.getParent().startViewTransition(arg1.view);
        }
    }

    private void captureValues(TransitionValues arg5) {
        Matrix v2;
        View v0 = arg5.view;
        if(v0.getVisibility() == 8) {
        }
        else {
            arg5.values.put("android:changeTransform:parent", v0.getParent());
            arg5.values.put("android:changeTransform:transforms", new Transforms(v0));
            Matrix v1 = v0.getMatrix();
            if(v1 == null || (v1.isIdentity())) {
                Object v2_1 = null;
            }
            else {
                v2 = new Matrix(v1);
            }

            arg5.values.put("android:changeTransform:matrix", v2);
            if(!this.mReparent) {
                return;
            }

            Matrix v4 = new Matrix();
            ViewParent v1_1 = v0.getParent();
            ViewUtils.transformMatrixToGlobal(((View)v1_1), v4);
            v4.preTranslate(((float)(-((ViewGroup)v1_1).getScrollX())), ((float)(-((ViewGroup)v1_1).getScrollY())));
            arg5.values.put("android:changeTransform:parentMatrix", v4);
            arg5.values.put("android:changeTransform:intermediateMatrix", v0.getTag(id.transition_transform));
            arg5.values.put("android:changeTransform:intermediateParentMatrix", v0.getTag(id.parent_matrix));
        }
    }

    public Animator createAnimator(ViewGroup arg6, TransitionValues arg7, TransitionValues arg8) {
        if(arg7 != null && arg8 != null) {
            String v1 = "android:changeTransform:parent";
            if(arg7.values.containsKey(v1)) {
                if(!arg8.values.containsKey(v1)) {
                }
                else {
                    Object v0 = arg7.values.get(v1);
                    Object v1_1 = arg8.values.get(v1);
                    boolean v1_2 = !this.mReparent || (this.parentsMatch(((ViewGroup)v0), ((ViewGroup)v1_1))) ? false : true;
                    Object v2 = arg7.values.get("android:changeTransform:intermediateMatrix");
                    if(v2 != null) {
                        arg7.values.put("android:changeTransform:matrix", v2);
                    }

                    v2 = arg7.values.get("android:changeTransform:intermediateParentMatrix");
                    if(v2 != null) {
                        arg7.values.put("android:changeTransform:parentMatrix", v2);
                    }

                    if(v1_2) {
                        this.setMatricesForParent(arg7, arg8);
                    }

                    ObjectAnimator v2_1 = this.createTransformAnimator(arg7, arg8, v1_2);
                    if((v1_2) && v2_1 != null && (this.mUseOverlay)) {
                        this.createGhostView(arg6, arg7, arg8);
                        return ((Animator)v2_1);
                    }

                    if(!ChangeTransform.SUPPORTS_VIEW_REMOVAL_SUPPRESSION) {
                        ((ViewGroup)v0).endViewTransition(arg7.view);
                    }

                    return ((Animator)v2_1);
                }
            }
        }

        return null;
    }

    private void createGhostView(ViewGroup arg4, TransitionValues arg5, TransitionValues arg6) {
        TransitionSet v3;
        View v0 = arg6.view;
        Matrix v2 = new Matrix(arg6.values.get("android:changeTransform:parentMatrix"));
        ViewUtils.transformMatrixToLocal(((View)arg4), v2);
        GhostView v4 = GhostViewUtils.addGhost(v0, arg4, v2);
        if(v4 == null) {
        }
        else {
            v4.reserveEndViewTransition(arg5.values.get("android:changeTransform:parent"), arg5.view);
            while(((Transition)this).mParent != null) {
                v3 = ((Transition)v3).mParent;
            }

            ((Transition)v3).addListener(new GhostListener(v0, v4));
            if(ChangeTransform.SUPPORTS_VIEW_REMOVAL_SUPPRESSION) {
                if(arg5.view != arg6.view) {
                    ViewUtils.setTransitionAlpha(arg5.view, 0f);
                }

                ViewUtils.setTransitionAlpha(v0, 1f);
            }
        }
    }

    private ObjectAnimator createTransformAnimator(TransitionValues arg11, TransitionValues arg12, boolean arg13) {
        Matrix v0_1;
        Matrix v11_1;
        Object v11 = arg11.values.get("android:changeTransform:matrix");
        Object v0 = arg12.values.get("android:changeTransform:matrix");
        if(v11 == null) {
            v11_1 = MatrixUtils.IDENTITY_MATRIX;
        }

        if(v0 == null) {
            v0_1 = MatrixUtils.IDENTITY_MATRIX;
        }

        Object v5 = v0_1;
        if(v11_1.equals(v5)) {
            return null;
        }

        Object v3 = arg12.values.get("android:changeTransform:transforms");
        View v2 = arg12.view;
        ChangeTransform.setIdentityTransforms(v2);
        float[] v0_2 = new float[9];
        v11_1.getValues(v0_2);
        float[] v11_2 = new float[9];
        ((Matrix)v5).getValues(v11_2);
        PathAnimatorMatrix v4 = new PathAnimatorMatrix(v2, v0_2);
        ObjectAnimator v11_3 = ObjectAnimator.ofPropertyValuesHolder(v4, new PropertyValuesHolder[]{PropertyValuesHolder.ofObject(ChangeTransform.NON_TRANSLATIONS_PROPERTY, new FloatArrayEvaluator(new float[9]), new float[][]{v0_2, v11_2}), PropertyValuesHolderUtils.ofPointF(ChangeTransform.TRANSLATIONS_PROPERTY, this.getPathMotion().getPath(v0_2[2], v0_2[5], v11_2[2], v11_2[5]))});
        Listener v1 = new Listener(v2, ((Transforms)v3), v4, ((Matrix)v5), arg13, this.mUseOverlay);
        v11_3.addListener(((Animator$AnimatorListener)v1));
        v11_3.addPauseListener(((Animator$AnimatorPauseListener)v1));
        return v11_3;
    }

    public boolean getReparent() {
        return this.mReparent;
    }

    public boolean getReparentWithOverlay() {
        return this.mUseOverlay;
    }

    public String[] getTransitionProperties() {
        return ChangeTransform.sTransitionProperties;
    }

    private boolean parentsMatch(ViewGroup arg4, ViewGroup arg5) {
        if(this.isValidTarget(((View)arg4))) {
            if(!this.isValidTarget(((View)arg5))) {
            }
            else {
                TransitionValues v3 = this.getMatchedTransitionValues(((View)arg4), true);
                if(v3 != null && arg5 == v3.view) {
                    return 1;
                }

                return 0;
            }
        }

        if(arg4 == arg5) {
            return 1;
        }

        return 0;
    }

    static void setIdentityTransforms(View arg9) {
        ChangeTransform.setTransforms(arg9, 0f, 0f, 0f, 1f, 1f, 0f, 0f, 0f);
    }

    private void setMatricesForParent(TransitionValues arg4, TransitionValues arg5) {
        Matrix v5_1;
        String v1 = "android:changeTransform:parentMatrix";
        Object v0 = arg5.values.get(v1);
        arg5.view.setTag(id.parent_matrix, v0);
        Matrix v3 = this.mTempMatrix;
        v3.reset();
        ((Matrix)v0).invert(v3);
        String v0_1 = "android:changeTransform:matrix";
        Object v5 = arg4.values.get(v0_1);
        if(v5 == null) {
            v5_1 = new Matrix();
            arg4.values.put(v0_1, v5_1);
        }

        v5_1.postConcat(arg4.values.get(v1));
        v5_1.postConcat(v3);
    }

    public void setReparent(boolean arg1) {
        this.mReparent = arg1;
    }

    public void setReparentWithOverlay(boolean arg1) {
        this.mUseOverlay = arg1;
    }

    static void setTransforms(View arg0, float arg1, float arg2, float arg3, float arg4, float arg5, float arg6, float arg7, float arg8) {
        arg0.setTranslationX(arg1);
        arg0.setTranslationY(arg2);
        ViewCompat.setTranslationZ(arg0, arg3);
        arg0.setScaleX(arg4);
        arg0.setScaleY(arg5);
        arg0.setRotationX(arg6);
        arg0.setRotationY(arg7);
        arg0.setRotation(arg8);
    }
}

