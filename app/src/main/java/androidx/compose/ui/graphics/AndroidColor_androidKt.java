package androidx.compose.ui.graphics;

import kotlin.Metadata;
import kotlin.ULong;

@Metadata(d1={"\u0000\u0016\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A\u0011\u0010\u0000\u001A\u00020\u0001*\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001A\u0017\u0010\u0005\u001A\u00020\u0002*\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u0001¢\u0006\u0002\u0010\b¨\u0006\t"}, d2={"toColorLong", "", "Landroidx/compose/ui/graphics/Color;", "toColorLong-8_81llA", "(J)J", "fromColorLong", "Landroidx/compose/ui/graphics/Color$Companion;", "colorLong", "(Landroidx/compose/ui/graphics/Color$Companion;J)J", "ui-graphics"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AndroidColor_androidKt {
    public static final long fromColorLong(Companion arg4, long arg5) {
        long v0 = 0x3F & arg5;
        if(v0 < 16) {
        }
        else {
            arg5 = arg5 & -64 | v0 + 1;
        }

        return Color.constructor-impl(ULong.constructor-impl(arg5));
    }

    public static final long toColorLong-8_81llA(long arg6) {
        long v0 = 0x3F & arg6;
        if(Long.compareUnsigned(ULong.constructor-impl(v0), 16) < 0) {
            return arg6;
        }

        return ULong.constructor-impl(ULong.constructor-impl(arg6 & ULong.constructor-impl(-64)) | ULong.constructor-impl(ULong.constructor-impl(v0) - 1));
    }
}

