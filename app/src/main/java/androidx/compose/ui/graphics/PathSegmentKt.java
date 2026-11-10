package androidx.compose.ui.graphics;

import kotlin.Metadata;

@Metadata(d1={"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0011\u0010\u0000\u001A\u00020\u0001¢\u0006\b\n\u0000\u001A\u0004\b\u0002\u0010\u0003\"\u0011\u0010\u0004\u001A\u00020\u0001¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u0003¨\u0006\u0006"}, d2={"DoneSegment", "Landroidx/compose/ui/graphics/PathSegment;", "getDoneSegment", "()Landroidx/compose/ui/graphics/PathSegment;", "CloseSegment", "getCloseSegment", "ui-graphics"}, k=2, mv={2, 0, 0}, xi=0x30) public final class PathSegmentKt {
    private static final PathSegment CloseSegment;
    private static final PathSegment DoneSegment;

    static {
        PathSegmentKt.DoneSegment = new PathSegment(Type.Done, new float[0], 0f);
        PathSegmentKt.CloseSegment = new PathSegment(Type.Close, new float[0], 0f);
    }

    public static final PathSegment getCloseSegment() {
        return PathSegmentKt.CloseSegment;
    }

    public static final PathSegment getDoneSegment() {
        return PathSegmentKt.DoneSegment;
    }
}

