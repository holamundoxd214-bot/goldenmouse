package androidx.compose.ui.text.android;

import android.text.Spanned;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001A\n\u0000\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001A\u0018\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\n\u0010\u0003\u001A\u0006\u0012\u0002\b\u00030\u0004H\u0000\u001A(\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\n\u0010\u0003\u001A\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u0006H\u0000¨\u0006\b"}, d2={"hasSpan", "", "Landroid/text/Spanned;", "clazz", "Ljava/lang/Class;", "startInclusive", "", "endExclusive", "ui-text"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SpannedExtensions_androidKt {
    public static final boolean hasSpan(Spanned arg2, Class arg3) {
        if(arg2.nextSpanTransition(-1, arg2.length(), arg3) != arg2.length()) {
            return 1;
        }

        return 0;
    }

    public static final boolean hasSpan(Spanned arg1, Class arg2, int arg3, int arg4) {
        if(arg1.nextSpanTransition(arg3 - 1, arg4, arg2) != arg4) {
            return 1;
        }

        return 0;
    }
}

