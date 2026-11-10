package androidx.compose.ui.text.android;

import android.graphics.Paint;
import android.graphics.Rect;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\r\u001A\u00020\u000EH\u0007¨\u0006\u000F"}, d2={"Landroidx/compose/ui/text/android/Paint29;", "", "<init>", "()V", "getTextBounds", "", "paint", "Landroid/graphics/Paint;", "text", "", "start", "", "end", "rect", "Landroid/graphics/Rect;", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) final class Paint29 {
    public static final Paint29 INSTANCE;

    static {
        Paint29.INSTANCE = new Paint29();
    }

    private Paint29() {
        super();
    }

    @JvmStatic public static final void getTextBounds(Paint arg0, CharSequence arg1, int arg2, int arg3, Rect arg4) {
        arg0.getTextBounds(arg1, arg2, arg3, arg4);
    }
}

