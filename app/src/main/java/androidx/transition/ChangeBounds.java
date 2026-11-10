package androidx.transition;

import android.animation.Animator$AnimatorListener;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.content.res.TypedArrayUtils;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;

public class ChangeBounds extends Transition {
    class androidx.transition.ChangeBounds$1 extends Property {
        androidx.transition.ChangeBounds$1(Class arg1, String arg2) {
            super(arg1, arg2);
        }

        public PointF get(ViewBounds arg1) {
            return null;
        }

        public Object get(Object arg1) {
            return this.get(((ViewBounds)arg1));
        }

        public void set(ViewBounds arg1, PointF arg2) {
            arg1.setTopLeft(arg2);
        }

        public void set(Object arg1, Object arg2) {
            this.set(((ViewBounds)arg1), ((PointF)arg2));
        }
    }

    class androidx.transition.ChangeBounds$2 extends Property {
        androidx.transition.ChangeBounds$2(Class arg1, String arg2) {
            super(arg1, arg2);
        }

        public PointF get(ViewBounds arg1) {
            return null;
        }

        public Object get(Object arg1) {
            return this.get(((ViewBounds)arg1));
        }

        public void set(ViewBounds arg1, PointF arg2) {
            arg1.setBottomRight(arg2);
        }

        public void set(Object arg1, Object arg2) {
            this.set(((ViewBounds)arg1), ((PointF)arg2));
        }
    }

    class androidx.transition.ChangeBounds$3 extends Property {
        androidx.transition.ChangeBounds$3(Class arg1, String arg2) {
            super(arg1, arg2);
        }

        public PointF get(View arg1) {
            return null;
        }

        public Object get(Object arg1) {
            return this.get(((View)arg1));
        }

        public void set(View arg3, PointF arg4) {
            ViewUtils.setLeftTopRightBottom(arg3, arg3.getLeft(), arg3.getTop(), Math.round(arg4.x), Math.round(arg4.y));
        }

        public void set(Object arg1, Object arg2) {
            this.set(((View)arg1), ((PointF)arg2));
        }
    }

    class androidx.transition.ChangeBounds$4 extends Property {
        androidx.transition.ChangeBounds$4(Class arg1, String arg2) {
            super(arg1, arg2);
        }

        public PointF get(View arg1) {
            return null;
        }

        public Object get(Object arg1) {
            return this.get(((View)arg1));
        }

        public void set(View arg3, PointF arg4) {
            ViewUtils.setLeftTopRightBottom(arg3, Math.round(arg4.x), Math.round(arg4.y), arg3.getRight(), arg3.getBottom());
        }

        public void set(Object arg1, Object arg2) {
            this.set(((View)arg1), ((PointF)arg2));
        }
    }

    class androidx.transition.ChangeBounds$5 extends Property {
        androidx.transition.ChangeBounds$5(Class arg1, String arg2) {
            super(arg1, arg2);
        }

        public PointF get(View arg1) {
            return null;
        }

        public Object get(Object arg1) {
            return this.get(((View)arg1));
        }

        public void set(View arg3, PointF arg4) {
            int v2 = Math.round(arg4.x);
            int v4 = Math.round(arg4.y);
            ViewUtils.setLeftTopRightBottom(arg3, v2, v4, arg3.getWidth() + v2, arg3.getHeight() + v4);
        }

        public void set(Object arg1, Object arg2) {
            this.set(((View)arg1), ((PointF)arg2));
        }
    }

    class ClipListener extends AnimatorListenerAdapter implements TransitionListener {
        private final int mEndBottom;
        private final Rect mEndClip;
        private final boolean mEndClipIsNull;
        private final int mEndLeft;
        private final int mEndRight;
        private final int mEndTop;
        private boolean mIsCanceled;
        private final int mStartBottom;
        private final Rect mStartClip;
        private final boolean mStartClipIsNull;
        private final int mStartLeft;
        private final int mStartRight;
        private final int mStartTop;
        private final View mView;

