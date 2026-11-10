package androidx.compose.ui.graphics;

import kotlin.Metadata;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J*\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u00032\u0006\u0010\t\u001A\u00020\u00032\u0006\u0010\n\u001A\u00020\u000B2\b\b\u0002\u0010\f\u001A\u00020\u0007H&J\u001A\u0010\r\u001A\u00020\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\u000B2\u0006\u0010\u0010\u001A\u00020\u0007H&J\u0017\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u0003H&¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u0003H&¢\u0006\u0004\b\u0017\u0010\u0015R\u0012\u0010\u0002\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0018À\u0006\u0003"}, d2={"Landroidx/compose/ui/graphics/PathMeasure;", "", "length", "", "getLength", "()F", "getSegment", "", "startDistance", "stopDistance", "destination", "Landroidx/compose/ui/graphics/Path;", "startWithMoveTo", "setPath", "", "path", "forceClosed", "getPosition", "Landroidx/compose/ui/geometry/Offset;", "distance", "getPosition-tuRUvjQ", "(F)J", "getTangent", "getTangent-tuRUvjQ", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public interface PathMeasure {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class DefaultImpls {
        public static boolean getSegment$default(PathMeasure arg0, float arg1, float arg2, Path arg3, boolean arg4, int arg5, Object arg6) {
            return PathMeasure.getSegment$default(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
        }
    }

    float getLength();

    long getPosition-tuRUvjQ(float arg1);

    boolean getSegment(float arg1, float arg2, Path arg3, boolean arg4);

    static boolean getSegment$default(PathMeasure arg0, float arg1, float arg2, Path arg3, boolean arg4, int arg5, Object arg6) {
        if(arg6 == null) {
            return arg0.getSegment(arg1, arg2, arg3, true);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getSegment");
    }

    long getTangent-tuRUvjQ(float arg1);

    void setPath(Path arg1, boolean arg2);
}

