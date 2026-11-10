package androidx.compose.ui.layout;

import androidx.core.graphics.Insets;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000B\u001A\u0016\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0080\b¢\u0006\u0002\u0010\u0004\u001A.\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\b\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\u0006H\u0080\b¢\u0006\u0002\u0010\n\"\u0016\u0010\u000B\u001A\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u000E\u001A\u0004\b\f\u0010\r\"\u0016\u0010\u000F\u001A\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u000E\u001A\u0004\b\u0010\u0010\r¨\u0006\u0011"}, d2={"ValueInsets", "Landroidx/compose/ui/layout/ValueInsets;", "insets", "Landroidx/core/graphics/Insets;", "(Landroidx/core/graphics/Insets;)J", "left", "", "top", "right", "bottom", "(IIII)J", "ZeroValueInsets", "getZeroValueInsets", "()J", "J", "UnsetValueInsets", "getUnsetValueInsets", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ValueInsets_androidKt {
    private static final long UnsetValueInsets;
    private static final long ZeroValueInsets;

    static {
        ValueInsets_androidKt.ZeroValueInsets = ValueInsets.constructor-impl(0);
        ValueInsets_androidKt.UnsetValueInsets = ValueInsets.constructor-impl(-1);
    }

    public static final long ValueInsets(int arg3, int arg4, int arg5, int arg6) {
        return ValueInsets.constructor-impl((((long)arg4)) << 0x20 | (((long)arg3)) << 0x30 | (((long)arg5)) << 16 | (((long)arg6)));
    }

    public static final long ValueInsets(Insets arg5) {
        return ValueInsets.constructor-impl((((long)arg5.left)) << 0x30 | (((long)arg5.top)) << 0x20 | (((long)arg5.right)) << 16 | (((long)arg5.bottom)));
    }

    public static final long getUnsetValueInsets() {
        return ValueInsets_androidKt.UnsetValueInsets;
    }

    public static final long getZeroValueInsets() {
        return ValueInsets_androidKt.ZeroValueInsets;
    }
}

