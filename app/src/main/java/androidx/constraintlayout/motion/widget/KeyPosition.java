package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.widget.R$styleable;
import java.util.HashMap;

public class KeyPosition extends KeyPositionBase {
    class Loader {
        private static final int CURVE_FIT = 4;
        private static final int DRAW_PATH = 5;
        private static final int FRAME_POSITION = 2;
        private static final int PATH_MOTION_ARC = 10;
        private static final int PERCENT_HEIGHT = 12;
        private static final int PERCENT_WIDTH = 11;
        private static final int PERCENT_X = 6;
        private static final int PERCENT_Y = 7;
        private static final int SIZE_PERCENT = 8;
        private static final int TARGET_ID = 1;
        private static final int TRANSITION_EASING = 3;
        private static final int TYPE = 9;
        private static SparseIntArray mAttrMap;

        static {
            SparseIntArray v0 = new SparseIntArray();
            Loader.mAttrMap = v0;
            v0.append(styleable.KeyPosition_motionTarget, 1);
            Loader.mAttrMap.append(styleable.KeyPosition_framePosition, 2);
            Loader.mAttrMap.append(styleable.KeyPosition_transitionEasing, 3);
            Loader.mAttrMap.append(styleable.KeyPosition_curveFit, 4);
            Loader.mAttrMap.append(styleable.KeyPosition_drawPath, 5);
            Loader.mAttrMap.append(styleable.KeyPosition_percentX, 6);
            Loader.mAttrMap.append(styleable.KeyPosition_percentY, 7);
            Loader.mAttrMap.append(styleable.KeyPosition_keyPositionType, 9);
            Loader.mAttrMap.append(styleable.KeyPosition_sizePercent, 8);
            Loader.mAttrMap.append(styleable.KeyPosition_percentWidth, 11);
            Loader.mAttrMap.append(styleable.KeyPosition_percentHeight, 12);
            Loader.mAttrMap.append(styleable.KeyPosition_pathMotionArc, 10);
        }

        private Loader() {
            super();
        }

        static void access$000(KeyPosition arg0, TypedArray arg1) {
            Loader.read(arg0, arg1);
        }

        private static void read(KeyPosition arg8, TypedArray arg9) {
            String v3;
            int v0 = arg9.getIndexCount();
            int v2;
            for(v2 = 0; true; ++v2) {
                v3 = "KeyPosition";
                int v4 = -1;
                if(v2 >= v0) {
                    break;
                }

                int v5 = arg9.getIndex(v2);
                int v7 = 3;
                switch(Loader.mAttrMap.get(v5)) {
                    case 1: {
                        if(MotionLayout.IS_IN_EDIT_MODE) {
                            arg8.mTargetId = arg9.getResourceId(v5, arg8.mTargetId);
                            if(arg8.mTargetId != v4) {
                                goto label_95;
                            }

                            arg8.mTargetString = arg9.getString(v5);
                            goto label_95;
                        }

                        if(arg9.peekValue(v5).type == v7) {
                            arg8.mTargetString = arg9.getString(v5);
                            goto label_95;
                        }

                        arg8.mTargetId = arg9.getResourceId(v5, arg8.mTargetId);
                        break;
                    }
                    case 2: {
                        arg8.mFramePosition = arg9.getInt(v5, arg8.mFramePosition);
                        break;
                    }
                    case 3: {
                        if(arg9.peekValue(v5).type == v7) {
                            arg8.mTransitionEasing = arg9.getString(v5);
                            goto label_95;
                        }

                        arg8.mTransitionEasing = Easing.NAMED_EASING[arg9.getInteger(v5, 0)];
                        break;
                    }
                    case 4: {
                        arg8.mCurveFit = arg9.getInteger(v5, arg8.mCurveFit);
                        break;
                    }
                    case 5: {
                        arg8.mDrawPath = arg9.getInt(v5, arg8.mDrawPath);
                        break;
                    }
                    case 6: {
                        arg8.mPercentX = arg9.getFloat(v5, arg8.mPercentX);
                        break;
                    }
                    case 7: {
                        arg8.mPercentY = arg9.getFloat(v5, arg8.mPercentY);
                        break;
                    }
                    case 8: {
                        float v3_1 = arg9.getFloat(v5, arg8.mPercentHeight);
                        arg8.mPercentWidth = v3_1;
                        arg8.mPercentHeight = v3_1;
                        break;
                    }
                    case 9: {
                        arg8.mPositionType = arg9.getInt(v5, arg8.mPositionType);
                        break;
                    }
                    case 10: {
                        arg8.mPathMotionArc = arg9.getInt(v5, arg8.mPathMotionArc);
                        break;
                    }
                    case 11: {
                        arg8.mPercentWidth = arg9.getFloat(v5, arg8.mPercentWidth);
                        break;
                    }
                    case 12: {
                        arg8.mPercentHeight = arg9.getFloat(v5, arg8.mPercentHeight);
                        break;
                    }
                    default: {
                        Log.e(v3, "unused attribute 0x" + Integer.toHexString(v5) + "   " + Loader.mAttrMap.get(v5));
                        break;
                    }
                }

            label_95:
            }

            if(arg8.mFramePosition == v4) {
                Log.e(v3, "no frame position");
            }
        }
    }

