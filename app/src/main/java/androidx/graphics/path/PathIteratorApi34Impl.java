package androidx.graphics.path;

import android.graphics.Path;
import android.graphics.PathIterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u0010H\u0016J\b\u0010\u0011\u001A\u00020\u0010H\u0016J\u0018\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u000EH\u0016J\b\u0010\u0017\u001A\u00020\u0013H\u0016R\u000E\u0010\t\u001A\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2={"Landroidx/graphics/path/PathIteratorApi34Impl;", "Landroidx/graphics/path/PathIteratorImpl;", "path", "Landroid/graphics/Path;", "conicEvaluation", "Landroidx/graphics/path/PathIterator$ConicEvaluation;", "tolerance", "", "(Landroid/graphics/Path;Landroidx/graphics/path/PathIterator$ConicEvaluation;F)V", "conicConverter", "Landroidx/graphics/path/ConicConverter;", "platformIterator", "Landroid/graphics/PathIterator;", "calculateSize", "", "includeConvertedConics", "", "hasNext", "next", "Landroidx/graphics/path/PathSegment$Type;", "points", "", "offset", "peek", "graphics-path_release"}, k=1, mv={1, 8, 0}, xi=0x30) public final class PathIteratorApi34Impl extends PathIteratorImpl {
    private final ConicConverter conicConverter;
    private final PathIterator platformIterator;

    public PathIteratorApi34Impl(Path arg2, ConicEvaluation arg3, float arg4) {
        Intrinsics.checkNotNullParameter(arg2, "path");
        Intrinsics.checkNotNullParameter(arg3, "conicEvaluation");
        super(arg2, arg3, arg4);
        PathIterator v2 = arg2.getPathIterator();
        Intrinsics.checkNotNullExpressionValue(v2, "path.pathIterator");
        this.platformIterator = v2;
        this.conicConverter = new ConicConverter();
    }

    public PathIteratorApi34Impl(Path arg1, ConicEvaluation arg2, float arg3, int arg4, DefaultConstructorMarker arg5) {
        if((arg4 & 2) != 0) {
            arg2 = ConicEvaluation.AsQuadratics;
        }

        if((arg4 & 4) != 0) {
            arg3 = 0.25f;
        }

        this(arg1, arg2, arg3);
    }

    public int calculateSize(boolean arg11) {
        int v11 = !arg11 || this.getConicEvaluation() != ConicEvaluation.AsQuadratics ? 0 : 1;
        PathIterator v1 = this.getPath().getPathIterator();
        Intrinsics.checkNotNullExpressionValue(v1, "path.pathIterator");
        float[] v4 = new float[8];
        int v2;
        for(v2 = 0; v1.hasNext(); ++v2) {
            if(v1.next(v4, 0) == 3 && v11 != 0) {
                ConicConverter v3 = this.conicConverter;
                ConicConverter.convert$default(v3, v4, v4[6], this.getTolerance(), 0, 8, null);
                v2 += v3.getQuadraticCount();
                continue;
            }
        }

        return v2;
    }

    public boolean hasNext() {
        return this.platformIterator.hasNext();
    }

    public Type next(float[] arg4, int arg5) {
        Intrinsics.checkNotNullParameter(arg4, "points");
        if(this.conicConverter.getCurrentQuadratic() < this.conicConverter.getQuadraticCount()) {
            this.conicConverter.nextQuadratic(arg4, arg5);
            return Type.Quadratic;
        }

        Type v0 = PathIteratorImplKt.access$platformToAndroidXSegmentType(this.platformIterator.next(arg4, arg5));
        if(v0 == Type.Conic && this.getConicEvaluation() == ConicEvaluation.AsQuadratics) {
            ConicConverter v0_1 = this.conicConverter;
            v0_1.convert(arg4, arg4[arg5 + 6], this.getTolerance(), arg5);
            if(v0_1.getQuadraticCount() > 0) {
                v0_1.nextQuadratic(arg4, arg5);
            }

            return Type.Quadratic;
        }

        return v0;
    }

    public Type peek() {
        return PathIteratorImplKt.access$platformToAndroidXSegmentType(this.platformIterator.peek());
    }
}

