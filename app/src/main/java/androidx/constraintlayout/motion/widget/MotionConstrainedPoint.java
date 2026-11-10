package androidx.constraintlayout.motion.widget;

import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintAttribute$AttributeType;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintSet$Constraint;
import androidx.constraintlayout.widget.ConstraintSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;

class MotionConstrainedPoint implements Comparable {
    static final int CARTESIAN = 2;
    public static final boolean DEBUG = false;
    static final int PERPENDICULAR = 1;
    public static final String TAG = "MotionPaths";
    private float alpha;
    private boolean applyElevation;
    LinkedHashMap attributes;
    private float elevation;
    private float height;
    private int mDrawPath;
    private Easing mKeyFrameEasing;
    int mMode;
    private float mPathRotate;
    private float mPivotX;
    private float mPivotY;
    private float mProgress;
    double[] mTempDelta;
    double[] mTempValue;
    int mVisibilityMode;
    static String[] names;
    private float position;
    private float rotation;
    private float rotationX;
    public float rotationY;
    private float scaleX;
    private float scaleY;
    private float translationX;
    private float translationY;
    private float translationZ;
    int visibility;
    private float width;
    private float x;
    private float y;

    static {
        MotionConstrainedPoint.names = new String[]{"position", "x", "y", "width", "height", "pathRotate"};
    }

    public MotionConstrainedPoint() {
        super();
        this.alpha = 1f;
        this.mVisibilityMode = 0;
        this.applyElevation = false;
        this.elevation = 0f;
        this.rotation = 0f;
        this.rotationX = 0f;
        this.rotationY = 0f;
        this.scaleX = 1f;
        this.scaleY = 1f;
        this.mPivotX = NaNf;
        this.mPivotY = NaNf;
        this.translationX = 0f;
        this.translationY = 0f;
        this.translationZ = 0f;
        this.mDrawPath = 0;
        this.mPathRotate = NaNf;
        this.mProgress = NaNf;
        this.attributes = new LinkedHashMap();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
    }

