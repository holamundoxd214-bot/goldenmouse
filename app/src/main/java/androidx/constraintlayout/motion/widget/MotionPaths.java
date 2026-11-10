package androidx.constraintlayout.motion.widget;

import android.view.View$MeasureSpec;
import android.view.View;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.widget.ConstraintAttribute$AttributeType;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintSet$Constraint;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;

class MotionPaths implements Comparable {
    static final int CARTESIAN = 2;
    public static final boolean DEBUG = false;
    static final int OFF_HEIGHT = 4;
    static final int OFF_PATH_ROTATE = 5;
    static final int OFF_POSITION = 0;
    static final int OFF_WIDTH = 3;
    static final int OFF_X = 1;
    static final int OFF_Y = 2;
    public static final boolean OLD_WAY = false;
    static final int PERPENDICULAR = 1;
    static final int SCREEN = 3;
    public static final String TAG = "MotionPaths";
    LinkedHashMap attributes;
    float height;
    int mDrawPath;
    Easing mKeyFrameEasing;
    int mMode;
    int mPathMotionArc;
    float mPathRotate;
    float mProgress;
    double[] mTempDelta;
    double[] mTempValue;
    static String[] names;
    float position;
    float time;
    float width;
    float x;
    float y;

    static {
        MotionPaths.names = new String[]{"position", "x", "y", "width", "height", "pathRotate"};
    }

    public MotionPaths() {
        super();
        this.mDrawPath = 0;
        this.mPathRotate = NaNf;
        this.mProgress = NaNf;
        this.mPathMotionArc = Key.UNSET;
        this.attributes = new LinkedHashMap();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
    }

    public MotionPaths(int arg3, int arg4, KeyPosition arg5, MotionPaths arg6, MotionPaths arg7) {
        super();
        this.mDrawPath = 0;
        this.mPathRotate = NaNf;
        this.mProgress = NaNf;
        this.mPathMotionArc = Key.UNSET;
        this.attributes = new LinkedHashMap();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
        int v0 = arg5.mPositionType;
        if(v0 != 1) {
            if(v0 != 2) {
                this.initCartesian(arg5, arg6, arg7);
                return;
            }

            this.initScreen(arg3, arg4, arg5, arg6, arg7);
            return;
        }

        this.initPath(arg5, arg6, arg7);
    }

    public void applyParameters(Constraint arg6) {
        this.mKeyFrameEasing = Easing.getInterpolator(arg6.motion.mTransitionEasing);
        this.mPathMotionArc = arg6.motion.mPathMotionArc;
        this.mPathRotate = arg6.motion.mPathRotate;
        this.mDrawPath = arg6.motion.mDrawPath;
        this.mProgress = arg6.propertySet.mProgress;
        Iterator v0 = arg6.mCustomConstraints.keySet().iterator();
        while(v0.hasNext()) {
            Object v1 = v0.next();
            Object v2 = arg6.mCustomConstraints.get(v1);
            if(((ConstraintAttribute)v2).getType() == AttributeType.STRING_TYPE) {
                continue;
            }

            this.attributes.put(v1, v2);
        }
    }

    public int compareTo(MotionPaths arg1) {
        return Float.compare(this.position, arg1.position);
    }

    public int compareTo(Object arg1) {
        return this.compareTo(((MotionPaths)arg1));
    }

    private boolean diff(float arg3, float arg4) {
        if(!Float.isNaN(arg3)) {
            if(Float.isNaN(arg4)) {
            }
            else if(Math.abs(arg3 - arg4) > 0.000001f) {
                return 1;
            }
            else {
                return 0;
            }
        }

        if(Float.isNaN(arg3) != Float.isNaN(arg4)) {
            return 1;
        }

        return 0;
    }

    void different(MotionPaths arg4, boolean[] arg5, String[] arg6, boolean arg7) {
        arg5[0] |= this.diff(this.position, arg4.position);
        arg5[1] |= this.diff(this.x, arg4.x) | (((int)arg7));
        arg5[2] |= (((int)arg7)) | this.diff(this.y, arg4.y);
        arg5[3] |= this.diff(this.width, arg4.width);
        arg5[4] |= this.diff(this.height, arg4.height);
    }