        ClipListener(View arg1, Rect arg2, boolean arg3, Rect arg4, boolean arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11, int arg12, int arg13) {
            super();
            this.mView = arg1;
            this.mStartClip = arg2;
            this.mStartClipIsNull = arg3;
            this.mEndClip = arg4;
            this.mEndClipIsNull = arg5;
            this.mStartLeft = arg6;
            this.mStartTop = arg7;
            this.mStartRight = arg8;
            this.mStartBottom = arg9;
            this.mEndLeft = arg10;
            this.mEndTop = arg11;
            this.mEndRight = arg12;
            this.mEndBottom = arg13;
        }

        public void onAnimationEnd(Animator arg2) {
            this.onAnimationEnd(arg2, false);
        }

        public void onAnimationEnd(Animator arg3, boolean arg4) {
            if(this.mIsCanceled) {
                return;
            }

            Rect v3 = null;
            if(arg4) {
                if(this.mStartClipIsNull) {
                }
                else {
                    v3 = this.mStartClip;
                }
            }
            else if(this.mEndClipIsNull) {
            }
            else {
                v3 = this.mEndClip;
            }

            this.mView.setClipBounds(v3);
            View v3_1 = this.mView;
            if(arg4) {
                ViewUtils.setLeftTopRightBottom(v3_1, this.mStartLeft, this.mStartTop, this.mStartRight, this.mStartBottom);
                return;
            }

            ViewUtils.setLeftTopRightBottom(v3_1, this.mEndLeft, this.mEndTop, this.mEndRight, this.mEndBottom);
        }

        public void onAnimationStart(Animator arg2) {
            this.onAnimationStart(arg2, false);
        }

        public void onAnimationStart(Animator arg5, boolean arg6) {
            int v5 = Math.max(this.mStartRight - this.mStartLeft, this.mEndRight - this.mEndLeft);
            int v0 = Math.max(this.mStartBottom - this.mStartTop, this.mEndBottom - this.mEndTop);
            int v1 = arg6 ? this.mEndLeft : this.mStartLeft;
            int v2 = arg6 ? this.mEndTop : this.mStartTop;
            ViewUtils.setLeftTopRightBottom(this.mView, v1, v2, v5 + v1, v0 + v2);
            Rect v5_1 = arg6 ? this.mEndClip : this.mStartClip;
            this.mView.setClipBounds(v5_1);
        }

        public void onTransitionCancel(Transition arg1) {
            this.mIsCanceled = true;
        }

        public void onTransitionEnd(Transition arg1) {
        }

        public void onTransitionPause(Transition arg3) {
            this.mView.setTag(id.transition_clip, this.mView.getClipBounds());
            Rect v3 = this.mEndClipIsNull ? null : this.mEndClip;
            this.mView.setClipBounds(v3);
        }

        public void onTransitionResume(Transition arg4) {
            Object v4 = this.mView.getTag(id.transition_clip);
            this.mView.setTag(id.transition_clip, null);
            this.mView.setClipBounds(((Rect)v4));
        }

        public void onTransitionStart(Transition arg1) {
        }
    }

    class SuppressLayoutListener extends TransitionListenerAdapter {
        boolean mCanceled;
        final ViewGroup mParent;

        SuppressLayoutListener(ViewGroup arg2) {
            super();
            this.mCanceled = false;
            this.mParent = arg2;
        }

        public void onTransitionCancel(Transition arg2) {
            ViewGroupUtils.suppressLayout(this.mParent, false);
            this.mCanceled = true;
        }

        public void onTransitionEnd(Transition arg3) {
            if(!this.mCanceled) {
                ViewGroupUtils.suppressLayout(this.mParent, false);
            }

            arg3.removeListener(((TransitionListener)this));
        }

        public void onTransitionPause(Transition arg1) {
            ViewGroupUtils.suppressLayout(this.mParent, false);
        }

        public void onTransitionResume(Transition arg1) {
            ViewGroupUtils.suppressLayout(this.mParent, true);
        }
    }

    class ViewBounds {
        private int mBottom;
        private int mBottomRightCalls;
        private int mLeft;
        private int mRight;
        private int mTop;
        private int mTopLeftCalls;
        private final View mView;

