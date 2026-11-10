package androidx.compose.material3;

import androidx.compose.ui.graphics.AndroidPathMeasure_androidKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathMeasure;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\u0006\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\n¨\u0006\u000E"}, d2={"Landroidx/compose/material3/CheckDrawingCache;", "", "checkPath", "Landroidx/compose/ui/graphics/Path;", "pathMeasure", "Landroidx/compose/ui/graphics/PathMeasure;", "pathToDraw", "<init>", "(Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/graphics/PathMeasure;Landroidx/compose/ui/graphics/Path;)V", "getCheckPath", "()Landroidx/compose/ui/graphics/Path;", "getPathMeasure", "()Landroidx/compose/ui/graphics/PathMeasure;", "getPathToDraw", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) final class CheckDrawingCache {
    private final Path checkPath;
    private final PathMeasure pathMeasure;
    private final Path pathToDraw;

    public CheckDrawingCache() {
        this(null, null, null, 7, null);
    }

    public CheckDrawingCache(Path arg1, PathMeasure arg2, Path arg3, int arg4, DefaultConstructorMarker arg5) {
        if((arg4 & 1) != 0) {
            arg1 = AndroidPath_androidKt.Path();
        }

        if((arg4 & 2) != 0) {
            arg2 = AndroidPathMeasure_androidKt.PathMeasure();
        }

        if((arg4 & 4) != 0) {
            arg3 = AndroidPath_androidKt.Path();
        }

        this(arg1, arg2, arg3);
    }

    public CheckDrawingCache(Path arg1, PathMeasure arg2, Path arg3) {
        super();
        this.checkPath = arg1;
        this.pathMeasure = arg2;
        this.pathToDraw = arg3;
    }

    public final Path getCheckPath() {
        return this.checkPath;
    }

    public final PathMeasure getPathMeasure() {
        return this.pathMeasure;
    }

    public final Path getPathToDraw() {
        return this.pathToDraw;
    }
}

