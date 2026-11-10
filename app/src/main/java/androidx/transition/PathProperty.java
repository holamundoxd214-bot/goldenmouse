package androidx.transition;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

class PathProperty extends Property {
    private float mCurrentFraction;
    private final float mPathLength;
    private final PathMeasure mPathMeasure;
    private final PointF mPointF;
    private final float[] mPosition;
    private final Property mProperty;

    PathProperty(Property arg3, Path arg4) {
        super(Float.class, arg3.getName());
        this.mPosition = new float[2];
        this.mPointF = new PointF();
        this.mProperty = arg3;
        PathMeasure v3 = new PathMeasure(arg4, false);
        this.mPathMeasure = v3;
        this.mPathLength = v3.getLength();
    }

    public Float get(Object arg1) {
        return Float.valueOf(this.mCurrentFraction);
    }

    public Object get(Object arg1) {
        return this.get(arg1);
    }

    public void set(Object arg4, Float arg5) {
        this.mCurrentFraction = arg5.floatValue();
        this.mPathMeasure.getPosTan(this.mPathLength * arg5.floatValue(), this.mPosition, null);
        this.mPointF.x = this.mPosition[0];
        this.mPointF.y = this.mPosition[1];
        this.mProperty.set(arg4, this.mPointF);
    }

    public void set(Object arg1, Object arg2) {
        this.set(arg1, ((Float)arg2));
    }
}