    void fillStandard(double[] arg9, int[] arg10) {
        float v0 = this.position;
        float v1 = this.x;
        float v2 = this.y;
        float v3 = this.width;
        float v4 = this.height;
        float v8 = this.mPathRotate;
        int v5 = 6;
        float[] v6 = new float[v5];
        int v7 = 0;
        v6[0] = v0;
        v6[1] = v1;
        v6[2] = v2;
        v6[3] = v3;
        v6[4] = v4;
        v6[5] = v8;
        int v8_1 = 0;
        while(v7 < arg10.length) {
            int v0_1 = arg10[v7];
            if(v0_1 < v5) {
                arg9[v8_1] = ((double)v6[v0_1]);
                ++v8_1;
            }

            ++v7;
        }
    }

    void getBounds(int[] arg6, double[] arg7, float[] arg8, int arg9) {
        float v0 = this.width;
        float v5 = this.height;
        int v1;
        for(v1 = 0; v1 < arg6.length; ++v1) {
            float v2 = ((float)arg7[v1]);
            int v3 = arg6[v1];
            if(v3 == 3) {
                v0 = v2;
            }
            else if(v3 != 4) {
            }
            else {
                v5 = v2;
            }
        }

        arg8[arg9] = v0;
        arg8[arg9 + 1] = v5;
    }

    void getCenter(int[] arg9, double[] arg10, float[] arg11, int arg12) {
        float v0 = this.x;
        float v1 = this.y;
        float v2 = this.width;
        float v8 = this.height;
        int v3;
        for(v3 = 0; v3 < arg9.length; ++v3) {
            float v4 = ((float)arg10[v3]);
            int v6 = arg9[v3];
            if(v6 == 1) {
                v0 = v4;
            }
            else if(v6 == 2) {
                v1 = v4;
            }
            else if(v6 == 3) {
                v2 = v4;
            }
            else if(v6 != 4) {
            }
            else {
                v8 = v4;
            }
        }

        arg11[arg12] = v0 + v2 / 2f + 0f;
        arg11[arg12 + 1] = v1 + v8 / 2f + 0f;
    }

    int getCustomData(String arg5, double[] arg6, int arg7) {
        Object v4 = this.attributes.get(arg5);
        if(((ConstraintAttribute)v4).noOfInterpValues() == 1) {
            arg6[arg7] = ((double)((ConstraintAttribute)v4).getValueToInterpolate());
            return 1;
        }

        int v5 = ((ConstraintAttribute)v4).noOfInterpValues();
        float[] v0 = new float[v5];
        ((ConstraintAttribute)v4).getValuesToInterpolate(v0);
        int v4_1 = 0;
        while(v4_1 < v5) {
            arg6[arg7] = ((double)v0[v4_1]);
            ++v4_1;
            ++arg7;
        }

        return v5;
    }

    int getCustomDataCount(String arg1) {
        return this.attributes.get(arg1).noOfInterpValues();
    }

    void getRect(int[] arg8, double[] arg9, float[] arg10, int arg11) {
        float v0 = this.x;
        float v1 = this.y;
        float v2 = this.width;
        float v7 = this.height;
        int v3;
        for(v3 = 0; v3 < arg8.length; ++v3) {
            float v4 = ((float)arg9[v3]);
            int v5 = arg8[v3];
            if(v5 == 1) {
                v0 = v4;
            }
            else if(v5 == 2) {
                v1 = v4;
            }
            else if(v5 == 3) {
                v2 = v4;
            }
            else if(v5 != 4) {
            }
            else {
                v7 = v4;
            }
        }

        v2 += v0;
        v7 += v1;
        Float.isNaN(NaNf);
        Float.isNaN(NaNf);
        arg10[arg11] = v0 + 0f;
        arg10[arg11 + 1] = v1 + 0f;
        arg10[arg11 + 2] = v2 + 0f;
        arg10[arg11 + 3] = v1 + 0f;
        arg10[arg11 + 4] = v2 + 0f;
        arg10[arg11 + 5] = v7 + 0f;
        arg10[arg11 + 6] = v0 + 0f;
        arg10[arg11 + 7] = v7 + 0f;
    }

