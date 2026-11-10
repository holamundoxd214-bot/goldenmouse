package androidx.compose.ui.text.input;

import android.view.inputmethod.CursorAnchorInfo$Builder;
import android.view.inputmethod.EditorBoundsInfo$Builder;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

@Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0007\u001A\u00020\bH\u0007¨\u0006\t"}, d2={"Landroidx/compose/ui/text/input/CursorAnchorInfoApi33Helper;", "", "<init>", "()V", "setEditorBoundsInfo", "Landroid/view/inputmethod/CursorAnchorInfo$Builder;", "builder", "decorationBoxBounds", "Landroidx/compose/ui/geometry/Rect;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class CursorAnchorInfoApi33Helper {
    public static final CursorAnchorInfoApi33Helper INSTANCE;

    static {
        CursorAnchorInfoApi33Helper.INSTANCE = new CursorAnchorInfoApi33Helper();
    }

    private CursorAnchorInfoApi33Helper() {
        super();
    }

    @JvmStatic public static final CursorAnchorInfo$Builder setEditorBoundsInfo(CursorAnchorInfo$Builder arg2, Rect arg3) {
        return arg2.setEditorBoundsInfo(new EditorBoundsInfo$Builder().setEditorBounds(RectHelper_androidKt.toAndroidRectF(arg3)).setHandwritingBounds(RectHelper_androidKt.toAndroidRectF(arg3)).build());
    }
}

