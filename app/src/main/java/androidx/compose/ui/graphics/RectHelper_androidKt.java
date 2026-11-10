package androidx.compose.ui.graphics;

import android.graphics.Rect;
import android.graphics.RectF;
import androidx.compose.ui.unit.IntRect;
import kotlin.Deprecated;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001A\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\f\u0010\u0000\u001A\u00020\u0001*\u00020\u0002H\u0007\u001A\n\u0010\u0003\u001A\u00020\u0004*\u00020\u0002\u001A\n\u0010\u0005\u001A\u00020\u0002*\u00020\u0001\u001A\n\u0010\u0005\u001A\u00020\u0002*\u00020\u0004\u001A\n\u0010\u0000\u001A\u00020\u0001*\u00020\u0006\u001A\n\u0010\u0007\u001A\u00020\u0006*\u00020\u0001¨\u0006\b"}, d2={"toAndroidRect", "Landroid/graphics/Rect;", "Landroidx/compose/ui/geometry/Rect;", "toAndroidRectF", "Landroid/graphics/RectF;", "toComposeRect", "Landroidx/compose/ui/unit/IntRect;", "toComposeIntRect", "ui-graphics"}, k=2, mv={2, 0, 0}, xi=0x30) public final class RectHelper_androidKt {
    @Deprecated(message="Converting Rect to android.graphics.Rect is lossy, and requires rounding. The behavior of toAndroidRect() truncates to an integral Rect, but you should choose the method of rounding most suitable for your use case.", replaceWith="<_subannotation>") public static final Rect toAndroidRect(androidx.compose.ui.geometry.Rect arg4) {
        return new Rect(((int)arg4.getLeft()), ((int)arg4.getTop()), ((int)arg4.getRight()), ((int)arg4.getBottom()));
    }

    public static final Rect toAndroidRect(IntRect arg4) {
        return new Rect(arg4.getLeft(), arg4.getTop(), arg4.getRight(), arg4.getBottom());
    }

    public static final RectF toAndroidRectF(androidx.compose.ui.geometry.Rect arg4) {
        return new RectF(arg4.getLeft(), arg4.getTop(), arg4.getRight(), arg4.getBottom());
    }

    public static final IntRect toComposeIntRect(Rect arg4) {
        return new IntRect(arg4.left, arg4.top, arg4.right, arg4.bottom);
    }

    public static final androidx.compose.ui.geometry.Rect toComposeRect(RectF arg4) {
        return new androidx.compose.ui.geometry.Rect(arg4.left, arg4.top, arg4.right, arg4.bottom);
    }

    public static final androidx.compose.ui.geometry.Rect toComposeRect(Rect arg4) {
        return new androidx.compose.ui.geometry.Rect(((float)arg4.left), ((float)arg4.top), ((float)arg4.right), ((float)arg4.bottom));
    }
}

