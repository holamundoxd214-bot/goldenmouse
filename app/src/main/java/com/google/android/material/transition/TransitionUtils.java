package com.google.android.material.transition;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader$TileMode;
import android.graphics.Shader;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewParent;
import androidx.core.graphics.PathParser;
import androidx.transition.PathMotion;
import androidx.transition.PatternPathMotion;
import androidx.transition.Transition;
import androidx.transition.TransitionSet;
import com.google.android.material.canvas.CanvasCompat$CanvasOperation;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.shape.AbsoluteCornerSize;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.RelativeCornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;

class TransitionUtils {
    interface CornerSizeBinaryOperator {
        CornerSize apply(CornerSize arg1, CornerSize arg2);
    }

    static final int NO_ATTR_RES_ID = 0;
    static final int NO_DURATION = -1;
    private static final int PATH_TYPE_ARC = 1;
    private static final int PATH_TYPE_LINEAR;
    private static final RectF transformAlphaRectF;

    static {
        TransitionUtils.transformAlphaRectF = new RectF();
    }

    private TransitionUtils() {
        super();
    }

    static float calculateArea(RectF arg1) {
        return arg1.width() * arg1.height();
    }

    static ShapeAppearanceModel convertToRelativeCornerSizes(ShapeAppearanceModel arg1, RectF arg2) {
        return arg1.withTransformedCornerSizes(new TransitionUtils$$ExternalSyntheticLambda0(arg2));
    }

    static Shader createColorShader(int arg8) {
        return new LinearGradient(0f, 0f, 0f, 0f, arg8, arg8, Shader$TileMode.CLAMP);
    }

    static Object defaultIfNull(Object arg0, Object arg1) {
        if(arg0 != null) {
            return arg0;
        }

        return arg1;
    }

    static View findAncestorById(View arg2, int arg3) {
        String v0 = arg2.getResources().getResourceName(arg3);
        while(arg2 != null) {
            if(arg2.getId() == arg3) {
                return arg2;
            }
            else {
                ViewParent v2 = ((View)v2).getParent();
                if((v2 instanceof View)) {
                    continue;
                }
            }

            break;
        }

        throw new IllegalArgumentException(v0 + " is not a valid ancestor");
    }

    static View findDescendantOrAncestorById(View arg1, int arg2) {
        View v0 = arg1.findViewById(arg2);
        if(v0 != null) {
            return v0;
        }

        return TransitionUtils.findAncestorById(arg1, arg2);
    }

    static RectF getLocationOnScreen(View arg4) {
        int[] v0 = new int[2];
        arg4.getLocationOnScreen(v0);
        return new RectF(((float)v0[0]), ((float)v0[1]), ((float)(arg4.getWidth() + v0[0])), ((float)(arg4.getHeight() + v0[1])));
    }

    static RectF getRelativeBounds(View arg4) {
        return new RectF(((float)arg4.getLeft()), ((float)arg4.getTop()), ((float)arg4.getRight()), ((float)arg4.getBottom()));
    }

    static Rect getRelativeBoundsRect(View arg4) {
        return new Rect(arg4.getLeft(), arg4.getTop(), arg4.getRight(), arg4.getBottom());
    }

