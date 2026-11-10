package androidx.compose.ui.graphics;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u001A\u0018\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0003\u0010\u0004\u001A\u00020\u0005\"\u000E\u0010\u0006\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2={"PathHitTester", "Landroidx/compose/ui/graphics/PathHitTester;", "path", "Landroidx/compose/ui/graphics/Path;", "tolerance", "", "EmptyPath", "ui-graphics"}, k=2, mv={2, 0, 0}, xi=0x30) public final class PathHitTesterKt {
    private static final Path EmptyPath;

    static {
        PathHitTesterKt.EmptyPath = AndroidPath_androidKt.Path();
    }

    public static final PathHitTester PathHitTester(Path arg1, float arg2) {
        PathHitTester v0 = new PathHitTester();
        v0.updatePath(arg1, arg2);
        return v0;
    }

    public static PathHitTester PathHitTester$default(Path arg0, float arg1, int arg2, Object arg3) {
        if((arg2 & 2) != 0) {
            arg1 = 0.5f;
        }

        return PathHitTesterKt.PathHitTester(arg0, arg1);
    }

    public static final Path access$getEmptyPath$p() {
        return PathHitTesterKt.EmptyPath;
    }
}

