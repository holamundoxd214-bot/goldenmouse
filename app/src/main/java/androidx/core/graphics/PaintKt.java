package androidx.core.graphics;

import android.graphics.Paint;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0012\n\u0000\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A\u0017\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001A\u0004\u0018\u00010\u0004H\u0086\b¨\u0006\u0005"}, d2={"setBlendMode", "", "Landroid/graphics/Paint;", "blendModeCompat", "Landroidx/core/graphics/BlendModeCompat;", "core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class PaintKt {
    public static final boolean setBlendMode(Paint arg1, BlendModeCompat arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return PaintCompat.setBlendMode(arg1, arg2);
    }
}