        ViewBounds(View arg1) {
            super();
            this.mView = arg1;
        }

        void setBottomRight(PointF arg2) {
            this.mRight = Math.round(arg2.x);
            this.mBottom = Math.round(arg2.y);
            int v2 = this.mBottomRightCalls + 1;
            this.mBottomRightCalls = v2;
            if(this.mTopLeftCalls == v2) {
                this.setLeftTopRightBottom();
            }
        }

        private void setLeftTopRightBottom() {
            ViewUtils.setLeftTopRightBottom(this.mView, this.mLeft, this.mTop, this.mRight, this.mBottom);
            this.mTopLeftCalls = 0;
            this.mBottomRightCalls = 0;
        }

        void setTopLeft(PointF arg2) {
            this.mLeft = Math.round(arg2.x);
            this.mTop = Math.round(arg2.y);
            int v2 = this.mTopLeftCalls + 1;
            this.mTopLeftCalls = v2;
            if(v2 == this.mBottomRightCalls) {
                this.setLeftTopRightBottom();
            }
        }
    }

    private static final Property BOTTOM_RIGHT_ONLY_PROPERTY = null;
    private static final Property BOTTOM_RIGHT_PROPERTY = null;
    private static final Property POSITION_PROPERTY = null;
    private static final String PROPNAME_BOUNDS = "android:changeBounds:bounds";
    private static final String PROPNAME_CLIP = "android:changeBounds:clip";
    private static final String PROPNAME_PARENT = "android:changeBounds:parent";
    private static final String PROPNAME_WINDOW_X = "android:changeBounds:windowX";
    private static final String PROPNAME_WINDOW_Y = "android:changeBounds:windowY";
    private static final Property TOP_LEFT_ONLY_PROPERTY;
    private static final Property TOP_LEFT_PROPERTY;
    private boolean mResizeClip;
    private static final RectEvaluator sRectEvaluator;
    private static final String[] sTransitionProperties;

