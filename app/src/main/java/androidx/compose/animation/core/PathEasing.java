package androidx.compose.animation.core;

import androidx.compose.ui.graphics.BezierKt;
import androidx.compose.ui.graphics.IntervalTree;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathIterator$ConicEvaluation;
import androidx.compose.ui.graphics.PathIterator;
import androidx.compose.ui.graphics.PathSegment$Type;
import androidx.compose.ui.graphics.PathSegment;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\nH\u0016J\b\u0010\f\u001A\u00020\rH\u0002R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2={"Landroidx/compose/animation/core/PathEasing;", "Landroidx/compose/animation/core/Easing;", "path", "Landroidx/compose/ui/graphics/Path;", "<init>", "(Landroidx/compose/ui/graphics/Path;)V", "intervals", "Landroidx/compose/ui/graphics/IntervalTree;", "Landroidx/compose/ui/graphics/PathSegment;", "transform", "", "fraction", "initializeEasing", "", "animation-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class PathEasing implements Easing {
    public static final int $stable;
    private IntervalTree intervals;
    private final Path path;

    static {
    }

    public PathEasing(Path arg1) {
        super();
        this.path = arg1;
    }

    private final void initializeEasing() {
        int v4;
        float[] v0 = new float[5];
        IntervalTree v1 = new IntervalTree();
        PathIterator v2 = this.path.iterator(ConicEvaluation.AsQuadratics, 0.0002f);
        while(true) {
            v4 = 1;
            if(!v2.hasNext()) {
                break;
            }

            PathSegment v3 = v2.next();
            if(v3.getType() != Type.Close) {
            }
            else {
                v4 = 0;
            }

            if(v4 == 0) {
                PreconditionsKt.throwIllegalArgumentException("The path cannot contain a close() command.");
            }

            if(v3.getType() == Type.Move) {
                continue;
            }

            if(v3.getType() == Type.Done) {
                continue;
            }

            long v4_1 = BezierKt.computeHorizontalBounds$default(v3, v0, 0, 4, null);
            v1.addInterval(Float.intBitsToFloat(((int)(v4_1 >> 0x20))), Float.intBitsToFloat(((int)(v4_1 & 0xFFFFFFFFL))), v3);
        }

        if(!v1.contains(0f) || !v1.contains(1f)) {
            v4 = 0;
        }
        else {
        }

        if(v4 == 0) {
            PreconditionsKt.throwIllegalArgumentException("The easing path must start at 0.0f and end at 1.0f.");
        }

        this.intervals = v1;
    }

    public float transform(float arg4) {
        if(arg4 <= 0f) {
            return 0;
        }

        float v1 = 1f;
        if(arg4 >= v1) {
            return v1;
        }

        if(this.intervals == null) {
            this.initializeEasing();
        }

        IntervalTree v3 = this.intervals;
        Object v1_1 = null;
        if(v3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intervals");
            v3 = ((IntervalTree)v1_1);
        }

        Object v3_1 = IntervalTree.findFirstOverlap$default(v3, arg4, 0f, 2, v1_1).getData();
        if(v3_1 != null) {
            arg4 = BezierKt.findFirstRoot(((PathSegment)v3_1), arg4);
            if(Float.isNaN(arg4)) {
                PreconditionsKt.throwIllegalStateException("The easing path is invalid. Make sure it does not contain NaN/Infinity values.");
            }

            return BezierKt.evaluateY(((PathSegment)v3_1), arg4);
        }

        PreconditionsKt.throwIllegalStateExceptionForNullCheck("The easing path is invalid. Make sure it is continuous on the x axis.");
        throw new KotlinNothingValueException();
    }
}