    boolean hasCustomData(String arg1) {
        return this.attributes.containsKey(arg1);
    }

    void initCartesian(KeyPosition arg20, MotionPaths arg21, MotionPaths arg22) {
        MotionPaths v0 = this;
        KeyPosition v1 = arg20;
        MotionPaths v2 = arg21;
        MotionPaths v3 = arg22;
        float v4 = (((float)v1.mFramePosition)) / 100f;
        v0.time = v4;
        v0.mDrawPath = v1.mDrawPath;
        float v5 = Float.isNaN(v1.mPercentWidth) ? v4 : v1.mPercentWidth;
        float v6 = Float.isNaN(v1.mPercentHeight) ? v4 : v1.mPercentHeight;
        float v7 = v3.width;
        float v8 = v2.width;
        float v10 = v3.height;
        float v11 = v2.height;
        v0.position = v0.time;
        float v13 = v2.x;
        float v14 = v2.y;
        float v18 = v4;
        v4 = v3.x + v7 / 2f - (v8 / 2f + v13);
        float v3_1 = v3.y + v10 / 2f - (v14 + v11 / 2f);
        float v9 = (v7 - v8) * v5;
        v5 = v9 / 2f;
        v0.x = ((float)(((int)(v13 + v4 * v18 - v5))));
        float v12 = (v10 - v11) * v6;
        v6 = v12 / 2f;
        v0.y = ((float)(((int)(v14 + v3_1 * v18 - v6))));
        v0.width = ((float)(((int)(v8 + v9))));
        v0.height = ((float)(((int)(v11 + v12))));
        v7 = Float.isNaN(v1.mPercentX) ? v18 : v1.mPercentX;
        v9 = 0f;
        v8 = Float.isNaN(v1.mAltPercentY) ? 0f : v1.mAltPercentY;
        if(Float.isNaN(v1.mPercentY)) {
        }
        else {
            v18 = v1.mPercentY;
        }

        if(Float.isNaN(v1.mAltPercentX)) {
        }
        else {
            v9 = v1.mAltPercentX;
        }

        v0.mMode = 2;
        v0.x = ((float)(((int)(v2.x + v7 * v4 + v9 * v3_1 - v5))));
        v0.y = ((float)(((int)(v2.y + v4 * v8 + v3_1 * v18 - v6))));
        v0.mKeyFrameEasing = Easing.getInterpolator(v1.mTransitionEasing);
        v0.mPathMotionArc = v1.mPathMotionArc;
    }

    void initPath(KeyPosition arg19, MotionPaths arg20, MotionPaths arg21) {
        MotionPaths v0 = this;
        KeyPosition v1 = arg19;
        MotionPaths v2 = arg20;
        MotionPaths v3 = arg21;
        float v4 = (((float)v1.mFramePosition)) / 100f;
        v0.time = v4;
        v0.mDrawPath = v1.mDrawPath;
        float v5 = Float.isNaN(v1.mPercentWidth) ? v4 : v1.mPercentWidth;
        float v6 = Float.isNaN(v1.mPercentHeight) ? v4 : v1.mPercentHeight;
        float v7 = v3.width - v2.width;
        float v8 = v3.height - v2.height;
        v0.position = v0.time;
        if(Float.isNaN(v1.mPercentX)) {
        }
        else {
            v4 = v1.mPercentX;
        }

        float v9 = v2.x;
        float v10 = v2.width;
        float v13 = v2.y;
        float v14 = v2.height;
        float v17 = v4;
        float v11 = v3.x + v3.width / 2f - (v10 / 2f + v9);
        v4 = v3.y + v3.height / 2f - (v14 / 2f + v13);
        float v3_1 = v11 * v17;
        v7 *= v5;
        v5 = v7 / 2f;
        v0.x = ((float)(((int)(v9 + v3_1 - v5))));
        v9 = v4 * v17;
        v8 *= v6;
        v6 = v8 / 2f;
        v0.y = ((float)(((int)(v13 + v9 - v6))));
        v0.width = ((float)(((int)(v10 + v7))));
        v0.height = ((float)(((int)(v14 + v8))));
        v7 = Float.isNaN(v1.mPercentY) ? 0f : v1.mPercentY;
        v0.mMode = 1;
        v3_1 = ((float)(((int)(v2.x + v3_1 - v5))));
        v0.x = v3_1;
        float v2_1 = ((float)(((int)(v2.y + v9 - v6))));
        v0.x = v3_1 + -v4 * v7;
        v0.y = v2_1 + v11 * v7;
        v0.mKeyFrameEasing = Easing.getInterpolator(v1.mTransitionEasing);
        v0.mPathMotionArc = v1.mPathMotionArc;
    }

