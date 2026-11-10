package androidx.graphics.path;

import android.graphics.Path;
import android.graphics.PointF;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b \u0018\u0000 !2\u00020\u0001:\u0001!B!\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u0014H&J#\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u0018\u001A\u00020\u0019H\u0002¢\u0006\u0002\u0010\u001AJ\b\u0010\u001B\u001A\u00020\u0014H&J\u0006\u0010\u001C\u001A\u00020\u001DJ\u001A\u0010\u001C\u001A\u00020\u00192\u0006\u0010\u001E\u001A\u00020\u000E2\b\b\u0002\u0010\u001F\u001A\u00020\u0012H&J\b\u0010 \u001A\u00020\u0019H&R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u000E\u0010\r\u001A\u00020\u000EX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010¨\u0006\""}, d2={"Landroidx/graphics/path/PathIteratorImpl;", "", "path", "Landroid/graphics/Path;", "conicEvaluation", "Landroidx/graphics/path/PathIterator$ConicEvaluation;", "tolerance", "", "(Landroid/graphics/Path;Landroidx/graphics/path/PathIterator$ConicEvaluation;F)V", "getConicEvaluation", "()Landroidx/graphics/path/PathIterator$ConicEvaluation;", "getPath", "()Landroid/graphics/Path;", "pointsData", "", "getTolerance", "()F", "calculateSize", "", "includeConvertedConics", "", "floatsToPoints", "", "Landroid/graphics/PointF;", "type", "Landroidx/graphics/path/PathSegment$Type;", "([FLandroidx/graphics/path/PathSegment$Type;)[Landroid/graphics/PointF;", "hasNext", "next", "Landroidx/graphics/path/PathSegment;", "points", "offset", "peek", "Companion", "graphics-path_release"}, k=1, mv={1, 8, 0}, xi=0x30) public abstract class PathIteratorImpl {
    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2={"Landroidx/graphics/path/PathIteratorImpl$Companion;", "", "()V", "graphics-path_release"}, k=1, mv={1, 8, 0}, xi=0x30) final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    @Metadata(k=3, mv={1, 8, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[Type.values().length];
            try {
                v0[Type.Move.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[Type.Line.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[Type.Quadratic.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_15:
                            v0[Type.Conic.ordinal()] = 4;
                            goto label_19;
                        }
                        catch(NoSuchFieldError ) {
                            try {
                            label_19:
                                v0[Type.Cubic.ordinal()] = 5;
                                goto label_23;
                            }
                            catch(NoSuchFieldError ) {
                            label_23:
                                WhenMappings.$EnumSwitchMapping$0 = v0;
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    private static final Companion Companion;
    private final ConicEvaluation conicEvaluation;
    private final Path path;
    private final float[] pointsData;
    private final float tolerance;

    static {
        PathIteratorImpl.Companion = new Companion(null);
        System.loadLibrary("androidx.graphics.path");
    }

    public PathIteratorImpl(Path arg2, ConicEvaluation arg3, float arg4) {
        Intrinsics.checkNotNullParameter(arg2, "path");
        Intrinsics.checkNotNullParameter(arg3, "conicEvaluation");
        super();
        this.path = arg2;
        this.conicEvaluation = arg3;
        this.tolerance = arg4;
        this.pointsData = new float[8];
    }

    public PathIteratorImpl(Path arg1, ConicEvaluation arg2, float arg3, int arg4, DefaultConstructorMarker arg5) {
        if((arg4 & 2) != 0) {
            arg2 = ConicEvaluation.AsQuadratics;
        }

        if((arg4 & 4) != 0) {
            arg3 = 0.25f;
        }

        this(arg1, arg2, arg3);
    }

    public abstract int calculateSize(boolean arg1);

    private final PointF[] floatsToPoints(float[] arg9, Type arg10) {
        PointF[] v8_1;
        int v8 = WhenMappings.$EnumSwitchMapping$0[arg10.ordinal()];
        if(v8 != 1) {
            int v1 = 3;
            int v2 = 2;
            if(v8 != v2) {
                int v3 = 5;
                int v4 = 4;
                if(v8 != v1 && v8 != v4) {
                    if(v8 != v3) {
                        return new PointF[0];
                    }
                    else {
                        v8_1 = new PointF[v4];
                        v8_1[0] = new PointF(arg9[0], arg9[1]);
                        v8_1[1] = new PointF(arg9[v2], arg9[v1]);
                        v8_1[v2] = new PointF(arg9[v4], arg9[v3]);
                        v8_1[v1] = new PointF(arg9[6], arg9[7]);
                        return v8_1;
                    }
                }

                v8_1 = new PointF[v1];
                v8_1[0] = new PointF(arg9[0], arg9[1]);
                v8_1[1] = new PointF(arg9[v2], arg9[v1]);
                v8_1[v2] = new PointF(arg9[v4], arg9[v3]);
                return v8_1;
            }

            v8_1 = new PointF[v2];
            v8_1[0] = new PointF(arg9[0], arg9[1]);
            v8_1[1] = new PointF(arg9[v2], arg9[v1]);
            return v8_1;
        }

        return new PointF[]{new PointF(arg9[0], arg9[1])};
    }

    public final ConicEvaluation getConicEvaluation() {
        return this.conicEvaluation;
    }

    public final Path getPath() {
        return this.path;
    }

    public final float getTolerance() {
        return this.tolerance;
    }

    public abstract boolean hasNext();

    public abstract Type next(float[] arg1, int arg2);

    public final PathSegment next() {
        Type v0 = this.next(this.pointsData, 0);
        if(v0 == Type.Done) {
            return PathSegmentUtilities.getDoneSegment();
        }

        if(v0 == Type.Close) {
            return PathSegmentUtilities.getCloseSegment();
        }

        float v1 = v0 == Type.Conic ? this.pointsData[6] : 0f;
        return new PathSegment(v0, this.floatsToPoints(this.pointsData, v0), v1);
    }

    public static Type next$default(PathIteratorImpl arg0, float[] arg1, int arg2, int arg3, Object arg4) {
        if(arg4 == null) {
            return arg0.next(arg1, 0);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: next");
    }

    public abstract Type peek();
}

