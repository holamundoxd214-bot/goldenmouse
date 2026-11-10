package androidx.core.text;

import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.UnderlineSpan;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\u001A%\u0010\u0000\u001A\u00020\u00012\u0017\u0010\u0002\u001A\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\bø\u0001\u0000\u001AB\u0010\u0007\u001A\u00020\u0004*\u00020\u00042\u0012\u0010\b\u001A\n\u0012\u0006\b\u0001\u0012\u00020\n0\t\"\u00020\n2\u0017\u0010\u0002\u001A\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u000B\u001A1\u0010\u0007\u001A\u00020\u0004*\u00020\u00042\u0006\u0010\f\u001A\u00020\n2\u0017\u0010\u0002\u001A\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\bø\u0001\u0000\u001A)\u0010\r\u001A\u00020\u0004*\u00020\u00042\u0017\u0010\u0002\u001A\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\bø\u0001\u0000\u001A)\u0010\u000E\u001A\u00020\u0004*\u00020\u00042\u0017\u0010\u0002\u001A\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\bø\u0001\u0000\u001A)\u0010\u000F\u001A\u00020\u0004*\u00020\u00042\u0017\u0010\u0002\u001A\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\bø\u0001\u0000\u001A3\u0010\u0010\u001A\u00020\u0004*\u00020\u00042\b\b\u0001\u0010\u0010\u001A\u00020\u00112\u0017\u0010\u0002\u001A\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\bø\u0001\u0000\u001A3\u0010\u0012\u001A\u00020\u0004*\u00020\u00042\b\b\u0001\u0010\u0010\u001A\u00020\u00112\u0017\u0010\u0002\u001A\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\bø\u0001\u0000\u001A)\u0010\u0013\u001A\u00020\u0004*\u00020\u00042\u0017\u0010\u0002\u001A\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\bø\u0001\u0000\u001A1\u0010\u0014\u001A\u00020\u0004*\u00020\u00042\u0006\u0010\u0015\u001A\u00020\u00162\u0017\u0010\u0002\u001A\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\bø\u0001\u0000\u001A)\u0010\u0017\u001A\u00020\u0004*\u00020\u00042\u0017\u0010\u0002\u001A\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\bø\u0001\u0000\u001A)\u0010\u0018\u001A\u00020\u0004*\u00020\u00042\u0017\u0010\u0002\u001A\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0019"}, d2={"buildSpannedString", "Landroid/text/SpannedString;", "builderAction", "Lkotlin/Function1;", "Landroid/text/SpannableStringBuilder;", "", "Lkotlin/ExtensionFunctionType;", "inSpans", "spans", "", "", "(Landroid/text/SpannableStringBuilder;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Landroid/text/SpannableStringBuilder;", "span", "bold", "italic", "underline", "color", "", "backgroundColor", "strikeThrough", "scale", "proportion", "", "superscript", "subscript", "core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class SpannableStringBuilderKt {
    public static final SpannableStringBuilder backgroundColor(SpannableStringBuilder arg2, int arg3, Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "builderAction");
        BackgroundColorSpan v0 = new BackgroundColorSpan(arg3);
        arg3 = arg2.length();
        arg4.invoke(arg2);
        arg2.setSpan(v0, arg3, arg2.length(), 17);
        return arg2;
    }

    public static final SpannableStringBuilder bold(SpannableStringBuilder arg3, Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "builderAction");
        StyleSpan v0 = new StyleSpan(1);
        int v1 = arg3.length();
        arg4.invoke(arg3);
        arg3.setSpan(v0, v1, arg3.length(), 17);
        return arg3;
    }

    public static final SpannedString buildSpannedString(Function1 arg1) {
        Intrinsics.checkNotNullParameter(arg1, "builderAction");
        SpannableStringBuilder v0 = new SpannableStringBuilder();
        arg1.invoke(v0);
        return new SpannedString(((CharSequence)v0));
    }

    public static final SpannableStringBuilder color(SpannableStringBuilder arg2, int arg3, Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "builderAction");
        ForegroundColorSpan v0 = new ForegroundColorSpan(arg3);
        arg3 = arg2.length();
        arg4.invoke(arg2);
        arg2.setSpan(v0, arg3, arg2.length(), 17);
        return arg2;
    }

    public static final SpannableStringBuilder inSpans(SpannableStringBuilder arg2, Object arg3, Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "span");
        Intrinsics.checkNotNullParameter(arg4, "builderAction");
        int v0 = arg2.length();
        arg4.invoke(arg2);
        arg2.setSpan(arg3, v0, arg2.length(), 17);
        return arg2;
    }

    public static final SpannableStringBuilder inSpans(SpannableStringBuilder arg5, Object[] arg6, Function1 arg7) {
        Intrinsics.checkNotNullParameter(arg5, "<this>");
        Intrinsics.checkNotNullParameter(arg6, "spans");
        Intrinsics.checkNotNullParameter(arg7, "builderAction");
        int v0 = arg5.length();
        arg7.invoke(arg5);
        int v7 = arg6.length;
        int v1;
        for(v1 = 0; v1 < v7; ++v1) {
            arg5.setSpan(arg6[v1], v0, arg5.length(), 17);
        }

        return arg5;
    }

    public static final SpannableStringBuilder italic(SpannableStringBuilder arg3, Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "builderAction");
        StyleSpan v0 = new StyleSpan(2);
        int v1 = arg3.length();
        arg4.invoke(arg3);
        arg3.setSpan(v0, v1, arg3.length(), 17);
        return arg3;
    }

    public static final SpannableStringBuilder scale(SpannableStringBuilder arg2, float arg3, Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "builderAction");
        RelativeSizeSpan v0 = new RelativeSizeSpan(arg3);
        int v3 = arg2.length();
        arg4.invoke(arg2);
        arg2.setSpan(v0, v3, arg2.length(), 17);
        return arg2;
    }

    public static final SpannableStringBuilder strikeThrough(SpannableStringBuilder arg3, Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "builderAction");
        StrikethroughSpan v0 = new StrikethroughSpan();
        int v1 = arg3.length();
        arg4.invoke(arg3);
        arg3.setSpan(v0, v1, arg3.length(), 17);
        return arg3;
    }

    public static final SpannableStringBuilder subscript(SpannableStringBuilder arg3, Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "builderAction");
        SubscriptSpan v0 = new SubscriptSpan();
        int v1 = arg3.length();
        arg4.invoke(arg3);
        arg3.setSpan(v0, v1, arg3.length(), 17);
        return arg3;
    }

    public static final SpannableStringBuilder superscript(SpannableStringBuilder arg3, Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "builderAction");
        SuperscriptSpan v0 = new SuperscriptSpan();
        int v1 = arg3.length();
        arg4.invoke(arg3);
        arg3.setSpan(v0, v1, arg3.length(), 17);
        return arg3;
    }

    public static final SpannableStringBuilder underline(SpannableStringBuilder arg3, Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "builderAction");
        UnderlineSpan v0 = new UnderlineSpan();
        int v1 = arg3.length();
        arg4.invoke(arg3);
        arg3.setSpan(v0, v1, arg3.length(), 17);
        return arg3;
    }
}