    static final int KEY_TYPE = 2;
    static final String NAME = "KeyPosition";
    private static final String PERCENT_X = "percentX";
    private static final String PERCENT_Y = "percentY";
    private static final String TAG = "KeyPosition";
    public static final int TYPE_CARTESIAN = 0;
    public static final int TYPE_PATH = 1;
    public static final int TYPE_SCREEN = 2;
    float mAltPercentX;
    float mAltPercentY;
    private float mCalculatedPositionX;
    private float mCalculatedPositionY;
    int mDrawPath;
    int mPathMotionArc;
    float mPercentHeight;
    float mPercentWidth;
    float mPercentX;
    float mPercentY;
    int mPositionType;
    String mTransitionEasing;

    public KeyPosition() {
        super();
        this.mTransitionEasing = null;
        this.mPathMotionArc = KeyPosition.UNSET;
        this.mDrawPath = 0;
        this.mPercentWidth = NaNf;
        this.mPercentHeight = NaNf;
        this.mPercentX = NaNf;
        this.mPercentY = NaNf;
        this.mAltPercentX = NaNf;
        this.mAltPercentY = NaNf;
        this.mPositionType = 0;
        this.mCalculatedPositionX = NaNf;
        this.mCalculatedPositionY = NaNf;
        this.mType = 2;
    }

    public void addValues(HashMap arg1) {
    }

    private void calcCartesianPosition(float arg6, float arg7, float arg8, float arg9) {
        arg8 -= arg6;
        arg9 -= arg7;
        float v1 = 0f;
        float v0 = Float.isNaN(this.mPercentX) ? 0f : this.mPercentX;
        float v2 = Float.isNaN(this.mAltPercentY) ? 0f : this.mAltPercentY;
        float v3 = Float.isNaN(this.mPercentY) ? 0f : this.mPercentY;
        if(Float.isNaN(this.mAltPercentX)) {
        }
        else {
            v1 = this.mAltPercentX;
        }

        this.mCalculatedPositionX = ((float)(((int)(arg6 + v0 * arg8 + v1 * arg9))));
        this.mCalculatedPositionY = ((float)(((int)(arg7 + arg8 * v2 + arg9 * v3))));
    }

    private void calcPathPosition(float arg4, float arg5, float arg6, float arg7) {
        arg6 -= arg4;
        arg7 -= arg5;
        float v1 = this.mPercentX;
        float v2 = this.mPercentY;
        this.mCalculatedPositionX = arg4 + arg6 * v1 + -arg7 * v2;
        this.mCalculatedPositionY = arg5 + arg7 * v1 + arg6 * v2;
    }

    void calcPosition(int arg3, int arg4, float arg5, float arg6, float arg7, float arg8) {
        int v0 = this.mPositionType;
        if(v0 != 1) {
            if(v0 != 2) {
                this.calcCartesianPosition(arg5, arg6, arg7, arg8);
                return;
            }

            this.calcScreenPosition(arg3, arg4);
            return;
        }

        this.calcPathPosition(arg5, arg6, arg7, arg8);
    }

    private void calcScreenPosition(int arg3, int arg4) {
        float v0 = this.mPercentX;
        this.mCalculatedPositionX = (((float)arg3)) * v0 + 0f;
        this.mCalculatedPositionY = (((float)arg4)) * v0 + 0f;
    }

    float getPositionX() {
        return this.mCalculatedPositionX;
    }

    float getPositionY() {
        return this.mCalculatedPositionY;
    }

    public boolean intersects(int arg8, int arg9, RectF arg10, RectF arg11, float arg12, float arg13) {
        KeyPosition v0 = this;
        v0.calcPosition(arg8, arg9, arg10.centerX(), arg10.centerY(), arg11.centerX(), arg11.centerY());
        float v8 = 20f;
        if(Math.abs(arg12 - v0.mCalculatedPositionX) < v8 && Math.abs(arg13 - v0.mCalculatedPositionY) < v8) {
            return 1;
        }

        return 0;
    }

    public void load(Context arg2, AttributeSet arg3) {
        Loader.access$000(this, arg2.obtainStyledAttributes(arg3, styleable.KeyPosition));
    }

    public void positionAttributes(View arg8, RectF arg9, RectF arg10, float arg11, float arg12, String[] arg13, float[] arg14) {
        int v1 = this.mPositionType;
        if(v1 != 1) {
            if(v1 != 2) {
                this.positionCartAttributes(arg9, arg10, arg11, arg12, arg13, arg14);
                return;
            }

            this.positionScreenAttributes(arg8, arg9, arg10, arg11, arg12, arg13, arg14);
            return;
        }

        this.positionPathAttributes(arg9, arg10, arg11, arg12, arg13, arg14);
    }