    public void addValues(HashMap arg8, int arg9) {
        Iterator v0 = arg8.keySet().iterator();
        while(v0.hasNext()) {
            Object v1 = v0.next();
            Object v2 = arg8.get(v1);
            ((String)v1).hashCode();
            int v5 = -1;
            switch(((String)v1).hashCode()) {
                case -1249320806: {
                    if(!((String)v1).equals("rotationX")) {
                        goto label_95;
                    }

                    v5 = 0;
                    break;
                }
                case -1249320805: {
                    if(!((String)v1).equals("rotationY")) {
                        goto label_95;
                    }

                    v5 = 1;
                    break;
                }
                case -1225497657: {
                    if(!((String)v1).equals("translationX")) {
                        goto label_95;
                    }

                    v5 = 2;
                    break;
                }
                case -1225497656: {
                    if(!((String)v1).equals("translationY")) {
                        goto label_95;
                    }

                    v5 = 3;
                    break;
                }
                case -1225497655: {
                    if(!((String)v1).equals("translationZ")) {
                        goto label_95;
                    }

                    v5 = 4;
                    break;
                }
                case -1001078227: {
                    if(!((String)v1).equals("progress")) {
                        goto label_95;
                    }

                    v5 = 5;
                    break;
                }
                case -908189618: {
                    if(!((String)v1).equals("scaleX")) {
                        goto label_95;
                    }

                    v5 = 6;
                    break;
                }
                case -908189617: {
                    if(!((String)v1).equals("scaleY")) {
                        goto label_95;
                    }

                    v5 = 7;
                    break;
                }
                case -760884510: {
                    if(!((String)v1).equals("transformPivotX")) {
                        goto label_95;
                    }

                    v5 = 8;
                    break;
                }
                case -760884509: {
                    if(!((String)v1).equals("transformPivotY")) {
                        goto label_95;
                    }

                    v5 = 9;
                    break;
                }
                case -40300674: {
                    if(!((String)v1).equals("rotation")) {
                        goto label_95;
                    }

                    v5 = 10;
                    break;
                }
                case -4379043: {
                    if(!((String)v1).equals("elevation")) {
                        goto label_95;
                    }

                    v5 = 11;
                    break;
                }
                case 37232917: {
                    if(!((String)v1).equals("transitionPathRotate")) {
                        goto label_95;
                    }

                    v5 = 12;
                    break;
                }
                case 92909918: {
                    if(!((String)v1).equals("alpha")) {
                        goto label_95;
                    }

                    v5 = 13;
                    break;
                }
                default: {
                    break;
                }
            }

        label_95:
            float v3 = 1f;
            float v6 = 0f;
            switch(v5) {
                case 0: {
                    goto label_233;
                }
                case 1: {
                    goto label_226;
                }
                case 2: {
                    goto label_219;
                }
                case 3: {
                    goto label_212;
                }
                case 4: {
                    goto label_205;
                }
                case 5: {
                    goto label_198;
                }
                case 6: {
                    goto label_191;
                }
                case 7: {
                    goto label_184;
                }
                case 8: {
                    goto label_177;
                }
                case 9: {
                    goto label_170;
                }
                case 10: {
                    goto label_163;
                }
                case 11: {
                    goto label_156;
                }
                case 12: {
                    goto label_149;
                }
                case 13: {
                    goto label_142;
                }
            }

            String v5_1 = "MotionPaths";
            if(((String)v1).startsWith("CUSTOM")) {
                String v3_1 = ((String)v1).split(",")[1];
                if(this.attributes.containsKey(v3_1)) {
                    Object v3_2 = this.attributes.get(v3_1);
                    if((v2 instanceof CustomSet)) {
                        ((CustomSet)v2).setPoint(arg9, ((ConstraintAttribute)v3_2));
                        continue;
                    }

                    Log.e(v5_1, (((String)v1)) + " splineSet not a CustomSet frame = " + arg9 + ", value" + ((ConstraintAttribute)v3_2).getValueToInterpolate() + v2);
                    continue;
                }

                Log.e(v5_1, "UNKNOWN customName " + v3_1);
                continue;
            }

            Log.e(v5_1, "UNKNOWN spline " + (((String)v1)));
            continue;
        label_226:
            if(Float.isNaN(this.rotationY)) {
            }
            else {
                v6 = this.rotationY;
            }

            ((SplineSet)v2).setPoint(arg9, v6);
            continue;
        label_163:
            if(Float.isNaN(this.rotation)) {
            }
            else {
                v6 = this.rotation;
            }

            ((SplineSet)v2).setPoint(arg9, v6);
            continue;
        label_198:
            if(Float.isNaN(this.mProgress)) {
            }
            else {
                v6 = this.mProgress;
            }

            ((SplineSet)v2).setPoint(arg9, v6);
            continue;
        label_233:
            if(Float.isNaN(this.rotationX)) {
            }
            else {
                v6 = this.rotationX;
            }

            ((SplineSet)v2).setPoint(arg9, v6);
            continue;
        label_170:
            if(Float.isNaN(this.mPivotY)) {
            }
            else {
                v6 = this.mPivotY;
            }

            ((SplineSet)v2).setPoint(arg9, v6);
            continue;
        label_205:
            if(Float.isNaN(this.translationZ)) {
            }
            else {
                v6 = this.translationZ;
            }

            ((SplineSet)v2).setPoint(arg9, v6);
            continue;
        label_142:
            if(Float.isNaN(this.alpha)) {
            }
            else {
                v3 = this.alpha;
            }

            ((SplineSet)v2).setPoint(arg9, v3);
            continue;
        label_177:
            if(Float.isNaN(this.mPivotX)) {
            }
            else {
                v6 = this.mPivotX;
            }

            ((SplineSet)v2).setPoint(arg9, v6);
            continue;
        label_212:
            if(Float.isNaN(this.translationY)) {
            }
            else {
                v6 = this.translationY;
            }

            ((SplineSet)v2).setPoint(arg9, v6);
            continue;
        label_149:
            if(Float.isNaN(this.mPathRotate)) {
            }
            else {
                v6 = this.mPathRotate;
            }

            ((SplineSet)v2).setPoint(arg9, v6);
            continue;
        label_184:
            if(Float.isNaN(this.scaleY)) {
            }
            else {
                v3 = this.scaleY;
            }

            ((SplineSet)v2).setPoint(arg9, v3);
            continue;
        label_219:
            if(Float.isNaN(this.translationX)) {
            }
            else {
                v6 = this.translationX;
            }

            ((SplineSet)v2).setPoint(arg9, v6);
            continue;
        label_156:
            if(Float.isNaN(this.elevation)) {
            }
            else {
                v6 = this.elevation;
            }

            ((SplineSet)v2).setPoint(arg9, v6);
            continue;
        label_191:
            if(Float.isNaN(this.scaleX)) {
            }
            else {
                v3 = this.scaleX;
            }

            ((SplineSet)v2).setPoint(arg9, v3);
        }
    }

