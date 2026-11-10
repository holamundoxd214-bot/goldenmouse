package androidx.graphics.path;

import android.graphics.Path;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u001A\r\u0010\u0000\u001A\u00020\u0001*\u00020\u0002H\u0086\u0002\u001A\u001C\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\b\b\u0002\u0010\u0005\u001A\u00020\u0006¨\u0006\u0007"}, d2={"iterator", "Landroidx/graphics/path/PathIterator;", "Landroid/graphics/Path;", "conicEvaluation", "Landroidx/graphics/path/PathIterator$ConicEvaluation;", "tolerance", "", "graphics-path_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PathUtilities {
    public static final PathIterator iterator(Path arg7) {
        Intrinsics.checkNotNullParameter(arg7, "<this>");
        return new PathIterator(arg7, null, 0f, 6, null);
    }

    public static final PathIterator iterator(Path arg1, ConicEvaluation arg2, float arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "conicEvaluation");
        return new PathIterator(arg1, arg2, arg3);
    }

    public static PathIterator iterator$default(Path arg0, ConicEvaluation arg1, float arg2, int arg3, Object arg4) {
        if((arg3 & 2) != 0) {
            arg2 = 0.25f;
        }

        return PathUtilities.iterator(arg0, arg1, arg2);
    }
}

