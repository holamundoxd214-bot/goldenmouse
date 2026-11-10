package androidx.compose.ui.text.android;

import android.text.BoringLayout$Metrics;
import android.text.BoringLayout;
import android.text.Layout$Alignment;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils$TruncateAt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

@Metadata(d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0007J^\u0010\f\u001A\u00020\r2\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0015\u001A\u00020\u00052\u0006\u0010\u0016\u001A\u00020\u00172\n\b\u0002\u0010\u0018\u001A\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001A\u001A\u00020\u000FH\u0007¨\u0006\u001B"}, d2={"Landroidx/compose/ui/text/android/BoringLayoutFactoryDefault;", "", "<init>", "()V", "isBoring", "Landroid/text/BoringLayout$Metrics;", "text", "", "paint", "Landroid/text/TextPaint;", "textDir", "Landroid/text/TextDirectionHeuristic;", "create", "Landroid/text/BoringLayout;", "width", "", "alignment", "Landroid/text/Layout$Alignment;", "lineSpacingMultiplier", "", "lineSpacingExtra", "metrics", "includePadding", "", "ellipsize", "Landroid/text/TextUtils$TruncateAt;", "ellipsizedWidth", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) final class BoringLayoutFactoryDefault {
    public static final BoringLayoutFactoryDefault INSTANCE;

    static {
        BoringLayoutFactoryDefault.INSTANCE = new BoringLayoutFactoryDefault();
    }

    private BoringLayoutFactoryDefault() {
        super();
    }

    @JvmStatic public static final BoringLayout create(CharSequence arg11, TextPaint arg12, int arg13, Layout$Alignment arg14, float arg15, float arg16, BoringLayout$Metrics arg17, boolean arg18, TextUtils$TruncateAt arg19, int arg20) {
        return new BoringLayout(arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20);
    }

    public static BoringLayout create$default(CharSequence arg12, TextPaint arg13, int arg14, Layout$Alignment arg15, float arg16, float arg17, BoringLayout$Metrics arg18, boolean arg19, TextUtils$TruncateAt arg20, int arg21, int arg22, Object arg23) {
        int v0 = arg22;
        TextUtils$TruncateAt v10 = (v0 & 0x100) != 0 ? null : arg20;
        int v4 = arg14;
        int v11 = (v0 & 0x200) != 0 ? v4 : arg21;
        return BoringLayoutFactoryDefault.create(arg12, arg13, v4, arg15, arg16, arg17, arg18, arg19, v10, v11);
    }

    @JvmStatic public static final BoringLayout$Metrics isBoring(CharSequence arg2, TextPaint arg3, TextDirectionHeuristic arg4) {
        BoringLayout$Metrics v0 = null;
        if(!arg4.isRtl(arg2, 0, arg2.length())) {
            return BoringLayout.isBoring(arg2, arg3, v0);
        }

        return v0;
    }
}

