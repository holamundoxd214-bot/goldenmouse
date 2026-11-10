package androidx.compose.ui.text.android.style;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.style.LeadingMarginSpan;
import androidx.compose.ui.text.android.TextLayout_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0016Jp\u0010\b\u001A\u00020\t2\b\u0010\n\u001A\u0004\u0018\u00010\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\r2\u0006\u0010\u000E\u001A\u00020\u00052\u0006\u0010\u000F\u001A\u00020\u00052\u0006\u0010\u0010\u001A\u00020\u00052\u0006\u0010\u0011\u001A\u00020\u00052\u0006\u0010\u0012\u001A\u00020\u00052\b\u0010\u0013\u001A\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001A\u00020\u00052\u0006\u0010\u0016\u001A\u00020\u00052\u0006\u0010\u0017\u001A\u00020\u00072\b\u0010\u0018\u001A\u0004\u0018\u00010\u0019H\u0016¨\u0006\u001A"}, d2={"Landroidx/compose/ui/text/android/style/IndentationFixSpan;", "Landroid/text/style/LeadingMarginSpan;", "<init>", "()V", "getLeadingMargin", "", "firstLine", "", "drawLeadingMargin", "", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "left", "dir", "top", "baseline", "bottom", "text", "", "start", "end", "first", "layout", "Landroid/text/Layout;", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class IndentationFixSpan implements LeadingMarginSpan {
    public static final int $stable;

    static {
    }

    public IndentationFixSpan() {
        super();
    }

    public void drawLeadingMargin(Canvas arg1, Paint arg2, int arg3, int arg4, int arg5, int arg6, int arg7, CharSequence arg8, int arg9, int arg10, boolean arg11, Layout arg12) {
        if(arg12 != null && arg2 != null) {
            int v0 = arg12.getLineForOffset(arg9);
            if(v0 == arg12.getLineCount() - 1 && (TextLayout_androidKt.isLineEllipsized(arg12, v0))) {
                float v3 = IndentationFixSpan_androidKt.getEllipsizedLeftPadding(arg12, v0, arg2) + IndentationFixSpan_androidKt.getEllipsizedRightPadding(arg12, v0, arg2);
                if(v3 == 0f) {
                    return;
                }
                else {
                    Intrinsics.checkNotNull(arg1);
                    arg1.translate(v3, 0f);
                }
            }
        }
    }

    public int getLeadingMargin(boolean arg1) {
        return 0;
    }
}