    void positionCartAttributes(RectF arg6, RectF arg7, float arg8, float arg9, String[] arg10, float[] arg11) {
        float v5 = arg6.centerX();
        float v6 = arg6.centerY();
        float v0 = arg7.centerX() - v5;
        float v7 = arg7.centerY() - v6;
        String v2 = arg10[0];
        String v3 = "percentX";
        if(v2 != null) {
            if(v3.equals(v2)) {
                arg11[0] = (arg8 - v5) / v0;
                arg11[1] = (arg9 - v6) / v7;
                return;
            }

            arg11[1] = (arg8 - v5) / v0;
            arg11[0] = (arg9 - v6) / v7;
            return;
        }

        arg10[0] = v3;
        arg11[0] = (arg8 - v5) / v0;
        arg10[1] = "percentY";
        arg11[1] = (arg9 - v6) / v7;
    }

    void positionPathAttributes(RectF arg7, RectF arg8, float arg9, float arg10, String[] arg11, float[] arg12) {
        float v6 = arg7.centerX();
        float v7 = arg7.centerY();
        float v0 = arg8.centerX() - v6;
        float v8 = arg8.centerY() - v7;
        float v1 = ((float)Math.hypot(((double)v0), ((double)v8)));
        if(Double.compare(((double)v1), 0.0001) < 0) {
            System.out.println("distance ~ 0");
            arg12[0] = 0f;
            arg12[1] = 0f;
            return;
        }

        v0 /= v1;
        v8 /= v1;
        arg10 -= v7;
        arg9 -= v6;
        v7 = (v0 * arg10 - arg9 * v8) / v1;
        v0 = (v0 * arg9 + v8 * arg10) / v1;
        String v6_1 = arg11[0];
        String v8_1 = "percentX";
        if(v6_1 != null) {
            if(v8_1.equals(v6_1)) {
                arg12[0] = v0;
                arg12[1] = v7;
            }

            return;
        }

        arg11[0] = v8_1;
        arg11[1] = "percentY";
        arg12[0] = v0;
        arg12[1] = v7;
    }

    void positionScreenAttributes(View arg3, RectF arg4, RectF arg5, float arg6, float arg7, String[] arg8, float[] arg9) {
        arg4.centerX();
        arg4.centerY();
        arg5.centerX();
        arg5.centerY();
        ViewParent v2 = arg3.getParent();
        int v3 = ((ViewGroup)v2).getWidth();
        int v2_1 = ((ViewGroup)v2).getHeight();
        String v5 = arg8[0];
        String v0 = "percentX";
        if(v5 != null) {
            if(v0.equals(v5)) {
                arg9[0] = arg6 / (((float)v3));
                arg9[1] = arg7 / (((float)v2_1));
                return;
            }

            arg9[1] = arg6 / (((float)v3));
            arg9[0] = arg7 / (((float)v2_1));
            return;
        }

        arg8[0] = v0;
        arg9[0] = arg6 / (((float)v3));
        arg8[1] = "percentY";
        arg9[1] = arg7 / (((float)v2_1));
    }

    public void setValue(String arg3, Object arg4) {
        arg3.hashCode();
        int v1 = -1;
        switch(arg3.hashCode()) {
            case -1812823328: {
                if(!arg3.equals("transitionEasing")) {
                    goto label_46;
                }

                v1 = 0;
                break;
            }
            case -1127236479: {
                if(!arg3.equals("percentWidth")) {
                    goto label_46;
                }

                v1 = 1;
                break;
            }
            case -1017587252: {
                if(!arg3.equals("percentHeight")) {
                    goto label_46;
                }

                v1 = 2;
                break;
            }
            case -827014263: {
                if(!arg3.equals("drawPath")) {
                    goto label_46;
                }

                v1 = 3;
                break;
            }
            case -200259324: {
                if(!arg3.equals("sizePercent")) {
                    goto label_46;
                }

                v1 = 4;
                break;
            }
            case 428090547: {
                if(!arg3.equals("percentX")) {
                    goto label_46;
                }

                v1 = 5;
                break;
            }
            case 428090548: {
                if(!arg3.equals("percentY")) {
                    goto label_46;
                }

                v1 = 6;
                break;
            }
            default: {
                break;
            }
        }

    label_46:
        switch(v1) {
            case 0: {
                goto label_67;
            }
            case 1: {
                goto label_64;
            }
            case 2: {
                goto label_61;
            }
            case 3: {
                goto label_58;
            }
            case 4: {
                goto label_54;
            }
            case 5: {
                goto label_51;
            }
            case 6: {
                goto label_48;
            }
        }

        return;
    label_67:
        this.mTransitionEasing = arg4.toString();
        return;
    label_51:
        this.mPercentX = this.toFloat(arg4);
        return;
    label_54:
        float v3 = this.toFloat(arg4);
        this.mPercentWidth = v3;
        this.mPercentHeight = v3;
        return;
    label_58:
        this.mDrawPath = this.toInt(arg4);
        return;
    label_61:
        this.mPercentHeight = this.toFloat(arg4);
        return;
    label_64:
        this.mPercentWidth = this.toFloat(arg4);
        return;
    label_48:
        this.mPercentY = this.toFloat(arg4);
    }
}

