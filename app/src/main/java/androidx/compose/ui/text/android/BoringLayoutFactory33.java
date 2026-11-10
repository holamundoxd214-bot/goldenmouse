package androidx.compose.ui.text.android;

import android.text.BoringLayout$Metrics;
import android.text.BoringLayout;
import android.text.Layout$Alignment;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils$TruncateAt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

@Metadata(d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0007Jf\u0010\f\u001A\u00020\r2\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0015\u001A\u00020\u00052\u0006\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00020\u00172\n\b\u0002\u0010\u0019\u001A\u0004\u0018\u00010\u001A2\b\b\u0002\u0010\u001B\u001A\u00020\u000FH\u0007J\u0010\u0010\u001C\u001A\u00020\u00172\u0006\u0010\u001D\u001A\u00020\rH\u0007¨\u0006\u001E"}, d2={"Landroidx/compose/ui/text/android/BoringLayoutFactory33;", "", "<init>", "()V", "isBoring", "Landroid/text/BoringLayout$Metrics;", "text", "", "paint", "Landroid/text/TextPaint;", "textDir", "Landroid/text/TextDirectionHeuristic;", "create", "Landroid/text/BoringLayout;", "width", "", "alignment", "Landroid/text/Layout$Alignment;", "lineSpacingMultiplier", "", "lineSpacingExtra", "metrics", "includePadding", "", "useFallbackLineSpacing", "ellipsize", "Landroid/text/TextUtils$TruncateAt;", "ellipsizedWidth", "isFallbackLineSpacingEnabled", "layout", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) final class BoringLayoutFactory33 {
    public static final BoringLayoutFactory33 INSTANCE;

    static {
        BoringLayoutFactory33.INSTANCE = new BoringLayoutFactory33();
    }

    private BoringLayoutFactory33() {
        super();
    }

    @JvmStatic public static final BoringLayout create(CharSequence arg12, TextPaint arg13, int arg14, Layout$Alignment arg15, float arg16, float arg17, BoringLayout$Metrics arg18, boolean arg19, boolean arg20, TextUtils$TruncateAt arg21, int arg22) {
        return new BoringLayout(arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg21, arg22, arg20);
    }

    public static BoringLayout create$default(CharSequence arg13, TextPaint arg14, int arg15, Layout$Alignment arg16, float arg17, float arg18, BoringLayout$Metrics arg19, boolean arg20, boolean arg21, TextUtils$TruncateAt arg22, int arg23, int arg24, Object arg25) {
        int v0 = arg24;
        TextUtils$TruncateAt v11 = (v0 & 0x200) != 0 ? null : arg22;
        int v4 = arg15;
        int v12 = (v0 & 0x400) != 0 ? v4 : arg23;
        return BoringLayoutFactory33.create(arg13, arg14, v4, arg16, arg17, arg18, arg19, arg20, arg21, v11, v12);
    }

    @JvmStatic public static final BoringLayout$Metrics isBoring(CharSequence arg2, TextPaint arg3, TextDirectionHeuristic arg4) {
        return BoringLayout.isBoring(arg2, arg3, arg4, true, null);
    }

    @JvmStatic public static final boolean isFallbackLineSpacingEnabled(BoringLayout arg0) {
        return arg0.isFallbackLineSpacingEnabled();
    }
}