    public void applyParameters(View arg2) {
        this.visibility = arg2.getVisibility();
        float v0 = arg2.getVisibility() != 0 ? 0f : arg2.getAlpha();
        this.alpha = v0;
        this.applyElevation = false;
        this.elevation = arg2.getElevation();
        this.rotation = arg2.getRotation();
        this.rotationX = arg2.getRotationX();
        this.rotationY = arg2.getRotationY();
        this.scaleX = arg2.getScaleX();
        this.scaleY = arg2.getScaleY();
        this.mPivotX = arg2.getPivotX();
        this.mPivotY = arg2.getPivotY();
        this.translationX = arg2.getTranslationX();
        this.translationY = arg2.getTranslationY();
        this.translationZ = arg2.getTranslationZ();
    }

    public void applyParameters(Constraint arg6) {
        this.mVisibilityMode = arg6.propertySet.mVisibilityMode;
        this.visibility = arg6.propertySet.visibility;
        float v0 = arg6.propertySet.visibility == 0 || this.mVisibilityMode != 0 ? arg6.propertySet.alpha : 0f;
        this.alpha = v0;
        this.applyElevation = arg6.transform.applyElevation;
        this.elevation = arg6.transform.elevation;
        this.rotation = arg6.transform.rotation;
        this.rotationX = arg6.transform.rotationX;
        this.rotationY = arg6.transform.rotationY;
        this.scaleX = arg6.transform.scaleX;
        this.scaleY = arg6.transform.scaleY;
        this.mPivotX = arg6.transform.transformPivotX;
        this.mPivotY = arg6.transform.transformPivotY;
        this.translationX = arg6.transform.translationX;
        this.translationY = arg6.transform.translationY;
        this.translationZ = arg6.transform.translationZ;
        this.mKeyFrameEasing = Easing.getInterpolator(arg6.motion.mTransitionEasing);
        this.mPathRotate = arg6.motion.mPathRotate;
        this.mDrawPath = arg6.motion.mDrawPath;
        this.mProgress = arg6.propertySet.mProgress;
        Iterator v0_1 = arg6.mCustomConstraints.keySet().iterator();
        while(v0_1.hasNext()) {
            Object v1 = v0_1.next();
            Object v2 = arg6.mCustomConstraints.get(v1);
            if(((ConstraintAttribute)v2).getType() == AttributeType.STRING_TYPE) {
                continue;
            }

            this.attributes.put(v1, v2);
        }
    }

    public int compareTo(MotionConstrainedPoint arg1) {
        return Float.compare(this.position, arg1.position);
    }

