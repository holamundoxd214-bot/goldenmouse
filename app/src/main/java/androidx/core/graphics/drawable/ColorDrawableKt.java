package androidx.core.graphics.drawable;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u001A\r\u0010\u0000\u001A\u00020\u0001*\u00020\u0002H\u0086\b\u001A\r\u0010\u0000\u001A\u00020\u0001*\u00020\u0003H\u0087\b¨\u0006\u0004"}, d2={"toDrawable", "Landroid/graphics/drawable/ColorDrawable;", "", "Landroid/graphics/Color;", "core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class ColorDrawableKt {
    public static final ColorDrawable toDrawable(int arg1) {
        return new ColorDrawable(arg1);
    }

    public static final ColorDrawable toDrawable(Color arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return new ColorDrawable(arg1.toArgb());
    }
}

