package androidx.core.text;

import android.text.Spannable;
import android.text.SpannableString;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(d1={"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A\r\u0010\u0000\u001A\u00020\u0001*\u00020\u0002H\u0086\b\u001A\r\u0010\u0003\u001A\u00020\u0004*\u00020\u0001H\u0086\b\u001A%\u0010\u0005\u001A\u00020\u0004*\u00020\u00012\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\t\u001A\u00020\nH\u0086\n\u001A\u001D\u0010\u0005\u001A\u00020\u0004*\u00020\u00012\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\t\u001A\u00020\nH\u0086\n¨\u0006\r"}, d2={"toSpannable", "Landroid/text/Spannable;", "", "clearSpans", "", "set", "start", "", "end", "span", "", "range", "Lkotlin/ranges/IntRange;", "core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class SpannableStringKt {
    public static final void clearSpans(Spannable arg4) {
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        int v3 = 0;
        Object[] v0 = arg4.getSpans(0, arg4.length(), Object.class);
        Intrinsics.checkNotNullExpressionValue(v0, "getSpans(...)");
        int v1 = v0.length;
        while(v3 < v1) {
            arg4.removeSpan(v0[v3]);
            ++v3;
        }
    }

    public static final void set(Spannable arg1, int arg2, int arg3, Object arg4) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "span");
        arg1.setSpan(arg4, arg2, arg3, 17);
    }

    public static final void set(Spannable arg2, IntRange arg3, Object arg4) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "range");
        Intrinsics.checkNotNullParameter(arg4, "span");
        arg2.setSpan(arg4, arg3.getStart().intValue(), arg3.getEndInclusive().intValue(), 17);
    }

    public static final Spannable toSpannable(CharSequence arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        SpannableString v1 = SpannableString.valueOf(arg1);
        Intrinsics.checkNotNullExpressionValue(v1, "valueOf(...)");
        return ((Spannable)v1);
    }
}

