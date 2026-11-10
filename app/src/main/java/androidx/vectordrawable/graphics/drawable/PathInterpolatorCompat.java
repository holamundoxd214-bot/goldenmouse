package androidx.vectordrawable.graphics.drawable;

import android.content.Context;
import android.content.res.Resources$Theme;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.animation.Interpolator;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import org.xmlpull.v1.XmlPullParser;

public class PathInterpolatorCompat implements Interpolator {
    public static final double EPSILON = 0.00001;
    public static final int MAX_NUM_POINTS = 3000;
    private static final float PRECISION = 0.002f;
    private float[] mX;
    private float[] mY;

    public PathInterpolatorCompat(Context arg2, AttributeSet arg3, XmlPullParser arg4) {
        this(arg2.getResources(), arg2.getTheme(), arg3, arg4);
    }

    public PathInterpolatorCompat(Resources arg2, Resources$Theme arg3, AttributeSet arg4, XmlPullParser arg5) {
        super();
        TypedArray v2 = TypedArrayUtils.obtainAttributes(arg2, arg3, arg4, AndroidResources.STYLEABLE_PATH_INTERPOLATOR);
        this.parseInterpolatorFromTypeArray(v2, arg5);
        v2.recycle();
    }

    public float getInterpolation(float arg7) {
        if(arg7 <= 0f) {
            return 0;
        }

        float v1 = 1f;
        if(arg7 >= v1) {
            return v1;
        }

        int v1_1 = this.mX.length - 1;
        int v3;
        for(v3 = 0; v1_1 - v3 > 1; v3 = v4) {
            int v4 = (v3 + v1_1) / 2;
            if(arg7 < this.mX[v4]) {
                v1_1 = v4;
                continue;
            }
        }

        float[] v2 = this.mX;
        float v4_1 = v2[v1_1];
        float v2_1 = v2[v3];
        v4_1 -= v2_1;
        int v0 = Float.compare(v4_1, 0f);
        float[] v6 = this.mY;
        if(v0 == 0) {
            return v6[v3];
        }

        return v6[v3] + (arg7 - v2_1) / v4_1 * (v6[v1_1] - v6[v3]);
    }

    private void initCubic(float arg8, float arg9, float arg10, float arg11) {
        Path v0 = new Path();
        v0.moveTo(0f, 0f);
        v0.cubicTo(arg8, arg9, arg10, arg11, 1f, 1f);
        this.initPath(v0);
    }

    private void initPath(Path arg11) {
        float v3_1;
        int v3;
        int v1 = 0;
        PathMeasure v0 = new PathMeasure(arg11, false);
        float v11 = v0.getLength();
        int v2 = Math.min(3000, (((int)(v11 / 0.002f))) + 1);
        if(v2 <= 0) {
            goto label_112;
        }

        this.mX = new float[v2];
        this.mY = new float[v2];
        float[] v4 = new float[2];
        int v5;
        for(v5 = 0; v5 < v2; ++v5) {
            v0.getPosTan((((float)v5)) * v11 / (((float)(v2 - 1))), v4, null);
            this.mX[v5] = v4[0];
            this.mY[v5] = v4[1];
        }

        double v6 = 0.00001;
        if((((double)Math.abs(this.mX[0]))) <= v6 && (((double)Math.abs(this.mY[0]))) <= v6) {
            int v4_1 = v2 - 1;
            float v5_1 = 1f;
            if((((double)Math.abs(this.mX[v4_1] - v5_1))) <= v6 && (((double)Math.abs(this.mY[v4_1] - v5_1))) <= v6) {
                v11 = 0f;
                v3 = 0;
                goto label_62;
            }
        }

        --v2;
        throw new IllegalArgumentException("The Path must start at (0,0) and end at (1,1) start: " + this.mX[0] + "," + this.mY[0] + " end:" + this.mX[v2] + "," + this.mY[v2]);
        while(true) {
        label_62:
            if(v1 >= v2) {
                goto label_80;
            }

            v4 = this.mX;
            v5 = v3 + 1;
            v3_1 = v4[v3];
            if(v3_1 < v11) {
                break;
            }

            v4[v1] = v3_1;
            ++v1;
            v11 = v3_1;
            v3 = v5;
        }

        throw new IllegalArgumentException("The Path cannot loop back on itself, x :" + v3_1);
    label_80:
        if(!v0.nextContour()) {
            return;
        }

        throw new IllegalArgumentException("The Path should be continuous, can\'t have 2+ contours");
    label_112:
        throw new IllegalArgumentException("The Path has a invalid length " + v11);
    }

    private void initQuad(float arg3, float arg4) {
        Path v0 = new Path();
        v0.moveTo(0f, 0f);
        v0.quadTo(arg3, arg4, 1f, 1f);
        this.initPath(v0);
    }

    private void parseInterpolatorFromTypeArray(TypedArray arg8, XmlPullParser arg9) {
        String v0 = "pathData";
        if(TypedArrayUtils.hasAttribute(arg9, v0)) {
            String v8 = TypedArrayUtils.getNamedString(arg8, arg9, v0, 4);
            Path v9 = PathParser.createPathFromPathData(v8);
            if(v9 != null) {
                this.initPath(v9);
                return;
            }

            throw new InflateException("The path is null, which is created from " + v8);
        }

        v0 = "controlX1";
        if(TypedArrayUtils.hasAttribute(arg9, v0)) {
            String v1 = "controlY1";
            if(TypedArrayUtils.hasAttribute(arg9, v1)) {
                float v0_1 = TypedArrayUtils.getNamedFloat(arg8, arg9, v0, 0, 0f);
                float v1_1 = TypedArrayUtils.getNamedFloat(arg8, arg9, v1, 1, 0f);
                String v2 = "controlX2";
                boolean v4 = TypedArrayUtils.hasAttribute(arg9, v2);
                String v5 = "controlY2";
                if(v4 == TypedArrayUtils.hasAttribute(arg9, v5)) {
                    if(!v4) {
                        this.initQuad(v0_1, v1_1);
                        return;
                    }

                    this.initCubic(v0_1, v1_1, TypedArrayUtils.getNamedFloat(arg8, arg9, v2, 2, 0f), TypedArrayUtils.getNamedFloat(arg8, arg9, v5, 3, 0f));
                    return;
                }

                throw new InflateException("pathInterpolator requires both controlX2 and controlY2 for cubic Beziers.");
            }

            throw new InflateException("pathInterpolator requires the controlY1 attribute");
        }

        throw new InflateException("pathInterpolator requires the controlX1 attribute");
    }
}

