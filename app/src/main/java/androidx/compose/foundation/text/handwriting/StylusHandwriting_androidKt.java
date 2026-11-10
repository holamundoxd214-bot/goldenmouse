package androidx.compose.foundation.text.handwriting;

import android.os.Build$VERSION;
import kotlin.Metadata;

@Metadata(d1={"\u0000\n\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\"\u0014\u0010\u0000\u001A\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0000\u0010\u0002¨\u0006\u0003"}, d2={"isStylusHandwritingSupported", "", "()Z", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class StylusHandwriting_androidKt {
    private static final boolean isStylusHandwritingSupported;

    static {
        boolean v0 = Build$VERSION.SDK_INT >= 34 ? true : false;
        StylusHandwriting_androidKt.isStylusHandwritingSupported = v0;
    }

    public static final boolean isStylusHandwritingSupported() {
        return StylusHandwriting_androidKt.isStylusHandwritingSupported;
    }
}

