package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.input.TextFieldCharSequence;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001A\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001A,\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\b\u001A\u00020\u0006H\u0000¨\u0006\t"}, d2={"toCharArray", "", "", "destination", "", "destinationOffset", "", "startIndex", "endIndex", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ToCharArray_androidKt {
    public static final void toCharArray(CharSequence arg2, char[] arg3, int arg4, int arg5, int arg6) {
        if((arg2 instanceof TextFieldCharSequence)) {
            ((TextFieldCharSequence)arg2).toCharArray(arg3, arg4, arg5, arg6);
            return;
        }

        while(arg5 < arg6) {
            arg3[arg4] = arg2.charAt(arg5);
            ++arg5;
            ++arg4;
        }
    }
}

