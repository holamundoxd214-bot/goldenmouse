package androidx.core.text;

import android.text.Spanned;
import android.text.SpannedString;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001A\r\u0010\u0000\u001A\u00020\u0001*\u00020\u0002H\u0086\b\u001A:\u0010\u0003\u001A\n\u0012\u0006\b\u0001\u0012\u0002H\u00050\u0004\"\n\b\u0000\u0010\u0005\u0018\u0001*\u00020\u0006*\u00020\u00012\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\bH\u0086\b¢\u0006\u0002\u0010\n¨\u0006\u000B"}, d2={"toSpanned", "Landroid/text/Spanned;", "", "getSpans", "", "T", "", "start", "", "end", "(Landroid/text/Spanned;II)[Ljava/lang/Object;", "core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class SpannedStringKt {
    public static final Object[] getSpans(Spanned arg2, int arg3, int arg4) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.reifiedOperationMarker(4, "T");
        Object[] v2 = arg2.getSpans(arg3, arg4, Object.class);
        Intrinsics.checkNotNullExpressionValue(v2, "getSpans(...)");
        return v2;
    }

    public static Object[] getSpans$default(Spanned arg0, int arg1, int arg2, int arg3, Object arg4) {
        if((arg3 & 2) != 0) {
            arg2 = arg0.length();
        }

        Intrinsics.checkNotNullParameter(arg0, "<this>");
        Intrinsics.reifiedOperationMarker(4, "T");
        Object[] v0 = arg0.getSpans(0, arg2, Object.class);
        Intrinsics.checkNotNullExpressionValue(v0, "getSpans(...)");
        return v0;
    }

    public static final Spanned toSpanned(CharSequence arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        SpannedString v1 = SpannedString.valueOf(arg1);
        Intrinsics.checkNotNullExpressionValue(v1, "valueOf(...)");
        return ((Spanned)v1);
    }
}