    public int compareTo(Object arg1) {
        return this.compareTo(((MotionConstrainedPoint)arg1));
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

    void different(MotionConstrainedPoint arg5, HashSet arg6) {
        String v1 = "alpha";
        if(this.diff(this.alpha, arg5.alpha)) {
            arg6.add(v1);
        }

        if(this.diff(this.elevation, arg5.elevation)) {
            arg6.add("elevation");
        }

        int v0 = this.visibility;
        int v2 = arg5.visibility;
        if(v0 != v2 && this.mVisibilityMode == 0 && (v0 == 0 || v2 == 0)) {
            arg6.add(v1);
        }

        if(this.diff(this.rotation, arg5.rotation)) {
            arg6.add("rotation");
        }

        if(!Float.isNaN(this.mPathRotate) || !Float.isNaN(arg5.mPathRotate)) {
            arg6.add("transitionPathRotate");
        }

        if(!Float.isNaN(this.mProgress) || !Float.isNaN(arg5.mProgress)) {
            arg6.add("progress");
        }

        if(this.diff(this.rotationX, arg5.rotationX)) {
            arg6.add("rotationX");
        }

        if(this.diff(this.rotationY, arg5.rotationY)) {
            arg6.add("rotationY");
        }

        if(this.diff(this.mPivotX, arg5.mPivotX)) {
            arg6.add("transformPivotX");
        }

        if(this.diff(this.mPivotY, arg5.mPivotY)) {
            arg6.add("transformPivotY");
        }

        if(this.diff(this.scaleX, arg5.scaleX)) {
            arg6.add("scaleX");
        }

        if(this.diff(this.scaleY, arg5.scaleY)) {
            arg6.add("scaleY");
        }

        if(this.diff(this.translationX, arg5.translationX)) {
            arg6.add("translationX");
        }

        if(this.diff(this.translationY, arg5.translationY)) {
            arg6.add("translationY");
        }

        if(this.diff(this.translationZ, arg5.translationZ)) {
            arg6.add("translationZ");
        }
    }

    void different(MotionConstrainedPoint arg4, boolean[] arg5, String[] arg6) {
        arg5[0] |= this.diff(this.position, arg4.position);
        arg5[1] |= this.diff(this.x, arg4.x);
        arg5[2] |= this.diff(this.y, arg4.y);
        arg5[3] |= this.diff(this.width, arg4.width);
        arg5[4] |= this.diff(this.height, arg4.height);
    }

    void fillStandard(double[] arg22, int[] arg23) {
        int[] v1 = arg23;
        float v2 = this.position;
        float v3 = this.x;
        float v4 = this.y;
        float v5 = this.width;
        float v6 = this.height;
        float v7 = this.alpha;
        float v8 = this.elevation;
        float v9 = this.rotation;
        float v10 = this.rotationX;
        float v11 = this.rotationY;
        float v12 = this.scaleX;
        float v13 = this.scaleY;
        float v14 = this.mPivotX;
        float v15 = this.mPivotY;
        float v16 = v2;
        float v17 = this.translationX;
        float v18 = this.translationY;
        v2 = this.translationZ;
        float v21 = this.mPathRotate;
        int v0 = 18;
        float v19 = v2;
        float[] v2_1 = new float[v0];
        int v20 = 0;
        v2_1[0] = v16;
        v2_1[1] = v3;
        v2_1[2] = v4;
        v2_1[3] = v5;
        v2_1[4] = v6;
        v2_1[5] = v7;
        v2_1[6] = v8;
        v2_1[7] = v9;
        v2_1[8] = v10;
        v2_1[9] = v11;
        v2_1[10] = v12;
        v2_1[11] = v13;
        v2_1[12] = v14;
        v2_1[13] = v15;
        v2_1[14] = v17;
        v2_1[15] = v18;
        v2_1[16] = v19;
        v2_1[17] = v21;
        int v3_1;
        for(v3_1 = 0; v3_1 < v1.length; ++v3_1) {
            int v4_1 = v1[v3_1];
            if(v4_1 < v0) {
                arg22[v20] = ((double)v2_1[v4_1]);
                ++v20;
            }
        }
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

    boolean hasCustomData(String arg1) {
        return this.attributes.containsKey(arg1);
    }

    void setBounds(float arg1, float arg2, float arg3, float arg4) {
        this.x = arg1;
        this.y = arg2;
        this.width = arg3;
        this.height = arg4;
    }

    public void setState(View arg5) {
        this.setBounds(arg5.getX(), arg5.getY(), ((float)arg5.getWidth()), ((float)arg5.getHeight()));
        this.applyParameters(arg5);
    }

    public void setState(ConstraintWidget arg4, ConstraintSet arg5, int arg6) {
        this.setBounds(((float)arg4.getX()), ((float)arg4.getY()), ((float)arg4.getWidth()), ((float)arg4.getHeight()));
        this.applyParameters(arg5.getParameters(arg6));
    }
}

