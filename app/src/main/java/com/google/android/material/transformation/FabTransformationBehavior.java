package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator$AnimatorUpdateListener;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$id;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.ArgbEvaluatorCompat;
import com.google.android.material.animation.ChildrenAlphaProperty;
import com.google.android.material.animation.DrawableAlphaProperty;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.animation.MotionTiming;
import com.google.android.material.animation.Positioning;
import com.google.android.material.circularreveal.CircularRevealCompat;
import com.google.android.material.circularreveal.CircularRevealHelper;
import com.google.android.material.circularreveal.CircularRevealWidget$CircularRevealScrimColorProperty;
import com.google.android.material.circularreveal.CircularRevealWidget$RevealInfo;
import com.google.android.material.circularreveal.CircularRevealWidget;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.math.MathUtils;
import java.util.ArrayList;
import java.util.List;

@Deprecated public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {
    public class FabTransformationSpec {
        public Positioning positioning;
        public MotionSpec timings;

        protected FabTransformationSpec() {
            super();
        }
    }

    private float dependencyOriginalTranslationX;
    private float dependencyOriginalTranslationY;
    private final int[] tmpArray;
    private final Rect tmpRect;
    private final RectF tmpRectF1;
    private final RectF tmpRectF2;

    public FabTransformationBehavior() {
        super();
        this.tmpRect = new Rect();
        this.tmpRectF1 = new RectF();
        this.tmpRectF2 = new RectF();
        this.tmpArray = new int[2];
    }

    public FabTransformationBehavior(Context arg1, AttributeSet arg2) {
        super(arg1, arg2);
        this.tmpRect = new Rect();
        this.tmpRectF1 = new RectF();
        this.tmpRectF2 = new RectF();
        this.tmpArray = new int[2];
    }

    private ViewGroup calculateChildContentContainer(View arg2) {
        View v0 = arg2.findViewById(id.mtrl_child_content_container);
        if(v0 != null) {
            return this.toViewGroupOrNull(v0);
        }

        if(!(arg2 instanceof TransformationChildLayout)) {
            if((arg2 instanceof TransformationChildCard)) {
            }
            else {
                return this.toViewGroupOrNull(arg2);
            }
        }

        return this.toViewGroupOrNull(((ViewGroup)arg2).getChildAt(0));
    }

    private void calculateChildVisibleBoundsAtEndOfExpansion(View arg1, FabTransformationSpec arg2, MotionTiming arg3, MotionTiming arg4, float arg5, float arg6, float arg7, float arg8, RectF arg9) {
        float v3 = this.calculateValueOfAnimationAtEndOfExpansion(arg2, arg3, arg5, arg7);
        float v2 = this.calculateValueOfAnimationAtEndOfExpansion(arg2, arg4, arg6, arg8);
        Rect v4 = this.tmpRect;
        arg1.getWindowVisibleDisplayFrame(v4);
        RectF v5 = this.tmpRectF1;
        v5.set(v4);
        RectF v4_1 = this.tmpRectF2;
        this.calculateWindowBounds(arg1, v4_1);
        v4_1.offset(v3, v2);
        v4_1.intersect(v5);
        arg9.set(v4_1);
    }

    private void calculateDependencyWindowBounds(View arg1, RectF arg2) {
        this.calculateWindowBounds(arg1, arg2);
        arg2.offset(this.dependencyOriginalTranslationX, this.dependencyOriginalTranslationY);
    }

    private Pair calculateMotionTiming(float arg1, float arg2, boolean arg3, FabTransformationSpec arg4) {
        MotionTiming v1_1;
        MotionTiming v0;
        if(arg1 != 0f) {
            int v1 = Float.compare(arg2, 0f);
            if(v1 == 0) {
                goto label_23;
            }
            else {
                if((arg3) && arg2 < 0f || !arg3 && v1 > 0) {
                    v0 = arg4.timings.getTiming("translationXCurveUpwards");
                    v1_1 = arg4.timings.getTiming("translationYCurveUpwards");
                    goto label_29;
                }

                v0 = arg4.timings.getTiming("translationXCurveDownwards");
                v1_1 = arg4.timings.getTiming("translationYCurveDownwards");
            }
        }
        else {
        label_23:
            v0 = arg4.timings.getTiming("translationXLinear");
            v1_1 = arg4.timings.getTiming("translationYLinear");
        }

    label_29:
        return new Pair(v0, v1_1);
    }

    private float calculateRevealCenterX(View arg3, View arg4, Positioning arg5) {
        RectF v0 = this.tmpRectF1;
        RectF v1 = this.tmpRectF2;
        this.calculateDependencyWindowBounds(arg3, v0);
        this.calculateWindowBounds(arg4, v1);
        v1.offset(-this.calculateTranslationX(arg3, arg4, arg5), 0f);
        return v0.centerX() - v1.left;
    }

    private float calculateRevealCenterY(View arg3, View arg4, Positioning arg5) {
        RectF v0 = this.tmpRectF1;
        RectF v1 = this.tmpRectF2;
        this.calculateDependencyWindowBounds(arg3, v0);
        this.calculateWindowBounds(arg4, v1);
        v1.offset(0f, -this.calculateTranslationY(arg3, arg4, arg5));
        return v0.centerY() - v1.top;
    }

    private float calculateTranslationX(View arg3, View arg4, Positioning arg5) {
        float v3;
        float v2_1;
        RectF v0 = this.tmpRectF1;
        RectF v1 = this.tmpRectF2;
        this.calculateDependencyWindowBounds(arg3, v0);
        this.calculateWindowBounds(arg4, v1);
        int v2 = arg5.gravity & 7;
        if(v2 == 1) {
            v2_1 = v1.centerX();
            v3 = v0.centerX();
        label_22:
            v2_1 -= v3;
        }
        else if(v2 == 3) {
            v2_1 = v1.left;
            v3 = v0.left;
            goto label_22;
        }
        else if(v2 != 5) {
            v2_1 = 0f;
        }
        else {
            v2_1 = v1.right;
            v3 = v0.right;
            goto label_22;
        }

        return v2_1 + arg5.xAdjustment;
    }

    private float calculateTranslationY(View arg3, View arg4, Positioning arg5) {
        float v3;
        float v2_1;
        RectF v0 = this.tmpRectF1;
        RectF v1 = this.tmpRectF2;
        this.calculateDependencyWindowBounds(arg3, v0);
        this.calculateWindowBounds(arg4, v1);
        int v2 = arg5.gravity & 0x70;
        if(v2 == 16) {
            v2_1 = v1.centerY();
            v3 = v0.centerY();
        label_22:
            v2_1 -= v3;
        }
        else if(v2 == 0x30) {
            v2_1 = v1.top;
            v3 = v0.top;
            goto label_22;
        }
        else if(v2 != 80) {
            v2_1 = 0f;
        }
        else {
            v2_1 = v1.bottom;
            v3 = v0.bottom;
            goto label_22;
        }

        return v2_1 + arg5.yAdjustment;
    }

    private float calculateValueOfAnimationAtEndOfExpansion(FabTransformationSpec arg7, MotionTiming arg8, float arg9, float arg10) {
        long v0 = arg8.getDelay();
        long v2 = arg8.getDuration();
        MotionTiming v6 = arg7.timings.getTiming("expansion");
        return AnimationUtils.lerp(arg9, arg10, arg8.getInterpolator().getInterpolation((((float)(v6.getDelay() + v6.getDuration() + 17 - v0))) / (((float)v2))));
    }

    private void calculateWindowBounds(View arg4, RectF arg5) {
        arg5.set(0f, 0f, ((float)arg4.getWidth()), ((float)arg4.getHeight()));
        int[] v3 = this.tmpArray;
        arg4.getLocationInWindow(v3);
        arg5.offsetTo(((float)v3[0]), ((float)v3[1]));
        arg5.offset(((float)(((int)(-arg4.getTranslationX())))), ((float)(((int)(-arg4.getTranslationY())))));
    }

    private void createChildrenFadeAnimation(View arg1, View arg2, boolean arg3, boolean arg4, FabTransformationSpec arg5, List arg6, List arg7) {
        ObjectAnimator v0_1;
        ViewGroup v0;
        if(!(arg2 instanceof ViewGroup)) {
        }
        else {
            if(((arg2 instanceof CircularRevealWidget)) && CircularRevealHelper.STRATEGY == 0) {
                return;
            }

            v0 = this.calculateChildContentContainer(arg2);
            if(v0 != null) {
                goto label_11;
            }
        }

        return;
    label_11:
        if(arg3) {
            if(!arg4) {
                ChildrenAlphaProperty.CHILDREN_ALPHA.set(v0, Float.valueOf(0f));
            }

            v0_1 = ObjectAnimator.ofFloat(v0, ChildrenAlphaProperty.CHILDREN_ALPHA, new float[]{1f});
        }
        else {
            v0_1 = ObjectAnimator.ofFloat(v0, ChildrenAlphaProperty.CHILDREN_ALPHA, new float[]{0f});
        }

        arg5.timings.getTiming("contentFade").apply(((Animator)v0_1));
        arg6.add(v0_1);
    }

    private void createColorAnimation(View arg1, View arg2, boolean arg3, boolean arg4, FabTransformationSpec arg5, List arg6, List arg7) {
        ObjectAnimator v0_1;
        if(!(arg2 instanceof CircularRevealWidget)) {
            return;
        }

        int v0 = this.getBackgroundTint(arg1);
        int v1 = 0xFFFFFF & v0;
        if(arg3) {
            if(!arg4) {
                ((CircularRevealWidget)arg2).setCircularRevealScrimColor(v0);
            }

            v0_1 = ObjectAnimator.ofInt(arg2, CircularRevealScrimColorProperty.CIRCULAR_REVEAL_SCRIM_COLOR, new int[]{v1});
        }
        else {
            v0_1 = ObjectAnimator.ofInt(arg2, CircularRevealScrimColorProperty.CIRCULAR_REVEAL_SCRIM_COLOR, new int[]{v0});
        }

        v0_1.setEvaluator(ArgbEvaluatorCompat.getInstance());
        arg5.timings.getTiming("color").apply(((Animator)v0_1));
        arg6.add(v0_1);
    }

    private void createDependencyTranslationAnimation(View arg7, View arg8, boolean arg9, FabTransformationSpec arg10, List arg11) {
        float v0 = this.calculateTranslationX(arg7, arg8, arg10.positioning);
        float v8 = this.calculateTranslationY(arg7, arg8, arg10.positioning);
        Pair v10 = this.calculateMotionTiming(v0, v8, arg9, arg10);
        Object v1 = v10.first;
        Object v10_1 = v10.second;
        Property v2 = View.TRANSLATION_X;
        if(arg9) {
        }
        else {
            v0 = this.dependencyOriginalTranslationX;
        }

        ObjectAnimator v0_1 = ObjectAnimator.ofFloat(arg7, v2, new float[]{v0});
        v2 = View.TRANSLATION_Y;
        if(arg9) {
        }
        else {
            v8 = this.dependencyOriginalTranslationY;
        }

        ObjectAnimator v6 = ObjectAnimator.ofFloat(arg7, v2, new float[]{v8});
        ((MotionTiming)v1).apply(((Animator)v0_1));
        ((MotionTiming)v10_1).apply(((Animator)v6));
        arg11.add(v0_1);
        arg11.add(v6);
    }

    private void createElevationAnimation(View arg1, View arg2, boolean arg3, boolean arg4, FabTransformationSpec arg5, List arg6, List arg7) {
        ObjectAnimator v0_1;
        float v0 = ViewCompat.getElevation(arg2) - ViewCompat.getElevation(arg1);
        if(arg3) {
            if(!arg4) {
                arg2.setTranslationZ(-v0);
            }

            v0_1 = ObjectAnimator.ofFloat(arg2, View.TRANSLATION_Z, new float[]{0f});
        }
        else {
            v0_1 = ObjectAnimator.ofFloat(arg2, View.TRANSLATION_Z, new float[]{-v0});
        }

        arg5.timings.getTiming("elevation").apply(((Animator)v0_1));
        arg6.add(v0_1);
    }

    private void createExpansionAnimation(View arg16, View arg17, boolean arg18, boolean arg19, FabTransformationSpec arg20, float arg21, float arg22, List arg23, List arg24) {
        Animator v8_1;
        View v0 = arg16;
        View v1 = arg17;
        FabTransformationSpec v8 = arg20;
        if(!(v1 instanceof CircularRevealWidget)) {
            return;
        }

        View v12 = v1;
        float v3 = this.calculateRevealCenterX(v0, v1, v8.positioning);
        float v4 = this.calculateRevealCenterY(v0, v1, v8.positioning);
        ((FloatingActionButton)v0).getContentRect(this.tmpRect);
        float v10 = (((float)this.tmpRect.width())) / 2f;
        MotionTiming v13 = v8.timings.getTiming("expansion");
        if(arg18) {
            if(!arg19) {
                ((CircularRevealWidget)v12).setRevealInfo(new RevealInfo(v3, v4, v10));
            }

            if(arg19) {
                v10 = ((CircularRevealWidget)v12).getRevealInfo().radius;
            }

            v8_1 = CircularRevealCompat.createCircularReveal(((CircularRevealWidget)v12), v3, v4, MathUtils.distanceToFurthestCorner(v3, v4, 0f, 0f, arg21, arg22));
            v8_1.addListener(new AnimatorListenerAdapter(((CircularRevealWidget)v12)) {
                public void onAnimationEnd(Animator arg2) {
                    RevealInfo v2 = this.val$circularRevealChild.getRevealInfo();
                    v2.radius = 3.402823E+38f;
                    this.val$circularRevealChild.setRevealInfo(v2);
                }
            });
            this.createPreFillRadialExpansion(v1, v13.getDelay(), ((int)v3), ((int)v4), v10, arg23);
        }
        else {
            float v6 = ((CircularRevealWidget)v12).getRevealInfo().radius;
            Animator v14 = CircularRevealCompat.createCircularReveal(((CircularRevealWidget)v12), v3, v4, v10);
            int v9 = ((int)v4);
            int v4_1 = ((int)v3);
            this.createPreFillRadialExpansion(arg17, v13.getDelay(), v4_1, v9, v6, arg23);
            this.createPostFillRadialExpansion(arg17, v13.getDelay(), v13.getDuration(), v8.timings.getTotalDuration(), v4_1, v9, v10, arg23);
            v8_1 = v14;
        }

        v13.apply(v8_1);
        arg23.add(v8_1);
        arg24.add(CircularRevealCompat.createCircularRevealListener(((CircularRevealWidget)v12)));
    }

    private void createIconFadeAnimation(View arg3, View arg4, boolean arg5, boolean arg6, FabTransformationSpec arg7, List arg8, List arg9) {
        ObjectAnimator v5;
        if((arg4 instanceof CircularRevealWidget)) {
            if(!(arg3 instanceof ImageView)) {
            }
            else {
                View v0 = arg4;
                Drawable v3 = ((ImageView)arg3).getDrawable();
                if(v3 == null) {
                }
                else {
                    v3.mutate();
                    int v1 = 0xFF;
                    if(arg5) {
                        if(!arg6) {
                            v3.setAlpha(v1);
                        }

                        v5 = ObjectAnimator.ofInt(v3, DrawableAlphaProperty.DRAWABLE_ALPHA_COMPAT, new int[]{0});
                    }
                    else {
                        v5 = ObjectAnimator.ofInt(v3, DrawableAlphaProperty.DRAWABLE_ALPHA_COMPAT, new int[]{v1});
                    }

                    v5.addUpdateListener(new ValueAnimator$AnimatorUpdateListener(arg4) {
                        public void onAnimationUpdate(ValueAnimator arg1) {
                            this.val$child.invalidate();
                        }
                    });
                    arg7.timings.getTiming("iconFade").apply(((Animator)v5));
                    arg8.add(v5);
                    arg9.add(new AnimatorListenerAdapter(((CircularRevealWidget)v0), v3) {
                        public void onAnimationEnd(Animator arg1) {
                            this.val$circularRevealChild.setCircularRevealOverlayDrawable(null);
                        }

                        public void onAnimationStart(Animator arg1) {
                            this.val$circularRevealChild.setCircularRevealOverlayDrawable(this.val$icon);
                        }
                    });
                }
            }
        }
    }

    private void createPostFillRadialExpansion(View arg1, long arg2, long arg4, long arg6, int arg8, int arg9, float arg10, List arg11) {
        arg2 += arg4;
        if(arg2 < arg6) {
            Animator v0 = ViewAnimationUtils.createCircularReveal(arg1, arg8, arg9, arg10, arg10);
            v0.setStartDelay(arg2);
            v0.setDuration(arg6 - arg2);
            arg11.add(v0);
        }
    }

    private void createPreFillRadialExpansion(View arg3, long arg4, int arg6, int arg7, float arg8, List arg9) {
        long v0 = 0;
        if(arg4 > v0) {
            Animator v2 = ViewAnimationUtils.createCircularReveal(arg3, arg6, arg7, arg8, arg8);
            v2.setStartDelay(v0);
            v2.setDuration(arg4);
            arg9.add(v2);
        }
    }

    private void createTranslationAnimation(View arg14, View arg15, boolean arg16, boolean arg17, FabTransformationSpec arg18, List arg19, List arg20, RectF arg21) {
        ObjectAnimator v12;
        ObjectAnimator v11;
        FabTransformationSpec v2 = arg18;
        List v10 = arg19;
        float v1 = this.calculateTranslationX(arg14, arg15, v2.positioning);
        float v14 = this.calculateTranslationY(arg14, arg15, v2.positioning);
        Pair v3 = this.calculateMotionTiming(v1, v14, arg16, v2);
        Object v4 = v3.first;
        Object v3_1 = v3.second;
        if(arg16) {
            if(!arg17) {
                arg15.setTranslationX(-v1);
                arg15.setTranslationY(-v14);
            }

            v11 = ObjectAnimator.ofFloat(arg15, View.TRANSLATION_X, new float[]{0f});
            v12 = ObjectAnimator.ofFloat(arg15, View.TRANSLATION_Y, new float[]{0f});
            Object v0 = v4;
            v4 = v3_1;
            v3_1 = v0;
            this.calculateChildVisibleBoundsAtEndOfExpansion(arg15, v2, ((MotionTiming)v3_1), ((MotionTiming)v4), -v1, -v14, 0f, 0f, arg21);
        }
        else {
            Object v13 = v4;
            v4 = v3_1;
            v3_1 = v13;
            v11 = ObjectAnimator.ofFloat(arg15, View.TRANSLATION_X, new float[]{-v1});
            v12 = ObjectAnimator.ofFloat(arg15, View.TRANSLATION_Y, new float[]{-v14});
        }

        ((MotionTiming)v3_1).apply(((Animator)v11));
        ((MotionTiming)v4).apply(((Animator)v12));
        v10.add(v11);
        v10.add(v12);
    }

    private int getBackgroundTint(View arg2) {
        ColorStateList v1 = ViewCompat.getBackgroundTintList(arg2);
        if(v1 != null) {
            return v1.getColorForState(arg2.getDrawableState(), v1.getDefaultColor());
        }

        return 0;
    }

    public boolean layoutDependsOn(CoordinatorLayout arg1, View arg2, View arg3) {
        if(arg2.getVisibility() != 8) {
            if((arg3 instanceof FloatingActionButton)) {
                int v0 = ((FloatingActionButton)arg3).getExpandedComponentIdHint();
                if(v0 != 0) {
                    if(v0 == arg2.getId()) {
                    }
                    else {
                        return 0;
                    }
                }

                return 1;
            }

            return 0;
        }

        throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
    }

    public void onAttachedToLayoutParams(LayoutParams arg1) {
        if(arg1.dodgeInsetEdges == 0) {
            arg1.dodgeInsetEdges = 80;
        }
    }

    protected AnimatorSet onCreateExpandedStateChangeAnimation(View arg12, View arg13, boolean arg14, boolean arg15) {
        FabTransformationSpec v6 = this.onCreateMotionSpec(arg13.getContext(), arg14);
        if(arg14) {
            this.dependencyOriginalTranslationX = arg12.getTranslationX();
            this.dependencyOriginalTranslationY = arg12.getTranslationY();
        }

        ArrayList v7 = new ArrayList();
        ArrayList v8 = new ArrayList();
        FabTransformationBehavior v1 = this;
        View v2 = arg12;
        View v3 = arg13;
        v1.createElevationAnimation(v2, v3, arg14, arg15, v6, ((List)v7), ((List)v8));
        RectF v9 = v1.tmpRectF1;
        v1.createTranslationAnimation(v2, v3, arg14, arg15, v6, ((List)v7), ((List)v8), v9);
        float v12 = v9.width();
        float v13 = v9.height();
        v1.createDependencyTranslationAnimation(v2, v3, arg14, v6, v7);
        v1.createIconFadeAnimation(v2, v3, arg14, arg15, v6, ((List)v7), ((List)v8));
        v1.createExpansionAnimation(v2, v3, arg14, arg15, v6, v12, v13, v7, v8);
        v8 = v8;
        v1.createColorAnimation(v2, v3, arg14, arg15, v6, v7, ((List)v8));
        v1.createChildrenFadeAnimation(v2, v3, arg14, arg15, v6, v7, ((List)v8));
        AnimatorSet v11 = new AnimatorSet();
        AnimatorSetCompat.playTogether(v11, v7);
        v11.addListener(new AnimatorListenerAdapter(arg14, v3, v2) {
            public void onAnimationEnd(Animator arg2) {
                if(!this.val$expanded) {
                    this.val$child.setVisibility(4);
                    this.val$dependency.setAlpha(1f);
                    this.val$dependency.setVisibility(0);
                }
            }

            public void onAnimationStart(Animator arg2) {
                if(this.val$expanded) {
                    this.val$child.setVisibility(0);
                    this.val$dependency.setAlpha(0f);
                    this.val$dependency.setVisibility(4);
                }
            }
        });
        int v12_1 = ((List)v8).size();
        int v13_1;
        for(v13_1 = 0; v13_1 < v12_1; ++v13_1) {
            v11.addListener(((List)v8).get(v13_1));
        }

        return v11;
    }

    protected abstract FabTransformationSpec onCreateMotionSpec(Context arg1, boolean arg2);

    private ViewGroup toViewGroupOrNull(View arg1) {
        if((arg1 instanceof ViewGroup)) {
            return arg1;
        }

        return null;
    }
}

