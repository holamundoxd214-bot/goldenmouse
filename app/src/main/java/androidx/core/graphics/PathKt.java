package androidx.core.graphics;

import android.graphics.Path$Op;
import android.graphics.Path;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0018\n\u0000\n\u0002\u0010\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\u001A\u001C\u0010\u0000\u001A\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0005H\u0007\u001A\u0015\u0010\u0006\u001A\u00020\u0003*\u00020\u00032\u0006\u0010\u0007\u001A\u00020\u0003H\u0086\n\u001A\u0015\u0010\b\u001A\u00020\u0003*\u00020\u00032\u0006\u0010\u0007\u001A\u00020\u0003H\u0086\n\u001A\u0015\u0010\t\u001A\u00020\u0003*\u00020\u00032\u0006\u0010\u0007\u001A\u00020\u0003H\u0086\f\u001A\u0015\u0010\n\u001A\u00020\u0003*\u00020\u00032\u0006\u0010\u0007\u001A\u00020\u0003H\u0086\f\u001A\u0015\u0010\u000B\u001A\u00020\u0003*\u00020\u00032\u0006\u0010\u0007\u001A\u00020\u0003H\u0086\f¨\u0006\f"}, d2={"flatten", "", "Landroidx/core/graphics/PathSegment;", "Landroid/graphics/Path;", "error", "", "plus", "p", "minus", "or", "and", "xor", "core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class PathKt {
    public static final Path and(Path arg2, Path arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "p");
        Path v0 = new Path();
        v0.op(arg2, arg3, Path$Op.INTERSECT);
        return v0;
    }

    public static final Iterable flatten(Path arg1, float arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Collection v1 = PathUtils.flatten(arg1, arg2);
        Intrinsics.checkNotNullExpressionValue(v1, "flatten(...)");
        return ((Iterable)v1);
    }

    public static Iterable flatten$default(Path arg0, float arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = 0.5f;
        }

        return PathKt.flatten(arg0, arg1);
    }

    public static final Path minus(Path arg1, Path arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "p");
        Path v0 = new Path(arg1);
        v0.op(arg2, Path$Op.DIFFERENCE);
        return v0;
    }

    public static final Path or(Path arg1, Path arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "p");
        Path v0 = new Path(arg1);
        v0.op(arg2, Path$Op.UNION);
        return v0;
    }

    public static final Path plus(Path arg1, Path arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "p");
        Path v0 = new Path(arg1);
        v0.op(arg2, Path$Op.UNION);
        return v0;
    }

    public static final Path xor(Path arg1, Path arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "p");
        Path v0 = new Path(arg1);
        v0.op(arg2, Path$Op.XOR);
        return v0;
    }
}

