package androidx.compose.ui.graphics;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u0017H\u0016J\t\u0010\u0018\u001A\u00020\u0017H\u0096\u0002J\u0018\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u001B\u001A\u00020\u00112\u0006\u0010\u001C\u001A\u00020\u0015H\u0016J\t\u0010\u0019\u001A\u00020\u001DH\u0096\u0002R\u0014\u0010\u0002\u001A\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0014\u0010\u0004\u001A\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0014\u0010\u0006\u001A\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u000E\u0010\u0010\u001A\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001E"}, d2={"Landroidx/compose/ui/graphics/AndroidPathIterator;", "Landroidx/compose/ui/graphics/PathIterator;", "path", "Landroidx/compose/ui/graphics/Path;", "conicEvaluation", "Landroidx/compose/ui/graphics/PathIterator$ConicEvaluation;", "tolerance", "", "<init>", "(Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/graphics/PathIterator$ConicEvaluation;F)V", "getPath", "()Landroidx/compose/ui/graphics/Path;", "getConicEvaluation", "()Landroidx/compose/ui/graphics/PathIterator$ConicEvaluation;", "getTolerance", "()F", "segmentPoints", "", "implementation", "Landroidx/graphics/path/PathIterator;", "calculateSize", "", "includeConvertedConics", "", "hasNext", "next", "Landroidx/compose/ui/graphics/PathSegment$Type;", "outPoints", "offset", "Landroidx/compose/ui/graphics/PathSegment;", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) final class AndroidPathIterator implements PathIterator {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[ConicEvaluation.values().length];
            try {
                v0[ConicEvaluation.AsConic.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
            label_7:
                int v2 = 2;
                try {
                    v0[ConicEvaluation.AsQuadratics.ordinal()] = v2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                label_11:
                    WhenMappings.$EnumSwitchMapping$0 = v0;
                    v0 = new int[Type.values().length];
                    try {
                        v0[Type.Move.ordinal()] = 1;
                        goto label_18;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_18:
                            v0[Type.Line.ordinal()] = v2;
                            goto label_21;
                        }
                        catch(NoSuchFieldError ) {
                            try {
                            label_21:
                                v0[Type.Quadratic.ordinal()] = 3;
                                goto label_25;
                            }
                            catch(NoSuchFieldError ) {
                                try {
                                label_25:
                                    v0[Type.Conic.ordinal()] = 4;
                                    goto label_29;
                                }
                                catch(NoSuchFieldError ) {
                                    try {
                                    label_29:
                                        v0[Type.Cubic.ordinal()] = 5;
                                        goto label_33;
                                    }
                                    catch(NoSuchFieldError ) {
                                    label_33:
                                        WhenMappings.$EnumSwitchMapping$1 = v0;
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private final ConicEvaluation conicEvaluation;
    private final androidx.graphics.path.PathIterator implementation;
    private final Path path;
    private final float[] segmentPoints;
    private final float tolerance;

    public AndroidPathIterator(Path arg2, ConicEvaluation arg3, float arg4) {
        androidx.graphics.path.PathIterator$ConicEvaluation v4_1;
        super();
        this.path = arg2;
        this.conicEvaluation = arg3;
        this.tolerance = arg4;
        this.segmentPoints = new float[8];
        Path v3 = this.getPath();
        if((v3 instanceof AndroidPath)) {
            android.graphics.Path v3_1 = ((AndroidPath)v3).getInternalPath();
            int v4 = WhenMappings.$EnumSwitchMapping$0[this.getConicEvaluation().ordinal()];
            if(v4 == 1) {
                v4_1 = androidx.graphics.path.PathIterator$ConicEvaluation.AsConic;
            }
            else if(v4 == 2) {
                v4_1 = androidx.graphics.path.PathIterator$ConicEvaluation.AsQuadratics;
            }
            else {
                throw new NoWhenBranchMatchedException();
            }

            this.implementation = new androidx.graphics.path.PathIterator(v3_1, v4_1, this.getTolerance());
            return;
        }

        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    }

    public int calculateSize(boolean arg1) {
        return this.implementation.calculateSize(arg1);
    }

    public ConicEvaluation getConicEvaluation() {
        return this.conicEvaluation;
    }

    public Path getPath() {
        return this.path;
    }

    public float getTolerance() {
        return this.tolerance;
    }

    public boolean hasNext() {
        return this.implementation.hasNext();
    }

    public Type next(float[] arg1, int arg2) {
        return AndroidPathIterator_androidKt.access$toPathSegmentType(this.implementation.next(arg1, arg2));
    }

    public PathSegment next() {
        float[] v2_1;
        float[] v1;
        float[] v0 = this.segmentPoints;
        int v2 = 8;
        if(v0.length < v2) {
            return PathSegmentKt.getDoneSegment();
        }

        Type v10 = AndroidPathIterator_androidKt.access$toPathSegmentType(this.implementation.next(v0, 0));
        if(v10 == Type.Done) {
            return PathSegmentKt.getDoneSegment();
        }

        if(v10 == Type.Close) {
            return PathSegmentKt.getCloseSegment();
        }

        int v3 = WhenMappings.$EnumSwitchMapping$1[v10.ordinal()];
        int v4 = 6;
        int v5 = 2;
        if(v3 != 1) {
            int v7 = 4;
            int v8 = 3;
            if(v3 != v5) {
                int v9 = 5;
                if(v3 == v8) {
                    v2_1 = new float[v4];
                    v2_1[0] = v0[0];
                    v2_1[1] = v0[1];
                    v2_1[v5] = v0[v5];
                    v2_1[v8] = v0[v8];
                    v2_1[v7] = v0[v7];
                    v2_1[v9] = v0[v9];
                    goto label_96;
                }
                else if(v3 == v7) {
                    v2_1 = new float[v4];
                    v2_1[0] = v0[0];
                    v2_1[1] = v0[1];
                    v2_1[v5] = v0[v5];
                    v2_1[v8] = v0[v8];
                    v2_1[v7] = v0[v7];
                    v2_1[v9] = v0[v9];
                    goto label_96;
                }
                else if(v3 != v9) {
                    v1 = new float[0];
                }
                else {
                    v2_1 = new float[v2];
                    v2_1[0] = v0[0];
                    v2_1[1] = v0[1];
                    v2_1[v5] = v0[v5];
                    v2_1[v8] = v0[v8];
                    v2_1[v7] = v0[v7];
                    v2_1[v9] = v0[v9];
                    v2_1[v4] = v0[v4];
                    v2_1[7] = v0[7];
                    goto label_96;
                }
            }
            else {
                v2_1 = new float[v7];
                v2_1[0] = v0[0];
                v2_1[1] = v0[1];
                v2_1[v5] = v0[v5];
                v2_1[v8] = v0[v8];
                goto label_96;
            }
        }
        else {
            v2_1 = new float[v5];
            v2_1[0] = v0[0];
            v2_1[1] = v0[1];
        label_96:
            v1 = v2_1;
        }

        float v0_1 = v10 == Type.Conic ? v0[v4] : 0f;
        return new PathSegment(v10, v1, v0_1);
    }

    public Object next() {
        return this.next();
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