    void initScreen(int arg19, int arg20, KeyPosition arg21, MotionPaths arg22, MotionPaths arg23) {
        MotionPaths v0 = this;
        KeyPosition v1 = arg21;
        MotionPaths v2 = arg22;
        MotionPaths v3 = arg23;
        float v4 = (((float)v1.mFramePosition)) / 100f;
        v0.time = v4;
        v0.mDrawPath = v1.mDrawPath;
        float v5 = Float.isNaN(v1.mPercentWidth) ? v4 : v1.mPercentWidth;
        float v6 = Float.isNaN(v1.mPercentHeight) ? v4 : v1.mPercentHeight;
        float v7 = v3.width;
        float v8 = v2.width;
        float v10 = v3.height;
        float v11 = v2.height;
        v0.position = v0.time;
        float v13 = v2.x;
        float v2_1 = v2.y;
        float v14 = v3.x + v7 / 2f;
        float v3_1 = v3.y + v10 / 2f - (v2_1 + v11 / 2f);
        float v9 = (v7 - v8) * v5;
        v0.x = ((float)(((int)(v13 + (v14 - (v8 / 2f + v13)) * v4 - v9 / 2f))));
        float v12 = (v10 - v11) * v6;
        v0.y = ((float)(((int)(v2_1 + v3_1 * v4 - v12 / 2f))));
        v0.width = ((float)(((int)(v8 + v9))));
        v0.height = ((float)(((int)(v11 + v12))));
        v0.mMode = 3;
        if(!Float.isNaN(v1.mPercentX)) {
            v0.x = ((float)(((int)(v1.mPercentX * (((float)(((int)((((float)arg19)) - v0.width)))))))));
        }

        if(!Float.isNaN(v1.mPercentY)) {
            v0.y = ((float)(((int)(v1.mPercentY * (((float)(((int)((((float)arg20)) - v0.height)))))))));
        }

        v0.mKeyFrameEasing = Easing.getInterpolator(v1.mTransitionEasing);
        v0.mPathMotionArc = v1.mPathMotionArc;
    }

    void setBounds(float arg1, float arg2, float arg3, float arg4) {
        this.x = arg1;
        this.y = arg2;
        this.width = arg3;
        this.height = arg4;
    }

    void setDpDt(float arg12, float arg13, float[] arg14, int[] arg15, double[] arg16, double[] arg17) {
        float v3 = 0f;
        float v4 = 0f;
        float v5 = 0f;
        float v6 = 0f;
        int v2;
        for(v2 = 0; v2 < arg15.length; ++v2) {
            float v7 = ((float)arg16[v2]);
            int v9 = arg15[v2];
            if(v9 == 1) {
                v3 = v7;
            }
            else if(v9 == 2) {
                v5 = v7;
            }
            else if(v9 == 3) {
                v4 = v7;
            }
            else if(v9 != 4) {
            }
            else {
                v6 = v7;
            }
        }

        v3 -= 0f * v4 / 2f;
        v5 -= 0f * v6 / 2f;
        arg14[0] = v3 * (1f - arg12) + (v4 * 1f + v3) * arg12 + 0f;
        arg14[1] = v5 * (1f - arg13) + (v6 * 1f + v5) * arg13 + 0f;
    }

