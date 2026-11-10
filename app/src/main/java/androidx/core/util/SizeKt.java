package androidx.core.util;

import android.util.Size;
import android.util.SizeF;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001A\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001A\r\u0010\u0000\u001A\u00020\u0001*\u00020\u0002H\u0086\n\u001A\r\u0010\u0003\u001A\u00020\u0001*\u00020\u0002H\u0086\n\u001A\r\u0010\u0000\u001A\u00020\u0004*\u00020\u0005H\u0086\n\u001A\r\u0010\u0003\u001A\u00020\u0004*\u00020\u0005H\u0086\n\u001A\r\u0010\u0000\u001A\u00020\u0004*\u00020\u0006H\u0086\n\u001A\r\u0010\u0003\u001A\u00020\u0004*\u00020\u0006H\u0086\n¨\u0006\u0007"}, d2={"component1", "", "Landroid/util/Size;", "component2", "", "Landroid/util/SizeF;", "Landroidx/core/util/SizeFCompat;", "core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class SizeKt {
    public static final float component1(SizeF arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.getWidth();
    }

    public static final float component1(SizeFCompat arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.getWidth();
    }

    public static final int component1(Size arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.getWidth();
    }

    public static final float component2(SizeF arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.getHeight();
    }

    public static final float component2(SizeFCompat arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.getHeight();
    }

    public static final int component2(Size arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.getHeight();
    }
}

