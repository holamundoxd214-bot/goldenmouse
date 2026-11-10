package androidx.core.text;

import android.text.Html$ImageGetter;
import android.text.Html$TagHandler;
import android.text.Spanned;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A/\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001A\u00020\u00042\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\bH\u0086\b\u001A\u0017\u0010\t\u001A\u00020\u0002*\u00020\u00012\b\b\u0002\u0010\n\u001A\u00020\u0004H\u0086\b¨\u0006\u000B"}, d2={"parseAsHtml", "Landroid/text/Spanned;", "", "flags", "", "imageGetter", "Landroid/text/Html$ImageGetter;", "tagHandler", "Landroid/text/Html$TagHandler;", "toHtml", "option", "core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class HtmlKt {
    public static final Spanned parseAsHtml(String arg1, int arg2, Html$ImageGetter arg3, Html$TagHandler arg4) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Spanned v1 = HtmlCompat.fromHtml(arg1, arg2, arg3, arg4);
        Intrinsics.checkNotNullExpressionValue(v1, "fromHtml(...)");
        return v1;
    }

    public static Spanned parseAsHtml$default(String arg1, int arg2, Html$ImageGetter arg3, Html$TagHandler arg4, int arg5, Object arg6) {
        Html$ImageGetter v0 = null;
        if((arg5 & 2) != 0) {
            arg3 = v0;
        }

        if((arg5 & 4) != 0) {
            arg4 = ((Html$TagHandler)v0);
        }

        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Spanned v1 = HtmlCompat.fromHtml(arg1, 0, arg3, arg4);
        Intrinsics.checkNotNullExpressionValue(v1, "fromHtml(...)");
        return v1;
    }

    public static final String toHtml(Spanned arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        String v1 = HtmlCompat.toHtml(arg1, arg2);
        Intrinsics.checkNotNullExpressionValue(v1, "toHtml(...)");
        return v1;
    }

    public static String toHtml$default(Spanned arg0, int arg1, int arg2, Object arg3) {
        Intrinsics.checkNotNullParameter(arg0, "<this>");
        String v0 = HtmlCompat.toHtml(arg0, 0);
        Intrinsics.checkNotNullExpressionValue(v0, "toHtml(...)");
        return v0;
    }
}