    void setView(View arg20, int[] arg21, double[] arg22, double[] arg23, double[] arg24) {
        float v2_2;
        float v23;
        int v7;
        MotionPaths v0 = this;
        View v1 = arg20;
        int[] v2 = arg21;
        float v3 = v0.x;
        float v4 = v0.y;
        float v5 = v0.width;
        float v6 = v0.height;
        if(v2.length != 0 && v0.mTempValue.length <= v2[v2.length - 1]) {
            v7 = v2[v2.length - 1] + 1;
            v0.mTempValue = new double[v7];
            v0.mTempDelta = new double[v7];
        }

        Arrays.fill(v0.mTempValue, NaN);
        v7 = 0;
        int v9;
        for(v9 = 0; v9 < v2.length; ++v9) {
            double[] v10 = v0.mTempValue;
            int v11 = v2[v9];
            v10[v11] = arg22[v9];
            v0.mTempDelta[v11] = arg23[v9];
        }

        float v10_1 = NaNf;
        float v11_1 = 0f;
        float v12 = 0f;
        float v13 = 0f;
        float v14 = 0f;
        while(true) {
            double[] v15 = v0.mTempValue;
            if(v7 >= v15.length) {
                break;
            }

            boolean v2_1 = Double.isNaN(v15[v7]);
            double v15_1 = 0;
            if(v2_1) {
                if(arg24 != null && arg24[v7] != v15_1) {
                    goto label_59;
                }

                v23 = v10_1;
                v10_1 = v3;
                goto label_87;
            }
            else {
            label_59:
                if(arg24 != null) {
                    v15_1 = arg24[v7];
                }

                if(Double.isNaN(v0.mTempValue[v7])) {
                }
                else {
                    v15_1 = v0.mTempValue[v7] + v15_1;
                }

                v23 = v10_1;
                float v15_2 = ((float)v15_1);
                v10_1 = v3;
                v2_2 = ((float)v0.mTempDelta[v7]);
                if(v7 != 1) {
                    if(v7 == 2) {
                        goto label_101;
                    }

                    if(v7 == 3) {
                        goto label_97;
                    }

                    if(v7 == 4) {
                        goto label_93;
                    }

                    if(v7 != 5) {
                    label_87:
                        v3 = v10_1;
                    }
                    else {
                        v3 = v10_1;
                        v10_1 = v15_2;
                        goto label_108;
                    label_93:
                        v14 = v2_2;
                        v3 = v10_1;
                        v6 = v15_2;
                        goto label_88;
                    label_97:
                        v12 = v2_2;
                        v3 = v10_1;
                        v5 = v15_2;
                        goto label_88;
                    label_101:
                        v13 = v2_2;
                        v3 = v10_1;
                        v4 = v15_2;
                    }

                label_88:
                    v10_1 = v23;
                    goto label_108;
                }

                v10_1 = v23;
                v11_1 = v2_2;
                v3 = v15_2;
            }

        label_108:
            ++v7;
        }

        v23 = v10_1;
        float v22 = NaNf;
        v10_1 = v3;
        if(!Float.isNaN(v23)) {
            float v0_1 = v22;
            v2_2 = Float.isNaN(v0_1) ? 0f : v0_1;
            v1.setRotation(((float)((((double)v2_2)) + ((((double)v23)) + Math.toDegrees(Math.atan2(((double)(v13 + v14 / 2f)), ((double)(v11_1 + v12 / 2f))))))));
        }
        else if(!Float.isNaN(v22)) {
            v1.setRotation(v22);
        }

        v3 = v10_1 + 0.5f;
        int v2_3 = ((int)v3);
        v4 += 0.5f;
        int v0_2 = ((int)v4);
        int v3_1 = ((int)(v3 + v5));
        int v4_1 = ((int)(v4 + v6));
        int v5_1 = v3_1 - v2_3;
        int v6_1 = v4_1 - v0_2;
        if(v5_1 != v1.getMeasuredWidth() || v6_1 != v1.getMeasuredHeight()) {
            v1.measure(View$MeasureSpec.makeMeasureSpec(v5_1, 0x40000000), View$MeasureSpec.makeMeasureSpec(v6_1, 0x40000000));
        }

        v1.layout(v2_3, v0_2, v3_1, v4_1);
    }

    private static final float xRotate(float arg0, float arg1, float arg2, float arg3, float arg4, float arg5) {
        return (arg4 - arg2) * arg1 - (arg5 - arg3) * arg0 + arg2;
    }

    private static final float yRotate(float arg0, float arg1, float arg2, float arg3, float arg4, float arg5) {
        return (arg4 - arg2) * arg0 + (arg5 - arg3) * arg1 + arg3;
    }
}

