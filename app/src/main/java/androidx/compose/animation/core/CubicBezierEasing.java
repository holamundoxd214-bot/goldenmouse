package androidx.compose.animation.core;

import androidx.compose.ui.graphics.BezierKt;
import kotlin.Metadata;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000B\u001A\u00020\u00032\u0006\u0010\f\u001A\u00020\u0003H\u0016J\u0010\u0010\r\u001A\u00020\u000E2\u0006\u0010\f\u001A\u00020\u0003H\u0002J\u0013\u0010\u000F\u001A\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0013\u001A\u00020\u0014H\u0016J\b\u0010\u0015\u001A\u00020\u0016H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2={"Landroidx/compose/animation/core/CubicBezierEasing;", "Landroidx/compose/animation/core/Easing;", "a", "", "b", "c", "d", "<init>", "(FFFF)V", "min", "max", "transform", "fraction", "throwNoSolution", "", "equals", "", "other", "", "hashCode", "", "toString", "", "animation-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class CubicBezierEasing implements Easing {
    public static final int $stable;
    private final float a;
    private final float b;
    private final float c;
    private final float d;
    private final float max;
    private final float min;

    static {
    }

    public CubicBezierEasing(float arg7, float arg8, float arg9, float arg10) {
        super();
        this.a = arg7;
        this.b = arg8;
        this.c = arg9;
        this.d = arg10;
        int v0 = (Float.isNaN(arg7)) || (Float.isNaN(arg8)) || (Float.isNaN(arg9)) || (Float.isNaN(arg10)) ? 0 : 1;
        if(v0 == 0) {
            PreconditionsKt.throwIllegalArgumentException("Parameters to CubicBezierEasing cannot be NaN. Actual parameters are: " + arg7 + ", " + arg8 + ", " + arg9 + ", " + arg10 + '.');
        }

        long v7 = BezierKt.computeCubicVerticalBounds(0f, arg8, arg10, 1f, new float[5], 0);
        this.min = Float.intBitsToFloat(((int)(v7 >> 0x20)));
        this.max = Float.intBitsToFloat(((int)(v7 & 0xFFFFFFFFL)));
    }

    public boolean equals(Object arg3) {
        if(((arg3 instanceof CubicBezierEasing)) && this.a == ((CubicBezierEasing)arg3).a && this.b == ((CubicBezierEasing)arg3).b && this.c == ((CubicBezierEasing)arg3).c && this.d == ((CubicBezierEasing)arg3).d) {
            return 1;
        }

        return 0;
    }

    public int hashCode() {
        return ((Float.hashCode(this.a) * 0x1F + Float.hashCode(this.b)) * 0x1F + Float.hashCode(this.c)) * 0x1F + Float.hashCode(this.d);
    }

    private final void throwNoSolution(float arg5) {
        throw new IllegalArgumentException("The cubic curve with parameters (" + this.a + ", " + this.b + ", " + this.c + ", " + this.d + ") has no solution at " + arg5);
    }

    public String toString() {
        return "CubicBezierEasing(a=" + this.a + ", b=" + this.b + ", c=" + this.c + ", d=" + this.d + ')';
    }

    public float transform(float arg6) {
        if(arg6 > 0f) {
            float v1 = 1f;
            if(arg6 < v1) {
                float v2 = Math.max(arg6, 1.192093E-07f);
                float v0 = BezierKt.findFirstCubicRoot(0f - v2, this.a - v2, this.c - v2, v1 - v2);
                if(Float.isNaN(v0)) {
                    this.throwNoSolution(arg6);
                }

                arg6 = BezierKt.evaluateCubic(this.b, this.d, v0);
                v0 = this.min;
                float v5 = this.max;
                if(arg6 < v0) {
                    arg6 = v0;
                }

                if(arg6 <= v5) {
                    return arg6;
                }

                return v5;
            }
        }

        return arg6;
    }
}

