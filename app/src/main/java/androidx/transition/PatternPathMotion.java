package androidx.transition;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import org.xmlpull.v1.XmlPullParser;

public class PatternPathMotion extends PathMotion {
    private Path mOriginalPatternPath;
    private final Path mPatternPath;
    private final Matrix mTempMatrix;

    public PatternPathMotion() {
        super();
        Path v0 = new Path();
        this.mPatternPath = v0;
        this.mTempMatrix = new Matrix();
        v0.lineTo(1f, 0f);
        this.mOriginalPatternPath = v0;
    }

    public PatternPathMotion(Context arg3, AttributeSet arg4) {
        super();
        this.mPatternPath = new Path();
        this.mTempMatrix = new Matrix();
        TypedArray v3 = arg3.obtainStyledAttributes(arg4, Styleable.PATTERN_PATH_MOTION);
        try {
            String v4 = TypedArrayUtils.getNamedString(v3, ((XmlPullParser)arg4), "patternPathData", 0);
            if(v4 == null) {
                goto label_17;
            }

            this.setPatternPath(PathParser.createPathFromPathData(v4));
        }
        catch(Throwable v2) {
            goto label_22;
        }

        v3.recycle();
        return;
        try {
        label_17:
            throw new RuntimeException("pathData must be supplied for patternPathMotion");
        }
        catch(Throwable v2) {
        label_22:
            v3.recycle();
            throw v2;
        }
    }

    public PatternPathMotion(Path arg2) {
        super();
        this.mPatternPath = new Path();
        this.mTempMatrix = new Matrix();
        this.setPatternPath(arg2);
    }

    private static float distance(float arg0, float arg1) {
        return ((float)Math.sqrt(((double)(arg0 * arg0 + arg1 * arg1))));
    }

    public Path getPath(float arg4, float arg5, float arg6, float arg7) {
        arg6 -= arg4;
        arg7 -= arg5;
        float v0 = PatternPathMotion.distance(arg6, arg7);
        double v6 = Math.atan2(((double)arg7), ((double)arg6));
        this.mTempMatrix.setScale(v0, v0);
        this.mTempMatrix.postRotate(((float)Math.toDegrees(v6)));
        this.mTempMatrix.postTranslate(arg4, arg5);
        Path v4 = new Path();
        this.mPatternPath.transform(this.mTempMatrix, v4);
        return v4;
    }

    public Path getPatternPath() {
        return this.mOriginalPatternPath;
    }

    public void setPatternPath(Path arg9) {
        PathMeasure v0 = new PathMeasure(arg9, false);
        float v2 = v0.getLength();
        float[] v3 = new float[2];
        v0.getPosTan(v2, v3, null);
        v2 = v3[0];
        float v6 = v3[1];
        v0.getPosTan(0f, v3, null);
        float v0_1 = v3[0];
        float v1 = v3[1];
        if(v0_1 == v2) {
            if(v1 != v6) {
            }
            else {
                throw new IllegalArgumentException("pattern must not end at the starting point");
            }
        }

        this.mTempMatrix.setTranslate(-v0_1, -v1);
        v2 -= v0_1;
        v6 -= v1;
        v1 = 1f / PatternPathMotion.distance(v2, v6);
        this.mTempMatrix.postScale(v1, v1);
        this.mTempMatrix.postRotate(((float)Math.toDegrees(-Math.atan2(((double)v6), ((double)v2)))));
        arg9.transform(this.mTempMatrix, this.mPatternPath);
        this.mOriginalPatternPath = arg9;
    }
}

