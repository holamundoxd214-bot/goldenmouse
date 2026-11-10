package androidx.compose.ui.text.input;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001A\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001A,\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\b\u001A\u00020\u0006H\u0000¨\u0006\t"}, d2={"toCharArray", "", "", "destination", "", "destinationOffset", "", "startIndex", "endIndex", "ui-text"}, k=2, mv={2, 0, 0}, xi=0x30) public final class GapBuffer_jvmKt {
    public static final void toCharArray(String arg1, char[] arg2, int arg3, int arg4, int arg5) {
        Intrinsics.checkNotNull(arg1, "null cannot be cast to non-null type java.lang.String");
        arg1.getChars(arg4, arg5, arg2, arg3);
    }
}

