package androidx.compose.ui.text.android;

import android.os.Build$VERSION;
import android.text.BoringLayout$Metrics;
import android.text.BoringLayout;
import android.text.Layout$Alignment;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils$TruncateAt;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BJZ\u0010\f\u001A\u00020\r2\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u00052\b\b\u0002\u0010\u0011\u001A\u00020\u00122\b\b\u0002\u0010\u0013\u001A\u00020\u00142\b\b\u0002\u0010\u0015\u001A\u00020\u00142\n\b\u0002\u0010\u0016\u001A\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0018\u001A\u00020\u000FJ\u000E\u0010\u0019\u001A\u00020\u00142\u0006\u0010\u001A\u001A\u00020\r¨\u0006\u001B"}, d2={"Landroidx/compose/ui/text/android/BoringLayoutFactory;", "", "<init>", "()V", "measure", "Landroid/text/BoringLayout$Metrics;", "text", "", "paint", "Landroid/text/TextPaint;", "textDir", "Landroid/text/TextDirectionHeuristic;", "create", "Landroid/text/BoringLayout;", "width", "", "metrics", "alignment", "Landroid/text/Layout$Alignment;", "includePadding", "", "useFallbackLineSpacing", "ellipsize", "Landroid/text/TextUtils$TruncateAt;", "ellipsizedWidth", "isFallbackLineSpacingEnabled", "layout", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class BoringLayoutFactory {
    public static final int $stable;
    public static final BoringLayoutFactory INSTANCE;

    static {
        BoringLayoutFactory.INSTANCE = new BoringLayoutFactory();
    }

    private BoringLayoutFactory() {
        super();
    }

    public final BoringLayout create(CharSequence arg13, TextPaint arg14, int arg15, BoringLayout$Metrics arg16, Layout$Alignment arg17, boolean arg18, boolean arg19, TextUtils$TruncateAt arg20, int arg21) {
        int v12 = 1;
        int v1 = arg15 >= 0 ? 1 : 0;
        if(v1 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("negative width");
        }

        if(arg21 >= 0) {
        }
        else {
            v12 = 0;
        }

        if(v12 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("negative ellipsized width");
        }

        if(Build$VERSION.SDK_INT >= 33) {
            return BoringLayoutFactory33.create(arg13, arg14, arg15, arg17, 1f, 0f, arg16, arg18, arg19, arg20, arg21);
        }

        return BoringLayoutFactoryDefault.create(arg13, arg14, arg15, arg17, 1f, 0f, arg16, arg18, arg20, arg21);
    }

    public static BoringLayout create$default(BoringLayoutFactory arg12, CharSequence arg13, TextPaint arg14, int arg15, BoringLayout$Metrics arg16, Layout$Alignment arg17, boolean arg18, boolean arg19, TextUtils$TruncateAt arg20, int arg21, int arg22, Object arg23) {
        int v0 = arg22;
        Layout$Alignment v7 = (v0 & 16) != 0 ? Layout$Alignment.ALIGN_NORMAL : arg17;
        boolean v8 = (v0 & 0x20) != 0 ? false : arg18;
        boolean v9 = (v0 & 0x40) != 0 ? true : arg19;
        TextUtils$TruncateAt v10 = (v0 & 0x80) != 0 ? null : arg20;
        int v5 = arg15;
        int v11 = (v0 & 0x100) != 0 ? v5 : arg21;
        return arg12.create(arg13, arg14, v5, arg16, v7, v8, v9, v10, v11);
    }

    public final boolean isFallbackLineSpacingEnabled(BoringLayout arg2) {
        if(Build$VERSION.SDK_INT >= 33) {
            return BoringLayoutFactory33.isFallbackLineSpacingEnabled(arg2);
        }

        return 0;
    }

    public final BoringLayout$Metrics measure(CharSequence arg2, TextPaint arg3, TextDirectionHeuristic arg4) {
        if(Build$VERSION.SDK_INT >= 33) {
            return BoringLayoutFactory33.isBoring(arg2, arg3, arg4);
        }

        return BoringLayoutFactoryDefault.isBoring(arg2, arg3, arg4);
    }
}

