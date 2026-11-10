package androidx.graphics.path;

import android.graphics.Path;
import android.os.Build$VERSION;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001DB!\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001A\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0012\u001A\u00020\u00132\b\b\u0002\u0010\u0014\u001A\u00020\u0015J\t\u0010\u0016\u001A\u00020\u0015H\u0096\u0002J\t\u0010\u0017\u001A\u00020\u0002H\u0096\u0002J\u001A\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u001A2\b\b\u0002\u0010\u001B\u001A\u00020\u0013H\u0007J\u0006\u0010\u001C\u001A\u00020\u0018R\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u000E\u0010\f\u001A\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011¨\u0006\u001E"}, d2={"Landroidx/graphics/path/PathIterator;", "", "Landroidx/graphics/path/PathSegment;", "path", "Landroid/graphics/Path;", "conicEvaluation", "Landroidx/graphics/path/PathIterator$ConicEvaluation;", "tolerance", "", "(Landroid/graphics/Path;Landroidx/graphics/path/PathIterator$ConicEvaluation;F)V", "getConicEvaluation", "()Landroidx/graphics/path/PathIterator$ConicEvaluation;", "implementation", "Landroidx/graphics/path/PathIteratorImpl;", "getPath", "()Landroid/graphics/Path;", "getTolerance", "()F", "calculateSize", "", "includeConvertedConics", "", "hasNext", "next", "Landroidx/graphics/path/PathSegment$Type;", "points", "", "offset", "peek", "ConicEvaluation", "graphics-path_release"}, k=1, mv={1, 8, 0}, xi=0x30) public final class PathIterator implements Iterator, KMappedMarker {
    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2={"Landroidx/graphics/path/PathIterator$ConicEvaluation;", "", "(Ljava/lang/String;I)V", "AsConic", "AsQuadratics", "graphics-path_release"}, k=1, mv={1, 8, 0}, xi=0x30) public enum ConicEvaluation {
        public static final enum ConicEvaluation AsConic;
        public static final enum ConicEvaluation AsQuadratics;

        private static final ConicEvaluation[] $values() {
            return new ConicEvaluation[]{ConicEvaluation.AsConic, ConicEvaluation.AsQuadratics};
        }

        static {
            ConicEvaluation.AsConic = new ConicEvaluation("AsConic", 0);
            ConicEvaluation.AsQuadratics = new ConicEvaluation("AsQuadratics", 1);
            ConicEvaluation.$VALUES = ConicEvaluation.$values();
        }

        private ConicEvaluation(String arg1, int arg2) {
            super(arg1, arg2);
        }

        public static ConicEvaluation valueOf(String arg1) {
            return Enum.valueOf(ConicEvaluation.class, arg1);
        }

        public static ConicEvaluation[] values() {
            return ConicEvaluation.$VALUES.clone();
        }
    }

    private final ConicEvaluation conicEvaluation;
    private final PathIteratorImpl implementation;
    private final Path path;
    private final float tolerance;

    public PathIterator(Path arg3, ConicEvaluation arg4, float arg5) {
        PathIteratorApi34Impl v0;
        Intrinsics.checkNotNullParameter(arg3, "path");
        Intrinsics.checkNotNullParameter(arg4, "conicEvaluation");
        super();
        this.path = arg3;
        this.conicEvaluation = arg4;
        this.tolerance = arg5;
        if(Build$VERSION.SDK_INT >= 34) {
            v0 = new PathIteratorApi34Impl(arg3, arg4, arg5);
        }
        else {
            PathIteratorPreApi34Impl v0_1 = new PathIteratorPreApi34Impl(arg3, arg4, arg5);
        }

        this.implementation = ((PathIteratorImpl)v0);
    }

    public PathIterator(Path arg1, ConicEvaluation arg2, float arg3, int arg4, DefaultConstructorMarker arg5) {
        if((arg4 & 2) != 0) {
            arg2 = ConicEvaluation.AsQuadratics;
        }

        if((arg4 & 4) != 0) {
            arg3 = 0.25f;
        }

        this(arg1, arg2, arg3);
    }

    public final int calculateSize(boolean arg1) {
        return this.implementation.calculateSize(arg1);
    }

    public static int calculateSize$default(PathIterator arg0, boolean arg1, int arg2, Object arg3) {
        return arg0.calculateSize(true);
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

    public boolean hasNext() {
        return this.implementation.hasNext();
    }

    public final Type next(float[] arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg2, "points");
        return this.implementation.next(arg2, arg3);
    }

    public final Type next(float[] arg4) {
        Intrinsics.checkNotNullParameter(arg4, "points");
        return PathIterator.next$default(this, arg4, 0, 2, null);
    }

    public PathSegment next() {
        return this.implementation.next();
    }

    public Object next() {
        return this.next();
    }

    public static Type next$default(PathIterator arg0, float[] arg1, int arg2, int arg3, Object arg4) {
        return arg0.next(arg1, 0);
    }

    public final Type peek() {
        return this.implementation.peek();
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