    private static boolean isShapeAppearanceSignificant(ShapeAppearanceModel arg2, RectF arg3) {
        if(arg2.getTopLeftCornerSize().getCornerSize(arg3) == 0f && arg2.getTopRightCornerSize().getCornerSize(arg3) == 0f && arg2.getBottomRightCornerSize().getCornerSize(arg3) == 0f) {
            if(arg2.getBottomLeftCornerSize().getCornerSize(arg3) != 0f) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    static CornerSize lambda$convertToRelativeCornerSizes$0(RectF arg0, CornerSize arg1) {
        return RelativeCornerSize.createFromCornerSize(arg0, arg1);
    }

    static int lerp(int arg1, int arg2, float arg3, float arg4, float arg5) {
        if(arg5 < arg3) {
            return arg1;
        }

        if(arg5 > arg4) {
            return arg2;
        }

        return ((int)TransitionUtils.lerp(((float)arg1), ((float)arg2), (arg5 - arg3) / (arg4 - arg3)));
    }

    static float lerp(float arg6, float arg7, float arg8, float arg9, float arg10) {
        return TransitionUtils.lerp(arg6, arg7, arg8, arg9, arg10, false);
    }

    static float lerp(float arg0, float arg1, float arg2, float arg3, float arg4, boolean arg5) {
        if((arg5) && (arg4 < 0f || arg4 > 1f)) {
            return TransitionUtils.lerp(arg0, arg1, arg4);
        }

        if(arg4 < arg2) {
            return arg0;
        }

        if(arg4 > arg3) {
            return arg1;
        }

        return TransitionUtils.lerp(arg0, arg1, (arg4 - arg2) / (arg3 - arg2));
    }

    static ShapeAppearanceModel lerp(ShapeAppearanceModel arg7, ShapeAppearanceModel arg8, RectF arg9, RectF arg10, float arg11, float arg12, float arg13) {
        if(arg13 < arg11) {
            return arg7;
        }

        if(arg13 > arg12) {
            return arg8;
        }

        return TransitionUtils.transformCornerSizes(arg7, arg8, arg9, new CornerSizeBinaryOperator(arg9, arg10, arg11, arg12, arg13) {
            public CornerSize apply(CornerSize arg3, CornerSize arg4) {
                return new AbsoluteCornerSize(TransitionUtils.lerp(arg3.getCornerSize(this.val$startBounds), arg4.getCornerSize(this.val$endBounds), this.val$startFraction, this.val$endFraction, this.val$fraction));
            }
        });
    }

    static float lerp(float arg0, float arg1, float arg2) {
        return arg0 + arg2 * (arg1 - arg0);
    }

    static void maybeAddTransition(TransitionSet arg0, Transition arg1) {
        if(arg1 != null) {
            arg0.addTransition(arg1);
        }
    }

    static boolean maybeApplyThemeDuration(Transition arg4, Context arg5, int arg6) {
        if(arg6 != 0 && arg4.getDuration() == -1) {
            int v5 = MotionUtils.resolveThemeDuration(arg5, arg6, -1);
            if(v5 != -1) {
                arg4.setDuration(((long)v5));
                return 1;
            }
        }

        return 0;
    }

    static boolean maybeApplyThemeInterpolator(Transition arg1, Context arg2, int arg3, TimeInterpolator arg4) {
        if(arg3 != 0 && arg1.getInterpolator() == null) {
            arg1.setInterpolator(MotionUtils.resolveThemeInterpolator(arg2, arg3, arg4));
            return 1;
        }

        return 0;
    }

    static boolean maybeApplyThemePath(Transition arg0, Context arg1, int arg2) {
        if(arg2 != 0) {
            PathMotion v1 = TransitionUtils.resolveThemePath(arg1, arg2);
            if(v1 != null) {
                arg0.setPathMotion(v1);
                return 1;
            }
        }

        return 0;
    }

    static void maybeRemoveTransition(TransitionSet arg0, Transition arg1) {
        if(arg1 != null) {
            arg0.removeTransition(arg1);
        }
    }

    static PathMotion resolveThemePath(Context arg3, int arg4) {
        TypedValue v0 = new TypedValue();
        boolean v3 = arg3.getTheme().resolveAttribute(arg4, v0, true);
        PathMotion v4 = null;
        if(v3) {
            if(v0.type == 16) {
                int v3_1 = v0.data;
                if(v3_1 == 0) {
                    return v4;
                }

                if(v3_1 == 1) {
                    return new MaterialArcMotion();
                }

                throw new IllegalArgumentException("Invalid motion path type: " + v3_1);
            }

            if(v0.type == 3) {
                return new PatternPathMotion(PathParser.createPathFromPathData(String.valueOf(v0.string)));
            }

            throw new IllegalArgumentException("Motion path theme attribute must either be an enum value or path data string");
        }

        return v4;
    }

    private static int saveLayerAlphaCompat(Canvas arg1, Rect arg2, int arg3) {
        RectF v0 = TransitionUtils.transformAlphaRectF;
        v0.set(arg2);
        return arg1.saveLayerAlpha(v0, arg3);
    }

    static void transform(Canvas arg1, Rect arg2, float arg3, float arg4, float arg5, int arg6, CanvasOperation arg7) {
        if(arg6 <= 0) {
            return;
        }

        int v0 = arg1.save();
        arg1.translate(arg3, arg4);
        arg1.scale(arg5, arg5);
        if(arg6 < 0xFF) {
            TransitionUtils.saveLayerAlphaCompat(arg1, arg2, arg6);
        }

        arg7.run(arg1);
        arg1.restoreToCount(v0);
    }

    static ShapeAppearanceModel transformCornerSizes(ShapeAppearanceModel arg2, ShapeAppearanceModel arg3, RectF arg4, CornerSizeBinaryOperator arg5) {
        ShapeAppearanceModel v4 = TransitionUtils.isShapeAppearanceSignificant(arg2, arg4) ? arg2 : arg3;
        return v4.toBuilder().setTopLeftCornerSize(arg5.apply(arg2.getTopLeftCornerSize(), arg3.getTopLeftCornerSize())).setTopRightCornerSize(arg5.apply(arg2.getTopRightCornerSize(), arg3.getTopRightCornerSize())).setBottomLeftCornerSize(arg5.apply(arg2.getBottomLeftCornerSize(), arg3.getBottomLeftCornerSize())).setBottomRightCornerSize(arg5.apply(arg2.getBottomRightCornerSize(), arg3.getBottomRightCornerSize())).build();
    }
}