    static {
        ChangeBounds.sTransitionProperties = new String[]{"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
        Class v1 = PointF.class;
        ChangeBounds.TOP_LEFT_PROPERTY = new androidx.transition.ChangeBounds$1(v1, "topLeft");
        ChangeBounds.BOTTOM_RIGHT_PROPERTY = new androidx.transition.ChangeBounds$2(v1, "bottomRight");
        ChangeBounds.BOTTOM_RIGHT_ONLY_PROPERTY = new androidx.transition.ChangeBounds$3(v1, "bottomRight");
        ChangeBounds.TOP_LEFT_ONLY_PROPERTY = new androidx.transition.ChangeBounds$4(v1, "topLeft");
        ChangeBounds.POSITION_PROPERTY = new androidx.transition.ChangeBounds$5(v1, "position");
        ChangeBounds.sRectEvaluator = new RectEvaluator();
    }

    public ChangeBounds() {
        super();
        this.mResizeClip = false;
    }

    public ChangeBounds(Context arg3, AttributeSet arg4) {
        super(arg3, arg4);
        this.mResizeClip = false;
        TypedArray v3 = arg3.obtainStyledAttributes(arg4, Styleable.CHANGE_BOUNDS);
        boolean v4 = TypedArrayUtils.getNamedBoolean(v3, ((XmlPullParser)arg4), "resizeClip", 0, false);
        v3.recycle();
        this.setResizeClip(v4);
    }

    public void captureEndValues(TransitionValues arg1) {
        this.captureValues(arg1);
    }

    public void captureStartValues(TransitionValues arg2) {
        this.captureValues(arg2);
        if(this.mResizeClip) {
            Object v1 = arg2.view.getTag(id.transition_clip);
            if(v1 != null) {
                arg2.values.put("android:changeBounds:clip", v1);
            }
        }
    }

    private void captureValues(TransitionValues arg8) {
        View v0 = arg8.view;
        if((v0.isLaidOut()) || v0.getWidth() != 0 || v0.getHeight() != 0) {
            arg8.values.put("android:changeBounds:bounds", new Rect(v0.getLeft(), v0.getTop(), v0.getRight(), v0.getBottom()));
            arg8.values.put("android:changeBounds:parent", arg8.view.getParent());
            if(this.mResizeClip) {
                arg8.values.put("android:changeBounds:clip", v0.getClipBounds());
            }
        }
    }

    public Animator createAnimator(ViewGroup arg22, TransitionValues arg23, TransitionValues arg24) {
        Rect v10_1;
        boolean v5_4;
        int v20;
        int v19;
        Animator v1_6;
        ObjectAnimator v3_1;
        ObjectAnimator v1_3;
        int v17;
        ChangeBounds v0 = this;
        TransitionValues v1 = arg23;
        TransitionValues v2 = arg24;
        if(v1 != null) {
            if(v2 == null) {
            }
            else {
                Map v4 = v1.values;
                Map v5 = v2.values;
                Object v4_1 = v4.get("android:changeBounds:parent");
                Object v5_1 = v5.get("android:changeBounds:parent");
                if(v4_1 != null) {
                    if(v5_1 == null) {
                    }
                    else {
                        View v7 = v2.view;
                        v4_1 = v1.values.get("android:changeBounds:bounds");
                        v5_1 = v2.values.get("android:changeBounds:bounds");
                        int v12 = ((Rect)v4_1).left;
                        int v6 = ((Rect)v5_1).left;
                        int v13 = ((Rect)v4_1).top;
                        int v8 = ((Rect)v5_1).top;
                        int v14 = ((Rect)v4_1).right;
                        int v9 = ((Rect)v5_1).right;
                        int v15 = ((Rect)v4_1).bottom;
                        int v4_2 = ((Rect)v5_1).bottom;
                        int v5_2 = v14 - v12;
                        int v10 = v15 - v13;
                        int v11 = v9 - v6;
                        Animator v22 = null;
                        int v16 = v4_2 - v8;
                        Object v1_1 = v1.values.get("android:changeBounds:clip");
                        Object v2_1 = v2.values.get("android:changeBounds:clip");
                        if(v5_2 == 0 || v10 == 0) {
                            if(v11 != 0 && v16 != 0) {
                            label_44:
                                v17 = v12 != v6 || v13 != v8 ? 1 : 0;
                                if(v14 == v9 && v15 == v4_2) {
                                    goto label_55;
                                }

                                ++v17;
                                goto label_55;
                            }

                            v17 = 0;
                        }
                        else {
                            goto label_44;
                        }

                    label_55:
                        if(v1_1 != null && !((Rect)v1_1).equals(v2_1) || v1_1 == null && v2_1 != null) {
                            ++v17;
                        }

                        int v3 = v17;
                        if(v3 > 0) {
                            Object v17_1 = v1_1;
                            if(!v0.mResizeClip) {
                                ViewUtils.setLeftTopRightBottom(v7, v12, v13, v14, v15);
                                int v1_2 = 2;
                                if(v3 == v1_2) {
                                    if(v5_2 == v11 && v10 == v16) {
                                        v1_3 = ObjectAnimatorUtils.ofPointF(v7, ChangeBounds.POSITION_PROPERTY, v0.getPathMotion().getPath(((float)v12), ((float)v13), ((float)v6), ((float)v8)));
                                        goto label_198;
                                    }

                                    ViewBounds v2_2 = new ViewBounds(v7);
                                    v3_1 = ObjectAnimatorUtils.ofPointF(v2_2, ChangeBounds.TOP_LEFT_PROPERTY, v0.getPathMotion().getPath(((float)v12), ((float)v13), ((float)v6), ((float)v8)));
                                    ObjectAnimator v4_3 = ObjectAnimatorUtils.ofPointF(v2_2, ChangeBounds.BOTTOM_RIGHT_PROPERTY, v0.getPathMotion().getPath(((float)v14), ((float)v15), ((float)v9), ((float)v4_2)));
                                    AnimatorSet v5_3 = new AnimatorSet();
                                    Animator[] v1_4 = new Animator[v1_2];
                                    v1_4[0] = v3_1;
                                    v1_4[1] = v4_3;
                                    v5_3.playTogether(v1_4);
                                    v5_3.addListener(new AnimatorListenerAdapter(v2_2) {
                                        private final ViewBounds mViewBounds;

                                    });
                                    AnimatorSet v1_5 = v5_3;
                                }
                                else {
                                    if(v12 == v6) {
                                        if(v13 != v8) {
                                        }
                                        else {
                                            v1_3 = ObjectAnimatorUtils.ofPointF(v7, ChangeBounds.BOTTOM_RIGHT_ONLY_PROPERTY, v0.getPathMotion().getPath(((float)v14), ((float)v15), ((float)v9), ((float)v4_2)));
                                            goto label_198;
                                        }
                                    }

                                    v1_3 = ObjectAnimatorUtils.ofPointF(v7, ChangeBounds.TOP_LEFT_ONLY_PROPERTY, v0.getPathMotion().getPath(((float)v12), ((float)v13), ((float)v6), ((float)v8)));
                                }
                            }
                            else {
                                v3 = v16;
                                Object v18 = v2_1;
                                ViewUtils.setLeftTopRightBottom(v7, v12, v13, Math.max(v5_2, v11) + v12, v13 + Math.max(v10, v3));
                                if(v12 != v6 || v13 != v8) {
                                    v19 = v4_2;
                                    v16 = v9;
                                    v20 = v6;
                                    v1_3 = ObjectAnimatorUtils.ofPointF(v7, ChangeBounds.POSITION_PROPERTY, v0.getPathMotion().getPath(((float)v12), ((float)v13), ((float)v6), ((float)v8)));
                                }
                                else {
                                    v1_6 = v22;
                                    v19 = v4_2;
                                    v20 = v6;
                                    v16 = v9;
                                }

                                boolean v9_1 = v17_1 == null ? true : false;
                                if(v9_1) {
                                    v4_2 = 0;
                                    Rect v2_3 = new Rect(0, 0, v5_2, v10);
                                }
                                else {
                                    v4_2 = 0;
                                    v2_1 = v17_1;
                                }

                                if(v18 == null) {
                                    v5_4 = true;
                                }
                                else {
                                    v5_2 = v4_2;
                                }

                                if(v5_4) {
                                    v10_1 = new Rect(v4_2, v4_2, v11, v3);
                                }
                                else {
                                    Object v10_2 = v18;
                                }

                                if(!((Rect)v2_1).equals(v10_1)) {
                                    v7.setClipBounds(((Rect)v2_1));
                                    v3_1 = ObjectAnimator.ofObject(v7, "clipBounds", ChangeBounds.sRectEvaluator, new Object[]{v2_1, v10_1});
                                    ClipListener v6_1 = new ClipListener(v7, ((Rect)v2_1), v9_1, v10_1, v5_4, v12, v13, v14, v15, v20, v8, v16, v19);
                                    v3_1.addListener(((Animator$AnimatorListener)v6_1));
                                    v0.addListener(((TransitionListener)v6_1));
                                }
                                else {
                                    Animator v3_2 = v22;
                                }

                                v1_6 = TransitionUtils.mergeAnimators(v1_6, ((Animator)v3_1));
                            }

                        label_198:
                            if((v7.getParent() instanceof ViewGroup)) {
                                ViewParent v2_4 = v7.getParent();
                                ViewGroupUtils.suppressLayout(((ViewGroup)v2_4), true);
                                v0.getRootTransition().addListener(new SuppressLayoutListener(((ViewGroup)v2_4)));
                            }

                            return v1_6;
                        }

                        return v22;
                    }
                }

                return null;
            }
        }

        return null;
    }

    public boolean getResizeClip() {
        return this.mResizeClip;
    }

    public String[] getTransitionProperties() {
        return ChangeBounds.sTransitionProperties;
    }

    public boolean isSeekingSupported() {
        return 1;
    }

    public void setResizeClip(boolean arg1) {
        this.mResizeClip = arg1;
    }
}

