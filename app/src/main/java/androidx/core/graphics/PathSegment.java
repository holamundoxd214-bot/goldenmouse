package androidx.core.graphics;

import android.graphics.PointF;
import androidx.core.util.Preconditions;

public final class PathSegment {
    private final PointF mEnd;
    private final float mEndFraction;
    private final PointF mStart;
    private final float mStartFraction;

    public PathSegment(PointF arg2, float arg3, PointF arg4, float arg5) {
        super();
        this.mStart = Preconditions.checkNotNull(arg2, "start == null");
        this.mStartFraction = arg3;
        this.mEnd = Preconditions.checkNotNull(arg4, "end == null");
        this.mEndFraction = arg5;
    }

    public boolean equals(Object arg5) {
        if(this == (((PathSegment)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof PathSegment)) {
            return 0;
        }

        if(Float.compare(this.mStartFraction, ((PathSegment)arg5).mStartFraction) == 0 && Float.compare(this.mEndFraction, ((PathSegment)arg5).mEndFraction) == 0 && (this.mStart.equals(((PathSegment)arg5).mStart)) && (this.mEnd.equals(((PathSegment)arg5).mEnd))) {
            return 1;
        }

        return 0;
    }

    public PointF getEnd() {
        return this.mEnd;
    }

    public float getEndFraction() {
        return this.mEndFraction;
    }

    public PointF getStart() {
        return this.mStart;
    }

    public float getStartFraction() {
        return this.mStartFraction;
    }

    public int hashCode() {
        int v0 = this.mStart.hashCode() * 0x1F;
        float v1 = this.mStartFraction;
        int v4 = 0;
        int v1_1 = Float.compare(v1, 0f) != 0 ? Float.floatToIntBits(v1) : 0;
        v0 = ((v0 + v1_1) * 0x1F + this.mEnd.hashCode()) * 0x1F;
        float v5 = this.mEndFraction;
        if(v5 != 0f) {
            v4 = Float.floatToIntBits(v5);
        }

        return v0 + v4;
    }

    public String toString() {
        return "PathSegment{start=" + this.mStart + ", startFraction=" + this.mStartFraction + ", end=" + this.mEnd + ", endFraction=" + this.mEndFraction + '}';
    }
}

